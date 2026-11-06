/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.protobuf.ByteString;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.Status;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.core5.util.Timeout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import org.opensearch.client.transport.endpoints.DelegatingJsonEndpoint;
import org.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Options;
import org.opensearch.client.transport.httpclient5.HttpAsyncResponseConsumerFactory;
import org.opensearch.client.transport.rest_client.RestClientOptions;
import org.opensearch.protobufs.HitsMetadata;
import org.opensearch.protobufs.HitsMetadataHitsInner;
import org.opensearch.protobufs.HitsMetadataTotal;
import org.opensearch.protobufs.ShardStatistics;
import org.opensearch.protobufs.TotalHits;
import org.opensearch.protobufs.TotalHitsRelation;
import org.opensearch.protobufs.services.DocumentServiceGrpc;
import org.opensearch.protobufs.services.SearchServiceGrpc;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

/**
 * Searches made through {@link OpenSearchClient} reach the gRPC search service, whose request is the translated one and
 * whose hits come back as the document class the caller asked for.
 */
public class GrpcSearchRoutingTest {

    /** A document of the test index. */
    public static class Product {
        public String name;
        public int stock;
    }

    private static final Metadata.Key<String> PROXY_USER = Metadata.Key.of("x-proxy-user", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> TENANT = Metadata.Key.of("securitytenant", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> USER_AGENT = Metadata.Key.of("user-agent", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> AUTHORIZATION = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);

    private final List<org.opensearch.protobufs.SearchRequest> received = new CopyOnWriteArrayList<>();
    private final List<Metadata> headers = new CopyOnWriteArrayList<>();
    private final AtomicInteger bulkAttempts = new AtomicInteger();
    private volatile Status failWith;
    /** The status the first bulk attempt fails with, if any; later ones succeed. */
    private volatile Status failFirstBulkWith;
    /** Whether the services leave calls unanswered, as a stalled server does. */
    private volatile boolean stall;
    /** The options and thread of each call made on a channel of {@link #channel(ClientInterceptor...)} with {@link #recordCalls}. */
    private final List<CallOptions> calls = new CopyOnWriteArrayList<>();
    private final List<Thread> callThreads = new CopyOnWriteArrayList<>();
    private final ClientInterceptor recordCalls = new ClientInterceptor() {
        @Override
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> method,
            CallOptions callOptions,
            Channel next
        ) {
            calls.add(callOptions);
            callThreads.add(Thread.currentThread());
            return next.newCall(method, callOptions);
        }
    };
    private final List<ManagedChannel> channels = new CopyOnWriteArrayList<>();
    private String name;
    private Server server;
    private ManagedChannel channel;
    private GrpcTransport transport;

    @Before
    public void start() throws IOException {
        name = InProcessServerBuilder.generateName();
        SearchServiceGrpc.SearchServiceImplBase search = new SearchServiceGrpc.SearchServiceImplBase() {
            @Override
            public void search(
                org.opensearch.protobufs.SearchRequest request,
                StreamObserver<org.opensearch.protobufs.SearchResponse> out
            ) {
                received.add(request);
                if (stall) {
                    return;
                }
                if (failWith != null) {
                    out.onError(failWith.asRuntimeException());
                    return;
                }
                HitsMetadataHitsInner hit = HitsMetadataHitsInner.newBuilder()
                    .setXIndex("products")
                    .setXId("7")
                    .setXSource(ByteString.copyFrom("{\"name\":\"lamp\",\"stock\":3}", StandardCharsets.UTF_8))
                    .build();
                out.onNext(
                    org.opensearch.protobufs.SearchResponse.newBuilder()
                        .setTook(4)
                        .setTimedOut(false)
                        .setTerminatedEarly(true)
                        .setXShards(ShardStatistics.newBuilder().setTotal(1).setSuccessful(1).setFailed(0))
                        .setHits(
                            HitsMetadata.newBuilder()
                                .setTotal(
                                    HitsMetadataTotal.newBuilder()
                                        .setTotalHits(
                                            TotalHits.newBuilder().setValue(1).setRelation(TotalHitsRelation.TOTAL_HITS_RELATION_EQ)
                                        )
                                )
                                .addHits(hit)
                        )
                        .build()
                );
                out.onCompleted();
            }
        };
        DocumentServiceGrpc.DocumentServiceImplBase documents = new DocumentServiceGrpc.DocumentServiceImplBase() {
            @Override
            public void bulk(org.opensearch.protobufs.BulkRequest request, StreamObserver<org.opensearch.protobufs.BulkResponse> out) {
                if (bulkAttempts.incrementAndGet() == 1 && failFirstBulkWith != null) {
                    out.onError(failFirstBulkWith.asRuntimeException());
                    return;
                }
                if (stall) {
                    return;
                }
                if (failWith != null) {
                    out.onError(failWith.asRuntimeException());
                    return;
                }
                out.onNext(org.opensearch.protobufs.BulkResponse.newBuilder().setTook(1).setErrors(false).build());
                out.onCompleted();
            }
        };
        ServerInterceptor recordHeaders = new ServerInterceptor() {
            @Override
            public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                ServerCall<ReqT, RespT> call,
                Metadata requestHeaders,
                ServerCallHandler<ReqT, RespT> next
            ) {
                headers.add(requestHeaders);
                return next.startCall(call, requestHeaders);
            }
        };
        server = InProcessServerBuilder.forName(name)
            .directExecutor()
            .addService(ServerInterceptors.intercept(search, recordHeaders))
            .addService(ServerInterceptors.intercept(documents, recordHeaders))
            .build()
            .start();
        channel = InProcessChannelBuilder.forName(name).directExecutor().build();
        transport = new GrpcTransport(channel, new JacksonJsonpMapper(), GrpcTransportOptions.builder().build(), null);
    }

