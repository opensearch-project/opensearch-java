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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

    @Nonnull
    private final String modelId;

    @Nonnull
    private final Map<String, JsonData> parameters;

    // ---------------------------------------------------------------------------------------------

    private PredictModelStreamRequest(Builder builder) {
        super(builder);
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.parameters = ApiTypeHelper.unmodifiableRequired(builder.parameters, this, "parameters");
    }

    public static PredictModelStreamRequest of(Function<PredictModelStreamRequest.Builder, ObjectBuilder<PredictModelStreamRequest>> fn) {
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
     * Required - API name: {@code parameters}
     */
    @Nonnull
    public final Map<String, JsonData> parameters() {
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
        generator.writeKey("parameters");
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
        private String modelId;
        private Map<String, JsonData> parameters;

        public Builder() {}

        private Builder(PredictModelStreamRequest o) {
            super(o);
            this.modelId = o.modelId;
            this.parameters = _mapCopy(o.parameters);
        }

        private Builder(Builder o) {
            super(o);
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
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(Map<String, JsonData> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         *
         * <p>
         * Adds an entry to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(String key, JsonData value) {
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
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
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
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + this.parameters.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictModelStreamRequest other = (PredictModelStreamRequest) o;
        return this.modelId.equals(other.modelId) && this.parameters.equals(other.parameters);
    }
}
