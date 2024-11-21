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
import org.opensearch.client.opensearch._types.mapping.TypeMapping;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexState

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexState implements PlainJsonSerializable, ToCopyableBuilder<IndexState.Builder, IndexState> {

    @Nonnull
    private final Map<String, Alias> aliases;

    @Nullable
    private final String dataStream;

    @Nullable
    private final IndexSettings defaults;

    @Nullable
    private final TypeMapping mappings;

    @Nullable
    private final IndexSettings settings;

    // ---------------------------------------------------------------------------------------------

    private IndexState(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.dataStream = builder.dataStream;
        this.defaults = builder.defaults;
        this.mappings = builder.mappings;
        this.settings = builder.settings;
    }

    public static IndexState of(Function<IndexState.Builder, ObjectBuilder<IndexState>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code aliases}
     */
    @Nonnull
    public final Map<String, Alias> aliases() {
        return this.aliases;
    }

    /**
     * API name: {@code data_stream}
     */
    @Nullable
    public final String dataStream() {
        return this.dataStream;
    }

    /**
     * API name: {@code defaults}
     */
    @Nullable
    public final IndexSettings defaults() {
        return this.defaults;
    }

    /**
     * API name: {@code mappings}
     */
    @Nullable
    public final TypeMapping mappings() {
        return this.mappings;
    }

    /**
     * API name: {@code settings}
     */
    @Nullable
    public final IndexSettings settings() {
        return this.settings;
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
            for (Map.Entry<String, Alias> item0 : this.aliases.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.dataStream != null) {
            generator.writeKey("data_stream");
            generator.write(this.dataStream);
        }

        if (this.defaults != null) {
            generator.writeKey("defaults");
            this.defaults.serialize(generator, mapper);
        }

        if (this.mappings != null) {
            generator.writeKey("mappings");
            this.mappings.serialize(generator, mapper);
        }

        if (this.settings != null) {
            generator.writeKey("settings");
            this.settings.serialize(generator, mapper);
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
     * Builder for {@link IndexState}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexState> {
        @Nullable
        private Map<String, Alias> aliases;
        @Nullable
        private String dataStream;
        @Nullable
        private IndexSettings defaults;
        @Nullable
        private TypeMapping mappings;
        @Nullable
        private IndexSettings settings;

        public Builder() {}

        private Builder(IndexState o) {
            this.aliases = _mapCopy(o.aliases);
            this.dataStream = o.dataStream;
            this.defaults = o.defaults;
            this.mappings = o.mappings;
            this.settings = o.settings;
        }

        private Builder(Builder o) {
            this.aliases = _mapCopy(o.aliases);
            this.dataStream = o.dataStream;
            this.defaults = o.defaults;
            this.mappings = o.mappings;
            this.settings = o.settings;
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
        public final Builder aliases(Map<String, Alias> map) {
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
        public final Builder aliases(String key, Alias value) {
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
        public final Builder aliases(String key, Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
            return aliases(key, fn.apply(new Alias.Builder()).build());
        }

        /**
         * API name: {@code data_stream}
         */
        @Nonnull
        public final Builder dataStream(@Nullable String value) {
            this.dataStream = value;
            return this;
        }

        /**
         * API name: {@code defaults}
         */
        @Nonnull
        public final Builder defaults(@Nullable IndexSettings value) {
            this.defaults = value;
            return this;
        }

        /**
         * API name: {@code defaults}
         */
        @Nonnull
        public final Builder defaults(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return defaults(fn.apply(new IndexSettings.Builder()).build());
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
         * API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(@Nullable IndexSettings value) {
            this.settings = value;
            return this;
        }

        /**
         * API name: {@code settings}
         */
        @Nonnull
        public final Builder settings(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return settings(fn.apply(new IndexSettings.Builder()).build());
        }

        /**
         * Builds a {@link IndexState}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexState build() {
            _checkSingleUse();

            return new IndexState(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexState}
     */
    public static final JsonpDeserializer<IndexState> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexState::setupIndexStateDeserializer
    );

    protected static void setupIndexStateDeserializer(ObjectDeserializer<IndexState.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(Alias._DESERIALIZER), "aliases");
        op.add(Builder::dataStream, JsonpDeserializer.stringDeserializer(), "data_stream");
        op.add(Builder::defaults, IndexSettings._DESERIALIZER, "defaults");
        op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
        op.add(Builder::settings, IndexSettings._DESERIALIZER, "settings");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.dataStream);
        result = 31 * result + Objects.hashCode(this.defaults);
        result = 31 * result + Objects.hashCode(this.mappings);
        result = 31 * result + Objects.hashCode(this.settings);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexState other = (IndexState) o;
        return Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.dataStream, other.dataStream)
            && Objects.equals(this.defaults, other.defaults)
            && Objects.equals(this.mappings, other.mappings)
            && Objects.equals(this.settings, other.settings);
    }
}
