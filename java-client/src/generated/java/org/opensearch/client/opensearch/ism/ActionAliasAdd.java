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

package org.opensearch.client.opensearch.ism;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.ActionAliasAdd

/**
 * Adds aliases to the managed index. Requires exactly one of <code>alias</code> or <code>aliases</code>.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionAliasAdd
    implements
        ActionAliasActionVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ActionAliasAdd.Builder, ActionAliasAdd> {

    @Nullable
    private final String alias;

    @Nonnull
    private final List<String> aliases;

    @Nullable
    private final Query filter;

    @Nullable
    private final String indexRouting;

    @Nullable
    private final Boolean isHidden;

    @Nullable
    private final Boolean isWriteIndex;

    @Nullable
    private final String routing;

    @Nullable
    private final String searchRouting;

    // ---------------------------------------------------------------------------------------------

    private ActionAliasAdd(Builder builder) {
        this.alias = builder.alias;
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.filter = builder.filter;
        this.indexRouting = builder.indexRouting;
        this.isHidden = builder.isHidden;
        this.isWriteIndex = builder.isWriteIndex;
        this.routing = builder.routing;
        this.searchRouting = builder.searchRouting;
    }

    public static ActionAliasAdd of(Function<ActionAliasAdd.Builder, ObjectBuilder<ActionAliasAdd>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ActionAliasAction} variant kind.
     */
    @Override
    public ActionAliasAction.Kind _actionAliasActionKind() {
        return ActionAliasAction.Kind.Add;
    }

    /**
     * API name: {@code alias}
     */
    @Nullable
    public final String alias() {
        return this.alias;
    }

    /**
     * API name: {@code aliases}
     */
    @Nonnull
    public final List<String> aliases() {
        return this.aliases;
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
    @Nullable
    public final String indexRouting() {
        return this.indexRouting;
    }

    /**
     * Whether the alias is hidden.
     * <p>
     * API name: {@code is_hidden}
     * </p>
     */
    @Nullable
    public final Boolean isHidden() {
        return this.isHidden;
    }

    /**
     * Whether the managed index is the write index for the alias.
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
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code search_routing}
     */
    @Nullable
    public final String searchRouting() {
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
        if (this.alias != null) {
            generator.writeKey("alias");
            generator.write(this.alias);
        }

        if (ApiTypeHelper.isDefined(this.aliases)) {
            generator.writeKey("aliases");
            generator.writeStartArray();
            for (String item0 : this.aliases) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.indexRouting != null) {
            generator.writeKey("index_routing");
            generator.write(this.indexRouting);
        }

        if (this.isHidden != null) {
            generator.writeKey("is_hidden");
            generator.write(this.isHidden);
        }

        if (this.isWriteIndex != null) {
            generator.writeKey("is_write_index");
            generator.write(this.isWriteIndex);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

        if (this.searchRouting != null) {
            generator.writeKey("search_routing");
            generator.write(this.searchRouting);
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
     * Builder for {@link ActionAliasAdd}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionAliasAdd> {
        @Nullable
        private String alias;
        @Nullable
        private List<String> aliases;
        @Nullable
        private Query filter;
        @Nullable
        private String indexRouting;
        @Nullable
        private Boolean isHidden;
        @Nullable
        private Boolean isWriteIndex;
        @Nullable
        private String routing;
        @Nullable
        private String searchRouting;

        public Builder() {}

        private Builder(ActionAliasAdd o) {
            this.alias = o.alias;
            this.aliases = _listCopy(o.aliases);
            this.filter = o.filter;
            this.indexRouting = o.indexRouting;
            this.isHidden = o.isHidden;
            this.isWriteIndex = o.isWriteIndex;
            this.routing = o.routing;
            this.searchRouting = o.searchRouting;
        }

        private Builder(Builder o) {
            this.alias = o.alias;
            this.aliases = _listCopy(o.aliases);
            this.filter = o.filter;
            this.indexRouting = o.indexRouting;
            this.isHidden = o.isHidden;
            this.isWriteIndex = o.isWriteIndex;
            this.routing = o.routing;
            this.searchRouting = o.searchRouting;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code alias}
         */
        @Nonnull
        public final Builder alias(@Nullable String value) {
            this.alias = value;
            return this;
        }

        /**
         * API name: {@code aliases}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(List<String> list) {
            this.aliases = _listAddAll(this.aliases, list);
            return this;
        }

        /**
         * API name: {@code aliases}
         *
         * <p>
         * Adds one or more values to <code>aliases</code>.
         * </p>
         */
        @Nonnull
        public final Builder aliases(String value, String... values) {
            this.aliases = _listAdd(this.aliases, value, values);
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(@Nullable Query value) {
            this.filter = value;
            return this;
        }

        /**
         * API name: {@code filter}
         */
        @Nonnull
        public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filter(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code index_routing}
         */
        @Nonnull
        public final Builder indexRouting(@Nullable String value) {
            this.indexRouting = value;
            return this;
        }

        /**
         * Whether the alias is hidden.
         * <p>
         * API name: {@code is_hidden}
         * </p>
         */
        @Nonnull
        public final Builder isHidden(@Nullable Boolean value) {
            this.isHidden = value;
            return this;
        }

        /**
         * Whether the managed index is the write index for the alias.
         * <p>
         * API name: {@code is_write_index}
         * </p>
         */
        @Nonnull
        public final Builder isWriteIndex(@Nullable Boolean value) {
            this.isWriteIndex = value;
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code search_routing}
         */
        @Nonnull
        public final Builder searchRouting(@Nullable String value) {
            this.searchRouting = value;
            return this;
        }

        /**
         * Builds a {@link ActionAliasAdd}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionAliasAdd build() {
            _checkSingleUse();

            return new ActionAliasAdd(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionAliasAdd}
     */
    public static final JsonpDeserializer<ActionAliasAdd> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionAliasAdd::setupActionAliasAddDeserializer
    );

    protected static void setupActionAliasAddDeserializer(ObjectDeserializer<ActionAliasAdd.Builder> op) {
        op.add(Builder::alias, JsonpDeserializer.stringDeserializer(), "alias");
        op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "aliases");
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::indexRouting, JsonpDeserializer.stringDeserializer(), "index_routing");
        op.add(Builder::isHidden, JsonpDeserializer.booleanDeserializer(), "is_hidden");
        op.add(Builder::isWriteIndex, JsonpDeserializer.booleanDeserializer(), "is_write_index");
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::searchRouting, JsonpDeserializer.stringDeserializer(), "search_routing");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alias);
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.indexRouting);
        result = 31 * result + Objects.hashCode(this.isHidden);
        result = 31 * result + Objects.hashCode(this.isWriteIndex);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.searchRouting);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionAliasAdd other = (ActionAliasAdd) o;
        return Objects.equals(this.alias, other.alias)
            && Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.indexRouting, other.indexRouting)
            && Objects.equals(this.isHidden, other.isHidden)
            && Objects.equals(this.isWriteIndex, other.isWriteIndex)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.searchRouting, other.searchRouting);
    }
}
