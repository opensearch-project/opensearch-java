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

package org.opensearch.client.opensearch.indices;

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
import org.opensearch.client.opensearch._types.WaitForActiveShards;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.open.Request

/**
 * Opens an index.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class OpenRequest extends RequestBase implements ToCopyableBuilder<OpenRequest.Builder, OpenRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final Time taskExecutionTimeout;

    @Nullable
    private final Time timeout;

    @Nullable
    private final WaitForActiveShards waitForActiveShards;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private OpenRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiableRequired(builder.index, this, "index");
        this.masterTimeout = builder.masterTimeout;
        this.taskExecutionTimeout = builder.taskExecutionTimeout;
        this.timeout = builder.timeout;
        this.waitForActiveShards = builder.waitForActiveShards;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static OpenRequest of(Function<OpenRequest.Builder, ObjectBuilder<OpenRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets only
     * missing or closed indexes. This behavior applies even if the request targets other open indexes.
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
     * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
     * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
     * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * If <code>false</code>, the request returns an error if it targets a missing or closed index.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * Required - Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>).
     * By default, you must explicitly name the indexes you using to limit the request. To limit a request using <code>_all</code>,
     * <code>*</code>, or other wildcard expressions, change the <code>action.destructive_requires_name</code> setting to false. You can
     * update this setting in the <code>opensearch.yml</code> file or using the cluster update settings API.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request fails
     * and returns an error.
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
     * Explicit task execution timeout, only useful when <code>wait_for_completion</code> is false, defaults to <code>1h</code>.
     * <p>
     * API name: {@code task_execution_timeout}
     * </p>
     */
    @Nullable
    public final Time taskExecutionTimeout() {
        return this.taskExecutionTimeout;
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

    /**
     * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive integer
     * up to the total number of shards in the index (<code>number_of_replicas+1</code>).
     * <p>
     * API name: {@code wait_for_active_shards}
     * </p>
     */
    @Nullable
    public final WaitForActiveShards waitForActiveShards() {
        return this.waitForActiveShards;
    }

    /**
     * Should this request wait until the operation has completed before returning.
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
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
     * Builder for {@link OpenRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, OpenRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean ignoreUnavailable;
        private List<String> index;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Time taskExecutionTimeout;
        @Nullable
        private Time timeout;
        @Nullable
        private WaitForActiveShards waitForActiveShards;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(OpenRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.taskExecutionTimeout = o.taskExecutionTimeout;
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.taskExecutionTimeout = o.taskExecutionTimeout;
            this.timeout = o.timeout;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForCompletion = o.waitForCompletion;
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
         * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets
         * only missing or closed indexes. This behavior applies even if the request targets other open indexes.
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
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
         * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
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
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
         * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
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
         * If <code>false</code>, the request returns an error if it targets a missing or closed index.
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
         * Required - Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards
         * (<code>*</code>). By default, you must explicitly name the indexes you using to limit the request. To limit a request using
         * <code>_all</code>, <code>*</code>, or other wildcard expressions, change the <code>action.destructive_requires_name</code>
         * setting to false. You can update this setting in the <code>opensearch.yml</code> file or using the cluster update settings API.
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
         * Required - Comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards
         * (<code>*</code>). By default, you must explicitly name the indexes you using to limit the request. To limit a request using
         * <code>_all</code>, <code>*</code>, or other wildcard expressions, change the <code>action.destructive_requires_name</code>
         * setting to false. You can update this setting in the <code>opensearch.yml</code> file or using the cluster update settings API.
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
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
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
         * Period to wait for a connection to the cluster-manager node. If no response is received before the timeout expires, the request
         * fails and returns an error.
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
         * Explicit task execution timeout, only useful when <code>wait_for_completion</code> is false, defaults to <code>1h</code>.
         * <p>
         * API name: {@code task_execution_timeout}
         * </p>
         */
        @Nonnull
        public final Builder taskExecutionTimeout(@Nullable Time value) {
            this.taskExecutionTimeout = value;
            return this;
        }

        /**
         * Explicit task execution timeout, only useful when <code>wait_for_completion</code> is false, defaults to <code>1h</code>.
         * <p>
         * API name: {@code task_execution_timeout}
         * </p>
         */
        @Nonnull
        public final Builder taskExecutionTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return taskExecutionTimeout(fn.apply(new Time.Builder()).build());
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
         * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive
         * integer up to the total number of shards in the index (<code>number_of_replicas+1</code>).
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
         * The number of shard copies that must be active before proceeding with the operation. Set to <code>all</code> or any positive
         * integer up to the total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
            return waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
        }

        /**
         * Should this request wait until the operation has completed before returning.
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        @Nonnull
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link OpenRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public OpenRequest build() {
            _checkSingleUse();

            return new OpenRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.taskExecutionTimeout != null) {
            params.put("task_execution_timeout", this.taskExecutionTimeout._toJsonString());
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.waitForActiveShards != null) {
            params.put("wait_for_active_shards", this.waitForActiveShards._toJsonString());
        }
        if (this.waitForCompletion != null) {
            params.put("wait_for_completion", String.valueOf(this.waitForCompletion));
        }
    }

    /**
     * Endpoint "{@code indices.open}".
     */
    public static final Endpoint<OpenRequest, OpenResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
            buf.append("/_open");
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        OpenResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.taskExecutionTimeout);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.waitForActiveShards);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OpenRequest other = (OpenRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && this.index.equals(other.index)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.taskExecutionTimeout, other.taskExecutionTimeout)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.waitForActiveShards, other.waitForActiveShards)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
