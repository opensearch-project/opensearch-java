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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.aggregations.MultiBucketAggregateBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class MultiBucketAggregateBase<TBucket> extends AggregateBase {

    @Nonnull
    private final Buckets<TBucket> buckets;

    // ---------------------------------------------------------------------------------------------

    protected MultiBucketAggregateBase(AbstractBuilder<TBucket, ?> builder) {
        super(builder);
        this.buckets = ApiTypeHelper.requireNonNull(builder.buckets, this, "buckets");
    }

    /**
     * Required - API name: {@code buckets}
     */
    @Nonnull
    public final Buckets<TBucket> buckets() {
        return this.buckets;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("buckets");
        this.buckets.serialize(generator, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<TBucket, BuilderT extends AbstractBuilder<TBucket, BuilderT>> extends
        AggregateBase.AbstractBuilder<BuilderT> {
        private Buckets<TBucket> buckets;

        protected AbstractBuilder() {}

        protected AbstractBuilder(MultiBucketAggregateBase<TBucket> o) {
            super(o);
            this.buckets = o.buckets;
        }

        protected AbstractBuilder(AbstractBuilder<TBucket, BuilderT> o) {
            super(o);
            this.buckets = o.buckets;
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final BuilderT buckets(Buckets<TBucket> value) {
            this.buckets = value;
            return self();
        }

        /**
         * Required - API name: {@code buckets}
         */
        @Nonnull
        public final BuilderT buckets(Function<Buckets.Builder<TBucket>, ObjectBuilder<Buckets<TBucket>>> fn) {
            return buckets(fn.apply(new Buckets.Builder<TBucket>()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <TBucket, BuilderT extends AbstractBuilder<TBucket, BuilderT>> void setupMultiBucketAggregateBaseDeserializer(
        ObjectDeserializer<BuilderT> op,
        JsonpDeserializer<TBucket> tBucketDeserializer
    ) {
        setupAggregateBaseDeserializer(op);
        op.add(AbstractBuilder::buckets, Buckets.createBucketsDeserializer(tBucketDeserializer), "buckets");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.buckets.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MultiBucketAggregateBase<?> other = (MultiBucketAggregateBase<?>) o;
        return this.buckets.equals(other.buckets);
    }
}
