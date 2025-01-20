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

// typedef: _types.aggregations.CompositeGeoTileGridAggregationSource

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompositeGeoTileGridAggregationSource extends CompositeValuesSource
    implements
        ToCopyableBuilder<CompositeGeoTileGridAggregationSource.Builder, CompositeGeoTileGridAggregationSource> {

    @Nullable
    private final GeoBounds bounds;

    @Nullable
    private final Integer precision;

    // ---------------------------------------------------------------------------------------------

    private CompositeGeoTileGridAggregationSource(Builder builder) {
        super(builder);
        this.bounds = builder.bounds;
        this.precision = builder.precision;
    }

    public static CompositeGeoTileGridAggregationSource of(
        Function<CompositeGeoTileGridAggregationSource.Builder, ObjectBuilder<CompositeGeoTileGridAggregationSource>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code bounds}
     */
    @Nullable
    public final GeoBounds bounds() {
        return this.bounds;
    }

    /**
     * API name: {@code precision}
     */
    @Nullable
    public final Integer precision() {
        return this.precision;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.bounds != null) {
            generator.writeKey("bounds");
            this.bounds.serialize(generator, mapper);
        }

        if (this.precision != null) {
            generator.writeKey("precision");
            generator.write(this.precision);
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
     * Builder for {@link CompositeGeoTileGridAggregationSource}.
     */
    public static class Builder extends CompositeValuesSource.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CompositeGeoTileGridAggregationSource> {
        @Nullable
        private GeoBounds bounds;
        @Nullable
        private Integer precision;

        public Builder() {}

        private Builder(CompositeGeoTileGridAggregationSource o) {
            super(o);
            this.bounds = o.bounds;
            this.precision = o.precision;
        }

        private Builder(Builder o) {
            super(o);
            this.bounds = o.bounds;
            this.precision = o.precision;
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
         * API name: {@code precision}
         */
        @Nonnull
        public final Builder precision(@Nullable Integer value) {
            this.precision = value;
            return this;
        }

        /**
         * Builds a {@link CompositeGeoTileGridAggregationSource}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompositeGeoTileGridAggregationSource build() {
            _checkSingleUse();

            return new CompositeGeoTileGridAggregationSource(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompositeGeoTileGridAggregationSource}
     */
    public static final JsonpDeserializer<CompositeGeoTileGridAggregationSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompositeGeoTileGridAggregationSource::setupCompositeGeoTileGridAggregationSourceDeserializer
    );

    protected static void setupCompositeGeoTileGridAggregationSourceDeserializer(
        ObjectDeserializer<CompositeGeoTileGridAggregationSource.Builder> op
    ) {
        setupCompositeValuesSourceDeserializer(op);
        op.add(Builder::bounds, GeoBounds._DESERIALIZER, "bounds");
        op.add(Builder::precision, JsonpDeserializer.integerDeserializer(), "precision");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.bounds);
        result = 31 * result + Objects.hashCode(this.precision);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompositeGeoTileGridAggregationSource other = (CompositeGeoTileGridAggregationSource) o;
        return Objects.equals(this.bounds, other.bounds) && Objects.equals(this.precision, other.precision);
    }
}
