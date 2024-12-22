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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.stats.IndexShardStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class IndexShardStats extends IndexStatsBase implements ToCopyableBuilder<IndexShardStats.Builder, IndexShardStats> {

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

    private IndexShardStats(Builder builder) {
        super(builder);
        this.commit = builder.commit;
        this.retentionLeases = builder.retentionLeases;
        this.routing = builder.routing;
        this.seqNo = builder.seqNo;
        this.shardPath = builder.shardPath;
    }

    public static IndexShardStats of(Function<IndexShardStats.Builder, ObjectBuilder<IndexShardStats>> fn) {
        return fn.apply(new Builder()).build();
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
     * Builder for {@link IndexShardStats}.
     */
    public static class Builder extends IndexStatsBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, IndexShardStats> {
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

        public Builder() {}

        private Builder(IndexShardStats o) {
            super(o);
            this.commit = o.commit;
            this.retentionLeases = o.retentionLeases;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.shardPath = o.shardPath;
        }

        private Builder(Builder o) {
            super(o);
            this.commit = o.commit;
            this.retentionLeases = o.retentionLeases;
            this.routing = o.routing;
            this.seqNo = o.seqNo;
            this.shardPath = o.shardPath;
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
         * API name: {@code commit}
         */
        @Nonnull
        public final Builder commit(@Nullable ShardCommit value) {
            this.commit = value;
            return this;
        }

        /**
         * API name: {@code commit}
         */
        @Nonnull
        public final Builder commit(Function<ShardCommit.Builder, ObjectBuilder<ShardCommit>> fn) {
            return commit(fn.apply(new ShardCommit.Builder()).build());
        }

        /**
         * API name: {@code retention_leases}
         */
        @Nonnull
        public final Builder retentionLeases(@Nullable ShardRetentionLeases value) {
            this.retentionLeases = value;
            return this;
        }

        /**
         * API name: {@code retention_leases}
         */
        @Nonnull
        public final Builder retentionLeases(Function<ShardRetentionLeases.Builder, ObjectBuilder<ShardRetentionLeases>> fn) {
            return retentionLeases(fn.apply(new ShardRetentionLeases.Builder()).build());
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(@Nullable ShardRouting value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code routing}
         */
        @Nonnull
        public final Builder routing(Function<ShardRouting.Builder, ObjectBuilder<ShardRouting>> fn) {
            return routing(fn.apply(new ShardRouting.Builder()).build());
        }

        /**
         * API name: {@code seq_no}
         */
        @Nonnull
        public final Builder seqNo(@Nullable ShardSequenceNumber value) {
            this.seqNo = value;
            return this;
        }

        /**
         * API name: {@code seq_no}
         */
        @Nonnull
        public final Builder seqNo(Function<ShardSequenceNumber.Builder, ObjectBuilder<ShardSequenceNumber>> fn) {
            return seqNo(fn.apply(new ShardSequenceNumber.Builder()).build());
        }

        /**
         * API name: {@code shard_path}
         */
        @Nonnull
        public final Builder shardPath(@Nullable ShardPath value) {
            this.shardPath = value;
            return this;
        }

        /**
         * API name: {@code shard_path}
         */
        @Nonnull
        public final Builder shardPath(Function<ShardPath.Builder, ObjectBuilder<ShardPath>> fn) {
            return shardPath(fn.apply(new ShardPath.Builder()).build());
        }

        /**
         * Builds a {@link IndexShardStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexShardStats build() {
            _checkSingleUse();

            return new IndexShardStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexShardStats}
     */
    public static final JsonpDeserializer<IndexShardStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexShardStats::setupIndexShardStatsDeserializer
    );

    protected static void setupIndexShardStatsDeserializer(ObjectDeserializer<IndexShardStats.Builder> op) {
        setupIndexStatsBaseDeserializer(op);
        op.add(Builder::commit, ShardCommit._DESERIALIZER, "commit");
        op.add(Builder::retentionLeases, ShardRetentionLeases._DESERIALIZER, "retention_leases");
        op.add(Builder::routing, ShardRouting._DESERIALIZER, "routing");
        op.add(Builder::seqNo, ShardSequenceNumber._DESERIALIZER, "seq_no");
        op.add(Builder::shardPath, ShardPath._DESERIALIZER, "shard_path");
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
        IndexShardStats other = (IndexShardStats) o;
        return Objects.equals(this.commit, other.commit)
            && Objects.equals(this.retentionLeases, other.retentionLeases)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.seqNo, other.seqNo)
            && Objects.equals(this.shardPath, other.shardPath);
    }
}
