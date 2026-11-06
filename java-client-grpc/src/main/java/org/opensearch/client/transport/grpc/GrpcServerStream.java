/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;

/**
 * The response messages of a server-streaming gRPC call, pulled one at a time. The server produces only as fast as the
 * caller pulls: a caller that stops calling {@link #next()} pauses the server, and one that calls it resumes it.
 * <p>
 * {@link #next()} and {@link #close()} must be called by one thread at a time; {@link #cancel()} may be called from
 * any thread.
 *
 * @param <MessageT> what each response message decodes to
 */
public interface GrpcServerStream<MessageT> extends Closeable {

    /**
     * Waits for the next message.
     *
     * @return the next message, or {@code null} once the stream ended normally
     * @throws IOException if the call failed, e.g. a {@code TransportException} for transport and authentication errors
     * @throws org.opensearch.client.opensearch._types.OpenSearchException for errors the server reported with a status
     */
    @Nullable
    MessageT next() throws IOException;

    /**
     * Cancels the call, which ends the request on the server; a waiting or later {@link #next()} fails. Safe from any
     * thread.
     */
    void cancel();

    /**
     * Ends the stream: cancels the call if it is still running, waits briefly for it to close, and releases the messages
     * the caller did not take. Idempotent.
     */
    @Override
    void close();
}
