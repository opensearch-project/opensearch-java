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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.samples.SampleClient;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=knn.KnnEfficientFilter</c>
 */
public class KnnEfficientFilter {
    private static final Logger LOGGER = LogManager.getLogger(KnnEfficientFilter.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexName = "hotels-index";

            if (!client.indices().exists(r -> r.index(indexName)).value()) {
                LOGGER.info("Creating index {}", indexName);
                client.indices()
                    .create(
                        r -> r.index(indexName)
                            .settings(s -> s.knn(true).knnAlgoParamEfSearch(100).numberOfShards(1).numberOfReplicas(0))
                            .mappings(
                                m -> m.properties(
                                    "location",
                                    p -> p.knnVector(
                                        k -> k.dimension(2)
                                            .method(
                                                v -> v.name("hnsw")
                                                    .spaceType("l2")
                                                    .engine("lucene")
                                                    .parameters("ef_construction", JsonData.of(100))
                                                    .parameters("m", JsonData.of(16))
                                            )
                                    )
                                )
                            )
                    );
            }

            final var hotels = new Hotel[] {
                new Hotel(5.2f, 4.f, true, 5),
                new Hotel(5.2f, 3.9f, false, 4),
                new Hotel(4.9f, 3.4f, true, 9),
                new Hotel(4.2f, 4.6f, false, 6),
                new Hotel(3.3f, 4.5f, true, 8),
                new Hotel(6.4f, 3.4f, true, 9),
                new Hotel(4.2f, 6.2f, true, 5),
                new Hotel(2.4f, 4.0f, true, 8),
                new Hotel(1.4f, 3.2f, false, 5),
                new Hotel(7.0f, 9.9f, true, 9),
                new Hotel(3.0f, 2.3f, false, 6),
                new Hotel(5.0f, 1.0f, true, 3), };
            var bulkRequest = new BulkRequest.Builder();
            for (var i = 0; i < hotels.length; ++i) {
                final var id = Integer.toString(i + 1);
                final var hotel = hotels[i];
                LOGGER.info("Indexing hotel {} with id {}", hotel, id);
                bulkRequest.operations(b -> b.index(o -> o.index(indexName).id(id).document(hotel)));
            }

            LOGGER.info("Indexing {} documents", hotels.length);
            client.bulk(bulkRequest.build());

            LOGGER.info("Waiting for indexing to finish");
            client.indices().refresh(i -> i.index(indexName));

            final var searchLocationX = 5.0f;
            final var searchLocationY = 4.0f;
            final var searchRatingMin = 8;
            final var searchRatingMax = 10;
            final var searchParking = true;
            LOGGER.info(
                "Searching for hotel near [{}, {}] with rating >={},<={} and parking={}",
                searchLocationX,
                searchLocationY,
                searchRatingMin,
                searchRatingMax,
                searchParking
            );

            var searchResponse = client.search(
                s -> s.index(indexName)
                    .size(3)
                    .query(
                        q -> q.knn(
                            k -> k.field("location")
                                .vector(searchLocationX, searchLocationY)
                                .k(3)
                                .filter(
                                    Query.of(
                                        f -> f.bool(
                                            b -> b.must(
                                                m -> m.range(
                                                    r -> r.field("rating")
                                                        .gte(JsonData.of(searchRatingMin))
                                                        .lte(JsonData.of(searchRatingMax))
                                                )
                                            ).must(m -> m.term(t -> t.field("parking").value(FieldValue.of(searchParking))))
                                        )
                                    )
                                )
                        )
                    ),
                Hotel.class
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

    public static class Hotel {
        private float[] location;
        private boolean parking;
        private int rating;

        public Hotel() {}

        public Hotel(float locX, float locY, boolean parking, int rating) {
            this.location = new float[] { locX, locY };
            this.parking = parking;
            this.rating = rating;
        }

        public float[] getLocation() {
            return location;
        }

        public void setLocation(float[] location) {
            this.location = location;
        }

        public boolean isParking() {
            return parking;
        }

        public void setParking(boolean parking) {
            this.parking = parking;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "{" + "location=" + Arrays.toString(location) + ", parking=" + parking + ", rating=" + rating + '}';
        }
    }
}
