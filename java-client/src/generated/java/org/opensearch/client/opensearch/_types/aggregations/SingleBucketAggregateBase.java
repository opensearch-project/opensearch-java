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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.ExternallyTaggedUnion;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.aggregations.SingleBucketAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class SingleBucketAggregateBase extends AggregateBase {

    @Nonnull
    private final Map<String, Aggregate> aggregations;

    private final long docCount;

    // ---------------------------------------------------------------------------------------------

    protected SingleBucketAggregateBase(AbstractBuilder<?> builder) {
        super(builder);
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.docCount = ApiTypeHelper.requireNonNull(builder.docCount, this, "docCount");
    }

    @Nonnull
    public final Map<String, Aggregate> aggregations() {
        return this.aggregations;
    }

    /**
     * Required - API name: {@code doc_count}
     */
    public final long docCount() {
        return this.docCount;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        ExternallyTaggedUnion.serializeTypedKeysInner(this.aggregations, generator, mapper);
        generator.writeKey("doc_count");
        generator.write(this.docCount);
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends AggregateBase.AbstractBuilder<
        BuilderT> {
        private Long docCount;
        @Nullable
        protected Map<String, Aggregate> aggregations;

        protected AbstractBuilder() {}

        protected AbstractBuilder(SingleBucketAggregateBase o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.docCount = o.docCount;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.docCount = o.docCount;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT aggregations(Map<String, Aggregate> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return self();
        }

        /**
         *
         * <p>
         * Adds an entry to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT aggregations(String key, Aggregate value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return self();
        }

        /**
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final BuilderT aggregations(String key, Function<Aggregate.Builder, ObjectBuilder<Aggregate>> fn) {
            return aggregations(key, fn.apply(new Aggregate.Builder()).build());
        }

        /**
         * Required - API name: {@code doc_count}
         */
        @Nonnull
        public final BuilderT docCount(long value) {
            this.docCount = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSingleBucketAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAggregateBaseDeserializer(op);
        op.add(AbstractBuilder::docCount, JsonpDeserializer.longDeserializer(), "doc_count");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.aggregations == null) {
                builder.aggregations = new HashMap<>();
            }
            Aggregate._TYPED_KEYS_DESERIALIZER.deserializeEntry(name, parser, mapper, builder.aggregations);
        });
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Long.hashCode(this.docCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SingleBucketAggregateBase other = (SingleBucketAggregateBase) o;
        return Objects.equals(this.aggregations, other.aggregations) && this.docCount == other.docCount;
    }
}
