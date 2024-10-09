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
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: indices.Alias

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Alias implements PlainJsonSerializable {

    @Nullable
    private final Query filter;

    @Nonnull
    private final List<String> indexRouting;

    @Nullable
    private final Boolean isHidden;

    @Nullable
    private final Boolean isWriteIndex;

    @Nonnull
    private final List<String> routing;

    @Nonnull
    private final List<String> searchRouting;

    // ---------------------------------------------------------------------------------------------

    private Alias(Builder builder) {
        this.filter = builder.filter;
        this.indexRouting = ApiTypeHelper.unmodifiable(builder.indexRouting);
        this.isHidden = builder.isHidden;
        this.isWriteIndex = builder.isWriteIndex;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.searchRouting = ApiTypeHelper.unmodifiable(builder.searchRouting);
    }

    public static Alias of(Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code filter}
     */
    @Nullable
    public final Query filter() {
        return this.filter;
    }

    /**
     * API name: {@code index_routing}
     */
    @Nonnull
    public final List<String> indexRouting() {
        return this.indexRouting;
    }

    /**
     * If <code>true</code>, the alias is hidden. All indices for the alias must have the same <code>is_hidden</code> value.
     * <p>
     * API name: {@code is_hidden}
     * </p>
     */
    @Nullable
    public final Boolean isHidden() {
        return this.isHidden;
    }

    /**
     * If <code>true</code>, the index is the write index for the alias.
     * <p>
     * API name: {@code is_write_index}
     * </p>
     */
    @Nullable
    public final Boolean isWriteIndex() {
        return this.isWriteIndex;
    }

    /**
     * API name: {@code routing}
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * API name: {@code search_routing}
     */
    @Nonnull
    public final List<String> searchRouting() {
        return this.searchRouting;
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
        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.indexRouting)) {
            generator.writeKey("index_routing");
            generator.writeStartArray();
            for (String item0 : this.indexRouting) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.isHidden != null) {
            generator.writeKey("is_hidden");
            generator.write(this.isHidden);
        }

        if (this.isWriteIndex != null) {
            generator.writeKey("is_write_index");
            generator.write(this.isWriteIndex);
        }

        if (ApiTypeHelper.isDefined(this.routing)) {
            generator.writeKey("routing");
            generator.writeStartArray();
            for (String item0 : this.routing) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.searchRouting)) {
            generator.writeKey("search_routing");
            generator.writeStartArray();
            for (String item0 : this.searchRouting) {
                generator.write(item0);
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link Alias}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Alias> {
        @Nullable
        private Query filter;
        @Nullable
        private List<String> indexRouting;
        @Nullable
        private Boolean isHidden;
        @Nullable
        private Boolean isWriteIndex;
        @Nullable
        private List<String> routing;
        @Nullable
        private List<String> searchRouting;

        /**
         * API name: {@code filter}
         */
        public final Builder filter(@Nullable Query value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filter(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code index_routing}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexRouting</code>.
         * </p>
         */
        public final Builder indexRouting(List<String> list) {
            this.indexRouting = _listAddAll(this.indexRouting, list);
            return this;
        }

        /**
         * API name: {@code index_routing}
         *
         * <p>
         * Adds one or more values to <code>indexRouting</code>.
         * </p>
         */
        public final Builder indexRouting(String value, String... values) {
            this.indexRouting = _listAdd(this.indexRouting, value, values);
            return this;
        }

        /**
         * If <code>true</code>, the alias is hidden. All indices for the alias must have the same <code>is_hidden</code> value.
         * <p>
         * API name: {@code is_hidden}
         * </p>
         */
        public final Builder isHidden(@Nullable Boolean value) {
            this.isHidden = value;
            return this;
        }

        /**
         * If <code>true</code>, the index is the write index for the alias.
         * <p>
         * API name: {@code is_write_index}
         * </p>
         */
        public final Builder isWriteIndex(@Nullable Boolean value) {
            this.isWriteIndex = value;
            return this;
        }

        /**
         * API name: {@code routing}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>routing</code>.
         * </p>
         */
        public final Builder routing(List<String> list) {
            this.routing = _listAddAll(this.routing, list);
            return this;
        }

        /**
         * API name: {@code routing}
         *
         * <p>
         * Adds one or more values to <code>routing</code>.
         * </p>
         */
        public final Builder routing(String value, String... values) {
            this.routing = _listAdd(this.routing, value, values);
            return this;
        }

        /**
         * API name: {@code search_routing}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>searchRouting</code>.
         * </p>
         */
        public final Builder searchRouting(List<String> list) {
            this.searchRouting = _listAddAll(this.searchRouting, list);
            return this;
        }

        /**
         * API name: {@code search_routing}
         *
         * <p>
         * Adds one or more values to <code>searchRouting</code>.
         * </p>
         */
        public final Builder searchRouting(String value, String... values) {
            this.searchRouting = _listAdd(this.searchRouting, value, values);
            return this;
        }

        /**
         * Builds a {@link Alias}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Alias build() {
            _checkSingleUse();

            return new Alias(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Alias}
     */
    public static final JsonpDeserializer<Alias> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Alias::setupAliasDeserializer
    );

    protected static void setupAliasDeserializer(ObjectDeserializer<Alias.Builder> op) {
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::indexRouting, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "index_routing");
        op.add(Builder::isHidden, JsonpDeserializer.booleanDeserializer(), "is_hidden");
        op.add(Builder::isWriteIndex, JsonpDeserializer.booleanDeserializer(), "is_write_index");
        op.add(Builder::routing, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "routing");
        op.add(Builder::searchRouting, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "search_routing");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.indexRouting);
        result = 31 * result + Objects.hashCode(this.isHidden);
        result = 31 * result + Objects.hashCode(this.isWriteIndex);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.searchRouting);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Alias other = (Alias) o;
        return Objects.equals(this.filter, other.filter)
            && Objects.equals(this.indexRouting, other.indexRouting)
            && Objects.equals(this.isHidden, other.isHidden)
            && Objects.equals(this.isWriteIndex, other.isWriteIndex)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.searchRouting, other.searchRouting);
    }
}
