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

// typedef: nodes.stats.ShardIndexingPressurePerShardRejectionStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardRejectionStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressurePerShardRejectionStats.Builder, ShardIndexingPressurePerShardRejectionStats> {

    @Nonnull
    private final ShardIndexingPressurePerShardRejectionCoordinatingStats coordinating;

    @Nonnull
    private final ShardIndexingPressurePerShardRejectionPrimaryStats primary;

    @Nonnull
    private final ShardIndexingPressurePerShardRejectionReplicaStats replica;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardRejectionStats(Builder builder) {
        this.coordinating = ApiTypeHelper.requireNonNull(builder.coordinating, this, "coordinating");
        this.primary = ApiTypeHelper.requireNonNull(builder.primary, this, "primary");
        this.replica = ApiTypeHelper.requireNonNull(builder.replica, this, "replica");
    }

    public static ShardIndexingPressurePerShardRejectionStats of(
        Function<ShardIndexingPressurePerShardRejectionStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardRejectionStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code coordinating}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardRejectionCoordinatingStats coordinating() {
        return this.coordinating;
    }

    /**
     * Required - API name: {@code primary}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardRejectionPrimaryStats primary() {
        return this.primary;
    }

    /**
     * Required - API name: {@code replica}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardRejectionReplicaStats replica() {
        return this.replica;
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
        generator.writeKey("coordinating");
        this.coordinating.serialize(generator, mapper);

        generator.writeKey("primary");
        this.primary.serialize(generator, mapper);

        generator.writeKey("replica");
        this.replica.serialize(generator, mapper);
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
     * Builder for {@link ShardIndexingPressurePerShardRejectionStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardIndexingPressurePerShardRejectionStats> {
        private ShardIndexingPressurePerShardRejectionCoordinatingStats coordinating;
        private ShardIndexingPressurePerShardRejectionPrimaryStats primary;
        private ShardIndexingPressurePerShardRejectionReplicaStats replica;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardRejectionStats o) {
            this.coordinating = o.coordinating;
            this.primary = o.primary;
            this.replica = o.replica;
        }

        private Builder(Builder o) {
            this.coordinating = o.coordinating;
            this.primary = o.primary;
            this.replica = o.replica;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code coordinating}
         */
        @Nonnull
        public final Builder coordinating(ShardIndexingPressurePerShardRejectionCoordinatingStats value) {
            this.coordinating = value;
            return this;
        }

        /**
         * Required - API name: {@code coordinating}
         */
        @Nonnull
        public final Builder coordinating(
            Function<
                ShardIndexingPressurePerShardRejectionCoordinatingStats.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardRejectionCoordinatingStats>> fn
        ) {
            return coordinating(fn.apply(new ShardIndexingPressurePerShardRejectionCoordinatingStats.Builder()).build());
        }

        /**
         * Required - API name: {@code primary}
         */
        @Nonnull
        public final Builder primary(ShardIndexingPressurePerShardRejectionPrimaryStats value) {
            this.primary = value;
            return this;
        }

        /**
         * Required - API name: {@code primary}
         */
        @Nonnull
        public final Builder primary(
            Function<
                ShardIndexingPressurePerShardRejectionPrimaryStats.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardRejectionPrimaryStats>> fn
        ) {
            return primary(fn.apply(new ShardIndexingPressurePerShardRejectionPrimaryStats.Builder()).build());
        }

        /**
         * Required - API name: {@code replica}
         */
        @Nonnull
        public final Builder replica(ShardIndexingPressurePerShardRejectionReplicaStats value) {
            this.replica = value;
            return this;
        }

        /**
         * Required - API name: {@code replica}
         */
        @Nonnull
        public final Builder replica(
            Function<
                ShardIndexingPressurePerShardRejectionReplicaStats.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardRejectionReplicaStats>> fn
        ) {
            return replica(fn.apply(new ShardIndexingPressurePerShardRejectionReplicaStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardRejectionStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardRejectionStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardRejectionStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardRejectionStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardRejectionStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIndexingPressurePerShardRejectionStats::setupShardIndexingPressurePerShardRejectionStatsDeserializer
    );

    protected static void setupShardIndexingPressurePerShardRejectionStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardRejectionStats.Builder> op
    ) {
        op.add(Builder::coordinating, ShardIndexingPressurePerShardRejectionCoordinatingStats._DESERIALIZER, "coordinating");
        op.add(Builder::primary, ShardIndexingPressurePerShardRejectionPrimaryStats._DESERIALIZER, "primary");
        op.add(Builder::replica, ShardIndexingPressurePerShardRejectionReplicaStats._DESERIALIZER, "replica");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.coordinating.hashCode();
        result = 31 * result + this.primary.hashCode();
        result = 31 * result + this.replica.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardRejectionStats other = (ShardIndexingPressurePerShardRejectionStats) o;
        return this.coordinating.equals(other.coordinating) && this.primary.equals(other.primary) && this.replica.equals(other.replica);
    }
}
