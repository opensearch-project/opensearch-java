package org.opensearch.client.transport.httpclient5;

import java.util.concurrent.CompletableFuture;
import org.opensearch.client.transport.client_metrics.RequestMetricContext;

public class OpenSearchRequestFuture<T> extends CompletableFuture<T> {
    private final RequestMetricContext context = new RequestMetricContext();

    public RequestMetricContext getContext() {
        return context;
    }
}