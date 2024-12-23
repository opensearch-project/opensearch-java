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
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.cluster.state.ClusterStateMetric;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.state.Request

/**
 * Returns a comprehensive information about the state of the cluster.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class StateRequest extends RequestBase implements ToCopyableBuilder<StateRequest.Builder, StateRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean flatSettings;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Boolean local;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nonnull
    private final List<ClusterStateMetric> metric;

    @Nullable
    private final Long waitForMetadataVersion;

    @Nullable
    private final Time waitForTimeout;

    // ---------------------------------------------------------------------------------------------

    private StateRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.flatSettings = builder.flatSettings;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.local = builder.local;
        this.masterTimeout = builder.masterTimeout;
        this.metric = ApiTypeHelper.unmodifiable(builder.metric);
        this.waitForMetadataVersion = builder.waitForMetadataVersion;
        this.waitForTimeout = builder.waitForTimeout;
    }

    public static StateRequest of(Function<StateRequest.Builder, ObjectBuilder<StateRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or when
     * no indexes have been specified)
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
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
     * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * Return settings in flat format.
     * <p>
     * API name: {@code flat_settings}
     * </p>
     */
    @Nullable
    public final Boolean flatSettings() {
        return this.flatSettings;
    }

    /**
     * Whether specified concrete indexes should be ignored when unavailable (missing or closed)
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Return local information, do not retrieve the state from cluster-manager node.
     * <p>
     * API name: {@code local}
     * </p>
     */
    @Nullable
    public final Boolean local() {
        return this.local;
    }

    /**
     * Specify timeout for connection to cluster manager.
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
     * Limit the information returned to the specified metrics
     * <p>
     * API name: {@code metric}
     * </p>
     */
    @Nonnull
    public final List<ClusterStateMetric> metric() {
        return this.metric;
    }

    /**
     * Wait for the metadata version to be equal or greater than the specified metadata version.
     * <p>
     * API name: {@code wait_for_metadata_version}
     * </p>
     */
    @Nullable
    public final Long waitForMetadataVersion() {
        return this.waitForMetadataVersion;
    }

    /**
     * The maximum time to wait for <code>wait_for_metadata_version</code> before timing out.
     * <p>
     * API name: {@code wait_for_timeout}
     * </p>
     */
    @Nullable
    public final Time waitForTimeout() {
        return this.waitForTimeout;
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
     * Builder for {@link StateRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, StateRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean flatSettings;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private Boolean local;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private List<ClusterStateMetric> metric;
        @Nullable
        private Long waitForMetadataVersion;
        @Nullable
        private Time waitForTimeout;

        public Builder() {}

        private Builder(StateRequest o) {
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.flatSettings = o.flatSettings;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.metric = _listCopy(o.metric);
            this.waitForMetadataVersion = o.waitForMetadataVersion;
            this.waitForTimeout = o.waitForTimeout;
        }

        private Builder(Builder o) {
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.flatSettings = o.flatSettings;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.local = o.local;
            this.masterTimeout = o.masterTimeout;
            this.metric = _listCopy(o.metric);
            this.waitForMetadataVersion = o.waitForMetadataVersion;
            this.waitForTimeout = o.waitForTimeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or
         * when no indexes have been specified)
         * <p>
         * API name: {@code allow_no_indices}
         * </p>
         */
        @Nonnull
        public final Builder allowNoIndices(@Nullable Boolean value) {
            this.allowNoIndices = value;
            return this;
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
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
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
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
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
         * Return settings in flat format.
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
         * Whether specified concrete indexes should be ignored when unavailable (missing or closed)
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
         * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
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
         * A comma-separated list of index names; use <code>_all</code> or empty string to perform the operation on all indexes
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
         * Return local information, do not retrieve the state from cluster-manager node.
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
         * Specify timeout for connection to cluster manager.
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
         * Specify timeout for connection to cluster manager.
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
         * Limit the information returned to the specified metrics
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(List<ClusterStateMetric> list) {
            this.metric = _listAddAll(this.metric, list);
            return this;
        }

        /**
         * Limit the information returned to the specified metrics
         * <p>
         * API name: {@code metric}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>metric</code>.
         * </p>
         */
        @Nonnull
        public final Builder metric(ClusterStateMetric value, ClusterStateMetric... values) {
            this.metric = _listAdd(this.metric, value, values);
            return this;
        }

        /**
         * Wait for the metadata version to be equal or greater than the specified metadata version.
         * <p>
         * API name: {@code wait_for_metadata_version}
         * </p>
         */
        @Nonnull
        public final Builder waitForMetadataVersion(@Nullable Long value) {
            this.waitForMetadataVersion = value;
            return this;
        }

        /**
         * The maximum time to wait for <code>wait_for_metadata_version</code> before timing out.
         * <p>
         * API name: {@code wait_for_timeout}
         * </p>
         */
        @Nonnull
        public final Builder waitForTimeout(@Nullable Time value) {
            this.waitForTimeout = value;
            return this;
        }

        /**
         * The maximum time to wait for <code>wait_for_metadata_version</code> before timing out.
         * <p>
         * API name: {@code wait_for_timeout}
         * </p>
         */
        @Nonnull
        public final Builder waitForTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return waitForTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link StateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public StateRequest build() {
            _checkSingleUse();

            return new StateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cluster.state}".
     */
    public static final Endpoint<StateRequest, StateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _index = 1 << 0;
            final int _metric = 1 << 1;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;
            if (ApiTypeHelper.isDefined(request.metric())) propsSet |= _metric;

            if (propsSet == 0) {
                return "/_cluster/state";
            }
            if (propsSet == (_metric)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cluster/state/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }
            if (propsSet == (_metric | _index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cluster/state/");
                SimpleEndpoint.pathEncode(request.metric.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            if (request.allowNoIndices != null) {
                params.put("allow_no_indices", String.valueOf(request.allowNoIndices));
            }
            if (request.clusterManagerTimeout != null) {
                params.put("cluster_manager_timeout", request.clusterManagerTimeout._toJsonString());
            }
            if (ApiTypeHelper.isDefined(request.expandWildcards)) {
                params.put("expand_wildcards", request.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
            }
            if (request.flatSettings != null) {
                params.put("flat_settings", String.valueOf(request.flatSettings));
            }
            if (request.ignoreUnavailable != null) {
                params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
            }
            if (request.local != null) {
                params.put("local", String.valueOf(request.local));
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            if (request.waitForMetadataVersion != null) {
                params.put("wait_for_metadata_version", String.valueOf(request.waitForMetadataVersion));
            }
            if (request.waitForTimeout != null) {
                params.put("wait_for_timeout", request.waitForTimeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        StateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.flatSettings);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.local);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.metric);
        result = 31 * result + Objects.hashCode(this.waitForMetadataVersion);
        result = 31 * result + Objects.hashCode(this.waitForTimeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StateRequest other = (StateRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.flatSettings, other.flatSettings)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.local, other.local)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.metric, other.metric)
            && Objects.equals(this.waitForMetadataVersion, other.waitForMetadataVersion)
            && Objects.equals(this.waitForTimeout, other.waitForTimeout);
    }
}
