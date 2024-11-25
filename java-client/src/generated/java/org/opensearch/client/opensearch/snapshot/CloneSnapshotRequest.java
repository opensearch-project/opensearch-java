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
import java.util.HashMap;
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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.clone.Request

/**
 * Clones indexes from one snapshot into another snapshot in the same repository.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CloneSnapshotRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CloneSnapshotRequest.Builder, CloneSnapshotRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final String indices;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final String repository;

    @Nonnull
    private final String snapshot;

    @Nonnull
    private final String targetSnapshot;

    // ---------------------------------------------------------------------------------------------

    private CloneSnapshotRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.indices = ApiTypeHelper.requireNonNull(builder.indices, this, "indices");
        this.masterTimeout = builder.masterTimeout;
        this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
        this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
        this.targetSnapshot = ApiTypeHelper.requireNonNull(builder.targetSnapshot, this, "targetSnapshot");
    }

    public static CloneSnapshotRequest of(Function<CloneSnapshotRequest.Builder, ObjectBuilder<CloneSnapshotRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Operation timeout for connection to cluster-manager node.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * Required - API name: {@code indices}
     */
    @Nonnull
    public final String indices() {
        return this.indices;
    }

    /**
     * Explicit operation timeout for connection to cluster-manager node
     * <p>
     * API name: {@code master_timeout}
     * </p>
     */
    @Deprecated
    @Nullable
    public final Time masterTimeout() {
        return this.masterTimeout;
    }

    /**
     * Required - A repository name
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nonnull
    public final String repository() {
        return this.repository;
    }

    /**
     * Required - The name of the snapshot to clone from
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nonnull
    public final String snapshot() {
        return this.snapshot;
    }

    /**
     * Required - The name of the cloned snapshot to create
     * <p>
     * API name: {@code target_snapshot}
     * </p>
     */
    @Nonnull
    public final String targetSnapshot() {
        return this.targetSnapshot;
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
        generator.writeKey("indices");
        generator.write(this.indices);
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
     * Builder for {@link CloneSnapshotRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CloneSnapshotRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        private String indices;
        @Nullable
        private Time masterTimeout;
        private String repository;
        private String snapshot;
        private String targetSnapshot;

        public Builder() {}

        private Builder(CloneSnapshotRequest o) {
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.indices = o.indices;
            this.masterTimeout = o.masterTimeout;
            this.repository = o.repository;
            this.snapshot = o.snapshot;
            this.targetSnapshot = o.targetSnapshot;
        }

        private Builder(Builder o) {
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.indices = o.indices;
            this.masterTimeout = o.masterTimeout;
            this.repository = o.repository;
            this.snapshot = o.snapshot;
            this.targetSnapshot = o.targetSnapshot;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(@Nullable Time value) {
            this.clusterManagerTimeout = value;
            return this;
        }

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code indices}
         */
        @Nonnull
        public final Builder indices(String value) {
            this.indices = value;
            return this;
        }

        /**
         * Explicit operation timeout for connection to cluster-manager node
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(@Nullable Time value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Explicit operation timeout for connection to cluster-manager node
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        @Nonnull
        public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return masterTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - A repository name
         * <p>
         * API name: {@code repository}
         * </p>
         */
        @Nonnull
        public final Builder repository(String value) {
            this.repository = value;
            return this;
        }

        /**
         * Required - The name of the snapshot to clone from
         * <p>
         * API name: {@code snapshot}
         * </p>
         */
        @Nonnull
        public final Builder snapshot(String value) {
            this.snapshot = value;
            return this;
        }

        /**
         * Required - The name of the cloned snapshot to create
         * <p>
         * API name: {@code target_snapshot}
         * </p>
         */
        @Nonnull
        public final Builder targetSnapshot(String value) {
            this.targetSnapshot = value;
            return this;
        }

        /**
         * Builds a {@link CloneSnapshotRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CloneSnapshotRequest build() {
            _checkSingleUse();

            return new CloneSnapshotRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CloneSnapshotRequest}
     */
    public static final JsonpDeserializer<CloneSnapshotRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CloneSnapshotRequest::setupCloneSnapshotRequestDeserializer
    );

    protected static void setupCloneSnapshotRequestDeserializer(ObjectDeserializer<CloneSnapshotRequest.Builder> op) {
        op.add(Builder::indices, JsonpDeserializer.stringDeserializer(), "indices");
        op.add(Builder::repository, JsonpDeserializer.stringDeserializer(), "repository");
        op.add(Builder::snapshot, JsonpDeserializer.stringDeserializer(), "snapshot");
        op.add(Builder::targetSnapshot, JsonpDeserializer.stringDeserializer(), "target_snapshot");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code snapshot.clone}".
     */
    public static final Endpoint<CloneSnapshotRequest, CloneSnapshotResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_snapshot/");
            SimpleEndpoint.pathEncode(request.repository, buf);
            buf.append("/");
            SimpleEndpoint.pathEncode(request.snapshot, buf);
            buf.append("/_clone/");
            SimpleEndpoint.pathEncode(request.targetSnapshot, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        CloneSnapshotResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + this.indices.hashCode();
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + this.repository.hashCode();
        result = 31 * result + this.snapshot.hashCode();
        result = 31 * result + this.targetSnapshot.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CloneSnapshotRequest other = (CloneSnapshotRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && this.indices.equals(other.indices)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && this.repository.equals(other.repository)
            && this.snapshot.equals(other.snapshot)
            && this.targetSnapshot.equals(other.targetSnapshot);
    }
}
