package org.opensearch.client.transport.client_metrics;

import java.util.ArrayList;
import java.util.List;

public class RequestMetricContext extends ExecutionMetricContext {
    private final List<NetworkRequestMetricContext> networkRequestContexts = new ArrayList<>();

    public List<NetworkRequestMetricContext> getNetworkRequestContexts() {
        return networkRequestContexts;
    }

    public String getContactedHosts() {
        StringBuilder builder = new StringBuilder();
        if (!networkRequestContexts.isEmpty()) {
            networkRequestContexts.forEach(networkRequest -> builder.append(networkRequest.getHostName()).append(","));
            return builder.substring(0, builder.length() - 1);
        }
        return "NONE";
    }

    public void addNetworkRequestContext(NetworkRequestMetricContext nodeContext) {
        networkRequestContexts.add(nodeContext);
    }

}