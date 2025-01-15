/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetModelResponse implements PlainJsonSerializable, ToCopyableBuilder<GetModelResponse.Builder, GetModelResponse> {

    @Nullable
    private final String algorithm;

    @Nullable
    private final Long createdTime;

    @Nullable
    private final Boolean isHidden;

    @Nullable
    private final Long lastRegisteredTime;

    @Nullable
    private final Long lastUpdatedTime;

    @Nullable
    private final ModelConfig modelConfig;

    @Nullable
    private final String modelContentHashValue;

    @Nullable
    private final Long modelContentSizeInBytes;

    @Nullable
    private final ModelFormat modelFormat;

    @Nullable
    private final String modelGroupId;

    @Nonnull
    private final String modelState;

    @Nullable
    private final String modelVersion;

    @Nullable
    private final String name;

    @Nullable
    private final Long totalChunks;

    // ---------------------------------------------------------------------------------------------

    private GetModelResponse(Builder builder) {
        this.algorithm = builder.algorithm;
        this.createdTime = builder.createdTime;
        this.isHidden = builder.isHidden;
        this.lastRegisteredTime = builder.lastRegisteredTime;
        this.lastUpdatedTime = builder.lastUpdatedTime;
        this.modelConfig = builder.modelConfig;
        this.modelContentHashValue = builder.modelContentHashValue;
        this.modelContentSizeInBytes = builder.modelContentSizeInBytes;
        this.modelFormat = builder.modelFormat;
        this.modelGroupId = builder.modelGroupId;
        this.modelState = ApiTypeHelper.requireNonNull(builder.modelState, this, "modelState");
        this.modelVersion = builder.modelVersion;
        this.name = builder.name;
        this.totalChunks = builder.totalChunks;
    }

    public static GetModelResponse of(Function<GetModelResponse.Builder, ObjectBuilder<GetModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The algorithm.
     * <p>
     * API name: {@code algorithm}
     * </p>
     */
    @Nullable
    public final String algorithm() {
        return this.algorithm;
    }

    /**
     * The created time.
     * <p>
     * API name: {@code created_time}
     * </p>
     */
    @Nullable
    public final Long createdTime() {
        return this.createdTime;
    }

    /**
     * Whether the model is hidden.
     * <p>
     * API name: {@code is_hidden}
     * </p>
     */
    @Nullable
    public final Boolean isHidden() {
        return this.isHidden;
    }

    /**
     * The last registered time.
     * <p>
     * API name: {@code last_registered_time}
     * </p>
     */
    @Nullable
    public final Long lastRegisteredTime() {
        return this.lastRegisteredTime;
    }

    /**
     * The last updated time.
     * <p>
     * API name: {@code last_updated_time}
     * </p>
     */
    @Nullable
    public final Long lastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /**
     * API name: {@code model_config}
     */
    @Nullable
    public final ModelConfig modelConfig() {
        return this.modelConfig;
    }

    /**
     * The model content hash value.
     * <p>
     * API name: {@code model_content_hash_value}
     * </p>
     */
    @Nullable
    public final String modelContentHashValue() {
        return this.modelContentHashValue;
    }

    /**
     * The model content size in bytes.
     * <p>
     * API name: {@code model_content_size_in_bytes}
     * </p>
     */
    @Nullable
    public final Long modelContentSizeInBytes() {
        return this.modelContentSizeInBytes;
    }

    /**
     * API name: {@code model_format}
     */
    @Nullable
    public final ModelFormat modelFormat() {
        return this.modelFormat;
    }

    /**
     * The model group ID.
     * <p>
     * API name: {@code model_group_id}
     * </p>
     */
    @Nullable
    public final String modelGroupId() {
        return this.modelGroupId;
    }

    /**
     * Required - The model state.
     * <p>
     * API name: {@code model_state}
     * </p>
     */
    @Nonnull
    public final String modelState() {
        return this.modelState;
    }

    /**
     * The model version.
     * <p>
     * API name: {@code model_version}
     * </p>
     */
    @Nullable
    public final String modelVersion() {
        return this.modelVersion;
    }

    /**
     * The model name.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nullable
    public final String name() {
        return this.name;
    }

    /**
     * The total chunks.
     * <p>
     * API name: {@code total_chunks}
     * </p>
     */
    @Nullable
    public final Long totalChunks() {
        return this.totalChunks;
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
        if (this.algorithm != null) {
            generator.writeKey("algorithm");
            generator.write(this.algorithm);
        }

        if (this.createdTime != null) {
            generator.writeKey("created_time");
            generator.write(this.createdTime);
        }

        if (this.isHidden != null) {
            generator.writeKey("is_hidden");
            generator.write(this.isHidden);
        }

        if (this.lastRegisteredTime != null) {
            generator.writeKey("last_registered_time");
            generator.write(this.lastRegisteredTime);
        }

        if (this.lastUpdatedTime != null) {
            generator.writeKey("last_updated_time");
            generator.write(this.lastUpdatedTime);
        }

        if (this.modelConfig != null) {
            generator.writeKey("model_config");
            this.modelConfig.serialize(generator, mapper);
        }

        if (this.modelContentHashValue != null) {
            generator.writeKey("model_content_hash_value");
            generator.write(this.modelContentHashValue);
        }

        if (this.modelContentSizeInBytes != null) {
            generator.writeKey("model_content_size_in_bytes");
            generator.write(this.modelContentSizeInBytes);
        }

        if (this.modelFormat != null) {
            generator.writeKey("model_format");
            this.modelFormat.serialize(generator, mapper);
        }

        if (this.modelGroupId != null) {
            generator.writeKey("model_group_id");
            generator.write(this.modelGroupId);
        }

        generator.writeKey("model_state");
        generator.write(this.modelState);

        if (this.modelVersion != null) {
            generator.writeKey("model_version");
            generator.write(this.modelVersion);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.totalChunks != null) {
            generator.writeKey("total_chunks");
            generator.write(this.totalChunks);
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
        private String algorithm;
        @Nullable
        private Long createdTime;
        @Nullable
        private Boolean isHidden;
        @Nullable
        private Long lastRegisteredTime;
        @Nullable
        private Long lastUpdatedTime;
        @Nullable
        private ModelConfig modelConfig;
        @Nullable
        private String modelContentHashValue;
        @Nullable
        private Long modelContentSizeInBytes;
        @Nullable
        private ModelFormat modelFormat;
        @Nullable
        private String modelGroupId;
        private String modelState;
        @Nullable
        private String modelVersion;
        @Nullable
        private String name;
        @Nullable
        private Long totalChunks;

        public Builder() {}

        private Builder(GetModelResponse o) {
            this.algorithm = o.algorithm;
            this.createdTime = o.createdTime;
            this.isHidden = o.isHidden;
            this.lastRegisteredTime = o.lastRegisteredTime;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.modelConfig = o.modelConfig;
            this.modelContentHashValue = o.modelContentHashValue;
            this.modelContentSizeInBytes = o.modelContentSizeInBytes;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.modelState = o.modelState;
            this.modelVersion = o.modelVersion;
            this.name = o.name;
            this.totalChunks = o.totalChunks;
        }

        private Builder(Builder o) {
            this.algorithm = o.algorithm;
            this.createdTime = o.createdTime;
            this.isHidden = o.isHidden;
            this.lastRegisteredTime = o.lastRegisteredTime;
            this.lastUpdatedTime = o.lastUpdatedTime;
            this.modelConfig = o.modelConfig;
            this.modelContentHashValue = o.modelContentHashValue;
            this.modelContentSizeInBytes = o.modelContentSizeInBytes;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.modelState = o.modelState;
            this.modelVersion = o.modelVersion;
            this.name = o.name;
            this.totalChunks = o.totalChunks;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The algorithm.
         * <p>
         * API name: {@code algorithm}
         * </p>
         */
        @Nonnull
        public final Builder algorithm(@Nullable String value) {
            this.algorithm = value;
            return this;
        }

        /**
         * The created time.
         * <p>
         * API name: {@code created_time}
         * </p>
         */
        @Nonnull
        public final Builder createdTime(@Nullable Long value) {
            this.createdTime = value;
            return this;
        }

        /**
         * Whether the model is hidden.
         * <p>
         * API name: {@code is_hidden}
         * </p>
         */
        @Nonnull
        public final Builder isHidden(@Nullable Boolean value) {
            this.isHidden = value;
            return this;
        }

        /**
         * The last registered time.
         * <p>
         * API name: {@code last_registered_time}
         * </p>
         */
        @Nonnull
        public final Builder lastRegisteredTime(@Nullable Long value) {
            this.lastRegisteredTime = value;
            return this;
        }

        /**
         * The last updated time.
         * <p>
         * API name: {@code last_updated_time}
         * </p>
         */
        @Nonnull
        public final Builder lastUpdatedTime(@Nullable Long value) {
            this.lastUpdatedTime = value;
            return this;
        }

        /**
         * API name: {@code model_config}
         */
        @Nonnull
        public final Builder modelConfig(@Nullable ModelConfig value) {
            this.modelConfig = value;
            return this;
        }

        /**
         * API name: {@code model_config}
         */
        @Nonnull
        public final Builder modelConfig(Function<ModelConfig.Builder, ObjectBuilder<ModelConfig>> fn) {
            return modelConfig(fn.apply(new ModelConfig.Builder()).build());
        }

        /**
         * The model content hash value.
         * <p>
         * API name: {@code model_content_hash_value}
         * </p>
         */
        @Nonnull
        public final Builder modelContentHashValue(@Nullable String value) {
            this.modelContentHashValue = value;
            return this;
        }

        /**
         * The model content size in bytes.
         * <p>
         * API name: {@code model_content_size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder modelContentSizeInBytes(@Nullable Long value) {
            this.modelContentSizeInBytes = value;
            return this;
        }

        /**
         * API name: {@code model_format}
         */
        @Nonnull
        public final Builder modelFormat(@Nullable ModelFormat value) {
            this.modelFormat = value;
            return this;
        }

        /**
         * The model group ID.
         * <p>
         * API name: {@code model_group_id}
         * </p>
         */
        @Nonnull
        public final Builder modelGroupId(@Nullable String value) {
            this.modelGroupId = value;
            return this;
        }

        /**
         * Required - The model state.
         * <p>
         * API name: {@code model_state}
         * </p>
         */
        @Nonnull
        public final Builder modelState(String value) {
            this.modelState = value;
            return this;
        }

        /**
         * The model version.
         * <p>
         * API name: {@code model_version}
         * </p>
         */
        @Nonnull
        public final Builder modelVersion(@Nullable String value) {
            this.modelVersion = value;
            return this;
        }

        /**
         * The model name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * The total chunks.
         * <p>
         * API name: {@code total_chunks}
         * </p>
         */
        @Nonnull
        public final Builder totalChunks(@Nullable Long value) {
            this.totalChunks = value;
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
        op.add(Builder::algorithm, JsonpDeserializer.stringDeserializer(), "algorithm");
        op.add(Builder::createdTime, JsonpDeserializer.longDeserializer(), "created_time");
        op.add(Builder::isHidden, JsonpDeserializer.booleanDeserializer(), "is_hidden");
        op.add(Builder::lastRegisteredTime, JsonpDeserializer.longDeserializer(), "last_registered_time");
        op.add(Builder::lastUpdatedTime, JsonpDeserializer.longDeserializer(), "last_updated_time");
        op.add(Builder::modelConfig, ModelConfig._DESERIALIZER, "model_config");
        op.add(Builder::modelContentHashValue, JsonpDeserializer.stringDeserializer(), "model_content_hash_value");
        op.add(Builder::modelContentSizeInBytes, JsonpDeserializer.longDeserializer(), "model_content_size_in_bytes");
        op.add(Builder::modelFormat, ModelFormat._DESERIALIZER, "model_format");
        op.add(Builder::modelGroupId, JsonpDeserializer.stringDeserializer(), "model_group_id");
        op.add(Builder::modelState, JsonpDeserializer.stringDeserializer(), "model_state");
        op.add(Builder::modelVersion, JsonpDeserializer.stringDeserializer(), "model_version");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::totalChunks, JsonpDeserializer.longDeserializer(), "total_chunks");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.algorithm);
        result = 31 * result + Objects.hashCode(this.createdTime);
        result = 31 * result + Objects.hashCode(this.isHidden);
        result = 31 * result + Objects.hashCode(this.lastRegisteredTime);
        result = 31 * result + Objects.hashCode(this.lastUpdatedTime);
        result = 31 * result + Objects.hashCode(this.modelConfig);
        result = 31 * result + Objects.hashCode(this.modelContentHashValue);
        result = 31 * result + Objects.hashCode(this.modelContentSizeInBytes);
        result = 31 * result + Objects.hashCode(this.modelFormat);
        result = 31 * result + Objects.hashCode(this.modelGroupId);
        result = 31 * result + this.modelState.hashCode();
        result = 31 * result + Objects.hashCode(this.modelVersion);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.totalChunks);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetModelResponse other = (GetModelResponse) o;
        return Objects.equals(this.algorithm, other.algorithm)
            && Objects.equals(this.createdTime, other.createdTime)
            && Objects.equals(this.isHidden, other.isHidden)
            && Objects.equals(this.lastRegisteredTime, other.lastRegisteredTime)
            && Objects.equals(this.lastUpdatedTime, other.lastUpdatedTime)
            && Objects.equals(this.modelConfig, other.modelConfig)
            && Objects.equals(this.modelContentHashValue, other.modelContentHashValue)
            && Objects.equals(this.modelContentSizeInBytes, other.modelContentSizeInBytes)
            && Objects.equals(this.modelFormat, other.modelFormat)
            && Objects.equals(this.modelGroupId, other.modelGroupId)
            && this.modelState.equals(other.modelState)
            && Objects.equals(this.modelVersion, other.modelVersion)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.totalChunks, other.totalChunks);
    }
}
