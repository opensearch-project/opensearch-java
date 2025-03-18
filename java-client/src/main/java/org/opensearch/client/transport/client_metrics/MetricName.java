package org.opensearch.client.transport.client_metrics;

public enum MetricName {
    REQUEST("request"),
    NETWORK_REQUEST("network.request"),
    ACTIVE_NODES("active.nodes"),
    INACTIVE_NODES("inactive.nodes"),
    REQUEST_PAYLOAD_SIZE("request.payload.size"),
    RESPONSE_PAYLOAD_SIZE("response.payload.size");

    private static final String PREFIX = "os.client";
    private final String metricName;

    MetricName(String metricName) {
        this.metricName = metricName;
    }

    @Override
    public String toString() {
        return PREFIX + "." + metricName;
    }
}