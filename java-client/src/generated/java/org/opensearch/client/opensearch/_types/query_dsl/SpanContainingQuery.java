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

// typedef: _types.query_dsl.SpanContainingQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanContainingQuery extends QueryBase
    implements
        QueryVariant,
        SpanQueryVariant,
        ToCopyableBuilder<SpanContainingQuery.Builder, SpanContainingQuery> {

    @Nonnull
    private final SpanQuery big;

    @Nonnull
    private final SpanQuery little;

    // ---------------------------------------------------------------------------------------------

    private SpanContainingQuery(Builder builder) {
        super(builder);
        this.big = ApiTypeHelper.requireNonNull(builder.big, this, "big");
        this.little = ApiTypeHelper.requireNonNull(builder.little, this, "little");
    }

    public static SpanContainingQuery of(Function<SpanContainingQuery.Builder, ObjectBuilder<SpanContainingQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SpanContaining;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanContaining;
    }

    /**
     * Required - API name: {@code big}
     */
    @Nonnull
    public final SpanQuery big() {
        return this.big;
    }

    /**
     * Required - API name: {@code little}
     */
    @Nonnull
    public final SpanQuery little() {
        return this.little;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("big");
        this.big.serialize(generator, mapper);

        generator.writeKey("little");
        this.little.serialize(generator, mapper);
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
     * Builder for {@link SpanContainingQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanContainingQuery> {
        private SpanQuery big;
        private SpanQuery little;

        public Builder() {}

        private Builder(SpanContainingQuery o) {
            super(o);
            this.big = o.big;
            this.little = o.little;
        }

        private Builder(Builder o) {
            super(o);
            this.big = o.big;
            this.little = o.little;
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
         * Required - API name: {@code big}
         */
        @Nonnull
        public final Builder big(SpanQuery value) {
            this.big = value;
            return this;
        }

        /**
         * Required - API name: {@code big}
         */
        @Nonnull
        public final Builder big(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
            return big(fn.apply(new SpanQuery.Builder()).build());
        }

        /**
         * Required - API name: {@code little}
         */
        @Nonnull
        public final Builder little(SpanQuery value) {
            this.little = value;
            return this;
        }

        /**
         * Required - API name: {@code little}
         */
        @Nonnull
        public final Builder little(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
            return little(fn.apply(new SpanQuery.Builder()).build());
        }

        /**
         * Builds a {@link SpanContainingQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanContainingQuery build() {
            _checkSingleUse();

            return new SpanContainingQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanContainingQuery}
     */
    public static final JsonpDeserializer<SpanContainingQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanContainingQuery::setupSpanContainingQueryDeserializer
    );

    protected static void setupSpanContainingQueryDeserializer(ObjectDeserializer<SpanContainingQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::big, SpanQuery._DESERIALIZER, "big");
        op.add(Builder::little, SpanQuery._DESERIALIZER, "little");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.big.hashCode();
        result = 31 * result + this.little.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SpanContainingQuery other = (SpanContainingQuery) o;
        return this.big.equals(other.big) && this.little.equals(other.little);
    }
}
