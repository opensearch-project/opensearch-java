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
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.HybridTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

public class GrpcDemo {

    static final String REST_HOST = "localhost";
    static final int REST_PORT = 9200;
    static final int GRPC_PORT = 9400;
    static final String INDEX = "grpc-demo-products";
    static final int NUM_DOCS = 500;

    public static void main(String[] args) throws Exception {
        System.out.println("\n🎬 OpenSearch gRPC Demo — Java Client");
        System.out.println("   Cluster: localhost:9200 (REST) + localhost:9400 (gRPC)");
        System.out.println("   Documents: " + NUM_DOCS + "\n");

        long restTime = demoRestBulk();
        long grpcTime = demoGrpcBulk();
        demoRouting();

        // Summary
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  SUMMARY");
        System.out.println("=".repeat(60));
        System.out.printf("  REST bulk:  %dms%n", restTime);
        System.out.printf("  gRPC bulk:  %dms%n", grpcTime);
        if (grpcTime < restTime) {
            double speedup = ((double) (restTime - grpcTime) / restTime) * 100;
            System.out.printf("  Speedup:    %.1f%% faster with gRPC%n", speedup);
        }
        System.out.println("\n  Key takeaway: Same client API, zero code migration,");
        System.out.println("  REST routing for unsupported operations.\n");
    }

    // ─── Demo 1: REST Bulk (baseline) ────────────────────────────────────────

    static long demoRestBulk() throws Exception {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  DEMO 1: Bulk Indexing via REST");
        System.out.println("=".repeat(60));

        var restTransport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("http", REST_HOST, REST_PORT)).build();
        var client = new OpenSearchClient(restTransport);

        List<BulkOperation> ops = buildBulkOps();

        long start = System.currentTimeMillis();
        BulkResponse response = client.bulk(new BulkRequest.Builder().index(INDEX).operations(ops).refresh(Refresh.True).build());
        long elapsed = System.currentTimeMillis() - start;

        System.out.printf("  ✅ Indexed %d documents via REST%n", NUM_DOCS);
        System.out.printf("  ⏱  Time: %dms%n", elapsed);
        System.out.printf("  📊 Errors: %s%n", response.errors());
        System.out.printf("  📊 Took (server): %dms%n", response.took());

