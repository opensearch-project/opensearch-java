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
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.aggregations.ExtendedStatsAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class ExtendedStatsAggregateBase extends StatsAggregateBase {

    @Nullable
    private final Double stdDeviation;

    @Nullable
    private final String stdDeviationAsString;

    @Nullable
    private final StandardDeviationBounds stdDeviationBounds;

    @Nullable
    private final StandardDeviationBoundsAsString stdDeviationBoundsAsString;

    @Nullable
    private final Double stdDeviationPopulation;

    @Nullable
    private final Double stdDeviationSampling;

    @Nullable
    private final Double sumOfSquares;

    @Nullable
    private final String sumOfSquaresAsString;

    @Nullable
    private final Double variance;

    @Nullable
    private final String varianceAsString;

    @Nullable
    private final Double variancePopulation;

    @Nullable
    private final String variancePopulationAsString;

    @Nullable
    private final Double varianceSampling;

    @Nullable
    private final String varianceSamplingAsString;

    // ---------------------------------------------------------------------------------------------

    protected ExtendedStatsAggregateBase(AbstractBuilder<?> builder) {
        super(builder);
        this.stdDeviation = builder.stdDeviation;
        this.stdDeviationAsString = builder.stdDeviationAsString;
        this.stdDeviationBounds = builder.stdDeviationBounds;
        this.stdDeviationBoundsAsString = builder.stdDeviationBoundsAsString;
        this.stdDeviationPopulation = builder.stdDeviationPopulation;
        this.stdDeviationSampling = builder.stdDeviationSampling;
        this.sumOfSquares = builder.sumOfSquares;
        this.sumOfSquaresAsString = builder.sumOfSquaresAsString;
        this.variance = builder.variance;
        this.varianceAsString = builder.varianceAsString;
        this.variancePopulation = builder.variancePopulation;
        this.variancePopulationAsString = builder.variancePopulationAsString;
        this.varianceSampling = builder.varianceSampling;
        this.varianceSamplingAsString = builder.varianceSamplingAsString;
    }

    /**
     * API name: {@code std_deviation}
     */
    @Nullable
    public final Double stdDeviation() {
        return this.stdDeviation;
    }

    /**
     * API name: {@code std_deviation_as_string}
     */
    @Nullable
    public final String stdDeviationAsString() {
        return this.stdDeviationAsString;
    }

    /**
     * API name: {@code std_deviation_bounds}
     */
    @Nullable
    public final StandardDeviationBounds stdDeviationBounds() {
        return this.stdDeviationBounds;
    }

    /**
     * API name: {@code std_deviation_bounds_as_string}
     */
    @Nullable
    public final StandardDeviationBoundsAsString stdDeviationBoundsAsString() {
        return this.stdDeviationBoundsAsString;
    }

    /**
     * API name: {@code std_deviation_population}
     */
    @Nullable
    public final Double stdDeviationPopulation() {
        return this.stdDeviationPopulation;
    }

    /**
     * API name: {@code std_deviation_sampling}
     */
    @Nullable
    public final Double stdDeviationSampling() {
        return this.stdDeviationSampling;
    }

    /**
     * API name: {@code sum_of_squares}
     */
    @Nullable
    public final Double sumOfSquares() {
        return this.sumOfSquares;
    }

    /**
     * API name: {@code sum_of_squares_as_string}
     */
    @Nullable
    public final String sumOfSquaresAsString() {
        return this.sumOfSquaresAsString;
    }

    /**
     * API name: {@code variance}
     */
    @Nullable
    public final Double variance() {
        return this.variance;
    }

    /**
     * API name: {@code variance_as_string}
     */
    @Nullable
    public final String varianceAsString() {
        return this.varianceAsString;
    }

    /**
     * API name: {@code variance_population}
     */
    @Nullable
    public final Double variancePopulation() {
        return this.variancePopulation;
    }

    /**
     * API name: {@code variance_population_as_string}
     */
    @Nullable
    public final String variancePopulationAsString() {
        return this.variancePopulationAsString;
    }

    /**
     * API name: {@code variance_sampling}
     */
    @Nullable
    public final Double varianceSampling() {
        return this.varianceSampling;
    }

    /**
     * API name: {@code variance_sampling_as_string}
     */
    @Nullable
    public final String varianceSamplingAsString() {
        return this.varianceSamplingAsString;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.stdDeviation != null) {
            generator.writeKey("std_deviation");
            generator.write(this.stdDeviation);
        }

        if (this.stdDeviationAsString != null) {
            generator.writeKey("std_deviation_as_string");
            generator.write(this.stdDeviationAsString);
        }

        if (this.stdDeviationBounds != null) {
            generator.writeKey("std_deviation_bounds");
            this.stdDeviationBounds.serialize(generator, mapper);
        }

        if (this.stdDeviationBoundsAsString != null) {
            generator.writeKey("std_deviation_bounds_as_string");
            this.stdDeviationBoundsAsString.serialize(generator, mapper);
        }

        if (this.stdDeviationPopulation != null) {
            generator.writeKey("std_deviation_population");
            generator.write(this.stdDeviationPopulation);
        }

        if (this.stdDeviationSampling != null) {
            generator.writeKey("std_deviation_sampling");
            generator.write(this.stdDeviationSampling);
        }

        if (this.sumOfSquares != null) {
            generator.writeKey("sum_of_squares");
            generator.write(this.sumOfSquares);
        }

        if (this.sumOfSquaresAsString != null) {
            generator.writeKey("sum_of_squares_as_string");
            generator.write(this.sumOfSquaresAsString);
        }

        if (this.variance != null) {
            generator.writeKey("variance");
            generator.write(this.variance);
        }

        if (this.varianceAsString != null) {
            generator.writeKey("variance_as_string");
            generator.write(this.varianceAsString);
        }

        if (this.variancePopulation != null) {
            generator.writeKey("variance_population");
            generator.write(this.variancePopulation);
        }

        if (this.variancePopulationAsString != null) {
            generator.writeKey("variance_population_as_string");
            generator.write(this.variancePopulationAsString);
        }

        if (this.varianceSampling != null) {
            generator.writeKey("variance_sampling");
            generator.write(this.varianceSampling);
        }

        if (this.varianceSamplingAsString != null) {
            generator.writeKey("variance_sampling_as_string");
            generator.write(this.varianceSamplingAsString);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends StatsAggregateBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private Double stdDeviation;
        @Nullable
        private String stdDeviationAsString;
        @Nullable
        private StandardDeviationBounds stdDeviationBounds;
        @Nullable
        private StandardDeviationBoundsAsString stdDeviationBoundsAsString;
        @Nullable
        private Double stdDeviationPopulation;
        @Nullable
        private Double stdDeviationSampling;
        @Nullable
        private Double sumOfSquares;
        @Nullable
        private String sumOfSquaresAsString;
        @Nullable
        private Double variance;
        @Nullable
        private String varianceAsString;
        @Nullable
        private Double variancePopulation;
        @Nullable
        private String variancePopulationAsString;
        @Nullable
        private Double varianceSampling;
        @Nullable
        private String varianceSamplingAsString;

        protected AbstractBuilder() {}

        protected AbstractBuilder(ExtendedStatsAggregateBase o) {
            super(o);
            this.stdDeviation = o.stdDeviation;
            this.stdDeviationAsString = o.stdDeviationAsString;
            this.stdDeviationBounds = o.stdDeviationBounds;
            this.stdDeviationBoundsAsString = o.stdDeviationBoundsAsString;
            this.stdDeviationPopulation = o.stdDeviationPopulation;
            this.stdDeviationSampling = o.stdDeviationSampling;
            this.sumOfSquares = o.sumOfSquares;
            this.sumOfSquaresAsString = o.sumOfSquaresAsString;
            this.variance = o.variance;
            this.varianceAsString = o.varianceAsString;
            this.variancePopulation = o.variancePopulation;
            this.variancePopulationAsString = o.variancePopulationAsString;
            this.varianceSampling = o.varianceSampling;
            this.varianceSamplingAsString = o.varianceSamplingAsString;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.stdDeviation = o.stdDeviation;
            this.stdDeviationAsString = o.stdDeviationAsString;
            this.stdDeviationBounds = o.stdDeviationBounds;
            this.stdDeviationBoundsAsString = o.stdDeviationBoundsAsString;
            this.stdDeviationPopulation = o.stdDeviationPopulation;
            this.stdDeviationSampling = o.stdDeviationSampling;
            this.sumOfSquares = o.sumOfSquares;
            this.sumOfSquaresAsString = o.sumOfSquaresAsString;
            this.variance = o.variance;
            this.varianceAsString = o.varianceAsString;
            this.variancePopulation = o.variancePopulation;
            this.variancePopulationAsString = o.variancePopulationAsString;
            this.varianceSampling = o.varianceSampling;
            this.varianceSamplingAsString = o.varianceSamplingAsString;
        }

        /**
         * API name: {@code std_deviation}
         */
        @Nonnull
        public final BuilderT stdDeviation(@Nullable Double value) {
            this.stdDeviation = value;
            return self();
        }

        /**
         * API name: {@code std_deviation_as_string}
         */
        @Nonnull
        public final BuilderT stdDeviationAsString(@Nullable String value) {
            this.stdDeviationAsString = value;
            return self();
        }

        /**
         * API name: {@code std_deviation_bounds}
         */
        @Nonnull
        public final BuilderT stdDeviationBounds(@Nullable StandardDeviationBounds value) {
            this.stdDeviationBounds = value;
            return self();
        }

        /**
         * API name: {@code std_deviation_bounds}
         */
        @Nonnull
        public final BuilderT stdDeviationBounds(Function<StandardDeviationBounds.Builder, ObjectBuilder<StandardDeviationBounds>> fn) {
            return stdDeviationBounds(fn.apply(new StandardDeviationBounds.Builder()).build());
        }

        /**
         * API name: {@code std_deviation_bounds_as_string}
         */
        @Nonnull
        public final BuilderT stdDeviationBoundsAsString(@Nullable StandardDeviationBoundsAsString value) {
            this.stdDeviationBoundsAsString = value;
            return self();
        }

        /**
         * API name: {@code std_deviation_bounds_as_string}
         */
        @Nonnull
        public final BuilderT stdDeviationBoundsAsString(
            Function<StandardDeviationBoundsAsString.Builder, ObjectBuilder<StandardDeviationBoundsAsString>> fn
        ) {
            return stdDeviationBoundsAsString(fn.apply(new StandardDeviationBoundsAsString.Builder()).build());
        }

        /**
         * API name: {@code std_deviation_population}
         */
        @Nonnull
        public final BuilderT stdDeviationPopulation(@Nullable Double value) {
            this.stdDeviationPopulation = value;
            return self();
        }

        /**
         * API name: {@code std_deviation_sampling}
         */
        @Nonnull
        public final BuilderT stdDeviationSampling(@Nullable Double value) {
            this.stdDeviationSampling = value;
            return self();
        }

        /**
         * API name: {@code sum_of_squares}
         */
        @Nonnull
        public final BuilderT sumOfSquares(@Nullable Double value) {
            this.sumOfSquares = value;
            return self();
        }

        /**
         * API name: {@code sum_of_squares_as_string}
         */
        @Nonnull
        public final BuilderT sumOfSquaresAsString(@Nullable String value) {
            this.sumOfSquaresAsString = value;
            return self();
        }

        /**
         * API name: {@code variance}
         */
        @Nonnull
        public final BuilderT variance(@Nullable Double value) {
            this.variance = value;
            return self();
        }

        /**
         * API name: {@code variance_as_string}
         */
        @Nonnull
        public final BuilderT varianceAsString(@Nullable String value) {
            this.varianceAsString = value;
            return self();
        }

        /**
         * API name: {@code variance_population}
         */
        @Nonnull
        public final BuilderT variancePopulation(@Nullable Double value) {
            this.variancePopulation = value;
            return self();
        }

        /**
         * API name: {@code variance_population_as_string}
         */
        @Nonnull
        public final BuilderT variancePopulationAsString(@Nullable String value) {
            this.variancePopulationAsString = value;
            return self();
        }

        /**
         * API name: {@code variance_sampling}
         */
        @Nonnull
        public final BuilderT varianceSampling(@Nullable Double value) {
            this.varianceSampling = value;
            return self();
        }

        /**
         * API name: {@code variance_sampling_as_string}
         */
        @Nonnull
        public final BuilderT varianceSamplingAsString(@Nullable String value) {
            this.varianceSamplingAsString = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupExtendedStatsAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupStatsAggregateBaseDeserializer(op);
        op.add(AbstractBuilder::stdDeviation, JsonpDeserializer.doubleDeserializer(), "std_deviation");
        op.add(AbstractBuilder::stdDeviationAsString, JsonpDeserializer.stringDeserializer(), "std_deviation_as_string");
        op.add(AbstractBuilder::stdDeviationBounds, StandardDeviationBounds._DESERIALIZER, "std_deviation_bounds");
        op.add(
            AbstractBuilder::stdDeviationBoundsAsString,
            StandardDeviationBoundsAsString._DESERIALIZER,
            "std_deviation_bounds_as_string"
        );
        op.add(AbstractBuilder::stdDeviationPopulation, JsonpDeserializer.doubleDeserializer(), "std_deviation_population");
        op.add(AbstractBuilder::stdDeviationSampling, JsonpDeserializer.doubleDeserializer(), "std_deviation_sampling");
        op.add(AbstractBuilder::sumOfSquares, JsonpDeserializer.doubleDeserializer(), "sum_of_squares");
        op.add(AbstractBuilder::sumOfSquaresAsString, JsonpDeserializer.stringDeserializer(), "sum_of_squares_as_string");
        op.add(AbstractBuilder::variance, JsonpDeserializer.doubleDeserializer(), "variance");
        op.add(AbstractBuilder::varianceAsString, JsonpDeserializer.stringDeserializer(), "variance_as_string");
        op.add(AbstractBuilder::variancePopulation, JsonpDeserializer.doubleDeserializer(), "variance_population");
        op.add(AbstractBuilder::variancePopulationAsString, JsonpDeserializer.stringDeserializer(), "variance_population_as_string");
        op.add(AbstractBuilder::varianceSampling, JsonpDeserializer.doubleDeserializer(), "variance_sampling");
        op.add(AbstractBuilder::varianceSamplingAsString, JsonpDeserializer.stringDeserializer(), "variance_sampling_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.stdDeviation);
        result = 31 * result + Objects.hashCode(this.stdDeviationAsString);
        result = 31 * result + Objects.hashCode(this.stdDeviationBounds);
        result = 31 * result + Objects.hashCode(this.stdDeviationBoundsAsString);
        result = 31 * result + Objects.hashCode(this.stdDeviationPopulation);
        result = 31 * result + Objects.hashCode(this.stdDeviationSampling);
        result = 31 * result + Objects.hashCode(this.sumOfSquares);
        result = 31 * result + Objects.hashCode(this.sumOfSquaresAsString);
        result = 31 * result + Objects.hashCode(this.variance);
        result = 31 * result + Objects.hashCode(this.varianceAsString);
        result = 31 * result + Objects.hashCode(this.variancePopulation);
        result = 31 * result + Objects.hashCode(this.variancePopulationAsString);
        result = 31 * result + Objects.hashCode(this.varianceSampling);
        result = 31 * result + Objects.hashCode(this.varianceSamplingAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExtendedStatsAggregateBase other = (ExtendedStatsAggregateBase) o;
        return Objects.equals(this.stdDeviation, other.stdDeviation)
            && Objects.equals(this.stdDeviationAsString, other.stdDeviationAsString)
            && Objects.equals(this.stdDeviationBounds, other.stdDeviationBounds)
            && Objects.equals(this.stdDeviationBoundsAsString, other.stdDeviationBoundsAsString)
            && Objects.equals(this.stdDeviationPopulation, other.stdDeviationPopulation)
            && Objects.equals(this.stdDeviationSampling, other.stdDeviationSampling)
            && Objects.equals(this.sumOfSquares, other.sumOfSquares)
            && Objects.equals(this.sumOfSquaresAsString, other.sumOfSquaresAsString)
            && Objects.equals(this.variance, other.variance)
            && Objects.equals(this.varianceAsString, other.varianceAsString)
            && Objects.equals(this.variancePopulation, other.variancePopulation)
            && Objects.equals(this.variancePopulationAsString, other.variancePopulationAsString)
            && Objects.equals(this.varianceSampling, other.varianceSampling)
            && Objects.equals(this.varianceSamplingAsString, other.varianceSamplingAsString);
    }
}
