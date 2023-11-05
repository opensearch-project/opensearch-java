/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.opensearch.client.ResponseException;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.opensearch._types.Level;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.cluster.GetClusterSettingsRequest;
import org.opensearch.client.opensearch.cluster.GetClusterSettingsResponse;
import org.opensearch.client.opensearch.cluster.HealthRequest;
import org.opensearch.client.opensearch.cluster.HealthResponse;
import org.opensearch.client.opensearch.cluster.PutClusterSettingsRequest;
import org.opensearch.client.opensearch.cluster.PutClusterSettingsResponse;
import org.opensearch.client.opensearch.cluster.health.IndexHealthStats;
import org.opensearch.client.opensearch.cluster.health.ShardHealthStats;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
import org.opensearch.common.settings.Settings;
import org.opensearch.indices.recovery.RecoverySettings;

public abstract class AbstractClusterClientIT extends OpenSearchJavaClientTestCase {
    public void testClusterPutSettings() throws IOException {
        OpenSearchClient openSearchClient = javaClient();

        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        String[] transientSettingKeySplit = transientSettingKey.split("\\.");
        final String transientSettingValue = "10b";

        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
        String[] persistentSettingKeySplit = persistentSettingKey.split("\\.");
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        Map<String, JsonData> persistentSettingsMap = new HashMap<>();

        transientSettingsMap.put(transientSettingKey, JsonData.of(transientSettingValue));
        persistentSettingsMap.put(persistentSettingKey, JsonData.of(persistentSettingValue));

        PutClusterSettingsRequest request = new PutClusterSettingsRequest.Builder().persistent(persistentSettingsMap)
            .transient_(transientSettingsMap)
            .build();
        PutClusterSettingsResponse response = openSearchClient.cluster().putSettings(request);

        assertTrue(response.acknowledged());
        assertThat(response.transient_().get(transientSettingKeySplit[0]), notNullValue());
        assertThat(response.transient_().get(persistentSettingKeySplit[0]), nullValue());
        assertEquals(
            response.transient_()
                .get(transientSettingKeySplit[0])
                .toJson()
                .asJsonObject()
                .getJsonObject("recovery")
                .getString("max_bytes_per_sec"),
            transientSettingValue
        );
        assertThat(response.persistent().get(transientSettingKeySplit[0]), nullValue());
        assertThat(response.persistent().get(persistentSettingKeySplit[0]), notNullValue());
        assertEquals(
            response.persistent()
                .get(persistentSettingKeySplit[0])
                .toJson()
                .asJsonObject()
                .getJsonObject("routing")
                .getJsonObject("allocation")
                .getString("enable"),
            persistentSettingValue
        );
    }

    public void testClusterUpdateSettingNonExistent() throws IOException {
        OpenSearchClient openSearchClient = javaClient();
        String setting = "no_idea_what_you_are_talking_about";
        int value = 10;

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        transientSettingsMap.put(setting, JsonData.of(value));

        PutClusterSettingsRequest request = new PutClusterSettingsRequest.Builder().transient_(transientSettingsMap).build();
        try {
            openSearchClient.cluster().putSettings(request);
            fail();
        } catch (OpenSearchException e) {
            assertNotNull(e);
            assertEquals(e.response().status().intValue(), 400);
            assertTrue(e.getMessage().contains("transient setting [no_idea_what_you_are_talking_about], not recognized"));
        }
    }

