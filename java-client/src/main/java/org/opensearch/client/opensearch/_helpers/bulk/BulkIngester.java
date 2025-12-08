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
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.transport.BackoffPolicy;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

/**
 * A bulk ingester for efficiently indexing large volumes of documents to OpenSearch.
 * <p>
 * The BulkIngester buffers bulk operations and automatically flushes them based on configurable thresholds:
 * <ul>
 *   <li>Number of operations (maxOperations)</li>
 *   <li>Total size in bytes (maxSize)</li>
 *   <li>Time interval (flushInterval)</li>
 * </ul>
 * <p>
 * It also provides:
 * <ul>
 *   <li>Backpressure control via maxConcurrentRequests to prevent overwhelming the cluster</li>
 *   <li>Automatic retries with configurable backoff policies for failed operations</li>
 *   <li>Per-request context tracking via the optional Context type parameter</li>
 *   <li>Event notifications through the {@link BulkListener} interface</li>
 * </ul>
 * <p>
 * The ingester is thread-safe and can be used concurrently from multiple threads. It must be closed
 * when no longer needed to flush any buffered operations and release resources.
 * <p>
 * Example usage:
 * <pre>{@code
 * BulkIngester<Void> ingester = BulkIngester.of(b -> b
 *     .client(client)
 *     .maxOperations(1000)
 *     .flushInterval(5, TimeUnit.SECONDS)
 * );
 *
 * // Add operations
 * ingester.add(op -> op.index(i -> i.index("my-index").id("1").document(myDoc)));
 *
 * // Close when done (flushes remaining operations)
 * ingester.close();
 * }</pre>
 *
 * @param <Context> optional context type to associate with each bulk operation
 */
public class BulkIngester<Context> implements AutoCloseable {

    private static final Log logger = LogFactory.getLog(BulkIngester.class);

    // Instance counter, to name the flush thread if we create one
    private static final AtomicInteger idCounter = new AtomicInteger();

    // Configuration
    private final OpenSearchAsyncClient client;
    private final @Nullable BulkRequest globalSettings;
    private final int maxRequests;
    private final long maxSize;
    private final int maxOperations;
    private final @Nullable BulkListener<Context> listener;
    private final Long flushIntervalMillis;

    private @Nullable ScheduledFuture<?> flushTask;
    private @Nullable ScheduledExecutorService scheduler;
    private @Nullable ScheduledExecutorService retryScheduler;
    private boolean isExternalScheduler = false;
    private BackoffPolicy backoffPolicy;

    // Current state
    private List<RetryableBulkOperation<Context>> operations = new ArrayList<>();
    private long currentSize;
    private int requestsInFlightCount;
    private volatile boolean isClosed = false;

    // Synchronization objects
    private final ReentrantLock lock = new ReentrantLock();
    private final FnCondition addCondition = new FnCondition(lock, this::canAddOperation);
    private final FnCondition sendRequestCondition = new FnCondition(lock, this::canSendRequest);
    private final FnCondition closeCondition = new FnCondition(lock, this::closedAndFlushed);
    private final AtomicInteger listenerInProgressCount = new AtomicInteger();
    private final AtomicInteger retriesInProgressCount = new AtomicInteger();

    private static class RequestExecution<Context> {
        public final long id;
        public final BulkRequest request;
        public final List<Context> contexts;
        public final CompletionStage<BulkResponse> futureResponse;

        RequestExecution(long id, BulkRequest request, List<Context> contexts, CompletionStage<BulkResponse> futureResponse) {
            this.id = id;
            this.request = request;
            this.contexts = contexts;
            this.futureResponse = futureResponse;
        }
    }

