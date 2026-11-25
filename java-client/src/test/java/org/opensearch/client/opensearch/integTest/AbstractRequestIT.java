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

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.opensearch.Version;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.aggregations.Aggregate;
import org.opensearch.client.opensearch._types.aggregations.HistogramAggregate;
import org.opensearch.client.opensearch._types.analysis.Analyzer;
import org.opensearch.client.opensearch._types.analysis.CustomAnalyzer;
import org.opensearch.client.opensearch._types.analysis.ShingleTokenFilter;
import org.opensearch.client.opensearch._types.analysis.TokenFilter;
import org.opensearch.client.opensearch._types.analysis.TokenFilterDefinition;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TextProperty;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch.cat.NodesResponse;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.ClearScrollResponse;
import org.opensearch.client.opensearch.core.CreatePitRequest;
import org.opensearch.client.opensearch.core.CreatePitResponse;
import org.opensearch.client.opensearch.core.DeletePitRequest;
import org.opensearch.client.opensearch.core.DeletePitResponse;
import org.opensearch.client.opensearch.core.GetAllPitsResponse;
import org.opensearch.client.opensearch.core.GetResponse;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.opensearch.core.msearch.RequestItem;
import org.opensearch.client.opensearch.core.search.CompletionSuggester;
import org.opensearch.client.opensearch.core.search.FieldSuggester;
import org.opensearch.client.opensearch.core.search.FieldSuggesterBuilders;
import org.opensearch.client.opensearch.core.search.Hit;
import org.opensearch.client.opensearch.core.search.PhraseSuggester;
import org.opensearch.client.opensearch.core.search.Suggester;
import org.opensearch.client.opensearch.core.search.TermSuggester;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsResponse;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.opensearch.indices.IndexSettingsAnalysis;
import org.opensearch.client.opensearch.indices.IndexState;
import org.opensearch.client.transport.endpoints.BooleanResponse;

public abstract class AbstractRequestIT extends OpenSearchJavaClientTestCase {

    @Test
    public void testCount() throws Exception {

        // Tests that a no-parameter method exists for endpoints that only have optional properties
        assertTrue(javaClient().count().count() >= 0);
    }

    @Test
    public void testIndexCreation() throws Exception {
        OpenSearchAsyncClient asyncClient = new OpenSearchAsyncClient(javaClient()._transport());

        // Ping the server
        assertTrue(javaClient().ping().value());

        // Create an index...
        final CreateIndexResponse createResponse = javaClient().indices().create(b -> b.index("my-index"));
        assertTrue(createResponse.acknowledged());
        assertTrue(createResponse.shardsAcknowledged());

        // Find info about it, using the async client
        CompletableFuture<GetIndexResponse> futureResponse = asyncClient.indices().get(b -> b.index("my-index"));
        GetIndexResponse response = futureResponse.get(10, TimeUnit.SECONDS);

        Map<String, IndexState> indices = response.result();

        assertEquals(1, indices.size());
        assertNotNull(indices.get("my-index"));
    }