    /** A channel to the test server with the given interceptors, shut down after the test. */
    private ManagedChannel channel(ClientInterceptor... interceptors) {
        ManagedChannel built = InProcessChannelBuilder.forName(name).directExecutor().intercept(interceptors).build();
        channels.add(built);
        return built;
    }

    @After
    public void stop() throws InterruptedException {
        for (ManagedChannel built : channels) {
            built.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        server.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }

    @Test
    public void testClientSearchGoesOverGrpcWithTypedHits() throws IOException {
        SearchResponse<Product> response = new OpenSearchClient(transport).search(
            s -> s.index("products").size(5).query(q -> q.term(t -> t.field("category").value(FieldValue.of("lighting")))),
            Product.class
        );
        assertEquals(1, received.size());
        org.opensearch.protobufs.SearchRequest sent = received.get(0);
        assertEquals(List.of("products"), sent.getIndexList());
        assertEquals("category", sent.getSearchRequestBody().getQuery().getTerm().getField());
        assertEquals("lighting", sent.getSearchRequestBody().getQuery().getTerm().getValue().getString());
        assertEquals(5, sent.getSearchRequestBody().getSize());

        assertEquals(4, response.took());
        assertTrue(response.terminatedEarly());
        assertEquals(1, response.hits().total().value());
        Product product = response.hits().hits().get(0).source();
        assertEquals("lamp", product.name);
        assertEquals(3, product.stock);
    }

    @Test
    public void testHitsDeserializeToJsonData() throws IOException {
        // JsonData has its own deserializer, which reads the document from the next event, as for a REST hit
        SearchResponse<JsonData> response = new OpenSearchClient(transport).search(
            s -> s.index("products").query(q -> q.term(t -> t.field("category").value(FieldValue.of("lighting")))),
            JsonData.class
        );
        JsonObject source = response.hits().hits().get(0).source().toJson().asJsonObject();
        assertEquals("lamp", source.getString("name"));
        assertEquals(3, source.getInt("stock"));
    }

    @Test
    public void testWrappedSearchEndpointIsRecognized() {
        SearchRequest request = new SearchRequest.Builder().index("products").build();
        EndpointWithResponseMapperAttr<?, ?, ?> wrapped = new EndpointWithResponseMapperAttr<>(SearchRequest._ENDPOINT, "attr", "value");
        assertTrue(GrpcTransport.isEndpointSupported(wrapped));
        assertTrue(GrpcTransport.isEndpointSupported(wrapped, request));
        SearchRequest sorted = new SearchRequest.Builder().index("products").sort(s -> s.field(f -> f.field("price"))).build();
        assertFalse(GrpcTransport.isEndpointSupported(wrapped, sorted));
    }

    @Test
    public void testSearchErrorsMapLikeBulkErrors() throws IOException {
        failWith = Status.INVALID_ARGUMENT.withDescription("[size] must be positive");
        try {
            new OpenSearchClient(transport).search(s -> s.index("products"), Product.class);
            fail("expected OpenSearchException");
        } catch (OpenSearchException e) {
            assertEquals(400, e.status());
            assertTrue(e.getMessage(), e.getMessage().contains("[size] must be positive"));
        }
    }

    @Test
    public void testRequestHeadersAreSentOnSearchAndBulk() throws IOException {
        OpenSearchClient client = new OpenSearchClient(transport).withTransportOptions(
            TransportOptions.builder()
                .addHeader("X-Proxy-User", "alice")
                .addHeader("securitytenant", "reports")
                .addHeader("User-Agent", "not-sent")
                .build()
        );
        client.search(s -> s.index("products"), Product.class);
        client.bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
        assertEquals(2, headers.size());
        for (Metadata call : headers) {
            assertEquals("alice", call.get(PROXY_USER));
            assertEquals("reports", call.get(TENANT));
            // gRPC owns the user agent
            assertNotEquals("not-sent", call.get(USER_AGENT));
        }
    }

    @Test
    public void testTransportHeadersAreSentWhenTheRequestHasNone() throws IOException {
        GrpcTransport withHeaders = new GrpcTransport(
            channel,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().build(),
            TransportOptions.builder().addHeader("x-proxy-user", "service").build()
        );
        new OpenSearchClient(withHeaders).search(s -> s.index("products"), Product.class);
        assertEquals("service", headers.get(0).get(PROXY_USER));
    }

    @Test
    public void testQueryParametersGrpcCannotSendGoOverRest() throws IOException {
        TransportOptions withParameter = TransportOptions.builder().setParameter("filter_path", "hits.hits._id").build();
        GrpcTransportTest.MockRestTransport rest = new GrpcTransportTest.MockRestTransport();
        new OpenSearchClient(new HybridTransport(transport, rest)).withTransportOptions(withParameter)
            .search(s -> s.index("products"), Product.class);
        assertEquals(1, rest.callCount);
        assertEquals(0, received.size());
        try {
            new OpenSearchClient(transport).withTransportOptions(withParameter).search(s -> s.index("products"), Product.class);
            fail("expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("filter_path"));
        }
        assertEquals(0, received.size());
    }

    @Test
    public void testRangeBoundsGrpcCannotSendGoOverRest() throws IOException {
        GrpcTransportTest.MockRestTransport rest = new GrpcTransportTest.MockRestTransport();
        OpenSearchClient client = new OpenSearchClient(new HybridTransport(transport, rest));
        // The conversion rejects a null bound, which REST takes as an open one, and a boolean bound, which only the
        // transport's mapper reads
        client.search(
            s -> s.index("products").query(q -> q.range(r -> r.field("stock").gte(JsonData.of(JsonValue.NULL)).lt(JsonData.of(10)))),
            Product.class
        );
        client.search(s -> s.index("products").query(q -> q.range(r -> r.field("stock").gte(JsonData.of(true)))), Product.class);
        assertEquals(2, rest.callCount);
        assertEquals(0, received.size());
    }

    @Test(timeout = 10_000)
    public void testDeadlineEndsStalledCalls() throws IOException {
        stall = true;
        GrpcTransport withDeadline = new GrpcTransport(
            channel,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder()
                .deadline(100, TimeUnit.MILLISECONDS)
                .maxRetries(1)
                .retryBackoff(1, TimeUnit.MILLISECONDS)
                .build(),
            null
        );
        OpenSearchClient client = new OpenSearchClient(withDeadline);
        try {
            client.search(s -> s.index("products"), Product.class);
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("timed out"));
        }
        try {
            client.bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("timed out"));
        }
        assertEquals("a bulk whose deadline expired may have run, so it is not sent again", 1, bulkAttempts.get());
    }

