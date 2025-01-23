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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.GeoShapeRelation;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.GeoShapeQueryField

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoShapeQueryField implements PlainJsonSerializable, ToCopyableBuilder<GeoShapeQueryField.Builder, GeoShapeQueryField> {

    @Nullable
    private final FieldLookup indexedShape;

    @Nullable
    private final GeoShapeRelation relation;

    @Nonnull
    private final GeoShape shape;

    // ---------------------------------------------------------------------------------------------

    private GeoShapeQueryField(Builder builder) {
        this.indexedShape = builder.indexedShape;
        this.relation = builder.relation;
        this.shape = ApiTypeHelper.requireNonNull(builder.shape, this, "shape");
    }

    public static GeoShapeQueryField of(Function<GeoShapeQueryField.Builder, ObjectBuilder<GeoShapeQueryField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code indexed_shape}
     */
    @Nullable
    public final FieldLookup indexedShape() {
        return this.indexedShape;
    }

    /**
     * API name: {@code relation}
     */
    @Nullable
    public final GeoShapeRelation relation() {
        return this.relation;
    }

    /**
     * Required - API name: {@code shape}
     */
    @Nonnull
    public final GeoShape shape() {
        return this.shape;
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
        if (this.indexedShape != null) {
            generator.writeKey("indexed_shape");
            this.indexedShape.serialize(generator, mapper);
        }

        if (this.relation != null) {
            generator.writeKey("relation");
            this.relation.serialize(generator, mapper);
        }

        generator.writeKey("shape");
        this.shape.serialize(generator, mapper);
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
     * Builder for {@link GeoShapeQueryField}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoShapeQueryField> {
        @Nullable
        private FieldLookup indexedShape;
        @Nullable
        private GeoShapeRelation relation;
        private GeoShape shape;

        public Builder() {}

        private Builder(GeoShapeQueryField o) {
            this.indexedShape = o.indexedShape;
            this.relation = o.relation;
            this.shape = o.shape;
        }

        private Builder(Builder o) {
            this.indexedShape = o.indexedShape;
            this.relation = o.relation;
            this.shape = o.shape;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code indexed_shape}
         */
        @Nonnull
        public final Builder indexedShape(@Nullable FieldLookup value) {
            this.indexedShape = value;
            return this;
        }

        /**
         * API name: {@code indexed_shape}
         */
        @Nonnull
        public final Builder indexedShape(Function<FieldLookup.Builder, ObjectBuilder<FieldLookup>> fn) {
            return indexedShape(fn.apply(new FieldLookup.Builder()).build());
        }

        /**
         * API name: {@code relation}
         */
        @Nonnull
        public final Builder relation(@Nullable GeoShapeRelation value) {
            this.relation = value;
            return this;
        }

        /**
         * Required - API name: {@code shape}
         */
        @Nonnull
        public final Builder shape(GeoShape value) {
            this.shape = value;
            return this;
        }

        /**
         * Required - API name: {@code shape}
         */
        @Nonnull
        public final Builder shape(Function<GeoShape.Builder, ObjectBuilder<GeoShape>> fn) {
            return shape(fn.apply(new GeoShape.Builder()).build());
        }

        /**
         * Builds a {@link GeoShapeQueryField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoShapeQueryField build() {
            _checkSingleUse();

            return new GeoShapeQueryField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoShapeQueryField}
     */
    public static final JsonpDeserializer<GeoShapeQueryField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoShapeQueryField::setupGeoShapeQueryFieldDeserializer
    );

    protected static void setupGeoShapeQueryFieldDeserializer(ObjectDeserializer<GeoShapeQueryField.Builder> op) {
        op.add(Builder::indexedShape, FieldLookup._DESERIALIZER, "indexed_shape");
        op.add(Builder::relation, GeoShapeRelation._DESERIALIZER, "relation");
        op.add(Builder::shape, GeoShape._DESERIALIZER, "shape");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.indexedShape);
        result = 31 * result + Objects.hashCode(this.relation);
        result = 31 * result + this.shape.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoShapeQueryField other = (GeoShapeQueryField) o;
        return Objects.equals(this.indexedShape, other.indexedShape)
            && Objects.equals(this.relation, other.relation)
            && this.shape.equals(other.shape);
    }
}
