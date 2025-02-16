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

package org.opensearch.client.opensearch.core.search;

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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.RescoreQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RescoreQuery implements PlainJsonSerializable, ToCopyableBuilder<RescoreQuery.Builder, RescoreQuery> {

    @Nullable
    private final Float queryWeight;

    @Nonnull
    private final Query rescoreQuery;

    @Nullable
    private final Float rescoreQueryWeight;

    @Nullable
    private final ScoreMode scoreMode;

    // ---------------------------------------------------------------------------------------------

    private RescoreQuery(Builder builder) {
        this.queryWeight = builder.queryWeight;
        this.rescoreQuery = ApiTypeHelper.requireNonNull(builder.rescoreQuery, this, "rescoreQuery");
        this.rescoreQueryWeight = builder.rescoreQueryWeight;
        this.scoreMode = builder.scoreMode;
    }

    public static RescoreQuery of(Function<RescoreQuery.Builder, ObjectBuilder<RescoreQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The relative importance of the original query as compared to the rescore query.
     * <p>
     * API name: {@code query_weight}
     * </p>
     */
    @Nullable
    public final Float queryWeight() {
        return this.queryWeight;
    }

    /**
     * Required - API name: {@code rescore_query}
     */
    @Nonnull
    public final Query rescoreQuery() {
        return this.rescoreQuery;
    }

    /**
     * The relative importance of the rescore query as compared to the original query.
     * <p>
     * API name: {@code rescore_query_weight}
     * </p>
     */
    @Nullable
    public final Float rescoreQueryWeight() {
        return this.rescoreQueryWeight;
    }

    /**
     * API name: {@code score_mode}
     */
    @Nullable
    public final ScoreMode scoreMode() {
        return this.scoreMode;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.queryWeight != null) {
            generator.writeKey("query_weight");
            generator.write(this.queryWeight);
        }

        generator.writeKey("rescore_query");
        this.rescoreQuery.serialize(generator, mapper);

        if (this.rescoreQueryWeight != null) {
            generator.writeKey("rescore_query_weight");
            generator.write(this.rescoreQueryWeight);
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
     * Builder for {@link RescoreQuery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RescoreQuery> {
        @Nullable
        private Float queryWeight;
        private Query rescoreQuery;
        @Nullable
        private Float rescoreQueryWeight;
        @Nullable
        private ScoreMode scoreMode;

        public Builder() {}

        private Builder(RescoreQuery o) {
            this.queryWeight = o.queryWeight;
            this.rescoreQuery = o.rescoreQuery;
            this.rescoreQueryWeight = o.rescoreQueryWeight;
            this.scoreMode = o.scoreMode;
        }

        private Builder(Builder o) {
            this.queryWeight = o.queryWeight;
            this.rescoreQuery = o.rescoreQuery;
            this.rescoreQueryWeight = o.rescoreQueryWeight;
            this.scoreMode = o.scoreMode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The relative importance of the original query as compared to the rescore query.
         * <p>
         * API name: {@code query_weight}
         * </p>
         */
        @Nonnull
        public final Builder queryWeight(@Nullable Float value) {
            this.queryWeight = value;
            return this;
        }

        /**
         * Required - API name: {@code rescore_query}
         */
        @Nonnull
        public final Builder rescoreQuery(Query value) {
            this.rescoreQuery = value;
            return this;
        }

        /**
         * Required - API name: {@code rescore_query}
         */
        @Nonnull
        public final Builder rescoreQuery(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return rescoreQuery(fn.apply(new Query.Builder()).build());
        }

        /**
         * The relative importance of the rescore query as compared to the original query.
         * <p>
         * API name: {@code rescore_query_weight}
         * </p>
         */
        @Nonnull
        public final Builder rescoreQueryWeight(@Nullable Float value) {
            this.rescoreQueryWeight = value;
            return this;
        }

        /**
         * API name: {@code score_mode}
         */
        @Nonnull
        public final Builder scoreMode(@Nullable ScoreMode value) {
            this.scoreMode = value;
            return this;
        }

        /**
         * Builds a {@link RescoreQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RescoreQuery build() {
            _checkSingleUse();

            return new RescoreQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RescoreQuery}
     */
    public static final JsonpDeserializer<RescoreQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RescoreQuery::setupRescoreQueryDeserializer
    );

    protected static void setupRescoreQueryDeserializer(ObjectDeserializer<RescoreQuery.Builder> op) {
        op.add(Builder::queryWeight, JsonpDeserializer.floatDeserializer(), "query_weight");
        op.add(Builder::rescoreQuery, Query._DESERIALIZER, "rescore_query");
        op.add(Builder::rescoreQueryWeight, JsonpDeserializer.floatDeserializer(), "rescore_query_weight");
        op.add(Builder::scoreMode, ScoreMode._DESERIALIZER, "score_mode");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.queryWeight);
        result = 31 * result + this.rescoreQuery.hashCode();
        result = 31 * result + Objects.hashCode(this.rescoreQueryWeight);
        result = 31 * result + Objects.hashCode(this.scoreMode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RescoreQuery other = (RescoreQuery) o;
        return Objects.equals(this.queryWeight, other.queryWeight)
            && this.rescoreQuery.equals(other.rescoreQuery)
            && Objects.equals(this.rescoreQueryWeight, other.rescoreQueryWeight)
            && Objects.equals(this.scoreMode, other.scoreMode);
    }
}
