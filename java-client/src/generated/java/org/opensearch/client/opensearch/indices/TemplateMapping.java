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

package org.opensearch.client.opensearch.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.TemplateMapping

/**
 * The mapping configuration for a template.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TemplateMapping implements PlainJsonSerializable, ToCopyableBuilder<TemplateMapping.Builder, TemplateMapping> {

    @Nonnull
    private final Map<String, Alias> aliases;

    @Nonnull
    private final List<String> indexPatterns;

    @Nonnull
    private final TypeMapping mappings;

    private final int order;

    @Nonnull
    private final Map<String, JsonData> settings;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private TemplateMapping(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiableRequired(builder.aliases, this, "aliases");
        this.indexPatterns = ApiTypeHelper.unmodifiableRequired(builder.indexPatterns, this, "indexPatterns");
        this.mappings = ApiTypeHelper.requireNonNull(builder.mappings, this, "mappings");
        this.order = ApiTypeHelper.requireNonNull(builder.order, this, "order");
        this.settings = ApiTypeHelper.unmodifiableRequired(builder.settings, this, "settings");
        this.version = builder.version;
    }

    public static TemplateMapping of(Function<TemplateMapping.Builder, ObjectBuilder<TemplateMapping>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code aliases}
     */
    @Nonnull
    public final Map<String, Alias> aliases() {
        return this.aliases;
    }

    /**
     * Required - API name: {@code index_patterns}
     */
    @Nonnull
    public final List<String> indexPatterns() {
        return this.indexPatterns;
    }

    /**
     * Required - API name: {@code mappings}
     */
    @Nonnull
    public final TypeMapping mappings() {
        return this.mappings;
    }

    /**
     * Required - The order in which the template should be applied.
     * <p>
     * API name: {@code order}
     * </p>
     */
    public final int order() {
        return this.order;
    }

    /**
     * Required - The index settings to apply.
     * <p>
     * API name: {@code settings}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> settings() {
        return this.settings;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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
        generator.writeKey("aliases");
        generator.writeStartObject();
        for (Map.Entry<String, Alias> item0 : this.aliases.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("index_patterns");
        generator.writeStartArray();
        for (String item0 : this.indexPatterns) {
            generator.write(item0);
        }
        generator.writeEnd();

        generator.writeKey("mappings");
        this.mappings.serialize(generator, mapper);

        generator.writeKey("order");
        generator.write(this.order);

        generator.writeKey("settings");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.settings.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link TemplateMapping}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TemplateMapping> {
        private Map<String, Alias> aliases;
        private List<String> indexPatterns;
        private TypeMapping mappings;
        private Integer order;
        private Map<String, JsonData> settings;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(TemplateMapping o) {
            this.aliases = _mapCopy(o.aliases);
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.mappings = o.mappings;
            this.order = o.order;
            this.settings = _mapCopy(o.settings);
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.aliases = _mapCopy(o.aliases);
            this.indexPatterns = _listCopy(o.indexPatterns);
            this.mappings = o.mappings;
            this.order = o.order;
            this.settings = _mapCopy(o.settings);
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code aliases}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(Map<String, Alias> map) {
            this.aliases = _mapPutAll(this.aliases, map);
            return this;
        }

        /**
         * Required - API name: {@code aliases}
         *
         * <p>
         * Adds an entry to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, Alias value) {
            this.aliases = _mapPut(this.aliases, key, value);
            return this;
        }

        /**
         * Required - API name: {@code aliases}
         *
         * <p>
         * Adds a value to <code>aliases</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
            return aliases(key, fn.apply(new Alias.Builder()).build());
        }

        /**
         * Required - API name: {@code index_patterns}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(List<String> list) {
            this.indexPatterns = _listAddAll(this.indexPatterns, list);
            return this;
        }

        /**
         * Required - API name: {@code index_patterns}
         *
         * <p>
         * Adds one or more values to <code>indexPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexPatterns(String value, String... values) {
            this.indexPatterns = _listAdd(this.indexPatterns, value, values);
            return this;
        }

        /**
         * Required - API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(TypeMapping value) {
            this.mappings = value;
            return this;
        }

        /**
         * Required - API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
            return mappings(fn.apply(new TypeMapping.Builder()).build());
        }

        /**
         * Required - The order in which the template should be applied.
         * <p>
         * API name: {@code order}
         * </p>
         */
        @Nonnull
        public final Builder order(int value) {
            this.order = value;
            return this;
        }

        /**
         * Required - The index settings to apply.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(Map<String, JsonData> map) {
            this.settings = _mapPutAll(this.settings, map);
            return this;
        }

        /**
         * Required - The index settings to apply.
         * <p>
         * API name: {@code settings}
         * </p>
         *
         * <p>
         * Adds an entry to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(String key, JsonData value) {
            this.settings = _mapPut(this.settings, key, value);
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link TemplateMapping}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TemplateMapping build() {
            _checkSingleUse();

            return new TemplateMapping(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TemplateMapping}
     */
    public static final JsonpDeserializer<TemplateMapping> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TemplateMapping::setupTemplateMappingDeserializer
    );

    protected static void setupTemplateMappingDeserializer(ObjectDeserializer<TemplateMapping.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(Alias._DESERIALIZER), "aliases");
        op.add(Builder::indexPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index_patterns");
        op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
        op.add(Builder::order, JsonpDeserializer.integerDeserializer(), "order");
        op.add(Builder::settings, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "settings");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.aliases.hashCode();
        result = 31 * result + this.indexPatterns.hashCode();
        result = 31 * result + this.mappings.hashCode();
        result = 31 * result + Integer.hashCode(this.order);
        result = 31 * result + this.settings.hashCode();
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TemplateMapping other = (TemplateMapping) o;
        return this.aliases.equals(other.aliases)
            && this.indexPatterns.equals(other.indexPatterns)
            && this.mappings.equals(other.mappings)
            && this.order == other.order
            && this.settings.equals(other.settings)
            && Objects.equals(this.version, other.version);
    }
}
