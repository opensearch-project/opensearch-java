/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch._types.NodeAttributes;
import org.opensearch.client.opensearch.indices.shard_stores.ShardStore;
import org.opensearch.client.opensearch.model.ModelTestCase;
import org.opensearch.client.util.MissingRequiredPropertyException;

/**
 * Managed OpenSearch distributions (e.g. Amazon OpenSearch Service) omit
 * {@code attributes} and {@code transport_address} from the node objects in
 * search_shards responses; those fields must not be required. See
 * https://github.com/opensearch-project/opensearch-java/issues/2145
 */
public class SearchShardsResponseTest extends ModelTestCase {

    @Test
    public void canDeserializeOmittedNodeMetadata() {
        // the exact payload from the issue report
        String json = "{\"nodes\":{\"node-id\":{\"name\":\"node-name\",\"ephemeral_id\":\"ephemeral-id\"}},\"indices\":{},\"shards\":[]}";

        SearchShardsResponse response = fromJson(json, SearchShardsResponse._DESERIALIZER);

        assertEquals(1, response.nodes().size());
        NodeAttributes node = response.nodes().get("node-id");
        assertNotNull(node);
        assertEquals("node-name", node.name());
        assertEquals("ephemeral-id", node.ephemeralId());
        assertTrue(node.attributes().isEmpty());
        assertNull(node.transportAddress());

        // re-serialization must omit the fields the server left out (and empty collections)
        checkJsonRoundtrip(
            response,
            "{\"indices\":{},\"nodes\":{\"node-id\":{\"ephemeral_id\":\"ephemeral-id\",\"name\":\"node-name\"}},\"shards\":[]}"
        );
    }

    @Test
    public void canDeserializeOmittedAttributesOnly() {
        String json =
            "{\"indices\":{},\"nodes\":{\"node-id\":{\"name\":\"node-name\",\"ephemeral_id\":\"ephemeral-id\",\"transport_address\":\"10.0.0.1:9300\"}},\"shards\":[]}";

        SearchShardsResponse response = fromJson(json, SearchShardsResponse._DESERIALIZER);

        NodeAttributes node = response.nodes().get("node-id");
        assertTrue(node.attributes().isEmpty());
        assertEquals("10.0.0.1:9300", node.transportAddress());
        checkJsonRoundtrip(
            response,
            "{\"indices\":{},\"nodes\":{\"node-id\":{\"ephemeral_id\":\"ephemeral-id\",\"name\":\"node-name\",\"transport_address\":\"10.0.0.1:9300\"}},\"shards\":[]}"
        );
    }

    @Test
    public void canDeserializeOmittedTransportAddressOnly() {
        String json =
            "{\"indices\":{},\"nodes\":{\"node-id\":{\"name\":\"node-name\",\"ephemeral_id\":\"ephemeral-id\",\"attributes\":{\"role\":\"master\"}}},\"shards\":[]}";

        SearchShardsResponse response = fromJson(json, SearchShardsResponse._DESERIALIZER);

        NodeAttributes node = response.nodes().get("node-id");
        assertEquals(Collections.singletonMap("role", "master"), node.attributes());
        assertNull(node.transportAddress());
        checkJsonRoundtrip(
            response,
            "{\"indices\":{},\"nodes\":{\"node-id\":{\"attributes\":{\"role\":\"master\"},\"ephemeral_id\":\"ephemeral-id\",\"name\":\"node-name\"}},\"shards\":[]}"
        );
    }

    @Test
    public void canDeserializePopulatedNodeMetadata() {
        // field order in the payload differs from the canonical serialization order
        String json = "{\"indices\":{},\"nodes\":{\"node-id\":{\"name\":\"node-name\",\"ephemeral_id\":\"ephemeral-id\","
            + "\"transport_address\":\"10.0.0.1:9300\",\"attributes\":{\"role\":\"master\",\"shard\":\"true\"}}},\"shards\":[]}";

        SearchShardsResponse response = fromJson(json, SearchShardsResponse._DESERIALIZER);

        NodeAttributes node = response.nodes().get("node-id");
        assertEquals("10.0.0.1:9300", node.transportAddress());
        assertEquals(2, node.attributes().size());
        assertEquals("master", node.attributes().get("role"));
        checkJsonRoundtrip(
            response,
            "{\"indices\":{},\"nodes\":{\"node-id\":{\"attributes\":{\"role\":\"master\",\"shard\":\"true\"},\"ephemeral_id\":\"ephemeral-id\","
                + "\"name\":\"node-name\",\"transport_address\":\"10.0.0.1:9300\"}},\"shards\":[]}"
        );
    }

    @Test
    public void canDeserializeShardsWithOmittedNodeMetadata() {
        String json = "{\"indices\":{},\"nodes\":{\"node-id\":{\"ephemeral_id\":\"ephemeral-id\",\"name\":\"node-name\"}},"
            + "\"shards\":[[{\"index\":\"idx\",\"node\":\"node-id\",\"primary\":true,\"shard\":0,\"state\":\"STARTED\"}]]}";

        SearchShardsResponse response = fromJson(json, SearchShardsResponse._DESERIALIZER);

        assertEquals(1, response.shards().size());
        assertEquals(1, response.shards().get(0).size());
        NodeAttributes node = response.nodes().get("node-id");
        assertTrue(node.attributes().isEmpty());
        assertNull(node.transportAddress());
        checkJsonRoundtrip(response, json);
    }

    @Test
    public void nodeIdentityRemainsRequired() {
        try {
            fromJson("{\"nodes\":{\"node-id\":{\"ephemeral_id\":\"ephemeral-id\"}}}", SearchShardsResponse._DESERIALIZER);
            fail("expected MissingRequiredPropertyException for name");
        } catch (MissingRequiredPropertyException e) {
            assertEquals("name", e.getPropertyName());
        }

        try {
            fromJson("{\"nodes\":{\"node-id\":{\"name\":\"node-name\"}}}", SearchShardsResponse._DESERIALIZER);
            fail("expected MissingRequiredPropertyException for ephemeralId");
        } catch (MissingRequiredPropertyException e) {
            assertEquals("ephemeralId", e.getPropertyName());
        }
    }

    @Test
    public void canDeserializeShardStoreWithOmittedNodeMetadata() {
        // In shard_stores responses each shard key maps directly to a NodeAttributes
        // object (parsed via the deserializer's unknown-field handler)
        String json = "{\"allocation\":\"primary\",\"1\":{\"ephemeral_id\":\"ephemeral-id\",\"name\":\"node-name\"}}";

        ShardStore store = fromJson(json, ShardStore._DESERIALIZER);

        NodeAttributes node = store.nodes().get("1");
        assertTrue(node.attributes().isEmpty());
        assertNull(node.transportAddress());
        // the nodes map serializes before the named fields
        checkJsonRoundtrip(store, "{\"1\":{\"ephemeral_id\":\"ephemeral-id\",\"name\":\"node-name\"},\"allocation\":\"primary\"}");
    }
}
