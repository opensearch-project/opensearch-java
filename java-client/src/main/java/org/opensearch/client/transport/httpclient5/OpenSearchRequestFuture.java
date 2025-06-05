/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import java.util.concurrent.CompletableFuture;
import org.opensearch.client.transport.client_metrics.RequestMetricContext;

public class OpenSearchRequestFuture<T> extends CompletableFuture<T> {
    private final RequestMetricContext context = new RequestMetricContext();

    public RequestMetricContext getContext() {
        return context;
    }
}
