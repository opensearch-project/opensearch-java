/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.util.Arrays;
import java.util.List;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.arrow.ArrowSearchResponse;
import org.opensearch.client.opensearch.arrow.OpenSearchArrowClient;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.transport.grpc.GrpcTlsConfig;
import org.opensearch.client.transport.grpc.GrpcTransport;

/**
 * Streams the doc values of every document matching a search as Arrow record batches, over the gRPC search service.
 * <p>
 * Prerequisites:
 * - OpenSearch with {@code transport-grpc} (or {@code secure-transport-grpc}) and the {@code arrow-search} plugin
 * - an index with doc-values fields
 * <p>
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=GrpcArrowSearch}
 * <p>
 * Environment variables:
 * - GRPC_HOST: gRPC host (default: localhost)
 * - GRPC_PORT: gRPC port (default: 9400)
 * - OPENSEARCH_INDEX: index to search (default: logs)
 * - ARROW_FIELDS: comma-separated doc-values fields or patterns, in column order (default: *)
 * - OPENSEARCH_CA: CA certificate (PEM) of a secured cluster; enables TLS
 * - OPENSEARCH_USER, OPENSEARCH_PASSWORD: basic auth for a cluster with the security plugin
 */
public class GrpcArrowSearch {
    private static final Logger LOGGER = LogManager.getLogger(GrpcArrowSearch.class);

    public static void main(String[] args) {
        try {
            var env = System.getenv();
            var host = env.getOrDefault("GRPC_HOST", "localhost");
            var port = Integer.parseInt(env.getOrDefault("GRPC_PORT", "9400"));
            var index = env.getOrDefault("OPENSEARCH_INDEX", "logs");
            List<String> fields = Arrays.stream(env.getOrDefault("ARROW_FIELDS", "*").split(",")).map(String::trim).toList();

            // ─── The same gRPC transport, TLS and auth as unary gRPC search ──────

            var builder = GrpcTransport.builder(host, port).jsonpMapper(new JacksonJsonpMapper());
            if (env.containsKey("OPENSEARCH_CA")) {
                builder.tls(GrpcTlsConfig.builder().trustCertificatePath(env.get("OPENSEARCH_CA")).build());
            }
            if (env.containsKey("OPENSEARCH_USER")) {
                builder.basicAuth(env.get("OPENSEARCH_USER"), env.getOrDefault("OPENSEARCH_PASSWORD", ""));
            }

            try (GrpcTransport transport = builder.build(); BufferAllocator allocator = new RootAllocator()) {
                OpenSearchArrowClient arrow = new OpenSearchArrowClient(transport, allocator);

                // ─── Stream the matches: a schema, then batches ──────────────────

                long rows = 0;
                int batches = 0;
                try (ArrowSearchResponse response = arrow.search(s -> {
                    s.index(index);
                    fields.forEach(field -> s.docvalueFields(f -> f.field(field)));
                    return s;
                })) {
                    VectorSchemaRoot root = response.getVectorSchemaRoot();
                    LOGGER.info("Columns: {}", root.getSchema());
                    while (response.loadNextBatch()) {
                        if (batches == 0) {
                            try (VectorSchemaRoot head = root.slice(0, Math.min(5, root.getRowCount()))) {
                                LOGGER.info("First rows:\n{}", head.contentToTSVString());
                            }
                        }
                        batches++;
                        rows += root.getRowCount();
                    }

                    // ─── The summary, as a regular search response ───────────────

                    SearchResponse<Void> summary = response.summary();
                    LOGGER.info(
                        "Streamed {} rows in {} batches ({} bytes); total hits {}, shards {}/{}, took {}ms",
                        rows,
                        batches,
                        response.bytesRead(),
                        summary.hits().total().value(),
                        summary.shards().successful(),
                        summary.shards().total(),
                        summary.took()
                    );
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage(), e);
        }
    }
}
