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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: geospatial.geojson_upload_post.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GeojsonUploadPostResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GeojsonUploadPostResponse.Builder, GeojsonUploadPostResponse> {

    private final boolean errors;

    private final int failure;

    private final int success;

    private final long took;

    private final int total;

    // ---------------------------------------------------------------------------------------------

    private GeojsonUploadPostResponse(Builder builder) {
        this.errors = ApiTypeHelper.requireNonNull(builder.errors, this, "errors");
        this.failure = ApiTypeHelper.requireNonNull(builder.failure, this, "failure");
        this.success = ApiTypeHelper.requireNonNull(builder.success, this, "success");
        this.took = ApiTypeHelper.requireNonNull(builder.took, this, "took");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static GeojsonUploadPostResponse of(Function<GeojsonUploadPostResponse.Builder, ObjectBuilder<GeojsonUploadPostResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Whether there were any errors.
     * <p>
     * API name: {@code errors}
     * </p>
     */
    public final boolean errors() {
        return this.errors;
    }

    /**
     * Required - Number of features that failed to upload.
     * <p>
     * API name: {@code failure}
     * </p>
     */
    public final int failure() {
        return this.failure;
    }

    /**
     * Required - Number of features successfully uploaded.
     * <p>
     * API name: {@code success}
     * </p>
     */
    public final int success() {
        return this.success;
    }

    /**
     * Required - API name: {@code took}
     */
    public final long took() {
        return this.took;
    }

    /**
     * Required - Total number of features processed.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final int total() {
        return this.total;
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
        generator.writeKey("errors");
        generator.write(this.errors);

        generator.writeKey("failure");
        generator.write(this.failure);

        generator.writeKey("success");
        generator.write(this.success);

        generator.writeKey("took");
        generator.write(this.took);

        generator.writeKey("total");
        generator.write(this.total);
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
     * Builder for {@link GeojsonUploadPostResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GeojsonUploadPostResponse> {
        private Boolean errors;
        private Integer failure;
        private Integer success;
        private Long took;
        private Integer total;

        public Builder() {}

        private Builder(GeojsonUploadPostResponse o) {
            this.errors = o.errors;
            this.failure = o.failure;
            this.success = o.success;
            this.took = o.took;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.errors = o.errors;
            this.failure = o.failure;
            this.success = o.success;
            this.took = o.took;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Whether there were any errors.
         * <p>
         * API name: {@code errors}
         * </p>
         */
        @Nonnull
        public final Builder errors(boolean value) {
            this.errors = value;
            return this;
        }

        /**
         * Required - Number of features that failed to upload.
         * <p>
         * API name: {@code failure}
         * </p>
         */
        @Nonnull
        public final Builder failure(int value) {
            this.failure = value;
            return this;
        }

        /**
         * Required - Number of features successfully uploaded.
         * <p>
         * API name: {@code success}
         * </p>
         */
        @Nonnull
        public final Builder success(int value) {
            this.success = value;
            return this;
        }

        /**
         * Required - API name: {@code took}
         */
        @Nonnull
        public final Builder took(long value) {
            this.took = value;
            return this;
        }

        /**
         * Required - Total number of features processed.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(int value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link GeojsonUploadPostResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GeojsonUploadPostResponse build() {
            _checkSingleUse();

            return new GeojsonUploadPostResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GeojsonUploadPostResponse}
     */
    public static final JsonpDeserializer<GeojsonUploadPostResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GeojsonUploadPostResponse::setupGeojsonUploadPostResponseDeserializer
    );

    protected static void setupGeojsonUploadPostResponseDeserializer(ObjectDeserializer<GeojsonUploadPostResponse.Builder> op) {
        op.add(Builder::errors, JsonpDeserializer.booleanDeserializer(), "errors");
        op.add(Builder::failure, JsonpDeserializer.integerDeserializer(), "failure");
        op.add(Builder::success, JsonpDeserializer.integerDeserializer(), "success");
        op.add(Builder::took, JsonpDeserializer.longDeserializer(), "took");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.errors);
        result = 31 * result + Integer.hashCode(this.failure);
        result = 31 * result + Integer.hashCode(this.success);
        result = 31 * result + Long.hashCode(this.took);
        result = 31 * result + Integer.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GeojsonUploadPostResponse other = (GeojsonUploadPostResponse) o;
        return this.errors == other.errors
            && this.failure == other.failure
            && this.success == other.success
            && this.took == other.took
            && this.total == other.total;
    }
}
