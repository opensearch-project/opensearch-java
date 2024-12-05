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

// typedef: _types.query_dsl.SpanNearQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanNearQuery extends QueryBase
    implements
        QueryVariant,
        SpanQueryVariant,
        ToCopyableBuilder<SpanNearQuery.Builder, SpanNearQuery> {

    @Nonnull
    private final List<SpanQuery> clauses;

    @Nullable
    private final Boolean inOrder;

    @Nullable
    private final Integer slop;

    // ---------------------------------------------------------------------------------------------

    private SpanNearQuery(Builder builder) {
        super(builder);
        this.clauses = ApiTypeHelper.unmodifiableRequired(builder.clauses, this, "clauses");
        this.inOrder = builder.inOrder;
        this.slop = builder.slop;
    }

    public static SpanNearQuery of(Function<SpanNearQuery.Builder, ObjectBuilder<SpanNearQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SpanNear;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanNear;
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

    /**
     * Controls whether matches are required to be in-order.
     * <p>
     * API name: {@code in_order}
     * </p>
     */
    @Nullable
    public final Boolean inOrder() {
        return this.inOrder;
    }

    /**
     * Controls the maximum number of intervening unmatched positions permitted.
     * <p>
     * API name: {@code slop}
     * </p>
     */
    @Nullable
    public final Integer slop() {
        return this.slop;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("clauses");
        generator.writeStartArray();
        for (SpanQuery item0 : this.clauses) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.inOrder != null) {
            generator.writeKey("in_order");
            generator.write(this.inOrder);
        }

        if (this.slop != null) {
            generator.writeKey("slop");
            generator.write(this.slop);
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
     * Builder for {@link SpanNearQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanNearQuery> {
        private List<SpanQuery> clauses;
        @Nullable
        private Boolean inOrder;
        @Nullable
        private Integer slop;

        public Builder() {}

        private Builder(SpanNearQuery o) {
            super(o);
            this.clauses = _listCopy(o.clauses);
            this.inOrder = o.inOrder;
            this.slop = o.slop;
        }

        private Builder(Builder o) {
            super(o);
            this.clauses = _listCopy(o.clauses);
            this.inOrder = o.inOrder;
            this.slop = o.slop;
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
         * Controls whether matches are required to be in-order.
         * <p>
         * API name: {@code in_order}
         * </p>
         */
        @Nonnull
        public final Builder inOrder(@Nullable Boolean value) {
            this.inOrder = value;
            return this;
        }

        /**
         * Controls the maximum number of intervening unmatched positions permitted.
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
         * Builds a {@link SpanNearQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanNearQuery build() {
            _checkSingleUse();

            return new SpanNearQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanNearQuery}
     */
    public static final JsonpDeserializer<SpanNearQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanNearQuery::setupSpanNearQueryDeserializer
    );

    protected static void setupSpanNearQueryDeserializer(ObjectDeserializer<SpanNearQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::clauses, JsonpDeserializer.arrayDeserializer(SpanQuery._DESERIALIZER), "clauses");
        op.add(Builder::inOrder, JsonpDeserializer.booleanDeserializer(), "in_order");
        op.add(Builder::slop, JsonpDeserializer.integerDeserializer(), "slop");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.clauses.hashCode();
        result = 31 * result + Objects.hashCode(this.inOrder);
        result = 31 * result + Objects.hashCode(this.slop);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SpanNearQuery other = (SpanNearQuery) o;
        return this.clauses.equals(other.clauses) && Objects.equals(this.inOrder, other.inOrder) && Objects.equals(this.slop, other.slop);
    }
}
