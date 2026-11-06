/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import java.io.IOException;
import javax.annotation.Nullable;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;

/**
 * A transport that can make server-streaming gRPC calls, on the same channel, with the same TLS, authentication and
 * interceptors as its other calls.
 */
public interface GrpcStreamingTransport extends OpenSearchTransport {

    /**
     * Starts a server-streaming call. It returns at once; the response messages, and any error, come from the returned
     * stream, which the caller must close.
     *
     * @param request  the client request
     * @param endpoint describes the call
     * @param options  per-request options, whose headers are sent as request metadata, as for unary calls; {@code null}
     *                 for the transport's
     * @return the stream of decoded response messages
     * @throws UnsupportedOperationException if the request cannot be sent over gRPC, or its options set something a
     *                                       gRPC call cannot carry, such as query parameters or a header value that is
     *                                       not printable ASCII (see {@link GrpcTransport#isSupported}); nothing is sent
     */
    <RequestT, ProtoT, MessageT> GrpcServerStream<MessageT> serverStream(
        RequestT request,
        GrpcStreamingEndpoint<RequestT, ProtoT, MessageT> endpoint,
        @Nullable TransportOptions options
    ) throws IOException;
}
