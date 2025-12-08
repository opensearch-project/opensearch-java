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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.core.bulk.OperationType;
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

    @Test
    @Ignore("Requires OpenSearchTestServer - should be moved to integration tests")
    public void multiThreadStressTest() throws InterruptedException, IOException {
        // This test requires OpenSearchTestServer which is not available in unit tests
        // TODO: Move to integration test suite
    }

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

        // Add an operation every 100 ms to give time
        // to the flushing timer to kick in.
        for (int i = 0; i < 10; i++) {
            ingester.add(operation);
            Thread.sleep(100);
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

        // Add an operation every 100 ms to give time
        // to the flushing timer to kick in.
        for (int i = 0; i < 10; i++) {
            ingester.add(operation);
            Thread.sleep(100);
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

    private static String toJsonString(BulkOperation operation) {
        try (java.io.StringWriter writer = new java.io.StringWriter()) {
            try (jakarta.json.stream.JsonGenerator generator = JsonpUtils.DEFAULT_JSONP_MAPPER.jsonProvider().createGenerator(writer)) {
                operation.serialize(generator, JsonpUtils.DEFAULT_JSONP_MAPPER);
            }
            return writer.toString();
        } catch (java.io.IOException ex) {
            throw new java.io.UncheckedIOException(ex);
        }
    }

    @Test
    public void pipelineTest() {
        String json = "{\"create\":{\"_id\":\"some_id\",\"_index\":\"some_idx\",\"pipeline\":\"pipe\",\"require_alias\":true}}";
        JsonpMapper mapper = new JacksonJsonpMapper();

        BulkOperation create = BulkOperation.of(
            o -> o.create(c -> c.pipeline("pipe").requireAlias(true).index("some_idx").id("some_id").document("Some doc"))
        );

        String createStr = toJsonString(create);
        assertEquals(json, createStr);

        BulkOperation create1 = IngesterOperation.of(new RetryableBulkOperation<>(create, null, null), mapper)
            .repeatableOperation()
            .operation();

        String create1Str = toJsonString(create1);
        assertEquals(json, create1Str);
    }

    @Test
    @Ignore("Requires OpenSearchTestServer - should be moved to integration tests")
    public void endToEndTest() throws Exception {
        // This test requires OpenSearchTestServer which is not available in unit tests
        // TODO: Move to integration test suite
    }

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
            requestsStarted.incrementAndGet();
            operations.addAndGet(bulk.operations().size());

            if (bulk.operations().size() == 0) {
                System.out.println("No operations!");
            }

            List<BulkResponseItem> items = new ArrayList<>();
            for (int i = 0; i < bulk.operations().size(); i++) {
                items.add(successItem);
            }

            CompletableFuture<BulkResponse> response = new CompletableFuture<>();
            executor.submit(() -> {
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

    private boolean isGithubBuild() {
        return Optional.ofNullable(System.getenv("GITHUB_JOB")).isPresent();
    }
}
