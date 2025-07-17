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

package org.opensearch.client.opensearch.geospatial;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

// typedef: geospatial.GeoJSONData

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeoJSONData implements PlainJsonSerializable, ToCopyableBuilder<GeoJSONData.Builder, GeoJSONData> {

    @Nonnull
    private final JsonData geometry;

    @Nonnull
    private final Map<String, JsonData> properties;

    @Nonnull
    private final GeoJSONDataType type;

    // ---------------------------------------------------------------------------------------------

    private GeoJSONData(Builder builder) {
        this.geometry = ApiTypeHelper.requireNonNull(builder.geometry, this, "geometry");
        this.properties = ApiTypeHelper.unmodifiable(builder.properties);
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static GeoJSONData of(Function<GeoJSONData.Builder, ObjectBuilder<GeoJSONData>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code geometry}
     */
    @Nonnull
    public final JsonData geometry() {
        return this.geometry;
    }

    /**
     * API name: {@code properties}
     */
    @Nonnull
    public final Map<String, JsonData> properties() {
        return this.properties;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final GeoJSONDataType type() {
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
        generator.writeKey("geometry");
        this.geometry.serialize(generator, mapper);

        if (ApiTypeHelper.isDefined(this.properties)) {
            generator.writeKey("properties");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.properties.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("type");
        this.type.serialize(generator, mapper);
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
     * Builder for {@link GeoJSONData}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeoJSONData> {
        private JsonData geometry;
        @Nullable
        private Map<String, JsonData> properties;
        private GeoJSONDataType type;

        public Builder() {}

        private Builder(GeoJSONData o) {
            this.geometry = o.geometry;
            this.properties = _mapCopy(o.properties);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.geometry = o.geometry;
            this.properties = _mapCopy(o.properties);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code geometry}
         */
        @Nonnull
        public final Builder geometry(JsonData value) {
            this.geometry = value;
            return this;
        }

        /**
         * API name: {@code properties}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(Map<String, JsonData> map) {
            this.properties = _mapPutAll(this.properties, map);
            return this;
        }

        /**
         * API name: {@code properties}
         *
         * <p>
         * Adds an entry to <code>properties</code>.
         * </p>
         */
        @Nonnull
        public final Builder properties(String key, JsonData value) {
            this.properties = _mapPut(this.properties, key, value);
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(GeoJSONDataType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link GeoJSONData}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeoJSONData build() {
            _checkSingleUse();

            return new GeoJSONData(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeoJSONData}
     */
    public static final JsonpDeserializer<GeoJSONData> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeoJSONData::setupGeoJSONDataDeserializer
    );

    protected static void setupGeoJSONDataDeserializer(ObjectDeserializer<GeoJSONData.Builder> op) {
        op.add(Builder::geometry, JsonData._DESERIALIZER, "geometry");
        op.add(Builder::properties, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "properties");
        op.add(Builder::type, GeoJSONDataType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.geometry.hashCode();
        result = 31 * result + Objects.hashCode(this.properties);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeoJSONData other = (GeoJSONData) o;
        return this.geometry.equals(other.geometry) && Objects.equals(this.properties, other.properties) && this.type.equals(other.type);
    }
}
