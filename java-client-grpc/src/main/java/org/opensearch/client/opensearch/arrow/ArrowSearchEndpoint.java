/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import io.grpc.MethodDescriptor;
import java.util.Map;
import org.apache.arrow.memory.BufferAllocator;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.transport.grpc.GrpcStreamingEndpoint;
import org.opensearch.client.transport.grpc.translation.SearchRequestConverter;
import org.opensearch.protobufs.services.SearchServiceGrpc;

/**
 * The Arrow search call: the existing {@code SearchService/ServerStreamSearch} method with the request metadata
 * {@code x-opensearch-format: arrow}, whose messages decode into Arrow memory of one call's allocator.
 */
final class ArrowSearchEndpoint
    implements
        GrpcStreamingEndpoint<SearchRequest, org.opensearch.protobufs.SearchRequest, ArrowStreamMessage> {

    /** The request metadata selecting the response format of {@code ServerStreamSearch}. */
    static final String FORMAT_HEADER = "x-opensearch-format";
    static final String ARROW_FORMAT = "arrow";

    private final ArrowIpcMarshaller marshaller;

    ArrowSearchEndpoint(BufferAllocator allocator) {
        this.marshaller = new ArrowIpcMarshaller(allocator);
    }

    @Override
    public MethodDescriptor<org.opensearch.protobufs.SearchRequest, ?> method() {
        return SearchServiceGrpc.getServerStreamSearchMethod();
    }

    @Override
    public org.opensearch.protobufs.SearchRequest toProto(SearchRequest request, JsonpMapper mapper) {
        // Strict: an option that cannot go over gRPC fails the call rather than being dropped.
        return SearchRequestConverter.toProto(request, mapper);
    }

    @Override
    public Map<String, String> headers(SearchRequest request) {
        return Map.of(FORMAT_HEADER, ARROW_FORMAT);
    }

    @Override
    public MethodDescriptor.Marshaller<ArrowStreamMessage> responseMarshaller() {
        return marshaller;
    }

    @Override
    public void discard(ArrowStreamMessage message) {
        message.close();
    }
}
