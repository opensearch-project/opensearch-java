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
import org.opensearch.client.opensearch.indices.add_block.IndicesBlockOptions;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.add_block.Request

/**
 * Adds a block to an index.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AddBlockRequest extends RequestBase implements ToCopyableBuilder<AddBlockRequest.Builder, AddBlockRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nonnull
    private final IndicesBlockOptions block;

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
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private AddBlockRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.block = ApiTypeHelper.requireNonNull(builder.block, this, "block");
        this.clusterManagerTimeout = builder.clusterManagerTimeout;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiableRequired(builder.index, this, "index");
        this.masterTimeout = builder.masterTimeout;
        this.timeout = builder.timeout;
    }

    public static AddBlockRequest of(Function<AddBlockRequest.Builder, ObjectBuilder<AddBlockRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or when
     * no indexes have been specified).
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    /**
     * Required - The block to add (one of <code>read</code>, <code>write</code>, <code>read_only</code> or <code>metadata</code>).
     * <p>
     * API name: {@code block}
     * </p>
     */
    @Nonnull
    public final IndicesBlockOptions block() {
        return this.block;
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
     * Whether specified concrete indexes should be ignored when unavailable (missing or closed).
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * Required - A comma separated list of indexes to add a block to.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
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
     * Explicit operation timeout
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
     * Builder for {@link AddBlockRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AddBlockRequest> {
        @Nullable
        private Boolean allowNoIndices;
        private IndicesBlockOptions block;
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
        private Time timeout;

        public Builder() {}

        private Builder(AddBlockRequest o) {
            this.allowNoIndices = o.allowNoIndices;
            this.block = o.block;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            this.allowNoIndices = o.allowNoIndices;
            this.block = o.block;
            this.clusterManagerTimeout = o.clusterManagerTimeout;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.masterTimeout = o.masterTimeout;
            this.timeout = o.timeout;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or
         * when no indexes have been specified).
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
         * Required - The block to add (one of <code>read</code>, <code>write</code>, <code>read_only</code> or <code>metadata</code>).
         * <p>
         * API name: {@code block}
         * </p>
         */
        @Nonnull
        public final Builder block(IndicesBlockOptions value) {
            this.block = value;
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
         * Whether specified concrete indexes should be ignored when unavailable (missing or closed).
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
         * Required - A comma separated list of indexes to add a block to.
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
         * Required - A comma separated list of indexes to add a block to.
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
         * Explicit operation timeout
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
         * Explicit operation timeout
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link AddBlockRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AddBlockRequest build() {
            _checkSingleUse();

            return new AddBlockRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code indices.add_block}".
     */
    public static final Endpoint<AddBlockRequest, AddBlockResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
            buf.append("/_block/");
            SimpleEndpoint.pathEncode(request.block.jsonValue(), buf);
            return buf.toString();
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
            if (request.ignoreUnavailable != null) {
                params.put("ignore_unavailable", String.valueOf(request.ignoreUnavailable));
            }
            if (request.masterTimeout != null) {
                params.put("master_timeout", request.masterTimeout._toJsonString());
            }
            if (request.timeout != null) {
                params.put("timeout", request.timeout._toJsonString());
            }
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        AddBlockResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + this.block.hashCode();
        result = 31 * result + Objects.hashCode(this.clusterManagerTimeout);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.masterTimeout);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AddBlockRequest other = (AddBlockRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && this.block.equals(other.block)
            && Objects.equals(this.clusterManagerTimeout, other.clusterManagerTimeout)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && this.index.equals(other.index)
            && Objects.equals(this.masterTimeout, other.masterTimeout)
            && Objects.equals(this.timeout, other.timeout);
    }
}
