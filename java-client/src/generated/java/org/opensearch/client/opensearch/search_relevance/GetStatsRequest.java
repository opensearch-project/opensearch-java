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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.get_stats.Request

/**
 * Gets stats.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetStatsRequest extends RequestBase implements ToCopyableBuilder<GetStatsRequest.Builder, GetStatsRequest> {

    @Nullable
    private final Boolean flatStatPaths;

    @Nullable
    private final Boolean includeAllNodes;

    @Nullable
    private final Boolean includeIndividualNodes;

    @Nullable
    private final Boolean includeInfo;

    @Nullable
    private final Boolean includeMetadata;

    @Nullable
    private final String stat;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private GetStatsRequest(Builder builder) {
        super(builder);
        this.flatStatPaths = builder.flatStatPaths;
        this.includeAllNodes = builder.includeAllNodes;
        this.includeIndividualNodes = builder.includeIndividualNodes;
        this.includeInfo = builder.includeInfo;
        this.includeMetadata = builder.includeMetadata;
        this.stat = builder.stat;
        this.timeout = builder.timeout;
    }

    public static GetStatsRequest of(Function<GetStatsRequest.Builder, ObjectBuilder<GetStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Requests flattened stat paths as keys
     * <p>
     * API name: {@code flat_stat_paths}
     * </p>
     */
    @Nullable
    public final Boolean flatStatPaths() {
        return this.flatStatPaths;
    }

    /**
     * Whether to include all nodes
     * <p>
     * API name: {@code include_all_nodes}
     * </p>
     */
    @Nullable
    public final Boolean includeAllNodes() {
        return this.includeAllNodes;
    }

    /**
     * Whether to include individual nodes
     * <p>
     * API name: {@code include_individual_nodes}
     * </p>
     */
    @Nullable
    public final Boolean includeIndividualNodes() {
        return this.includeIndividualNodes;
    }

    /**
     * Whether to include info
     * <p>
     * API name: {@code include_info}
     * </p>
     */
    @Nullable
    public final Boolean includeInfo() {
        return this.includeInfo;
    }

    /**
     * Whether to include metadata
     * <p>
     * API name: {@code include_metadata}
     * </p>
     */
    @Nullable
    public final Boolean includeMetadata() {
        return this.includeMetadata;
    }

    /**
     * A comma-separated list of statistics to return. Valid values: <code>cluster_version</code>,
     * <code>import_judgment_rating_generations</code>, <code>llm_judgment_rating_generations</code>,
     * <code>ubi_judgment_rating_generations</code>, <code>experiment_executions</code>,
     * <code>experiment_pairwise_comparison_executions</code>, <code>experiment_pointwise_evaluation_executions</code>,
     * <code>experiment_hybrid_optimizer_executions</code>.
     * <p>
     * API name: {@code stat}
     * </p>
     */
    @Nullable
    public final String stat() {
        return this.stat;
    }

    /**
     * The amount of time to wait for a response.
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
     * Builder for {@link GetStatsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetStatsRequest> {
        @Nullable
        private Boolean flatStatPaths;
        @Nullable
        private Boolean includeAllNodes;
        @Nullable
        private Boolean includeIndividualNodes;
        @Nullable
        private Boolean includeInfo;
        @Nullable
        private Boolean includeMetadata;
        @Nullable
        private String stat;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(GetStatsRequest o) {
            super(o);
            this.flatStatPaths = o.flatStatPaths;
            this.includeAllNodes = o.includeAllNodes;
            this.includeIndividualNodes = o.includeIndividualNodes;
            this.includeInfo = o.includeInfo;
            this.includeMetadata = o.includeMetadata;
            this.stat = o.stat;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.flatStatPaths = o.flatStatPaths;
            this.includeAllNodes = o.includeAllNodes;
            this.includeIndividualNodes = o.includeIndividualNodes;
            this.includeInfo = o.includeInfo;
            this.includeMetadata = o.includeMetadata;
            this.stat = o.stat;
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
         * Requests flattened stat paths as keys
         * <p>
         * API name: {@code flat_stat_paths}
         * </p>
         */
        @Nonnull
        public final Builder flatStatPaths(@Nullable Boolean value) {
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
        public final Builder includeAllNodes(@Nullable Boolean value) {
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
        public final Builder includeIndividualNodes(@Nullable Boolean value) {
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
        public final Builder includeInfo(@Nullable Boolean value) {
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
        public final Builder includeMetadata(@Nullable Boolean value) {
            this.includeMetadata = value;
            return this;
        }

        /**
         * A comma-separated list of statistics to return. Valid values: <code>cluster_version</code>,
         * <code>import_judgment_rating_generations</code>, <code>llm_judgment_rating_generations</code>,
         * <code>ubi_judgment_rating_generations</code>, <code>experiment_executions</code>,
         * <code>experiment_pairwise_comparison_executions</code>, <code>experiment_pointwise_evaluation_executions</code>,
         * <code>experiment_hybrid_optimizer_executions</code>.
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
         * The amount of time to wait for a response.
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
         * The amount of time to wait for a response.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link GetStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStatsRequest build() {
            _checkSingleUse();

            return new GetStatsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.flatStatPaths != null) {
            params.put("flat_stat_paths", String.valueOf(this.flatStatPaths));
        }
        if (this.includeAllNodes != null) {
            params.put("include_all_nodes", String.valueOf(this.includeAllNodes));
        }
        if (this.includeIndividualNodes != null) {
            params.put("include_individual_nodes", String.valueOf(this.includeIndividualNodes));
        }
        if (this.includeInfo != null) {
            params.put("include_info", String.valueOf(this.includeInfo));
        }
        if (this.includeMetadata != null) {
            params.put("include_metadata", String.valueOf(this.includeMetadata));
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code search_relevance.get_stats}".
     */
    public static final Endpoint<GetStatsRequest, GetStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _stat = 1 << 0;

            int propsSet = 0;

            if (request.stat() != null) propsSet |= _stat;

            if (propsSet == 0) {
                return "/_plugins/_search_relevance/stats";
            }
            if (propsSet == (_stat)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/stats/");
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
        GetStatsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.flatStatPaths);
        result = 31 * result + Objects.hashCode(this.includeAllNodes);
        result = 31 * result + Objects.hashCode(this.includeIndividualNodes);
        result = 31 * result + Objects.hashCode(this.includeInfo);
        result = 31 * result + Objects.hashCode(this.includeMetadata);
        result = 31 * result + Objects.hashCode(this.stat);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStatsRequest other = (GetStatsRequest) o;
        return Objects.equals(this.flatStatPaths, other.flatStatPaths)
            && Objects.equals(this.includeAllNodes, other.includeAllNodes)
            && Objects.equals(this.includeIndividualNodes, other.includeIndividualNodes)
            && Objects.equals(this.includeInfo, other.includeInfo)
            && Objects.equals(this.includeMetadata, other.includeMetadata)
            && Objects.equals(this.stat, other.stat)
            && Objects.equals(this.timeout, other.timeout);
    }
}
