package org.opensearch.client.transport.client_metrics;

public enum MetricTag {
    REQUEST("Request"),
    CLIENT_ID("ClientID"),
    STATUS_CODE_OR_EXCEPTION("StatusCodeOrException"),
    HOST_CONTACTED("HostContacted"),
    HOST("Host");

    private String name;

    MetricTag(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}