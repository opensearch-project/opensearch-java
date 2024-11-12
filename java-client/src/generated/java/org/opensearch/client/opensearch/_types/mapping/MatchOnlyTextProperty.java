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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.mapping.MatchOnlyTextProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MatchOnlyTextProperty implements PropertyVariant, PlainJsonSerializable {

    @Nonnull
    private final List<String> copyTo;

    @Nonnull
    private final Map<String, Property> fields;

    @Nonnull
    private final Map<String, String> meta;

    // ---------------------------------------------------------------------------------------------

    private MatchOnlyTextProperty(Builder builder) {
        this.copyTo = ApiTypeHelper.unmodifiable(builder.copyTo);
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
    }

    public static MatchOnlyTextProperty of(Function<MatchOnlyTextProperty.Builder, ObjectBuilder<MatchOnlyTextProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.MatchOnlyText;
    }

    /**
     * API name: {@code copy_to}
     */
    @Nonnull
    public final List<String> copyTo() {
        return this.copyTo;
    }

    /**
     * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and a
     * multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final Map<String, Property> fields() {
        return this.fields;
    }

    /**
     * Metadata about the field.
     * <p>
     * API name: {@code meta}
     * </p>
     */
    @Nonnull
    public final Map<String, String> meta() {
        return this.meta;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "match_only_text");
        if (ApiTypeHelper.isDefined(this.copyTo)) {
            generator.writeKey("copy_to");
            generator.writeStartArray();
            for (String item0 : this.copyTo) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartObject();
            for (Map.Entry<String, Property> item0 : this.fields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link MatchOnlyTextProperty}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MatchOnlyTextProperty> {
        @Nullable
        private List<String> copyTo;
        @Nullable
        private Map<String, Property> fields;
        @Nullable
        private Map<String, String> meta;

        /**
         * API name: {@code copy_to}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>copyTo</code>.
         * </p>
         */
        public final Builder copyTo(List<String> list) {
            this.copyTo = _listAddAll(this.copyTo, list);
            return this;
        }

        /**
         * API name: {@code copy_to}
         *
         * <p>
         * Adds one or more values to <code>copyTo</code>.
         * </p>
         */
        public final Builder copyTo(String value, String... values) {
            this.copyTo = _listAdd(this.copyTo, value, values);
            return this;
        }

        /**
         * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and
         * a multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        public final Builder fields(Map<String, Property> map) {
            this.fields = _mapPutAll(this.fields, map);
            return this;
        }

        /**
         * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and
         * a multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        public final Builder fields(String key, Property value) {
            this.fields = _mapPut(this.fields, key, value);
            return this;
        }

        /**
         * Multi-fields allow the same string value to be indexed in multiple ways for different purposes, such as one field for search and
         * a multi-field for sorting and aggregations, or the same string value analyzed by different analyzers.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        public final Builder fields(String key, Function<Property.Builder, ObjectBuilder<Property>> fn) {
            return fields(key, fn.apply(new Property.Builder()).build());
        }

        /**
         * Metadata about the field.
         * <p>
         * API name: {@code meta}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        public final Builder meta(Map<String, String> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * Metadata about the field.
         * <p>
         * API name: {@code meta}
         * </p>
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        public final Builder meta(String key, String value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * Builds a {@link MatchOnlyTextProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public MatchOnlyTextProperty build() {
            _checkSingleUse();

            return new MatchOnlyTextProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MatchOnlyTextProperty}
     */
    public static final JsonpDeserializer<MatchOnlyTextProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MatchOnlyTextProperty::setupMatchOnlyTextPropertyDeserializer
    );

    protected static void setupMatchOnlyTextPropertyDeserializer(ObjectDeserializer<MatchOnlyTextProperty.Builder> op) {
        op.add(Builder::copyTo, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "copy_to");
        op.add(Builder::fields, JsonpDeserializer.stringMapDeserializer(Property._DESERIALIZER), "fields");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "meta");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.copyTo);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.meta);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MatchOnlyTextProperty other = (MatchOnlyTextProperty) o;
        return Objects.equals(this.copyTo, other.copyTo)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.meta, other.meta);
    }
}
