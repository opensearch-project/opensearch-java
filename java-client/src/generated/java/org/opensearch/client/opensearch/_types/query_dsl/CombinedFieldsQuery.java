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

// typedef: _types.query_dsl.CombinedFieldsQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CombinedFieldsQuery extends QueryBase
    implements
        QueryVariant,
        ToCopyableBuilder<CombinedFieldsQuery.Builder, CombinedFieldsQuery> {

    @Nullable
    private final Boolean autoGenerateSynonymsPhraseQuery;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final String minimumShouldMatch;

    @Nullable
    private final CombinedFieldsOperator operator;

    @Nonnull
    private final String query;

    @Nullable
    private final CombinedFieldsZeroTerms zeroTermsQuery;

    // ---------------------------------------------------------------------------------------------

    private CombinedFieldsQuery(Builder builder) {
        super(builder);
        this.autoGenerateSynonymsPhraseQuery = builder.autoGenerateSynonymsPhraseQuery;
        this.fields = ApiTypeHelper.unmodifiableRequired(builder.fields, this, "fields");
        this.minimumShouldMatch = builder.minimumShouldMatch;
        this.operator = builder.operator;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.zeroTermsQuery = builder.zeroTermsQuery;
    }

    public static CombinedFieldsQuery of(Function<CombinedFieldsQuery.Builder, ObjectBuilder<CombinedFieldsQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.CombinedFields;
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
     * Required - List of fields to search. Field wildcard patterns are allowed. Only <code>text</code> fields are supported, and they must
     * all have the same search <code>analyzer</code>.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
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
    public final CombinedFieldsOperator operator() {
        return this.operator;
    }

    /**
     * Required - Text to search for in the provided <code>fields</code>. The <code>combined_fields</code> query analyzes the provided text
     * before performing a search.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nonnull
    public final String query() {
        return this.query;
    }

    /**
     * API name: {@code zero_terms_query}
     */
    @Nullable
    public final CombinedFieldsZeroTerms zeroTermsQuery() {
        return this.zeroTermsQuery;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.autoGenerateSynonymsPhraseQuery != null) {
            generator.writeKey("auto_generate_synonyms_phrase_query");
            generator.write(this.autoGenerateSynonymsPhraseQuery);
        }

        generator.writeKey("fields");
        generator.writeStartArray();
        for (String item0 : this.fields) {
            generator.write(item0);
        }
        generator.writeEnd();

        if (this.minimumShouldMatch != null) {
            generator.writeKey("minimum_should_match");
            generator.write(this.minimumShouldMatch);
        }

        if (this.operator != null) {
            generator.writeKey("operator");
            this.operator.serialize(generator, mapper);
        }

        generator.writeKey("query");
        generator.write(this.query);

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
     * Builder for {@link CombinedFieldsQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CombinedFieldsQuery> {
        @Nullable
        private Boolean autoGenerateSynonymsPhraseQuery;
        private List<String> fields;
        @Nullable
        private String minimumShouldMatch;
        @Nullable
        private CombinedFieldsOperator operator;
        private String query;
        @Nullable
        private CombinedFieldsZeroTerms zeroTermsQuery;

        public Builder() {}

        private Builder(CombinedFieldsQuery o) {
            super(o);
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.fields = _listCopy(o.fields);
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.operator = o.operator;
            this.query = o.query;
            this.zeroTermsQuery = o.zeroTermsQuery;
        }

        private Builder(Builder o) {
            super(o);
            this.autoGenerateSynonymsPhraseQuery = o.autoGenerateSynonymsPhraseQuery;
            this.fields = _listCopy(o.fields);
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.operator = o.operator;
            this.query = o.query;
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
         * Required - List of fields to search. Field wildcard patterns are allowed. Only <code>text</code> fields are supported, and they
         * must all have the same search <code>analyzer</code>.
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
         * Required - List of fields to search. Field wildcard patterns are allowed. Only <code>text</code> fields are supported, and they
         * must all have the same search <code>analyzer</code>.
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
        public final Builder operator(@Nullable CombinedFieldsOperator value) {
            this.operator = value;
            return this;
        }

        /**
         * Required - Text to search for in the provided <code>fields</code>. The <code>combined_fields</code> query analyzes the provided
         * text before performing a search.
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
         * API name: {@code zero_terms_query}
         */
        @Nonnull
        public final Builder zeroTermsQuery(@Nullable CombinedFieldsZeroTerms value) {
            this.zeroTermsQuery = value;
            return this;
        }

        /**
         * Builds a {@link CombinedFieldsQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CombinedFieldsQuery build() {
            _checkSingleUse();

            return new CombinedFieldsQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CombinedFieldsQuery}
     */
    public static final JsonpDeserializer<CombinedFieldsQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CombinedFieldsQuery::setupCombinedFieldsQueryDeserializer
    );

    protected static void setupCombinedFieldsQueryDeserializer(ObjectDeserializer<CombinedFieldsQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::autoGenerateSynonymsPhraseQuery, JsonpDeserializer.booleanDeserializer(), "auto_generate_synonyms_phrase_query");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "fields");
        op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
        op.add(Builder::operator, CombinedFieldsOperator._DESERIALIZER, "operator");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::zeroTermsQuery, CombinedFieldsZeroTerms._DESERIALIZER, "zero_terms_query");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.autoGenerateSynonymsPhraseQuery);
        result = 31 * result + this.fields.hashCode();
        result = 31 * result + Objects.hashCode(this.minimumShouldMatch);
        result = 31 * result + Objects.hashCode(this.operator);
        result = 31 * result + this.query.hashCode();
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
        CombinedFieldsQuery other = (CombinedFieldsQuery) o;
        return Objects.equals(this.autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
            && this.fields.equals(other.fields)
            && Objects.equals(this.minimumShouldMatch, other.minimumShouldMatch)
            && Objects.equals(this.operator, other.operator)
            && this.query.equals(other.query)
            && Objects.equals(this.zeroTermsQuery, other.zeroTermsQuery);
    }
}
