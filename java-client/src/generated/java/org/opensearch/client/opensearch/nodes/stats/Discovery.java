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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.Discovery

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Discovery implements PlainJsonSerializable, ToCopyableBuilder<Discovery.Builder, Discovery> {

    @Nullable
    private final ClusterStateQueue clusterStateQueue;

    @Nullable
    private final ClusterStateStats clusterStateStats;

    @Nullable
    private final PublishedClusterStates publishedClusterStates;

    // ---------------------------------------------------------------------------------------------

    private Discovery(Builder builder) {
        this.clusterStateQueue = builder.clusterStateQueue;
        this.clusterStateStats = builder.clusterStateStats;
        this.publishedClusterStates = builder.publishedClusterStates;
    }

    public static Discovery of(Function<Discovery.Builder, ObjectBuilder<Discovery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cluster_state_queue}
     */
    @Nullable
    public final ClusterStateQueue clusterStateQueue() {
        return this.clusterStateQueue;
    }

    /**
     * API name: {@code cluster_state_stats}
     */
    @Nullable
    public final ClusterStateStats clusterStateStats() {
        return this.clusterStateStats;
    }

    /**
     * API name: {@code published_cluster_states}
     */
    @Nullable
    public final PublishedClusterStates publishedClusterStates() {
        return this.publishedClusterStates;
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
        if (this.clusterStateQueue != null) {
            generator.writeKey("cluster_state_queue");
            this.clusterStateQueue.serialize(generator, mapper);
        }

        if (this.clusterStateStats != null) {
            generator.writeKey("cluster_state_stats");
            this.clusterStateStats.serialize(generator, mapper);
        }

        if (this.publishedClusterStates != null) {
            generator.writeKey("published_cluster_states");
            this.publishedClusterStates.serialize(generator, mapper);
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
     * Builder for {@link Discovery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Discovery> {
        @Nullable
        private ClusterStateQueue clusterStateQueue;
        @Nullable
        private ClusterStateStats clusterStateStats;
        @Nullable
        private PublishedClusterStates publishedClusterStates;

        public Builder() {}

        private Builder(Discovery o) {
            this.clusterStateQueue = o.clusterStateQueue;
            this.clusterStateStats = o.clusterStateStats;
            this.publishedClusterStates = o.publishedClusterStates;
        }

        private Builder(Builder o) {
            this.clusterStateQueue = o.clusterStateQueue;
            this.clusterStateStats = o.clusterStateStats;
            this.publishedClusterStates = o.publishedClusterStates;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cluster_state_queue}
         */
        @Nonnull
        public final Builder clusterStateQueue(@Nullable ClusterStateQueue value) {
            this.clusterStateQueue = value;
            return this;
        }

        /**
         * API name: {@code cluster_state_queue}
         */
        @Nonnull
        public final Builder clusterStateQueue(Function<ClusterStateQueue.Builder, ObjectBuilder<ClusterStateQueue>> fn) {
            return clusterStateQueue(fn.apply(new ClusterStateQueue.Builder()).build());
        }

        /**
         * API name: {@code cluster_state_stats}
         */
        @Nonnull
        public final Builder clusterStateStats(@Nullable ClusterStateStats value) {
            this.clusterStateStats = value;
            return this;
        }

        /**
         * API name: {@code cluster_state_stats}
         */
        @Nonnull
        public final Builder clusterStateStats(Function<ClusterStateStats.Builder, ObjectBuilder<ClusterStateStats>> fn) {
            return clusterStateStats(fn.apply(new ClusterStateStats.Builder()).build());
        }

        /**
         * API name: {@code published_cluster_states}
         */
        @Nonnull
        public final Builder publishedClusterStates(@Nullable PublishedClusterStates value) {
            this.publishedClusterStates = value;
            return this;
        }

        /**
         * API name: {@code published_cluster_states}
         */
        @Nonnull
        public final Builder publishedClusterStates(Function<PublishedClusterStates.Builder, ObjectBuilder<PublishedClusterStates>> fn) {
            return publishedClusterStates(fn.apply(new PublishedClusterStates.Builder()).build());
        }

        /**
         * Builds a {@link Discovery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Discovery build() {
            _checkSingleUse();

            return new Discovery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Discovery}
     */
    public static final JsonpDeserializer<Discovery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Discovery::setupDiscoveryDeserializer
    );

    protected static void setupDiscoveryDeserializer(ObjectDeserializer<Discovery.Builder> op) {
        op.add(Builder::clusterStateQueue, ClusterStateQueue._DESERIALIZER, "cluster_state_queue");
        op.add(Builder::clusterStateStats, ClusterStateStats._DESERIALIZER, "cluster_state_stats");
        op.add(Builder::publishedClusterStates, PublishedClusterStates._DESERIALIZER, "published_cluster_states");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterStateQueue);
        result = 31 * result + Objects.hashCode(this.clusterStateStats);
        result = 31 * result + Objects.hashCode(this.publishedClusterStates);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Discovery other = (Discovery) o;
        return Objects.equals(this.clusterStateQueue, other.clusterStateQueue)
            && Objects.equals(this.clusterStateStats, other.clusterStateStats)
            && Objects.equals(this.publishedClusterStates, other.publishedClusterStates);
    }
}
