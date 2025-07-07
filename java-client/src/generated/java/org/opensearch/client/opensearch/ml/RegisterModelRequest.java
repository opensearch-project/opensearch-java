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

// typedef: ml.register_model.Request

/**
 * Registers a model.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RegisterModelRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RegisterModelRequest.Builder, RegisterModelRequest> {

    @Nullable
    private final String connectorId;

    @Nullable
    private final String description;

    @Nullable
    private final String functionName;

    @Nullable
    private final ModelConfig modelConfig;

    @Nullable
    private final String modelContentHashValue;

    @Nullable
    private final ModelFormat modelFormat;

    @Nullable
    private final String modelGroupId;

    @Nonnull
    private final String name;

    @Nullable
    private final String url;

    @Nullable
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private RegisterModelRequest(Builder builder) {
        super(builder);
        this.connectorId = builder.connectorId;
        this.description = builder.description;
        this.functionName = builder.functionName;
        this.modelConfig = builder.modelConfig;
        this.modelContentHashValue = builder.modelContentHashValue;
        this.modelFormat = builder.modelFormat;
        this.modelGroupId = builder.modelGroupId;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.url = builder.url;
        this.version = builder.version;
    }

    public static RegisterModelRequest of(Function<RegisterModelRequest.Builder, ObjectBuilder<RegisterModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The connector ID.
     * <p>
     * API name: {@code connector_id}
     * </p>
     */
    @Nullable
    public final String connectorId() {
        return this.connectorId;
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
     * The function name.
     * <p>
     * API name: {@code function_name}
     * </p>
     */
    @Nullable
    public final String functionName() {
        return this.functionName;
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
     * API name: {@code model_format}
     */
    @Nullable
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
     * API name: {@code version}
     */
    @Nullable
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
        if (this.connectorId != null) {
            generator.writeKey("connector_id");
            generator.write(this.connectorId);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.functionName != null) {
            generator.writeKey("function_name");
            generator.write(this.functionName);
        }

        if (this.modelConfig != null) {
            generator.writeKey("model_config");
            this.modelConfig.serialize(generator, mapper);
        }

        if (this.modelContentHashValue != null) {
            generator.writeKey("model_content_hash_value");
            generator.write(this.modelContentHashValue);
        }

        if (this.modelFormat != null) {
            generator.writeKey("model_format");
            this.modelFormat.serialize(generator, mapper);
        }

        if (this.modelGroupId != null) {
            generator.writeKey("model_group_id");
            generator.write(this.modelGroupId);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.url != null) {
            generator.writeKey("url");
            generator.write(this.url);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link RegisterModelRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RegisterModelRequest> {
        @Nullable
        private String connectorId;
        @Nullable
        private String description;
        @Nullable
        private String functionName;
        @Nullable
        private ModelConfig modelConfig;
        @Nullable
        private String modelContentHashValue;
        @Nullable
        private ModelFormat modelFormat;
        @Nullable
        private String modelGroupId;
        private String name;
        @Nullable
        private String url;
        @Nullable
        private String version;

        public Builder() {}

        private Builder(RegisterModelRequest o) {
            super(o);
            this.connectorId = o.connectorId;
            this.description = o.description;
            this.functionName = o.functionName;
            this.modelConfig = o.modelConfig;
            this.modelContentHashValue = o.modelContentHashValue;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
            this.url = o.url;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.connectorId = o.connectorId;
            this.description = o.description;
            this.functionName = o.functionName;
            this.modelConfig = o.modelConfig;
            this.modelContentHashValue = o.modelContentHashValue;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
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
         * The connector ID.
         * <p>
         * API name: {@code connector_id}
         * </p>
         */
        @Nonnull
        public final Builder connectorId(@Nullable String value) {
            this.connectorId = value;
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
         * The function name.
         * <p>
         * API name: {@code function_name}
         * </p>
         */
        @Nonnull
        public final Builder functionName(@Nullable String value) {
            this.functionName = value;
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
         * API name: {@code model_format}
         */
        @Nonnull
        public final Builder modelFormat(@Nullable ModelFormat value) {
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
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link RegisterModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RegisterModelRequest build() {
            _checkSingleUse();

            return new RegisterModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RegisterModelRequest}
     */
    public static final JsonpDeserializer<RegisterModelRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RegisterModelRequest::setupRegisterModelRequestDeserializer
    );

    protected static void setupRegisterModelRequestDeserializer(ObjectDeserializer<RegisterModelRequest.Builder> op) {
        op.add(Builder::connectorId, JsonpDeserializer.stringDeserializer(), "connector_id");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::functionName, JsonpDeserializer.stringDeserializer(), "function_name");
        op.add(Builder::modelConfig, ModelConfig._DESERIALIZER, "model_config");
        op.add(Builder::modelContentHashValue, JsonpDeserializer.stringDeserializer(), "model_content_hash_value");
        op.add(Builder::modelFormat, ModelFormat._DESERIALIZER, "model_format");
        op.add(Builder::modelGroupId, JsonpDeserializer.stringDeserializer(), "model_group_id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::url, JsonpDeserializer.stringDeserializer(), "url");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.register_model}".
     */
    public static final Endpoint<RegisterModelRequest, RegisterModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_ml/models/_register",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        RegisterModelResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.connectorId);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.functionName);
        result = 31 * result + Objects.hashCode(this.modelConfig);
        result = 31 * result + Objects.hashCode(this.modelContentHashValue);
        result = 31 * result + Objects.hashCode(this.modelFormat);
        result = 31 * result + Objects.hashCode(this.modelGroupId);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.url);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegisterModelRequest other = (RegisterModelRequest) o;
        return Objects.equals(this.connectorId, other.connectorId)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.functionName, other.functionName)
            && Objects.equals(this.modelConfig, other.modelConfig)
            && Objects.equals(this.modelContentHashValue, other.modelContentHashValue)
            && Objects.equals(this.modelFormat, other.modelFormat)
            && Objects.equals(this.modelGroupId, other.modelGroupId)
            && this.name.equals(other.name)
            && Objects.equals(this.url, other.url)
            && Objects.equals(this.version, other.version);
    }
}
