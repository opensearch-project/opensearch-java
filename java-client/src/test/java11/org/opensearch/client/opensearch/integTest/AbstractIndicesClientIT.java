/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.opensearch.Version;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.mapping.FlatObjectProperty;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.indices.CreateDataStreamResponse;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.DataStreamsStatsResponse;
import org.opensearch.client.opensearch.indices.DeleteDataStreamResponse;
import org.opensearch.client.opensearch.indices.GetAliasRequest;
import org.opensearch.client.opensearch.indices.GetAliasResponse;
import org.opensearch.client.opensearch.indices.GetDataStreamResponse;
import org.opensearch.client.opensearch.indices.GetIndexRequest;
import org.opensearch.client.opensearch.indices.GetIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsRequest;
import org.opensearch.client.opensearch.indices.GetMappingRequest;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.opensearch.client.opensearch.indices.IndexState;
import org.opensearch.client.opensearch.indices.PutIndexTemplateResponse;
import org.opensearch.common.settings.Settings;

public abstract class AbstractIndicesClientIT extends OpenSearchJavaClientTestCase {
    public void testIndicesExists() throws IOException {

        // Index present
        {
            String indexName = "test_index_exists_index_present";
            javaClient().indices().create(_1 -> _1.index(indexName));

            GetIndexRequest request = new GetIndexRequest.Builder().index(indexName).build();
            GetIndexResponse response = javaClient().indices().get(request);

            assertNotNull(response.result());
            assertEquals(response.result().size(), 1);
        }

        // Index doesn't exist
        {
            String indexName = "non_existent_index";
            GetIndexRequest request = new GetIndexRequest.Builder().index(indexName).build();

            try {
                javaClient().indices().get(request);
                fail(); // should never execute
            } catch (OpenSearchException ex) {
                assertNotNull(ex);
                assertEquals(ex.status(), 404);
                assertEquals(ex.getMessage(), "Request failed: [index_not_found_exception] " + "no such index [non_existent_index]");
            }
        }

        // One index exists, one doesn't
        {
            String existingIndex = "apples";
            createIndex(existingIndex, Settings.EMPTY);

            String nonExistentIndex = "oranges";

            GetIndexRequest request = new GetIndexRequest.Builder().index(existingIndex, nonExistentIndex).build();

            try {
                javaClient().indices().get(request);
                fail(); // should never execute
            } catch (OpenSearchException ex) {
                assertNotNull(ex);
            }
        }
    }

    public void testCreateIndex() throws Exception {
        OpenSearchAsyncClient asyncClient = new OpenSearchAsyncClient(javaClient()._transport());
        CreateIndexResponse createResponse = javaClient().indices().create(b -> b.index("my-index"));
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

        GetIndicesSettingsRequest getIndicesSettingsRequest = new GetIndicesSettingsRequest.Builder().index(nonExistentIndex).build();

        try {
            javaClient().indices().getSettings(getIndicesSettingsRequest);
            fail();
        } catch (OpenSearchException ex) {
            assertNotNull(ex);
            assertEquals(ex.status(), 404);
            assertEquals(ex.getMessage(), "Request failed: [index_not_found_exception] " + "no such index [index_that_doesnt_exist]");
        }
    }

