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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.GeoPolygonQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoPolygonQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<GeoPolygonQuery.Builder, GeoPolygonQuery> {

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nonnull
    private final GeoPolygonPoints polygon;

    @Nullable
    private final GeoValidationMethod validationMethod;

    // ---------------------------------------------------------------------------------------------

    private GeoPolygonQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.polygon = ApiTypeHelper.requireNonNull(builder.polygon, this, "polygon");
        this.validationMethod = builder.validationMethod;
    }

    public static GeoPolygonQuery of(Function<GeoPolygonQuery.Builder, ObjectBuilder<GeoPolygonQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.GeoPolygon;
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
     */
    @Nonnull
    public final GeoPolygonPoints polygon() {
        return this.polygon;
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
        this.polygon.serialize(generator, mapper);
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
     * Builder for {@link GeoPolygonQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GeoPolygonQuery> {
        private String field;
        @Nullable
        private Boolean ignoreUnmapped;
        private GeoPolygonPoints polygon;
        @Nullable
        private GeoValidationMethod validationMethod;

        public Builder() {}

        private Builder(GeoPolygonQuery o) {
            super(o);
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.polygon = o.polygon;
            this.validationMethod = o.validationMethod;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.polygon = o.polygon;
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
         */
        @Nonnull
        public final Builder polygon(GeoPolygonPoints value) {
            this.polygon = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder polygon(Function<GeoPolygonPoints.Builder, ObjectBuilder<GeoPolygonPoints>> fn) {
            return polygon(fn.apply(new GeoPolygonPoints.Builder()).build());
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
         * Builds a {@link GeoPolygonQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoPolygonQuery build() {
            _checkSingleUse();

            return new GeoPolygonQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoPolygonQuery}
     */
    public static final JsonpDeserializer<GeoPolygonQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoPolygonQuery::setupGeoPolygonQueryDeserializer
    );

    protected static void setupGeoPolygonQueryDeserializer(ObjectDeserializer<GeoPolygonQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.add(Builder::validationMethod, GeoValidationMethod._DESERIALIZER, "validation_method");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.polygon(GeoPolygonPoints._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + this.polygon.hashCode();
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
        GeoPolygonQuery other = (GeoPolygonQuery) o;
        return this.field.equals(other.field)
            && Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && this.polygon.equals(other.polygon)
            && Objects.equals(this.validationMethod, other.validationMethod);
    }
}
