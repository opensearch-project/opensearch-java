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

package org.opensearch.client.opensearch.indices;

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

// typedef: indices.IndexRoutingAllocation

/**
 * The configuration for shard allocation.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexRoutingAllocation
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IndexRoutingAllocation.Builder, IndexRoutingAllocation> {

    @Nullable
    private final IndexRoutingAllocationDisk disk;

    @Nullable
    private final IndexRoutingAllocationOptions enable;

    @Nullable
    private final IndexRoutingAllocationInclude include;

    @Nullable
    private final IndexRoutingAllocationInitialRecovery initialRecovery;

    @Nullable
    private final Integer totalPrimaryShardsPerNode;

    @Nullable
    private final Integer totalRemoteCapablePrimaryShardsPerNode;

    @Nullable
    private final Integer totalRemoteCapableShardsPerNode;

    @Nullable
    private final Integer totalShardsPerNode;

    // ---------------------------------------------------------------------------------------------

    protected IndexRoutingAllocation(AbstractBuilder<?> builder) {
        this.disk = builder.disk;
        this.enable = builder.enable;
        this.include = builder.include;
        this.initialRecovery = builder.initialRecovery;
        this.totalPrimaryShardsPerNode = builder.totalPrimaryShardsPerNode;
        this.totalRemoteCapablePrimaryShardsPerNode = builder.totalRemoteCapablePrimaryShardsPerNode;
        this.totalRemoteCapableShardsPerNode = builder.totalRemoteCapableShardsPerNode;
        this.totalShardsPerNode = builder.totalShardsPerNode;
    }

    public static IndexRoutingAllocation indexRoutingAllocationOf(
        Function<IndexRoutingAllocation.Builder, ObjectBuilder<IndexRoutingAllocation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code disk}
     */
    @Nullable
    public final IndexRoutingAllocationDisk disk() {
        return this.disk;
    }

    /**
     * API name: {@code enable}
     */
    @Nullable
    public final IndexRoutingAllocationOptions enable() {
        return this.enable;
    }

    /**
     * API name: {@code include}
     */
    @Nullable
    public final IndexRoutingAllocationInclude include() {
        return this.include;
    }

    /**
     * API name: {@code initial_recovery}
     */
    @Nullable
    public final IndexRoutingAllocationInitialRecovery initialRecovery() {
        return this.initialRecovery;
    }

    /**
     * API name: {@code total_primary_shards_per_node}
     */
    @Nullable
    public final Integer totalPrimaryShardsPerNode() {
        return this.totalPrimaryShardsPerNode;
    }

    /**
     * API name: {@code total_remote_capable_primary_shards_per_node}
     */
    @Nullable
    public final Integer totalRemoteCapablePrimaryShardsPerNode() {
        return this.totalRemoteCapablePrimaryShardsPerNode;
    }

    /**
     * API name: {@code total_remote_capable_shards_per_node}
     */
    @Nullable
    public final Integer totalRemoteCapableShardsPerNode() {
        return this.totalRemoteCapableShardsPerNode;
    }

    /**
     * API name: {@code total_shards_per_node}
     */
    @Nullable
    public final Integer totalShardsPerNode() {
        return this.totalShardsPerNode;
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
        if (this.disk != null) {
            generator.writeKey("disk");
            this.disk.serialize(generator, mapper);
        }

        if (this.enable != null) {
            generator.writeKey("enable");
            this.enable.serialize(generator, mapper);
        }

        if (this.include != null) {
            generator.writeKey("include");
            this.include.serialize(generator, mapper);
        }

        if (this.initialRecovery != null) {
            generator.writeKey("initial_recovery");
            this.initialRecovery.serialize(generator, mapper);
        }

        if (this.totalPrimaryShardsPerNode != null) {
            generator.writeKey("total_primary_shards_per_node");
            generator.write(this.totalPrimaryShardsPerNode);
        }

        if (this.totalRemoteCapablePrimaryShardsPerNode != null) {
            generator.writeKey("total_remote_capable_primary_shards_per_node");
            generator.write(this.totalRemoteCapablePrimaryShardsPerNode);
        }

        if (this.totalRemoteCapableShardsPerNode != null) {
            generator.writeKey("total_remote_capable_shards_per_node");
            generator.write(this.totalRemoteCapableShardsPerNode);
        }

        if (this.totalShardsPerNode != null) {
            generator.writeKey("total_shards_per_node");
            generator.write(this.totalShardsPerNode);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder indexRoutingAllocationBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link IndexRoutingAllocation}.
     */
    public static class Builder extends IndexRoutingAllocation.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, IndexRoutingAllocation> {
        public Builder() {}

        private Builder(IndexRoutingAllocation o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
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
         * Builds a {@link IndexRoutingAllocation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexRoutingAllocation build() {
            _checkSingleUse();

            return new IndexRoutingAllocation(this);
        }
    }

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private IndexRoutingAllocationDisk disk;
        @Nullable
        private IndexRoutingAllocationOptions enable;
        @Nullable
        private IndexRoutingAllocationInclude include;
        @Nullable
        private IndexRoutingAllocationInitialRecovery initialRecovery;
        @Nullable
        private Integer totalPrimaryShardsPerNode;
        @Nullable
        private Integer totalRemoteCapablePrimaryShardsPerNode;
        @Nullable
        private Integer totalRemoteCapableShardsPerNode;
        @Nullable
        private Integer totalShardsPerNode;

        protected AbstractBuilder() {}

        protected AbstractBuilder(IndexRoutingAllocation o) {
            this.disk = o.disk;
            this.enable = o.enable;
            this.include = o.include;
            this.initialRecovery = o.initialRecovery;
            this.totalPrimaryShardsPerNode = o.totalPrimaryShardsPerNode;
            this.totalRemoteCapablePrimaryShardsPerNode = o.totalRemoteCapablePrimaryShardsPerNode;
            this.totalRemoteCapableShardsPerNode = o.totalRemoteCapableShardsPerNode;
            this.totalShardsPerNode = o.totalShardsPerNode;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.disk = o.disk;
            this.enable = o.enable;
            this.include = o.include;
            this.initialRecovery = o.initialRecovery;
            this.totalPrimaryShardsPerNode = o.totalPrimaryShardsPerNode;
            this.totalRemoteCapablePrimaryShardsPerNode = o.totalRemoteCapablePrimaryShardsPerNode;
            this.totalRemoteCapableShardsPerNode = o.totalRemoteCapableShardsPerNode;
            this.totalShardsPerNode = o.totalShardsPerNode;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code disk}
         */
        @Nonnull
        public final BuilderT disk(@Nullable IndexRoutingAllocationDisk value) {
            this.disk = value;
            return self();
        }

        /**
         * API name: {@code disk}
         */
        @Nonnull
        public final BuilderT disk(Function<IndexRoutingAllocationDisk.Builder, ObjectBuilder<IndexRoutingAllocationDisk>> fn) {
            return disk(fn.apply(new IndexRoutingAllocationDisk.Builder()).build());
        }

        /**
         * API name: {@code enable}
         */
        @Nonnull
        public final BuilderT enable(@Nullable IndexRoutingAllocationOptions value) {
            this.enable = value;
            return self();
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final BuilderT include(@Nullable IndexRoutingAllocationInclude value) {
            this.include = value;
            return self();
        }

        /**
         * API name: {@code include}
         */
        @Nonnull
        public final BuilderT include(Function<IndexRoutingAllocationInclude.Builder, ObjectBuilder<IndexRoutingAllocationInclude>> fn) {
            return include(fn.apply(new IndexRoutingAllocationInclude.Builder()).build());
        }

        /**
         * API name: {@code initial_recovery}
         */
        @Nonnull
        public final BuilderT initialRecovery(@Nullable IndexRoutingAllocationInitialRecovery value) {
            this.initialRecovery = value;
            return self();
        }

        /**
         * API name: {@code initial_recovery}
         */
        @Nonnull
        public final BuilderT initialRecovery(
            Function<IndexRoutingAllocationInitialRecovery.Builder, ObjectBuilder<IndexRoutingAllocationInitialRecovery>> fn
        ) {
            return initialRecovery(fn.apply(new IndexRoutingAllocationInitialRecovery.Builder()).build());
        }

        /**
         * API name: {@code total_primary_shards_per_node}
         */
        @Nonnull
        public final BuilderT totalPrimaryShardsPerNode(@Nullable Integer value) {
            this.totalPrimaryShardsPerNode = value;
            return self();
        }

        /**
         * API name: {@code total_remote_capable_primary_shards_per_node}
         */
        @Nonnull
        public final BuilderT totalRemoteCapablePrimaryShardsPerNode(@Nullable Integer value) {
            this.totalRemoteCapablePrimaryShardsPerNode = value;
            return self();
        }

        /**
         * API name: {@code total_remote_capable_shards_per_node}
         */
        @Nonnull
        public final BuilderT totalRemoteCapableShardsPerNode(@Nullable Integer value) {
            this.totalRemoteCapableShardsPerNode = value;
            return self();
        }

        /**
         * API name: {@code total_shards_per_node}
         */
        @Nonnull
        public final BuilderT totalShardsPerNode(@Nullable Integer value) {
            this.totalShardsPerNode = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexRoutingAllocation}
     */
    public static final JsonpDeserializer<IndexRoutingAllocation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexRoutingAllocation::setupIndexRoutingAllocationDeserializer
    );

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupIndexRoutingAllocationDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        op.add(AbstractBuilder::disk, IndexRoutingAllocationDisk._DESERIALIZER, "disk");
        op.add(AbstractBuilder::enable, IndexRoutingAllocationOptions._DESERIALIZER, "enable");
        op.add(AbstractBuilder::include, IndexRoutingAllocationInclude._DESERIALIZER, "include");
        op.add(AbstractBuilder::initialRecovery, IndexRoutingAllocationInitialRecovery._DESERIALIZER, "initial_recovery");
        op.add(AbstractBuilder::totalPrimaryShardsPerNode, JsonpDeserializer.integerDeserializer(), "total_primary_shards_per_node");
        op.add(
            AbstractBuilder::totalRemoteCapablePrimaryShardsPerNode,
            JsonpDeserializer.integerDeserializer(),
            "total_remote_capable_primary_shards_per_node"
        );
        op.add(
            AbstractBuilder::totalRemoteCapableShardsPerNode,
            JsonpDeserializer.integerDeserializer(),
            "total_remote_capable_shards_per_node"
        );
        op.add(AbstractBuilder::totalShardsPerNode, JsonpDeserializer.integerDeserializer(), "total_shards_per_node");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.disk);
        result = 31 * result + Objects.hashCode(this.enable);
        result = 31 * result + Objects.hashCode(this.include);
        result = 31 * result + Objects.hashCode(this.initialRecovery);
        result = 31 * result + Objects.hashCode(this.totalPrimaryShardsPerNode);
        result = 31 * result + Objects.hashCode(this.totalRemoteCapablePrimaryShardsPerNode);
        result = 31 * result + Objects.hashCode(this.totalRemoteCapableShardsPerNode);
        result = 31 * result + Objects.hashCode(this.totalShardsPerNode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexRoutingAllocation other = (IndexRoutingAllocation) o;
        return Objects.equals(this.disk, other.disk)
            && Objects.equals(this.enable, other.enable)
            && Objects.equals(this.include, other.include)
            && Objects.equals(this.initialRecovery, other.initialRecovery)
            && Objects.equals(this.totalPrimaryShardsPerNode, other.totalPrimaryShardsPerNode)
            && Objects.equals(this.totalRemoteCapablePrimaryShardsPerNode, other.totalRemoteCapablePrimaryShardsPerNode)
            && Objects.equals(this.totalRemoteCapableShardsPerNode, other.totalRemoteCapableShardsPerNode)
            && Objects.equals(this.totalShardsPerNode, other.totalShardsPerNode);
    }
}
