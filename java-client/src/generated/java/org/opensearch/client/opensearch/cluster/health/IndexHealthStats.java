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
import java.util.Map;
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
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.health.IndexHealthStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexHealthStats implements PlainJsonSerializable, ToCopyableBuilder<IndexHealthStats.Builder, IndexHealthStats> {

    private final int activePrimaryShards;

    private final int activeShards;

    private final int initializingShards;

    private final int numberOfReplicas;

    private final int numberOfShards;

    private final int relocatingShards;

    @Nonnull
    private final Map<String, ShardHealthStats> shards;

    @Nonnull
    private final HealthStatus status;

    private final int unassignedShards;

    // ---------------------------------------------------------------------------------------------

    private IndexHealthStats(Builder builder) {
        this.activePrimaryShards = ApiTypeHelper.requireNonNull(builder.activePrimaryShards, this, "activePrimaryShards");
        this.activeShards = ApiTypeHelper.requireNonNull(builder.activeShards, this, "activeShards");
        this.initializingShards = ApiTypeHelper.requireNonNull(builder.initializingShards, this, "initializingShards");
        this.numberOfReplicas = ApiTypeHelper.requireNonNull(builder.numberOfReplicas, this, "numberOfReplicas");
        this.numberOfShards = ApiTypeHelper.requireNonNull(builder.numberOfShards, this, "numberOfShards");
        this.relocatingShards = ApiTypeHelper.requireNonNull(builder.relocatingShards, this, "relocatingShards");
        this.shards = ApiTypeHelper.unmodifiable(builder.shards);
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.unassignedShards = ApiTypeHelper.requireNonNull(builder.unassignedShards, this, "unassignedShards");
    }

    public static IndexHealthStats of(Function<IndexHealthStats.Builder, ObjectBuilder<IndexHealthStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code active_primary_shards}
     */
    public final int activePrimaryShards() {
        return this.activePrimaryShards;
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
     * Required - API name: {@code number_of_replicas}
     */
    public final int numberOfReplicas() {
        return this.numberOfReplicas;
    }

    /**
     * Required - API name: {@code number_of_shards}
     */
    public final int numberOfShards() {
        return this.numberOfShards;
    }

    /**
     * Required - API name: {@code relocating_shards}
     */
    public final int relocatingShards() {
        return this.relocatingShards;
    }

    /**
     * API name: {@code shards}
     */
    @Nonnull
    public final Map<String, ShardHealthStats> shards() {
        return this.shards;
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
        generator.writeKey("active_primary_shards");
        generator.write(this.activePrimaryShards);

        generator.writeKey("active_shards");
        generator.write(this.activeShards);

        generator.writeKey("initializing_shards");
        generator.write(this.initializingShards);

        generator.writeKey("number_of_replicas");
        generator.write(this.numberOfReplicas);

        generator.writeKey("number_of_shards");
        generator.write(this.numberOfShards);

        generator.writeKey("relocating_shards");
        generator.write(this.relocatingShards);

        if (ApiTypeHelper.isDefined(this.shards)) {
            generator.writeKey("shards");
            generator.writeStartObject();
            for (Map.Entry<String, ShardHealthStats> item0 : this.shards.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

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
     * Builder for {@link IndexHealthStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexHealthStats> {
        private Integer activePrimaryShards;
        private Integer activeShards;
        private Integer initializingShards;
        private Integer numberOfReplicas;
        private Integer numberOfShards;
        private Integer relocatingShards;
        @Nullable
        private Map<String, ShardHealthStats> shards;
        private HealthStatus status;
        private Integer unassignedShards;

        public Builder() {}

        private Builder(IndexHealthStats o) {
            this.activePrimaryShards = o.activePrimaryShards;
            this.activeShards = o.activeShards;
            this.initializingShards = o.initializingShards;
            this.numberOfReplicas = o.numberOfReplicas;
            this.numberOfShards = o.numberOfShards;
            this.relocatingShards = o.relocatingShards;
            this.shards = _mapCopy(o.shards);
            this.status = o.status;
            this.unassignedShards = o.unassignedShards;
        }

        private Builder(Builder o) {
            this.activePrimaryShards = o.activePrimaryShards;
            this.activeShards = o.activeShards;
            this.initializingShards = o.initializingShards;
            this.numberOfReplicas = o.numberOfReplicas;
            this.numberOfShards = o.numberOfShards;
            this.relocatingShards = o.relocatingShards;
            this.shards = _mapCopy(o.shards);
            this.status = o.status;
            this.unassignedShards = o.unassignedShards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code active_primary_shards}
         */
        @Nonnull
        public final Builder activePrimaryShards(int value) {
            this.activePrimaryShards = value;
            return this;
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
         * Required - API name: {@code number_of_replicas}
         */
        @Nonnull
        public final Builder numberOfReplicas(int value) {
            this.numberOfReplicas = value;
            return this;
        }

        /**
         * Required - API name: {@code number_of_shards}
         */
        @Nonnull
        public final Builder numberOfShards(int value) {
            this.numberOfShards = value;
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
         * API name: {@code shards}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, ShardHealthStats> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * API name: {@code shards}
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, ShardHealthStats value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * API name: {@code shards}
         *
         * <p>
         * Adds a value to <code>shards</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, Function<ShardHealthStats.Builder, ObjectBuilder<ShardHealthStats>> fn) {
            return shards(key, fn.apply(new ShardHealthStats.Builder()).build());
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
         * Builds a {@link IndexHealthStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexHealthStats build() {
            _checkSingleUse();

            return new IndexHealthStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexHealthStats}
     */
    public static final JsonpDeserializer<IndexHealthStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexHealthStats::setupIndexHealthStatsDeserializer
    );

    protected static void setupIndexHealthStatsDeserializer(ObjectDeserializer<IndexHealthStats.Builder> op) {
        op.add(Builder::activePrimaryShards, JsonpDeserializer.integerDeserializer(), "active_primary_shards");
        op.add(Builder::activeShards, JsonpDeserializer.integerDeserializer(), "active_shards");
        op.add(Builder::initializingShards, JsonpDeserializer.integerDeserializer(), "initializing_shards");
        op.add(Builder::numberOfReplicas, JsonpDeserializer.integerDeserializer(), "number_of_replicas");
        op.add(Builder::numberOfShards, JsonpDeserializer.integerDeserializer(), "number_of_shards");
        op.add(Builder::relocatingShards, JsonpDeserializer.integerDeserializer(), "relocating_shards");
        op.add(Builder::shards, JsonpDeserializer.stringMapDeserializer(ShardHealthStats._DESERIALIZER), "shards");
        op.add(Builder::status, HealthStatus._DESERIALIZER, "status");
        op.add(Builder::unassignedShards, JsonpDeserializer.integerDeserializer(), "unassigned_shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.activePrimaryShards);
        result = 31 * result + Integer.hashCode(this.activeShards);
        result = 31 * result + Integer.hashCode(this.initializingShards);
        result = 31 * result + Integer.hashCode(this.numberOfReplicas);
        result = 31 * result + Integer.hashCode(this.numberOfShards);
        result = 31 * result + Integer.hashCode(this.relocatingShards);
        result = 31 * result + Objects.hashCode(this.shards);
        result = 31 * result + this.status.hashCode();
        result = 31 * result + Integer.hashCode(this.unassignedShards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexHealthStats other = (IndexHealthStats) o;
        return this.activePrimaryShards == other.activePrimaryShards
            && this.activeShards == other.activeShards
            && this.initializingShards == other.initializingShards
            && this.numberOfReplicas == other.numberOfReplicas
            && this.numberOfShards == other.numberOfShards
            && this.relocatingShards == other.relocatingShards
            && Objects.equals(this.shards, other.shards)
            && this.status.equals(other.status)
            && this.unassignedShards == other.unassignedShards;
    }
}
