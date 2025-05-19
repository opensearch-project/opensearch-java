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

// typedef: nodes.stats.ShardIndexingPressurePerShardMemoryAllocationLimitStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardMemoryAllocationLimitStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<
            ShardIndexingPressurePerShardMemoryAllocationLimitStats.Builder,
            ShardIndexingPressurePerShardMemoryAllocationLimitStats> {

    private final long currentCoordinatingAndPrimaryLimitsInBytes;

    private final long currentReplicaLimitsInBytes;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardMemoryAllocationLimitStats(Builder builder) {
        this.currentCoordinatingAndPrimaryLimitsInBytes = ApiTypeHelper.requireNonNull(
            builder.currentCoordinatingAndPrimaryLimitsInBytes,
            this,
            "currentCoordinatingAndPrimaryLimitsInBytes"
        );
        this.currentReplicaLimitsInBytes = ApiTypeHelper.requireNonNull(
            builder.currentReplicaLimitsInBytes,
            this,
            "currentReplicaLimitsInBytes"
        );
    }

    public static ShardIndexingPressurePerShardMemoryAllocationLimitStats of(
        Function<
            ShardIndexingPressurePerShardMemoryAllocationLimitStats.Builder,
            ObjectBuilder<ShardIndexingPressurePerShardMemoryAllocationLimitStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code current_coordinating_and_primary_limits_in_bytes}
     */
    public final long currentCoordinatingAndPrimaryLimitsInBytes() {
        return this.currentCoordinatingAndPrimaryLimitsInBytes;
    }

    /**
     * Required - API name: {@code current_replica_limits_in_bytes}
     */
    public final long currentReplicaLimitsInBytes() {
        return this.currentReplicaLimitsInBytes;
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
        generator.writeKey("current_coordinating_and_primary_limits_in_bytes");
        generator.write(this.currentCoordinatingAndPrimaryLimitsInBytes);

        generator.writeKey("current_replica_limits_in_bytes");
        generator.write(this.currentReplicaLimitsInBytes);
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
     * Builder for {@link ShardIndexingPressurePerShardMemoryAllocationLimitStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardIndexingPressurePerShardMemoryAllocationLimitStats> {
        private Long currentCoordinatingAndPrimaryLimitsInBytes;
        private Long currentReplicaLimitsInBytes;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardMemoryAllocationLimitStats o) {
            this.currentCoordinatingAndPrimaryLimitsInBytes = o.currentCoordinatingAndPrimaryLimitsInBytes;
            this.currentReplicaLimitsInBytes = o.currentReplicaLimitsInBytes;
        }

        private Builder(Builder o) {
            this.currentCoordinatingAndPrimaryLimitsInBytes = o.currentCoordinatingAndPrimaryLimitsInBytes;
            this.currentReplicaLimitsInBytes = o.currentReplicaLimitsInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code current_coordinating_and_primary_limits_in_bytes}
         */
        @Nonnull
        public final Builder currentCoordinatingAndPrimaryLimitsInBytes(long value) {
            this.currentCoordinatingAndPrimaryLimitsInBytes = value;
            return this;
        }

        /**
         * Required - API name: {@code current_replica_limits_in_bytes}
         */
        @Nonnull
        public final Builder currentReplicaLimitsInBytes(long value) {
            this.currentReplicaLimitsInBytes = value;
            return this;
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardMemoryAllocationLimitStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardMemoryAllocationLimitStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardMemoryAllocationLimitStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardMemoryAllocationLimitStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardMemoryAllocationLimitStats> _DESERIALIZER = ObjectBuilderDeserializer
        .lazy(
            Builder::new,
            ShardIndexingPressurePerShardMemoryAllocationLimitStats::setupShardIndexingPressurePerShardMemoryAllocationLimitStatsDeserializer
        );

    protected static void setupShardIndexingPressurePerShardMemoryAllocationLimitStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardMemoryAllocationLimitStats.Builder> op
    ) {
        op.add(
            Builder::currentCoordinatingAndPrimaryLimitsInBytes,
            JsonpDeserializer.longDeserializer(),
            "current_coordinating_and_primary_limits_in_bytes"
        );
        op.add(Builder::currentReplicaLimitsInBytes, JsonpDeserializer.longDeserializer(), "current_replica_limits_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.currentCoordinatingAndPrimaryLimitsInBytes);
        result = 31 * result + Long.hashCode(this.currentReplicaLimitsInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardMemoryAllocationLimitStats other = (ShardIndexingPressurePerShardMemoryAllocationLimitStats) o;
        return this.currentCoordinatingAndPrimaryLimitsInBytes == other.currentCoordinatingAndPrimaryLimitsInBytes
            && this.currentReplicaLimitsInBytes == other.currentReplicaLimitsInBytes;
    }
}
