/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientStreamTracer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.MetadataUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import org.opensearch.client.transport.endpoints.DelegatingJsonEndpoint;
import org.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import org.opensearch.client.transport.grpc.translation.BulkRequestConverter;
import org.opensearch.client.transport.grpc.translation.BulkResponseConverter;
import org.opensearch.client.transport.grpc.translation.GrpcStatusConverter;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Options;
import org.opensearch.client.transport.httpclient5.HttpAsyncResponseConsumerFactory;
import org.opensearch.client.transport.rest_client.RestClientOptions;
import org.opensearch.protobufs.services.DocumentServiceGrpc;
import org.opensearch.protobufs.services.SearchServiceGrpc;

/**
 * Pure gRPC transport for OpenSearch. Implements {@link OpenSearchTransport} and routes
 * supported operations (Bulk) through gRPC stubs.
 * <p>
 * For unsupported endpoints, this transport throws {@link UnsupportedOperationException}.
 * Use {@link HybridTransport} to route unsupported endpoints to REST automatically.
 * <p>
 * The headers of the request's {@link TransportOptions}, or of this transport's, are sent as call metadata, except those
 * gRPC and HTTP/2 own (such as {@code content-type}, {@code user-agent} and connection-specific headers). An
 * {@code Authorization} header among them replaces the credentials of {@link Builder#basicAuth} or {@link Builder#jwtAuth},
 * as over REST. A request whose options set query parameters, headers that gRPC metadata cannot carry, or settings a gRPC
 * call cannot apply, such as per-request AWS credentials or a warnings handler, is not supported (see {@link #isSupported}).
 * Each call gets the deadline of {@link GrpcTransportOptions#deadlineMs()}.
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
        endpoints.add(SearchRequest._ENDPOINT);
        // Future: KnnSearchRequest._ENDPOINT
        SUPPORTED_ENDPOINTS = java.util.Collections.unmodifiableSet(endpoints);
    }

    /**
     * Returns true if the given endpoint is supported by gRPC transport.
     */
    public static boolean isEndpointSupported(Endpoint<?, ?, ?> endpoint) {
        return SUPPORTED_ENDPOINTS.contains(baseEndpoint(endpoint));
    }

    /**
     * Returns the endpoint behind the wrappers that only set attributes for reading the response, such as the document
     * deserializer that {@code OpenSearchClient.search(request, Class)} attaches to the search endpoint.
     */
    private static Endpoint<?, ?, ?> baseEndpoint(Endpoint<?, ?, ?> endpoint) {
        while (isResponseMapperWrapper(endpoint)) {
            endpoint = ((DelegatingJsonEndpoint<?, ?, ?>) endpoint).unwrap();
        }
        return endpoint;
    }

    /**
     * Whether the endpoint is an {@link EndpointWithResponseMapperAttr}, which changes nothing the request sends. Other
     * {@link DelegatingJsonEndpoint}s, including subclasses of it, may change the URL or the query parameters, which a
     * gRPC call does not send, so they are not looked through and their requests are not supported.
     */
    private static boolean isResponseMapperWrapper(Endpoint<?, ?, ?> endpoint) {
        return endpoint != null && endpoint.getClass() == EndpointWithResponseMapperAttr.class;
    }

    /** Returns the mapper with the attributes the wrappers of an endpoint set for its response, e.g. the hit document type. */
    private JsonpMapper responseMapper(Endpoint<?, ?, ?> endpoint) {
        JsonpMapper mapper = jsonpMapper;
        while (isResponseMapperWrapper(endpoint)) {
            EndpointWithResponseMapperAttr<?, ?, ?> withAttr = (EndpointWithResponseMapperAttr<?, ?, ?>) endpoint;
            mapper = mapper.withAttribute(withAttr.attributeName(), withAttr.attributeValue());
            endpoint = withAttr.unwrap();
        }
        return mapper;
    }

    /**
     * Returns true if the given endpoint and request can be handled by gRPC transport.
     * For endpoints that only partially support gRPC (e.g., search with limited query types),
     * this method inspects the request to determine if gRPC can handle it. It does not read
     * untyped values wrapped from Java objects, such as some range bounds, nor look at the
     * request's options; {@link #isSupported(Endpoint, Object, TransportOptions)} does.
     */
    public static <RequestT> boolean isEndpointSupported(Endpoint<?, ?, ?> endpoint, RequestT request) {
        return isEndpointSupported(endpoint, request, null);
    }

    /**
     * Returns true if gRPC transport can send the request to the endpoint.
     *
     * @param jsonpMapper reads the untyped values of a request, such as range bounds, as its conversion does; with
     *                    {@code null}, values wrapped from Java objects are not checked
     */
    private static <RequestT> boolean isEndpointSupported(Endpoint<?, ?, ?> endpoint, RequestT request, @Nullable JsonpMapper jsonpMapper) {
        endpoint = baseEndpoint(endpoint);
        if (!SUPPORTED_ENDPOINTS.contains(endpoint)) {
            return false;
        }
        // Bulk: all operations supported
        if (endpoint == BulkRequest._ENDPOINT) {
            return true;
        }
        // Search: only requests whose options and queries the converter all maps, so that none is dropped
        if (endpoint == SearchRequest._ENDPOINT && request instanceof SearchRequest) {
            return org.opensearch.client.transport.grpc.translation.SearchRequestConverter.isSupported(
                (SearchRequest) request,
                jsonpMapper
            );
        }
        return true;
    }

    /**
     * Returns true if this transport sends the request with the given options over gRPC without dropping any of them.
     * Unlike {@link #isEndpointSupported(Endpoint, Object)}, this reads the untyped values of the request, such as range
     * bounds, with this transport's mapper, as the conversion does, and rejects options that a gRPC call cannot carry:
     * <ul>
     * <li>query parameters, including the request parameters of {@code RestClientOptions};</li>
     * <li>headers whose name has characters other than ASCII letters, digits, {@code -}, {@code _} and {@code .}, or ends
     * in {@code -bin}, or whose value has characters other than printable ASCII;</li>
     * <li>a warnings handler ({@link TransportOptions#onWarnings()}), as gRPC calls report no warnings;</li>
     * <li>the request config or non-default response consumer factory of {@code ApacheHttpClient5Options} and
     * {@code RestClientOptions};</li>
     * <li>the credentials, signing clock or mapper of {@code AwsSdk2TransportOptions}: a gRPC call is signed with the
     * credentials of the transport's {@link GrpcSigV4Config} and read with its mapper.</li>
     * </ul>
     * {@link HybridTransport} sends the requests this rejects over REST.
     *
     * @param options the options of the request, or {@code null} for this transport's
     */
    public <RequestT> boolean isSupported(Endpoint<?, ?, ?> endpoint, RequestT request, @Nullable TransportOptions options) {
        return unsupportedOptions(options != null ? options : transportOptions) == null
            && isEndpointSupported(endpoint, request, jsonpMapper);
    }

    // ─── Instance Fields ─────────────────────────────────────────────────────────

    private final ManagedChannel channel;
    private final DocumentServiceGrpc.DocumentServiceBlockingStub documentStub;
    private final SearchServiceGrpc.SearchServiceBlockingStub searchStub;
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
        this.searchStub = channel != null ? SearchServiceGrpc.newBlockingStub(channel) : null;
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

        if (!GrpcTransport.isEndpointSupported(endpoint, request)) {
            throw new UnsupportedOperationException(
                "Endpoint not supported by gRPC transport: "
                    + endpoint.requestUrl(request)
                    + ". Use HybridTransport to route unsupported endpoints to REST."
            );
        }
        TransportOptions requestOptions = options != null ? options : transportOptions;
        String unsupported = unsupportedOptions(requestOptions);
        if (unsupported != null) {
            throw new UnsupportedOperationException(unsupported + ". Use HybridTransport to send such requests over REST.");
        }
        Metadata headers = requestHeaders(requestOptions);

        // Route to the appropriate gRPC handler
        Endpoint<?, ?, ?> base = baseEndpoint(endpoint);
        if (base == BulkRequest._ENDPOINT) {
            return (ResponseT) performBulk((BulkRequest) request, headers);
        }
        if (base == SearchRequest._ENDPOINT) {
            return (ResponseT) performSearch((SearchRequest) request, responseMapper(endpoint), headers);
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
        }, ASYNC_CALLS);
    }

    /**
     * Runs each call of {@link #performRequestAsync} on its own virtual thread, which parks while it waits for the server,
     * so that slow calls do not hold the threads of a shared pool such as the common {@code ForkJoinPool}.
     */
    private static final ThreadFactory ASYNC_THREADS = Thread.ofVirtual().name("opensearch-grpc-call-", 0).factory();
    private static final Executor ASYNC_CALLS = task -> ASYNC_THREADS.newThread(task).start();

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
     */
    protected void preProcessBulk(org.opensearch.protobufs.BulkRequest protoRequest) {
        // No-op by default.
    }

    // ─── Internal gRPC Handlers ──────────────────────────────────────────────────

    /**
     * Request metadata that gRPC or HTTP/2 own, which the headers of transport options may not set. They include the
     * connection-specific headers, which apply to a connection, not to a request, and which HTTP/2 forbids (RFC 9113,
     * section 8.2.2).
     */
    static final Set<String> RESERVED_HEADERS = Set.of(
        "content-type",
        "te",
        "user-agent",
        "host",
        "connection",
        "keep-alive",
        "proxy-connection",
        "transfer-encoding",
        "upgrade"
    );

    /**
     * Returns the headers of the options as call metadata, in lower case and without those gRPC or HTTP/2 own.
     */
    static Metadata requestHeaders(@Nullable TransportOptions options) {
        Metadata metadata = new Metadata();
        for (Map.Entry<String, String> header : headers(options)) {
            String name = header.getKey().toLowerCase(Locale.ROOT);
            if (isReserved(name) == false) {
                metadata.put(Metadata.Key.of(name, Metadata.ASCII_STRING_MARSHALLER), header.getValue());
            }
        }
        return metadata;
    }

    private static Collection<Map.Entry<String, String>> headers(@Nullable TransportOptions options) {
        return options != null && options.headers() != null ? options.headers() : Collections.emptyList();
    }

    private static boolean isReserved(String name) {
        return RESERVED_HEADERS.contains(name) || name.startsWith("grpc-") || name.startsWith(":");
    }

    /**
     * Returns why a call cannot carry the options without dropping or changing some of them, or {@code null} if it can.
     */
    @Nullable
    private static String unsupportedOptions(@Nullable TransportOptions options) {
        if (options == null) {
            return null;
        }
        String setting = unsupportedSetting(options);
        if (setting != null) {
            return "The " + setting + " of the transport options cannot be applied over gRPC";
        }
        if (options.queryParameters() != null && options.queryParameters().isEmpty() == false) {
            return "Query parameters " + options.queryParameters().keySet() + " of the transport options cannot be sent over gRPC";
        }
        List<String> unsendable = new ArrayList<>();
        for (Map.Entry<String, String> header : headers(options)) {
            String name = header.getKey() != null ? header.getKey().toLowerCase(Locale.ROOT) : "";
            if (isReserved(name) == false && (isMetadataName(name) == false || isMetadataValue(header.getValue()) == false)) {
                unsendable.add(header.getKey());
            }
        }
        if (unsendable.isEmpty() == false) {
            return "Headers " + unsendable + " of the transport options cannot be sent as gRPC metadata";
        }
        return null;
    }

    /**
     * Returns the first setting of the options, besides headers and query parameters, that the REST transports apply to a
     * request and a gRPC call cannot, or {@code null} if there is none. Compression settings only change how the bytes
     * travel, so they are not among them.
     */
    @Nullable
    private static String unsupportedSetting(TransportOptions options) {
        if (options.onWarnings() != null) {
            return "warnings handler";
        }
        if (options instanceof ApacheHttpClient5Options) {
            ApacheHttpClient5Options http = (ApacheHttpClient5Options) options;
            if (http.getRequestConfig() != null) {
                return "request config";
            }
            if (http.getHttpAsyncResponseConsumerFactory() != HttpAsyncResponseConsumerFactory.DEFAULT) {
                return "response consumer factory";
            }
        }
        // In classes of their own, loaded only for options of their type, as the REST client and the AWS SDK are optional.
        if (options instanceof RestClientOptions) {
            return RestClientSettings.unsupported((RestClientOptions) options);
        }
        if (options instanceof AwsSdk2TransportOptions) {
            return AwsSdk2Settings.unsupported((AwsSdk2TransportOptions) options);
        }
        return null;
    }

    /**
     * Reads the {@code RequestOptions} of opensearch-rest-client 3.0 and later, which is built on HttpClient 5 and has
     * {@code getParameters()}. Like {@code RestClientOptions}, this class does not link with an older client, whose
     * {@code getRequestConfig()} returns an HttpClient 4 type.
     */
    private static final class RestClientSettings {
        @Nullable
        static String unsupported(RestClientOptions options) {
            RequestOptions request = options.restClientRequestOptions();
            if (request.getRequestConfig() != null) {
                return "request config";
            }
            if (request.getParameters().isEmpty() == false) {
                return "request parameters " + request.getParameters().keySet();
            }
            if (request.getHttpAsyncResponseConsumerFactory() != org.opensearch.client.HttpAsyncResponseConsumerFactory.DEFAULT) {
                return "response consumer factory";
            }
            return null;
        }
    }

    private static final class AwsSdk2Settings {
        @Nullable
        static String unsupported(AwsSdk2TransportOptions options) {
            // A gRPC call is signed with the credentials of the transport's GrpcSigV4Config, at the current time.
            if (options.credentials() != null) {
                return "credentials";
            }
            if (options.signingClock() != null) {
                return "signing clock";
            }
            if (options.mapper() != null) {
                return "mapper";
            }
            return null;
        }
    }

    /** Whether a text entry of gRPC metadata may have this name: lower-case letters, digits, '-', '_' and '.', not ending in -bin. */
    private static boolean isMetadataName(String name) {
        if (name.isEmpty() || name.endsWith(Metadata.BINARY_HEADER_SUFFIX)) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if ((c >= 'a' && c <= 'z') == false && (c >= '0' && c <= '9') == false && c != '-' && c != '_' && c != '.') {
                return false;
            }
        }
        return true;
    }

    /** Whether gRPC sends this value of a text entry as it is: printable ASCII; it drops or alters others. */
    private static boolean isMetadataValue(@Nullable String value) {
        if (value == null) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c < ' ' || c > '~') {
                return false;
            }
        }
        return true;
    }

    /** Returns the stub for one call, with the request's headers and, if set, the deadline, which starts now. */
    private <S extends AbstractStub<S>> S forCall(S stub, Metadata headers) {
        if (headers.keys().isEmpty() == false) {
            stub = stub.withInterceptors(MetadataUtils.newAttachHeadersInterceptor(headers));
        }
        if (grpcOptions.deadlineMs() > 0) {
            stub = stub.withDeadlineAfter(grpcOptions.deadlineMs(), TimeUnit.MILLISECONDS);
        }
        return stub;
    }

    private BulkResponse performBulk(BulkRequest request, Metadata headers) throws TransportException {
        // Convert client request to protobuf
        org.opensearch.protobufs.BulkRequest protoRequest = BulkRequestConverter.toProto(request, jsonpMapper);

        // Hook for subclasses
        preProcessBulk(protoRequest);

        // Execute with retry logic
        int attempt = 0;
        long backoffMs = grpcOptions.retryBackoffMs();

        while (true) {
            RequestSent sent = new RequestSent();
            try {
                // Each attempt gets the whole deadline
                org.opensearch.protobufs.BulkResponse protoResponse = forCall(documentStub, headers).withInterceptors(sent)
                    .bulk(protoRequest);
                return BulkResponseConverter.fromProto(protoResponse);
            } catch (StatusRuntimeException e) {
                // A message too large fails again. A bulk may have run if its response was too large, if its deadline
                // expired, which does not stop it on the server, or if it failed with UNAVAILABLE after its request was
                // handed to a connection, as when the connection drops before the response arrives. None is sent again,
                // so that operations such as index requests with generated ids apply once. The REST transport does not
                // resend a timed out bulk either.
                Status status = e.getStatus();
                if (attempt < grpcOptions.maxRetries()
                    && GrpcStatusConverter.isRetryable(status.getCode())
                    && status.getCode() != Status.Code.DEADLINE_EXCEEDED
                    && (status.getCode() != Status.Code.UNAVAILABLE || sent.sent == false)
                    && GrpcStatusConverter.isMessageTooLarge(status) == false) {
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

    /**
     * Records whether a call handed its request message to a connection, after which the server may run the request
     * even if the call fails. A call that failed before, e.g. because no connection could be made, did not reach it.
     */
    private static final class RequestSent extends ClientStreamTracer.Factory implements ClientInterceptor {
        private volatile boolean sent;

        @Override
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method,
            CallOptions callOptions,
            Channel next
        ) {
            return next.newCall(method, callOptions.withStreamTracerFactory(this));
        }

        @Override
        public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo info, Metadata headers) {
            return new ClientStreamTracer() {
                @Override
                public void outboundMessage(int seqNo) {
                    // Called as the message is written to a transport's stream, not for a stream that failed before
                    sent = true;
                }
            };
        }
    }

    @SuppressWarnings("unchecked")
    private <TDocument> SearchResponse<TDocument> performSearch(SearchRequest request, JsonpMapper responseMapper, Metadata headers)
        throws TransportException {
        // Convert client request to protobuf
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.client.transport.grpc.translation.SearchRequestConverter
            .toProto(request, jsonpMapper);

        // Execute gRPC call
        try {
            org.opensearch.protobufs.SearchResponse protoResponse = forCall(searchStub, headers).search(protoRequest);

            // Hit documents use the deserializer that client.search(request, Class) attached, if any, as over REST, and
            // deserialize to Object otherwise.
            return (SearchResponse<TDocument>) org.opensearch.client.transport.grpc.translation.SearchResponseConverter.fromProto(
                protoResponse,
                responseMapper,
                (Class<TDocument>) Object.class
            );
        } catch (StatusRuntimeException e) {
            // Same mapping as bulk: server errors become OpenSearchException with their status, others TransportException.
            GrpcStatusConverter.throwConverted(e);
            throw new TransportException("gRPC search request failed: " + e.getStatus().getDescription(), e);
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
         * {@code Authorization: Basic <base64>} to every gRPC call
         * whose transport options set no {@code Authorization} header.
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
         * Configures JWT Bearer token authentication for the gRPC channel.
         * <p>
         * The token supplier is called on every gRPC request to support
         * automatic token refresh when tokens expire. A request whose
         * transport options set an {@code Authorization} header is sent
         * with that header instead.
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
