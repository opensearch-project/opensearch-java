/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.arrow;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.apache.arrow.memory.BufferAllocator;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.grpc.GrpcServerStream;
import org.opensearch.client.transport.grpc.GrpcStreamingTransport;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Arrow streaming search: runs a search and streams its matches as Apache Arrow record batches, read from doc values on
 * the server, through the existing {@code SearchService/ServerStreamSearch} gRPC method.
 * <p>
 * It uses the gRPC transport an {@code OpenSearchClient} uses, so the same TLS, basic, JWT or AWS SigV4 authentication
 * and interceptors apply, on the same port. The server needs the arrow-search plugin.
 * <pre>{@code
 * try (BufferAllocator allocator = new RootAllocator()) {
 *     OpenSearchArrowClient arrow = new OpenSearchArrowClient(transport, allocator); // a GrpcTransport or HybridTransport
 *     try (ArrowSearchResponse response = arrow.search(s -> s.index("logs-*")
 *             .query(q -> q.term(t -> t.field("status").value(FieldValue.of(500))))
 *             .docvalueFields(f -> f.field("@timestamp"))
 *             .docvalueFields(f -> f.field("tags").format("list")))) {   // every value of a multi-valued field
 *         VectorSchemaRoot root = response.getVectorSchemaRoot();
 *         while (response.loadNextBatch()) {
 *             consume(root);
 *         }
 *         SearchResponse<Void> summary = response.summary();
 *     }
 * }
 * }</pre>
 * <p>
 * {@code docvalue_fields} select the columns, in order; a field with format {@code list} becomes a list column. The
 * query, {@code post_filter}, {@code size} (total rows), {@code terminate_after} (rows per shard), {@code timeout},
 * routing, preference and index options apply. Options that need scores, ordering, paging, fetching or aggregations
 * (sort, from, aggregations, _source, highlight, ...) are rejected. Using Arrow memory on Java 17 and later needs
 * {@code --add-opens=java.base/java.nio=org.apache.arrow.memory.core,ALL-UNNAMED}.
 */
public class OpenSearchArrowClient extends ApiClient<GrpcStreamingTransport, OpenSearchArrowClient> {

    private final BufferAllocator allocator;

    /**
     * Creates a client that uses the options of the transport.
     *
     * @param transport the gRPC transport, e.g. a {@code GrpcTransport} or {@code HybridTransport}
     * @param allocator the allocator the batches are read into; each search uses a child allocator of it
     */
    public OpenSearchArrowClient(GrpcStreamingTransport transport, BufferAllocator allocator) {
        this(transport, allocator, null);
    }

    /**
     * Creates a client with its own transport options.
     *
     * @param transport        the gRPC transport, e.g. a {@code GrpcTransport} or {@code HybridTransport}
     * @param allocator        the allocator the batches are read into; each search uses a child allocator of it
     * @param transportOptions the options of every search, or {@code null} for those of the transport
     */
    public OpenSearchArrowClient(GrpcStreamingTransport transport, BufferAllocator allocator, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
        this.allocator = Objects.requireNonNull(allocator, "allocator");
    }

    @Override
    public OpenSearchArrowClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchArrowClient(transport, allocator, transportOptions);
    }

    /**
     * Starts an Arrow search and waits for its schema.
     *
     * @return the results, to read batch by batch and close
     * @throws IOException if the search could not start, e.g. a {@code TransportException} for transport or
     *                     authentication errors
     * @throws org.opensearch.client.opensearch._types.OpenSearchException for errors the server reported, such as an
     *                     unsupported option or a missing index
     * @throws UnsupportedOperationException if the request sets an option the gRPC transport cannot send, or its transport
     *                                       options set one a gRPC call cannot carry, such as query parameters
     */
    public ArrowSearchResponse search(SearchRequest request) throws IOException {
        BufferAllocator callAllocator = allocator.newChildAllocator("opensearch-arrow-search", 0, allocator.getLimit());
        GrpcServerStream<ArrowStreamMessage> stream = null;
        try {
            stream = transport.serverStream(request, new ArrowSearchEndpoint(callAllocator), transportOptions);
            return new ArrowSearchResponse(stream, callAllocator, transport.jsonpMapper());
        } catch (IOException | RuntimeException | Error e) {
            try {
                if (stream != null) {
                    stream.close();
                }
            } finally {
                callAllocator.close();
            }
            throw e;
        }
    }

    /**
     * Starts an Arrow search and waits for its schema.
     *
     * @see #search(SearchRequest)
     */
    public final ArrowSearchResponse search(Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn) throws IOException {
        return search(fn.apply(new SearchRequest.Builder()).build());
    }
}
