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

package org.opensearch.client.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.opensearch.indices.AliasDefinition;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.ComponentTemplateSummary

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ComponentTemplateSummary
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ComponentTemplateSummary.Builder, ComponentTemplateSummary> {

    @Nonnull
    private final Map<String, AliasDefinition> aliases;

    @Nullable
    private final TypeMapping mappings;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nonnull
    private final Map<String, IndexSettings> settings;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    private ComponentTemplateSummary(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.mappings = builder.mappings;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.settings = ApiTypeHelper.unmodifiable(builder.settings);
        this.version = builder.version;
    }

    public static ComponentTemplateSummary of(Function<ComponentTemplateSummary.Builder, ObjectBuilder<ComponentTemplateSummary>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code aliases}
     */
    @Nonnull
    public final Map<String, AliasDefinition> aliases() {
        return this.aliases;
    }

    /**
     * API name: {@code mappings}
     */
    @Nullable
    public final TypeMapping mappings() {
        return this.mappings;
    }

    /**
     * API name: {@code _meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * API name: {@code settings}
     */
    @Nonnull
    public final Map<String, IndexSettings> settings() {
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
        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartObject();
            for (Map.Entry<String, AliasDefinition> item0 : this.aliases.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.mappings != null) {
            generator.writeKey("mappings");
            this.mappings.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("_meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.settings)) {
            generator.writeKey("settings");
            generator.writeStartObject();
            for (Map.Entry<String, IndexSettings> item0 : this.settings.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

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
     * Builder for {@link ComponentTemplateSummary}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ComponentTemplateSummary> {
        @Nullable
        private Map<String, AliasDefinition> aliases;
        @Nullable
        private TypeMapping mappings;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private Map<String, IndexSettings> settings;
        @Nullable
        private Long version;

        public Builder() {}

        private Builder(ComponentTemplateSummary o) {
            this.aliases = _mapCopy(o.aliases);
            this.mappings = o.mappings;
            this.meta = _mapCopy(o.meta);
            this.settings = _mapCopy(o.settings);
            this.version = o.version;
        }

        private Builder(Builder o) {
            this.aliases = _mapCopy(o.aliases);
            this.mappings = o.mappings;
            this.meta = _mapCopy(o.meta);
            this.settings = _mapCopy(o.settings);
            this.version = o.version;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code aliases}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(Map<String, AliasDefinition> map) {
            this.aliases = _mapPutAll(this.aliases, map);
            return this;
        }

        /**
         * API name: {@code aliases}
         *
         * <p>
         * Adds an entry to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, AliasDefinition value) {
            this.aliases = _mapPut(this.aliases, key, value);
            return this;
        }

        /**
         * API name: {@code aliases}
         *
         * <p>
         * Adds a value to <code>aliases</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String key, Function<AliasDefinition.Builder, ObjectBuilder<AliasDefinition>> fn) {
            return aliases(key, fn.apply(new AliasDefinition.Builder()).build());
        }

        /**
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(@Nullable TypeMapping value) {
            this.mappings = value;
            return this;
        }

        /**
         * API name: {@code mappings}
         */
        @Nonnull
        public final Builder mappings(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
            return mappings(fn.apply(new TypeMapping.Builder()).build());
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code _meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * API name: {@code settings}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(Map<String, IndexSettings> map) {
            this.settings = _mapPutAll(this.settings, map);
            return this;
        }

        /**
         * API name: {@code settings}
         *
         * <p>
         * Adds an entry to <code>settings</code>.
         * </p>
         */
        @Nonnull
        public final Builder settings(String key, IndexSettings value) {
            this.settings = _mapPut(this.settings, key, value);
            return this;
        }

        /**
         * API name: {@code settings}
         *
         * <p>
         * Adds a value to <code>settings</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder settings(String key, Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return settings(key, fn.apply(new IndexSettings.Builder()).build());
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
         * Builds a {@link ComponentTemplateSummary}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ComponentTemplateSummary build() {
            _checkSingleUse();

            return new ComponentTemplateSummary(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ComponentTemplateSummary}
     */
    public static final JsonpDeserializer<ComponentTemplateSummary> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ComponentTemplateSummary::setupComponentTemplateSummaryDeserializer
    );

    protected static void setupComponentTemplateSummaryDeserializer(ObjectDeserializer<ComponentTemplateSummary.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(AliasDefinition._DESERIALIZER), "aliases");
        op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "_meta");
        op.add(Builder::settings, JsonpDeserializer.stringMapDeserializer(IndexSettings._DESERIALIZER), "settings");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.mappings);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.settings);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ComponentTemplateSummary other = (ComponentTemplateSummary) o;
        return Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.mappings, other.mappings)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.settings, other.settings)
            && Objects.equals(this.version, other.version);
    }
}
