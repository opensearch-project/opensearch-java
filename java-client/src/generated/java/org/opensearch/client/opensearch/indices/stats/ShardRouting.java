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

package org.opensearch.client.opensearch.indices.stats;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.stats.ShardRouting

/**
 * The routing information for a shard.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardRouting implements PlainJsonSerializable, ToCopyableBuilder<ShardRouting.Builder, ShardRouting> {

    @Nonnull
    private final String node;

    private final boolean primary;

    @Nullable
    private final String relocatingNode;

    @Nonnull
    private final ShardRoutingState state;

    // ---------------------------------------------------------------------------------------------

    private ShardRouting(Builder builder) {
        this.node = ApiTypeHelper.requireNonNull(builder.node, this, "node");
        this.primary = ApiTypeHelper.requireNonNull(builder.primary, this, "primary");
        this.relocatingNode = builder.relocatingNode;
        this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");
    }

    public static ShardRouting of(Function<ShardRouting.Builder, ObjectBuilder<ShardRouting>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The node containing the shard.
     * <p>
     * API name: {@code node}
     * </p>
     */
    @Nonnull
    public final String node() {
        return this.node;
    }

    /**
     * Required - Whether this is a primary shard.
     * <p>
     * API name: {@code primary}
     * </p>
     */
    public final boolean primary() {
        return this.primary;
    }

    /**
     * The node where the shard is relocating to.
     * <p>
     * API name: {@code relocating_node}
     * </p>
     */
    @Nullable
    public final String relocatingNode() {
        return this.relocatingNode;
    }

    /**
     * Required - API name: {@code state}
     */
    @Nonnull
    public final ShardRoutingState state() {
        return this.state;
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
        generator.writeKey("node");
        generator.write(this.node);

        generator.writeKey("primary");
        generator.write(this.primary);

        if (this.relocatingNode != null) {
            generator.writeKey("relocating_node");
            generator.write(this.relocatingNode);
        }

        generator.writeKey("state");
        this.state.serialize(generator, mapper);
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
     * Builder for {@link ShardRouting}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardRouting> {
        private String node;
        private Boolean primary;
        @Nullable
        private String relocatingNode;
        private ShardRoutingState state;

        public Builder() {}

        private Builder(ShardRouting o) {
            this.node = o.node;
            this.primary = o.primary;
            this.relocatingNode = o.relocatingNode;
            this.state = o.state;
        }

        private Builder(Builder o) {
            this.node = o.node;
            this.primary = o.primary;
            this.relocatingNode = o.relocatingNode;
            this.state = o.state;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The node containing the shard.
         * <p>
         * API name: {@code node}
         * </p>
         */
        @Nonnull
        public final Builder node(String value) {
            this.node = value;
            return this;
        }

        /**
         * Required - Whether this is a primary shard.
         * <p>
         * API name: {@code primary}
         * </p>
         */
        @Nonnull
        public final Builder primary(boolean value) {
            this.primary = value;
            return this;
        }

        /**
         * The node where the shard is relocating to.
         * <p>
         * API name: {@code relocating_node}
         * </p>
         */
        @Nonnull
        public final Builder relocatingNode(@Nullable String value) {
            this.relocatingNode = value;
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
         * Builds a {@link ShardRouting}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardRouting build() {
            _checkSingleUse();

            return new ShardRouting(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardRouting}
     */
    public static final JsonpDeserializer<ShardRouting> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardRouting::setupShardRoutingDeserializer
    );

    protected static void setupShardRoutingDeserializer(ObjectDeserializer<ShardRouting.Builder> op) {
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::primary, JsonpDeserializer.booleanDeserializer(), "primary");
        op.add(Builder::relocatingNode, JsonpDeserializer.stringDeserializer(), "relocating_node");
        op.add(Builder::state, ShardRoutingState._DESERIALIZER, "state");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.node.hashCode();
        result = 31 * result + Boolean.hashCode(this.primary);
        result = 31 * result + Objects.hashCode(this.relocatingNode);
        result = 31 * result + this.state.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardRouting other = (ShardRouting) o;
        return this.node.equals(other.node)
            && this.primary == other.primary
            && Objects.equals(this.relocatingNode, other.relocatingNode)
            && this.state.equals(other.state);
    }
}
