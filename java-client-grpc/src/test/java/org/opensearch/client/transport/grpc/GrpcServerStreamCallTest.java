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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.TransportOptions;

public class GrpcServerStreamCallTest {

    private static final Metadata.Key<String> FORMAT = Metadata.Key.of("x-test-format", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> OPAQUE_ID = Metadata.Key.of("x-opaque-id", Metadata.ASCII_STRING_MARSHALLER);
    private static final Context.Key<Metadata> HEADERS = Context.key("headers");

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

    private static final MethodDescriptor<String, String> ITEMS = MethodDescriptor.<String, String>newBuilder()
        .setFullMethodName("test.Stream/Items")
        .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
        .setRequestMarshaller(UTF8)
        .setResponseMarshaller(UTF8)
        .build();

    // What the server does, set per test.
    private volatile int items = 5;
    private volatile int failuresBeforeFirstMessage;
    private volatile Status failureStatus = Status.UNAVAILABLE;
    private volatile int failAfter = -1;

    private final AtomicInteger attempts = new AtomicInteger();
    private final AtomicInteger sent = new AtomicInteger();
    private final List<Metadata> receivedHeaders = new ArrayList<>();
    private final CountDownLatch serverCancelled = new CountDownLatch(1);
    private volatile CountDownLatch sentBeyond = new CountDownLatch(1);
    private volatile int sentBeyondThreshold = Integer.MAX_VALUE;

    private String name;
    private Server server;
    private ManagedChannel channel;
    private GrpcTransport transport;

    @Before
    public void start() throws IOException {
        name = InProcessServerBuilder.generateName();
        ServerInterceptor headersToContext = new ServerInterceptor() {
            @Override
            public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                ServerCall<ReqT, RespT> call,
                Metadata headers,
                ServerCallHandler<ReqT, RespT> next
            ) {
                return Contexts.interceptCall(Context.current().withValue(HEADERS, headers), call, headers, next);
            }
        };
        ServerServiceDefinition service = ServerServiceDefinition.builder("test.Stream")
            .addMethod(ITEMS, ServerCalls.asyncServerStreamingCall((String request, StreamObserver<String> out) -> serve(request, out)))
            .build();
        server = InProcessServerBuilder.forName(name).addService(ServerInterceptors.intercept(service, headersToContext)).build().start();
        channel = InProcessChannelBuilder.forName(name).build();
        transport = new GrpcTransport(
            channel,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().maxRetries(2).retryBackoff(1, TimeUnit.MILLISECONDS).build(),
            null
        );
    }

    /** Sends the items while the client has room for them, as a flow-controlled server does. */
    private void serve(String request, StreamObserver<String> out) {
        synchronized (receivedHeaders) {
            receivedHeaders.add(HEADERS.get());
        }
        if (attempts.incrementAndGet() <= failuresBeforeFirstMessage) {
            out.onError(failureStatus.asRuntimeException());
            return;
        }
        ServerCallStreamObserver<String> observer = (ServerCallStreamObserver<String>) out;
        observer.setOnCancelHandler(serverCancelled::countDown);
        AtomicInteger next = new AtomicInteger();
        Runnable drain = new Runnable() {
            @Override
            public synchronized void run() {
                while (observer.isReady() && observer.isCancelled() == false) {
                    int i = next.getAndIncrement();
                    if (i == failAfter) {
                        observer.onError(failureStatus.asRuntimeException());
                        return;
                    }
                    if (i >= items) {
                        if (i == items) {
                            observer.onCompleted();
                        }
                        return;
                    }
                    observer.onNext(request + i);
                    if (sent.incrementAndGet() > sentBeyondThreshold) {
                        sentBeyond.countDown();
                    }
                }
            }
        };
        observer.setOnReadyHandler(drain);
        drain.run();
    }

