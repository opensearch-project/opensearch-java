/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import io.grpc.HasByteBuffer;
import io.grpc.KnownLength;
import io.grpc.MethodDescriptor;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import org.apache.arrow.flatbuf.MessageHeader;
import org.apache.arrow.memory.ArrowBuf;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageMetadataResult;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.opensearch.protobufs.SearchResponse;

/**
 * Decodes the response messages of an Arrow search without parsing them as protobuf when they carry Arrow data.
 * <p>
 * Every message is a protobuf {@code SearchResponse}. A data message holds only field 100, one Arrow IPC encapsulated
 * message (a schema or a record batch); the last message is a regular {@code SearchResponse}, the summary. A record
 * batch's body is copied once, straight from gRPC's network buffers into one {@link ArrowBuf} of the call's allocator,
 * which the batch's vectors then slice: no heap copy, no protobuf parse, no row objects.
 * <p>
 * Every byte length a message declares (its payload, its IPC metadata and its body) must match the bytes it holds before
 * anything is allocated for it. gRPC knows the size of the messages it buffered, except compressed ones: their payload is
 * read onto the heap first, as it arrives. The row and value counts of a record batch are checked against its buffers by
 * {@link RecordBatchValidator} before the batch is loaded into vectors.
 */
final class ArrowIpcMarshaller implements MethodDescriptor.Marshaller<ArrowStreamMessage> {

    /** The protobuf tag of field 100, length-delimited: {@code (100 << 3) | 2} as a varint. */
    private static final int PAYLOAD_TAG_FIRST_BYTE = 0xA2;
    private static final int PAYLOAD_TAG_SECOND_BYTE = 0x06;
    /** Chunk size when the stream cannot expose its buffers, as with the in-process transport. */
    private static final int COPY_CHUNK = 64 * 1024;

    private final BufferAllocator allocator;

    ArrowIpcMarshaller(BufferAllocator allocator) {
        this.allocator = allocator;
    }

    @Override
    public InputStream stream(ArrowStreamMessage value) {
        throw new UnsupportedOperationException("Arrow search messages are only received");
    }

    @Override
    public ArrowStreamMessage parse(InputStream stream) {
        try {
            int first = stream.read();
            int second = first < 0 ? -1 : stream.read();
            if (first != PAYLOAD_TAG_FIRST_BYTE || second != PAYLOAD_TAG_SECOND_BYTE) {
                // Not an Arrow payload: the summary, a small regular SearchResponse.
                byte[] head = first < 0 ? new byte[0]
                    : second < 0 ? new byte[] { (byte) first }
                    : new byte[] { (byte) first, (byte) second };
                return ArrowStreamMessage.summary(
                    SearchResponse.parseFrom(new SequenceInputStream(new ByteArrayInputStream(head), stream))
                );
            }
            long payloadLength = readVarint(stream);
            if (payloadLength < 0 || payloadLength >= Integer.MAX_VALUE) {
                throw new IOException("Malformed length in an Arrow search message");
            }
            if (stream instanceof KnownLength == false) {
                // A compressed message: read it as it arrives, plus one byte to detect a message that holds more.
                stream = new ByteArrayInputStream(stream.readNBytes((int) payloadLength + 1));
            }
            int held = stream.available();
            if (held != payloadLength) {
                throw new IOException(
                    "Arrow search message holds "
                        + (held < payloadLength ? held : "more")
                        + " bytes after its length, which declares "
                        + payloadLength
                );
            }
            return readIpcMessage(stream, payloadLength);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read an Arrow search message", e);
        }
    }

