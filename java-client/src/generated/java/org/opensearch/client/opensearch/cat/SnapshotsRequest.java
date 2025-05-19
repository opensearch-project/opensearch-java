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

package org.opensearch.client.opensearch.cat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.snapshots.Request

/**
 * Lists all of the snapshots stored in a specific repository.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SnapshotsRequest extends CatRequestBase implements ToCopyableBuilder<SnapshotsRequest.Builder, SnapshotsRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final List<String> repository;

    @Nullable
    private final TimeUnit time;

    // ---------------------------------------------------------------------------------------------

    private SnapshotsRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.masterTimeout = builder.masterTimeout;
        this.repository = ApiTypeHelper.unmodifiable(builder.repository);
        this.time = builder.time;
    }

    public static SnapshotsRequest of(Function<SnapshotsRequest.Builder, ObjectBuilder<SnapshotsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The amount of time allowed to establish a connection to the cluster manager node.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
    }

    /**
     * When <code>true</code>, the response does not include information from unavailable snapshots.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * The amount of time allowed to establish a connection to the cluster manager node.
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
     * A comma-separated list of snapshot repositories used to limit the request. Accepts wildcard expressions. <code>_all</code> returns
     * all repositories. If any repository fails during the request, OpenSearch returns an error.
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nonnull
    public final List<String> repository() {
        return this.repository;
    }

    /**
     * Specifies the time units, for example, <code>5d</code> or <code>7h</code>. For more information, see
     * <a href="https://opensearch.org/docs/latest/api-reference/units/">Supported units</a>.
     * <p>
     * API name: {@code time}
     * </p>
     */
    @Nullable
    public final TimeUnit time() {
        return this.time;
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
     * Builder for {@link SnapshotsRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SnapshotsRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private List<String> repository;
        @Nullable
        private TimeUnit time;

        public Builder() {}

        private Builder(SnapshotsRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.masterTimeout = o.masterTimeout;
            this.repository = _listCopy(o.repository);
            this.time = o.time;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.masterTimeout = o.masterTimeout;
            this.repository = _listCopy(o.repository);
            this.time = o.time;
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
         * The amount of time allowed to establish a connection to the cluster manager node.
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
         * The amount of time allowed to establish a connection to the cluster manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * When <code>true</code>, the response does not include information from unavailable snapshots.
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
         * The amount of time allowed to establish a connection to the cluster manager node.
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
         * The amount of time allowed to establish a connection to the cluster manager node.
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
         * A comma-separated list of snapshot repositories used to limit the request. Accepts wildcard expressions. <code>_all</code>
         * returns all repositories. If any repository fails during the request, OpenSearch returns an error.
         * <p>
         * API name: {@code repository}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>repository</code>.
         * </p>
         */
        @Nonnull
        public final Builder repository(List<String> list) {
            this.repository = _listAddAll(this.repository, list);
            return this;
        }

        /**
         * A comma-separated list of snapshot repositories used to limit the request. Accepts wildcard expressions. <code>_all</code>
         * returns all repositories. If any repository fails during the request, OpenSearch returns an error.
         * <p>
         * API name: {@code repository}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>repository</code>.
         * </p>
         */
        @Nonnull
        public final Builder repository(String value, String... values) {
            this.repository = _listAdd(this.repository, value, values);
            return this;
        }

        /**
         * Specifies the time units, for example, <code>5d</code> or <code>7h</code>. For more information, see
         * <a href="https://opensearch.org/docs/latest/api-reference/units/">Supported units</a>.
         * <p>
         * API name: {@code time}
         * </p>
         */
        @Nonnull
        public final Builder time(@Nullable TimeUnit value) {
            this.time = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotsRequest build() {
            _checkSingleUse();

            return new SnapshotsRequest(this);
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
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.snapshots}".
     */
    public static final Endpoint<SnapshotsRequest, SnapshotsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _repository = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.repository())) propsSet |= _repository;

            if (propsSet == 0) {
                return "/_cat/snapshots";
            }
            if (propsSet == (_repository)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cat/snapshots/");
                SimpleEndpoint.pathEncode(String.join(",", request.repository), buf);
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
        SnapshotsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.repository);
        result = 31 * result + Objects.hashCode(this.time);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotsRequest other = (SnapshotsRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.repository, other.repository)
            && Objects.equals(this.time, other.time);
    }
}
