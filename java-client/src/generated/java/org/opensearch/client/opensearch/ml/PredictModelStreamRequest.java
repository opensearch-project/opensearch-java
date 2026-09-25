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

// typedef: ml.predict_model_stream.Request

/**
 * Predicts a model in streaming mode.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PredictModelStreamRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PredictModelStreamRequest.Builder, PredictModelStreamRequest> {

    @Nullable
    private final PredictionActionType actionType;

    @Nonnull
    private final Map<String, String> dlq;

    @Nonnull
    private final String modelId;

    @Nonnull
    private final Map<String, String> parameters;

    // ---------------------------------------------------------------------------------------------

    private PredictModelStreamRequest(Builder builder) {
        super(builder);
        this.actionType = builder.actionType;
        this.dlq = ApiTypeHelper.unmodifiable(builder.dlq);
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
    }

    public static PredictModelStreamRequest of(Function<PredictModelStreamRequest.Builder, ObjectBuilder<PredictModelStreamRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Overrides the action type derived from the request path.
     * <p>
     * API name: {@code action_type}
     * </p>
     */
    @Nullable
    public final PredictionActionType actionType() {
        return this.actionType;
    }

    /**
     * Dead-letter queue configuration for batch predict on remote connector models.
     * <p>
     * API name: {@code dlq}
     * </p>
     */
    @Nonnull
    public final Map<String, String> dlq() {
        return this.dlq;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * The parameters to pass to the remote connector model.
     * <p>
     * API name: {@code parameters}
     * </p>
     */
    @Nonnull
    public final Map<String, String> parameters() {
        return this.parameters;
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
        if (this.actionType != null) {
            generator.writeKey("action_type");
            this.actionType.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.dlq)) {
            generator.writeKey("dlq");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.dlq.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
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
     * Builder for {@link PredictModelStreamRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PredictModelStreamRequest> {
        @Nullable
        private PredictionActionType actionType;
        @Nullable
        private Map<String, String> dlq;
        private String modelId;
        @Nullable
        private Map<String, String> parameters;

        public Builder() {}

        private Builder(PredictModelStreamRequest o) {
            super(o);
            this.actionType = o.actionType;
            this.dlq = _mapCopy(o.dlq);
            this.modelId = o.modelId;
            this.parameters = _mapCopy(o.parameters);
        }

        private Builder(Builder o) {
            super(o);
            this.actionType = o.actionType;
            this.dlq = _mapCopy(o.dlq);
            this.modelId = o.modelId;
            this.parameters = _mapCopy(o.parameters);
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
         * Overrides the action type derived from the request path.
         * <p>
         * API name: {@code action_type}
         * </p>
         */
        @Nonnull
        public final Builder actionType(@Nullable PredictionActionType value) {
            this.actionType = value;
            return this;
        }

        /**
         * Dead-letter queue configuration for batch predict on remote connector models.
         * <p>
         * API name: {@code dlq}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>dlq</code>.
         * </p>
         */
        @Nonnull
        public final Builder dlq(Map<String, String> map) {
            this.dlq = _mapPutAll(this.dlq, map);
            return this;
        }

        /**
         * Dead-letter queue configuration for batch predict on remote connector models.
         * <p>
         * API name: {@code dlq}
         * </p>
         *
         * <p>
         * Adds an entry to <code>dlq</code>.
         * </p>
         */
        @Nonnull
        public final Builder dlq(String key, String value) {
            this.dlq = _mapPut(this.dlq, key, value);
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
         * The parameters to pass to the remote connector model.
         * <p>
         * API name: {@code parameters}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(Map<String, String> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * The parameters to pass to the remote connector model.
         * <p>
         * API name: {@code parameters}
         * </p>
         *
         * <p>
         * Adds an entry to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(String key, String value) {
            this.parameters = _mapPut(this.parameters, key, value);
            return this;
        }

        /**
         * Builds a {@link PredictModelStreamRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PredictModelStreamRequest build() {
            _checkSingleUse();

            return new PredictModelStreamRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PredictModelStreamRequest}
     */
    public static final JsonpDeserializer<PredictModelStreamRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PredictModelStreamRequest::setupPredictModelStreamRequestDeserializer
    );

    protected static void setupPredictModelStreamRequestDeserializer(ObjectDeserializer<PredictModelStreamRequest.Builder> op) {
        op.add(Builder::actionType, PredictionActionType._DESERIALIZER, "action_type");
        op.add(Builder::dlq, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "dlq");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "parameters");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.predict_model_stream}".
     */
    public static final Endpoint<PredictModelStreamRequest, PredictModelStreamResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/models/");
            SimpleEndpoint.pathEncode(request.modelId, buf);
            buf.append("/_predict/stream");
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
        PredictModelStreamResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actionType);
        result = 31 * result + Objects.hashCode(this.dlq);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.parameters);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictModelStreamRequest other = (PredictModelStreamRequest) o;
        return Objects.equals(this.actionType, other.actionType)
            && Objects.equals(this.dlq, other.dlq)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.parameters, other.parameters);
    }
}
