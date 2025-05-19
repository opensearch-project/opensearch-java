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
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GeoCentroidAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoCentroidAggregation extends MetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<GeoCentroidAggregation.Builder, GeoCentroidAggregation> {

    @Nullable
    private final Long count;

    @Nullable
    private final GeoLocation location;

    // ---------------------------------------------------------------------------------------------

    private GeoCentroidAggregation(Builder builder) {
        super(builder);
        this.count = builder.count;
        this.location = builder.location;
    }

    public static GeoCentroidAggregation of(Function<GeoCentroidAggregation.Builder, ObjectBuilder<GeoCentroidAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.GeoCentroid;
    }

    /**
     * API name: {@code count}
     */
    @Nullable
    public final Long count() {
        return this.count;
    }

    /**
     * API name: {@code location}
     */
    @Nullable
    public final GeoLocation location() {
        return this.location;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.location != null) {
            generator.writeKey("location");
            this.location.serialize(generator, mapper);
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
     * Builder for {@link GeoCentroidAggregation}.
     */
    public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GeoCentroidAggregation> {
        @Nullable
        private Long count;
        @Nullable
        private GeoLocation location;

        public Builder() {}

        private Builder(GeoCentroidAggregation o) {
            super(o);
            this.count = o.count;
            this.location = o.location;
        }

        private Builder(Builder o) {
            super(o);
            this.count = o.count;
            this.location = o.location;
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
         * API name: {@code count}
         */
        @Nonnull
        public final Builder count(@Nullable Long value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code location}
         */
        @Nonnull
        public final Builder location(@Nullable GeoLocation value) {
            this.location = value;
            return this;
        }

        /**
         * API name: {@code location}
         */
        @Nonnull
        public final Builder location(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return location(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Builds a {@link GeoCentroidAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoCentroidAggregation build() {
            _checkSingleUse();

            return new GeoCentroidAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoCentroidAggregation}
     */
    public static final JsonpDeserializer<GeoCentroidAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoCentroidAggregation::setupGeoCentroidAggregationDeserializer
    );

    protected static void setupGeoCentroidAggregationDeserializer(ObjectDeserializer<GeoCentroidAggregation.Builder> op) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::location, GeoLocation._DESERIALIZER, "location");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.location);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoCentroidAggregation other = (GeoCentroidAggregation) o;
        return Objects.equals(this.count, other.count) && Objects.equals(this.location, other.location);
    }
}
