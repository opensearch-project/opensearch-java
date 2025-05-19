/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.client_metrics;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_ADDITIONAL_METRIC_GROUPS;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_EXCLUDED_TAGS;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_PERCENTILES;
import static org.opensearch.client.transport.client_metrics.MetricConstants.DEFAULT_REGISTRY;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.util.EnumSet;
import org.junit.Test;

public class MetricOptionsTest {
    @Test
    public void testBuildMetricOptions() {
        MeterRegistry meterRegistry = new SimpleMeterRegistry();
        String clientID = "testClient";
        MetricOptions metricOptions = MetricOptions.builder()
                .setMetricsEnabled(true)
                .setMeterRegistry(meterRegistry)
                .setClientId(clientID)
                .setPercentiles(0.90, 0.8, 0.5)
                .setExcludedTags(MetricTag.HOST_CONTACTED, MetricTag.STATUS_CODE_OR_EXCEPTION)
                .setAdditionalMetricGroups(MetricGroup.NETWORK_DETAILS)
                .build();
        assertTrue(metricOptions.isMetricsEnabled());
        assertEquals(meterRegistry, metricOptions.getMeterRegistry());
        assertEquals(clientID, metricOptions.getClientId());
        assertArrayEquals(new double[] { 0.90, 0.8, 0.5 }, metricOptions.getPercentiles(), 0);
        assertEquals(EnumSet.of(MetricTag.HOST_CONTACTED, MetricTag.STATUS_CODE_OR_EXCEPTION), metricOptions.getExcludedTags());
        assertEquals(EnumSet.of(MetricGroup.NETWORK_DETAILS), metricOptions.getMetricGroups());
    }

    @Test
    public void testClientIDAlwaysNotNullOrEmpty() {
        MetricOptions metricOptions = MetricOptions.builder().build();
        assertNotNull(metricOptions.getClientId());
        assertFalse(metricOptions.getClientId().isEmpty());

        metricOptions = MetricOptions.builder().setClientId(null).build();
        assertNotNull(metricOptions.getClientId());
        assertFalse(metricOptions.getClientId().isEmpty());

        metricOptions = MetricOptions.builder().setClientId("").build();
        assertNotNull(metricOptions.getClientId());
        assertFalse(metricOptions.getClientId().isEmpty());
    }

    @Test
    public void testDefaults() {
        MetricOptions metricOptions = MetricOptions.builder().build();
        validateDefaults(metricOptions);

        metricOptions = MetricOptions.builder().setMeterRegistry(null).setClientId(null).build();
        validateDefaults(metricOptions);
    }

    private void validateDefaults(MetricOptions metricOptions) {
        assertFalse(metricOptions.isMetricsEnabled());
        assertEquals(DEFAULT_REGISTRY, metricOptions.getMeterRegistry());
        assertNotNull(metricOptions.getClientId());
        assertFalse(metricOptions.getClientId().isEmpty());
        assertArrayEquals(DEFAULT_PERCENTILES, metricOptions.getPercentiles(), 0);
        assertEquals(DEFAULT_EXCLUDED_TAGS, metricOptions.getExcludedTags());
        assertEquals(DEFAULT_ADDITIONAL_METRIC_GROUPS, metricOptions.getMetricGroups());
    }
}