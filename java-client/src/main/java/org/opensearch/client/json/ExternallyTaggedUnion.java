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

import static jakarta.json.stream.JsonParser.Event;

import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParsingException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.util.TaggedUnion;

/**
 * Utilities for union types whose discriminant is not directly part of the structure, either as an enclosing property name or as
 * an inner property. This is used for OpenSearch aggregation results and suggesters, using the {@code typed_keys} parameter that
 * encodes a name+type in a single JSON property.
 *
 */
public class ExternallyTaggedUnion {

    private ExternallyTaggedUnion() {}

    /**
     * A deserializer for externally-tagged unions. Since the union variant discriminant is provided externally, this cannot be a
     * regular {@link JsonpDeserializer} as the caller has to provide the discriminant value.
     */
    public static class Deserializer<Union extends TaggedUnion<?, ?>, Member> {
        private final Map<String, JsonpDeserializer<? extends Member>> deserializers;
        private final Function<Member, Union> unionCtor;
        @Nullable
        private final BiFunction<String, JsonData, Union> unKnownUnionCtor;

        public Deserializer(Map<String, JsonpDeserializer<? extends Member>> deserializers, Function<Member, Union> unionCtor) {
            this.deserializers = deserializers;
            this.unionCtor = unionCtor;
            this.unKnownUnionCtor = null;
        }

        public Deserializer(
            Map<String, JsonpDeserializer<? extends Member>> deserializers,
            Function<Member, Union> unionCtor,
            BiFunction<String, JsonData, Union> unKnownUnionCtor
        ) {
            this.deserializers = deserializers;
            this.unionCtor = unionCtor;
            this.unKnownUnionCtor = unKnownUnionCtor;
        }

        public Union deserialize(String type, JsonParser parser, JsonpMapper mapper, Event event) {
            JsonpDeserializer<? extends Member> deserializer = deserializers.get(type);
            if (deserializer == null) {
                if (unKnownUnionCtor != null) {
                    return unKnownUnionCtor.apply(type, JsonData._DESERIALIZER.deserialize(parser, mapper, event));
                }
            }

            return unionCtor.apply(deserializer.deserialize(parser, mapper, event));
        }

        /**
         * Deserialize an externally tagged union encoded as typed keys, a JSON dictionary whose property names combine type and name
         * in a single string.
         */
        public TypedKeysDeserializer<Union> typedKeys() {
            return new TypedKeysDeserializer<>(this);
        }
    }

    public static class TypedKeysDeserializer<Union extends TaggedUnion<?, ?>> extends JsonpDeserializerBase<Map<String, Union>> {
        Deserializer<Union, ?> deserializer;

        protected TypedKeysDeserializer(Deserializer<Union, ?> deser) {
            super(EnumSet.of(Event.START_OBJECT));
            this.deserializer = deser;
        }

        @Override
        public Map<String, Union> deserialize(JsonParser parser, JsonpMapper mapper, Event event) {
            Map<String, Union> result = new HashMap<>();
            while ((event = parser.next()) != Event.END_OBJECT) {
                JsonpUtils.expectEvent(parser, event, Event.KEY_NAME);
                deserializeEntry(parser.getString(), parser, mapper, result);
            }
            return result;
        }

        public void deserializeEntry(String key, JsonParser parser, JsonpMapper mapper, Map<String, Union> targetMap) {
            int hashPos = key.indexOf('#');
            if (hashPos == -1) {
                throw new JsonParsingException(
                    "Property name '" + key + "' is not in the 'type#name' format. Make sure the request has 'typed_keys' set.",
                    parser.getLocation()
                );
            }

            String type = key.substring(0, hashPos);
            String name = key.substring(hashPos + 1);

            targetMap.put(name, deserializer.deserialize(type, parser, mapper, parser.next()));
        }
    }

    public static <T extends TaggedUnion<?, ?>> JsonpDeserializer<Map<String, List<T>>> arrayDeserializer(
        TypedKeysDeserializer<T> deserializer
    ) {
        return JsonpDeserializer.of(EnumSet.of(Event.START_OBJECT), (parser, mapper, event) -> {
            Map<String, List<T>> result = new HashMap<>();
            String key = null;
            while ((event = parser.next()) != Event.END_OBJECT) {
                JsonpUtils.expectEvent(parser, event, Event.KEY_NAME);
                // Split key and type
                key = parser.getString();
                int hashPos = key.indexOf('#');

                String type = key.substring(0, hashPos);
                String name = key.substring(hashPos + 1);

                List<T> list = new ArrayList<>();
                JsonpUtils.expectNextEvent(parser, Event.START_ARRAY);
                try {
                    while ((event = parser.next()) != Event.END_ARRAY) {
                        list.add(deserializer.deserializer.deserialize(type, parser, mapper, event));
                    }
                } catch (Exception e) {
                    throw e;
                }
                result.put(name, list);
            }
            return result;
        });
    }

    /**
     * Serialize an externally tagged union using the typed keys encoding.
     */
    public static <T extends JsonpSerializable & TaggedUnion<? extends JsonEnum, ?>> void serializeTypedKeys(
        Map<String, T> map,
        JsonGenerator generator,
        JsonpMapper mapper
    ) {
        generator.writeStartObject();
        serializeTypedKeysInner(map, generator, mapper);
        generator.writeEnd();
    }

    /**
     * Serialize an externally tagged union using the typed keys encoding, without the enclosing start/end object.
     */
    public static <T extends JsonpSerializable & TaggedUnion<? extends JsonEnum, ?>> void serializeTypedKeysInner(
        Map<String, T> map,
        JsonGenerator generator,
        JsonpMapper mapper
    ) {
        if (mapper.attribute(JsonpMapperAttributes.SERIALIZE_TYPED_KEYS, true)) {
            for (Map.Entry<String, T> entry : map.entrySet()) {
                T value = entry.getValue();
                generator.writeKey(value._kind().jsonValue() + "#" + entry.getKey());
                value.serialize(generator, mapper);
            }
        } else {
            for (Map.Entry<String, T> entry : map.entrySet()) {
                generator.writeKey(entry.getKey());
                entry.getValue().serialize(generator, mapper);
            }
        }
    }
}
