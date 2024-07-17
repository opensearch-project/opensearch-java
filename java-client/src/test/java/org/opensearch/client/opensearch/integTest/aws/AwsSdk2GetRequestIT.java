/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import java.util.concurrent.CompletableFuture;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.*;

public class AwsSdk2GetRequestIT extends AwsSdk2TransportTestCase {
    @Test
    public void testSyncGetRequest() throws Exception {
        resetTestIndex(false);
        final OpenSearchClient client = getClient(false, null, null);

        SimplePojo doc1 = new SimplePojo("Document 1", "The text of document 1");
        addDoc(client, "id1", doc1);

        Thread.sleep(1000);

        GetRequest doc1Request = new GetRequest.Builder().index(TEST_INDEX).id("id1").build();
        GetResponse<SimplePojo> doc1Response = client.get(doc1Request, SimplePojo.class);
        Assert.assertTrue(doc1Response.found());

        GetRequest doc2Request = new GetRequest.Builder().index(TEST_INDEX).id("does-not-exist").build();
        GetResponse<SimplePojo> doc2Response = client.get(doc2Request, SimplePojo.class);
        Assert.assertFalse(doc2Response.found());
    }

    @Test
    public void testAsyncGetRequest() throws Exception {
        resetTestIndex(false);
        final OpenSearchAsyncClient client = getAsyncClient(false, null, null);

        SimplePojo doc1 = new SimplePojo("Document 1", "The text of document 1");
        addDoc(client, "id1", doc1).join();

        Thread.sleep(1000);

        GetRequest doc1Request = new GetRequest.Builder().index(TEST_INDEX).id("id1").build();
        CompletableFuture<GetResponse<SimplePojo>> doc1ResponseFuture = client.get(doc1Request, SimplePojo.class);

        GetRequest doc2Request = new GetRequest.Builder().index(TEST_INDEX).id("does-not-exist").build();
        CompletableFuture<GetResponse<SimplePojo>> doc2ResponseFuture = client.get(doc2Request, SimplePojo.class);

        Assert.assertTrue(doc1ResponseFuture.join().found());
        Assert.assertFalse(doc2ResponseFuture.join().found());
    }
}
