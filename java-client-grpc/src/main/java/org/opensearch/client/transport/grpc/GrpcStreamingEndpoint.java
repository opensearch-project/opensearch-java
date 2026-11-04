/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.MethodDescriptor;
import java.util.Collections;
import java.util.Map;
import org.opensearch.client.json.JsonpMapper;

/**
 * Describes a server-streaming gRPC call made through a {@link GrpcStreamingTransport}: the method it calls, how a
 * client request becomes the method's request message, the request metadata it adds, and how its response messages
 * are decoded.
 *
 * @param <RequestT> the client request
 * @param <ProtoT>   the request message of the method
 * @param <MessageT> what each response message decodes to
 */
public interface GrpcStreamingEndpoint<RequestT, ProtoT, MessageT> {

    /**
     * Returns the server-streaming method to call. Its response marshaller is replaced by {@link #responseMarshaller()}.
     */
    MethodDescriptor<ProtoT, ?> method();

    /**
     * Converts the client request to the request message of the method.
     *
     * @throws UnsupportedOperationException if the request cannot be sent over gRPC
     */
    ProtoT toProto(RequestT request, JsonpMapper mapper);

    /**
     * Returns the request metadata to send with the call, e.g. a response format. Names are lower case.
     */
    default Map<String, String> headers(RequestT request) {
        return Collections.emptyMap();
    }

    /**
     * Returns the marshaller that decodes each response message. It runs on gRPC's call executor, one message at a time,
     * and may hold resources until the message is {@linkplain #discard discarded} or handed to the caller.
     */
    MethodDescriptor.Marshaller<MessageT> responseMarshaller();

    /**
     * Returns how many decoded messages may wait for the caller. Once this many are unread, gRPC flow control pauses the
     * server.
     */
    default int prefetch() {
        return 2;
    }

    /**
     * Releases a decoded message the caller will never see, e.g. one still queued when the stream is closed early.
     */
    default void discard(MessageT message) {}
}
