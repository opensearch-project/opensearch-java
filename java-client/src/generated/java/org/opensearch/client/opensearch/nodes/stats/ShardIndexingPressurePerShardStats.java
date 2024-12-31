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

package org.opensearch.client.opensearch.nodes.stats;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ShardIndexingPressurePerShardStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressurePerShardStats.Builder, ShardIndexingPressurePerShardStats> {

    @Nonnull
    private final ShardIndexingPressurePerShardIndexingStats indexing;

    @Nonnull
    private final ShardIndexingPressurePerShardLastSuccessfulTimestamp lastSuccessfulTimestamp;

    @Nonnull
    private final ShardIndexingPressurePerShardMemoryStats memory;

    @Nonnull
    private final ShardIndexingPressurePerShardMemoryAllocationStats memoryAllocation;

    @Nonnull
    private final ShardIndexingPressurePerShardRejectionStats rejection;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardStats(Builder builder) {
        this.indexing = ApiTypeHelper.requireNonNull(builder.indexing, this, "indexing");
        this.lastSuccessfulTimestamp = ApiTypeHelper.requireNonNull(builder.lastSuccessfulTimestamp, this, "lastSuccessfulTimestamp");
        this.memory = ApiTypeHelper.requireNonNull(builder.memory, this, "memory");
        this.memoryAllocation = ApiTypeHelper.requireNonNull(builder.memoryAllocation, this, "memoryAllocation");
        this.rejection = ApiTypeHelper.requireNonNull(builder.rejection, this, "rejection");
    }

    public static ShardIndexingPressurePerShardStats of(
        Function<ShardIndexingPressurePerShardStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code indexing}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardIndexingStats indexing() {
        return this.indexing;
    }

    /**
     * Required - API name: {@code last_successful_timestamp}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardLastSuccessfulTimestamp lastSuccessfulTimestamp() {
        return this.lastSuccessfulTimestamp;
    }

    /**
     * Required - API name: {@code memory}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardMemoryStats memory() {
        return this.memory;
    }

    /**
     * Required - API name: {@code memory_allocation}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardMemoryAllocationStats memoryAllocation() {
        return this.memoryAllocation;
    }

    /**
     * Required - API name: {@code rejection}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardRejectionStats rejection() {
        return this.rejection;
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
        generator.writeKey("indexing");
        this.indexing.serialize(generator, mapper);

        generator.writeKey("last_successful_timestamp");
        this.lastSuccessfulTimestamp.serialize(generator, mapper);

        generator.writeKey("memory");
        this.memory.serialize(generator, mapper);

        generator.writeKey("memory_allocation");
        this.memoryAllocation.serialize(generator, mapper);

        generator.writeKey("rejection");
        this.rejection.serialize(generator, mapper);
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
     * Builder for {@link ShardIndexingPressurePerShardStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardIndexingPressurePerShardStats> {
        private ShardIndexingPressurePerShardIndexingStats indexing;
        private ShardIndexingPressurePerShardLastSuccessfulTimestamp lastSuccessfulTimestamp;
        private ShardIndexingPressurePerShardMemoryStats memory;
        private ShardIndexingPressurePerShardMemoryAllocationStats memoryAllocation;
        private ShardIndexingPressurePerShardRejectionStats rejection;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardStats o) {
            this.indexing = o.indexing;
            this.lastSuccessfulTimestamp = o.lastSuccessfulTimestamp;
            this.memory = o.memory;
            this.memoryAllocation = o.memoryAllocation;
            this.rejection = o.rejection;
        }

        private Builder(Builder o) {
            this.indexing = o.indexing;
            this.lastSuccessfulTimestamp = o.lastSuccessfulTimestamp;
            this.memory = o.memory;
            this.memoryAllocation = o.memoryAllocation;
            this.rejection = o.rejection;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code indexing}
         */
        @Nonnull
        public final Builder indexing(ShardIndexingPressurePerShardIndexingStats value) {
            this.indexing = value;
            return this;
        }

        /**
         * Required - API name: {@code indexing}
         */
        @Nonnull
        public final Builder indexing(
            Function<ShardIndexingPressurePerShardIndexingStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardIndexingStats>> fn
        ) {
            return indexing(fn.apply(new ShardIndexingPressurePerShardIndexingStats.Builder()).build());
        }

        /**
         * Required - API name: {@code last_successful_timestamp}
         */
        @Nonnull
        public final Builder lastSuccessfulTimestamp(ShardIndexingPressurePerShardLastSuccessfulTimestamp value) {
            this.lastSuccessfulTimestamp = value;
            return this;
        }

        /**
         * Required - API name: {@code last_successful_timestamp}
         */
        @Nonnull
        public final Builder lastSuccessfulTimestamp(
            Function<
                ShardIndexingPressurePerShardLastSuccessfulTimestamp.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardLastSuccessfulTimestamp>> fn
        ) {
            return lastSuccessfulTimestamp(fn.apply(new ShardIndexingPressurePerShardLastSuccessfulTimestamp.Builder()).build());
        }

        /**
         * Required - API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(ShardIndexingPressurePerShardMemoryStats value) {
            this.memory = value;
            return this;
        }

        /**
         * Required - API name: {@code memory}
         */
        @Nonnull
        public final Builder memory(
            Function<ShardIndexingPressurePerShardMemoryStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardMemoryStats>> fn
        ) {
            return memory(fn.apply(new ShardIndexingPressurePerShardMemoryStats.Builder()).build());
        }

        /**
         * Required - API name: {@code memory_allocation}
         */
        @Nonnull
        public final Builder memoryAllocation(ShardIndexingPressurePerShardMemoryAllocationStats value) {
            this.memoryAllocation = value;
            return this;
        }

        /**
         * Required - API name: {@code memory_allocation}
         */
        @Nonnull
        public final Builder memoryAllocation(
            Function<
                ShardIndexingPressurePerShardMemoryAllocationStats.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardMemoryAllocationStats>> fn
        ) {
            return memoryAllocation(fn.apply(new ShardIndexingPressurePerShardMemoryAllocationStats.Builder()).build());
        }

        /**
         * Required - API name: {@code rejection}
         */
        @Nonnull
        public final Builder rejection(ShardIndexingPressurePerShardRejectionStats value) {
            this.rejection = value;
            return this;
        }

        /**
         * Required - API name: {@code rejection}
         */
        @Nonnull
        public final Builder rejection(
            Function<ShardIndexingPressurePerShardRejectionStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardRejectionStats>> fn
        ) {
            return rejection(fn.apply(new ShardIndexingPressurePerShardRejectionStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIndexingPressurePerShardStats::setupShardIndexingPressurePerShardStatsDeserializer
    );

    protected static void setupShardIndexingPressurePerShardStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardStats.Builder> op
    ) {
        op.add(Builder::indexing, ShardIndexingPressurePerShardIndexingStats._DESERIALIZER, "indexing");
        op.add(
            Builder::lastSuccessfulTimestamp,
            ShardIndexingPressurePerShardLastSuccessfulTimestamp._DESERIALIZER,
            "last_successful_timestamp"
        );
        op.add(Builder::memory, ShardIndexingPressurePerShardMemoryStats._DESERIALIZER, "memory");
        op.add(Builder::memoryAllocation, ShardIndexingPressurePerShardMemoryAllocationStats._DESERIALIZER, "memory_allocation");
        op.add(Builder::rejection, ShardIndexingPressurePerShardRejectionStats._DESERIALIZER, "rejection");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.indexing.hashCode();
        result = 31 * result + this.lastSuccessfulTimestamp.hashCode();
        result = 31 * result + this.memory.hashCode();
        result = 31 * result + this.memoryAllocation.hashCode();
        result = 31 * result + this.rejection.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardStats other = (ShardIndexingPressurePerShardStats) o;
        return this.indexing.equals(other.indexing)
            && this.lastSuccessfulTimestamp.equals(other.lastSuccessfulTimestamp)
            && this.memory.equals(other.memory)
            && this.memoryAllocation.equals(other.memoryAllocation)
            && this.rejection.equals(other.rejection);
    }
}