    public void testClusterGetSettings() throws IOException {
        OpenSearchClient openSearchClient = javaClient();

        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        final String transientSettingValue = "10b";

        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        Map<String, JsonData> persistentSettingsMap = new HashMap<>();

        transientSettingsMap.put(transientSettingKey, JsonData.of(transientSettingValue));
        persistentSettingsMap.put(persistentSettingKey, JsonData.of(persistentSettingValue));

        PutClusterSettingsRequest request = new PutClusterSettingsRequest.Builder().persistent(persistentSettingsMap)
            .transient_(transientSettingsMap)
            .build();
        openSearchClient.cluster().putSettings(request);

        GetClusterSettingsResponse getSettingsResponse = openSearchClient.cluster()
            .getSettings(new GetClusterSettingsRequest.Builder().build());
        assertTrue(getSettingsResponse.persistent().containsKey("cluster"));
        assertEquals(
            getSettingsResponse.persistent()
                .get("cluster")
                .toJson()
                .asJsonObject()
                .getJsonObject("routing")
                .getJsonObject("allocation")
                .getString("enable"),
            persistentSettingValue
        );
        assertEquals(1, getSettingsResponse.transient_().size());
        assertEquals(0, getSettingsResponse.defaults().size());
    }

    public void testClusterGetSettingsWithDefault() throws IOException {
        OpenSearchClient openSearchClient = javaClient();

        final String transientSettingKey = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
        final String transientSettingValue = "10b";

        final String persistentSettingKey = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
        final String persistentSettingValue = EnableAllocationDecider.Allocation.NONE.name();

        Map<String, JsonData> transientSettingsMap = new HashMap<>();
        Map<String, JsonData> persistentSettingsMap = new HashMap<>();

        transientSettingsMap.put(transientSettingKey, JsonData.of(transientSettingValue));
        persistentSettingsMap.put(persistentSettingKey, JsonData.of(persistentSettingValue));

        PutClusterSettingsRequest request = new PutClusterSettingsRequest.Builder().persistent(persistentSettingsMap)
            .transient_(transientSettingsMap)
            .build();
        openSearchClient.cluster().putSettings(request);

        GetClusterSettingsResponse getSettingsResponse = openSearchClient.cluster()
            .getSettings(new GetClusterSettingsRequest.Builder().includeDefaults(true).build());
        assertTrue(getSettingsResponse.persistent().containsKey("cluster"));
        assertEquals(
            getSettingsResponse.persistent()
                .get("cluster")
                .toJson()
                .asJsonObject()
                .getJsonObject("routing")
                .getJsonObject("allocation")
                .getString("enable"),
            persistentSettingValue
        );
        assertEquals(1, getSettingsResponse.transient_().size());
        assertTrue(getSettingsResponse.defaults().size() > 0);
    }

    public void testClusterHealthYellowClusterLevel() throws IOException {
        OpenSearchClient openSearchClient = javaClient();
        createIndex("index", Settings.EMPTY);
        createIndex("index2", Settings.EMPTY);
        HealthRequest request = new HealthRequest.Builder().timeout(t -> t.time("5s")).build();
        HealthResponse response = openSearchClient.cluster().health(request);
        assertEquals(response.indices().size(), 0);
    }

    public void testClusterHealthYellowIndicesLevel() throws IOException {
        OpenSearchClient openSearchClient = javaClient();
        String firstIndex = "index";
        String secondIndex = "index2";
        // including another index that we do not assert on, to ensure that we are not
        // accidentally asserting on entire cluster state
        String ignoredIndex = "tasks";
        createIndex(firstIndex, Settings.EMPTY);
        createIndex(secondIndex, Settings.EMPTY);
        if (randomBoolean()) {
            createIndex(ignoredIndex, Settings.EMPTY);
        }
        HealthRequest request = new HealthRequest.Builder().index(firstIndex, secondIndex)
            .timeout(t -> t.time("5s"))
            .level(Level.Indices)
            .build();
        HealthResponse response = openSearchClient.cluster().health(request);
        assertYellowShards(response);
        assertEquals(response.indices().size(), 2);
        for (Map.Entry<String, IndexHealthStats> entry : response.indices().entrySet()) {
            assertYellowIndex(entry.getKey(), entry.getValue(), true);
        }
    }

