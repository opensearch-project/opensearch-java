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

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.opensearch._types.query_dsl.SpanGapQuery;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;

public class BuiltinTypesTest extends ModelTestCase {

    @Test
    public void testPrimitiveTypes() {

        assertGetterType(Integer.class, SearchRequest.class, "size");

        // Lenient boolean: 'query_string.lenient'?: boolean | string
        // Also tests field names with '.'
        assertGetterType(Boolean.class, IndexSettings.class, "queryStringLenient");

    }

    @Test
    public void testLenientArray() {
        // index: Indices --> type Indices = IndexName | IndexName[]
        assertGetterType(List.class, SearchRequest.class, "index");
    }

    @Test
    public void testSpanGapQuery() {
        // Hand-written class
        SpanGapQuery q = SpanGapQuery.of(b -> b.field("a-field").spanWidth(12));

        q = checkJsonRoundtrip(q, "{\"a-field\":12}");

        assertEquals("a-field", q.field());
        assertEquals(12, q.spanWidth());
    }

    @Test
    public void testSortOptions() {
        // Has a custom deserializer

        String json;
        SortOptions sort;

        // Arbitrary field
        sort = fromJson("{ \"post_date\" : {\"order\" : \"asc\", \"format\": \"strict_date_optional_time_nanos\"}}", SortOptions.class);

        assertEquals("post_date", sort.field().field());
        assertEquals(SortOrder.Asc, sort.field().order());

        sort = fromJson(
            "{\n"
                + "          \"offer.price\" : {\n"
                + "             \"mode\" :  \"avg\",\n"
                + "             \"order\" : \"asc\",\n"
                + "             \"nested\": {\n"
                + "                \"path\": \"offer\",\n"
                + "                \"filter\": {\n"
                + "                   \"term\" : { \"offer.color\" : \"blue\" }\n"
                + "                }\n"
                + "             }\n"
                + "          }\n"
                + "       }",
            SortOptions.class
        );

        assertEquals("blue", sort.field().nested().filter().term().value().stringValue());

        // Geo distance
        sort = fromJson(
            "{\n"
                + "      \"_geo_distance\" : {\n"
                + "        \"pin.location\" : {\n"
                + "          \"lat\" : 40,\n"
                + "          \"lon\" : -70\n"
                + "        },\n"
                + "        \"order\" : \"asc\",\n"
                + "        \"unit\" : \"km\"\n"
                + "      }\n"
                + "    }",
            SortOptions.class
        );

        assertEquals(40, sort.geoDistance().location().get(0).latlon().lat(), 0.1);

        // Simple string shortcuts
        sort = fromJson("\"user\"", SortOptions.class);
        assertEquals("user", sort.field().field());

        sort = fromJson("\"_doc\"", SortOptions.class);
        assertTrue(sort.isDoc());

        sort = fromJson("\"_score\"", SortOptions.class);
        assertTrue(sort.isScore());
    }

    @Test
    public void testFieldValue() {

        FieldValue f;

        f = FieldValue.of(b -> b.nullValue());
        f = checkJsonRoundtrip(f, "null");
        assertTrue(f.isNull());
        assertEquals("null", f._toJsonString());

        f = FieldValue.of(b -> b.doubleValue(1.23));
        f = checkJsonRoundtrip(f, "1.23");
        assertTrue(f.isDouble());
        assertEquals(1.23, f.doubleValue(), 0.01);
        assertEquals("1.23", f._toJsonString());

        f = FieldValue.of(b -> b.longValue(123));
        f = checkJsonRoundtrip(f, "123");
        assertTrue(f.isLong());
        assertEquals(123, f.longValue());
        assertEquals("123", f._toJsonString());

        f = FieldValue.of(b -> b.booleanValue(true));
        f = checkJsonRoundtrip(f, "true");
        assertTrue(f.isBoolean());
        assertTrue(f.booleanValue());
        assertEquals("true", f._toJsonString());

        f = FieldValue.of(b -> b.booleanValue(false));
        f = checkJsonRoundtrip(f, "false");
        assertTrue(f.isBoolean());
        assertFalse(f.booleanValue());
        assertEquals("false", f._toJsonString());

        f = FieldValue.of(b -> b.stringValue("foo"));
        f = checkJsonRoundtrip(f, "\"foo\"");
        assertTrue(f.isString());
        assertEquals("foo", f.stringValue());
        assertEquals("foo", f._toJsonString());

    }

    @Test
    public void testNullableStringInArray() {
        // stringOrNullDeserializer allows to handle null events in string arrays
        String json = "[\"lettuce\", null, \"tomato\"]";
        JsonpDeserializer<String> stringDeserializer = JsonpDeserializer.stringOrNullDeserializer();

        List<String> result = fromJson(json, JsonpDeserializer.arrayDeserializer(stringDeserializer));

        List<String> expected = new ArrayList<>();
        expected.add("lettuce");
        expected.add(null);
        expected.add("tomato");

        assertEquals(result, expected);
    }
}
