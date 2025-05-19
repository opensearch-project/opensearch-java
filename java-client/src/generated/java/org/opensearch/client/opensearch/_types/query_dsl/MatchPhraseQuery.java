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

// typedef: _types.query_dsl.MatchPhraseQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MatchPhraseQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<MatchPhraseQuery.Builder, MatchPhraseQuery> {

    @Nullable
    private final String analyzer;

    @Nonnull
    private final String field;

    @Nonnull
    private final String query;

    @Nullable
    private final Integer slop;

    @Nullable
    private final ZeroTermsQuery zeroTermsQuery;

    // ---------------------------------------------------------------------------------------------

    private MatchPhraseQuery(Builder builder) {
        super(builder);
        this.analyzer = builder.analyzer;
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.slop = builder.slop;
        this.zeroTermsQuery = builder.zeroTermsQuery;
    }

    public static MatchPhraseQuery of(Function<MatchPhraseQuery.Builder, ObjectBuilder<MatchPhraseQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.MatchPhrase;
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
     * Required - The target field
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - Query terms that are analyzed and turned into a phrase query.
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
     * API name: {@code zero_terms_query}
     */
    @Nullable
    public final ZeroTermsQuery zeroTermsQuery() {
        return this.zeroTermsQuery;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject(this.field);
        super.serializeInternal(generator, mapper);
        if (this.analyzer != null) {
            generator.writeKey("analyzer");
            generator.write(this.analyzer);
        }

        generator.writeKey("query");
        generator.write(this.query);

        if (this.slop != null) {
            generator.writeKey("slop");
            generator.write(this.slop);
        }

        if (this.zeroTermsQuery != null) {
            generator.writeKey("zero_terms_query");
            this.zeroTermsQuery.serialize(generator, mapper);
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
     * Builder for {@link MatchPhraseQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, MatchPhraseQuery> {
        @Nullable
        private String analyzer;
        private String field;
        private String query;
        @Nullable
        private Integer slop;
        @Nullable
        private ZeroTermsQuery zeroTermsQuery;

        public Builder() {}

        private Builder(MatchPhraseQuery o) {
            super(o);
            this.analyzer = o.analyzer;
            this.field = o.field;
            this.query = o.query;
            this.slop = o.slop;
            this.zeroTermsQuery = o.zeroTermsQuery;
        }

        private Builder(Builder o) {
            super(o);
            this.analyzer = o.analyzer;
            this.field = o.field;
            this.query = o.query;
            this.slop = o.slop;
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
         * Required - The target field
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - Query terms that are analyzed and turned into a phrase query.
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
         * API name: {@code zero_terms_query}
         */
        @Nonnull
        public final Builder zeroTermsQuery(@Nullable ZeroTermsQuery value) {
            this.zeroTermsQuery = value;
            return this;
        }

        /**
         * Builds a {@link MatchPhraseQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MatchPhraseQuery build() {
            _checkSingleUse();

            return new MatchPhraseQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MatchPhraseQuery}
     */
    public static final JsonpDeserializer<MatchPhraseQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MatchPhraseQuery::setupMatchPhraseQueryDeserializer
    );

    protected static void setupMatchPhraseQueryDeserializer(ObjectDeserializer<MatchPhraseQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::analyzer, JsonpDeserializer.stringDeserializer(), "analyzer");
        op.add(Builder::query, JsonpDeserializer.stringDeserializer(), "query");
        op.add(Builder::slop, JsonpDeserializer.integerDeserializer(), "slop");
        op.add(Builder::zeroTermsQuery, ZeroTermsQuery._DESERIALIZER, "zero_terms_query");
        op.setKey(Builder::field, JsonpDeserializer.stringDeserializer());

        op.shortcutProperty("query");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.slop);
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
        MatchPhraseQuery other = (MatchPhraseQuery) o;
        return Objects.equals(this.analyzer, other.analyzer)
            && this.field.equals(other.field)
            && this.query.equals(other.query)
            && Objects.equals(this.slop, other.slop)
            && Objects.equals(this.zeroTermsQuery, other.zeroTermsQuery);
    }
}
