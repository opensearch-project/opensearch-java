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

package org.opensearch.client.json;

import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class JsonpMapperBase implements JsonpMapper {
    @Nullable
    private Map<String, Object> attributes;

    protected JsonpMapperBase() {}

    protected JsonpMapperBase(JsonpMapperBase o) {
        this.attributes = o.attributes; // We always copy in `setAttribute` so no need to copy here.
    }

    @Override
    public <T> T attribute(String name) {
        // noinspection unchecked
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
            // Copy the map to avoid modifying the original in case it was shared.
            // We're generally only ever called from implementations' `withAttribute` methods which are intended
            // to construct new instances rather than modify existing ones.
            Map<String, Object> attributes = new HashMap<>(this.attributes.size() + 1);
            attributes.putAll(this.attributes);
            attributes.put(name, value);
            this.attributes = attributes;
        }
        return this;
    }

    /** Get a serializer when none of the builtin ones are applicable */
    protected abstract <T> JsonpDeserializer<T> getDefaultDeserializer(Class<T> clazz);

    @Override
    public <T> T deserialize(JsonParser parser, Class<T> clazz) {
        JsonpDeserializer<T> deserializer = findDeserializer(clazz);
        if (deserializer != null) {
            return deserializer.deserialize(parser, this);
        }

        return getDefaultDeserializer(clazz).deserialize(parser, this);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> JsonpDeserializer<T> findDeserializer(Class<T> clazz) {
        JsonpDeserializable annotation = clazz.getAnnotation(JsonpDeserializable.class);
        if (annotation != null) {
            try {
                Field field = clazz.getDeclaredField(annotation.field());
                return (JsonpDeserializer<T>) field.get(null);
            } catch (Exception e) {
                throw new RuntimeException("No deserializer found in '" + clazz.getName() + "." + annotation.field() + "'");
            }
        }

        return null;
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> JsonpSerializer<T> findSerializer(T value) {
        Class<?> valueClass = value.getClass();
        if (JsonpSerializable.class.isAssignableFrom(valueClass)) {
            return (JsonpSerializer<T>) JsonpSerializableSerializer.INSTANCE;
        }

        if (JsonValue.class.isAssignableFrom(valueClass)) {
            return (JsonpSerializer<T>) JsonpValueSerializer.INSTANCE;
        }

        return null;
    }

    protected static class JsonpSerializableSerializer<T extends JsonpSerializable> implements JsonpSerializer<T> {
        @Override
        public void serialize(T value, JsonGenerator generator, JsonpMapper mapper) {
            value.serialize(generator, mapper);
        }

        protected static final JsonpSerializer<?> INSTANCE = new JsonpSerializableSerializer<>();

    }

    protected static class JsonpValueSerializer implements JsonpSerializer<JsonValue> {
        @Override
        public void serialize(JsonValue value, JsonGenerator generator, JsonpMapper mapper) {
            generator.write(value);
        }

        protected static final JsonpSerializer<?> INSTANCE = new JsonpValueSerializer();

    }

}
