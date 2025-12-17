/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.json;

import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Result;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.SearchRequest;

public class PlainJsonSerializableTest extends Assert {

    // Test IndexResponse which extends WriteResponseBase which implements PlainJsonSerializable
    @Test
    public void testIndexResponse() {

        String expectedStringValue =
            "{\"_id\":\"id\",\"_index\":\"index\",\"_primary_term\":1,\"result\":\"created\",\"_seq_no\":2,\"_shards\":{\"failed\":1,\"failures\":[{\"index\":\"index\",\"node\":\"node\",\"primary\":true,\"reason\":{\"reason\":\"Failed to create query.\",\"type\":\"query_shard_exception\"},\"shard\":1,\"status\":\"Failed\"}],\"skipped\":1,\"successful\":1,\"total\":3},\"_version\":3}";
        IndexResponse indexResponse = IndexResponse.of(
            response -> response.result(Result.Created)
                .index("index")
                .id("id")
                .primaryTerm(1)
                .seqNo(2)
                .version(3)
                .shards(
                    shardStats -> shardStats.total(3)
                        .successful(1)
                        .skipped(1)
                        .failed(1)
                        .failures(
                            shardFailure -> shardFailure.index("index")
                                .node("node")
                                .shard(1)
                                .status("Failed")
                                .reason(cause -> cause.type("query_shard_exception").reason("Failed to create query."))
                                .primary(true)
                        )
                )
        );

        String indexResponseString = indexResponse.toJsonString();
        assertEquals(expectedStringValue, indexResponseString);
    }

    // Test SearchRequest which implements PlainJsonSerializable
    @Test
    public void testSearchRequest() {

        String expectedStringValue =
            "{\"aggregations\":{},\"query\":{\"match\":{\"name\":{\"query\":\"OpenSearch\"}}},\"terminate_after\":5}";
        SearchRequest searchRequest = SearchRequest.of(
            request -> request.index("index1", "index2")
                .aggregations(Collections.emptyMap())
                .terminateAfter(5L)
                .query(q -> q.match(t -> t.field("name").query(FieldValue.of("OpenSearch"))))
        );
        String searchRequestString = searchRequest.toJsonString();
        assertEquals(expectedStringValue, searchRequestString);

    }

}
