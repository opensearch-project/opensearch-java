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

// typedef: _types.query_dsl.SpanMultiTermQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanMultiTermQuery extends QueryBase
    implements
        QueryVariant,
        SpanQueryVariant,
        ToCopyableBuilder<SpanMultiTermQuery.Builder, SpanMultiTermQuery> {

    @Nonnull
    private final Query match;

    // ---------------------------------------------------------------------------------------------

    private SpanMultiTermQuery(Builder builder) {
        super(builder);
        this.match = ApiTypeHelper.requireNonNull(builder.match, this, "match");
    }

    public static SpanMultiTermQuery of(Function<SpanMultiTermQuery.Builder, ObjectBuilder<SpanMultiTermQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SpanMulti;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanMulti;
    }

    /**
     * Required - API name: {@code match}
     */
    @Nonnull
    public final Query match() {
        return this.match;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("match");
        this.match.serialize(generator, mapper);
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
     * Builder for {@link SpanMultiTermQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanMultiTermQuery> {
        private Query match;

        public Builder() {}

        private Builder(SpanMultiTermQuery o) {
            super(o);
            this.match = o.match;
        }

        private Builder(Builder o) {
            super(o);
            this.match = o.match;
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
         * Required - API name: {@code match}
         */
        @Nonnull
        public final Builder match(Query value) {
            this.match = value;
            return this;
        }

        /**
         * Required - API name: {@code match}
         */
        @Nonnull
        public final Builder match(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return match(fn.apply(new Query.Builder()).build());
        }

        /**
         * Builds a {@link SpanMultiTermQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanMultiTermQuery build() {
            _checkSingleUse();

            return new SpanMultiTermQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanMultiTermQuery}
     */
    public static final JsonpDeserializer<SpanMultiTermQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanMultiTermQuery::setupSpanMultiTermQueryDeserializer
    );

    protected static void setupSpanMultiTermQueryDeserializer(ObjectDeserializer<SpanMultiTermQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::match, Query._DESERIALIZER, "match");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.match.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SpanMultiTermQuery other = (SpanMultiTermQuery) o;
        return this.match.equals(other.match);
    }
}
