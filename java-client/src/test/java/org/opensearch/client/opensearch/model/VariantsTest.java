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

package org.opensearch.client.opensearch.model;

import java.util.Arrays;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.mapping.Property;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.opensearch._types.query_dsl.KnnQuery;
import org.opensearch.client.opensearch._types.query_dsl.NeuralQuery;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch._types.query_dsl.QueryBuilders;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.indices.GetMappingResponse;

public class VariantsTest extends ModelTestCase {

    @Test
    public void testNested() {
        // nested containers: query > intervals > interval
        // intervals is a single key dictionary
        // query has container properties

        Query q = Query.of(
            _0 -> _0.intervals(
                _1 -> _1.queryName("my-query")
                    .field("a_field")
                    .anyOf(_2 -> _2.intervals(_3 -> _3.match(_5 -> _5.query("match-query").analyzer("lowercase"))))
            )
        );

        assertEquals(Query.Kind.Intervals, q._kind());
        assertNotNull(q.intervals());
        assertEquals("a_field", q.intervals().field());
        assertEquals(1, q.intervals().anyOf().intervals().size());
        assertEquals("lowercase", q.intervals().anyOf().intervals().get(0).match().analyzer());

        String json = toJson(q);

        assertEquals(
            "{\"intervals\":{\"a_field\":{\"_name\":\"my-query\","
                + "\"any_of\":{\"intervals\":[{\"match\":{\"analyzer\":\"lowercase\",\"query\":\"match-query\"}}]}}}}",
            json
        );

        Query q2 = fromJson(json, Query.class);
        assertEquals(json, toJson(q2));

        assertEquals(Query.Kind.Intervals, q2._kind());
        assertNotNull(q2.intervals());
        assertEquals("a_field", q2.intervals().field());
        assertEquals(1, q2.intervals().anyOf().intervals().size());
        assertEquals("lowercase", q2.intervals().anyOf().intervals().get(0).match().analyzer());

    }

    @Test
    public void testInternalTag() {
        String expected = "{\"type\":\"ip\",\"fields\":{\"a-field\":{\"type\":\"float\",\"coerce\":true}},\"boost\":1"
            + ".0,\"index\":true}";

        Property p = Property.of(_0 -> _0.ip(_1 -> _1.index(true).boost(1.0).fields("a-field", _3 -> _3.float_(_4 -> _4.coerce(true)))));

        assertEquals(expected, toJson(p));

        Property property = fromJson(expected, Property.class);
        assertTrue(property.ip().index());
        assertEquals(1.0, property.ip().boost().doubleValue(), 0.09);

        assertTrue(property.ip().fields().get("a-field").float_().coerce());
    }

    @Test
    public void testBuilders() {
        Query q = new Query(QueryBuilders.exists().field("foo").build());

        assertEquals("{\"exists\":{\"field\":\"foo\"}}", toJson(q));
    }

    @Test
    public void testNestedTaggedUnionWithDefaultTag() {

        // Object fields don't really exist in ES and are based on a naming convention where field names
        // are dot-separated paths. The hierarchy is rebuilt from these names and ES doesn't send back
        // "type": "object" for object properties.
        //
        // Mappings are therefore a hierarchy of internally-tagged unions based on the "type" property
        // with a default "object" tag value if the "type" property is missing.

        String json = "{\n"
            + "  \"testindex\" : {\n"
            + "    \"mappings\" : {\n"
            + "      \"properties\" : {\n"
            + "        \"id\" : {\n"
            + "          \"type\" : \"text\",\n"
            + "          \"fields\" : {\n"
            + "            \"keyword\" : {\n"
            + "              \"type\" : \"keyword\",\n"
            + "              \"ignore_above\" : 256\n"
            + "            }\n"
            + "          }\n"
            + "        },\n"
            + "        \"name\" : {\n"
            + "          \"properties\" : {\n"
            + "            \"first\" : {\n"
            + "              \"type\" : \"text\",\n"
            + "              \"fields\" : {\n"
            + "                \"keyword\" : {\n"
            + "                  \"type\" : \"keyword\",\n"
            + "                  \"ignore_above\" : 256\n"
            + "                }\n"
            + "              }\n"
            + "            },\n"
            + "            \"last\" : {\n"
            + "              \"type\" : \"text\",\n"
            + "              \"fields\" : {\n"
            + "                \"keyword\" : {\n"
            + "                  \"type\" : \"keyword\",\n"
            + "                  \"ignore_above\" : 256\n"
            + "                }\n"
            + "              }\n"
            + "            }\n"
            + "          }\n"
            + "        }\n"
            + "      }\n"
            + "    }\n"
            + "  }\n"
            + "}";

        GetMappingResponse response = fromJson(json, GetMappingResponse.class);

        TypeMapping mappings = response.get("testindex").mappings();
        assertTrue(mappings.properties().get("name").isObject());

        assertEquals(
            256,
            mappings.properties()
                .get("name")
                .object()
                .properties()
                .get("first")
                .text()
                .fields()
                .get("keyword")
                .keyword()
                .ignoreAbove()
                .longValue()
        );

        assertTrue(mappings.properties().get("id").isText());

        assertEquals(256, mappings.properties().get("id").text().fields().get("keyword").keyword().ignoreAbove().longValue());
    }

    @Test
    public void testEmptyProperty() {
        // Edge case where we have a property with no fields and no type
        String json = "{}";
        Property property = fromJson(json, Property.class);
        assertEquals(Property.Kind.Object, property._kind());
    }

