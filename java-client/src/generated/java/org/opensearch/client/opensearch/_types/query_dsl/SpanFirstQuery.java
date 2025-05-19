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

// typedef: _types.query_dsl.SpanFirstQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanFirstQuery extends QueryBase
    implements
        QueryVariant,
        SpanQueryVariant,
        ToCopyableBuilder<SpanFirstQuery.Builder, SpanFirstQuery> {

    private final int end;

    @Nonnull
    private final SpanQuery match;

    // ---------------------------------------------------------------------------------------------

    private SpanFirstQuery(Builder builder) {
        super(builder);
        this.end = ApiTypeHelper.requireNonNull(builder.end, this, "end");
        this.match = ApiTypeHelper.requireNonNull(builder.match, this, "match");
    }

    public static SpanFirstQuery of(Function<SpanFirstQuery.Builder, ObjectBuilder<SpanFirstQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SpanFirst;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanFirst;
    }

    /**
     * Required - Controls the maximum end position permitted in a match.
     * <p>
     * API name: {@code end}
     * </p>
     */
    public final int end() {
        return this.end;
    }

    /**
     * Required - API name: {@code match}
     */
    @Nonnull
    public final SpanQuery match() {
        return this.match;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("end");
        generator.write(this.end);

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
     * Builder for {@link SpanFirstQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanFirstQuery> {
        private Integer end;
        private SpanQuery match;

        public Builder() {}

        private Builder(SpanFirstQuery o) {
            super(o);
            this.end = o.end;
            this.match = o.match;
        }

        private Builder(Builder o) {
            super(o);
            this.end = o.end;
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
         * Required - Controls the maximum end position permitted in a match.
         * <p>
         * API name: {@code end}
         * </p>
         */
        @Nonnull
        public final Builder end(int value) {
            this.end = value;
            return this;
        }

        /**
         * Required - API name: {@code match}
         */
        @Nonnull
        public final Builder match(SpanQuery value) {
            this.match = value;
            return this;
        }

        /**
         * Required - API name: {@code match}
         */
        @Nonnull
        public final Builder match(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
            return match(fn.apply(new SpanQuery.Builder()).build());
        }

        /**
         * Builds a {@link SpanFirstQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanFirstQuery build() {
            _checkSingleUse();

            return new SpanFirstQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanFirstQuery}
     */
    public static final JsonpDeserializer<SpanFirstQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanFirstQuery::setupSpanFirstQueryDeserializer
    );

    protected static void setupSpanFirstQueryDeserializer(ObjectDeserializer<SpanFirstQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::end, JsonpDeserializer.integerDeserializer(), "end");
        op.add(Builder::match, SpanQuery._DESERIALIZER, "match");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Integer.hashCode(this.end);
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
        SpanFirstQuery other = (SpanFirstQuery) o;
        return this.end == other.end && this.match.equals(other.match);
    }
}
