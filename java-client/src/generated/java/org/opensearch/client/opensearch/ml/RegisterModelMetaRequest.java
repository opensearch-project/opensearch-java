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

// typedef: ml.register_model_meta.Request

/**
 * Registers model metadata.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RegisterModelMetaRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RegisterModelMetaRequest.Builder, RegisterModelMetaRequest> {

    @Nullable
    private final String description;

    @Nonnull
    private final ModelConfig modelConfig;

    @Nonnull
    private final String modelContentHashValue;

    @Nonnull
    private final ModelFormat modelFormat;

    @Nullable
    private final String modelGroupId;

    @Nonnull
    private final String name;

    private final long totalChunks;

    @Nullable
    private final String url;

    @Nonnull
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private RegisterModelMetaRequest(Builder builder) {
        super(builder);
        this.description = builder.description;
        this.modelConfig = ApiTypeHelper.requireNonNull(builder.modelConfig, this, "modelConfig");
        this.modelContentHashValue = ApiTypeHelper.requireNonNull(builder.modelContentHashValue, this, "modelContentHashValue");
        this.modelFormat = ApiTypeHelper.requireNonNull(builder.modelFormat, this, "modelFormat");
        this.modelGroupId = builder.modelGroupId;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.totalChunks = ApiTypeHelper.requireNonNull(builder.totalChunks, this, "totalChunks");
        this.url = builder.url;
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static RegisterModelMetaRequest of(Function<RegisterModelMetaRequest.Builder, ObjectBuilder<RegisterModelMetaRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The model description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code model_config}
     */
    @Nonnull
    public final ModelConfig modelConfig() {
        return this.modelConfig;
    }

    /**
     * Required - The model content hash value.
     * <p>
     * API name: {@code model_content_hash_value}
     * </p>
     */
    @Nonnull
    public final String modelContentHashValue() {
        return this.modelContentHashValue;
    }

    /**
     * Required - API name: {@code model_format}
     */
    @Nonnull
    public final ModelFormat modelFormat() {
        return this.modelFormat;
    }

    /**
     * API name: {@code model_group_id}
     */
    @Nullable
    public final String modelGroupId() {
        return this.modelGroupId;
    }

    /**
     * Required - The model name.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - Number of chunks the model is split into.
     * <p>
     * API name: {@code total_chunks}
     * </p>
     */
    public final long totalChunks() {
        return this.totalChunks;
    }

    /**
     * The model URL.
     * <p>
     * API name: {@code url}
     * </p>
     */
    @Nullable
    public final String url() {
        return this.url;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
    public final String version() {
        return this.version;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("model_config");
        this.modelConfig.serialize(generator, mapper);

        generator.writeKey("model_content_hash_value");
        generator.write(this.modelContentHashValue);

        generator.writeKey("model_format");
        this.modelFormat.serialize(generator, mapper);

        if (this.modelGroupId != null) {
            generator.writeKey("model_group_id");
            generator.write(this.modelGroupId);
        }

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("total_chunks");
        generator.write(this.totalChunks);

        if (this.url != null) {
            generator.writeKey("url");
            generator.write(this.url);
        }

        generator.writeKey("version");
        generator.write(this.version);
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
     * Builder for {@link RegisterModelMetaRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RegisterModelMetaRequest> {
        @Nullable
        private String description;
        private ModelConfig modelConfig;
        private String modelContentHashValue;
        private ModelFormat modelFormat;
        @Nullable
        private String modelGroupId;
        private String name;
        private Long totalChunks;
        @Nullable
        private String url;
        private String version;

        public Builder() {}

        private Builder(RegisterModelMetaRequest o) {
            super(o);
            this.description = o.description;
            this.modelConfig = o.modelConfig;
            this.modelContentHashValue = o.modelContentHashValue;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
            this.totalChunks = o.totalChunks;
            this.url = o.url;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.description = o.description;
            this.modelConfig = o.modelConfig;
            this.modelContentHashValue = o.modelContentHashValue;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
            this.totalChunks = o.totalChunks;
            this.url = o.url;
            this.version = o.version;
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
         * The model description.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code model_config}
         */
        @Nonnull
        public final Builder modelConfig(ModelConfig value) {
            this.modelConfig = value;
            return this;
        }

        /**
         * Required - API name: {@code model_config}
         */
        @Nonnull
        public final Builder modelConfig(Function<ModelConfig.Builder, ObjectBuilder<ModelConfig>> fn) {
            return modelConfig(fn.apply(new ModelConfig.Builder()).build());
        }

        /**
         * Required - The model content hash value.
         * <p>
         * API name: {@code model_content_hash_value}
         * </p>
         */
        @Nonnull
        public final Builder modelContentHashValue(String value) {
            this.modelContentHashValue = value;
            return this;
        }

        /**
         * Required - API name: {@code model_format}
         */
        @Nonnull
        public final Builder modelFormat(ModelFormat value) {
            this.modelFormat = value;
            return this;
        }

        /**
         * API name: {@code model_group_id}
         */
        @Nonnull
        public final Builder modelGroupId(@Nullable String value) {
            this.modelGroupId = value;
            return this;
        }

        /**
         * Required - The model name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - Number of chunks the model is split into.
         * <p>
         * API name: {@code total_chunks}
         * </p>
         */
        @Nonnull
        public final Builder totalChunks(long value) {
            this.totalChunks = value;
            return this;
        }

        /**
         * The model URL.
         * <p>
         * API name: {@code url}
         * </p>
         */
        @Nonnull
        public final Builder url(@Nullable String value) {
            this.url = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link RegisterModelMetaRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RegisterModelMetaRequest build() {
            _checkSingleUse();

            return new RegisterModelMetaRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterModelMetaRequest}
     */
    public static final JsonpDeserializer<RegisterModelMetaRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterModelMetaRequest::setupRegisterModelMetaRequestDeserializer
    );

    protected static void setupRegisterModelMetaRequestDeserializer(ObjectDeserializer<RegisterModelMetaRequest.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::modelConfig, ModelConfig._DESERIALIZER, "model_config");
        op.add(Builder::modelContentHashValue, JsonpDeserializer.stringDeserializer(), "model_content_hash_value");
        op.add(Builder::modelFormat, ModelFormat._DESERIALIZER, "model_format");
        op.add(Builder::modelGroupId, JsonpDeserializer.stringDeserializer(), "model_group_id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::totalChunks, JsonpDeserializer.longDeserializer(), "total_chunks");
        op.add(Builder::url, JsonpDeserializer.stringDeserializer(), "url");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.register_model_meta}".
     */
    public static final Endpoint<RegisterModelMetaRequest, RegisterModelMetaResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_ml/models/_register_meta",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        RegisterModelMetaResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.modelConfig.hashCode();
        result = 31 * result + this.modelContentHashValue.hashCode();
        result = 31 * result + this.modelFormat.hashCode();
        result = 31 * result + Objects.hashCode(this.modelGroupId);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Long.hashCode(this.totalChunks);
        result = 31 * result + Objects.hashCode(this.url);
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegisterModelMetaRequest other = (RegisterModelMetaRequest) o;
        return Objects.equals(this.description, other.description)
            && this.modelConfig.equals(other.modelConfig)
            && this.modelContentHashValue.equals(other.modelContentHashValue)
            && this.modelFormat.equals(other.modelFormat)
            && Objects.equals(this.modelGroupId, other.modelGroupId)
            && this.name.equals(other.name)
            && this.totalChunks == other.totalChunks
            && Objects.equals(this.url, other.url)
            && this.version.equals(other.version);
    }
}
