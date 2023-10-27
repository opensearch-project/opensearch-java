/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import static org.opensearch.client.samples.util.CommonUtil.search;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.samples.util.CommonUtil;
import org.opensearch.client.samples.util.IndexData;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=Bulk</c>
 */
public class Bulk {
    private static final Logger LOGGER = LogManager.getLogger(Bulk.class);
    private static OpenSearchClient client;
    private static final String indexName = "my-index";

    public static void main(String[] args) {
        try {
            client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            CommonUtil.createIndex(client, indexName);

            LOGGER.info("Bulk indexing documents");
            ArrayList<BulkOperation> ops = new ArrayList<>();
            IndexData doc1 = new IndexData("Document 1", "The text of document 1");
            ops.add(new BulkOperation.Builder().index(IndexOperation.of(io -> io.index(indexName).id("id1").document(doc1))).build());
            IndexData doc2 = new IndexData("Document 2", "The text of document 2");
            ops.add(new BulkOperation.Builder().index(IndexOperation.of(io -> io.index(indexName).id("id2").document(doc2))).build());
            IndexData doc3 = new IndexData("Document 3", "The text of document 3");
            ops.add(new BulkOperation.Builder().index(IndexOperation.of(io -> io.index(indexName).id("id3").document(doc3))).build());

            BulkRequest.Builder bulkReq = new BulkRequest.Builder().index(indexName).operations(ops).refresh(Refresh.WaitFor);
            BulkResponse bulkResponse = client.bulk(bulkReq.build());
            LOGGER.info("Bulk response items: {}", bulkResponse.items().size());

            // wait for the changes to reflect
            Thread.sleep(3000);
            LOGGER.info("Search & bulk update documents");

            SearchResponse<IndexData> searchResponse = search(client, indexName, "title", "Document");
            LOGGER.info("Found {} documents", searchResponse.hits().hits().size());

            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {} and id {}", hit.source(), hit.score(), hit.id());
                IndexData finalSearchedData = hit.source();
                finalSearchedData.setText("Updated document");
                BulkRequest request = new BulkRequest.Builder().operations(
                    o -> o.update(u -> u.index(indexName).id(hit.id()).document(finalSearchedData))
                ).build();
                bulkResponse = client.bulk(request);
                LOGGER.info("Bulk update response items: {}", bulkResponse.items().size());
            }
            // wait for the changes to reflect
            Thread.sleep(3000);
            searchResponse = search(client, indexName, "title", "Document");

            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {} and id {}", hit.source(), hit.score(), hit.id());
            }
            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
