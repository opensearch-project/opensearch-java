/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.aws;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;

public class AwsSdk2BulkRequestIT extends AwsSdk2TransportTestCase {

    @Test
    public void testBulkRequest() throws Exception {
        resetTestIndex(false);
        final OpenSearchClient client = getClient(false, null, null);

        ArrayList<BulkOperation> ops = new ArrayList<>();
        SimplePojo doc1 = new SimplePojo("Document 1", "The text of document 1");
        ops.add(new BulkOperation.Builder().index(IndexOperation.of(io -> io.index(TEST_INDEX).id("id1").document(doc1))).build());
        SimplePojo doc2 = new SimplePojo("Document 2", "The text of document 2");
        ops.add(new BulkOperation.Builder().index(IndexOperation.of(io -> io.index(TEST_INDEX).id("id2").document(doc2))).build());
        SimplePojo doc3 = getLongDoc("Long Document 3", 100000);
        ops.add(new BulkOperation.Builder().index(IndexOperation.of(io -> io.index(TEST_INDEX).id("id3").document(doc3))).build());

        BulkRequest.Builder bulkReq = new BulkRequest.Builder().index(TEST_INDEX).operations(ops).refresh(Refresh.WaitFor);
        BulkResponse bulkResponse = client.bulk(bulkReq.build());
        Assert.assertEquals(3, bulkResponse.items().size());

        Query query = Query.of(qb -> qb.match(mb -> mb.field("title").query(fv -> fv.stringValue("Document"))));
        final SearchRequest.Builder searchReq = new SearchRequest.Builder().allowPartialSearchResults(false)
            .index(Collections.singletonList(TEST_INDEX))
            .size(10)
            .source(sc -> sc.fetch(false))
            .ignoreThrottled(false)
            .query(query);
        SearchResponse<SimplePojo> searchResponse = client.search(searchReq.build(), SimplePojo.class);
        Assert.assertEquals(3, searchResponse.hits().hits().size());
    }
}
