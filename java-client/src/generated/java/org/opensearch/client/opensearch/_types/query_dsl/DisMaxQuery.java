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

// typedef: _types.query_dsl.DisMaxQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DisMaxQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<DisMaxQuery.Builder, DisMaxQuery> {

    @Nonnull
    private final List<Query> queries;

    @Nullable
    private final Float tieBreaker;

    // ---------------------------------------------------------------------------------------------

    private DisMaxQuery(Builder builder) {
        super(builder);
        this.queries = ApiTypeHelper.unmodifiableRequired(builder.queries, this, "queries");
        this.tieBreaker = builder.tieBreaker;
    }

    public static DisMaxQuery of(Function<DisMaxQuery.Builder, ObjectBuilder<DisMaxQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.DisMax;
    }

    /**
     * Required - One or more query clauses. Returned documents must match one or more of these queries. If a document matches multiple
     * queries, OpenSearch uses the highest relevance score.
     * <p>
     * API name: {@code queries}
     * </p>
     */
    @Nonnull
    public final List<Query> queries() {
        return this.queries;
    }

    /**
     * Floating point number between 0 and 1.0 used to increase the relevance scores of documents matching multiple query clauses.
     * <p>
     * API name: {@code tie_breaker}
     * </p>
     */
    @Nullable
    public final Float tieBreaker() {
        return this.tieBreaker;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("queries");
        generator.writeStartArray();
        for (Query item0 : this.queries) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.tieBreaker != null) {
            generator.writeKey("tie_breaker");
            generator.write(this.tieBreaker);
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
     * Builder for {@link DisMaxQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DisMaxQuery> {
        private List<Query> queries;
        @Nullable
        private Float tieBreaker;

        public Builder() {}

        private Builder(DisMaxQuery o) {
            super(o);
            this.queries = _listCopy(o.queries);
            this.tieBreaker = o.tieBreaker;
        }

        private Builder(Builder o) {
            super(o);
            this.queries = _listCopy(o.queries);
            this.tieBreaker = o.tieBreaker;
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
         * Required - One or more query clauses. Returned documents must match one or more of these queries. If a document matches multiple
         * queries, OpenSearch uses the highest relevance score.
         * <p>
         * API name: {@code queries}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>queries</code>.
         * </p>
         */
        @Nonnull
        public final Builder queries(List<Query> list) {
            this.queries = _listAddAll(this.queries, list);
            return this;
        }

        /**
         * Required - One or more query clauses. Returned documents must match one or more of these queries. If a document matches multiple
         * queries, OpenSearch uses the highest relevance score.
         * <p>
         * API name: {@code queries}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>queries</code>.
         * </p>
         */
        @Nonnull
        public final Builder queries(Query value, Query... values) {
            this.queries = _listAdd(this.queries, value, values);
            return this;
        }

        /**
         * Required - One or more query clauses. Returned documents must match one or more of these queries. If a document matches multiple
         * queries, OpenSearch uses the highest relevance score.
         * <p>
         * API name: {@code queries}
         * </p>
         *
         * <p>
         * Adds a value to <code>queries</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder queries(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return queries(fn.apply(new Query.Builder()).build());
        }

        /**
         * Floating point number between 0 and 1.0 used to increase the relevance scores of documents matching multiple query clauses.
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
         * Builds a {@link DisMaxQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DisMaxQuery build() {
            _checkSingleUse();

            return new DisMaxQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DisMaxQuery}
     */
    public static final JsonpDeserializer<DisMaxQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DisMaxQuery::setupDisMaxQueryDeserializer
    );

    protected static void setupDisMaxQueryDeserializer(ObjectDeserializer<DisMaxQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::queries, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "queries");
        op.add(Builder::tieBreaker, JsonpDeserializer.floatDeserializer(), "tie_breaker");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.queries.hashCode();
        result = 31 * result + Objects.hashCode(this.tieBreaker);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DisMaxQuery other = (DisMaxQuery) o;
        return this.queries.equals(other.queries) && Objects.equals(this.tieBreaker, other.tieBreaker);
    }
}
