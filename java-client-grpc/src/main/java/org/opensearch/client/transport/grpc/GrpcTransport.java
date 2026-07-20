/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.grpc.translation.BulkRequestConverter;
import org.opensearch.client.transport.grpc.translation.BulkResponseConverter;
import org.opensearch.client.transport.grpc.translation.GrpcStatusConverter;
import org.opensearch.protobufs.services.DocumentServiceGrpc;

/**
 * Pure gRPC transport for OpenSearch. Implements {@link OpenSearchTransport} and routes
 * supported operations (Bulk) through gRPC stubs.
 * <p>
 * For unsupported endpoints, this transport throws {@link UnsupportedOperationException}.
 * Use {@link HybridTransport} for automatic REST fallback.
 * <p>
 * Usage:
 * <pre>{@code
 * GrpcTransport transport = GrpcTransport.builder("localhost", 9400)
 *     .jsonpMapper(mapper)
 *     .build();
 *
 * OpenSearchClient client = new OpenSearchClient(transport);
 * client.bulk(bulkRequest); // goes over gRPC
 * }</pre>
 */
public class GrpcTransport implements OpenSearchTransport {

    // ─── Supported Endpoints Registry ────────────────────────────────────────────

    private static final java.util.Set<Endpoint<?, ?, ?>> SUPPORTED_ENDPOINTS;

    static {
        java.util.Set<Endpoint<?, ?, ?>> endpoints = new java.util.HashSet<>();
        endpoints.add(BulkRequest._ENDPOINT);
        // Future: SearchRequest._ENDPOINT, KnnSearchRequest._ENDPOINT
        SUPPORTED_ENDPOINTS = java.util.Collections.unmodifiableSet(endpoints);
    }

    /**
     * Returns true if the given endpoint is supported by gRPC transport.
     */
    public static boolean isEndpointSupported(Endpoint<?, ?, ?> endpoint) {
        return SUPPORTED_ENDPOINTS.contains(endpoint);
    }

    // ─── Instance Fields ─────────────────────────────────────────────────────────

    private final ManagedChannel channel;
    private final DocumentServiceGrpc.DocumentServiceBlockingStub documentStub;
    private final JsonpMapper jsonpMapper;
    private final GrpcTransportOptions grpcOptions;
    private final TransportOptions transportOptions;
    private final GrpcChannelHealthMonitor healthMonitor;

