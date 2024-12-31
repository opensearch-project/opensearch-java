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

// typedef: nodes.stats.ShardIndexingPressurePerShardIndexingStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardIndexingStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressurePerShardIndexingStats.Builder, ShardIndexingPressurePerShardIndexingStats> {

    private final long coordinatingCount;

    private final long coordinatingTimeInMillis;

    private final long primaryCount;

    private final long primaryTimeInMillis;

    private final long replicaCount;

    private final long replicaTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardIndexingStats(Builder builder) {
        this.coordinatingCount = ApiTypeHelper.requireNonNull(builder.coordinatingCount, this, "coordinatingCount");
        this.coordinatingTimeInMillis = ApiTypeHelper.requireNonNull(builder.coordinatingTimeInMillis, this, "coordinatingTimeInMillis");
        this.primaryCount = ApiTypeHelper.requireNonNull(builder.primaryCount, this, "primaryCount");
        this.primaryTimeInMillis = ApiTypeHelper.requireNonNull(builder.primaryTimeInMillis, this, "primaryTimeInMillis");
        this.replicaCount = ApiTypeHelper.requireNonNull(builder.replicaCount, this, "replicaCount");
        this.replicaTimeInMillis = ApiTypeHelper.requireNonNull(builder.replicaTimeInMillis, this, "replicaTimeInMillis");
    }

    public static ShardIndexingPressurePerShardIndexingStats of(
        Function<ShardIndexingPressurePerShardIndexingStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardIndexingStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code coordinating_count}
     */
    public final long coordinatingCount() {
        return this.coordinatingCount;
    }

    /**
     * Required - API name: {@code coordinating_time_in_millis}
     */
    public final long coordinatingTimeInMillis() {
        return this.coordinatingTimeInMillis;
    }

    /**
     * Required - API name: {@code primary_count}
     */
    public final long primaryCount() {
        return this.primaryCount;
    }

    /**
     * Required - API name: {@code primary_time_in_millis}
     */
    public final long primaryTimeInMillis() {
        return this.primaryTimeInMillis;
    }

    /**
     * Required - API name: {@code replica_count}
     */
    public final long replicaCount() {
        return this.replicaCount;
    }

    /**
     * Required - API name: {@code replica_time_in_millis}
     */
    public final long replicaTimeInMillis() {
        return this.replicaTimeInMillis;
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
        generator.writeKey("coordinating_count");
        generator.write(this.coordinatingCount);

        generator.writeKey("coordinating_time_in_millis");
        generator.write(this.coordinatingTimeInMillis);

        generator.writeKey("primary_count");
        generator.write(this.primaryCount);

        generator.writeKey("primary_time_in_millis");
        generator.write(this.primaryTimeInMillis);

        generator.writeKey("replica_count");
        generator.write(this.replicaCount);

        generator.writeKey("replica_time_in_millis");
        generator.write(this.replicaTimeInMillis);
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
     * Builder for {@link ShardIndexingPressurePerShardIndexingStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardIndexingPressurePerShardIndexingStats> {
        private Long coordinatingCount;
        private Long coordinatingTimeInMillis;
        private Long primaryCount;
        private Long primaryTimeInMillis;
        private Long replicaCount;
        private Long replicaTimeInMillis;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardIndexingStats o) {
            this.coordinatingCount = o.coordinatingCount;
            this.coordinatingTimeInMillis = o.coordinatingTimeInMillis;
            this.primaryCount = o.primaryCount;
            this.primaryTimeInMillis = o.primaryTimeInMillis;
            this.replicaCount = o.replicaCount;
            this.replicaTimeInMillis = o.replicaTimeInMillis;
        }

        private Builder(Builder o) {
            this.coordinatingCount = o.coordinatingCount;
            this.coordinatingTimeInMillis = o.coordinatingTimeInMillis;
            this.primaryCount = o.primaryCount;
            this.primaryTimeInMillis = o.primaryTimeInMillis;
            this.replicaCount = o.replicaCount;
            this.replicaTimeInMillis = o.replicaTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code coordinating_count}
         */
        @Nonnull
        public final Builder coordinatingCount(long value) {
            this.coordinatingCount = value;
            return this;
        }

        /**
         * Required - API name: {@code coordinating_time_in_millis}
         */
        @Nonnull
        public final Builder coordinatingTimeInMillis(long value) {
            this.coordinatingTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_count}
         */
        @Nonnull
        public final Builder primaryCount(long value) {
            this.primaryCount = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_time_in_millis}
         */
        @Nonnull
        public final Builder primaryTimeInMillis(long value) {
            this.primaryTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code replica_count}
         */
        @Nonnull
        public final Builder replicaCount(long value) {
            this.replicaCount = value;
            return this;
        }

        /**
         * Required - API name: {@code replica_time_in_millis}
         */
        @Nonnull
        public final Builder replicaTimeInMillis(long value) {
            this.replicaTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardIndexingStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardIndexingStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardIndexingStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardIndexingStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardIndexingStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIndexingPressurePerShardIndexingStats::setupShardIndexingPressurePerShardIndexingStatsDeserializer
    );

    protected static void setupShardIndexingPressurePerShardIndexingStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardIndexingStats.Builder> op
    ) {
        op.add(Builder::coordinatingCount, JsonpDeserializer.longDeserializer(), "coordinating_count");
        op.add(Builder::coordinatingTimeInMillis, JsonpDeserializer.longDeserializer(), "coordinating_time_in_millis");
        op.add(Builder::primaryCount, JsonpDeserializer.longDeserializer(), "primary_count");
        op.add(Builder::primaryTimeInMillis, JsonpDeserializer.longDeserializer(), "primary_time_in_millis");
        op.add(Builder::replicaCount, JsonpDeserializer.longDeserializer(), "replica_count");
        op.add(Builder::replicaTimeInMillis, JsonpDeserializer.longDeserializer(), "replica_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.coordinatingCount);
        result = 31 * result + Long.hashCode(this.coordinatingTimeInMillis);
        result = 31 * result + Long.hashCode(this.primaryCount);
        result = 31 * result + Long.hashCode(this.primaryTimeInMillis);
        result = 31 * result + Long.hashCode(this.replicaCount);
        result = 31 * result + Long.hashCode(this.replicaTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardIndexingStats other = (ShardIndexingPressurePerShardIndexingStats) o;
        return this.coordinatingCount == other.coordinatingCount
            && this.coordinatingTimeInMillis == other.coordinatingTimeInMillis
            && this.primaryCount == other.primaryCount
            && this.primaryTimeInMillis == other.primaryTimeInMillis
            && this.replicaCount == other.replicaCount
            && this.replicaTimeInMillis == other.replicaTimeInMillis;
    }
}