    @Test
    public void testIndexSettings() throws Exception {
        var createResponse = javaClient().indices()
            .create(
                r -> r.index("test-settings")
                    .settings(
                        s -> s.translog(tl -> tl.syncInterval(t -> t.time("10s")))
                            .mapping(
                                m -> m.fieldNameLength(f -> f.limit(300L))
                                    .totalFields(f -> f.limit(30L))
                                    .nestedFields(f -> f.limit(10L))
                                    .depth(f -> f.limit(3L))
                                    .nestedObjects(f -> f.limit(9L))
                            )
                            .indexing(
                                i -> i.slowlog(
                                    sl -> sl.level("info")
                                        .source(1000)
                                        .reformat(false)
                                        .threshold(
                                            th -> th.index(
                                                in -> in.trace(t -> t.time("5s"))
                                                    .debug(t -> t.time("10s"))
                                                    .info(t -> t.time("20s"))
                                                    .warn(t -> t.time("30s"))
                                            )
                                        )
                                )
                            )
                            .search(
                                i -> i.slowlog(
                                    sl -> sl.level("info")
                                        .threshold(
                                            th -> th.query(
                                                in -> in.trace(t -> t.time("5s"))
                                                    .debug(t -> t.time("10s"))
                                                    .info(t -> t.time("20s"))
                                                    .warn(t -> t.time("30s"))
                                            )
                                                .fetch(
                                                    in -> in.trace(t -> t.time("5s"))
                                                        .debug(t -> t.time("10s"))
                                                        .info(t -> t.time("20s"))
                                                        .warn(t -> t.time("30s"))
                                                )
                                        )
                                ).idle(id -> id.after(a -> a.time("120s")))
                            )
                    )
            );
        assertTrue(createResponse.acknowledged());
        assertTrue(createResponse.shardsAcknowledged());

        var createdSettings = javaClient().indices().getSettings(r -> r.index("test-settings"));

        var createdIndexSettings = createdSettings.get("test-settings");
        assertNotNull(createdIndexSettings);
        assertNotNull(createdIndexSettings.settings());
        assertNotNull(createdIndexSettings.settings().index());
        assertNotNull(createdIndexSettings.settings().index().translog());
        assertNotNull(createdIndexSettings.settings().index().translog().syncInterval());
        assertEquals("10s", createdIndexSettings.settings().index().translog().syncInterval().time());
        var createdMappingSettings = createdIndexSettings.settings().index().mapping();
        assertNotNull(createdMappingSettings);
        assertNotNull(createdMappingSettings.fieldNameLength());
        assertEquals(300L, (Object) createdMappingSettings.fieldNameLength().limit());
        assertNotNull(createdMappingSettings.totalFields());
        assertEquals(30L, (Object) createdMappingSettings.totalFields().limit());
        assertNotNull(createdMappingSettings.nestedFields());
        assertEquals(10L, (Object) createdMappingSettings.nestedFields().limit());
        assertNotNull(createdMappingSettings.depth());
        assertEquals(3L, (Object) createdMappingSettings.depth().limit());
        assertNotNull(createdMappingSettings.nestedObjects());
        assertEquals(9L, (Object) createdMappingSettings.nestedObjects().limit());

        var createdIndexingSettings = createdIndexSettings.settings().index().indexing();
        assertNotNull(createdIndexingSettings);
        assertNotNull(createdIndexingSettings.slowlog());
        assertEquals("info", createdIndexingSettings.slowlog().level());
        assertEquals(1000, (Object) createdIndexingSettings.slowlog().source());
        assertEquals(false, createdIndexingSettings.slowlog().reformat());
        assertNotNull(createdIndexingSettings.slowlog().threshold());
        assertNotNull(createdIndexingSettings.slowlog().threshold().index());
        assertEquals("5s", createdIndexingSettings.slowlog().threshold().index().trace().time());
        assertEquals("10s", createdIndexingSettings.slowlog().threshold().index().debug().time());
        assertEquals("20s", createdIndexingSettings.slowlog().threshold().index().info().time());
        assertEquals("30s", createdIndexingSettings.slowlog().threshold().index().warn().time());

        var createdSearchSettings = createdIndexSettings.settings().index().search();
        assertNotNull(createdSearchSettings);
        assertNotNull(createdSearchSettings.slowlog());
        assertEquals("info", createdSearchSettings.slowlog().level());
        assertNotNull(createdSearchSettings.slowlog().threshold());
        assertNotNull(createdSearchSettings.slowlog().threshold().query());
        assertEquals("5s", createdSearchSettings.slowlog().threshold().query().trace().time());
        assertEquals("10s", createdSearchSettings.slowlog().threshold().query().debug().time());
        assertEquals("20s", createdSearchSettings.slowlog().threshold().query().info().time());
        assertEquals("30s", createdSearchSettings.slowlog().threshold().query().warn().time());
        assertNotNull(createdSearchSettings.slowlog().threshold().fetch());
        assertEquals("5s", createdSearchSettings.slowlog().threshold().fetch().trace().time());
        assertEquals("10s", createdSearchSettings.slowlog().threshold().fetch().debug().time());
        assertEquals("20s", createdSearchSettings.slowlog().threshold().fetch().info().time());
        assertEquals("30s", createdSearchSettings.slowlog().threshold().fetch().warn().time());

        var putSettingsResponse = javaClient().indices()
            .putSettings(
                r -> r.index("test-settings")
                    .settings(
                        s -> s.translog(tl -> tl.syncInterval(Time.of(t -> t.time("5s"))))
                            .mapping(
                                m -> m.fieldNameLength(f -> f.limit(400L))
                                    .totalFields(f -> f.limit(130L))
                                    .nestedFields(f -> f.limit(110L))
                                    .depth(f -> f.limit(13L))
                                    .nestedObjects(f -> f.limit(19L))
                            )
                    )
            );
        assertTrue(putSettingsResponse.acknowledged());

        var updatedSettings = javaClient().indices().getSettings(r -> r.index("test-settings"));

        var updatedIndexSettings = updatedSettings.get("test-settings");
        assertNotNull(updatedIndexSettings);
        assertNotNull(updatedIndexSettings.settings());
        assertNotNull(updatedIndexSettings.settings().index());
        assertNotNull(updatedIndexSettings.settings().index().translog());
        assertNotNull(updatedIndexSettings.settings().index().translog().syncInterval());
        assertEquals("5s", updatedIndexSettings.settings().index().translog().syncInterval().time());
        var updatedMappingSettings = updatedIndexSettings.settings().index().mapping();
        assertNotNull(updatedMappingSettings);
        assertNotNull(updatedMappingSettings.fieldNameLength());
        assertEquals(400L, (Object) updatedMappingSettings.fieldNameLength().limit());
        assertNotNull(updatedMappingSettings.totalFields());
        assertEquals(130L, (Object) updatedMappingSettings.totalFields().limit());
        assertNotNull(updatedMappingSettings.nestedFields());
        assertEquals(110L, (Object) updatedMappingSettings.nestedFields().limit());
        assertNotNull(updatedMappingSettings.depth());
        assertEquals(13L, (Object) updatedMappingSettings.depth().limit());
        assertNotNull(updatedMappingSettings.nestedObjects());
        assertEquals(19L, (Object) updatedMappingSettings.nestedObjects().limit());
    }