    private BulkIngester(Builder<Context> builder) {
        int ingesterId = idCounter.incrementAndGet();
        this.client = ApiTypeHelper.requireNonNull(builder.client, this, "client");
        this.globalSettings = builder.globalSettings;
        this.maxRequests = builder.maxConcurrentRequests;
        this.maxSize = builder.bulkSize < 0 ? Long.MAX_VALUE : builder.bulkSize;
        this.maxOperations = builder.bulkOperations < 0 ? Integer.MAX_VALUE : builder.bulkOperations;
        this.listener = builder.listener;
        this.backoffPolicy = builder.backoffPolicy;
        this.flushIntervalMillis = builder.flushIntervalMillis;

        if (flushIntervalMillis != null || listener != null) {
            // Create a scheduler if needed
            if (builder.scheduler == null) {
                this.scheduler = Executors.newScheduledThreadPool(maxRequests + 1, (r) -> {
                    Thread t = Executors.defaultThreadFactory().newThread(r);
                    t.setName("bulk-ingester-executor#" + ingesterId + "#" + t.getId());
                    t.setDaemon(true);
                    return t;
                });
            } else {
                // It's not ours, we will not close it.
                this.scheduler = builder.scheduler;
                this.isExternalScheduler = true;
            }
        }

        if (flushIntervalMillis != null) {
            long flushInterval = flushIntervalMillis;
            this.flushTask = scheduler.scheduleWithFixedDelay(this::failsafeFlush, flushInterval, flushInterval, TimeUnit.MILLISECONDS);
        }

        if (backoffPolicy == null) {
            backoffPolicy = BackoffPolicy.noBackoff();
        }
        // preparing a scheduler that will trigger flushes to retry failed requests
        else {
            retryScheduler = Executors.newScheduledThreadPool(maxRequests + 1, (r) -> {
                Thread t = Executors.defaultThreadFactory().newThread(r);
                t.setName("bulk-ingester-retry#" + ingesterId + "#" + t.getId());
                t.setDaemon(true);
                return t;
            });
        }
    }

    // ----- Getters

    /**
     * The configured max operations to buffer in a single bulk request.
     */
    public int maxOperations() {
        return this.maxOperations;
    }

    /**
     * The configured maximum size in bytes for a bulk request. Operations are added to the request until
     * adding an operation leads the request to exceed this size.
     */
    public long maxSize() {
        return this.maxSize;
    }

    /**
     * The configured maximum number of concurrent request sent to OpenSearch.
     */
    public int maxConcurrentRequests() {
        return this.maxRequests;
    }

    /**
     * The configured flush period.
     */
    public Duration flushInterval() {
        if (this.flushIntervalMillis != null) {
            return Duration.ofMillis(flushIntervalMillis);
        } else {
            return null;
        }
    }

    /**
     * The number of operations that have been buffered, waiting to be sent.
     */
    public int pendingOperations() {
        List<RetryableBulkOperation<Context>> operations = this.operations;
        return operations == null ? 0 : operations.size();
    }

    /**
     * The size in bytes of operations that have been buffered, waiting to be sent.
     */
    public long pendingOperationsSize() {
        return this.currentSize;
    }

    /**
     * The number of in flight bulk requests.
     */
    public int pendingRequests() {
        return this.requestsInFlightCount;
    }

    // ----- Statistics

    /**
     * Statistics: the number of operations that were added to this ingester since it was created.
     */
    public long operationsCount() {
        return this.addCondition.invocations();
    }

    /**
     * Statistics: the number of operations that had to wait before being added because the operation buffer
     * was full and the number of http requests in flight exceeded the configured maximum number.
     *
     * @see Builder#maxConcurrentRequests
     * @see Builder#maxOperations
     * @see Builder#maxSize
     */
    public long operationContentionsCount() {
        return this.addCondition.contentions();
    }

    /**
     * Statistics: the number of bulk requests that were produced by this ingester since it was created.
     */
    public long requestCount() {
        return this.sendRequestCondition.invocations();
    }

    /**
     * Statistics: the number of bulk requests that could not be sent immediately because the number of
     * http requests in flight exceeded the configured maximum number.
     *
     * @see Builder#maxConcurrentRequests
     */
    public long requestContentionsCount() {
        return this.sendRequestCondition.contentions();
    }

    // ----- Predicates for the condition variables

    private boolean canSendRequest() {
        return requestsInFlightCount < maxRequests;
    }

    private boolean canAddOperation() {
        return currentSize < maxSize && operations.size() < maxOperations;
    }

    private boolean closedAndFlushed() {
        return isClosed
            && operations.isEmpty()
            && requestsInFlightCount == 0
            && listenerInProgressCount.get() == 0
            && retriesInProgressCount.get() == 0;
    }

    // ----- Ingester logic

