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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: ism.ActionAlias

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionAlias implements PlainJsonSerializable, ToCopyableBuilder<ActionAlias.Builder, ActionAlias> {

    @Nonnull
    private final List<ActionAliasAction> actions;

    // ---------------------------------------------------------------------------------------------

    private ActionAlias(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiableRequired(builder.actions, this, "actions");
    }

    public static ActionAlias of(Function<ActionAlias.Builder, ObjectBuilder<ActionAlias>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The alias actions to perform.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    @Nonnull
    public final List<ActionAliasAction> actions() {
        return this.actions;
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
        generator.writeKey("actions");
        generator.writeStartArray();
        for (ActionAliasAction item0 : this.actions) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link ActionAlias}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionAlias> {
        private List<ActionAliasAction> actions;

        public Builder() {}

        private Builder(ActionAlias o) {
            this.actions = _listCopy(o.actions);
        }

        private Builder(Builder o) {
            this.actions = _listCopy(o.actions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The alias actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(List<ActionAliasAction> list) {
            this.actions = _listAddAll(this.actions, list);
            return this;
        }

        /**
         * Required - The alias actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(ActionAliasAction value, ActionAliasAction... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * Required - The alias actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds a value to <code>actions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder actions(Function<ActionAliasAction.Builder, ObjectBuilder<ActionAliasAction>> fn) {
            return actions(fn.apply(new ActionAliasAction.Builder()).build());
        }

        /**
         * Builds a {@link ActionAlias}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionAlias build() {
            _checkSingleUse();

            return new ActionAlias(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionAlias}
     */
    public static final JsonpDeserializer<ActionAlias> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionAlias::setupActionAliasDeserializer
    );

    protected static void setupActionAliasDeserializer(ObjectDeserializer<ActionAlias.Builder> op) {
        op.add(Builder::actions, JsonpDeserializer.arrayDeserializer(ActionAliasAction._DESERIALIZER), "actions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.actions.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionAlias other = (ActionAlias) o;
        return this.actions.equals(other.actions);
    }
}
