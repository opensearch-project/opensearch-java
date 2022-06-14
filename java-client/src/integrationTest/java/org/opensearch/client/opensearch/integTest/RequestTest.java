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


import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.aggregations.HistogramAggregate;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch.cat.NodesResponse;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.ClearScrollResponse;
import org.opensearch.client.opensearch.core.GetResponse;
import org.opensearch.client.opensearch.core.IndexResponse;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.opensearch.core.msearch.RequestItem;
import org.opensearch.client.opensearch.indices.CreateIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndexResponse;
import org.opensearch.client.opensearch.indices.GetIndicesSettingsResponse;
import org.opensearch.client.opensearch.indices.GetMappingResponse;
import org.opensearch.client.opensearch.indices.IndexState;
import org.opensearch.client.opensearch.model.ModelTestCase;
import org.opensearch.client.transport.endpoints.BooleanResponse;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RequestTest extends OpenSearchRestHighLevelClientTestCase {


    @Test
    public void testCount() throws Exception {

        // Tests that a no-parameter method exists for endpoints that only have optional properties
        assertTrue(highLevelClient().count().count() >= 0);
    }

    @Test
    public void testIndexCreation() throws Exception {
        OpenSearchAsyncClient asyncClient = new OpenSearchAsyncClient(highLevelClient()._transport());

        // Ping the server
        assertTrue(highLevelClient().ping().value());

        // Create an index...
        final CreateIndexResponse createResponse = highLevelClient().indices().create(b -> b.index("my-index"));
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
    public void testDataIngestion() throws Exception {

        String index = "ingest-test";

        // Create an index
        CreateIndexResponse createIndexResponse = highLevelClient().indices().create(b -> b
                .index(index)
        );

        assertEquals(index, createIndexResponse.index());

        // Check that it actually exists. Example of a boolean response
        BooleanResponse existsResponse = highLevelClient().indices().exists(b -> b.index(index));
        assertTrue(existsResponse.value());

        // Ingest some data
        AppData appData = new AppData();
        appData.setIntValue(1337);
        appData.setMsg("foo");

        String docId = highLevelClient().index(b -> b
                .index(index)
                .id("my/Id") // test with url-unsafe string
                .document(appData)
                .refresh(Refresh.True) // Make it visible for search
        ).id();

        assertEquals("my/Id", docId);

        // Check auto-created mapping
        GetMappingResponse mapping = highLevelClient().indices().getMapping(b -> b.index(index));
        assertEquals(
                Property.Kind.Long,
                mapping.get("ingest-test").mappings().properties().get("intValue")._kind()
        );

        // Query by id
        AppData esData = highLevelClient().get(b -> b
                        .index(index)
                        .id(docId)
                , AppData.class
        ).source();

        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());

        // Query by id a non-existing document
        final GetResponse<AppData> notExists = highLevelClient().get(b -> b
                        .index(index)
                        .id("some-random-id")
                , AppData.class
        );

        assertFalse(notExists.found());
        assertNull(notExists.source());

        // Search
        SearchResponse<AppData> search = highLevelClient().search(b -> b
                        .index(index)
                , AppData.class
        );

        long hits = search.hits().total().value();
        assertEquals(1, hits);

        esData = search.hits().hits().get(0).source();
        assertEquals(1337, esData.getIntValue());
        assertEquals("foo", esData.getMsg());

        RequestItem item = RequestItem.of(_1 -> _1
                .header(_2 -> _2.index("test"))
                .body(_2 -> _2.size(4))
        );

        // MSearch: 1st search on an existing index, 2nd one on a non-existing index
        final MsearchResponse<AppData> msearch = highLevelClient().msearch(_0 -> _0
                        .searches(_1 -> _1
                                .header(_3 -> _3.index(index))
                                .body(_3 -> _3.query(_4 -> _4.matchAll(_5 -> _5)))
                        ).searches(_1 -> _1
                                .header(_3 -> _3.index("non-existing"))
                                .body(_3 -> _3.query(_4 -> _4.matchAll(_5 -> _5)))
                        )
                , AppData.class);

        assertEquals(2, msearch.responses().size());
        assertTrue(msearch.responses().get(0).isResult());
        assertEquals(1, msearch.responses().get(0).result().hits().hits().size());
        assertTrue(msearch.responses().get(1).isFailure());
        assertEquals(404, msearch.responses().get(1).failure().status());
    }

    @Test
    public void testCatRequest() throws IOException {
        // Cat requests should have the "format=json" added by the transport
        NodesResponse nodes = highLevelClient().cat().nodes(_0 -> _0);
        System.out.println(ModelTestCase.toJson(nodes, highLevelClient()._transport().jsonpMapper()));

        assertEquals(1, nodes.valueBody().size());
        // TODO: Removing this assert for now since the endpoint _cat/nodes now returns cluster_manager. 
        // This will be done along with changes for inclusive naming.
        // assertEquals("*", nodes.valueBody().get(0).master());
    }

    @Test
    public void testBulkRequest() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        BulkResponse bulk = highLevelClient().bulk(_0 -> _0
                .operations(_1 -> _1
                        .create(_2 -> _2
                                .index("foo")
                                .id("abc")
                                .document(appData)
                        ))
                .operations(_1 -> _1
                        .create(_2 -> _2
                                .index("foo")
                                .id("def")
                                .document(appData)
                        ))
        );

        assertFalse(bulk.errors());
        assertEquals(2, bulk.items().size());
        assertEquals(OperationType.Create, bulk.items().get(0).operationType());
        assertEquals("foo", bulk.items().get(0).index());
        assertEquals(1L, bulk.items().get(0).version().longValue());
        assertEquals("foo", bulk.items().get(1).index());
        assertEquals(1L, bulk.items().get(1).version().longValue());
        assertEquals(42, highLevelClient().get(b -> b.index("foo").id("abc"), AppData.class).source().getIntValue());
    }

    @Test
    public void testRefresh() throws IOException {
        AppData appData = new AppData();
        appData.setIntValue(42);
        appData.setMsg("Some message");

        IndexResponse ir = highLevelClient().index(_0 -> _0
                .index("test")
                .id("1")
                .document(appData)
                .refresh(Refresh.WaitFor)
        );

        assertEquals("1", ir.id());
    }

    @Test public void errorResponse() throws Exception {
        BooleanResponse exists = highLevelClient().exists(_0 -> _0.index("doesnotexist").id("reallynot"));
        assertFalse(exists.value());

        OpenSearchException ex = assertThrows(OpenSearchException.class, () -> {
            GetResponse<String> response = highLevelClient().get(
                    _0 -> _0.index("doesnotexist").id("reallynot"), String.class
            );
        });

        assertEquals(404, ex.status());
        assertEquals("index_not_found_exception", ex.error().type());
        assertEquals("doesnotexist", ex.error().metadata().get("index").to(String.class));


        ExecutionException ee = assertThrows(ExecutionException.class, () -> {
            OpenSearchAsyncClient aClient = new OpenSearchAsyncClient(highLevelClient()._transport());
            GetResponse<String> response = aClient.get(
                    _0 -> _0.index("doesnotexist").id("reallynot"), String.class
            ).get();
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

        final ClearScrollResponse clearResponse = highLevelClient().clearScroll(b -> b.scrollId(
                "DXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAD4WYm9laVYtZndUQlNsdDcwakFMNjU1QQ==")
        );
        assertEquals(0, clearResponse.numFreed());
    }

    @Test
    public void testSearchAggregation() throws IOException {

        highLevelClient().create(_1 -> _1.index("products").id("A").document(new Product(5)).refresh(Refresh.True));
        highLevelClient().create(_1 -> _1.index("products").id("B").document(new Product(15)).refresh(Refresh.True));
        highLevelClient().create(_1 -> _1.index("products").id("C").document(new Product(25)).refresh(Refresh.True));

        SearchResponse<Product> searchResponse = highLevelClient().search(_1 -> _1
                        .index("products")
                        .size(0)
                        .aggregations(
                                "prices", _3 -> _3
                                        .histogram(_4 -> _4
                                                .field("price")
                                                .interval(10.0)
                                        ).aggregations(
                                                "average", _5 -> _5
                                                        .avg(_6 -> _6.field("price"))
                                        )
                        )
                , Product.class
        );

        HistogramAggregate prices = searchResponse.aggregations().get("prices").histogram();
        assertEquals(3, prices.buckets().array().size());
        assertEquals(1, prices.buckets().array().get(0).docCount());
        assertEquals(5.0, prices.buckets().array().get(0).aggregations().get("average").avg().value(), 0.01);

        // We've set "size" to zero
        assertEquals(0, searchResponse.hits().hits().size());

    }

    @Test
    public void testGetMapping() throws Exception {
        // See also VariantsTest.testNestedTaggedUnionWithDefaultTag()
        String index = "testindex";

        Map<String, Property> fields = Collections.singletonMap("keyword", Property.of(p -> p.keyword(k -> k.ignoreAbove(256))));
        Property text = Property.of(p -> p.text(t -> t.fields(fields)));

        highLevelClient().indices().create(c -> c
                .index(index)
                .mappings(m -> m
                        .properties("id", text)
                        .properties("name", p -> p
                                .object(o -> o
                                        .properties("first", text)
                                        .properties("last", text)
                                )
                        )
                )
        );

        GetMappingResponse mr = highLevelClient().indices().getMapping(mrb -> mrb.index(index));

        assertNotNull(mr.result().get(index));
        assertNotNull(mr.result().get(index).mappings().properties().get("name").object());
    }

    @Test
    public void testDefaultIndexSettings() throws IOException {

        String index = "index-settings";
        highLevelClient().index(_1 -> _1.index(index).document(new Product(5)).refresh(Refresh.True));

        GetIndicesSettingsResponse settings;
        settings = highLevelClient().indices().getSettings(b -> b.index(index).includeDefaults(true));
        assertNotNull(settings.get(index).defaults());

        settings = highLevelClient().indices().getSettings(b -> b.index(index));
        assertNull(settings.get(index).defaults());
    }

//    @Test
//    public void testValueBodyResponse() throws Exception {
//        DiskUsageResponse resp = highLevelClient().indices().diskUsage(b -> b
//                .index("*")
//                .allowNoIndices(true)
//                .runExpensiveTasks(true)
//        );
//
//        assertNotNull(resp.valueBody().toJson().asJsonObject().get("_shards"));
//    }

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

        public Product() {}
        public Product(double price) {
            this.price = price;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}