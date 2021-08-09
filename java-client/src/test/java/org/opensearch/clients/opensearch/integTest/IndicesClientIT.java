/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.clients.opensearch.integTest;

import org.opensearch.client.ResponseException;
import org.opensearch.clients.opensearch.OpenSearchClient;
import org.opensearch.clients.opensearch.indices.CreateRequest;
import org.opensearch.clients.opensearch.indices.CreateResponse;
import org.opensearch.clients.opensearch.indices.GetRequest;
import org.opensearch.clients.opensearch.indices.GetResponse;
import org.opensearch.clients.opensearch.indices.GetSettingsRequest;
import org.opensearch.common.settings.Settings;

import java.io.IOException;

public class IndicesClientIT extends OpenSearchRestHighLevelClientTestCase {

    public void testIndicesExists() throws IOException {
        OpenSearchClient openSearchClient = highLevelClient();

        // Index present
        {
            String indexName = "test_index_exists_index_present";
            createIndex(indexName, Settings.EMPTY);

            GetRequest request = new GetRequest.Builder().index(indexName).build();
            GetResponse getResponse = openSearchClient.indices().get(request);

            assertNotNull(getResponse.value());
            assertEquals(getResponse.value().size(), 1);
        }

        // Index doesn't exist
        {
            String indexName = "non_existent_index";
            GetRequest request = new GetRequest.Builder().index(indexName).build();

            try {
                openSearchClient.indices().get(request);
                fail(); // should never execute
            } catch (ResponseException ex) {
                assertNotNull(ex);
            }
        }

        // One index exists, one doesn't
        {
            String existingIndex = "apples";
            createIndex(existingIndex, Settings.EMPTY);

            String nonExistentIndex = "oranges";

            GetRequest request = new GetRequest.Builder().index(existingIndex, nonExistentIndex).build();

            try {
                openSearchClient.indices().get(request);
                fail(); // should never execute
            } catch (ResponseException ex) {
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

            CreateRequest createIndexRequest = new CreateRequest.Builder().index(indexName).build();
            CreateResponse createIndexResponse = openSearchClient.indices().create(createIndexRequest);

            assertTrue(createIndexResponse.acknowledged());
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
        } catch (ResponseException ex) {
            assertNotNull(ex);
        }
    }
}
