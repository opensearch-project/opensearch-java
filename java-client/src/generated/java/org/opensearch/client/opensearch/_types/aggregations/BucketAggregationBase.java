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
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.aggregations.BucketAggregationBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class BucketAggregationBase extends AggregationBase {

    @Nonnull
    private final Map<String, Aggregation> aggregations;

    @Nonnull
    private final Map<String, Aggregation> aggs;

    // ---------------------------------------------------------------------------------------------

    protected BucketAggregationBase(AbstractBuilder<?> builder) {
        super(builder);
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.aggs = ApiTypeHelper.unmodifiable(builder.aggs);
    }

    /**
     * Sub-aggregations for this bucket aggregation
     * <p>
     * API name: {@code aggregations}
     * </p>
     */
    @Nonnull
    public final Map<String, Aggregation> aggregations() {
        return this.aggregations;
    }

    /**
     * Sub-aggregations for this bucket aggregation
     * <p>
     * API name: {@code aggs}
     * </p>
     */
    @Nonnull
    public final Map<String, Aggregation> aggs() {
        return this.aggs;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            generator.writeStartObject();
            for (Map.Entry<String, Aggregation> item0 : this.aggregations.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.aggs)) {
            generator.writeKey("aggs");
            generator.writeStartObject();
            for (Map.Entry<String, Aggregation> item0 : this.aggs.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends AggregationBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private Map<String, Aggregation> aggregations;
        @Nullable
        private Map<String, Aggregation> aggs;

        protected AbstractBuilder() {}

        protected AbstractBuilder(BucketAggregationBase o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.aggs = _mapCopy(o.aggs);
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.aggs = _mapCopy(o.aggs);
        }

        /**
         * Sub-aggregations for this bucket aggregation
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT aggregations(Map<String, Aggregation> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return self();
        }

        /**
         * Sub-aggregations for this bucket aggregation
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT aggregations(String key, Aggregation value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return self();
        }

        /**
         * Sub-aggregations for this bucket aggregation
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final BuilderT aggregations(String key, Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return aggregations(key, fn.apply(new Aggregation.Builder()).build());
        }

        /**
         * Sub-aggregations for this bucket aggregation
         * <p>
         * API name: {@code aggs}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggs</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT aggs(Map<String, Aggregation> map) {
            this.aggs = _mapPutAll(this.aggs, map);
            return self();
        }

        /**
         * Sub-aggregations for this bucket aggregation
         * <p>
         * API name: {@code aggs}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aggs</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT aggs(String key, Aggregation value) {
            this.aggs = _mapPut(this.aggs, key, value);
            return self();
        }

        /**
         * Sub-aggregations for this bucket aggregation
         * <p>
         * API name: {@code aggs}
         * </p>
         *
         * <p>
         * Adds a value to <code>aggs</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final BuilderT aggs(String key, Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return aggs(key, fn.apply(new Aggregation.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupBucketAggregationBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAggregationBaseDeserializer(op);
        op.add(AbstractBuilder::aggregations, JsonpDeserializer.stringMapDeserializer(Aggregation._DESERIALIZER), "aggregations");
        op.add(AbstractBuilder::aggs, JsonpDeserializer.stringMapDeserializer(Aggregation._DESERIALIZER), "aggs");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Objects.hashCode(this.aggs);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BucketAggregationBase other = (BucketAggregationBase) o;
        return Objects.equals(this.aggregations, other.aggregations) && Objects.equals(this.aggs, other.aggs);
    }
}
