/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch._helpers.bulk;

import jakarta.json.stream.JsonGenerator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.transport.BackoffPolicy;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;

public class BulkIngesterTest extends Assert {

    static class AppData {
        private int intValue;
        private String msg;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    private static final BulkResponseItem successItem = BulkResponseItem.of(
        i -> i.index("foo").status(200).operationType(OperationType.Delete)
    );

    private static final BulkOperation operation = BulkOperation.of(op -> op.delete(d -> d.index("foo").id("bar")));

    private void printStats(BulkIngester<?> ingester) {
        System.out.printf(
            "Ingester - operations: %d (%d), requests: %d (%d)%n",
            ingester.operationsCount(),
            ingester.operationContentionsCount(),
            ingester.requestCount(),
            ingester.requestContentionsCount()
        );
    }

    private void printStats(CountingListener listener) {
        System.out.printf("Listener - operations: %d, requests: %d%n", listener.operations.get(), listener.requests.get());
    }

    private void printStats(TestTransport transport) {
        System.out.printf(
            "Transport - operations: %d, requests: %d (%d completed)%n",
            transport.operations.get(),
            transport.requestsStarted.get(),
            transport.requestsCompleted.get()
        );
    }

    @Test
    public void basicTestFlush() throws Exception {
        // Prime numbers, so that we have leftovers to flush before shutting down
        multiThreadTest(7, 3, 5, 101, true);
    }

    @Test
    public void basicTestFlushWithInternalScheduler() throws Exception {
        // Prime numbers, so that we have leftovers to flush before shutting down
        multiThreadTest(7, 3, 5, 101, false);
    }

    @Test
    public void basicTestNoFlush() throws Exception {
        // Will have nothing to flush on close.
        multiThreadTest(10, 3, 5, 100, true);
    }

    @Test
    public void basicTestNoFlushWithInternalScheduler() throws Exception {
        // Will have nothing to flush on close.
        multiThreadTest(10, 3, 5, 100, false);
    }

    private void multiThreadTest(int maxOperations, int maxRequests, int numThreads, int numOperations, boolean externalScheduler)
        throws Exception {

        CountingListener listener = new CountingListener();
        TestTransport transport = new TestTransport();
        OpenSearchAsyncClient client = new OpenSearchAsyncClient(transport);
        ScheduledExecutorService scheduler;
        if (externalScheduler) {
            scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
                Thread t = Executors.defaultThreadFactory().newThread(r);
                t.setName("my-bulk-ingester-executor#");
                t.setDaemon(true);
                return t;
            });
        } else {
            scheduler = null;
        }

        BulkIngester<Void> ingester = BulkIngester.of(
            b -> b.client(client).maxOperations(maxOperations).maxConcurrentRequests(maxRequests).scheduler(scheduler).listener(listener)
        );

