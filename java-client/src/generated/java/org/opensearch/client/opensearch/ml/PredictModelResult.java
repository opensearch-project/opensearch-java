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

// typedef: ml.PredictModelResult

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PredictModelResult implements PlainJsonSerializable, ToCopyableBuilder<PredictModelResult.Builder, PredictModelResult> {

    @Nonnull
    private final List<PredictModelOutput> output;

    // ---------------------------------------------------------------------------------------------

    private PredictModelResult(Builder builder) {
        this.output = ApiTypeHelper.unmodifiable(builder.output);
    }

    public static PredictModelResult of(Function<PredictModelResult.Builder, ObjectBuilder<PredictModelResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code output}
     */
    @Nonnull
    public final List<PredictModelOutput> output() {
        return this.output;
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
        if (ApiTypeHelper.isDefined(this.output)) {
            generator.writeKey("output");
            generator.writeStartArray();
            for (PredictModelOutput item0 : this.output) {
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
     * Builder for {@link PredictModelResult}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PredictModelResult> {
        @Nullable
        private List<PredictModelOutput> output;

        public Builder() {}

        private Builder(PredictModelResult o) {
            this.output = _listCopy(o.output);
        }

        private Builder(Builder o) {
            this.output = _listCopy(o.output);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code output}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>output</code>.
         * </p>
         */
        @Nonnull
        public final Builder output(List<PredictModelOutput> list) {
            this.output = _listAddAll(this.output, list);
            return this;
        }

        /**
         * API name: {@code output}
         *
         * <p>
         * Adds one or more values to <code>output</code>.
         * </p>
         */
        @Nonnull
        public final Builder output(PredictModelOutput value, PredictModelOutput... values) {
            this.output = _listAdd(this.output, value, values);
            return this;
        }

        /**
         * API name: {@code output}
         *
         * <p>
         * Adds a value to <code>output</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder output(Function<PredictModelOutput.Builder, ObjectBuilder<PredictModelOutput>> fn) {
            return output(fn.apply(new PredictModelOutput.Builder()).build());
        }

        /**
         * Builds a {@link PredictModelResult}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PredictModelResult build() {
            _checkSingleUse();

            return new PredictModelResult(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PredictModelResult}
     */
    public static final JsonpDeserializer<PredictModelResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PredictModelResult::setupPredictModelResultDeserializer
    );

    protected static void setupPredictModelResultDeserializer(ObjectDeserializer<PredictModelResult.Builder> op) {
        op.add(Builder::output, JsonpDeserializer.arrayDeserializer(PredictModelOutput._DESERIALIZER), "output");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.output);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictModelResult other = (PredictModelResult) o;
        return Objects.equals(this.output, other.output);
    }
}
