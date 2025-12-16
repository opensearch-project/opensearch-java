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

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * A helper to make {@link Condition} easier and less error-prone to use.
 * <p>
 * This utility class wraps a {@link Lock} and {@link Condition} with a readiness predicate,
 * providing a functional interface for executing code when the condition is satisfied.
 * It handles the lock/unlock pattern and waiting on the condition variable automatically.
 * <p>
 * This is an internal utility class used by {@link BulkIngester} for coordinating concurrent operations.
 */
class FnCondition {
    private final Lock lock;
    public final Condition condition;
    private final BooleanSupplier ready;
    private long invocations;
    private long contentions;

    FnCondition(Lock lock, BooleanSupplier ready) {
        this.lock = lock;
        this.condition = lock.newCondition();
        this.ready = ready;
    }

    /**
     * Execute a runnable when the condition becomes ready, blocking if necessary.
     * <p>
     * This method will wait on the condition variable until the readiness predicate returns true,
     * then execute the provided runnable while holding the lock.
     *
     * @param fn the runnable to execute when ready
     */
    public void whenReady(Runnable fn) {
        whenReadyIf(null, () -> {
            fn.run();
            return null;
        });
    }

    /**
     * Execute a function when the condition becomes ready, blocking if necessary.
     * <p>
     * This method will wait on the condition variable until the readiness predicate returns true,
     * then execute the provided function while holding the lock.
     *
     * @param fn the function to execute when ready
     * @param <T> the return type of the function
     * @return the result of the function
     */
    public <T> T whenReady(Supplier<T> fn) {
        return whenReadyIf(null, fn);
    }

    /**
     * Runs a function when the condition variable is ready, after verifying in that it can actually run.
     * <p>
     * {@code canRun} and {@code fn} are executed withing the lock.
     *
     * @param canRun a predicate indicating if {@code fn} is ready to run. If not, returns {@code null} immediately.
     * @param fn the function to run once the condition variable allows it.
     * @return the result of {@code fn}.
     */
    public <T> T whenReadyIf(BooleanSupplier canRun, Supplier<T> fn) {
        lock.lock();
        try {
            if (canRun != null && !canRun.getAsBoolean()) {
                return null;
            }

            invocations++;
            boolean firstLoop = true;
            while (!ready.getAsBoolean()) {
                if (firstLoop) {
                    contentions++;
                    firstLoop = false;
                }
                condition.awaitUninterruptibly();
            }

            if (canRun != null && !canRun.getAsBoolean()) {
                return null;
            }

            return fn.get();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Signal one waiting thread if the condition is ready.
     * <p>
     * This method checks if the readiness predicate is true, and if so, signals one thread
     * waiting on the condition variable.
     */
    public void signalIfReady() {
        lock.lock();
        try {
            if (ready.getAsBoolean()) {
                this.condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Signal all waiting threads if the condition is ready.
     * <p>
     * This method checks if the readiness predicate is true, and if so, signals all threads
     * waiting on the condition variable.
     */
    public void signalAllIfReady() {
        lock.lock();
        try {
            if (ready.getAsBoolean()) {
                this.condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Execute a runnable and then signal if the condition becomes ready.
     * <p>
     * This method executes the provided runnable while holding the lock, then checks the
     * readiness predicate and signals one waiting thread if ready.
     *
     * @param r the runnable to execute
     */
    public void signalIfReadyAfter(Runnable r) {
        lock.lock();
        try {
            r.run();
            if (ready.getAsBoolean()) {
                this.condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Number of invocations of {@code whenReady}.
     */
    public long invocations() {
        return this.invocations;
    }

    /**
     * Number of invocations of {@code whenReady} that contended and required to wait on the condition variable.
     */
    public long contentions() {
        return this.contentions;
    }
}
