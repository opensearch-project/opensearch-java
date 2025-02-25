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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.pending_tasks.Request

/**
 * Returns a concise representation of the cluster's pending tasks.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PendingTasksRequest extends CatRequestBase
    implements
        ToCopyableBuilder<PendingTasksRequest.Builder, PendingTasksRequest> {

    @Nullable
    private final Time clusterManagerTimeout;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final TimeUnit time;

    // ---------------------------------------------------------------------------------------------

    private PendingTasksRequest(Builder builder) {
        super(builder);
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.masterTimeout = builder.masterTimeout;
        this.time = builder.time;
    }

    public static PendingTasksRequest of(Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn) {
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
     * Builder for {@link PendingTasksRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PendingTasksRequest> {
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private TimeUnit time;

        public Builder() {}

        private Builder(PendingTasksRequest o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.masterTimeout = o.masterTimeout;
            this.time = o.time;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterManagerTimeout = o.clusterManagerTimeout;
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
         * Builds a {@link PendingTasksRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PendingTasksRequest build() {
            _checkSingleUse();

            return new PendingTasksRequest(this);
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
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.pending_tasks}".
     */
    public static final Endpoint<PendingTasksRequest, PendingTasksResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cat/pending_tasks",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        PendingTasksResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.time);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PendingTasksRequest other = (PendingTasksRequest) o;
        return Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.time, other.time);
    }
}
