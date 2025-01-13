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
import org.opensearch.client.opensearch._types.DistanceUnit;
import org.opensearch.client.opensearch._types.GeoDistanceType;
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GeoDistanceAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoDistanceAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<GeoDistanceAggregation.Builder, GeoDistanceAggregation> {

    @Nullable
    private final GeoDistanceType distanceType;

    @Nullable
    private final String field;

    @Nullable
    private final GeoLocation origin;

    @Nonnull
    private final List<AggregationRange> ranges;

    @Nullable
    private final DistanceUnit unit;

    // ---------------------------------------------------------------------------------------------

    private GeoDistanceAggregation(Builder builder) {
        super(builder);
        this.distanceType = builder.distanceType;
        this.field = builder.field;
        this.origin = builder.origin;
        this.ranges = ApiTypeHelper.unmodifiable(builder.ranges);
        this.unit = builder.unit;
    }

    public static GeoDistanceAggregation of(Function<GeoDistanceAggregation.Builder, ObjectBuilder<GeoDistanceAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.GeoDistance;
    }

    /**
     * API name: {@code distance_type}
     */
    @Nullable
    public final GeoDistanceType distanceType() {
        return this.distanceType;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code origin}
     */
    @Nullable
    public final GeoLocation origin() {
        return this.origin;
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
     * API name: {@code unit}
     */
    @Nullable
    public final DistanceUnit unit() {
        return this.unit;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.distanceType != null) {
            generator.writeKey("distance_type");
            this.distanceType.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.origin != null) {
            generator.writeKey("origin");
            this.origin.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.ranges)) {
            generator.writeKey("ranges");
            generator.writeStartArray();
            for (AggregationRange item0 : this.ranges) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.unit != null) {
            generator.writeKey("unit");
            this.unit.serialize(generator, mapper);
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
     * Builder for {@link GeoDistanceAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GeoDistanceAggregation> {
        @Nullable
        private GeoDistanceType distanceType;
        @Nullable
        private String field;
        @Nullable
        private GeoLocation origin;
        @Nullable
        private List<AggregationRange> ranges;
        @Nullable
        private DistanceUnit unit;

        public Builder() {}

        private Builder(GeoDistanceAggregation o) {
            super(o);
            this.distanceType = o.distanceType;
            this.field = o.field;
            this.origin = o.origin;
            this.ranges = _listCopy(o.ranges);
            this.unit = o.unit;
        }

        private Builder(Builder o) {
            super(o);
            this.distanceType = o.distanceType;
            this.field = o.field;
            this.origin = o.origin;
            this.ranges = _listCopy(o.ranges);
            this.unit = o.unit;
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
         * API name: {@code distance_type}
         */
        @Nonnull
        public final Builder distanceType(@Nullable GeoDistanceType value) {
            this.distanceType = value;
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
         * API name: {@code origin}
         */
        @Nonnull
        public final Builder origin(@Nullable GeoLocation value) {
            this.origin = value;
            return this;
        }

        /**
         * API name: {@code origin}
         */
        @Nonnull
        public final Builder origin(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return origin(fn.apply(new GeoLocation.Builder()).build());
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
         * API name: {@code unit}
         */
        @Nonnull
        public final Builder unit(@Nullable DistanceUnit value) {
            this.unit = value;
            return this;
        }

        /**
         * Builds a {@link GeoDistanceAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoDistanceAggregation build() {
            _checkSingleUse();

            return new GeoDistanceAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoDistanceAggregation}
     */
    public static final JsonpDeserializer<GeoDistanceAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoDistanceAggregation::setupGeoDistanceAggregationDeserializer
    );

    protected static void setupGeoDistanceAggregationDeserializer(ObjectDeserializer<GeoDistanceAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::distanceType, GeoDistanceType._DESERIALIZER, "distance_type");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::origin, GeoLocation._DESERIALIZER, "origin");
        op.add(Builder::ranges, JsonpDeserializer.arrayDeserializer(AggregationRange._DESERIALIZER), "ranges");
        op.add(Builder::unit, DistanceUnit._DESERIALIZER, "unit");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.distanceType);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.origin);
        result = 31 * result + Objects.hashCode(this.ranges);
        result = 31 * result + Objects.hashCode(this.unit);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoDistanceAggregation other = (GeoDistanceAggregation) o;
        return Objects.equals(this.distanceType, other.distanceType)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.origin, other.origin)
            && Objects.equals(this.ranges, other.ranges)
            && Objects.equals(this.unit, other.unit);
    }
}
