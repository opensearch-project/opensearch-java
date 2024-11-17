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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: snapshot.SnapshotShardFailure

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotShardFailure implements PlainJsonSerializable {

    @Nonnull
    private final String index;

    @Nullable
    private final String nodeId;

    @Nonnull
    private final String reason;

    @Nonnull
    private final String shardId;

    @Nonnull
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private SnapshotShardFailure(Builder builder) {
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.nodeId = builder.nodeId;
        this.reason = ApiTypeHelper.requireNonNull(builder.reason, this, "reason");
        this.shardId = ApiTypeHelper.requireNonNull(builder.shardId, this, "shardId");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
    }

    public static SnapshotShardFailure of(Function<SnapshotShardFailure.Builder, ObjectBuilder<SnapshotShardFailure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * API name: {@code node_id}
     */
    @Nullable
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * Required - API name: {@code reason}
     */
    @Nonnull
    public final String reason() {
        return this.reason;
    }

    /**
     * Required - API name: {@code shard_id}
     */
    @Nonnull
    public final String shardId() {
        return this.shardId;
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
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
        generator.writeKey("index");
        generator.write(this.index);

        if (this.nodeId != null) {
            generator.writeKey("node_id");
            generator.write(this.nodeId);
        }

        generator.writeKey("reason");
        generator.write(this.reason);

        generator.writeKey("shard_id");
        generator.write(this.shardId);

        generator.writeKey("status");
        generator.write(this.status);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link SnapshotShardFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<SnapshotShardFailure> {
        private String index;
        @Nullable
        private String nodeId;
        private String reason;
        private String shardId;
        private String status;

        /**
         * Required - API name: {@code index}
         */
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code node_id}
         */
        public final Builder nodeId(@Nullable String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        public final Builder reason(String value) {
            this.reason = value;
            return this;
        }

        /**
         * Required - API name: {@code shard_id}
         */
        public final Builder shardId(String value) {
            this.shardId = value;
            return this;
        }

        /**
         * Required - API name: {@code status}
         */
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotShardFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
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
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + this.reason.hashCode();
        result = 31 * result + this.shardId.hashCode();
        result = 31 * result + this.status.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotShardFailure other = (SnapshotShardFailure) o;
        return this.index.equals(other.index)
            && Objects.equals(this.nodeId, other.nodeId)
            && this.reason.equals(other.reason)
            && this.shardId.equals(other.shardId)
            && this.status.equals(other.status);
    }
}
