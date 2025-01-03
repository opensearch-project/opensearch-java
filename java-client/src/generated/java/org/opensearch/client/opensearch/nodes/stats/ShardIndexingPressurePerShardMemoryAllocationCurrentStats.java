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

// typedef: nodes.stats.ShardIndexingPressurePerShardMemoryAllocationCurrentStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardMemoryAllocationCurrentStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<
            ShardIndexingPressurePerShardMemoryAllocationCurrentStats.Builder,
            ShardIndexingPressurePerShardMemoryAllocationCurrentStats> {

    private final long currentCoordinatingAndPrimaryBytes;

    private final long currentReplicaBytes;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardMemoryAllocationCurrentStats(Builder builder) {
        this.currentCoordinatingAndPrimaryBytes = ApiTypeHelper.requireNonNull(
            builder.currentCoordinatingAndPrimaryBytes,
            this,
            "currentCoordinatingAndPrimaryBytes"
        );
        this.currentReplicaBytes = ApiTypeHelper.requireNonNull(builder.currentReplicaBytes, this, "currentReplicaBytes");
    }

    public static ShardIndexingPressurePerShardMemoryAllocationCurrentStats of(
        Function<
            ShardIndexingPressurePerShardMemoryAllocationCurrentStats.Builder,
            ObjectBuilder<ShardIndexingPressurePerShardMemoryAllocationCurrentStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code current_coordinating_and_primary_bytes}
     */
    public final long currentCoordinatingAndPrimaryBytes() {
        return this.currentCoordinatingAndPrimaryBytes;
    }

    /**
     * Required - API name: {@code current_replica_bytes}
     */
    public final long currentReplicaBytes() {
        return this.currentReplicaBytes;
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
        generator.writeKey("current_coordinating_and_primary_bytes");
        generator.write(this.currentCoordinatingAndPrimaryBytes);

        generator.writeKey("current_replica_bytes");
        generator.write(this.currentReplicaBytes);
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
     * Builder for {@link ShardIndexingPressurePerShardMemoryAllocationCurrentStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardIndexingPressurePerShardMemoryAllocationCurrentStats> {
        private Long currentCoordinatingAndPrimaryBytes;
        private Long currentReplicaBytes;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardMemoryAllocationCurrentStats o) {
            this.currentCoordinatingAndPrimaryBytes = o.currentCoordinatingAndPrimaryBytes;
            this.currentReplicaBytes = o.currentReplicaBytes;
        }

        private Builder(Builder o) {
            this.currentCoordinatingAndPrimaryBytes = o.currentCoordinatingAndPrimaryBytes;
            this.currentReplicaBytes = o.currentReplicaBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code current_coordinating_and_primary_bytes}
         */
        @Nonnull
        public final Builder currentCoordinatingAndPrimaryBytes(long value) {
            this.currentCoordinatingAndPrimaryBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code current_replica_bytes}
         */
        @Nonnull
        public final Builder currentReplicaBytes(long value) {
            this.currentReplicaBytes = value;
            return this;
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardMemoryAllocationCurrentStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardMemoryAllocationCurrentStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardMemoryAllocationCurrentStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardMemoryAllocationCurrentStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardMemoryAllocationCurrentStats> _DESERIALIZER =
        ObjectBuilderDeserializer.lazy(
            Builder::new,
            ShardIndexingPressurePerShardMemoryAllocationCurrentStats::setupShardIndexingPressurePerShardMemoryAllocationCurrentStatsDeserializer
        );

    protected static void setupShardIndexingPressurePerShardMemoryAllocationCurrentStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardMemoryAllocationCurrentStats.Builder> op
    ) {
        op.add(Builder::currentCoordinatingAndPrimaryBytes, JsonpDeserializer.longDeserializer(), "current_coordinating_and_primary_bytes");
        op.add(Builder::currentReplicaBytes, JsonpDeserializer.longDeserializer(), "current_replica_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.currentCoordinatingAndPrimaryBytes);
        result = 31 * result + Long.hashCode(this.currentReplicaBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardMemoryAllocationCurrentStats other = (ShardIndexingPressurePerShardMemoryAllocationCurrentStats) o;
        return this.currentCoordinatingAndPrimaryBytes == other.currentCoordinatingAndPrimaryBytes
            && this.currentReplicaBytes == other.currentReplicaBytes;
    }
}
