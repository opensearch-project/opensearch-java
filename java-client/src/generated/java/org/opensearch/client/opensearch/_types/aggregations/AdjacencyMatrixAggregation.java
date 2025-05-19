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

package org.opensearch.client.opensearch._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
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
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.AdjacencyMatrixAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AdjacencyMatrixAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<AdjacencyMatrixAggregation.Builder, AdjacencyMatrixAggregation> {

    @Nonnull
    private final Map<String, Query> filters;

    // ---------------------------------------------------------------------------------------------

    private AdjacencyMatrixAggregation(Builder builder) {
        super(builder);
        this.filters = ApiTypeHelper.unmodifiable(builder.filters);
    }

    public static AdjacencyMatrixAggregation of(
        Function<AdjacencyMatrixAggregation.Builder, ObjectBuilder<AdjacencyMatrixAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.AdjacencyMatrix;
    }

    /**
     * Filters used to create buckets. At least one filter is required.
     * <p>
     * API name: {@code filters}
     * </p>
     */
    @Nonnull
    public final Map<String, Query> filters() {
        return this.filters;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.filters)) {
            generator.writeKey("filters");
            generator.writeStartObject();
            for (Map.Entry<String, Query> item0 : this.filters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link AdjacencyMatrixAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, AdjacencyMatrixAggregation> {
        @Nullable
        private Map<String, Query> filters;

        public Builder() {}

        private Builder(AdjacencyMatrixAggregation o) {
            super(o);
            this.filters = _mapCopy(o.filters);
        }

        private Builder(Builder o) {
            super(o);
            this.filters = _mapCopy(o.filters);
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
         * Filters used to create buckets. At least one filter is required.
         * <p>
         * API name: {@code filters}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>filters</code>.
         * </p>
         */
        @Nonnull
        public final Builder filters(Map<String, Query> map) {
            this.filters = _mapPutAll(this.filters, map);
            return this;
        }

        /**
         * Filters used to create buckets. At least one filter is required.
         * <p>
         * API name: {@code filters}
         * </p>
         *
         * <p>
         * Adds an entry to <code>filters</code>.
         * </p>
         */
        @Nonnull
        public final Builder filters(String key, Query value) {
            this.filters = _mapPut(this.filters, key, value);
            return this;
        }

        /**
         * Filters used to create buckets. At least one filter is required.
         * <p>
         * API name: {@code filters}
         * </p>
         *
         * <p>
         * Adds a value to <code>filters</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder filters(String key, Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return filters(key, fn.apply(new Query.Builder()).build());
        }

        /**
         * Builds a {@link AdjacencyMatrixAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AdjacencyMatrixAggregation build() {
            _checkSingleUse();

            return new AdjacencyMatrixAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AdjacencyMatrixAggregation}
     */
    public static final JsonpDeserializer<AdjacencyMatrixAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AdjacencyMatrixAggregation::setupAdjacencyMatrixAggregationDeserializer
    );

    protected static void setupAdjacencyMatrixAggregationDeserializer(ObjectDeserializer<AdjacencyMatrixAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::filters, JsonpDeserializer.stringMapDeserializer(Query._DESERIALIZER), "filters");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.filters);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AdjacencyMatrixAggregation other = (AdjacencyMatrixAggregation) o;
        return Objects.equals(this.filters, other.filters);
    }
}
