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
import org.opensearch.client.opensearch.indices.IndexRoutingAllocation;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.info.NodeInfoSettingsClusterRoutingAllocation

/**
 * The cluster-level shard allocation configuration.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoSettingsClusterRoutingAllocation extends IndexRoutingAllocation
    implements
        ToCopyableBuilder<NodeInfoSettingsClusterRoutingAllocation.Builder, NodeInfoSettingsClusterRoutingAllocation> {

    @Nullable
    private final NodeInfoSettingsClusterRoutingAllocationAwareness awareness;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoSettingsClusterRoutingAllocation(Builder builder) {
        super(builder);
        this.awareness = builder.awareness;
    }

    public static NodeInfoSettingsClusterRoutingAllocation of(
        Function<NodeInfoSettingsClusterRoutingAllocation.Builder, ObjectBuilder<NodeInfoSettingsClusterRoutingAllocation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code awareness}
     */
    @Nullable
    public final NodeInfoSettingsClusterRoutingAllocationAwareness awareness() {
        return this.awareness;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.awareness != null) {
            generator.writeKey("awareness");
            this.awareness.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoSettingsClusterRoutingAllocation}.
     */
    public static class Builder extends IndexRoutingAllocation.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, NodeInfoSettingsClusterRoutingAllocation> {
        @Nullable
        private NodeInfoSettingsClusterRoutingAllocationAwareness awareness;

        public Builder() {}

        private Builder(NodeInfoSettingsClusterRoutingAllocation o) {
            super(o);
            this.awareness = o.awareness;
        }

        private Builder(Builder o) {
            super(o);
            this.awareness = o.awareness;
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
         * API name: {@code awareness}
         */
        @Nonnull
        public final Builder awareness(@Nullable NodeInfoSettingsClusterRoutingAllocationAwareness value) {
            this.awareness = value;
            return this;
        }

        /**
         * API name: {@code awareness}
         */
        @Nonnull
        public final Builder awareness(
            Function<
                NodeInfoSettingsClusterRoutingAllocationAwareness.Builder,
                ObjectBuilder<NodeInfoSettingsClusterRoutingAllocationAwareness>> fn
        ) {
            return awareness(fn.apply(new NodeInfoSettingsClusterRoutingAllocationAwareness.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoSettingsClusterRoutingAllocation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoSettingsClusterRoutingAllocation build() {
            _checkSingleUse();

            return new NodeInfoSettingsClusterRoutingAllocation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoSettingsClusterRoutingAllocation}
     */
    public static final JsonpDeserializer<NodeInfoSettingsClusterRoutingAllocation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoSettingsClusterRoutingAllocation::setupNodeInfoSettingsClusterRoutingAllocationDeserializer
    );

    protected static void setupNodeInfoSettingsClusterRoutingAllocationDeserializer(
        ObjectDeserializer<NodeInfoSettingsClusterRoutingAllocation.Builder> op
    ) {
        setupIndexRoutingAllocationDeserializer(op);
        op.add(Builder::awareness, NodeInfoSettingsClusterRoutingAllocationAwareness._DESERIALIZER, "awareness");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.awareness);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoSettingsClusterRoutingAllocation other = (NodeInfoSettingsClusterRoutingAllocation) o;
        return Objects.equals(this.awareness, other.awareness);
    }
}
