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

// typedef: ml.execute_tool.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExecuteToolResponse implements PlainJsonSerializable, ToCopyableBuilder<ExecuteToolResponse.Builder, ExecuteToolResponse> {

    @Nonnull
    private final List<InferenceResults> inferenceResults;

    // ---------------------------------------------------------------------------------------------

    private ExecuteToolResponse(Builder builder) {
        this.inferenceResults = ApiTypeHelper.unmodifiable(builder.inferenceResults);
    }

    public static ExecuteToolResponse of(Function<ExecuteToolResponse.Builder, ObjectBuilder<ExecuteToolResponse>> fn) {
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
     * Builder for {@link ExecuteToolResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExecuteToolResponse> {
        @Nullable
        private List<InferenceResults> inferenceResults;

        public Builder() {}

        private Builder(ExecuteToolResponse o) {
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
         * Builds a {@link ExecuteToolResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteToolResponse build() {
            _checkSingleUse();

            return new ExecuteToolResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteToolResponse}
     */
    public static final JsonpDeserializer<ExecuteToolResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteToolResponse::setupExecuteToolResponseDeserializer
    );

    protected static void setupExecuteToolResponseDeserializer(ObjectDeserializer<ExecuteToolResponse.Builder> op) {
        op.add(Builder::inferenceResults, JsonpDeserializer.arrayDeserializer(InferenceResults._DESERIALIZER), "inference_results");
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
        ExecuteToolResponse other = (ExecuteToolResponse) o;
        return Objects.equals(this.inferenceResults, other.inferenceResults);
    }
}
