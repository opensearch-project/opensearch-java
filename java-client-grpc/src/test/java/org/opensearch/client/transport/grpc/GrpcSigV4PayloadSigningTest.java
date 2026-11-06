/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.protobufs.services.DocumentServiceGrpc;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;

/**
 * Checks that {@link GrpcSigV4Interceptor} signs what it actually sends, on a real (in-process) gRPC server that records
 * the headers and bytes of every call.
 */
public class GrpcSigV4PayloadSigningTest {

    private static final String EMPTY_BODY_HASH = GrpcSigV4Interceptor.computePayloadHash(new byte[0]);
    private static final Metadata.Key<String> CONTENT_SHA256 = Metadata.Key.of("x-amz-content-sha256", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> AUTHORIZATION = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);

    private static final MethodDescriptor.Marshaller<String> UTF8 = new MethodDescriptor.Marshaller<String>() {
        @Override
        public InputStream stream(String value) {
            return new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        public String parse(InputStream stream) {
            try {
                return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    private static final MethodDescriptor<String, String> UNARY = method("test.Echo/Unary", MethodDescriptor.MethodType.UNARY);
    private static final MethodDescriptor<String, String> SERVER_STREAMING = method(
        "test.Echo/ServerStream",
        MethodDescriptor.MethodType.SERVER_STREAMING
    );
    private static final MethodDescriptor<String, String> CLIENT_STREAMING = method(
        "test.Echo/ClientStream",
        MethodDescriptor.MethodType.CLIENT_STREAMING
    );

    /** What the server saw for one call: its headers and the request it received. */
    private static final class Received {
        final Metadata headers;
        final List<String> messages = new CopyOnWriteArrayList<>();

        Received(Metadata headers) {
            this.headers = headers;
        }
    }

    private static final Context.Key<Received> RECEIVED = Context.key("received");

    private final List<Received> calls = new CopyOnWriteArrayList<>();
    private final AtomicInteger bulkAttempts = new AtomicInteger();
    private String serverName;
    private Server server;
    private ManagedChannel channel;

    private static MethodDescriptor<String, String> method(String name, MethodDescriptor.MethodType type) {
        return MethodDescriptor.<String, String>newBuilder()
            .setFullMethodName(name)
            .setType(type)
            .setRequestMarshaller(UTF8)
            .setResponseMarshaller(UTF8)
            .build();
    }

    @Before
    public void startServer() throws IOException {
        serverName = InProcessServerBuilder.generateName();
        // Records each call's headers, and hands the record to the call's handler through its context.
        ServerInterceptor recorder = new ServerInterceptor() {
            @Override
            public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                ServerCall<ReqT, RespT> call,
                Metadata headers,
                ServerCallHandler<ReqT, RespT> next
            ) {
                Received received = new Received(headers);
                calls.add(received);
                return Contexts.interceptCall(Context.current().withValue(RECEIVED, received), call, headers, next);
            }
        };
        DocumentServiceGrpc.DocumentServiceImplBase documents = new DocumentServiceGrpc.DocumentServiceImplBase() {
            @Override
            public void bulk(org.opensearch.protobufs.BulkRequest request, StreamObserver<org.opensearch.protobufs.BulkResponse> out) {
                record(GrpcSigV4Interceptor.computePayloadHash(request.toByteArray()));
                if (bulkAttempts.incrementAndGet() == 1) {
                    // Throttled, so it ran none of its operations and is sent again
                    out.onError(Status.RESOURCE_EXHAUSTED.withDescription("too many requests").asRuntimeException());
                    return;
                }
                out.onNext(org.opensearch.protobufs.BulkResponse.newBuilder().setTook(1).setErrors(false).build());
                out.onCompleted();
            }
        };
        ServerServiceDefinition service = ServerServiceDefinition.builder("test.Echo")
            .addMethod(UNARY, ServerCalls.asyncUnaryCall((String request, StreamObserver<String> out) -> {
                record(request);
                out.onNext("echo:" + request);
                out.onCompleted();
            }))
            .addMethod(SERVER_STREAMING, ServerCalls.asyncServerStreamingCall((String request, StreamObserver<String> out) -> {
                record(request);
                for (int i = 0; i < 3; i++) {
                    out.onNext(request + i);
                }
                out.onCompleted();
            }))
            .addMethod(CLIENT_STREAMING, ServerCalls.asyncClientStreamingCall((StreamObserver<String> out) -> new StreamObserver<String>() {
                @Override
                public void onNext(String value) {
                    record(value);
                }

                @Override
                public void onError(Throwable t) {}

                @Override
                public void onCompleted() {
                    out.onNext("done");
                    out.onCompleted();
                }
            }))
            .build();
        server = InProcessServerBuilder.forName(serverName)
            .directExecutor()
            .addService(ServerInterceptors.intercept(service, recorder))
            .addService(ServerInterceptors.intercept(documents, recorder))
            .build()
            .start();
        channel = InProcessChannelBuilder.forName(serverName).directExecutor().intercept(interceptor()).build();
    }

    private static void record(String message) {
        RECEIVED.get().messages.add(message);
    }

    @After
    public void stopServer() throws InterruptedException {
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        server.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }

    private static GrpcSigV4Interceptor interceptor() {
        return new GrpcSigV4Interceptor(
            GrpcSigV4Config.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("AKIDEXAMPLE", "secret")))
                .build(),
            "search-domain.us-east-1.es.amazonaws.com"
        );
    }

    private static String hash(String message) {
        return GrpcSigV4Interceptor.computePayloadHash(message.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void testUnaryCallIsSignedWithTheHashOfTheBytesItSends() {
        String response = ClientCalls.blockingUnaryCall(channel, UNARY, CallOptions.DEFAULT, "hello");
        assertEquals("echo:hello", response);
        assertEquals(1, calls.size());
        Received received = calls.get(0);
        assertEquals(List.of("hello"), received.messages);
        assertEquals(hash("hello"), received.headers.get(CONTENT_SHA256));
        assertNotEquals(EMPTY_BODY_HASH, received.headers.get(CONTENT_SHA256));
        String authorization = received.headers.get(AUTHORIZATION);
        assertNotNull(authorization);
        assertTrue(authorization, authorization.startsWith("AWS4-HMAC-SHA256 "));
        assertTrue(authorization, authorization.contains("x-amz-content-sha256"));
        int signatures = 0;
        for (String ignored : received.headers.getAll(AUTHORIZATION)) {
            signatures++;
        }
        assertEquals("one signature per call", 1, signatures);
    }

    @Test
    public void testServerStreamingCallIsSignedWithTheHashOfItsRequest() {
        Iterator<String> responses = ClientCalls.blockingServerStreamingCall(channel, SERVER_STREAMING, CallOptions.DEFAULT, "batch");
        List<String> all = new ArrayList<>();
        responses.forEachRemaining(all::add);
        assertEquals(List.of("batch0", "batch1", "batch2"), all);
        assertEquals(hash("batch"), calls.get(0).headers.get(CONTENT_SHA256));
    }

    @Test
    public void testRequestsMadeBeforeTheMessageAreReplayed() throws InterruptedException {
        ClientCall<String, String> call = channel.newCall(SERVER_STREAMING, CallOptions.DEFAULT);
        List<String> responses = new CopyOnWriteArrayList<>();
        CountDownLatch closed = new CountDownLatch(1);
        AtomicReference<Status> status = new AtomicReference<>();
        call.start(new ClientCall.Listener<String>() {
            @Override
            public void onMessage(String message) {
                responses.add(message);
                call.request(1);
            }

            @Override
            public void onClose(Status s, Metadata trailers) {
                status.set(s);
                closed.countDown();
            }
        }, new Metadata());
        // A pull-based client asks for its first message before it sends the request.
        call.request(1);
        assertEquals("not ready before the message is signed", false, call.isReady());
        call.sendMessage("pull");
        call.halfClose();
        assertTrue(closed.await(5, TimeUnit.SECONDS));
        assertTrue(String.valueOf(status.get()), status.get().isOk());
        assertEquals(List.of("pull0", "pull1", "pull2"), responses);
        assertEquals(hash("pull"), calls.get(0).headers.get(CONTENT_SHA256));
    }

    @Test
    public void testConcurrentCallsEachSignTheirOwnMessage() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        try {
            List<Future<String>> results = new ArrayList<>();
            for (int i = 0; i < 64; i++) {
                String message = "message-" + i;
                results.add(pool.submit(() -> ClientCalls.blockingUnaryCall(channel, UNARY, CallOptions.DEFAULT, message)));
            }
            for (Future<String> result : results) {
                result.get(10, TimeUnit.SECONDS);
            }
        } finally {
            pool.shutdownNow();
        }
        assertEquals(64, calls.size());
        for (Received received : calls) {
            assertEquals(1, received.messages.size());
            assertEquals(hash(received.messages.get(0)), received.headers.get(CONTENT_SHA256));
        }
    }

    @Test
    public void testClientStreamingCallIsSignedWithUnsignedPayload() throws InterruptedException {
        CountDownLatch done = new CountDownLatch(1);
        StreamObserver<String> requests = io.grpc.stub.ClientCalls.asyncClientStreamingCall(
            channel.newCall(CLIENT_STREAMING, CallOptions.DEFAULT),
            new StreamObserver<String>() {
                @Override
                public void onNext(String value) {}

                @Override
                public void onError(Throwable t) {
                    done.countDown();
                }

                @Override
                public void onCompleted() {
                    done.countDown();
                }
            }
        );
        requests.onNext("a");
        requests.onNext("b");
        requests.onCompleted();
        assertTrue(done.await(5, TimeUnit.SECONDS));
        assertEquals(GrpcSigV4Interceptor.UNSIGNED_PAYLOAD, calls.get(0).headers.get(CONTENT_SHA256));
        assertEquals(List.of("a", "b"), calls.get(0).messages);
    }

    @Test
    public void testSigningFailureFailsTheCallAndSendsNothing() throws InterruptedException {
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        GrpcSigV4Interceptor failing = new GrpcSigV4Interceptor(
            GrpcSigV4Config.builder().region(Region.US_EAST_1).credentialsProvider(() -> {
                throw new IllegalStateException("no credentials");
            }).build(),
            "search-domain.us-east-1.es.amazonaws.com"
        );
        channel = InProcessChannelBuilder.forName(serverName).directExecutor().intercept(failing).build();
        try {
            ClientCalls.blockingUnaryCall(channel, UNARY, CallOptions.DEFAULT, "secret");
            fail("expected UNAUTHENTICATED");
        } catch (StatusRuntimeException e) {
            assertEquals(Status.Code.UNAUTHENTICATED, e.getStatus().getCode());
            assertTrue(e.getStatus().getDescription(), e.getStatus().getDescription().contains("no credentials"));
        }
        assertEquals("the server received nothing", 0, calls.size());
    }

    @Test
    public void testCancelBeforeTheMessageEndsTheCallWithoutSendingIt() throws InterruptedException {
        ClientCall<String, String> call = channel.newCall(UNARY, CallOptions.DEFAULT);
        AtomicReference<Status> status = new AtomicReference<>();
        CountDownLatch closed = new CountDownLatch(1);
        call.start(new ClientCall.Listener<String>() {
            @Override
            public void onClose(Status s, Metadata trailers) {
                status.set(s);
                closed.countDown();
            }
        }, new Metadata());
        call.request(1);
        call.cancel("caller gave up", null);
        assertTrue(closed.await(5, TimeUnit.SECONDS));
        assertEquals(Status.Code.CANCELLED, status.get().getCode());
        assertEquals("caller gave up", status.get().getDescription());
        assertEquals(0, calls.size());
    }

    @Test
    public void testEachBulkRetryIsSignedForTheRequestItSends() throws IOException {
        GrpcTransport transport = new GrpcTransport(
            channel,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().maxRetries(1).retryBackoff(1, TimeUnit.MILLISECONDS).build(),
            null
        );
        BulkResponse response = new OpenSearchClient(transport).bulk(
            new BulkRequest.Builder().operations(op -> op.delete(d -> d.id("1").index("logs"))).build()
        );
        assertEquals(1, response.took());
        assertEquals("the first attempt failed and was retried", 2, bulkAttempts.get());
        assertEquals(2, calls.size());
        for (Received received : calls) {
            // The server recorded the hash of the request it parsed; the signature carries the same hash.
            assertEquals(received.messages.get(0), received.headers.get(CONTENT_SHA256));
            assertNotEquals(EMPTY_BODY_HASH, received.headers.get(CONTENT_SHA256));
        }
    }
}
