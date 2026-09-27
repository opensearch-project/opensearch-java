/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.anEmptyMap;

import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;
import org.opensearch.client.opensearch.nodes.NodesStatsResponse;
import org.opensearch.client.opensearch.nodes.stats.NodesStatsMetric;
import org.opensearch.client.opensearch.tasks.ListRequest;
import org.opensearch.client.opensearch.tasks.ListResponse;

public abstract class AbstractNodesIT extends OpenSearchJavaClientTestCase {
    public void testNodesStats() throws IOException {
        final NodesStatsResponse response = javaClient().nodes().stats();
        assertThat(response.clusterName(), not(nullValue()));
        assertThat(response.nodes(), not(anEmptyMap()));
    }

    public void testNodesList() throws IOException {
        ListRequest listRequest = new ListRequest.Builder().actions(Arrays.asList("*reindex")).build();
        ListResponse listResponse = javaClient().tasks().list();
        assertThat(listResponse.nodes(), not(anEmptyMap()));
    }

    @Test
    public void stats_fsMetricRequested_returnsFsStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Fs));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.fs()); });
    }

    @Test
    public void stats_httpMetricRequested_returnsHttpStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Http));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.http()); });
    }

    @Test
    public void stats_indicesMetricRequested_returnsIndicesStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Indices));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.indices()); });
    }

    @Test
    public void stats_ingestMetricRequested_returnsIngestStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Ingest));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.ingest()); });
    }

    @Test
    public void stats_jvmMetricRequested_returnsJvmStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Jvm));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.jvm()); });
    }

    @Test
    public void stats_osMetricRequested_returnsOsStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Os));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.os()); });
    }

    @Test
    public void stats_processMetricRequested_returnsProcessStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Process));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.process()); });
    }

    @Test
    public void stats_scriptMetricRequested_returnsScriptStatsWithoutException() throws IOException {
        final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric(NodesStatsMetric.Script));
        statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.script()); });
    }
}
