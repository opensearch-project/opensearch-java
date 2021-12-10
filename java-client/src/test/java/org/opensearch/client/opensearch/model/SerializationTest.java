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

package org.opensearch.client.opensearch.model;

import org.opensearch.client.opensearch.cat.NodesResponse;
import org.opensearch.client.opensearch.core.GetSourceResponse;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapperBase;
import org.opensearch.client.json.JsonpUtils;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import jakarta.json.Json;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParsingException;
import org.junit.Test;

import java.io.StringReader;

public class SerializationTest extends ModelTestCase {

    @Test
    public void loadAllDeserializers() throws Exception {

        ScanResult scan = new ClassGraph()
            .acceptPackages("org.opensearch.client")
            .enableAnnotationInfo()
            .enableFieldInfo()
            .scan();

        ClassInfoList withAnnotation = scan.getClassesWithAnnotation(JsonpDeserializable.class.getName());

        assertFalse("No JsonpDeserializable classes", withAnnotation.isEmpty());

        for (ClassInfo info: withAnnotation) {
            Class<?> clazz = Class.forName(info.getName());
            JsonpDeserializer<?> deserializer = JsonpMapperBase.findDeserializer(clazz);
            assertNotNull(deserializer);

            // Deserialize something dummy to resolve lazy deserializers
            JsonParser parser = mapper.jsonProvider().createParser(new StringReader("-"));
            assertThrows(JsonParsingException.class, () -> deserializer.deserialize(parser, mapper));
        }

        // Check that all classes that have a _DESERIALIZER field also have the annotation
        ClassInfoList withDeserializer = scan.getAllClasses().filter((c) -> c.hasDeclaredField("_DESERIALIZER"));
        assertFalse("No classes with a _DESERIALIZER field", withDeserializer.isEmpty());

// Disabled for now, empty response classes still need a deserializer object
// e.g. ExistsIndexTemplateResponse, PingResponse, ExistsResponse, ExistsAliasResponse
//
//        Set<String> annotationNames = withAnnotation.stream().map(c -> c.getName()).collect(Collectors.toSet());
//        Set<String> withFieldNames = withDeserializer.stream().map(c -> c.getName()).collect(Collectors.toSet());
//
//        withFieldNames.removeAll(annotationNames);
//
//        assertFalse("Some classes with the field but not the annotation: " + withFieldNames, !withFieldNames.isEmpty());

    }

    @Test
    public void testArrayValueBody() {

        NodesResponse nr = NodesResponse.of(_0 -> _0
            .valueBody(_1 -> _1.bulkTotalOperations("1"))
            .valueBody(_1 -> _1.bulkTotalOperations("2"))
        );

        checkJsonRoundtrip(nr, "[{\"bulk.total_operations\":\"1\"},{\"bulk.total_operations\":\"2\"}]");

        assertEquals(2, nr.valueBody().size());
        assertEquals("1", nr.valueBody().get(0).bulkTotalOperations());
        assertEquals("2", nr.valueBody().get(1).bulkTotalOperations());
    }

    @Test
    public void testGenericValueBody() {

        GetSourceResponse<String> r = GetSourceResponse.of(_0 -> _0
            .valueBody("The value")
        );

        String json = toJson(r);
        assertEquals("\"The value\"", json);

        JsonpDeserializer<GetSourceResponse<String>> deserializer =
            GetSourceResponse.createGetSourceResponseDeserializer(JsonpDeserializer.stringDeserializer());

        r = deserializer.deserialize(mapper.jsonProvider().createParser(new StringReader(json)), mapper);

        assertEquals("The value", r.valueBody());

    }

    @Test
    public void testJsonpValuesToString() {

        assertEquals("foo", JsonpUtils.toString(Json.createValue("foo")));
        assertEquals("42", JsonpUtils.toString(Json.createValue(42)));
        assertEquals("42.1337", JsonpUtils.toString(Json.createValue(42.1337)));
        assertEquals("true", JsonpUtils.toString(JsonValue.TRUE));
        assertEquals("false", JsonpUtils.toString(JsonValue.FALSE));
        assertEquals("null", JsonpUtils.toString(JsonValue.NULL));
        assertEquals("a,b,c", JsonpUtils.toString(Json.createArrayBuilder().add("a").add("b").add("c").build()));

        assertThrows(IllegalArgumentException.class, () -> {
            JsonpUtils.toString(Json.createObjectBuilder().build());
        });
    }
}