    @Test
    public void testNestedVariantsWithContainerProperties() {

        SearchRequest search = SearchRequest.of(
            s -> s.aggregations(
                "agg1",
                a -> a.meta("m1", JsonData.of("m1 value"))
                    // Here we can choose any aggregation type, but build() isn't accessible
                    .valueCount(v -> v.field("f"))
                    // Here we can only set container properties (meta and (sub)aggregations) or build()
                    .meta("m2", JsonData.of("m2 value"))
            )
        );

        assertEquals("m1 value", search.aggregations().get("agg1").meta().get("m1").to(String.class));
        assertEquals("m2 value", search.aggregations().get("agg1").meta().get("m2").to(String.class));
    }

    @Test
    public void testNeuralQuery() {

        SearchRequest searchRequest = SearchRequest.of(
            s -> s.query(q -> q.neural(n -> n.field("passage_embedding").queryText("Hi world").modelId("bQ1J8ooBpBj3wT4HVUsb").k(100)))
        );

        assertEquals("passage_embedding", searchRequest.query().neural().field());
        assertEquals("Hi world", searchRequest.query().neural().queryText());
        assertEquals("bQ1J8ooBpBj3wT4HVUsb", searchRequest.query().neural().modelId());
        assertEquals((Integer) 100, searchRequest.query().neural().k());
    }

    @Test
    public void testNeuralQueryFromJson() {

        String json = "{\n"
            + "  \"from\": 0,\n"
            + "  \"size\": 100,\n"
            + "  \"query\": {\n"
            + "    \"neural\": {\n"
            + "      \"passage_embedding\": {\n"
            + "        \"query_text\": \"Hi world!\",\n"
            + "        \"query_image\": \"iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAA1JREFUGFdj+L+U4T8ABu8CpCYJ1DQAAAAASUVORK5CYII=\",\n"
            + "        \"model_id\": \"bQ1J8ooBpBj3wT4HVUsb\",\n"
            + "        \"k\": 100\n"
            + "      }\n"
            + "    }\n"
            + "  }\n"
            + "}";

        SearchRequest searchRequest = ModelTestCase.fromJson(json, SearchRequest.class, mapper);

        assertEquals("passage_embedding", searchRequest.query().neural().field());
        assertEquals("Hi world!", searchRequest.query().neural().queryText());
        assertEquals(
            "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAA1JREFUGFdj+L+U4T8ABu8CpCYJ1DQAAAAASUVORK5CYII=",
            searchRequest.query().neural().queryImage()
        );
        assertEquals("bQ1J8ooBpBj3wT4HVUsb", searchRequest.query().neural().modelId());
        assertEquals((Integer) 100, searchRequest.query().neural().k());
    }

    @Test
    public void testHybridQuery() {

        Query query = Query.of(
            h -> h.hybrid(
                q -> q.queries(
                    Arrays.asList(
                        new TermQuery.Builder().field("passage_text").value(FieldValue.of("Foo bar")).build().toQuery(),
                        new NeuralQuery.Builder().field("passage_embedding")
                            .queryText("Hi world")
                            .modelId("bQ1J8ooBpBj3wT4HVUsb")
                            .k(100)
                            .build()
                            .toQuery(),
                        new KnnQuery.Builder().field("passage_embedding").vector(0.01f, 0.02f).k(2).build().toQuery()
                    )
                )
            )
        );
        SearchRequest searchRequest = SearchRequest.of(s -> s.query(query));
        assertEquals("passage_text", searchRequest.query().hybrid().queries().get(0).term().field());
        assertEquals("Foo bar", searchRequest.query().hybrid().queries().get(0).term().value().stringValue());
        assertEquals("passage_embedding", searchRequest.query().hybrid().queries().get(1).neural().field());
        assertEquals("Hi world", searchRequest.query().hybrid().queries().get(1).neural().queryText());
        assertEquals("bQ1J8ooBpBj3wT4HVUsb", searchRequest.query().hybrid().queries().get(1).neural().modelId());
        assertEquals((Integer) 100, searchRequest.query().hybrid().queries().get(1).neural().k());
        assertEquals("passage_embedding", searchRequest.query().hybrid().queries().get(2).knn().field());
        assertEquals(2, searchRequest.query().hybrid().queries().get(2).knn().vector().size());
        assertEquals((Integer) 2, searchRequest.query().hybrid().queries().get(2).knn().k());
    }

    @Test
    public void testHybridQueryFromJson() {

        String json = "{\"query\""
            + ":{\"hybrid\":{\"queries\":[{\"term\":{\"passage_text\":\"Foo bar\"}},"
            + "{\"neural\":{\"passage_embedding\":{\"query_text\":\"Hi world\",\"model_id\":\"bQ1J8ooBpBj3wT4HVUsb\",\"k\":100}}},"
            + "{\"knn\":{\"passage_embedding\":{\"vector\":[0.01,0.02],\"k\":2}}}]}},\"size\":10"
            + "}";

        SearchRequest searchRequest = ModelTestCase.fromJson(json, SearchRequest.class, mapper);

        assertEquals("passage_text", searchRequest.query().hybrid().queries().get(0).term().field());
        assertEquals("Foo bar", searchRequest.query().hybrid().queries().get(0).term().value().stringValue());
        assertEquals("passage_embedding", searchRequest.query().hybrid().queries().get(1).neural().field());
        assertEquals("Hi world", searchRequest.query().hybrid().queries().get(1).neural().queryText());
        assertEquals("bQ1J8ooBpBj3wT4HVUsb", searchRequest.query().hybrid().queries().get(1).neural().modelId());
        assertEquals((Integer) 100, searchRequest.query().hybrid().queries().get(1).neural().k());
        assertEquals("passage_embedding", searchRequest.query().hybrid().queries().get(2).knn().field());
        assertEquals(2, searchRequest.query().hybrid().queries().get(2).knn().vector().size());
        assertEquals((Integer) 2, searchRequest.query().hybrid().queries().get(2).knn().k());
    }
}
