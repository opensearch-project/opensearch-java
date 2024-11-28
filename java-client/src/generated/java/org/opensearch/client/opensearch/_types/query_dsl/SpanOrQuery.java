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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.SpanOrQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanOrQuery extends QueryBase implements QueryVariant, SpanQueryVariant, ToCopyableBuilder<SpanOrQuery.Builder, SpanOrQuery> {

    @Nonnull
    private final List<SpanQuery> clauses;

    // ---------------------------------------------------------------------------------------------

    private SpanOrQuery(Builder builder) {
        super(builder);
        this.clauses = ApiTypeHelper.unmodifiableRequired(builder.clauses, this, "clauses");
    }

    public static SpanOrQuery of(Function<SpanOrQuery.Builder, ObjectBuilder<SpanOrQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SpanOr;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanOr;
    }

    /**
     * Required - Array of one or more other span type queries.
     * <p>
     * API name: {@code clauses}
     * </p>
     */
    @Nonnull
    public final List<SpanQuery> clauses() {
        return this.clauses;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("clauses");
        generator.writeStartArray();
        for (SpanQuery item0 : this.clauses) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link SpanOrQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanOrQuery> {
        private List<SpanQuery> clauses;

        public Builder() {}

        private Builder(SpanOrQuery o) {
            super(o);
            this.clauses = _listCopy(o.clauses);
        }

        private Builder(Builder o) {
            super(o);
            this.clauses = _listCopy(o.clauses);
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
         * Required - Array of one or more other span type queries.
         * <p>
         * API name: {@code clauses}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>clauses</code>.
         * </p>
         */
        @Nonnull
        public final Builder clauses(List<SpanQuery> list) {
            this.clauses = _listAddAll(this.clauses, list);
            return this;
        }

        /**
         * Required - Array of one or more other span type queries.
         * <p>
         * API name: {@code clauses}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>clauses</code>.
         * </p>
         */
        @Nonnull
        public final Builder clauses(SpanQuery value, SpanQuery... values) {
            this.clauses = _listAdd(this.clauses, value, values);
            return this;
        }

        /**
         * Required - Array of one or more other span type queries.
         * <p>
         * API name: {@code clauses}
         * </p>
         *
         * <p>
         * Adds a value to <code>clauses</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder clauses(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
            return clauses(fn.apply(new SpanQuery.Builder()).build());
        }

        /**
         * Builds a {@link SpanOrQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanOrQuery build() {
            _checkSingleUse();

            return new SpanOrQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanOrQuery}
     */
    public static final JsonpDeserializer<SpanOrQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanOrQuery::setupSpanOrQueryDeserializer
    );

    protected static void setupSpanOrQueryDeserializer(ObjectDeserializer<SpanOrQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::clauses, JsonpDeserializer.arrayDeserializer(SpanQuery._DESERIALIZER), "clauses");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.clauses.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SpanOrQuery other = (SpanOrQuery) o;
        return this.clauses.equals(other.clauses);
    }
}
