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
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.GeoJsonGeoShape

/**
 * The shape specified using a GeoJSON object.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoJsonGeoShape implements PlainJsonSerializable, ToCopyableBuilder<GeoJsonGeoShape.Builder, GeoJsonGeoShape> {

    @Nonnull
    private final List<JsonData> coordinates;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private GeoJsonGeoShape(Builder builder) {
        this.coordinates = ApiTypeHelper.unmodifiableRequired(builder.coordinates, this, "coordinates");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static GeoJsonGeoShape of(Function<GeoJsonGeoShape.Builder, ObjectBuilder<GeoJsonGeoShape>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The coordinates of the shape.
     * <p>
     * API name: {@code coordinates}
     * </p>
     */
    @Nonnull
    public final List<JsonData> coordinates() {
        return this.coordinates;
    }

    /**
     * Required - The type of the GeoJSON shape (e.g. <code>envelope</code>, <code>polygon</code>).
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        generator.writeKey("coordinates");
        generator.writeStartArray();
        for (JsonData item0 : this.coordinates) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link GeoJsonGeoShape}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoJsonGeoShape> {
        private List<JsonData> coordinates;
        private String type;

        public Builder() {}

        private Builder(GeoJsonGeoShape o) {
            this.coordinates = _listCopy(o.coordinates);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.coordinates = _listCopy(o.coordinates);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The coordinates of the shape.
         * <p>
         * API name: {@code coordinates}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>coordinates</code>.
         * </p>
         */
        @Nonnull
        public final Builder coordinates(List<JsonData> list) {
            this.coordinates = _listAddAll(this.coordinates, list);
            return this;
        }

        /**
         * Required - The coordinates of the shape.
         * <p>
         * API name: {@code coordinates}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>coordinates</code>.
         * </p>
         */
        @Nonnull
        public final Builder coordinates(JsonData value, JsonData... values) {
            this.coordinates = _listAdd(this.coordinates, value, values);
            return this;
        }

        /**
         * Required - The type of the GeoJSON shape (e.g. <code>envelope</code>, <code>polygon</code>).
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link GeoJsonGeoShape}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoJsonGeoShape build() {
            _checkSingleUse();

            return new GeoJsonGeoShape(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoJsonGeoShape}
     */
    public static final JsonpDeserializer<GeoJsonGeoShape> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoJsonGeoShape::setupGeoJsonGeoShapeDeserializer
    );

    protected static void setupGeoJsonGeoShapeDeserializer(ObjectDeserializer<GeoJsonGeoShape.Builder> op) {
        op.add(Builder::coordinates, JsonpDeserializer.arrayDeserializer(JsonData._DESERIALIZER), "coordinates");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.coordinates.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoJsonGeoShape other = (GeoJsonGeoShape) o;
        return this.coordinates.equals(other.coordinates) && this.type.equals(other.type);
    }
}
