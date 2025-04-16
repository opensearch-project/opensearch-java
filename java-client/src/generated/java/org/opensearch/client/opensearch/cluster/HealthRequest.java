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
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.WaitForActiveShards;
import org.opensearch.client.opensearch._types.WaitForEvents;
import org.opensearch.client.opensearch.cluster.health.ClusterHealthLevel;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.health.Request

/**
 * Returns basic information about the health of the cluster.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class HealthRequest extends RequestBase implements ToCopyableBuilder<HealthRequest.Builder, HealthRequest> {

    @Nullable
    private final String awarenessAttribute;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final ClusterHealthLevel level;

    @Nullable
    private final Boolean local;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final Time timeout;

    @Nullable
    private final WaitForActiveShards waitForActiveShards;

    @Nullable
    private final WaitForEvents waitForEvents;

    @Nullable
    private final Boolean waitForNoInitializingShards;

    @Nullable
    private final Boolean waitForNoRelocatingShards;

    @Nullable
    private final String waitForNodes;

    @Nullable
    private final HealthStatus waitForStatus;

    // ---------------------------------------------------------------------------------------------

    private HealthRequest(Builder builder) {
        super(builder);
        this.awarenessAttribute = builder.awarenessAttribute;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.level = builder.level;
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
        this.timeout = builder.timeout;
        this.waitForActiveShards = builder.waitForActiveShards;
        this.waitForEvents = builder.waitForEvents;
        this.waitForNoInitializingShards = builder.waitForNoInitializingShards;
        this.waitForNoRelocatingShards = builder.waitForNoRelocatingShards;
        this.waitForNodes = builder.waitForNodes;
        this.waitForStatus = builder.waitForStatus;
    }

    public static HealthRequest of(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The name of the awareness attribute for which to return the cluster health status (for example, <code>zone</code>). Applicable only
     * if <code>level</code> is set to <code>awareness_attributes</code>.
     * <p>
     * API name: {@code awareness_attribute}
     * </p>
     */
    @Nullable
    public final String awarenessAttribute() {
        return this.awarenessAttribute;
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
     * Specifies the type of index that wildcard expressions can match. Supports comma-separated values.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
     * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Controls the amount of detail included in the cluster health response.
     * <p>
     * API name: {@code level}
     * </p>
     */
    @Nullable
    public final ClusterHealthLevel level() {
        return this.level;
    }

    /**
     * Whether to return information from the local node only instead of from the cluster manager node.
     * <p>
     * API name: {@code local}
     * </p>
     */
    @Nullable
    public final Boolean local() {
        return this.local;
    }

    /**
     * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
     * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts <code>0</code> without a unit and
     * <code>-1</code> to indicate an unspecified value.
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
     * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
     * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * Waits until the specified number of shards is active before returning a response. Use <code>all</code> for all shards.
     * <p>
     * API name: {@code wait_for_active_shards}
     * </p>
     */
    @Nullable
    public final WaitForActiveShards waitForActiveShards() {
        return this.waitForActiveShards;
    }

    /**
     * Waits until all currently queued events with the given priority are processed.
     * <p>
     * API name: {@code wait_for_events}
     * </p>
     */
    @Nullable
    public final WaitForEvents waitForEvents() {
        return this.waitForEvents;
    }

    /**
     * Whether to wait until there are no initializing shards in the cluster.
     * <p>
     * API name: {@code wait_for_no_initializing_shards}
     * </p>
     */
    @Nullable
    public final Boolean waitForNoInitializingShards() {
        return this.waitForNoInitializingShards;
    }

    /**
     * Whether to wait until there are no relocating shards in the cluster.
     * <p>
     * API name: {@code wait_for_no_relocating_shards}
     * </p>
     */
    @Nullable
    public final Boolean waitForNoRelocatingShards() {
        return this.waitForNoRelocatingShards;
    }

    /**
     * Waits until the specified number of nodes (<code>N</code>) is available. Accepts <code>&gt;=N</code>, <code>&lt;=N</code>,
     * <code>&gt;N</code>, and <code>&lt;N</code>. You can also use <code>ge(N)</code>, <code>le(N)</code>, <code>gt(N)</code>, and
     * <code>lt(N)</code> notation.
     * <p>
     * API name: {@code wait_for_nodes}
     * </p>
     */
    @Nullable
    public final String waitForNodes() {
        return this.waitForNodes;
    }

    /**
     * Waits until the cluster health reaches the specified status or better.
     * <p>
     * API name: {@code wait_for_status}
     * </p>
     */
    @Nullable
    public final HealthStatus waitForStatus() {
        return this.waitForStatus;
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
     * Builder for {@link HealthRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, HealthRequest> {
        @Nullable
        private String awarenessAttribute;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private List<String> index;
        @Nullable
        private ClusterHealthLevel level;
        @Nullable
        private Boolean local;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Time timeout;
        @Nullable
        private WaitForActiveShards waitForActiveShards;
        @Nullable
        private WaitForEvents waitForEvents;
        @Nullable
        private Boolean waitForNoInitializingShards;
        @Nullable
        private Boolean waitForNoRelocatingShards;
        @Nullable
        private String waitForNodes;
        @Nullable
        private HealthStatus waitForStatus;

        public Builder() {}

        private Builder(HealthRequest o) {
            super(o);
            this.awarenessAttribute = o.awarenessAttribute;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.index = _listCopy(o.index);
            this.level = o.level;
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForEvents = o.waitForEvents;
            this.waitForNoInitializingShards = o.waitForNoInitializingShards;
            this.waitForNoRelocatingShards = o.waitForNoRelocatingShards;
            this.waitForNodes = o.waitForNodes;
            this.waitForStatus = o.waitForStatus;
        }

        private Builder(Builder o) {
            super(o);
            this.awarenessAttribute = o.awarenessAttribute;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.index = _listCopy(o.index);
            this.level = o.level;
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForEvents = o.waitForEvents;
            this.waitForNoInitializingShards = o.waitForNoInitializingShards;
            this.waitForNoRelocatingShards = o.waitForNoRelocatingShards;
            this.waitForNodes = o.waitForNodes;
            this.waitForStatus = o.waitForStatus;
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
         * The name of the awareness attribute for which to return the cluster health status (for example, <code>zone</code>). Applicable
         * only if <code>level</code> is set to <code>awareness_attributes</code>.
         * <p>
         * API name: {@code awareness_attribute}
         * </p>
         */
        @Nonnull
        public final Builder awarenessAttribute(@Nullable String value) {
            this.awarenessAttribute = value;
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
         * Specifies the type of index that wildcard expressions can match. Supports comma-separated values.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * Specifies the type of index that wildcard expressions can match. Supports comma-separated values.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(List<String> list) {
            this.index = _listAddAll(this.index, list);
            return this;
        }

        /**
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(String value, String... values) {
            this.index = _listAdd(this.index, value, values);
            return this;
        }

        /**
         * Controls the amount of detail included in the cluster health response.
         * <p>
         * API name: {@code level}
         * </p>
         */
        @Nonnull
        public final Builder level(@Nullable ClusterHealthLevel value) {
            this.level = value;
            return this;
        }

        /**
         * Whether to return information from the local node only instead of from the cluster manager node.
         * <p>
         * API name: {@code local}
         * </p>
         */
        @Nonnull
        public final Builder local(@Nullable Boolean value) {
            this.local = value;
            return this;
        }

        /**
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts <code>0</code> without a unit and
         * <code>-1</code> to indicate an unspecified value.
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
         * A duration. Units can be <code>nanos</code>, <code>micros</code>, <code>ms</code> (milliseconds), <code>s</code> (seconds),
         * <code>m</code> (minutes), <code>h</code> (hours) and <code>d</code> (days). Also accepts <code>0</code> without a unit and
         * <code>-1</code> to indicate an unspecified value.
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
         * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
         * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
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
         * The amount of time to wait for a response from the cluster manager node. For more information about supported time units, see
         * <a href="https://opensearch.org/docs/latest/api-reference/common-parameters/#time-units">Common parameters</a>.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Waits until the specified number of shards is active before returning a response. Use <code>all</code> for all shards.
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(@Nullable WaitForActiveShards value) {
            this.waitForActiveShards = value;
            return this;
        }

        /**
         * Waits until the specified number of shards is active before returning a response. Use <code>all</code> for all shards.
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
            return waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
        }

        /**
         * Waits until all currently queued events with the given priority are processed.
         * <p>
         * API name: {@code wait_for_events}
         * </p>
         */
        @Nonnull
        public final Builder waitForEvents(@Nullable WaitForEvents value) {
            this.waitForEvents = value;
            return this;
        }

        /**
         * Whether to wait until there are no initializing shards in the cluster.
         * <p>
         * API name: {@code wait_for_no_initializing_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForNoInitializingShards(@Nullable Boolean value) {
            this.waitForNoInitializingShards = value;
            return this;
        }

        /**
         * Whether to wait until there are no relocating shards in the cluster.
         * <p>
         * API name: {@code wait_for_no_relocating_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForNoRelocatingShards(@Nullable Boolean value) {
            this.waitForNoRelocatingShards = value;
            return this;
        }

        /**
         * Waits until the specified number of nodes (<code>N</code>) is available. Accepts <code>&gt;=N</code>, <code>&lt;=N</code>,
         * <code>&gt;N</code>, and <code>&lt;N</code>. You can also use <code>ge(N)</code>, <code>le(N)</code>, <code>gt(N)</code>, and
         * <code>lt(N)</code> notation.
         * <p>
         * API name: {@code wait_for_nodes}
         * </p>
         */
        @Nonnull
        public final Builder waitForNodes(@Nullable String value) {
            this.waitForNodes = value;
            return this;
        }

        /**
         * Waits until the cluster health reaches the specified status or better.
         * <p>
         * API name: {@code wait_for_status}
         * </p>
         */
        @Nonnull
        public final Builder waitForStatus(@Nullable HealthStatus value) {
            this.waitForStatus = value;
            return this;
        }

        /**
         * Builds a {@link HealthRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HealthRequest build() {
            _checkSingleUse();

            return new HealthRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.awarenessAttribute != null) {
            params.put("awareness_attribute", this.awarenessAttribute);
        }
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.level != null) {
            params.put("level", this.level.jsonValue());
        }
        if (this.local != null) {
            params.put("local", String.valueOf(this.local));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.waitForActiveShards != null) {
            params.put("wait_for_active_shards", this.waitForActiveShards._toJsonString());
        }
        if (this.waitForEvents != null) {
            params.put("wait_for_events", this.waitForEvents.jsonValue());
        }
        if (this.waitForNoInitializingShards != null) {
            params.put("wait_for_no_initializing_shards", String.valueOf(this.waitForNoInitializingShards));
        }
        if (this.waitForNoRelocatingShards != null) {
            params.put("wait_for_no_relocating_shards", String.valueOf(this.waitForNoRelocatingShards));
        }
        if (this.waitForNodes != null) {
            params.put("wait_for_nodes", this.waitForNodes);
        }
        if (this.waitForStatus != null) {
            params.put("wait_for_status", this.waitForStatus.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cluster.health}".
     */
    public static final Endpoint<HealthRequest, HealthResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_cluster/health";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cluster/health/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
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
        HealthResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.awarenessAttribute);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.level);
        result = 31 * result + Objects.hashCode(this.local);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.waitForActiveShards);
        result = 31 * result + Objects.hashCode(this.waitForEvents);
        result = 31 * result + Objects.hashCode(this.waitForNoInitializingShards);
        result = 31 * result + Objects.hashCode(this.waitForNoRelocatingShards);
        result = 31 * result + Objects.hashCode(this.waitForNodes);
        result = 31 * result + Objects.hashCode(this.waitForStatus);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HealthRequest other = (HealthRequest) o;
        return Objects.equals(this.awarenessAttribute, other.awarenessAttribute)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.level, other.level)
            && Objects.equals(this.local, other.local)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.waitForActiveShards, other.waitForActiveShards)
            && Objects.equals(this.waitForEvents, other.waitForEvents)
            && Objects.equals(this.waitForNoInitializingShards, other.waitForNoInitializingShards)
            && Objects.equals(this.waitForNoRelocatingShards, other.waitForNoRelocatingShards)
            && Objects.equals(this.waitForNodes, other.waitForNodes)
            && Objects.equals(this.waitForStatus, other.waitForStatus);
    }
}
