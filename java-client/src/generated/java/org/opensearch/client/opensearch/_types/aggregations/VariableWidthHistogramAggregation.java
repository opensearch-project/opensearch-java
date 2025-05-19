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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.VariableWidthHistogramAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class VariableWidthHistogramAggregation
    implements
        AggregationVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<VariableWidthHistogramAggregation.Builder, VariableWidthHistogramAggregation> {

    @Nullable
    private final Integer buckets;

    @Nullable
    private final String field;

    @Nullable
    private final Integer initialBuffer;

    @Nullable
    private final Integer shardSize;

    // ---------------------------------------------------------------------------------------------

    private VariableWidthHistogramAggregation(Builder builder) {
        this.buckets = builder.buckets;
        this.field = builder.field;
        this.initialBuffer = builder.initialBuffer;
        this.shardSize = builder.shardSize;
    }

    public static VariableWidthHistogramAggregation of(
        Function<VariableWidthHistogramAggregation.Builder, ObjectBuilder<VariableWidthHistogramAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Aggregation} variant kind.
     */
    @Override
    public Aggregation.Kind _aggregationKind() {
        return Aggregation.Kind.VariableWidthHistogram;
    }

    /**
     * The target number of buckets.
     * <p>
     * API name: {@code buckets}
     * </p>
     */
    @Nullable
    public final Integer buckets() {
        return this.buckets;
    }

    /**
     * API name: {@code field}
     */
    @Nullable
    public final String field() {
        return this.field;
    }

    /**
     * Specifies the number of individual documents that will be stored in memory on a shard before the initial bucketing algorithm is run.
     * Defaults to <code>min(10 * shard_size, 50000)</code>.
     * <p>
     * API name: {@code initial_buffer}
     * </p>
     */
    @Nullable
    public final Integer initialBuffer() {
        return this.initialBuffer;
    }

    /**
     * The number of buckets that the coordinating node will request from each shard. Defaults to <code>buckets * 50</code>.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
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
        if (this.buckets != null) {
            generator.writeKey("buckets");
            generator.write(this.buckets);
        }

        if (this.field != null) {
            generator.writeKey("field");
            generator.write(this.field);
        }

        if (this.initialBuffer != null) {
            generator.writeKey("initial_buffer");
            generator.write(this.initialBuffer);
        }

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
     * Builder for {@link VariableWidthHistogramAggregation}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, VariableWidthHistogramAggregation> {
        @Nullable
        private Integer buckets;
        @Nullable
        private String field;
        @Nullable
        private Integer initialBuffer;
        @Nullable
        private Integer shardSize;

        public Builder() {}

        private Builder(VariableWidthHistogramAggregation o) {
            this.buckets = o.buckets;
            this.field = o.field;
            this.initialBuffer = o.initialBuffer;
            this.shardSize = o.shardSize;
        }

        private Builder(Builder o) {
            this.buckets = o.buckets;
            this.field = o.field;
            this.initialBuffer = o.initialBuffer;
            this.shardSize = o.shardSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The target number of buckets.
         * <p>
         * API name: {@code buckets}
         * </p>
         */
        @Nonnull
        public final Builder buckets(@Nullable Integer value) {
            this.buckets = value;
            return this;
        }

        /**
         * API name: {@code field}
         */
        @Nonnull
        public final Builder field(@Nullable String value) {
            this.field = value;
            return this;
        }

        /**
         * Specifies the number of individual documents that will be stored in memory on a shard before the initial bucketing algorithm is
         * run. Defaults to <code>min(10 * shard_size, 50000)</code>.
         * <p>
         * API name: {@code initial_buffer}
         * </p>
         */
        @Nonnull
        public final Builder initialBuffer(@Nullable Integer value) {
            this.initialBuffer = value;
            return this;
        }

        /**
         * The number of buckets that the coordinating node will request from each shard. Defaults to <code>buckets * 50</code>.
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
         * Builds a {@link VariableWidthHistogramAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public VariableWidthHistogramAggregation build() {
            _checkSingleUse();

            return new VariableWidthHistogramAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link VariableWidthHistogramAggregation}
     */
    public static final JsonpDeserializer<VariableWidthHistogramAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        VariableWidthHistogramAggregation::setupVariableWidthHistogramAggregationDeserializer
    );

    protected static void setupVariableWidthHistogramAggregationDeserializer(
        ObjectDeserializer<VariableWidthHistogramAggregation.Builder> op
    ) {
        op.add(Builder::buckets, JsonpDeserializer.integerDeserializer(), "buckets");
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::initialBuffer, JsonpDeserializer.integerDeserializer(), "initial_buffer");
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.buckets);
        result = 31 * result + Objects.hashCode(this.field);
        result = 31 * result + Objects.hashCode(this.initialBuffer);
        result = 31 * result + Objects.hashCode(this.shardSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        VariableWidthHistogramAggregation other = (VariableWidthHistogramAggregation) o;
        return Objects.equals(this.buckets, other.buckets)
            && Objects.equals(this.field, other.field)
            && Objects.equals(this.initialBuffer, other.initialBuffer)
            && Objects.equals(this.shardSize, other.shardSize);
    }
}
