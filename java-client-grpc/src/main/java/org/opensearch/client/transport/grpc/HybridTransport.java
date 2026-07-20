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
 * Hybrid transport that routes supported endpoints to gRPC and all other
 * operations to REST.
 * <p>
 * Supported endpoints (e.g., Bulk) are sent over gRPC for better performance.
 * Unsupported endpoints are sent over REST automatically.
 * <p>
 * gRPC errors are propagated directly to the caller — there is no silent
 * fallback to REST for supported endpoints. This ensures users know
 * immediately when their gRPC configuration is not working.
 */
public class HybridTransport implements OpenSearchTransport {

    private static final Logger logger = Logger.getLogger(HybridTransport.class.getName());

    private final GrpcTransport grpcTransport;
    private final OpenSearchTransport restTransport;

    /**
     * Creates a HybridTransport that routes supported endpoints to gRPC
     * and all other endpoints to REST.
     * <p>
     * gRPC errors are propagated directly to the caller — there is no silent
     * fallback to REST for gRPC-supported endpoints. This ensures users are
     * aware when their gRPC configuration is not working.
     *
     * @param grpcTransport the gRPC transport for supported endpoints
     * @param restTransport the REST transport for all other endpoints
     */
    public HybridTransport(GrpcTransport grpcTransport, OpenSearchTransport restTransport) {
        this.grpcTransport = grpcTransport;
        this.restTransport = restTransport;
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

        // gRPC-supported endpoints go over gRPC — errors propagate to caller
        return grpcTransport.performRequest(request, endpoint, options);
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

        // gRPC-supported endpoints go over gRPC — errors propagate to caller
        return grpcTransport.performRequestAsync(request, endpoint, options);
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

}