    @Test
    public void testCallsHaveADeadlineByDefault() throws IOException {
        failFirstBulkWith = Status.RESOURCE_EXHAUSTED.withDescription("too many requests");
        GrpcTransport defaults = new GrpcTransport(
            channel(recordCalls),
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().retryBackoff(1, TimeUnit.MILLISECONDS).build(),
            null
        );
        OpenSearchClient client = new OpenSearchClient(defaults);
        client.search(s -> s.index("products"), Product.class);
        client.bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
        assertEquals("the throttled bulk was sent again", 2, bulkAttempts.get());
        assertEquals(3, calls.size());
        for (CallOptions call : calls) {
            assertNotNull(call.getDeadline());
            assertTrue(call.getDeadline().timeRemaining(TimeUnit.MILLISECONDS) <= 30_000);
        }
        assertTrue("each bulk attempt gets the deadline from its start", calls.get(1).getDeadline().isBefore(calls.get(2).getDeadline()));

        calls.clear();
        GrpcTransport noDeadline = new GrpcTransport(
            channel(recordCalls),
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().deadline(0, TimeUnit.MILLISECONDS).build(),
            null
        );
        new OpenSearchClient(noDeadline).search(s -> s.index("products"), Product.class);
        assertNull(calls.get(0).getDeadline());
    }

