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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.RangeAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RangeAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<RangeAggregation.Builder, RangeAggregation> {

    @Nullable
    private final String field;

    @Nullable
    private final String format;

    @Nullable
    private final Boolean keyed;

    @Nullable
    private final Integer missing;

    @Nonnull
    private final List<AggregationRange> ranges;

    @Nullable
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    private RangeAggregation(Builder builder) {
        super(builder);
        this.field = builder.field;
        this.format = builder.format;
        this.keyed = builder.keyed;
        this.missing = builder.missing;
        this.ranges = ApiTypeHelper.unmodifiable(builder.ranges);
        this.script = builder.script;
    }

    public static RangeAggregation of(Function<RangeAggregation.Builder, ObjectBuilder<RangeAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Range;
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
     * The value to apply to documents that do not have a value. By default, documents without a value are ignored.
     * <p>
     * API name: {@code missing}
     * </p>
     */
    @Nullable
    public final Integer missing() {
        return this.missing;
    }

    /**
     * An array of ranges used to bucket documents.
     * <p>
     * API name: {@code ranges}
     * </p>
     */
    @Nonnull
    public final List<AggregationRange> ranges() {
        return this.ranges;
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
            generator.write(this.missing);
        }

        if (ApiTypeHelper.isDefined(this.ranges)) {
            generator.writeKey("ranges");
            generator.writeStartArray();
            for (AggregationRange item0 : this.ranges) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link RangeAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RangeAggregation> {
        @Nullable
        private String field;
        @Nullable
        private String format;
        @Nullable
        private Boolean keyed;
        @Nullable
        private Integer missing;
        @Nullable
        private List<AggregationRange> ranges;
        @Nullable
        private Script script;

        public Builder() {}

        private Builder(RangeAggregation o) {
            super(o);
            this.field = o.field;
            this.format = o.format;
            this.keyed = o.keyed;
            this.missing = o.missing;
            this.ranges = _listCopy(o.ranges);
            this.script = o.script;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.format = o.format;
            this.keyed = o.keyed;
            this.missing = o.missing;
            this.ranges = _listCopy(o.ranges);
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
         * The value to apply to documents that do not have a value. By default, documents without a value are ignored.
         * <p>
         * API name: {@code missing}
         * </p>
         */
        @Nonnull
        public final Builder missing(@Nullable Integer value) {
            this.missing = value;
            return this;
        }

        /**
         * An array of ranges used to bucket documents.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>ranges</code>.
         * </p>
         */
        @Nonnull
        public final Builder ranges(List<AggregationRange> list) {
            this.ranges = _listAddAll(this.ranges, list);
            return this;
        }

        /**
         * An array of ranges used to bucket documents.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>ranges</code>.
         * </p>
         */
        @Nonnull
        public final Builder ranges(AggregationRange value, AggregationRange... values) {
            this.ranges = _listAdd(this.ranges, value, values);
            return this;
        }

        /**
         * An array of ranges used to bucket documents.
         * <p>
         * API name: {@code ranges}
         * </p>
         *
         * <p>
         * Adds a value to <code>ranges</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder ranges(Function<AggregationRange.Builder, ObjectBuilder<AggregationRange>> fn) {
            return ranges(fn.apply(new AggregationRange.Builder()).build());
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
         * Builds a {@link RangeAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RangeAggregation build() {
            _checkSingleUse();

            return new RangeAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RangeAggregation}
     */
    public static final JsonpDeserializer<RangeAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RangeAggregation::setupRangeAggregationDeserializer
    );

    protected static void setupRangeAggregationDeserializer(ObjectDeserializer<RangeAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::format, JsonpDeserializer.stringDeserializer(), "format");
        op.add(Builder::keyed, JsonpDeserializer.booleanDeserializer(), "keyed");
        op.add(Builder::missing, JsonpDeserializer.integerDeserializer(), "missing");
        op.add(Builder::ranges, JsonpDeserializer.arrayDeserializer(AggregationRange._DESERIALIZER), "ranges");
        op.add(Builder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.keyed);
        result = 31 * result + Objects.hashCode(this.missing);
        result = 31 * result + Objects.hashCode(this.ranges);
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
        RangeAggregation other = (RangeAggregation) o;
        return Objects.equals(this.field, other.field)
            && Objects.equals(this.format, other.format)
            && Objects.equals(this.keyed, other.keyed)
            && Objects.equals(this.missing, other.missing)
            && Objects.equals(this.ranges, other.ranges)
            && Objects.equals(this.script, other.script);
    }
}
