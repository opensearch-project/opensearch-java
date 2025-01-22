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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

// typedef: _types.query_dsl.FunctionScoreContainer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FunctionScore implements TaggedUnion<FunctionScore.Kind, FunctionScoreVariant>, PlainJsonSerializable {
    /**
     * {@link FunctionScore} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Exp("exp"),
        FieldValueFactor("field_value_factor"),
        Gauss("gauss"),
        Linear("linear"),
        RandomScore("random_score"),
        ScriptScore("script_score");

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
    private final FunctionScoreVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final FunctionScoreVariant _get() {
        return _value;
    }

    @Nullable
    private final Query filter;

    @Nullable
    private final Float weight;

    public FunctionScore(FunctionScoreVariant value) {
        if (value != null) {
            this._kind = ApiTypeHelper.requireNonNull(value._functionScoreKind(), this, "<variant kind>");
            this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
        } else {
            this._kind = null;
            this._value = null;
        }
        this.filter = null;
        this.weight = null;
    }

    private FunctionScore(Builder builder) {
        this.filter = builder.filter;
        this.weight = builder.weight;
        if (builder._kind != null) {
            this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
            this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
        } else {
            this._kind = null;
            this._value = null;
        }
    }

    public static FunctionScore of(Function<FunctionScore.Builder, ObjectBuilder<FunctionScore>> fn) {
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
     * API name: {@code weight}
     */
    @Nullable
    public final Float weight() {
        return this.weight;
    }

    /**
     * Is this variant instance of kind {@code exp}?
     */
    public boolean isExp() {
        return _kind == Kind.Exp;
    }

    /**
     * Get the {@code exp} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code exp} kind.
     */
    public DecayFunction exp() {
        return TaggedUnionUtils.get(this, Kind.Exp);
    }

    /**
     * Is this variant instance of kind {@code field_value_factor}?
     */
    public boolean isFieldValueFactor() {
        return _kind == Kind.FieldValueFactor;
    }

    /**
     * Get the {@code field_value_factor} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code field_value_factor} kind.
     */
    public FieldValueFactorScoreFunction fieldValueFactor() {
        return TaggedUnionUtils.get(this, Kind.FieldValueFactor);
    }

    /**
     * Is this variant instance of kind {@code gauss}?
     */
    public boolean isGauss() {
        return _kind == Kind.Gauss;
    }

    /**
     * Get the {@code gauss} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code gauss} kind.
     */
    public DecayFunction gauss() {
        return TaggedUnionUtils.get(this, Kind.Gauss);
    }

    /**
     * Is this variant instance of kind {@code linear}?
     */
    public boolean isLinear() {
        return _kind == Kind.Linear;
    }

    /**
     * Get the {@code linear} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code linear} kind.
     */
    public DecayFunction linear() {
        return TaggedUnionUtils.get(this, Kind.Linear);
    }

    /**
     * Is this variant instance of kind {@code random_score}?
     */
    public boolean isRandomScore() {
        return _kind == Kind.RandomScore;
    }

    /**
     * Get the {@code random_score} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code random_score} kind.
     */
    public RandomScoreFunction randomScore() {
        return TaggedUnionUtils.get(this, Kind.RandomScore);
    }

    /**
     * Is this variant instance of kind {@code script_score}?
     */
    public boolean isScriptScore() {
        return _kind == Kind.ScriptScore;
    }

    /**
     * Get the {@code script_score} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code script_score} kind.
     */
    public ScriptScoreFunction scriptScore() {
        return TaggedUnionUtils.get(this, Kind.ScriptScore);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        if (this.filter != null) {
            generator.writeKey("filter");
            this.filter.serialize(generator, mapper);
        }

        if (this.weight != null) {
            generator.writeKey("weight");
            generator.write(this.weight);
        }
        if (_kind != null) {
            generator.writeKey(_kind.jsonValue());
            if (_value instanceof JsonpSerializable) {
                ((JsonpSerializable) _value).serialize(generator, mapper);
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

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<FunctionScore> {
        private Kind _kind;
        private FunctionScoreVariant _value;
        @Nullable
        private Query filter;
        @Nullable
        private Float weight;

        public Builder() {}

        private Builder(FunctionScore o) {
            this.filter = o.filter;
            this.weight = o.weight;
            this._kind = o._kind;
            this._value = o._value;
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
         * API name: {@code weight}
         */
        @Nonnull
        public final Builder weight(@Nullable Float value) {
            this.weight = value;
            return this;
        }

        public ContainerBuilder exp(DecayFunction v) {
            this._kind = Kind.Exp;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder exp(Function<DecayFunction.Builder, ObjectBuilder<DecayFunction>> fn) {
            return this.exp(fn.apply(new DecayFunction.Builder()).build());
        }

        public ContainerBuilder fieldValueFactor(FieldValueFactorScoreFunction v) {
            this._kind = Kind.FieldValueFactor;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder fieldValueFactor(
            Function<FieldValueFactorScoreFunction.Builder, ObjectBuilder<FieldValueFactorScoreFunction>> fn
        ) {
            return this.fieldValueFactor(fn.apply(new FieldValueFactorScoreFunction.Builder()).build());
        }

        public ContainerBuilder gauss(DecayFunction v) {
            this._kind = Kind.Gauss;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder gauss(Function<DecayFunction.Builder, ObjectBuilder<DecayFunction>> fn) {
            return this.gauss(fn.apply(new DecayFunction.Builder()).build());
        }

        public ContainerBuilder linear(DecayFunction v) {
            this._kind = Kind.Linear;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder linear(Function<DecayFunction.Builder, ObjectBuilder<DecayFunction>> fn) {
            return this.linear(fn.apply(new DecayFunction.Builder()).build());
        }

        public ContainerBuilder randomScore(RandomScoreFunction v) {
            this._kind = Kind.RandomScore;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder randomScore(Function<RandomScoreFunction.Builder, ObjectBuilder<RandomScoreFunction>> fn) {
            return this.randomScore(fn.apply(new RandomScoreFunction.Builder()).build());
        }

        public ContainerBuilder scriptScore(ScriptScoreFunction v) {
            this._kind = Kind.ScriptScore;
            this._value = v;
            return new ContainerBuilder();
        }

        public ContainerBuilder scriptScore(Function<ScriptScoreFunction.Builder, ObjectBuilder<ScriptScoreFunction>> fn) {
            return this.scriptScore(fn.apply(new ScriptScoreFunction.Builder()).build());
        }

        public FunctionScore build() {
            _checkSingleUse();
            return new FunctionScore(this);
        }

        public class ContainerBuilder implements ObjectBuilder<FunctionScore> {
            private ContainerBuilder() {}

            /**
             * API name: {@code filter}
             */
            @Nonnull
            public final ContainerBuilder filter(@Nullable Query value) {
                Builder.this.filter = value;
                return this;
            }

            /**
             * API name: {@code filter}
             */
            @Nonnull
            public final ContainerBuilder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
                return filter(fn.apply(new Query.Builder()).build());
            }

            /**
             * API name: {@code weight}
             */
            @Nonnull
            public final ContainerBuilder weight(@Nullable Float value) {
                Builder.this.weight = value;
                return this;
            }

            @Override
            public FunctionScore build() {
                return Builder.this.build();
            }
        }
    }

    protected static void setupFunctionScoreDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::filter, Query._DESERIALIZER, "filter");
        op.add(Builder::weight, JsonpDeserializer.floatDeserializer(), "weight");
        op.add(Builder::exp, DecayFunction._DESERIALIZER, "exp");
        op.add(Builder::fieldValueFactor, FieldValueFactorScoreFunction._DESERIALIZER, "field_value_factor");
        op.add(Builder::gauss, DecayFunction._DESERIALIZER, "gauss");
        op.add(Builder::linear, DecayFunction._DESERIALIZER, "linear");
        op.add(Builder::randomScore, RandomScoreFunction._DESERIALIZER, "random_score");
        op.add(Builder::scriptScore, ScriptScoreFunction._DESERIALIZER, "script_score");
    }

    public static final JsonpDeserializer<FunctionScore> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FunctionScore::setupFunctionScoreDeserializer,
        Builder::build
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.weight);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FunctionScore other = (FunctionScore) o;
        return Objects.equals(this._kind, other._kind)
            && Objects.equals(this._value, other._value)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.weight, other.weight);
    }
}
