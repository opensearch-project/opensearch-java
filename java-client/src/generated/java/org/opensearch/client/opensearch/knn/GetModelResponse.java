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

// typedef: knn.get_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetModelResponse implements PlainJsonSerializable, ToCopyableBuilder<GetModelResponse.Builder, GetModelResponse> {

    @Nullable
    private final String compressionLevel;

    @Nullable
    private final String dataType;

    @Nullable
    private final String description;

    @Nullable
    private final Integer dimension;

    @Nullable
    private final String engine;

    @Nullable
    private final String error;

    @Nullable
    private final String mode;

    @Nullable
    private final String modelBlob;

    @Nonnull
    private final Map<String, JsonData> modelDefinition;

    @Nonnull
    private final String modelId;

    @Nullable
    private final String modelVersion;

    @Nullable
    private final String spaceType;

    @Nullable
    private final ModelState state;

    @Nullable
    private final String timestamp;

    @Nullable
    private final String trainingNodeAssignment;

    // ---------------------------------------------------------------------------------------------

    private GetModelResponse(Builder builder) {
        this.compressionLevel = builder.compressionLevel;
        this.dataType = builder.dataType;
        this.description = builder.description;
        this.dimension = builder.dimension;
        this.engine = builder.engine;
        this.error = builder.error;
        this.mode = builder.mode;
        this.modelBlob = builder.modelBlob;
        this.modelDefinition = ApiTypeHelper.unmodifiable(builder.modelDefinition);
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.modelVersion = builder.modelVersion;
        this.spaceType = builder.spaceType;
        this.state = builder.state;
        this.timestamp = builder.timestamp;
        this.trainingNodeAssignment = builder.trainingNodeAssignment;
    }

    public static GetModelResponse of(Function<GetModelResponse.Builder, ObjectBuilder<GetModelResponse>> fn) {
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
     * The vector data type.
     * <p>
     * API name: {@code data_type}
     * </p>
     */
    @Nullable
    public final String dataType() {
        return this.dataType;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code dimension}
     */
    @Nullable
    public final Integer dimension() {
        return this.dimension;
    }

    /**
     * API name: {@code engine}
     */
    @Nullable
    public final String engine() {
        return this.engine;
    }

    /**
     * API name: {@code error}
     */
    @Nullable
    public final String error() {
        return this.error;
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final String mode() {
        return this.mode;
    }

    /**
     * The base64-encoded model data.
     * <p>
     * API name: {@code model_blob}
     * </p>
     */
    @Nullable
    public final String modelBlob() {
        return this.modelBlob;
    }

    /**
     * API name: {@code model_definition}
     */
    @Nonnull
    public final Map<String, JsonData> modelDefinition() {
        return this.modelDefinition;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code model_version}
     */
    @Nullable
    public final String modelVersion() {
        return this.modelVersion;
    }

    /**
     * API name: {@code space_type}
     */
    @Nullable
    public final String spaceType() {
        return this.spaceType;
    }

    /**
     * API name: {@code state}
     */
    @Nullable
    public final ModelState state() {
        return this.state;
    }

    /**
     * The timestamp when the model was created.
     * <p>
     * API name: {@code timestamp}
     * </p>
     */
    @Nullable
    public final String timestamp() {
        return this.timestamp;
    }

    /**
     * API name: {@code training_node_assignment}
     */
    @Nullable
    public final String trainingNodeAssignment() {
        return this.trainingNodeAssignment;
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

        if (this.dataType != null) {
            generator.writeKey("data_type");
            generator.write(this.dataType);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.dimension != null) {
            generator.writeKey("dimension");
            generator.write(this.dimension);
        }

        if (this.engine != null) {
            generator.writeKey("engine");
            generator.write(this.engine);
        }

        if (this.error != null) {
            generator.writeKey("error");
            generator.write(this.error);
        }

        if (this.mode != null) {
            generator.writeKey("mode");
            generator.write(this.mode);
        }

        if (this.modelBlob != null) {
            generator.writeKey("model_blob");
            generator.write(this.modelBlob);
        }

        if (ApiTypeHelper.isDefined(this.modelDefinition)) {
            generator.writeKey("model_definition");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.modelDefinition.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("model_id");
        generator.write(this.modelId);

        if (this.modelVersion != null) {
            generator.writeKey("model_version");
            generator.write(this.modelVersion);
        }

        if (this.spaceType != null) {
            generator.writeKey("space_type");
            generator.write(this.spaceType);
        }

        if (this.state != null) {
            generator.writeKey("state");
            this.state.serialize(generator, mapper);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
        }

        if (this.trainingNodeAssignment != null) {
            generator.writeKey("training_node_assignment");
            generator.write(this.trainingNodeAssignment);
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
     * Builder for {@link GetModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetModelResponse> {
        @Nullable
        private String compressionLevel;
        @Nullable
        private String dataType;
        @Nullable
        private String description;
        @Nullable
        private Integer dimension;
        @Nullable
        private String engine;
        @Nullable
        private String error;
        @Nullable
        private String mode;
        @Nullable
        private String modelBlob;
        @Nullable
        private Map<String, JsonData> modelDefinition;
        private String modelId;
        @Nullable
        private String modelVersion;
        @Nullable
        private String spaceType;
        @Nullable
        private ModelState state;
        @Nullable
        private String timestamp;
        @Nullable
        private String trainingNodeAssignment;

        public Builder() {}

        private Builder(GetModelResponse o) {
            this.compressionLevel = o.compressionLevel;
            this.dataType = o.dataType;
            this.description = o.description;
            this.dimension = o.dimension;
            this.engine = o.engine;
            this.error = o.error;
            this.mode = o.mode;
            this.modelBlob = o.modelBlob;
            this.modelDefinition = _mapCopy(o.modelDefinition);
            this.modelId = o.modelId;
            this.modelVersion = o.modelVersion;
            this.spaceType = o.spaceType;
            this.state = o.state;
            this.timestamp = o.timestamp;
            this.trainingNodeAssignment = o.trainingNodeAssignment;
        }

        private Builder(Builder o) {
            this.compressionLevel = o.compressionLevel;
            this.dataType = o.dataType;
            this.description = o.description;
            this.dimension = o.dimension;
            this.engine = o.engine;
            this.error = o.error;
            this.mode = o.mode;
            this.modelBlob = o.modelBlob;
            this.modelDefinition = _mapCopy(o.modelDefinition);
            this.modelId = o.modelId;
            this.modelVersion = o.modelVersion;
            this.spaceType = o.spaceType;
            this.state = o.state;
            this.timestamp = o.timestamp;
            this.trainingNodeAssignment = o.trainingNodeAssignment;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * The vector data type.
         * <p>
         * API name: {@code data_type}
         * </p>
         */
        @Nonnull
        public final Builder dataType(@Nullable String value) {
            this.dataType = value;
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
         * API name: {@code dimension}
         */
        @Nonnull
        public final Builder dimension(@Nullable Integer value) {
            this.dimension = value;
            return this;
        }

        /**
         * API name: {@code engine}
         */
        @Nonnull
        public final Builder engine(@Nullable String value) {
            this.engine = value;
            return this;
        }

        /**
         * API name: {@code error}
         */
        @Nonnull
        public final Builder error(@Nullable String value) {
            this.error = value;
            return this;
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
         * The base64-encoded model data.
         * <p>
         * API name: {@code model_blob}
         * </p>
         */
        @Nonnull
        public final Builder modelBlob(@Nullable String value) {
            this.modelBlob = value;
            return this;
        }

        /**
         * API name: {@code model_definition}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>modelDefinition</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelDefinition(Map<String, JsonData> map) {
            this.modelDefinition = _mapPutAll(this.modelDefinition, map);
            return this;
        }

        /**
         * API name: {@code model_definition}
         *
         * <p>
         * Adds an entry to <code>modelDefinition</code>.
         * </p>
         */
        @Nonnull
        public final Builder modelDefinition(String key, JsonData value) {
            this.modelDefinition = _mapPut(this.modelDefinition, key, value);
            return this;
        }

        /**
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code model_version}
         */
        @Nonnull
        public final Builder modelVersion(@Nullable String value) {
            this.modelVersion = value;
            return this;
        }

        /**
         * API name: {@code space_type}
         */
        @Nonnull
        public final Builder spaceType(@Nullable String value) {
            this.spaceType = value;
            return this;
        }

        /**
         * API name: {@code state}
         */
        @Nonnull
        public final Builder state(@Nullable ModelState value) {
            this.state = value;
            return this;
        }

        /**
         * The timestamp when the model was created.
         * <p>
         * API name: {@code timestamp}
         * </p>
         */
        @Nonnull
        public final Builder timestamp(@Nullable String value) {
            this.timestamp = value;
            return this;
        }

        /**
         * API name: {@code training_node_assignment}
         */
        @Nonnull
        public final Builder trainingNodeAssignment(@Nullable String value) {
            this.trainingNodeAssignment = value;
            return this;
        }

        /**
         * Builds a {@link GetModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetModelResponse build() {
            _checkSingleUse();

            return new GetModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetModelResponse}
     */
    public static final JsonpDeserializer<GetModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetModelResponse::setupGetModelResponseDeserializer
    );

    protected static void setupGetModelResponseDeserializer(ObjectDeserializer<GetModelResponse.Builder> op) {
        op.add(Builder::compressionLevel, JsonpDeserializer.stringDeserializer(), "compression_level");
        op.add(Builder::dataType, JsonpDeserializer.stringDeserializer(), "data_type");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::dimension, JsonpDeserializer.integerDeserializer(), "dimension");
        op.add(Builder::engine, JsonpDeserializer.stringDeserializer(), "engine");
        op.add(Builder::error, JsonpDeserializer.stringDeserializer(), "error");
        op.add(Builder::mode, JsonpDeserializer.stringDeserializer(), "mode");
        op.add(Builder::modelBlob, JsonpDeserializer.stringDeserializer(), "model_blob");
        op.add(Builder::modelDefinition, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "model_definition");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::modelVersion, JsonpDeserializer.stringDeserializer(), "model_version");
        op.add(Builder::spaceType, JsonpDeserializer.stringDeserializer(), "space_type");
        op.add(Builder::state, ModelState._DESERIALIZER, "state");
        op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp");
        op.add(Builder::trainingNodeAssignment, JsonpDeserializer.stringDeserializer(), "training_node_assignment");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.compressionLevel);
        result = 31 * result + Objects.hashCode(this.dataType);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.dimension);
        result = 31 * result + Objects.hashCode(this.engine);
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.modelBlob);
        result = 31 * result + Objects.hashCode(this.modelDefinition);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.modelVersion);
        result = 31 * result + Objects.hashCode(this.spaceType);
        result = 31 * result + Objects.hashCode(this.state);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.trainingNodeAssignment);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetModelResponse other = (GetModelResponse) o;
        return Objects.equals(this.compressionLevel, other.compressionLevel)
            && Objects.equals(this.dataType, other.dataType)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.dimension, other.dimension)
            && Objects.equals(this.engine, other.engine)
            && Objects.equals(this.error, other.error)
            && Objects.equals(this.mode, other.mode)
            && Objects.equals(this.modelBlob, other.modelBlob)
            && Objects.equals(this.modelDefinition, other.modelDefinition)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.modelVersion, other.modelVersion)
            && Objects.equals(this.spaceType, other.spaceType)
            && Objects.equals(this.state, other.state)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.trainingNodeAssignment, other.trainingNodeAssignment);
    }
}
