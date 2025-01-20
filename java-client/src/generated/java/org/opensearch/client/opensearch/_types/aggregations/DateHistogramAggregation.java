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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.DateHistogramAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateHistogramAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<DateHistogramAggregation.Builder, DateHistogramAggregation> {

    @Nullable
    private final CalendarInterval calendarInterval;

    @Nullable
    private final ExtendedBounds<FieldDateMath> extendedBounds;

    @Nullable
    private final String field;

    @Nullable
    private final Time fixedInterval;

    @Nullable
    private final String format;

    @Nullable
    private final ExtendedBounds<FieldDateMath> hardBounds;

    @Nullable
    private final Time interval;

    @Nullable
    private final Boolean keyed;

    @Nullable
    private final Integer minDocCount;

    @Nullable
    private final String missing;

    @Nullable
    private final Time offset;

    @Nullable
    private final HistogramOrder order;

    @Nonnull
    private final Map<String, JsonData> params;

    @Nullable
    private final Script script;

    @Nullable
    private final String timeZone;

    // ---------------------------------------------------------------------------------------------

    private DateHistogramAggregation(Builder builder) {
        super(builder);
        this.calendarInterval = builder.calendarInterval;
        this.extendedBounds = builder.extendedBounds;
        this.field = builder.field;
        this.fixedInterval = builder.fixedInterval;
        this.format = builder.format;
        this.hardBounds = builder.hardBounds;
        this.interval = builder.interval;
        this.keyed = builder.keyed;
        this.minDocCount = builder.minDocCount;
        this.missing = builder.missing;
        this.offset = builder.offset;
        this.order = builder.order;
        this.params = ApiTypeHelper.unmodifiable(builder.params);
        this.script = builder.script;
        this.timeZone = builder.timeZone;
    }

    public static DateHistogramAggregation of(Function<DateHistogramAggregation.Builder, ObjectBuilder<DateHistogramAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.DateHistogram;
    }

    /**
     * API name: {@code calendar_interval}
     */
    @Nullable
    public final CalendarInterval calendarInterval() {
        return this.calendarInterval;
    }

    /**
     * API name: {@code extended_bounds}
     */
    @Nullable
    public final ExtendedBounds<FieldDateMath> extendedBounds() {
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
     * API name: {@code fixed_interval}
     */
    @Nullable
    public final Time fixedInterval() {
        return this.fixedInterval;
    }

    /**
     * The date format used to format <code>key_as_string</code> in the response. If no <code>format</code> is specified, the first date
     * format specified in the field mapping is used.
     * <p>
     * API name: {@code format}
     * </p>
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code hard_bounds}
     */
    @Nullable
    public final ExtendedBounds<FieldDateMath> hardBounds() {
        return this.hardBounds;
    }

    /**
     * API name: {@code interval}
     */
    @Nullable
    public final Time interval() {
        return this.interval;
    }

    /**
     * Set to <code>true</code> to associate a unique string key with each bucket and return the ranges as a hash rather than an array.
     * <p>
     * API name: {@code keyed}
     * </p>
     */
    @Nullable
    public final Boolean keyed() {
        return this.keyed;
    }

    /**
     * Only returns buckets that have <code>min_doc_count</code> number of documents. By default, all buckets between the first bucket that
     * matches documents and the last one are returned.
     * <p>
     * API name: {@code min_doc_count}
     * </p>
     */
    @Nullable
    public final Integer minDocCount() {
        return this.minDocCount;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final String missing() {
        return this.missing;
    }

    /**
     * API name: {@code offset}
     */
    @Nullable
    public final Time offset() {
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
     * API name: {@code params}
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
    }

    /**
     * API name: {@code script}
     */
    @Nullable
    public final Script script() {
        return this.script;
    }

    /**
     * API name: {@code time_zone}
     */
    @Nullable
    public final String timeZone() {
        return this.timeZone;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.calendarInterval != null) {
            generator.writeKey("calendar_interval");
            this.calendarInterval.serialize(generator, mapper);
        }

        if (this.extendedBounds != null) {
            generator.writeKey("extended_bounds");
            this.extendedBounds.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.fixedInterval != null) {
            generator.writeKey("fixed_interval");
            this.fixedInterval.serialize(generator, mapper);
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
            this.interval.serialize(generator, mapper);
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
            this.offset.serialize(generator, mapper);
        }

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.params)) {
            generator.writeKey("params");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.timeZone != null) {
            generator.writeKey("time_zone");
            generator.write(this.timeZone);
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
     * Builder for {@link DateHistogramAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DateHistogramAggregation> {
        @Nullable
        private CalendarInterval calendarInterval;
        @Nullable
        private ExtendedBounds<FieldDateMath> extendedBounds;
        @Nullable
        private String field;
        @Nullable
        private Time fixedInterval;
        @Nullable
        private String format;
        @Nullable
        private ExtendedBounds<FieldDateMath> hardBounds;
        @Nullable
        private Time interval;
        @Nullable
        private Boolean keyed;
        @Nullable
        private Integer minDocCount;
        @Nullable
        private String missing;
        @Nullable
        private Time offset;
        @Nullable
        private HistogramOrder order;
        @Nullable
        private Map<String, JsonData> params;
        @Nullable
        private Script script;
        @Nullable
        private String timeZone;

        public Builder() {}

        private Builder(DateHistogramAggregation o) {
            super(o);
            this.calendarInterval = o.calendarInterval;
            this.extendedBounds = o.extendedBounds;
            this.field = o.field;
            this.fixedInterval = o.fixedInterval;
            this.format = o.format;
            this.hardBounds = o.hardBounds;
            this.interval = o.interval;
            this.keyed = o.keyed;
            this.minDocCount = o.minDocCount;
            this.missing = o.missing;
            this.offset = o.offset;
            this.order = o.order;
            this.params = _mapCopy(o.params);
            this.script = o.script;
            this.timeZone = o.timeZone;
        }

        private Builder(Builder o) {
            super(o);
            this.calendarInterval = o.calendarInterval;
            this.extendedBounds = o.extendedBounds;
            this.field = o.field;
            this.fixedInterval = o.fixedInterval;
            this.format = o.format;
            this.hardBounds = o.hardBounds;
            this.interval = o.interval;
            this.keyed = o.keyed;
            this.minDocCount = o.minDocCount;
            this.missing = o.missing;
            this.offset = o.offset;
            this.order = o.order;
            this.params = _mapCopy(o.params);
            this.script = o.script;
            this.timeZone = o.timeZone;
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
         * API name: {@code calendar_interval}
         */
        @Nonnull
        public final Builder calendarInterval(@Nullable CalendarInterval value) {
            this.calendarInterval = value;
            return this;
        }

        /**
         * API name: {@code extended_bounds}
         */
        @Nonnull
        public final Builder extendedBounds(@Nullable ExtendedBounds<FieldDateMath> value) {
            this.extendedBounds = value;
            return this;
        }

        /**
         * API name: {@code extended_bounds}
         */
        @Nonnull
        public final Builder extendedBounds(Function<ExtendedBounds.Builder, ObjectBuilder<ExtendedBounds<FieldDateMath>>> fn) {
            return extendedBounds(fn.apply(new ExtendedBounds.Builder()).build());
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
         * API name: {@code fixed_interval}
         */
        @Nonnull
        public final Builder fixedInterval(@Nullable Time value) {
            this.fixedInterval = value;
            return this;
        }

        /**
         * API name: {@code fixed_interval}
         */
        @Nonnull
        public final Builder fixedInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return fixedInterval(fn.apply(new Time.Builder()).build());
        }

        /**
         * The date format used to format <code>key_as_string</code> in the response. If no <code>format</code> is specified, the first date
         * format specified in the field mapping is used.
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
         * API name: {@code hard_bounds}
         */
        @Nonnull
        public final Builder hardBounds(@Nullable ExtendedBounds<FieldDateMath> value) {
            this.hardBounds = value;
            return this;
        }

        /**
         * API name: {@code hard_bounds}
         */
        @Nonnull
        public final Builder hardBounds(Function<ExtendedBounds.Builder, ObjectBuilder<ExtendedBounds<FieldDateMath>>> fn) {
            return hardBounds(fn.apply(new ExtendedBounds.Builder()).build());
        }

        /**
         * API name: {@code interval}
         */
        @Nonnull
        public final Builder interval(@Nullable Time value) {
            this.interval = value;
            return this;
        }

        /**
         * API name: {@code interval}
         */
        @Nonnull
        public final Builder interval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return interval(fn.apply(new Time.Builder()).build());
        }

        /**
         * Set to <code>true</code> to associate a unique string key with each bucket and return the ranges as a hash rather than an array.
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
         * Only returns buckets that have <code>min_doc_count</code> number of documents. By default, all buckets between the first bucket
         * that matches documents and the last one are returned.
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
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(@Nullable String value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code offset}
         */
        @Nonnull
        public final Builder offset(@Nullable Time value) {
            this.offset = value;
            return this;
        }

        /**
         * API name: {@code offset}
         */
        @Nonnull
        public final Builder offset(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return offset(fn.apply(new Time.Builder()).build());
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
         * API name: {@code params}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(Map<String, JsonData> map) {
            this.params = _mapPutAll(this.params, map);
            return this;
        }

        /**
         * API name: {@code params}
         *
         * <p>
         * Adds an entry to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(String key, JsonData value) {
            this.params = _mapPut(this.params, key, value);
            return this;
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
         * API name: {@code time_zone}
         */
        @Nonnull
        public final Builder timeZone(@Nullable String value) {
            this.timeZone = value;
            return this;
        }

        /**
         * Builds a {@link DateHistogramAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateHistogramAggregation build() {
            _checkSingleUse();

            return new DateHistogramAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateHistogramAggregation}
     */
    public static final JsonpDeserializer<DateHistogramAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateHistogramAggregation::setupDateHistogramAggregationDeserializer
    );

    protected static void setupDateHistogramAggregationDeserializer(ObjectDeserializer<DateHistogramAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::calendarInterval, CalendarInterval._DESERIALIZER, "calendar_interval");
        op.add(Builder::extendedBounds, ExtendedBounds.createExtendedBoundsDeserializer(FieldDateMath._DESERIALIZER), "extended_bounds");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::fixedInterval, Time._DESERIALIZER, "fixed_interval");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::hardBounds, ExtendedBounds.createExtendedBoundsDeserializer(FieldDateMath._DESERIALIZER), "hard_bounds");
        op.add(Builder::interval, Time._DESERIALIZER, "interval");
        op.add(Builder::keyed, JsonpDeserializer.booleanDeserializer(), "keyed");
        op.add(Builder::minDocCount, JsonpDeserializer.integerDeserializer(), "min_doc_count");
        op.add(Builder::missing, JsonpDeserializer.stringDeserializer(), "missing");
        op.add(Builder::offset, Time._DESERIALIZER, "offset");
        op.add(Builder::order, HistogramOrder._DESERIALIZER, "order");
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::timeZone, JsonpDeserializer.stringDeserializer(), "time_zone");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.calendarInterval);
        result = 31 * result + Objects.hashCode(this.extendedBounds);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.fixedInterval);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.hardBounds);
        result = 31 * result + Objects.hashCode(this.interval);
        result = 31 * result + Objects.hashCode(this.keyed);
        result = 31 * result + Objects.hashCode(this.minDocCount);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.offset);
        result = 31 * result + Objects.hashCode(this.order);
        result = 31 * result + Objects.hashCode(this.params);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.timeZone);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DateHistogramAggregation other = (DateHistogramAggregation) o;
        return Objects.equals(this.calendarInterval, other.calendarInterval)
            && Objects.equals(this.extendedBounds, other.extendedBounds)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.fixedInterval, other.fixedInterval)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.hardBounds, other.hardBounds)
            && Objects.equals(this.interval, other.interval)
            && Objects.equals(this.keyed, other.keyed)
            && Objects.equals(this.minDocCount, other.minDocCount)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.offset, other.offset)
            && Objects.equals(this.order, other.order)
            && Objects.equals(this.params, other.params)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.timeZone, other.timeZone);
    }
}
