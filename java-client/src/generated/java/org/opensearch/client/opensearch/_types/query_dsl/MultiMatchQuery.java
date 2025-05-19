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

// typedef: _types.query_dsl.MultiMatchQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MultiMatchQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<MultiMatchQuery.Builder, MultiMatchQuery> {

    @Nullable
    private final String analyzer;

    @Nullable
    private final Boolean autoGenerateSynonymsPhraseQuery;

    @Nullable
    private final Float cutoffFrequency;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final String fuzziness;

    @Nullable
    private final String fuzzyRewrite;

    @Nullable
    private final Boolean fuzzyTranspositions;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final Integer maxExpansions;

    @Nullable
    private final String minimumShouldMatch;

    @Nullable
    private final Operator operator;

    @Nullable
    private final Integer prefixLength;

    @Nonnull
    private final String query;

    @Nullable
    private final Integer slop;

    @Nullable
    private final Float tieBreaker;

    @Nullable
    private final TextQueryType type;

    @Nullable
    private final ZeroTermsQuery zeroTermsQuery;

    // ---------------------------------------------------------------------------------------------

    private MultiMatchQuery(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.autoGenerateSynonymsPhraseQuery = builder.autoGenerateSynonymsPhraseQuery;
        this.cutoffFrequency = builder.cutoffFrequency;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.fuzziness = builder.fuzziness;
        this.fuzzyRewrite = builder.fuzzyRewrite;
        this.fuzzyTranspositions = builder.fuzzyTranspositions;
        this.lenient = builder.lenient;
        this.maxExpansions = builder.maxExpansions;
        this.minimumShouldMatch = builder.minimumShouldMatch;
        this.operator = builder.operator;
        this.prefixLength = builder.prefixLength;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.slop = builder.slop;
        this.tieBreaker = builder.tieBreaker;
        this.type = builder.type;
        this.zeroTermsQuery = builder.zeroTermsQuery;
    }

    public static MultiMatchQuery of(Function<MultiMatchQuery.Builder, ObjectBuilder<MultiMatchQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.MultiMatch;
    }

    /**
     * Analyzer used to convert the text in the query value into tokens.
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
     * API name: {@code cutoff_frequency}
     */
    @Nullable
    public final Float cutoffFrequency() {
        return this.cutoffFrequency;
    }

    /**
     * API name: {@code fields}
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
     * API name: {@code fuzzy_rewrite}
     */
    @Nullable
    public final String fuzzyRewrite() {
        return this.fuzzyRewrite;
    }

    /**
     * If <code>true</code>, edits for fuzzy matching include transpositions of two adjacent characters (for example, <code>ab</code> to
     * <code>ba</code>). Can be applied to the term subqueries constructed for all terms but the final term.
     * <p>
     * API name: {@code fuzzy_transpositions}
     * </p>
     */
    @Nullable
    public final Boolean fuzzyTranspositions() {
        return this.fuzzyTranspositions;
    }

    /**
     * If <code>true</code>, format-based errors, such as providing a text query value for a numeric field, are ignored.
     * <p>
     * API name: {@code lenient}
     * </p>
     */
    @Nullable
    public final Boolean lenient() {
        return this.lenient;
    }

    /**
     * Maximum number of terms to which the query will expand.
     * <p>
     * API name: {@code max_expansions}
     * </p>
     */
    @Nullable
    public final Integer maxExpansions() {
        return this.maxExpansions;
    }

    /**
     * API name: {@code minimum_should_match}
     */
    @Nullable
    public final String minimumShouldMatch() {
        return this.minimumShouldMatch;
    }

    /**
     * API name: {@code operator}
     */
    @Nullable
    public final Operator operator() {
        return this.operator;
    }

    /**
     * Number of beginning characters left unchanged for fuzzy matching.
     * <p>
     * API name: {@code prefix_length}
     * </p>
     */
    @Nullable
    public final Integer prefixLength() {
        return this.prefixLength;
    }

    /**
     * Required - Text, number, Boolean value or date you wish to find in the provided field.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nonnull
    public final String query() {
        return this.query;
    }

    /**
     * Maximum number of positions allowed between matching tokens.
     * <p>
     * API name: {@code slop}
     * </p>
     */
    @Nullable
    public final Integer slop() {
        return this.slop;
    }

    /**
     * Determines how scores for each per-term blended query and scores across groups are combined.
     * <p>
     * API name: {@code tie_breaker}
     * </p>
     */
    @Nullable
    public final Float tieBreaker() {
        return this.tieBreaker;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final TextQueryType type() {
        return this.type;
    }

    /**
     * API name: {@code zero_terms_query}
     */
    @Nullable
    public final ZeroTermsQuery zeroTermsQuery() {
        return this.zeroTermsQuery;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        if (this.autoGenerateSynonymsPhraseQuery != null) {
            generator.writeKey("auto_generate_synonyms_phrase_query");
            generator.write(this.autoGenerateSynonymsPhraseQuery);
        }

        if (this.cutoffFrequency != null) {
            generator.writeKey("cutoff_frequency");
            generator.write(this.cutoffFrequency);
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

        if (this.maxExpansions != null) {
            generator.writeKey("max_expansions");
            generator.write(this.maxExpansions);
        }

        if (this.minimumShouldMatch != null) {
            generator.writeKey("minimum_should_match");
            generator.write(this.minimumShouldMatch);
        }

        if (this.operator != null) {
            generator.writeKey("operator");
            this.operator.serialize(generator, mapper);
        }

        if (this.prefixLength != null) {
            generator.writeKey("prefix_length");
            generator.write(this.prefixLength);
        }

        generator.writeKey("query");
        generator.write(this.query);

        if (this.slop != null) {
            generator.writeKey("slop");
            generator.write(this.slop);
        }

        if (this.tieBreaker != null) {
            generator.writeKey("tie_breaker");
            generator.write(this.tieBreaker);
        }

        if (this.type != null) {
            generator.writeKey("type");
            this.type.serialize(generator, mapper);
        }

        if (this.zeroTermsQuery != null) {
            generator.writeKey("zero_terms_query");
            this.zeroTermsQuery.serialize(generator, mapper);
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
     * Builder for {@link MultiMatchQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, MultiMatchQuery> {
        @Nullable
        private String analyzer;
        @Nullable
        private Boolean autoGenerateSynonymsPhraseQuery;
        @Nullable
        private Float cutoffFrequency;
        @Nullable
        private List<String> fields;
        @Nullable
        private String fuzziness;
        @Nullable
        private String fuzzyRewrite;
        @Nullable
        private Boolean fuzzyTranspositions;
        @Nullable
        private Boolean lenient;
        @Nullable
        private Integer maxExpansions;
        @Nullable
        private String minimumShouldMatch;
        @Nullable
        private Operator operator;
        @Nullable
        private Integer prefixLength;
        private String query;
        @Nullable
        private Integer slop;
        @Nullable
        private Float tieBreaker;
        @Nullable
        private TextQueryType type;
        @Nullable
        private ZeroTermsQuery zeroTermsQuery;

        public Builder() {}

        private Builder(MultiMatchQuery o) {
            super(o);
            this.analyzer = o.analyzer;
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.cutoffFrequency = o.cutoffFrequency;
            this.fields = _listCopy(o.fields);
            this.fuzziness = o.fuzziness;
            this.fuzzyRewrite = o.fuzzyRewrite;
            this.fuzzyTranspositions = o.fuzzyTranspositions;
            this.lenient = o.lenient;
            this.maxExpansions = o.maxExpansions;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.operator = o.operator;
            this.prefixLength = o.prefixLength;
            this.query = o.query;
            this.slop = o.slop;
            this.tieBreaker = o.tieBreaker;
            this.type = o.type;
            this.zeroTermsQuery = o.zeroTermsQuery;
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.cutoffFrequency = o.cutoffFrequency;
            this.fields = _listCopy(o.fields);
            this.fuzziness = o.fuzziness;
            this.fuzzyRewrite = o.fuzzyRewrite;
            this.fuzzyTranspositions = o.fuzzyTranspositions;
            this.lenient = o.lenient;
            this.maxExpansions = o.maxExpansions;
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.operator = o.operator;
            this.prefixLength = o.prefixLength;
            this.query = o.query;
            this.slop = o.slop;
            this.tieBreaker = o.tieBreaker;
            this.type = o.type;
            this.zeroTermsQuery = o.zeroTermsQuery;
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
         * Analyzer used to convert the text in the query value into tokens.
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
         * API name: {@code cutoff_frequency}
         */
        @Nonnull
        public final Builder cutoffFrequency(@Nullable Float value) {
            this.cutoffFrequency = value;
            return this;
        }

        /**
         * API name: {@code fields}
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
         * API name: {@code fields}
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
         * API name: {@code fuzzy_rewrite}
         */
        @Nonnull
        public final Builder fuzzyRewrite(@Nullable String value) {
            this.fuzzyRewrite = value;
            return this;
        }

        /**
         * If <code>true</code>, edits for fuzzy matching include transpositions of two adjacent characters (for example, <code>ab</code> to
         * <code>ba</code>). Can be applied to the term subqueries constructed for all terms but the final term.
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
         * If <code>true</code>, format-based errors, such as providing a text query value for a numeric field, are ignored.
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
         * Maximum number of terms to which the query will expand.
         * <p>
         * API name: {@code max_expansions}
         * </p>
         */
        @Nonnull
        public final Builder maxExpansions(@Nullable Integer value) {
            this.maxExpansions = value;
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
         * API name: {@code operator}
         */
        @Nonnull
        public final Builder operator(@Nullable Operator value) {
            this.operator = value;
            return this;
        }

        /**
         * Number of beginning characters left unchanged for fuzzy matching.
         * <p>
         * API name: {@code prefix_length}
         * </p>
         */
        @Nonnull
        public final Builder prefixLength(@Nullable Integer value) {
            this.prefixLength = value;
            return this;
        }

        /**
         * Required - Text, number, Boolean value or date you wish to find in the provided field.
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
         * Maximum number of positions allowed between matching tokens.
         * <p>
         * API name: {@code slop}
         * </p>
         */
        @Nonnull
        public final Builder slop(@Nullable Integer value) {
            this.slop = value;
            return this;
        }

        /**
         * Determines how scores for each per-term blended query and scores across groups are combined.
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
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable TextQueryType value) {
            this.type = value;
            return this;
        }

        /**
         * API name: {@code zero_terms_query}
         */
        @Nonnull
        public final Builder zeroTermsQuery(@Nullable ZeroTermsQuery value) {
            this.zeroTermsQuery = value;
            return this;
        }

        /**
         * Builds a {@link MultiMatchQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MultiMatchQuery build() {
            _checkSingleUse();

            return new MultiMatchQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MultiMatchQuery}
     */
    public static final JsonpDeserializer<MultiMatchQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MultiMatchQuery::setupMultiMatchQueryDeserializer
    );

    protected static void setupMultiMatchQueryDeserializer(ObjectDeserializer<MultiMatchQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::autoGenerateSynonymsPhraseQuery, JsonpDeserializer.booleanDeserializer(), "auto_generate_synonyms_phrase_query");
        op.add(Builder::cutoffFrequency, JsonpDeserializer.floatDeserializer(), "cutoff_frequency");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::fuzziness, JsonpDeserializer.stringDeserializer(), "fuzziness");
        op.add(Builder::fuzzyRewrite, JsonpDeserializer.stringDeserializer(), "fuzzy_rewrite");
        op.add(Builder::fuzzyTranspositions, JsonpDeserializer.booleanDeserializer(), "fuzzy_transpositions");
        op.add(Builder::lenient, JsonpDeserializer.booleanDeserializer(), "lenient");
        op.add(Builder::maxExpansions, JsonpDeserializer.integerDeserializer(), "max_expansions");
        op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
        op.add(Builder::operator, Operator._DESERIALIZER, "operator");
        op.add(Builder::prefixLength, JsonpDeserializer.integerDeserializer(), "prefix_length");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::slop, JsonpDeserializer.integerDeserializer(), "slop");
        op.add(Builder::tieBreaker, JsonpDeserializer.floatDeserializer(), "tie_breaker");
        op.add(Builder::type, TextQueryType._DESERIALIZER, "type");
        op.add(Builder::zeroTermsQuery, ZeroTermsQuery._DESERIALIZER, "zero_terms_query");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.autoGenerateSynonymsPhraseQuery);
        result = 31 * result + Objects.hashCode(this.cutoffFrequency);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.fuzziness);
        result = 31 * result + Objects.hashCode(this.fuzzyRewrite);
        result = 31 * result + Objects.hashCode(this.fuzzyTranspositions);
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.maxExpansions);
        result = 31 * result + Objects.hashCode(this.minimumShouldMatch);
        result = 31 * result + Objects.hashCode(this.operator);
        result = 31 * result + Objects.hashCode(this.prefixLength);
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.slop);
        result = 31 * result + Objects.hashCode(this.tieBreaker);
        result = 31 * result + Objects.hashCode(this.type);
        result = 31 * result + Objects.hashCode(this.zeroTermsQuery);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiMatchQuery other = (MultiMatchQuery) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
            && Objects.equals(this.cutoffFrequency, other.cutoffFrequency)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.fuzziness, other.fuzziness)
            && Objects.equals(this.fuzzyRewrite, other.fuzzyRewrite)
            && Objects.equals(this.fuzzyTranspositions, other.fuzzyTranspositions)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.maxExpansions, other.maxExpansions)
            && Objects.equals(this.minimumShouldMatch, other.minimumShouldMatch)
            && Objects.equals(this.operator, other.operator)
            && Objects.equals(this.prefixLength, other.prefixLength)
            && this.query.equals(other.query)
            && Objects.equals(this.slop, other.slop)
            && Objects.equals(this.tieBreaker, other.tieBreaker)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.zeroTermsQuery, other.zeroTermsQuery);
    }
}
