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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.analysis.Analyzer;
import org.opensearch.client.opensearch._types.analysis.CharFilter;
import org.opensearch.client.opensearch._types.analysis.Normalizer;
import org.opensearch.client.opensearch._types.analysis.TokenFilter;
import org.opensearch.client.opensearch._types.analysis.Tokenizer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IndexSettingsAnalysis

/**
 * The text analysis configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexSettingsAnalysis
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexSettingsAnalysis.Builder, IndexSettingsAnalysis> {

    @Nonnull
    private final Map<String, Analyzer> analyzer;

    @Nonnull
    private final Map<String, CharFilter> charFilter;

    @Nonnull
    private final Map<String, TokenFilter> filter;

    @Nonnull
    private final Map<String, Normalizer> normalizer;

    @Nonnull
    private final Map<String, Tokenizer> tokenizer;

    // ---------------------------------------------------------------------------------------------

    private IndexSettingsAnalysis(Builder builder) {
        this.analyzer = ApiTypeHelper.unmodifiable(builder.analyzer);
        this.charFilter = ApiTypeHelper.unmodifiable(builder.charFilter);
        this.filter = ApiTypeHelper.unmodifiable(builder.filter);
        this.normalizer = ApiTypeHelper.unmodifiable(builder.normalizer);
        this.tokenizer = ApiTypeHelper.unmodifiable(builder.tokenizer);
    }

    public static IndexSettingsAnalysis of(Function<IndexSettingsAnalysis.Builder, ObjectBuilder<IndexSettingsAnalysis>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The custom analyzer configurations.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nonnull
    public final Map<String, Analyzer> analyzer() {
        return this.analyzer;
    }

    /**
     * The custom character filter configurations.
     * <p>
     * API name: {@code char_filter}
     * </p>
     */
    @Nonnull
    public final Map<String, CharFilter> charFilter() {
        return this.charFilter;
    }

    /**
     * The custom token filter configurations.
     * <p>
     * API name: {@code filter}
     * </p>
     */
    @Nonnull
    public final Map<String, TokenFilter> filter() {
        return this.filter;
    }

    /**
     * The custom normalizer configurations.
     * <p>
     * API name: {@code normalizer}
     * </p>
     */
    @Nonnull
    public final Map<String, Normalizer> normalizer() {
        return this.normalizer;
    }

    /**
     * The custom tokenizer configurations.
     * <p>
     * API name: {@code tokenizer}
     * </p>
     */
    @Nonnull
    public final Map<String, Tokenizer> tokenizer() {
        return this.tokenizer;
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
        if (ApiTypeHelper.isDefined(this.analyzer)) {
            generator.writeKey("analyzer");
            generator.writeStartObject();
            for (Map.Entry<String, Analyzer> item0 : this.analyzer.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.charFilter)) {
            generator.writeKey("char_filter");
            generator.writeStartObject();
            for (Map.Entry<String, CharFilter> item0 : this.charFilter.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.filter)) {
            generator.writeKey("filter");
            generator.writeStartObject();
            for (Map.Entry<String, TokenFilter> item0 : this.filter.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.normalizer)) {
            generator.writeKey("normalizer");
            generator.writeStartObject();
            for (Map.Entry<String, Normalizer> item0 : this.normalizer.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.tokenizer)) {
            generator.writeKey("tokenizer");
            generator.writeStartObject();
            for (Map.Entry<String, Tokenizer> item0 : this.tokenizer.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link IndexSettingsAnalysis}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSettingsAnalysis> {
        @Nullable
        private Map<String, Analyzer> analyzer;
        @Nullable
        private Map<String, CharFilter> charFilter;
        @Nullable
        private Map<String, TokenFilter> filter;
        @Nullable
        private Map<String, Normalizer> normalizer;
        @Nullable
        private Map<String, Tokenizer> tokenizer;

        public Builder() {}

        private Builder(IndexSettingsAnalysis o) {
            this.analyzer = _mapCopy(o.analyzer);
            this.charFilter = _mapCopy(o.charFilter);
            this.filter = _mapCopy(o.filter);
            this.normalizer = _mapCopy(o.normalizer);
            this.tokenizer = _mapCopy(o.tokenizer);
        }

        private Builder(Builder o) {
            this.analyzer = _mapCopy(o.analyzer);
            this.charFilter = _mapCopy(o.charFilter);
            this.filter = _mapCopy(o.filter);
            this.normalizer = _mapCopy(o.normalizer);
            this.tokenizer = _mapCopy(o.tokenizer);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The custom analyzer configurations.
         * <p>
         * API name: {@code analyzer}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>analyzer</code>.
         * </p>
         */
        @Nonnull
        public final Builder analyzer(Map<String, Analyzer> map) {
            this.analyzer = _mapPutAll(this.analyzer, map);
            return this;
        }

        /**
         * The custom analyzer configurations.
         * <p>
         * API name: {@code analyzer}
         * </p>
         *
         * <p>
         * Adds an entry to <code>analyzer</code>.
         * </p>
         */
        @Nonnull
        public final Builder analyzer(String key, Analyzer value) {
            this.analyzer = _mapPut(this.analyzer, key, value);
            return this;
        }

        /**
         * The custom analyzer configurations.
         * <p>
         * API name: {@code analyzer}
         * </p>
         *
         * <p>
         * Adds a value to <code>analyzer</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder analyzer(String key, Function<Analyzer.Builder, ObjectBuilder<Analyzer>> fn) {
            return analyzer(key, fn.apply(new Analyzer.Builder()).build());
        }

        /**
         * The custom character filter configurations.
         * <p>
         * API name: {@code char_filter}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>charFilter</code>.
         * </p>
         */
        @Nonnull
        public final Builder charFilter(Map<String, CharFilter> map) {
            this.charFilter = _mapPutAll(this.charFilter, map);
            return this;
        }

        /**
         * The custom character filter configurations.
         * <p>
         * API name: {@code char_filter}
         * </p>
         *
         * <p>
         * Adds an entry to <code>charFilter</code>.
         * </p>
         */
        @Nonnull
        public final Builder charFilter(String key, CharFilter value) {
            this.charFilter = _mapPut(this.charFilter, key, value);
            return this;
        }

        /**
         * The custom character filter configurations.
         * <p>
         * API name: {@code char_filter}
         * </p>
         *
         * <p>
         * Adds a value to <code>charFilter</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder charFilter(String key, Function<CharFilter.Builder, ObjectBuilder<CharFilter>> fn) {
            return charFilter(key, fn.apply(new CharFilter.Builder()).build());
        }

        /**
         * The custom token filter configurations.
         * <p>
         * API name: {@code filter}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>filter</code>.
         * </p>
         */
        @Nonnull
        public final Builder filter(Map<String, TokenFilter> map) {
            this.filter = _mapPutAll(this.filter, map);
            return this;
        }

        /**
         * The custom token filter configurations.
         * <p>
         * API name: {@code filter}
         * </p>
         *
         * <p>
         * Adds an entry to <code>filter</code>.
         * </p>
         */
        @Nonnull
        public final Builder filter(String key, TokenFilter value) {
            this.filter = _mapPut(this.filter, key, value);
            return this;
        }

        /**
         * The custom token filter configurations.
         * <p>
         * API name: {@code filter}
         * </p>
         *
         * <p>
         * Adds a value to <code>filter</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder filter(String key, Function<TokenFilter.Builder, ObjectBuilder<TokenFilter>> fn) {
            return filter(key, fn.apply(new TokenFilter.Builder()).build());
        }

        /**
         * The custom normalizer configurations.
         * <p>
         * API name: {@code normalizer}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>normalizer</code>.
         * </p>
         */
        @Nonnull
        public final Builder normalizer(Map<String, Normalizer> map) {
            this.normalizer = _mapPutAll(this.normalizer, map);
            return this;
        }

        /**
         * The custom normalizer configurations.
         * <p>
         * API name: {@code normalizer}
         * </p>
         *
         * <p>
         * Adds an entry to <code>normalizer</code>.
         * </p>
         */
        @Nonnull
        public final Builder normalizer(String key, Normalizer value) {
            this.normalizer = _mapPut(this.normalizer, key, value);
            return this;
        }

        /**
         * The custom normalizer configurations.
         * <p>
         * API name: {@code normalizer}
         * </p>
         *
         * <p>
         * Adds a value to <code>normalizer</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder normalizer(String key, Function<Normalizer.Builder, ObjectBuilder<Normalizer>> fn) {
            return normalizer(key, fn.apply(new Normalizer.Builder()).build());
        }

        /**
         * The custom tokenizer configurations.
         * <p>
         * API name: {@code tokenizer}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>tokenizer</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenizer(Map<String, Tokenizer> map) {
            this.tokenizer = _mapPutAll(this.tokenizer, map);
            return this;
        }

        /**
         * The custom tokenizer configurations.
         * <p>
         * API name: {@code tokenizer}
         * </p>
         *
         * <p>
         * Adds an entry to <code>tokenizer</code>.
         * </p>
         */
        @Nonnull
        public final Builder tokenizer(String key, Tokenizer value) {
            this.tokenizer = _mapPut(this.tokenizer, key, value);
            return this;
        }

        /**
         * The custom tokenizer configurations.
         * <p>
         * API name: {@code tokenizer}
         * </p>
         *
         * <p>
         * Adds a value to <code>tokenizer</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder tokenizer(String key, Function<Tokenizer.Builder, ObjectBuilder<Tokenizer>> fn) {
            return tokenizer(key, fn.apply(new Tokenizer.Builder()).build());
        }

        /**
         * Builds a {@link IndexSettingsAnalysis}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSettingsAnalysis build() {
            _checkSingleUse();

            return new IndexSettingsAnalysis(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSettingsAnalysis}
     */
    public static final JsonpDeserializer<IndexSettingsAnalysis> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSettingsAnalysis::setupIndexSettingsAnalysisDeserializer
    );

    protected static void setupIndexSettingsAnalysisDeserializer(ObjectDeserializer<IndexSettingsAnalysis.Builder> op) {
        op.add(Builder::analyzer, JsonpDeserializer.stringMapDeserializer(Analyzer._DESERIALIZER), "analyzer");
        op.add(Builder::charFilter, JsonpDeserializer.stringMapDeserializer(CharFilter._DESERIALIZER), "char_filter");
        op.add(Builder::filter, JsonpDeserializer.stringMapDeserializer(TokenFilter._DESERIALIZER), "filter");
        op.add(Builder::normalizer, JsonpDeserializer.stringMapDeserializer(Normalizer._DESERIALIZER), "normalizer");
        op.add(Builder::tokenizer, JsonpDeserializer.stringMapDeserializer(Tokenizer._DESERIALIZER), "tokenizer");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.charFilter);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.normalizer);
        result = 31 * result + Objects.hashCode(this.tokenizer);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSettingsAnalysis other = (IndexSettingsAnalysis) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.charFilter, other.charFilter)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.normalizer, other.normalizer)
            && Objects.equals(this.tokenizer, other.tokenizer);
    }
}
