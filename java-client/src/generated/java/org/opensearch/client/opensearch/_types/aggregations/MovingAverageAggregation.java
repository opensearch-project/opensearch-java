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

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.aggregations.MovingAverageAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MovingAverageAggregation
    implements
        TaggedUnion<MovingAverageAggregation.Kind, MovingAverageAggregationVariant>,
        AggregationVariant,
        PlainJsonSerializable {
    /**
     * {@link MovingAverageAggregation} variant kinds.
     */
    public enum Kind implements JsonEnum {
        Ewma("ewma"),
        Holt("holt"),
        HoltWinters("holt_winters"),
        Linear("linear"),
        Simple("simple");

        private final String jsonValue;

        Kind(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        @Override
        public String jsonValue() {
            return jsonValue;
        }
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.MovingAvg;
    }

    private final Kind _kind;
    private final MovingAverageAggregationVariant _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final MovingAverageAggregationVariant _get() {
        return _value;
    }

    public MovingAverageAggregation(MovingAverageAggregationVariant value) {
        this._kind = ApiTypeHelper.requireNonNull(value._movingAverageAggregationKind(), this, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(value, this, "<variant value>");
    }

    private MovingAverageAggregation(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static MovingAverageAggregation of(Function<MovingAverageAggregation.Builder, ObjectBuilder<MovingAverageAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code ewma}?
     */
    public boolean isEwma() {
        return _kind == Kind.Ewma;
    }

    /**
     * Get the {@code ewma} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code ewma} kind.
     */
    public EwmaMovingAverageAggregation ewma() {
        return TaggedUnionUtils.get(this, Kind.Ewma);
    }

    /**
     * Is this variant instance of kind {@code holt}?
     */
    public boolean isHolt() {
        return _kind == Kind.Holt;
    }

    /**
     * Get the {@code holt} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code holt} kind.
     */
    public HoltMovingAverageAggregation holt() {
        return TaggedUnionUtils.get(this, Kind.Holt);
    }

    /**
     * Is this variant instance of kind {@code holt_winters}?
     */
    public boolean isHoltWinters() {
        return _kind == Kind.HoltWinters;
    }

    /**
     * Get the {@code holt_winters} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code holt_winters} kind.
     */
    public HoltWintersMovingAverageAggregation holtWinters() {
        return TaggedUnionUtils.get(this, Kind.HoltWinters);
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
    public LinearMovingAverageAggregation linear() {
        return TaggedUnionUtils.get(this, Kind.Linear);
    }

    /**
     * Is this variant instance of kind {@code simple}?
     */
    public boolean isSimple() {
        return _kind == Kind.Simple;
    }

    /**
     * Get the {@code simple} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code simple} kind.
     */
    public SimpleMovingAverageAggregation simple() {
        return TaggedUnionUtils.get(this, Kind.Simple);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        mapper.serialize(_value, generator);
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<MovingAverageAggregation> {
        private Kind _kind;
        private MovingAverageAggregationVariant _value;

        public Builder() {}

        private Builder(MovingAverageAggregation o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<MovingAverageAggregation> ewma(EwmaMovingAverageAggregation v) {
            this._kind = Kind.Ewma;
            this._value = v;
            return this;
        }

        public ObjectBuilder<MovingAverageAggregation> ewma(
            Function<EwmaMovingAverageAggregation.Builder, ObjectBuilder<EwmaMovingAverageAggregation>> fn
        ) {
            return this.ewma(fn.apply(new EwmaMovingAverageAggregation.Builder()).build());
        }

        public ObjectBuilder<MovingAverageAggregation> holt(HoltMovingAverageAggregation v) {
            this._kind = Kind.Holt;
            this._value = v;
            return this;
        }

        public ObjectBuilder<MovingAverageAggregation> holt(
            Function<HoltMovingAverageAggregation.Builder, ObjectBuilder<HoltMovingAverageAggregation>> fn
        ) {
            return this.holt(fn.apply(new HoltMovingAverageAggregation.Builder()).build());
        }

        public ObjectBuilder<MovingAverageAggregation> holtWinters(HoltWintersMovingAverageAggregation v) {
            this._kind = Kind.HoltWinters;
            this._value = v;
            return this;
        }

        public ObjectBuilder<MovingAverageAggregation> holtWinters(
            Function<HoltWintersMovingAverageAggregation.Builder, ObjectBuilder<HoltWintersMovingAverageAggregation>> fn
        ) {
            return this.holtWinters(fn.apply(new HoltWintersMovingAverageAggregation.Builder()).build());
        }

        public ObjectBuilder<MovingAverageAggregation> linear(LinearMovingAverageAggregation v) {
            this._kind = Kind.Linear;
            this._value = v;
            return this;
        }

        public ObjectBuilder<MovingAverageAggregation> linear(
            Function<LinearMovingAverageAggregation.Builder, ObjectBuilder<LinearMovingAverageAggregation>> fn
        ) {
            return this.linear(fn.apply(new LinearMovingAverageAggregation.Builder()).build());
        }

        public ObjectBuilder<MovingAverageAggregation> simple(SimpleMovingAverageAggregation v) {
            this._kind = Kind.Simple;
            this._value = v;
            return this;
        }

        public ObjectBuilder<MovingAverageAggregation> simple(
            Function<SimpleMovingAverageAggregation.Builder, ObjectBuilder<SimpleMovingAverageAggregation>> fn
        ) {
            return this.simple(fn.apply(new SimpleMovingAverageAggregation.Builder()).build());
        }

        @Override
        public MovingAverageAggregation build() {
            _checkSingleUse();
            return new MovingAverageAggregation(this);
        }
    }

    protected static void setupMovingAverageAggregationDeserializer(ObjectDeserializer<Builder> op) {
        op.add(Builder::ewma, EwmaMovingAverageAggregation._DESERIALIZER, "ewma");
        op.add(Builder::holt, HoltMovingAverageAggregation._DESERIALIZER, "holt");
        op.add(Builder::holtWinters, HoltWintersMovingAverageAggregation._DESERIALIZER, "holt_winters");
        op.add(Builder::linear, LinearMovingAverageAggregation._DESERIALIZER, "linear");
        op.add(Builder::simple, SimpleMovingAverageAggregation._DESERIALIZER, "simple");
        op.setTypeProperty("model", null);
    }

    public static final JsonpDeserializer<MovingAverageAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MovingAverageAggregation::setupMovingAverageAggregationDeserializer,
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
        MovingAverageAggregation other = (MovingAverageAggregation) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
