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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;

// typedef: _types.aggregations.StatsAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class StatsAggregateBase extends AggregateBase {

    @Nullable
    private final Double avg;

    @Nullable
    private final String avgAsString;

    private final long count;

    @Nullable
    private final Double max;

    @Nullable
    private final String maxAsString;

    @Nullable
    private final Double min;

    @Nullable
    private final String minAsString;

    private final double sum;

    @Nullable
    private final String sumAsString;

    // ---------------------------------------------------------------------------------------------

    protected StatsAggregateBase(AbstractBuilder<?> builder) {
        super(builder);
        this.avg = builder.avg;
        this.avgAsString = builder.avgAsString;
        this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count");
        this.max = builder.max;
        this.maxAsString = builder.maxAsString;
        this.min = builder.min;
        this.minAsString = builder.minAsString;
        this.sum = ApiTypeHelper.requireNonNull(builder.sum, this, "sum");
        this.sumAsString = builder.sumAsString;
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

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
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

        if (this.min != null) {
            generator.writeKey("min");
            generator.write(this.min);
        }

        if (this.minAsString != null) {
            generator.writeKey("min_as_string");
            generator.write(this.minAsString);
        }

        generator.writeKey("sum");
        generator.write(this.sum);

        if (this.sumAsString != null) {
            generator.writeKey("sum_as_string");
            generator.write(this.sumAsString);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends AggregateBase.AbstractBuilder<
        BuilderT> {
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
        private Double min;
        @Nullable
        private String minAsString;
        private Double sum;
        @Nullable
        private String sumAsString;

        protected AbstractBuilder() {}

        protected AbstractBuilder(StatsAggregateBase o) {
            super(o);
            this.avg = o.avg;
            this.avgAsString = o.avgAsString;
            this.count = o.count;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.sum = o.sum;
            this.sumAsString = o.sumAsString;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.avg = o.avg;
            this.avgAsString = o.avgAsString;
            this.count = o.count;
            this.max = o.max;
            this.maxAsString = o.maxAsString;
            this.min = o.min;
            this.minAsString = o.minAsString;
            this.sum = o.sum;
            this.sumAsString = o.sumAsString;
        }

        /**
         * API name: {@code avg}
         */
        @Nonnull
        public final BuilderT avg(@Nullable Double value) {
            this.avg = value;
            return self();
        }

        /**
         * API name: {@code avg_as_string}
         */
        @Nonnull
        public final BuilderT avgAsString(@Nullable String value) {
            this.avgAsString = value;
            return self();
        }

        /**
         * Required - API name: {@code count}
         */
        @Nonnull
        public final BuilderT count(long value) {
            this.count = value;
            return self();
        }

        /**
         * API name: {@code max}
         */
        @Nonnull
        public final BuilderT max(@Nullable Double value) {
            this.max = value;
            return self();
        }

        /**
         * API name: {@code max_as_string}
         */
        @Nonnull
        public final BuilderT maxAsString(@Nullable String value) {
            this.maxAsString = value;
            return self();
        }

        /**
         * API name: {@code min}
         */
        @Nonnull
        public final BuilderT min(@Nullable Double value) {
            this.min = value;
            return self();
        }

        /**
         * API name: {@code min_as_string}
         */
        @Nonnull
        public final BuilderT minAsString(@Nullable String value) {
            this.minAsString = value;
            return self();
        }

        /**
         * Required - API name: {@code sum}
         */
        @Nonnull
        public final BuilderT sum(double value) {
            this.sum = value;
            return self();
        }

        /**
         * API name: {@code sum_as_string}
         */
        @Nonnull
        public final BuilderT sumAsString(@Nullable String value) {
            this.sumAsString = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupStatsAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAggregateBaseDeserializer(op);
        op.add(AbstractBuilder::avg, JsonpDeserializer.doubleDeserializer(), "avg");
        op.add(AbstractBuilder::avgAsString, JsonpDeserializer.stringDeserializer(), "avg_as_string");
        op.add(AbstractBuilder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(AbstractBuilder::max, JsonpDeserializer.doubleDeserializer(), "max");
        op.add(AbstractBuilder::maxAsString, JsonpDeserializer.stringDeserializer(), "max_as_string");
        op.add(AbstractBuilder::min, JsonpDeserializer.doubleDeserializer(), "min");
        op.add(AbstractBuilder::minAsString, JsonpDeserializer.stringDeserializer(), "min_as_string");
        op.add(AbstractBuilder::sum, JsonpDeserializer.doubleDeserializer(), "sum");
        op.add(AbstractBuilder::sumAsString, JsonpDeserializer.stringDeserializer(), "sum_as_string");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.avg);
        result = 31 * result + Objects.hashCode(this.avgAsString);
        result = 31 * result + Long.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.max);
        result = 31 * result + Objects.hashCode(this.maxAsString);
        result = 31 * result + Objects.hashCode(this.min);
        result = 31 * result + Objects.hashCode(this.minAsString);
        result = 31 * result + Double.hashCode(this.sum);
        result = 31 * result + Objects.hashCode(this.sumAsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StatsAggregateBase other = (StatsAggregateBase) o;
        return Objects.equals(this.avg, other.avg)
            && Objects.equals(this.avgAsString, other.avgAsString)
            && this.count == other.count
            && Objects.equals(this.max, other.max)
            && Objects.equals(this.maxAsString, other.maxAsString)
            && Objects.equals(this.min, other.min)
            && Objects.equals(this.minAsString, other.minAsString)
            && this.sum == other.sum
            && Objects.equals(this.sumAsString, other.sumAsString);
    }
}