    @Test
    public void testDataIngestion() throws Exception {

        String index = "ingest-test";

        // Create an index
        CreateIndexResponse createIndexResponse = javaClient().indices().create(b -> b.index(index));

        assertEquals(index, createIndexResponse.index());

        // Check that it actually exists. Example of a boolean response
        BooleanResponse existsResponse = javaClient().indices().exists(b -> b.index(index));
        assertTrue(existsResponse.value());

        // Ingest some data
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        String docId = javaClient().index(
            b -> b.index(index)
                .id("my/Id") // test with url-unsafe string
                .document(appData)
                .refresh(Refresh.True) // Make it visible for search
        ).id();

        assertEquals("my/Id", docId);

        // Check auto-created mapping
        GetMappingResponse mapping = javaClient().indices().getMapping(b -> b.index(index));
        assertEquals(Property.Kind.Long, mapping.get("ingest-test").mappings().properties().get("intValue")._kind());

        // Query by id
        AppData esData = javaClient().get(b -> b.index(index).id(docId), AppData.class).source();

        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());

        // Query by id a non-existing document
        final GetResponse<AppData> notExists = javaClient().get(b -> b.index(index).id("some-random-id"), AppData.class);

        assertFalse(notExists.found());
        assertNull(notExists.source());

        // Search
        SearchResponse<AppData> search = javaClient().search(b -> b.index(index), AppData.class);

