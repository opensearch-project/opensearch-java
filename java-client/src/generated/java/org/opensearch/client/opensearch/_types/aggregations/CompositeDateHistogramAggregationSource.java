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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.CompositeDateHistogramAggregationSource

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompositeDateHistogramAggregationSource extends CompositeValuesSource
    implements
        ToCopyableBuilder<CompositeDateHistogramAggregationSource.Builder, CompositeDateHistogramAggregationSource> {

    @Nullable
    private final Time calendarInterval;

    @Nullable
    private final Time fixedInterval;

    @Nullable
    private final String format;

    @Nullable
    private final Time offset;

    @Nullable
    private final String timeZone;

    // ---------------------------------------------------------------------------------------------

    private CompositeDateHistogramAggregationSource(Builder builder) {
        super(builder);
        this.calendarInterval = builder.calendarInterval;
        this.fixedInterval = builder.fixedInterval;
        this.format = builder.format;
        this.offset = builder.offset;
        this.timeZone = builder.timeZone;
    }

    public static CompositeDateHistogramAggregationSource of(
        Function<CompositeDateHistogramAggregationSource.Builder, ObjectBuilder<CompositeDateHistogramAggregationSource>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code calendar_interval}
     */
    @Nullable
    public final Time calendarInterval() {
        return this.calendarInterval;
    }

    /**
     * API name: {@code fixed_interval}
     */
    @Nullable
    public final Time fixedInterval() {
        return this.fixedInterval;
    }

    /**
     * API name: {@code format}
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * API name: {@code offset}
     */
    @Nullable
    public final Time offset() {
        return this.offset;
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

        if (this.fixedInterval != null) {
            generator.writeKey("fixed_interval");
            this.fixedInterval.serialize(generator, mapper);
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.offset != null) {
            generator.writeKey("offset");
            this.offset.serialize(generator, mapper);
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
     * Builder for {@link CompositeDateHistogramAggregationSource}.
     */
    public static class Builder extends CompositeValuesSource.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CompositeDateHistogramAggregationSource> {
        @Nullable
        private Time calendarInterval;
        @Nullable
        private Time fixedInterval;
        @Nullable
        private String format;
        @Nullable
        private Time offset;
        @Nullable
        private String timeZone;

        public Builder() {}

        private Builder(CompositeDateHistogramAggregationSource o) {
            super(o);
            this.calendarInterval = o.calendarInterval;
            this.fixedInterval = o.fixedInterval;
            this.format = o.format;
            this.offset = o.offset;
            this.timeZone = o.timeZone;
        }

        private Builder(Builder o) {
            super(o);
            this.calendarInterval = o.calendarInterval;
            this.fixedInterval = o.fixedInterval;
            this.format = o.format;
            this.offset = o.offset;
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
        public final Builder calendarInterval(@Nullable Time value) {
            this.calendarInterval = value;
            return this;
        }

        /**
         * API name: {@code calendar_interval}
         */
        @Nonnull
        public final Builder calendarInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return calendarInterval(fn.apply(new Time.Builder()).build());
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
         * API name: {@code format}
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
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
         * API name: {@code time_zone}
         */
        @Nonnull
        public final Builder timeZone(@Nullable String value) {
            this.timeZone = value;
            return this;
        }

        /**
         * Builds a {@link CompositeDateHistogramAggregationSource}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompositeDateHistogramAggregationSource build() {
            _checkSingleUse();

            return new CompositeDateHistogramAggregationSource(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompositeDateHistogramAggregationSource}
     */
    public static final JsonpDeserializer<CompositeDateHistogramAggregationSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeDateHistogramAggregationSource::setupCompositeDateHistogramAggregationSourceDeserializer
    );

    protected static void setupCompositeDateHistogramAggregationSourceDeserializer(
        ObjectDeserializer<CompositeDateHistogramAggregationSource.Builder> op
    ) {
        setupCompositeValuesSourceDeserializer(op);
        op.add(Builder::calendarInterval, Time._DESERIALIZER, "calendar_interval");
        op.add(Builder::fixedInterval, Time._DESERIALIZER, "fixed_interval");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::offset, Time._DESERIALIZER, "offset");
        op.add(Builder::timeZone, JsonpDeserializer.stringDeserializer(), "time_zone");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.calendarInterval);
        result = 31 * result + Objects.hashCode(this.fixedInterval);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.offset);
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
        CompositeDateHistogramAggregationSource other = (CompositeDateHistogramAggregationSource) o;
        return Objects.equals(this.calendarInterval, other.calendarInterval)
            && Objects.equals(this.fixedInterval, other.fixedInterval)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.offset, other.offset)
            && Objects.equals(this.timeZone, other.timeZone);
    }
}
