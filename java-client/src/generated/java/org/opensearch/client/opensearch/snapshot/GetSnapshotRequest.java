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
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: snapshot.get.Request

/**
 * Returns information about a snapshot.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetSnapshotRequest extends RequestBase {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final String repository;

    @Nonnull
    private final List<String> snapshot;

    @Nullable
    private final Boolean verbose;

    // ---------------------------------------------------------------------------------------------

    private GetSnapshotRequest(Builder builder) {
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.masterTimeout = builder.masterTimeout;
        this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
        this.snapshot = ApiTypeHelper.unmodifiableRequired(builder.snapshot, this, "snapshot");
        this.verbose = builder.verbose;
    }

    public static GetSnapshotRequest of(Function<GetSnapshotRequest.Builder, ObjectBuilder<GetSnapshotRequest>> fn) {
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
     * If false, the request returns an error for any snapshots that are unavailable.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * Period to wait for a connection to the master node. If no response is received before the timeout expires, the request fails and
     * returns an error.
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
     * Required - Comma-separated list of snapshot repository names used to limit the request. Wildcard (*) expressions are supported.
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nonnull
    public final String repository() {
        return this.repository;
    }

    /**
     * Required -
     * <p>
     * Comma-separated list of snapshot names to retrieve. Also accepts wildcards (*).
     * </p>
     * <ul>
     * <li>To get information about all snapshots in a registered repository, use a wildcard (*) or _all.</li>
     * <li>To get information about any snapshots that are currently running, use _current.</li>
     * </ul>
     * <p>
     * API name: {@code snapshot}
     * </p>
     */
    @Nonnull
    public final List<String> snapshot() {
        return this.snapshot;
    }

    /**
     * If true, returns additional information about each snapshot such as the version of OpenSearch which took the snapshot, the start and
     * end times of the snapshot, and the number of shards snapshotted.
     * <p>
     * API name: {@code verbose}
     * </p>
     */
    @Nullable
    public final Boolean verbose() {
        return this.verbose;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link GetSnapshotRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetSnapshotRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Time masterTimeout;
        private String repository;
        private List<String> snapshot;
        @Nullable
        private Boolean verbose;

        /**
         * Operation timeout for connection to cluster-manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
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
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * If false, the request returns an error for any snapshots that are unavailable.
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        /**
         * Period to wait for a connection to the master node. If no response is received before the timeout expires, the request fails and
         * returns an error.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        public final Builder masterTimeout(@Nullable Time value) {
            this.masterTimeout = value;
            return this;
        }

        /**
         * Period to wait for a connection to the master node. If no response is received before the timeout expires, the request fails and
         * returns an error.
         * <p>
         * API name: {@code master_timeout}
         * </p>
         */
        @Deprecated
        public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return masterTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - Comma-separated list of snapshot repository names used to limit the request. Wildcard (*) expressions are supported.
         * <p>
         * API name: {@code repository}
         * </p>
         */
        public final Builder repository(String value) {
            this.repository = value;
            return this;
        }

        /**
         * Required -
         * <p>
         * Comma-separated list of snapshot names to retrieve. Also accepts wildcards (*).
         * </p>
         * <ul>
         * <li>To get information about all snapshots in a registered repository, use a wildcard (*) or _all.</li>
         * <li>To get information about any snapshots that are currently running, use _current.</li>
         * </ul>
         * <p>
         * API name: {@code snapshot}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>snapshot</code>.
         * </p>
         */
        public final Builder snapshot(List<String> list) {
            this.snapshot = _listAddAll(this.snapshot, list);
            return this;
        }

        /**
         * Required -
         * <p>
         * Comma-separated list of snapshot names to retrieve. Also accepts wildcards (*).
         * </p>
         * <ul>
         * <li>To get information about all snapshots in a registered repository, use a wildcard (*) or _all.</li>
         * <li>To get information about any snapshots that are currently running, use _current.</li>
         * </ul>
         * <p>
         * API name: {@code snapshot}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>snapshot</code>.
         * </p>
         */
        public final Builder snapshot(String value, String... values) {
            this.snapshot = _listAdd(this.snapshot, value, values);
            return this;
        }

        /**
         * If true, returns additional information about each snapshot such as the version of OpenSearch which took the snapshot, the start
         * and end times of the snapshot, and the number of shards snapshotted.
         * <p>
         * API name: {@code verbose}
         * </p>
         */
        public final Builder verbose(@Nullable Boolean value) {
            this.verbose = value;
            return this;
        }

        /**
         * Builds a {@link GetSnapshotRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetSnapshotRequest build() {
            _checkSingleUse();

            return new GetSnapshotRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code snapshot.get}".
     */
    public static final Endpoint<GetSnapshotRequest, GetSnapshotResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_snapshot/");
            SimpleEndpoint.pathEncode(request.repository, buf);
            buf.append("/");
            SimpleEndpoint.pathEncode(String.join(",", request.snapshot), buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (request.ignoreUnavailable != null) {
                params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            if (request.verbose != null) {
                params.put("verbose", String.valueOf(request.verbose));
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetSnapshotResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + this.repository.hashCode();
        result = 31 * result + this.snapshot.hashCode();
        result = 31 * result + Objects.hashCode(this.verbose);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetSnapshotRequest other = (GetSnapshotRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && this.repository.equals(other.repository)
            && this.snapshot.equals(other.snapshot)
            && Objects.equals(this.verbose, other.verbose);
    }
}
