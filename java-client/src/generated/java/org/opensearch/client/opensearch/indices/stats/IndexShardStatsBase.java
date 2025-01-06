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
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ObjectBuilder;

// typedef: indices.stats.IndexShardStatsBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class IndexShardStatsBase extends IndexStatsBase {

    @Nullable
    private final ShardCommit commit;

    @Nullable
    private final ShardRetentionLeases retentionLeases;

    @Nullable
    private final ShardRouting routing;

    @Nullable
    private final ShardSequenceNumber seqNo;

    @Nullable
    private final ShardPath shardPath;

    // ---------------------------------------------------------------------------------------------

    protected IndexShardStatsBase(AbstractBuilder<?> builder) {
        super(builder);
        this.commit = builder.commit;
        this.retentionLeases = builder.retentionLeases;
        this.routing = builder.routing;
        this.seqNo = builder.seqNo;
        this.shardPath = builder.shardPath;
    }

    /**
     * API name: {@code commit}
     */
    @Nullable
    public final ShardCommit commit() {
        return this.commit;
    }

    /**
     * API name: {@code retention_leases}
     */
    @Nullable
    public final ShardRetentionLeases retentionLeases() {
        return this.retentionLeases;
    }

    /**
     * API name: {@code routing}
     */
    @Nullable
    public final ShardRouting routing() {
        return this.routing;
    }

    /**
     * API name: {@code seq_no}
     */
    @Nullable
    public final ShardSequenceNumber seqNo() {
        return this.seqNo;
    }

    /**
     * API name: {@code shard_path}
     */
    @Nullable
    public final ShardPath shardPath() {
        return this.shardPath;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.commit != null) {
            generator.writeKey("commit");
            this.commit.serialize(generator, mapper);
        }

        if (this.retentionLeases != null) {
            generator.writeKey("retention_leases");
            this.retentionLeases.serialize(generator, mapper);
        }

        if (this.routing != null) {
            generator.writeKey("routing");
            this.routing.serialize(generator, mapper);
        }

        if (this.seqNo != null) {
            generator.writeKey("seq_no");
            this.seqNo.serialize(generator, mapper);
        }

        if (this.shardPath != null) {
            generator.writeKey("shard_path");
            this.shardPath.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends IndexStatsBase.AbstractBuilder<
        BuilderT> {
        @Nullable
        private ShardCommit commit;
        @Nullable
        private ShardRetentionLeases retentionLeases;
        @Nullable
        private ShardRouting routing;
        @Nullable
        private ShardSequenceNumber seqNo;
        @Nullable
        private ShardPath shardPath;

        protected AbstractBuilder() {}

        protected AbstractBuilder(IndexShardStatsBase o) {
            super(o);
            this.commit = o.commit;
            this.retentionLeases = o.retentionLeases;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.shardPath = o.shardPath;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            super(o);
            this.commit = o.commit;
            this.retentionLeases = o.retentionLeases;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.shardPath = o.shardPath;
        }

        /**
         * API name: {@code commit}
         */
        @Nonnull
        public final BuilderT commit(@Nullable ShardCommit value) {
            this.commit = value;
            return self();
        }

        /**
         * API name: {@code commit}
         */
        @Nonnull
        public final BuilderT commit(Function<ShardCommit.Builder, ObjectBuilder<ShardCommit>> fn) {
            return commit(fn.apply(new ShardCommit.Builder()).build());
        }

        /**
         * API name: {@code retention_leases}
         */
        @Nonnull
        public final BuilderT retentionLeases(@Nullable ShardRetentionLeases value) {
            this.retentionLeases = value;
            return self();
        }

        /**
         * API name: {@code retention_leases}
         */
        @Nonnull
        public final BuilderT retentionLeases(Function<ShardRetentionLeases.Builder, ObjectBuilder<ShardRetentionLeases>> fn) {
            return retentionLeases(fn.apply(new ShardRetentionLeases.Builder()).build());
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final BuilderT routing(@Nullable ShardRouting value) {
            this.routing = value;
            return self();
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final BuilderT routing(Function<ShardRouting.Builder, ObjectBuilder<ShardRouting>> fn) {
            return routing(fn.apply(new ShardRouting.Builder()).build());
        }

        /**
         * API name: {@code seq_no}
         */
        @Nonnull
        public final BuilderT seqNo(@Nullable ShardSequenceNumber value) {
            this.seqNo = value;
            return self();
        }

        /**
         * API name: {@code seq_no}
         */
        @Nonnull
        public final BuilderT seqNo(Function<ShardSequenceNumber.Builder, ObjectBuilder<ShardSequenceNumber>> fn) {
            return seqNo(fn.apply(new ShardSequenceNumber.Builder()).build());
        }

        /**
         * API name: {@code shard_path}
         */
        @Nonnull
        public final BuilderT shardPath(@Nullable ShardPath value) {
            this.shardPath = value;
            return self();
        }

        /**
         * API name: {@code shard_path}
         */
        @Nonnull
        public final BuilderT shardPath(Function<ShardPath.Builder, ObjectBuilder<ShardPath>> fn) {
            return shardPath(fn.apply(new ShardPath.Builder()).build());
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupIndexShardStatsBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        setupIndexStatsBaseDeserializer(op);
        op.add(AbstractBuilder::commit, ShardCommit._DESERIALIZER, "commit");
        op.add(AbstractBuilder::retentionLeases, ShardRetentionLeases._DESERIALIZER, "retention_leases");
        op.add(AbstractBuilder::routing, ShardRouting._DESERIALIZER, "routing");
        op.add(AbstractBuilder::seqNo, ShardSequenceNumber._DESERIALIZER, "seq_no");
        op.add(AbstractBuilder::shardPath, ShardPath._DESERIALIZER, "shard_path");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.commit);
        result = 31 * result + Objects.hashCode(this.retentionLeases);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.seqNo);
        result = 31 * result + Objects.hashCode(this.shardPath);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexShardStatsBase other = (IndexShardStatsBase) o;
        return Objects.equals(this.commit, other.commit)
            && Objects.equals(this.retentionLeases, other.retentionLeases)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.seqNo, other.seqNo)
            && Objects.equals(this.shardPath, other.shardPath);
    }
}
