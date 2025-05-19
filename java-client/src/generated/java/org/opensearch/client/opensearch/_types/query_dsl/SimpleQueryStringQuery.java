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

// typedef: _types.query_dsl.SimpleQueryStringQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SimpleQueryStringQuery extends QueryBase
    implements
        QueryVariant,
        ToCopyableBuilder<SimpleQueryStringQuery.Builder, SimpleQueryStringQuery> {

    @Nullable
    private final Boolean analyzeWildcard;

    @Nullable
    private final String analyzer;

    @Nullable
    private final Boolean autoGenerateSynonymsPhraseQuery;

    @Nullable
    private final Operator defaultOperator;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final SimpleQueryStringFlags flags;

    @Nullable
    private final Integer fuzzyMaxExpansions;

    @Nullable
    private final Integer fuzzyPrefixLength;

    @Nullable
    private final Boolean fuzzyTranspositions;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final String minimumShouldMatch;

    @Nonnull
    private final String query;

    @Nullable
    private final String quoteFieldSuffix;

    // ---------------------------------------------------------------------------------------------

    private SimpleQueryStringQuery(Builder builder) {
        super(builder);
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.autoGenerateSynonymsPhraseQuery = builder.autoGenerateSynonymsPhraseQuery;
        this.defaultOperator = builder.defaultOperator;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.flags = builder.flags;
        this.fuzzyMaxExpansions = builder.fuzzyMaxExpansions;
        this.fuzzyPrefixLength = builder.fuzzyPrefixLength;
        this.fuzzyTranspositions = builder.fuzzyTranspositions;
        this.lenient = builder.lenient;
        this.minimumShouldMatch = builder.minimumShouldMatch;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.quoteFieldSuffix = builder.quoteFieldSuffix;
    }

    public static SimpleQueryStringQuery of(Function<SimpleQueryStringQuery.Builder, ObjectBuilder<SimpleQueryStringQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SimpleQueryString;
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
     * If <code>true</code>, the parser creates a <code>match_phrase</code> query for each multi-position token.
     * <p>
     * API name: {@code auto_generate_synonyms_phrase_query}
     * </p>
     */
    @Nullable
    public final Boolean autoGenerateSynonymsPhraseQuery() {
        return this.autoGenerateSynonymsPhraseQuery;
    }

    /**
     * API name: {@code default_operator}
     */
    @Nullable
    public final Operator defaultOperator() {
        return this.defaultOperator;
    }

    /**
     * Array of fields you wish to search. Accepts wildcard expressions. You also can boost relevance scores for matches to particular
     * fields using a caret (<code>^</code>) notation. Defaults to the <code>index.query.default_field index</code> setting, which has a
     * default value of <code>*</code>.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * API name: {@code flags}
     */
    @Nullable
    public final SimpleQueryStringFlags flags() {
        return this.flags;
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
     * API name: {@code minimum_should_match}
     */
    @Nullable
    public final String minimumShouldMatch() {
        return this.minimumShouldMatch;
    }

    /**
     * Required - Query string in the simple query string syntax you wish to parse and use for search.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nonnull
    public final String query() {
        return this.query;
    }

    /**
     * Suffix appended to quoted text in the query string.
     * <p>
     * API name: {@code quote_field_suffix}
     * </p>
     */
    @Nullable
    public final String quoteFieldSuffix() {
        return this.quoteFieldSuffix;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
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

        if (this.defaultOperator != null) {
            generator.writeKey("default_operator");
            this.defaultOperator.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.flags != null) {
            generator.writeKey("flags");
            this.flags.serialize(generator, mapper);
        }

        if (this.fuzzyMaxExpansions != null) {
            generator.writeKey("fuzzy_max_expansions");
            generator.write(this.fuzzyMaxExpansions);
        }

        if (this.fuzzyPrefixLength != null) {
            generator.writeKey("fuzzy_prefix_length");
            generator.write(this.fuzzyPrefixLength);
        }

        if (this.fuzzyTranspositions != null) {
            generator.writeKey("fuzzy_transpositions");
            generator.write(this.fuzzyTranspositions);
        }

        if (this.lenient != null) {
            generator.writeKey("lenient");
            generator.write(this.lenient);
        }

        if (this.minimumShouldMatch != null) {
            generator.writeKey("minimum_should_match");
            generator.write(this.minimumShouldMatch);
        }

        generator.writeKey("query");
        generator.write(this.query);

        if (this.quoteFieldSuffix != null) {
            generator.writeKey("quote_field_suffix");
            generator.write(this.quoteFieldSuffix);
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
     * Builder for {@link SimpleQueryStringQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SimpleQueryStringQuery> {
        @Nullable
        private Boolean analyzeWildcard;
        @Nullable
        private String analyzer;
        @Nullable
        private Boolean autoGenerateSynonymsPhraseQuery;
        @Nullable
        private Operator defaultOperator;
        @Nullable
        private List<String> fields;
        @Nullable
        private SimpleQueryStringFlags flags;
        @Nullable
        private Integer fuzzyMaxExpansions;
        @Nullable
        private Integer fuzzyPrefixLength;
        @Nullable
        private Boolean fuzzyTranspositions;
        @Nullable
        private Boolean lenient;
        @Nullable
        private String minimumShouldMatch;
        private String query;
        @Nullable
        private String quoteFieldSuffix;

        public Builder() {}

        private Builder(SimpleQueryStringQuery o) {
            super(o);
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.defaultOperator = o.defaultOperator;
            this.fields = _listCopy(o.fields);
            this.flags = o.flags;
            this.fuzzyMaxExpansions = o.fuzzyMaxExpansions;
            this.fuzzyPrefixLength = o.fuzzyPrefixLength;
            this.fuzzyTranspositions = o.fuzzyTranspositions;
            this.lenient = o.lenient;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.query = o.query;
            this.quoteFieldSuffix = o.quoteFieldSuffix;
        }

        private Builder(Builder o) {
            super(o);
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.defaultOperator = o.defaultOperator;
            this.fields = _listCopy(o.fields);
            this.flags = o.flags;
            this.fuzzyMaxExpansions = o.fuzzyMaxExpansions;
            this.fuzzyPrefixLength = o.fuzzyPrefixLength;
            this.fuzzyTranspositions = o.fuzzyTranspositions;
            this.lenient = o.lenient;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.query = o.query;
            this.quoteFieldSuffix = o.quoteFieldSuffix;
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
         * If <code>true</code>, the parser creates a <code>match_phrase</code> query for each multi-position token.
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
         * API name: {@code default_operator}
         */
        @Nonnull
        public final Builder defaultOperator(@Nullable Operator value) {
            this.defaultOperator = value;
            return this;
        }

        /**
         * Array of fields you wish to search. Accepts wildcard expressions. You also can boost relevance scores for matches to particular
         * fields using a caret (<code>^</code>) notation. Defaults to the <code>index.query.default_field index</code> setting, which has a
         * default value of <code>*</code>.
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
         * Array of fields you wish to search. Accepts wildcard expressions. You also can boost relevance scores for matches to particular
         * fields using a caret (<code>^</code>) notation. Defaults to the <code>index.query.default_field index</code> setting, which has a
         * default value of <code>*</code>.
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
         * API name: {@code flags}
         */
        @Nonnull
        public final Builder flags(@Nullable SimpleQueryStringFlags value) {
            this.flags = value;
            return this;
        }

        /**
         * API name: {@code flags}
         */
        @Nonnull
        public final Builder flags(Function<SimpleQueryStringFlags.Builder, ObjectBuilder<SimpleQueryStringFlags>> fn) {
            return flags(fn.apply(new SimpleQueryStringFlags.Builder()).build());
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
         * API name: {@code minimum_should_match}
         */
        @Nonnull
        public final Builder minimumShouldMatch(@Nullable String value) {
            this.minimumShouldMatch = value;
            return this;
        }

        /**
         * Required - Query string in the simple query string syntax you wish to parse and use for search.
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
         * Suffix appended to quoted text in the query string.
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
         * Builds a {@link SimpleQueryStringQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SimpleQueryStringQuery build() {
            _checkSingleUse();

            return new SimpleQueryStringQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SimpleQueryStringQuery}
     */
    public static final JsonpDeserializer<SimpleQueryStringQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SimpleQueryStringQuery::setupSimpleQueryStringQueryDeserializer
    );

    protected static void setupSimpleQueryStringQueryDeserializer(ObjectDeserializer<SimpleQueryStringQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::analyzeWildcard, JsonpDeserializer.booleanDeserializer(), "analyze_wildcard");
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::autoGenerateSynonymsPhraseQuery, JsonpDeserializer.booleanDeserializer(), "auto_generate_synonyms_phrase_query");
        op.add(Builder::defaultOperator, Operator._DESERIALIZER, "default_operator");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::flags, SimpleQueryStringFlags._DESERIALIZER, "flags");
        op.add(Builder::fuzzyMaxExpansions, JsonpDeserializer.integerDeserializer(), "fuzzy_max_expansions");
        op.add(Builder::fuzzyPrefixLength, JsonpDeserializer.integerDeserializer(), "fuzzy_prefix_length");
        op.add(Builder::fuzzyTranspositions, JsonpDeserializer.booleanDeserializer(), "fuzzy_transpositions");
        op.add(Builder::lenient, JsonpDeserializer.booleanDeserializer(), "lenient");
        op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::quoteFieldSuffix, JsonpDeserializer.stringDeserializer(), "quote_field_suffix");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.autoGenerateSynonymsPhraseQuery);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.flags);
        result = 31 * result + Objects.hashCode(this.fuzzyMaxExpansions);
        result = 31 * result + Objects.hashCode(this.fuzzyPrefixLength);
        result = 31 * result + Objects.hashCode(this.fuzzyTranspositions);
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.minimumShouldMatch);
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.quoteFieldSuffix);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SimpleQueryStringQuery other = (SimpleQueryStringQuery) o;
        return Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.flags, other.flags)
            && Objects.equals(this.fuzzyMaxExpansions, other.fuzzyMaxExpansions)
            && Objects.equals(this.fuzzyPrefixLength, other.fuzzyPrefixLength)
            && Objects.equals(this.fuzzyTranspositions, other.fuzzyTranspositions)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.minimumShouldMatch, other.minimumShouldMatch)
            && this.query.equals(other.query)
            && Objects.equals(this.quoteFieldSuffix, other.quoteFieldSuffix);
    }
}
