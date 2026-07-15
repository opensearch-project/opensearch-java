/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;

/**
 * Hybrid transport that composes a {@link GrpcTransport} with a REST transport.
 * <p>
 * Routes supported endpoints (Bulk) to gRPC for better performance,
 * and all other operations to the REST transport automatically.
 * <p>
 * If a gRPC request fails due to connection issues or unsupported payload,
 * the request is retried via REST (fallback behavior).
 * <p>
 * This is the recommended transport for production use:
 * <pre>{@code
 * OpenSearchTransport restTransport = ApacheHttpClient5TransportBuilder.builder(host).build();
 * GrpcTransport grpcTransport = GrpcTransport.builder("localhost", 9400)
 *     .jsonpMapper(mapper).build();
 *
 * HybridTransport hybrid = new HybridTransport(grpcTransport, restTransport);
 * OpenSearchClient client = new OpenSearchClient(hybrid);
 *
 * client.bulk(bulkRequest);  // → gRPC
 * client.search(searchReq);  // → REST
 * }</pre>
 */
public class HybridTransport implements OpenSearchTransport {

    private static final Logger logger = Logger.getLogger(HybridTransport.class.getName());

    private final GrpcTransport grpcTransport;
    private final OpenSearchTransport restTransport;
    private final boolean fallbackOnError;

    /**
     * Creates a HybridTransport with default fallback behavior (fallback on error = true).
     *
     * @param grpcTransport the gRPC transport for supported endpoints
     * @param restTransport the REST transport for all other endpoints and fallback
     */
    public HybridTransport(GrpcTransport grpcTransport, OpenSearchTransport restTransport) {
        this(grpcTransport, restTransport, true);
    }

    /**
     * Creates a HybridTransport.
     *
     * @param grpcTransport   the gRPC transport for supported endpoints
     * @param restTransport   the REST transport for all other endpoints and fallback
     * @param fallbackOnError if true, retries failed gRPC requests via REST
     */
    public HybridTransport(GrpcTransport grpcTransport, OpenSearchTransport restTransport, boolean fallbackOnError) {
        this.grpcTransport = grpcTransport;
        this.restTransport = restTransport;
        this.fallbackOnError = fallbackOnError;
    }

    @Override
    public <RequestT, ResponseT, ErrorT> ResponseT performRequest(
        RequestT request,
        Endpoint<RequestT, ResponseT, ErrorT> endpoint,
        @Nullable TransportOptions options
    ) throws IOException {

        // Route unsupported endpoints directly to REST
        if (!GrpcTransport.isEndpointSupported(endpoint)) {
            return restTransport.performRequest(request, endpoint, options);
        }

        // Try gRPC for supported endpoints
        try {
            return grpcTransport.performRequest(request, endpoint, options);
        } catch (UnsupportedOperationException e) {
            // Endpoint registered but payload not convertible — fallback to REST
            if (fallbackOnError) {
                logger.log(Level.FINE, "gRPC conversion failed, falling back to REST: {0}", e.getMessage());
                return restTransport.performRequest(request, endpoint, options);
            }
            throw e;
        } catch (TransportException e) {
            // Connection error — fallback to REST if enabled
            if (fallbackOnError) {
                logger.log(Level.WARNING, "gRPC request failed, falling back to REST: {0}", e.getMessage());
                return restTransport.performRequest(request, endpoint, options);
            }
            throw e;
        }
    }

    @Override
    public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(
        RequestT request,
        Endpoint<RequestT, ResponseT, ErrorT> endpoint,
        @Nullable TransportOptions options
    ) {
        // Route unsupported endpoints directly to REST
        if (!GrpcTransport.isEndpointSupported(endpoint)) {
            return restTransport.performRequestAsync(request, endpoint, options);
        }

        // Try gRPC, fallback to REST on failure
        CompletableFuture<ResponseT> future = grpcTransport.performRequestAsync(request, endpoint, options);

        if (fallbackOnError) {
            return future.exceptionally(throwable -> {
                logger.log(Level.WARNING, "Async gRPC failed, falling back to REST: {0}", throwable.getMessage());
                try {
                    return restTransport.performRequest(request, endpoint, options);
                } catch (IOException e) {
                    throw new RuntimeException("REST fallback also failed", e);
                }
            });
        }

        return future;
    }

    @Override
    public JsonpMapper jsonpMapper() {
        // Use the REST transport's mapper as the primary
        return restTransport.jsonpMapper();
    }

    @Override
    public TransportOptions options() {
        return restTransport.options();
    }

    @Override
    public void close() throws IOException {
        try {
            grpcTransport.close();
        } finally {
            restTransport.close();
        }
    }

    /**
     * Returns the underlying gRPC transport.
     */
    public GrpcTransport grpcTransport() {
        return grpcTransport;
    }

    /**
     * Returns the underlying REST transport.
     */
    public OpenSearchTransport restTransport() {
        return restTransport;
    }

    /**
     * Returns whether fallback on gRPC error is enabled.
     */
    public boolean fallbackOnError() {
        return fallbackOnError;
    }
}
