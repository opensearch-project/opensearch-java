/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import java.time.Duration;

public class NetworkRequestMetricContext extends ExecutionMetricContext {
    private String hostName;
    private long responsePayloadSize = -1;
    private long requestPayloadSize = -1;

    public NetworkRequestMetricContext(String hostName, Throwable throwable, int statusCode, Duration executionTime) {
        super(throwable, statusCode, executionTime);
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public long getResponsePayloadSize() {
        return responsePayloadSize;
    }

    public void setResponsePayloadSize(long responsePayloadSize) {
        this.responsePayloadSize = responsePayloadSize;
    }

    public long getRequestPayloadSize() {
        return requestPayloadSize;
    }

    public void setRequestPayloadSize(long requestPayloadSize) {
        this.requestPayloadSize = requestPayloadSize;
    }
}
