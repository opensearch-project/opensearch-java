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

// typedef: cluster.health.AwarenessAttributeStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AwarenessAttributeStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AwarenessAttributeStats.Builder, AwarenessAttributeStats> {

    @Nullable
    private final Integer activeShards;

    @Nullable
    private final Integer dataNodes;

    @Nullable
    private final Integer initializingShards;

    @Nullable
    private final Integer relocatingShards;

    @Nullable
    private final Integer unassignedShards;

    @Nullable
    private final Integer weight;

    // ---------------------------------------------------------------------------------------------

    private AwarenessAttributeStats(Builder builder) {
        this.activeShards = builder.activeShards;
        this.dataNodes = builder.dataNodes;
        this.initializingShards = builder.initializingShards;
        this.relocatingShards = builder.relocatingShards;
        this.unassignedShards = builder.unassignedShards;
        this.weight = builder.weight;
    }

    public static AwarenessAttributeStats of(Function<AwarenessAttributeStats.Builder, ObjectBuilder<AwarenessAttributeStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code active_shards}
     */
    @Nullable
    public final Integer activeShards() {
        return this.activeShards;
    }

    /**
     * API name: {@code data_nodes}
     */
    @Nullable
    public final Integer dataNodes() {
        return this.dataNodes;
    }

    /**
     * API name: {@code initializing_shards}
     */
    @Nullable
    public final Integer initializingShards() {
        return this.initializingShards;
    }

    /**
     * API name: {@code relocating_shards}
     */
    @Nullable
    public final Integer relocatingShards() {
        return this.relocatingShards;
    }

    /**
     * API name: {@code unassigned_shards}
     */
    @Nullable
    public final Integer unassignedShards() {
        return this.unassignedShards;
    }

    /**
     * API name: {@code weight}
     */
    @Nullable
    public final Integer weight() {
        return this.weight;
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
        if (this.activeShards != null) {
            generator.writeKey("active_shards");
            generator.write(this.activeShards);
        }

        if (this.dataNodes != null) {
            generator.writeKey("data_nodes");
            generator.write(this.dataNodes);
        }

        if (this.initializingShards != null) {
            generator.writeKey("initializing_shards");
            generator.write(this.initializingShards);
        }

        if (this.relocatingShards != null) {
            generator.writeKey("relocating_shards");
            generator.write(this.relocatingShards);
        }

        if (this.unassignedShards != null) {
            generator.writeKey("unassigned_shards");
            generator.write(this.unassignedShards);
        }

        if (this.weight != null) {
            generator.writeKey("weight");
            generator.write(this.weight);
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
     * Builder for {@link AwarenessAttributeStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AwarenessAttributeStats> {
        @Nullable
        private Integer activeShards;
        @Nullable
        private Integer dataNodes;
        @Nullable
        private Integer initializingShards;
        @Nullable
        private Integer relocatingShards;
        @Nullable
        private Integer unassignedShards;
        @Nullable
        private Integer weight;

        public Builder() {}

        private Builder(AwarenessAttributeStats o) {
            this.activeShards = o.activeShards;
            this.dataNodes = o.dataNodes;
            this.initializingShards = o.initializingShards;
            this.relocatingShards = o.relocatingShards;
            this.unassignedShards = o.unassignedShards;
            this.weight = o.weight;
        }

        private Builder(Builder o) {
            this.activeShards = o.activeShards;
            this.dataNodes = o.dataNodes;
            this.initializingShards = o.initializingShards;
            this.relocatingShards = o.relocatingShards;
            this.unassignedShards = o.unassignedShards;
            this.weight = o.weight;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code active_shards}
         */
        @Nonnull
        public final Builder activeShards(@Nullable Integer value) {
            this.activeShards = value;
            return this;
        }

        /**
         * API name: {@code data_nodes}
         */
        @Nonnull
        public final Builder dataNodes(@Nullable Integer value) {
            this.dataNodes = value;
            return this;
        }

        /**
         * API name: {@code initializing_shards}
         */
        @Nonnull
        public final Builder initializingShards(@Nullable Integer value) {
            this.initializingShards = value;
            return this;
        }

        /**
         * API name: {@code relocating_shards}
         */
        @Nonnull
        public final Builder relocatingShards(@Nullable Integer value) {
            this.relocatingShards = value;
            return this;
        }

        /**
         * API name: {@code unassigned_shards}
         */
        @Nonnull
        public final Builder unassignedShards(@Nullable Integer value) {
            this.unassignedShards = value;
            return this;
        }

        /**
         * API name: {@code weight}
         */
        @Nonnull
        public final Builder weight(@Nullable Integer value) {
            this.weight = value;
            return this;
        }

        /**
         * Builds a {@link AwarenessAttributeStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AwarenessAttributeStats build() {
            _checkSingleUse();

            return new AwarenessAttributeStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link AwarenessAttributeStats}
     */
    public static final JsonpDeserializer<AwarenessAttributeStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        AwarenessAttributeStats::setupAwarenessAttributeStatsDeserializer
    );

    protected static void setupAwarenessAttributeStatsDeserializer(ObjectDeserializer<AwarenessAttributeStats.Builder> op) {
        op.add(Builder::activeShards, JsonpDeserializer.integerDeserializer(), "active_shards");
        op.add(Builder::dataNodes, JsonpDeserializer.integerDeserializer(), "data_nodes");
        op.add(Builder::initializingShards, JsonpDeserializer.integerDeserializer(), "initializing_shards");
        op.add(Builder::relocatingShards, JsonpDeserializer.integerDeserializer(), "relocating_shards");
        op.add(Builder::unassignedShards, JsonpDeserializer.integerDeserializer(), "unassigned_shards");
        op.add(Builder::weight, JsonpDeserializer.integerDeserializer(), "weight");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.activeShards);
        result = 31 * result + Objects.hashCode(this.dataNodes);
        result = 31 * result + Objects.hashCode(this.initializingShards);
        result = 31 * result + Objects.hashCode(this.relocatingShards);
        result = 31 * result + Objects.hashCode(this.unassignedShards);
        result = 31 * result + Objects.hashCode(this.weight);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AwarenessAttributeStats other = (AwarenessAttributeStats) o;
        return Objects.equals(this.activeShards, other.activeShards)
            && Objects.equals(this.dataNodes, other.dataNodes)
            && Objects.equals(this.initializingShards, other.initializingShards)
            && Objects.equals(this.relocatingShards, other.relocatingShards)
            && Objects.equals(this.unassignedShards, other.unassignedShards)
            && Objects.equals(this.weight, other.weight);
    }
}
