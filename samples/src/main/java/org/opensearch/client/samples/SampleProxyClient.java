package org.opensearch.client.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch._types.mapping.IntegerNumberProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.samples.util.IndexData;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=SampleProxyClient</c>
 */
public class SampleProxyClient {

    private static final Logger LOGGER = LogManager.getLogger(SampleProxyClient.class);

    public static void main(String[] args) {
        try {
            var transport = SampleClient.createTransport();
            var client = OpenSearchClientProxy.create(transport);

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

            LOGGER.info("Indexing documents");
            IndexData indexData = new IndexData("Document 1", "Text for document 1");
            IndexRequest<IndexData> indexRequest = new IndexRequest.Builder<IndexData>().index(indexName)
                .id("1")
                .document(indexData)
                .build();
            client.index(indexRequest);

            indexData = new IndexData("Document 2", "Text for document 2");
            indexRequest = new IndexRequest.Builder<IndexData>().index(indexName).id("2").document(indexData).build();
            client.index(indexRequest);

            // wait for the document to index
            Thread.sleep(3000);

            SearchResponse<IndexData> searchResponse = client.search(s -> s.index(indexName), IndexData.class);
            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

            LOGGER.info("Deleting document with id 1");
            client.delete(d -> d.index(indexName).id("1"));

            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
