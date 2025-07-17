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

package org.opensearch.client.opensearch.knn;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
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

// typedef: knn.train_model.Request

/**
 * Create and train a model that can be used for initializing k-NN native library indexes during indexing.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class TrainModelRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<TrainModelRequest.Builder, TrainModelRequest> {

    @Nullable
    private final String compressionLevel;

    @Nullable
    private final String description;

    private final int dimension;

    @Nullable
    private final Integer maxTrainingVectorCount;

    @Nullable
    private final KnnMethod method;

    @Nullable
    private final String mode;

    @Nullable
    private final String modelId;

    @Nullable
    private final String preference;

    @Nullable
    private final Integer searchSize;

    @Nullable
    private final String spaceType;

    @Nonnull
    private final String trainingField;

    @Nonnull
    private final String trainingIndex;

    // ---------------------------------------------------------------------------------------------

    private TrainModelRequest(Builder builder) {
        super(builder);
        this.compressionLevel = builder.compressionLevel;
        this.description = builder.description;
        this.dimension = ApiTypeHelper.requireNonNull(builder.dimension, this, "dimension");
        this.maxTrainingVectorCount = builder.maxTrainingVectorCount;
        this.method = builder.method;
        this.mode = builder.mode;
        this.modelId = builder.modelId;
        this.preference = builder.preference;
        this.searchSize = builder.searchSize;
        this.spaceType = builder.spaceType;
        this.trainingField = ApiTypeHelper.requireNonNull(builder.trainingField, this, "trainingField");
        this.trainingIndex = ApiTypeHelper.requireNonNull(builder.trainingIndex, this, "trainingIndex");
    }

    public static TrainModelRequest of(Function<TrainModelRequest.Builder, ObjectBuilder<TrainModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code compression_level}
     */
    @Nullable
    public final String compressionLevel() {
        return this.compressionLevel;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code dimension}
     */
    public final int dimension() {
        return this.dimension;
    }

    /**
     * API name: {@code max_training_vector_count}
     */
    @Nullable
    public final Integer maxTrainingVectorCount() {
        return this.maxTrainingVectorCount;
    }

    /**
     * API name: {@code method}
     */
    @Nullable
    public final KnnMethod method() {
        return this.method;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final String mode() {
        return this.mode;
    }

    /**
     * The id of the model.
     * <p>
     * API name: {@code model_id}
     * </p>
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * Preferred node to execute training.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * API name: {@code search_size}
     */
    @Nullable
    public final Integer searchSize() {
        return this.searchSize;
    }

    /**
     * API name: {@code spaceType}
     */
    @Nullable
    public final String spaceType() {
        return this.spaceType;
    }

    /**
     * Required - API name: {@code training_field}
     */
    @Nonnull
    public final String trainingField() {
        return this.trainingField;
    }

    /**
     * Required - API name: {@code training_index}
     */
    @Nonnull
    public final String trainingIndex() {
        return this.trainingIndex;
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
        if (this.compressionLevel != null) {
            generator.writeKey("compression_level");
            generator.write(this.compressionLevel);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("dimension");
        generator.write(this.dimension);

        if (this.maxTrainingVectorCount != null) {
            generator.writeKey("max_training_vector_count");
            generator.write(this.maxTrainingVectorCount);
        }

        if (this.method != null) {
            generator.writeKey("method");
            this.method.serialize(generator, mapper);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            generator.write(this.mode);
        }

        if (this.searchSize != null) {
            generator.writeKey("search_size");
            generator.write(this.searchSize);
        }

        if (this.spaceType != null) {
            generator.writeKey("spaceType");
            generator.write(this.spaceType);
        }

        generator.writeKey("training_field");
        generator.write(this.trainingField);

        generator.writeKey("training_index");
        generator.write(this.trainingIndex);
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
     * Builder for {@link TrainModelRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TrainModelRequest> {
        @Nullable
        private String compressionLevel;
        @Nullable
        private String description;
        private Integer dimension;
        @Nullable
        private Integer maxTrainingVectorCount;
        @Nullable
        private KnnMethod method;
        @Nullable
        private String mode;
        @Nullable
        private String modelId;
        @Nullable
        private String preference;
        @Nullable
        private Integer searchSize;
        @Nullable
        private String spaceType;
        private String trainingField;
        private String trainingIndex;

        public Builder() {}

        private Builder(TrainModelRequest o) {
            super(o);
            this.compressionLevel = o.compressionLevel;
            this.description = o.description;
            this.dimension = o.dimension;
            this.maxTrainingVectorCount = o.maxTrainingVectorCount;
            this.method = o.method;
            this.mode = o.mode;
            this.modelId = o.modelId;
            this.preference = o.preference;
            this.searchSize = o.searchSize;
            this.spaceType = o.spaceType;
            this.trainingField = o.trainingField;
            this.trainingIndex = o.trainingIndex;
        }

        private Builder(Builder o) {
            super(o);
            this.compressionLevel = o.compressionLevel;
            this.description = o.description;
            this.dimension = o.dimension;
            this.maxTrainingVectorCount = o.maxTrainingVectorCount;
            this.method = o.method;
            this.mode = o.mode;
            this.modelId = o.modelId;
            this.preference = o.preference;
            this.searchSize = o.searchSize;
            this.spaceType = o.spaceType;
            this.trainingField = o.trainingField;
            this.trainingIndex = o.trainingIndex;
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
         * API name: {@code compression_level}
         */
        @Nonnull
        public final Builder compressionLevel(@Nullable String value) {
            this.compressionLevel = value;
            return this;
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code dimension}
         */
        @Nonnull
        public final Builder dimension(int value) {
            this.dimension = value;
            return this;
        }

        /**
         * API name: {@code max_training_vector_count}
         */
        @Nonnull
        public final Builder maxTrainingVectorCount(@Nullable Integer value) {
            this.maxTrainingVectorCount = value;
            return this;
        }

        /**
         * API name: {@code method}
         */
        @Nonnull
        public final Builder method(@Nullable KnnMethod value) {
            this.method = value;
            return this;
        }

        /**
         * API name: {@code method}
         */
        @Nonnull
        public final Builder method(Function<KnnMethod.Builder, ObjectBuilder<KnnMethod>> fn) {
            return method(fn.apply(new KnnMethod.Builder()).build());
        }

        /**
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable String value) {
            this.mode = value;
            return this;
        }

        /**
         * The id of the model.
         * <p>
         * API name: {@code model_id}
         * </p>
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Preferred node to execute training.
         * <p>
         * API name: {@code preference}
         * </p>
         */
        @Nonnull
        public final Builder preference(@Nullable String value) {
            this.preference = value;
            return this;
        }

        /**
         * API name: {@code search_size}
         */
        @Nonnull
        public final Builder searchSize(@Nullable Integer value) {
            this.searchSize = value;
            return this;
        }

        /**
         * API name: {@code spaceType}
         */
        @Nonnull
        public final Builder spaceType(@Nullable String value) {
            this.spaceType = value;
            return this;
        }

        /**
         * Required - API name: {@code training_field}
         */
        @Nonnull
        public final Builder trainingField(String value) {
            this.trainingField = value;
            return this;
        }

        /**
         * Required - API name: {@code training_index}
         */
        @Nonnull
        public final Builder trainingIndex(String value) {
            this.trainingIndex = value;
            return this;
        }

        /**
         * Builds a {@link TrainModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TrainModelRequest build() {
            _checkSingleUse();

            return new TrainModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TrainModelRequest}
     */
    public static final JsonpDeserializer<TrainModelRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TrainModelRequest::setupTrainModelRequestDeserializer
    );

    protected static void setupTrainModelRequestDeserializer(ObjectDeserializer<TrainModelRequest.Builder> op) {
        op.add(Builder::compressionLevel, JsonpDeserializer.stringDeserializer(), "compression_level");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::dimension, JsonpDeserializer.integerDeserializer(), "dimension");
        op.add(Builder::maxTrainingVectorCount, JsonpDeserializer.integerDeserializer(), "max_training_vector_count");
        op.add(Builder::method, KnnMethod._DESERIALIZER, "method");
        op.add(Builder::mode, JsonpDeserializer.stringDeserializer(), "mode");
        op.add(Builder::searchSize, JsonpDeserializer.integerDeserializer(), "search_size");
        op.add(Builder::spaceType, JsonpDeserializer.stringDeserializer(), "spaceType");
        op.add(Builder::trainingField, JsonpDeserializer.stringDeserializer(), "training_field");
        op.add(Builder::trainingIndex, JsonpDeserializer.stringDeserializer(), "training_index");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
    }

    /**
     * Endpoint "{@code knn.train_model}".
     */
    public static final Endpoint<TrainModelRequest, TrainModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _modelId = 1 << 0;

            int propsSet = 0;

            if (request.modelId() != null) propsSet |= _modelId;

            if (propsSet == 0) {
                return "/_plugins/_knn/models/_train";
            }
            if (propsSet == (_modelId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_knn/models/");
                SimpleEndpoint.pathEncode(request.modelId, buf);
                buf.append("/_train");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        TrainModelResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.compressionLevel);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Integer.hashCode(this.dimension);
        result = 31 * result + Objects.hashCode(this.maxTrainingVectorCount);
        result = 31 * result + Objects.hashCode(this.method);
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.searchSize);
        result = 31 * result + Objects.hashCode(this.spaceType);
        result = 31 * result + this.trainingField.hashCode();
        result = 31 * result + this.trainingIndex.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TrainModelRequest other = (TrainModelRequest) o;
        return Objects.equals(this.compressionLevel, other.compressionLevel)
            && Objects.equals(this.description, other.description)
            && this.dimension == other.dimension
            && Objects.equals(this.maxTrainingVectorCount, other.maxTrainingVectorCount)
            && Objects.equals(this.method, other.method)
            && Objects.equals(this.mode, other.mode)
            && Objects.equals(this.modelId, other.modelId)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.searchSize, other.searchSize)
            && Objects.equals(this.spaceType, other.spaceType)
            && this.trainingField.equals(other.trainingField)
            && this.trainingIndex.equals(other.trainingIndex);
    }
}
