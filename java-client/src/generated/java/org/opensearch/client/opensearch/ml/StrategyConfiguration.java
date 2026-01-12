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

// typedef: ml.StrategyConfiguration

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StrategyConfiguration
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<StrategyConfiguration.Builder, StrategyConfiguration> {

    @Nullable
    private final String llmId;

    @Nullable
    private final String llmResultPath;

    @Nullable
    private final String systemPrompt;

    // ---------------------------------------------------------------------------------------------

    private StrategyConfiguration(Builder builder) {
        this.llmId = builder.llmId;
        this.llmResultPath = builder.llmResultPath;
        this.systemPrompt = builder.systemPrompt;
    }

    public static StrategyConfiguration of(Function<StrategyConfiguration.Builder, ObjectBuilder<StrategyConfiguration>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The LLM ID for strategy.
     * <p>
     * API name: {@code llm_id}
     * </p>
     */
    @Nullable
    public final String llmId() {
        return this.llmId;
    }

    /**
     * JSONPath expression for extracting LLM results from responses.
     * <p>
     * API name: {@code llm_result_path}
     * </p>
     */
    @Nullable
    public final String llmResultPath() {
        return this.llmResultPath;
    }

    /**
     * Custom system prompt to override default strategy prompt.
     * <p>
     * API name: {@code system_prompt}
     * </p>
     */
    @Nullable
    public final String systemPrompt() {
        return this.systemPrompt;
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
        if (this.llmId != null) {
            generator.writeKey("llm_id");
            generator.write(this.llmId);
        }

        if (this.llmResultPath != null) {
            generator.writeKey("llm_result_path");
            generator.write(this.llmResultPath);
        }

        if (this.systemPrompt != null) {
            generator.writeKey("system_prompt");
            generator.write(this.systemPrompt);
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
     * Builder for {@link StrategyConfiguration}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StrategyConfiguration> {
        @Nullable
        private String llmId;
        @Nullable
        private String llmResultPath;
        @Nullable
        private String systemPrompt;

        public Builder() {}

        private Builder(StrategyConfiguration o) {
            this.llmId = o.llmId;
            this.llmResultPath = o.llmResultPath;
            this.systemPrompt = o.systemPrompt;
        }

        private Builder(Builder o) {
            this.llmId = o.llmId;
            this.llmResultPath = o.llmResultPath;
            this.systemPrompt = o.systemPrompt;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The LLM ID for strategy.
         * <p>
         * API name: {@code llm_id}
         * </p>
         */
        @Nonnull
        public final Builder llmId(@Nullable String value) {
            this.llmId = value;
            return this;
        }

        /**
         * JSONPath expression for extracting LLM results from responses.
         * <p>
         * API name: {@code llm_result_path}
         * </p>
         */
        @Nonnull
        public final Builder llmResultPath(@Nullable String value) {
            this.llmResultPath = value;
            return this;
        }

        /**
         * Custom system prompt to override default strategy prompt.
         * <p>
         * API name: {@code system_prompt}
         * </p>
         */
        @Nonnull
        public final Builder systemPrompt(@Nullable String value) {
            this.systemPrompt = value;
            return this;
        }

        /**
         * Builds a {@link StrategyConfiguration}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StrategyConfiguration build() {
            _checkSingleUse();

            return new StrategyConfiguration(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link StrategyConfiguration}
     */
    public static final JsonpDeserializer<StrategyConfiguration> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        StrategyConfiguration::setupStrategyConfigurationDeserializer
    );

    protected static void setupStrategyConfigurationDeserializer(ObjectDeserializer<StrategyConfiguration.Builder> op) {
        op.add(Builder::llmId, JsonpDeserializer.stringDeserializer(), "llm_id");
        op.add(Builder::llmResultPath, JsonpDeserializer.stringDeserializer(), "llm_result_path");
        op.add(Builder::systemPrompt, JsonpDeserializer.stringDeserializer(), "system_prompt");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.llmId);
        result = 31 * result + Objects.hashCode(this.llmResultPath);
        result = 31 * result + Objects.hashCode(this.systemPrompt);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StrategyConfiguration other = (StrategyConfiguration) o;
        return Objects.equals(this.llmId, other.llmId)
            && Objects.equals(this.llmResultPath, other.llmResultPath)
            && Objects.equals(this.systemPrompt, other.systemPrompt);
    }
}
