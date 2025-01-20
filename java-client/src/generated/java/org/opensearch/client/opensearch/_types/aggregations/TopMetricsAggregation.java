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
import java.util.List;
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
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.TopMetricsAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TopMetricsAggregation extends MetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<TopMetricsAggregation.Builder, TopMetricsAggregation> {

    @Nonnull
    private final List<TopMetricsValue> metrics;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<SortOptions> sort;

    // ---------------------------------------------------------------------------------------------

    private TopMetricsAggregation(Builder builder) {
        super(builder);
        this.metrics = ApiTypeHelper.unmodifiable(builder.metrics);
        this.size = builder.size;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
    }

    public static TopMetricsAggregation of(Function<TopMetricsAggregation.Builder, ObjectBuilder<TopMetricsAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.TopMetrics;
    }

    /**
     * The fields of the top document to return.
     * <p>
     * API name: {@code metrics}
     * </p>
     */
    @Nonnull
    public final List<TopMetricsValue> metrics() {
        return this.metrics;
    }

    /**
     * The number of top documents from which to return metrics.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code sort}
     */
    @Nonnull
    public final List<SortOptions> sort() {
        return this.sort;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.metrics)) {
            generator.writeKey("metrics");
            generator.writeStartArray();
            for (TopMetricsValue item0 : this.metrics) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (SortOptions item0 : this.sort) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link TopMetricsAggregation}.
     */
    public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, TopMetricsAggregation> {
        @Nullable
        private List<TopMetricsValue> metrics;
        @Nullable
        private Integer size;
        @Nullable
        private List<SortOptions> sort;

        public Builder() {}

        private Builder(TopMetricsAggregation o) {
            super(o);
            this.metrics = _listCopy(o.metrics);
            this.size = o.size;
            this.sort = _listCopy(o.sort);
        }

        private Builder(Builder o) {
            super(o);
            this.metrics = _listCopy(o.metrics);
            this.size = o.size;
            this.sort = _listCopy(o.sort);
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
         * The fields of the top document to return.
         * <p>
         * API name: {@code metrics}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(List<TopMetricsValue> list) {
            this.metrics = _listAddAll(this.metrics, list);
            return this;
        }

        /**
         * The fields of the top document to return.
         * <p>
         * API name: {@code metrics}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metrics</code>.
         * </p>
         */
        @Nonnull
        public final Builder metrics(TopMetricsValue value, TopMetricsValue... values) {
            this.metrics = _listAdd(this.metrics, value, values);
            return this;
        }

        /**
         * The fields of the top document to return.
         * <p>
         * API name: {@code metrics}
         * </p>
         *
         * <p>
         * Adds a value to <code>metrics</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder metrics(Function<TopMetricsValue.Builder, ObjectBuilder<TopMetricsValue>> fn) {
            return metrics(fn.apply(new TopMetricsValue.Builder()).build());
        }

        /**
         * The number of top documents from which to return metrics.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(List<SortOptions> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds one or more values to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(SortOptions value, SortOptions... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds a value to <code>sort</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return sort(fn.apply(new SortOptions.Builder()).build());
        }

        /**
         * Builds a {@link TopMetricsAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TopMetricsAggregation build() {
            _checkSingleUse();

            return new TopMetricsAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TopMetricsAggregation}
     */
    public static final JsonpDeserializer<TopMetricsAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TopMetricsAggregation::setupTopMetricsAggregationDeserializer
    );

    protected static void setupTopMetricsAggregationDeserializer(ObjectDeserializer<TopMetricsAggregation.Builder> op) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(Builder::metrics, JsonpDeserializer.arrayDeserializer(TopMetricsValue._DESERIALIZER), "metrics");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.metrics);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sort);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TopMetricsAggregation other = (TopMetricsAggregation) o;
        return Objects.equals(this.metrics, other.metrics)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sort, other.sort);
    }
}
