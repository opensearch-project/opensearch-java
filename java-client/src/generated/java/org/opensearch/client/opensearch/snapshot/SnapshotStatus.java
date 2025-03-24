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

// typedef: snapshot.SnapshotStatus

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotStatus implements PlainJsonSerializable, ToCopyableBuilder<SnapshotStatus.Builder, SnapshotStatus> {

    @Nullable
    private final Boolean includeGlobalState;

    @Nonnull
    private final Map<String, SnapshotIndexStats> indices;

    @Nullable
    private final String repository;

    @Nullable
    private final SnapshotShardsStats shardsStats;

    @Nullable
    private final String snapshot;

    @Nullable
    private final String state;

    @Nullable
    private final SnapshotStats stats;

    @Nullable
    private final String uuid;

    // ---------------------------------------------------------------------------------------------

    private SnapshotStatus(Builder builder) {
        this.includeGlobalState = builder.includeGlobalState;
        this.indices = ApiTypeHelper.unmodifiable(builder.indices);
        this.repository = builder.repository;
        this.shardsStats = builder.shardsStats;
        this.snapshot = builder.snapshot;
        this.state = builder.state;
        this.stats = builder.stats;
        this.uuid = builder.uuid;
    }

    public static SnapshotStatus of(Function<SnapshotStatus.Builder, ObjectBuilder<SnapshotStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether the snapshot includes the cluster state.
     * <p>
     * API name: {@code include_global_state}
     * </p>
     */
    @Nullable
    public final Boolean includeGlobalState() {
        return this.includeGlobalState;
    }

    /**
     * The status of indexes in the snapshot.
     * <p>
     * API name: {@code indices}
     * </p>
     */
    @Nonnull
    public final Map<String, SnapshotIndexStats> indices() {
        return this.indices;
    }

    /**
     * The name of the repository containing the snapshot.
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nullable
    public final String repository() {
        return this.repository;
    }

    /**
     * The statistics about snapshot shards.
     * <p>
     * API name: {@code shards_stats}
     * </p>
     */
    @Nullable
    public final SnapshotShardsStats shardsStats() {
        return this.shardsStats;
    }

    /**
     * The name of the snapshot.
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nullable
    public final String snapshot() {
        return this.snapshot;
    }

    /**
     * The current state of the snapshot.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nullable
    public final String state() {
        return this.state;
    }

    /**
     * The detailed statistics about the snapshot.
     * <p>
     * API name: {@code stats}
     * </p>
     */
    @Nullable
    public final SnapshotStats stats() {
        return this.stats;
    }

    /**
     * The unique identifier for the snapshot.
     * <p>
     * API name: {@code uuid}
     * </p>
     */
    @Nullable
    public final String uuid() {
        return this.uuid;
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
        if (this.includeGlobalState != null) {
            generator.writeKey("include_global_state");
            generator.write(this.includeGlobalState);
        }

        if (ApiTypeHelper.isDefined(this.indices)) {
            generator.writeKey("indices");
            generator.writeStartObject();
            for (Map.Entry<String, SnapshotIndexStats> item0 : this.indices.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.repository != null) {
            generator.writeKey("repository");
            generator.write(this.repository);
        }

        if (this.shardsStats != null) {
            generator.writeKey("shards_stats");
            this.shardsStats.serialize(generator, mapper);
        }

        if (this.snapshot != null) {
            generator.writeKey("snapshot");
            generator.write(this.snapshot);
        }

        if (this.state != null) {
            generator.writeKey("state");
            generator.write(this.state);
        }

        if (this.stats != null) {
            generator.writeKey("stats");
            this.stats.serialize(generator, mapper);
        }

        if (this.uuid != null) {
            generator.writeKey("uuid");
            generator.write(this.uuid);
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
     * Builder for {@link SnapshotStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotStatus> {
        @Nullable
        private Boolean includeGlobalState;
        @Nullable
        private Map<String, SnapshotIndexStats> indices;
        @Nullable
        private String repository;
        @Nullable
        private SnapshotShardsStats shardsStats;
        @Nullable
        private String snapshot;
        @Nullable
        private String state;
        @Nullable
        private SnapshotStats stats;
        @Nullable
        private String uuid;

        public Builder() {}

        private Builder(SnapshotStatus o) {
            this.includeGlobalState = o.includeGlobalState;
            this.indices = _mapCopy(o.indices);
            this.repository = o.repository;
            this.shardsStats = o.shardsStats;
            this.snapshot = o.snapshot;
            this.state = o.state;
            this.stats = o.stats;
            this.uuid = o.uuid;
        }

        private Builder(Builder o) {
            this.includeGlobalState = o.includeGlobalState;
            this.indices = _mapCopy(o.indices);
            this.repository = o.repository;
            this.shardsStats = o.shardsStats;
            this.snapshot = o.snapshot;
            this.state = o.state;
            this.stats = o.stats;
            this.uuid = o.uuid;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether the snapshot includes the cluster state.
         * <p>
         * API name: {@code include_global_state}
         * </p>
         */
        @Nonnull
        public final Builder includeGlobalState(@Nullable Boolean value) {
            this.includeGlobalState = value;
            return this;
        }

        /**
         * The status of indexes in the snapshot.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, SnapshotIndexStats> map) {
            this.indices = _mapPutAll(this.indices, map);
            return this;
        }

        /**
         * The status of indexes in the snapshot.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds an entry to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, SnapshotIndexStats value) {
            this.indices = _mapPut(this.indices, key, value);
            return this;
        }

        /**
         * The status of indexes in the snapshot.
         * <p>
         * API name: {@code indices}
         * </p>
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, Function<SnapshotIndexStats.Builder, ObjectBuilder<SnapshotIndexStats>> fn) {
            return indices(key, fn.apply(new SnapshotIndexStats.Builder()).build());
        }

        /**
         * The name of the repository containing the snapshot.
         * <p>
         * API name: {@code repository}
         * </p>
         */
        @Nonnull
        public final Builder repository(@Nullable String value) {
            this.repository = value;
            return this;
        }

        /**
         * The statistics about snapshot shards.
         * <p>
         * API name: {@code shards_stats}
         * </p>
         */
        @Nonnull
        public final Builder shardsStats(@Nullable SnapshotShardsStats value) {
            this.shardsStats = value;
            return this;
        }

        /**
         * The statistics about snapshot shards.
         * <p>
         * API name: {@code shards_stats}
         * </p>
         */
        @Nonnull
        public final Builder shardsStats(Function<SnapshotShardsStats.Builder, ObjectBuilder<SnapshotShardsStats>> fn) {
            return shardsStats(fn.apply(new SnapshotShardsStats.Builder()).build());
        }

        /**
         * The name of the snapshot.
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(@Nullable String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * The current state of the snapshot.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(@Nullable String value) {
            this.state = value;
            return this;
        }

        /**
         * The detailed statistics about the snapshot.
         * <p>
         * API name: {@code stats}
         * </p>
         */
        @Nonnull
        public final Builder stats(@Nullable SnapshotStats value) {
            this.stats = value;
            return this;
        }

        /**
         * The detailed statistics about the snapshot.
         * <p>
         * API name: {@code stats}
         * </p>
         */
        @Nonnull
        public final Builder stats(Function<SnapshotStats.Builder, ObjectBuilder<SnapshotStats>> fn) {
            return stats(fn.apply(new SnapshotStats.Builder()).build());
        }

        /**
         * The unique identifier for the snapshot.
         * <p>
         * API name: {@code uuid}
         * </p>
         */
        @Nonnull
        public final Builder uuid(@Nullable String value) {
            this.uuid = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotStatus build() {
            _checkSingleUse();

            return new SnapshotStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotStatus}
     */
    public static final JsonpDeserializer<SnapshotStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotStatus::setupSnapshotStatusDeserializer
    );

    protected static void setupSnapshotStatusDeserializer(ObjectDeserializer<SnapshotStatus.Builder> op) {
        op.add(Builder::includeGlobalState, JsonpDeserializer.booleanDeserializer(), "include_global_state");
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(SnapshotIndexStats._DESERIALIZER), "indices");
        op.add(Builder::repository, JsonpDeserializer.stringDeserializer(), "repository");
        op.add(Builder::shardsStats, SnapshotShardsStats._DESERIALIZER, "shards_stats");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
        op.add(Builder::stats, SnapshotStats._DESERIALIZER, "stats");
        op.add(Builder::uuid, JsonpDeserializer.stringDeserializer(), "uuid");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.includeGlobalState);
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.repository);
        result = 31 * result + Objects.hashCode(this.shardsStats);
        result = 31 * result + Objects.hashCode(this.snapshot);
        result = 31 * result + Objects.hashCode(this.state);
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.uuid);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotStatus other = (SnapshotStatus) o;
        return Objects.equals(this.includeGlobalState, other.includeGlobalState)
            && Objects.equals(this.indices, other.indices)
            && Objects.equals(this.repository, other.repository)
            && Objects.equals(this.shardsStats, other.shardsStats)
            && Objects.equals(this.snapshot, other.snapshot)
            && Objects.equals(this.state, other.state)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.uuid, other.uuid);
    }
}
