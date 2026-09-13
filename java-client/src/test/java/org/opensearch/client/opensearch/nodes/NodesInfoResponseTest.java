/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.nodes;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class NodesInfoResponseTest extends ModelTestCase {
    @Test
    public void canDeserializePluginWithoutOpenSearchVersion() {
        final String json = "{\n"
            + "  \"cluster_name\": \"opensearch\",\n"
            + "  \"nodes\": {\n"
            + "    \"node-0\": {\n"
            + "      \"name\": \"opensearch-node1\",\n"
            + "      \"version\": \"3.3.0\",\n"
            + "      \"build_hash\": \"unknown\",\n"
            + "      \"build_type\": \"tar\",\n"
            + "      \"roles\": [\"cluster_manager\", \"data\"],\n"
            + "      \"plugins\": [\n"
            + "        {\n"
            + "          \"classname\": \"org.example.Plugin\",\n"
            + "          \"description\": \"test plugin\",\n"
            + "          \"extended_plugins\": [],\n"
            + "          \"has_native_controller\": false,\n"
            + "          \"java_version\": \"21\",\n"
            + "          \"name\": \"test-plugin\",\n"
            + "          \"version\": \"1.0.0\"\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  }\n"
            + "}";

        final NodesInfoResponse response = fromJson(json, NodesInfoResponse._DESERIALIZER);

        assertNull(response.nodes().get("node-0").plugins().get(0).opensearchVersion());
    }
}
