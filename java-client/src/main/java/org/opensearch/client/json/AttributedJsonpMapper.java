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

import jakarta.json.spi.JsonProvider;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;

@Deprecated
class AttributedJsonpMapper implements JsonpMapper {

    private final JsonpMapper mapper;
    private final String name;
    private final Object value;

    AttributedJsonpMapper(JsonpMapper mapper, String name, Object value) {
        this.mapper = mapper;
        this.name = name;
        this.value = value;
    }

    @Override
    public JsonProvider jsonProvider() {
        return mapper.jsonProvider();
    }

    @Override
    public <T> T deserialize(JsonParser parser, Class<T> clazz) {
        return mapper.deserialize(parser, clazz);
    }

    @Override
    public <T> void serialize(T value, JsonGenerator generator) {
        mapper.serialize(value, generator);
    }

    @Override
    public boolean ignoreUnknownFields() {
        return mapper.ignoreUnknownFields();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T attribute(String name) {
        if (this.name.equals(name)) {
            return (T) this.value;
        } else {
            return mapper.attribute(name);
        }
    }
}