    @After
    public void stop() throws InterruptedException {
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        server.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** An endpoint for the test method, counting the messages it was asked to discard. */
    private static class ItemsEndpoint implements GrpcStreamingEndpoint<String, String, String> {
        final AtomicInteger discarded = new AtomicInteger();
        final MethodDescriptor.Marshaller<String> marshaller;

        ItemsEndpoint() {
            this(UTF8);
        }

        ItemsEndpoint(MethodDescriptor.Marshaller<String> marshaller) {
            this.marshaller = marshaller;
        }

        @Override
        public MethodDescriptor<String, ?> method() {
            return ITEMS;
        }

        @Override
        public String toProto(String request, JsonpMapper mapper) {
            return request;
        }

        @Override
        public Map<String, String> headers(String request) {
            return Map.of("x-test-format", "items");
        }

        @Override
        public MethodDescriptor.Marshaller<String> responseMarshaller() {
            return marshaller;
        }

        @Override
        public void discard(String message) {
            discarded.incrementAndGet();
        }
    }

    private static List<String> drain(GrpcServerStream<String> stream) throws IOException {
        List<String> all = new ArrayList<>();
        for (String item = stream.next(); item != null; item = stream.next()) {
            all.add(item);
        }
        return all;
    }

    /** Returns whether {@code thread} reached {@code state} within 10 seconds. */
    private static boolean reachesState(Thread thread, Thread.State state) {
        long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
        while (thread.getState() != state) {
            if (System.nanoTime() - deadline > 0) {
                return false;
            }
            Thread.yield();
        }
        return true;
    }

    @Test
    public void testMessagesArriveInOrderThenTheStreamEnds() throws IOException {
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null)) {
            assertEquals(List.of("item0", "item1", "item2", "item3", "item4"), drain(stream));
            assertNull("ended streams stay ended", stream.next());
        }
    }

    @Test
    public void testTheServerPausesUntilTheCallerPulls() throws Exception {
        items = 100;
        sentBeyondThreshold = 4;
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null)) {
            assertEquals("item0", stream.next());
            // With prefetch 2 the server may run a little ahead, but never far while the caller does not pull.
            assertFalse("the server kept sending while the caller did not pull", sentBeyond.await(300, TimeUnit.MILLISECONDS));
            assertEquals(99, drain(stream).size());
        }
    }

    @Test
    public void testServerErrorsMapLikeUnaryErrors() throws IOException {
        failuresBeforeFirstMessage = 1;
        failureStatus = Status.INVALID_ARGUMENT.withDescription("[sort] is not supported");
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null)) {
            stream.next();
            fail("expected OpenSearchException");
        } catch (OpenSearchException e) {
            assertEquals(400, e.status());
            assertTrue(e.getMessage(), e.getMessage().contains("[sort] is not supported"));
        }
        assertEquals("not retried", 1, attempts.get());

        attempts.set(0);
        failureStatus = Status.UNAUTHENTICATED.withDescription("bad password");
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null)) {
            stream.next();
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("401"));
        }
    }

    @Test
    public void testAFailureBeforeTheFirstMessageIsRetried() throws IOException {
        failuresBeforeFirstMessage = 2;
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null)) {
            assertEquals(5, drain(stream).size());
        }
        assertEquals(3, attempts.get());
    }

    @Test
    public void testAFailureAfterAMessageIsNotRetried() throws IOException {
        failAfter = 1;
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null)) {
            assertEquals("item0", stream.next());
            stream.next();
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("unavailable"));
        }
        assertEquals(1, attempts.get());
    }

    @Test
    public void testCancelFromAnotherThreadUnblocksTheCallerAndStopsTheServer() throws Exception {
        items = 1_000_000;
        GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null);
        assertEquals("item0", stream.next());
        AtomicReference<Throwable> thrown = new AtomicReference<>();
        CountDownLatch done = new CountDownLatch(1);
        Thread consumer = new Thread(() -> {
            try {
                while (stream.next() != null) {
                    // keep pulling
                }
            } catch (Throwable t) {
                thrown.set(t);
            } finally {
                done.countDown();
            }
        });
        consumer.start();
        stream.cancel();
        assertTrue(done.await(10, TimeUnit.SECONDS));
        assertTrue(String.valueOf(thrown.get()), thrown.get() instanceof TransportException);
        assertTrue("the server saw the cancellation", serverCancelled.await(10, TimeUnit.SECONDS));
        stream.close();
    }

    @Test
    public void testCancelDuringTheRetryBackoffEndsTheCallWithoutRetrying() throws Exception {
        failuresBeforeFirstMessage = 1;
        GrpcTransport slowRetries = new GrpcTransport(
            channel,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().maxRetries(1).retryBackoff(1, TimeUnit.MINUTES).build(),
            null
        );
        GrpcServerStream<String> stream = slowRetries.serverStream("item", new ItemsEndpoint(), null);
        AtomicReference<Throwable> thrown = new AtomicReference<>();
        CountDownLatch done = new CountDownLatch(1);
        Thread consumer = new Thread(() -> {
            try {
                stream.next();
            } catch (Throwable t) {
                thrown.set(t);
            } finally {
                done.countDown();
            }
        });
        consumer.setDaemon(true);
        consumer.start();
        // The only timed wait of next() is the backoff after the failed first attempt.
        assertTrue("the caller waits out the backoff", reachesState(consumer, Thread.State.TIMED_WAITING));
        stream.cancel();
        assertTrue("cancel() ends the backoff", done.await(10, TimeUnit.SECONDS));
        assertTrue(String.valueOf(thrown.get()), thrown.get() instanceof TransportException);
        long closing = System.nanoTime();
        stream.close();
        assertTrue("no attempt is left running to wait for", System.nanoTime() - closing < TimeUnit.SECONDS.toNanos(4));
        assertEquals("no attempt after the cancel", 1, attempts.get());
    }

    @Test
    public void testCloseDuringTheRetryBackoffEndsTheCallWithoutRetrying() throws Exception {
        failuresBeforeFirstMessage = 1;
        GrpcTransport slowRetries = new GrpcTransport(
            channel,
            new JacksonJsonpMapper(),
            GrpcTransportOptions.builder().maxRetries(1).retryBackoff(1, TimeUnit.MINUTES).build(),
            null
        );
        GrpcServerStream<String> stream = slowRetries.serverStream("item", new ItemsEndpoint(), null);
        CountDownLatch done = new CountDownLatch(1);
        Thread consumer = new Thread(() -> {
            try {
                stream.next();
            } catch (Throwable t) {
                // the first attempt's failure
            } finally {
                done.countDown();
            }
        });
        consumer.setDaemon(true);
        consumer.start();
        assertTrue("the caller waits out the backoff", reachesState(consumer, Thread.State.TIMED_WAITING));
        stream.close();
        assertTrue("close() ends the backoff", done.await(10, TimeUnit.SECONDS));
        assertEquals("no attempt after the close", 1, attempts.get());
    }

    @Test
    public void testClosingEarlyStopsTheServerAndReleasesUnreadMessages() throws Exception {
        items = 1_000_000;
        ItemsEndpoint endpoint = new ItemsEndpoint();
        GrpcServerStream<String> stream = transport.serverStream("item", endpoint, null);
        assertEquals("item0", stream.next());
        stream.close();
        assertTrue("the server saw the cancellation", serverCancelled.await(10, TimeUnit.SECONDS));
        assertTrue("messages queued for the caller are released", endpoint.discarded.get() >= 1);
        stream.close();
    }

    @Test
    public void testRequestHeadersReachTheServer() throws IOException {
        TransportOptions options = TransportOptions.builder().addHeader("X-Opaque-Id", "export-1").addHeader("Content-Type", "x").build();
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), options)) {
            drain(stream);
        }
        Metadata headers = receivedHeaders.get(0);
        assertEquals("items", headers.get(FORMAT));
        assertEquals("export-1", headers.get(OPAQUE_ID));
        assertFalse(
            "headers gRPC owns are not forwarded",
            "x".equals(headers.get(Metadata.Key.of("content-type", Metadata.ASCII_STRING_MARSHALLER)))
        );
    }

    @Test
    public void testAnInterruptedCallerCancelsTheCall() throws Exception {
        items = 1_000_000;
        GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), null);
        assertEquals("item0", stream.next());
        Thread.currentThread().interrupt();
        try {
            // The prefetched messages may still be returned; the interrupt fails the first wait.
            while (stream.next() != null) {
                Thread.currentThread().interrupt();
            }
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(Thread.interrupted());
        }
        assertTrue(serverCancelled.await(10, TimeUnit.SECONDS));
        stream.close();
    }

    @Test
    public void testClosingOnAnInterruptedThreadStillWaitsForTheDecoder() throws Exception {
        items = 1_000_000;
        CountDownLatch decoding = new CountDownLatch(1);
        CountDownLatch release = new CountDownLatch(1);
        AtomicBoolean decoded = new AtomicBoolean();
        MethodDescriptor.Marshaller<String> blocking = new MethodDescriptor.Marshaller<String>() {
            private final AtomicInteger parsed = new AtomicInteger();

            @Override
            public InputStream stream(String value) {
                return UTF8.stream(value);
            }

            @Override
            public String parse(InputStream stream) {
                if (parsed.incrementAndGet() == 2) {
                    decoding.countDown();
                    try {
                        release.await(10, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    decoded.set(true);
                }
                return UTF8.parse(stream);
            }
        };
        GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(blocking), null);
        assertEquals("item0", stream.next());
        assertTrue(decoding.await(10, TimeUnit.SECONDS));
        // Lets the decoder finish once close() waits for the call to close.
        Thread closer = Thread.currentThread();
        Thread releaser = new Thread(() -> {
            reachesState(closer, Thread.State.TIMED_WAITING);
            release.countDown();
        });
        releaser.setDaemon(true);
        releaser.start();
        // As after a next() that an interrupt failed.
        closer.interrupt();
        try {
            stream.close();
            assertTrue("close() returned while a message was being decoded", decoded.get());
            assertTrue("the thread stays interrupted", Thread.currentThread().isInterrupted());
        } finally {
            Thread.interrupted();
            release.countDown();
        }
    }

    @Test
    public void testACancelledCallerContextFailsAsACancellation() throws Exception {
        items = 1_000_000;
        Context.CancellableContext caller = Context.current().withCancellation();
        GrpcServerStream<String> stream = caller.call(() -> transport.serverStream("item", new ItemsEndpoint(), null));
        try {
            assertEquals("item0", stream.next());
            // As gRPC cancels the context of a server call whose client went away.
            caller.cancel(Status.CANCELLED.withDescription("client went away").asRuntimeException());
            drain(stream);
            fail("expected TransportException");
        } catch (TransportException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("client went away"));
        } finally {
            stream.close();
        }
        assertTrue("the server saw the cancellation", serverCancelled.await(10, TimeUnit.SECONDS));
    }

    @Test
    public void testADecodingFailureIsReportedAsItself() throws IOException {
        MethodDescriptor.Marshaller<String> failing = new MethodDescriptor.Marshaller<String>() {
            private final AtomicInteger parsed = new AtomicInteger();

            @Override
            public InputStream stream(String value) {
                return UTF8.stream(value);
            }

            @Override
            public String parse(InputStream stream) {
                if (parsed.incrementAndGet() == 2) {
                    throw new IllegalStateException("bad message");
                }
                return UTF8.parse(stream);
            }
        };
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(failing), null)) {
            assertEquals("item0", stream.next());
            stream.next();
            fail("expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertEquals("bad message", e.getMessage());
        }
    }

    @Test
    public void testHybridTransportStreamsOverGrpc() throws IOException {
        HybridTransport hybrid = new HybridTransport(transport, null);
        try (GrpcServerStream<String> stream = hybrid.serverStream("item", new ItemsEndpoint(), null)) {
            assertEquals(5, drain(stream).size());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOnlyServerStreamingMethodsAreAccepted() throws IOException {
        ItemsEndpoint unary = new ItemsEndpoint() {
            @Override
            public MethodDescriptor<String, ?> method() {
                return ITEMS.toBuilder().setType(MethodDescriptor.MethodType.UNARY).build();
            }
        };
        transport.serverStream("item", unary, null);
    }

    @Test(timeout = 20_000)
    public void testARetryThatFailsToStartEndsTheStream() throws Exception {
        failuresBeforeFirstMessage = 1;
        // As when the token service fails while the first attempt's failure is retried
        AtomicInteger tokens = new AtomicInteger();
        JwtAuthInterceptor jwt = new JwtAuthInterceptor(() -> {
            if (tokens.incrementAndGet() == 2) {
                throw new IllegalStateException("token service unavailable");
            }
            return "token";
        });
        ManagedChannel withJwt = InProcessChannelBuilder.forName(name).intercept(jwt).build();
        try {
            GrpcServerStream<String> stream = new GrpcTransport(
                withJwt,
                new JacksonJsonpMapper(),
                GrpcTransportOptions.builder().maxRetries(2).retryBackoff(1, TimeUnit.MILLISECONDS).build(),
                null
            ).serverStream("item", new ItemsEndpoint(), null);
            try {
                stream.next();
                fail("expected IllegalStateException");
            } catch (IllegalStateException e) {
                assertEquals("token service unavailable", e.getMessage());
            }
            try {
                stream.next();
                fail("expected TransportException");
            } catch (TransportException e) {
                assertTrue(e.getMessage(), e.getMessage().contains("failed to start"));
            }
            long closing = System.nanoTime();
            stream.close();
            assertTrue("no attempt is left running to wait for", System.nanoTime() - closing < TimeUnit.SECONDS.toNanos(4));
            assertEquals("no attempt after the one that failed to start", 1, attempts.get());
        } finally {
            withJwt.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    @Test
    public void testOptionsGrpcCannotCarryFailBeforeAnythingIsSent() {
        List<TransportOptions> unsendable = List.of(
            // A token read from a file that ends in a newline
            TransportOptions.builder().addHeader("Authorization", "Bearer secret-token\n").build(),
            TransportOptions.builder().addHeader("X-Trace-Bin", "AAEC").build(),
            TransportOptions.builder().addHeader("X-Tenant!", "reports").build(),
            TransportOptions.builder().setParameter("filter_path", "hits").build(),
            TransportOptions.builder().onWarnings(warnings -> true).build()
        );
        for (TransportOptions options : unsendable) {
            try {
                transport.serverStream("item", new ItemsEndpoint(), options).close();
                fail("expected UnsupportedOperationException for " + options.headers() + options.queryParameters());
            } catch (UnsupportedOperationException e) {
                assertFalse("values, such as credentials, are not shown", e.getMessage().contains("secret-token"));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        assertEquals("nothing was sent", 0, attempts.get());
    }

    @Test
    public void testHeadersAreSentAsUnaryCallsSendThem() throws IOException {
        TransportOptions options = TransportOptions.builder()
            .addHeader("Keep-Alive", "timeout=5")
            .addHeader("Proxy-Connection", "keep-alive")
            .addHeader("Transfer-Encoding", "chunked")
            .addHeader("Upgrade", "h2c")
            .addHeader("X-Forwarded-For", "10.0.0.1")
            .addHeader("X-Forwarded-For", "10.0.0.2")
            .addHeader("X-Test-Format", "replaced")
            .build();
        try (GrpcServerStream<String> stream = transport.serverStream("item", new ItemsEndpoint(), options)) {
            drain(stream);
        }
        Metadata headers = receivedHeaders.get(0);
        // HTTP/2 forbids them; they apply to a connection, not to a request
        for (String header : List.of("keep-alive", "proxy-connection", "transfer-encoding", "upgrade")) {
            assertFalse(header, headers.containsKey(Metadata.Key.of(header, Metadata.ASCII_STRING_MARSHALLER)));
        }
        List<String> forwarded = new ArrayList<>();
        headers.getAll(Metadata.Key.of("x-forwarded-for", Metadata.ASCII_STRING_MARSHALLER)).forEach(forwarded::add);
        assertEquals(List.of("10.0.0.1", "10.0.0.2"), forwarded);
        List<String> format = new ArrayList<>();
        headers.getAll(FORMAT).forEach(format::add);
        assertEquals("the endpoint's header replaces the request's", List.of("items"), format);
    }
}
