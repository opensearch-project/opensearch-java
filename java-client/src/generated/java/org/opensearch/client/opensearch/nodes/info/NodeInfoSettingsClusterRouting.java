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

package org.opensearch.client.opensearch.nodes.info;

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
import org.opensearch.client.opensearch.indices.IndexRoutingRebalance;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeInfoSettingsClusterRouting

/**
 * The cluster-level routing configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsClusterRouting
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoSettingsClusterRouting.Builder, NodeInfoSettingsClusterRouting> {

    @Nullable
    private final NodeInfoSettingsClusterRoutingAllocation allocation;

    @Nullable
    private final IndexRoutingRebalance rebalance;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsClusterRouting(Builder builder) {
        this.allocation = builder.allocation;
        this.rebalance = builder.rebalance;
    }

    public static NodeInfoSettingsClusterRouting of(
        Function<NodeInfoSettingsClusterRouting.Builder, ObjectBuilder<NodeInfoSettingsClusterRouting>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code allocation}
     */
    @Nullable
    public final NodeInfoSettingsClusterRoutingAllocation allocation() {
        return this.allocation;
    }

    /**
     * API name: {@code rebalance}
     */
    @Nullable
    public final IndexRoutingRebalance rebalance() {
        return this.rebalance;
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
        if (this.allocation != null) {
            generator.writeKey("allocation");
            this.allocation.serialize(generator, mapper);
        }

        if (this.rebalance != null) {
            generator.writeKey("rebalance");
            this.rebalance.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoSettingsClusterRouting}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoSettingsClusterRouting> {
        @Nullable
        private NodeInfoSettingsClusterRoutingAllocation allocation;
        @Nullable
        private IndexRoutingRebalance rebalance;

        public Builder() {}

        private Builder(NodeInfoSettingsClusterRouting o) {
            this.allocation = o.allocation;
            this.rebalance = o.rebalance;
        }

        private Builder(Builder o) {
            this.allocation = o.allocation;
            this.rebalance = o.rebalance;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code allocation}
         */
        @Nonnull
        public final Builder allocation(@Nullable NodeInfoSettingsClusterRoutingAllocation value) {
            this.allocation = value;
            return this;
        }

        /**
         * API name: {@code allocation}
         */
        @Nonnull
        public final Builder allocation(
            Function<NodeInfoSettingsClusterRoutingAllocation.Builder, ObjectBuilder<NodeInfoSettingsClusterRoutingAllocation>> fn
        ) {
            return allocation(fn.apply(new NodeInfoSettingsClusterRoutingAllocation.Builder()).build());
        }

        /**
         * API name: {@code rebalance}
         */
        @Nonnull
        public final Builder rebalance(@Nullable IndexRoutingRebalance value) {
            this.rebalance = value;
            return this;
        }

        /**
         * API name: {@code rebalance}
         */
        @Nonnull
        public final Builder rebalance(Function<IndexRoutingRebalance.Builder, ObjectBuilder<IndexRoutingRebalance>> fn) {
            return rebalance(fn.apply(new IndexRoutingRebalance.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSettingsClusterRouting}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsClusterRouting build() {
            _checkSingleUse();

            return new NodeInfoSettingsClusterRouting(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsClusterRouting}
     */
    public static final JsonpDeserializer<NodeInfoSettingsClusterRouting> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsClusterRouting::setupNodeInfoSettingsClusterRoutingDeserializer
    );

    protected static void setupNodeInfoSettingsClusterRoutingDeserializer(ObjectDeserializer<NodeInfoSettingsClusterRouting.Builder> op) {
        op.add(Builder::allocation, NodeInfoSettingsClusterRoutingAllocation._DESERIALIZER, "allocation");
        op.add(Builder::rebalance, IndexRoutingRebalance._DESERIALIZER, "rebalance");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allocation);
        result = 31 * result + Objects.hashCode(this.rebalance);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsClusterRouting other = (NodeInfoSettingsClusterRouting) o;
        return Objects.equals(this.allocation, other.allocation) && Objects.equals(this.rebalance, other.rebalance);
    }
}
