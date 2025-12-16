/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch._helpers.bulk.BulkIngester;
import org.opensearch.client.opensearch._types.mapping.IntegerNumberProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.samples.util.IndexData;

/**
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=BulkIngesterBasics}
 */
public class BulkIngesterBasics {
    private static final Logger LOGGER = LogManager.getLogger(BulkIngesterBasics.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexName = "my-index";

            if (!client.indices().exists(r -> r.index(indexName)).value()) {
                LOGGER.info("Creating index {}", indexName);
                IndexSettings settings = new IndexSettings.Builder().numberOfShards(2).numberOfReplicas(1).build();
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

            LOGGER.info("Bulk indexing documents using BulkIngester");

            // Create BulkIngester with custom settings
            BulkIngester<Void> ingester = BulkIngester.of(b -> b.client(client).maxOperations(100).flushInterval(1, TimeUnit.SECONDS));

            // Add index operations - they are automatically buffered and flushed
            IndexData doc1 = new IndexData("Document 1", "The text of document 1");
            ingester.add(op -> op.index(i -> i.index(indexName).id("id1").document(doc1)));

            IndexData doc2 = new IndexData("Document 2", "The text of document 2");
            ingester.add(op -> op.index(i -> i.index(indexName).id("id2").document(doc2)));

            IndexData doc3 = new IndexData("Document 3", "The text of document 3");
            ingester.add(op -> op.index(i -> i.index(indexName).id("id3").document(doc3)));

            // Close the ingester to flush remaining operations and wait for completion
            ingester.close();
            LOGGER.info("Bulk indexing completed");

            // Refresh index to make documents searchable
            client.indices().refresh(r -> r.index(indexName));

            Query query = Query.of(qb -> qb.match(mb -> mb.field("title").query(fv -> fv.stringValue("Document"))));
            final SearchRequest.Builder searchReq = new SearchRequest.Builder().allowPartialSearchResults(false)
                .index(List.of(indexName))
                .size(10)
                .source(sc -> sc.fetch(false))
                .ignoreThrottled(false)
                .query(query);

            SearchResponse<IndexData> searchResponse = client.search(searchReq.build(), IndexData.class);
            LOGGER.info("Found {} documents", searchResponse.hits().hits().size());

            LOGGER.info("Bulk update document using BulkIngester");
            doc1.setText("Updated Document");

            // Create a new ingester for updates
            BulkIngester<Void> updateIngester = BulkIngester.of(b -> b.client(client));

            updateIngester.add(op -> op.update(u -> u.index(indexName).id("id1").document(doc1)));

            // Close to flush and wait for completion
            updateIngester.close();
            LOGGER.info("Bulk update completed");

            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
