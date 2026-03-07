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

package org.opensearch.client.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.json.spi.JsonProvider;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import org.opensearch.client.json.*;
import tools.jackson.core.JacksonException;
import tools.jackson.core.json.JsonFactory;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.util.EnumSet;

public class Jackson3JsonpMapper extends JsonpMapperBase {
    private final Jackson3JsonProvider provider;
    private final ObjectMapper objectMapper;

    public Jackson3JsonpMapper(ObjectMapper objectMapper) {
        // Creating the json factory from the mapper ensures it will be returned by JsonParser.getCodec()
        this(objectMapper, (JsonFactory) objectMapper.tokenStreamFactory());
    }

    public Jackson3JsonpMapper(ObjectMapper objectMapper, JsonFactory jsonFactory) {
        this.provider = new Jackson3JsonProvider(jsonFactory);
        this.objectMapper = objectMapper;
    }

    public Jackson3JsonpMapper() {
        this(
                JsonMapper.builder().configure(SerializationFeature.INDENT_OUTPUT, false)
                        .changeDefaultPropertyInclusion(incl -> incl.withValueInclusion(JsonInclude.Include.NON_NULL))
                        .changeDefaultPropertyInclusion(incl -> incl.withContentInclusion(JsonInclude.Include.NON_NULL))
                        .disable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)
                        .build()
        );
    }

    private Jackson3JsonpMapper(Jackson3JsonpMapper o) {
        super(o);
        this.provider = o.provider;
        this.objectMapper = o.objectMapper;
    }

    @Override
    public <T> JsonpMapper withAttribute(String name, T value) {
        return new Jackson3JsonpMapper(this).addAttribute(name, value);
    }

    /**
     * Returns the underlying Jackson mapper.
     */
    public ObjectMapper objectMapper() {
        return this.objectMapper;
    }

    @Override
    public JsonProvider jsonProvider() {
        return provider;
    }

    @Override
    protected <T> JsonpDeserializer<T> getDefaultDeserializer(Class<T> clazz) {
        return new JacksonValueParser<>(clazz);
    }

    @Override
    public <T> void serialize(T value, JsonGenerator generator) {

        if (!(generator instanceof Jackson3JsonpGenerator)) {
            throw new IllegalArgumentException("Jackson's ObjectMapper can only be used with the Jackson3JsonpProvider");
        }

        JsonpSerializer<T> serializer = findSerializer(value);
        if (serializer != null) {
            serializer.serialize(value, generator, this);
            return;
        }

        tools.jackson.core.JsonGenerator jkGenerator = ((Jackson3JsonpGenerator) generator).jacksonGenerator();
        try {
            objectMapper.writeValue(jkGenerator, value);
        } catch (JacksonException je) {
            throw Jackson3Utils.convertException(je);
        }
    }

    private class JacksonValueParser<T> extends JsonpDeserializerBase<T> {

        private final Class<T> clazz;

        protected JacksonValueParser(Class<T> clazz) {
            super(EnumSet.allOf(JsonParser.Event.class));
            this.clazz = clazz;
        }

        @Override
        public T deserialize(JsonParser parser, JsonpMapper mapper, JsonParser.Event event) {

            if (!(parser instanceof Jackson3JsonpParser)) {
                throw new IllegalArgumentException("Jackson's ObjectMapper can only be used with the JacksonJsonpProvider");
            }

            tools.jackson.core.JsonParser jkParser = ((Jackson3JsonpParser) parser).jacksonParser();

            try {
                return objectMapper.readValue(jkParser, clazz);
            } catch (JacksonException je) {
                throw Jackson3Utils.convertException(je);
            }
        }
    }
}