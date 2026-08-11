/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.util.ArrayList;
import java.util.List;
import org.apache.hc.core5.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.HybridTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

/**
 * Demonstrates using gRPC transport for high-performance bulk operations.
 * <p>
 * gRPC provides lower latency and higher throughput for bulk indexing compared to REST.
 * The HybridTransport automatically routes bulk operations over gRPC and everything
 * else (search, index management, etc.) over REST.
 * <p>
 * Prerequisites:
 * - OpenSearch 3.5+ with gRPC transport enabled:
 *   {@code aux.transport.types: [transport-grpc]}
 *   {@code aux.transport.transport-grpc.port: '9400'}
 * <p>
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=GrpcBulk}
 * <p>
 * Environment variables:
 * - HOST: OpenSearch hostname (default: localhost)
 * - PORT: REST port (default: 9200)
 * - GRPC_PORT: gRPC port (default: 9400)
 * - USERNAME: basic auth username (default: admin)
 * - PASSWORD: basic auth password (default: admin)
 * - HTTPS: use TLS (default: true)
 */
public class GrpcBulk {
    private static final Logger LOGGER = LogManager.getLogger(GrpcBulk.class);

    public static void main(String[] args) {
        try {
            var env = System.getenv();
            var hostname = env.getOrDefault("HOST", "localhost");
            var restPort = Integer.parseInt(env.getOrDefault("PORT", "9200"));
            var grpcPort = Integer.parseInt(env.getOrDefault("GRPC_PORT", "9400"));
            var user = env.getOrDefault("USERNAME", "admin");
            var pass = env.getOrDefault("PASSWORD", "admin");
            var https = Boolean.parseBoolean(env.getOrDefault("HTTPS", "false"));

            // ─── Build the HybridTransport ───────────────────────────────────────
            // Bulk → gRPC (port 9400), everything else → REST (port 9200)

            OpenSearchClient client = createClient(hostname, restPort, grpcPort, user, pass, https);

            var version = client.info().version();
            LOGGER.info("Server: {}@{} (REST)", version.distribution(), version.number());

            // ─── Create Index ────────────────────────────────────────────────────

            final var indexName = "grpc-sample";

            if (client.indices().exists(r -> r.index(indexName)).value()) {
                client.indices().delete(r -> r.index(indexName));
            }
            client.indices().create(r -> r.index(indexName));
            LOGGER.info("Created index: {}", indexName);

            // ─── Bulk Index via gRPC ─────────────────────────────────────────────
            // This call is transparently routed over gRPC by HybridTransport

            List<BulkOperation> operations = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                final int docId = i;
                operations.add(
                    new BulkOperation.Builder().index(
                        new IndexOperation.Builder<SampleDoc>().index(indexName)
                            .id(String.valueOf(docId))
                            .document(new SampleDoc("Document " + docId, docId * 1.5, docId % 10))
                            .build()
                    ).build()
                );
            }

            LOGGER.info("Bulk indexing 100 documents over gRPC...");
            BulkResponse bulkResponse = client.bulk(
                new BulkRequest.Builder().index(indexName).operations(operations).refresh(Refresh.True).build()
            );

            LOGGER.info(
                "Bulk response: took={}ms, errors={}, items={}",
                bulkResponse.took(),
                bulkResponse.errors(),
                bulkResponse.items().size()
            );

            if (!bulkResponse.errors()) {
                LOGGER.info("All 100 documents indexed successfully via gRPC!");
            } else {
                for (BulkResponseItem item : bulkResponse.items()) {
                    if (item.error() != null) {
                        LOGGER.error("  Failed: id={}, error={}", item.id(), item.error().reason());
                    }
                }
            }

            // ─── Search via REST ─────────────────────────────────────────────────
            // Search is automatically routed to REST by HybridTransport

            LOGGER.info("Searching via REST...");
            SearchResponse<SampleDoc> searchResponse = client.search(s -> s.index(indexName).size(5), SampleDoc.class);
            LOGGER.info("Search: found {} documents (showing first 5)", searchResponse.hits().total().value());
            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("  {} (score={})", hit.source().name, hit.score());
            }

            // ─── Cleanup ─────────────────────────────────────────────────────────

            client.indices().delete(r -> r.index(indexName));
            LOGGER.info("Deleted index: {}", indexName);

        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage(), e);
        }
    }

    /**
     * Creates an OpenSearchClient with HybridTransport (gRPC + REST).
     */
    private static OpenSearchClient createClient(String hostname, int restPort, int grpcPort, String user, String pass, boolean https)
        throws Exception {

        // 1. REST transport (for search, index management, etc.)
        var hosts = new HttpHost[] { new HttpHost(https ? "https" : "http", hostname, restPort) };
        OpenSearchTransport restTransport = ApacheHttpClient5TransportBuilder.builder(hosts).build();

        // 2. gRPC transport (for bulk operations)
        var grpcBuilder = GrpcTransport.builder(hostname, grpcPort).jsonpMapper(new JacksonJsonpMapper());

        // Configure auth and TLS
        if (https) {
            grpcBuilder.tlsInsecure();  // trust all for local dev (use proper certs in production)
        }
        if (user != null && !user.isEmpty()) {
            grpcBuilder.basicAuth(user, pass);
        }

        GrpcTransport grpcTransport = grpcBuilder.build();

        // 3. Combine into HybridTransport
        HybridTransport hybridTransport = new HybridTransport(grpcTransport, restTransport);

        return new OpenSearchClient(hybridTransport);
    }

    // ─── Sample Document ─────────────────────────────────────────────────────────

    public static class SampleDoc {
        public String name;
        public double score;
        public int category;

        public SampleDoc() {}

        public SampleDoc(String name, double score, int category) {
            this.name = name;
            this.score = score;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }
}
