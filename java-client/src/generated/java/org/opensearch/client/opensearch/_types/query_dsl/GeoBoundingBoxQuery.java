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
import org.opensearch.client.opensearch._types.GeoBounds;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.GeoBoundingBoxQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoBoundingBoxQuery extends QueryBase
    implements
        QueryVariant,
        ToCopyableBuilder<GeoBoundingBoxQuery.Builder, GeoBoundingBoxQuery> {

    @Nonnull
    private final GeoBounds boundingBox;

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nullable
    private final GeoExecution type;

    @Nullable
    private final GeoValidationMethod validationMethod;

    // ---------------------------------------------------------------------------------------------

    private GeoBoundingBoxQuery(Builder builder) {
        super(builder);
        this.boundingBox = ApiTypeHelper.requireNonNull(builder.boundingBox, this, "boundingBox");
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.type = builder.type;
        this.validationMethod = builder.validationMethod;
    }

    public static GeoBoundingBoxQuery of(Function<GeoBoundingBoxQuery.Builder, ObjectBuilder<GeoBoundingBoxQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.GeoBoundingBox;
    }

    /**
     * Required -
     * <p>
     * A geo-bounding box. It can be represented in the following ways:
     * </p>
     * <ul>
     * <li>As 4 top/bottom/left/right coordinates.</li>
     * <li>As 2 top_left/bottom_right points.</li>
     * <li>As 2 top_right/bottom_left points.</li>
     * <li>As a Well Known Text (WKT) bounding box.</li>
     * </ul>
     */
    @Nonnull
    public final GeoBounds boundingBox() {
        return this.boundingBox;
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
     * API name: {@code type}
     */
    @Nullable
    public final GeoExecution type() {
        return this.type;
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
        this.boundingBox.serialize(generator, mapper);
        if (this.ignoreUnmapped != null) {
            generator.writeKey("ignore_unmapped");
            generator.write(this.ignoreUnmapped);
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
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
     * Builder for {@link GeoBoundingBoxQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GeoBoundingBoxQuery> {
        private GeoBounds boundingBox;
        private String field;
        @Nullable
        private Boolean ignoreUnmapped;
        @Nullable
        private GeoExecution type;
        @Nullable
        private GeoValidationMethod validationMethod;

        public Builder() {}

        private Builder(GeoBoundingBoxQuery o) {
            super(o);
            this.boundingBox = o.boundingBox;
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.type = o.type;
            this.validationMethod = o.validationMethod;
        }

        private Builder(Builder o) {
            super(o);
            this.boundingBox = o.boundingBox;
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.type = o.type;
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
         * <p>
         * A geo-bounding box. It can be represented in the following ways:
         * </p>
         * <ul>
         * <li>As 4 top/bottom/left/right coordinates.</li>
         * <li>As 2 top_left/bottom_right points.</li>
         * <li>As 2 top_right/bottom_left points.</li>
         * <li>As a Well Known Text (WKT) bounding box.</li>
         * </ul>
         */
        @Nonnull
        public final Builder boundingBox(GeoBounds value) {
            this.boundingBox = value;
            return this;
        }

        /**
         * Required -
         * <p>
         * A geo-bounding box. It can be represented in the following ways:
         * </p>
         * <ul>
         * <li>As 4 top/bottom/left/right coordinates.</li>
         * <li>As 2 top_left/bottom_right points.</li>
         * <li>As 2 top_right/bottom_left points.</li>
         * <li>As a Well Known Text (WKT) bounding box.</li>
         * </ul>
         */
        @Nonnull
        public final Builder boundingBox(Function<GeoBounds.Builder, ObjectBuilder<GeoBounds>> fn) {
            return boundingBox(fn.apply(new GeoBounds.Builder()).build());
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
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable GeoExecution value) {
            this.type = value;
            return this;
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
         * Builds a {@link GeoBoundingBoxQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoBoundingBoxQuery build() {
            _checkSingleUse();

            return new GeoBoundingBoxQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoBoundingBoxQuery}
     */
    public static final JsonpDeserializer<GeoBoundingBoxQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoBoundingBoxQuery::setupGeoBoundingBoxQueryDeserializer
    );

    protected static void setupGeoBoundingBoxQueryDeserializer(ObjectDeserializer<GeoBoundingBoxQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.add(Builder::type, GeoExecution._DESERIALIZER, "type");
        op.add(Builder::validationMethod, GeoValidationMethod._DESERIALIZER, "validation_method");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.boundingBox(GeoBounds._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.boundingBox.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + Objects.hashCode(this.type);
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
        GeoBoundingBoxQuery other = (GeoBoundingBoxQuery) o;
        return this.boundingBox.equals(other.boundingBox)
            && this.field.equals(other.field)
            && Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.validationMethod, other.validationMethod);
    }
}
