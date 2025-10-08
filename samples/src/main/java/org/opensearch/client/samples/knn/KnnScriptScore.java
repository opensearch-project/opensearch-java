/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples.knn;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.samples.SampleClient;
import org.opensearch.client.samples.util.RandUtil;

/**
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=knn.KnnScriptScore}
 */
public class KnnScriptScore {
    private static final Logger LOGGER = LogManager.getLogger(KnnScriptScore.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexName = "my-index";
            final var dimensions = 5;

            if (!client.indices().exists(r -> r.index(indexName)).value()) {
                LOGGER.info("Creating index {}", indexName);
                client.indices()
                    .create(
                        r -> r.index(indexName)
                            .settings(s -> s.knn(true))
                            .mappings(m -> m.properties("values", p -> p.knnVector(k -> k.dimension(dimensions))))
                    );
            }

            final var nVectors = 10;
            var bulkRequest = new BulkRequest.Builder();
            for (var i = 0; i < nVectors; ++i) {
                var id = Integer.toString(i);
                var doc = Doc.rand(dimensions);
                bulkRequest.operations(b -> b.index(o -> o.index(indexName).id(id).document(doc)));
            }

            LOGGER.info("Indexing {} vectors", nVectors);
            client.bulk(bulkRequest.build());

            LOGGER.info("Waiting for indexing to finish");
            client.indices().refresh(i -> i.index(indexName));

            final var searchVector = RandUtil.rand2SfArray(dimensions);
            LOGGER.info("Searching for vector {}", searchVector);

            var searchResponse = client.search(
                s -> s.index(indexName)
                    .query(
                        q -> q.scriptScore(
                            ss -> ss.query(qq -> qq.matchAll(m -> m))
                                .script(
                                    sss -> sss.inline(
                                        i -> i.source("knn_score")
                                            .lang(l -> l.custom("knn"))
                                            .params("field", JsonData.of("values"))
                                            .params("query_value", JsonData.of(searchVector))
                                            .params("space_type", JsonData.of("cosinesimil"))
                                    )
                                )
                        )
                    ),
                Doc.class
            );

            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

            LOGGER.info("Deleting index {}", indexName);
            client.indices().delete(r -> r.index(indexName));
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }

    public static class Doc {
        private float[] values;

        public Doc() {}

        public Doc(float[] values) {
            this.values = values;
        }

        public static Doc rand(int dimensions) {
            return new Doc(RandUtil.rand2SfArray(dimensions));
        }

        public float[] getValues() {
            return values;
        }

        public void setValues(float[] values) {
            this.values = values;
        }

        @Override
        public String toString() {
            return "{" + "values=" + Arrays.toString(values) + '}';
        }
    }
}
