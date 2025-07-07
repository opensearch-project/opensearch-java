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

// typedef: ml.ModelConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ModelConfig implements PlainJsonSerializable, ToCopyableBuilder<ModelConfig.Builder, ModelConfig> {

    @Nullable
    private final AdditionalConfig additionalConfig;

    @Nullable
    private final String allConfig;

    @Nullable
    private final Long embeddingDimension;

    @Nullable
    private final String frameworkType;

    @Nullable
    private final String modelType;

    // ---------------------------------------------------------------------------------------------

    private ModelConfig(Builder builder) {
        this.additionalConfig = builder.additionalConfig;
        this.allConfig = builder.allConfig;
        this.embeddingDimension = builder.embeddingDimension;
        this.frameworkType = builder.frameworkType;
        this.modelType = builder.modelType;
    }

    public static ModelConfig of(Function<ModelConfig.Builder, ObjectBuilder<ModelConfig>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code additional_config}
     */
    @Nullable
    public final AdditionalConfig additionalConfig() {
        return this.additionalConfig;
    }

    /**
     * The all config.
     * <p>
     * API name: {@code all_config}
     * </p>
     */
    @Nullable
    public final String allConfig() {
        return this.allConfig;
    }

    /**
     * The embedding dimension.
     * <p>
     * API name: {@code embedding_dimension}
     * </p>
     */
    @Nullable
    public final Long embeddingDimension() {
        return this.embeddingDimension;
    }

    /**
     * The framework type.
     * <p>
     * API name: {@code framework_type}
     * </p>
     */
    @Nullable
    public final String frameworkType() {
        return this.frameworkType;
    }

    /**
     * The model type.
     * <p>
     * API name: {@code model_type}
     * </p>
     */
    @Nullable
    public final String modelType() {
        return this.modelType;
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
        if (this.additionalConfig != null) {
            generator.writeKey("additional_config");
            this.additionalConfig.serialize(generator, mapper);
        }

        if (this.allConfig != null) {
            generator.writeKey("all_config");
            generator.write(this.allConfig);
        }

        if (this.embeddingDimension != null) {
            generator.writeKey("embedding_dimension");
            generator.write(this.embeddingDimension);
        }

        if (this.frameworkType != null) {
            generator.writeKey("framework_type");
            generator.write(this.frameworkType);
        }

        if (this.modelType != null) {
            generator.writeKey("model_type");
            generator.write(this.modelType);
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
     * Builder for {@link ModelConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ModelConfig> {
        @Nullable
        private AdditionalConfig additionalConfig;
        @Nullable
        private String allConfig;
        @Nullable
        private Long embeddingDimension;
        @Nullable
        private String frameworkType;
        @Nullable
        private String modelType;

        public Builder() {}

        private Builder(ModelConfig o) {
            this.additionalConfig = o.additionalConfig;
            this.allConfig = o.allConfig;
            this.embeddingDimension = o.embeddingDimension;
            this.frameworkType = o.frameworkType;
            this.modelType = o.modelType;
        }

        private Builder(Builder o) {
            this.additionalConfig = o.additionalConfig;
            this.allConfig = o.allConfig;
            this.embeddingDimension = o.embeddingDimension;
            this.frameworkType = o.frameworkType;
            this.modelType = o.modelType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code additional_config}
         */
        @Nonnull
        public final Builder additionalConfig(@Nullable AdditionalConfig value) {
            this.additionalConfig = value;
            return this;
        }

        /**
         * API name: {@code additional_config}
         */
        @Nonnull
        public final Builder additionalConfig(Function<AdditionalConfig.Builder, ObjectBuilder<AdditionalConfig>> fn) {
            return additionalConfig(fn.apply(new AdditionalConfig.Builder()).build());
        }

        /**
         * The all config.
         * <p>
         * API name: {@code all_config}
         * </p>
         */
        @Nonnull
        public final Builder allConfig(@Nullable String value) {
            this.allConfig = value;
            return this;
        }

        /**
         * The embedding dimension.
         * <p>
         * API name: {@code embedding_dimension}
         * </p>
         */
        @Nonnull
        public final Builder embeddingDimension(@Nullable Long value) {
            this.embeddingDimension = value;
            return this;
        }

        /**
         * The framework type.
         * <p>
         * API name: {@code framework_type}
         * </p>
         */
        @Nonnull
        public final Builder frameworkType(@Nullable String value) {
            this.frameworkType = value;
            return this;
        }

        /**
         * The model type.
         * <p>
         * API name: {@code model_type}
         * </p>
         */
        @Nonnull
        public final Builder modelType(@Nullable String value) {
            this.modelType = value;
            return this;
        }

        /**
         * Builds a {@link ModelConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ModelConfig build() {
            _checkSingleUse();

            return new ModelConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ModelConfig}
     */
    public static final JsonpDeserializer<ModelConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ModelConfig::setupModelConfigDeserializer
    );

    protected static void setupModelConfigDeserializer(ObjectDeserializer<ModelConfig.Builder> op) {
        op.add(Builder::additionalConfig, AdditionalConfig._DESERIALIZER, "additional_config");
        op.add(Builder::allConfig, JsonpDeserializer.stringDeserializer(), "all_config");
        op.add(Builder::embeddingDimension, JsonpDeserializer.longDeserializer(), "embedding_dimension");
        op.add(Builder::frameworkType, JsonpDeserializer.stringDeserializer(), "framework_type");
        op.add(Builder::modelType, JsonpDeserializer.stringDeserializer(), "model_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.additionalConfig);
        result = 31 * result + Objects.hashCode(this.allConfig);
        result = 31 * result + Objects.hashCode(this.embeddingDimension);
        result = 31 * result + Objects.hashCode(this.frameworkType);
        result = 31 * result + Objects.hashCode(this.modelType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ModelConfig other = (ModelConfig) o;
        return Objects.equals(this.additionalConfig, other.additionalConfig)
            && Objects.equals(this.allConfig, other.allConfig)
            && Objects.equals(this.embeddingDimension, other.embeddingDimension)
            && Objects.equals(this.frameworkType, other.frameworkType)
            && Objects.equals(this.modelType, other.modelType);
    }
}
