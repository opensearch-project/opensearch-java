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
import org.opensearch.client.opensearch._types.GeoBounds;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GeoTileGridAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoTileGridAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<GeoTileGridAggregation.Builder, GeoTileGridAggregation> {

    @Nullable
    private final GeoBounds bounds;

    @Nullable
    private final String field;

    @Nullable
    private final Number precision;

    @Nullable
    private final Integer shardSize;

    @Nullable
    private final Integer size;

    // ---------------------------------------------------------------------------------------------

    private GeoTileGridAggregation(Builder builder) {
        super(builder);
        this.bounds = builder.bounds;
        this.field = builder.field;
        this.precision = builder.precision;
        this.shardSize = builder.shardSize;
        this.size = builder.size;
    }

    public static GeoTileGridAggregation of(Function<GeoTileGridAggregation.Builder, ObjectBuilder<GeoTileGridAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.GeotileGrid;
    }

    /**
     * API name: {@code bounds}
     */
    @Nullable
    public final GeoBounds bounds() {
        return this.bounds;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code precision}
     */
    @Nullable
    public final Number precision() {
        return this.precision;
    }

    /**
     * Allows for more accurate counting of the top cells returned in the final result the aggregation. Defaults to returning
     * <code>max(10,(size x number-of-shards))</code> buckets from each shard.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
    }

    /**
     * The maximum number of buckets to return.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.bounds != null) {
            generator.writeKey("bounds");
            this.bounds.serialize(generator, mapper);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.precision != null) {
            generator.writeKey("precision");
            generator.write(this.precision.doubleValue());
        }

        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
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
     * Builder for {@link GeoTileGridAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GeoTileGridAggregation> {
        @Nullable
        private GeoBounds bounds;
        @Nullable
        private String field;
        @Nullable
        private Number precision;
        @Nullable
        private Integer shardSize;
        @Nullable
        private Integer size;

        public Builder() {}

        private Builder(GeoTileGridAggregation o) {
            super(o);
            this.bounds = o.bounds;
            this.field = o.field;
            this.precision = o.precision;
            this.shardSize = o.shardSize;
            this.size = o.size;
        }

        private Builder(Builder o) {
            super(o);
            this.bounds = o.bounds;
            this.field = o.field;
            this.precision = o.precision;
            this.shardSize = o.shardSize;
            this.size = o.size;
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
         * API name: {@code bounds}
         */
        @Nonnull
        public final Builder bounds(@Nullable GeoBounds value) {
            this.bounds = value;
            return this;
        }

        /**
         * API name: {@code bounds}
         */
        @Nonnull
        public final Builder bounds(Function<GeoBounds.Builder, ObjectBuilder<GeoBounds>> fn) {
            return bounds(fn.apply(new GeoBounds.Builder()).build());
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
         * API name: {@code precision}
         */
        @Nonnull
        public final Builder precision(@Nullable Number value) {
            this.precision = value;
            return this;
        }

        /**
         * Allows for more accurate counting of the top cells returned in the final result the aggregation. Defaults to returning
         * <code>max(10,(size x number-of-shards))</code> buckets from each shard.
         * <p>
         * API name: {@code shard_size}
         * </p>
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * The maximum number of buckets to return.
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
         * Builds a {@link GeoTileGridAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoTileGridAggregation build() {
            _checkSingleUse();

            return new GeoTileGridAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoTileGridAggregation}
     */
    public static final JsonpDeserializer<GeoTileGridAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoTileGridAggregation::setupGeoTileGridAggregationDeserializer
    );

    protected static void setupGeoTileGridAggregationDeserializer(ObjectDeserializer<GeoTileGridAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::bounds, GeoBounds._DESERIALIZER, "bounds");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::precision, JsonpDeserializer.numberDeserializer(), "precision");
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.bounds);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.precision);
        result = 31 * result + Objects.hashCode(this.shardSize);
        result = 31 * result + Objects.hashCode(this.size);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoTileGridAggregation other = (GeoTileGridAggregation) o;
        return Objects.equals(this.bounds, other.bounds)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.precision, other.precision)
            && Objects.equals(this.shardSize, other.shardSize)
            && Objects.equals(this.size, other.size);
    }
}
