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

// typedef: snapshot.SnapshotShardFailure

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotShardFailure implements PlainJsonSerializable, ToCopyableBuilder<SnapshotShardFailure.Builder, SnapshotShardFailure> {

    @Nullable
    private final String index;

    @Nullable
    private final String nodeId;

    @Nullable
    private final String reason;

    @Nullable
    private final String shardId;

    @Nullable
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private SnapshotShardFailure(Builder builder) {
        this.index = builder.index;
        this.nodeId = builder.nodeId;
        this.reason = builder.reason;
        this.shardId = builder.shardId;
        this.status = builder.status;
    }

    public static SnapshotShardFailure of(Function<SnapshotShardFailure.Builder, ObjectBuilder<SnapshotShardFailure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The name of the index containing the failed shard.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * The ID of the node where the shard failure occurred.
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nullable
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * The reason for the shard failure.
     * <p>
     * API name: {@code reason}
     * </p>
     */
    @Nullable
    public final String reason() {
        return this.reason;
    }

    /**
     * The ID of the failed shard.
     * <p>
     * API name: {@code shard_id}
     * </p>
     */
    @Nullable
    public final String shardId() {
        return this.shardId;
    }

    /**
     * The status of the failed shard.
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nullable
    public final String status() {
        return this.status;
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
        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.nodeId != null) {
            generator.writeKey("node_id");
            generator.write(this.nodeId);
        }

        if (this.reason != null) {
            generator.writeKey("reason");
            generator.write(this.reason);
        }

        if (this.shardId != null) {
            generator.writeKey("shard_id");
            generator.write(this.shardId);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link SnapshotShardFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotShardFailure> {
        @Nullable
        private String index;
        @Nullable
        private String nodeId;
        @Nullable
        private String reason;
        @Nullable
        private String shardId;
        @Nullable
        private String status;

        public Builder() {}

        private Builder(SnapshotShardFailure o) {
            this.index = o.index;
            this.nodeId = o.nodeId;
            this.reason = o.reason;
            this.shardId = o.shardId;
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.index = o.index;
            this.nodeId = o.nodeId;
            this.reason = o.reason;
            this.shardId = o.shardId;
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The name of the index containing the failed shard.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * The ID of the node where the shard failure occurred.
         * <p>
         * API name: {@code node_id}
         * </p>
         */
        @Nonnull
        public final Builder nodeId(@Nullable String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * The reason for the shard failure.
         * <p>
         * API name: {@code reason}
         * </p>
         */
        @Nonnull
        public final Builder reason(@Nullable String value) {
            this.reason = value;
            return this;
        }

        /**
         * The ID of the failed shard.
         * <p>
         * API name: {@code shard_id}
         * </p>
         */
        @Nonnull
        public final Builder shardId(@Nullable String value) {
            this.shardId = value;
            return this;
        }

        /**
         * The status of the failed shard.
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotShardFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotShardFailure build() {
            _checkSingleUse();

            return new SnapshotShardFailure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotShardFailure}
     */
    public static final JsonpDeserializer<SnapshotShardFailure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotShardFailure::setupSnapshotShardFailureDeserializer
    );

    protected static void setupSnapshotShardFailureDeserializer(ObjectDeserializer<SnapshotShardFailure.Builder> op) {
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::shardId, JsonpDeserializer.stringDeserializer(), "shard_id");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.reason);
        result = 31 * result + Objects.hashCode(this.shardId);
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotShardFailure other = (SnapshotShardFailure) o;
        return Objects.equals(this.index, other.index)
            && Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.reason, other.reason)
            && Objects.equals(this.shardId, other.shardId)
            && Objects.equals(this.status, other.status);
    }
}
