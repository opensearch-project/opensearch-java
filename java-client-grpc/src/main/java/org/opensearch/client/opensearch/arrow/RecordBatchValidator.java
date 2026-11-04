/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import java.util.Iterator;
import java.util.List;
import org.apache.arrow.memory.ArrowBuf;
import org.apache.arrow.vector.TypeLayout;
import org.apache.arrow.vector.compression.CompressionUtil;
import org.apache.arrow.vector.ipc.message.ArrowFieldNode;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.types.TimeUnit;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.opensearch.client.transport.TransportException;

/**
 * Checks, before a record batch is loaded into vectors, that the counts it declares fit the buffers it holds.
 * <p>
 * Loading sets every vector's value count from the batch's row count and its node lengths, and Arrow grows a vector's
 * buffers until they hold that many values. It also creates a validity bitmap for each node whose validity buffer the
 * message leaves empty. Without this check, a message of a few hundred bytes that declares a billion rows would make the
 * client allocate gigabytes. So every buffer must hold the values its node declares, at the width of the vector they load
 * into. Offsets must not decrease and must stay within the data or the child they index. The bitmaps Arrow creates for
 * empty validity buffers must not exceed the size of the message. Loading then allocates about as much as the message
 * holds, at most.
 * <p>
 * The nodes and buffers are walked in the order {@code VectorLoader} takes them: a column's node, its buffers, then its
 * children's. Column types the arrow-search plugin does not send, such as unions and views, and compressed batches are
 * rejected.
 */
final class RecordBatchValidator {

    private final Iterator<ArrowFieldNode> nodes;
    private final Iterator<ArrowBuf> buffers;
    /** Bytes of the validity bitmaps loading creates for nodes without a validity buffer. */
    private long createdValidityBytes;

    private RecordBatchValidator(ArrowRecordBatch batch) {
        this.nodes = batch.getNodes().iterator();
        this.buffers = batch.getBuffers().iterator();
    }

    /**
     * Checks that loading the batch into vectors of the given fields stays within the buffers it holds.
     *
     * @param batch        a record batch, as decoded from a message
     * @param fields       the columns of the vectors it loads into, e.g. the fields of the reader's root
     * @param messageBytes the size of the Arrow IPC message that carried it
     * @throws TransportException if loading the batch would not fit its buffers
     */
    static void validate(ArrowRecordBatch batch, List<Field> fields, long messageBytes) throws TransportException {
        // As VectorLoader reads the codec
        CompressionUtil.CodecType codec = CompressionUtil.CodecType.fromCompressionType(batch.getBodyCompression().getCodec());
        if (codec != CompressionUtil.CodecType.NO_COMPRESSION) {
            throw invalid("is compressed with " + codec + ", which Arrow search does not do");
        }
        if (batch.getVariadicBufferCounts() != null && batch.getVariadicBufferCounts().isEmpty() == false) {
            throw invalid("has variadic buffers, which no column type Arrow search sends has");
        }
        long rows = batch.getLength();
        if (rows < 0) {
            throw invalid("declares " + rows + " rows");
        }
        RecordBatchValidator validator = new RecordBatchValidator(batch);
        for (Field field : fields) {
            long length = validator.column(field, field.getName(), rows);
            if (length != rows) {
                throw invalid("column [" + field.getName() + "] has " + length + " values in a batch of " + rows + " rows");
            }
        }
        if (validator.nodes.hasNext() || validator.buffers.hasNext()) {
            throw invalid("has more field nodes or buffers than its columns");
        }
        if (validator.createdValidityBytes > messageBytes) {
            throw invalid(
                "leaves out validity buffers Arrow would create "
                    + validator.createdValidityBytes
                    + " bytes for, more than the "
                    + messageBytes
                    + " bytes of its message"
            );
        }
    }

    /**
     * Checks one column and its children.
     *
     * @param needed how many values the parent reads from the column, which it must hold
     * @return the number of values the column's node declares
     */
    private long column(Field field, String path, long needed) throws TransportException {
        if (nodes.hasNext() == false) {
            throw invalid("has no field node for column [" + path + "]");
        }
        ArrowFieldNode node = nodes.next();
        long length = node.getLength();
        long nulls = node.getNullCount();
        if (length < 0 || nulls < 0 || nulls > length) {
            throw invalid("column [" + path + "] declares " + nulls + " nulls among " + length + " values");
        }
        if (length < needed) {
            throw invalid("column [" + path + "] has " + length + " values where " + needed + " are read");
        }
        ArrowType type = field.getType();
        while (type instanceof ArrowType.ExtensionType) {
            type = ((ArrowType.ExtensionType) type).storageType();
        }
        switch (type.getTypeID()) {
            case Null:
                // No buffers, and nothing to allocate
                break;
            case Int:
            case FloatingPoint:
            case Bool:
            case Decimal:
            case Date:
            case Time:
            case Timestamp:
            case Interval:
            case Duration:
            case FixedSizeBinary:
                validity(path, length, nulls);
                atLeast(path, "data", buffer(path), dataBytes(path, type, length));
                break;
            case Utf8:
            case Binary:
                variableWidth(path, length, nulls, Integer.BYTES);
                break;
            case LargeUtf8:
            case LargeBinary:
                variableWidth(path, length, nulls, Long.BYTES);
                break;
            case List:
            case Map:
                list(field, path, length, nulls, Integer.BYTES);
                break;
            case LargeList:
                list(field, path, length, nulls, Long.BYTES);
                break;
            case FixedSizeList:
                validity(path, length, nulls);
                long values = length * ((ArrowType.FixedSizeList) type).getListSize();
                if (values > Integer.MAX_VALUE) {
                    throw invalid("column [" + path + "] has " + values + " list values");
                }
                child(field, path, values);
                break;
            case Struct:
                validity(path, length, nulls);
                for (Field child : field.getChildren()) {
                    column(child, path + "." + child.getName(), length);
                }
                break;
            default:
                throw invalid("column [" + path + "] has type " + type + ", which Arrow search does not send");
        }
        return length;
    }

