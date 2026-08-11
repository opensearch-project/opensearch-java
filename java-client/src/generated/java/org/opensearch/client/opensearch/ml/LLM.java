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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.LLM

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class LLM implements PlainJsonSerializable, ToCopyableBuilder<LLM.Builder, LLM> {

    @Nullable
    private final String modelId;

    @Nullable
    private final Parameters parameters;

    // ---------------------------------------------------------------------------------------------

    private LLM(Builder builder) {
        this.modelId = builder.modelId;
        this.parameters = builder.parameters;
    }

    public static LLM of(Function<LLM.Builder, ObjectBuilder<LLM>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code model_id}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code parameters}
     */
    @Nullable
    public final Parameters parameters() {
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
        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        if (this.parameters != null) {
            generator.writeKey("parameters");
            this.parameters.serialize(generator, mapper);
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
     * Builder for {@link LLM}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, LLM> {
        @Nullable
        private String modelId;
        @Nullable
        private Parameters parameters;

        public Builder() {}

        private Builder(LLM o) {
            this.modelId = o.modelId;
            this.parameters = o.parameters;
        }

        private Builder(Builder o) {
            this.modelId = o.modelId;
            this.parameters = o.parameters;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(@Nullable Parameters value) {
            this.parameters = value;
            return this;
        }

        /**
         * API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(Function<Parameters.Builder, ObjectBuilder<Parameters>> fn) {
            return parameters(fn.apply(new Parameters.Builder()).build());
        }

        /**
         * Builds a {@link LLM}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LLM build() {
            _checkSingleUse();

            return new LLM(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LLM}
     */
    public static final JsonpDeserializer<LLM> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, LLM::setupLLMDeserializer);

    protected static void setupLLMDeserializer(ObjectDeserializer<LLM.Builder> op) {
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::parameters, Parameters._DESERIALIZER, "parameters");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.parameters);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LLM other = (LLM) o;
        return Objects.equals(this.modelId, other.modelId) && Objects.equals(this.parameters, other.parameters);
    }
}
