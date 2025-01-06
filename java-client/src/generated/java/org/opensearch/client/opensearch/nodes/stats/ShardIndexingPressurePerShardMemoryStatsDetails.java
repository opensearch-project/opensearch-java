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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ShardIndexingPressurePerShardMemoryStatsDetails

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardMemoryStatsDetails
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressurePerShardMemoryStatsDetails.Builder, ShardIndexingPressurePerShardMemoryStatsDetails> {

    @Nullable
    private final String coordinating;

    private final long coordinatingInBytes;

    @Nullable
    private final String primary;

    private final long primaryInBytes;

    @Nullable
    private final String replica;

    private final long replicaInBytes;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardMemoryStatsDetails(Builder builder) {
        this.coordinating = builder.coordinating;
        this.coordinatingInBytes = ApiTypeHelper.requireNonNull(builder.coordinatingInBytes, this, "coordinatingInBytes");
        this.primary = builder.primary;
        this.primaryInBytes = ApiTypeHelper.requireNonNull(builder.primaryInBytes, this, "primaryInBytes");
        this.replica = builder.replica;
        this.replicaInBytes = ApiTypeHelper.requireNonNull(builder.replicaInBytes, this, "replicaInBytes");
    }

    public static ShardIndexingPressurePerShardMemoryStatsDetails of(
        Function<ShardIndexingPressurePerShardMemoryStatsDetails.Builder, ObjectBuilder<ShardIndexingPressurePerShardMemoryStatsDetails>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code coordinating}
     */
    @Nullable
    public final String coordinating() {
        return this.coordinating;
    }

    /**
     * Required - API name: {@code coordinating_in_bytes}
     */
    public final long coordinatingInBytes() {
        return this.coordinatingInBytes;
    }

    /**
     * API name: {@code primary}
     */
    @Nullable
    public final String primary() {
        return this.primary;
    }

    /**
     * Required - API name: {@code primary_in_bytes}
     */
    public final long primaryInBytes() {
        return this.primaryInBytes;
    }

    /**
     * API name: {@code replica}
     */
    @Nullable
    public final String replica() {
        return this.replica;
    }

    /**
     * Required - API name: {@code replica_in_bytes}
     */
    public final long replicaInBytes() {
        return this.replicaInBytes;
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
        if (this.coordinating != null) {
            generator.writeKey("coordinating");
            generator.write(this.coordinating);
        }

        generator.writeKey("coordinating_in_bytes");
        generator.write(this.coordinatingInBytes);

        if (this.primary != null) {
            generator.writeKey("primary");
            generator.write(this.primary);
        }

        generator.writeKey("primary_in_bytes");
        generator.write(this.primaryInBytes);

        if (this.replica != null) {
            generator.writeKey("replica");
            generator.write(this.replica);
        }

        generator.writeKey("replica_in_bytes");
        generator.write(this.replicaInBytes);
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
     * Builder for {@link ShardIndexingPressurePerShardMemoryStatsDetails}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardIndexingPressurePerShardMemoryStatsDetails> {
        @Nullable
        private String coordinating;
        private Long coordinatingInBytes;
        @Nullable
        private String primary;
        private Long primaryInBytes;
        @Nullable
        private String replica;
        private Long replicaInBytes;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardMemoryStatsDetails o) {
            this.coordinating = o.coordinating;
            this.coordinatingInBytes = o.coordinatingInBytes;
            this.primary = o.primary;
            this.primaryInBytes = o.primaryInBytes;
            this.replica = o.replica;
            this.replicaInBytes = o.replicaInBytes;
        }

        private Builder(Builder o) {
            this.coordinating = o.coordinating;
            this.coordinatingInBytes = o.coordinatingInBytes;
            this.primary = o.primary;
            this.primaryInBytes = o.primaryInBytes;
            this.replica = o.replica;
            this.replicaInBytes = o.replicaInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code coordinating}
         */
        @Nonnull
        public final Builder coordinating(@Nullable String value) {
            this.coordinating = value;
            return this;
        }

        /**
         * Required - API name: {@code coordinating_in_bytes}
         */
        @Nonnull
        public final Builder coordinatingInBytes(long value) {
            this.coordinatingInBytes = value;
            return this;
        }

        /**
         * API name: {@code primary}
         */
        @Nonnull
        public final Builder primary(@Nullable String value) {
            this.primary = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_in_bytes}
         */
        @Nonnull
        public final Builder primaryInBytes(long value) {
            this.primaryInBytes = value;
            return this;
        }

        /**
         * API name: {@code replica}
         */
        @Nonnull
        public final Builder replica(@Nullable String value) {
            this.replica = value;
            return this;
        }

        /**
         * Required - API name: {@code replica_in_bytes}
         */
        @Nonnull
        public final Builder replicaInBytes(long value) {
            this.replicaInBytes = value;
            return this;
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardMemoryStatsDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardMemoryStatsDetails build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardMemoryStatsDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardMemoryStatsDetails}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardMemoryStatsDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIndexingPressurePerShardMemoryStatsDetails::setupShardIndexingPressurePerShardMemoryStatsDetailsDeserializer
    );

    protected static void setupShardIndexingPressurePerShardMemoryStatsDetailsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardMemoryStatsDetails.Builder> op
    ) {
        op.add(Builder::coordinating, JsonpDeserializer.stringDeserializer(), "coordinating");
        op.add(Builder::coordinatingInBytes, JsonpDeserializer.longDeserializer(), "coordinating_in_bytes");
        op.add(Builder::primary, JsonpDeserializer.stringDeserializer(), "primary");
        op.add(Builder::primaryInBytes, JsonpDeserializer.longDeserializer(), "primary_in_bytes");
        op.add(Builder::replica, JsonpDeserializer.stringDeserializer(), "replica");
        op.add(Builder::replicaInBytes, JsonpDeserializer.longDeserializer(), "replica_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.coordinating);
        result = 31 * result + Long.hashCode(this.coordinatingInBytes);
        result = 31 * result + Objects.hashCode(this.primary);
        result = 31 * result + Long.hashCode(this.primaryInBytes);
        result = 31 * result + Objects.hashCode(this.replica);
        result = 31 * result + Long.hashCode(this.replicaInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardMemoryStatsDetails other = (ShardIndexingPressurePerShardMemoryStatsDetails) o;
        return Objects.equals(this.coordinating, other.coordinating)
            && this.coordinatingInBytes == other.coordinatingInBytes
            && Objects.equals(this.primary, other.primary)
            && this.primaryInBytes == other.primaryInBytes
            && Objects.equals(this.replica, other.replica)
            && this.replicaInBytes == other.replicaInBytes;
    }
}
