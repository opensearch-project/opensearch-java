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

// typedef: _types.aggregations.CardinalityAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CardinalityAggregation extends MetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<CardinalityAggregation.Builder, CardinalityAggregation> {

    @Nullable
    private final CardinalityExecutionMode executionHint;

    @Nullable
    private final Integer precisionThreshold;

    @Nullable
    private final Boolean rehash;

    // ---------------------------------------------------------------------------------------------

    private CardinalityAggregation(Builder builder) {
        super(builder);
        this.executionHint = builder.executionHint;
        this.precisionThreshold = builder.precisionThreshold;
        this.rehash = builder.rehash;
    }

    public static CardinalityAggregation of(Function<CardinalityAggregation.Builder, ObjectBuilder<CardinalityAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Cardinality;
    }

    /**
     * API name: {@code execution_hint}
     */
    @Nullable
    public final CardinalityExecutionMode executionHint() {
        return this.executionHint;
    }

    /**
     * A unique count below which counts are expected to be close to accurate. This allows to trade memory for accuracy.
     * <p>
     * API name: {@code precision_threshold}
     * </p>
     */
    @Nullable
    public final Integer precisionThreshold() {
        return this.precisionThreshold;
    }

    /**
     * API name: {@code rehash}
     */
    @Nullable
    public final Boolean rehash() {
        return this.rehash;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.executionHint != null) {
            generator.writeKey("execution_hint");
            this.executionHint.serialize(generator, mapper);
        }

        if (this.precisionThreshold != null) {
            generator.writeKey("precision_threshold");
            generator.write(this.precisionThreshold);
        }

        if (this.rehash != null) {
            generator.writeKey("rehash");
            generator.write(this.rehash);
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
     * Builder for {@link CardinalityAggregation}.
     */
    public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CardinalityAggregation> {
        @Nullable
        private CardinalityExecutionMode executionHint;
        @Nullable
        private Integer precisionThreshold;
        @Nullable
        private Boolean rehash;

        public Builder() {}

        private Builder(CardinalityAggregation o) {
            super(o);
            this.executionHint = o.executionHint;
            this.precisionThreshold = o.precisionThreshold;
            this.rehash = o.rehash;
        }

        private Builder(Builder o) {
            super(o);
            this.executionHint = o.executionHint;
            this.precisionThreshold = o.precisionThreshold;
            this.rehash = o.rehash;
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
         * API name: {@code execution_hint}
         */
        @Nonnull
        public final Builder executionHint(@Nullable CardinalityExecutionMode value) {
            this.executionHint = value;
            return this;
        }

        /**
         * A unique count below which counts are expected to be close to accurate. This allows to trade memory for accuracy.
         * <p>
         * API name: {@code precision_threshold}
         * </p>
         */
        @Nonnull
        public final Builder precisionThreshold(@Nullable Integer value) {
            this.precisionThreshold = value;
            return this;
        }

        /**
         * API name: {@code rehash}
         */
        @Nonnull
        public final Builder rehash(@Nullable Boolean value) {
            this.rehash = value;
            return this;
        }

        /**
         * Builds a {@link CardinalityAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CardinalityAggregation build() {
            _checkSingleUse();

            return new CardinalityAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CardinalityAggregation}
     */
    public static final JsonpDeserializer<CardinalityAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CardinalityAggregation::setupCardinalityAggregationDeserializer
    );

    protected static void setupCardinalityAggregationDeserializer(ObjectDeserializer<CardinalityAggregation.Builder> op) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(Builder::executionHint, CardinalityExecutionMode._DESERIALIZER, "execution_hint");
        op.add(Builder::precisionThreshold, JsonpDeserializer.integerDeserializer(), "precision_threshold");
        op.add(Builder::rehash, JsonpDeserializer.booleanDeserializer(), "rehash");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.executionHint);
        result = 31 * result + Objects.hashCode(this.precisionThreshold);
        result = 31 * result + Objects.hashCode(this.rehash);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CardinalityAggregation other = (CardinalityAggregation) o;
        return Objects.equals(this.executionHint, other.executionHint)
            && Objects.equals(this.precisionThreshold, other.precisionThreshold)
            && Objects.equals(this.rehash, other.rehash);
    }
}