        long hits = search.hits().total().value();
        assertEquals(1, hits);

        esData = search.hits().hits().get(0).source();
        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());

        RequestItem item = RequestItem.of(_1 -> _1.header(_2 -> _2.index("test")).body(_2 -> _2.size(4)));

        // MSearch: 1st search on an existing index, 2nd one on a non-existing index
        final MsearchResponse<AppData> msearch = javaClient().msearch(
            _0 -> _0.searches(_1 -> _1.header(_3 -> _3.index(index)).body(_3 -> _3.query(_4 -> _4.matchAll(_5 -> _5))))
                .searches(_1 -> _1.header(_3 -> _3.index("non-existing")).body(_3 -> _3.query(_4 -> _4.matchAll(_5 -> _5)))),
            AppData.class
        );

        assertEquals(2, msearch.responses().size());
        assertTrue(msearch.responses().get(0).isResult());
        assertEquals(1, msearch.responses().get(0).result().hits().hits().size());
        assertTrue(msearch.responses().get(1).isFailure());
        assertEquals(404, msearch.responses().get(1).failure().status().intValue());
    }

    @Test
    public void testCatRequest() throws IOException {
        // Cat requests should have the "format=json" added by the transport
        NodesResponse nodes = javaClient().cat().nodes(_0 -> _0);

        InfoResponse info = javaClient().info();
        String version = info.version().number();
        if (version.contains("SNAPSHOT")) {
            version = version.split("-")[0];
        }
        assertEquals(1, nodes.valueBody().size());
        if (Version.fromString(version).onOrAfter(Version.fromString("2.0.0"))) {
            assertEquals("*", nodes.valueBody().get(0).clusterManager());
        } else {
            assertEquals("*", nodes.valueBody().get(0).master());
        }

    }

    @Test
    public void testBulkRequest() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        BulkResponse bulk = javaClient().bulk(
            _0 -> _0.operations(_1 -> _1.create(_2 -> _2.index("foo").id("abc").document(appData)))
                .operations(_1 -> _1.create(_2 -> _2.index("foo").id("def").document(appData)))
        );

        assertFalse(bulk.errors());
        assertEquals(2, bulk.items().size());
        assertEquals(OperationType.Create, bulk.items().get(0).operationType());
        assertEquals("foo", bulk.items().get(0).index());
        assertEquals(1L, bulk.items().get(0).version().longValue());
        assertEquals("foo", bulk.items().get(1).index());
        assertEquals(1L, bulk.items().get(1).version().longValue());
        assertEquals(42, javaClient().get(b -> b.index("foo").id("abc"), AppData.class).source().getIntValue());
    }

    @Test
    public void testTrackTotalHitsFalse() throws Exception {
        // https://github.com/opensearch-project/opensearch-java/issues/354
        String index = "ingest-test";

        javaClient().indices().create(b -> b.index(index));

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        javaClient().index(
            b -> b.index(index).id("myId").document(appData).refresh(Refresh.True) // Make it visible for search
        ).id();

        // Search
        SearchResponse<AppData> search = javaClient().search(b -> b.index(index).trackTotalHits(t -> t.enabled(false)), AppData.class);

        List<Hit<AppData>> hits = search.hits().hits();
        AppData appDataResult = search.hits().hits().get(0).source();
        assertEquals(1337, appDataResult.getIntValue());
        assertEquals("foo", appDataResult.getMsg());
    }

    @Test
    public void testRefresh() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        IndexResponse ir = javaClient().index(_0 -> _0.index("test").id("1").document(appData).refresh(Refresh.WaitFor));

        assertEquals("1", ir.id());
    }

    @Test
    public void errorResponse() throws Exception {
        BooleanResponse exists = javaClient().exists(_0 -> _0.index("doesnotexist").id("reallynot"));
        assertFalse(exists.value());

        OpenSearchException ex = assertThrows(OpenSearchException.class, () -> {
            GetResponse<String> response = javaClient().get(_0 -> _0.index("doesnotexist").id("reallynot"), String.class);
        });

        assertEquals(404, ex.status());
        assertEquals("index_not_found_exception", ex.error().type());
        assertEquals("doesnotexist", ex.error().metadata().get("index").to(String.class));

        ExecutionException ee = assertThrows(ExecutionException.class, () -> {
            OpenSearchAsyncClient aClient = new OpenSearchAsyncClient(javaClient()._transport());
            GetResponse<String> response = aClient.get(_0 -> _0.index("doesnotexist").id("reallynot"), String.class).get();
        });

        ex = ((OpenSearchException) ee.getCause());
        assertEquals(404, ex.status());
        assertEquals("index_not_found_exception", ex.error().type());
    }

    @Test
    public void testErrorStatusCodeWithValidResponse() throws IOException {
        // Some endpoints return a faulty status code 404 with a valid response.
        // Transports should first try to decode an error, and if they fail because of missing properties for
        // the error type, then try to decode the regular request.

        final ClearScrollResponse clearResponse = javaClient().clearScroll(
            b -> b.scrollId("DXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAD4WYm9laVYtZndUQlNsdDcwakFMNjU1QQ==")
        );
        assertEquals(0, clearResponse.numFreed());
    }

    @Test
    public void testSearchAggregation() throws IOException {

        javaClient().create(_1 -> _1.index("products").id("A").document(new Product(5)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index("products").id("B").document(new Product(15)).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index("products").id("C").document(new Product(25)).refresh(Refresh.True));

        SearchResponse<Product> searchResponse = javaClient().search(
            _1 -> _1.index("products").size(0).aggregations("prices", _3 -> _3.histogram(_4 -> _4.field("price").interval(10.0))),
            Product.class
        );

        HistogramAggregate prices = searchResponse.aggregations().get("prices").histogram();
        assertEquals(3, prices.buckets().array().size());
        assertEquals(1, prices.buckets().array().get(0).docCount());

        // We've set "size" to zero
        assertEquals(0, searchResponse.hits().hits().size());

    }

    @Test
    public void testSubAggregation() throws IOException {

        javaClient().create(_1 -> _1.index("products").id("A").document(new Product(5, "Blue")).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index("products").id("B").document(new Product(10, "Blue")).refresh(Refresh.True));
        javaClient().create(_1 -> _1.index("products").id("C").document(new Product(15, "Black")).refresh(Refresh.True));

        SearchRequest searchRequest = SearchRequest.of(
            _1 -> _1.index("products").size(0).aggregations("price", _3 -> _3.terms(_4 -> _4.field("price")))
        );
        SearchResponse<Product> searchResponse = javaClient().search(searchRequest, Product.class);

        Aggregate prices = searchResponse.aggregations().get("price")._get().toAggregate();
        assertEquals(1, prices.dterms().buckets().array().get(0).docCount());
        assertEquals(1, prices.dterms().buckets().array().get(1).docCount());

        // We've set "size" to zero
        assertEquals(0, searchResponse.hits().hits().size());

    }

    @Test
    public void testChildAggregation() throws IOException {

        String index = "test_child";
        String question = "question";
        String answer = "answer";

        javaClient().indices()
            .create(
                c -> c.index(index)
                    .mappings(
                        m -> m.properties(
                            "join",
                            p -> p.join(j -> j.relations(Collections.singletonMap(question, Collections.singletonList(answer))))
                        )
                    )
            );
        javaClient().index(i -> i.index(index).id("1").document(new Question("exists")).refresh(Refresh.True));
        javaClient().index(i -> i.index(index).id("2").routing("1").document(new Answer("true", "1")).refresh(Refresh.True));
        javaClient().index(i -> i.index(index).id("3").routing("1").document(new Answer("false", "1")).refresh(Refresh.True));

        SearchRequest searchRequest = SearchRequest.of(
            r -> r.index(index).size(0).aggregations(answer, a -> a.children(c -> c.type(answer)))
        );

        SearchResponse<Void> searchResponse = javaClient().search(searchRequest, Void.class);

        assertEquals(2, searchResponse.aggregations().get(answer).children().docCount());
    }

    @Test
    public void testGetMapping() throws Exception {
        // See also VariantsTest.testNestedTaggedUnionWithDefaultTag()
        String index = "testindex";

        Map<String, Property> fields = Collections.singletonMap("keyword", Property.of(p -> p.keyword(k -> k.ignoreAbove(256))));
        Property text = Property.of(p -> p.text(t -> t.fields(fields)));

        javaClient().indices()
            .create(
                c -> c.index(index)
                    .mappings(
                        m -> m.properties("id", text)
                            .properties("name", p -> p.object(o -> o.properties("first", text).properties("last", text)))
                    )
            );

        GetMappingResponse mr = javaClient().indices().getMapping(mrb -> mrb.index(index));

        assertNotNull(mr.result().get(index));
        assertNotNull(mr.result().get(index).mappings().properties().get("name").object());
    }

    @Test
    public void testDefaultIndexSettings() throws IOException {

        String index = "index-settings";
        javaClient().index(_1 -> _1.index(index).document(new Product(5)).refresh(Refresh.True));

        GetIndicesSettingsResponse settings;
        settings = javaClient().indices().getSettings(b -> b.index(index).includeDefaults(true));
        assertNotNull(settings.get(index).defaults());

        settings = javaClient().indices().getSettings(b -> b.index(index));
        assertNull(settings.get(index).defaults());
    }

    @Test
    public void testCompletionSuggesterFailure() throws IOException {

        String index = "test-completion-suggester-failure";

        Property intValueProp = new Property.Builder().long_(v -> v).build();
        Property msgCompletionProp = new Property.Builder().completion(c -> c).build();
        javaClient().indices()
            .create(c -> c.index(index).mappings(m -> m.properties("intValue", intValueProp).properties("msg", msgCompletionProp)));

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        javaClient().index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));

        appData.setIntValue(1338);
        appData.setMsg("foobar");

        javaClient().index(b -> b.index(index).id("2").document(appData).refresh(Refresh.True));

        String suggesterName = "msgSuggester";

        CompletionSuggester completionSuggester = FieldSuggesterBuilders.completion().field("msg").size(1).build();
        FieldSuggester fieldSuggester = new FieldSuggester.Builder().prefix("xyz").completion(completionSuggester).build();
        Suggester suggester = new Suggester.Builder().suggesters(Collections.singletonMap(suggesterName, fieldSuggester)).build();
        SearchRequest searchRequest = new SearchRequest.Builder().index(index).suggest(suggester).build();

        SearchResponse<AppData> response = javaClient().search(searchRequest, AppData.class);
        assertTrue(response.suggest().size() > 0);
        assertTrue(response.suggest().keySet().contains(suggesterName));
        assertNotNull(response.suggest().get(suggesterName));
        assertEquals(response.suggest().get(suggesterName).get(0).completion().options().size(), 0);
    }

    @Test
    public void testPit() throws IOException {
        assumeTrue("The PIT is supported in OpenSearch 2.4.0 and later", getServerVersion().onOrAfter(Version.V_2_4_0));

        String index = "test-point-in-time";

        javaClient().indices().create(c -> c.index(index));

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        javaClient().index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));
        CreatePitRequest createPitRequest = new CreatePitRequest.Builder().index(Collections.singletonList(index))
            .keepAlive(new Time.Builder().time("100m").build())
            .build();

        CreatePitResponse createPitResponse = javaClient().createPit(createPitRequest);

        assertNotNull(createPitResponse);
        assertNotNull(createPitResponse.pitId());
        assertEquals(createPitResponse.shards().total(), createPitResponse.shards().successful());

        GetAllPitsResponse listAllPitResponse = javaClient().getAllPits();

        assertNotNull(listAllPitResponse);
        assertNotNull(listAllPitResponse.pits());
        assertEquals(listAllPitResponse.pits().get(0).pitId(), createPitResponse.pitId());
        assertEquals(listAllPitResponse.pits().get(0).keepAlive(), Long.valueOf(6000000L));

        DeletePitRequest deletePitRequest = new DeletePitRequest.Builder().pitId(Collections.singletonList(createPitResponse.pitId()))
            .build();

        DeletePitResponse deletePitResponse = javaClient().deletePit(deletePitRequest);

        assertNotNull(deletePitResponse);
        assertNotNull(deletePitResponse.pits());
        assertEquals(deletePitResponse.pits().get(0).pitId(), createPitResponse.pitId());
        assertTrue(deletePitResponse.pits().get(0).successful());
    }

    public void testCompletionSuggester() throws IOException {

        String index = "test-completion-suggester";

        Property intValueProp = new Property.Builder().long_(v -> v).build();
        Property msgCompletionProp = new Property.Builder().completion(c -> c).build();
        javaClient().indices()
            .create(c -> c.index(index).mappings(m -> m.properties("intValue", intValueProp).properties("msg", msgCompletionProp)));

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        javaClient().index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));

        appData.setIntValue(1338);
        appData.setMsg("foobar");

        javaClient().index(b -> b.index(index).id("2").document(appData).refresh(Refresh.True));

        String suggesterName = "msgSuggester";

        CompletionSuggester completionSuggester = FieldSuggesterBuilders.completion().field("msg").size(1).build();
        FieldSuggester fieldSuggester = new FieldSuggester.Builder().prefix("foo").completion(completionSuggester).build();
        Suggester suggester = new Suggester.Builder().suggesters(Collections.singletonMap(suggesterName, fieldSuggester)).build();
        SearchRequest searchRequest = new SearchRequest.Builder().index(index).suggest(suggester).build();

        SearchResponse<AppData> response = javaClient().search(searchRequest, AppData.class);
        assertTrue(response.suggest().size() > 0);
        assertTrue(response.suggest().keySet().contains(suggesterName));
        assertNotNull(response.suggest().get(suggesterName));
        assertNotNull(response.suggest().get(suggesterName).get(0).completion().options());
        assertTrue(response.suggest().get(suggesterName).get(0).isCompletion());
        assertNotNull(response.suggest().get(suggesterName).get(0).completion().options());
        assertEquals(response.suggest().get(suggesterName).get(0).completion().options().get(0).text(), "foo");
    }

    @Test
    public void testTermSuggester() throws IOException {

        String index = "test-term-suggester";

        // term suggester does not require a special mapping
        javaClient().indices().create(c -> c.index(index));

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        javaClient().index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));

        appData.setIntValue(1338);
        appData.setMsg("foobar");

        javaClient().index(b -> b.index(index).id("2").document(appData).refresh(Refresh.True));

        String suggesterName = "msgSuggester";

        TermSuggester termSuggester = FieldSuggesterBuilders.term().field("msg").size(1).build();
        FieldSuggester fieldSuggester = new FieldSuggester.Builder().text("fool").term(termSuggester).build();
        Suggester suggester = new Suggester.Builder().suggesters(Collections.singletonMap(suggesterName, fieldSuggester)).build();
        SearchRequest searchRequest = new SearchRequest.Builder().index(index).suggest(suggester).build();

        SearchResponse<AppData> response = javaClient().search(searchRequest, AppData.class);
        assertTrue(response.suggest().size() > 0);
        assertTrue(response.suggest().keySet().contains(suggesterName));
        assertNotNull(response.suggest().get(suggesterName));
        assertTrue(response.suggest().get(suggesterName).get(0).isTerm());
        assertNotNull(response.suggest().get(suggesterName).get(0).term().options());
        assertEquals(response.suggest().get(suggesterName).get(0).term().options().get(0).text(), "foo");
    }

    @Test
    public void testPhraseSuggester() throws IOException {

        String index = "test-phrase-suggester";

        ShingleTokenFilter shingleTokenFilter = new ShingleTokenFilter.Builder().minShingleSize(2).maxShingleSize(3).build();

        Analyzer analyzer = new Analyzer.Builder().custom(
            new CustomAnalyzer.Builder().tokenizer("standard").filter(Arrays.asList("lowercase", "shingle")).build()
        ).build();

        TokenFilter tokenFilter = new TokenFilter.Builder().definition(
            new TokenFilterDefinition.Builder().shingle(shingleTokenFilter).build()
        ).build();

        IndexSettingsAnalysis indexSettingsAnalysis = new IndexSettingsAnalysis.Builder().analyzer("trigram", analyzer)
            .filter("shingle", tokenFilter)
            .build();

        IndexSettings settings = new IndexSettings.Builder().analysis(indexSettingsAnalysis).build();

        TypeMapping mapping = new TypeMapping.Builder().properties(
            "msg",
            new Property.Builder().text(
                new TextProperty.Builder().fields(
                    "trigram",
                    new Property.Builder().text(new TextProperty.Builder().analyzer("trigram").build()).build()
                ).build()
            ).build()
        ).build();

        javaClient().indices().create(c -> c.index(index).settings(settings).mappings(mapping));

        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("Design Patterns");

        javaClient().index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));

        appData.setIntValue(1338);
        appData.setMsg("Software Architecture Patterns Explained");

        javaClient().index(b -> b.index(index).id("2").document(appData).refresh(Refresh.True));

        String suggesterName = "msgSuggester";

        PhraseSuggester phraseSuggester = FieldSuggesterBuilders.phrase()
            .field("msg.trigram")
            .collate(
                c -> c.query(q -> q.source("{\"match\": {\"{{field_name}}\" : \"{{suggestion}}\"}}"))
                    .prune(true)
                    .params(Map.of("field_name", JsonData.of("msg")))
            )
            .build();
        FieldSuggester fieldSuggester = new FieldSuggester.Builder().text("design paterns").phrase(phraseSuggester).build();
        Suggester suggester = new Suggester.Builder().suggesters(Collections.singletonMap(suggesterName, fieldSuggester)).build();
        SearchRequest searchRequest = new SearchRequest.Builder().index(index).suggest(suggester).build();

        SearchResponse<AppData> response = javaClient().search(searchRequest, AppData.class);
        assertTrue(response.suggest().size() > 0);
        assertTrue(response.suggest().keySet().contains(suggesterName));
        assertNotNull(response.suggest().get(suggesterName));
        assertNotNull(response.suggest().get(suggesterName).get(0));
        assertTrue(response.suggest().get(suggesterName).get(0).isPhrase());
        assertNotNull(response.suggest().get(suggesterName).get(0).phrase().options());
        assertEquals(response.suggest().get(suggesterName).get(0).phrase().options().get(0).text(), "design patterns");
        assertEquals(response.suggest().get(suggesterName).get(0).phrase().options().get(0).collateMatch(), true);
    }

    public static class AppData {

        private int intValue;
        private String msg;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static class Product {

        public double price;
        public String color;

        public Product() {}

        public Product(double price) {
            this.price = price;
        }

        public Product(double price, String color) {
            this.price = price;
            this.color = color;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static class Join {

        public String name;
        public String parent;

        Join() {}

        Join(String name) {
            this.name = name;
        }

        Join(String name, String parent) {
            this.name = name;
            this.parent = parent;
        }
    }

    public static class Question {

        public String title;
        public Join join;

        Question() {}

        Question(String title) {
            this.title = title;
            this.join = new Join("question");
        }
    }

    public static class Answer {

        public String body;
        public Join join;

        Answer() {}

        Answer(String body) {
            this.body = body;
        }

        Answer(String body, String parent) {
            this.body = body;
            this.join = new Join("answer", parent);
        }
    }
}
