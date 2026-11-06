/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import java.io.IOException;
import java.io.UncheckedIOException;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.ipc.ArrowReader;
import org.apache.arrow.vector.types.pojo.Schema;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.grpc.GrpcServerStream;
import org.opensearch.client.transport.grpc.translation.SearchResponseConverter;

/**
 * The results of an Arrow search, read batch by batch as a standard {@link ArrowReader}: {@link #getVectorSchemaRoot()}
 * holds the current batch, {@link #loadNextBatch()} replaces it with the next one, and {@link #summary()} is available
 * once {@link #loadNextBatch()} returns {@code false}.
 * <p>
 * The search produces only as fast as this reader is read: not calling {@link #loadNextBatch()} pauses it on every
 * node, and calling it resumes it. Rows of different shards interleave, in no particular order. A failure after some
 * batches were read is thrown from {@link #loadNextBatch()}; the rows read so far are then incomplete and should be
 * discarded. A batch whose row and value counts do not fit the bytes it holds fails the search with a
 * {@code TransportException} before it is loaded, so that a malformed batch cannot make Arrow allocate memory for rows it
 * does not hold. Closing the reader before the end cancels the search and frees all its Arrow memory.
 * <p>
 * Being an {@link ArrowReader}, it can be handed to Arrow-native tools without copying, e.g. with
 * {@code Data.exportArrayStream} from the Arrow C data interface. Not thread-safe, except {@link #cancel()}.
 */
public final class ArrowSearchResponse extends ArrowReader {

    private final GrpcServerStream<ArrowStreamMessage> stream;
    private final BufferAllocator callAllocator;
    private final JsonpMapper mapper;
    private final Schema schema;
    private org.opensearch.protobufs.SearchResponse summary;
    private long bytesRead;
    private boolean ended;

    /**
     * Waits for the schema, so that request, authentication and authorization errors are thrown here.
     */
    ArrowSearchResponse(GrpcServerStream<ArrowStreamMessage> stream, BufferAllocator callAllocator, JsonpMapper mapper) throws IOException {
        super(callAllocator);
        this.stream = stream;
        this.callAllocator = callAllocator;
        this.mapper = mapper;
        ArrowStreamMessage first = next();
        if (first == null) {
            throw new TransportException("Arrow search stream ended without a schema");
        }
        if (first.kind != ArrowStreamMessage.Kind.SCHEMA) {
            first.close();
            throw new TransportException("Arrow search stream did not start with a schema");
        }
        this.schema = first.schema;
        this.bytesRead = first.payloadBytes;
    }

    /** Returns the next message, reporting a message that fails to decode as a {@link TransportException}. */
    private ArrowStreamMessage next() throws IOException {
        try {
            return stream.next();
        } catch (UncheckedIOException e) {
            throw new TransportException("Malformed Arrow search message: " + e.getCause().getMessage(), e.getCause());
        }
    }

    @Override
    protected Schema readSchema() {
        return schema;
    }

    /**
     * Loads the next batch into {@link #getVectorSchemaRoot()}, waiting for it.
     *
     * @return {@code true} if a batch was loaded, {@code false} at the end of the results
     * @throws IOException if the search failed, e.g. a {@code TransportException}; rows read so far are incomplete
     * @throws org.opensearch.client.opensearch._types.OpenSearchException for errors the server reported with a status
     */
    @Override
    public boolean loadNextBatch() throws IOException {
        prepareLoadNextBatch();
        if (ended) {
            return false;
        }
        final ArrowStreamMessage message;
        try {
            message = next();
        } catch (IOException | RuntimeException e) {
            ended = true;
            throw e;
        }
        if (message == null) {
            ended = true;
            throw new TransportException("Arrow search stream ended without its summary");
        }
        switch (message.kind) {
            case BATCH:
                bytesRead += message.payloadBytes;
                try {
                    // Validate before Arrow sizes the vectors from the counts the batch declares
                    RecordBatchValidator.validate(message.batch, getVectorSchemaRoot().getSchema().getFields(), message.payloadBytes);
                } catch (TransportException e) {
                    message.close();
                    ended = true;
                    throw e;
                }
                // Loads the batch into the root's vectors, and releases it.
                loadRecordBatch(message.batch);
                return true;
            case SUMMARY:
                ended = true;
                // The summary counts only once the call closed successfully after it.
                ArrowStreamMessage after = next();
                if (after != null) {
                    after.close();
                    throw new TransportException("Arrow search stream continued after its summary");
                }
                summary = message.summary;
                return false;
            default:
                message.close();
                ended = true;
                throw new TransportException("Arrow search stream sent a second schema");
        }
    }

    /**
     * Returns the search's summary: took, shards, timed out, terminated early, and the number of rows as total hits. The
     * relation is {@code gte} when {@code size}, {@code terminate_after} or {@code timeout} cut the results.
     *
     * @throws IllegalStateException until {@link #loadNextBatch()} returned {@code false}
     */
    public SearchResponse<Void> summary() {
        if (summary == null) {
            throw new IllegalStateException("The summary is available once loadNextBatch() returned false");
        }
        return SearchResponseConverter.fromProto(summary, mapper, Void.class);
    }

    /**
     * Cancels the search on every node; a waiting or later {@link #loadNextBatch()} fails. Safe from any thread.
     */
    public void cancel() {
        stream.cancel();
    }

    /**
     * Returns the number of bytes of Arrow IPC messages read so far.
     */
    @Override
    public long bytesRead() {
        return bytesRead;
    }

    @Override
    protected void closeReadSource() {
        try {
            // Cancels a search still running and frees the batches not read.
            stream.close();
        } finally {
            callAllocator.close();
        }
    }
}
