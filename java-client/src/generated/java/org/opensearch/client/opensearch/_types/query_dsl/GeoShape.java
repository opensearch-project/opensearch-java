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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.GeoShape

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoShape implements PlainJsonSerializable, ToCopyableBuilder<GeoShape.Builder, GeoShape> {

    @Nonnull
    private final List<String> coordinates;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private GeoShape(Builder builder) {
        this.coordinates = ApiTypeHelper.unmodifiable(builder.coordinates);
        this.type = builder.type;
    }

    public static GeoShape of(Function<GeoShape.Builder, ObjectBuilder<GeoShape>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code coordinates}
     */
    @Nonnull
    public final List<String> coordinates() {
        return this.coordinates;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
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
        if (ApiTypeHelper.isDefined(this.coordinates)) {
            generator.writeKey("coordinates");
            generator.writeStartArray();
            for (String item0 : this.coordinates) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
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
     * Builder for {@link GeoShape}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoShape> {
        @Nullable
        private List<String> coordinates;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(GeoShape o) {
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
         * API name: {@code coordinates}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>coordinates</code>.
         * </p>
         */
        @Nonnull
        public final Builder coordinates(List<String> list) {
            this.coordinates = _listAddAll(this.coordinates, list);
            return this;
        }

        /**
         * API name: {@code coordinates}
         *
         * <p>
         * Adds one or more values to <code>coordinates</code>.
         * </p>
         */
        @Nonnull
        public final Builder coordinates(String value, String... values) {
            this.coordinates = _listAdd(this.coordinates, value, values);
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link GeoShape}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoShape build() {
            _checkSingleUse();

            return new GeoShape(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoShape}
     */
    public static final JsonpDeserializer<GeoShape> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoShape::setupGeoShapeDeserializer
    );

    protected static void setupGeoShapeDeserializer(ObjectDeserializer<GeoShape.Builder> op) {
        op.add(Builder::coordinates, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "coordinates");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.coordinates);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoShape other = (GeoShape) o;
        return Objects.equals(this.coordinates, other.coordinates) && Objects.equals(this.type, other.type);
    }
}
