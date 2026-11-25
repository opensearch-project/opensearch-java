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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.ActionAliasRemove

/**
 * Removes aliases from the managed index. Requires exactly one of <code>alias</code> or <code>aliases</code>.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionAliasRemove
    implements
        ActionAliasActionVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ActionAliasRemove.Builder, ActionAliasRemove> {

    @Nullable
    private final String alias;

    @Nonnull
    private final List<String> aliases;

    @Nullable
    private final Boolean mustExist;

    // ---------------------------------------------------------------------------------------------

    private ActionAliasRemove(Builder builder) {
        this.alias = builder.alias;
        this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
        this.mustExist = builder.mustExist;
    }

    public static ActionAliasRemove of(Function<ActionAliasRemove.Builder, ObjectBuilder<ActionAliasRemove>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ActionAliasAction} variant kind.
     */
    @Override
    public ActionAliasAction.Kind _actionAliasActionKind() {
        return ActionAliasAction.Kind.Remove;
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
     * Whether the alias must exist to perform the action.
     * <p>
     * API name: {@code must_exist}
     * </p>
     */
    @Nullable
    public final Boolean mustExist() {
        return this.mustExist;
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

        if (this.mustExist != null) {
            generator.writeKey("must_exist");
            generator.write(this.mustExist);
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
     * Builder for {@link ActionAliasRemove}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionAliasRemove> {
        @Nullable
        private String alias;
        @Nullable
        private List<String> aliases;
        @Nullable
        private Boolean mustExist;

        public Builder() {}

        private Builder(ActionAliasRemove o) {
            this.alias = o.alias;
            this.aliases = _listCopy(o.aliases);
            this.mustExist = o.mustExist;
        }

        private Builder(Builder o) {
            this.alias = o.alias;
            this.aliases = _listCopy(o.aliases);
            this.mustExist = o.mustExist;
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
         * Whether the alias must exist to perform the action.
         * <p>
         * API name: {@code must_exist}
         * </p>
         */
        @Nonnull
        public final Builder mustExist(@Nullable Boolean value) {
            this.mustExist = value;
            return this;
        }

        /**
         * Builds a {@link ActionAliasRemove}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionAliasRemove build() {
            _checkSingleUse();

            return new ActionAliasRemove(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionAliasRemove}
     */
    public static final JsonpDeserializer<ActionAliasRemove> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionAliasRemove::setupActionAliasRemoveDeserializer
    );

    protected static void setupActionAliasRemoveDeserializer(ObjectDeserializer<ActionAliasRemove.Builder> op) {
        op.add(Builder::alias, JsonpDeserializer.stringDeserializer(), "alias");
        op.add(Builder::aliases, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "aliases");
        op.add(Builder::mustExist, JsonpDeserializer.booleanDeserializer(), "must_exist");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.alias);
        result = 31 * result + Objects.hashCode(this.aliases);
        result = 31 * result + Objects.hashCode(this.mustExist);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionAliasRemove other = (ActionAliasRemove) o;
        return Objects.equals(this.alias, other.alias)
            && Objects.equals(this.aliases, other.aliases)
            && Objects.equals(this.mustExist, other.mustExist);
    }
}
