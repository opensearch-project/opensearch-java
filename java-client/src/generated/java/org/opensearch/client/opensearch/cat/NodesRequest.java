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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.nodes.Request

/**
 * Returns basic statistics about the performance of cluster nodes.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class NodesRequest extends CatRequestBase implements ToCopyableBuilder<NodesRequest.Builder, NodesRequest> {

    @Nullable
    private final Bytes bytes;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nullable
    private final Boolean fullId;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final TimeUnit time;

    // ---------------------------------------------------------------------------------------------

    private NodesRequest(Builder builder) {
        super(builder);
        this.bytes = builder.bytes;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.fullId = builder.fullId;
        this.masterTimeout = builder.masterTimeout;
        this.time = builder.time;
    }

    public static NodesRequest of(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The units used to display byte values.
     * <p>
     * API name: {@code bytes}
     * </p>
     */
    @Nullable
    public final Bytes bytes() {
        return this.bytes;
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
     * When <code>true</code>, returns the full node ID. When <code>false</code>, returns the shortened node ID.
     * <p>
     * API name: {@code full_id}
     * </p>
     */
    @Nullable
    public final Boolean fullId() {
        return this.fullId;
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
     * Builder for {@link NodesRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NodesRequest> {
        @Nullable
        private Bytes bytes;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Boolean fullId;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private TimeUnit time;

        public Builder() {}

        private Builder(NodesRequest o) {
            super(o);
            this.bytes = o.bytes;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.fullId = o.fullId;
            this.masterTimeout = o.masterTimeout;
            this.time = o.time;
        }

        private Builder(Builder o) {
            super(o);
            this.bytes = o.bytes;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.fullId = o.fullId;
            this.masterTimeout = o.masterTimeout;
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
         * The units used to display byte values.
         * <p>
         * API name: {@code bytes}
         * </p>
         */
        @Nonnull
        public final Builder bytes(@Nullable Bytes value) {
            this.bytes = value;
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
         * When <code>true</code>, returns the full node ID. When <code>false</code>, returns the shortened node ID.
         * <p>
         * API name: {@code full_id}
         * </p>
         */
        @Nonnull
        public final Builder fullId(@Nullable Boolean value) {
            this.fullId = value;
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
         * Builds a {@link NodesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodesRequest build() {
            _checkSingleUse();

            return new NodesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.bytes != null) {
            params.put("bytes", this.bytes.jsonValue());
        }
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.fullId != null) {
            params.put("full_id", String.valueOf(this.fullId));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.nodes}".
     */
    public static final Endpoint<NodesRequest, NodesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cat/nodes",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        NodesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.fullId);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.time);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodesRequest other = (NodesRequest) o;
        return Objects.equals(this.bytes, other.bytes)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.fullId, other.fullId)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.time, other.time);
    }
}
