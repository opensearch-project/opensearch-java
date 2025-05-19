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

// typedef: snapshot.SnapshotShardsStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotShardsStats implements PlainJsonSerializable, ToCopyableBuilder<SnapshotShardsStats.Builder, SnapshotShardsStats> {

    @Nullable
    private final Long done;

    @Nullable
    private final Long failed;

    @Nullable
    private final Long finalizing;

    @Nullable
    private final Long initializing;

    @Nullable
    private final Long started;

    @Nullable
    private final Long total;

    // ---------------------------------------------------------------------------------------------

    private SnapshotShardsStats(Builder builder) {
        this.done = builder.done;
        this.failed = builder.failed;
        this.finalizing = builder.finalizing;
        this.initializing = builder.initializing;
        this.started = builder.started;
        this.total = builder.total;
    }

    public static SnapshotShardsStats of(Function<SnapshotShardsStats.Builder, ObjectBuilder<SnapshotShardsStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of completed shard snapshots.
     * <p>
     * API name: {@code done}
     * </p>
     */
    @Nullable
    public final Long done() {
        return this.done;
    }

    /**
     * The number of failed shard snapshots.
     * <p>
     * API name: {@code failed}
     * </p>
     */
    @Nullable
    public final Long failed() {
        return this.failed;
    }

    /**
     * The number of finalizing shard snapshots.
     * <p>
     * API name: {@code finalizing}
     * </p>
     */
    @Nullable
    public final Long finalizing() {
        return this.finalizing;
    }

    /**
     * The number of initializing shard snapshots.
     * <p>
     * API name: {@code initializing}
     * </p>
     */
    @Nullable
    public final Long initializing() {
        return this.initializing;
    }

    /**
     * The number of started shard snapshots.
     * <p>
     * API name: {@code started}
     * </p>
     */
    @Nullable
    public final Long started() {
        return this.started;
    }

    /**
     * The total number of shard snapshots.
     * <p>
     * API name: {@code total}
     * </p>
     */
    @Nullable
    public final Long total() {
        return this.total;
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
        if (this.done != null) {
            generator.writeKey("done");
            generator.write(this.done);
        }

        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
        }

        if (this.finalizing != null) {
            generator.writeKey("finalizing");
            generator.write(this.finalizing);
        }

        if (this.initializing != null) {
            generator.writeKey("initializing");
            generator.write(this.initializing);
        }

        if (this.started != null) {
            generator.writeKey("started");
            generator.write(this.started);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
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
     * Builder for {@link SnapshotShardsStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotShardsStats> {
        @Nullable
        private Long done;
        @Nullable
        private Long failed;
        @Nullable
        private Long finalizing;
        @Nullable
        private Long initializing;
        @Nullable
        private Long started;
        @Nullable
        private Long total;

        public Builder() {}

        private Builder(SnapshotShardsStats o) {
            this.done = o.done;
            this.failed = o.failed;
            this.finalizing = o.finalizing;
            this.initializing = o.initializing;
            this.started = o.started;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.done = o.done;
            this.failed = o.failed;
            this.finalizing = o.finalizing;
            this.initializing = o.initializing;
            this.started = o.started;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of completed shard snapshots.
         * <p>
         * API name: {@code done}
         * </p>
         */
        @Nonnull
        public final Builder done(@Nullable Long value) {
            this.done = value;
            return this;
        }

        /**
         * The number of failed shard snapshots.
         * <p>
         * API name: {@code failed}
         * </p>
         */
        @Nonnull
        public final Builder failed(@Nullable Long value) {
            this.failed = value;
            return this;
        }

        /**
         * The number of finalizing shard snapshots.
         * <p>
         * API name: {@code finalizing}
         * </p>
         */
        @Nonnull
        public final Builder finalizing(@Nullable Long value) {
            this.finalizing = value;
            return this;
        }

        /**
         * The number of initializing shard snapshots.
         * <p>
         * API name: {@code initializing}
         * </p>
         */
        @Nonnull
        public final Builder initializing(@Nullable Long value) {
            this.initializing = value;
            return this;
        }

        /**
         * The number of started shard snapshots.
         * <p>
         * API name: {@code started}
         * </p>
         */
        @Nonnull
        public final Builder started(@Nullable Long value) {
            this.started = value;
            return this;
        }

        /**
         * The total number of shard snapshots.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(@Nullable Long value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotShardsStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotShardsStats build() {
            _checkSingleUse();

            return new SnapshotShardsStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotShardsStats}
     */
    public static final JsonpDeserializer<SnapshotShardsStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotShardsStats::setupSnapshotShardsStatsDeserializer
    );

    protected static void setupSnapshotShardsStatsDeserializer(ObjectDeserializer<SnapshotShardsStats.Builder> op) {
        op.add(Builder::done, JsonpDeserializer.longDeserializer(), "done");
        op.add(Builder::failed, JsonpDeserializer.longDeserializer(), "failed");
        op.add(Builder::finalizing, JsonpDeserializer.longDeserializer(), "finalizing");
        op.add(Builder::initializing, JsonpDeserializer.longDeserializer(), "initializing");
        op.add(Builder::started, JsonpDeserializer.longDeserializer(), "started");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.done);
        result = 31 * result + Objects.hashCode(this.failed);
        result = 31 * result + Objects.hashCode(this.finalizing);
        result = 31 * result + Objects.hashCode(this.initializing);
        result = 31 * result + Objects.hashCode(this.started);
        result = 31 * result + Objects.hashCode(this.total);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotShardsStats other = (SnapshotShardsStats) o;
        return Objects.equals(this.done, other.done)
            && Objects.equals(this.failed, other.failed)
            && Objects.equals(this.finalizing, other.finalizing)
            && Objects.equals(this.initializing, other.initializing)
            && Objects.equals(this.started, other.started)
            && Objects.equals(this.total, other.total);
    }
}
