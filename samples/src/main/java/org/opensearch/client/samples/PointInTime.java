/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.mapping.IntegerNumberProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch.core.CreatePitRequest;
import org.opensearch.client.opensearch.core.CreatePitResponse;
import org.opensearch.client.opensearch.core.DeletePitRequest;
import org.opensearch.client.opensearch.core.DeletePitResponse;
import org.opensearch.client.opensearch.core.GetAllPitsResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=PointInTime</c>
 */
public class PointInTime {
    private static final Logger LOGGER = LogManager.getLogger(PointInTime.class);

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

            CreatePitRequest createPitRequest = new CreatePitRequest.Builder().index(Collections.singletonList(indexName))
                .keepAlive(new Time.Builder().time("100m").build())
                .build();

            CreatePitResponse createPitResponse = client.createPit(createPitRequest);
            LOGGER.info("PIT created with id: {}", createPitResponse.pitId());

            GetAllPitsResponse listAllPitResponse = client.getAllPits();
            LOGGER.info("Found {} PITs", listAllPitResponse.pits().size());

            DeletePitRequest deletePitRequest = new DeletePitRequest.Builder().pitId(Collections.singletonList(createPitResponse.pitId()))
                .build();
            DeletePitResponse deletePitResponse = client.deletePit(deletePitRequest);
            LOGGER.info("Deleting PIT: {}", deletePitResponse.pits());

            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
