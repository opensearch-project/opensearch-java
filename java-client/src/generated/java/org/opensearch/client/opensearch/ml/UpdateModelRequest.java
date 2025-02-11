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
import org.opensearch.client.json.JsonData;
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

// typedef: ml.update_model.Request

/**
 * Updates a model.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateModelRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateModelRequest.Builder, UpdateModelRequest> {

    @Nonnull
    private final Map<String, JsonData> connector;

    @Nullable
    private final String connectorId;

    @Nullable
    private final String description;

    @Nullable
    private final Guardrails guardrails;

    @Nonnull
    private final Map<String, JsonData> interface_;

    @Nullable
    private final Boolean isEnabled;

    @Nullable
    private final ModelConfig modelConfig;

    @Nonnull
    private final String modelId;

    @Nullable
    private final String name;

    @Nullable
    private final RateLimiter rateLimiter;

    // ---------------------------------------------------------------------------------------------

    private UpdateModelRequest(Builder builder) {
        super(builder);
        this.connector = ApiTypeHelper.unmodifiable(builder.connector);
        this.connectorId = builder.connectorId;
        this.description = builder.description;
        this.guardrails = builder.guardrails;
        this.interface_ = ApiTypeHelper.unmodifiable(builder.interface_);
        this.isEnabled = builder.isEnabled;
        this.modelConfig = builder.modelConfig;
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.name = builder.name;
        this.rateLimiter = builder.rateLimiter;
    }

    public static UpdateModelRequest of(Function<UpdateModelRequest.Builder, ObjectBuilder<UpdateModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The connector to use for the model.
     * <p>
     * API name: {@code connector}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> connector() {
        return this.connector;
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
     * API name: {@code guardrails}
     */
    @Nullable
    public final Guardrails guardrails() {
        return this.guardrails;
    }

    /**
     * The model interface.
     * <p>
     * API name: {@code interface}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> interface_() {
        return this.interface_;
    }

    /**
     * Whether the model is enabled.
     * <p>
     * API name: {@code is_enabled}
     * </p>
     */
    @Nullable
    public final Boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * API name: {@code model_config}
     */
    @Nullable
    public final ModelConfig modelConfig() {
        return this.modelConfig;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
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
     * API name: {@code rate_limiter}
     */
    @Nullable
    public final RateLimiter rateLimiter() {
        return this.rateLimiter;
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
        if (ApiTypeHelper.isDefined(this.connector)) {
            generator.writeKey("connector");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.connector.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.connectorId != null) {
            generator.writeKey("connector_id");
            generator.write(this.connectorId);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.guardrails != null) {
            generator.writeKey("guardrails");
            this.guardrails.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.interface_)) {
            generator.writeKey("interface");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.interface_.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.isEnabled != null) {
            generator.writeKey("is_enabled");
            generator.write(this.isEnabled);
        }

        if (this.modelConfig != null) {
            generator.writeKey("model_config");
            this.modelConfig.serialize(generator, mapper);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
        }

        if (this.rateLimiter != null) {
            generator.writeKey("rate_limiter");
            this.rateLimiter.serialize(generator, mapper);
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
     * Builder for {@link UpdateModelRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UpdateModelRequest> {
        @Nullable
        private Map<String, JsonData> connector;
        @Nullable
        private String connectorId;
        @Nullable
        private String description;
        @Nullable
        private Guardrails guardrails;
        @Nullable
        private Map<String, JsonData> interface_;
        @Nullable
        private Boolean isEnabled;
        @Nullable
        private ModelConfig modelConfig;
        private String modelId;
        @Nullable
        private String name;
        @Nullable
        private RateLimiter rateLimiter;

        public Builder() {}

        private Builder(UpdateModelRequest o) {
            super(o);
            this.connector = _mapCopy(o.connector);
            this.connectorId = o.connectorId;
            this.description = o.description;
            this.guardrails = o.guardrails;
            this.interface_ = _mapCopy(o.interface_);
            this.isEnabled = o.isEnabled;
            this.modelConfig = o.modelConfig;
            this.modelId = o.modelId;
            this.name = o.name;
            this.rateLimiter = o.rateLimiter;
        }

        private Builder(Builder o) {
            super(o);
            this.connector = _mapCopy(o.connector);
            this.connectorId = o.connectorId;
            this.description = o.description;
            this.guardrails = o.guardrails;
            this.interface_ = _mapCopy(o.interface_);
            this.isEnabled = o.isEnabled;
            this.modelConfig = o.modelConfig;
            this.modelId = o.modelId;
            this.name = o.name;
            this.rateLimiter = o.rateLimiter;
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
         * The connector to use for the model.
         * <p>
         * API name: {@code connector}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>connector</code>.
         * </p>
         */
        @Nonnull
        public final Builder connector(Map<String, JsonData> map) {
            this.connector = _mapPutAll(this.connector, map);
            return this;
        }

        /**
         * The connector to use for the model.
         * <p>
         * API name: {@code connector}
         * </p>
         *
         * <p>
         * Adds an entry to <code>connector</code>.
         * </p>
         */
        @Nonnull
        public final Builder connector(String key, JsonData value) {
            this.connector = _mapPut(this.connector, key, value);
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
         * API name: {@code guardrails}
         */
        @Nonnull
        public final Builder guardrails(@Nullable Guardrails value) {
            this.guardrails = value;
            return this;
        }

        /**
         * API name: {@code guardrails}
         */
        @Nonnull
        public final Builder guardrails(Function<Guardrails.Builder, ObjectBuilder<Guardrails>> fn) {
            return guardrails(fn.apply(new Guardrails.Builder()).build());
        }

        /**
         * The model interface.
         * <p>
         * API name: {@code interface}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>interface_</code>.
         * </p>
         */
        @Nonnull
        public final Builder interface_(Map<String, JsonData> map) {
            this.interface_ = _mapPutAll(this.interface_, map);
            return this;
        }

        /**
         * The model interface.
         * <p>
         * API name: {@code interface}
         * </p>
         *
         * <p>
         * Adds an entry to <code>interface_</code>.
         * </p>
         */
        @Nonnull
        public final Builder interface_(String key, JsonData value) {
            this.interface_ = _mapPut(this.interface_, key, value);
            return this;
        }

        /**
         * Whether the model is enabled.
         * <p>
         * API name: {@code is_enabled}
         * </p>
         */
        @Nonnull
        public final Builder isEnabled(@Nullable Boolean value) {
            this.isEnabled = value;
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
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
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
         * API name: {@code rate_limiter}
         */
        @Nonnull
        public final Builder rateLimiter(@Nullable RateLimiter value) {
            this.rateLimiter = value;
            return this;
        }

        /**
         * API name: {@code rate_limiter}
         */
        @Nonnull
        public final Builder rateLimiter(Function<RateLimiter.Builder, ObjectBuilder<RateLimiter>> fn) {
            return rateLimiter(fn.apply(new RateLimiter.Builder()).build());
        }

        /**
         * Builds a {@link UpdateModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateModelRequest build() {
            _checkSingleUse();

            return new UpdateModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateModelRequest}
     */
    public static final JsonpDeserializer<UpdateModelRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateModelRequest::setupUpdateModelRequestDeserializer
    );

    protected static void setupUpdateModelRequestDeserializer(ObjectDeserializer<UpdateModelRequest.Builder> op) {
        op.add(Builder::connector, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "connector");
        op.add(Builder::connectorId, JsonpDeserializer.stringDeserializer(), "connector_id");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::guardrails, Guardrails._DESERIALIZER, "guardrails");
        op.add(Builder::interface_, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "interface");
        op.add(Builder::isEnabled, JsonpDeserializer.booleanDeserializer(), "is_enabled");
        op.add(Builder::modelConfig, ModelConfig._DESERIALIZER, "model_config");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::rateLimiter, RateLimiter._DESERIALIZER, "rate_limiter");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.update_model}".
     */
    public static final Endpoint<UpdateModelRequest, UpdateModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/models/");
            SimpleEndpoint.pathEncode(request.modelId, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        UpdateModelResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.connector);
        result = 31 * result + Objects.hashCode(this.connectorId);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.guardrails);
        result = 31 * result + Objects.hashCode(this.interface_);
        result = 31 * result + Objects.hashCode(this.isEnabled);
        result = 31 * result + Objects.hashCode(this.modelConfig);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.rateLimiter);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateModelRequest other = (UpdateModelRequest) o;
        return Objects.equals(this.connector, other.connector)
            && Objects.equals(this.connectorId, other.connectorId)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.guardrails, other.guardrails)
            && Objects.equals(this.interface_, other.interface_)
            && Objects.equals(this.isEnabled, other.isEnabled)
            && Objects.equals(this.modelConfig, other.modelConfig)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.name, other.name)
            && Objects.equals(this.rateLimiter, other.rateLimiter);
    }
}
