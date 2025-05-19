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
import java.util.List;
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
import org.opensearch.client.opensearch._types.VersionType;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.MoreLikeThisQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MoreLikeThisQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<MoreLikeThisQuery.Builder, MoreLikeThisQuery> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final Float boostTerms;

    @Nullable
    private final Boolean failOnUnsupportedField;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final Boolean include;

    @Nonnull
    private final List<Like> like;

    @Nullable
    private final Integer maxDocFreq;

    @Nullable
    private final Integer maxQueryTerms;

    @Nullable
    private final Integer maxWordLength;

    @Nullable
    private final Integer minDocFreq;

    @Nullable
    private final Integer minTermFreq;

    @Nullable
    private final Integer minWordLength;

    @Nullable
    private final String minimumShouldMatch;

    @Nonnull
    private final Map<String, String> perFieldAnalyzer;

    @Nullable
    private final String routing;

    @Nonnull
    private final List<String> stopWords;

    @Nonnull
    private final List<Like> unlike;

    @Nullable
    private final Long version;

    @Nullable
    private final VersionType versionType;

    // ---------------------------------------------------------------------------------------------

    private MoreLikeThisQuery(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.boostTerms = builder.boostTerms;
        this.failOnUnsupportedField = builder.failOnUnsupportedField;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.include = builder.include;
        this.like = ApiTypeHelper.unmodifiableRequired(builder.like, this, "like");
        this.maxDocFreq = builder.maxDocFreq;
        this.maxQueryTerms = builder.maxQueryTerms;
        this.maxWordLength = builder.maxWordLength;
        this.minDocFreq = builder.minDocFreq;
        this.minTermFreq = builder.minTermFreq;
        this.minWordLength = builder.minWordLength;
        this.minimumShouldMatch = builder.minimumShouldMatch;
        this.perFieldAnalyzer = ApiTypeHelper.unmodifiable(builder.perFieldAnalyzer);
        this.routing = builder.routing;
        this.stopWords = ApiTypeHelper.unmodifiable(builder.stopWords);
        this.unlike = ApiTypeHelper.unmodifiable(builder.unlike);
        this.version = builder.version;
        this.versionType = builder.versionType;
    }

    public static MoreLikeThisQuery of(Function<MoreLikeThisQuery.Builder, ObjectBuilder<MoreLikeThisQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.MoreLikeThis;
    }

    /**
     * The analyzer that is used to analyze the free form text. Defaults to the analyzer associated with the first field in fields.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * Each term in the formed query could be further boosted by their tf-idf score. This sets the boost factor to use when using this
     * feature. Defaults to deactivated (0).
     * <p>
     * API name: {@code boost_terms}
     * </p>
     */
    @Nullable
    public final Float boostTerms() {
        return this.boostTerms;
    }

    /**
     * Controls whether the query should fail (throw an exception) if any of the specified fields are not of the supported types
     * (<code>text</code> or <code>keyword</code>).
     * <p>
     * API name: {@code fail_on_unsupported_field}
     * </p>
     */
    @Nullable
    public final Boolean failOnUnsupportedField() {
        return this.failOnUnsupportedField;
    }

    /**
     * A list of fields to fetch and analyze the text from. Defaults to the <code>index.query.default_field</code> index setting, which has
     * a default value of <code>*</code>.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * Specifies whether the input documents should also be included in the search results returned.
     * <p>
     * API name: {@code include}
     * </p>
     */
    @Nullable
    public final Boolean include() {
        return this.include;
    }

    /**
     * Required - Specifies free form text and/or a single or multiple documents for which you want to find similar documents.
     * <p>
     * API name: {@code like}
     * </p>
     */
    @Nonnull
    public final List<Like> like() {
        return this.like;
    }

    /**
     * The maximum document frequency above which the terms are ignored from the input document.
     * <p>
     * API name: {@code max_doc_freq}
     * </p>
     */
    @Nullable
    public final Integer maxDocFreq() {
        return this.maxDocFreq;
    }

    /**
     * The maximum number of query terms that can be selected.
     * <p>
     * API name: {@code max_query_terms}
     * </p>
     */
    @Nullable
    public final Integer maxQueryTerms() {
        return this.maxQueryTerms;
    }

    /**
     * The maximum word length above which the terms are ignored. Defaults to unbounded (<code>0</code>).
     * <p>
     * API name: {@code max_word_length}
     * </p>
     */
    @Nullable
    public final Integer maxWordLength() {
        return this.maxWordLength;
    }

    /**
     * The minimum document frequency below which the terms are ignored from the input document.
     * <p>
     * API name: {@code min_doc_freq}
     * </p>
     */
    @Nullable
    public final Integer minDocFreq() {
        return this.minDocFreq;
    }

    /**
     * The minimum term frequency below which the terms are ignored from the input document.
     * <p>
     * API name: {@code min_term_freq}
     * </p>
     */
    @Nullable
    public final Integer minTermFreq() {
        return this.minTermFreq;
    }

    /**
     * The minimum word length below which the terms are ignored.
     * <p>
     * API name: {@code min_word_length}
     * </p>
     */
    @Nullable
    public final Integer minWordLength() {
        return this.minWordLength;
    }

    /**
     * API name: {@code minimum_should_match}
     */
    @Nullable
    public final String minimumShouldMatch() {
        return this.minimumShouldMatch;
    }

    /**
     * Overrides the default analyzer.
     * <p>
     * API name: {@code per_field_analyzer}
     * </p>
     */
    @Nonnull
    public final Map<String, String> perFieldAnalyzer() {
        return this.perFieldAnalyzer;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code stop_words}
     */
    @Nonnull
    public final List<String> stopWords() {
        return this.stopWords;
    }

    /**
     * Used in combination with <code>like</code> to exclude documents that match a set of terms.
     * <p>
     * API name: {@code unlike}
     * </p>
     */
    @Nonnull
    public final List<Like> unlike() {
        return this.unlike;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final Long version() {
        return this.version;
    }

    /**
     * API name: {@code version_type}
     */
    @Nullable
    public final VersionType versionType() {
        return this.versionType;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.boostTerms != null) {
            generator.writeKey("boost_terms");
            generator.write(this.boostTerms);
        }

        if (this.failOnUnsupportedField != null) {
            generator.writeKey("fail_on_unsupported_field");
            generator.write(this.failOnUnsupportedField);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.include != null) {
            generator.writeKey("include");
            generator.write(this.include);
        }

        generator.writeKey("like");
        generator.writeStartArray();
        for (Like item0 : this.like) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.maxDocFreq != null) {
            generator.writeKey("max_doc_freq");
            generator.write(this.maxDocFreq);
        }

        if (this.maxQueryTerms != null) {
            generator.writeKey("max_query_terms");
            generator.write(this.maxQueryTerms);
        }

        if (this.maxWordLength != null) {
            generator.writeKey("max_word_length");
            generator.write(this.maxWordLength);
        }

        if (this.minDocFreq != null) {
            generator.writeKey("min_doc_freq");
            generator.write(this.minDocFreq);
        }

        if (this.minTermFreq != null) {
            generator.writeKey("min_term_freq");
            generator.write(this.minTermFreq);
        }

        if (this.minWordLength != null) {
            generator.writeKey("min_word_length");
            generator.write(this.minWordLength);
        }

        if (this.minimumShouldMatch != null) {
            generator.writeKey("minimum_should_match");
            generator.write(this.minimumShouldMatch);
        }

        if (ApiTypeHelper.isDefined(this.perFieldAnalyzer)) {
            generator.writeKey("per_field_analyzer");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.perFieldAnalyzer.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            generator.write(this.routing);
        }

        if (ApiTypeHelper.isDefined(this.stopWords)) {
            generator.writeKey("stop_words");
            generator.writeStartArray();
            for (String item0 : this.stopWords) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.unlike)) {
            generator.writeKey("unlike");
            generator.writeStartArray();
            for (Like item0 : this.unlike) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }

        if (this.versionType != null) {
            generator.writeKey("version_type");
            this.versionType.serialize(generator, mapper);
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
     * Builder for {@link MoreLikeThisQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, MoreLikeThisQuery> {
        @Nullable
        private String analyzer;
        @Nullable
        private Float boostTerms;
        @Nullable
        private Boolean failOnUnsupportedField;
        @Nullable
        private List<String> fields;
        @Nullable
        private Boolean include;
        private List<Like> like;
        @Nullable
        private Integer maxDocFreq;
        @Nullable
        private Integer maxQueryTerms;
        @Nullable
        private Integer maxWordLength;
        @Nullable
        private Integer minDocFreq;
        @Nullable
        private Integer minTermFreq;
        @Nullable
        private Integer minWordLength;
        @Nullable
        private String minimumShouldMatch;
        @Nullable
        private Map<String, String> perFieldAnalyzer;
        @Nullable
        private String routing;
        @Nullable
        private List<String> stopWords;
        @Nullable
        private List<Like> unlike;
        @Nullable
        private Long version;
        @Nullable
        private VersionType versionType;

        public Builder() {}

        private Builder(MoreLikeThisQuery o) {
            super(o);
            this.analyzer = o.analyzer;
            this.boostTerms = o.boostTerms;
            this.failOnUnsupportedField = o.failOnUnsupportedField;
            this.fields = _listCopy(o.fields);
            this.include = o.include;
            this.like = _listCopy(o.like);
            this.maxDocFreq = o.maxDocFreq;
            this.maxQueryTerms = o.maxQueryTerms;
            this.maxWordLength = o.maxWordLength;
            this.minDocFreq = o.minDocFreq;
            this.minTermFreq = o.minTermFreq;
            this.minWordLength = o.minWordLength;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.perFieldAnalyzer = _mapCopy(o.perFieldAnalyzer);
            this.routing = o.routing;
            this.stopWords = _listCopy(o.stopWords);
            this.unlike = _listCopy(o.unlike);
            this.version = o.version;
            this.versionType = o.versionType;
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.boostTerms = o.boostTerms;
            this.failOnUnsupportedField = o.failOnUnsupportedField;
            this.fields = _listCopy(o.fields);
            this.include = o.include;
            this.like = _listCopy(o.like);
            this.maxDocFreq = o.maxDocFreq;
            this.maxQueryTerms = o.maxQueryTerms;
            this.maxWordLength = o.maxWordLength;
            this.minDocFreq = o.minDocFreq;
            this.minTermFreq = o.minTermFreq;
            this.minWordLength = o.minWordLength;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.perFieldAnalyzer = _mapCopy(o.perFieldAnalyzer);
            this.routing = o.routing;
            this.stopWords = _listCopy(o.stopWords);
            this.unlike = _listCopy(o.unlike);
            this.version = o.version;
            this.versionType = o.versionType;
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
         * The analyzer that is used to analyze the free form text. Defaults to the analyzer associated with the first field in fields.
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
         * Each term in the formed query could be further boosted by their tf-idf score. This sets the boost factor to use when using this
         * feature. Defaults to deactivated (0).
         * <p>
         * API name: {@code boost_terms}
         * </p>
         */
        @Nonnull
        public final Builder boostTerms(@Nullable Float value) {
            this.boostTerms = value;
            return this;
        }

        /**
         * Controls whether the query should fail (throw an exception) if any of the specified fields are not of the supported types
         * (<code>text</code> or <code>keyword</code>).
         * <p>
         * API name: {@code fail_on_unsupported_field}
         * </p>
         */
        @Nonnull
        public final Builder failOnUnsupportedField(@Nullable Boolean value) {
            this.failOnUnsupportedField = value;
            return this;
        }

        /**
         * A list of fields to fetch and analyze the text from. Defaults to the <code>index.query.default_field</code> index setting, which
         * has a default value of <code>*</code>.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * A list of fields to fetch and analyze the text from. Defaults to the <code>index.query.default_field</code> index setting, which
         * has a default value of <code>*</code>.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * Specifies whether the input documents should also be included in the search results returned.
         * <p>
         * API name: {@code include}
         * </p>
         */
        @Nonnull
        public final Builder include(@Nullable Boolean value) {
            this.include = value;
            return this;
        }

        /**
         * Required - Specifies free form text and/or a single or multiple documents for which you want to find similar documents.
         * <p>
         * API name: {@code like}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>like</code>.
         * </p>
         */
        @Nonnull
        public final Builder like(List<Like> list) {
            this.like = _listAddAll(this.like, list);
            return this;
        }

        /**
         * Required - Specifies free form text and/or a single or multiple documents for which you want to find similar documents.
         * <p>
         * API name: {@code like}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>like</code>.
         * </p>
         */
        @Nonnull
        public final Builder like(Like value, Like... values) {
            this.like = _listAdd(this.like, value, values);
            return this;
        }

        /**
         * Required - Specifies free form text and/or a single or multiple documents for which you want to find similar documents.
         * <p>
         * API name: {@code like}
         * </p>
         *
         * <p>
         * Adds a value to <code>like</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder like(Function<Like.Builder, ObjectBuilder<Like>> fn) {
            return like(fn.apply(new Like.Builder()).build());
        }

        /**
         * The maximum document frequency above which the terms are ignored from the input document.
         * <p>
         * API name: {@code max_doc_freq}
         * </p>
         */
        @Nonnull
        public final Builder maxDocFreq(@Nullable Integer value) {
            this.maxDocFreq = value;
            return this;
        }

        /**
         * The maximum number of query terms that can be selected.
         * <p>
         * API name: {@code max_query_terms}
         * </p>
         */
        @Nonnull
        public final Builder maxQueryTerms(@Nullable Integer value) {
            this.maxQueryTerms = value;
            return this;
        }

        /**
         * The maximum word length above which the terms are ignored. Defaults to unbounded (<code>0</code>).
         * <p>
         * API name: {@code max_word_length}
         * </p>
         */
        @Nonnull
        public final Builder maxWordLength(@Nullable Integer value) {
            this.maxWordLength = value;
            return this;
        }

        /**
         * The minimum document frequency below which the terms are ignored from the input document.
         * <p>
         * API name: {@code min_doc_freq}
         * </p>
         */
        @Nonnull
        public final Builder minDocFreq(@Nullable Integer value) {
            this.minDocFreq = value;
            return this;
        }

        /**
         * The minimum term frequency below which the terms are ignored from the input document.
         * <p>
         * API name: {@code min_term_freq}
         * </p>
         */
        @Nonnull
        public final Builder minTermFreq(@Nullable Integer value) {
            this.minTermFreq = value;
            return this;
        }

        /**
         * The minimum word length below which the terms are ignored.
         * <p>
         * API name: {@code min_word_length}
         * </p>
         */
        @Nonnull
        public final Builder minWordLength(@Nullable Integer value) {
            this.minWordLength = value;
            return this;
        }

        /**
         * API name: {@code minimum_should_match}
         */
        @Nonnull
        public final Builder minimumShouldMatch(@Nullable String value) {
            this.minimumShouldMatch = value;
            return this;
        }

        /**
         * Overrides the default analyzer.
         * <p>
         * API name: {@code per_field_analyzer}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>perFieldAnalyzer</code>.
         * </p>
         */
        @Nonnull
        public final Builder perFieldAnalyzer(Map<String, String> map) {
            this.perFieldAnalyzer = _mapPutAll(this.perFieldAnalyzer, map);
            return this;
        }

        /**
         * Overrides the default analyzer.
         * <p>
         * API name: {@code per_field_analyzer}
         * </p>
         *
         * <p>
         * Adds an entry to <code>perFieldAnalyzer</code>.
         * </p>
         */
        @Nonnull
        public final Builder perFieldAnalyzer(String key, String value) {
            this.perFieldAnalyzer = _mapPut(this.perFieldAnalyzer, key, value);
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code stop_words}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stopWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder stopWords(List<String> list) {
            this.stopWords = _listAddAll(this.stopWords, list);
            return this;
        }

        /**
         * API name: {@code stop_words}
         *
         * <p>
         * Adds one or more values to <code>stopWords</code>.
         * </p>
         */
        @Nonnull
        public final Builder stopWords(String value, String... values) {
            this.stopWords = _listAdd(this.stopWords, value, values);
            return this;
        }

        /**
         * Used in combination with <code>like</code> to exclude documents that match a set of terms.
         * <p>
         * API name: {@code unlike}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>unlike</code>.
         * </p>
         */
        @Nonnull
        public final Builder unlike(List<Like> list) {
            this.unlike = _listAddAll(this.unlike, list);
            return this;
        }

        /**
         * Used in combination with <code>like</code> to exclude documents that match a set of terms.
         * <p>
         * API name: {@code unlike}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>unlike</code>.
         * </p>
         */
        @Nonnull
        public final Builder unlike(Like value, Like... values) {
            this.unlike = _listAdd(this.unlike, value, values);
            return this;
        }

        /**
         * Used in combination with <code>like</code> to exclude documents that match a set of terms.
         * <p>
         * API name: {@code unlike}
         * </p>
         *
         * <p>
         * Adds a value to <code>unlike</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder unlike(Function<Like.Builder, ObjectBuilder<Like>> fn) {
            return unlike(fn.apply(new Like.Builder()).build());
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable Long value) {
            this.version = value;
            return this;
        }

        /**
         * API name: {@code version_type}
         */
        @Nonnull
        public final Builder versionType(@Nullable VersionType value) {
            this.versionType = value;
            return this;
        }

        /**
         * Builds a {@link MoreLikeThisQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MoreLikeThisQuery build() {
            _checkSingleUse();

            return new MoreLikeThisQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MoreLikeThisQuery}
     */
    public static final JsonpDeserializer<MoreLikeThisQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MoreLikeThisQuery::setupMoreLikeThisQueryDeserializer
    );

    protected static void setupMoreLikeThisQueryDeserializer(ObjectDeserializer<MoreLikeThisQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::boostTerms, JsonpDeserializer.floatDeserializer(), "boost_terms");
        op.add(Builder::failOnUnsupportedField, JsonpDeserializer.booleanDeserializer(), "fail_on_unsupported_field");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::include, JsonpDeserializer.booleanDeserializer(), "include");
        op.add(Builder::like, JsonpDeserializer.arrayDeserializer(Like._DESERIALIZER), "like");
        op.add(Builder::maxDocFreq, JsonpDeserializer.integerDeserializer(), "max_doc_freq");
        op.add(Builder::maxQueryTerms, JsonpDeserializer.integerDeserializer(), "max_query_terms");
        op.add(Builder::maxWordLength, JsonpDeserializer.integerDeserializer(), "max_word_length");
        op.add(Builder::minDocFreq, JsonpDeserializer.integerDeserializer(), "min_doc_freq");
        op.add(Builder::minTermFreq, JsonpDeserializer.integerDeserializer(), "min_term_freq");
        op.add(Builder::minWordLength, JsonpDeserializer.integerDeserializer(), "min_word_length");
        op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
        op.add(
            Builder::perFieldAnalyzer,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()),
            "per_field_analyzer"
        );
        op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
        op.add(Builder::stopWords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stop_words");
        op.add(Builder::unlike, JsonpDeserializer.arrayDeserializer(Like._DESERIALIZER), "unlike");
        op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");
        op.add(Builder::versionType, VersionType._DESERIALIZER, "version_type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.boostTerms);
        result = 31 * result + Objects.hashCode(this.failOnUnsupportedField);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.include);
        result = 31 * result + this.like.hashCode();
        result = 31 * result + Objects.hashCode(this.maxDocFreq);
        result = 31 * result + Objects.hashCode(this.maxQueryTerms);
        result = 31 * result + Objects.hashCode(this.maxWordLength);
        result = 31 * result + Objects.hashCode(this.minDocFreq);
        result = 31 * result + Objects.hashCode(this.minTermFreq);
        result = 31 * result + Objects.hashCode(this.minWordLength);
        result = 31 * result + Objects.hashCode(this.minimumShouldMatch);
        result = 31 * result + Objects.hashCode(this.perFieldAnalyzer);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.stopWords);
        result = 31 * result + Objects.hashCode(this.unlike);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.versionType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MoreLikeThisQuery other = (MoreLikeThisQuery) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.boostTerms, other.boostTerms)
            && Objects.equals(this.failOnUnsupportedField, other.failOnUnsupportedField)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.include, other.include)
            && this.like.equals(other.like)
            && Objects.equals(this.maxDocFreq, other.maxDocFreq)
            && Objects.equals(this.maxQueryTerms, other.maxQueryTerms)
            && Objects.equals(this.maxWordLength, other.maxWordLength)
            && Objects.equals(this.minDocFreq, other.minDocFreq)
            && Objects.equals(this.minTermFreq, other.minTermFreq)
            && Objects.equals(this.minWordLength, other.minWordLength)
            && Objects.equals(this.minimumShouldMatch, other.minimumShouldMatch)
            && Objects.equals(this.perFieldAnalyzer, other.perFieldAnalyzer)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.stopWords, other.stopWords)
            && Objects.equals(this.unlike, other.unlike)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.versionType, other.versionType);
    }
}
