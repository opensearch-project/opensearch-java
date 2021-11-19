/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.OpensearchException;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndexRequest;
import org.opensearch.client.opensearch.indices.GetIndexResponse;
import org.opensearch.client.opensearch.indices.GetSettingsRequest;
import org.opensearch.common.settings.Settings;


import java.io.IOException;

public class IndicesClientIT extends OpenSearchRestHighLevelClientTestCase {

    public void testIndicesExists() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();

        // Index present
        {
            String indexName = "test_index_exists_index_present";
            createIndex(indexName, Settings.EMPTY);

            GetIndexRequest request = new GetIndexRequest.Builder().index(indexName).build();
            GetIndexResponse response = openSearchClient.indices().get(request);

            assertNotNull(response.result());
            assertEquals(response.result().size(), 1);
        }

        // Index doesn't exist
        {
            String indexName = "non_existent_index";
            GetIndexRequest request = new GetIndexRequest.Builder().index(indexName).build();

            try {
                openSearchClient.indices().get(request);
                fail(); // should never execute
            } catch (OpensearchException ex) {
                assertNotNull(ex);
            }
        }

        // One index exists, one doesn't
        {
            String existingIndex = "apples";
            createIndex(existingIndex, Settings.EMPTY);

            String nonExistentIndex = "oranges";

            GetIndexRequest request = new GetIndexRequest.Builder().index(existingIndex, nonExistentIndex).build();

            try {
                openSearchClient.indices().get(request);
                fail(); // should never execute
            } catch (OpensearchException ex) {
                assertNotNull(ex);
            }
        }
    }

    public void testCreateIndex() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();

        // Create index
        {
            String indexName = "plain_index";
            assertFalse(indexExists(indexName));

            CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName).build();
            CreateIndexResponse createIndexResponse = openSearchClient.indices().create(createIndexRequest);

            assertTrue((createIndexResponse.acknowledged()));
            assertTrue(createIndexResponse.shardsAcknowledged());
            assertTrue(indexExists(indexName));
        }
    }

    public void testGetSettingsNonExistentIndex() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();

        String nonExistentIndex = "index_that_doesnt_exist";
        assertFalse(indexExists(nonExistentIndex));

        GetSettingsRequest getSettingsRequest = new GetSettingsRequest.Builder().index(nonExistentIndex).build();

        try {
            openSearchClient.indices().getSettings(getSettingsRequest);
            fail();
        } catch (OpensearchException ex) {
            assertNotNull(ex);
        }
    }
}
