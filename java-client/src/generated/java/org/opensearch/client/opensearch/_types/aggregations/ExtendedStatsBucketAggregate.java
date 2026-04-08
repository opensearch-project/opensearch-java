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

// typedef: _types.aggregations.ExtendedStatsBucketAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExtendedStatsBucketAggregate
    implements
        AggregateVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<ExtendedStatsBucketAggregate.Builder, ExtendedStatsBucketAggregate> {

    @Nullable
    private final Double avg;

    @Nullable
    private final String avgAsString;

    private final long count;

    @Nullable
    private final Double max;

    @Nullable
    private final String maxAsString;

    @Nonnull
    private final Map<String, JsonData> meta;

    @Nullable
    private final Double min;

    @Nullable
    private final String minAsString;

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

    private final double sum;

    @Nullable
    private final String sumAsString;

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

    private ExtendedStatsBucketAggregate(Builder builder) {
        this.avg = builder.avg;
        this.avgAsString = builder.avgAsString;
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.max = builder.max;
        this.maxAsString = builder.maxAsString;
        this.meta = ApiTypeHelper.unmodifiable(builder.meta);
        this.min = builder.min;
        this.minAsString = builder.minAsString;
        this.stdDeviation = builder.stdDeviation;
        this.stdDeviationAsString = builder.stdDeviationAsString;
        this.stdDeviationBounds = builder.stdDeviationBounds;
        this.stdDeviationBoundsAsString = builder.stdDeviationBoundsAsString;
        this.stdDeviationPopulation = builder.stdDeviationPopulation;
        this.stdDeviationSampling = builder.stdDeviationSampling;
        this.sum = ApiTypeHelper.requireNonNull(builder.sum, this, "sum");
        this.sumAsString = builder.sumAsString;
        this.sumOfSquares = builder.sumOfSquares;
        this.sumOfSquaresAsString = builder.sumOfSquaresAsString;
        this.variance = builder.variance;
        this.varianceAsString = builder.varianceAsString;
        this.variancePopulation = builder.variancePopulation;
        this.variancePopulationAsString = builder.variancePopulationAsString;
        this.varianceSampling = builder.varianceSampling;
        this.varianceSamplingAsString = builder.varianceSamplingAsString;
    }

    public static ExtendedStatsBucketAggregate of(
        Function<ExtendedStatsBucketAggregate.Builder, ObjectBuilder<ExtendedStatsBucketAggregate>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.ExtendedStatsBucket;
    }

    /**
     * API name: {@code avg}
     */
    @Nullable
    public final Double avg() {
        return this.avg;
    }

    /**
     * API name: {@code avg_as_string}
     */
    @Nullable
    public final String avgAsString() {
        return this.avgAsString;
    }

    /**
     * Required - API name: {@code count}
     */
    public final long count() {
        return this.count;
    }

    /**
     * API name: {@code max}
     */
    @Nullable
    public final Double max() {
        return this.max;
    }

    /**
     * API name: {@code max_as_string}
     */
    @Nullable
    public final String maxAsString() {
        return this.maxAsString;
    }

    /**
     * API name: {@code meta}
     */
    @Nonnull
    public final Map<String, JsonData> meta() {
        return this.meta;
    }

    /**
     * API name: {@code min}
     */
    @Nullable
    public final Double min() {
        return this.min;
    }

    /**
     * API name: {@code min_as_string}
     */
    @Nullable
    public final String minAsString() {
        return this.minAsString;
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
     * Required - API name: {@code sum}
     */
    public final double sum() {
        return this.sum;
    }

    /**
     * API name: {@code sum_as_string}
     */
    @Nullable
    public final String sumAsString() {
        return this.sumAsString;
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
        if (this.avg != null) {
            generator.writeKey("avg");
            generator.write(this.avg);
        }

        if (this.avgAsString != null) {
            generator.writeKey("avg_as_string");
            generator.write(this.avgAsString);
        }

        generator.writeKey("count");
        generator.write(this.count);

        if (this.max != null) {
            generator.writeKey("max");
            generator.write(this.max);
        }

        if (this.maxAsString != null) {
            generator.writeKey("max_as_string");
            generator.write(this.maxAsString);
        }

        if (ApiTypeHelper.isDefined(this.meta)) {
            generator.writeKey("meta");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.meta.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.min != null) {
            generator.writeKey("min");
            generator.write(this.min);
        }

        if (this.minAsString != null) {
            generator.writeKey("min_as_string");
            generator.write(this.minAsString);
        }

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

        generator.writeKey("sum");
        generator.write(this.sum);

        if (this.sumAsString != null) {
            generator.writeKey("sum_as_string");
            generator.write(this.sumAsString);
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
     * Builder for {@link ExtendedStatsBucketAggregate}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExtendedStatsBucketAggregate> {
        @Nullable
        private Double avg;
        @Nullable
        private String avgAsString;
        private Long count;
        @Nullable
        private Double max;
        @Nullable
        private String maxAsString;
        @Nullable
        private Map<String, JsonData> meta;
        @Nullable
        private Double min;
        @Nullable
        private String minAsString;
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
        private Double sum;
        @Nullable
        private String sumAsString;
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

        public Builder() {}

        private Builder(ExtendedStatsBucketAggregate o) {
            this.avg = o.avg;
            this.avgAsString = o.avgAsString;
            this.count = o.count;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.meta = _mapCopy(o.meta);
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.stdDeviation = o.stdDeviation;
            this.stdDeviationAsString = o.stdDeviationAsString;
            this.stdDeviationBounds = o.stdDeviationBounds;
            this.stdDeviationBoundsAsString = o.stdDeviationBoundsAsString;
            this.stdDeviationPopulation = o.stdDeviationPopulation;
            this.stdDeviationSampling = o.stdDeviationSampling;
            this.sum = o.sum;
            this.sumAsString = o.sumAsString;
            this.sumOfSquares = o.sumOfSquares;
            this.sumOfSquaresAsString = o.sumOfSquaresAsString;
            this.variance = o.variance;
            this.varianceAsString = o.varianceAsString;
            this.variancePopulation = o.variancePopulation;
            this.variancePopulationAsString = o.variancePopulationAsString;
            this.varianceSampling = o.varianceSampling;
            this.varianceSamplingAsString = o.varianceSamplingAsString;
        }

        private Builder(Builder o) {
            this.avg = o.avg;
            this.avgAsString = o.avgAsString;
            this.count = o.count;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.meta = _mapCopy(o.meta);
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.stdDeviation = o.stdDeviation;
            this.stdDeviationAsString = o.stdDeviationAsString;
            this.stdDeviationBounds = o.stdDeviationBounds;
            this.stdDeviationBoundsAsString = o.stdDeviationBoundsAsString;
            this.stdDeviationPopulation = o.stdDeviationPopulation;
            this.stdDeviationSampling = o.stdDeviationSampling;
            this.sum = o.sum;
            this.sumAsString = o.sumAsString;
            this.sumOfSquares = o.sumOfSquares;
            this.sumOfSquaresAsString = o.sumOfSquaresAsString;
            this.variance = o.variance;
            this.varianceAsString = o.varianceAsString;
            this.variancePopulation = o.variancePopulation;
            this.variancePopulationAsString = o.variancePopulationAsString;
            this.varianceSampling = o.varianceSampling;
            this.varianceSamplingAsString = o.varianceSamplingAsString;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code avg}
         */
        @Nonnull
        public final Builder avg(@Nullable Double value) {
            this.avg = value;
            return this;
        }

        /**
         * API name: {@code avg_as_string}
         */
        @Nonnull
        public final Builder avgAsString(@Nullable String value) {
            this.avgAsString = value;
            return this;
        }

        /**
         * Required - API name: {@code count}
         */
        @Nonnull
        public final Builder count(long value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final Builder max(@Nullable Double value) {
            this.max = value;
            return this;
        }

        /**
         * API name: {@code max_as_string}
         */
        @Nonnull
        public final Builder maxAsString(@Nullable String value) {
            this.maxAsString = value;
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(Map<String, JsonData> map) {
            this.meta = _mapPutAll(this.meta, map);
            return this;
        }

        /**
         * API name: {@code meta}
         *
         * <p>
         * Adds an entry to <code>meta</code>.
         * </p>
         */
        @Nonnull
        public final Builder meta(String key, JsonData value) {
            this.meta = _mapPut(this.meta, key, value);
            return this;
        }

        /**
         * API name: {@code min}
         */
        @Nonnull
        public final Builder min(@Nullable Double value) {
            this.min = value;
            return this;
        }

        /**
         * API name: {@code min_as_string}
         */
        @Nonnull
        public final Builder minAsString(@Nullable String value) {
            this.minAsString = value;
            return this;
        }

        /**
         * API name: {@code std_deviation}
         */
        @Nonnull
        public final Builder stdDeviation(@Nullable Double value) {
            this.stdDeviation = value;
            return this;
        }

        /**
         * API name: {@code std_deviation_as_string}
         */
        @Nonnull
        public final Builder stdDeviationAsString(@Nullable String value) {
            this.stdDeviationAsString = value;
            return this;
        }

        /**
         * API name: {@code std_deviation_bounds}
         */
        @Nonnull
        public final Builder stdDeviationBounds(@Nullable StandardDeviationBounds value) {
            this.stdDeviationBounds = value;
            return this;
        }

        /**
         * API name: {@code std_deviation_bounds}
         */
        @Nonnull
        public final Builder stdDeviationBounds(Function<StandardDeviationBounds.Builder, ObjectBuilder<StandardDeviationBounds>> fn) {
            return stdDeviationBounds(fn.apply(new StandardDeviationBounds.Builder()).build());
        }

        /**
         * API name: {@code std_deviation_bounds_as_string}
         */
        @Nonnull
        public final Builder stdDeviationBoundsAsString(@Nullable StandardDeviationBoundsAsString value) {
            this.stdDeviationBoundsAsString = value;
            return this;
        }

        /**
         * API name: {@code std_deviation_bounds_as_string}
         */
        @Nonnull
        public final Builder stdDeviationBoundsAsString(
            Function<StandardDeviationBoundsAsString.Builder, ObjectBuilder<StandardDeviationBoundsAsString>> fn
        ) {
            return stdDeviationBoundsAsString(fn.apply(new StandardDeviationBoundsAsString.Builder()).build());
        }

        /**
         * API name: {@code std_deviation_population}
         */
        @Nonnull
        public final Builder stdDeviationPopulation(@Nullable Double value) {
            this.stdDeviationPopulation = value;
            return this;
        }

        /**
         * API name: {@code std_deviation_sampling}
         */
        @Nonnull
        public final Builder stdDeviationSampling(@Nullable Double value) {
            this.stdDeviationSampling = value;
            return this;
        }

        /**
         * Required - API name: {@code sum}
         */
        @Nonnull
        public final Builder sum(double value) {
            this.sum = value;
            return this;
        }

        /**
         * API name: {@code sum_as_string}
         */
        @Nonnull
        public final Builder sumAsString(@Nullable String value) {
            this.sumAsString = value;
            return this;
        }

        /**
         * API name: {@code sum_of_squares}
         */
        @Nonnull
        public final Builder sumOfSquares(@Nullable Double value) {
            this.sumOfSquares = value;
            return this;
        }

        /**
         * API name: {@code sum_of_squares_as_string}
         */
        @Nonnull
        public final Builder sumOfSquaresAsString(@Nullable String value) {
            this.sumOfSquaresAsString = value;
            return this;
        }

        /**
         * API name: {@code variance}
         */
        @Nonnull
        public final Builder variance(@Nullable Double value) {
            this.variance = value;
            return this;
        }

        /**
         * API name: {@code variance_as_string}
         */
        @Nonnull
        public final Builder varianceAsString(@Nullable String value) {
            this.varianceAsString = value;
            return this;
        }

        /**
         * API name: {@code variance_population}
         */
        @Nonnull
        public final Builder variancePopulation(@Nullable Double value) {
            this.variancePopulation = value;
            return this;
        }

        /**
         * API name: {@code variance_population_as_string}
         */
        @Nonnull
        public final Builder variancePopulationAsString(@Nullable String value) {
            this.variancePopulationAsString = value;
            return this;
        }

        /**
         * API name: {@code variance_sampling}
         */
        @Nonnull
        public final Builder varianceSampling(@Nullable Double value) {
            this.varianceSampling = value;
            return this;
        }

        /**
         * API name: {@code variance_sampling_as_string}
         */
        @Nonnull
        public final Builder varianceSamplingAsString(@Nullable String value) {
            this.varianceSamplingAsString = value;
            return this;
        }

        /**
         * Builds a {@link ExtendedStatsBucketAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExtendedStatsBucketAggregate build() {
            _checkSingleUse();

            return new ExtendedStatsBucketAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExtendedStatsBucketAggregate}
     */
    public static final JsonpDeserializer<ExtendedStatsBucketAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExtendedStatsBucketAggregate::setupExtendedStatsBucketAggregateDeserializer
    );

    protected static void setupExtendedStatsBucketAggregateDeserializer(ObjectDeserializer<ExtendedStatsBucketAggregate.Builder> op) {
        op.add(Builder::avg, JsonpDeserializer.doubleDeserializer(), "avg");
        op.add(Builder::avgAsString, JsonpDeserializer.stringDeserializer(), "avg_as_string");
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(Builder::maxAsString, JsonpDeserializer.stringDeserializer(), "max_as_string");
        op.add(Builder::meta, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "meta");
        op.add(Builder::min, JsonpDeserializer.doubleDeserializer(), "min");
        op.add(Builder::minAsString, JsonpDeserializer.stringDeserializer(), "min_as_string");
        op.add(Builder::stdDeviation, JsonpDeserializer.doubleDeserializer(), "std_deviation");
        op.add(Builder::stdDeviationAsString, JsonpDeserializer.stringDeserializer(), "std_deviation_as_string");
        op.add(Builder::stdDeviationBounds, StandardDeviationBounds._DESERIALIZER, "std_deviation_bounds");
        op.add(Builder::stdDeviationBoundsAsString, StandardDeviationBoundsAsString._DESERIALIZER, "std_deviation_bounds_as_string");
        op.add(Builder::stdDeviationPopulation, JsonpDeserializer.doubleDeserializer(), "std_deviation_population");
        op.add(Builder::stdDeviationSampling, JsonpDeserializer.doubleDeserializer(), "std_deviation_sampling");
        op.add(Builder::sum, JsonpDeserializer.doubleDeserializer(), "sum");
        op.add(Builder::sumAsString, JsonpDeserializer.stringDeserializer(), "sum_as_string");
        op.add(Builder::sumOfSquares, JsonpDeserializer.doubleDeserializer(), "sum_of_squares");
        op.add(Builder::sumOfSquaresAsString, JsonpDeserializer.stringDeserializer(), "sum_of_squares_as_string");
        op.add(Builder::variance, JsonpDeserializer.doubleDeserializer(), "variance");
        op.add(Builder::varianceAsString, JsonpDeserializer.stringDeserializer(), "variance_as_string");
        op.add(Builder::variancePopulation, JsonpDeserializer.doubleDeserializer(), "variance_population");
        op.add(Builder::variancePopulationAsString, JsonpDeserializer.stringDeserializer(), "variance_population_as_string");
        op.add(Builder::varianceSampling, JsonpDeserializer.doubleDeserializer(), "variance_sampling");
        op.add(Builder::varianceSamplingAsString, JsonpDeserializer.stringDeserializer(), "variance_sampling_as_string");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.avg);
        result = 31 * result + Objects.hashCode(this.avgAsString);
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxAsString);
        result = 31 * result + Objects.hashCode(this.meta);
        result = 31 * result + Objects.hashCode(this.min);
        result = 31 * result + Objects.hashCode(this.minAsString);
        result = 31 * result + Objects.hashCode(this.stdDeviation);
        result = 31 * result + Objects.hashCode(this.stdDeviationAsString);
        result = 31 * result + Objects.hashCode(this.stdDeviationBounds);
        result = 31 * result + Objects.hashCode(this.stdDeviationBoundsAsString);
        result = 31 * result + Objects.hashCode(this.stdDeviationPopulation);
        result = 31 * result + Objects.hashCode(this.stdDeviationSampling);
        result = 31 * result + Double.hashCode(this.sum);
        result = 31 * result + Objects.hashCode(this.sumAsString);
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
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExtendedStatsBucketAggregate other = (ExtendedStatsBucketAggregate) o;
        return Objects.equals(this.avg, other.avg)
            && Objects.equals(this.avgAsString, other.avgAsString)
            && this.count == other.count
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.maxAsString, other.maxAsString)
            && Objects.equals(this.meta, other.meta)
            && Objects.equals(this.min, other.min)
            && Objects.equals(this.minAsString, other.minAsString)
            && Objects.equals(this.stdDeviation, other.stdDeviation)
            && Objects.equals(this.stdDeviationAsString, other.stdDeviationAsString)
            && Objects.equals(this.stdDeviationBounds, other.stdDeviationBounds)
            && Objects.equals(this.stdDeviationBoundsAsString, other.stdDeviationBoundsAsString)
            && Objects.equals(this.stdDeviationPopulation, other.stdDeviationPopulation)
            && Objects.equals(this.stdDeviationSampling, other.stdDeviationSampling)
            && this.sum == other.sum
            && Objects.equals(this.sumAsString, other.sumAsString)
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
