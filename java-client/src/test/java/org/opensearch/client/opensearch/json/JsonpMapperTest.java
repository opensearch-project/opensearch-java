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

import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsonp.JSONPModule;

import jakarta.json.Json;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.core.internal.io.IOUtils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class JsonpMapperTest extends Assert {

    @Test
    public void testJsonb() {
        String json = "{\"children\":[{\"doubleValue\":3.2,\"intValue\":2}],\"doubleValue\":2.1," +
                "\"instantValue\":\"1970-01-01T00:00:00Z\",\"intValue\":1,\"stringValue\":\"foo\"}";

        JsonpMapper mapper = new JsonbJsonpMapper();
        testSerialize(mapper, json);
        testDeserialize(mapper, json);
    }

    @Test
    public void testJackson() {
        String json = "{\"children\":[{\"doubleValue\":3.2,\"intValue\":2}],\"doubleValue\":2.1,\"intValue\":1," +
                "\"stringValue\":\"foo\",\"instantValue\":0.0}";

        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        testSerialize(mapper, json);
        testDeserialize(mapper, json);
    }

    @Test
    public void testJacksonCustomMapper() {
        ObjectMapper jkMapper = new ObjectMapper();
        jkMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        jkMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JacksonJsonpMapper mapper = new JacksonJsonpMapper(jkMapper);

        String json = "{\"children\":[{\"double_value\":3.2,\"int_value\":2}],\"double_value\":2.1,\"int_value\":1," +
            "\"string_value\":\"foo\",\"instant_value\":0.0}";

        testSerialize(mapper, json);
        testDeserialize(mapper, json);
    }

    @Test
    public void testJacksonCustomJsonFactory() {
        final ObjectMapper jkMapper = new ObjectMapper().registerModule(new JSONPModule());
        final JsonFactory jsonFactory = new MappingJsonFactory(jkMapper);
        final JacksonJsonpMapper mapper = new JacksonJsonpMapper(jkMapper, jsonFactory);

        final JsonValue json = Json.createObjectBuilder()
            .add("children", Json
                .createArrayBuilder()
                .add(Json.createObjectBuilder()
                    .add("doubleValue", 3.2)
                    .add("intValue", 2)))
            .add("doubleValue", "2.1")
            .add("intValue", 1)
            .add("stringValue", "foo")
            .add("instantValue", "1970-01-01T00:00:00Z")
            .build();

        final Writer writer = new StringWriter();
        try (JsonGenerator generator = mapper.jsonProvider().createGenerator(writer)){
            generator.write(json);
        }

        testDeserialize(mapper, writer.toString());
        IOUtils.closeWhileHandlingException(writer);
    }

    @Test
    public void testConcurrentLazyResolve() throws Exception {
        // Test fix for issue 172 - concurrency error in LazyDeserializer
        // This latch holds off resolution of the LazyDeserializer until we're sure that
        // two threads are attempting it simultaneously
        CountDownLatch trigger = new CountDownLatch(1);
        JsonpDeserializer<Integer> deserializer = JsonpDeserializer.lazy(() -> {
            try {
                trigger.await();
            } catch (Exception e) {
                throw new RuntimeException("Interrupted", e);
            }
            return JsonpDeserializer.integerDeserializer();
        });

        // Two threads will attempt to deserialize.  They should both be successful
        final AtomicInteger successes = new AtomicInteger(0);
        final JsonpMapper mapper = new JsonbJsonpMapper();
        Runnable threadProc = () -> {
            JsonParser parser = mapper.jsonProvider().createParser(new StringReader("0"));
            try {
                // Prior to fix, one of these would throw NPE because its
                // LazyDeserializer resolution would return null
                deserializer.deserialize(parser,mapper);
                successes.incrementAndGet();
            } catch (Throwable e) {
                // We'll notice that we failed to increment successes
            }
        };
        // Two identical threads
        Thread thread1 = new Thread(threadProc);
        thread1.setDaemon(true);
        thread1.start();
        Thread thread2 = new Thread(threadProc);
        thread2.setDaemon(true);
        thread2.start();

        // Wait until both threads are blocked waiting LazyDeserializer resolution
        do {
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                break;
            }
        } while (thread1.getState() == Thread.State.RUNNABLE || thread2.getState() == Thread.State.RUNNABLE);

        // Now allow resolution to proceed and wait for results
        trigger.countDown();
        thread1.join();
        thread2.join();
        assertEquals(2, successes.get());
    }


    private void testSerialize(JsonpMapper mapper, String expected) {

        SomeClass something = new SomeClass();
        something.setIntValue(1);
        something.setDoubleValue(2.1);
        something.setStringValue("foo");
        something.setInstantValue(Instant.EPOCH);

        SomeClass other = new SomeClass();
        other.setIntValue(2);
        other.setDoubleValue(3.2);
        something.setChildren(Collections.singletonList(other));

        StringWriter strw = new StringWriter();
        JsonGenerator generator = mapper.jsonProvider().createGenerator(strw);

        mapper.serialize(something, generator);

        generator.close();

        assertEquals(expected, strw.getBuffer().toString());
    }

    private void testDeserialize(JsonpMapper mapper, String json) {

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        SomeClass parsed = mapper.deserialize(parser, SomeClass.class);

        assertEquals(1, parsed.getIntValue());
        assertEquals(2.1, parsed.getDoubleValue(), 0.0);
        assertEquals("foo", parsed.getStringValue());
        assertEquals(Instant.EPOCH, parsed.getInstantValue());

        List<SomeClass> children = parsed.getChildren();
        assertEquals(1, children.size());

        SomeClass child = children.get(0);

        assertEquals(2, child.getIntValue());
        assertEquals(3.2, child.getDoubleValue(), 0.0);
        assertNull(child.getStringValue());
        assertNull(child.getChildren());
    }

    public static class SomeClass {
        private List<SomeClass> children;
        private double doubleValue;
        private int intValue;
        private String stringValue;
        private Instant instantValue;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public String getStringValue() {
            return stringValue;
        }

        public void setStringValue(String stringValue) {
            this.stringValue = stringValue;
        }

        public double getDoubleValue() {
            return doubleValue;
        }

        public void setInstantValue(Instant instantValue) {
            this.instantValue = instantValue;
        }

        public Instant getInstantValue() {
            return instantValue;
        }

        public void setDoubleValue(double doubleValue) {
            this.doubleValue = doubleValue;
        }

        public List<SomeClass> getChildren() {
            return children;
        }

        public void setChildren(List<SomeClass> children) {
            this.children = children;
        }
    }
}
