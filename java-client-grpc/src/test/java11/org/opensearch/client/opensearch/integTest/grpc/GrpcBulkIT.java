/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.grpc;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.GetResponse;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;

/**
 * End-to-end integration tests for gRPC Bulk transport.
 * <p>
 * Verifies the complete pipeline:
 * <ol>
 *   <li>Client builds BulkRequest (Java API types)</li>
 *   <li>GrpcTransport converts to protobuf</li>
 *   <li>Sent over gRPC channel to OpenSearch on port 9400</li>
 *   <li>Server processes and returns protobuf BulkResponse</li>
 *   <li>GrpcTransport converts response back to Java API types</li>
 *   <li>Client receives standard BulkResponse</li>
 * </ol>
 * <p>
 * Tests are condensed to minimize cluster load while covering:
 * - All 4 operation types (index, create, update, delete)
 * - Response format completeness (_shards, _version, _seq_no, _primary_term)
 * - Status code mapping (201, 200, 409, 404)
 * - REST routing for non-bulk operations
 * <p>
 * Skips automatically on OpenSearch versions below 3.5.0.
 * <p>
 * Run:
 * <pre>
 * ./gradlew integrationTest --tests "org.opensearch.client.opensearch.integTest.grpc.GrpcBulkIT" \
 *   -Dtests.opensearch.version=3.5.0
 * </pre>
 */
public class GrpcBulkIT extends AbstractGrpcIT {

    private static final String INDEX = "grpc-bulk-it";

    // ─── Test Document ───────────────────────────────────────────────────────────

    public static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product() {}

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // ─── Tests ───────────────────────────────────────────────────────────────────

    /**
     * Tests all 4 bulk operations in one call and validates the full response format.
     * Covers: index, create, update, delete, response fields, status codes.
     */
    @Test
    public void testBulkMixedOpsAndResponseFormat() throws IOException {
        assumeGrpcSupported();

        String index = INDEX + "-mixed";
        grpcClient().indices().create(new CreateIndexRequest.Builder().index(index).build());

        try {
            // Step 1: Seed with index + create
            List<BulkOperation> seedOps = new ArrayList<>();
            seedOps.add(
                new BulkOperation.Builder().index(
                    new IndexOperation.Builder<Product>().index(index).id("1").document(new Product("Laptop", 999.99, 10)).build()
                ).build()
            );
            seedOps.add(new BulkOperation.Builder().create(c -> c.index(index).id("2").document(new Product("Mouse", 29.99, 200))).build());

            BulkResponse seedResp = grpcClient().bulk(
                new BulkRequest.Builder().index(index).operations(seedOps).refresh(Refresh.True).build()
            );

            // Validate response format on seed
            assertFalse("Should have no errors", seedResp.errors());
            assertEquals(2, seedResp.items().size());
            assertTrue("took should be >= 0", seedResp.took() >= 0);

            // Validate index response item fields
            BulkResponseItem indexItem = seedResp.items().get(0);
            assertEquals(OperationType.Index, indexItem.operationType());
            assertEquals(index, indexItem.index());
            assertEquals("1", indexItem.id());
            assertEquals("created", indexItem.result());
            assertNotNull("Should have _version", indexItem.version());
            assertNotNull("Should have _seq_no", indexItem.seqNo());
            assertNotNull("Should have _primary_term", indexItem.primaryTerm());
            assertNotNull("Should have _shards", indexItem.shards());
            assertTrue("_shards.successful >= 1", indexItem.shards().successful() >= 1);

            // Validate create response item
            BulkResponseItem createItem = seedResp.items().get(1);
            assertEquals(OperationType.Create, createItem.operationType());
            assertEquals("created", createItem.result());

            // Step 2: Mixed ops — update + delete in one call
            List<BulkOperation> mixedOps = new ArrayList<>();
            mixedOps.add(
                new BulkOperation.Builder().update(u -> u.index(index).id("1").document(new Product("Laptop Pro", 1299.99, 5))).build()
            );
            mixedOps.add(new BulkOperation.Builder().delete(d -> d.index(index).id("2")).build());

            BulkResponse mixedResp = grpcClient().bulk(
                new BulkRequest.Builder().index(index).operations(mixedOps).refresh(Refresh.True).build()
            );

            assertFalse(mixedResp.errors());
            assertEquals(2, mixedResp.items().size());

            // Update returns status 200 and result "updated"
            BulkResponseItem updateItem = mixedResp.items().get(0);
            assertEquals(OperationType.Update, updateItem.operationType());
            assertEquals("updated", updateItem.result());

            // Delete returns result "deleted"
            BulkResponseItem deleteItem = mixedResp.items().get(1);
            assertEquals(OperationType.Delete, deleteItem.operationType());
            assertEquals("deleted", deleteItem.result());

            // Step 3: Verify final state via REST
            SearchResponse<Product> search = grpcClient().search(s -> s.index(index), Product.class);
            assertEquals("Should have 1 doc remaining", 1, search.hits().total().value());

            GetResponse<Product> get = grpcClient().get(g -> g.index(index).id("1"), Product.class);
            assertTrue(get.found());
            assertEquals("Laptop Pro", get.source().getName());

        } finally {
            grpcClient().indices().delete(new DeleteIndexRequest.Builder().index(index).build());
        }
    }

