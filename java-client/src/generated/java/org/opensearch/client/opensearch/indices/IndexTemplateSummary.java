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
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices.IndexTemplateSummary

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexTemplateSummary implements PlainJsonSerializable {

    @Nonnull
    private final Map<String, Alias> aliases;

    @Nullable
    private final TypeMapping mappings;

    @Nullable
    private final IndexSettings settings;

    // ---------------------------------------------------------------------------------------------

    private IndexTemplateSummary(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.mappings = builder.mappings;
        this.settings = builder.settings;
    }

    public static IndexTemplateSummary of(Function<IndexTemplateSummary.Builder, ObjectBuilder<IndexTemplateSummary>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Aliases to add. If the index template includes a <code>data_stream</code> object, these are data stream aliases. Otherwise, these are
     * index aliases. Data stream aliases ignore the <code>index_routing</code>, <code>routing</code>, and <code>search_routing</code>
     * options.
     * <p>
     * API name: {@code aliases}
     * </p>
     */
    @Nonnull
    public final Map<String, Alias> aliases() {
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

    /**
     * Builder for {@link IndexTemplateSummary}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<IndexTemplateSummary> {
        @Nullable
        private Map<String, Alias> aliases;
        @Nullable
        private TypeMapping mappings;
        @Nullable
        private IndexSettings settings;

        /**
         * Aliases to add. If the index template includes a <code>data_stream</code> object, these are data stream aliases. Otherwise, these
         * are index aliases. Data stream aliases ignore the <code>index_routing</code>, <code>routing</code>, and
         * <code>search_routing</code> options.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aliases</code>.
         * </p>
         */
        public final Builder aliases(Map<String, Alias> map) {
            this.aliases = _mapPutAll(this.aliases, map);
            return this;
        }

        /**
         * Aliases to add. If the index template includes a <code>data_stream</code> object, these are data stream aliases. Otherwise, these
         * are index aliases. Data stream aliases ignore the <code>index_routing</code>, <code>routing</code>, and
         * <code>search_routing</code> options.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aliases</code>.
         * </p>
         */
        public final Builder aliases(String key, Alias value) {
            this.aliases = _mapPut(this.aliases, key, value);
            return this;
        }

        /**
         * Aliases to add. If the index template includes a <code>data_stream</code> object, these are data stream aliases. Otherwise, these
         * are index aliases. Data stream aliases ignore the <code>index_routing</code>, <code>routing</code>, and
         * <code>search_routing</code> options.
         * <p>
         * API name: {@code aliases}
         * </p>
         *
         * <p>
         * Adds a value to <code>aliases</code> using a builder lambda.
         * </p>
         */
        public final Builder aliases(String key, Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
            return aliases(key, fn.apply(new Alias.Builder()).build());
        }

        /**
         * API name: {@code mappings}
         */
        public final Builder mappings(@Nullable TypeMapping value) {
            this.mappings = value;
            return this;
        }

        /**
         * API name: {@code mappings}
         */
        public final Builder mappings(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
            return mappings(fn.apply(new TypeMapping.Builder()).build());
        }

        /**
         * API name: {@code settings}
         */
        public final Builder settings(@Nullable IndexSettings value) {
            this.settings = value;
            return this;
        }

        /**
         * API name: {@code settings}
         */
        public final Builder settings(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return settings(fn.apply(new IndexSettings.Builder()).build());
        }

        /**
         * Builds a {@link IndexTemplateSummary}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public IndexTemplateSummary build() {
            _checkSingleUse();

            return new IndexTemplateSummary(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexTemplateSummary}
     */
    public static final JsonpDeserializer<IndexTemplateSummary> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexTemplateSummary::setupIndexTemplateSummaryDeserializer
    );

    protected static void setupIndexTemplateSummaryDeserializer(ObjectDeserializer<IndexTemplateSummary.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(Alias._DESERIALIZER), "aliases");
        op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
        op.add(Builder::settings, IndexSettings._DESERIALIZER, "settings");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.mappings);
        result = 31 * result + Objects.hashCode(this.settings);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexTemplateSummary other = (IndexTemplateSummary) o;
        return Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.mappings, other.mappings)
            && Objects.equals(this.settings, other.settings);
    }
}
