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

package org.opensearch.client.opensearch.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.junit.Test;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpMapperBase;
import org.opensearch.client.json.jackson.JacksonJsonProvider;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.core.MsearchResponse;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class JacksonJsonpParserTest extends ModelTestCase {

    private static final String json = "{ 'foo': 'fooValue', 'bar': { 'baz': 1}, 'quux': [true] }".replace('\'', '"');

    @Test
    public void testEventStream() {

        JacksonJsonProvider provider = new JacksonJsonProvider();
        JsonParser parser = provider.createParser(new StringReader(json));

        assertEquals(Event.START_OBJECT, parser.next());

        assertEquals(Event.KEY_NAME, parser.next());
        assertEquals("foo", parser.getString());

        assertEquals(Event.VALUE_STRING, parser.next());
        assertEquals("fooValue", parser.getString());

        // test it sometimes, but not always to detect invalid state management
        assertTrue(parser.hasNext());

        assertEquals(Event.KEY_NAME, parser.next());
        assertEquals("bar", parser.getString());

        assertEquals(Event.START_OBJECT, parser.next());

        assertEquals(Event.KEY_NAME, parser.next());
        assertEquals("baz", parser.getString());

        assertTrue(parser.hasNext());
        assertEquals(Event.VALUE_NUMBER, parser.next());
        assertEquals(1, parser.getInt());

        assertEquals(Event.END_OBJECT, parser.next());

        assertEquals(Event.KEY_NAME, parser.next());
        assertEquals("quux", parser.getString());

        assertEquals(Event.START_ARRAY, parser.next());

        assertEquals(Event.VALUE_TRUE, parser.next());

        assertEquals(Event.END_ARRAY, parser.next());
        assertEquals(Event.END_OBJECT, parser.next());

        assertFalse(parser.hasNext());
    }

    @Test
    public void testForbidValueGettersAfterHasNext() {

        JacksonJsonProvider provider = new JacksonJsonProvider();
        JsonParser parser = provider.createParser(new StringReader(json));

        assertEquals(Event.START_OBJECT, parser.next());
        assertEquals(Event.KEY_NAME, parser.next());
        assertEquals(Event.VALUE_STRING, parser.next());
        assertEquals("fooValue", parser.getString());

        assertTrue(parser.hasNext());

        try {
            assertEquals("fooValue", parser.getString());
            fail();
        } catch (IllegalStateException e) {
            // expected
        }
    }

    @Test
    public void testMultiSearchResponse() {
        String json = "{\n"
            + "  \"took\" : 1,\n"
            + "  \"responses\" : [\n"
            + "    {\n"
            + "      \"error\" : {\n"
            + "        \"root_cause\" : [\n"
            + "          {\n"
            + "            \"type\" : \"index_not_found_exception\",\n"
            + "            \"reason\" : \"no such index [foo_bar]\",\n"
            + "            \"resource.type\" : \"index_or_alias\",\n"
            + "            \"resource.id\" : \"foo_bar\",\n"
            + "            \"index_uuid\" : \"_na_\",\n"
            + "            \"index\" : \"foo_bar\"\n"
            + "          }\n"
            + "        ],\n"
            + "        \"type\" : \"index_not_found_exception\",\n"
            + "        \"reason\" : \"no such index [foo_bar]\",\n"
            + "        \"resource.type\" : \"index_or_alias\",\n"
            + "        \"resource.id\" : \"foo_bar\",\n"
            + "        \"index_uuid\" : \"_na_\",\n"
            + "        \"index\" : \"foo_bar\"\n"
            + "      },\n"
            + "      \"status\" : 404\n"
            + "    },\n"
            + "    {\n"
            + "      \"took\" : 1,\n"
            + "      \"timed_out\" : false,\n"
            + "      \"_shards\" : {\n"
            + "        \"total\" : 1,\n"
            + "        \"successful\" : 1,\n"
            + "        \"skipped\" : 0,\n"
            + "        \"failed\" : 0\n"
            + "      },\n"
            + "      \"hits\" : {\n"
            + "        \"total\" : {\n"
            + "          \"value\" : 5,\n"
            + "          \"relation\" : \"eq\"\n"
            + "        },\n"
            + "        \"max_score\" : 1.0,\n"
            + "        \"hits\" : [\n"
            + "          {\n"
            + "            \"_index\" : \"foo\",\n"
            + "            \"_id\" : \"Wr0ApoEBa_iiaABtVM57\",\n"
            + "            \"_score\" : 1.0,\n"
            + "            \"_source\" : {\n"
            + "              \"x\" : 1,\n"
            + "              \"y\" : true\n"
            + "            }\n"
            + "          }\n"
            + "        ]\n"
            + "      },\n"
            + "      \"status\" : 200\n"
            + "    }\n"
            + "  ]\n"
            + "}\n";

        JsonpMapper mapper = new AttributedJacksonJsonpMapper().withAttribute(
            "org.opensearch.client:Deserializer:_global.msearch.TDocument",
            JsonpDeserializer.of(Foo.class)
        );

        @SuppressWarnings("unchecked")
        MsearchResponse<Foo> response = fromJson(json, MsearchResponse.class, mapper);

        assertEquals(2, response.responses().size());
        assertEquals(404, response.responses().get(0).failure().status());
        assertEquals(200, response.responses().get(1).result().status());
    }

    public static class AttributedJacksonJsonpMapper extends JacksonJsonpMapper {
        private Map<String, Object> attributes;

        public AttributedJacksonJsonpMapper() {
            super();
        }

        public AttributedJacksonJsonpMapper(ObjectMapper objectMapper) {
            super(objectMapper);
        }

        @Nullable
        @Override
        @SuppressWarnings("unchecked")
        public <T> T attribute(String name) {
            return attributes == null ? null : (T) attributes.get(name);
        }

        /**
         * Updates attributes to a copy of the current ones with an additional key/value pair.
         * Mutates the current mapper, intended to be used in implementations of {@link #withAttribute(String, Object)}
         */
        protected JsonpMapperBase addAttribute(String name, Object value) {
            if (attributes == null) {
                this.attributes = Collections.singletonMap(name, value);
            } else {
                Map<String, Object> newAttrs = new HashMap<>(attributes.size() + 1);
                newAttrs.putAll(attributes);
                newAttrs.put(name, value);
                this.attributes = newAttrs;
            }
            return this;
        }

        @Override
        public <T> JsonpMapper withAttribute(String name, T value) {
            return new AttributedJacksonJsonpMapper(objectMapper()).addAttribute(name, value);
        }
    }

    public static class Foo {
        private int x;
        private boolean y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public boolean isY() {
            return y;
        }

        public void setY(boolean y) {
            this.y = y;
        }
    }

}
