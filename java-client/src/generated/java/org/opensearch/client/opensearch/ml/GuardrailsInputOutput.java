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

// typedef: ml.GuardrailsInputOutput

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GuardrailsInputOutput
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GuardrailsInputOutput.Builder, GuardrailsInputOutput> {

    @Nullable
    private final String modelId;

    @Nullable
    private final String responseValidationRegex;

    // ---------------------------------------------------------------------------------------------

    private GuardrailsInputOutput(Builder builder) {
        this.modelId = builder.modelId;
        this.responseValidationRegex = builder.responseValidationRegex;
    }

    public static GuardrailsInputOutput of(Function<GuardrailsInputOutput.Builder, ObjectBuilder<GuardrailsInputOutput>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The model ID.
     * <p>
     * API name: {@code model_id}
     * </p>
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * The response validation regex.
     * <p>
     * API name: {@code response_validation_regex}
     * </p>
     */
    @Nullable
    public final String responseValidationRegex() {
        return this.responseValidationRegex;
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

        if (this.responseValidationRegex != null) {
            generator.writeKey("response_validation_regex");
            generator.write(this.responseValidationRegex);
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
     * Builder for {@link GuardrailsInputOutput}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GuardrailsInputOutput> {
        @Nullable
        private String modelId;
        @Nullable
        private String responseValidationRegex;

        public Builder() {}

        private Builder(GuardrailsInputOutput o) {
            this.modelId = o.modelId;
            this.responseValidationRegex = o.responseValidationRegex;
        }

        private Builder(Builder o) {
            this.modelId = o.modelId;
            this.responseValidationRegex = o.responseValidationRegex;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The model ID.
         * <p>
         * API name: {@code model_id}
         * </p>
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * The response validation regex.
         * <p>
         * API name: {@code response_validation_regex}
         * </p>
         */
        @Nonnull
        public final Builder responseValidationRegex(@Nullable String value) {
            this.responseValidationRegex = value;
            return this;
        }

        /**
         * Builds a {@link GuardrailsInputOutput}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GuardrailsInputOutput build() {
            _checkSingleUse();

            return new GuardrailsInputOutput(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GuardrailsInputOutput}
     */
    public static final JsonpDeserializer<GuardrailsInputOutput> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GuardrailsInputOutput::setupGuardrailsInputOutputDeserializer
    );

    protected static void setupGuardrailsInputOutputDeserializer(ObjectDeserializer<GuardrailsInputOutput.Builder> op) {
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::responseValidationRegex, JsonpDeserializer.stringDeserializer(), "response_validation_regex");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.responseValidationRegex);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GuardrailsInputOutput other = (GuardrailsInputOutput) o;
        return Objects.equals(this.modelId, other.modelId) && Objects.equals(this.responseValidationRegex, other.responseValidationRegex);
    }
}
