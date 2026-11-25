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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: ism.ActionAliasAction

/**
 * An alias action on the managed index. Only <code>add</code> and <code>remove</code> are supported.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ActionAliasAction implements TaggedUnion<ActionAliasAction.Kind, ActionAliasActionVariant>, PlainJsonSerializable {
    /**
     * {@link ActionAliasAction} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Add("add"),
        Remove("remove");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    private final Kind _kind;
    private final ActionAliasActionVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final ActionAliasActionVariant _get() {
        return _value;
    }

    public ActionAliasAction(ActionAliasActionVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._actionAliasActionKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private ActionAliasAction(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static ActionAliasAction of(Function<ActionAliasAction.Builder, ObjectBuilder<ActionAliasAction>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code add}?
     */
    public boolean isAdd() {
        return _kind == Kind.Add;
    }

    /**
     * Get the {@code add} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code add} kind.
     */
    public ActionAliasAdd add() {
        return TaggedUnionUtils.get(this, Kind.Add);
    }

    /**
     * Is this variant instance of kind {@code remove}?
     */
    public boolean isRemove() {
        return _kind == Kind.Remove;
    }

    /**
     * Get the {@code remove} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code remove} kind.
     */
    public ActionAliasRemove remove() {
        return TaggedUnionUtils.get(this, Kind.Remove);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        generator.writeKey(_kind.jsonValue());
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ActionAliasAction> {
        private Kind _kind;
        private ActionAliasActionVariant _value;

        public Builder() {}

        private Builder(ActionAliasAction o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<ActionAliasAction> add(ActionAliasAdd v) {
            this._kind = Kind.Add;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ActionAliasAction> add(Function<ActionAliasAdd.Builder, ObjectBuilder<ActionAliasAdd>> fn) {
            return this.add(fn.apply(new ActionAliasAdd.Builder()).build());
        }

        public ObjectBuilder<ActionAliasAction> remove(ActionAliasRemove v) {
            this._kind = Kind.Remove;
            this._value = v;
            return this;
        }

        public ObjectBuilder<ActionAliasAction> remove(Function<ActionAliasRemove.Builder, ObjectBuilder<ActionAliasRemove>> fn) {
            return this.remove(fn.apply(new ActionAliasRemove.Builder()).build());
        }

        @Override
        public ActionAliasAction build() {
            _checkSingleUse();
            return new ActionAliasAction(this);
        }
    }

    protected static void setupActionAliasActionDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::add, ActionAliasAdd._DESERIALIZER, "add");
        op.add(Builder::remove, ActionAliasRemove._DESERIALIZER, "remove");
    }

    public static final JsonpDeserializer<ActionAliasAction> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionAliasAction::setupActionAliasActionDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionAliasAction other = (ActionAliasAction) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
