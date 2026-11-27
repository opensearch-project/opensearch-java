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
import java.util.List;
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

// typedef: ml.predict_model.Request

/**
 * Predicts a model.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PredictModelRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PredictModelRequest.Builder, PredictModelRequest> {

    @Nullable
    private final PredictionActionType actionType;

    @Nullable
    private final String context;

    @Nonnull
    private final Map<String, String> dlq;

    @Nonnull
    private final String modelId;

    @Nonnull
    private final Map<String, String> parameters;

    @Nullable
    private final String queryText;

    @Nullable
    private final String question;

    @Nonnull
    private final List<String> textDocs;

    // ---------------------------------------------------------------------------------------------

    private PredictModelRequest(Builder builder) {
        super(builder);
        this.actionType = builder.actionType;
        this.context = builder.context;
        this.dlq = ApiTypeHelper.unmodifiable(builder.dlq);
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.queryText = builder.queryText;
        this.question = builder.question;
        this.textDocs = ApiTypeHelper.unmodifiable(builder.textDocs);
    }

    public static PredictModelRequest of(Function<PredictModelRequest.Builder, ObjectBuilder<PredictModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Overrides the action type derived from the request path. Used for remote connector models.
     * <p>
     * API name: {@code action_type}
     * </p>
     */
    @Nullable
    public final PredictionActionType actionType() {
        return this.actionType;
    }

    /**
     * The context input. Used by local question-answering models.
     * <p>
     * API name: {@code context}
     * </p>
     */
    @Nullable
    public final String context() {
        return this.context;
    }

    /**
     * Dead-letter queue configuration for batch predict on remote connector models (since OpenSearch 2.19).
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
     * The parameters to pass to the model. Used by remote connector models to fill the connector request_body template variables from this
     * map.
     * <p>
     * API name: {@code parameters}
     * </p>
     */
    @Nonnull
    public final Map<String, String> parameters() {
        return this.parameters;
    }

    /**
     * The query text. Used by local text-similarity models.
     * <p>
     * API name: {@code query_text}
     * </p>
     */
    @Nullable
    public final String queryText() {
        return this.queryText;
    }

    /**
     * The question input. Used by local question-answering models.
     * <p>
     * API name: {@code question}
     * </p>
     */
    @Nullable
    public final String question() {
        return this.question;
    }

    /**
     * The text documents. Used by local text-embedding and sparse-encoding models.
     * <p>
     * API name: {@code text_docs}
     * </p>
     */
    @Nonnull
    public final List<String> textDocs() {
        return this.textDocs;
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

        if (this.context != null) {
            generator.writeKey("context");
            generator.write(this.context);
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

        if (this.queryText != null) {
            generator.writeKey("query_text");
            generator.write(this.queryText);
        }

        if (this.question != null) {
            generator.writeKey("question");
            generator.write(this.question);
        }

        if (ApiTypeHelper.isDefined(this.textDocs)) {
            generator.writeKey("text_docs");
            generator.writeStartArray();
            for (String item0 : this.textDocs) {
                generator.write(item0);
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
     * Builder for {@link PredictModelRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PredictModelRequest> {
        @Nullable
        private PredictionActionType actionType;
        @Nullable
        private String context;
        @Nullable
        private Map<String, String> dlq;
        private String modelId;
        @Nullable
        private Map<String, String> parameters;
        @Nullable
        private String queryText;
        @Nullable
        private String question;
        @Nullable
        private List<String> textDocs;

        public Builder() {}

        private Builder(PredictModelRequest o) {
            super(o);
            this.actionType = o.actionType;
            this.context = o.context;
            this.dlq = _mapCopy(o.dlq);
            this.modelId = o.modelId;
            this.parameters = _mapCopy(o.parameters);
            this.queryText = o.queryText;
            this.question = o.question;
            this.textDocs = _listCopy(o.textDocs);
        }

        private Builder(Builder o) {
            super(o);
            this.actionType = o.actionType;
            this.context = o.context;
            this.dlq = _mapCopy(o.dlq);
            this.modelId = o.modelId;
            this.parameters = _mapCopy(o.parameters);
            this.queryText = o.queryText;
            this.question = o.question;
            this.textDocs = _listCopy(o.textDocs);
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
         * Overrides the action type derived from the request path. Used for remote connector models.
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
         * The context input. Used by local question-answering models.
         * <p>
         * API name: {@code context}
         * </p>
         */
        @Nonnull
        public final Builder context(@Nullable String value) {
            this.context = value;
            return this;
        }

        /**
         * Dead-letter queue configuration for batch predict on remote connector models (since OpenSearch 2.19).
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
         * Dead-letter queue configuration for batch predict on remote connector models (since OpenSearch 2.19).
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
         * The parameters to pass to the model. Used by remote connector models to fill the connector request_body template variables from
         * this map.
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
         * The parameters to pass to the model. Used by remote connector models to fill the connector request_body template variables from
         * this map.
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
         * The query text. Used by local text-similarity models.
         * <p>
         * API name: {@code query_text}
         * </p>
         */
        @Nonnull
        public final Builder queryText(@Nullable String value) {
            this.queryText = value;
            return this;
        }

        /**
         * The question input. Used by local question-answering models.
         * <p>
         * API name: {@code question}
         * </p>
         */
        @Nonnull
        public final Builder question(@Nullable String value) {
            this.question = value;
            return this;
        }

        /**
         * The text documents. Used by local text-embedding and sparse-encoding models.
         * <p>
         * API name: {@code text_docs}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>textDocs</code>.
         * </p>
         */
        @Nonnull
        public final Builder textDocs(List<String> list) {
            this.textDocs = _listAddAll(this.textDocs, list);
            return this;
        }

        /**
         * The text documents. Used by local text-embedding and sparse-encoding models.
         * <p>
         * API name: {@code text_docs}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>textDocs</code>.
         * </p>
         */
        @Nonnull
        public final Builder textDocs(String value, String... values) {
            this.textDocs = _listAdd(this.textDocs, value, values);
            return this;
        }

        /**
         * Builds a {@link PredictModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PredictModelRequest build() {
            _checkSingleUse();

            return new PredictModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PredictModelRequest}
     */
    public static final JsonpDeserializer<PredictModelRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PredictModelRequest::setupPredictModelRequestDeserializer
    );

    protected static void setupPredictModelRequestDeserializer(ObjectDeserializer<PredictModelRequest.Builder> op) {
        op.add(Builder::actionType, PredictionActionType._DESERIALIZER, "action_type");
        op.add(Builder::context, JsonpDeserializer.stringDeserializer(), "context");
        op.add(Builder::dlq, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "dlq");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "parameters");
        op.add(Builder::queryText, JsonpDeserializer.stringDeserializer(), "query_text");
        op.add(Builder::question, JsonpDeserializer.stringDeserializer(), "question");
        op.add(Builder::textDocs, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "text_docs");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.predict_model}".
     */
    public static final Endpoint<PredictModelRequest, PredictModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/models/");
            SimpleEndpoint.pathEncode(request.modelId, buf);
            buf.append("/_predict");
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
        PredictModelResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actionType);
        result = 31 * result + Objects.hashCode(this.context);
        result = 31 * result + Objects.hashCode(this.dlq);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.queryText);
        result = 31 * result + Objects.hashCode(this.question);
        result = 31 * result + Objects.hashCode(this.textDocs);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictModelRequest other = (PredictModelRequest) o;
        return Objects.equals(this.actionType, other.actionType)
            && Objects.equals(this.context, other.context)
            && Objects.equals(this.dlq, other.dlq)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.parameters, other.parameters)
            && Objects.equals(this.queryText, other.queryText)
            && Objects.equals(this.question, other.question)
            && Objects.equals(this.textDocs, other.textDocs);
    }
}