        CountDownLatch latch = new CountDownLatch(numThreads);
        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int j = 0; j < numOperations; j++) {
                    ingester.add(operation);
                }

                latch.countDown();
            }).start();
        }

        latch.await();

        ingester.close();
        transport.close();
        if (scheduler != null) scheduler.shutdownNow();

        printStats(ingester);
        printStats(listener);
        printStats(transport);

        int expectedOperations = numThreads * numOperations;
        assertEquals(expectedOperations, ingester.operationsCount());
        assertEquals(expectedOperations, listener.operations.get());
        assertEquals(expectedOperations, transport.operations.get());

        int expectedRequests = expectedOperations / maxOperations + ((expectedOperations % maxOperations == 0) ? 0 : 1);

        assertEquals(expectedRequests, ingester.requestCount());
        assertEquals(expectedRequests, listener.requests.get());
        assertEquals(expectedRequests, transport.requestsStarted.get());
    }

    // Note: multiThreadStressTest has been moved to AbstractBulkIngesterIT
    // See: java-client/src/test/java11/org/opensearch/client/opensearch/integTest/AbstractBulkIngesterIT.java

    @Test
    public void sizeLimitTest() throws Exception {
        TestTransport transport = new TestTransport();

        long operationSize = IngesterOperation.of(new RetryableBulkOperation<>(operation, null, null), transport.jsonpMapper()).size();

        BulkIngester<?> ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                // Set size limit just above operation's size, leading to 2 operations per request
                .maxSize(operationSize + 1)
        );

        for (int i = 0; i < 10; i++) {
            ingester.add(operation);
        }

        ingester.close();
        transport.close();

        assertEquals(10, ingester.operationsCount());
        assertEquals(5, ingester.requestCount());
    }

    private static BulkOperation docOperation(String id, int length) {
        final var doc = Map.of("text", "x".repeat(length));
        return BulkOperation.of(op -> op.index(i -> i.index("foo").id(id).document(doc)));
    }

    private static long operationSize(BulkOperation op, JsonpMapper mapper) {
        return IngesterOperation.of(new RetryableBulkOperation<>(op, null, null), mapper).size();
    }

    private static long requestSize(BulkRequest request, JsonpMapper mapper) {
        return request.operations().stream().mapToLong(op -> operationSize(op, mapper)).sum();
    }

    private static void assertRequestsWithinMaxSize(List<BulkRequest> requests, long maxSize, JsonpMapper mapper) {
        synchronized (requests) {
            for (final var request : requests) {
                if (request.operations().size() > 1) {
                    assertTrue(
                        "Request with " + request.operations().size() + " operations exceeds maxSize",
                        requestSize(request, mapper) <= maxSize
                    );
                }
            }
        }
    }

    @Test
    public void strictSizeLimitMixedOperationsTest() throws Exception {
        final var mapper = new JacksonJsonpMapper();
        final var small = docOperation("small", 100);
        final var large = docOperation("large", 1000);
        // Two large operations fit, adding a small one would exceed maxSize
        final var maxSize = 2 * operationSize(large, mapper) + operationSize(small, mapper) - 1;
        final var sequence = List.of(large, large, small, large, small, small, large, large, small, large, small, small);

        final var strictTransport = new TestTransport();
        final var strictIngester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(strictTransport)).maxOperations(-1).maxSize(maxSize).strictMaxSize(true)
        );
        sequence.forEach(strictIngester::add);
        strictIngester.close();
        strictTransport.close();

        assertTrue(strictIngester.strictMaxSize());
        assertEquals(sequence.size(), strictTransport.operations.get());
        assertRequestsWithinMaxSize(strictTransport.requests, maxSize, mapper);

        // Default (non-strict) behaviour is unchanged: requests may exceed maxSize by up to one operation
        final var defaultTransport = new TestTransport();
        final var defaultIngester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(defaultTransport)).maxOperations(-1).maxSize(maxSize)
        );
        sequence.forEach(defaultIngester::add);
        defaultIngester.close();
        defaultTransport.close();

        assertFalse(defaultIngester.strictMaxSize());
        assertEquals(sequence.size(), defaultTransport.operations.get());
        assertTrue(defaultTransport.requests.stream().anyMatch(r -> requestSize(r, mapper) > maxSize));
    }

    @Test
    public void strictSizeLimitOversizedOperationTest() throws Exception {
        final var mapper = new JacksonJsonpMapper();
        final var small = docOperation("small", 10);
        final var huge = docOperation("huge", 10_000);
        final var maxSize = 3 * operationSize(small, mapper);
        assertTrue(operationSize(huge, mapper) > maxSize);

        final var transport = new TestTransport();
        final var ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport)).maxOperations(-1).maxSize(maxSize).strictMaxSize(true)
        );
        ingester.add(small);
        ingester.add(small);
        ingester.add(huge);
        ingester.add(small);
        ingester.add(small);
        ingester.close();
        transport.close();

        assertEquals(5, ingester.operationsCount());
        assertEquals(3, ingester.requestCount());
        assertEquals(2, transport.requests.get(0).operations().size());
        assertEquals("huge", transport.requests.get(1).operations().get(0).index().id());
        assertEquals(1, transport.requests.get(1).operations().size());
        assertEquals(2, transport.requests.get(2).operations().size());
    }

    @Test
    public void strictSizeLimitWithMaxOperationsTest() throws Exception {
        final var mapper = new JacksonJsonpMapper();
        final var operationSize = operationSize(operation, mapper);

        // maxOperations is reached first
        final var transport1 = new TestTransport();
        final var ingester1 = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport1)).maxOperations(3).maxSize(10 * operationSize).strictMaxSize(true)
        );
        for (int i = 0; i < 10; i++) {
            ingester1.add(operation);
        }
        ingester1.close();
        transport1.close();

        assertEquals(10, transport1.operations.get());
        assertEquals(4, ingester1.requestCount());

        // maxSize is reached first: a third operation would exceed it
        final var transport2 = new TestTransport();
        final var ingester2 = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport2)).maxOperations(3).maxSize(2 * operationSize + 1).strictMaxSize(true)
        );
        for (int i = 0; i < 10; i++) {
            ingester2.add(operation);
        }
        ingester2.close();
        transport2.close();

        assertEquals(10, transport2.operations.get());
        assertEquals(5, ingester2.requestCount());
        assertRequestsWithinMaxSize(transport2.requests, 2 * operationSize + 1, mapper);
    }

    @Test
    public void strictSizeLimitWithFlushIntervalTest() throws Exception {
        final var mapper = new JacksonJsonpMapper();
        final var maxSize = 2 * operationSize(operation, mapper) + 1;

        final var transport = new TestTransport();
        final var ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                .flushInterval(50, TimeUnit.MILLISECONDS)
                .maxOperations(-1)
                .maxSize(maxSize)
                .strictMaxSize(true)
        );

        // A single operation is sent by the periodic flush
        ingester.add(operation);
        awaitRequestCount(ingester, 1);

        // Two requests are sent because of maxSize, the remaining operation by the periodic flush
        for (int i = 0; i < 5; i++) {
            ingester.add(operation);
        }
        awaitRequestCount(ingester, 4);

        ingester.close();
        transport.close();

        assertEquals(6, transport.operations.get());
        assertRequestsWithinMaxSize(transport.requests, maxSize, mapper);
    }

    @Test
    public void strictSizeLimitWithBackPressureTest() throws Exception {
        final var mapper = new JacksonJsonpMapper();
        final var maxSize = 2 * operationSize(operation, mapper) + 1;

        final var transport = new TestTransport();
        final var gate = new CountDownLatch(1);
        transport.responseGate = gate;

        final var ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                .maxOperations(-1)
                .maxSize(maxSize)
                .strictMaxSize(true)
                .maxConcurrentRequests(1)
        );

        final var producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ingester.add(operation);
            }
        });
        producer.start();

        // The first request is in flight and never completes until the gate is opened: the producer must block
        // instead of adding operations to the full buffer.
        long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
        while (transport.requestsStarted.get() < 1 || ingester.requestContentionsCount() < 1) {
            if (System.nanoTime() - deadline > 0) {
                fail("Timed out waiting for the producer to block");
            }
            Thread.sleep(5);
        }
        assertTrue(producer.isAlive());
        assertEquals(1, transport.requestsStarted.get());
        assertTrue(ingester.pendingOperationsSize() <= maxSize);

        gate.countDown();
        producer.join(TimeUnit.SECONDS.toMillis(10));
        assertFalse(producer.isAlive());

        ingester.close();
        transport.close();

        assertEquals(10, transport.operations.get());
        assertEquals(5, ingester.requestCount());
        assertRequestsWithinMaxSize(transport.requests, maxSize, mapper);
    }

    @Test
    public void strictSizeLimitWithRetriesTest() throws Exception {
        final var mapper = new JacksonJsonpMapper();
        final var operations = new ArrayList<BulkOperation>();
        for (int i = 0; i < 6; i++) {
            operations.add(docOperation("id-" + i, 100));
        }
        final var maxSize = 2 * operationSize(operations.get(0), mapper) + 1;

        // The operations of the first request are rejected with a 429 the first time they are sent.
        // Only a few operations are rejected: retries that are not yet sendable occupy the buffer and
        // could otherwise block all retry threads.
        final var rejectedIds = Set.of("id-0", "id-1");
        final var attempts = new ConcurrentHashMap<String, AtomicInteger>();
        final var transport = new TestTransport();
        transport.itemProvider = op -> {
            final var id = op.index().id();
            final var attempt = attempts.computeIfAbsent(id, k -> new AtomicInteger()).getAndIncrement();
            if (rejectedIds.contains(id) && attempt == 0) {
                return BulkResponseItem.of(
                    i -> i.index("foo")
                        .id(id)
                        .status(429)
                        .operationType(OperationType.Index)
                        .error(e -> e.type("es_rejected_execution_exception").reason("rejected"))
                );
            }
            return BulkResponseItem.of(i -> i.index("foo").id(id).status(201).operationType(OperationType.Index));
        };

        final var ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                .maxOperations(-1)
                .maxSize(maxSize)
                .strictMaxSize(true)
                .backoffPolicy(BackoffPolicy.constantBackoff(10L, 3))
        );
        operations.forEach(ingester::add);
        ingester.close();
        transport.close();

        // Rejected operations were sent twice, the others once
        assertEquals(8, transport.operations.get());
        attempts.forEach((id, count) -> assertEquals(id, rejectedIds.contains(id) ? 2 : 1, count.get()));
        assertRequestsWithinMaxSize(transport.requests, maxSize, mapper);
    }

    /**
     * Waits for the periodic flusher to have emitted {@code expected} requests. Tests that add operations
     * spaced apart in time cannot rely on sleeping longer than the flush interval: under load two operations
     * can land in the same flush window, which coalesces them into a single request.
     */
    private static void awaitRequestCount(BulkIngester<?> ingester, long expected) throws InterruptedException {
        long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
        while (ingester.requestCount() < expected) {
            if (System.nanoTime() - deadline > 0) {
                fail("Timed out waiting for " + expected + " requests, got " + ingester.requestCount());
            }
            Thread.sleep(5);
        }
    }

    @Test
    public void periodicFlushTest() throws Exception {
        TestTransport transport = new TestTransport();

        BulkIngester<?> ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                // Flush every 50 ms
                .flushInterval(50, TimeUnit.MILLISECONDS)
                // Disable other flushing limits
                .maxSize(-1)
                .maxOperations(-1)
                .maxConcurrentRequests(Integer.MAX_VALUE - 1)
        );

        // Add an operation at a time, waiting for the flushing timer to kick in
        // before adding the next one so that each gets its own request.
        for (int i = 0; i < 10; i++) {
            ingester.add(operation);
            awaitRequestCount(ingester, i + 1);
        }

        ingester.close();
        transport.close();

        // We should have one operation per request
        assertEquals(10, ingester.operationsCount());
        assertEquals(10, ingester.requestCount());
    }

    @Test
    public void failingListener() throws Exception {
        TestTransport transport = new TestTransport();
        AtomicInteger failureCount = new AtomicInteger();
        AtomicReference<List<Void>> lastContexts = new AtomicReference<>();
        AtomicReference<BulkRequest> lastRequest = new AtomicReference<>();

        BulkListener<Void> listener = new BulkListener<Void>() {
            @Override
            public void beforeBulk(long executionId, BulkRequest request, List<Void> contexts) {
                // So that we can test that it's non-empty
                lastContexts.set(contexts);
                lastRequest.set(request);

                if (executionId == 1) {
                    // Fail before the request is sent
                    failureCount.incrementAndGet();
                    throw new RuntimeException("Before bulk failure");
                }
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, List<Void> contexts, BulkResponse response) {
                if (executionId == 2) {
                    // Fail after the request is sent
                    failureCount.incrementAndGet();
                    throw new RuntimeException("After bulk failure");
                }
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, List<Void> contexts, Throwable failure) {

            }
        };

        BulkIngester<Void> ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                // Flush every 50 ms
                .flushInterval(50, TimeUnit.MILLISECONDS)
                // Disable other flushing limits
                .maxSize(-1)
                .maxOperations(-1)
                .maxConcurrentRequests(Integer.MAX_VALUE - 1)
                .listener(listener)
        );

        // Add an operation at a time, waiting for the flushing timer to kick in
        // before adding the next one so that each gets its own request.
        for (int i = 0; i < 10; i++) {
            ingester.add(operation);
            awaitRequestCount(ingester, i + 1);
        }

        ingester.close();
        transport.close();

        // We should have one operation per request
        assertEquals(10, ingester.operationsCount());
        assertEquals(10, ingester.requestCount());
        // Transport hasn't seen the request where beforeBulk failed
        assertEquals(9, transport.requestsStarted.get());

        assertEquals(2, failureCount.get());

        // Also test context list when no values were provided
        assertTrue(lastRequest.get().operations().size() > 0);
        assertEquals(lastRequest.get().operations().size(), lastContexts.get().size());
    }

    @Test
    public void withContextValues() throws Exception {
        TestTransport transport = new TestTransport();
        List<BulkRequest> allRequests = Collections.synchronizedList(new ArrayList<>());
        List<List<Integer>> allContexts = Collections.synchronizedList(new ArrayList<>());

        BulkListener<Integer> listener = new BulkListener<Integer>() {
            @Override
            public void beforeBulk(long executionId, BulkRequest request, List<Integer> contexts) {
                allRequests.add(request);
                allContexts.add(contexts);
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, List<Integer> contexts, BulkResponse response) {}

            @Override
            public void afterBulk(long executionId, BulkRequest request, List<Integer> contexts, Throwable failure) {}
        };

        BulkIngester<Integer> ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport))
                // Split every 10 operations
                .maxOperations(10)
                .listener(listener)
        );

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Set a context only after 5, so that we test filling with nulls.
                Integer context = j < 5 ? null : i * 10 + j;
                ingester.add(operation, context);
            }
        }

        ingester.close();
        transport.close();

        // We should have 10 operations per request
        assertEquals(100, ingester.operationsCount());
        assertEquals(10, ingester.requestCount());

        for (int i = 0; i < 10; i++) {
            List<Integer> contexts = allContexts.get(i);
            for (int j = 0; j < 10; j++) {
                if (j < 5) {
                    assertNull(contexts.get(j));
                } else {
                    assertEquals(Integer.valueOf(i * 10 + j), contexts.get(j));
                }
            }
        }
    }

    @Test
    public void testGlobalSettings() throws Exception {
        AtomicReference<BulkRequest> storedRequest = new AtomicReference<>();

        TestTransport transport = new TestTransport();
        CountingListener listener = new CountingListener() {
            @Override
            public void beforeBulk(long executionId, BulkRequest request, List<Void> contexts) {
                super.beforeBulk(executionId, request, contexts);
                storedRequest.set(request);
            }
        };

        BulkIngester<Void> ingester = BulkIngester.of(
            b -> b.client(new OpenSearchAsyncClient(transport)).listener(listener).globalSettings(s -> s.index("foo").routing("bar"))
        );

        ingester.add(operation);

        ingester.close();
        transport.close();

        assertEquals(1, ingester.operationsCount());
        assertEquals(1, ingester.requestCount());

        assertEquals("foo", storedRequest.get().index());
        assertEquals("bar", storedRequest.get().routing());
    }

    @Test
    public void pipelineTest() {
        String json = "{\"create\":{\"_id\":\"some_id\",\"_index\":\"some_idx\",\"pipeline\":\"pipe\",\"require_alias\":true}}";
        JsonpMapper mapper = new JacksonJsonpMapper();

        BulkOperation create = BulkOperation.of(
            o -> o.create(c -> c.pipeline("pipe").requireAlias(true).index("some_idx").id("some_id").document("Some doc"))
        );

        String createStr = toJsonString(create, mapper);
        assertEquals(json, createStr);

        BulkOperation create1 = IngesterOperation.of(new RetryableBulkOperation<>(create, null, null), mapper)
            .repeatableOperation()
            .operation();

        String create1Str = toJsonString(create1, mapper);
        assertEquals(json, create1Str);
    }

    // Note: endToEndTest has been moved to AbstractBulkIngesterIT
    // See: java-client/src/test/java11/org/opensearch/client/opensearch/integTest/AbstractBulkIngesterIT.java

    @Test
    public void testConfigValidation() {

        BulkIngester.Builder<Void> b = new BulkIngester.Builder<>();

        try {
            b.flushInterval(-1, TimeUnit.MILLISECONDS);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }

        try {
            b.maxConcurrentRequests(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }

        try {
            b.maxSize(-2);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }

        try {
            b.maxOperations(-2);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }

        try {
            b.maxSize(-1).maxOperations(-1).build();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            // Expected
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    private static class CountingListener implements BulkListener<Void> {
        public final AtomicInteger operations = new AtomicInteger();
        public final AtomicInteger requests = new AtomicInteger();

        @Override
        public void beforeBulk(long executionId, BulkRequest request, List<Void> contexts) {

        }

        @Override
        public void afterBulk(long executionId, BulkRequest request, List<Void> contexts, BulkResponse response) {
            operations.addAndGet(request.operations().size());
            requests.incrementAndGet();
        }

        @Override
        public void afterBulk(long executionId, BulkRequest request, List<Void> contexts, Throwable failure) {
            failure.printStackTrace();
            operations.addAndGet(request.operations().size());
            requests.incrementAndGet();
        }
    }

    private static class TestTransport implements OpenSearchTransport {
        public final AtomicInteger requestsStarted = new AtomicInteger();
        public final AtomicInteger requestsCompleted = new AtomicInteger();
        public final AtomicInteger operations = new AtomicInteger();
        public final List<BulkRequest> requests = Collections.synchronizedList(new ArrayList<>());

        // Optional: creates the response item for an operation, defaults to a successful item
        public volatile Function<BulkOperation, BulkResponseItem> itemProvider = op -> successItem;
        // Optional: responses are only completed once this latch is released
        public volatile CountDownLatch responseGate = null;

        private final ExecutorService executor = Executors.newCachedThreadPool();

        @Override
        public <RequestT, ResponseT, ErrorT> ResponseT performRequest(
            RequestT request,
            Endpoint<RequestT, ResponseT, ErrorT> endpoint,
            @Nullable TransportOptions options
        ) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override
        public <RequestT, ResponseT, ErrorT> CompletableFuture<ResponseT> performRequestAsync(
            RequestT request,
            Endpoint<RequestT, ResponseT, ErrorT> endpoint,
            @Nullable TransportOptions options
        ) {

            BulkRequest bulk = (BulkRequest) request;
            requests.add(bulk);
            requestsStarted.incrementAndGet();
            operations.addAndGet(bulk.operations().size());

            if (bulk.operations().size() == 0) {
                System.out.println("No operations!");
            }

            List<BulkResponseItem> items = new ArrayList<>();
            for (BulkOperation op : bulk.operations()) {
                items.add(itemProvider.apply(op));
            }

            CompletableFuture<BulkResponse> response = new CompletableFuture<>();
            final var gate = responseGate;
            executor.submit(() -> {
                if (gate != null) {
                    try {
                        gate.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                requestsCompleted.incrementAndGet();
                response.complete(BulkResponse.of(r -> r.errors(false).items(items).took(3)));
            });

            @SuppressWarnings("unchecked")
            CompletableFuture<ResponseT> result = (CompletableFuture<ResponseT>) response;
            return result;
        }

        @Override
        public JsonpMapper jsonpMapper() {
            return new JacksonJsonpMapper();
        }

        @Override
        public TransportOptions options() {
            return null;
        }

        @Override
        public void close() throws IOException {
            executor.shutdown();
            try {
                executor.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Serializes an object to a JSON string.
     *
     * @param value the object to serialize
     * @param mapper the JSON mapper to use for serialization
     * @return the JSON string representation
     */
    public static String toJsonString(Object value, JsonpMapper mapper) {
        java.io.StringWriter writer = new java.io.StringWriter();
        JsonGenerator generator = mapper.jsonProvider().createGenerator(writer);
        mapper.serialize(value, generator);
        generator.close();
        return writer.toString();
    }

    private boolean isGithubBuild() {
        return Optional.ofNullable(System.getenv("GITHUB_JOB")).isPresent();
    }
}
