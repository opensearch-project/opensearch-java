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

// typedef: _types.query_dsl.HasChildQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class HasChildQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<HasChildQuery.Builder, HasChildQuery> {

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nullable
    private final InnerHits innerHits;

    @Nullable
    private final Integer maxChildren;

    @Nullable
    private final Integer minChildren;

    @Nonnull
    private final Query query;

    @Nullable
    private final ChildScoreMode scoreMode;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private HasChildQuery(Builder builder) {
        super(builder);
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.innerHits = builder.innerHits;
        this.maxChildren = builder.maxChildren;
        this.minChildren = builder.minChildren;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.scoreMode = builder.scoreMode;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static HasChildQuery of(Function<HasChildQuery.Builder, ObjectBuilder<HasChildQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.HasChild;
    }

    /**
     * Indicates whether to ignore an unmapped <code>type</code> and not return any documents instead of an error.
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
     * Maximum number of child documents that match the query allowed for a returned parent document. If the parent document exceeds this
     * limit, it is excluded from the search results.
     * <p>
     * API name: {@code max_children}
     * </p>
     */
    @Nullable
    public final Integer maxChildren() {
        return this.maxChildren;
    }

    /**
     * Minimum number of child documents that match the query required to match the query for a returned parent document. If the parent
     * document does not meet this limit, it is excluded from the search results.
     * <p>
     * API name: {@code min_children}
     * </p>
     */
    @Nullable
    public final Integer minChildren() {
        return this.minChildren;
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

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
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

        if (this.maxChildren != null) {
            generator.writeKey("max_children");
            generator.write(this.maxChildren);
        }

        if (this.minChildren != null) {
            generator.writeKey("min_children");
            generator.write(this.minChildren);
        }

        generator.writeKey("query");
        this.query.serialize(generator, mapper);

        if (this.scoreMode != null) {
            generator.writeKey("score_mode");
            this.scoreMode.serialize(generator, mapper);
        }

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link HasChildQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, HasChildQuery> {
        @Nullable
        private Boolean ignoreUnmapped;
        @Nullable
        private InnerHits innerHits;
        @Nullable
        private Integer maxChildren;
        @Nullable
        private Integer minChildren;
        private Query query;
        @Nullable
        private ChildScoreMode scoreMode;
        private String type;

        public Builder() {}

        private Builder(HasChildQuery o) {
            super(o);
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.innerHits = o.innerHits;
            this.maxChildren = o.maxChildren;
            this.minChildren = o.minChildren;
            this.query = o.query;
            this.scoreMode = o.scoreMode;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.innerHits = o.innerHits;
            this.maxChildren = o.maxChildren;
            this.minChildren = o.minChildren;
            this.query = o.query;
            this.scoreMode = o.scoreMode;
            this.type = o.type;
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
         * Indicates whether to ignore an unmapped <code>type</code> and not return any documents instead of an error.
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
         * Maximum number of child documents that match the query allowed for a returned parent document. If the parent document exceeds
         * this limit, it is excluded from the search results.
         * <p>
         * API name: {@code max_children}
         * </p>
         */
        @Nonnull
        public final Builder maxChildren(@Nullable Integer value) {
            this.maxChildren = value;
            return this;
        }

        /**
         * Minimum number of child documents that match the query required to match the query for a returned parent document. If the parent
         * document does not meet this limit, it is excluded from the search results.
         * <p>
         * API name: {@code min_children}
         * </p>
         */
        @Nonnull
        public final Builder minChildren(@Nullable Integer value) {
            this.minChildren = value;
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
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link HasChildQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HasChildQuery build() {
            _checkSingleUse();

            return new HasChildQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HasChildQuery}
     */
    public static final JsonpDeserializer<HasChildQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HasChildQuery::setupHasChildQueryDeserializer
    );

    protected static void setupHasChildQueryDeserializer(ObjectDeserializer<HasChildQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.add(Builder::innerHits, InnerHits._DESERIALIZER, "inner_hits");
        op.add(Builder::maxChildren, JsonpDeserializer.integerDeserializer(), "max_children");
        op.add(Builder::minChildren, JsonpDeserializer.integerDeserializer(), "min_children");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::scoreMode, ChildScoreMode._DESERIALIZER, "score_mode");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + Objects.hashCode(this.innerHits);
        result = 31 * result + Objects.hashCode(this.maxChildren);
        result = 31 * result + Objects.hashCode(this.minChildren);
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.scoreMode);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HasChildQuery other = (HasChildQuery) o;
        return Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && Objects.equals(this.innerHits, other.innerHits)
            && Objects.equals(this.maxChildren, other.maxChildren)
            && Objects.equals(this.minChildren, other.minChildren)
            && this.query.equals(other.query)
            && Objects.equals(this.scoreMode, other.scoreMode)
            && this.type.equals(other.type);
    }
}
