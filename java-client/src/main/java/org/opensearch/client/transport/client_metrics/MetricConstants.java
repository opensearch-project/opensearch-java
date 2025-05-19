package org.opensearch.client.transport.client_metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import java.util.EnumSet;
import java.util.Set;

public class MetricConstants {
    public static final double[] DEFAULT_PERCENTILES = new double[] { 0.99, 0.95, 0.9, 0.75, 0.5 };
    public static final MeterRegistry DEFAULT_REGISTRY = Metrics.globalRegistry;
    public static final Set<MetricTag> DEFAULT_EXCLUDED_TAGS = EnumSet.noneOf(MetricTag.class);
    public static final Set<MetricGroup> DEFAULT_ADDITIONAL_METRIC_GROUPS = EnumSet.noneOf(MetricGroup.class);
}