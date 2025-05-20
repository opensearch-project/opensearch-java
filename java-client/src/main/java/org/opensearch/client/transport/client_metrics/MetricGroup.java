package org.opensearch.client.transport.client_metrics;

import java.util.EnumSet;
import java.util.Set;

public enum MetricGroup {
    GENERAL,
    NETWORK_DETAILS;

    public static final Set<MetricGroup> REQUIRED_GROUPS = EnumSet.of(GENERAL);
    public static final Set<MetricGroup> ALL = EnumSet.allOf(MetricGroup.class);
}