    GrpcTransport(
        ManagedChannel channel,
        JsonpMapper jsonpMapper,
        GrpcTransportOptions grpcOptions,
        @Nullable TransportOptions transportOptions

    ) {
        this.channel = channel;
        this.documentStub = channel != null ? DocumentServiceGrpc.newBlockingStub(channel) : null;
        this.jsonpMapper = jsonpMapper;
        this.grpcOptions = grpcOptions;
        this.transportOptions = transportOptions;
        this.healthMonitor = channel != null ? new GrpcChannelHealthMonitor(channel) : null;

        // Start monitoring channel health and warm up the connection
        if (this.healthMonitor != null) {
            this.healthMonitor.startMonitoring();
            this.healthMonitor.connectIfIdle();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <RequestT, ResponseT, ErrorT> ResponseT performRequest(
        RequestT request,
        Endpoint<RequestT, ResponseT, ErrorT> endpoint,
        @Nullable TransportOptions options
    ) throws IOException {

        if (!GrpcTransport.isEndpointSupported(endpoint)) {
            throw new UnsupportedOperationException(
                "Endpoint not supported by gRPC transport: "
                    + endpoint.requestUrl(request)
                    + ". Use HybridTransport for automatic REST fallback."
            );
        }

        // Route to the appropriate gRPC handler
        if (endpoint == BulkRequest._ENDPOINT) {
            return (ResponseT) performBulk((BulkRequest) request);
        }

        throw new UnsupportedOperationException("Endpoint registered but no handler: " + endpoint.requestUrl(request));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(
        RequestT request,
        Endpoint<RequestT, ResponseT, ErrorT> endpoint,
        @Nullable TransportOptions options
    ) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return performRequest(request, endpoint, options);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public JsonpMapper jsonpMapper() {
        return jsonpMapper;
    }

    @Override
    public TransportOptions options() {
        return transportOptions;
    }

    @Override
    public void close() throws IOException {
        if (channel == null) {
            return;
        }
        if (healthMonitor != null) {
            healthMonitor.stopMonitoring();
        }
        try {
            channel.shutdown();
            if (!channel.awaitTermination(5, TimeUnit.SECONDS)) {
                channel.shutdownNow();
                channel.awaitTermination(5, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            channel.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Returns the underlying ManagedChannel for advanced use cases.
     */
    public ManagedChannel channel() {
        return channel;
    }

    /**
     * Returns the channel health monitor for checking connectivity state.
     * <p>
     * Usage:
     * <pre>{@code
     * if (transport.healthMonitor().isReady()) {
     *     // channel is connected
     * }
     *
     * // Wait for connection (useful at startup)
     * transport.healthMonitor().waitForReady(5, TimeUnit.SECONDS);
     * }</pre>
     */
    public GrpcChannelHealthMonitor healthMonitor() {
        return healthMonitor;
    }

    /**
     * Returns the gRPC transport options.
     */
    public GrpcTransportOptions grpcOptions() {
        return grpcOptions;
    }

    /**
     * Hook for subclasses to pre-process the protobuf request before sending.
     * Override in subclasses like {@link AwsGrpcTransport} for SigV4 payload signing.
     */
    protected void preProcessBulk(org.opensearch.protobufs.BulkRequest protoRequest) {
        // Default: no-op. Subclasses override for auth-specific pre-processing.
    }

    // ─── Internal gRPC Handlers ──────────────────────────────────────────────────

    private BulkResponse performBulk(BulkRequest request) throws TransportException {
        // Convert client request to protobuf
        org.opensearch.protobufs.BulkRequest protoRequest = BulkRequestConverter.toProto(request, jsonpMapper);

        // Hook for subclasses (e.g., AwsGrpcTransport for SigV4 payload signing)
        preProcessBulk(protoRequest);

        // Execute with retry logic
        int attempt = 0;
        long backoffMs = grpcOptions.retryBackoffMs();

        while (true) {
            try {
                org.opensearch.protobufs.BulkResponse protoResponse = documentStub.bulk(protoRequest);
                return BulkResponseConverter.fromProto(protoResponse);
            } catch (StatusRuntimeException e) {
                if (attempt < grpcOptions.maxRetries() && GrpcStatusConverter.isRetryable(e.getStatus().getCode())) {
                    attempt++;
                    try {
                        Thread.sleep(backoffMs);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new TransportException("gRPC request interrupted", ie);
                    }
                    backoffMs *= 2; // exponential backoff
                } else {
                    GrpcStatusConverter.throwConverted(e);
                    // unreachable, but compiler needs it
                    throw new TransportException("gRPC error: " + e.getMessage(), e);
                }
            }
        }
    }

    // ─── Builder ─────────────────────────────────────────────────────────────────

    /**
     * Creates a builder for GrpcTransport.
     *
     * @param host the gRPC server hostname
     * @param port the gRPC server port (default: 9400)
     */
    public static Builder builder(String host, int port) {
        return new Builder(host, port);
    }

    public static final class Builder {
        private final String host;
        private final int port;
        private JsonpMapper jsonpMapper;
        private GrpcTransportOptions grpcOptions = GrpcTransportOptions.defaults();
        private TransportOptions transportOptions;
        private GrpcTlsConfig tlsConfig;
        private String basicAuthUsername;
        private String basicAuthPassword;
        private java.util.function.Supplier<String> jwtTokenSupplier;
        private final java.util.List<io.grpc.ClientInterceptor> interceptors = new java.util.ArrayList<>();
        private ManagedChannel channel; // allow injecting channel for testing

        Builder(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public Builder jsonpMapper(JsonpMapper mapper) {
            this.jsonpMapper = mapper;
            return this;
        }

        public Builder grpcOptions(GrpcTransportOptions options) {
            this.grpcOptions = options;
            return this;
        }

        public Builder transportOptions(TransportOptions options) {
            this.transportOptions = options;
            return this;
        }

        /**
         * Configures TLS for the gRPC channel.
         * <p>
         * Example:
         * <pre>{@code
         * .tls(GrpcTlsConfig.builder()
         *     .trustCertificatePath("/path/to/ca.pem")
         *     .build())
         * }</pre>
         *
         * @param tlsConfig the TLS configuration
         */
        public Builder tls(GrpcTlsConfig tlsConfig) {
            this.tlsConfig = tlsConfig;
            return this;
        }

        /**
         * Enables TLS with insecure trust (trust all certificates).
         * Convenience method for development/testing.
         */
        public Builder tlsInsecure() {
            this.tlsConfig = GrpcTlsConfig.insecure();
            return this;
        }

        /**
         * Configures basic authentication credentials.
         * Adds a {@link BasicAuthInterceptor} that attaches
         * {@code Authorization: Basic <base64>} to every gRPC call.
         *
         * @param username the username
         * @param password the password
         */
        public Builder basicAuth(String username, String password) {
            this.basicAuthUsername = username;
            this.basicAuthPassword = password;
            return this;
        }

        /**
         * Adds a custom client interceptor to the gRPC channel.
         * Interceptors are applied in the order they are added.
         *
         * @param interceptor the gRPC client interceptor
         */
        public Builder addInterceptor(io.grpc.ClientInterceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        /**
        }

        /**
         * Configures JWT Bearer token authentication for the gRPC channel.
         * <p>
         * The token supplier is called on every gRPC request to support
         * automatic token refresh when tokens expire.
         * <p>
         * Example:
         * <pre>{@code
         * // Static token
         * .jwtAuth(() -> "my-jwt-token")
         *
         * // Token from a provider that handles refresh
         * .jwtAuth(() -> myTokenProvider.getAccessToken())
         * }</pre>
         *
         * @param tokenSupplier supplies the JWT token (without "Bearer " prefix)
         * @see <a href="https://docs.opensearch.org/latest/security/authentication-backends/jwt/">OpenSearch JWT</a>
         */
        public Builder jwtAuth(java.util.function.Supplier<String> tokenSupplier) {
            this.jwtTokenSupplier = tokenSupplier;
            return this;
        }

        /**
         * Inject a pre-built channel (primarily for testing).
         * When set, TLS config and interceptors are ignored.
         */
        public Builder channel(ManagedChannel channel) {
            this.channel = channel;
            return this;
        }

        public GrpcTransport build() {
            if (jsonpMapper == null) {
                throw new IllegalArgumentException("jsonpMapper is required");
            }

            ManagedChannel ch = this.channel;
            if (ch == null) {
                // Build interceptor list
                java.util.List<io.grpc.ClientInterceptor> allInterceptors = new java.util.ArrayList<>();

                // Basic auth interceptor goes first (applied to every call)
                if (basicAuthUsername != null && basicAuthPassword != null) {
                    allInterceptors.add(new BasicAuthInterceptor(basicAuthUsername, basicAuthPassword));
                }


                // JWT auth interceptor
                if (jwtTokenSupplier != null) {
                    allInterceptors.add(new JwtAuthInterceptor(jwtTokenSupplier));
                }

                // Add any custom interceptors
                allInterceptors.addAll(this.interceptors);

                // Create channel via factory
                try {
                    ch = GrpcChannelFactory.createChannel(host, port, tlsConfig, grpcOptions, allInterceptors);
                } catch (java.io.IOException e) {
                    throw new IllegalStateException("Failed to create gRPC channel: " + e.getMessage(), e);
                }
            }

            return new GrpcTransport(ch, jsonpMapper, grpcOptions, transportOptions);
        }
    }
}