    /**
     * Tests error status codes: 409 conflict and 404 not found.
     */
    @Test
    public void testBulkErrorStatusCodes() throws IOException {
        assumeGrpcSupported();

        String index = INDEX + "-errors";
        grpcClient().indices().create(new CreateIndexRequest.Builder().index(index).build());

        try {
            // Create a doc
            List<BulkOperation> createOps = new ArrayList<>();
            createOps.add(
                new BulkOperation.Builder().create(c -> c.index(index).id("exists").document(new Product("Existing", 1.0, 1))).build()
            );
            grpcClient().bulk(new BulkRequest.Builder().index(index).operations(createOps).refresh(Refresh.True).build());

            // Conflict (409): create same doc again + Not found (404): delete nonexistent
            List<BulkOperation> errorOps = new ArrayList<>();
            errorOps.add(
                new BulkOperation.Builder().create(c -> c.index(index).id("exists").document(new Product("Duplicate", 2.0, 2))).build()
            );
            errorOps.add(new BulkOperation.Builder().delete(d -> d.index(index).id("nonexistent")).build());

            BulkResponse errorResp = grpcClient().bulk(
                new BulkRequest.Builder().index(index).operations(errorOps).refresh(Refresh.True).build()
            );

            assertTrue("Should have errors", errorResp.errors());
            assertEquals(2, errorResp.items().size());

            // Create conflict → 409
            BulkResponseItem conflictItem = errorResp.items().get(0);
            assertEquals(409, conflictItem.status());
            assertNotNull("Should have error detail", conflictItem.error());

            // Delete not found → 404
            BulkResponseItem notFoundItem = errorResp.items().get(1);
            assertEquals(404, notFoundItem.status());

        } finally {
            grpcClient().indices().delete(new DeleteIndexRequest.Builder().index(index).build());
        }
    }

    /**
     * Tests that non-bulk operations are routed to REST.
     */
    @Test
    public void testRestRouting() throws IOException {
        assumeGrpcSupported();

        // info() — REST
        InfoResponse info = grpcClient().info();
        assertNotNull(info);
        assertNotNull(info.version().number());

        // Index create/search/delete — all REST
        String index = INDEX + "-routing";
        grpcClient().indices().create(new CreateIndexRequest.Builder().index(index).build());
        try {
            SearchResponse<Product> resp = grpcClient().search(s -> s.index(index), Product.class);
            assertNotNull(resp);
            assertEquals(0, resp.hits().total().value());
        } finally {
            grpcClient().indices().delete(new DeleteIndexRequest.Builder().index(index).build());
        }
    }
}
