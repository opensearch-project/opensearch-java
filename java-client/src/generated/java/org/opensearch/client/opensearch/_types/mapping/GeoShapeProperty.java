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

package org.opensearch.client.opensearch._types.mapping;

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

// typedef: _types.mapping.GeoShapeProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoShapeProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<GeoShapeProperty.Builder, GeoShapeProperty> {

    @Nullable
    private final Boolean coerce;

    @Nullable
    private final Double distanceErrorPct;

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final Boolean ignoreZValue;

    @Nullable
    private final GeoOrientation orientation;

    @Nullable
    private final GeoStrategy strategy;

    // ---------------------------------------------------------------------------------------------

    private GeoShapeProperty(Builder builder) {
        super(builder);
        this.coerce = builder.coerce;
        this.distanceErrorPct = builder.distanceErrorPct;
        this.ignoreMalformed = builder.ignoreMalformed;
        this.ignoreZValue = builder.ignoreZValue;
        this.orientation = builder.orientation;
        this.strategy = builder.strategy;
    }

    public static GeoShapeProperty of(Function<GeoShapeProperty.Builder, ObjectBuilder<GeoShapeProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.GeoShape;
    }

    /**
     * API name: {@code coerce}
     */
    @Nullable
    public final Boolean coerce() {
        return this.coerce;
    }

    /**
     * API name: {@code distance_error_pct}
     */
    @Nullable
    public final Double distanceErrorPct() {
        return this.distanceErrorPct;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
    }

    /**
     * API name: {@code ignore_z_value}
     */
    @Nullable
    public final Boolean ignoreZValue() {
        return this.ignoreZValue;
    }

    /**
     * API name: {@code orientation}
     */
    @Nullable
    public final GeoOrientation orientation() {
        return this.orientation;
    }

    /**
     * API name: {@code strategy}
     */
    @Nullable
    public final GeoStrategy strategy() {
        return this.strategy;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "geo_shape");
        super.serializeInternal(generator, mapper);
        if (this.coerce != null) {
            generator.writeKey("coerce");
            generator.write(this.coerce);
        }

        if (this.distanceErrorPct != null) {
            generator.writeKey("distance_error_pct");
            generator.write(this.distanceErrorPct);
        }

        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.ignoreZValue != null) {
            generator.writeKey("ignore_z_value");
            generator.write(this.ignoreZValue);
        }

        if (this.orientation != null) {
            generator.writeKey("orientation");
            this.orientation.serialize(generator, mapper);
        }

        if (this.strategy != null) {
            generator.writeKey("strategy");
            this.strategy.serialize(generator, mapper);
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
     * Builder for {@link GeoShapeProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GeoShapeProperty> {
        @Nullable
        private Boolean coerce;
        @Nullable
        private Double distanceErrorPct;
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private Boolean ignoreZValue;
        @Nullable
        private GeoOrientation orientation;
        @Nullable
        private GeoStrategy strategy;

        public Builder() {}

        private Builder(GeoShapeProperty o) {
            super(o);
            this.coerce = o.coerce;
            this.distanceErrorPct = o.distanceErrorPct;
            this.ignoreMalformed = o.ignoreMalformed;
            this.ignoreZValue = o.ignoreZValue;
            this.orientation = o.orientation;
            this.strategy = o.strategy;
        }

        private Builder(Builder o) {
            super(o);
            this.coerce = o.coerce;
            this.distanceErrorPct = o.distanceErrorPct;
            this.ignoreMalformed = o.ignoreMalformed;
            this.ignoreZValue = o.ignoreZValue;
            this.orientation = o.orientation;
            this.strategy = o.strategy;
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
         * API name: {@code coerce}
         */
        @Nonnull
        public final Builder coerce(@Nullable Boolean value) {
            this.coerce = value;
            return this;
        }

        /**
         * API name: {@code distance_error_pct}
         */
        @Nonnull
        public final Builder distanceErrorPct(@Nullable Double value) {
            this.distanceErrorPct = value;
            return this;
        }

        /**
         * API name: {@code ignore_malformed}
         */
        @Nonnull
        public final Builder ignoreMalformed(@Nullable Boolean value) {
            this.ignoreMalformed = value;
            return this;
        }

        /**
         * API name: {@code ignore_z_value}
         */
        @Nonnull
        public final Builder ignoreZValue(@Nullable Boolean value) {
            this.ignoreZValue = value;
            return this;
        }

        /**
         * API name: {@code orientation}
         */
        @Nonnull
        public final Builder orientation(@Nullable GeoOrientation value) {
            this.orientation = value;
            return this;
        }

        /**
         * API name: {@code strategy}
         */
        @Nonnull
        public final Builder strategy(@Nullable GeoStrategy value) {
            this.strategy = value;
            return this;
        }

        /**
         * Builds a {@link GeoShapeProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoShapeProperty build() {
            _checkSingleUse();

            return new GeoShapeProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoShapeProperty}
     */
    public static final JsonpDeserializer<GeoShapeProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoShapeProperty::setupGeoShapePropertyDeserializer
    );

    protected static void setupGeoShapePropertyDeserializer(ObjectDeserializer<GeoShapeProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::coerce, JsonpDeserializer.booleanDeserializer(), "coerce");
        op.add(Builder::distanceErrorPct, JsonpDeserializer.doubleDeserializer(), "distance_error_pct");
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::ignoreZValue, JsonpDeserializer.booleanDeserializer(), "ignore_z_value");
        op.add(Builder::orientation, GeoOrientation._DESERIALIZER, "orientation");
        op.add(Builder::strategy, GeoStrategy._DESERIALIZER, "strategy");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.coerce);
        result = 31 * result + Objects.hashCode(this.distanceErrorPct);
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.ignoreZValue);
        result = 31 * result + Objects.hashCode(this.orientation);
        result = 31 * result + Objects.hashCode(this.strategy);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoShapeProperty other = (GeoShapeProperty) o;
        return Objects.equals(this.coerce, other.coerce)
            && Objects.equals(this.distanceErrorPct, other.distanceErrorPct)
            && Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.ignoreZValue, other.ignoreZValue)
            && Objects.equals(this.orientation, other.orientation)
            && Objects.equals(this.strategy, other.strategy);
    }
}