    private BulkRequest.Builder newRequest() {
        BulkRequest.Builder result = new BulkRequest.Builder();

        if (this.globalSettings != null) {
            BulkRequest settings = this.globalSettings;
            result.index(settings.index())
                .pipeline(settings.pipeline())
                .refresh(settings.refresh())
                .requireAlias(settings.requireAlias())
                .routing(settings.routing())
                .sourceExcludes(settings.sourceExcludes())
                .sourceIncludes(settings.sourceIncludes())
                .source(settings.source())
                .timeout(settings.timeout())
                .waitForActiveShards(settings.waitForActiveShards());
        }

        return result;
    }

    private void failsafeFlush() {
        try {
            flush();
        } catch (Throwable thr) {
            // Log the error and continue
            logger.error("Error in background flush", thr);
        }
    }

    /**
     * Manually flush any buffered operations, sending them to OpenSearch immediately.
     * <p>
     * This method is non-blocking and returns immediately. Flushing happens asynchronously,
     * subject to the maxConcurrentRequests limit. Operations that are scheduled for retry
     * will only be sent once their retry delay has elapsed.
     * <p>
     * This method is useful when you want to ensure operations are sent without waiting for
     * automatic flush triggers (maxOperations, maxSize, or flushInterval).
     */
    public void flush() {
        List<RetryableBulkOperation<Context>> sentRequests = new ArrayList<>();
        RequestExecution<Context> exec = sendRequestCondition.whenReadyIf(() -> {
            // May happen on manual and periodic flushes
            return !operations.isEmpty() && operations.stream().anyMatch(RetryableBulkOperation::isSendable);
        }, () -> {
            // Selecting operations that can be sent immediately,
            // Dividing actual operations from contexts
            List<BulkOperation> immediateOps = new ArrayList<>();
            List<Context> contexts = new ArrayList<>();

            for (Iterator<RetryableBulkOperation<Context>> it = operations.iterator(); it.hasNext();) {
                RetryableBulkOperation<Context> op = it.next();
                if (op.isSendable()) {
                    immediateOps.add(op.operation());
                    contexts.add(op.context());

                    sentRequests.add(op);
                    it.remove();
                }
            }

            // Build the request
            BulkRequest request = newRequest().operations(immediateOps).build();

            // Prepare for next round
            currentSize = operations.size();
            addCondition.signalIfReady();

            long id = sendRequestCondition.invocations();

            if (listener != null) {
                // synchronous execution to make sure it actually runs before
                listener.beforeBulk(id, request, contexts);
            }

            CompletionStage<BulkResponse> result;
            try {
                result = client.bulk(request);
            } catch (IOException e) {
                // Convert IOException to a failed CompletionStage
                result = CompletableFuture.failedFuture(e);
            }
            requestsInFlightCount++;

            if (listener == null) {
                // No need to keep the request around, it can be GC'ed
                request = null;
            }

            return new RequestExecution<>(id, request, contexts, result);
        });

        if (exec != null) {
            // A request was actually sent
            exec.futureResponse.handle((resp, thr) -> {
                if (resp != null) {

                    // Success? Checking if total or partial
                    List<BulkResponseItem> failedRequestsCanRetry = resp.items()
                        .stream()
                        .filter(i -> i.error() != null && i.status() == 429)
                        .collect(Collectors.toList());

                    if (failedRequestsCanRetry.isEmpty() || backoffPolicy.equals(BackoffPolicy.noBackoff())) {
                        // Total success! ...or there's no retry policy implemented. Either way, can call
                        listenerAfterBulkSuccess(resp, exec);
                    } else {
                        // Partial success, retrying failed requests if policy allows it
                        // Keeping list of retryable requests/responses, to exclude them for calling
                        // listener later
                        List<RetryableBulkOperation<Context>> retryableReq = new ArrayList<>();
                        List<RetryableBulkOperation<Context>> refires = new ArrayList<>();
                        List<BulkResponseItem> retryableResp = new ArrayList<>();

                        for (BulkResponseItem bulkItemResponse : failedRequestsCanRetry) {
                            int index = resp.items().indexOf(bulkItemResponse);
                            selectingRetries(index, bulkItemResponse, sentRequests, retryableResp, retryableReq, refires);
                        }
                        // Scheduling flushes for just sent out retryable requests
                        if (!refires.isEmpty()) {
                            scheduleRetries(refires);
                        }
                        // Retrieving list of remaining successful or not retryable requests
                        retryableReq.forEach(sentRequests::remove);
                        if (!sentRequests.isEmpty()) {
                            if (listener != null) {
                                // Creating partial BulkRequest
                                List<BulkOperation> partialOps = new ArrayList<>();
                                List<Context> partialCtx = new ArrayList<>();
                                for (RetryableBulkOperation<Context> op : sentRequests) {
                                    partialOps.add(op.operation());
                                    partialCtx.add(op.context());
                                }
                                BulkRequest partialRequest = newRequest().operations(partialOps).build();

                                // Filtering response
                                List<BulkResponseItem> partialItems = resp.items()
                                    .stream()
                                    .filter(i -> !retryableResp.contains(i))
                                    .collect(Collectors.toList());

                                BulkResponse partialResp = BulkResponse.of(
                                    br -> br.items(partialItems).errors(resp.errors()).took(resp.took()).ingestTook(resp.ingestTook())
                                );

                                listenerInProgressCount.incrementAndGet();
                                scheduler.submit(() -> {
                                    try {
                                        listener.afterBulk(exec.id, partialRequest, partialCtx, partialResp);
                                    } finally {
                                        if (listenerInProgressCount.decrementAndGet() == 0) {
                                            closeCondition.signalIfReady();
                                        }
                                    }
                                });
                            }
                        }

                    }
                } else {
                    // Failure
                    listenerAfterBulkException(thr, exec);
                }

                sendRequestCondition.signalIfReadyAfter(() -> {
                    requestsInFlightCount--;
                    closeCondition.signalAllIfReady();
                });
                return null;
            });
        }
    }

