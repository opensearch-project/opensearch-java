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

// typedef: ml.create_controller.Request

/**
 * Creates a controller.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CreateControllerRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateControllerRequest.Builder, CreateControllerRequest> {

    @Nonnull
    private final String modelId;

    @Nonnull
    private final Map<String, RateLimiter> userRateLimiter;

    // ---------------------------------------------------------------------------------------------

    private CreateControllerRequest(Builder builder) {
        super(builder);
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.userRateLimiter = ApiTypeHelper.unmodifiable(builder.userRateLimiter);
    }

    public static CreateControllerRequest of(Function<CreateControllerRequest.Builder, ObjectBuilder<CreateControllerRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code user_rate_limiter}
     */
    @Nonnull
    public final Map<String, RateLimiter> userRateLimiter() {
        return this.userRateLimiter;
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
        if (ApiTypeHelper.isDefined(this.userRateLimiter)) {
            generator.writeKey("user_rate_limiter");
            generator.writeStartObject();
            for (Map.Entry<String, RateLimiter> item0 : this.userRateLimiter.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link CreateControllerRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CreateControllerRequest> {
        private String modelId;
        @Nullable
        private Map<String, RateLimiter> userRateLimiter;

        public Builder() {}

        private Builder(CreateControllerRequest o) {
            super(o);
            this.modelId = o.modelId;
            this.userRateLimiter = _mapCopy(o.userRateLimiter);
        }

        private Builder(Builder o) {
            super(o);
            this.modelId = o.modelId;
            this.userRateLimiter = _mapCopy(o.userRateLimiter);
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
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code user_rate_limiter}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>userRateLimiter</code>.
         * </p>
         */
        @Nonnull
        public final Builder userRateLimiter(Map<String, RateLimiter> map) {
            this.userRateLimiter = _mapPutAll(this.userRateLimiter, map);
            return this;
        }

        /**
         * API name: {@code user_rate_limiter}
         *
         * <p>
         * Adds an entry to <code>userRateLimiter</code>.
         * </p>
         */
        @Nonnull
        public final Builder userRateLimiter(String key, RateLimiter value) {
            this.userRateLimiter = _mapPut(this.userRateLimiter, key, value);
            return this;
        }

        /**
         * API name: {@code user_rate_limiter}
         *
         * <p>
         * Adds a value to <code>userRateLimiter</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder userRateLimiter(String key, Function<RateLimiter.Builder, ObjectBuilder<RateLimiter>> fn) {
            return userRateLimiter(key, fn.apply(new RateLimiter.Builder()).build());
        }

        /**
         * Builds a {@link CreateControllerRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateControllerRequest build() {
            _checkSingleUse();

            return new CreateControllerRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateControllerRequest}
     */
    public static final JsonpDeserializer<CreateControllerRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateControllerRequest::setupCreateControllerRequestDeserializer
    );

    protected static void setupCreateControllerRequestDeserializer(ObjectDeserializer<CreateControllerRequest.Builder> op) {
        op.add(Builder::userRateLimiter, JsonpDeserializer.stringMapDeserializer(RateLimiter._DESERIALIZER), "user_rate_limiter");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.create_controller}".
     */
    public static final Endpoint<CreateControllerRequest, CreateControllerResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/controllers/");
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
        CreateControllerResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.userRateLimiter);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateControllerRequest other = (CreateControllerRequest) o;
        return this.modelId.equals(other.modelId) && Objects.equals(this.userRateLimiter, other.userRateLimiter);
    }
}
