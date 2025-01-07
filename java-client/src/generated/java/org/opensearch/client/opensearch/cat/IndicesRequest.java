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
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.Bytes;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.HealthStatus;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.indices.Request

/**
 * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status, and so
 * on.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class IndicesRequest extends CatRequestBase implements ToCopyableBuilder<IndicesRequest.Builder, IndicesRequest> {

    @Nullable
    private final Bytes bytes;

    @Nullable
    private final Time clusterManagerTimeout;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final HealthStatus health;

    @Nullable
    private final Boolean includeUnloadedSegments;

    @Nonnull
    private final List<String> index;

    @Deprecated
    @Nullable
    private final Time masterTimeout;

    @Nullable
    private final Boolean pri;

    @Nullable
    private final TimeUnit time;

    // ---------------------------------------------------------------------------------------------

    private IndicesRequest(Builder builder) {
        super(builder);
        this.bytes = builder.bytes;
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.health = builder.health;
        this.includeUnloadedSegments = builder.includeUnloadedSegments;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.masterTimeout = builder.masterTimeout;
        this.pri = builder.pri;
        this.time = builder.time;
    }

    public static IndicesRequest of(Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn) {
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
     * The type of index that wildcard patterns can match.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * Limits indexes based on their health status. Supported values are <code>green</code>, <code>yellow</code>, and <code>red</code>.
     * <p>
     * API name: {@code health}
     * </p>
     */
    @Nullable
    public final HealthStatus health() {
        return this.health;
    }

    /**
     * Whether to include information from segments not loaded into memory.
     * <p>
     * API name: {@code include_unloaded_segments}
     * </p>
     */
    @Nullable
    public final Boolean includeUnloadedSegments() {
        return this.includeUnloadedSegments;
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
     * When <code>true</code>, returns information only from the primary shards.
     * <p>
     * API name: {@code pri}
     * </p>
     */
    @Nullable
    public final Boolean pri() {
        return this.pri;
    }

    /**
     * Specifies the time units.
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
     * Builder for {@link IndicesRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, IndicesRequest> {
        @Nullable
        private Bytes bytes;
        @Nullable
        private Time clusterManagerTimeout;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private HealthStatus health;
        @Nullable
        private Boolean includeUnloadedSegments;
        @Nullable
        private List<String> index;
        @Nullable
        private Time masterTimeout;
        @Nullable
        private Boolean pri;
        @Nullable
        private TimeUnit time;

        public Builder() {}

        private Builder(IndicesRequest o) {
            super(o);
            this.bytes = o.bytes;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.health = o.health;
            this.includeUnloadedSegments = o.includeUnloadedSegments;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.pri = o.pri;
            this.time = o.time;
        }

        private Builder(Builder o) {
            super(o);
            this.bytes = o.bytes;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.health = o.health;
            this.includeUnloadedSegments = o.includeUnloadedSegments;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.pri = o.pri;
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
         * The type of index that wildcard patterns can match.
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
         * The type of index that wildcard patterns can match.
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
         * Limits indexes based on their health status. Supported values are <code>green</code>, <code>yellow</code>, and <code>red</code>.
         * <p>
         * API name: {@code health}
         * </p>
         */
        @Nonnull
        public final Builder health(@Nullable HealthStatus value) {
            this.health = value;
            return this;
        }

        /**
         * Whether to include information from segments not loaded into memory.
         * <p>
         * API name: {@code include_unloaded_segments}
         * </p>
         */
        @Nonnull
        public final Builder includeUnloadedSegments(@Nullable Boolean value) {
            this.includeUnloadedSegments = value;
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
         * When <code>true</code>, returns information only from the primary shards.
         * <p>
         * API name: {@code pri}
         * </p>
         */
        @Nonnull
        public final Builder pri(@Nullable Boolean value) {
            this.pri = value;
            return this;
        }

        /**
         * Specifies the time units.
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
         * Builds a {@link IndicesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndicesRequest build() {
            _checkSingleUse();

            return new IndicesRequest(this);
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
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.health != null) {
            params.put("health", this.health.jsonValue());
        }
        if (this.includeUnloadedSegments != null) {
            params.put("include_unloaded_segments", String.valueOf(this.includeUnloadedSegments));
        }
        if (this.masterTimeout != null) {
            params.put("master_timeout", this.masterTimeout._toJsonString());
        }
        if (this.pri != null) {
            params.put("pri", String.valueOf(this.pri));
        }
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.indices}".
     */
    public static final Endpoint<IndicesRequest, IndicesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_cat/indices";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_cat/indices/");
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
        IndicesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.health);
        result = 31 * result + Objects.hashCode(this.includeUnloadedSegments);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.pri);
        result = 31 * result + Objects.hashCode(this.time);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndicesRequest other = (IndicesRequest) o;
        return Objects.equals(this.bytes, other.bytes)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.health, other.health)
            && Objects.equals(this.includeUnloadedSegments, other.includeUnloadedSegments)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.pri, other.pri)
            && Objects.equals(this.time, other.time);
    }
}
