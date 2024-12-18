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
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.ScriptScoreQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ScriptScoreQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<ScriptScoreQuery.Builder, ScriptScoreQuery> {

    @Nullable
    private final Float minScore;

    @Nonnull
    private final Query query;

    @Nonnull
    private final Script script;

    // ---------------------------------------------------------------------------------------------

    private ScriptScoreQuery(Builder builder) {
        super(builder);
        this.minScore = builder.minScore;
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.script = ApiTypeHelper.requireNonNull(builder.script, this, "script");
    }

    public static ScriptScoreQuery of(Function<ScriptScoreQuery.Builder, ObjectBuilder<ScriptScoreQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.ScriptScore;
    }

    /**
     * Documents with a score lower than this floating point number are excluded from the search results.
     * <p>
     * API name: {@code min_score}
     * </p>
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final Query query() {
        return this.query;
    }

    /**
     * Required - API name: {@code script}
     */
    @Nonnull
    public final Script script() {
        return this.script;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);
        }

        generator.writeKey("query");
        this.query.serialize(generator, mapper);

        generator.writeKey("script");
        this.script.serialize(generator, mapper);
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
     * Builder for {@link ScriptScoreQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ScriptScoreQuery> {
        @Nullable
        private Float minScore;
        private Query query;
        private Script script;

        public Builder() {}

        private Builder(ScriptScoreQuery o) {
            super(o);
            this.minScore = o.minScore;
            this.query = o.query;
            this.script = o.script;
        }

        private Builder(Builder o) {
            super(o);
            this.minScore = o.minScore;
            this.query = o.query;
            this.script = o.script;
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
         * Documents with a score lower than this floating point number are excluded from the search results.
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
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Script value) {
            this.script = value;
            return this;
        }

        /**
         * Required - API name: {@code script}
         */
        @Nonnull
        public final Builder script(Function<Script.Builder, ObjectBuilder<Script>> fn) {
            return script(fn.apply(new Script.Builder()).build());
        }

        /**
         * Builds a {@link ScriptScoreQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptScoreQuery build() {
            _checkSingleUse();

            return new ScriptScoreQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptScoreQuery}
     */
    public static final JsonpDeserializer<ScriptScoreQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptScoreQuery::setupScriptScoreQueryDeserializer
    );

    protected static void setupScriptScoreQueryDeserializer(ObjectDeserializer<ScriptScoreQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::script, Script._DESERIALIZER, "script");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.minScore);
        result = 31 * result + this.query.hashCode();
        result = 31 * result + this.script.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptScoreQuery other = (ScriptScoreQuery) o;
        return Objects.equals(this.minScore, other.minScore) && this.query.equals(other.query) && this.script.equals(other.script);
    }
}