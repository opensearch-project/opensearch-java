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
    private final Map<String, JsonData> actions;

    // ---------------------------------------------------------------------------------------------

    private ActionAlias(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
    }

    public static ActionAlias of(Function<ActionAlias.Builder, ObjectBuilder<ActionAlias>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The alias actions to perform.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> actions() {
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
        if (ApiTypeHelper.isDefined(this.actions)) {
            generator.writeKey("actions");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.actions.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link ActionAlias}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionAlias> {
        @Nullable
        private Map<String, JsonData> actions;

        public Builder() {}

        private Builder(ActionAlias o) {
            this.actions = _mapCopy(o.actions);
        }

        private Builder(Builder o) {
            this.actions = _mapCopy(o.actions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The alias actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(Map<String, JsonData> map) {
            this.actions = _mapPutAll(this.actions, map);
            return this;
        }

        /**
         * The alias actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds an entry to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(String key, JsonData value) {
            this.actions = _mapPut(this.actions, key, value);
            return this;
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
        op.add(Builder::actions, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "actions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionAlias other = (ActionAlias) o;
        return Objects.equals(this.actions, other.actions);
    }
}