    private void selectingRetries(
        int index,
        BulkResponseItem bulkItemResponse,
        List<RetryableBulkOperation<Context>> sentRequests,
        List<BulkResponseItem> retryableResp,
        List<RetryableBulkOperation<Context>> retryableReq,
        List<RetryableBulkOperation<Context>> refires
    ) {

        // Getting original failed, requests and keeping successful ones to send to the listener
        RetryableBulkOperation<Context> original = sentRequests.get(index);
        if (original.canRetry()) {
            retryableResp.add(bulkItemResponse);
            Iterator<Long> retryTimes = Optional.ofNullable(original.retries()).orElse(backoffPolicy.iterator());
            RetryableBulkOperation<Context> refire = new RetryableBulkOperation<>(original.operation(), original.context(), retryTimes);
            retryableReq.add(original);
            refires.add(refire);
            addRetry(refire);
            logger.warn("Added failed request back in queue, retrying in : " + refire.currentRetryTimeDelay() + " ms");
        } else {
            logger.warn("Retries finished for request: " + original.operation()._kind().toString());
        }
    }

    private void listenerAfterBulkException(Throwable thr, RequestExecution<Context> exec) {
        if (listener != null) {
            listenerInProgressCount.incrementAndGet();
            scheduler.submit(() -> {
                try {
                    listener.afterBulk(exec.id, exec.request, exec.contexts, thr);
                } finally {
                    if (listenerInProgressCount.decrementAndGet() == 0) {
                        closeCondition.signalIfReady();
                    }
                }
            });
        }
    }

    private void listenerAfterBulkSuccess(BulkResponse resp, RequestExecution<Context> exec) {
        if (listener != null) {
            listenerInProgressCount.incrementAndGet();
            scheduler.submit(() -> {
                try {
                    listener.afterBulk(exec.id, exec.request, exec.contexts, resp);
                } finally {
                    if (listenerInProgressCount.decrementAndGet() == 0) {
                        closeCondition.signalIfReady();
                    }
                }
            });
        }
    }

    private void scheduleRetries(List<RetryableBulkOperation<Context>> retryableReq) {
        LongSummaryStatistics statsDelays = retryableReq.stream()
            .map(RetryableBulkOperation::currentRetryTimeDelay)
            .mapToLong(Long::longValue)
            .summaryStatistics();

        // scheduling earlier and latest delay
        retryScheduler.schedule(this::flush, statsDelays.getMin(), TimeUnit.MILLISECONDS);
        retryScheduler.schedule(this::flush, statsDelays.getMax(), TimeUnit.MILLISECONDS);

    }

