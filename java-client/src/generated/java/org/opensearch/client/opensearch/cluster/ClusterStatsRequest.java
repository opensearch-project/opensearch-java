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

package org.opensearch.client.opensearch.cluster;

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
import org.opensearch.client.opensearch.cluster.stats.IndexMetric;
import org.opensearch.client.opensearch.cluster.stats.Metric;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.stats.Request

/**
 * Returns high-level overview of cluster statistics.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClusterStatsRequest extends RequestBase implements ToCopyableBuilder<ClusterStatsRequest.Builder, ClusterStatsRequest> {

    @Nullable
    private final Boolean flatSettings;

    @Nonnull
    private final List<IndexMetric> indexMetric;

    @Nonnull
    private final List<Metric> metric;

    @Nonnull
    private final List<String> nodeId;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private ClusterStatsRequest(Builder builder) {
        this.flatSettings = builder.flatSettings;
        this.indexMetric = ApiTypeHelper.unmodifiable(builder.indexMetric);
        this.metric = ApiTypeHelper.unmodifiable(builder.metric);
        this.nodeId = ApiTypeHelper.unmodifiable(builder.nodeId);
        this.timeout = builder.timeout;
    }

    public static ClusterStatsRequest of(Function<ClusterStatsRequest.Builder, ObjectBuilder<ClusterStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>true</code>, returns settings in flat format.
     * <p>
     * API name: {@code flat_settings}
     * </p>
     */
    @Nullable
    public final Boolean flatSettings() {
        return this.flatSettings;
    }

    /**
     * Limit the information returned for indexes metric to the specific index metrics. It can be used only if indexes (or all) metric is
     * specified.
     * <p>
     * API name: {@code index_metric}
     * </p>
     */
    @Nonnull
    public final List<IndexMetric> indexMetric() {
        return this.indexMetric;
    }

    /**
     * Limit the information returned to the specified metrics.
     * <p>
     * API name: {@code metric}
     * </p>
     */
    @Nonnull
    public final List<Metric> metric() {
        return this.metric;
    }

    /**
     * Comma-separated list of node filters used to limit returned information. Defaults to all nodes in the cluster.
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nonnull
    public final List<String> nodeId() {
        return this.nodeId;
    }

    /**
     * Period to wait for each node to respond. If a node does not respond before its timeout expires, the response does not include its
     * stats. However, timed out nodes are included in the response's <code>_nodes.failed</code> property. Defaults to no timeout.
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
     * Builder for {@link ClusterStatsRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ClusterStatsRequest> {
        @Nullable
        private Boolean flatSettings;
        @Nullable
        private List<IndexMetric> indexMetric;
        @Nullable
        private List<Metric> metric;
        @Nullable
        private List<String> nodeId;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(ClusterStatsRequest o) {
            this.flatSettings = o.flatSettings;
            this.indexMetric = _listCopy(o.indexMetric);
            this.metric = _listCopy(o.metric);
            this.nodeId = _listCopy(o.nodeId);
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            this.flatSettings = o.flatSettings;
            this.indexMetric = _listCopy(o.indexMetric);
            this.metric = _listCopy(o.metric);
            this.nodeId = _listCopy(o.nodeId);
            this.timeout = o.timeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * If <code>true</code>, returns settings in flat format.
         * <p>
         * API name: {@code flat_settings}
         * </p>
         */
        @Nonnull
        public final Builder flatSettings(@Nullable Boolean value) {
            this.flatSettings = value;
            return this;
        }

        /**
         * Limit the information returned for indexes metric to the specific index metrics. It can be used only if indexes (or all) metric
         * is specified.
         * <p>
         * API name: {@code index_metric}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexMetric</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexMetric(List<IndexMetric> list) {
            this.indexMetric = _listAddAll(this.indexMetric, list);
            return this;
        }

        /**
         * Limit the information returned for indexes metric to the specific index metrics. It can be used only if indexes (or all) metric
         * is specified.
         * <p>
         * API name: {@code index_metric}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indexMetric</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexMetric(IndexMetric value, IndexMetric... values) {
            this.indexMetric = _listAdd(this.indexMetric, value, values);
            return this;
        }

        /**
         * Limit the information returned to the specified metrics.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(List<Metric> list) {
            this.metric = _listAddAll(this.metric, list);
            return this;
        }

        /**
         * Limit the information returned to the specified metrics.
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(Metric value, Metric... values) {
            this.metric = _listAdd(this.metric, value, values);
            return this;
        }

        /**
         * Comma-separated list of node filters used to limit returned information. Defaults to all nodes in the cluster.
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
         * Comma-separated list of node filters used to limit returned information. Defaults to all nodes in the cluster.
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
         * Period to wait for each node to respond. If a node does not respond before its timeout expires, the response does not include its
         * stats. However, timed out nodes are included in the response's <code>_nodes.failed</code> property. Defaults to no timeout.
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
         * Period to wait for each node to respond. If a node does not respond before its timeout expires, the response does not include its
         * stats. However, timed out nodes are included in the response's <code>_nodes.failed</code> property. Defaults to no timeout.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link ClusterStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClusterStatsRequest build() {
            _checkSingleUse();

            return new ClusterStatsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cluster.stats}".
     */
    public static final Endpoint<ClusterStatsRequest, ClusterStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _indexMetric = 1 << 0;
            final int _metric = 1 << 1;
            final int _nodeId = 1 << 2;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.indexMetric())) propsSet |= _indexMetric;
            if (ApiTypeHelper.isDefined(request.metric())) propsSet |= _metric;
            if (ApiTypeHelper.isDefined(request.nodeId())) propsSet |= _nodeId;

            if (propsSet == 0) {
                return "/_cluster/stats";
            }
            if (propsSet == (_metric | _indexMetric | _nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cluster/stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                buf.append("/");
                SimpleEndpoint.pathEncode(request.indexMetric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                buf.append("/nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                return buf.toString();
            }
            if (propsSet == (_metric | _nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cluster/stats/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                buf.append("/nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                return buf.toString();
            }
            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cluster/stats/nodes/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.flatSettings != null) {
                params.put("flat_settings", String.valueOf(request.flatSettings));
            }
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        ClusterStatsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.flatSettings);
        result = 31 * result + Objects.hashCode(this.indexMetric);
        result = 31 * result + Objects.hashCode(this.metric);
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClusterStatsRequest other = (ClusterStatsRequest) o;
        return Objects.equals(this.flatSettings, other.flatSettings)
            && Objects.equals(this.indexMetric, other.indexMetric)
            && Objects.equals(this.metric, other.metric)
            && Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.timeout, other.timeout);
    }
}
