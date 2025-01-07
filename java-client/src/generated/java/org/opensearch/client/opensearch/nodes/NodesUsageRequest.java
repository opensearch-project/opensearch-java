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

package org.opensearch.client.opensearch.nodes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.nodes.usage.NodesUsageMetric;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.usage.Request

/**
 * Returns low-level information about REST actions usage on nodes.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class NodesUsageRequest extends RequestBase implements ToCopyableBuilder<NodesUsageRequest.Builder, NodesUsageRequest> {

    @Nonnull
    private final List<NodesUsageMetric> metric;

    @Nonnull
    private final List<String> nodeId;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private NodesUsageRequest(Builder builder) {
        super(builder);
        this.metric = ApiTypeHelper.unmodifiable(builder.metric);
        this.nodeId = ApiTypeHelper.unmodifiable(builder.nodeId);
        this.timeout = builder.timeout;
    }

    public static NodesUsageRequest of(Function<NodesUsageRequest.Builder, ObjectBuilder<NodesUsageRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Limits the information returned to the specific metrics. A comma-separated list of the following options: <code>_all</code>,
     * <code>rest_actions</code>.
     * <p>
     * API name: {@code metric}
     * </p>
     */
    @Nonnull
    public final List<NodesUsageMetric> metric() {
        return this.metric;
    }

    /**
     * A comma-separated list of node IDs or names to limit the returned information; use <code>_local</code> to return information from the
     * node you're connecting to, leave empty to get information from all nodes
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nonnull
    public final List<String> nodeId() {
        return this.nodeId;
    }

    /**
     * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
     * Builder for {@link NodesUsageRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, NodesUsageRequest> {
        @Nullable
        private List<NodesUsageMetric> metric;
        @Nullable
        private List<String> nodeId;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(NodesUsageRequest o) {
            super(o);
            this.metric = _listCopy(o.metric);
            this.nodeId = _listCopy(o.nodeId);
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.metric = _listCopy(o.metric);
            this.nodeId = _listCopy(o.nodeId);
            this.timeout = o.timeout;
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
         * Limits the information returned to the specific metrics. A comma-separated list of the following options: <code>_all</code>,
         * <code>rest_actions</code>.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(List<NodesUsageMetric> list) {
            this.metric = _listAddAll(this.metric, list);
            return this;
        }

        /**
         * Limits the information returned to the specific metrics. A comma-separated list of the following options: <code>_all</code>,
         * <code>rest_actions</code>.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(NodesUsageMetric value, NodesUsageMetric... values) {
            this.metric = _listAdd(this.metric, value, values);
            return this;
        }

        /**
         * A comma-separated list of node IDs or names to limit the returned information; use <code>_local</code> to return information from
         * the node you're connecting to, leave empty to get information from all nodes
         * <p>
         * API name: {@code node_id}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeId</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeId(List<String> list) {
            this.nodeId = _listAddAll(this.nodeId, list);
            return this;
        }

        /**
         * A comma-separated list of node IDs or names to limit the returned information; use <code>_local</code> to return information from
         * the node you're connecting to, leave empty to get information from all nodes
         * <p>
         * API name: {@code node_id}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodeId</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeId(String value, String... values) {
            this.nodeId = _listAdd(this.nodeId, value, values);
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Period to wait for a response. If no response is received before the timeout expires, the request fails and returns an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link NodesUsageRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodesUsageRequest build() {
            _checkSingleUse();

            return new NodesUsageRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code nodes.usage}".
     */
    public static final Endpoint<NodesUsageRequest, NodesUsageResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _metric = 1 << 0;
            final int _nodeId = 1 << 1;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.metric())) propsSet |= _metric;
            if (ApiTypeHelper.isDefined(request.nodeId())) propsSet |= _nodeId;

            if (propsSet == 0) {
                return "/_nodes/usage";
            }
            if (propsSet == (_metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/usage/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }
            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/usage");
                return buf.toString();
            }
            if (propsSet == (_nodeId | _metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/usage/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
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
        NodesUsageResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.metric);
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodesUsageRequest other = (NodesUsageRequest) o;
        return Objects.equals(this.metric, other.metric)
            && Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.timeout, other.timeout);
    }
}
