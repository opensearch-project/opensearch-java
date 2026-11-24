/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.opensearch.core.search.Hit;

/**
 * Integration tests for Search over gRPC transport.
 *
 * Verifies the complete search pipeline:
 * 1. Index documents via gRPC bulk
 * 2. Search with match_all via gRPC
 * 3. Verify response structure and _source deserialization
 *
 * Skips automatically on OpenSearch versions below 3.5.0.
 *
 * Run:
 * ./gradlew integrationTest --tests "org.opensearch.client.opensearch.integTest.grpc.GrpcSearchIT" \
 *   -Dtests.opensearch.version=3.5.0
 */
public class GrpcSearchIT extends AbstractGrpcIT {

    private static final String INDEX = "grpc-search-it";

    // ─── Test Document ───────────────────────────────────────────────────────────

    public static class Movie {
        public String title;
        public int year;
        public String director;

        public Movie() {}

        public Movie(String title, int year, String director) {
            this.title = title;
            this.year = year;
            this.director = director;
        }
    }

    // ─── Tests ───────────────────────────────────────────────────────────────────

    @Test
    public void testMatchAllSearch() throws IOException {
        assumeGrpcSupported();

        try {
            // Setup: create index and index documents via gRPC bulk
            grpcClient().indices().create(c -> c.index(INDEX));

            List<BulkOperation> ops = new ArrayList<>();
            ops.add(
                new BulkOperation.Builder().index(
                    new IndexOperation.Builder<Movie>().index(INDEX)
                        .id("1")
                        .document(new Movie("The Dark Knight", 2008, "Christopher Nolan"))
                        .build()
                ).build()
            );
            ops.add(
                new BulkOperation.Builder().index(
                    new IndexOperation.Builder<Movie>().index(INDEX)
                        .id("2")
                        .document(new Movie("Inception", 2010, "Christopher Nolan"))
                        .build()
                ).build()
            );
            ops.add(
                new BulkOperation.Builder().index(
                    new IndexOperation.Builder<Movie>().index(INDEX)
                        .id("3")
                        .document(new Movie("Interstellar", 2014, "Christopher Nolan"))
                        .build()
                ).build()
            );

            BulkResponse bulkResponse = grpcClient().bulk(
                new BulkRequest.Builder().index(INDEX).operations(ops).refresh(Refresh.True).build()
            );
            assertFalse("Bulk should have no errors", bulkResponse.errors());

            // Search: match_all via gRPC
            SearchResponse<Movie> searchResponse = grpcClient().search(s -> s.index(INDEX).query(q -> q.matchAll(m -> m)), Movie.class);

            // Verify response structure
            assertNotNull("Search response should not be null", searchResponse);
            assertNotNull("Hits should not be null", searchResponse.hits());
            assertNotNull("Total should not be null", searchResponse.hits().total());
            assertEquals("Should find 3 documents", 3L, searchResponse.hits().total().value());
            assertTrue("Took should be >= 0", searchResponse.took() >= 0);
            assertFalse("Should not time out", searchResponse.timedOut());

            // Verify hits
            List<Hit<Movie>> hits = searchResponse.hits().hits();
            assertEquals("Should have 3 hits", 3, hits.size());

            // Verify _source deserialization
            for (Hit<Movie> hit : hits) {
                assertNotNull("Hit should have _index", hit.index());
                assertNotNull("Hit should have _id", hit.id());
                assertNotNull("Hit should have _source", hit.source());
                assertNotNull("Movie should have title", hit.source().title);
                assertTrue("Movie year should be > 0", hit.source().year > 0);
                assertNotNull("Movie should have director", hit.source().director);
            }

        } finally {
            // Cleanup
            grpcClient().indices().delete(d -> d.index(INDEX).ignoreUnavailable(true));
        }
    }

    @Test
    public void testMatchAllWithSizeAndFrom() throws IOException {
        assumeGrpcSupported();

        try {
            // Setup: index 5 documents
            grpcClient().indices().create(c -> c.index(INDEX));

            List<BulkOperation> ops = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                final int id = i;
                ops.add(
                    new BulkOperation.Builder().index(
                        new IndexOperation.Builder<Movie>().index(INDEX)
                            .id(String.valueOf(id))
                            .document(new Movie("Movie " + id, 2000 + id, "Director " + id))
                            .build()
                    ).build()
                );
            }

            grpcClient().bulk(new BulkRequest.Builder().index(INDEX).operations(ops).refresh(Refresh.True).build());

            // Search with size=2
            SearchResponse<Movie> response = grpcClient().search(s -> s.index(INDEX).query(q -> q.matchAll(m -> m)).size(2), Movie.class);

            assertEquals("Total should be 5", 5L, response.hits().total().value());
            assertEquals("Should return 2 hits (size=2)", 2, response.hits().hits().size());

            // Search with from=2, size=2 (pagination)
            SearchResponse<Movie> page2 = grpcClient().search(
                s -> s.index(INDEX).query(q -> q.matchAll(m -> m)).from(2).size(2),
                Movie.class
            );

            assertEquals("Total should still be 5", 5L, page2.hits().total().value());
            assertEquals("Should return 2 hits (page 2)", 2, page2.hits().hits().size());

        } finally {
            grpcClient().indices().delete(d -> d.index(INDEX).ignoreUnavailable(true));
        }
    }

    @Test
    public void testSearchEmptyIndex() throws IOException {
        assumeGrpcSupported();

        try {
            // Create empty index
            grpcClient().indices().create(c -> c.index(INDEX));

            // Search empty index
            SearchResponse<Movie> response = grpcClient().search(s -> s.index(INDEX).query(q -> q.matchAll(m -> m)), Movie.class);

            assertNotNull("Response should not be null", response);
            assertEquals("Should find 0 documents", 0L, response.hits().total().value());
            assertTrue("Hits list should be empty", response.hits().hits().isEmpty());

        } finally {
            grpcClient().indices().delete(d -> d.index(INDEX).ignoreUnavailable(true));
        }
    }
}
