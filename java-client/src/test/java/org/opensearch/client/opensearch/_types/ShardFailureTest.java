/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;

public class ShardFailureTest {

    private final JsonpMapper mapper = new JacksonJsonpMapper();

    @Test
    public void testShardFailureWithPrimaryField() {
        String json = "{"
            + "\"shard\": 0,"
            + "\"index\": \"test-index\","
            + "\"node\": \"node-123\","
            + "\"primary\": true,"
            + "\"reason\": {"
            + "  \"type\": \"query_shard_exception\","
            + "  \"reason\": \"Failed to parse query\""
            + "}"
            + "}";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        ShardFailure shardFailure = ShardFailure._DESERIALIZER.deserialize(parser, mapper);

        assertNotNull(shardFailure);
        assertEquals(0, shardFailure.shard());
        assertEquals("test-index", shardFailure.index());
        assertEquals("node-123", shardFailure.node());
        assertNotNull(shardFailure.primary());
        assertTrue(shardFailure.primary());
        assertNotNull(shardFailure.reason());
        assertEquals("query_shard_exception", shardFailure.reason().type());
    }

    @Test
    public void testShardFailureWithoutPrimaryField() {
        // This is the real-world case that fails - OpenSearch often omits the "primary" field
        String json = "{"
            + "\"shard\": 0,"
            + "\"index\": \"cases-p360\","
            + "\"node\": \"h88XL3ygSy2OxP0Ak-YIdA\","
            + "\"reason\": {"
            + "  \"type\": \"query_shard_exception\","
            + "  \"reason\": \"Failed to execute query\""
            + "}"
            + "}";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        ShardFailure shardFailure = ShardFailure._DESERIALIZER.deserialize(parser, mapper);

        assertNotNull(shardFailure);
        assertEquals(0, shardFailure.shard());
        assertEquals("cases-p360", shardFailure.index());
        assertEquals("h88XL3ygSy2OxP0Ak-YIdA", shardFailure.node());
        // Primary field should be null when not present in JSON
        assertNull(shardFailure.primary());
        assertNotNull(shardFailure.reason());
        assertEquals("query_shard_exception", shardFailure.reason().type());
    }

    @Test
    public void testErrorCauseWithFailedShards() {
        // Test a more complete error response with failed_shards array
        // This verifies that ErrorCause can be deserialized when it contains
        // a failed_shards array with ShardFailure objects missing the primary field
        String json = "{"
            + "\"type\": \"search_phase_execution_exception\","
            + "\"reason\": \"all shards failed\","
            + "\"metadata\": {"
            + "  \"failed_shards\": ["
            + "    {"
            + "      \"shard\": 0,"
            + "      \"index\": \"test-index\","
            + "      \"node\": \"node-1\","
            + "      \"reason\": {"
            + "        \"type\": \"query_shard_exception\","
            + "        \"reason\": \"Parse error\""
            + "      }"
            + "    }"
            + "  ]"
            + "}"
            + "}";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        ErrorCause errorCause = ErrorCause._DESERIALIZER.deserialize(parser, mapper);

        // The main goal is to verify deserialization succeeds without throwing
        assertNotNull(errorCause);
        assertEquals("search_phase_execution_exception", errorCause.type());
        assertEquals("all shards failed", errorCause.reason());
    }
}
