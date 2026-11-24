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

import jakarta.json.spi.JsonProvider;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;

/**
 * Base class for tests that encode/decode json.
 * Every test is run once per JsonpMapper implementation.
 */
@RunWith(Parameterized.class)
public abstract class ModelTestCase extends Assert {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> mappers() {
        JsonpMapper jsonb = new JsonbJsonpMapper() {
            @Override
            public boolean ignoreUnknownFields() {
                return false;
            }
        };
        JsonpMapper jackson = new JacksonJsonpMapper() {
            @Override
            public boolean ignoreUnknownFields() {
                return false;
            }
        };
        return Arrays.asList(new Object[] { "json-b", jsonb }, new Object[] { "jackson", jackson });
    }

    @Parameterized.Parameter(0)
    public String mapperName;

    @Parameterized.Parameter(1)
    public JsonpMapper mapper;

    protected <T> String toJson(T value) {
        return toJson(value, mapper);
    }

    public static <T> String toJson(T value, JsonpMapper mapper) {
        StringWriter sw = new StringWriter();
        JsonProvider provider = mapper.jsonProvider();
        JsonGenerator generator = provider.createGenerator(sw);
        mapper.serialize(value, generator);
        generator.close();
        return sw.toString();
    }

    public static <T> T fromJson(String json, Class<T> clazz, JsonpMapper mapper) {
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        return mapper.deserialize(parser, clazz);
    }

    protected <T> T fromJson(String json, Class<T> clazz) {
        return fromJson(json, clazz, mapper);
    }

    @SuppressWarnings("unchecked")
    protected <T> T checkJsonRoundtrip(T value, String expectedJson) {
        assertEquals(expectedJson, toJson(value));
        return fromJson(expectedJson, (Class<T>) value.getClass());
    }

    protected <T> T fromJson(String json, JsonpDeserializer<T> deserializer) {
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        return deserializer.deserialize(parser, mapper);
    }

    public static void assertGetterType(Class<?> expected, Class<?> clazz, String name) {
        Method method;
        try {
            method = clazz.getMethod(name);
        } catch (NoSuchMethodException e) {
            Assert.fail("Getter '" + clazz.getName() + "." + name + "' doesn't exist");
            return;
        }

        Assert.assertSame(expected, method.getReturnType());
    }
}
