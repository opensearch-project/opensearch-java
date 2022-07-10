/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import org.junit.Test;
import org.locationtech.jts.util.Assert;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.OpType;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.SearchResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
        addDoc(client, "id1", doc1, false);
        SimplePojo doc2 = new SimplePojo("Document 2", "The text of document 2");
        addDoc(client, "id2", doc2, false);
        SimplePojo doc3 = getLongDoc("Long Document 3", 1000000);
        addDoc(client, "id3", doc3, true);

        SearchResponse<SimplePojo> response = query(client, "NotPresent", null);
        Assert.equals(0, response.hits().hits().size());

        response = query(client, "Document", null);
        Assert.equals(3, response.hits().hits().size());

        response = query(client, "1", null);
        Assert.equals(1, response.hits().hits().size());
        Assert.equals(doc1, response.hits().hits().get(0).source());

        response = query(client, null, "wait");
        Assert.equals(1, response.hits().hits().size());
        Assert.equals(doc3, response.hits().hits().get(0).source());
    }

    void testClientAsync(boolean async) throws Exception {
        resetTestIndex(async);
        final OpenSearchAsyncClient client = getAsyncClient(async, null, null);

        SimplePojo doc1 = new SimplePojo("Document 1", "The text of document 1");
        CompletableFuture<IndexResponse> add1 = addDoc(client, "id1", doc1, false);
        SimplePojo doc2 = new SimplePojo("Document 2", "The text of document 2");
        CompletableFuture<IndexResponse> add2 = addDoc(client, "id2", doc2, false);
        SimplePojo doc3 = getLongDoc("Long Document 3", 1000000);
        CompletableFuture<IndexResponse> add3 = CompletableFuture.allOf(add1, add2).thenCompose(
                unused -> addDoc(client, "id3", doc3, true));

        List<SearchResponse<SimplePojo>> results = add3.thenCompose(unused -> {
            CompletableFuture<SearchResponse<SimplePojo>> r1 = query(client, "NotPresent", null);
            CompletableFuture<SearchResponse<SimplePojo>> r2 = query(client, "Document", null);
            CompletableFuture<SearchResponse<SimplePojo>> r3 = query(client, "1", null);
            return CompletableFuture.allOf(r1, r2, r3).thenApply(u2 -> List.of(
                    r1.getNow(null),
                    r2.getNow(null),
                    r3.getNow(null))
            );
        }).get();

        SearchResponse<SimplePojo> response = results.get(0);
        Assert.equals(0, response.hits().hits().size());

        response = results.get(1);
        Assert.equals(3, response.hits().hits().size());

        response = results.get(2);
        Assert.equals(1, response.hits().hits().size());
        Assert.equals(doc1, response.hits().hits().get(0).source());
    }


    private void addDoc(OpenSearchClient client, String id, SimplePojo doc, boolean wait) throws Exception {
        IndexRequest.Builder<SimplePojo> req = new IndexRequest.Builder<SimplePojo>()
                .index(TEST_INDEX)
                .document(doc)
                .id(id)
                .opType(OpType.Index);
        if (wait) {
            req.refresh(Refresh.WaitFor);
        }
        client.index(req.build());
    }

    private CompletableFuture<IndexResponse> addDoc(
            OpenSearchAsyncClient client, String id, SimplePojo doc, boolean wait
    ) {
        IndexRequest.Builder<SimplePojo> req = new IndexRequest.Builder<SimplePojo>()
                .index(TEST_INDEX)
                .document(doc)
                .id(id)
                .opType(OpType.Index);
        if (wait) {
            req.refresh(Refresh.WaitFor);
        }
        try {
            return client.index(req.build());
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
}
