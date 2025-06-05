/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import java.time.Duration;

/**
 * Contains necessary information about a request execution to be used for metric recordings.
 */
public abstract class ExecutionMetricContext {

    public static final int DEFAULT_EMPTY_STATUS_CODE = -1;
    private Throwable throwable = null;
    private int statusCode = DEFAULT_EMPTY_STATUS_CODE;
    private Duration executionTime = null;

    protected ExecutionMetricContext() {}

    protected ExecutionMetricContext(Throwable throwable, int statusCode, Duration executionTime) {
        this.throwable = throwable;
        this.statusCode = statusCode;
        this.executionTime = executionTime;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Duration getRequestExecutionTime() {
        return executionTime;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setRequestExecutionTime(Duration executionTime) {
        this.executionTime = executionTime;
    }
}
