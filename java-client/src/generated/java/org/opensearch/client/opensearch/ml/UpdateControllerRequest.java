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

// typedef: ml.update_controller.Request

/**
 * Updates a controller.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class UpdateControllerRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateControllerRequest.Builder, UpdateControllerRequest> {

    @Nonnull
    private final String modelId;

    @Nonnull
    private final Map<String, RateLimiter> userRateLimiter;

    // ---------------------------------------------------------------------------------------------

    private UpdateControllerRequest(Builder builder) {
        super(builder);
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.userRateLimiter = ApiTypeHelper.unmodifiable(builder.userRateLimiter);
    }

    public static UpdateControllerRequest of(Function<UpdateControllerRequest.Builder, ObjectBuilder<UpdateControllerRequest>> fn) {
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
     * Builder for {@link UpdateControllerRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UpdateControllerRequest> {
        private String modelId;
        @Nullable
        private Map<String, RateLimiter> userRateLimiter;

        public Builder() {}

        private Builder(UpdateControllerRequest o) {
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
         * Builds a {@link UpdateControllerRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateControllerRequest build() {
            _checkSingleUse();

            return new UpdateControllerRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateControllerRequest}
     */
    public static final JsonpDeserializer<UpdateControllerRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateControllerRequest::setupUpdateControllerRequestDeserializer
    );

    protected static void setupUpdateControllerRequestDeserializer(ObjectDeserializer<UpdateControllerRequest.Builder> op) {
        op.add(Builder::userRateLimiter, JsonpDeserializer.stringMapDeserializer(RateLimiter._DESERIALIZER), "user_rate_limiter");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.update_controller}".
     */
    public static final Endpoint<UpdateControllerRequest, UpdateControllerResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
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
        UpdateControllerResponse._DESERIALIZER
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
        UpdateControllerRequest other = (UpdateControllerRequest) o;
        return this.modelId.equals(other.modelId) && Objects.equals(this.userRateLimiter, other.userRateLimiter);
    }
}
