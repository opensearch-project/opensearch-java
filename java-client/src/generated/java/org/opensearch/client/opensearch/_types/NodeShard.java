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

package org.opensearch.client.opensearch._types;

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
import org.opensearch.client.opensearch.cluster.allocation_explain.UnassignedInformation;
import org.opensearch.client.opensearch.indices.stats.ShardRoutingState;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.NodeShard

/**
 * The information about a shard on a node.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeShard implements PlainJsonSerializable, ToCopyableBuilder<NodeShard.Builder, NodeShard> {

    @Nonnull
    private final Map<String, String> allocationId;

    @Nonnull
    private final String index;

    @Nullable
    private final String node;

    private final boolean primary;

    @Nonnull
    private final Map<String, String> recoverySource;

    @Nullable
    private final String relocatingNode;

    private final int shard;

    @Nonnull
    private final ShardRoutingState state;

    @Nullable
    private final UnassignedInformation unassignedInfo;

    // ---------------------------------------------------------------------------------------------

    private NodeShard(Builder builder) {
        this.allocationId = ApiTypeHelper.unmodifiable(builder.allocationId);
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.node = builder.node;
        this.primary = ApiTypeHelper.requireNonNull(builder.primary, this, "primary");
        this.recoverySource = ApiTypeHelper.unmodifiable(builder.recoverySource);
        this.relocatingNode = builder.relocatingNode;
        this.shard = ApiTypeHelper.requireNonNull(builder.shard, this, "shard");
        this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");
        this.unassignedInfo = builder.unassignedInfo;
    }

    public static NodeShard of(Function<NodeShard.Builder, ObjectBuilder<NodeShard>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allocation_id}
     */
    @Nonnull
    public final Map<String, String> allocationId() {
        return this.allocationId;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code node}
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * Required - API name: {@code primary}
     */
    public final boolean primary() {
        return this.primary;
    }

    /**
     * The recovery source information for this shard.
     * <p>
     * API name: {@code recovery_source}
     * </p>
     */
    @Nonnull
    public final Map<String, String> recoverySource() {
        return this.recoverySource;
    }

    /**
     * API name: {@code relocating_node}
     */
    @Nullable
    public final String relocatingNode() {
        return this.relocatingNode;
    }

    /**
     * Required - API name: {@code shard}
     */
    public final int shard() {
        return this.shard;
    }

    /**
     * Required - API name: {@code state}
     */
    @Nonnull
    public final ShardRoutingState state() {
        return this.state;
    }

    /**
     * API name: {@code unassigned_info}
     */
    @Nullable
    public final UnassignedInformation unassignedInfo() {
        return this.unassignedInfo;
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
        if (ApiTypeHelper.isDefined(this.allocationId)) {
            generator.writeKey("allocation_id");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.allocationId.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        generator.writeKey("index");
        generator.write(this.index);

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        generator.writeKey("primary");
        generator.write(this.primary);

        if (ApiTypeHelper.isDefined(this.recoverySource)) {
            generator.writeKey("recovery_source");
            generator.writeStartObject();
            for (Map.Entry<String, String> item0 : this.recoverySource.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.write(item0.getValue());
            }
            generator.writeEnd();
        }

        if (this.relocatingNode != null) {
            generator.writeKey("relocating_node");
            generator.write(this.relocatingNode);
        }

        generator.writeKey("shard");
        generator.write(this.shard);

        generator.writeKey("state");
        this.state.serialize(generator, mapper);

        if (this.unassignedInfo != null) {
            generator.writeKey("unassigned_info");
            this.unassignedInfo.serialize(generator, mapper);
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
     * Builder for {@link NodeShard}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeShard> {
        @Nullable
        private Map<String, String> allocationId;
        private String index;
        @Nullable
        private String node;
        private Boolean primary;
        @Nullable
        private Map<String, String> recoverySource;
        @Nullable
        private String relocatingNode;
        private Integer shard;
        private ShardRoutingState state;
        @Nullable
        private UnassignedInformation unassignedInfo;

        public Builder() {}

        private Builder(NodeShard o) {
            this.allocationId = _mapCopy(o.allocationId);
            this.index = o.index;
            this.node = o.node;
            this.primary = o.primary;
            this.recoverySource = _mapCopy(o.recoverySource);
            this.relocatingNode = o.relocatingNode;
            this.shard = o.shard;
            this.state = o.state;
            this.unassignedInfo = o.unassignedInfo;
        }

        private Builder(Builder o) {
            this.allocationId = _mapCopy(o.allocationId);
            this.index = o.index;
            this.node = o.node;
            this.primary = o.primary;
            this.recoverySource = _mapCopy(o.recoverySource);
            this.relocatingNode = o.relocatingNode;
            this.shard = o.shard;
            this.state = o.state;
            this.unassignedInfo = o.unassignedInfo;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allocation_id}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>allocationId</code>.
         * </p>
         */
        @Nonnull
        public final Builder allocationId(Map<String, String> map) {
            this.allocationId = _mapPutAll(this.allocationId, map);
            return this;
        }

        /**
         * API name: {@code allocation_id}
         *
         * <p>
         * Adds an entry to <code>allocationId</code>.
         * </p>
         */
        @Nonnull
        public final Builder allocationId(String key, String value) {
            this.allocationId = _mapPut(this.allocationId, key, value);
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code node}
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * Required - API name: {@code primary}
         */
        @Nonnull
        public final Builder primary(boolean value) {
            this.primary = value;
            return this;
        }

        /**
         * The recovery source information for this shard.
         * <p>
         * API name: {@code recovery_source}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>recoverySource</code>.
         * </p>
         */
        @Nonnull
        public final Builder recoverySource(Map<String, String> map) {
            this.recoverySource = _mapPutAll(this.recoverySource, map);
            return this;
        }

        /**
         * The recovery source information for this shard.
         * <p>
         * API name: {@code recovery_source}
         * </p>
         *
         * <p>
         * Adds an entry to <code>recoverySource</code>.
         * </p>
         */
        @Nonnull
        public final Builder recoverySource(String key, String value) {
            this.recoverySource = _mapPut(this.recoverySource, key, value);
            return this;
        }

        /**
         * API name: {@code relocating_node}
         */
        @Nonnull
        public final Builder relocatingNode(@Nullable String value) {
            this.relocatingNode = value;
            return this;
        }

        /**
         * Required - API name: {@code shard}
         */
        @Nonnull
        public final Builder shard(int value) {
            this.shard = value;
            return this;
        }

        /**
         * Required - API name: {@code state}
         */
        @Nonnull
        public final Builder state(ShardRoutingState value) {
            this.state = value;
            return this;
        }

        /**
         * API name: {@code unassigned_info}
         */
        @Nonnull
        public final Builder unassignedInfo(@Nullable UnassignedInformation value) {
            this.unassignedInfo = value;
            return this;
        }

        /**
         * API name: {@code unassigned_info}
         */
        @Nonnull
        public final Builder unassignedInfo(Function<UnassignedInformation.Builder, ObjectBuilder<UnassignedInformation>> fn) {
            return unassignedInfo(fn.apply(new UnassignedInformation.Builder()).build());
        }

        /**
         * Builds a {@link NodeShard}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeShard build() {
            _checkSingleUse();

            return new NodeShard(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeShard}
     */
    public static final JsonpDeserializer<NodeShard> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeShard::setupNodeShardDeserializer
    );

    protected static void setupNodeShardDeserializer(ObjectDeserializer<NodeShard.Builder> op) {
        op.add(Builder::allocationId, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "allocation_id");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::primary, JsonpDeserializer.booleanDeserializer(), "primary");
        op.add(Builder::recoverySource, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "recovery_source");
        op.add(Builder::relocatingNode, JsonpDeserializer.stringDeserializer(), "relocating_node");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
        op.add(Builder::state, ShardRoutingState._DESERIALIZER, "state");
        op.add(Builder::unassignedInfo, UnassignedInformation._DESERIALIZER, "unassigned_info");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocationId);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Boolean.hashCode(this.primary);
        result = 31 * result + Objects.hashCode(this.recoverySource);
        result = 31 * result + Objects.hashCode(this.relocatingNode);
        result = 31 * result + Integer.hashCode(this.shard);
        result = 31 * result + this.state.hashCode();
        result = 31 * result + Objects.hashCode(this.unassignedInfo);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeShard other = (NodeShard) o;
        return Objects.equals(this.allocationId, other.allocationId)
            && this.index.equals(other.index)
            && Objects.equals(this.node, other.node)
            && this.primary == other.primary
            && Objects.equals(this.recoverySource, other.recoverySource)
            && Objects.equals(this.relocatingNode, other.relocatingNode)
            && this.shard == other.shard
            && this.state.equals(other.state)
            && Objects.equals(this.unassignedInfo, other.unassignedInfo);
    }
}
