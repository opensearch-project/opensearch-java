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

// typedef: ml.execute_algorithm.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ExecuteAlgorithmResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExecuteAlgorithmResponse.Builder, ExecuteAlgorithmResponse> {

    @Nullable
    private final Number result;

    @Nonnull
    private final List<ExecuteAnomalyLocalizationResponse> results;

    // ---------------------------------------------------------------------------------------------

    private ExecuteAlgorithmResponse(Builder builder) {
        this.result = builder.result;
        this.results = ApiTypeHelper.unmodifiable(builder.results);
    }

    public static ExecuteAlgorithmResponse of(Function<ExecuteAlgorithmResponse.Builder, ObjectBuilder<ExecuteAlgorithmResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The result.
     * <p>
     * API name: {@code result}
     * </p>
     */
    @Nullable
    public final Number result() {
        return this.result;
    }

    /**
     * API name: {@code results}
     */
    @Nonnull
    public final List<ExecuteAnomalyLocalizationResponse> results() {
        return this.results;
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
        if (this.result != null) {
            generator.writeKey("result");
            generator.write(this.result.doubleValue());
        }

        if (ApiTypeHelper.isDefined(this.results)) {
            generator.writeKey("results");
            generator.writeStartArray();
            for (ExecuteAnomalyLocalizationResponse item0 : this.results) {
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
     * Builder for {@link ExecuteAlgorithmResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ExecuteAlgorithmResponse> {
        @Nullable
        private Number result;
        @Nullable
        private List<ExecuteAnomalyLocalizationResponse> results;

        public Builder() {}

        private Builder(ExecuteAlgorithmResponse o) {
            this.result = o.result;
            this.results = _listCopy(o.results);
        }

        private Builder(Builder o) {
            this.result = o.result;
            this.results = _listCopy(o.results);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The result.
         * <p>
         * API name: {@code result}
         * </p>
         */
        @Nonnull
        public final Builder result(@Nullable Number value) {
            this.result = value;
            return this;
        }

        /**
         * API name: {@code results}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>results</code>.
         * </p>
         */
        @Nonnull
        public final Builder results(List<ExecuteAnomalyLocalizationResponse> list) {
            this.results = _listAddAll(this.results, list);
            return this;
        }

        /**
         * API name: {@code results}
         *
         * <p>
         * Adds one or more values to <code>results</code>.
         * </p>
         */
        @Nonnull
        public final Builder results(ExecuteAnomalyLocalizationResponse value, ExecuteAnomalyLocalizationResponse... values) {
            this.results = _listAdd(this.results, value, values);
            return this;
        }

        /**
         * API name: {@code results}
         *
         * <p>
         * Adds a value to <code>results</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder results(
            Function<ExecuteAnomalyLocalizationResponse.Builder, ObjectBuilder<ExecuteAnomalyLocalizationResponse>> fn
        ) {
            return results(fn.apply(new ExecuteAnomalyLocalizationResponse.Builder()).build());
        }

        /**
         * Builds a {@link ExecuteAlgorithmResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteAlgorithmResponse build() {
            _checkSingleUse();

            return new ExecuteAlgorithmResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteAlgorithmResponse}
     */
    public static final JsonpDeserializer<ExecuteAlgorithmResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteAlgorithmResponse::setupExecuteAlgorithmResponseDeserializer
    );

    protected static void setupExecuteAlgorithmResponseDeserializer(ObjectDeserializer<ExecuteAlgorithmResponse.Builder> op) {
        op.add(Builder::result, JsonpDeserializer.numberDeserializer(), "result");
        op.add(Builder::results, JsonpDeserializer.arrayDeserializer(ExecuteAnomalyLocalizationResponse._DESERIALIZER), "results");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.result);
        result = 31 * result + Objects.hashCode(this.results);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExecuteAlgorithmResponse other = (ExecuteAlgorithmResponse) o;
        return Objects.equals(this.result, other.result) && Objects.equals(this.results, other.results);
    }
}
