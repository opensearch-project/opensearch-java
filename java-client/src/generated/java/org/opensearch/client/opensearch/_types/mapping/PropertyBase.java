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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.mapping.PropertyBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class PropertyBase implements PlainJsonSerializable {

    @Nullable
    private final DynamicMapping dynamic;

    @Nonnull
    private final Map<String, Property> fields;

    @Nullable
    private final Integer ignoreAbove;

    @Nonnull
    private final Map<String, String> meta;

    @Nonnull
    private final Map<String, Property> properties;

    // ---------------------------------------------------------------------------------------------

    protected PropertyBase(AbstractBuilder<?> builder) {
        this.dynamic = builder.dynamic;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.ignoreAbove = builder.ignoreAbove;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.properties = ApiTypeHelper.unmodifiable(builder.properties);
    }

    /**
     * API name: {@code dynamic}
     */
    @Nullable
    public final DynamicMapping dynamic() {
        return this.dynamic;
    }

    /**
     * API name: {@code fields}
     */
    @Nonnull
    public final Map<String, Property> fields() {
        return this.fields;
    }

    /**
     * API name: {@code ignore_above}
     */
    @Nullable
    public final Integer ignoreAbove() {
        return this.ignoreAbove;
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
     * API name: {@code properties}
     */
    @Nonnull
    public final Map<String, Property> properties() {
        return this.properties;
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
        if (this.dynamic != null) {
            generator.writeKey("dynamic");
            this.dynamic.serialize(generator, mapper);
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

        if (this.ignoreAbove != null) {
            generator.writeKey("ignore_above");
            generator.write(this.ignoreAbove);
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

        if (ApiTypeHelper.isDefined(this.properties)) {
            generator.writeKey("properties");
            generator.writeStartObject();
            for (Map.Entry<String, Property> item0 : this.properties.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private DynamicMapping dynamic;
        @Nullable
        private Map<String, Property> fields;
        @Nullable
        private Integer ignoreAbove;
        @Nullable
        private Map<String, String> meta;
        @Nullable
        private Map<String, Property> properties;

        protected AbstractBuilder() {}

        protected AbstractBuilder(PropertyBase o) {
            this.dynamic = o.dynamic;
            this.fields = _mapCopy(o.fields);
            this.ignoreAbove = o.ignoreAbove;
            this.meta = _mapCopy(o.meta);
            this.properties = _mapCopy(o.properties);
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.dynamic = o.dynamic;
            this.fields = _mapCopy(o.fields);
            this.ignoreAbove = o.ignoreAbove;
            this.meta = _mapCopy(o.meta);
            this.properties = _mapCopy(o.properties);
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code dynamic}
         */
        @Nonnull
        public final BuilderT dynamic(@Nullable DynamicMapping value) {
            this.dynamic = value;
            return self();
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT fields(Map<String, Property> map) {
            this.fields = _mapPutAll(this.fields, map);
            return self();
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds an entry to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT fields(String key, Property value) {
            this.fields = _mapPut(this.fields, key, value);
            return self();
        }

        /**
         * API name: {@code fields}
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final BuilderT fields(String key, Function<Property.Builder, ObjectBuilder<Property>> fn) {
            return fields(key, fn.apply(new Property.Builder()).build());
        }

        /**
         * API name: {@code ignore_above}
         */
        @Nonnull
        public final BuilderT ignoreAbove(@Nullable Integer value) {
            this.ignoreAbove = value;
            return self();
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
        @Nonnull
        public final BuilderT meta(Map<String, String> map) {
            this.meta = _mapPutAll(this.meta, map);
            return self();
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
        @Nonnull
        public final BuilderT meta(String key, String value) {
            this.meta = _mapPut(this.meta, key, value);
            return self();
        }

        /**
         * API name: {@code properties}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT properties(Map<String, Property> map) {
            this.properties = _mapPutAll(this.properties, map);
            return self();
        }

        /**
         * API name: {@code properties}
         *
         * <p>
         * Adds an entry to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT properties(String key, Property value) {
            this.properties = _mapPut(this.properties, key, value);
            return self();
        }

        /**
         * API name: {@code properties}
         *
         * <p>
         * Adds a value to <code>properties</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final BuilderT properties(String key, Function<Property.Builder, ObjectBuilder<Property>> fn) {
            return properties(key, fn.apply(new Property.Builder()).build());
        }

    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupPropertyBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::dynamic, DynamicMapping._DESERIALIZER, "dynamic");
        op.add(AbstractBuilder::fields, JsonpDeserializer.stringMapDeserializer(Property._DESERIALIZER), "fields");
        op.add(AbstractBuilder::ignoreAbove, JsonpDeserializer.integerDeserializer(), "ignore_above");
        op.add(AbstractBuilder::meta, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "meta");
        op.add(AbstractBuilder::properties, JsonpDeserializer.stringMapDeserializer(Property._DESERIALIZER), "properties");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.dynamic);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.ignoreAbove);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.properties);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PropertyBase other = (PropertyBase) o;
        return Objects.equals(this.dynamic, other.dynamic)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.ignoreAbove, other.ignoreAbove)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.properties, other.properties);
    }
}
