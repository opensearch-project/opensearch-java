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

// typedef: _types.query_dsl.BoostingQuery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BoostingQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<BoostingQuery.Builder, BoostingQuery> {

    @Nonnull
    private final Query negative;

    private final float negativeBoost;

    @Nonnull
    private final Query positive;

    // ---------------------------------------------------------------------------------------------

    private BoostingQuery(Builder builder) {
        super(builder);
        this.negative = ApiTypeHelper.requireNonNull(builder.negative, this, "negative");
        this.negativeBoost = ApiTypeHelper.requireNonNull(builder.negativeBoost, this, "negativeBoost");
        this.positive = ApiTypeHelper.requireNonNull(builder.positive, this, "positive");
    }

    public static BoostingQuery of(Function<BoostingQuery.Builder, ObjectBuilder<BoostingQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.Boosting;
    }

    /**
     * Required - API name: {@code negative}
     */
    @Nonnull
    public final Query negative() {
        return this.negative;
    }

    /**
     * Required - Floating point number between 0 and 1.0 used to decrease the relevance scores of documents matching the
     * <code>negative</code> query.
     * <p>
     * API name: {@code negative_boost}
     * </p>
     */
    public final float negativeBoost() {
        return this.negativeBoost;
    }

    /**
     * Required - API name: {@code positive}
     */
    @Nonnull
    public final Query positive() {
        return this.positive;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("negative");
        this.negative.serialize(generator, mapper);

        generator.writeKey("negative_boost");
        generator.write(this.negativeBoost);

        generator.writeKey("positive");
        this.positive.serialize(generator, mapper);
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
     * Builder for {@link BoostingQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, BoostingQuery> {
        private Query negative;
        private Float negativeBoost;
        private Query positive;

        public Builder() {}

        private Builder(BoostingQuery o) {
            super(o);
            this.negative = o.negative;
            this.negativeBoost = o.negativeBoost;
            this.positive = o.positive;
        }

        private Builder(Builder o) {
            super(o);
            this.negative = o.negative;
            this.negativeBoost = o.negativeBoost;
            this.positive = o.positive;
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
         * Required - API name: {@code negative}
         */
        @Nonnull
        public final Builder negative(Query value) {
            this.negative = value;
            return this;
        }

        /**
         * Required - API name: {@code negative}
         */
        @Nonnull
        public final Builder negative(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return negative(fn.apply(new Query.Builder()).build());
        }

        /**
         * Required - Floating point number between 0 and 1.0 used to decrease the relevance scores of documents matching the
         * <code>negative</code> query.
         * <p>
         * API name: {@code negative_boost}
         * </p>
         */
        @Nonnull
        public final Builder negativeBoost(float value) {
            this.negativeBoost = value;
            return this;
        }

        /**
         * Required - API name: {@code positive}
         */
        @Nonnull
        public final Builder positive(Query value) {
            this.positive = value;
            return this;
        }

        /**
         * Required - API name: {@code positive}
         */
        @Nonnull
        public final Builder positive(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return positive(fn.apply(new Query.Builder()).build());
        }

        /**
         * Builds a {@link BoostingQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public BoostingQuery build() {
            _checkSingleUse();

            return new BoostingQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link BoostingQuery}
     */
    public static final JsonpDeserializer<BoostingQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        BoostingQuery::setupBoostingQueryDeserializer
    );

    protected static void setupBoostingQueryDeserializer(ObjectDeserializer<BoostingQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::negative, Query._DESERIALIZER, "negative");
        op.add(Builder::negativeBoost, JsonpDeserializer.floatDeserializer(), "negative_boost");
        op.add(Builder::positive, Query._DESERIALIZER, "positive");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.negative.hashCode();
        result = 31 * result + Float.hashCode(this.negativeBoost);
        result = 31 * result + this.positive.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BoostingQuery other = (BoostingQuery) o;
        return this.negative.equals(other.negative) && this.negativeBoost == other.negativeBoost && this.positive.equals(other.positive);
    }
}
