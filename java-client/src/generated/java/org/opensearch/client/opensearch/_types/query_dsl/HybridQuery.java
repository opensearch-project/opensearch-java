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

// typedef: _types.query_dsl.HybridQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HybridQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<HybridQuery.Builder, HybridQuery> {

    @Nullable
    private final Integer paginationDepth;

    @Nonnull
    private final List<Query> queries;

    // ---------------------------------------------------------------------------------------------

    private HybridQuery(Builder builder) {
        super(builder);
        this.paginationDepth = builder.paginationDepth;
        this.queries = ApiTypeHelper.unmodifiable(builder.queries);
    }

    public static HybridQuery of(Function<HybridQuery.Builder, ObjectBuilder<HybridQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Hybrid;
    }

    /**
     * API name: {@code pagination_depth}
     */
    @Nullable
    public final Integer paginationDepth() {
        return this.paginationDepth;
    }

    /**
     * API name: {@code queries}
     */
    @Nonnull
    public final List<Query> queries() {
        return this.queries;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.paginationDepth != null) {
            generator.writeKey("pagination_depth");
            generator.write(this.paginationDepth);
        }

        if (ApiTypeHelper.isDefined(this.queries)) {
            generator.writeKey("queries");
            generator.writeStartArray();
            for (Query item0 : this.queries) {
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
     * Builder for {@link HybridQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, HybridQuery> {
        @Nullable
        private Integer paginationDepth;
        @Nullable
        private List<Query> queries;

        public Builder() {}

        private Builder(HybridQuery o) {
            super(o);
            this.paginationDepth = o.paginationDepth;
            this.queries = _listCopy(o.queries);
        }

        private Builder(Builder o) {
            super(o);
            this.paginationDepth = o.paginationDepth;
            this.queries = _listCopy(o.queries);
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
         * API name: {@code pagination_depth}
         */
        @Nonnull
        public final Builder paginationDepth(@Nullable Integer value) {
            this.paginationDepth = value;
            return this;
        }

        /**
         * API name: {@code queries}
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
         * API name: {@code queries}
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
         * API name: {@code queries}
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
         * Builds a {@link HybridQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HybridQuery build() {
            _checkSingleUse();

            return new HybridQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HybridQuery}
     */
    public static final JsonpDeserializer<HybridQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HybridQuery::setupHybridQueryDeserializer
    );

    protected static void setupHybridQueryDeserializer(ObjectDeserializer<HybridQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::paginationDepth, JsonpDeserializer.integerDeserializer(), "pagination_depth");
        op.add(Builder::queries, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "queries");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.paginationDepth);
        result = 31 * result + Objects.hashCode(this.queries);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HybridQuery other = (HybridQuery) o;
        return Objects.equals(this.paginationDepth, other.paginationDepth) && Objects.equals(this.queries, other.queries);
    }
}
