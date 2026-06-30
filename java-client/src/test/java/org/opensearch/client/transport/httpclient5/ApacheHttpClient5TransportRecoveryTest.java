/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncPushConsumer;
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.reactor.IOReactorShutdownException;
import org.apache.hc.core5.reactor.IOReactorStatus;
import org.apache.hc.core5.util.TimeValue;
import org.junit.Test;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.transport.endpoints.BooleanEndpoint;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.transport.httpclient5.internal.Node;

/**
 * Unit tests for the self-healing recovery of {@link ApacheHttpClient5Transport} (see opensearch-java#1969).
 */
public class ApacheHttpClient5TransportRecoveryTest {

    private static final HttpHost HOST_A = new HttpHost("localhost", 9200);

    // --- Reactor recovery -----------------------------------------------------------------------------------------

    @Test
    public void testRecoversByRebuildingClientAfterReactorShutdown() throws IOException {
        FakeAsyncClient dead = new FakeAsyncClient(true);
        FakeAsyncClient healthy = new FakeAsyncClient(false);
        AtomicInteger factoryCalls = new AtomicInteger();
        Supplier<CloseableHttpAsyncClient> factory = () -> {
            factoryCalls.incrementAndGet();
            return healthy;
        };

        ApacheHttpClient5Transport transport = newTransport(factory, dead);

        // The dead reactor is detected, the client is rebuilt, and the request is retried on the healthy client.
        BooleanResponse response = transport.performRequest(null, headEndpoint(), null);

        assertTrue("request should succeed after recovery", response.value());
        assertEquals("client should be rebuilt exactly once", 1, factoryCalls.get());
        assertTrue("dead client should be closed during recovery", dead.closed);
    }

    @Test
    public void testRecoversWhenReactorShutdownIsReportedToCallback() throws IOException {
        FakeAsyncClient dead = FakeAsyncClient.reactorShutdownViaCallback();
        FakeAsyncClient healthy = new FakeAsyncClient(false);
        AtomicInteger factoryCalls = new AtomicInteger();
        Supplier<CloseableHttpAsyncClient> factory = () -> {
            factoryCalls.incrementAndGet();
            return healthy;
        };

        ApacheHttpClient5Transport transport = newTransport(factory, dead);

        // The real HC5 client catches IOReactorShutdownException as an IllegalStateException and reports it to the
        // FutureCallback. Recovery must therefore happen from failed(...), not only from a synchronous execute() throw.
        BooleanResponse response = transport.performRequest(null, headEndpoint(), null);

        assertTrue("request should succeed after callback-delivered recovery", response.value());
        assertEquals("client should be rebuilt exactly once", 1, factoryCalls.get());
        assertEquals("dead client should receive the original request once", 1, dead.executeCount.get());
        assertEquals("healthy client should receive the recovered retry once", 1, healthy.executeCount.get());
        assertTrue("dead client should be closed during recovery", dead.closed);
    }

