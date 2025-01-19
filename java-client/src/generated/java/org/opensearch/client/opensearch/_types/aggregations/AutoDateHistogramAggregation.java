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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.AutoDateHistogramAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AutoDateHistogramAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<AutoDateHistogramAggregation.Builder, AutoDateHistogramAggregation> {

    @Nullable
    private final Integer buckets;

    @Nullable
    private final String field;

    @Nullable
    private final String format;

    @Nullable
    private final MinimumInterval minimumInterval;

    @Nullable
    private final String missing;

    @Nullable
    private final String offset;

    @Nonnull
    private final Map<String, JsonData> params;

    @Nullable
    private final Script script;

    @Nullable
    private final String timeZone;

    // ---------------------------------------------------------------------------------------------

    private AutoDateHistogramAggregation(Builder builder) {
        super(builder);
        this.buckets = builder.buckets;
        this.field = builder.field;
        this.format = builder.format;
        this.minimumInterval = builder.minimumInterval;
        this.missing = builder.missing;
        this.offset = builder.offset;
        this.params = ApiTypeHelper.unmodifiable(builder.params);
        this.script = builder.script;
        this.timeZone = builder.timeZone;
    }

    public static AutoDateHistogramAggregation of(
        Function<AutoDateHistogramAggregation.Builder, ObjectBuilder<AutoDateHistogramAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.AutoDateHistogram;
    }

    /**
     * The target number of buckets.
     * <p>
     * API name: {@code buckets}
     * </p>
     */
    @Nullable
    public final Integer buckets() {
        return this.buckets;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
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
     * API name: {@code minimum_interval}
     */
    @Nullable
    public final MinimumInterval minimumInterval() {
        return this.minimumInterval;
    }

    /**
     * API name: {@code missing}
     */
    @Nullable
    public final String missing() {
        return this.missing;
    }

    /**
     * Time zone specified as a ISO 8601 UTC offset.
     * <p>
     * API name: {@code offset}
     * </p>
     */
    @Nullable
    public final String offset() {
        return this.offset;
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
        if (this.buckets != null) {
            generator.writeKey("buckets");
            generator.write(this.buckets);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.format != null) {
            generator.writeKey("format");
            generator.write(this.format);
        }

        if (this.minimumInterval != null) {
            generator.writeKey("minimum_interval");
            this.minimumInterval.serialize(generator, mapper);
        }

        if (this.missing != null) {
            generator.writeKey("missing");
            generator.write(this.missing);
        }

        if (this.offset != null) {
            generator.writeKey("offset");
            generator.write(this.offset);
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
     * Builder for {@link AutoDateHistogramAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, AutoDateHistogramAggregation> {
        @Nullable
        private Integer buckets;
        @Nullable
        private String field;
        @Nullable
        private String format;
        @Nullable
        private MinimumInterval minimumInterval;
        @Nullable
        private String missing;
        @Nullable
        private String offset;
        @Nullable
        private Map<String, JsonData> params;
        @Nullable
        private Script script;
        @Nullable
        private String timeZone;

        public Builder() {}

        private Builder(AutoDateHistogramAggregation o) {
            super(o);
            this.buckets = o.buckets;
            this.field = o.field;
            this.format = o.format;
            this.minimumInterval = o.minimumInterval;
            this.missing = o.missing;
            this.offset = o.offset;
            this.params = _mapCopy(o.params);
            this.script = o.script;
            this.timeZone = o.timeZone;
        }

        private Builder(Builder o) {
            super(o);
            this.buckets = o.buckets;
            this.field = o.field;
            this.format = o.format;
            this.minimumInterval = o.minimumInterval;
            this.missing = o.missing;
            this.offset = o.offset;
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
         * The target number of buckets.
         * <p>
         * API name: {@code buckets}
         * </p>
         */
        @Nonnull
        public final Builder buckets(@Nullable Integer value) {
            this.buckets = value;
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
         * API name: {@code minimum_interval}
         */
        @Nonnull
        public final Builder minimumInterval(@Nullable MinimumInterval value) {
            this.minimumInterval = value;
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
         * Time zone specified as a ISO 8601 UTC offset.
         * <p>
         * API name: {@code offset}
         * </p>
         */
        @Nonnull
        public final Builder offset(@Nullable String value) {
            this.offset = value;
            return this;
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
         * Builds a {@link AutoDateHistogramAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AutoDateHistogramAggregation build() {
            _checkSingleUse();

            return new AutoDateHistogramAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AutoDateHistogramAggregation}
     */
    public static final JsonpDeserializer<AutoDateHistogramAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AutoDateHistogramAggregation::setupAutoDateHistogramAggregationDeserializer
    );

    protected static void setupAutoDateHistogramAggregationDeserializer(ObjectDeserializer<AutoDateHistogramAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::buckets, JsonpDeserializer.integerDeserializer(), "buckets");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::minimumInterval, MinimumInterval._DESERIALIZER, "minimum_interval");
        op.add(Builder::missing, JsonpDeserializer.stringDeserializer(), "missing");
        op.add(Builder::offset, JsonpDeserializer.stringDeserializer(), "offset");
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::script, Script._DESERIALIZER, "script");
        op.add(Builder::timeZone, JsonpDeserializer.stringDeserializer(), "time_zone");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.buckets);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.minimumInterval);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.offset);
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
        AutoDateHistogramAggregation other = (AutoDateHistogramAggregation) o;
        return Objects.equals(this.buckets, other.buckets)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.minimumInterval, other.minimumInterval)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.offset, other.offset)
            && Objects.equals(this.params, other.params)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.timeZone, other.timeZone);
    }
}