    /**
     * Add a bulk operation to the ingester with an associated context.
     * <p>
     * The operation will be buffered and sent to OpenSearch when any of the configured
     * flush thresholds is reached (maxOperations, maxSize, or flushInterval), or when
     * {@link #flush()} or {@link #close()} is called.
     * <p>
     * This method blocks if adding the operation would exceed the maxConcurrentRequests limit,
     * providing backpressure to prevent overwhelming the cluster.
     *
     * @param operation the bulk operation to add
     * @param context   optional context to associate with this operation for tracking purposes
     * @throws IllegalStateException if the ingester has been closed
     */
    public void add(BulkOperation operation, Context context) {
        if (isClosed) {
            throw new IllegalStateException("Ingester has been closed");
        }

        RetryableBulkOperation<Context> repeatableOp = new RetryableBulkOperation<>(operation, context, null);

        innerAdd(repeatableOp);
    }

    // Same as "add", but skips the closed check to allow retries to be added even after ingester closure
    private void addRetry(RetryableBulkOperation<Context> repeatableOp) {
        // Sending the operation back in the queue using the retry scheduler
        retriesInProgressCount.incrementAndGet();
        retryScheduler.submit(() -> {
            try {
                innerAdd(repeatableOp);
            } finally {
                if (retriesInProgressCount.decrementAndGet() == 0) {
                    closeCondition.signalIfReady();
                }
            }
        });
    }

    private void innerAdd(RetryableBulkOperation<Context> repeatableOp) {
        IngesterOperation ingestOp = IngesterOperation.of(repeatableOp, client._transport().jsonpMapper());

        addCondition.whenReady(() -> {
            operations.add(ingestOp.repeatableOperation());
            currentSize += ingestOp.size();

            if (!canAddOperation()) {
                flush();
            } else {
                addCondition.signalIfReady();
            }
        });
    }

    /**
     * Add a bulk operation to the ingester without an associated context.
     * <p>
     * Equivalent to calling {@code add(operation, null)}.
     *
     * @param operation the bulk operation to add
     * @throws IllegalStateException if the ingester has been closed
     * @see #add(BulkOperation, Object)
     */
    public void add(BulkOperation operation) {
        add(operation, null);
    }

    /**
     * Add a bulk operation to the ingester using a builder function, without an associated context.
     * <p>
     * This is a convenience method that accepts a function to build the bulk operation inline.
     *
     * @param f the function to build the bulk operation
     * @throws IllegalStateException if the ingester has been closed
     * @see #add(BulkOperation)
     */
    public void add(Function<BulkOperation.Builder, ObjectBuilder<BulkOperation>> f) {
        add(f.apply(new BulkOperation.Builder()).build(), null);
    }

    /**
     * Add a bulk operation to the ingester using a builder function, with an associated context.
     * <p>
     * This is a convenience method that accepts a function to build the bulk operation inline.
     *
     * @param f       the function to build the bulk operation
     * @param context optional context to associate with this operation for tracking purposes
     * @throws IllegalStateException if the ingester has been closed
     * @see #add(BulkOperation, Object)
     */
    public void add(Function<BulkOperation.Builder, ObjectBuilder<BulkOperation>> f, Context context) {
        add(f.apply(new BulkOperation.Builder()).build(), context);
    }

    /**
     * Close this ingester, first flushing any buffered operations. This <strong>does not close</strong>
     * the underlying {@link OpenSearchClient} and {@link org.opensearch.client.transport.Transport}.
     */
    @Override
    public void close() {
        if (isClosed) {
            return;
        }

        isClosed = true;
        // Flush buffered operations
        flush();
        // and wait for all requests to be completed
        closeCondition.whenReady(() -> {});

        if (flushTask != null) {
            flushTask.cancel(false);
        }

        if (scheduler != null && !isExternalScheduler) {
            scheduler.shutdownNow();
        }

        if (retryScheduler != null) {
            retryScheduler.shutdownNow();
        }
    }

    // ----------------------------------------------------------------------------------------------------

    public static <Context> BulkIngester<Context> of(Function<Builder<Context>, Builder<Context>> f) {
        return f.apply(new Builder<>()).build();
    }

    public static class Builder<Context> implements ObjectBuilder<BulkIngester<Context>> {
        private OpenSearchAsyncClient client;
        private BulkRequest globalSettings;
        private int bulkOperations = 1000;
        private long bulkSize = 5 * 1024 * 1024;
        private int maxConcurrentRequests = 1;
        private Long flushIntervalMillis;
        private BulkListener<Context> listener;
        private ScheduledExecutorService scheduler;
        private BackoffPolicy backoffPolicy;

        public Builder<Context> client(OpenSearchAsyncClient client) {
            this.client = client;
            return this;
        }

