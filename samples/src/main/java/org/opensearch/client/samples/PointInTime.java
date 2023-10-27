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
import org.opensearch.client.opensearch.core.pit.CreatePitRequest;
import org.opensearch.client.opensearch.core.pit.CreatePitResponse;
import org.opensearch.client.opensearch.core.pit.DeletePitRequest;
import org.opensearch.client.opensearch.core.pit.DeletePitResponse;
import org.opensearch.client.opensearch.core.pit.ListAllPitResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.samples.util.CommonUtil;

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

            CommonUtil.createIndex(client, indexName);

            CreatePitRequest createPitRequest = new CreatePitRequest.Builder().targetIndexes(Collections.singletonList(indexName))
                .keepAlive(new Time.Builder().time("100m").build())
                .build();

            CreatePitResponse createPitResponse = client.createPit(createPitRequest);
            LOGGER.info("PIT created with id: {}", createPitResponse.pitId());

            ListAllPitResponse listAllPitResponse = client.listAllPit();
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
