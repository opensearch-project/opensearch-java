/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;

public abstract class AbstractKnnIT extends OpenSearchJavaClientTestCase {
    @Test
    public void testCanIndexAndSearchKnn() throws Exception {
        final String indexName = "knn-index-and-search";

        var createIndexResponse = javaClient()
                .indices()
                .create(c -> c
                        .index(indexName)
                        .settings(s -> s
                                .knn(true)
                                .knnAlgoParamEfSearch(100))
                        .mappings(m -> m
                                .properties("vector", p -> p
                                        .knnVector(k -> k
                                                .dimension(4)
                                                .method(km -> km
                                                        .name("hnsw")
                                                        .spaceType("l2")
                                                        .engine("nmslib")
                                                        .parameters("ef_construction", JsonData.of(256))
                                                        .parameters("m", JsonData.of(16)))))));

        assertEquals(true, createIndexResponse.acknowledged());

        var docs = new Doc[] {
                new Doc(new float[] { 1.5f, 5.5f, 4.5f, 6.4f }, 10.3f),
                new Doc(new float[] { 2.5f, 3.5f, 5.6f, 6.7f }, 5.5f),
                new Doc(new float[] { 4.5f, 5.5f, 6.7f, 3.7f }, 4.4f),
                new Doc(new float[] { 1.5f, 5.5f, 4.5f, 6.4f }, 8.9f)
        };
        var bulkOps = Arrays.stream(docs)
                .map(d -> BulkOperation.of(o -> o.index(i -> i.document(d))))
                .collect(Collectors.toList());

        var bulkResponse = javaClient()
                .bulk(b -> b
                        .index(indexName)
                        .refresh(Refresh.WaitFor)
                        .operations(bulkOps));

        assertFalse(bulkResponse.errors());

        var searchResponse = javaClient()
                .search(s -> s
                        .index(indexName)
                        .size(2)
                        .query(q -> q
                                .knn(k -> k
                                        .field("vector")
                                        .vector(new float[] { 2.0f, 3.0f, 5.0f, 6.0f })
                                        .k(2))),
                    Doc.class);

        var hits = searchResponse.hits().hits();

        assertEquals(2, hits.size());
        assertEquals(5.5f, hits.get(0).source().price, 0.01f);
        assertEquals(4.4f, hits.get(1).source().price, 0.01f);
    }

    private static class Doc {
        public float[] vector;
        public float price;

        Doc(float[] vector, float price) {
            this.vector = vector;
            this.price = price;
        }
    }
}
