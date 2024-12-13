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

    @Nonnull
    private final String repository;

    @Nonnull
    private final SnapshotShardsStats shardsStats;

    @Nonnull
    private final String snapshot;

    @Nonnull
    private final String state;

    @Nonnull
    private final SnapshotStats stats;

    @Nonnull
    private final String uuid;

    // ---------------------------------------------------------------------------------------------

    private SnapshotStatus(Builder builder) {
        this.includeGlobalState = builder.includeGlobalState;
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
        this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
        this.shardsStats = ApiTypeHelper.requireNonNull(builder.shardsStats, this, "shardsStats");
        this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
        this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");
        this.stats = ApiTypeHelper.requireNonNull(builder.stats, this, "stats");
        this.uuid = ApiTypeHelper.requireNonNull(builder.uuid, this, "uuid");
    }

    public static SnapshotStatus of(Function<SnapshotStatus.Builder, ObjectBuilder<SnapshotStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code include_global_state}
     */
    @Nullable
    public final Boolean includeGlobalState() {
        return this.includeGlobalState;
    }

    /**
     * Required - API name: {@code indices}
     */
    @Nonnull
    public final Map<String, SnapshotIndexStats> indices() {
        return this.indices;
    }

    /**
     * Required - API name: {@code repository}
     */
    @Nonnull
    public final String repository() {
        return this.repository;
    }

    /**
     * Required - API name: {@code shards_stats}
     */
    @Nonnull
    public final SnapshotShardsStats shardsStats() {
        return this.shardsStats;
    }

    /**
     * Required - API name: {@code snapshot}
     */
    @Nonnull
    public final String snapshot() {
        return this.snapshot;
    }

    /**
     * Required - API name: {@code state}
     */
    @Nonnull
    public final String state() {
        return this.state;
    }

    /**
     * Required - API name: {@code stats}
     */
    @Nonnull
    public final SnapshotStats stats() {
        return this.stats;
    }

    /**
     * Required - API name: {@code uuid}
     */
    @Nonnull
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

        generator.writeKey("indices");
        generator.writeStartObject();
        for (Map.Entry<String, SnapshotIndexStats> item0 : this.indices.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        generator.writeKey("repository");
        generator.write(this.repository);

        generator.writeKey("shards_stats");
        this.shardsStats.serialize(generator, mapper);

        generator.writeKey("snapshot");
        generator.write(this.snapshot);

        generator.writeKey("state");
        generator.write(this.state);

        generator.writeKey("stats");
        this.stats.serialize(generator, mapper);

        generator.writeKey("uuid");
        generator.write(this.uuid);
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
        private Map<String, SnapshotIndexStats> indices;
        private String repository;
        private SnapshotShardsStats shardsStats;
        private String snapshot;
        private String state;
        private SnapshotStats stats;
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
         * API name: {@code include_global_state}
         */
        @Nonnull
        public final Builder includeGlobalState(@Nullable Boolean value) {
            this.includeGlobalState = value;
            return this;
        }

        /**
         * Required - API name: {@code indices}
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
         * Required - API name: {@code indices}
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
         * Required - API name: {@code indices}
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
         * Required - API name: {@code repository}
         */
        @Nonnull
        public final Builder repository(String value) {
            this.repository = value;
            return this;
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
         * Required - API name: {@code snapshot}
         */
        @Nonnull
        public final Builder snapshot(String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * Required - API name: {@code state}
         */
        @Nonnull
        public final Builder state(String value) {
            this.state = value;
            return this;
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
         * Required - API name: {@code uuid}
         */
        @Nonnull
        public final Builder uuid(String value) {
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
        result = 31 * result + this.indices.hashCode();
        result = 31 * result + this.repository.hashCode();
        result = 31 * result + this.shardsStats.hashCode();
        result = 31 * result + this.snapshot.hashCode();
        result = 31 * result + this.state.hashCode();
        result = 31 * result + this.stats.hashCode();
        result = 31 * result + this.uuid.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotStatus other = (SnapshotStatus) o;
        return Objects.equals(this.includeGlobalState, other.includeGlobalState)
            && this.indices.equals(other.indices)
            && this.repository.equals(other.repository)
            && this.shardsStats.equals(other.shardsStats)
            && this.snapshot.equals(other.snapshot)
            && this.state.equals(other.state)
            && this.stats.equals(other.stats)
            && this.uuid.equals(other.uuid);
    }
}
