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

package org.opensearch.client.opensearch.json;

import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpUtils;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch.core.IndexRequest;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.experiments.api.query2.BoolQuery;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class JsonDataTest extends Assert {

    @Test
    public void testParsing() {
        JsonpMapper mapper = new JsonbJsonpMapper();
        String json = "{\"children\":[{\"doubleValue\":3.2,\"intValue\":2}],\"doubleValue\":2.1,\"intValue\":1,"
            + "\"stringValue\":\"foo\"}";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));

        JsonData data = JsonData.from(parser, mapper);
        assertEquals("foo", data.toJson().asJsonObject().getString("stringValue"));

        JsonpMapperTest.SomeClass to = data.to(JsonpMapperTest.SomeClass.class);
        assertEquals("foo", to.getStringValue());
    }

    @Test
    public void testSerialize() {

        JsonpMapper mapper = new JsonbJsonpMapper();
        String json = "{\"children\":[{\"doubleValue\":3.2,\"intValue\":2}],\"doubleValue\":2.1,\"intValue\":1,"
            + "\"stringValue\":\"foo\"}";

        JsonpMapperTest.SomeClass sc = ModelTestCase.fromJson(json, JsonpMapperTest.SomeClass.class, mapper);

        assertEquals("foo", sc.getStringValue());
        assertEquals(1, sc.getChildren().size());
        assertEquals(2, sc.getChildren().get(0).getIntValue());
        // All good

        JsonData data = JsonData.of(sc);

        assertEquals(json, ModelTestCase.toJson(data, mapper));
    }

    @Test
    public void testConvert() {

        JsonData json = JsonData.of("foo");

        final JsonValue value = json.toJson(new JsonbJsonpMapper());

        assertEquals(JsonValue.ValueType.STRING, value.getValueType());
        assertEquals("foo", ((JsonString) value).getString());
    }



    public class Person {
        private int aga;
        private String name;


        public Person(int aga, String name) {
            this.aga = aga;
            this.name = name;
        }

        public int getAga() {
            return aga;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    public void indexRequestToJsonTest() {
        String expectedJson = "{\"aga\":42,\"name\":\"koko\"}";
        Person person = new Person(42, "koko");
        IndexRequest<Person> indexRequest = new IndexRequest.Builder<Person>()
                .index("sample-index")
                .id("1")
                .document(person)
                .build();

        String json = JsonpUtils.toJson(indexRequest);
        System.out.println(json);

        assertEquals(expectedJson, json);
    }

    @Test
    public void searchRequestToJsonTest() {
        String expectedJson = "{\"query\":{\"term\":{\"key-field\":{\"value\":\"value-filed\"}}}}";

        SearchRequest searchRequest = new SearchRequest
                .Builder()
                .index("my-index")
                .query(new TermQuery
                        .Builder()
                        .field("key-field")
                        .value(FieldValue.of("value-filed"))
                        .build()
                        ._toQuery()
                )
                .build();

        String json = JsonpUtils.toJson(searchRequest);
        System.out.println(json);

        assertEquals(expectedJson, json);
    }


}
