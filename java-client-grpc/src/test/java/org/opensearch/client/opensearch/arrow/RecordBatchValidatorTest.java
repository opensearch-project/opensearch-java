/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.arrow.flatbuf.BodyCompressionMethod;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.BitVector;
import org.apache.arrow.vector.FixedSizeBinaryVector;
import org.apache.arrow.vector.Float8Vector;
import org.apache.arrow.vector.TimeStampMilliTZVector;
import org.apache.arrow.vector.UInt8Vector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.complex.ListVector;
import org.apache.arrow.vector.complex.impl.UnionListWriter;
import org.apache.arrow.vector.compression.CompressionUtil;
import org.apache.arrow.vector.ipc.WriteChannel;
import org.apache.arrow.vector.ipc.message.ArrowBodyCompression;
import org.apache.arrow.vector.ipc.message.ArrowFieldNode;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.FloatingPointPrecision;
import org.apache.arrow.vector.types.TimeUnit;
import org.apache.arrow.vector.types.UnionMode;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.transport.TransportException;

public class RecordBatchValidatorTest {

    private static final Field LONG = new Field("value", FieldType.nullable(new ArrowType.Int(64, true)), null);
    private static final Field KEYWORD = new Field("id", FieldType.nullable(new ArrowType.Utf8()), null);
    private static final Field LONGS = new Field(
        "values",
        FieldType.nullable(new ArrowType.List()),
        List.of(new Field("$data$", FieldType.nullable(new ArrowType.Int(64, true)), null))
    );

