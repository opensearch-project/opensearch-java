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

package org.opensearch.client.opensearch._types.query_dsl;

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
import org.opensearch.client.opensearch._types.GeoDistanceType;
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.GeoDistanceQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoDistanceQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<GeoDistanceQuery.Builder, GeoDistanceQuery> {

    @Nonnull
    private final String distance;

    @Nullable
    private final GeoDistanceType distanceType;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nonnull
    private final GeoLocation location;

    @Nullable
    private final GeoValidationMethod validationMethod;

    // ---------------------------------------------------------------------------------------------

    private GeoDistanceQuery(Builder builder) {
        super(builder);
        this.distance = ApiTypeHelper.requireNonNull(builder.distance, this, "distance");
        this.distanceType = builder.distanceType;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.location = ApiTypeHelper.requireNonNull(builder.location, this, "location");
        this.validationMethod = builder.validationMethod;
    }

    public static GeoDistanceQuery of(Function<GeoDistanceQuery.Builder, ObjectBuilder<GeoDistanceQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.GeoDistance;
    }

    /**
     * Required - API name: {@code distance}
     */
    @Nonnull
    public final String distance() {
        return this.distance;
    }

    /**
     * API name: {@code distance_type}
     */
    @Nullable
    public final GeoDistanceType distanceType() {
        return this.distanceType;
    }

    /**
     * Required -
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code ignore_unmapped}
     */
    @Nullable
    public final Boolean ignoreUnmapped() {
        return this.ignoreUnmapped;
    }

    /**
     * Required -
     * <p>
     * A latitude/longitude as a two-dimensional point. It can be represented in the following ways:
     * </p>
     * <ul>
     * <li>As a <code>{lat, long}</code> object.</li>
     * <li>As a geohash value.</li>
     * <li>As a <code>[lon, lat]</code> array.</li>
     * <li>As a string in <code>&lt;lat&gt;, &lt;lon&gt;</code> or WKT point format.</li>
     * </ul>
     */
    @Nonnull
    public final GeoLocation location() {
        return this.location;
    }

    /**
     * API name: {@code validation_method}
     */
    @Nullable
    public final GeoValidationMethod validationMethod() {
        return this.validationMethod;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey(this.field);
        this.location.serialize(generator, mapper);
        generator.writeKey("distance");
        generator.write(this.distance);

        if (this.distanceType != null) {
            generator.writeKey("distance_type");
            this.distanceType.serialize(generator, mapper);
        }

        if (this.ignoreUnmapped != null) {
            generator.writeKey("ignore_unmapped");
            generator.write(this.ignoreUnmapped);
        }

        if (this.validationMethod != null) {
            generator.writeKey("validation_method");
            this.validationMethod.serialize(generator, mapper);
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
     * Builder for {@link GeoDistanceQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GeoDistanceQuery> {
        private String distance;
        @Nullable
        private GeoDistanceType distanceType;
        private String field;
        @Nullable
        private Boolean ignoreUnmapped;
        private GeoLocation location;
        @Nullable
        private GeoValidationMethod validationMethod;

        public Builder() {}

        private Builder(GeoDistanceQuery o) {
            super(o);
            this.distance = o.distance;
            this.distanceType = o.distanceType;
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.location = o.location;
            this.validationMethod = o.validationMethod;
        }

        private Builder(Builder o) {
            super(o);
            this.distance = o.distance;
            this.distanceType = o.distanceType;
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.location = o.location;
            this.validationMethod = o.validationMethod;
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
         * Required - API name: {@code distance}
         */
        @Nonnull
        public final Builder distance(String value) {
            this.distance = value;
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
         * Required -
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code ignore_unmapped}
         */
        @Nonnull
        public final Builder ignoreUnmapped(@Nullable Boolean value) {
            this.ignoreUnmapped = value;
            return this;
        }

        /**
         * Required -
         * <p>
         * A latitude/longitude as a two-dimensional point. It can be represented in the following ways:
         * </p>
         * <ul>
         * <li>As a <code>{lat, long}</code> object.</li>
         * <li>As a geohash value.</li>
         * <li>As a <code>[lon, lat]</code> array.</li>
         * <li>As a string in <code>&lt;lat&gt;, &lt;lon&gt;</code> or WKT point format.</li>
         * </ul>
         */
        @Nonnull
        public final Builder location(GeoLocation value) {
            this.location = value;
            return this;
        }

        /**
         * Required -
         * <p>
         * A latitude/longitude as a two-dimensional point. It can be represented in the following ways:
         * </p>
         * <ul>
         * <li>As a <code>{lat, long}</code> object.</li>
         * <li>As a geohash value.</li>
         * <li>As a <code>[lon, lat]</code> array.</li>
         * <li>As a string in <code>&lt;lat&gt;, &lt;lon&gt;</code> or WKT point format.</li>
         * </ul>
         */
        @Nonnull
        public final Builder location(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return location(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * API name: {@code validation_method}
         */
        @Nonnull
        public final Builder validationMethod(@Nullable GeoValidationMethod value) {
            this.validationMethod = value;
            return this;
        }

        /**
         * Builds a {@link GeoDistanceQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoDistanceQuery build() {
            _checkSingleUse();

            return new GeoDistanceQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoDistanceQuery}
     */
    public static final JsonpDeserializer<GeoDistanceQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoDistanceQuery::setupGeoDistanceQueryDeserializer
    );

    protected static void setupGeoDistanceQueryDeserializer(ObjectDeserializer<GeoDistanceQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::distance, JsonpDeserializer.stringDeserializer(), "distance");
        op.add(Builder::distanceType, GeoDistanceType._DESERIALIZER, "distance_type");
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.add(Builder::validationMethod, GeoValidationMethod._DESERIALIZER, "validation_method");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.location(GeoLocation._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.distance.hashCode();
        result = 31 * result + Objects.hashCode(this.distanceType);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + this.location.hashCode();
        result = 31 * result + Objects.hashCode(this.validationMethod);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoDistanceQuery other = (GeoDistanceQuery) o;
        return this.distance.equals(other.distance)
            && Objects.equals(this.distanceType, other.distanceType)
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && this.location.equals(other.location)
            && Objects.equals(this.validationMethod, other.validationMethod);
    }
}
