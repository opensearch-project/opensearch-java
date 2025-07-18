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

package org.opensearch.client.opensearch.ltr;

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
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ltr.stats.Request

/**
 * Provides information about the current status of the LTR plugin.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class LtrStatsRequest extends RequestBase implements ToCopyableBuilder<LtrStatsRequest.Builder, LtrStatsRequest> {

    @Nonnull
    private final List<String> nodeId;

    @Nonnull
    private final List<LtrStatName> stat;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private LtrStatsRequest(Builder builder) {
        super(builder);
        this.nodeId = ApiTypeHelper.unmodifiable(builder.nodeId);
        this.stat = ApiTypeHelper.unmodifiable(builder.stat);
        this.timeout = builder.timeout;
    }

    public static LtrStatsRequest of(Function<LtrStatsRequest.Builder, ObjectBuilder<LtrStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A comma-separated list of node IDs or names to limit the returned information; use <code>_local</code> to return information from the
     * node you're connecting to, leave empty to get information from all nodes.
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nonnull
    public final List<String> nodeId() {
        return this.nodeId;
    }

    /**
     * A comma-separated list of stats to retrieve; use <code>_all</code> or empty string to retrieve all stats.
     * <p>
     * API name: {@code stat}
     * </p>
     */
    @Nonnull
    public final List<LtrStatName> stat() {
        return this.stat;
    }

    /**
     * The time in milliseconds to wait for a response.
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
     * Builder for {@link LtrStatsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, LtrStatsRequest> {
        @Nullable
        private List<String> nodeId;
        @Nullable
        private List<LtrStatName> stat;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(LtrStatsRequest o) {
            super(o);
            this.nodeId = _listCopy(o.nodeId);
            this.stat = _listCopy(o.stat);
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.nodeId = _listCopy(o.nodeId);
            this.stat = _listCopy(o.stat);
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
         * A comma-separated list of node IDs or names to limit the returned information; use <code>_local</code> to return information from
         * the node you're connecting to, leave empty to get information from all nodes.
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
         * the node you're connecting to, leave empty to get information from all nodes.
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
         * A comma-separated list of stats to retrieve; use <code>_all</code> or empty string to retrieve all stats.
         * <p>
         * API name: {@code stat}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stat</code>.
         * </p>
         */
        @Nonnull
        public final Builder stat(List<LtrStatName> list) {
            this.stat = _listAddAll(this.stat, list);
            return this;
        }

        /**
         * A comma-separated list of stats to retrieve; use <code>_all</code> or empty string to retrieve all stats.
         * <p>
         * API name: {@code stat}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>stat</code>.
         * </p>
         */
        @Nonnull
        public final Builder stat(LtrStatName value, LtrStatName... values) {
            this.stat = _listAdd(this.stat, value, values);
            return this;
        }

        /**
         * The time in milliseconds to wait for a response.
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
         * The time in milliseconds to wait for a response.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link LtrStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LtrStatsRequest build() {
            _checkSingleUse();

            return new LtrStatsRequest(this);
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
     * Endpoint "{@code ltr.stats}".
     */
    public static final Endpoint<LtrStatsRequest, LtrStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _nodeId = 1 << 0;
            final int _stat = 1 << 1;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.nodeId())) propsSet |= _nodeId;
            if (ApiTypeHelper.isDefined(request.stat())) propsSet |= _stat;

            if (propsSet == 0) {
                return "/_plugins/_ltr/stats";
            }
            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ltr/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/stats");
                return buf.toString();
            }
            if (propsSet == (_nodeId | _stat)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ltr/");
                SimpleEndpoint.pathEncode(String.join(",", request.nodeId), buf);
                buf.append("/stats/");
                SimpleEndpoint.pathEncode(request.stat.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
                return buf.toString();
            }
            if (propsSet == (_stat)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ltr/stats/");
                SimpleEndpoint.pathEncode(request.stat.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")), buf);
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
        LtrStatsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.stat);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LtrStatsRequest other = (LtrStatsRequest) o;
        return Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.stat, other.stat)
            && Objects.equals(this.timeout, other.timeout);
    }
}
