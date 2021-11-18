///*
// * SPDX-License-Identifier: Apache-2.0
// *
// * The OpenSearch Contributors require contributions made to
// * this file be licensed under the Apache-2.0 license or a
// * compatible open source license.
// */
//
//package org.opensearch.client.opensearch.integTest;
//
//import org.opensearch.client.opensearch.OpenSearchClient;
//
//import org.opensearch.client.opensearch.indices.GetSettingsRequest;
//
//
//import java.io.IOException;
//
//public class IndicesClientIT extends OpenSearchRestHighLevelClientTestCase {
//
////    public void testIndicesExists() throws IOException {
////        OpenSearchClient openSearchClient = highLevelClient();
////
////        // Index present
////        {
////            String indexName = "test_index_exists_index_present";
////            createIndex(indexName, Settings.EMPTY);
////
////            GetRequest request = new GetRequest.Builder().index(indexName).build();
////            GetResponse getResponse = openSearchClient.indices().get(request);
////
////            assertNotNull(getResponse.value());
////            assertEquals(getResponse.value().size(), 1);
////        }
////
////        // Index doesn't exist
////        {
////            String indexName = "non_existent_index";
////            GetRequest request = new GetRequest.Builder().index(indexName).build();
////
////            try {
////                openSearchClient.indices().get(request);
////                fail(); // should never execute
////            } catch (ResponseException ex) {
////                assertNotNull(ex);
////            }
////        }
////
////        // One index exists, one doesn't
////        {
////            String existingIndex = "apples";
////            createIndex(existingIndex, Settings.EMPTY);
////
////            String nonExistentIndex = "oranges";
////
////            GetRequest request = new GetRequest.Builder().index(existingIndex, nonExistentIndex).build();
////
////            try {
////                openSearchClient.indices().get(request);
////                fail(); // should never execute
////            } catch (ResponseException ex) {
////                assertNotNull(ex);
////            }
////        }
////    }
////
////    public void testCreateIndex() throws IOException {
////        OpenSearchClient openSearchClient = highLevelClient();
////
////        // Create index
////        {
////            String indexName = "plain_index";
////            assertFalse(indexExists(indexName));
////
////            CreateRequest createIndexRequest = new CreateRequest.Builder().index(indexName).build();
////            CreateResponse createIndexResponse = openSearchClient.indices().create(createIndexRequest);
////
////            assertTrue(createIndexResponse.acknowledged());
////            assertTrue(createIndexResponse.shardsAcknowledged());
////            assertTrue(indexExists(indexName));
////        }
////    }
////
////    public void testGetSettingsNonExistentIndex() throws IOException {
////        OpenSearchClient openSearchClient = highLevelClient();
////
////        String nonExistentIndex = "index_that_doesnt_exist";
////        assertFalse(indexExists(nonExistentIndex));
////
////        GetSettingsRequest getSettingsRequest = new GetSettingsRequest.Builder().index(nonExistentIndex).build();
////
////        try {
////            openSearchClient.indices().getSettings(getSettingsRequest);
////            fail();
////        } catch (ResponseException ex) {
////            assertNotNull(ex);
////        }
////    }
//}
