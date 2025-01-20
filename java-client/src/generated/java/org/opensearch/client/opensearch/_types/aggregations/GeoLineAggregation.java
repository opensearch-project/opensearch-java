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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GeoLineAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoLineAggregation
    implements
        AggregationVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<GeoLineAggregation.Builder, GeoLineAggregation> {

    @Nullable
    private final Boolean includeSort;

    @Nonnull
    private final GeoLinePoint point;

    @Nullable
    private final Integer size;

    @Nonnull
    private final GeoLineSort sort;

    @Nullable
    private final SortOrder sortOrder;

    // ---------------------------------------------------------------------------------------------

    private GeoLineAggregation(Builder builder) {
        this.includeSort = builder.includeSort;
        this.point = ApiTypeHelper.requireNonNull(builder.point, this, "point");
        this.size = builder.size;
        this.sort = ApiTypeHelper.requireNonNull(builder.sort, this, "sort");
        this.sortOrder = builder.sortOrder;
    }

    public static GeoLineAggregation of(Function<GeoLineAggregation.Builder, ObjectBuilder<GeoLineAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Line;
    }

    /**
     * When <code>true</code>, returns an additional array of the sort values in the feature properties.
     * <p>
     * API name: {@code include_sort}
     * </p>
     */
    @Nullable
    public final Boolean includeSort() {
        return this.includeSort;
    }

    /**
     * Required - API name: {@code point}
     */
    @Nonnull
    public final GeoLinePoint point() {
        return this.point;
    }

    /**
     * The maximum length of the line represented in the aggregation. Valid sizes are between 1 and 10000.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * Required - API name: {@code sort}
     */
    @Nonnull
    public final GeoLineSort sort() {
        return this.sort;
    }

    /**
     * API name: {@code sort_order}
     */
    @Nullable
    public final SortOrder sortOrder() {
        return this.sortOrder;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.includeSort != null) {
            generator.writeKey("include_sort");
            generator.write(this.includeSort);
        }

        generator.writeKey("point");
        this.point.serialize(generator, mapper);

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        generator.writeKey("sort");
        this.sort.serialize(generator, mapper);

        if (this.sortOrder != null) {
            generator.writeKey("sort_order");
            this.sortOrder.serialize(generator, mapper);
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
     * Builder for {@link GeoLineAggregation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoLineAggregation> {
        @Nullable
        private Boolean includeSort;
        private GeoLinePoint point;
        @Nullable
        private Integer size;
        private GeoLineSort sort;
        @Nullable
        private SortOrder sortOrder;

        public Builder() {}

        private Builder(GeoLineAggregation o) {
            this.includeSort = o.includeSort;
            this.point = o.point;
            this.size = o.size;
            this.sort = o.sort;
            this.sortOrder = o.sortOrder;
        }

        private Builder(Builder o) {
            this.includeSort = o.includeSort;
            this.point = o.point;
            this.size = o.size;
            this.sort = o.sort;
            this.sortOrder = o.sortOrder;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * When <code>true</code>, returns an additional array of the sort values in the feature properties.
         * <p>
         * API name: {@code include_sort}
         * </p>
         */
        @Nonnull
        public final Builder includeSort(@Nullable Boolean value) {
            this.includeSort = value;
            return this;
        }

        /**
         * Required - API name: {@code point}
         */
        @Nonnull
        public final Builder point(GeoLinePoint value) {
            this.point = value;
            return this;
        }

        /**
         * Required - API name: {@code point}
         */
        @Nonnull
        public final Builder point(Function<GeoLinePoint.Builder, ObjectBuilder<GeoLinePoint>> fn) {
            return point(fn.apply(new GeoLinePoint.Builder()).build());
        }

        /**
         * The maximum length of the line represented in the aggregation. Valid sizes are between 1 and 10000.
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
         * Required - API name: {@code sort}
         */
        @Nonnull
        public final Builder sort(GeoLineSort value) {
            this.sort = value;
            return this;
        }

        /**
         * Required - API name: {@code sort}
         */
        @Nonnull
        public final Builder sort(Function<GeoLineSort.Builder, ObjectBuilder<GeoLineSort>> fn) {
            return sort(fn.apply(new GeoLineSort.Builder()).build());
        }

        /**
         * API name: {@code sort_order}
         */
        @Nonnull
        public final Builder sortOrder(@Nullable SortOrder value) {
            this.sortOrder = value;
            return this;
        }

        /**
         * Builds a {@link GeoLineAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoLineAggregation build() {
            _checkSingleUse();

            return new GeoLineAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoLineAggregation}
     */
    public static final JsonpDeserializer<GeoLineAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoLineAggregation::setupGeoLineAggregationDeserializer
    );

    protected static void setupGeoLineAggregationDeserializer(ObjectDeserializer<GeoLineAggregation.Builder> op) {
        op.add(Builder::includeSort, JsonpDeserializer.booleanDeserializer(), "include_sort");
        op.add(Builder::point, GeoLinePoint._DESERIALIZER, "point");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::sort, GeoLineSort._DESERIALIZER, "sort");
        op.add(Builder::sortOrder, SortOrder._DESERIALIZER, "sort_order");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.includeSort);
        result = 31 * result + this.point.hashCode();
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + this.sort.hashCode();
        result = 31 * result + Objects.hashCode(this.sortOrder);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoLineAggregation other = (GeoLineAggregation) o;
        return Objects.equals(this.includeSort, other.includeSort)
            && this.point.equals(other.point)
            && Objects.equals(this.size, other.size)
            && this.sort.equals(other.sort)
            && Objects.equals(this.sortOrder, other.sortOrder);
    }
}
