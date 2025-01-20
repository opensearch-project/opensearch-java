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
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.WeightedAverageAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WeightedAverageAggregation extends AggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<WeightedAverageAggregation.Builder, WeightedAverageAggregation> {

    @Nullable
    private final String format;

    @Nullable
    private final WeightedAverageValue value;

    @Nullable
    private final ValueType valueType;

    @Nullable
    private final WeightedAverageValue weight;

    // ---------------------------------------------------------------------------------------------

    private WeightedAverageAggregation(Builder builder) {
        super(builder);
        this.format = builder.format;
        this.value = builder.value;
        this.valueType = builder.valueType;
        this.weight = builder.weight;
    }

    public static WeightedAverageAggregation of(
        Function<WeightedAverageAggregation.Builder, ObjectBuilder<WeightedAverageAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.WeightedAvg;
    }

    /**
     * A numeric response formatter.
     * <p>
     * API name: {@code format}
     * </p>
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code value}
     */
    @Nullable
    public final WeightedAverageValue value() {
        return this.value;
    }

    /**
     * API name: {@code value_type}
     */
    @Nullable
    public final ValueType valueType() {
        return this.valueType;
    }

    /**
     * API name: {@code weight}
     */
    @Nullable
    public final WeightedAverageValue weight() {
        return this.weight;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.value != null) {
            generator.writeKey("value");
            this.value.serialize(generator, mapper);
        }

        if (this.valueType != null) {
            generator.writeKey("value_type");
            this.valueType.serialize(generator, mapper);
        }

        if (this.weight != null) {
            generator.writeKey("weight");
            this.weight.serialize(generator, mapper);
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
     * Builder for {@link WeightedAverageAggregation}.
     */
    public static class Builder extends AggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, WeightedAverageAggregation> {
        @Nullable
        private String format;
        @Nullable
        private WeightedAverageValue value;
        @Nullable
        private ValueType valueType;
        @Nullable
        private WeightedAverageValue weight;

        public Builder() {}

        private Builder(WeightedAverageAggregation o) {
            super(o);
            this.format = o.format;
            this.value = o.value;
            this.valueType = o.valueType;
            this.weight = o.weight;
        }

        private Builder(Builder o) {
            super(o);
            this.format = o.format;
            this.value = o.value;
            this.valueType = o.valueType;
            this.weight = o.weight;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * A numeric response formatter.
         * <p>
         * API name: {@code format}
         * </p>
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code value}
         */
        @Nonnull
        public final Builder value(@Nullable WeightedAverageValue value) {
            this.value = value;
            return this;
        }

        /**
         * API name: {@code value}
         */
        @Nonnull
        public final Builder value(Function<WeightedAverageValue.Builder, ObjectBuilder<WeightedAverageValue>> fn) {
            return value(fn.apply(new WeightedAverageValue.Builder()).build());
        }

        /**
         * API name: {@code value_type}
         */
        @Nonnull
        public final Builder valueType(@Nullable ValueType value) {
            this.valueType = value;
            return this;
        }

        /**
         * API name: {@code weight}
         */
        @Nonnull
        public final Builder weight(@Nullable WeightedAverageValue value) {
            this.weight = value;
            return this;
        }

        /**
         * API name: {@code weight}
         */
        @Nonnull
        public final Builder weight(Function<WeightedAverageValue.Builder, ObjectBuilder<WeightedAverageValue>> fn) {
            return weight(fn.apply(new WeightedAverageValue.Builder()).build());
        }

        /**
         * Builds a {@link WeightedAverageAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public WeightedAverageAggregation build() {
            _checkSingleUse();

            return new WeightedAverageAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link WeightedAverageAggregation}
     */
    public static final JsonpDeserializer<WeightedAverageAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        WeightedAverageAggregation::setupWeightedAverageAggregationDeserializer
    );

    protected static void setupWeightedAverageAggregationDeserializer(ObjectDeserializer<WeightedAverageAggregation.Builder> op) {
        setupAggregationBaseDeserializer(op);
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::value, WeightedAverageValue._DESERIALIZER, "value");
        op.add(Builder::valueType, ValueType._DESERIALIZER, "value_type");
        op.add(Builder::weight, WeightedAverageValue._DESERIALIZER, "weight");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.value);
        result = 31 * result + Objects.hashCode(this.valueType);
        result = 31 * result + Objects.hashCode(this.weight);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WeightedAverageAggregation other = (WeightedAverageAggregation) o;
        return Objects.equals(this.format, other.format)
            && Objects.equals(this.value, other.value)
            && Objects.equals(this.valueType, other.valueType)
            && Objects.equals(this.weight, other.weight);
    }
}
