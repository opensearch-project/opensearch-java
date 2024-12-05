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
import org.opensearch.client.opensearch.core.search.InnerHits;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.NestedQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NestedQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<NestedQuery.Builder, NestedQuery> {

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nullable
    private final InnerHits innerHits;

    @Nonnull
    private final String path;

    @Nonnull
    private final Query query;

    @Nullable
    private final ChildScoreMode scoreMode;

    // ---------------------------------------------------------------------------------------------

    private NestedQuery(Builder builder) {
        super(builder);
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.innerHits = builder.innerHits;
        this.path = ApiTypeHelper.requireNonNull(builder.path, this, "path");
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.scoreMode = builder.scoreMode;
    }

    public static NestedQuery of(Function<NestedQuery.Builder, ObjectBuilder<NestedQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Nested;
    }

    /**
     * Indicates whether to ignore an unmapped path and not return any documents instead of an error.
     * <p>
     * API name: {@code ignore_unmapped}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnmapped() {
        return this.ignoreUnmapped;
    }

    /**
     * API name: {@code inner_hits}
     */
    @Nullable
    public final InnerHits innerHits() {
        return this.innerHits;
    }

    /**
     * Required - API name: {@code path}
     */
    @Nonnull
    public final String path() {
        return this.path;
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final Query query() {
        return this.query;
    }

    /**
     * API name: {@code score_mode}
     */
    @Nullable
    public final ChildScoreMode scoreMode() {
        return this.scoreMode;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.ignoreUnmapped != null) {
            generator.writeKey("ignore_unmapped");
            generator.write(this.ignoreUnmapped);
        }

        if (this.innerHits != null) {
            generator.writeKey("inner_hits");
            this.innerHits.serialize(generator, mapper);
        }

        generator.writeKey("path");
        generator.write(this.path);

        generator.writeKey("query");
        this.query.serialize(generator, mapper);

        if (this.scoreMode != null) {
            generator.writeKey("score_mode");
            this.scoreMode.serialize(generator, mapper);
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
     * Builder for {@link NestedQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NestedQuery> {
        @Nullable
        private Boolean ignoreUnmapped;
        @Nullable
        private InnerHits innerHits;
        private String path;
        private Query query;
        @Nullable
        private ChildScoreMode scoreMode;

        public Builder() {}

        private Builder(NestedQuery o) {
            super(o);
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.innerHits = o.innerHits;
            this.path = o.path;
            this.query = o.query;
            this.scoreMode = o.scoreMode;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.innerHits = o.innerHits;
            this.path = o.path;
            this.query = o.query;
            this.scoreMode = o.scoreMode;
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
         * Indicates whether to ignore an unmapped path and not return any documents instead of an error.
         * <p>
         * API name: {@code ignore_unmapped}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnmapped(@Nullable Boolean value) {
            this.ignoreUnmapped = value;
            return this;
        }

        /**
         * API name: {@code inner_hits}
         */
        @Nonnull
        public final Builder innerHits(@Nullable InnerHits value) {
            this.innerHits = value;
            return this;
        }

        /**
         * API name: {@code inner_hits}
         */
        @Nonnull
        public final Builder innerHits(Function<InnerHits.Builder, ObjectBuilder<InnerHits>> fn) {
            return innerHits(fn.apply(new InnerHits.Builder()).build());
        }

        /**
         * Required - API name: {@code path}
         */
        @Nonnull
        public final Builder path(String value) {
            this.path = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(Query value) {
            this.query = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return query(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code score_mode}
         */
        @Nonnull
        public final Builder scoreMode(@Nullable ChildScoreMode value) {
            this.scoreMode = value;
            return this;
        }

        /**
         * Builds a {@link NestedQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NestedQuery build() {
            _checkSingleUse();

            return new NestedQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NestedQuery}
     */
    public static final JsonpDeserializer<NestedQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NestedQuery::setupNestedQueryDeserializer
    );

    protected static void setupNestedQueryDeserializer(ObjectDeserializer<NestedQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.add(Builder::innerHits, InnerHits._DESERIALIZER, "inner_hits");
        op.add(Builder::path, JsonpDeserializer.stringDeserializer(), "path");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::scoreMode, ChildScoreMode._DESERIALIZER, "score_mode");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + Objects.hashCode(this.innerHits);
        result = 31 * result + this.path.hashCode();
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.scoreMode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NestedQuery other = (NestedQuery) o;
        return Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && Objects.equals(this.innerHits, other.innerHits)
            && this.path.equals(other.path)
            && this.query.equals(other.query)
            && Objects.equals(this.scoreMode, other.scoreMode);
    }
}
