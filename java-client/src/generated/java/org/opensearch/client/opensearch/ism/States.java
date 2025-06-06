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

// typedef: ism.States

/**
 * The list of actions to perform and transitions to enter a new state.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class States implements PlainJsonSerializable, ToCopyableBuilder<States.Builder, States> {

    @Nonnull
    private final List<Action> actions;

    @Nullable
    private final String name;

    @Nonnull
    private final List<Transition> transitions;

    // ---------------------------------------------------------------------------------------------

    private States(Builder builder) {
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.name = builder.name;
        this.transitions = ApiTypeHelper.unmodifiable(builder.transitions);
    }

    public static States of(Function<States.Builder, ObjectBuilder<States>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The list of actions to perform.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    @Nonnull
    public final List<Action> actions() {
        return this.actions;
    }

    /**
     * The name of the state.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * The list of transitions to enter a new state.
     * <p>
     * API name: {@code transitions}
     * </p>
     */
    @Nonnull
    public final List<Transition> transitions() {
        return this.transitions;
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
            generator.writeStartArray();
            for (Action item0 : this.actions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (ApiTypeHelper.isDefined(this.transitions)) {
            generator.writeKey("transitions");
            generator.writeStartArray();
            for (Transition item0 : this.transitions) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link States}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, States> {
        @Nullable
        private List<Action> actions;
        @Nullable
        private String name;
        @Nullable
        private List<Transition> transitions;

        public Builder() {}

        private Builder(States o) {
            this.actions = _listCopy(o.actions);
            this.name = o.name;
            this.transitions = _listCopy(o.transitions);
        }

        private Builder(Builder o) {
            this.actions = _listCopy(o.actions);
            this.name = o.name;
            this.transitions = _listCopy(o.transitions);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The list of actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(List<Action> list) {
            this.actions = _listAddAll(this.actions, list);
            return this;
        }

        /**
         * The list of actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(Action value, Action... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * The list of actions to perform.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds a value to <code>actions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder actions(Function<Action.Builder, ObjectBuilder<Action>> fn) {
            return actions(fn.apply(new Action.Builder()).build());
        }

        /**
         * The name of the state.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * The list of transitions to enter a new state.
         * <p>
         * API name: {@code transitions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>transitions</code>.
         * </p>
         */
        @Nonnull
        public final Builder transitions(List<Transition> list) {
            this.transitions = _listAddAll(this.transitions, list);
            return this;
        }

        /**
         * The list of transitions to enter a new state.
         * <p>
         * API name: {@code transitions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>transitions</code>.
         * </p>
         */
        @Nonnull
        public final Builder transitions(Transition value, Transition... values) {
            this.transitions = _listAdd(this.transitions, value, values);
            return this;
        }

        /**
         * The list of transitions to enter a new state.
         * <p>
         * API name: {@code transitions}
         * </p>
         *
         * <p>
         * Adds a value to <code>transitions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder transitions(Function<Transition.Builder, ObjectBuilder<Transition>> fn) {
            return transitions(fn.apply(new Transition.Builder()).build());
        }

        /**
         * Builds a {@link States}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public States build() {
            _checkSingleUse();

            return new States(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link States}
     */
    public static final JsonpDeserializer<States> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        States::setupStatesDeserializer
    );

    protected static void setupStatesDeserializer(ObjectDeserializer<States.Builder> op) {
        op.add(Builder::actions, JsonpDeserializer.arrayDeserializer(Action._DESERIALIZER), "actions");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::transitions, JsonpDeserializer.arrayDeserializer(Transition._DESERIALIZER), "transitions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actions);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.transitions);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        States other = (States) o;
        return Objects.equals(this.actions, other.actions)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.transitions, other.transitions);
    }
}
