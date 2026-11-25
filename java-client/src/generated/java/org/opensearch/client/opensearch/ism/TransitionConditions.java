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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: ism.TransitionConditions

/**
 * The condition for the transition. Accepts at most one condition.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TransitionConditions implements TaggedUnion<TransitionConditions.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link TransitionConditions} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Cron("cron"),
        MinDocCount("min_doc_count"),
        MinIndexAge("min_index_age"),
        MinRolloverAge("min_rollover_age"),
        MinSize("min_size"),
        MinStateAge("min_state_age"),
        NoAlias("no_alias");

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
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    public TransitionConditions(TransitionConditionsVariant value) {
        if (value != null) {
            this._kind = ApiTypeHelper.requireNonNull(value._transitionConditionsKind(), this, "<variant kind>");
            this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
        } else {
            this._kind = null;
            this._value = null;
        }
    }

    private TransitionConditions(Builder builder) {
        if (builder._kind != null) {
            this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
            this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
        } else {
            this._kind = null;
            this._value = null;
        }
    }

    public static TransitionConditions of(Function<TransitionConditions.Builder, ObjectBuilder<TransitionConditions>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code cron}?
     */
    public boolean isCron() {
        return _kind == Kind.Cron;
    }

    /**
     * Get the {@code cron} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code cron} kind.
     */
    public TransitionCron cron() {
        return TaggedUnionUtils.get(this, Kind.Cron);
    }

    /**
     * Is this variant instance of kind {@code min_doc_count}?
     */
    public boolean isMinDocCount() {
        return _kind == Kind.MinDocCount;
    }

    /**
     * Get the {@code min_doc_count} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code min_doc_count} kind.
     */
    public Long minDocCount() {
        return TaggedUnionUtils.get(this, Kind.MinDocCount);
    }

    /**
     * Is this variant instance of kind {@code min_index_age}?
     */
    public boolean isMinIndexAge() {
        return _kind == Kind.MinIndexAge;
    }

    /**
     * Get the {@code min_index_age} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code min_index_age} kind.
     */
    public Time minIndexAge() {
        return TaggedUnionUtils.get(this, Kind.MinIndexAge);
    }

    /**
     * Is this variant instance of kind {@code min_rollover_age}?
     */
    public boolean isMinRolloverAge() {
        return _kind == Kind.MinRolloverAge;
    }

    /**
     * Get the {@code min_rollover_age} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code min_rollover_age} kind.
     */
    public Time minRolloverAge() {
        return TaggedUnionUtils.get(this, Kind.MinRolloverAge);
    }

    /**
     * Is this variant instance of kind {@code min_size}?
     */
    public boolean isMinSize() {
        return _kind == Kind.MinSize;
    }

    /**
     * Get the {@code min_size} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code min_size} kind.
     */
    public String minSize() {
        return TaggedUnionUtils.get(this, Kind.MinSize);
    }

    /**
     * Is this variant instance of kind {@code min_state_age}?
     */
    public boolean isMinStateAge() {
        return _kind == Kind.MinStateAge;
    }

    /**
     * Get the {@code min_state_age} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code min_state_age} kind.
     */
    public Time minStateAge() {
        return TaggedUnionUtils.get(this, Kind.MinStateAge);
    }

    /**
     * Is this variant instance of kind {@code no_alias}?
     */
    public boolean isNoAlias() {
        return _kind == Kind.NoAlias;
    }

    /**
     * Get the {@code no_alias} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code no_alias} kind.
     */
    public Boolean noAlias() {
        return TaggedUnionUtils.get(this, Kind.NoAlias);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        if (_kind != null) {
            generator.writeKey(_kind.jsonValue());
            if (_value instanceof JsonpSerializable) {
                ((JsonpSerializable) _value).serialize(generator, mapper);
            } else {
                switch (_kind) {
                    case MinDocCount:
                        generator.write(((Long) this._value));
                        break;
                    case MinSize:
                        generator.write(((String) this._value));
                        break;
                    case NoAlias:
                        generator.write(((Boolean) this._value));
                        break;
                }
            }
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TransitionConditions> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(TransitionConditions o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<TransitionConditions> cron(TransitionCron v) {
            this._kind = Kind.Cron;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TransitionConditions> cron(Function<TransitionCron.Builder, ObjectBuilder<TransitionCron>> fn) {
            return this.cron(fn.apply(new TransitionCron.Builder()).build());
        }

        public ObjectBuilder<TransitionConditions> minDocCount(Long v) {
            this._kind = Kind.MinDocCount;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TransitionConditions> minIndexAge(Time v) {
            this._kind = Kind.MinIndexAge;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TransitionConditions> minIndexAge(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.minIndexAge(fn.apply(new Time.Builder()).build());
        }

        public ObjectBuilder<TransitionConditions> minRolloverAge(Time v) {
            this._kind = Kind.MinRolloverAge;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TransitionConditions> minRolloverAge(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.minRolloverAge(fn.apply(new Time.Builder()).build());
        }

        public ObjectBuilder<TransitionConditions> minSize(String v) {
            this._kind = Kind.MinSize;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TransitionConditions> minStateAge(Time v) {
            this._kind = Kind.MinStateAge;
            this._value = v;
            return this;
        }

        public ObjectBuilder<TransitionConditions> minStateAge(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return this.minStateAge(fn.apply(new Time.Builder()).build());
        }

        public ObjectBuilder<TransitionConditions> noAlias(Boolean v) {
            this._kind = Kind.NoAlias;
            this._value = v;
            return this;
        }

        @Override
        public TransitionConditions build() {
            _checkSingleUse();
            return new TransitionConditions(this);
        }
    }

    protected static void setupTransitionConditionsDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::cron, TransitionCron._DESERIALIZER, "cron");
        op.add(Builder::minDocCount, JsonpDeserializer.longDeserializer(), "min_doc_count");
        op.add(Builder::minIndexAge, Time._DESERIALIZER, "min_index_age");
        op.add(Builder::minRolloverAge, Time._DESERIALIZER, "min_rollover_age");
        op.add(Builder::minSize, JsonpDeserializer.stringDeserializer(), "min_size");
        op.add(Builder::minStateAge, Time._DESERIALIZER, "min_state_age");
        op.add(Builder::noAlias, JsonpDeserializer.booleanDeserializer(), "no_alias");
    }

    public static final JsonpDeserializer<TransitionConditions> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TransitionConditions::setupTransitionConditionsDeserializer,
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
        TransitionConditions other = (TransitionConditions) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