    public void testDataStream() throws IOException {
        String dataStreamIndexTemplateName = "test-data-stream-template";
        String timestampFieldName = "my_timestamp_field";
        String namePattern = "test_data_stream-*";
        String dataStreamName = "test_data_stream-1";

        // create an index template before creating data streams
        PutIndexTemplateResponse putIndexTemplateResponse = javaClient().indices()
            .putIndexTemplate(
                b -> b.name(dataStreamIndexTemplateName)
                    .dataStream(ds -> ds.timestampField(bd -> bd.name(timestampFieldName)))
                    .indexPatterns(namePattern)
            );
        assertTrue(putIndexTemplateResponse.acknowledged());

        // create data streams follow the index pattern
        CreateDataStreamResponse createDataStreamResponse1 = javaClient().indices().createDataStream(b -> b.name(dataStreamName));
        assertTrue(createDataStreamResponse1.acknowledged());

        // get data stream
        GetDataStreamResponse getDataStreamResponse = javaClient().indices().getDataStream(b -> b.name(dataStreamName));
        assertEquals(1, getDataStreamResponse.dataStreams().size());
        assertEquals(dataStreamName, getDataStreamResponse.dataStreams().get(0).name());
        assertEquals(timestampFieldName, getDataStreamResponse.dataStreams().get(0).timestampField().name());
        assertEquals(dataStreamIndexTemplateName, getDataStreamResponse.dataStreams().get(0).template());
        assertNotNull(getDataStreamResponse.dataStreams().get(0).status());

        // get all data streams
        GetDataStreamResponse getAllDataStreamsResponse = javaClient().indices().getDataStream();
        assertEquals(1, getAllDataStreamsResponse.dataStreams().size());

        // get one data stream stats
        // TODO: support the `human` global parameter on all requests
        DataStreamsStatsResponse dataStreamStatsResponse = javaClient().indices()
            .dataStreamsStats(b -> b.name(dataStreamName)/* .human(true) */);
        assertNotNull(dataStreamStatsResponse.shards());
        assertEquals(1, dataStreamStatsResponse.dataStreamCount());
        assertEquals(1, dataStreamStatsResponse.backingIndices());
        assertTrue(dataStreamStatsResponse.totalStoreSizeBytes() > 0L);
        // assertNotNull(dataStreamStatsResponse.totalStoreSize());
        assertEquals(1, dataStreamStatsResponse.dataStreams().size());
        assertEquals(dataStreamName, dataStreamStatsResponse.dataStreams().get(0).dataStream());
        assertEquals(1, dataStreamStatsResponse.dataStreams().get(0).backingIndices());
        assertTrue(dataStreamStatsResponse.dataStreams().get(0).storeSizeBytes() > 0);
        // assertNotNull(dataStreamStatsResponse.dataStreams().get(0).storeSize());

        // get all data streams stats
        // TODO: support the `human` global parameter on all requests
        DataStreamsStatsResponse allDataStreamsStatsResponse = javaClient().indices().dataStreamsStats(b -> b/* .human(true) */);
        assertNotNull(allDataStreamsStatsResponse.shards());
        assertEquals(1, allDataStreamsStatsResponse.dataStreamCount());
        assertEquals(1, allDataStreamsStatsResponse.backingIndices());
        assertTrue(allDataStreamsStatsResponse.totalStoreSizeBytes() > 0L);
        // assertNotNull(allDataStreamsStatsResponse.totalStoreSize());
        assertEquals(1, allDataStreamsStatsResponse.dataStreams().size());
        assertEquals(dataStreamName, allDataStreamsStatsResponse.dataStreams().get(0).dataStream());
        assertEquals(1, allDataStreamsStatsResponse.dataStreams().get(0).backingIndices());
        assertTrue(allDataStreamsStatsResponse.dataStreams().get(0).storeSizeBytes() > 0);
        // assertNotNull(allDataStreamsStatsResponse.dataStreams().get(0).storeSize());

        // delete data stream
        DeleteDataStreamResponse deleteDataStreamResponse = javaClient().indices().deleteDataStream(b -> b.name(namePattern));
        assertTrue(deleteDataStreamResponse.acknowledged());

        // verify data stream is deleted
        try {
            javaClient().indices().getDataStream(b -> b.name(dataStreamName));
            fail();
        } catch (OpenSearchException ex) {
            assertNotNull(ex);
            assertEquals(ex.status(), 404);
        }
    }

    public void testGetNotExistingIndexAlias() throws Exception {
        String notExistingIndexAlias = "alias_not_exists";
        GetAliasRequest aliasRequest = new GetAliasRequest.Builder().name(notExistingIndexAlias).build();
        try {
            GetAliasResponse response = javaClient().indices().getAlias(aliasRequest);
            fail();
        } catch (OpenSearchException ex) {
            assertNotNull(ex);
            assertEquals(ex.status(), 404);
            assertEquals(ex.getMessage(), "Request failed: [string_error] " + "alias [alias_not_exists] missing");
        }
    }

    @Test
    public void createIndex_withFlatObject_indexCreatesSuccessfully() throws IOException {
        assumeFlatObjectSupport();

        try {
            final CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index("flat-object-test")
                .mappings(m -> m.properties("sample_flat_object", Property.of(p -> p.flatObject(new FlatObjectProperty.Builder().build()))))
                .build();
            final CreateIndexResponse createIndexResponse = javaClient().indices().create(createIndexRequest);
            assertTrue(createIndexResponse.acknowledged());
        } catch (OpenSearchException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void createIndex_withFlatObject_mappingCanBeRetrieved() throws IOException {
        assumeFlatObjectSupport();

        try {
            final String indexName = "flat-object-mapping-index";
            final CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName)
                .mappings(m -> m.properties("sample_flat_object", Property.of(p -> p.flatObject(new FlatObjectProperty.Builder().build()))))
                .build();
            final CreateIndexResponse createIndexResponse = javaClient().indices().create(createIndexRequest);
            assertTrue(createIndexResponse.acknowledged());

            final GetMappingResponse response = javaClient().indices().getMapping(GetMappingRequest.of(m -> m.index(indexName)));
            final Property.Kind mappingKind = response.result().get(indexName).mappings().properties().get("sample_flat_object")._kind();
            assertEquals(mappingKind, Property.Kind.FlatObject);
        } catch (OpenSearchException ex) {
            fail(ex.getMessage());
        }
    }

    private void assumeFlatObjectSupport() throws IOException {
        InfoResponse info = javaClient().info();
        String version = info.version().number();
        if (version.contains("SNAPSHOT")) {
            version = version.split("-")[0];
        }
        assumeTrue("Flat Object is supported after version 2.7.0 only", Version.fromString(version).onOrAfter(Version.fromString("2.7.0")));
    }
}
