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
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.GeoPointProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoPointProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<GeoPointProperty.Builder, GeoPointProperty> {

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final Boolean ignoreZValue;

    @Nullable
    private final GeoLocation nullValue;

    // ---------------------------------------------------------------------------------------------

    private GeoPointProperty(Builder builder) {
        super(builder);
        this.ignoreMalformed = builder.ignoreMalformed;
        this.ignoreZValue = builder.ignoreZValue;
        this.nullValue = builder.nullValue;
    }

    public static GeoPointProperty of(Function<GeoPointProperty.Builder, ObjectBuilder<GeoPointProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.GeoPoint;
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
     * API name: {@code null_value}
     */
    @Nullable
    public final GeoLocation nullValue() {
        return this.nullValue;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "geo_point");
        super.serializeInternal(generator, mapper);
        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.ignoreZValue != null) {
            generator.writeKey("ignore_z_value");
            generator.write(this.ignoreZValue);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            this.nullValue.serialize(generator, mapper);
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
     * Builder for {@link GeoPointProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GeoPointProperty> {
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private Boolean ignoreZValue;
        @Nullable
        private GeoLocation nullValue;

        public Builder() {}

        private Builder(GeoPointProperty o) {
            super(o);
            this.ignoreMalformed = o.ignoreMalformed;
            this.ignoreZValue = o.ignoreZValue;
            this.nullValue = o.nullValue;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreMalformed = o.ignoreMalformed;
            this.ignoreZValue = o.ignoreZValue;
            this.nullValue = o.nullValue;
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
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(@Nullable GeoLocation value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(Function<GeoLocation.Builder, ObjectBuilder<GeoLocation>> fn) {
            return nullValue(fn.apply(new GeoLocation.Builder()).build());
        }

        /**
         * Builds a {@link GeoPointProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoPointProperty build() {
            _checkSingleUse();

            return new GeoPointProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoPointProperty}
     */
    public static final JsonpDeserializer<GeoPointProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoPointProperty::setupGeoPointPropertyDeserializer
    );

    protected static void setupGeoPointPropertyDeserializer(ObjectDeserializer<GeoPointProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::ignoreZValue, JsonpDeserializer.booleanDeserializer(), "ignore_z_value");
        op.add(Builder::nullValue, GeoLocation._DESERIALIZER, "null_value");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.ignoreZValue);
        result = 31 * result + Objects.hashCode(this.nullValue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoPointProperty other = (GeoPointProperty) o;
        return Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.ignoreZValue, other.ignoreZValue)
            && Objects.equals(this.nullValue, other.nullValue);
    }
}
