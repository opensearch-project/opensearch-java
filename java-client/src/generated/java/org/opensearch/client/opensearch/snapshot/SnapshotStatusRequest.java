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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.status.Request

/**
 * Returns information about the status of a snapshot.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SnapshotStatusRequest extends RequestBase
    implements
        ToCopyableBuilder<SnapshotStatusRequest.Builder, SnapshotStatusRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final String repository;

    @Nonnull
    private final List<String> snapshot;

    // ---------------------------------------------------------------------------------------------

    private SnapshotStatusRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.masterTimeout = builder.masterTimeout;
        this.repository = builder.repository;
        this.snapshot = ApiTypeHelper.unmodifiable(builder.snapshot);
    }

    public static SnapshotStatusRequest of(Function<SnapshotStatusRequest.Builder, ObjectBuilder<SnapshotStatusRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
     * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * Whether to ignore any unavailable snapshots, When <code>false</code>, a <code>SnapshotMissingException</code> is thrown.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
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
     * A comma-separated list of snapshot names.
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nonnull
    public final List<String> snapshot() {
        return this.snapshot;
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
     * Builder for {@link SnapshotStatusRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SnapshotStatusRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private String repository;
        @Nullable
        private List<String> snapshot;

        public Builder() {}

        private Builder(SnapshotStatusRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.masterTimeout = o.masterTimeout;
            this.repository = o.repository;
            this.snapshot = _listCopy(o.snapshot);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.masterTimeout = o.masterTimeout;
            this.repository = o.repository;
            this.snapshot = _listCopy(o.snapshot);
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
         * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
         * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
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
         * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
         * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Whether to ignore any unavailable snapshots, When <code>false</code>, a <code>SnapshotMissingException</code> is thrown.
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
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
         * A comma-separated list of snapshot names.
         * <p>
         * API name: {@code snapshot}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>snapshot</code>.
         * </p>
         */
        @Nonnull
        public final Builder snapshot(List<String> list) {
            this.snapshot = _listAddAll(this.snapshot, list);
            return this;
        }

        /**
         * A comma-separated list of snapshot names.
         * <p>
         * API name: {@code snapshot}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>snapshot</code>.
         * </p>
         */
        @Nonnull
        public final Builder snapshot(String value, String... values) {
            this.snapshot = _listAdd(this.snapshot, value, values);
            return this;
        }

        /**
         * Builds a {@link SnapshotStatusRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotStatusRequest build() {
            _checkSingleUse();

            return new SnapshotStatusRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code snapshot.status}".
     */
    public static final Endpoint<SnapshotStatusRequest, SnapshotStatusResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _repository = 1 << 0;
            final int _snapshot = 1 << 1;

            int propsSet = 0;

            if (request.repository() != null) propsSet |= _repository;
            if (ApiTypeHelper.isDefined(request.snapshot())) propsSet |= _snapshot;

            if (propsSet == 0) {
                return "/_snapshot/_status";
            }
            if (propsSet == (_repository)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_snapshot/");
                SimpleEndpoint.pathEncode(request.repository, buf);
                buf.append("/_status");
                return buf.toString();
            }
            if (propsSet == (_repository | _snapshot)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_snapshot/");
                SimpleEndpoint.pathEncode(request.repository, buf);
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.snapshot), buf);
                buf.append("/_status");
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        SnapshotStatusResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.repository);
        result = 31 * result + Objects.hashCode(this.snapshot);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotStatusRequest other = (SnapshotStatusRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.repository, other.repository)
            && Objects.equals(this.snapshot, other.snapshot);
    }
}
