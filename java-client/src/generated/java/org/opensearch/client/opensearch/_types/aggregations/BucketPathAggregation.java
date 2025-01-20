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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: _types.aggregations.BucketPathAggregation

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class BucketPathAggregation extends AggregationBase {

    @Nullable
    private final BucketsPath bucketsPath;

    // ---------------------------------------------------------------------------------------------

    protected BucketPathAggregation(AbstractBuilder<?> builder) {
        super(builder);
        this.bucketsPath = builder.bucketsPath;
    }

    /**
     * API name: {@code buckets_path}
     */
    @Nullable
    public final BucketsPath bucketsPath() {
        return this.bucketsPath;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.bucketsPath != null) {
            generator.writeKey("buckets_path");
            this.bucketsPath.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends AggregationBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private BucketsPath bucketsPath;

        protected AbstractBuilder() {}

        protected AbstractBuilder(BucketPathAggregation o) {
            super(o);
            this.bucketsPath = o.bucketsPath;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.bucketsPath = o.bucketsPath;
        }

        /**
         * API name: {@code buckets_path}
         */
        @Nonnull
        public final BuilderT bucketsPath(@Nullable BucketsPath value) {
            this.bucketsPath = value;
            return self();
        }

        /**
         * API name: {@code buckets_path}
         */
        @Nonnull
        public final BuilderT bucketsPath(Function<BucketsPath.Builder, ObjectBuilder<BucketsPath>> fn) {
            return bucketsPath(fn.apply(new BucketsPath.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupBucketPathAggregationDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupAggregationBaseDeserializer(op);
        op.add(AbstractBuilder::bucketsPath, BucketsPath._DESERIALIZER, "buckets_path");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.bucketsPath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        BucketPathAggregation other = (BucketPathAggregation) o;
        return Objects.equals(this.bucketsPath, other.bucketsPath);
    }
}
