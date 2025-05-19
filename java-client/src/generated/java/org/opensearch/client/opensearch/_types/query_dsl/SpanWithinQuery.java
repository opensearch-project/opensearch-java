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

// typedef: _types.query_dsl.SpanWithinQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanWithinQuery extends QueryBase
    implements
        QueryVariant,
        SpanQueryVariant,
        ToCopyableBuilder<SpanWithinQuery.Builder, SpanWithinQuery> {

    @Nonnull
    private final SpanQuery big;

    @Nonnull
    private final SpanQuery little;

    // ---------------------------------------------------------------------------------------------

    private SpanWithinQuery(Builder builder) {
        super(builder);
        this.big = ApiTypeHelper.requireNonNull(builder.big, this, "big");
        this.little = ApiTypeHelper.requireNonNull(builder.little, this, "little");
    }

    public static SpanWithinQuery of(Function<SpanWithinQuery.Builder, ObjectBuilder<SpanWithinQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SpanWithin;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanWithin;
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
     * Builder for {@link SpanWithinQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanWithinQuery> {
        private SpanQuery big;
        private SpanQuery little;

        public Builder() {}

        private Builder(SpanWithinQuery o) {
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
         * Builds a {@link SpanWithinQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanWithinQuery build() {
            _checkSingleUse();

            return new SpanWithinQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanWithinQuery}
     */
    public static final JsonpDeserializer<SpanWithinQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanWithinQuery::setupSpanWithinQueryDeserializer
    );

    protected static void setupSpanWithinQueryDeserializer(ObjectDeserializer<SpanWithinQuery.Builder> op) {
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
        SpanWithinQuery other = (SpanWithinQuery) o;
        return this.big.equals(other.big) && this.little.equals(other.little);
    }
}
