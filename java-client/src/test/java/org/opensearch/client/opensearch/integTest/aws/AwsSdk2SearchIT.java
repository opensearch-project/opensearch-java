/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.OpenSearchIndicesClient;

public class AwsSdk2SearchIT extends AwsSdk2TransportTestCase {

    @Test
    public void testSyncClient() throws Exception {
        testClient(false);
    }

    @Test
    public void testAsyncClient() throws Exception {
        testClient(true);
    }

    @Test
    public void testSyncAsyncClient() throws Exception {
        testClientAsync(false);
    }

    @Test
    public void testAsyncAsyncClient() throws Exception {
        testClientAsync(true);
    }

    void testClient(boolean async) throws Exception {
        resetTestIndex(async);
        final OpenSearchClient client = getClient(async, null, null);

        SimplePojo doc1 = new SimplePojo("Document 1", "The text of document 1");
        addDoc(client, "id1", doc1);
        SimplePojo doc2 = new SimplePojo("Document 2", "The text of document 2");
        addDoc(client, "id2", doc2);
        SimplePojo doc3 = getLongDoc("Long Document 3", 1000000);
        addDoc(client, "id3", doc3);

        // wait for the document to index
        Thread.sleep(1000);

        SearchResponse<SimplePojo> response = query(client, "NotPresent", null);
        Assert.assertEquals(0, response.hits().hits().size());

        response = query(client, "Document", null);
        Assert.assertEquals(3, response.hits().hits().size());

        response = query(client, "1", null);
        Assert.assertEquals(1, response.hits().hits().size());
        Assert.assertEquals(doc1, response.hits().hits().get(0).source());

        response = query(client, null, "wait");
        Assert.assertEquals(1, response.hits().hits().size());
        Assert.assertEquals(doc3, response.hits().hits().get(0).source());
    }

    void testClientAsync(boolean async) throws Exception {
        resetTestIndex(async);
        final OpenSearchAsyncClient client = getAsyncClient(async, null, null);

        SimplePojo doc1 = new SimplePojo("Document 1", "The text of document 1");
        CompletableFuture<IndexResponse> add1 = addDoc(client, "id1", doc1);
        SimplePojo doc2 = new SimplePojo("Document 2", "The text of document 2");
        CompletableFuture<IndexResponse> add2 = addDoc(client, "id2", doc2);
        SimplePojo doc3 = getLongDoc("Long Document 3", 1000000);
        CompletableFuture<IndexResponse> add3 = CompletableFuture.allOf(add1, add2).thenCompose(unused -> addDoc(client, "id3", doc3));

        // wait for the document to index
        Thread.sleep(1000);

        List<SearchResponse<SimplePojo>> results = add3.thenCompose(unused -> {
            CompletableFuture<SearchResponse<SimplePojo>> r1 = query(client, "NotPresent", null);
            CompletableFuture<SearchResponse<SimplePojo>> r2 = query(client, "Document", null);
            CompletableFuture<SearchResponse<SimplePojo>> r3 = query(client, "1", null);
            return CompletableFuture.allOf(r1, r2, r3).thenApply(u2 -> List.of(r1.getNow(null), r2.getNow(null), r3.getNow(null)));
        }).get();

        SearchResponse<SimplePojo> response = results.get(0);
        Assert.assertEquals(0, response.hits().hits().size());

        response = results.get(1);
        Assert.assertEquals(3, response.hits().hits().size());

        response = results.get(2);
        Assert.assertEquals(1, response.hits().hits().size());
        Assert.assertEquals(doc1, response.hits().hits().get(0).source());
    }

    private void addDoc(OpenSearchClient client, String id, SimplePojo doc) throws Exception {
        IndexRequest.Builder<SimplePojo> req = new IndexRequest.Builder<SimplePojo>().index(TEST_INDEX).document(doc).id(id);
        client.index(req.build());
    }

    private CompletableFuture<IndexResponse> addDoc(OpenSearchAsyncClient client, String id, SimplePojo doc) {
        IndexRequest.Builder<SimplePojo> req = new IndexRequest.Builder<SimplePojo>().index(TEST_INDEX).document(doc).id(id);
        try {
            return client.index(req.build());
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }

    @Test
    public void testDoubleWrappedException() throws Exception {
        // ensure the test index exists
        resetTestIndex(false);
        // attempt to create the same index a second time
        OpenSearchIndicesClient client = getIndexesClient(false, null, null);
        var req = new CreateIndexRequest.Builder().index(TEST_INDEX);
        Exception exception = Assert.assertThrows(OpenSearchException.class, () -> { client.create(req.build()); });
        // error message contains the actual error, not a generic [http_exception]
        Assert.assertTrue(exception.getMessage().contains("[resource_already_exists_exception]"));
    }
}