    /** Checks a validity buffer: it covers every value, or is left out when all or no values are null, as Arrow then creates it. */
    private void validity(String path, long length, long nulls) throws TransportException {
        ArrowBuf validity = buffer(path);
        if (validity.capacity() == 0) {
            if (nulls != 0 && nulls != length) {
                throw invalid("column [" + path + "] has " + nulls + " nulls among " + length + " values but no validity buffer");
            }
            createdValidityBytes += (length + 7) / 8;
        } else {
            atLeast(path, "validity", validity, (length + 7) / 8);
        }
    }

    /**
     * Returns the bytes of data the vector of a fixed-width type holds for {@code length} values. A type that declares
     * another width than its vector's is rejected, as loading would read the data with the vector's width and grow it to
     * hold the values.
     */
    private static long dataBytes(String path, ArrowType type, long length) throws TransportException {
        switch (type.getTypeID()) {
            case FixedSizeBinary:
                int byteWidth = ((ArrowType.FixedSizeBinary) type).getByteWidth();
                if (byteWidth <= 0) {
                    throw invalid("column [" + path + "] has values of " + byteWidth + " bytes");
                }
                // Not from TypeLayout, which keeps the width in bits as a short: values of 8192 bytes would take none
                return length * byteWidth;
            case Decimal:
                // DecimalVector holds 128 bits per value, Decimal256Vector 256
                int decimalBits = ((ArrowType.Decimal) type).getBitWidth();
                requireWidth(path, type, decimalBits, decimalBits == 256 ? 256 : 128);
                break;
            case Time:
                // TimeSecVector and TimeMilliVector hold 32 bits per value, TimeMicroVector and TimeNanoVector 64
                ArrowType.Time time = (ArrowType.Time) type;
                boolean time32 = time.getUnit() == TimeUnit.SECOND || time.getUnit() == TimeUnit.MILLISECOND;
                requireWidth(path, type, time.getBitWidth(), time32 ? 32 : 64);
                break;
            default:
                // The other fixed-width types have the width of their vector
                break;
        }
        int bits = TypeLayout.getTypeLayout(type).getBufferLayouts().get(1).getTypeBitWidth();
        return (length * bits + 7) / 8;
    }

    private static void requireWidth(String path, ArrowType type, int declaredBits, int vectorBits) throws TransportException {
        if (declaredBits != vectorBits) {
            throw invalid("column [" + path + "] has type " + type + ", whose values Arrow loads as " + vectorBits + " bits");
        }
    }

    private void variableWidth(String path, long length, long nulls, int offsetWidth) throws TransportException {
        validity(path, length, nulls);
        long end = offsets(path, buffer(path), length, offsetWidth);
        ArrowBuf data = buffer(path);
        if (end > data.capacity()) {
            throw invalid("column [" + path + "] has values up to byte " + end + " of a data buffer of " + data.capacity() + " bytes");
        }
    }

    private void list(Field field, String path, long length, long nulls, int offsetWidth) throws TransportException {
        validity(path, length, nulls);
        // Loading sets the child's value count to the last offset
        child(field, path, offsets(path, buffer(path), length, offsetWidth));
    }

    private void child(Field field, String path, long needed) throws TransportException {
        if (field.getChildren().size() != 1) {
            throw invalid("column [" + path + "] has " + field.getChildren().size() + " children, not one");
        }
        Field child = field.getChildren().get(0);
        column(child, path + "." + child.getName(), needed);
    }

    /**
     * Checks the offsets of {@code length} values, which must not decrease.
     *
     * @return the last offset: the end of the values in the data, or the number of child values
     */
    private static long offsets(String path, ArrowBuf offsets, long length, int width) throws TransportException {
        if (length == 0 && offsets.capacity() == 0) {
            return 0;
        }
        atLeast(path, "offset", offsets, (length + 1) * width);
        long previous = offset(offsets, 0, width);
        if (previous < 0) {
            throw invalid("column [" + path + "] has a negative offset");
        }
        for (long i = 1; i <= length; i++) {
            long offset = offset(offsets, i, width);
            if (offset < previous) {
                throw invalid("column [" + path + "] has decreasing offsets");
            }
            previous = offset;
        }
        return previous;
    }

    private static long offset(ArrowBuf offsets, long index, int width) {
        return width == Integer.BYTES ? offsets.getInt(index * width) : offsets.getLong(index * width);
    }

    private ArrowBuf buffer(String path) throws TransportException {
        if (buffers.hasNext() == false) {
            throw invalid("has too few buffers for column [" + path + "]");
        }
        return buffers.next();
    }

    private static void atLeast(String path, String kind, ArrowBuf buffer, long bytes) throws TransportException {
        if (buffer.capacity() < bytes) {
            throw invalid(
                "column [" + path + "] needs " + bytes + " bytes of " + kind + " buffer for its values, which has " + buffer.capacity()
            );
        }
    }

    private static TransportException invalid(String problem) {
        return new TransportException("Invalid Arrow record batch: it " + problem);
    }
}
