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

package org.opensearch.client.opensearch.snapshot;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: snapshot.SnapshotIndexStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotIndexStats implements PlainJsonSerializable, ToCopyableBuilder<SnapshotIndexStats.Builder, SnapshotIndexStats> {

    @Nonnull
    private final Map<String, SnapshotShardsStatus> shards;

    @Nonnull
    private final SnapshotShardsStats shardsStats;

    @Nonnull
    private final SnapshotStats stats;

    // ---------------------------------------------------------------------------------------------

    private SnapshotIndexStats(Builder builder) {
        this.shards = ApiTypeHelper.unmodifiableRequired(builder.shards, this, "shards");
        this.shardsStats = ApiTypeHelper.requireNonNull(builder.shardsStats, this, "shardsStats");
        this.stats = ApiTypeHelper.requireNonNull(builder.stats, this, "stats");
    }

    public static SnapshotIndexStats of(Function<SnapshotIndexStats.Builder, ObjectBuilder<SnapshotIndexStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code shards}
     */
    @Nonnull
    public final Map<String, SnapshotShardsStatus> shards() {
        return this.shards;
    }

    /**
     * Required - API name: {@code shards_stats}
     */
    @Nonnull
    public final SnapshotShardsStats shardsStats() {
        return this.shardsStats;
    }

    /**
     * Required - API name: {@code stats}
     */
    @Nonnull
    public final SnapshotStats stats() {
        return this.stats;
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
        generator.writeKey("shards");
        generator.writeStartObject();
        for (Map.Entry<String, SnapshotShardsStatus> item0 : this.shards.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("shards_stats");
        this.shardsStats.serialize(generator, mapper);

        generator.writeKey("stats");
        this.stats.serialize(generator, mapper);
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
     * Builder for {@link SnapshotIndexStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotIndexStats> {
        private Map<String, SnapshotShardsStatus> shards;
        private SnapshotShardsStats shardsStats;
        private SnapshotStats stats;

        public Builder() {}

        private Builder(SnapshotIndexStats o) {
            this.shards = _mapCopy(o.shards);
            this.shardsStats = o.shardsStats;
            this.stats = o.stats;
        }

        private Builder(Builder o) {
            this.shards = _mapCopy(o.shards);
            this.shardsStats = o.shardsStats;
            this.stats = o.stats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code shards}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, SnapshotShardsStatus> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * Required - API name: {@code shards}
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, SnapshotShardsStatus value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * Required - API name: {@code shards}
         *
         * <p>
         * Adds a value to <code>shards</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, Function<SnapshotShardsStatus.Builder, ObjectBuilder<SnapshotShardsStatus>> fn) {
            return shards(key, fn.apply(new SnapshotShardsStatus.Builder()).build());
        }

        /**
         * Required - API name: {@code shards_stats}
         */
        @Nonnull
        public final Builder shardsStats(SnapshotShardsStats value) {
            this.shardsStats = value;
            return this;
        }

        /**
         * Required - API name: {@code shards_stats}
         */
        @Nonnull
        public final Builder shardsStats(Function<SnapshotShardsStats.Builder, ObjectBuilder<SnapshotShardsStats>> fn) {
            return shardsStats(fn.apply(new SnapshotShardsStats.Builder()).build());
        }

        /**
         * Required - API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(SnapshotStats value) {
            this.stats = value;
            return this;
        }

        /**
         * Required - API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(Function<SnapshotStats.Builder, ObjectBuilder<SnapshotStats>> fn) {
            return stats(fn.apply(new SnapshotStats.Builder()).build());
        }

        /**
         * Builds a {@link SnapshotIndexStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotIndexStats build() {
            _checkSingleUse();

            return new SnapshotIndexStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotIndexStats}
     */
    public static final JsonpDeserializer<SnapshotIndexStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotIndexStats::setupSnapshotIndexStatsDeserializer
    );

    protected static void setupSnapshotIndexStatsDeserializer(ObjectDeserializer<SnapshotIndexStats.Builder> op) {
        op.add(Builder::shards, JsonpDeserializer.stringMapDeserializer(SnapshotShardsStatus._DESERIALIZER), "shards");
        op.add(Builder::shardsStats, SnapshotShardsStats._DESERIALIZER, "shards_stats");
        op.add(Builder::stats, SnapshotStats._DESERIALIZER, "stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.shards.hashCode();
        result = 31 * result + this.shardsStats.hashCode();
        result = 31 * result + this.stats.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotIndexStats other = (SnapshotIndexStats) o;
        return this.shards.equals(other.shards) && this.shardsStats.equals(other.shardsStats) && this.stats.equals(other.stats);
    }
}