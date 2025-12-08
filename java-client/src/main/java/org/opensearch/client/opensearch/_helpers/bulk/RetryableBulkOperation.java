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

import java.util.Iterator;
import java.util.Optional;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;

/**
 * A bulk operation with retry information and optional context.
 * <p>
 * This class wraps a {@link BulkOperation} along with:
 * <ul>
 *   <li>An optional context value for tracking</li>
 *   <li>A retry iterator providing delay values in milliseconds</li>
 *   <li>The calculated time when this operation can be sent (for retries)</li>
 * </ul>
 * <p>
 * This is an internal utility class used by {@link BulkIngester} to manage operation retries
 * with backoff delays.
 *
 * @param <Context> optional context type associated with the operation
 */
class RetryableBulkOperation<Context> {
    private final BulkOperation operation;
    private final Context context;
    private final Iterator<Long> retries;
    private final Long retryTime;

    /**
     * Create a retryable bulk operation.
     *
     * @param request the bulk operation
     * @param context optional context associated with this operation
     * @param retries iterator providing retry delay values in milliseconds, or null if this is not a retry
     */
    RetryableBulkOperation(BulkOperation request, Context context, Iterator<Long> retries) {
        this.operation = request;
        this.context = context;
        this.retries = retries;
        // if the retries iterator is null it means that it's not a retry, otherwise calculating retry time
        long currentMillis = currentMillis();
        this.retryTime = Optional.ofNullable(retries).map(r -> currentMillis + r.next()).orElse(currentMillis);
    }

    /**
     * Get the wrapped bulk operation.
     *
     * @return the bulk operation
     */
    public BulkOperation operation() {
        return operation;
    }

    /**
     * Get the optional context associated with this operation.
     *
     * @return the context, or null if none was provided
     */
    public Context context() {
        return context;
    }

    /**
     * Get the retry iterator providing backoff delay values.
     *
     * @return the retry iterator, or null if this is not a retry
     */
    public Iterator<Long> retries() {
        return retries;
    }

    /**
     * Get the time delay in milliseconds until this operation can be sent.
     *
     * @return the delay in milliseconds (may be negative if the operation is ready to send)
     */
    public long currentRetryTimeDelay() {
        return this.retryTime - currentMillis();
    }

    /**
     * Check if this operation can be retried again after a failure.
     *
     * @return true if more retry attempts are available, false otherwise
     */
    public boolean canRetry() {
        return Optional.ofNullable(retries).map(Iterator::hasNext).orElse(true);
    }

    /**
     * Check if this operation can be sent now (retry delay has elapsed).
     *
     * @return true if the operation can be sent immediately, false if it needs to wait
     */
    public boolean isSendable() {
        return (this.retryTime - currentMillis()) <= 0;
    }

    private Long currentMillis() {
        return System.nanoTime() / 1_000_000L;
    }
}
