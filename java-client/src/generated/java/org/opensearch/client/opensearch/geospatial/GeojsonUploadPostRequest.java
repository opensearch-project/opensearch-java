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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: geospatial.geojson_upload_post.Request

/**
 * <p>
 * Use an OpenSearch query to upload <code>GeoJSON</code>, operation will fail if index exists.
 * </p>
 * <ul>
 * <li>When type is <code>geo_point</code>, only Point geometry is allowed</li>
 * <li>When type is <code>geo_shape</code>, all geometry types are allowed (Point, MultiPoint, LineString, MultiLineString, Polygon,
 * MultiPolygon, GeometryCollection, Envelope).</li>
 * </ul>
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GeojsonUploadPostRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GeojsonUploadPostRequest.Builder, GeojsonUploadPostRequest> {

    @Nonnull
    private final List<GeoJSONData> data;

    @Nullable
    private final String field;

    @Nonnull
    private final String index;

    @Nonnull
    private final GeospatialFieldType type;

    // ---------------------------------------------------------------------------------------------

    private GeojsonUploadPostRequest(Builder builder) {
        super(builder);
        this.data = ApiTypeHelper.unmodifiableRequired(builder.data, this, "data");
        this.field = builder.field;
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static GeojsonUploadPostRequest of(Function<GeojsonUploadPostRequest.Builder, ObjectBuilder<GeojsonUploadPostRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Array of GeoJSON features.
     * <p>
     * API name: {@code data}
     * </p>
     */
    @Nonnull
    public final List<GeoJSONData> data() {
        return this.data;
    }

    /**
     * Field name for the geospatial data.
     * <p>
     * API name: {@code field}
     * </p>
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - Field type for the geospatial data.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final GeospatialFieldType type() {
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
        generator.writeKey("data");
        generator.writeStartArray();
        for (GeoJSONData item0 : this.data) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        generator.writeKey("index");
        generator.write(this.index);

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
     * Builder for {@link GeojsonUploadPostRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GeojsonUploadPostRequest> {
        private List<GeoJSONData> data;
        @Nullable
        private String field;
        private String index;
        private GeospatialFieldType type;

        public Builder() {}

        private Builder(GeojsonUploadPostRequest o) {
            super(o);
            this.data = _listCopy(o.data);
            this.field = o.field;
            this.index = o.index;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.data = _listCopy(o.data);
            this.field = o.field;
            this.index = o.index;
            this.type = o.type;
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
         * Required - Array of GeoJSON features.
         * <p>
         * API name: {@code data}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(List<GeoJSONData> list) {
            this.data = _listAddAll(this.data, list);
            return this;
        }

        /**
         * Required - Array of GeoJSON features.
         * <p>
         * API name: {@code data}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>data</code>.
         * </p>
         */
        @Nonnull
        public final Builder data(GeoJSONData value, GeoJSONData... values) {
            this.data = _listAdd(this.data, value, values);
            return this;
        }

        /**
         * Required - Array of GeoJSON features.
         * <p>
         * API name: {@code data}
         * </p>
         *
         * <p>
         * Adds a value to <code>data</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder data(Function<GeoJSONData.Builder, ObjectBuilder<GeoJSONData>> fn) {
            return data(fn.apply(new GeoJSONData.Builder()).build());
        }

        /**
         * Field name for the geospatial data.
         * <p>
         * API name: {@code field}
         * </p>
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - Field type for the geospatial data.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(GeospatialFieldType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link GeojsonUploadPostRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeojsonUploadPostRequest build() {
            _checkSingleUse();

            return new GeojsonUploadPostRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeojsonUploadPostRequest}
     */
    public static final JsonpDeserializer<GeojsonUploadPostRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeojsonUploadPostRequest::setupGeojsonUploadPostRequestDeserializer
    );

    protected static void setupGeojsonUploadPostRequestDeserializer(ObjectDeserializer<GeojsonUploadPostRequest.Builder> op) {
        op.add(Builder::data, JsonpDeserializer.arrayDeserializer(GeoJSONData._DESERIALIZER), "data");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::type, GeospatialFieldType._DESERIALIZER, "type");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code geospatial.geojson_upload_post}".
     */
    public static final Endpoint<GeojsonUploadPostRequest, GeojsonUploadPostResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/geospatial/geojson/_upload",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        GeojsonUploadPostResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.data.hashCode();
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeojsonUploadPostRequest other = (GeojsonUploadPostRequest) o;
        return this.data.equals(other.data)
            && Objects.equals(this.field, other.field)
            && this.index.equals(other.index)
            && this.type.equals(other.type);
    }
}
