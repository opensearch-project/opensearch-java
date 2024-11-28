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

// typedef: _types.query_dsl.QueryStringQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class QueryStringQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<QueryStringQuery.Builder, QueryStringQuery> {

    @Nullable
    private final Boolean allowLeadingWildcard;

    @Nullable
    private final Boolean analyzeWildcard;

    @Nullable
    private final String analyzer;

    @Nullable
    private final Boolean autoGenerateSynonymsPhraseQuery;

    @Nullable
    private final String defaultField;

    @Nullable
    private final Operator defaultOperator;

    @Nullable
    private final Boolean enablePositionIncrements;

    @Nullable
    private final Boolean escape;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final String fuzziness;

    @Nullable
    private final Integer fuzzyMaxExpansions;

    @Nullable
    private final Integer fuzzyPrefixLength;

    @Nullable
    private final String fuzzyRewrite;

    @Nullable
    private final Boolean fuzzyTranspositions;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final Integer maxDeterminizedStates;

    @Nullable
    private final String minimumShouldMatch;

    @Nullable
    private final Integer phraseSlop;

    @Nonnull
    private final String query;

    @Nullable
    private final String quoteAnalyzer;

    @Nullable
    private final String quoteFieldSuffix;

    @Nullable
    private final String rewrite;

    @Nullable
    private final Float tieBreaker;

    @Nullable
    private final String timeZone;

    @Nullable
    private final TextQueryType type;

    // ---------------------------------------------------------------------------------------------

    private QueryStringQuery(Builder builder) {
        super(builder);
        this.allowLeadingWildcard = builder.allowLeadingWildcard;
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.autoGenerateSynonymsPhraseQuery = builder.autoGenerateSynonymsPhraseQuery;
        this.defaultField = builder.defaultField;
        this.defaultOperator = builder.defaultOperator;
        this.enablePositionIncrements = builder.enablePositionIncrements;
        this.escape = builder.escape;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.fuzziness = builder.fuzziness;
        this.fuzzyMaxExpansions = builder.fuzzyMaxExpansions;
        this.fuzzyPrefixLength = builder.fuzzyPrefixLength;
        this.fuzzyRewrite = builder.fuzzyRewrite;
        this.fuzzyTranspositions = builder.fuzzyTranspositions;
        this.lenient = builder.lenient;
        this.maxDeterminizedStates = builder.maxDeterminizedStates;
        this.minimumShouldMatch = builder.minimumShouldMatch;
        this.phraseSlop = builder.phraseSlop;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.quoteAnalyzer = builder.quoteAnalyzer;
        this.quoteFieldSuffix = builder.quoteFieldSuffix;
        this.rewrite = builder.rewrite;
        this.tieBreaker = builder.tieBreaker;
        this.timeZone = builder.timeZone;
        this.type = builder.type;
    }

    public static QueryStringQuery of(Function<QueryStringQuery.Builder, ObjectBuilder<QueryStringQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.QueryString;
    }

    /**
     * If <code>true</code>, the wildcard characters <code>*</code> and <code>?</code> are allowed as the first character of the query
     * string.
     * <p>
     * API name: {@code allow_leading_wildcard}
     * </p>
     */
    @Nullable
    public final Boolean allowLeadingWildcard() {
        return this.allowLeadingWildcard;
    }

    /**
     * If <code>true</code>, the query attempts to analyze wildcard terms in the query string.
     * <p>
     * API name: {@code analyze_wildcard}
     * </p>
     */
    @Nullable
    public final Boolean analyzeWildcard() {
        return this.analyzeWildcard;
    }

    /**
     * Analyzer used to convert text in the query string into tokens.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * If <code>true</code>, match phrase queries are automatically created for multi-term synonyms.
     * <p>
     * API name: {@code auto_generate_synonyms_phrase_query}
     * </p>
     */
    @Nullable
    public final Boolean autoGenerateSynonymsPhraseQuery() {
        return this.autoGenerateSynonymsPhraseQuery;
    }

    /**
     * API name: {@code default_field}
     */
    @Nullable
    public final String defaultField() {
        return this.defaultField;
    }

    /**
     * API name: {@code default_operator}
     */
    @Nullable
    public final Operator defaultOperator() {
        return this.defaultOperator;
    }

    /**
     * If <code>true</code>, enable position increments in queries constructed from a <code>query_string</code> search.
     * <p>
     * API name: {@code enable_position_increments}
     * </p>
     */
    @Nullable
    public final Boolean enablePositionIncrements() {
        return this.enablePositionIncrements;
    }

    /**
     * API name: {@code escape}
     */
    @Nullable
    public final Boolean escape() {
        return this.escape;
    }

    /**
     * Array of fields to search. Supports wildcards (<code>*</code>).
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * API name: {@code fuzziness}
     */
    @Nullable
    public final String fuzziness() {
        return this.fuzziness;
    }

    /**
     * Maximum number of terms to which the query expands for fuzzy matching.
     * <p>
     * API name: {@code fuzzy_max_expansions}
     * </p>
     */
    @Nullable
    public final Integer fuzzyMaxExpansions() {
        return this.fuzzyMaxExpansions;
    }

    /**
     * Number of beginning characters left unchanged for fuzzy matching.
     * <p>
     * API name: {@code fuzzy_prefix_length}
     * </p>
     */
    @Nullable
    public final Integer fuzzyPrefixLength() {
        return this.fuzzyPrefixLength;
    }

    /**
     * API name: {@code fuzzy_rewrite}
     */
    @Nullable
    public final String fuzzyRewrite() {
        return this.fuzzyRewrite;
    }

    /**
     * If <code>true</code>, edits for fuzzy matching include transpositions of two adjacent characters (for example, <code>ab</code> to
     * <code>ba</code>).
     * <p>
     * API name: {@code fuzzy_transpositions}
     * </p>
     */
    @Nullable
    public final Boolean fuzzyTranspositions() {
        return this.fuzzyTranspositions;
    }

    /**
     * If <code>true</code>, format-based errors, such as providing a text value for a numeric field, are ignored.
     * <p>
     * API name: {@code lenient}
     * </p>
     */
    @Nullable
    public final Boolean lenient() {
        return this.lenient;
    }

    /**
     * Maximum number of automaton states required for the query.
     * <p>
     * API name: {@code max_determinized_states}
     * </p>
     */
    @Nullable
    public final Integer maxDeterminizedStates() {
        return this.maxDeterminizedStates;
    }

    /**
     * API name: {@code minimum_should_match}
     */
    @Nullable
    public final String minimumShouldMatch() {
        return this.minimumShouldMatch;
    }

    /**
     * Maximum number of positions allowed between matching tokens for phrases.
     * <p>
     * API name: {@code phrase_slop}
     * </p>
     */
    @Nullable
    public final Integer phraseSlop() {
        return this.phraseSlop;
    }

    /**
     * Required - Query string you wish to parse and use for search.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nonnull
    public final String query() {
        return this.query;
    }

    /**
     * Analyzer used to convert quoted text in the query string into tokens. For quoted text, this parameter overrides the analyzer
     * specified in the <code>analyzer</code> parameter.
     * <p>
     * API name: {@code quote_analyzer}
     * </p>
     */
    @Nullable
    public final String quoteAnalyzer() {
        return this.quoteAnalyzer;
    }

    /**
     * Suffix appended to quoted text in the query string. You can use this suffix to use a different analysis method for exact matches.
     * <p>
     * API name: {@code quote_field_suffix}
     * </p>
     */
    @Nullable
    public final String quoteFieldSuffix() {
        return this.quoteFieldSuffix;
    }

    /**
     * API name: {@code rewrite}
     */
    @Nullable
    public final String rewrite() {
        return this.rewrite;
    }

    /**
     * How to combine the queries generated from the individual search terms in the resulting <code>dis_max</code> query.
     * <p>
     * API name: {@code tie_breaker}
     * </p>
     */
    @Nullable
    public final Float tieBreaker() {
        return this.tieBreaker;
    }

    /**
     * API name: {@code time_zone}
     */
    @Nullable
    public final String timeZone() {
        return this.timeZone;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final TextQueryType type() {
        return this.type;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.allowLeadingWildcard != null) {
            generator.writeKey("allow_leading_wildcard");
            generator.write(this.allowLeadingWildcard);
        }

        if (this.analyzeWildcard != null) {
            generator.writeKey("analyze_wildcard");
            generator.write(this.analyzeWildcard);
        }

        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.autoGenerateSynonymsPhraseQuery != null) {
            generator.writeKey("auto_generate_synonyms_phrase_query");
            generator.write(this.autoGenerateSynonymsPhraseQuery);
        }

        if (this.defaultField != null) {
            generator.writeKey("default_field");
            generator.write(this.defaultField);
        }

        if (this.defaultOperator != null) {
            generator.writeKey("default_operator");
            this.defaultOperator.serialize(generator, mapper);
        }

        if (this.enablePositionIncrements != null) {
            generator.writeKey("enable_position_increments");
            generator.write(this.enablePositionIncrements);
        }

        if (this.escape != null) {
            generator.writeKey("escape");
            generator.write(this.escape);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.fuzziness != null) {
            generator.writeKey("fuzziness");
            generator.write(this.fuzziness);
        }

        if (this.fuzzyMaxExpansions != null) {
            generator.writeKey("fuzzy_max_expansions");
            generator.write(this.fuzzyMaxExpansions);
        }

        if (this.fuzzyPrefixLength != null) {
            generator.writeKey("fuzzy_prefix_length");
            generator.write(this.fuzzyPrefixLength);
        }

        if (this.fuzzyRewrite != null) {
            generator.writeKey("fuzzy_rewrite");
            generator.write(this.fuzzyRewrite);
        }

        if (this.fuzzyTranspositions != null) {
            generator.writeKey("fuzzy_transpositions");
            generator.write(this.fuzzyTranspositions);
        }

        if (this.lenient != null) {
            generator.writeKey("lenient");
            generator.write(this.lenient);
        }

        if (this.maxDeterminizedStates != null) {
            generator.writeKey("max_determinized_states");
            generator.write(this.maxDeterminizedStates);
        }

        if (this.minimumShouldMatch != null) {
            generator.writeKey("minimum_should_match");
            generator.write(this.minimumShouldMatch);
        }

        if (this.phraseSlop != null) {
            generator.writeKey("phrase_slop");
            generator.write(this.phraseSlop);
        }

        generator.writeKey("query");
        generator.write(this.query);

        if (this.quoteAnalyzer != null) {
            generator.writeKey("quote_analyzer");
            generator.write(this.quoteAnalyzer);
        }

        if (this.quoteFieldSuffix != null) {
            generator.writeKey("quote_field_suffix");
            generator.write(this.quoteFieldSuffix);
        }

        if (this.rewrite != null) {
            generator.writeKey("rewrite");
            generator.write(this.rewrite);
        }

        if (this.tieBreaker != null) {
            generator.writeKey("tie_breaker");
            generator.write(this.tieBreaker);
        }

        if (this.timeZone != null) {
            generator.writeKey("time_zone");
            generator.write(this.timeZone);
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
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
     * Builder for {@link QueryStringQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, QueryStringQuery> {
        @Nullable
        private Boolean allowLeadingWildcard;
        @Nullable
        private Boolean analyzeWildcard;
        @Nullable
        private String analyzer;
        @Nullable
        private Boolean autoGenerateSynonymsPhraseQuery;
        @Nullable
        private String defaultField;
        @Nullable
        private Operator defaultOperator;
        @Nullable
        private Boolean enablePositionIncrements;
        @Nullable
        private Boolean escape;
        @Nullable
        private List<String> fields;
        @Nullable
        private String fuzziness;
        @Nullable
        private Integer fuzzyMaxExpansions;
        @Nullable
        private Integer fuzzyPrefixLength;
        @Nullable
        private String fuzzyRewrite;
        @Nullable
        private Boolean fuzzyTranspositions;
        @Nullable
        private Boolean lenient;
        @Nullable
        private Integer maxDeterminizedStates;
        @Nullable
        private String minimumShouldMatch;
        @Nullable
        private Integer phraseSlop;
        private String query;
        @Nullable
        private String quoteAnalyzer;
        @Nullable
        private String quoteFieldSuffix;
        @Nullable
        private String rewrite;
        @Nullable
        private Float tieBreaker;
        @Nullable
        private String timeZone;
        @Nullable
        private TextQueryType type;

        public Builder() {}

        private Builder(QueryStringQuery o) {
            super(o);
            this.allowLeadingWildcard = o.allowLeadingWildcard;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.defaultField = o.defaultField;
            this.defaultOperator = o.defaultOperator;
            this.enablePositionIncrements = o.enablePositionIncrements;
            this.escape = o.escape;
            this.fields = _listCopy(o.fields);
            this.fuzziness = o.fuzziness;
            this.fuzzyMaxExpansions = o.fuzzyMaxExpansions;
            this.fuzzyPrefixLength = o.fuzzyPrefixLength;
            this.fuzzyRewrite = o.fuzzyRewrite;
            this.fuzzyTranspositions = o.fuzzyTranspositions;
            this.lenient = o.lenient;
            this.maxDeterminizedStates = o.maxDeterminizedStates;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.phraseSlop = o.phraseSlop;
            this.query = o.query;
            this.quoteAnalyzer = o.quoteAnalyzer;
            this.quoteFieldSuffix = o.quoteFieldSuffix;
            this.rewrite = o.rewrite;
            this.tieBreaker = o.tieBreaker;
            this.timeZone = o.timeZone;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.allowLeadingWildcard = o.allowLeadingWildcard;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.defaultField = o.defaultField;
            this.defaultOperator = o.defaultOperator;
            this.enablePositionIncrements = o.enablePositionIncrements;
            this.escape = o.escape;
            this.fields = _listCopy(o.fields);
            this.fuzziness = o.fuzziness;
            this.fuzzyMaxExpansions = o.fuzzyMaxExpansions;
            this.fuzzyPrefixLength = o.fuzzyPrefixLength;
            this.fuzzyRewrite = o.fuzzyRewrite;
            this.fuzzyTranspositions = o.fuzzyTranspositions;
            this.lenient = o.lenient;
            this.maxDeterminizedStates = o.maxDeterminizedStates;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.phraseSlop = o.phraseSlop;
            this.query = o.query;
            this.quoteAnalyzer = o.quoteAnalyzer;
            this.quoteFieldSuffix = o.quoteFieldSuffix;
            this.rewrite = o.rewrite;
            this.tieBreaker = o.tieBreaker;
            this.timeZone = o.timeZone;
            this.type = o.type;
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
         * If <code>true</code>, the wildcard characters <code>*</code> and <code>?</code> are allowed as the first character of the query
         * string.
         * <p>
         * API name: {@code allow_leading_wildcard}
         * </p>
         */
        @Nonnull
        public final Builder allowLeadingWildcard(@Nullable Boolean value) {
            this.allowLeadingWildcard = value;
            return this;
        }

        /**
         * If <code>true</code>, the query attempts to analyze wildcard terms in the query string.
         * <p>
         * API name: {@code analyze_wildcard}
         * </p>
         */
        @Nonnull
        public final Builder analyzeWildcard(@Nullable Boolean value) {
            this.analyzeWildcard = value;
            return this;
        }

        /**
         * Analyzer used to convert text in the query string into tokens.
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
         * If <code>true</code>, match phrase queries are automatically created for multi-term synonyms.
         * <p>
         * API name: {@code auto_generate_synonyms_phrase_query}
         * </p>
         */
        @Nonnull
        public final Builder autoGenerateSynonymsPhraseQuery(@Nullable Boolean value) {
            this.autoGenerateSynonymsPhraseQuery = value;
            return this;
        }

        /**
         * API name: {@code default_field}
         */
        @Nonnull
        public final Builder defaultField(@Nullable String value) {
            this.defaultField = value;
            return this;
        }

        /**
         * API name: {@code default_operator}
         */
        @Nonnull
        public final Builder defaultOperator(@Nullable Operator value) {
            this.defaultOperator = value;
            return this;
        }

        /**
         * If <code>true</code>, enable position increments in queries constructed from a <code>query_string</code> search.
         * <p>
         * API name: {@code enable_position_increments}
         * </p>
         */
        @Nonnull
        public final Builder enablePositionIncrements(@Nullable Boolean value) {
            this.enablePositionIncrements = value;
            return this;
        }

        /**
         * API name: {@code escape}
         */
        @Nonnull
        public final Builder escape(@Nullable Boolean value) {
            this.escape = value;
            return this;
        }

        /**
         * Array of fields to search. Supports wildcards (<code>*</code>).
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
         * Array of fields to search. Supports wildcards (<code>*</code>).
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
         * API name: {@code fuzziness}
         */
        @Nonnull
        public final Builder fuzziness(@Nullable String value) {
            this.fuzziness = value;
            return this;
        }

        /**
         * Maximum number of terms to which the query expands for fuzzy matching.
         * <p>
         * API name: {@code fuzzy_max_expansions}
         * </p>
         */
        @Nonnull
        public final Builder fuzzyMaxExpansions(@Nullable Integer value) {
            this.fuzzyMaxExpansions = value;
            return this;
        }

        /**
         * Number of beginning characters left unchanged for fuzzy matching.
         * <p>
         * API name: {@code fuzzy_prefix_length}
         * </p>
         */
        @Nonnull
        public final Builder fuzzyPrefixLength(@Nullable Integer value) {
            this.fuzzyPrefixLength = value;
            return this;
        }

        /**
         * API name: {@code fuzzy_rewrite}
         */
        @Nonnull
        public final Builder fuzzyRewrite(@Nullable String value) {
            this.fuzzyRewrite = value;
            return this;
        }

        /**
         * If <code>true</code>, edits for fuzzy matching include transpositions of two adjacent characters (for example, <code>ab</code> to
         * <code>ba</code>).
         * <p>
         * API name: {@code fuzzy_transpositions}
         * </p>
         */
        @Nonnull
        public final Builder fuzzyTranspositions(@Nullable Boolean value) {
            this.fuzzyTranspositions = value;
            return this;
        }

        /**
         * If <code>true</code>, format-based errors, such as providing a text value for a numeric field, are ignored.
         * <p>
         * API name: {@code lenient}
         * </p>
         */
        @Nonnull
        public final Builder lenient(@Nullable Boolean value) {
            this.lenient = value;
            return this;
        }

        /**
         * Maximum number of automaton states required for the query.
         * <p>
         * API name: {@code max_determinized_states}
         * </p>
         */
        @Nonnull
        public final Builder maxDeterminizedStates(@Nullable Integer value) {
            this.maxDeterminizedStates = value;
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
         * Maximum number of positions allowed between matching tokens for phrases.
         * <p>
         * API name: {@code phrase_slop}
         * </p>
         */
        @Nonnull
        public final Builder phraseSlop(@Nullable Integer value) {
            this.phraseSlop = value;
            return this;
        }

        /**
         * Required - Query string you wish to parse and use for search.
         * <p>
         * API name: {@code query}
         * </p>
         */
        @Nonnull
        public final Builder query(String value) {
            this.query = value;
            return this;
        }

        /**
         * Analyzer used to convert quoted text in the query string into tokens. For quoted text, this parameter overrides the analyzer
         * specified in the <code>analyzer</code> parameter.
         * <p>
         * API name: {@code quote_analyzer}
         * </p>
         */
        @Nonnull
        public final Builder quoteAnalyzer(@Nullable String value) {
            this.quoteAnalyzer = value;
            return this;
        }

        /**
         * Suffix appended to quoted text in the query string. You can use this suffix to use a different analysis method for exact matches.
         * <p>
         * API name: {@code quote_field_suffix}
         * </p>
         */
        @Nonnull
        public final Builder quoteFieldSuffix(@Nullable String value) {
            this.quoteFieldSuffix = value;
            return this;
        }

        /**
         * API name: {@code rewrite}
         */
        @Nonnull
        public final Builder rewrite(@Nullable String value) {
            this.rewrite = value;
            return this;
        }

        /**
         * How to combine the queries generated from the individual search terms in the resulting <code>dis_max</code> query.
         * <p>
         * API name: {@code tie_breaker}
         * </p>
         */
        @Nonnull
        public final Builder tieBreaker(@Nullable Float value) {
            this.tieBreaker = value;
            return this;
        }

        /**
         * API name: {@code time_zone}
         */
        @Nonnull
        public final Builder timeZone(@Nullable String value) {
            this.timeZone = value;
            return this;
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable TextQueryType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link QueryStringQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public QueryStringQuery build() {
            _checkSingleUse();

            return new QueryStringQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link QueryStringQuery}
     */
    public static final JsonpDeserializer<QueryStringQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        QueryStringQuery::setupQueryStringQueryDeserializer
    );

    protected static void setupQueryStringQueryDeserializer(ObjectDeserializer<QueryStringQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::allowLeadingWildcard, JsonpDeserializer.booleanDeserializer(), "allow_leading_wildcard");
        op.add(Builder::analyzeWildcard, JsonpDeserializer.booleanDeserializer(), "analyze_wildcard");
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::autoGenerateSynonymsPhraseQuery, JsonpDeserializer.booleanDeserializer(), "auto_generate_synonyms_phrase_query");
        op.add(Builder::defaultField, JsonpDeserializer.stringDeserializer(), "default_field");
        op.add(Builder::defaultOperator, Operator._DESERIALIZER, "default_operator");
        op.add(Builder::enablePositionIncrements, JsonpDeserializer.booleanDeserializer(), "enable_position_increments");
        op.add(Builder::escape, JsonpDeserializer.booleanDeserializer(), "escape");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::fuzziness, JsonpDeserializer.stringDeserializer(), "fuzziness");
        op.add(Builder::fuzzyMaxExpansions, JsonpDeserializer.integerDeserializer(), "fuzzy_max_expansions");
        op.add(Builder::fuzzyPrefixLength, JsonpDeserializer.integerDeserializer(), "fuzzy_prefix_length");
        op.add(Builder::fuzzyRewrite, JsonpDeserializer.stringDeserializer(), "fuzzy_rewrite");
        op.add(Builder::fuzzyTranspositions, JsonpDeserializer.booleanDeserializer(), "fuzzy_transpositions");
        op.add(Builder::lenient, JsonpDeserializer.booleanDeserializer(), "lenient");
        op.add(Builder::maxDeterminizedStates, JsonpDeserializer.integerDeserializer(), "max_determinized_states");
        op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
        op.add(Builder::phraseSlop, JsonpDeserializer.integerDeserializer(), "phrase_slop");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::quoteAnalyzer, JsonpDeserializer.stringDeserializer(), "quote_analyzer");
        op.add(Builder::quoteFieldSuffix, JsonpDeserializer.stringDeserializer(), "quote_field_suffix");
        op.add(Builder::rewrite, JsonpDeserializer.stringDeserializer(), "rewrite");
        op.add(Builder::tieBreaker, JsonpDeserializer.floatDeserializer(), "tie_breaker");
        op.add(Builder::timeZone, JsonpDeserializer.stringDeserializer(), "time_zone");
        op.add(Builder::type, TextQueryType._DESERIALIZER, "type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.allowLeadingWildcard);
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.autoGenerateSynonymsPhraseQuery);
        result = 31 * result + Objects.hashCode(this.defaultField);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.enablePositionIncrements);
        result = 31 * result + Objects.hashCode(this.escape);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.fuzziness);
        result = 31 * result + Objects.hashCode(this.fuzzyMaxExpansions);
        result = 31 * result + Objects.hashCode(this.fuzzyPrefixLength);
        result = 31 * result + Objects.hashCode(this.fuzzyRewrite);
        result = 31 * result + Objects.hashCode(this.fuzzyTranspositions);
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.maxDeterminizedStates);
        result = 31 * result + Objects.hashCode(this.minimumShouldMatch);
        result = 31 * result + Objects.hashCode(this.phraseSlop);
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.quoteAnalyzer);
        result = 31 * result + Objects.hashCode(this.quoteFieldSuffix);
        result = 31 * result + Objects.hashCode(this.rewrite);
        result = 31 * result + Objects.hashCode(this.tieBreaker);
        result = 31 * result + Objects.hashCode(this.timeZone);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        QueryStringQuery other = (QueryStringQuery) o;
        return Objects.equals(this.allowLeadingWildcard, other.allowLeadingWildcard)
            && Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
            && Objects.equals(this.defaultField, other.defaultField)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.enablePositionIncrements, other.enablePositionIncrements)
            && Objects.equals(this.escape, other.escape)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.fuzziness, other.fuzziness)
            && Objects.equals(this.fuzzyMaxExpansions, other.fuzzyMaxExpansions)
            && Objects.equals(this.fuzzyPrefixLength, other.fuzzyPrefixLength)
            && Objects.equals(this.fuzzyRewrite, other.fuzzyRewrite)
            && Objects.equals(this.fuzzyTranspositions, other.fuzzyTranspositions)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.maxDeterminizedStates, other.maxDeterminizedStates)
            && Objects.equals(this.minimumShouldMatch, other.minimumShouldMatch)
            && Objects.equals(this.phraseSlop, other.phraseSlop)
            && this.query.equals(other.query)
            && Objects.equals(this.quoteAnalyzer, other.quoteAnalyzer)
            && Objects.equals(this.quoteFieldSuffix, other.quoteFieldSuffix)
            && Objects.equals(this.rewrite, other.rewrite)
            && Objects.equals(this.tieBreaker, other.tieBreaker)
            && Objects.equals(this.timeZone, other.timeZone)
            && Objects.equals(this.type, other.type);
    }
}
