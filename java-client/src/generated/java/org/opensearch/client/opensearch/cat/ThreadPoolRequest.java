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
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.thread_pool.Request

/**
 * Returns cluster-wide thread pool statistics per node. By default the active, queued, and rejected statistics are returned for all thread
 * pools.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ThreadPoolRequest extends CatRequestBase implements ToCopyableBuilder<ThreadPoolRequest.Builder, ThreadPoolRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<String> threadPoolPatterns;

    // ---------------------------------------------------------------------------------------------

    private ThreadPoolRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.masterTimeout = builder.masterTimeout;
        this.size = builder.size;
        this.threadPoolPatterns = ApiTypeHelper.unmodifiable(builder.threadPoolPatterns);
    }

    public static ThreadPoolRequest of(Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A timeout for connection to the cluster manager node.
     * <p>
     * API name: {@code cluster_manager_timeout}
     * </p>
     */
    @Nullable
    public final Time clusterManagerTimeout() {
        return this.clusterManagerTimeout;
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
     * The multiplier in which to display values.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * A comma-separated list of thread pool names used to limit the request. Accepts wildcard expressions.
     * <p>
     * API name: {@code thread_pool_patterns}
     * </p>
     */
    @Nonnull
    public final List<String> threadPoolPatterns() {
        return this.threadPoolPatterns;
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
     * Builder for {@link ThreadPoolRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ThreadPoolRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Integer size;
        @Nullable
        private List<String> threadPoolPatterns;

        public Builder() {}

        private Builder(ThreadPoolRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.masterTimeout = o.masterTimeout;
            this.size = o.size;
            this.threadPoolPatterns = _listCopy(o.threadPoolPatterns);
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.masterTimeout = o.masterTimeout;
            this.size = o.size;
            this.threadPoolPatterns = _listCopy(o.threadPoolPatterns);
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
         * A timeout for connection to the cluster manager node.
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
         * A timeout for connection to the cluster manager node.
         * <p>
         * API name: {@code cluster_manager_timeout}
         * </p>
         */
        @Nonnull
        public final Builder clusterManagerTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return clusterManagerTimeout(fn.apply(new Time.Builder()).build());
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
         * The multiplier in which to display values.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * A comma-separated list of thread pool names used to limit the request. Accepts wildcard expressions.
         * <p>
         * API name: {@code thread_pool_patterns}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>threadPoolPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder threadPoolPatterns(List<String> list) {
            this.threadPoolPatterns = _listAddAll(this.threadPoolPatterns, list);
            return this;
        }

        /**
         * A comma-separated list of thread pool names used to limit the request. Accepts wildcard expressions.
         * <p>
         * API name: {@code thread_pool_patterns}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>threadPoolPatterns</code>.
         * </p>
         */
        @Nonnull
        public final Builder threadPoolPatterns(String value, String... values) {
            this.threadPoolPatterns = _listAdd(this.threadPoolPatterns, value, values);
            return this;
        }

        /**
         * Builds a {@link ThreadPoolRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ThreadPoolRequest build() {
            _checkSingleUse();

            return new ThreadPoolRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.clusterManagerTimeout != null) {
            params.put("cluster_manager_timeout", this.clusterManagerTimeout._toJsonString());
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.size != null) {
            params.put("size", String.valueOf(this.size));
        }
    }

    /**
     * Endpoint "{@code cat.thread_pool}".
     */
    public static final Endpoint<ThreadPoolRequest, ThreadPoolResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _threadPoolPatterns = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.threadPoolPatterns())) propsSet |= _threadPoolPatterns;

            if (propsSet == 0) {
                return "/_cat/thread_pool";
            }
            if (propsSet == (_threadPoolPatterns)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cat/thread_pool/");
                SimpleEndpoint.pathEncode(String.join(",", request.threadPoolPatterns), buf);
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
        ThreadPoolResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.threadPoolPatterns);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ThreadPoolRequest other = (ThreadPoolRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.threadPoolPatterns, other.threadPoolPatterns);
    }
}
