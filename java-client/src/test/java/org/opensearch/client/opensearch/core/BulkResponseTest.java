/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch._types.ShardSearchFailure;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class BulkResponseTest extends ModelTestCase {

    @Test
    public void shouldDeserializeBulkResponseShardFailureWithoutShard() {
        String json = "{\"took\":1,\"errors\":true,\"items\":[{\"index\":{\"_index\":\"products\",\"status\":500,"
            + "\"error\":{\"type\":\"illegal_argument_exception\",\"reason\":\"boom\"},"
            + "\"_shards\":{\"total\":2,\"successful\":1,\"failed\":1,\"failures\":[{\"index\":\"products\","
            + "\"node\":\"node-1\",\"reason\":{\"type\":\"illegal_argument_exception\",\"reason\":\"boom\"}}]}}}]}";

        BulkResponse response = fromJson(json, BulkResponse._DESERIALIZER);

        BulkResponseItem item = response.items().get(0);
        assertEquals(500, item.status());
        assertNotNull(item.shards());
        ShardSearchFailure failure = item.shards().failures().get(0);
        assertEquals("products", failure.index());
        assertNull(failure.shard());
        assertEquals("illegal_argument_exception", failure.reason().type());
    }

    @Test
    public void shouldDeserializeBulkResponseShardFailureWithShard() {
        String json = "{\"took\":1,\"errors\":true,\"items\":[{\"index\":{\"_index\":\"products\",\"status\":500,"
            + "\"error\":{\"type\":\"illegal_argument_exception\",\"reason\":\"boom\"},"
            + "\"_shards\":{\"total\":2,\"successful\":1,\"failed\":1,\"failures\":[{\"index\":\"products\","
            + "\"node\":\"node-1\",\"shard\":3,\"reason\":{\"type\":\"illegal_argument_exception\",\"reason\":\"boom\"}}]}}}]}";

        BulkResponse response = fromJson(json, BulkResponse._DESERIALIZER);

        BulkResponseItem item = response.items().get(0);
        assertNotNull(item.shards());
        ShardSearchFailure failure = item.shards().failures().get(0);
        assertEquals("products", failure.index());
        assertEquals(Integer.valueOf(3), failure.shard());
        assertEquals("illegal_argument_exception", failure.reason().type());
    }
}
