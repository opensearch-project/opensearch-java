/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.mapping.DynamicMapping;
import org.opensearch.client.opensearch._types.mapping.FieldNamesField;
import org.opensearch.client.opensearch._types.mapping.IntegerNumberProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.RoutingField;
import org.opensearch.client.opensearch._types.mapping.SourceField;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.GetMappingRequest;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.opensearch.indices.PutMappingRequest;
import org.opensearch.client.samples.util.IndexData;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=IndexingBasics</c>
 */
public class IndexingBasics {
    private static final Logger LOGGER = LogManager.getLogger(IndexingBasics.class);

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

            LOGGER.info("Adding a new mapping to index {}", indexName);
            PutMappingRequest.Builder mappingsRequestBuilder = new PutMappingRequest.Builder().index(indexName)
                .source(new SourceField.Builder().enabled(true).build())
                .routing(new RoutingField.Builder().required(false).build())
                .dynamic(DynamicMapping.Strict)
                .meta("key", JsonData.of("key value"))
                .fieldNames(new FieldNamesField.Builder().enabled(false).build())
                .dateDetection(false)
                .dynamicDateFormats(new ArrayList<>())
                .dynamicTemplates(new ArrayList<>())
                .numericDetection(false);
            client.indices().putMapping(mappingsRequestBuilder.build());

            GetMappingRequest mappingsRequest = new GetMappingRequest.Builder().index(indexName).build();
            GetMappingResponse getMappingResponse = client.indices().getMapping(mappingsRequest);
            LOGGER.info("Mappings {} found for index {}", getMappingResponse.result().get(indexName).mappings(), indexName);

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