        client.indices().delete(d -> d.index(INDEX));
        restTransport.close();
        return elapsed;
    }

    // ─── Demo 2: gRPC Bulk (transparent) ─────────────────────────────────────

    static long demoGrpcBulk() throws Exception {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  DEMO 2: Bulk Indexing via gRPC (transparent)");
        System.out.println("=".repeat(60));

        // REST transport for unsupported operations
        var restTransport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("http", REST_HOST, REST_PORT)).build();

        // gRPC transport for bulk
        var grpcTransport = GrpcTransport.builder(REST_HOST, GRPC_PORT).jsonpMapper(new JacksonJsonpMapper()).build();

        // Combine — bulk → gRPC, everything else → REST
        var hybridTransport = new HybridTransport(grpcTransport, restTransport);
        var client = new OpenSearchClient(hybridTransport);

        List<BulkOperation> ops = buildBulkOps();

        // Show what the client sends
        System.out.println();
        System.out.printf("  📤 CLIENT REQUEST (first 2 operations):%n");
        System.out.printf("     Action: POST /_bulk (routed to gRPC on port %d)%n", GRPC_PORT);
        System.out.printf("     Operations: %d index operations%n", NUM_DOCS);
        System.out.println("     Sample:");
        System.out.printf("       {\"index\": {\"_index\": \"%s\", \"_id\": \"0\"}}%n", INDEX);
        System.out.println("       {\"name\": \"Product 0\", \"price\": 9.99, \"category\": \"electronics\", \"inStock\": true}");
        System.out.printf("       {\"index\": {\"_index\": \"%s\", \"_id\": \"1\"}}%n", INDEX);
        System.out.println("       {\"name\": \"Product 1\", \"price\": 10.49, \"category\": \"clothing\", \"inStock\": true}");
        System.out.printf("       ... (%d more operations)%n", NUM_DOCS - 2);
        System.out.println();
        System.out.println("  ⚙️  INTERNAL CONVERSION (transparent to user):");
        System.out.println("     BulkRequest (Java API) → BulkRequestConverter → protobuf BulkRequest");
        System.out.println("     → gRPC channel (HTTP/2, binary) → OpenSearch server:" + GRPC_PORT);
        System.out.println();

        long start = System.currentTimeMillis();
        BulkResponse response = client.bulk(new BulkRequest.Builder().index(INDEX).operations(ops).refresh(Refresh.True).build());
        long elapsed = System.currentTimeMillis() - start;

        // Show the response as the client receives it
        System.out.println("  📥 SERVER RESPONSE (as client sees it — same format as REST):");
        System.out.println("     {");
        System.out.printf("       \"took\": %d,%n", response.took());
        System.out.printf("       \"errors\": %s,%n", response.errors());
        System.out.println("       \"items\": [");
        // Show first 3 items
        var items = response.items();
        for (int i = 0; i < Math.min(3, items.size()); i++) {
            var item = items.get(i);
            System.out.printf("         {\"%s\": {%n", item.operationType().jsonValue());
            System.out.printf("           \"_index\": \"%s\",%n", item.index());
            System.out.printf("           \"_id\": \"%s\",%n", item.id());
            System.out.printf("           \"result\": \"%s\",%n", item.result());
            System.out.printf("           \"status\": %d,%n", item.status());
            if (item.version() != null) System.out.printf("           \"_version\": %d,%n", item.version());
            if (item.seqNo() != null) System.out.printf("           \"_seq_no\": %d,%n", item.seqNo());
            if (item.primaryTerm() != null) System.out.printf("           \"_primary_term\": %d,%n", item.primaryTerm());
            if (item.shards() != null) System.out.printf(
                "           \"_shards\": {\"total\": %d, \"successful\": %d, \"failed\": %d}%n",
                item.shards().total(),
                item.shards().successful(),
                item.shards().failed()
            );
            System.out.printf("         }}%s%n", i < 2 ? "," : "");
        }
        System.out.printf("         ... (%d more items)%n", NUM_DOCS - 3);
        System.out.println("       ]");
        System.out.println("     }");
        System.out.println();
        System.out.printf("  ✅ Indexed %d documents via gRPC%n", NUM_DOCS);
        System.out.printf("  ⏱  Time: %dms%n", elapsed);
        System.out.printf("  📊 Took (server): %dms%n", response.took());

        // Search goes via REST automatically
        SearchResponse<Product> search = client.search(s -> s.index(INDEX).size(3), Product.class);
        System.out.printf("  🔍 Search (via REST): found %d docs%n", search.hits().total().value());

        client.indices().delete(d -> d.index(INDEX));
        hybridTransport.close();
        return elapsed;
    }

    // ─── Demo 3: Fallback ────────────────────────────────────────────────────

    static void demoRouting() throws Exception {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  DEMO 3: REST routing — unsupported ops go to REST");
        System.out.println("=".repeat(60));

        var restTransport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("http", REST_HOST, REST_PORT)).build();

        var grpcTransport = GrpcTransport.builder(REST_HOST, GRPC_PORT).jsonpMapper(new JacksonJsonpMapper()).build();

        var hybridTransport = new HybridTransport(grpcTransport, restTransport);
        var client = new OpenSearchClient(hybridTransport);

        // Search is not supported by gRPC — routed to REST automatically
        System.out.println("  📤 client.search() → not in gRPC registry → REST");
        var info = client.info();
        System.out.printf("  ✅ info() via REST: %s %s%n", info.version().distribution(), info.version().number());

        // Index create/delete also goes to REST
        System.out.println("  📤 client.indices().create() → REST");
        client.indices().create(c -> c.index(INDEX + "-routing"));
        System.out.println("  ✅ Index created via REST");

        client.indices().delete(d -> d.index(INDEX + "-routing"));
        System.out.println("  ✅ Index deleted via REST");
        System.out.println();
        System.out.println("  💡 HybridTransport routes by endpoint:");
        System.out.println("     bulk()   → gRPC (supported)");
        System.out.println("     search() → REST (not yet supported by gRPC)");
        System.out.println("     info()   → REST (not yet supported by gRPC)");

        hybridTransport.close();
    }

    // ─── Helpers ─────────────────────────────────────────────────────────────

    static List<BulkOperation> buildBulkOps() {
        String[] categories = { "electronics", "clothing", "home", "sports" };
        List<BulkOperation> ops = new ArrayList<>();
        for (int i = 0; i < NUM_DOCS; i++) {
            final int id = i;
            ops.add(
                new BulkOperation.Builder().index(
                    new IndexOperation.Builder<Product>().index(INDEX)
                        .id(String.valueOf(id))
                        .document(new Product("Product " + id, 9.99 + id * 0.5, categories[id % 4], id % 3 != 0))
                        .build()
                ).build()
            );
        }
        return ops;
    }

    public static class Product {
        public String name;
        public double price;
        public String category;
        public boolean inStock;

        public Product() {}

        public Product(String name, double price, String category, boolean inStock) {
            this.name = name;
            this.price = price;
            this.category = category;
            this.inStock = inStock;
        }

        public String getName() {
            return name;
        }

        public void setName(String n) {
            name = n;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double p) {
            price = p;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String c) {
            category = c;
        }

        public boolean isInStock() {
            return inStock;
        }

        public void setInStock(boolean s) {
            inStock = s;
        }
    }
}
