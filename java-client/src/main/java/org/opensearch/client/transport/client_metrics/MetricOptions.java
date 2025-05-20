/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_ADDITIONAL_METRIC_GROUPS;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_EXCLUDED_TAGS;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_PERCENTILES;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_REGISTRY;

import io.micrometer.core.instrument.MeterRegistry;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

/**
 * Contains settings to configure metrics
 */
public class MetricOptions {
    private final boolean isEnabled;
    private final MeterRegistry meterRegistry;
    private final String clientId;
    private final double[] percentiles;
    private final Set<MetricTag> excludedTags;
    private final Set<MetricGroup> metricGroups;

    public MetricOptions(MetricOptionsBuilder builder) {
        meterRegistry = builder.meterRegistry == null ? DEFAULT_REGISTRY : builder.meterRegistry;
        clientId = builder.clientId == null || builder.clientId.isEmpty()
            ? String.valueOf(TelemetryMetricsManager.generateClientID())
            : builder.clientId;
        percentiles = builder.percentiles == null ? DEFAULT_PERCENTILES : builder.percentiles;
        isEnabled = builder.isEnabled;
        excludedTags = builder.excludedTags == null ? DEFAULT_EXCLUDED_TAGS : builder.excludedTags;
        metricGroups = builder.metricGroups == null ? DEFAULT_ADDITIONAL_METRIC_GROUPS : builder.metricGroups;
    }

    public static MetricOptionsBuilder builder() {
        return new MetricOptionsBuilder();
    }

    public boolean isMetricsEnabled() {
        return isEnabled;
    }

    public MeterRegistry getMeterRegistry() {
        return meterRegistry;
    }

    public String getClientId() {
        return clientId;
    }

    public double[] getPercentiles() {
        return percentiles;
    }

    public Set<MetricTag> getExcludedTags() {
        return excludedTags;
    }

    public Set<MetricGroup> getMetricGroups() {
        return metricGroups;
    }

    public static class MetricOptionsBuilder {
        private boolean isEnabled;
        private MeterRegistry meterRegistry = null;
        private String clientId = null;
        private double[] percentiles = null;
        private Set<MetricTag> excludedTags = null;
        private Set<MetricGroup> metricGroups = null;

        /**
         * Set whether the metrics system is enabled
         * @param enabled true to enable metrics; otherwise, false
         * @return current {@link MetricOptionsBuilder}
         */
        public MetricOptionsBuilder setMetricsEnabled(boolean enabled) {
            this.isEnabled = enabled;
            return this;
        }

        /**
         * Set a {@link MeterRegistry} for the client to propagate metrics
         * @param meterRegistry a {@link MeterRegistry} instance
         * @return current {@link MetricOptionsBuilder}
         */
        public MetricOptionsBuilder setMeterRegistry(MeterRegistry meterRegistry) {
            this.meterRegistry = meterRegistry;
            return this;
        }

        /**
         * Give the client a name/ID
         * @param clientId a name
         * @return current {@link MetricOptionsBuilder}
         */
        public MetricOptionsBuilder setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        /**
         * Set percentiles of distribution metrics to be published. For instance, pass {@code 0.95},
         * {@code 0.99} to publish request latency P99 and P95.
         *
         * @param percentiles percentile values to publish
         * @return current {@link MetricOptionsBuilder}
         */
        public MetricOptionsBuilder setPercentiles(double... percentiles) {
            this.percentiles = percentiles;
            return this;
        }

        /**
         * Set tags that metrics cannot have. Each metric has a set of required tags
         * that cannot be excluded. However, for optional tags, they can be dropped based on
         * the tags set here. This option allows users to exclude high cardinality tags.
         * @param tags {@link MetricTag} names to exclude
         * @return current {@link MetricOptionsBuilder}
         */
        public MetricOptionsBuilder setExcludedTags(MetricTag... tags) {
            this.excludedTags = EnumSet.copyOf(Arrays.asList(tags));
            return this;
        }

        /**
         * Set {@link MetricGroup} that you would like to be enabled in addition to groups under
         * {@link MetricGroup#REQUIRED_GROUPS}.
         *
         * @param metricGroups {@link MetricGroup} names to be enabled
         * @return current {@link MetricOptionsBuilder}
         */
        public MetricOptionsBuilder setAdditionalMetricGroups(MetricGroup... metricGroups) {
            this.metricGroups = EnumSet.copyOf(Arrays.asList(metricGroups));
            return this;
        }

        public MetricOptions build() {
            return new MetricOptions(this);
        }
    }
}
