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

// typedef: ml.predict.Request

/**
 * Predicts new data with trained model.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PredictRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PredictRequest.Builder, PredictRequest> {

    @Nonnull
    private final String algorithmName;

    @Nonnull
    private final List<String> inputIndex;

    @Nullable
    private final InputQuery inputQuery;

    @Nonnull
    private final String modelId;

    @Nullable
    private final Boolean returnNumber;

    @Nonnull
    private final List<String> targetResponse;

    @Nonnull
    private final List<String> textDocs;

    // ---------------------------------------------------------------------------------------------

    private PredictRequest(Builder builder) {
        super(builder);
        this.algorithmName = ApiTypeHelper.requireNonNull(builder.algorithmName, this, "algorithmName");
        this.inputIndex = ApiTypeHelper.unmodifiable(builder.inputIndex);
        this.inputQuery = builder.inputQuery;
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.returnNumber = builder.returnNumber;
        this.targetResponse = ApiTypeHelper.unmodifiable(builder.targetResponse);
        this.textDocs = ApiTypeHelper.unmodifiable(builder.textDocs);
    }

    public static PredictRequest of(Function<PredictRequest.Builder, ObjectBuilder<PredictRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code algorithm_name}
     */
    @Nonnull
    public final String algorithmName() {
        return this.algorithmName;
    }

    /**
     * The input index.
     * <p>
     * API name: {@code input_index}
     * </p>
     */
    @Nonnull
    public final List<String> inputIndex() {
        return this.inputIndex;
    }

    /**
     * API name: {@code input_query}
     */
    @Nullable
    public final InputQuery inputQuery() {
        return this.inputQuery;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * Whether to return bytes in model output.
     * <p>
     * API name: {@code return_number}
     * </p>
     */
    @Nullable
    public final Boolean returnNumber() {
        return this.returnNumber;
    }

    /**
     * The target response.
     * <p>
     * API name: {@code target_response}
     * </p>
     */
    @Nonnull
    public final List<String> targetResponse() {
        return this.targetResponse;
    }

    /**
     * The text documents.
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
        if (ApiTypeHelper.isDefined(this.inputIndex)) {
            generator.writeKey("input_index");
            generator.writeStartArray();
            for (String item0 : this.inputIndex) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.inputQuery != null) {
            generator.writeKey("input_query");
            this.inputQuery.serialize(generator, mapper);
        }

        if (this.returnNumber != null) {
            generator.writeKey("return_number");
            generator.write(this.returnNumber);
        }

        if (ApiTypeHelper.isDefined(this.targetResponse)) {
            generator.writeKey("target_response");
            generator.writeStartArray();
            for (String item0 : this.targetResponse) {
                generator.write(item0);
            }
            generator.writeEnd();
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
     * Builder for {@link PredictRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PredictRequest> {
        private String algorithmName;
        @Nullable
        private List<String> inputIndex;
        @Nullable
        private InputQuery inputQuery;
        private String modelId;
        @Nullable
        private Boolean returnNumber;
        @Nullable
        private List<String> targetResponse;
        @Nullable
        private List<String> textDocs;

        public Builder() {}

        private Builder(PredictRequest o) {
            super(o);
            this.algorithmName = o.algorithmName;
            this.inputIndex = _listCopy(o.inputIndex);
            this.inputQuery = o.inputQuery;
            this.modelId = o.modelId;
            this.returnNumber = o.returnNumber;
            this.targetResponse = _listCopy(o.targetResponse);
            this.textDocs = _listCopy(o.textDocs);
        }

        private Builder(Builder o) {
            super(o);
            this.algorithmName = o.algorithmName;
            this.inputIndex = _listCopy(o.inputIndex);
            this.inputQuery = o.inputQuery;
            this.modelId = o.modelId;
            this.returnNumber = o.returnNumber;
            this.targetResponse = _listCopy(o.targetResponse);
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
         * Required - API name: {@code algorithm_name}
         */
        @Nonnull
        public final Builder algorithmName(String value) {
            this.algorithmName = value;
            return this;
        }

        /**
         * The input index.
         * <p>
         * API name: {@code input_index}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>inputIndex</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputIndex(List<String> list) {
            this.inputIndex = _listAddAll(this.inputIndex, list);
            return this;
        }

        /**
         * The input index.
         * <p>
         * API name: {@code input_index}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>inputIndex</code>.
         * </p>
         */
        @Nonnull
        public final Builder inputIndex(String value, String... values) {
            this.inputIndex = _listAdd(this.inputIndex, value, values);
            return this;
        }

        /**
         * API name: {@code input_query}
         */
        @Nonnull
        public final Builder inputQuery(@Nullable InputQuery value) {
            this.inputQuery = value;
            return this;
        }

        /**
         * API name: {@code input_query}
         */
        @Nonnull
        public final Builder inputQuery(Function<InputQuery.Builder, ObjectBuilder<InputQuery>> fn) {
            return inputQuery(fn.apply(new InputQuery.Builder()).build());
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
         * Whether to return bytes in model output.
         * <p>
         * API name: {@code return_number}
         * </p>
         */
        @Nonnull
        public final Builder returnNumber(@Nullable Boolean value) {
            this.returnNumber = value;
            return this;
        }

        /**
         * The target response.
         * <p>
         * API name: {@code target_response}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>targetResponse</code>.
         * </p>
         */
        @Nonnull
        public final Builder targetResponse(List<String> list) {
            this.targetResponse = _listAddAll(this.targetResponse, list);
            return this;
        }

        /**
         * The target response.
         * <p>
         * API name: {@code target_response}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>targetResponse</code>.
         * </p>
         */
        @Nonnull
        public final Builder targetResponse(String value, String... values) {
            this.targetResponse = _listAdd(this.targetResponse, value, values);
            return this;
        }

        /**
         * The text documents.
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
         * The text documents.
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
         * Builds a {@link PredictRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PredictRequest build() {
            _checkSingleUse();

            return new PredictRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PredictRequest}
     */
    public static final JsonpDeserializer<PredictRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PredictRequest::setupPredictRequestDeserializer
    );

    protected static void setupPredictRequestDeserializer(ObjectDeserializer<PredictRequest.Builder> op) {
        op.add(Builder::inputIndex, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "input_index");
        op.add(Builder::inputQuery, InputQuery._DESERIALIZER, "input_query");
        op.add(Builder::returnNumber, JsonpDeserializer.booleanDeserializer(), "return_number");
        op.add(Builder::targetResponse, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "target_response");
        op.add(Builder::textDocs, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "text_docs");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.predict}".
     */
    public static final Endpoint<PredictRequest, PredictResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/_predict/");
            SimpleEndpoint.pathEncode(request.algorithmName, buf);
            buf.append("/");
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
        PredictResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.algorithmName.hashCode();
        result = 31 * result + Objects.hashCode(this.inputIndex);
        result = 31 * result + Objects.hashCode(this.inputQuery);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.returnNumber);
        result = 31 * result + Objects.hashCode(this.targetResponse);
        result = 31 * result + Objects.hashCode(this.textDocs);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictRequest other = (PredictRequest) o;
        return this.algorithmName.equals(other.algorithmName)
            && Objects.equals(this.inputIndex, other.inputIndex)
            && Objects.equals(this.inputQuery, other.inputQuery)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.returnNumber, other.returnNumber)
            && Objects.equals(this.targetResponse, other.targetResponse)
            && Objects.equals(this.textDocs, other.textDocs);
    }
}
