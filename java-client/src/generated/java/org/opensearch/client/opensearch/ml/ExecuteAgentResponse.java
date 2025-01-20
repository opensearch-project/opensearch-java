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
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.execute_agent.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExecuteAgentResponse implements PlainJsonSerializable, ToCopyableBuilder<ExecuteAgentResponse.Builder, ExecuteAgentResponse> {

    @Nonnull
    private final List<InferenceResults> inferenceResults;

    @Nullable
    private final PredictionResult predictionResult;

    @Nullable
    private final Status status;

    // ---------------------------------------------------------------------------------------------

    private ExecuteAgentResponse(Builder builder) {
        this.inferenceResults = ApiTypeHelper.unmodifiable(builder.inferenceResults);
        this.predictionResult = builder.predictionResult;
        this.status = builder.status;
    }

    public static ExecuteAgentResponse of(Function<ExecuteAgentResponse.Builder, ObjectBuilder<ExecuteAgentResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code inference_results}
     */
    @Nonnull
    public final List<InferenceResults> inferenceResults() {
        return this.inferenceResults;
    }

    /**
     * API name: {@code prediction_result}
     */
    @Nullable
    public final PredictionResult predictionResult() {
        return this.predictionResult;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final Status status() {
        return this.status;
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
        if (ApiTypeHelper.isDefined(this.inferenceResults)) {
            generator.writeKey("inference_results");
            generator.writeStartArray();
            for (InferenceResults item0 : this.inferenceResults) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.predictionResult != null) {
            generator.writeKey("prediction_result");
            this.predictionResult.serialize(generator, mapper);
        }

        if (this.status != null) {
            generator.writeKey("status");
            this.status.serialize(generator, mapper);
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
     * Builder for {@link ExecuteAgentResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExecuteAgentResponse> {
        @Nullable
        private List<InferenceResults> inferenceResults;
        @Nullable
        private PredictionResult predictionResult;
        @Nullable
        private Status status;

        public Builder() {}

        private Builder(ExecuteAgentResponse o) {
            this.inferenceResults = _listCopy(o.inferenceResults);
            this.predictionResult = o.predictionResult;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.inferenceResults = _listCopy(o.inferenceResults);
            this.predictionResult = o.predictionResult;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code inference_results}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>inferenceResults</code>.
         * </p>
         */
        @Nonnull
        public final Builder inferenceResults(List<InferenceResults> list) {
            this.inferenceResults = _listAddAll(this.inferenceResults, list);
            return this;
        }

        /**
         * API name: {@code inference_results}
         *
         * <p>
         * Adds one or more values to <code>inferenceResults</code>.
         * </p>
         */
        @Nonnull
        public final Builder inferenceResults(InferenceResults value, InferenceResults... values) {
            this.inferenceResults = _listAdd(this.inferenceResults, value, values);
            return this;
        }

        /**
         * API name: {@code inference_results}
         *
         * <p>
         * Adds a value to <code>inferenceResults</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder inferenceResults(Function<InferenceResults.Builder, ObjectBuilder<InferenceResults>> fn) {
            return inferenceResults(fn.apply(new InferenceResults.Builder()).build());
        }

        /**
         * API name: {@code prediction_result}
         */
        @Nonnull
        public final Builder predictionResult(@Nullable PredictionResult value) {
            this.predictionResult = value;
            return this;
        }

        /**
         * API name: {@code prediction_result}
         */
        @Nonnull
        public final Builder predictionResult(Function<PredictionResult.Builder, ObjectBuilder<PredictionResult>> fn) {
            return predictionResult(fn.apply(new PredictionResult.Builder()).build());
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final Builder status(@Nullable Status value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link ExecuteAgentResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteAgentResponse build() {
            _checkSingleUse();

            return new ExecuteAgentResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteAgentResponse}
     */
    public static final JsonpDeserializer<ExecuteAgentResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteAgentResponse::setupExecuteAgentResponseDeserializer
    );

    protected static void setupExecuteAgentResponseDeserializer(ObjectDeserializer<ExecuteAgentResponse.Builder> op) {
        op.add(Builder::inferenceResults, JsonpDeserializer.arrayDeserializer(InferenceResults._DESERIALIZER), "inference_results");
        op.add(Builder::predictionResult, PredictionResult._DESERIALIZER, "prediction_result");
        op.add(Builder::status, Status._DESERIALIZER, "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.inferenceResults);
        result = 31 * result + Objects.hashCode(this.predictionResult);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExecuteAgentResponse other = (ExecuteAgentResponse) o;
        return Objects.equals(this.inferenceResults, other.inferenceResults)
            && Objects.equals(this.predictionResult, other.predictionResult)
            && Objects.equals(this.status, other.status);
    }
}
