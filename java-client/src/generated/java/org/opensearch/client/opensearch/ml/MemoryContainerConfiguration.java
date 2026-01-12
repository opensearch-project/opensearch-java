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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: ml.MemoryContainerConfiguration

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MemoryContainerConfiguration
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<MemoryContainerConfiguration.Builder, MemoryContainerConfiguration> {

    @Nullable
    private final Boolean disableHistory;

    @Nullable
    private final Boolean disableSession;

    @Nullable
    private final Long embeddingDimension;

    @Nullable
    private final String embeddingModelId;

    @Nullable
    private final String embeddingModelType;

    @Nullable
    private final String indexPrefix;

    @Nullable
    private final IndexSettings indexSettings;

    @Nullable
    private final String llmId;

    @Nullable
    private final Long maxInferSize;

    @Nonnull
    private final Map<String, JsonData> parameters;

    @Nonnull
    private final List<Strategy> strategies;

    @Nullable
    private final Boolean useSystemIndex;

    // ---------------------------------------------------------------------------------------------

    private MemoryContainerConfiguration(Builder builder) {
        this.disableHistory = builder.disableHistory;
        this.disableSession = builder.disableSession;
        this.embeddingDimension = builder.embeddingDimension;
        this.embeddingModelId = builder.embeddingModelId;
        this.embeddingModelType = builder.embeddingModelType;
        this.indexPrefix = builder.indexPrefix;
        this.indexSettings = builder.indexSettings;
        this.llmId = builder.llmId;
        this.maxInferSize = builder.maxInferSize;
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.strategies = ApiTypeHelper.unmodifiable(builder.strategies);
        this.useSystemIndex = builder.useSystemIndex;
    }

    public static MemoryContainerConfiguration of(
        Function<MemoryContainerConfiguration.Builder, ObjectBuilder<MemoryContainerConfiguration>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether history will be persisted.
     * <p>
     * API name: {@code disable_history}
     * </p>
     */
    @Nullable
    public final Boolean disableHistory() {
        return this.disableHistory;
    }

    /**
     * Whether session will be persisted.
     * <p>
     * API name: {@code disable_session}
     * </p>
     */
    @Nullable
    public final Boolean disableSession() {
        return this.disableSession;
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
     * The embedding model ID.
     * <p>
     * API name: {@code embedding_model_id}
     * </p>
     */
    @Nullable
    public final String embeddingModelId() {
        return this.embeddingModelId;
    }

    /**
     * The embedding model type.
     * <p>
     * API name: {@code embedding_model_type}
     * </p>
     */
    @Nullable
    public final String embeddingModelType() {
        return this.embeddingModelType;
    }

    /**
     * Custom prefix for memory indices.
     * <p>
     * API name: {@code index_prefix}
     * </p>
     */
    @Nullable
    public final String indexPrefix() {
        return this.indexPrefix;
    }

    /**
     * API name: {@code index_settings}
     */
    @Nullable
    public final IndexSettings indexSettings() {
        return this.indexSettings;
    }

    /**
     * The LLM ID.
     * <p>
     * API name: {@code llm_id}
     * </p>
     */
    @Nullable
    public final String llmId() {
        return this.llmId;
    }

    /**
     * The maximum number of similar memories retrieved during consolidation.
     * <p>
     * API name: {@code max_infer_size}
     * </p>
     */
    @Nullable
    public final Long maxInferSize() {
        return this.maxInferSize;
    }

    /**
     * API name: {@code parameters}
     */
    @Nonnull
    public final Map<String, JsonData> parameters() {
        return this.parameters;
    }

    /**
     * API name: {@code strategies}
     */
    @Nonnull
    public final List<Strategy> strategies() {
        return this.strategies;
    }

    /**
     * Whether to use system indices.
     * <p>
     * API name: {@code use_system_index}
     * </p>
     */
    @Nullable
    public final Boolean useSystemIndex() {
        return this.useSystemIndex;
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
        if (this.disableHistory != null) {
            generator.writeKey("disable_history");
            generator.write(this.disableHistory);
        }

        if (this.disableSession != null) {
            generator.writeKey("disable_session");
            generator.write(this.disableSession);
        }

        if (this.embeddingDimension != null) {
            generator.writeKey("embedding_dimension");
            generator.write(this.embeddingDimension);
        }

        if (this.embeddingModelId != null) {
            generator.writeKey("embedding_model_id");
            generator.write(this.embeddingModelId);
        }

        if (this.embeddingModelType != null) {
            generator.writeKey("embedding_model_type");
            generator.write(this.embeddingModelType);
        }

        if (this.indexPrefix != null) {
            generator.writeKey("index_prefix");
            generator.write(this.indexPrefix);
        }

        if (this.indexSettings != null) {
            generator.writeKey("index_settings");
            this.indexSettings.serialize(generator, mapper);
        }

        if (this.llmId != null) {
            generator.writeKey("llm_id");
            generator.write(this.llmId);
        }

        if (this.maxInferSize != null) {
            generator.writeKey("max_infer_size");
            generator.write(this.maxInferSize);
        }

        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.strategies)) {
            generator.writeKey("strategies");
            generator.writeStartArray();
            for (Strategy item0 : this.strategies) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.useSystemIndex != null) {
            generator.writeKey("use_system_index");
            generator.write(this.useSystemIndex);
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
     * Builder for {@link MemoryContainerConfiguration}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MemoryContainerConfiguration> {
        @Nullable
        private Boolean disableHistory;
        @Nullable
        private Boolean disableSession;
        @Nullable
        private Long embeddingDimension;
        @Nullable
        private String embeddingModelId;
        @Nullable
        private String embeddingModelType;
        @Nullable
        private String indexPrefix;
        @Nullable
        private IndexSettings indexSettings;
        @Nullable
        private String llmId;
        @Nullable
        private Long maxInferSize;
        @Nullable
        private Map<String, JsonData> parameters;
        @Nullable
        private List<Strategy> strategies;
        @Nullable
        private Boolean useSystemIndex;

        public Builder() {}

        private Builder(MemoryContainerConfiguration o) {
            this.disableHistory = o.disableHistory;
            this.disableSession = o.disableSession;
            this.embeddingDimension = o.embeddingDimension;
            this.embeddingModelId = o.embeddingModelId;
            this.embeddingModelType = o.embeddingModelType;
            this.indexPrefix = o.indexPrefix;
            this.indexSettings = o.indexSettings;
            this.llmId = o.llmId;
            this.maxInferSize = o.maxInferSize;
            this.parameters = _mapCopy(o.parameters);
            this.strategies = _listCopy(o.strategies);
            this.useSystemIndex = o.useSystemIndex;
        }

        private Builder(Builder o) {
            this.disableHistory = o.disableHistory;
            this.disableSession = o.disableSession;
            this.embeddingDimension = o.embeddingDimension;
            this.embeddingModelId = o.embeddingModelId;
            this.embeddingModelType = o.embeddingModelType;
            this.indexPrefix = o.indexPrefix;
            this.indexSettings = o.indexSettings;
            this.llmId = o.llmId;
            this.maxInferSize = o.maxInferSize;
            this.parameters = _mapCopy(o.parameters);
            this.strategies = _listCopy(o.strategies);
            this.useSystemIndex = o.useSystemIndex;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether history will be persisted.
         * <p>
         * API name: {@code disable_history}
         * </p>
         */
        @Nonnull
        public final Builder disableHistory(@Nullable Boolean value) {
            this.disableHistory = value;
            return this;
        }

        /**
         * Whether session will be persisted.
         * <p>
         * API name: {@code disable_session}
         * </p>
         */
        @Nonnull
        public final Builder disableSession(@Nullable Boolean value) {
            this.disableSession = value;
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
         * The embedding model ID.
         * <p>
         * API name: {@code embedding_model_id}
         * </p>
         */
        @Nonnull
        public final Builder embeddingModelId(@Nullable String value) {
            this.embeddingModelId = value;
            return this;
        }

        /**
         * The embedding model type.
         * <p>
         * API name: {@code embedding_model_type}
         * </p>
         */
        @Nonnull
        public final Builder embeddingModelType(@Nullable String value) {
            this.embeddingModelType = value;
            return this;
        }

        /**
         * Custom prefix for memory indices.
         * <p>
         * API name: {@code index_prefix}
         * </p>
         */
        @Nonnull
        public final Builder indexPrefix(@Nullable String value) {
            this.indexPrefix = value;
            return this;
        }

        /**
         * API name: {@code index_settings}
         */
        @Nonnull
        public final Builder indexSettings(@Nullable IndexSettings value) {
            this.indexSettings = value;
            return this;
        }

        /**
         * API name: {@code index_settings}
         */
        @Nonnull
        public final Builder indexSettings(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
            return indexSettings(fn.apply(new IndexSettings.Builder()).build());
        }

        /**
         * The LLM ID.
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
         * The maximum number of similar memories retrieved during consolidation.
         * <p>
         * API name: {@code max_infer_size}
         * </p>
         */
        @Nonnull
        public final Builder maxInferSize(@Nullable Long value) {
            this.maxInferSize = value;
            return this;
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(Map<String, JsonData> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * API name: {@code parameters}
         *
         * <p>
         * Adds an entry to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(String key, JsonData value) {
            this.parameters = _mapPut(this.parameters, key, value);
            return this;
        }

        /**
         * API name: {@code strategies}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>strategies</code>.
         * </p>
         */
        @Nonnull
        public final Builder strategies(List<Strategy> list) {
            this.strategies = _listAddAll(this.strategies, list);
            return this;
        }

        /**
         * API name: {@code strategies}
         *
         * <p>
         * Adds one or more values to <code>strategies</code>.
         * </p>
         */
        @Nonnull
        public final Builder strategies(Strategy value, Strategy... values) {
            this.strategies = _listAdd(this.strategies, value, values);
            return this;
        }

        /**
         * API name: {@code strategies}
         *
         * <p>
         * Adds a value to <code>strategies</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder strategies(Function<Strategy.Builder, ObjectBuilder<Strategy>> fn) {
            return strategies(fn.apply(new Strategy.Builder()).build());
        }

        /**
         * Whether to use system indices.
         * <p>
         * API name: {@code use_system_index}
         * </p>
         */
        @Nonnull
        public final Builder useSystemIndex(@Nullable Boolean value) {
            this.useSystemIndex = value;
            return this;
        }

        /**
         * Builds a {@link MemoryContainerConfiguration}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MemoryContainerConfiguration build() {
            _checkSingleUse();

            return new MemoryContainerConfiguration(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MemoryContainerConfiguration}
     */
    public static final JsonpDeserializer<MemoryContainerConfiguration> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MemoryContainerConfiguration::setupMemoryContainerConfigurationDeserializer
    );

    protected static void setupMemoryContainerConfigurationDeserializer(ObjectDeserializer<MemoryContainerConfiguration.Builder> op) {
        op.add(Builder::disableHistory, JsonpDeserializer.booleanDeserializer(), "disable_history");
        op.add(Builder::disableSession, JsonpDeserializer.booleanDeserializer(), "disable_session");
        op.add(Builder::embeddingDimension, JsonpDeserializer.longDeserializer(), "embedding_dimension");
        op.add(Builder::embeddingModelId, JsonpDeserializer.stringDeserializer(), "embedding_model_id");
        op.add(Builder::embeddingModelType, JsonpDeserializer.stringDeserializer(), "embedding_model_type");
        op.add(Builder::indexPrefix, JsonpDeserializer.stringDeserializer(), "index_prefix");
        op.add(Builder::indexSettings, IndexSettings._DESERIALIZER, "index_settings");
        op.add(Builder::llmId, JsonpDeserializer.stringDeserializer(), "llm_id");
        op.add(Builder::maxInferSize, JsonpDeserializer.longDeserializer(), "max_infer_size");
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
        op.add(Builder::strategies, JsonpDeserializer.arrayDeserializer(Strategy._DESERIALIZER), "strategies");
        op.add(Builder::useSystemIndex, JsonpDeserializer.booleanDeserializer(), "use_system_index");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.disableHistory);
        result = 31 * result + Objects.hashCode(this.disableSession);
        result = 31 * result + Objects.hashCode(this.embeddingDimension);
        result = 31 * result + Objects.hashCode(this.embeddingModelId);
        result = 31 * result + Objects.hashCode(this.embeddingModelType);
        result = 31 * result + Objects.hashCode(this.indexPrefix);
        result = 31 * result + Objects.hashCode(this.indexSettings);
        result = 31 * result + Objects.hashCode(this.llmId);
        result = 31 * result + Objects.hashCode(this.maxInferSize);
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + Objects.hashCode(this.strategies);
        result = 31 * result + Objects.hashCode(this.useSystemIndex);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MemoryContainerConfiguration other = (MemoryContainerConfiguration) o;
        return Objects.equals(this.disableHistory, other.disableHistory)
            && Objects.equals(this.disableSession, other.disableSession)
            && Objects.equals(this.embeddingDimension, other.embeddingDimension)
            && Objects.equals(this.embeddingModelId, other.embeddingModelId)
            && Objects.equals(this.embeddingModelType, other.embeddingModelType)
            && Objects.equals(this.indexPrefix, other.indexPrefix)
            && Objects.equals(this.indexSettings, other.indexSettings)
            && Objects.equals(this.llmId, other.llmId)
            && Objects.equals(this.maxInferSize, other.maxInferSize)
            && Objects.equals(this.parameters, other.parameters)
            && Objects.equals(this.strategies, other.strategies)
            && Objects.equals(this.useSystemIndex, other.useSystemIndex);
    }
}
