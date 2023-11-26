package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import org.junit.Test;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.nodes.NodesStatsResponse;

public abstract class AbstractStatsIT extends OpenSearchJavaClientTestCase {
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