    private ArrowStreamMessage readIpcMessage(InputStream stream, long payloadLength) throws IOException {
        // Not MessageSerializer.readMessage, which allocates the metadata length it reads before checking it.
        int prefixLength = 4;
        int metadataLength = readInt(stream);
        if (metadataLength == MessageSerializer.IPC_CONTINUATION_TOKEN) {
            prefixLength = 8;
            metadataLength = readInt(stream);
        }
        if (metadataLength == 0) {
            throw new IOException("Arrow search message holds no Arrow IPC message");
        }
        if (metadataLength < 0 || prefixLength + (long) metadataLength > payloadLength) {
            throw new IOException(
                "Arrow IPC metadata of " + metadataLength + " bytes does not fit its payload of " + payloadLength + " bytes"
            );
        }
        byte[] metadataBytes = stream.readNBytes(metadataLength);
        if (metadataBytes.length != metadataLength) {
            throw new EOFException("Arrow search message ended inside its Arrow IPC metadata");
        }
        MessageMetadataResult metadata = MessageMetadataResult.create(ByteBuffer.wrap(metadataBytes), metadataLength);
        long bodyLength = metadata.getMessageBodyLength();
        long messageLength = (long) prefixLength + metadataLength + bodyLength;
        if (messageLength != payloadLength) {
            throw new IOException(
                "Arrow IPC message of " + messageLength + " bytes does not fill its payload of " + payloadLength + " bytes"
            );
        }
        byte header = metadata.getMessage().headerType();
        if (header == MessageHeader.Schema) {
            skipFully(stream, bodyLength);
            return ArrowStreamMessage.schema(MessageSerializer.deserializeSchema(metadata), payloadLength);
        }
        if (header != MessageHeader.RecordBatch) {
            throw new IOException("Unexpected Arrow IPC message type [" + MessageHeader.name(header) + "] in an Arrow search stream");
        }
        ArrowBuf body = allocator.buffer(bodyLength);
        boolean handedOver = false;
        try {
            copyBody(stream, body, bodyLength);
            // The batch takes over the body: it retains its slices and releases the body's own reference.
            ArrowRecordBatch batch = MessageSerializer.deserializeRecordBatch(metadata, body);
            handedOver = true;
            return ArrowStreamMessage.batch(batch, payloadLength);
        } finally {
            if (handedOver == false) {
                body.close();
            }
        }
    }

    /** Copies the body from gRPC's buffers, directly when the stream exposes them. */
    private static void copyBody(InputStream stream, ArrowBuf body, long length) throws IOException {
        long copied = 0;
        byte[] chunk = null;
        while (copied < length) {
            if (stream instanceof HasByteBuffer && ((HasByteBuffer) stream).byteBufferSupported()) {
                ByteBuffer buffer = ((HasByteBuffer) stream).getByteBuffer();
                if (buffer == null || buffer.hasRemaining() == false) {
                    throw new EOFException("Arrow search message ended inside a record batch");
                }
                int n = (int) Math.min(buffer.remaining(), length - copied);
                body.setBytes(copied, buffer, buffer.position(), n);
                skipFully(stream, n);
                copied += n;
            } else {
                if (chunk == null) {
                    chunk = new byte[(int) Math.min(COPY_CHUNK, length)];
                }
                int n = stream.read(chunk, 0, (int) Math.min(chunk.length, length - copied));
                if (n < 0) {
                    throw new EOFException("Arrow search message ended inside a record batch");
                }
                body.setBytes(copied, chunk, 0, n);
                copied += n;
            }
        }
    }

    private static void skipFully(InputStream stream, long n) throws IOException {
        long left = n;
        while (left > 0) {
            long skipped = stream.skip(left);
            if (skipped <= 0) {
                if (stream.read() < 0) {
                    throw new EOFException("Arrow search message ended early");
                }
                skipped = 1;
            }
            left -= skipped;
        }
    }

    /** Reads a little-endian int32, as Arrow IPC writes the metadata length. */
    private static int readInt(InputStream stream) throws IOException {
        byte[] bytes = stream.readNBytes(4);
        if (bytes.length != 4) {
            throw new EOFException("Arrow search message ended inside its Arrow IPC metadata");
        }
        return MessageSerializer.bytesToInt(bytes);
    }

    private static long readVarint(InputStream stream) throws IOException {
        long value = 0;
        for (int shift = 0; shift < 64; shift += 7) {
            int b = stream.read();
            if (b < 0) {
                throw new EOFException("Arrow search message ended inside its length");
            }
            value |= (long) (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return value;
            }
        }
        throw new IOException("Malformed length in an Arrow search message");
    }
}
