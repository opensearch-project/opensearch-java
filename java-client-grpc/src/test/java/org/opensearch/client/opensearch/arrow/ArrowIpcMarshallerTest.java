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

import io.grpc.HasByteBuffer;
import io.grpc.KnownLength;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.arrow.memory.ArrowBuf;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.ipc.WriteChannel;
import org.apache.arrow.vector.ipc.message.ArrowFieldNode;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.protobufs.SearchResponse;

public class ArrowIpcMarshallerTest {

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

    static final Schema SCHEMA = new Schema(
        List.of(
            new Field("id", FieldType.nullable(new ArrowType.Utf8()), null),
            new Field("group", FieldType.nullable(new ArrowType.Int(32, true)), null),
            new Field("value", FieldType.nullable(new ArrowType.Int(64, true)), null)
        )
    );

    /** Wraps an Arrow IPC message in field 100 of a SearchResponse, as the server sends it. */
    static byte[] payload(byte[] ipc) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(0xA2);
        out.write(0x06);
        long length = ipc.length;
        while ((length & ~0x7FL) != 0) {
            out.write((int) ((length & 0x7F) | 0x80));
            length >>>= 7;
        }
        out.write((int) length);
        out.writeBytes(ipc);
        return out.toByteArray();
    }

    static byte[] schemaMessage(Schema schema) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MessageSerializer.serialize(new WriteChannel(Channels.newChannel(out)), schema);
        return payload(out.toByteArray());
    }

    static byte[] batchMessage(BufferAllocator allocator, int rows, int offset) throws Exception {
        try (VectorSchemaRoot root = VectorSchemaRoot.create(SCHEMA, allocator)) {
            VarCharVector id = (VarCharVector) root.getVector("id");
            IntVector group = (IntVector) root.getVector("group");
            BigIntVector value = (BigIntVector) root.getVector("value");
            root.allocateNew();
            for (int i = 0; i < rows; i++) {
                int n = offset + i;
                id.setSafe(i, String.valueOf(n).getBytes(StandardCharsets.UTF_8));
                group.setSafe(i, n % 4);
                if (n % 5 != 0) {
                    value.setSafe(i, n * 10L);
                }
            }
            root.setRowCount(rows);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try (ArrowRecordBatch batch = new VectorUnloader(root).getRecordBatch()) {
                MessageSerializer.serialize(new WriteChannel(Channels.newChannel(out)), batch);
            }
            return payload(out.toByteArray());
        }
    }

    /** A record batch message with these nodes and buffers, whatever counts they declare. */
    static byte[] recordBatchMessage(BufferAllocator allocator, int rows, List<ArrowFieldNode> nodes, byte[]... buffers) throws Exception {
        List<ArrowBuf> held = new ArrayList<>();
        try {
            for (byte[] bytes : buffers) {
                ArrowBuf buffer = allocator.buffer(bytes.length);
                buffer.setBytes(0, bytes);
                buffer.writerIndex(bytes.length);
                held.add(buffer);
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try (ArrowRecordBatch batch = new ArrowRecordBatch(rows, nodes, held)) {
                MessageSerializer.serialize(new WriteChannel(Channels.newChannel(out)), batch);
            }
            return payload(out.toByteArray());
        } finally {
            held.forEach(ArrowBuf::close);
        }
    }

    /** The offset of the body of a record batch message: past the tag, the length, the IPC prefix and the metadata. */
    private static int bodyStart(byte[] message) {
        int start = 2;
        while ((message[start] & 0x80) != 0) {
            start++;
        }
        start++;
        int metadataLength = ByteBuffer.wrap(message, start + 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
        return start + 8 + metadataLength;
    }

    @Test
    public void testSchemaAndBatchDecodeIntoVectors() throws Exception {
        ArrowIpcMarshaller marshaller = new ArrowIpcMarshaller(allocator);
        try (ArrowStreamMessage schema = marshaller.parse(new ByteArrayInputStream(schemaMessage(SCHEMA)))) {
            assertEquals(ArrowStreamMessage.Kind.SCHEMA, schema.kind);
            assertEquals(SCHEMA, schema.schema);
        }
        try (
            ArrowStreamMessage batch = marshaller.parse(new ByteArrayInputStream(batchMessage(allocator, 100, 0)));
            VectorSchemaRoot root = VectorSchemaRoot.create(SCHEMA, allocator)
        ) {
            assertEquals(ArrowStreamMessage.Kind.BATCH, batch.kind);
            new VectorLoader(root).load(batch.batch);
            assertEquals(100, root.getRowCount());
            assertEquals("42", new String(((VarCharVector) root.getVector("id")).get(42), StandardCharsets.UTF_8));
            assertEquals(2, ((IntVector) root.getVector("group")).get(42));
            assertEquals(420L, ((BigIntVector) root.getVector("value")).get(42));
            assertEquals(true, root.getVector("value").isNull(40));
        }
    }

    @Test
    public void testTheSummaryIsARegularSearchResponse() {
        byte[] summary = SearchResponse.newBuilder().setTook(7).setTimedOut(false).build().toByteArray();
        try (ArrowStreamMessage message = new ArrowIpcMarshaller(allocator).parse(new ByteArrayInputStream(summary))) {
            assertEquals(ArrowStreamMessage.Kind.SUMMARY, message.kind);
            assertEquals(7, message.summary.getTook());
        }
    }

    @Test
    public void testBodiesAreCopiedStraightFromBuffersTheStreamExposes() throws Exception {
        byte[] message = batchMessage(allocator, 1_000, 0);
        try (
            ArrowStreamMessage batch = new ArrowIpcMarshaller(allocator).parse(new BufferStream(message, 1_000));
            VectorSchemaRoot root = VectorSchemaRoot.create(SCHEMA, allocator)
        ) {
            new VectorLoader(root).load(batch.batch);
            assertEquals(1_000, root.getRowCount());
            assertEquals("999", new String(((VarCharVector) root.getVector("id")).get(999), StandardCharsets.UTF_8));
            assertEquals(9_990L, ((BigIntVector) root.getVector("value")).get(999));
        }
    }

    @Test
    public void testATruncatedBatchIsRejectedBeforeItsBodyIsAllocated() throws Exception {
        // The length and the batch's body length agree, but the message stops 10 bytes into the body.
        byte[] message = batchMessage(allocator, 10_000, 0);
        byte[] truncated = Arrays.copyOf(message, bodyStart(message) + 10);
        for (InputStream stream : List.of(new ByteArrayInputStream(truncated), new BufferStream(truncated, 1_000))) {
            try (BufferAllocator decoder = allocator.newChildAllocator("decoder", 0, Long.MAX_VALUE)) {
                try {
                    new ArrowIpcMarshaller(decoder).parse(stream);
                    fail("expected UncheckedIOException");
                } catch (UncheckedIOException e) {
                    assertTrue(e.getCause().getMessage(), e.getCause().getMessage().contains("after its length, which declares"));
                }
                assertEquals("no Arrow memory is reserved for bytes the message does not hold", 0, decoder.getPeakMemoryAllocation());
            }
        }
    }

    @Test
    public void testAMetadataLengthPastThePayloadIsRejectedBeforeItIsAllocated() {
        // A payload of 8 bytes: the continuation token, then a metadata length of 64MB.
        byte[] message = { (byte) 0xA2, 0x06, 0x08, -1, -1, -1, -1, 0x00, 0x00, 0x00, 0x04 };
        for (InputStream stream : List.of(new ByteArrayInputStream(message), new BufferStream(message, 1_000))) {
            try {
                new ArrowIpcMarshaller(allocator).parse(stream);
                fail("expected UncheckedIOException");
            } catch (UncheckedIOException e) {
                assertTrue(e.getCause().getMessage(), e.getCause().getMessage().contains("does not fit its payload"));
            }
        }
    }

    @Test
    public void testBytesPastThePayloadAreRejected() throws Exception {
        byte[] schema = schemaMessage(SCHEMA);
        byte[] message = Arrays.copyOf(schema, schema.length + 1);
        for (InputStream stream : List.of(new ByteArrayInputStream(message), new BufferStream(message, 1_000))) {
            try (ArrowStreamMessage parsed = new ArrowIpcMarshaller(allocator).parse(stream)) {
                fail("expected UncheckedIOException, got " + parsed.kind);
            } catch (UncheckedIOException e) {
                assertTrue(e.getCause().getMessage(), e.getCause().getMessage().contains("after its length, which declares"));
            }
        }
    }

    @Test
    public void testAPayloadLengthThatDisagreesWithTheMessageIsRejected() throws Exception {
        byte[] message = batchMessage(allocator, 100, 0);
        // The payload declares one byte more than the Arrow message holds: tag, then a varint length, then the message.
        int start = 2;
        while ((message[start] & 0x80) != 0) {
            start++;
        }
        ByteArrayOutputStream ipc = new ByteArrayOutputStream();
        ipc.write(message, start + 1, message.length - start - 1);
        ipc.write(0);
        try {
            new ArrowIpcMarshaller(allocator).parse(new ByteArrayInputStream(payload(ipc.toByteArray())));
            fail("expected UncheckedIOException");
        } catch (UncheckedIOException e) {
            assertTrue(e.getCause().getMessage(), e.getCause().getMessage().contains("does not fill its payload"));
        }
    }

    /**
     * A stream of known length exposing its bytes as buffers of at most {@code chunk} bytes, as gRPC's Netty transport
     * passes an uncompressed message.
     */
    private static final class BufferStream extends InputStream implements KnownLength, HasByteBuffer {
        private final ByteBuffer bytes;
        private final int chunk;

        BufferStream(byte[] bytes, int chunk) {
            this.bytes = ByteBuffer.wrap(bytes);
            this.chunk = chunk;
        }

        @Override
        public boolean byteBufferSupported() {
            return true;
        }

        @Override
        public ByteBuffer getByteBuffer() {
            ByteBuffer view = bytes.slice();
            return view.limit(Math.min(chunk, view.remaining()));
        }

        @Override
        public int available() {
            return bytes.remaining();
        }

        @Override
        public int read() {
            return bytes.hasRemaining() ? bytes.get() & 0xFF : -1;
        }

        @Override
        public int read(byte[] b, int off, int len) {
            if (bytes.hasRemaining() == false) {
                return -1;
            }
            int n = Math.min(len, bytes.remaining());
            bytes.get(b, off, n);
            return n;
        }

        @Override
        public long skip(long n) {
            int skipped = (int) Math.min(n, bytes.remaining());
            bytes.position(bytes.position() + skipped);
            return skipped;
        }
    }
}
