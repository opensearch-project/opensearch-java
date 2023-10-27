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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.mapping.IntegerNumberProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.samples.util.IndexData;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=Bulk</c>
 */
public class Bulk {
    private static final Logger LOGGER = LogManager.getLogger(Bulk.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexName = "my-index";

            if (!client.indices().exists(r -> r.index(indexName)).value()) {
                LOGGER.info("Creating index {}", indexName);
                IndexSettings settings = new IndexSettings.Builder().numberOfShards("2").numberOfReplicas("1").build();
                TypeMapping mapping = new TypeMapping.Builder().properties(
                    "age",
                    new Property.Builder().integer(new IntegerNumberProperty.Builder().build()).build()
                ).build();
                CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName)
                    .settings(settings)
                    .mappings(mapping)
                    .build();
                client.indices().create(createIndexRequest);
            }

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

            Query query = Query.of(qb -> qb.match(mb -> mb.field("title").query(fv -> fv.stringValue("document"))));
            final SearchRequest.Builder searchReq = new SearchRequest.Builder().allowPartialSearchResults(false)
                .index(List.of(indexName))
                .size(10)
                .ignoreThrottled(false)
                .query(query);

            SearchResponse<IndexData> searchResponse = client.search(searchReq.build(), IndexData.class);
            LOGGER.info("Found {} documents", searchResponse.hits().hits().size());

            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {} and id {}", hit.source(), hit.score(), hit.id());
            }

            LOGGER.info("Bulk update document");
            doc1.setText("Updated Document");
            BulkRequest request = new BulkRequest.Builder().operations(o -> o.update(u -> u.index(indexName).id("id1").document(doc1)))
                .refresh(Refresh.WaitFor)
                .build();
            bulkResponse = client.bulk(request);
            LOGGER.info("Bulk update response items: {}", bulkResponse.items().size());

            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
