/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.httpclient5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import java.io.IOException;
import java.util.Optional;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.transport.client_metrics.MetricOptions;
import org.opensearch.client.transport.client_metrics.MetricTag;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

public class ApacheHttpClient5TransportTest {
    @Test
    public void testInitWithMetricsOptions() throws IOException {
        MeterRegistry meterRegistry = new SimpleMeterRegistry();
        String clientID = "testClient";
        HttpHost host = new HttpHost("localhost", 9200);
        MetricOptions metricOptions = MetricOptions.builder()
                .setMetricsEnabled(true)
                .setMeterRegistry(meterRegistry)
                .setClientId(clientID)
                .setPercentiles(0.90, 0.8, 0.5)
                .build();
        ApacheHttpClient5TransportBuilder builder = ApacheHttpClient5TransportBuilder.builder(host);
        builder.setMetricOptions(metricOptions);
        try (ApacheHttpClient5Transport transport = builder.build()) {
            assertTrue(transport.isMetricsEnabled());
            assertArrayEquals(new double[] { 0.90, 0.8, 0.5 }, transport.getMeterOptions().getPercentiles(), 0);
            Optional<Tag> clientIDTag = transport.getMeterOptions()
                    .getCommonTags()
                    .stream()
                    .filter(tag -> tag.getKey().equals(MetricTag.CLIENT_ID.toString()))
                    .findFirst();
            assertFalse(clientIDTag.isEmpty());
            assertEquals(clientID, clientIDTag.get().getValue());
            assertEquals(clientID, transport.getClientID());
        }
    }
}