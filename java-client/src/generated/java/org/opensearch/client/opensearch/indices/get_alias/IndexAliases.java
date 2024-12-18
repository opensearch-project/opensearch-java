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

package org.opensearch.client.opensearch.indices.get_alias;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch.indices.AliasDefinition;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.get_alias.IndexAliases

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexAliases implements PlainJsonSerializable, ToCopyableBuilder<IndexAliases.Builder, IndexAliases> {

    @Nonnull
    private final Map<String, AliasDefinition> aliases;

    // ---------------------------------------------------------------------------------------------

    private IndexAliases(Builder builder) {
        this.aliases = ApiTypeHelper.unmodifiableRequired(builder.aliases, this, "aliases");
    }

    public static IndexAliases of(Function<IndexAliases.Builder, ObjectBuilder<IndexAliases>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code aliases}
     */
    @Nonnull
    public final Map<String, AliasDefinition> aliases() {
        return this.aliases;
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
        for (Map.Entry<String, AliasDefinition> item0 : this.aliases.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link IndexAliases}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexAliases> {
        private Map<String, AliasDefinition> aliases;

        public Builder() {}

        private Builder(IndexAliases o) {
            this.aliases = _mapCopy(o.aliases);
        }

        private Builder(Builder o) {
            this.aliases = _mapCopy(o.aliases);
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
        public final Builder aliases(Map<String, AliasDefinition> map) {
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
        public final Builder aliases(String key, AliasDefinition value) {
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
        public final Builder aliases(String key, Function<AliasDefinition.Builder, ObjectBuilder<AliasDefinition>> fn) {
            return aliases(key, fn.apply(new AliasDefinition.Builder()).build());
        }

        /**
         * Builds a {@link IndexAliases}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexAliases build() {
            _checkSingleUse();

            return new IndexAliases(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexAliases}
     */
    public static final JsonpDeserializer<IndexAliases> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexAliases::setupIndexAliasesDeserializer
    );

    protected static void setupIndexAliasesDeserializer(ObjectDeserializer<IndexAliases.Builder> op) {
        op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(AliasDefinition._DESERIALIZER), "aliases");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.aliases.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexAliases other = (IndexAliases) o;
        return this.aliases.equals(other.aliases);
    }
}
