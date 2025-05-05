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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.HistogramAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HistogramAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<HistogramAggregation.Builder, HistogramAggregation> {

    @Nullable
    private final ExtendedBounds<Double> extendedBounds;

    @Nullable
    private final String field;

    @Nullable
    private final String format;

    @Nullable
    private final ExtendedBounds<Double> hardBounds;

    @Nullable
    private final Double interval;

    @Nullable
    private final Boolean keyed;

    @Nullable
    private final Integer minDocCount;

    @Nullable
    private final Double missing;

    @Nullable
    private final Double offset;

    @Nullable
    private final HistogramOrder order;

    @Nullable
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    private HistogramAggregation(Builder builder) {
        super(builder);
        this.extendedBounds = builder.extendedBounds;
        this.field = builder.field;
        this.format = builder.format;
        this.hardBounds = builder.hardBounds;
        this.interval = builder.interval;
        this.keyed = builder.keyed;
        this.minDocCount = builder.minDocCount;
        this.missing = builder.missing;
        this.offset = builder.offset;
        this.order = builder.order;
        this.script = builder.script;
    }

    public static HistogramAggregation of(Function<HistogramAggregation.Builder, ObjectBuilder<HistogramAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Histogram;
    }

    /**
     * API name: {@code extended_bounds}
     */
    @Nullable
    public final ExtendedBounds<Double> extendedBounds() {
        return this.extendedBounds;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code hard_bounds}
     */
    @Nullable
    public final ExtendedBounds<Double> hardBounds() {
        return this.hardBounds;
    }

    /**
     * The interval for the buckets. Must be a positive decimal.
     * <p>
     * API name: {@code interval}
     * </p>
     */
    @Nullable
    public final Double interval() {
        return this.interval;
    }

    /**
     * If <code>true</code>, returns buckets as a hash instead of an array, keyed by the bucket keys.
     * <p>
     * API name: {@code keyed}
     * </p>
     */
    @Nullable
    public final Boolean keyed() {
        return this.keyed;
    }

    /**
     * Only returns buckets that have <code>min_doc_count</code> number of documents. By default, the response will fill gaps in the
     * histogram with empty buckets.
     * <p>
     * API name: {@code min_doc_count}
     * </p>
     */
    @Nullable
    public final Integer minDocCount() {
        return this.minDocCount;
    }

    /**
     * The value to apply to documents that do not have a value. By default, documents without a value are ignored.
     * <p>
     * API name: {@code missing}
     * </p>
     */
    @Nullable
    public final Double missing() {
        return this.missing;
    }

    /**
     * By default, the bucket keys start with 0 and then continue in even spaced steps of <code>interval</code>. The bucket boundaries can
     * be shifted by using the <code>offset</code> option.
     * <p>
     * API name: {@code offset}
     * </p>
     */
    @Nullable
    public final Double offset() {
        return this.offset;
    }

    /**
     * API name: {@code order}
     */
    @Nullable
    public final HistogramOrder order() {
        return this.order;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.extendedBounds != null) {
            generator.writeKey("extended_bounds");
            this.extendedBounds.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.hardBounds != null) {
            generator.writeKey("hard_bounds");
            this.hardBounds.serialize(generator, mapper);
        }

        if (this.interval != null) {
            generator.writeKey("interval");
            generator.write(this.interval);
        }

        if (this.keyed != null) {
            generator.writeKey("keyed");
            generator.write(this.keyed);
        }

        if (this.minDocCount != null) {
            generator.writeKey("min_doc_count");
            generator.write(this.minDocCount);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            generator.write(this.missing);
        }

        if (this.offset != null) {
            generator.writeKey("offset");
            generator.write(this.offset);
        }

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
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
     * Builder for {@link HistogramAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, HistogramAggregation> {
        @Nullable
        private ExtendedBounds<Double> extendedBounds;
        @Nullable
        private String field;
        @Nullable
        private String format;
        @Nullable
        private ExtendedBounds<Double> hardBounds;
        @Nullable
        private Double interval;
        @Nullable
        private Boolean keyed;
        @Nullable
        private Integer minDocCount;
        @Nullable
        private Double missing;
        @Nullable
        private Double offset;
        @Nullable
        private HistogramOrder order;
        @Nullable
        private Script script;

        public Builder() {}

        private Builder(HistogramAggregation o) {
            super(o);
            this.extendedBounds = o.extendedBounds;
            this.field = o.field;
            this.format = o.format;
            this.hardBounds = o.hardBounds;
            this.interval = o.interval;
            this.keyed = o.keyed;
            this.minDocCount = o.minDocCount;
            this.missing = o.missing;
            this.offset = o.offset;
            this.order = o.order;
            this.script = o.script;
        }

        private Builder(Builder o) {
            super(o);
            this.extendedBounds = o.extendedBounds;
            this.field = o.field;
            this.format = o.format;
            this.hardBounds = o.hardBounds;
            this.interval = o.interval;
            this.keyed = o.keyed;
            this.minDocCount = o.minDocCount;
            this.missing = o.missing;
            this.offset = o.offset;
            this.order = o.order;
            this.script = o.script;
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
         * API name: {@code extended_bounds}
         */
        @Nonnull
        public final Builder extendedBounds(@Nullable ExtendedBounds<Double> value) {
            this.extendedBounds = value;
            return this;
        }

        /**
         * API name: {@code extended_bounds}
         */
        @Nonnull
        public final Builder extendedBounds(Function<ExtendedBounds.Builder<Double>, ObjectBuilder<ExtendedBounds<Double>>> fn) {
            return extendedBounds(fn.apply(new ExtendedBounds.Builder<Double>()).build());
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * API name: {@code hard_bounds}
         */
        @Nonnull
        public final Builder hardBounds(@Nullable ExtendedBounds<Double> value) {
            this.hardBounds = value;
            return this;
        }

        /**
         * API name: {@code hard_bounds}
         */
        @Nonnull
        public final Builder hardBounds(Function<ExtendedBounds.Builder<Double>, ObjectBuilder<ExtendedBounds<Double>>> fn) {
            return hardBounds(fn.apply(new ExtendedBounds.Builder<Double>()).build());
        }

        /**
         * The interval for the buckets. Must be a positive decimal.
         * <p>
         * API name: {@code interval}
         * </p>
         */
        @Nonnull
        public final Builder interval(@Nullable Double value) {
            this.interval = value;
            return this;
        }

        /**
         * If <code>true</code>, returns buckets as a hash instead of an array, keyed by the bucket keys.
         * <p>
         * API name: {@code keyed}
         * </p>
         */
        @Nonnull
        public final Builder keyed(@Nullable Boolean value) {
            this.keyed = value;
            return this;
        }

        /**
         * Only returns buckets that have <code>min_doc_count</code> number of documents. By default, the response will fill gaps in the
         * histogram with empty buckets.
         * <p>
         * API name: {@code min_doc_count}
         * </p>
         */
        @Nonnull
        public final Builder minDocCount(@Nullable Integer value) {
            this.minDocCount = value;
            return this;
        }

        /**
         * The value to apply to documents that do not have a value. By default, documents without a value are ignored.
         * <p>
         * API name: {@code missing}
         * </p>
         */
        @Nonnull
        public final Builder missing(@Nullable Double value) {
            this.missing = value;
            return this;
        }

        /**
         * By default, the bucket keys start with 0 and then continue in even spaced steps of <code>interval</code>. The bucket boundaries
         * can be shifted by using the <code>offset</code> option.
         * <p>
         * API name: {@code offset}
         * </p>
         */
        @Nonnull
        public final Builder offset(@Nullable Double value) {
            this.offset = value;
            return this;
        }

        /**
         * API name: {@code order}
         */
        @Nonnull
        public final Builder order(@Nullable HistogramOrder value) {
            this.order = value;
            return this;
        }

        /**
         * API name: {@code order}
         */
        @Nonnull
        public final Builder order(Function<HistogramOrder.Builder, ObjectBuilder<HistogramOrder>> fn) {
            return order(fn.apply(new HistogramOrder.Builder()).build());
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(@Nullable Script value) {
            this.script = value;
            return this;
        }

        /**
         * API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link HistogramAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HistogramAggregation build() {
            _checkSingleUse();

            return new HistogramAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HistogramAggregation}
     */
    public static final JsonpDeserializer<HistogramAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HistogramAggregation::setupHistogramAggregationDeserializer
    );

    protected static void setupHistogramAggregationDeserializer(ObjectDeserializer<HistogramAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(
            Builder::extendedBounds,
            ExtendedBounds.createExtendedBoundsDeserializer(JsonpDeserializer.doubleDeserializer()),
            "extended_bounds"
        );
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::hardBounds, ExtendedBounds.createExtendedBoundsDeserializer(JsonpDeserializer.doubleDeserializer()), "hard_bounds");
        op.add(Builder::interval, JsonpDeserializer.doubleDeserializer(), "interval");
        op.add(Builder::keyed, JsonpDeserializer.booleanDeserializer(), "keyed");
        op.add(Builder::minDocCount, JsonpDeserializer.integerDeserializer(), "min_doc_count");
        op.add(Builder::missing, JsonpDeserializer.doubleDeserializer(), "missing");
        op.add(Builder::offset, JsonpDeserializer.doubleDeserializer(), "offset");
        op.add(Builder::order, HistogramOrder._DESERIALIZER, "order");
        op.add(Builder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.extendedBounds);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.hardBounds);
        result = 31 * result + Objects.hashCode(this.interval);
        result = 31 * result + Objects.hashCode(this.keyed);
        result = 31 * result + Objects.hashCode(this.minDocCount);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.offset);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.script);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HistogramAggregation other = (HistogramAggregation) o;
        return Objects.equals(this.extendedBounds, other.extendedBounds)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.hardBounds, other.hardBounds)
            && Objects.equals(this.interval, other.interval)
            && Objects.equals(this.keyed, other.keyed)
            && Objects.equals(this.minDocCount, other.minDocCount)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.offset, other.offset)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.script, other.script);
    }
}
