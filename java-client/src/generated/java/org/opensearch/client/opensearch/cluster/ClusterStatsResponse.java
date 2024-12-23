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

package org.opensearch.client.opensearch.cluster;

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
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.opensearch.cluster.stats.ClusterIndices;
import org.opensearch.client.opensearch.cluster.stats.ClusterNodes;
import org.opensearch.client.opensearch.nodes.NodesResponseBase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.stats.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterStatsResponse extends NodesResponseBase
    implements
        ToCopyableBuilder<ClusterStatsResponse.Builder, ClusterStatsResponse> {

    @Nonnull
    private final String clusterName;

    @Nonnull
    private final String clusterUuid;

    @Nullable
    private final ClusterIndices indices;

    @Nullable
    private final ClusterNodes nodes;

    @Nonnull
    private final HealthStatus status;

    private final long timestamp;

    // ---------------------------------------------------------------------------------------------

    private ClusterStatsResponse(Builder builder) {
        super(builder);
        this.clusterName = ApiTypeHelper.requireNonNull(builder.clusterName, this, "clusterName");
        this.clusterUuid = ApiTypeHelper.requireNonNull(builder.clusterUuid, this, "clusterUuid");
        this.indices = builder.indices;
        this.nodes = builder.nodes;
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.timestamp = ApiTypeHelper.requireNonNull(builder.timestamp, this, "timestamp");
    }

    public static ClusterStatsResponse of(Function<ClusterStatsResponse.Builder, ObjectBuilder<ClusterStatsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Name of the cluster, based on the Cluster name setting setting.
     * <p>
     * API name: {@code cluster_name}
     * </p>
     */
    @Nonnull
    public final String clusterName() {
        return this.clusterName;
    }

    /**
     * Required - Unique identifier for the cluster.
     * <p>
     * API name: {@code cluster_uuid}
     * </p>
     */
    @Nonnull
    public final String clusterUuid() {
        return this.clusterUuid;
    }

    /**
     * Contains statistics about indices with shards assigned to selected nodes.
     * <p>
     * API name: {@code indices}
     * </p>
     */
    @Nullable
    public final ClusterIndices indices() {
        return this.indices;
    }

    /**
     * Contains statistics about nodes selected by the request's node filters.
     * <p>
     * API name: {@code nodes}
     * </p>
     */
    @Nullable
    public final ClusterNodes nodes() {
        return this.nodes;
    }

    /**
     * Required - Health status of the cluster, based on the state of its primary and replica shards.
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nonnull
    public final HealthStatus status() {
        return this.status;
    }

    /**
     * Required - Unix timestamp, in milliseconds, for the last time the cluster statistics were refreshed.
     * <p>
     * API name: {@code timestamp}
     * </p>
     */
    public final long timestamp() {
        return this.timestamp;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("cluster_name");
        generator.write(this.clusterName);

        generator.writeKey("cluster_uuid");
        generator.write(this.clusterUuid);

        if (this.indices != null) {
            generator.writeKey("indices");
            this.indices.serialize(generator, mapper);
        }

        if (this.nodes != null) {
            generator.writeKey("nodes");
            this.nodes.serialize(generator, mapper);
        }

        generator.writeKey("status");
        this.status.serialize(generator, mapper);

        generator.writeKey("timestamp");
        generator.write(this.timestamp);
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
     * Builder for {@link ClusterStatsResponse}.
     */
    public static class Builder extends NodesResponseBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ClusterStatsResponse> {
        private String clusterName;
        private String clusterUuid;
        @Nullable
        private ClusterIndices indices;
        @Nullable
        private ClusterNodes nodes;
        private HealthStatus status;
        private Long timestamp;

        public Builder() {}

        private Builder(ClusterStatsResponse o) {
            super(o);
            this.clusterName = o.clusterName;
            this.clusterUuid = o.clusterUuid;
            this.indices = o.indices;
            this.nodes = o.nodes;
            this.status = o.status;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterName = o.clusterName;
            this.clusterUuid = o.clusterUuid;
            this.indices = o.indices;
            this.nodes = o.nodes;
            this.status = o.status;
            this.timestamp = o.timestamp;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - Name of the cluster, based on the Cluster name setting setting.
         * <p>
         * API name: {@code cluster_name}
         * </p>
         */
        @Nonnull
        public final Builder clusterName(String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * Required - Unique identifier for the cluster.
         * <p>
         * API name: {@code cluster_uuid}
         * </p>
         */
        @Nonnull
        public final Builder clusterUuid(String value) {
            this.clusterUuid = value;
            return this;
        }

        /**
         * Contains statistics about indices with shards assigned to selected nodes.
         * <p>
         * API name: {@code indices}
         * </p>
         */
        @Nonnull
        public final Builder indices(@Nullable ClusterIndices value) {
            this.indices = value;
            return this;
        }

        /**
         * Contains statistics about indices with shards assigned to selected nodes.
         * <p>
         * API name: {@code indices}
         * </p>
         */
        @Nonnull
        public final Builder indices(Function<ClusterIndices.Builder, ObjectBuilder<ClusterIndices>> fn) {
            return indices(fn.apply(new ClusterIndices.Builder()).build());
        }

        /**
         * Contains statistics about nodes selected by the request's node filters.
         * <p>
         * API name: {@code nodes}
         * </p>
         */
        @Nonnull
        public final Builder nodes(@Nullable ClusterNodes value) {
            this.nodes = value;
            return this;
        }

        /**
         * Contains statistics about nodes selected by the request's node filters.
         * <p>
         * API name: {@code nodes}
         * </p>
         */
        @Nonnull
        public final Builder nodes(Function<ClusterNodes.Builder, ObjectBuilder<ClusterNodes>> fn) {
            return nodes(fn.apply(new ClusterNodes.Builder()).build());
        }

        /**
         * Required - Health status of the cluster, based on the state of its primary and replica shards.
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(HealthStatus value) {
            this.status = value;
            return this;
        }

        /**
         * Required - Unix timestamp, in milliseconds, for the last time the cluster statistics were refreshed.
         * <p>
         * API name: {@code timestamp}
         * </p>
         */
        @Nonnull
        public final Builder timestamp(long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link ClusterStatsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterStatsResponse build() {
            _checkSingleUse();

            return new ClusterStatsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClusterStatsResponse}
     */
    public static final JsonpDeserializer<ClusterStatsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClusterStatsResponse::setupClusterStatsResponseDeserializer
    );

    protected static void setupClusterStatsResponseDeserializer(ObjectDeserializer<ClusterStatsResponse.Builder> op) {
        setupNodesResponseBaseDeserializer(op);
        op.add(Builder::clusterName, JsonpDeserializer.stringDeserializer(), "cluster_name");
        op.add(Builder::clusterUuid, JsonpDeserializer.stringDeserializer(), "cluster_uuid");
        op.add(Builder::indices, ClusterIndices._DESERIALIZER, "indices");
        op.add(Builder::nodes, ClusterNodes._DESERIALIZER, "nodes");
        op.add(Builder::status, HealthStatus._DESERIALIZER, "status");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.clusterName.hashCode();
        result = 31 * result + this.clusterUuid.hashCode();
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + this.status.hashCode();
        result = 31 * result + Long.hashCode(this.timestamp);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterStatsResponse other = (ClusterStatsResponse) o;
        return this.clusterName.equals(other.clusterName)
            && this.clusterUuid.equals(other.clusterUuid)
            && Objects.equals(this.indices, other.indices)
            && Objects.equals(this.nodes, other.nodes)
            && this.status.equals(other.status)
            && this.timestamp == other.timestamp;
    }
}
