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

package org.opensearch.client.opensearch.core.rank_eval;

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

// typedef: core.rank_eval.RankEvalQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RankEvalQuery implements PlainJsonSerializable, ToCopyableBuilder<RankEvalQuery.Builder, RankEvalQuery> {

    @Nonnull
    private final Query query;

    @Nullable
    private final Integer size;

    // ---------------------------------------------------------------------------------------------

    private RankEvalQuery(Builder builder) {
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
        this.size = builder.size;
    }

    public static RankEvalQuery of(Function<RankEvalQuery.Builder, ObjectBuilder<RankEvalQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final Query query() {
        return this.query;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
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
        generator.writeKey("query");
        this.query.serialize(generator, mapper);

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
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
     * Builder for {@link RankEvalQuery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RankEvalQuery> {
        private Query query;
        @Nullable
        private Integer size;

        public Builder() {}

        private Builder(RankEvalQuery o) {
            this.query = o.query;
            this.size = o.size;
        }

        private Builder(Builder o) {
            this.query = o.query;
            this.size = o.size;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * Builds a {@link RankEvalQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalQuery build() {
            _checkSingleUse();

            return new RankEvalQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalQuery}
     */
    public static final JsonpDeserializer<RankEvalQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalQuery::setupRankEvalQueryDeserializer
    );

    protected static void setupRankEvalQueryDeserializer(ObjectDeserializer<RankEvalQuery.Builder> op) {
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.query.hashCode();
        result = 31 * result + Objects.hashCode(this.size);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalQuery other = (RankEvalQuery) o;
        return this.query.equals(other.query) && Objects.equals(this.size, other.size);
    }
}