    @Test
    public void testAsyncCallsRunOnVirtualThreads() throws Exception {
        GrpcTransport recorded = new GrpcTransport(channel(recordCalls), new JacksonJsonpMapper(), GrpcTransportOptions.defaults(), null);
        OpenSearchAsyncClient client = new OpenSearchAsyncClient(recorded);
        client.search(s -> s.index("products"), Product.class).get(10, TimeUnit.SECONDS);
        client.bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7")))).get(10, TimeUnit.SECONDS);
        assertEquals(2, callThreads.size());
        for (Thread thread : callThreads) {
            // Not a thread of the common pool, which a call waiting for the server would hold
            assertTrue(thread.getName(), thread.isVirtual());
        }
    }

    @Test
    public void testRequestAuthorizationReplacesChannelCredentials() throws IOException {
        BasicAuthInterceptor basic = new BasicAuthInterceptor("service", "secret");
        assertRequestAuthorizationReplaces(basic, basic.getAuthHeaderValue());
        assertRequestAuthorizationReplaces(new JwtAuthInterceptor(() -> "service-token"), "Bearer service-token");
    }

    private void assertRequestAuthorizationReplaces(ClientInterceptor channelAuth, String channelCredentials) throws IOException {
        headers.clear();
        OpenSearchClient client = new OpenSearchClient(
            new GrpcTransport(channel(channelAuth), new JacksonJsonpMapper(), GrpcTransportOptions.defaults(), null)
        );
        OpenSearchClient alice = client.withTransportOptions(
            TransportOptions.builder().addHeader("Authorization", "Bearer alice-token").build()
        );
        alice.search(s -> s.index("products"), Product.class);
        alice.bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
        client.search(s -> s.index("products"), Product.class);
        assertEquals(3, headers.size());
        // As over REST, the request's credentials are sent alone, in place of the channel's
        assertEquals(List.of("Bearer alice-token"), values(headers.get(0), AUTHORIZATION));
        assertEquals(List.of("Bearer alice-token"), values(headers.get(1), AUTHORIZATION));
        assertEquals(List.of(channelCredentials), values(headers.get(2), AUTHORIZATION));
    }

    private static List<String> values(Metadata metadata, Metadata.Key<String> key) {
        List<String> values = new ArrayList<>();
        Iterable<String> all = metadata.getAll(key);
        if (all != null) {
            all.forEach(values::add);
        }
        return values;
    }

    @Test
    public void testHeadersGrpcMetadataCannotCarryGoOverRest() throws IOException {
        GrpcTransportTest.MockRestTransport rest = new GrpcTransportTest.MockRestTransport();
        OpenSearchClient hybrid = new OpenSearchClient(new HybridTransport(transport, rest));
        // A binary metadata name, a name with a character metadata names cannot have, a value that is not printable ASCII
        Map<String, String> unsendable = Map.of("X-Trace-Bin", "AAEC", "X-Tenant!", "reports", "X-Proxy-User", "andr\u00e9\tadmin");
        for (Map.Entry<String, String> header : unsendable.entrySet()) {
            TransportOptions options = TransportOptions.builder().addHeader(header.getKey(), header.getValue()).build();
            hybrid.withTransportOptions(options).search(s -> s.index("products"), Product.class);
            hybrid.withTransportOptions(options).bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
            try {
                new OpenSearchClient(transport).withTransportOptions(options).search(s -> s.index("products"), Product.class);
                fail("expected UnsupportedOperationException");
            } catch (UnsupportedOperationException e) {
                assertTrue(e.getMessage(), e.getMessage().contains(header.getKey()));
                // Values, such as credentials, are not shown
                assertFalse(e.getMessage(), e.getMessage().contains(header.getValue()));
            }
        }
        assertEquals(6, rest.callCount);
        assertEquals(0, received.size());
        assertEquals(0, bulkAttempts.get());
    }

