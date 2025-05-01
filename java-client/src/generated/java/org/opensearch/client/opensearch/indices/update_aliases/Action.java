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

package org.opensearch.client.opensearch.indices.update_aliases;

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

// typedef: indices.update_aliases.Action

/**
 * The action to perform on aliases.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Action implements TaggedUnion<Action.Kind, ActionVariant>, PlainJsonSerializable {
    /**
     * {@link Action} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Add("add"),
        Remove("remove"),
        RemoveIndex("remove_index");

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
    private final ActionVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final ActionVariant _get() {
        return _value;
    }

    public Action(ActionVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._actionKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private Action(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static Action of(Function<Action.Builder, ObjectBuilder<Action>> fn) {
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
    public AddAction add() {
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
    public RemoveAction remove() {
        return TaggedUnionUtils.get(this, Kind.Remove);
    }

    /**
     * Is this variant instance of kind {@code remove_index}?
     */
    public boolean isRemoveIndex() {
        return _kind == Kind.RemoveIndex;
    }

    /**
     * Get the {@code remove_index} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code remove_index} kind.
     */
    public RemoveIndexAction removeIndex() {
        return TaggedUnionUtils.get(this, Kind.RemoveIndex);
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Action> {
        private Kind _kind;
        private ActionVariant _value;

        public Builder() {}

        private Builder(Action o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<Action> add(AddAction v) {
            this._kind = Kind.Add;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Action> add(Function<AddAction.Builder, ObjectBuilder<AddAction>> fn) {
            return this.add(fn.apply(new AddAction.Builder()).build());
        }

        public ObjectBuilder<Action> remove(RemoveAction v) {
            this._kind = Kind.Remove;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Action> remove(Function<RemoveAction.Builder, ObjectBuilder<RemoveAction>> fn) {
            return this.remove(fn.apply(new RemoveAction.Builder()).build());
        }

        public ObjectBuilder<Action> removeIndex(RemoveIndexAction v) {
            this._kind = Kind.RemoveIndex;
            this._value = v;
            return this;
        }

        public ObjectBuilder<Action> removeIndex(Function<RemoveIndexAction.Builder, ObjectBuilder<RemoveIndexAction>> fn) {
            return this.removeIndex(fn.apply(new RemoveIndexAction.Builder()).build());
        }

        @Override
        public Action build() {
            _checkSingleUse();
            return new Action(this);
        }
    }

    protected static void setupActionDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::add, AddAction._DESERIALIZER, "add");
        op.add(Builder::remove, RemoveAction._DESERIALIZER, "remove");
        op.add(Builder::removeIndex, RemoveIndexAction._DESERIALIZER, "remove_index");
    }

    public static final JsonpDeserializer<Action> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Action::setupActionDeserializer,
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
        Action other = (Action) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
