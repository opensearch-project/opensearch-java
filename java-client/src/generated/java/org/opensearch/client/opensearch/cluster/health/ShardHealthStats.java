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

package org.opensearch.client.opensearch.cluster.health;

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
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.health.ShardHealthStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardHealthStats implements PlainJsonSerializable, ToCopyableBuilder<ShardHealthStats.Builder, ShardHealthStats> {

    private final int activeShards;

    private final int initializingShards;

    private final boolean primaryActive;

    private final int relocatingShards;

    @Nonnull
    private final HealthStatus status;

    private final int unassignedShards;

    // ---------------------------------------------------------------------------------------------

    private ShardHealthStats(Builder builder) {
        this.activeShards = ApiTypeHelper.requireNonNull(builder.activeShards, this, "activeShards");
        this.initializingShards = ApiTypeHelper.requireNonNull(builder.initializingShards, this, "initializingShards");
        this.primaryActive = ApiTypeHelper.requireNonNull(builder.primaryActive, this, "primaryActive");
        this.relocatingShards = ApiTypeHelper.requireNonNull(builder.relocatingShards, this, "relocatingShards");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.unassignedShards = ApiTypeHelper.requireNonNull(builder.unassignedShards, this, "unassignedShards");
    }

    public static ShardHealthStats of(Function<ShardHealthStats.Builder, ObjectBuilder<ShardHealthStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code active_shards}
     */
    public final int activeShards() {
        return this.activeShards;
    }

    /**
     * Required - API name: {@code initializing_shards}
     */
    public final int initializingShards() {
        return this.initializingShards;
    }

    /**
     * Required - API name: {@code primary_active}
     */
    public final boolean primaryActive() {
        return this.primaryActive;
    }

    /**
     * Required - API name: {@code relocating_shards}
     */
    public final int relocatingShards() {
        return this.relocatingShards;
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
    public final HealthStatus status() {
        return this.status;
    }

    /**
     * Required - API name: {@code unassigned_shards}
     */
    public final int unassignedShards() {
        return this.unassignedShards;
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
        generator.writeKey("active_shards");
        generator.write(this.activeShards);

        generator.writeKey("initializing_shards");
        generator.write(this.initializingShards);

        generator.writeKey("primary_active");
        generator.write(this.primaryActive);

        generator.writeKey("relocating_shards");
        generator.write(this.relocatingShards);

        generator.writeKey("status");
        this.status.serialize(generator, mapper);

        generator.writeKey("unassigned_shards");
        generator.write(this.unassignedShards);
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
     * Builder for {@link ShardHealthStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardHealthStats> {
        private Integer activeShards;
        private Integer initializingShards;
        private Boolean primaryActive;
        private Integer relocatingShards;
        private HealthStatus status;
        private Integer unassignedShards;

        public Builder() {}

        private Builder(ShardHealthStats o) {
            this.activeShards = o.activeShards;
            this.initializingShards = o.initializingShards;
            this.primaryActive = o.primaryActive;
            this.relocatingShards = o.relocatingShards;
            this.status = o.status;
            this.unassignedShards = o.unassignedShards;
        }

        private Builder(Builder o) {
            this.activeShards = o.activeShards;
            this.initializingShards = o.initializingShards;
            this.primaryActive = o.primaryActive;
            this.relocatingShards = o.relocatingShards;
            this.status = o.status;
            this.unassignedShards = o.unassignedShards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code active_shards}
         */
        @Nonnull
        public final Builder activeShards(int value) {
            this.activeShards = value;
            return this;
        }

        /**
         * Required - API name: {@code initializing_shards}
         */
        @Nonnull
        public final Builder initializingShards(int value) {
            this.initializingShards = value;
            return this;
        }

        /**
         * Required - API name: {@code primary_active}
         */
        @Nonnull
        public final Builder primaryActive(boolean value) {
            this.primaryActive = value;
            return this;
        }

        /**
         * Required - API name: {@code relocating_shards}
         */
        @Nonnull
        public final Builder relocatingShards(int value) {
            this.relocatingShards = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(HealthStatus value) {
            this.status = value;
            return this;
        }

        /**
         * Required - API name: {@code unassigned_shards}
         */
        @Nonnull
        public final Builder unassignedShards(int value) {
            this.unassignedShards = value;
            return this;
        }

        /**
         * Builds a {@link ShardHealthStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardHealthStats build() {
            _checkSingleUse();

            return new ShardHealthStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardHealthStats}
     */
    public static final JsonpDeserializer<ShardHealthStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardHealthStats::setupShardHealthStatsDeserializer
    );

    protected static void setupShardHealthStatsDeserializer(ObjectDeserializer<ShardHealthStats.Builder> op) {
        op.add(Builder::activeShards, JsonpDeserializer.integerDeserializer(), "active_shards");
        op.add(Builder::initializingShards, JsonpDeserializer.integerDeserializer(), "initializing_shards");
        op.add(Builder::primaryActive, JsonpDeserializer.booleanDeserializer(), "primary_active");
        op.add(Builder::relocatingShards, JsonpDeserializer.integerDeserializer(), "relocating_shards");
        op.add(Builder::status, HealthStatus._DESERIALIZER, "status");
        op.add(Builder::unassignedShards, JsonpDeserializer.integerDeserializer(), "unassigned_shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.activeShards);
        result = 31 * result + Integer.hashCode(this.initializingShards);
        result = 31 * result + Boolean.hashCode(this.primaryActive);
        result = 31 * result + Integer.hashCode(this.relocatingShards);
        result = 31 * result + this.status.hashCode();
        result = 31 * result + Integer.hashCode(this.unassignedShards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardHealthStats other = (ShardHealthStats) o;
        return this.activeShards == other.activeShards
            && this.initializingShards == other.initializingShards
            && this.primaryActive == other.primaryActive
            && this.relocatingShards == other.relocatingShards
            && this.status.equals(other.status)
            && this.unassignedShards == other.unassignedShards;
    }
}