        public Builder<Context> client(OpenSearchClient client) {
            TransportOptions options = client._transportOptions();
            if (options == client._transport().options()) {
                options = null;
            }
            return client(new OpenSearchAsyncClient(client._transport(), options));
        }

        /**
         * Sets when to flush a new bulk request based on the number of operations currently added.
         * Defaults to
         * {@code 1000}. Can be set to {@code -1} to disable it.
         *
         * @throws IllegalArgumentException if less than -1.
         */
        public Builder<Context> maxOperations(int count) {
            if (count < -1) {
                throw new IllegalArgumentException("Max operations should be at least -1");
            }
            this.bulkOperations = count;
            return this;
        }

        /**
         * Sets when to flush a new bulk request based on the size in bytes of actions currently added. A
         * request is sent
         * once that size has been exceeded. Defaults to 5 megabytes. Can be set to {@code -1} to disable it.
         *
         * @throws IllegalArgumentException if less than -1.
         */
        public Builder<Context> maxSize(long bytes) {
            if (bytes < -1) {
                throw new IllegalArgumentException("Max size should be at least -1");
            }
            this.bulkSize = bytes;
            return this;
        }

        /**
         * Sets the number of concurrent requests allowed to be executed. A value of 1 means 1 request is
         * allowed to be executed
         * while accumulating new bulk requests. Defaults to {@code 1}.
         *
         * @throws IllegalArgumentException if less than 1.
         */
        public Builder<Context> maxConcurrentRequests(int max) {
            if (max < 1) {
                throw new IllegalArgumentException("Max concurrent request should be at least 1");
            }
            this.maxConcurrentRequests = max;
            return this;
        }

        /**
         * Sets an interval flushing any bulk actions pending if the interval passes. Defaults to not set.
         * <p>
         * Flushing is still subject to the maximum number of requests set with
         * {@link #maxConcurrentRequests}.
         *
         * @throws IllegalArgumentException if not a positive duration.
         */
        public Builder<Context> flushInterval(long value, TimeUnit unit) {
            if (value < 0) {
                throw new IllegalArgumentException("Duration should be positive");
            }
            this.flushIntervalMillis = unit.toMillis(value);
            return this;
        }

        /**
         * Sets an interval flushing any bulk actions pending if the interval passes. Defaults to not set.
         * <p>
         * Flushing is still subject to the maximum number of requests set with
         * {@link #maxConcurrentRequests}.
         *
         * @deprecated use {@link #scheduler(ScheduledExecutorService)}
         */
        @Deprecated
        public Builder<Context> flushInterval(long value, TimeUnit unit, ScheduledExecutorService scheduler) {
            this.scheduler = scheduler;
            return flushInterval(value, unit);
        }

        /**
         * Sets a custom scheduler to run the flush thread and the listener logic. A default one is used if
         * not set.
         */
        public Builder<Context> scheduler(ScheduledExecutorService scheduler) {
            this.scheduler = scheduler;
            return this;
        }

        public Builder<Context> listener(BulkListener<Context> listener) {
            this.listener = listener;
            return this;
        }

        /**
         * Sets the backoff policy that will handle retries for error 429: too many requests.
         * All the times are defined in milliseconds.
         */
        public Builder<Context> backoffPolicy(BackoffPolicy backoffPolicy) {
            this.backoffPolicy = backoffPolicy;
            return this;
        }

        /**
         * Sets global bulk request settings that will be applied to all requests sent by the ingester.
         */
        public Builder<Context> globalSettings(BulkRequest.Builder settings) {
            if (settings != null) {
                // Set required field
                this.globalSettings = settings.operations(Collections.emptyList()).build();
            } else {
                this.globalSettings = null;
            }
            return this;
        }

        /**
         * Sets global bulk request settings that will be applied to all bulk requests.
         */
        public Builder<Context> globalSettings(Function<BulkRequest.Builder, BulkRequest.Builder> fn) {
            return globalSettings(fn.apply(new BulkRequest.Builder()));
        }

        @Override
        public BulkIngester<Context> build() {
            // Ensure some chunking criteria are defined
            boolean hasCriteria = this.bulkOperations >= 0 || this.bulkSize >= 0 || this.flushIntervalMillis != null;

            if (!hasCriteria) {
                throw new IllegalStateException("No bulk operation chunking criteria have been set.");
            }

            return new BulkIngester<>(this);
        }
    }
}
