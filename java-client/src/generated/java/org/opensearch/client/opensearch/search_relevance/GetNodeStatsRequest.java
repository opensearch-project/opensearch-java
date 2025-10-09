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

package org.opensearch.client.opensearch.search_relevance;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.get_node_stats.Request

/**
 * Gets stats by node.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetNodeStatsRequest extends RequestBase implements ToCopyableBuilder<GetNodeStatsRequest.Builder, GetNodeStatsRequest> {

    @Nullable
    private final String flatStatPaths;

    @Nullable
    private final String includeAllNodes;

    @Nullable
    private final String includeIndividualNodes;

    @Nullable
    private final String includeInfo;

    @Nullable
    private final String includeMetadata;

    @Nonnull
    private final String nodeId;

    @Nullable
    private final String stat;

    // ---------------------------------------------------------------------------------------------

    private GetNodeStatsRequest(Builder builder) {
        super(builder);
        this.flatStatPaths = builder.flatStatPaths;
        this.includeAllNodes = builder.includeAllNodes;
        this.includeIndividualNodes = builder.includeIndividualNodes;
        this.includeInfo = builder.includeInfo;
        this.includeMetadata = builder.includeMetadata;
        this.nodeId = ApiTypeHelper.requireNonNull(builder.nodeId, this, "nodeId");
        this.stat = builder.stat;
    }

    public static GetNodeStatsRequest of(Function<GetNodeStatsRequest.Builder, ObjectBuilder<GetNodeStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Requests flattened stat paths as keys
     * <p>
     * API name: {@code flat_stat_paths}
     * </p>
     */
    @Nullable
    public final String flatStatPaths() {
        return this.flatStatPaths;
    }

    /**
     * Whether to include all nodes
     * <p>
     * API name: {@code include_all_nodes}
     * </p>
     */
    @Nullable
    public final String includeAllNodes() {
        return this.includeAllNodes;
    }

    /**
     * Whether to include individual nodes
     * <p>
     * API name: {@code include_individual_nodes}
     * </p>
     */
    @Nullable
    public final String includeIndividualNodes() {
        return this.includeIndividualNodes;
    }

    /**
     * Whether to include info
     * <p>
     * API name: {@code include_info}
     * </p>
     */
    @Nullable
    public final String includeInfo() {
        return this.includeInfo;
    }

    /**
     * Whether to include metadata
     * <p>
     * API name: {@code include_metadata}
     * </p>
     */
    @Nullable
    public final String includeMetadata() {
        return this.includeMetadata;
    }

    /**
     * Required - The node id
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nonnull
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * The statistic to return
     * <p>
     * API name: {@code stat}
     * </p>
     */
    @Nullable
    public final String stat() {
        return this.stat;
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
     * Builder for {@link GetNodeStatsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetNodeStatsRequest> {
        @Nullable
        private String flatStatPaths;
        @Nullable
        private String includeAllNodes;
        @Nullable
        private String includeIndividualNodes;
        @Nullable
        private String includeInfo;
        @Nullable
        private String includeMetadata;
        private String nodeId;
        @Nullable
        private String stat;

        public Builder() {}

        private Builder(GetNodeStatsRequest o) {
            super(o);
            this.flatStatPaths = o.flatStatPaths;
            this.includeAllNodes = o.includeAllNodes;
            this.includeIndividualNodes = o.includeIndividualNodes;
            this.includeInfo = o.includeInfo;
            this.includeMetadata = o.includeMetadata;
            this.nodeId = o.nodeId;
            this.stat = o.stat;
        }

        private Builder(Builder o) {
            super(o);
            this.flatStatPaths = o.flatStatPaths;
            this.includeAllNodes = o.includeAllNodes;
            this.includeIndividualNodes = o.includeIndividualNodes;
            this.includeInfo = o.includeInfo;
            this.includeMetadata = o.includeMetadata;
            this.nodeId = o.nodeId;
            this.stat = o.stat;
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
         * Requests flattened stat paths as keys
         * <p>
         * API name: {@code flat_stat_paths}
         * </p>
         */
        @Nonnull
        public final Builder flatStatPaths(@Nullable String value) {
            this.flatStatPaths = value;
            return this;
        }

        /**
         * Whether to include all nodes
         * <p>
         * API name: {@code include_all_nodes}
         * </p>
         */
        @Nonnull
        public final Builder includeAllNodes(@Nullable String value) {
            this.includeAllNodes = value;
            return this;
        }

        /**
         * Whether to include individual nodes
         * <p>
         * API name: {@code include_individual_nodes}
         * </p>
         */
        @Nonnull
        public final Builder includeIndividualNodes(@Nullable String value) {
            this.includeIndividualNodes = value;
            return this;
        }

        /**
         * Whether to include info
         * <p>
         * API name: {@code include_info}
         * </p>
         */
        @Nonnull
        public final Builder includeInfo(@Nullable String value) {
            this.includeInfo = value;
            return this;
        }

        /**
         * Whether to include metadata
         * <p>
         * API name: {@code include_metadata}
         * </p>
         */
        @Nonnull
        public final Builder includeMetadata(@Nullable String value) {
            this.includeMetadata = value;
            return this;
        }

        /**
         * Required - The node id
         * <p>
         * API name: {@code node_id}
         * </p>
         */
        @Nonnull
        public final Builder nodeId(String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * The statistic to return
         * <p>
         * API name: {@code stat}
         * </p>
         */
        @Nonnull
        public final Builder stat(@Nullable String value) {
            this.stat = value;
            return this;
        }

        /**
         * Builds a {@link GetNodeStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetNodeStatsRequest build() {
            _checkSingleUse();

            return new GetNodeStatsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.flatStatPaths != null) {
            params.put("flat_stat_paths", this.flatStatPaths);
        }
        if (this.includeAllNodes != null) {
            params.put("include_all_nodes", this.includeAllNodes);
        }
        if (this.includeIndividualNodes != null) {
            params.put("include_individual_nodes", this.includeIndividualNodes);
        }
        if (this.includeInfo != null) {
            params.put("include_info", this.includeInfo);
        }
        if (this.includeMetadata != null) {
            params.put("include_metadata", this.includeMetadata);
        }
    }

    /**
     * Endpoint "{@code search_relevance.get_node_stats}".
     */
    public static final Endpoint<GetNodeStatsRequest, GetNodeStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _nodeId = 1 << 0;
            final int _stat = 1 << 1;

            int propsSet = 0;

            propsSet |= _nodeId;
            if (request.stat() != null) propsSet |= _stat;

            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/");
                SimpleEndpoint.pathEncode(request.nodeId, buf);
                buf.append("/stats");
                return buf.toString();
            }
            if (propsSet == (_nodeId | _stat)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/");
                SimpleEndpoint.pathEncode(request.nodeId, buf);
                buf.append("/stats/");
                SimpleEndpoint.pathEncode(request.stat, buf);
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
        GetNodeStatsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.flatStatPaths);
        result = 31 * result + Objects.hashCode(this.includeAllNodes);
        result = 31 * result + Objects.hashCode(this.includeIndividualNodes);
        result = 31 * result + Objects.hashCode(this.includeInfo);
        result = 31 * result + Objects.hashCode(this.includeMetadata);
        result = 31 * result + this.nodeId.hashCode();
        result = 31 * result + Objects.hashCode(this.stat);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetNodeStatsRequest other = (GetNodeStatsRequest) o;
        return Objects.equals(this.flatStatPaths, other.flatStatPaths)
            && Objects.equals(this.includeAllNodes, other.includeAllNodes)
            && Objects.equals(this.includeIndividualNodes, other.includeIndividualNodes)
            && Objects.equals(this.includeInfo, other.includeInfo)
            && Objects.equals(this.includeMetadata, other.includeMetadata)
            && this.nodeId.equals(other.nodeId)
            && Objects.equals(this.stat, other.stat);
    }
}
