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
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.nodes.NodesStatsResponse;
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
    public void stats_fsMetricRequested_returnsFsStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("fs"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.fs()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void stats_httpMetricRequested_returnsHttpStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("http"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.http()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void stats_indicesMetricRequested_returnsIndicesStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("indices"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.indices()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void stats_ingestMetricRequested_returnsIngestStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("ingest"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.ingest()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void stats_jvmMetricRequested_returnsJvmStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("jvm"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.jvm()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void stats_osMetricRequested_returnsOsStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("os"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.os()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void stats_processMetricRequested_returnsProcessStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("host"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.process()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void stats_scriptMetricRequested_returnsScriptStatsWithoutException() {
        try {
            final NodesStatsResponse statsResponse = javaClient().nodes().stats(s -> s.metric("script"));
            statsResponse.nodes().values().forEach((v) -> { assertNotNull(v.script()); });
        } catch (OpenSearchException | IOException ex) {
            fail(ex.getMessage());
        }
    }
}
