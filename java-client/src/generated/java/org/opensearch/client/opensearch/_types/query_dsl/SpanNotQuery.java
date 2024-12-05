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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.SpanNotQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SpanNotQuery extends QueryBase
    implements
        QueryVariant,
        SpanQueryVariant,
        ToCopyableBuilder<SpanNotQuery.Builder, SpanNotQuery> {

    @Nullable
    private final Integer dist;

    @Nonnull
    private final SpanQuery exclude;

    @Nonnull
    private final SpanQuery include;

    @Nullable
    private final Integer post;

    @Nullable
    private final Integer pre;

    // ---------------------------------------------------------------------------------------------

    private SpanNotQuery(Builder builder) {
        super(builder);
        this.dist = builder.dist;
        this.exclude = ApiTypeHelper.requireNonNull(builder.exclude, this, "exclude");
        this.include = ApiTypeHelper.requireNonNull(builder.include, this, "include");
        this.post = builder.post;
        this.pre = builder.pre;
    }

    public static SpanNotQuery of(Function<SpanNotQuery.Builder, ObjectBuilder<SpanNotQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.SpanNot;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.SpanNot;
    }

    /**
     * The number of tokens from within the include span that can't have overlap with the exclude span. Equivalent to setting both
     * <code>pre</code> and <code>post</code>.
     * <p>
     * API name: {@code dist}
     * </p>
     */
    @Nullable
    public final Integer dist() {
        return this.dist;
    }

    /**
     * Required - API name: {@code exclude}
     */
    @Nonnull
    public final SpanQuery exclude() {
        return this.exclude;
    }

    /**
     * Required - API name: {@code include}
     */
    @Nonnull
    public final SpanQuery include() {
        return this.include;
    }

    /**
     * The number of tokens after the include span that can't have overlap with the exclude span.
     * <p>
     * API name: {@code post}
     * </p>
     */
    @Nullable
    public final Integer post() {
        return this.post;
    }

    /**
     * The number of tokens before the include span that can't have overlap with the exclude span.
     * <p>
     * API name: {@code pre}
     * </p>
     */
    @Nullable
    public final Integer pre() {
        return this.pre;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.dist != null) {
            generator.writeKey("dist");
            generator.write(this.dist);
        }

        generator.writeKey("exclude");
        this.exclude.serialize(generator, mapper);

        generator.writeKey("include");
        this.include.serialize(generator, mapper);

        if (this.post != null) {
            generator.writeKey("post");
            generator.write(this.post);
        }

        if (this.pre != null) {
            generator.writeKey("pre");
            generator.write(this.pre);
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
     * Builder for {@link SpanNotQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanNotQuery> {
        @Nullable
        private Integer dist;
        private SpanQuery exclude;
        private SpanQuery include;
        @Nullable
        private Integer post;
        @Nullable
        private Integer pre;

        public Builder() {}

        private Builder(SpanNotQuery o) {
            super(o);
            this.dist = o.dist;
            this.exclude = o.exclude;
            this.include = o.include;
            this.post = o.post;
            this.pre = o.pre;
        }

        private Builder(Builder o) {
            super(o);
            this.dist = o.dist;
            this.exclude = o.exclude;
            this.include = o.include;
            this.post = o.post;
            this.pre = o.pre;
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
         * The number of tokens from within the include span that can't have overlap with the exclude span. Equivalent to setting both
         * <code>pre</code> and <code>post</code>.
         * <p>
         * API name: {@code dist}
         * </p>
         */
        @Nonnull
        public final Builder dist(@Nullable Integer value) {
            this.dist = value;
            return this;
        }

        /**
         * Required - API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(SpanQuery value) {
            this.exclude = value;
            return this;
        }

        /**
         * Required - API name: {@code exclude}
         */
        @Nonnull
        public final Builder exclude(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
            return exclude(fn.apply(new SpanQuery.Builder()).build());
        }

        /**
         * Required - API name: {@code include}
         */
        @Nonnull
        public final Builder include(SpanQuery value) {
            this.include = value;
            return this;
        }

        /**
         * Required - API name: {@code include}
         */
        @Nonnull
        public final Builder include(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
            return include(fn.apply(new SpanQuery.Builder()).build());
        }

        /**
         * The number of tokens after the include span that can't have overlap with the exclude span.
         * <p>
         * API name: {@code post}
         * </p>
         */
        @Nonnull
        public final Builder post(@Nullable Integer value) {
            this.post = value;
            return this;
        }

        /**
         * The number of tokens before the include span that can't have overlap with the exclude span.
         * <p>
         * API name: {@code pre}
         * </p>
         */
        @Nonnull
        public final Builder pre(@Nullable Integer value) {
            this.pre = value;
            return this;
        }

        /**
         * Builds a {@link SpanNotQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanNotQuery build() {
            _checkSingleUse();

            return new SpanNotQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanNotQuery}
     */
    public static final JsonpDeserializer<SpanNotQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanNotQuery::setupSpanNotQueryDeserializer
    );

    protected static void setupSpanNotQueryDeserializer(ObjectDeserializer<SpanNotQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::dist, JsonpDeserializer.integerDeserializer(), "dist");
        op.add(Builder::exclude, SpanQuery._DESERIALIZER, "exclude");
        op.add(Builder::include, SpanQuery._DESERIALIZER, "include");
        op.add(Builder::post, JsonpDeserializer.integerDeserializer(), "post");
        op.add(Builder::pre, JsonpDeserializer.integerDeserializer(), "pre");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.dist);
        result = 31 * result + this.exclude.hashCode();
        result = 31 * result + this.include.hashCode();
        result = 31 * result + Objects.hashCode(this.post);
        result = 31 * result + Objects.hashCode(this.pre);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SpanNotQuery other = (SpanNotQuery) o;
        return Objects.equals(this.dist, other.dist)
            && this.exclude.equals(other.exclude)
            && this.include.equals(other.include)
            && Objects.equals(this.post, other.post)
            && Objects.equals(this.pre, other.pre);
    }
}