    /** The column types the arrow-search plugin sends. */
    private static final Schema PLUGIN_TYPES = new Schema(
        List.of(
            new Field("long", FieldType.nullable(new ArrowType.Int(64, true)), null),
            new Field("unsigned_long", FieldType.nullable(new ArrowType.Int(64, false)), null),
            new Field("double", FieldType.nullable(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)), null),
            new Field("boolean", FieldType.nullable(new ArrowType.Bool()), null),
            new Field("date", FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MILLISECOND, "UTC")), null),
            new Field("keyword", FieldType.nullable(new ArrowType.Utf8()), null),
            new Field("ip", FieldType.nullable(new ArrowType.FixedSizeBinary(16)), null),
            LONGS
        )
    );

    private BufferAllocator allocator;

    @Before
    public void createAllocator() {
        allocator = new RootAllocator();
    }

    @After
    public void closeAllocator() {
        assertEquals("all Arrow memory is released", 0, allocator.getAllocatedMemory());
        allocator.close();
    }

    private static ArrowFieldNode node(int length, int nulls) {
        return new ArrowFieldNode(length, nulls);
    }

    private static byte[] ints(int... values) {
        ByteBuffer buffer = ByteBuffer.allocate(values.length * Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        for (int value : values) {
            buffer.putInt(value);
        }
        return buffer.array();
    }

    /** Sends a batch with these nodes and buffers through the marshaller, as the client receives it. */
    private ArrowStreamMessage received(int rows, List<ArrowFieldNode> nodes, byte[]... buffers) throws Exception {
        byte[] message = ArrowIpcMarshallerTest.recordBatchMessage(allocator, rows, nodes, buffers);
        return new ArrowIpcMarshaller(allocator).parse(new ByteArrayInputStream(message));
    }

    private void assertRejected(String expected, List<Field> fields, int rows, List<ArrowFieldNode> nodes, byte[]... buffers)
        throws Exception {
        try (ArrowStreamMessage message = received(rows, nodes, buffers)) {
            RecordBatchValidator.validate(message.batch, fields, message.payloadBytes);
            fail("expected TransportException containing [" + expected + "]");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains(expected));
        }
    }

    @Test
    public void testRowCountsLargerThanTheBuffersAreRejected() throws Exception {
        // A billion rows in a few bytes: loading would grow the vector to 8GB
        assertRejected(
            "needs 8000000000 bytes of data buffer",
            List.of(LONG),
            1_000_000_000,
            List.of(node(1_000_000_000, 0)),
            new byte[0],
            new byte[8]
        );
        assertRejected(
            "needs 125000000 bytes of validity buffer",
            List.of(LONG),
            1_000_000_000,
            List.of(node(1_000_000_000, 1)),
            new byte[8],
            new byte[8]
        );
        // A column with fewer values than the batch has rows, which loading would grow to the row count
        assertRejected("has 1 values where 2 are read", List.of(LONG), 2, List.of(node(1, 0)), new byte[1], new byte[8]);
        assertRejected("has 2 values in a batch of 1 rows", List.of(LONG), 1, List.of(node(2, 0)), new byte[1], new byte[16]);
        assertRejected("declares 2 nulls among 1 values", List.of(LONG), 1, List.of(node(1, 2)), new byte[1], new byte[8]);
    }

    @Test
    public void testFixedWidthDataIsCheckedAtTheWidthOfItsVector() throws Exception {
        // TypeLayout keeps the width in bits as a short, 0 for 8192 bytes: loading would grow the data to 3970 values of 8KB
        Field wide = new Field("wide", FieldType.nullable(new ArrowType.FixedSizeBinary(8192)), null);
        assertRejected("needs 8192 bytes of data buffer", List.of(wide), 1, List.of(node(1, 0)), new byte[1], new byte[0]);
        // A width whose size in bits overflows an int to 8
        Field huge = new Field("huge", FieldType.nullable(new ArrowType.FixedSizeBinary((1 << 29) + 1)), null);
        assertRejected("needs 536870913 bytes of data buffer", List.of(huge), 1, List.of(node(1, 0)), new byte[1], new byte[1]);
        Field negative = new Field("negative", FieldType.nullable(new ArrowType.FixedSizeBinary(-1)), null);
        assertRejected("has values of -1 bytes", List.of(negative), 1, List.of(node(1, 0)), new byte[1], new byte[0]);
        // Declared widths that their vectors do not have, which loading would read and grow at the vector's width
        Field decimal = new Field("decimal", FieldType.nullable(new ArrowType.Decimal(10, 2, 64)), null);
        assertRejected("whose values Arrow loads as 128 bits", List.of(decimal), 1, List.of(node(1, 0)), new byte[1], new byte[8]);
        Field time = new Field("time", FieldType.nullable(new ArrowType.Time(TimeUnit.MICROSECOND, 32)), null);
        assertRejected("whose values Arrow loads as 64 bits", List.of(time), 1, List.of(node(1, 0)), new byte[1], new byte[4]);
        try (ArrowStreamMessage message = received(1, List.of(node(1, 0)), new byte[1], new byte[8192])) {
            RecordBatchValidator.validate(message.batch, List.of(wide), message.payloadBytes);
        }
    }

    @Test
    public void testValidityLeftOutOnlyWhenAllOrNoValuesAreNull() throws Exception {
        // Loading would keep the empty bitmap, then grow it and the data for the declared values
        assertRejected(
            "has 1 nulls among 2 values but no validity buffer",
            List.of(LONG),
            2,
            List.of(node(2, 1)),
            new byte[0],
            new byte[16]
        );
        // Arrow creates a bitmap for each left out; together they may not exceed the message
        Field noChildren = new Field("s", FieldType.nullable(new ArrowType.Struct()), List.of());
        assertRejected(
            "leaves out validity buffers Arrow would create 125000000 bytes for",
            List.of(noChildren),
            1_000_000_000,
            List.of(node(1_000_000_000, 0)),
            new byte[0]
        );
        try (ArrowStreamMessage message = received(2, List.of(node(2, 0)), new byte[0], new byte[16])) {
            RecordBatchValidator.validate(message.batch, List.of(LONG), message.payloadBytes);
        }
    }

    @Test
    public void testOffsetsMustFitTheirDataAndChildren() throws Exception {
        assertRejected("needs 12 bytes of offset buffer", List.of(KEYWORD), 2, List.of(node(2, 0)), new byte[1], ints(0, 1), new byte[1]);
        assertRejected(
            "has values up to byte 9 of a data buffer of 2 bytes",
            List.of(KEYWORD),
            2,
            List.of(node(2, 0)),
            new byte[1],
            ints(0, 1, 9),
            new byte[2]
        );
        assertRejected("has decreasing offsets", List.of(KEYWORD), 2, List.of(node(2, 0)), new byte[1], ints(0, 2, 1), new byte[2]);
        assertRejected("has a negative offset", List.of(KEYWORD), 1, List.of(node(1, 0)), new byte[1], ints(-1, 0), new byte[0]);
        // A list's last offset is the number of child values loading reads, which the child must hold
        assertRejected(
            "column [values.$data$] has 1 values where 1000000000 are read",
            List.of(LONGS),
            1,
            List.of(node(1, 0), node(1, 0)),
            new byte[1],
            ints(0, 1_000_000_000),
            new byte[1],
            new byte[8]
        );
        assertRejected(
            "column [values.$data$] needs 8000000000 bytes of data buffer",
            List.of(LONGS),
            1,
            List.of(node(1, 0), node(1_000_000_000, 0)),
            new byte[1],
            ints(0, 1_000_000_000),
            new byte[0],
            new byte[8]
        );
    }

    @Test
    public void testNodesAndBuffersMustMatchTheColumns() throws Exception {
        assertRejected("has no field node for column [id]", List.of(LONG, KEYWORD), 1, List.of(node(1, 0)), new byte[1], new byte[8]);
        assertRejected("has too few buffers for column [value]", List.of(LONG), 1, List.of(node(1, 0)), new byte[1]);
        assertRejected("has more field nodes or buffers", List.of(LONG), 1, List.of(node(1, 0), node(1, 0)), new byte[1], new byte[8]);
        Field union = new Field(
            "u",
            FieldType.nullable(new ArrowType.Union(UnionMode.Sparse, new int[] { 0 })),
            List.of(new Field("i", FieldType.nullable(new ArrowType.Int(32, true)), null))
        );
        assertRejected("which Arrow search does not send", List.of(union), 0, List.of(node(0, 0)), new byte[0]);
    }

    @Test
    public void testCompressedBatchesAreRejected() {
        ArrowBodyCompression lz4 = new ArrowBodyCompression(CompressionUtil.CodecType.LZ4_FRAME.getType(), BodyCompressionMethod.BUFFER);
        // Their buffer sizes are not those of the values; Arrow search sends none
        try (
            ArrowRecordBatch batch = new ArrowRecordBatch(0, List.of(node(0, 0)), List.of(allocator.getEmpty(), allocator.getEmpty()), lz4)
        ) {
            RecordBatchValidator.validate(batch, List.of(LONG), 100);
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("is compressed with LZ4_FRAME"));
        }
    }

    @Test
    public void testBatchesOfThePluginTypesLoad() throws Exception {
        for (int rows : new int[] { 0, 1, 100 }) {
            try (VectorSchemaRoot written = VectorSchemaRoot.create(PLUGIN_TYPES, allocator)) {
                if (rows > 0) {
                    written.allocateNew();
                    fill(written, rows);
                }
                written.setRowCount(rows);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                try (ArrowRecordBatch batch = new VectorUnloader(written).getRecordBatch()) {
                    MessageSerializer.serialize(new WriteChannel(Channels.newChannel(out)), batch);
                }
                byte[] payload = ArrowIpcMarshallerTest.payload(out.toByteArray());
                try (
                    ArrowStreamMessage message = new ArrowIpcMarshaller(allocator).parse(new ByteArrayInputStream(payload));
                    VectorSchemaRoot read = VectorSchemaRoot.create(PLUGIN_TYPES, allocator)
                ) {
                    RecordBatchValidator.validate(message.batch, read.getSchema().getFields(), message.payloadBytes);
                    new VectorLoader(read).load(message.batch);
                    assertEquals(rows, read.getRowCount());
                    assertTrue(written.equals(read));
                }
            }
        }
    }

    private static void fill(VectorSchemaRoot root, int rows) {
        UnionListWriter values = ((ListVector) root.getVector("values")).getWriter();
        for (int i = 0; i < rows; i++) {
            if (i % 7 == 3) {
                // nulls in every column but the list
                continue;
            }
            ((BigIntVector) root.getVector("long")).setSafe(i, i * 10L);
            ((UInt8Vector) root.getVector("unsigned_long")).setSafe(i, i);
            ((Float8Vector) root.getVector("double")).setSafe(i, i / 4.0);
            ((BitVector) root.getVector("boolean")).setSafe(i, i % 2);
            ((TimeStampMilliTZVector) root.getVector("date")).setSafe(i, 1_700_000_000_000L + i);
            ((VarCharVector) root.getVector("keyword")).setSafe(i, ("k" + i).getBytes(StandardCharsets.UTF_8));
            ((FixedSizeBinaryVector) root.getVector("ip")).setSafe(i, new byte[16]);
        }
        for (int i = 0; i < rows; i++) {
            values.setPosition(i);
            values.startList();
            for (int j = 0; j < i % 3; j++) {
                values.bigInt().writeBigInt(i + j);
            }
            values.endList();
        }
        values.setValueCount(rows);
    }
}
