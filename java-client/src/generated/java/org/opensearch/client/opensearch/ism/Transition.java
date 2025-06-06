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

// typedef: ism.Transition

/**
 * A transition into a new state.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Transition implements PlainJsonSerializable, ToCopyableBuilder<Transition.Builder, Transition> {

    @Nonnull
    private final Map<String, JsonData> conditions;

    @Nullable
    private final String stateName;

    // ---------------------------------------------------------------------------------------------

    private Transition(Builder builder) {
        this.conditions = ApiTypeHelper.unmodifiable(builder.conditions);
        this.stateName = builder.stateName;
    }

    public static Transition of(Function<Transition.Builder, ObjectBuilder<Transition>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The conditions for the transition.
     * <p>
     * API name: {@code conditions}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> conditions() {
        return this.conditions;
    }

    /**
     * The name of the state to transition to.
     * <p>
     * API name: {@code state_name}
     * </p>
     */
    @Nullable
    public final String stateName() {
        return this.stateName;
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
        if (ApiTypeHelper.isDefined(this.conditions)) {
            generator.writeKey("conditions");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.conditions.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.stateName != null) {
            generator.writeKey("state_name");
            generator.write(this.stateName);
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
     * Builder for {@link Transition}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Transition> {
        @Nullable
        private Map<String, JsonData> conditions;
        @Nullable
        private String stateName;

        public Builder() {}

        private Builder(Transition o) {
            this.conditions = _mapCopy(o.conditions);
            this.stateName = o.stateName;
        }

        private Builder(Builder o) {
            this.conditions = _mapCopy(o.conditions);
            this.stateName = o.stateName;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The conditions for the transition.
         * <p>
         * API name: {@code conditions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>conditions</code>.
         * </p>
         */
        @Nonnull
        public final Builder conditions(Map<String, JsonData> map) {
            this.conditions = _mapPutAll(this.conditions, map);
            return this;
        }

        /**
         * The conditions for the transition.
         * <p>
         * API name: {@code conditions}
         * </p>
         *
         * <p>
         * Adds an entry to <code>conditions</code>.
         * </p>
         */
        @Nonnull
        public final Builder conditions(String key, JsonData value) {
            this.conditions = _mapPut(this.conditions, key, value);
            return this;
        }

        /**
         * The name of the state to transition to.
         * <p>
         * API name: {@code state_name}
         * </p>
         */
        @Nonnull
        public final Builder stateName(@Nullable String value) {
            this.stateName = value;
            return this;
        }

        /**
         * Builds a {@link Transition}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Transition build() {
            _checkSingleUse();

            return new Transition(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Transition}
     */
    public static final JsonpDeserializer<Transition> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Transition::setupTransitionDeserializer
    );

    protected static void setupTransitionDeserializer(ObjectDeserializer<Transition.Builder> op) {
        op.add(Builder::conditions, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "conditions");
        op.add(Builder::stateName, JsonpDeserializer.stringDeserializer(), "state_name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.conditions);
        result = 31 * result + Objects.hashCode(this.stateName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Transition other = (Transition) o;
        return Objects.equals(this.conditions, other.conditions) && Objects.equals(this.stateName, other.stateName);
    }
}
