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
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.samples.SampleClient;
import org.opensearch.client.samples.util.RandUtil;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=knn.KnnBooleanFilter</c>
 */
public class KnnBooleanFilter {
    private static final Logger LOGGER = LogManager.getLogger(KnnBooleanFilter.class);

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

            final var nVectors = 3000;
            final var genres = new String[] { "fiction", "drama", "romance" };
            var bulkRequest = new BulkRequest.Builder();
            for (var i = 0; i < nVectors; ++i) {
                var id = Integer.toString(i);
                var doc = Doc.rand(dimensions, genres);
                bulkRequest.operations(b -> b.index(o -> o.index(indexName).id(id).document(doc)));
            }

            LOGGER.info("Indexing {} vectors", nVectors);
            client.bulk(bulkRequest.build());

            LOGGER.info("Waiting for indexing to finish");
            client.indices().refresh(i -> i.index(indexName));

            final var searchGenre = RandUtil.choice(genres);
            final var searchVector = RandUtil.rand2SfList(dimensions);
            LOGGER.info("Searching for vector {} with the '{}' genre", searchVector, searchGenre);

            var searchResponse = client.search(
                s -> s.index(indexName)
                    .query(
                        q -> q.bool(
                            b -> b.filter(
                                f -> f.bool(
                                    b2 -> b2.must(m -> m.term(t -> t.field("metadata.genre").value(v -> v.stringValue(searchGenre))))
                                )
                            ).must(m -> m.knn(k -> k.field("values").vector(searchVector).k(5)))
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

    private static class Doc {
        private float[] values;
        private Metadata metadata;

        public Doc() {}

        public Doc(float[] values, Metadata metadata) {
            this.values = values;
            this.metadata = metadata;
        }

        public static Doc rand(int dimensions, String[] genres) {
            return new Doc(RandUtil.rand2SfArray(dimensions), new Metadata(RandUtil.choice(genres)));
        }

        public float[] getValues() {
            return values;
        }

        public void setValues(float[] values) {
            this.values = values;
        }

        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }

        @Override
        public String toString() {
            return "{" + "values=" + Arrays.toString(values) + ", metadata=" + metadata + '}';
        }
    }

    private static class Metadata {
        private String genre;

        private Metadata() {}

        private Metadata(String genre) {
            this.genre = genre;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        @Override
        public String toString() {
            return "{" + "genre=" + genre + '}';
        }
    }
}
