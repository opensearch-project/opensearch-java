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

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.mapping.FieldMapping

@JsonpDeserializable
public class FieldMapping implements PlainJsonSerializable {
    private final String fullName;

    private final Map<String, Property> mapping;

    // ---------------------------------------------------------------------------------------------

    private FieldMapping(Builder builder) {

        this.fullName = ApiTypeHelper.requireNonNull(builder.fullName, this, "fullName");
        this.mapping = ApiTypeHelper.unmodifiableRequired(builder.mapping, this, "mapping");

    }

    public static FieldMapping of(Function<Builder, ObjectBuilder<FieldMapping>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code full_name}
     */
    public final String fullName() {
        return this.fullName;
    }

    /**
     * Required - API name: {@code mapping}
     */
    public final Map<String, Property> mapping() {
        return this.mapping;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("full_name");
        generator.write(this.fullName);

        if (ApiTypeHelper.isDefined(this.mapping)) {
            generator.writeKey("mapping");
            generator.writeStartObject();
            for (Map.Entry<String, Property> item0 : this.mapping.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);

            }
            generator.writeEnd();

        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link FieldMapping}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<FieldMapping> {

        private String fullName;

        private Map<String, Property> mapping;

        /**
         * Required - API name: {@code full_name}
         */
        public final Builder fullName(String value) {
            this.fullName = value;
            return this;
        }

        /**
         * Required - API name: {@code mapping}
         * <p>
         * Adds all entries of <code>map</code> to <code>mapping</code>.
         */
        public final Builder mapping(Map<String, Property> map) {
            this.mapping = _mapPutAll(this.mapping, map);
            return this;
        }

        /**
         * Required - API name: {@code mapping}
         * <p>
         * Adds an entry to <code>mapping</code>.
         */
        public final Builder mapping(String key, Property value) {
            this.mapping = _mapPut(this.mapping, key, value);
            return this;
        }

        /**
         * Required - API name: {@code mapping}
         * <p>
         * Adds an entry to <code>mapping</code> using a builder lambda.
         */
        public final Builder mapping(String key, Function<Property.Builder, ObjectBuilder<Property>> fn) {
            return mapping(key, fn.apply(new Property.Builder()).build());
        }

        /**
         * Builds a {@link FieldMapping}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public FieldMapping build() {
            _checkSingleUse();

            return new FieldMapping(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FieldMapping}
     */
    public static final JsonpDeserializer<FieldMapping> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FieldMapping::setupFieldMappingDeserializer
    );

    protected static void setupFieldMappingDeserializer(ObjectDeserializer<FieldMapping.Builder> op) {

        op.add(Builder::fullName, JsonpDeserializer.stringDeserializer(), "full_name");
        op.add(Builder::mapping, JsonpDeserializer.stringMapDeserializer(Property._DESERIALIZER), "mapping");

    }

}
