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
    private final String description;

    @Nonnull
    private final String modelFormat;

    @Nullable
    private final String modelGroupId;

    @Nonnull
    private final String name;

    @Nonnull
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private RegisterModelRequest(Builder builder) {
        super(builder);
        this.description = builder.description;
        this.modelFormat = ApiTypeHelper.requireNonNull(builder.modelFormat, this, "modelFormat");
        this.modelGroupId = builder.modelGroupId;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static RegisterModelRequest of(Function<RegisterModelRequest.Builder, ObjectBuilder<RegisterModelRequest>> fn) {
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
     * Required - The portable format of the model file.
     * <p>
     * API name: {@code model_format}
     * </p>
     */
    @Nonnull
    public final String modelFormat() {
        return this.modelFormat;
    }

    /**
     * The ID of the model group to which to register the model.
     * <p>
     * API name: {@code model_group_id}
     * </p>
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
     * Required - The model version.
     * <p>
     * API name: {@code version}
     * </p>
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

        generator.writeKey("model_format");
        generator.write(this.modelFormat);

        if (this.modelGroupId != null) {
            generator.writeKey("model_group_id");
            generator.write(this.modelGroupId);
        }

        generator.writeKey("name");
        generator.write(this.name);

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
     * Builder for {@link RegisterModelRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RegisterModelRequest> {
        @Nullable
        private String description;
        private String modelFormat;
        @Nullable
        private String modelGroupId;
        private String name;
        private String version;

        public Builder() {}

        private Builder(RegisterModelRequest o) {
            super(o);
            this.description = o.description;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.description = o.description;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
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
         * Required - The portable format of the model file.
         * <p>
         * API name: {@code model_format}
         * </p>
         */
        @Nonnull
        public final Builder modelFormat(String value) {
            this.modelFormat = value;
            return this;
        }

        /**
         * The ID of the model group to which to register the model.
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
         * Required - The model version.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(String value) {
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
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::modelFormat, JsonpDeserializer.stringDeserializer(), "model_format");
        op.add(Builder::modelGroupId, JsonpDeserializer.stringDeserializer(), "model_group_id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
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
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.modelFormat.hashCode();
        result = 31 * result + Objects.hashCode(this.modelGroupId);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RegisterModelRequest other = (RegisterModelRequest) o;
        return Objects.equals(this.description, other.description)
            && this.modelFormat.equals(other.modelFormat)
            && Objects.equals(this.modelGroupId, other.modelGroupId)
            && this.name.equals(other.name)
            && this.version.equals(other.version);
    }
}
