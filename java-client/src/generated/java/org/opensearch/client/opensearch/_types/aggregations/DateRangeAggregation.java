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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.DateRangeAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DateRangeAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<DateRangeAggregation.Builder, DateRangeAggregation> {

    @Nullable
    private final String field;

    @Nullable
    private final String format;

    @Nullable
    private final Boolean keyed;

    @Nullable
    private final FieldValue missing;

    @Nonnull
    private final List<DateRangeExpression> ranges;

    @Nullable
    private final String timeZone;

    // ---------------------------------------------------------------------------------------------

    private DateRangeAggregation(Builder builder) {
        super(builder);
        this.field = builder.field;
        this.format = builder.format;
        this.keyed = builder.keyed;
        this.missing = builder.missing;
        this.ranges = ApiTypeHelper.unmodifiable(builder.ranges);
        this.timeZone = builder.timeZone;
    }

    public static DateRangeAggregation of(Function<DateRangeAggregation.Builder, ObjectBuilder<DateRangeAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.DateRange;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * The date format used to format <code>from</code> and <code>to</code> in the response.
     * <p>
     * API name: {@code format}
     * </p>
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * Set to <code>true</code> to associate a unique string key with each bucket and returns the ranges as a hash rather than an array.
     * <p>
     * API name: {@code keyed}
     * </p>
     */
    @Nullable
    public final Boolean keyed() {
        return this.keyed;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final FieldValue missing() {
        return this.missing;
    }

    /**
     * Array of date ranges.
     * <p>
     * API name: {@code ranges}
     * </p>
     */
    @Nonnull
    public final List<DateRangeExpression> ranges() {
        return this.ranges;
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
        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.keyed != null) {
            generator.writeKey("keyed");
            generator.write(this.keyed);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            this.missing.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.ranges)) {
            generator.writeKey("ranges");
            generator.writeStartArray();
            for (DateRangeExpression item0 : this.ranges) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link DateRangeAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DateRangeAggregation> {
        @Nullable
        private String field;
        @Nullable
        private String format;
        @Nullable
        private Boolean keyed;
        @Nullable
        private FieldValue missing;
        @Nullable
        private List<DateRangeExpression> ranges;
        @Nullable
        private String timeZone;

        public Builder() {}

        private Builder(DateRangeAggregation o) {
            super(o);
            this.field = o.field;
            this.format = o.format;
            this.keyed = o.keyed;
            this.missing = o.missing;
            this.ranges = _listCopy(o.ranges);
            this.timeZone = o.timeZone;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.format = o.format;
            this.keyed = o.keyed;
            this.missing = o.missing;
            this.ranges = _listCopy(o.ranges);
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
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * The date format used to format <code>from</code> and <code>to</code> in the response.
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
         * Set to <code>true</code> to associate a unique string key with each bucket and returns the ranges as a hash rather than an array.
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
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(@Nullable FieldValue value) {
            this.missing = value;
            return this;
        }

        /**
         * API name: {@code missing}
         */
        @Nonnull
        public final Builder missing(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return missing(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Array of date ranges.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ranges</code>.
         * </p>
         */
        @Nonnull
        public final Builder ranges(List<DateRangeExpression> list) {
            this.ranges = _listAddAll(this.ranges, list);
            return this;
        }

        /**
         * Array of date ranges.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ranges</code>.
         * </p>
         */
        @Nonnull
        public final Builder ranges(DateRangeExpression value, DateRangeExpression... values) {
            this.ranges = _listAdd(this.ranges, value, values);
            return this;
        }

        /**
         * Array of date ranges.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds a value to <code>ranges</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder ranges(Function<DateRangeExpression.Builder, ObjectBuilder<DateRangeExpression>> fn) {
            return ranges(fn.apply(new DateRangeExpression.Builder()).build());
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
         * Builds a {@link DateRangeAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DateRangeAggregation build() {
            _checkSingleUse();

            return new DateRangeAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DateRangeAggregation}
     */
    public static final JsonpDeserializer<DateRangeAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DateRangeAggregation::setupDateRangeAggregationDeserializer
    );

    protected static void setupDateRangeAggregationDeserializer(ObjectDeserializer<DateRangeAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::keyed, JsonpDeserializer.booleanDeserializer(), "keyed");
        op.add(Builder::missing, FieldValue._DESERIALIZER, "missing");
        op.add(Builder::ranges, JsonpDeserializer.arrayDeserializer(DateRangeExpression._DESERIALIZER), "ranges");
        op.add(Builder::timeZone, JsonpDeserializer.stringDeserializer(), "time_zone");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.keyed);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.ranges);
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
        DateRangeAggregation other = (DateRangeAggregation) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.keyed, other.keyed)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.ranges, other.ranges)
            && Objects.equals(this.timeZone, other.timeZone);
    }
}
