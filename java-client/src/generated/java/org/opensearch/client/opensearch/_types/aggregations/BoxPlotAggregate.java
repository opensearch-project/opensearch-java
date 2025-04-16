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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.BoxPlotAggregate

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BoxPlotAggregate extends AggregateBase
    implements
        AggregateVariant,
        ToCopyableBuilder<BoxPlotAggregate.Builder, BoxPlotAggregate> {

    private final double lower;

    @Nullable
    private final String lowerAsString;

    private final double max;

    @Nullable
    private final String maxAsString;

    private final double min;

    @Nullable
    private final String minAsString;

    private final double q1;

    @Nullable
    private final String q1AsString;

    private final double q2;

    @Nullable
    private final String q2AsString;

    private final double q3;

    @Nullable
    private final String q3AsString;

    private final double upper;

    @Nullable
    private final String upperAsString;

    // ---------------------------------------------------------------------------------------------

    private BoxPlotAggregate(Builder builder) {
        super(builder);
        this.lower = ApiTypeHelper.requireNonNull(builder.lower, this, "lower");
        this.lowerAsString = builder.lowerAsString;
        this.max = ApiTypeHelper.requireNonNull(builder.max, this, "max");
        this.maxAsString = builder.maxAsString;
        this.min = ApiTypeHelper.requireNonNull(builder.min, this, "min");
        this.minAsString = builder.minAsString;
        this.q1 = ApiTypeHelper.requireNonNull(builder.q1, this, "q1");
        this.q1AsString = builder.q1AsString;
        this.q2 = ApiTypeHelper.requireNonNull(builder.q2, this, "q2");
        this.q2AsString = builder.q2AsString;
        this.q3 = ApiTypeHelper.requireNonNull(builder.q3, this, "q3");
        this.q3AsString = builder.q3AsString;
        this.upper = ApiTypeHelper.requireNonNull(builder.upper, this, "upper");
        this.upperAsString = builder.upperAsString;
    }

    public static BoxPlotAggregate of(Function<BoxPlotAggregate.Builder, ObjectBuilder<BoxPlotAggregate>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregate} variant kind.
     */
    @Override
    public Aggregate.Kind _aggregateKind() {
        return Aggregate.Kind.BoxPlot;
    }

    /**
     * Required - API name: {@code lower}
     */
    public final double lower() {
        return this.lower;
    }

    /**
     * API name: {@code lower_as_string}
     */
    @Nullable
    public final String lowerAsString() {
        return this.lowerAsString;
    }

    /**
     * Required - API name: {@code max}
     */
    public final double max() {
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
     * Required - API name: {@code min}
     */
    public final double min() {
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
     * Required - API name: {@code q1}
     */
    public final double q1() {
        return this.q1;
    }

    /**
     * API name: {@code q1_as_string}
     */
    @Nullable
    public final String q1AsString() {
        return this.q1AsString;
    }

    /**
     * Required - API name: {@code q2}
     */
    public final double q2() {
        return this.q2;
    }

    /**
     * API name: {@code q2_as_string}
     */
    @Nullable
    public final String q2AsString() {
        return this.q2AsString;
    }

    /**
     * Required - API name: {@code q3}
     */
    public final double q3() {
        return this.q3;
    }

    /**
     * API name: {@code q3_as_string}
     */
    @Nullable
    public final String q3AsString() {
        return this.q3AsString;
    }

    /**
     * Required - API name: {@code upper}
     */
    public final double upper() {
        return this.upper;
    }

    /**
     * API name: {@code upper_as_string}
     */
    @Nullable
    public final String upperAsString() {
        return this.upperAsString;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("lower");
        generator.write(this.lower);

        if (this.lowerAsString != null) {
            generator.writeKey("lower_as_string");
            generator.write(this.lowerAsString);
        }

        generator.writeKey("max");
        generator.write(this.max);

        if (this.maxAsString != null) {
            generator.writeKey("max_as_string");
            generator.write(this.maxAsString);
        }

        generator.writeKey("min");
        generator.write(this.min);

        if (this.minAsString != null) {
            generator.writeKey("min_as_string");
            generator.write(this.minAsString);
        }

        generator.writeKey("q1");
        generator.write(this.q1);

        if (this.q1AsString != null) {
            generator.writeKey("q1_as_string");
            generator.write(this.q1AsString);
        }

        generator.writeKey("q2");
        generator.write(this.q2);

        if (this.q2AsString != null) {
            generator.writeKey("q2_as_string");
            generator.write(this.q2AsString);
        }

        generator.writeKey("q3");
        generator.write(this.q3);

        if (this.q3AsString != null) {
            generator.writeKey("q3_as_string");
            generator.write(this.q3AsString);
        }

        generator.writeKey("upper");
        generator.write(this.upper);

        if (this.upperAsString != null) {
            generator.writeKey("upper_as_string");
            generator.write(this.upperAsString);
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
     * Builder for {@link BoxPlotAggregate}.
     */
    public static class Builder extends AggregateBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, BoxPlotAggregate> {
        private Double lower;
        @Nullable
        private String lowerAsString;
        private Double max;
        @Nullable
        private String maxAsString;
        private Double min;
        @Nullable
        private String minAsString;
        private Double q1;
        @Nullable
        private String q1AsString;
        private Double q2;
        @Nullable
        private String q2AsString;
        private Double q3;
        @Nullable
        private String q3AsString;
        private Double upper;
        @Nullable
        private String upperAsString;

        public Builder() {}

        private Builder(BoxPlotAggregate o) {
            super(o);
            this.lower = o.lower;
            this.lowerAsString = o.lowerAsString;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.q1 = o.q1;
            this.q1AsString = o.q1AsString;
            this.q2 = o.q2;
            this.q2AsString = o.q2AsString;
            this.q3 = o.q3;
            this.q3AsString = o.q3AsString;
            this.upper = o.upper;
            this.upperAsString = o.upperAsString;
        }

        private Builder(Builder o) {
            super(o);
            this.lower = o.lower;
            this.lowerAsString = o.lowerAsString;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.q1 = o.q1;
            this.q1AsString = o.q1AsString;
            this.q2 = o.q2;
            this.q2AsString = o.q2AsString;
            this.q3 = o.q3;
            this.q3AsString = o.q3AsString;
            this.upper = o.upper;
            this.upperAsString = o.upperAsString;
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
         * Required - API name: {@code lower}
         */
        @Nonnull
        public final Builder lower(double value) {
            this.lower = value;
            return this;
        }

        /**
         * API name: {@code lower_as_string}
         */
        @Nonnull
        public final Builder lowerAsString(@Nullable String value) {
            this.lowerAsString = value;
            return this;
        }

        /**
         * Required - API name: {@code max}
         */
        @Nonnull
        public final Builder max(double value) {
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
         * Required - API name: {@code min}
         */
        @Nonnull
        public final Builder min(double value) {
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
         * Required - API name: {@code q1}
         */
        @Nonnull
        public final Builder q1(double value) {
            this.q1 = value;
            return this;
        }

        /**
         * API name: {@code q1_as_string}
         */
        @Nonnull
        public final Builder q1AsString(@Nullable String value) {
            this.q1AsString = value;
            return this;
        }

        /**
         * Required - API name: {@code q2}
         */
        @Nonnull
        public final Builder q2(double value) {
            this.q2 = value;
            return this;
        }

        /**
         * API name: {@code q2_as_string}
         */
        @Nonnull
        public final Builder q2AsString(@Nullable String value) {
            this.q2AsString = value;
            return this;
        }

        /**
         * Required - API name: {@code q3}
         */
        @Nonnull
        public final Builder q3(double value) {
            this.q3 = value;
            return this;
        }

        /**
         * API name: {@code q3_as_string}
         */
        @Nonnull
        public final Builder q3AsString(@Nullable String value) {
            this.q3AsString = value;
            return this;
        }

        /**
         * Required - API name: {@code upper}
         */
        @Nonnull
        public final Builder upper(double value) {
            this.upper = value;
            return this;
        }

        /**
         * API name: {@code upper_as_string}
         */
        @Nonnull
        public final Builder upperAsString(@Nullable String value) {
            this.upperAsString = value;
            return this;
        }

        /**
         * Builds a {@link BoxPlotAggregate}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BoxPlotAggregate build() {
            _checkSingleUse();

            return new BoxPlotAggregate(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BoxPlotAggregate}
     */
    public static final JsonpDeserializer<BoxPlotAggregate> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BoxPlotAggregate::setupBoxPlotAggregateDeserializer
    );

    protected static void setupBoxPlotAggregateDeserializer(ObjectDeserializer<BoxPlotAggregate.Builder> op) {
        setupAggregateBaseDeserializer(op);
        op.add(Builder::lower, JsonpDeserializer.doubleDeserializer(), "lower");
        op.add(Builder::lowerAsString, JsonpDeserializer.stringDeserializer(), "lower_as_string");
        op.add(Builder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(Builder::maxAsString, JsonpDeserializer.stringDeserializer(), "max_as_string");
        op.add(Builder::min, JsonpDeserializer.doubleDeserializer(), "min");
        op.add(Builder::minAsString, JsonpDeserializer.stringDeserializer(), "min_as_string");
        op.add(Builder::q1, JsonpDeserializer.doubleDeserializer(), "q1");
        op.add(Builder::q1AsString, JsonpDeserializer.stringDeserializer(), "q1_as_string");
        op.add(Builder::q2, JsonpDeserializer.doubleDeserializer(), "q2");
        op.add(Builder::q2AsString, JsonpDeserializer.stringDeserializer(), "q2_as_string");
        op.add(Builder::q3, JsonpDeserializer.doubleDeserializer(), "q3");
        op.add(Builder::q3AsString, JsonpDeserializer.stringDeserializer(), "q3_as_string");
        op.add(Builder::upper, JsonpDeserializer.doubleDeserializer(), "upper");
        op.add(Builder::upperAsString, JsonpDeserializer.stringDeserializer(), "upper_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(this.lower);
        result = 31 * result + Objects.hashCode(this.lowerAsString);
        result = 31 * result + Double.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxAsString);
        result = 31 * result + Double.hashCode(this.min);
        result = 31 * result + Objects.hashCode(this.minAsString);
        result = 31 * result + Double.hashCode(this.q1);
        result = 31 * result + Objects.hashCode(this.q1AsString);
        result = 31 * result + Double.hashCode(this.q2);
        result = 31 * result + Objects.hashCode(this.q2AsString);
        result = 31 * result + Double.hashCode(this.q3);
        result = 31 * result + Objects.hashCode(this.q3AsString);
        result = 31 * result + Double.hashCode(this.upper);
        result = 31 * result + Objects.hashCode(this.upperAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BoxPlotAggregate other = (BoxPlotAggregate) o;
        return this.lower == other.lower
            && Objects.equals(this.lowerAsString, other.lowerAsString)
            && this.max == other.max
            && Objects.equals(this.maxAsString, other.maxAsString)
            && this.min == other.min
            && Objects.equals(this.minAsString, other.minAsString)
            && this.q1 == other.q1
            && Objects.equals(this.q1AsString, other.q1AsString)
            && this.q2 == other.q2
            && Objects.equals(this.q2AsString, other.q2AsString)
            && this.q3 == other.q3
            && Objects.equals(this.q3AsString, other.q3AsString)
            && this.upper == other.upper
            && Objects.equals(this.upperAsString, other.upperAsString);
    }
}
