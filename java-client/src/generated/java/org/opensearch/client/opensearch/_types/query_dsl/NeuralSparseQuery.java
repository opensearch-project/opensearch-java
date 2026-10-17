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

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.NeuralSparseQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NeuralSparseQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<NeuralSparseQuery.Builder, NeuralSparseQuery> {

    @Nullable
    private final String analyzer;

    @Nonnull
    private final String field;

    @Nullable
    private final Float maxTokenScore;

    @Nullable
    private final String modelId;

    @Nullable
    private final String queryText;

    @Nonnull
    private final Map<String, Float> queryTokens;

    // ---------------------------------------------------------------------------------------------

    private NeuralSparseQuery(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.maxTokenScore = builder.maxTokenScore;
        this.modelId = builder.modelId;
        this.queryText = builder.queryText;
        this.queryTokens = ApiTypeHelper.unmodifiable(builder.queryTokens);
    }

    public static NeuralSparseQuery of(Function<NeuralSparseQuery.Builder, ObjectBuilder<NeuralSparseQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.NeuralSparse;
    }

    /**
     * The analyzer to use for tokenization instead of an ML model.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * The maximum score threshold for sparse tokens. Deprecated since OpenSearch 2.12.
     * <p>
     * API name: {@code max_token_score}
     * </p>
     */
    @Nullable
    public final Float maxTokenScore() {
        return this.maxTokenScore;
    }

    /**
     * The ID of the sparse encoding model or tokenizer model at the ML node.
     * <p>
     * API name: {@code model_id}
     * </p>
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * The query text to be encoded into sparse tokens by the model.
     * <p>
     * API name: {@code query_text}
     * </p>
     */
    @Nullable
    public final String queryText() {
        return this.queryText;
    }

    /**
     * Pre-computed sparse tokens and their weights. Use instead of query_text+model_id when tokens are already available.
     * <p>
     * API name: {@code query_tokens}
     * </p>
     */
    @Nonnull
    public final Map<String, Float> queryTokens() {
        return this.queryTokens;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.maxTokenScore != null) {
            generator.writeKey("max_token_score");
            generator.write(this.maxTokenScore);
        }

        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        if (this.queryText != null) {
            generator.writeKey("query_text");
            generator.write(this.queryText);
        }

        if (ApiTypeHelper.isDefined(this.queryTokens)) {
            generator.writeKey("query_tokens");
            generator.writeStartObject();
            for (Map.Entry<String, Float> item0 : this.queryTokens.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }
        generator.writeEnd();
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
     * Builder for {@link NeuralSparseQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NeuralSparseQuery> {
        @Nullable
        private String analyzer;
        private String field;
        @Nullable
        private Float maxTokenScore;
        @Nullable
        private String modelId;
        @Nullable
        private String queryText;
        @Nullable
        private Map<String, Float> queryTokens;

        public Builder() {}

        private Builder(NeuralSparseQuery o) {
            super(o);
            this.analyzer = o.analyzer;
            this.field = o.field;
            this.maxTokenScore = o.maxTokenScore;
            this.modelId = o.modelId;
            this.queryText = o.queryText;
            this.queryTokens = _mapCopy(o.queryTokens);
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.field = o.field;
            this.maxTokenScore = o.maxTokenScore;
            this.modelId = o.modelId;
            this.queryText = o.queryText;
            this.queryTokens = _mapCopy(o.queryTokens);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * The analyzer to use for tokenization instead of an ML model.
         * <p>
         * API name: {@code analyzer}
         * </p>
         */
        @Nonnull
        public final Builder analyzer(@Nullable String value) {
            this.analyzer = value;
            return this;
        }

        /**
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * The maximum score threshold for sparse tokens. Deprecated since OpenSearch 2.12.
         * <p>
         * API name: {@code max_token_score}
         * </p>
         */
        @Nonnull
        public final Builder maxTokenScore(@Nullable Float value) {
            this.maxTokenScore = value;
            return this;
        }

        /**
         * The ID of the sparse encoding model or tokenizer model at the ML node.
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
         * The query text to be encoded into sparse tokens by the model.
         * <p>
         * API name: {@code query_text}
         * </p>
         */
        @Nonnull
        public final Builder queryText(@Nullable String value) {
            this.queryText = value;
            return this;
        }

        /**
         * Pre-computed sparse tokens and their weights. Use instead of query_text+model_id when tokens are already available.
         * <p>
         * API name: {@code query_tokens}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>queryTokens</code>.
         * </p>
         */
        @Nonnull
        public final Builder queryTokens(Map<String, Float> map) {
            this.queryTokens = _mapPutAll(this.queryTokens, map);
            return this;
        }

        /**
         * Pre-computed sparse tokens and their weights. Use instead of query_text+model_id when tokens are already available.
         * <p>
         * API name: {@code query_tokens}
         * </p>
         *
         * <p>
         * Adds an entry to <code>queryTokens</code>.
         * </p>
         */
        @Nonnull
        public final Builder queryTokens(String key, Float value) {
            this.queryTokens = _mapPut(this.queryTokens, key, value);
            return this;
        }

        /**
         * Builds a {@link NeuralSparseQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NeuralSparseQuery build() {
            _checkSingleUse();

            return new NeuralSparseQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NeuralSparseQuery}
     */
    public static final JsonpDeserializer<NeuralSparseQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NeuralSparseQuery::setupNeuralSparseQueryDeserializer
    );

    protected static void setupNeuralSparseQueryDeserializer(ObjectDeserializer<NeuralSparseQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::maxTokenScore, JsonpDeserializer.floatDeserializer(), "max_token_score");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::queryText, JsonpDeserializer.stringDeserializer(), "query_text");
        op.add(Builder::queryTokens, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.floatDeserializer()), "query_tokens");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.maxTokenScore);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.queryText);
        result = 31 * result + Objects.hashCode(this.queryTokens);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NeuralSparseQuery other = (NeuralSparseQuery) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && this.field.equals(other.field)
            && Objects.equals(this.maxTokenScore, other.maxTokenScore)
            && Objects.equals(this.modelId, other.modelId)
            && Objects.equals(this.queryText, other.queryText)
            && Objects.equals(this.queryTokens, other.queryTokens);
    }
}
