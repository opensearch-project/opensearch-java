/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types.mapping;

import jakarta.json.stream.JsonGenerator;
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

// typedef: _types.mapping.SemanticProperty

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SemanticProperty
    implements
        PropertyVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<SemanticProperty.Builder, SemanticProperty> {

    @Nullable
    private final JsonData chunking;

    @Nullable
    private final SemanticDenseEmbeddingConfig denseEmbeddingConfig;

    @Nonnull
    private final String modelId;

    @Nullable
    private final String rawFieldType;

    @Nullable
    private final String searchModelId;

    @Nullable
    private final String semanticFieldSearchAnalyzer;

    @Nullable
    private final String semanticInfoFieldName;

    @Nullable
    private final Boolean skipExistingEmbedding;

    @Nullable
    private final SemanticSparseEncodingConfig sparseEncodingConfig;

    // ---------------------------------------------------------------------------------------------

    private SemanticProperty(Builder builder) {
        this.chunking = builder.chunking;
        this.denseEmbeddingConfig = builder.denseEmbeddingConfig;
        this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
        this.rawFieldType = builder.rawFieldType;
        this.searchModelId = builder.searchModelId;
        this.semanticFieldSearchAnalyzer = builder.semanticFieldSearchAnalyzer;
        this.semanticInfoFieldName = builder.semanticInfoFieldName;
        this.skipExistingEmbedding = builder.skipExistingEmbedding;
        this.sparseEncodingConfig = builder.sparseEncodingConfig;
    }

    public static SemanticProperty of(Function<SemanticProperty.Builder, ObjectBuilder<SemanticProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.Semantic;
    }

    /**
     * API name: {@code chunking}
     */
    @Nullable
    public final JsonData chunking() {
        return this.chunking;
    }

    /**
     * API name: {@code dense_embedding_config}
     */
    @Nullable
    public final SemanticDenseEmbeddingConfig denseEmbeddingConfig() {
        return this.denseEmbeddingConfig;
    }

    /**
     * Required - API name: {@code model_id}
     */
    @Nonnull
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code raw_field_type}
     */
    @Nullable
    public final String rawFieldType() {
        return this.rawFieldType;
    }

    /**
     * API name: {@code search_model_id}
     */
    @Nullable
    public final String searchModelId() {
        return this.searchModelId;
    }

    /**
     * API name: {@code semantic_field_search_analyzer}
     */
    @Nullable
    public final String semanticFieldSearchAnalyzer() {
        return this.semanticFieldSearchAnalyzer;
    }

    /**
     * API name: {@code semantic_info_field_name}
     */
    @Nullable
    public final String semanticInfoFieldName() {
        return this.semanticInfoFieldName;
    }

    /**
     * API name: {@code skip_existing_embedding}
     */
    @Nullable
    public final Boolean skipExistingEmbedding() {
        return this.skipExistingEmbedding;
    }

    /**
     * API name: {@code sparse_encoding_config}
     */
    @Nullable
    public final SemanticSparseEncodingConfig sparseEncodingConfig() {
        return this.sparseEncodingConfig;
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
        generator.write("type", "semantic");
        if (this.chunking != null) {
            generator.writeKey("chunking");
            this.chunking.serialize(generator, mapper);
        }

        if (this.denseEmbeddingConfig != null) {
            generator.writeKey("dense_embedding_config");
            this.denseEmbeddingConfig.serialize(generator, mapper);
        }

        generator.writeKey("model_id");
        generator.write(this.modelId);

        if (this.rawFieldType != null) {
            generator.writeKey("raw_field_type");
            generator.write(this.rawFieldType);
        }

        if (this.searchModelId != null) {
            generator.writeKey("search_model_id");
            generator.write(this.searchModelId);
        }

        if (this.semanticFieldSearchAnalyzer != null) {
            generator.writeKey("semantic_field_search_analyzer");
            generator.write(this.semanticFieldSearchAnalyzer);
        }

        if (this.semanticInfoFieldName != null) {
            generator.writeKey("semantic_info_field_name");
            generator.write(this.semanticInfoFieldName);
        }

        if (this.skipExistingEmbedding != null) {
            generator.writeKey("skip_existing_embedding");
            generator.write(this.skipExistingEmbedding);
        }

        if (this.sparseEncodingConfig != null) {
            generator.writeKey("sparse_encoding_config");
            this.sparseEncodingConfig.serialize(generator, mapper);
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
     * Builder for {@link SemanticProperty}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SemanticProperty> {
        @Nullable
        private JsonData chunking;
        @Nullable
        private SemanticDenseEmbeddingConfig denseEmbeddingConfig;
        private String modelId;
        @Nullable
        private String rawFieldType;
        @Nullable
        private String searchModelId;
        @Nullable
        private String semanticFieldSearchAnalyzer;
        @Nullable
        private String semanticInfoFieldName;
        @Nullable
        private Boolean skipExistingEmbedding;
        @Nullable
        private SemanticSparseEncodingConfig sparseEncodingConfig;

        public Builder() {}

        private Builder(SemanticProperty o) {
            this.chunking = o.chunking;
            this.denseEmbeddingConfig = o.denseEmbeddingConfig;
            this.modelId = o.modelId;
            this.rawFieldType = o.rawFieldType;
            this.searchModelId = o.searchModelId;
            this.semanticFieldSearchAnalyzer = o.semanticFieldSearchAnalyzer;
            this.semanticInfoFieldName = o.semanticInfoFieldName;
            this.skipExistingEmbedding = o.skipExistingEmbedding;
            this.sparseEncodingConfig = o.sparseEncodingConfig;
        }

        private Builder(Builder o) {
            this.chunking = o.chunking;
            this.denseEmbeddingConfig = o.denseEmbeddingConfig;
            this.modelId = o.modelId;
            this.rawFieldType = o.rawFieldType;
            this.searchModelId = o.searchModelId;
            this.semanticFieldSearchAnalyzer = o.semanticFieldSearchAnalyzer;
            this.semanticInfoFieldName = o.semanticInfoFieldName;
            this.skipExistingEmbedding = o.skipExistingEmbedding;
            this.sparseEncodingConfig = o.sparseEncodingConfig;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code chunking}
         */
        @Nonnull
        public final Builder chunking(@Nullable JsonData value) {
            this.chunking = value;
            return this;
        }

        /**
         * API name: {@code dense_embedding_config}
         */
        @Nonnull
        public final Builder denseEmbeddingConfig(@Nullable SemanticDenseEmbeddingConfig value) {
            this.denseEmbeddingConfig = value;
            return this;
        }

        /**
         * API name: {@code dense_embedding_config}
         */
        @Nonnull
        public final Builder denseEmbeddingConfig(
            Function<SemanticDenseEmbeddingConfig.Builder, ObjectBuilder<SemanticDenseEmbeddingConfig>> fn
        ) {
            return denseEmbeddingConfig(fn.apply(new SemanticDenseEmbeddingConfig.Builder()).build());
        }

        /**
         * Required - API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code raw_field_type}
         */
        @Nonnull
        public final Builder rawFieldType(@Nullable String value) {
            this.rawFieldType = value;
            return this;
        }

        /**
         * API name: {@code search_model_id}
         */
        @Nonnull
        public final Builder searchModelId(@Nullable String value) {
            this.searchModelId = value;
            return this;
        }

        /**
         * API name: {@code semantic_field_search_analyzer}
         */
        @Nonnull
        public final Builder semanticFieldSearchAnalyzer(@Nullable String value) {
            this.semanticFieldSearchAnalyzer = value;
            return this;
        }

        /**
         * API name: {@code semantic_info_field_name}
         */
        @Nonnull
        public final Builder semanticInfoFieldName(@Nullable String value) {
            this.semanticInfoFieldName = value;
            return this;
        }

        /**
         * API name: {@code skip_existing_embedding}
         */
        @Nonnull
        public final Builder skipExistingEmbedding(@Nullable Boolean value) {
            this.skipExistingEmbedding = value;
            return this;
        }

        /**
         * API name: {@code sparse_encoding_config}
         */
        @Nonnull
        public final Builder sparseEncodingConfig(@Nullable SemanticSparseEncodingConfig value) {
            this.sparseEncodingConfig = value;
            return this;
        }

        /**
         * API name: {@code sparse_encoding_config}
         */
        @Nonnull
        public final Builder sparseEncodingConfig(
            Function<SemanticSparseEncodingConfig.Builder, ObjectBuilder<SemanticSparseEncodingConfig>> fn
        ) {
            return sparseEncodingConfig(fn.apply(new SemanticSparseEncodingConfig.Builder()).build());
        }

        /**
         * Builds a {@link SemanticProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SemanticProperty build() {
            _checkSingleUse();

            return new SemanticProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SemanticProperty}
     */
    public static final JsonpDeserializer<SemanticProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SemanticProperty::setupSemanticPropertyDeserializer
    );

    protected static void setupSemanticPropertyDeserializer(ObjectDeserializer<SemanticProperty.Builder> op) {
        op.add(Builder::chunking, JsonData._DESERIALIZER, "chunking");
        op.add(Builder::denseEmbeddingConfig, SemanticDenseEmbeddingConfig._DESERIALIZER, "dense_embedding_config");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::rawFieldType, JsonpDeserializer.stringDeserializer(), "raw_field_type");
        op.add(Builder::searchModelId, JsonpDeserializer.stringDeserializer(), "search_model_id");
        op.add(Builder::semanticFieldSearchAnalyzer, JsonpDeserializer.stringDeserializer(), "semantic_field_search_analyzer");
        op.add(Builder::semanticInfoFieldName, JsonpDeserializer.stringDeserializer(), "semantic_info_field_name");
        op.add(Builder::skipExistingEmbedding, JsonpDeserializer.booleanDeserializer(), "skip_existing_embedding");
        op.add(Builder::sparseEncodingConfig, SemanticSparseEncodingConfig._DESERIALIZER, "sparse_encoding_config");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.chunking);
        result = 31 * result + Objects.hashCode(this.denseEmbeddingConfig);
        result = 31 * result + this.modelId.hashCode();
        result = 31 * result + Objects.hashCode(this.rawFieldType);
        result = 31 * result + Objects.hashCode(this.searchModelId);
        result = 31 * result + Objects.hashCode(this.semanticFieldSearchAnalyzer);
        result = 31 * result + Objects.hashCode(this.semanticInfoFieldName);
        result = 31 * result + Objects.hashCode(this.skipExistingEmbedding);
        result = 31 * result + Objects.hashCode(this.sparseEncodingConfig);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SemanticProperty other = (SemanticProperty) o;
        return Objects.equals(this.chunking, other.chunking)
            && Objects.equals(this.denseEmbeddingConfig, other.denseEmbeddingConfig)
            && this.modelId.equals(other.modelId)
            && Objects.equals(this.rawFieldType, other.rawFieldType)
            && Objects.equals(this.searchModelId, other.searchModelId)
            && Objects.equals(this.semanticFieldSearchAnalyzer, other.semanticFieldSearchAnalyzer)
            && Objects.equals(this.semanticInfoFieldName, other.semanticInfoFieldName)
            && Objects.equals(this.skipExistingEmbedding, other.skipExistingEmbedding)
            && Objects.equals(this.sparseEncodingConfig, other.sparseEncodingConfig);
    }
}
