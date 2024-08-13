/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.tasks;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ListResponseTest extends ModelTestCase {
    @Test
    public void canDeserializeGroupedByNodes() {
        final String json = "{\n"
            + "  \"nodes\": {\n"
            + "    \"y2hDJUdMTWa6sNA_0vdF6Q\": {\n"
            + "      \"name\": \"opensearch-node1\",\n"
            + "      \"transport_address\": \"172.17.0.4:9300\",\n"
            + "      \"host\": \"172.17.0.4\",\n"
            + "      \"ip\": \"172.17.0.4:9300\",\n"
            + "      \"roles\": [\n"
            + "        \"cluster_manager\",\n"
            + "        \"data\",\n"
            + "        \"ingest\",\n"
            + "        \"remote_cluster_client\"\n"
            + "      ],\n"
            + "      \"attributes\": {\n"
            + "        \"shard_indexing_pressure_enabled\": \"true\"\n"
            + "      },\n"
            + "      \"tasks\": {\n"
            + "        \"y2hDJUdMTWa6sNA_0vdF6Q:3970\": {\n"
            + "          \"node\": \"y2hDJUdMTWa6sNA_0vdF6Q\",\n"
            + "          \"id\": 3970,\n"
            + "          \"type\": \"transport\",\n"
            + "          \"action\": \"cluster:monitor/tasks/lists\",\n"
            + "          \"start_time_in_millis\": 1722997372508,\n"
            + "          \"running_time_in_nanos\": 2141574,\n"
            + "          \"cancellable\": false,\n"
            + "          \"headers\": {\n"
            + "            \"X-Opaque-Id\": \"7ef238e7-e5fb-4779-81f5-9b7bfcc46bdd\"\n"
            + "          }\n"
            + "        },\n"
            + "        \"y2hDJUdMTWa6sNA_0vdF6Q:3971\": {\n"
            + "          \"node\": \"y2hDJUdMTWa6sNA_0vdF6Q\",\n"
            + "          \"id\": 3971,\n"
            + "          \"type\": \"direct\",\n"
            + "          \"action\": \"cluster:monitor/tasks/lists[n]\",\n"
            + "          \"start_time_in_millis\": 1722997372510,\n"
            + "          \"running_time_in_nanos\": 868850,\n"
            + "          \"cancellable\": false,\n"
            + "          \"parent_task_id\": \"y2hDJUdMTWa6sNA_0vdF6Q:3970\",\n"
            + "          \"headers\": {\n"
            + "            \"X-Opaque-Id\": \"7ef238e7-e5fb-4779-81f5-9b7bfcc46bdd\"\n"
            + "          }\n"
            + "        }\n"
            + "      }\n"
            + "    },\n"
            + "    \"upjixfEITyuPot3qTn9H_Q\": {\n"
            + "      \"name\": \"opensearch-node2\",\n"
            + "      \"transport_address\": \"172.17.0.3:9300\",\n"
            + "      \"host\": \"172.17.0.3\",\n"
            + "      \"ip\": \"172.17.0.3:9300\",\n"
            + "      \"roles\": [\n"
            + "        \"cluster_manager\",\n"
            + "        \"data\",\n"
            + "        \"ingest\",\n"
            + "        \"remote_cluster_client\"\n"
            + "      ],\n"
            + "      \"attributes\": {\n"
            + "        \"shard_indexing_pressure_enabled\": \"true\"\n"
            + "      },\n"
            + "      \"tasks\": {\n"
            + "        \"upjixfEITyuPot3qTn9H_Q:5061\": {\n"
            + "          \"node\": \"upjixfEITyuPot3qTn9H_Q\",\n"
            + "          \"id\": 5061,\n"
            + "          \"type\": \"transport\",\n"
            + "          \"action\": \"cluster:monitor/tasks/lists[n]\",\n"
            + "          \"start_time_in_millis\": 1722997372510,\n"
            + "          \"running_time_in_nanos\": 886766,\n"
            + "          \"cancellable\": false,\n"
            + "          \"parent_task_id\": \"y2hDJUdMTWa6sNA_0vdF6Q:3970\",\n"
            + "          \"headers\": {\n"
            + "            \"X-Opaque-Id\": \"7ef238e7-e5fb-4779-81f5-9b7bfcc46bdd\"\n"
            + "          }\n"
            + "        }\n"
            + "      }\n"
            + "    }\n"
            + "  }\n"
            + "}";

        final ListResponse response = fromJson(json, ListResponse._DESERIALIZER);
        assertTrue(response.tasks().isEmpty());

        final Map<String, TaskExecutingNode> nodes = response.nodes();
        assertNotNull(nodes);
        assertEquals(2, nodes.size());
        assertEquals("opensearch-node2", nodes.get("upjixfEITyuPot3qTn9H_Q").name());
    }

    @Test
    public void canDeserializeGroupedByParents() {
        final String json = "{\n"
            + "  \"tasks\": {\n"
            + "    \"y2hDJUdMTWa6sNA_0vdF6Q:5306\": {\n"
            + "      \"node\": \"y2hDJUdMTWa6sNA_0vdF6Q\",\n"
            + "      \"id\": 5306,\n"
            + "      \"type\": \"transport\",\n"
            + "      \"action\": \"cluster:monitor/tasks/lists\",\n"
            + "      \"start_time_in_millis\": 1722997879217,\n"
            + "      \"running_time_in_nanos\": 1572170,\n"
            + "      \"cancellable\": false,\n"
            + "      \"headers\": {\n"
            + "        \"X-Opaque-Id\": \"6033796b-4901-44f0-aae9-37c46d7d36ea\"\n"
            + "      },\n"
            + "      \"children\": [\n"
            + "        {\n"
            + "          \"node\": \"y2hDJUdMTWa6sNA_0vdF6Q\",\n"
            + "          \"id\": 5307,\n"
            + "          \"type\": \"direct\",\n"
            + "          \"action\": \"cluster:monitor/tasks/lists[n]\",\n"
            + "          \"start_time_in_millis\": 1722997879218,\n"
            + "          \"running_time_in_nanos\": 393734,\n"
            + "          \"cancellable\": false,\n"
            + "          \"parent_task_id\": \"y2hDJUdMTWa6sNA_0vdF6Q:5306\",\n"
            + "          \"headers\": {\n"
            + "            \"X-Opaque-Id\": \"6033796b-4901-44f0-aae9-37c46d7d36ea\"\n"
            + "          }\n"
            + "        },\n"
            + "        {\n"
            + "          \"node\": \"upjixfEITyuPot3qTn9H_Q\",\n"
            + "          \"id\": 6646,\n"
            + "          \"type\": \"transport\",\n"
            + "          \"action\": \"cluster:monitor/tasks/lists[n]\",\n"
            + "          \"start_time_in_millis\": 1722997879218,\n"
            + "          \"running_time_in_nanos\": 356705,\n"
            + "          \"cancellable\": false,\n"
            + "          \"parent_task_id\": \"y2hDJUdMTWa6sNA_0vdF6Q:5306\",\n"
            + "          \"headers\": {\n"
            + "            \"X-Opaque-Id\": \"6033796b-4901-44f0-aae9-37c46d7d36ea\"\n"
            + "          }\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  }\n"
            + "}";

        final ListResponse response = fromJson(json, ListResponse._DESERIALIZER);
        assertTrue(response.nodes().isEmpty());

        final Map<String, Info> tasks = response.tasks();
        assertNotNull(tasks);
        assertEquals(1, tasks.size());

        final Info task = tasks.get("y2hDJUdMTWa6sNA_0vdF6Q:5306");
        assertNotNull(task);

        final List<Info> children = task.children();
        assertEquals(2, children.size());

        assertEquals("cluster:monitor/tasks/lists[n]", children.get(0).action());
    }

    @Test
    public void canDeserializeGroupedByNone() {
        final String json = "{\n"
            + "  \"tasks\": [\n"
            + "    {\n"
            + "      \"node\": \"y2hDJUdMTWa6sNA_0vdF6Q\",\n"
            + "      \"id\": 5961,\n"
            + "      \"type\": \"transport\",\n"
            + "      \"action\": \"cluster:monitor/tasks/lists\",\n"
            + "      \"start_time_in_millis\": 1722998118297,\n"
            + "      \"running_time_in_nanos\": 1472050,\n"
            + "      \"cancellable\": false,\n"
            + "      \"headers\": {\n"
            + "        \"X-Opaque-Id\": \"ccfdeab1-5807-4f9d-8258-111ea6642d9b\"\n"
            + "      }\n"
            + "    },\n"
            + "    {\n"
            + "      \"node\": \"y2hDJUdMTWa6sNA_0vdF6Q\",\n"
            + "      \"id\": 5962,\n"
            + "      \"type\": \"direct\",\n"
            + "      \"action\": \"cluster:monitor/tasks/lists[n]\",\n"
            + "      \"start_time_in_millis\": 1722998118298,\n"
            + "      \"running_time_in_nanos\": 95393,\n"
            + "      \"cancellable\": false,\n"
            + "      \"parent_task_id\": \"y2hDJUdMTWa6sNA_0vdF6Q:5961\",\n"
            + "      \"headers\": {\n"
            + "        \"X-Opaque-Id\": \"ccfdeab1-5807-4f9d-8258-111ea6642d9b\"\n"
            + "      }\n"
            + "    },\n"
            + "    {\n"
            + "      \"node\": \"upjixfEITyuPot3qTn9H_Q\",\n"
            + "      \"id\": 7356,\n"
            + "      \"type\": \"transport\",\n"
            + "      \"action\": \"cluster:monitor/tasks/lists[n]\",\n"
            + "      \"start_time_in_millis\": 1722998118299,\n"
            + "      \"running_time_in_nanos\": 885987,\n"
            + "      \"cancellable\": false,\n"
            + "      \"parent_task_id\": \"y2hDJUdMTWa6sNA_0vdF6Q:5961\",\n"
            + "      \"headers\": {\n"
            + "        \"X-Opaque-Id\": \"ccfdeab1-5807-4f9d-8258-111ea6642d9b\"\n"
            + "      }\n"
            + "    }\n"
            + "  ]\n"
            + "}";

        final ListResponse response = fromJson(json, ListResponse._DESERIALIZER);
    }
}
