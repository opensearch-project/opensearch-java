/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndexRequest;
import org.opensearch.client.opensearch.indices.GetIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsRequest;
import org.opensearch.client.opensearch.indices.IndexState;
import org.opensearch.common.settings.Settings;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class IndicesClientIT extends OpenSearchRestHighLevelClientTestCase {

    public void testIndicesExists() throws IOException {

        // Index present
        {
            String indexName = "test_index_exists_index_present";
            highLevelClient().indices().create(_1 -> _1.index(indexName));

            GetIndexRequest request = new GetIndexRequest.Builder().index(indexName).build();
            GetIndexResponse response = highLevelClient().indices().get(request);

            assertNotNull(response.result());
            assertEquals(response.result().size(), 1);
        }

        // Index doesn't exist
        {
            String indexName = "non_existent_index";
            GetIndexRequest request = new GetIndexRequest.Builder().index(indexName).build();

            try {
                highLevelClient().indices().get(request);
                fail(); // should never execute
            } catch (OpenSearchException ex) {
                assertNotNull(ex);
                assertEquals(ex.status(), 404);
                assertEquals(ex.getMessage(),
                        "[opensearch/indices.get] failed: [index_not_found_exception] " +
                                "no such index [non_existent_index]");
            }
        }

        // One index exists, one doesn't
        {
            String existingIndex = "apples";
            createIndex(existingIndex, Settings.EMPTY);

            String nonExistentIndex = "oranges";

            GetIndexRequest request = new GetIndexRequest.Builder().index(existingIndex, nonExistentIndex).build();

            try {
                highLevelClient().indices().get(request);
                fail(); // should never execute
            } catch (OpenSearchException ex) {
                assertNotNull(ex);
            }
        }
    }

    public void testCreateIndex() throws Exception {
        OpenSearchAsyncClient asyncClient = new OpenSearchAsyncClient(highLevelClient()._transport());
        CreateIndexResponse createResponse = highLevelClient().indices().create(b -> b.index("my-index"));
        assertTrue(createResponse.acknowledged());
        assertTrue(createResponse.shardsAcknowledged());

        // Find info about it, using the async client
        CompletableFuture<GetIndexResponse> futureResponse = asyncClient.indices().get(b -> b.index("my-index"));
        GetIndexResponse response = futureResponse.get(10, TimeUnit.SECONDS);

        Map<String, IndexState> indices = response.result();

        assertEquals(1, indices.size());
        assertNotNull(indices.get("my-index"));
    }

    public void testGetSettingsNonExistentIndex() throws IOException {

        String nonExistentIndex = "index_that_doesnt_exist";

        GetIndicesSettingsRequest getIndicesSettingsRequest = new GetIndicesSettingsRequest.Builder()
                .index(nonExistentIndex).build();

        try {
            highLevelClient().indices().getSettings(getIndicesSettingsRequest);
            fail();
        } catch (OpenSearchException ex) {
            assertNotNull(ex);
            assertEquals(ex.status(), 404);
            assertEquals(ex.getMessage(),
                    "[opensearch/indices.get_settings] failed: [index_not_found_exception] " +
                            "no such index [index_that_doesnt_exist]");
        }
    }
}