    @Test
    public void testConnectionSpecificHeadersAreNotSent() throws IOException {
        new OpenSearchClient(transport).withTransportOptions(
            TransportOptions.builder()
                .addHeader("Keep-Alive", "timeout=5")
                .addHeader("Proxy-Connection", "keep-alive")
                .addHeader("Transfer-Encoding", "chunked")
                .addHeader("Upgrade", "h2c")
                .addHeader("X-Proxy-User", "alice")
                .build()
        ).search(s -> s.index("products"), Product.class);
        Metadata sent = headers.get(0);
        // HTTP/2 forbids them; they apply to a connection, not to a request
        for (String header : List.of("keep-alive", "proxy-connection", "transfer-encoding", "upgrade")) {
            assertFalse(header, sent.containsKey(Metadata.Key.of(header, Metadata.ASCII_STRING_MARSHALLER)));
        }
        assertEquals("alice", sent.get(PROXY_USER));
    }

    @Test
    public void testMessageTooLargeIsNotReportedAsThrottlingNorRetried() throws IOException {
        failWith = Status.RESOURCE_EXHAUSTED.withDescription("gRPC message exceeds maximum size 10485760: 16777216");
        OpenSearchClient client = new OpenSearchClient(transport);
        try {
            client.search(s -> s.index("products"), Product.class);
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("maxInboundMessageSize"));
            assertFalse(e.getMessage(), e.getMessage().contains("429"));
        }
        try {
            client.bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("maxInboundMessageSize"));
        }
        assertEquals("the bulk ran, so it is not sent again", 1, bulkAttempts.get());

        failWith = Status.RESOURCE_EXHAUSTED.withDescription("too many requests");
        try {
            client.search(s -> s.index("products"), Product.class);
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("Rate limited (429)"));
        }
    }

    @Test
    public void testBulkIsNotSentAgainWhenItsConnectionFailedAfterItWasSent() throws IOException {
        // As gRPC fails the calls of a connection that dropped: the server may have run the bulk
        failWith = Status.UNAVAILABLE.withDescription("Network closed for unknown reason");
        GrpcTransport retrying = new GrpcTransport(
            channel,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().retryBackoff(1, TimeUnit.MILLISECONDS).build(),
            null
        );
        try {
            new OpenSearchClient(retrying).bulk(b -> b.operations(op -> op.index(i -> i.index("products").document(new Product()))));
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("Network closed"));
        }
        assertEquals("a bulk that may have run is not sent again", 1, bulkAttempts.get());
    }

    @Test
    public void testBulkIsSentAgainWhenUnavailableBeforeItWasSent() throws IOException {
        // No server listens on this name, so every call fails before its request reaches a connection
        ManagedChannel unconnected = InProcessChannelBuilder.forName(name + "-missing").directExecutor().intercept(recordCalls).build();
        channels.add(unconnected);
        GrpcTransport retrying = new GrpcTransport(
            unconnected,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().maxRetries(2).retryBackoff(1, TimeUnit.MILLISECONDS).build(),
            null
        );
        try {
            new OpenSearchClient(retrying).bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().toLowerCase(java.util.Locale.ROOT).contains("unavailable"));
        }
        assertEquals("the first attempt and both retries", 3, calls.size());
    }

    @Test
    public void testOptionsGrpcCannotApplyGoOverRest() throws IOException {
        RequestConfig longTimeout = RequestConfig.custom().setResponseTimeout(Timeout.ofMinutes(2)).build();
        ApacheHttpClient5Options.Builder smallBuffer = ApacheHttpClient5Options.DEFAULT.toBuilder();
        smallBuffer.setHttpAsyncResponseConsumerFactory(new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(1024));
        // Each with the setting the message names
        List<Map.Entry<String, TransportOptions>> unsupported = List.of(
            Map.entry("warnings handler", TransportOptions.builder().onWarnings(warnings -> true).build()),
            Map.entry(
                "credentials",
                AwsSdk2TransportOptions.builder()
                    .setCredentials(StaticCredentialsProvider.create(AwsBasicCredentials.create("tenant", "secret")))
                    .build()
            ),
            Map.entry("signing clock", AwsSdk2TransportOptions.builder().setSigningClock(Clock.systemUTC()).build()),
            Map.entry("mapper", AwsSdk2TransportOptions.builder().setMapper(new JacksonJsonpMapper()).build()),
            Map.entry("request config", ApacheHttpClient5Options.DEFAULT.toBuilder().setRequestConfig(longTimeout).build()),
            Map.entry("response consumer factory", smallBuffer.build()),
            Map.entry("request config", new RestClientOptions(RequestOptions.DEFAULT.toBuilder().setRequestConfig(longTimeout).build())),
            Map.entry(
                "request parameters [filter_path]",
                new RestClientOptions(RequestOptions.DEFAULT.toBuilder().addParameter("filter_path", "hits.hits._id").build())
            )
        );
        GrpcTransportTest.MockRestTransport rest = new GrpcTransportTest.MockRestTransport();
        OpenSearchClient hybrid = new OpenSearchClient(new HybridTransport(transport, rest));
        for (Map.Entry<String, TransportOptions> options : unsupported) {
            hybrid.withTransportOptions(options.getValue()).search(s -> s.index("products"), Product.class);
            hybrid.withTransportOptions(options.getValue()).bulk(b -> b.operations(op -> op.delete(d -> d.index("products").id("7"))));
            try {
                new OpenSearchClient(transport).withTransportOptions(options.getValue()).search(s -> s.index("products"), Product.class);
                fail("expected UnsupportedOperationException for the " + options.getKey());
            } catch (UnsupportedOperationException e) {
                assertTrue(e.getMessage(), e.getMessage().contains("The " + options.getKey() + " of the transport options"));
            }
        }
        assertEquals(2 * unsupported.size(), rest.callCount);
        assertEquals(0, received.size());
        assertEquals(0, bulkAttempts.get());
    }

    @Test
    public void testOptionsThatOnlyCarryHeadersGoOverGrpc() throws IOException {
        List<TransportOptions> supported = List.of(
            // Compression only changes how the bytes travel
            AwsSdk2TransportOptions.builder()
                .setResponseCompression(false)
                .setRequestCompressionSize(100)
                .addHeader("X-Proxy-User", "alice")
                .build(),
            ApacheHttpClient5Options.DEFAULT.toBuilder().addHeader("X-Proxy-User", "alice").build(),
            new RestClientOptions(RequestOptions.DEFAULT.toBuilder().addHeader("X-Proxy-User", "alice").build())
        );
        GrpcTransportTest.MockRestTransport rest = new GrpcTransportTest.MockRestTransport();
        OpenSearchClient hybrid = new OpenSearchClient(new HybridTransport(transport, rest));
        for (TransportOptions options : supported) {
            hybrid.withTransportOptions(options).search(s -> s.index("products"), Product.class);
        }
        assertEquals(0, rest.callCount);
        assertEquals(supported.size(), received.size());
        for (Metadata call : headers) {
            assertEquals("alice", call.get(PROXY_USER));
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testEndpointWrappersThatMayChangeTheRequestGoOverRest() throws IOException {
        JsonEndpoint<SearchRequest, SearchResponse<Object>, ErrorResponse> search = (JsonEndpoint<
            SearchRequest,
            SearchResponse<Object>,
            ErrorResponse>) SearchRequest._ENDPOINT;
        // Over REST these search a filtered alias, or add routing; gRPC would send neither
        DelegatingJsonEndpoint<SearchRequest, SearchResponse<Object>, ErrorResponse> aliased = new DelegatingJsonEndpoint<>(search) {
            @Override
            public String requestUrl(SearchRequest request) {
                return "/tenant-42-alias/_search";
            }
        };
        EndpointWithResponseMapperAttr<SearchRequest, SearchResponse<Object>, ErrorResponse> routed = new EndpointWithResponseMapperAttr<>(
            search,
            "attr",
            "value"
        ) {
            @Override
            public Map<String, String> queryParameters(SearchRequest request) {
                return Map.of("routing", "tenant-42");
            }
        };
        SearchRequest request = new SearchRequest.Builder().index("docs-*").build();
        GrpcTransportTest.MockRestTransport rest = new GrpcTransportTest.MockRestTransport();
        HybridTransport hybrid = new HybridTransport(transport, rest);
        for (JsonEndpoint<SearchRequest, SearchResponse<Object>, ErrorResponse> wrapper : List.of(aliased, routed)) {
            assertFalse(GrpcTransport.isEndpointSupported(wrapper));
            assertFalse(transport.isSupported(wrapper, request, null));
            // Nor inside the one wrapper that changes nothing the request sends
            assertFalse(GrpcTransport.isEndpointSupported(new EndpointWithResponseMapperAttr<>(wrapper, "attr", "value")));
            hybrid.performRequest(request, wrapper, null);
        }
        assertEquals(2, rest.callCount);
        assertEquals(0, received.size());
    }
}
