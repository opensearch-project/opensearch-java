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

// typedef: ml.predict_model.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PredictModelResponse implements PlainJsonSerializable, ToCopyableBuilder<PredictModelResponse.Builder, PredictModelResponse> {

    @Nonnull
    private final List<PredictModelResult> inferenceResults;

    // ---------------------------------------------------------------------------------------------

    private PredictModelResponse(Builder builder) {
        this.inferenceResults = ApiTypeHelper.unmodifiable(builder.inferenceResults);
    }

    public static PredictModelResponse of(Function<PredictModelResponse.Builder, ObjectBuilder<PredictModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code inference_results}
     */
    @Nonnull
    public final List<PredictModelResult> inferenceResults() {
        return this.inferenceResults;
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
            for (PredictModelResult item0 : this.inferenceResults) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link PredictModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PredictModelResponse> {
        @Nullable
        private List<PredictModelResult> inferenceResults;

        public Builder() {}

        private Builder(PredictModelResponse o) {
            this.inferenceResults = _listCopy(o.inferenceResults);
        }

        private Builder(Builder o) {
            this.inferenceResults = _listCopy(o.inferenceResults);
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
        public final Builder inferenceResults(List<PredictModelResult> list) {
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
        public final Builder inferenceResults(PredictModelResult value, PredictModelResult... values) {
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
        public final Builder inferenceResults(Function<PredictModelResult.Builder, ObjectBuilder<PredictModelResult>> fn) {
            return inferenceResults(fn.apply(new PredictModelResult.Builder()).build());
        }

        /**
         * Builds a {@link PredictModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PredictModelResponse build() {
            _checkSingleUse();

            return new PredictModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PredictModelResponse}
     */
    public static final JsonpDeserializer<PredictModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PredictModelResponse::setupPredictModelResponseDeserializer
    );

    protected static void setupPredictModelResponseDeserializer(ObjectDeserializer<PredictModelResponse.Builder> op) {
        op.add(Builder::inferenceResults, JsonpDeserializer.arrayDeserializer(PredictModelResult._DESERIALIZER), "inference_results");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.inferenceResults);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictModelResponse other = (PredictModelResponse) o;
        return Objects.equals(this.inferenceResults, other.inferenceResults);
    }
}