    private static void assertYellowShards(HealthResponse response) {
        assertNotNull(response);
        assertFalse(response.timedOut());
        assertEquals(response.status(), HealthStatus.Yellow);
        assertEquals(response.activePrimaryShards(), 2);
        assertEquals(response.numberOfDataNodes(), 1);
        assertEquals(response.numberOfNodes(), 1);
        assertEquals(response.activeShards(), 2);
        assertEquals(response.delayedUnassignedShards(), 0);
        assertEquals(response.initializingShards(), 0);
        assertEquals(response.unassignedShards(), 2);
    }

    public void testClusterHealthYellowSpecificIndex() throws IOException {
        OpenSearchClient openSearchClient = javaClient();
        createIndex("index", Settings.EMPTY);
        createIndex("index2", Settings.EMPTY);
        HealthRequest request = new HealthRequest.Builder().index("index").timeout(t -> t.time("5s")).level(Level.Shards).build();
        HealthResponse response = openSearchClient.cluster().health(request);

        assertNotNull(response);
        assertFalse(response.timedOut());
        assertEquals(response.status(), HealthStatus.Yellow);
        assertEquals(response.activePrimaryShards(), 1);
        assertEquals(response.numberOfDataNodes(), 1);
        assertEquals(response.numberOfNodes(), 1);
        assertEquals(response.activeShards(), 1);
        assertEquals(response.delayedUnassignedShards(), 0);
        assertEquals(response.initializingShards(), 0);
        assertEquals(response.unassignedShards(), 1);
        assertEquals(response.indices().size(), 1);
        Map.Entry<String, IndexHealthStats> index = response.indices().entrySet().iterator().next();
        assertYellowIndex(index.getKey(), index.getValue(), false);
    }

    private static void assertYellowIndex(String indexName, IndexHealthStats indexHealth, boolean emptyShards) {
        assertNotNull(indexHealth);
        assertEquals(indexHealth.activePrimaryShards(), 1);
        assertEquals(indexHealth.activeShards(), 1);
        assertEquals(indexHealth.numberOfReplicas(), 1);
        assertEquals(indexHealth.initializingShards(), 0);
        assertEquals(indexHealth.unassignedShards(), 1);
        assertEquals(indexHealth.relocatingShards(), 0);
        assertEquals(indexHealth.status(), HealthStatus.Yellow);
        if (emptyShards) {
            assertEquals(indexHealth.shards().size(), 0);
        } else {
            assertEquals(indexHealth.shards().size(), 1);
            for (Map.Entry<String, ShardHealthStats> entry : indexHealth.shards().entrySet()) {
                assertYellowShard(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void assertYellowShard(String shardId, ShardHealthStats shardHealth) {
        assertNotNull(shardHealth);
        assertEquals(shardHealth.status(), HealthStatus.Yellow);
        assertEquals(shardHealth.activeShards(), 1);
        assertEquals(shardHealth.initializingShards(), 0);
        assertEquals(shardHealth.unassignedShards(), 1);
        assertEquals(shardHealth.relocatingShards(), 0);
    }

    private static void assertNoIndices(HealthResponse response) {
        assertEquals(response.indices(), emptyMap());
        assertEquals(response.activePrimaryShards(), 0);
        assertEquals(response.numberOfDataNodes(), 1);
        assertEquals(response.numberOfNodes(), 1);
        assertEquals(response.activeShards(), 0);
        assertEquals(response.delayedUnassignedShards(), 0);
        assertEquals(response.initializingShards(), 0);
        assertEquals(response.unassignedShards(), 0);
    }

    public void testClusterHealthNotFoundIndex() throws IOException {
        OpenSearchClient openSearchClient = javaClient();
        createIndex("index", Settings.EMPTY);
        HealthRequest request = new HealthRequest.Builder().index("notexisted-index")
            .timeout(t -> t.time("5s"))
            .level(Level.Indices)
            .build();
        try {
            HealthResponse response = openSearchClient.cluster().health(request);
            assertNotNull(response);
            assertTrue(response.timedOut());
            assertEquals(response.status(), HealthStatus.Red);
            assertNoIndices(response);
        } catch (ResponseException e) {
            assertNotNull(e);
        }
    }
}
