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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.GeoBoundsAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoBoundsAggregation extends MetricAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<GeoBoundsAggregation.Builder, GeoBoundsAggregation> {

    @Nullable
    private final Boolean wrapLongitude;

    // ---------------------------------------------------------------------------------------------

    private GeoBoundsAggregation(Builder builder) {
        super(builder);
        this.wrapLongitude = builder.wrapLongitude;
    }

    public static GeoBoundsAggregation of(Function<GeoBoundsAggregation.Builder, ObjectBuilder<GeoBoundsAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.GeoBounds;
    }

    /**
     * Specifies whether the bounding box should be allowed to overlap the international date line.
     * <p>
     * API name: {@code wrap_longitude}
     * </p>
     */
    @Nullable
    public final Boolean wrapLongitude() {
        return this.wrapLongitude;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.wrapLongitude != null) {
            generator.writeKey("wrap_longitude");
            generator.write(this.wrapLongitude);
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
     * Builder for {@link GeoBoundsAggregation}.
     */
    public static class Builder extends MetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GeoBoundsAggregation> {
        @Nullable
        private Boolean wrapLongitude;

        public Builder() {}

        private Builder(GeoBoundsAggregation o) {
            super(o);
            this.wrapLongitude = o.wrapLongitude;
        }

        private Builder(Builder o) {
            super(o);
            this.wrapLongitude = o.wrapLongitude;
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
         * Specifies whether the bounding box should be allowed to overlap the international date line.
         * <p>
         * API name: {@code wrap_longitude}
         * </p>
         */
        @Nonnull
        public final Builder wrapLongitude(@Nullable Boolean value) {
            this.wrapLongitude = value;
            return this;
        }

        /**
         * Builds a {@link GeoBoundsAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoBoundsAggregation build() {
            _checkSingleUse();

            return new GeoBoundsAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoBoundsAggregation}
     */
    public static final JsonpDeserializer<GeoBoundsAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoBoundsAggregation::setupGeoBoundsAggregationDeserializer
    );

    protected static void setupGeoBoundsAggregationDeserializer(ObjectDeserializer<GeoBoundsAggregation.Builder> op) {
        setupMetricAggregationBaseDeserializer(op);
        op.add(Builder::wrapLongitude, JsonpDeserializer.booleanDeserializer(), "wrap_longitude");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.wrapLongitude);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoBoundsAggregation other = (GeoBoundsAggregation) o;
        return Objects.equals(this.wrapLongitude, other.wrapLongitude);
    }
}
