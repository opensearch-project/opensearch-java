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

// typedef: _types.query_dsl.BoolQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BoolQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<BoolQuery.Builder, BoolQuery> {

    @Nullable
    private final Boolean adjustPureNegative;

    @Nonnull
    private final List<Query> filter;

    @Nullable
    private final String minimumShouldMatch;

    @Nonnull
    private final List<Query> must;

    @Nonnull
    private final List<Query> mustNot;

    @Nonnull
    private final List<Query> should;

    // ---------------------------------------------------------------------------------------------

    private BoolQuery(Builder builder) {
        super(builder);
        this.adjustPureNegative = builder.adjustPureNegative;
        this.filter = ApiTypeHelper.unmodifiable(builder.filter);
        this.minimumShouldMatch = builder.minimumShouldMatch;
        this.must = ApiTypeHelper.unmodifiable(builder.must);
        this.mustNot = ApiTypeHelper.unmodifiable(builder.mustNot);
        this.should = ApiTypeHelper.unmodifiable(builder.should);
    }

    public static BoolQuery of(Function<BoolQuery.Builder, ObjectBuilder<BoolQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Bool;
    }

    /**
     * Ensures correct behavior when a query contains only <code>must_not</code> clauses. By default set to true, OpenSearch adds a
     * match-all clause to ensure results are returned from Lucene, with the <code>must_not</code> conditions applied as filters. If set to
     * false, the query may return no results, as Lucene typically requires at least one positive condition.
     * <p>
     * API name: {@code adjust_pure_negative}
     * </p>
     */
    @Nullable
    public final Boolean adjustPureNegative() {
        return this.adjustPureNegative;
    }

    /**
     * The clause (query) must appear in matching documents. However, unlike <code>must</code>, the score of the query will be ignored.
     * <p>
     * API name: {@code filter}
     * </p>
     */
    @Nonnull
    public final List<Query> filter() {
        return this.filter;
    }

    /**
     * API name: {@code minimum_should_match}
     */
    @Nullable
    public final String minimumShouldMatch() {
        return this.minimumShouldMatch;
    }

    /**
     * The clause (query) must appear in matching documents and will contribute to the score.
     * <p>
     * API name: {@code must}
     * </p>
     */
    @Nonnull
    public final List<Query> must() {
        return this.must;
    }

    /**
     * The clause (query) must not appear in the matching documents. Because scoring is ignored, a score of <code>0</code> is returned for
     * all documents.
     * <p>
     * API name: {@code must_not}
     * </p>
     */
    @Nonnull
    public final List<Query> mustNot() {
        return this.mustNot;
    }

    /**
     * The clause (query) should appear in the matching document.
     * <p>
     * API name: {@code should}
     * </p>
     */
    @Nonnull
    public final List<Query> should() {
        return this.should;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.adjustPureNegative != null) {
            generator.writeKey("adjust_pure_negative");
            generator.write(this.adjustPureNegative);
        }

        if (ApiTypeHelper.isDefined(this.filter)) {
            generator.writeKey("filter");
            generator.writeStartArray();
            for (Query item0 : this.filter) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.minimumShouldMatch != null) {
            generator.writeKey("minimum_should_match");
            generator.write(this.minimumShouldMatch);
        }

        if (ApiTypeHelper.isDefined(this.must)) {
            generator.writeKey("must");
            generator.writeStartArray();
            for (Query item0 : this.must) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.mustNot)) {
            generator.writeKey("must_not");
            generator.writeStartArray();
            for (Query item0 : this.mustNot) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.should)) {
            generator.writeKey("should");
            generator.writeStartArray();
            for (Query item0 : this.should) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link BoolQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, BoolQuery> {
        @Nullable
        private Boolean adjustPureNegative;
        @Nullable
        private List<Query> filter;
        @Nullable
        private String minimumShouldMatch;
        @Nullable
        private List<Query> must;
        @Nullable
        private List<Query> mustNot;
        @Nullable
        private List<Query> should;

        public Builder() {}

        private Builder(BoolQuery o) {
            super(o);
            this.adjustPureNegative = o.adjustPureNegative;
            this.filter = _listCopy(o.filter);
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.must = _listCopy(o.must);
            this.mustNot = _listCopy(o.mustNot);
            this.should = _listCopy(o.should);
        }

        private Builder(Builder o) {
            super(o);
            this.adjustPureNegative = o.adjustPureNegative;
            this.filter = _listCopy(o.filter);
            this.minimumShouldMatch = o.minimumShouldMatch;
            this.must = _listCopy(o.must);
            this.mustNot = _listCopy(o.mustNot);
            this.should = _listCopy(o.should);
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
         * Ensures correct behavior when a query contains only <code>must_not</code> clauses. By default set to true, OpenSearch adds a
         * match-all clause to ensure results are returned from Lucene, with the <code>must_not</code> conditions applied as filters. If set
         * to false, the query may return no results, as Lucene typically requires at least one positive condition.
         * <p>
         * API name: {@code adjust_pure_negative}
         * </p>
         */
        @Nonnull
        public final Builder adjustPureNegative(@Nullable Boolean value) {
            this.adjustPureNegative = value;
            return this;
        }

        /**
         * The clause (query) must appear in matching documents. However, unlike <code>must</code>, the score of the query will be ignored.
         * <p>
         * API name: {@code filter}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>filter</code>.
         * </p>
         */
        @Nonnull
        public final Builder filter(List<Query> list) {
            this.filter = _listAddAll(this.filter, list);
            return this;
        }

        /**
         * The clause (query) must appear in matching documents. However, unlike <code>must</code>, the score of the query will be ignored.
         * <p>
         * API name: {@code filter}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>filter</code>.
         * </p>
         */
        @Nonnull
        public final Builder filter(Query value, Query... values) {
            this.filter = _listAdd(this.filter, value, values);
            return this;
        }

        /**
         * The clause (query) must appear in matching documents. However, unlike <code>must</code>, the score of the query will be ignored.
         * <p>
         * API name: {@code filter}
         * </p>
         *
         * <p>
         * Adds a value to <code>filter</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filter(fn.apply(new Query.Builder()).build());
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
         * The clause (query) must appear in matching documents and will contribute to the score.
         * <p>
         * API name: {@code must}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>must</code>.
         * </p>
         */
        @Nonnull
        public final Builder must(List<Query> list) {
            this.must = _listAddAll(this.must, list);
            return this;
        }

        /**
         * The clause (query) must appear in matching documents and will contribute to the score.
         * <p>
         * API name: {@code must}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>must</code>.
         * </p>
         */
        @Nonnull
        public final Builder must(Query value, Query... values) {
            this.must = _listAdd(this.must, value, values);
            return this;
        }

        /**
         * The clause (query) must appear in matching documents and will contribute to the score.
         * <p>
         * API name: {@code must}
         * </p>
         *
         * <p>
         * Adds a value to <code>must</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder must(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return must(fn.apply(new Query.Builder()).build());
        }

        /**
         * The clause (query) must not appear in the matching documents. Because scoring is ignored, a score of <code>0</code> is returned
         * for all documents.
         * <p>
         * API name: {@code must_not}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>mustNot</code>.
         * </p>
         */
        @Nonnull
        public final Builder mustNot(List<Query> list) {
            this.mustNot = _listAddAll(this.mustNot, list);
            return this;
        }

        /**
         * The clause (query) must not appear in the matching documents. Because scoring is ignored, a score of <code>0</code> is returned
         * for all documents.
         * <p>
         * API name: {@code must_not}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>mustNot</code>.
         * </p>
         */
        @Nonnull
        public final Builder mustNot(Query value, Query... values) {
            this.mustNot = _listAdd(this.mustNot, value, values);
            return this;
        }

        /**
         * The clause (query) must not appear in the matching documents. Because scoring is ignored, a score of <code>0</code> is returned
         * for all documents.
         * <p>
         * API name: {@code must_not}
         * </p>
         *
         * <p>
         * Adds a value to <code>mustNot</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder mustNot(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return mustNot(fn.apply(new Query.Builder()).build());
        }

        /**
         * The clause (query) should appear in the matching document.
         * <p>
         * API name: {@code should}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>should</code>.
         * </p>
         */
        @Nonnull
        public final Builder should(List<Query> list) {
            this.should = _listAddAll(this.should, list);
            return this;
        }

        /**
         * The clause (query) should appear in the matching document.
         * <p>
         * API name: {@code should}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>should</code>.
         * </p>
         */
        @Nonnull
        public final Builder should(Query value, Query... values) {
            this.should = _listAdd(this.should, value, values);
            return this;
        }

        /**
         * The clause (query) should appear in the matching document.
         * <p>
         * API name: {@code should}
         * </p>
         *
         * <p>
         * Adds a value to <code>should</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder should(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return should(fn.apply(new Query.Builder()).build());
        }

        /**
         * Builds a {@link BoolQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BoolQuery build() {
            _checkSingleUse();

            return new BoolQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BoolQuery}
     */
    public static final JsonpDeserializer<BoolQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BoolQuery::setupBoolQueryDeserializer
    );

    protected static void setupBoolQueryDeserializer(ObjectDeserializer<BoolQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::adjustPureNegative, JsonpDeserializer.booleanDeserializer(), "adjust_pure_negative");
        op.add(Builder::filter, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "filter");
        op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
        op.add(Builder::must, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "must");
        op.add(Builder::mustNot, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "must_not");
        op.add(Builder::should, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "should");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.adjustPureNegative);
        result = 31 * result + Objects.hashCode(this.filter);
        result = 31 * result + Objects.hashCode(this.minimumShouldMatch);
        result = 31 * result + Objects.hashCode(this.must);
        result = 31 * result + Objects.hashCode(this.mustNot);
        result = 31 * result + Objects.hashCode(this.should);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BoolQuery other = (BoolQuery) o;
        return Objects.equals(this.adjustPureNegative, other.adjustPureNegative)
            && Objects.equals(this.filter, other.filter)
            && Objects.equals(this.minimumShouldMatch, other.minimumShouldMatch)
            && Objects.equals(this.must, other.must)
            && Objects.equals(this.mustNot, other.mustNot)
            && Objects.equals(this.should, other.should);
    }
}