    @Test
    public void testRebuildIsCircuitBroken() {
        FakeAsyncClient dead = new FakeAsyncClient(true);
        AtomicInteger factoryCalls = new AtomicInteger();
        // Every rebuilt client is also dead, simulating sustained pressure that keeps killing the reactor.
        Supplier<CloseableHttpAsyncClient> factory = () -> {
            factoryCalls.incrementAndGet();
            return new FakeAsyncClient(true);
        };

        ApacheHttpClient5Transport transport = newTransport(factory, dead);

        // Two requests in quick succession (well within the back-off window).
        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));

        // The breaker must allow only a single rebuild attempt within the back-off window.
        assertEquals("circuit breaker should permit only one rebuild within the back-off window", 1, factoryCalls.get());
    }

    @Test
    public void testRecoveryDisabledWhenNoFactory() {
        FakeAsyncClient dead = new FakeAsyncClient(true);

        // No factory => client lifecycle owned externally => recovery disabled, request just fails.
        ApacheHttpClient5Transport transport = newTransport(null, dead);

        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertFalse("externally-owned client must not be closed by the transport", dead.closed);
    }

    @Test
    public void testClosedTransportDoesNotRecover() throws IOException {
        FakeAsyncClient initial = FakeAsyncClient.reactorShutdownViaCallback();
        AtomicInteger factoryCalls = new AtomicInteger();
        Supplier<CloseableHttpAsyncClient> factory = () -> {
            factoryCalls.incrementAndGet();
            return new FakeAsyncClient(false);
        };

        ApacheHttpClient5Transport transport = newTransport(factory, initial);
        transport.close();

        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertTrue("close should close the current client", initial.closed);
        assertEquals("closed transport must not execute requests", 0, initial.executeCount.get());
        assertEquals("closed transport must not rebuild a new client", 0, factoryCalls.get());
    }

    @Test
    public void testRebuildBackoffGrowsExponentially() {
        AtomicLong clock = new AtomicLong(0L);
        AtomicInteger factoryCalls = new AtomicInteger();
        Supplier<CloseableHttpAsyncClient> factory = () -> {
            factoryCalls.incrementAndGet();
            return new FakeAsyncClient(true); // rebuilt clients are also dead (sustained failure)
        };
        // Base back-off 1000 ms.
        ApacheHttpClient5Transport transport = newTransport(
            factory,
            new FakeAsyncClient(true),
            1000L,
            Collections.singletonList(new Node(HOST_A))
        );
        transport.setNanoClock(clock::get);

        final long ms = 1_000_000L;

        // t=0: first detected shutdown -> rebuild #1, back-off = 1000 ms.
        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertEquals(1, factoryCalls.get());

        // Still within 1000 ms of the last rebuild -> no rebuild.
        clock.set(900L * ms);
        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertEquals(1, factoryCalls.get());

        // Past 1000 ms -> rebuild #2, back-off doubles to 2000 ms.
        clock.set(1_100L * ms);
        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertEquals(2, factoryCalls.get());

        // Only 1000 ms after the last rebuild (< 2000 ms window) -> no rebuild.
        clock.set(2_100L * ms);
        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertEquals(2, factoryCalls.get());

        // Past the 2000 ms window -> rebuild #3.
        clock.set(3_200L * ms);
        assertThrows(IOException.class, () -> transport.performRequest(null, headEndpoint(), null));
        assertEquals(3, factoryCalls.get());
    }

    // --- helpers --------------------------------------------------------------------------------------------------

    private static ApacheHttpClient5Transport newTransport(Supplier<CloseableHttpAsyncClient> factory, CloseableHttpAsyncClient initial) {
        return newTransport(factory, initial, 60_000L, Collections.singletonList(new Node(HOST_A)));
    }

    private static ApacheHttpClient5Transport newTransport(
        Supplier<CloseableHttpAsyncClient> factory,
        CloseableHttpAsyncClient initial,
        long backoffMillis,
        List<Node> nodes
    ) {
        return new ApacheHttpClient5Transport(
            factory,
            backoffMillis,
            initial,
            new Header[0],
            nodes,
            new JacksonJsonpMapper(),
            null,
            null,
            null,
            null,
            false,
            false,
            false
        );
    }

    private static BooleanEndpoint<Void> headEndpoint() {
        return new BooleanEndpoint<>(v -> "HEAD", v -> "/", v -> Collections.emptyMap(), v -> Collections.emptyMap());
    }

    /**
     * Minimal {@link CloseableHttpAsyncClient}. When {@code reactorDown} is set, {@code doExecute} throws
     * {@link IOReactorShutdownException}; when {@code reactorDownViaCallback} is set, it reports the same shutdown to
     * the callback, matching the path used by the real HC5 client when scheduling catches the shutdown. Otherwise it
     * completes with an empty {@code 200} response.
     */
    private static final class FakeAsyncClient extends CloseableHttpAsyncClient {
        private final boolean reactorDown;
        private final boolean reactorDownViaCallback;
        final AtomicInteger executeCount = new AtomicInteger();
        volatile boolean closed = false;

        FakeAsyncClient(boolean reactorDown) {
            this(reactorDown, false);
        }

        private FakeAsyncClient(boolean reactorDown, boolean reactorDownViaCallback) {
            this.reactorDown = reactorDown;
            this.reactorDownViaCallback = reactorDownViaCallback;
        }

        static FakeAsyncClient reactorShutdownViaCallback() {
            return new FakeAsyncClient(true, true);
        }

        @Override
        protected <T> Future<T> doExecute(
            HttpHost target,
            AsyncRequestProducer requestProducer,
            AsyncResponseConsumer<T> responseConsumer,
            HandlerFactory<AsyncPushConsumer> pushHandlerFactory,
            HttpContext context,
            FutureCallback<T> callback
        ) {
            executeCount.incrementAndGet();
            if (reactorDown) {
                IOReactorShutdownException shutdown = new IOReactorShutdownException("I/O reactor has been shut down");
                if (reactorDownViaCallback) {
                    if (callback != null) {
                        callback.failed(shutdown);
                    }
                    return CompletableFuture.completedFuture(null);
                }
                throw shutdown;
            }
            @SuppressWarnings("unchecked")
            T response = (T) new BasicClassicHttpResponse(200);
            if (callback != null) {
                callback.completed(response);
            }
            return CompletableFuture.completedFuture(response);
        }

        @Override
        public void start() {}

        @Override
        public IOReactorStatus getStatus() {
            return reactorDown ? IOReactorStatus.SHUT_DOWN : IOReactorStatus.ACTIVE;
        }

        @Override
        public void awaitShutdown(TimeValue waitTime) {}

        @Override
        public void initiateShutdown() {}

        @Override
        public void register(String hostname, String uriPattern, org.apache.hc.core5.function.Supplier<AsyncPushConsumer> supplier) {}

        @Override
        public void close(CloseMode closeMode) {
            closed = true;
        }

        @Override
        public void close() {
            closed = true;
        }
    }
}
