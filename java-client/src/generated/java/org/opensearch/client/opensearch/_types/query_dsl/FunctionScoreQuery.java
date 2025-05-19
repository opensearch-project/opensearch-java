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

// typedef: _types.query_dsl.FunctionScoreQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FunctionScoreQuery extends QueryBase
    implements
        QueryVariant,
        ToCopyableBuilder<FunctionScoreQuery.Builder, FunctionScoreQuery> {

    @Nullable
    private final FunctionBoostMode boostMode;

    @Nonnull
    private final List<FunctionScore> functions;

    @Nullable
    private final Float maxBoost;

    @Nullable
    private final Float minScore;

    @Nullable
    private final Query query;

    @Nullable
    private final FunctionScoreMode scoreMode;

    // ---------------------------------------------------------------------------------------------

    private FunctionScoreQuery(Builder builder) {
        super(builder);
        this.boostMode = builder.boostMode;
        this.functions = ApiTypeHelper.unmodifiable(builder.functions);
        this.maxBoost = builder.maxBoost;
        this.minScore = builder.minScore;
        this.query = builder.query;
        this.scoreMode = builder.scoreMode;
    }

    public static FunctionScoreQuery of(Function<FunctionScoreQuery.Builder, ObjectBuilder<FunctionScoreQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.FunctionScore;
    }

    /**
     * API name: {@code boost_mode}
     */
    @Nullable
    public final FunctionBoostMode boostMode() {
        return this.boostMode;
    }

    /**
     * One or more functions that compute a new score for each document returned by the query.
     * <p>
     * API name: {@code functions}
     * </p>
     */
    @Nonnull
    public final List<FunctionScore> functions() {
        return this.functions;
    }

    /**
     * Restricts the new score to not exceed the provided limit.
     * <p>
     * API name: {@code max_boost}
     * </p>
     */
    @Nullable
    public final Float maxBoost() {
        return this.maxBoost;
    }

    /**
     * Excludes documents that do not meet the provided score threshold.
     * <p>
     * API name: {@code min_score}
     * </p>
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * API name: {@code score_mode}
     */
    @Nullable
    public final FunctionScoreMode scoreMode() {
        return this.scoreMode;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.boostMode != null) {
            generator.writeKey("boost_mode");
            this.boostMode.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.functions)) {
            generator.writeKey("functions");
            generator.writeStartArray();
            for (FunctionScore item0 : this.functions) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.maxBoost != null) {
            generator.writeKey("max_boost");
            generator.write(this.maxBoost);
        }

        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);
        }

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

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
     * Builder for {@link FunctionScoreQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, FunctionScoreQuery> {
        @Nullable
        private FunctionBoostMode boostMode;
        @Nullable
        private List<FunctionScore> functions;
        @Nullable
        private Float maxBoost;
        @Nullable
        private Float minScore;
        @Nullable
        private Query query;
        @Nullable
        private FunctionScoreMode scoreMode;

        public Builder() {}

        private Builder(FunctionScoreQuery o) {
            super(o);
            this.boostMode = o.boostMode;
            this.functions = _listCopy(o.functions);
            this.maxBoost = o.maxBoost;
            this.minScore = o.minScore;
            this.query = o.query;
            this.scoreMode = o.scoreMode;
        }

        private Builder(Builder o) {
            super(o);
            this.boostMode = o.boostMode;
            this.functions = _listCopy(o.functions);
            this.maxBoost = o.maxBoost;
            this.minScore = o.minScore;
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
         * API name: {@code boost_mode}
         */
        @Nonnull
        public final Builder boostMode(@Nullable FunctionBoostMode value) {
            this.boostMode = value;
            return this;
        }

        /**
         * One or more functions that compute a new score for each document returned by the query.
         * <p>
         * API name: {@code functions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>functions</code>.
         * </p>
         */
        @Nonnull
        public final Builder functions(List<FunctionScore> list) {
            this.functions = _listAddAll(this.functions, list);
            return this;
        }

        /**
         * One or more functions that compute a new score for each document returned by the query.
         * <p>
         * API name: {@code functions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>functions</code>.
         * </p>
         */
        @Nonnull
        public final Builder functions(FunctionScore value, FunctionScore... values) {
            this.functions = _listAdd(this.functions, value, values);
            return this;
        }

        /**
         * One or more functions that compute a new score for each document returned by the query.
         * <p>
         * API name: {@code functions}
         * </p>
         *
         * <p>
         * Adds a value to <code>functions</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder functions(Function<FunctionScore.Builder, ObjectBuilder<FunctionScore>> fn) {
            return functions(fn.apply(new FunctionScore.Builder()).build());
        }

        /**
         * Restricts the new score to not exceed the provided limit.
         * <p>
         * API name: {@code max_boost}
         * </p>
         */
        @Nonnull
        public final Builder maxBoost(@Nullable Float value) {
            this.maxBoost = value;
            return this;
        }

        /**
         * Excludes documents that do not meet the provided score threshold.
         * <p>
         * API name: {@code min_score}
         * </p>
         */
        @Nonnull
        public final Builder minScore(@Nullable Float value) {
            this.minScore = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable Query value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return query(fn.apply(new Query.Builder()).build());
        }

        /**
         * API name: {@code score_mode}
         */
        @Nonnull
        public final Builder scoreMode(@Nullable FunctionScoreMode value) {
            this.scoreMode = value;
            return this;
        }

        /**
         * Builds a {@link FunctionScoreQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FunctionScoreQuery build() {
            _checkSingleUse();

            return new FunctionScoreQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FunctionScoreQuery}
     */
    public static final JsonpDeserializer<FunctionScoreQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FunctionScoreQuery::setupFunctionScoreQueryDeserializer
    );

    protected static void setupFunctionScoreQueryDeserializer(ObjectDeserializer<FunctionScoreQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::boostMode, FunctionBoostMode._DESERIALIZER, "boost_mode");
        op.add(Builder::functions, JsonpDeserializer.arrayDeserializer(FunctionScore._DESERIALIZER), "functions");
        op.add(Builder::maxBoost, JsonpDeserializer.floatDeserializer(), "max_boost");
        op.add(Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::scoreMode, FunctionScoreMode._DESERIALIZER, "score_mode");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.boostMode);
        result = 31 * result + Objects.hashCode(this.functions);
        result = 31 * result + Objects.hashCode(this.maxBoost);
        result = 31 * result + Objects.hashCode(this.minScore);
        result = 31 * result + Objects.hashCode(this.query);
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
        FunctionScoreQuery other = (FunctionScoreQuery) o;
        return Objects.equals(this.boostMode, other.boostMode)
            && Objects.equals(this.functions, other.functions)
            && Objects.equals(this.maxBoost, other.maxBoost)
            && Objects.equals(this.minScore, other.minScore)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.scoreMode, other.scoreMode);
    }
}
