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
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.SamplerAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SamplerAggregation extends BucketAggregationBase
    implements
        AggregationVariant,
        ToCopyableBuilder<SamplerAggregation.Builder, SamplerAggregation> {

    @Nullable
    private final Integer shardSize;

    // ---------------------------------------------------------------------------------------------

    private SamplerAggregation(Builder builder) {
        super(builder);
        this.shardSize = builder.shardSize;
    }

    public static SamplerAggregation of(Function<SamplerAggregation.Builder, ObjectBuilder<SamplerAggregation>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.Sampler;
    }

    /**
     * Limits how many top-scoring documents are collected in the sample processed on each shard.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
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
     * Builder for {@link SamplerAggregation}.
     */
    public static class Builder extends BucketAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, SamplerAggregation> {
        @Nullable
        private Integer shardSize;

        public Builder() {}

        private Builder(SamplerAggregation o) {
            super(o);
            this.shardSize = o.shardSize;
        }

        private Builder(Builder o) {
            super(o);
            this.shardSize = o.shardSize;
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
         * Limits how many top-scoring documents are collected in the sample processed on each shard.
         * <p>
         * API name: {@code shard_size}
         * </p>
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * Builds a {@link SamplerAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SamplerAggregation build() {
            _checkSingleUse();

            return new SamplerAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SamplerAggregation}
     */
    public static final JsonpDeserializer<SamplerAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SamplerAggregation::setupSamplerAggregationDeserializer
    );

    protected static void setupSamplerAggregationDeserializer(ObjectDeserializer<SamplerAggregation.Builder> op) {
        setupBucketAggregationBaseDeserializer(op);
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.shardSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SamplerAggregation other = (SamplerAggregation) o;
        return Objects.equals(this.shardSize, other.shardSize);
    }
}
