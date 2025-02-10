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
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.BooleanEndpoint;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.post_voting_config_exclusions.Request

/**
 * Updates the cluster voting configuration by excluding certain node IDs or names.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class PostVotingConfigExclusionsRequest extends RequestBase
    implements
        ToCopyableBuilder<PostVotingConfigExclusionsRequest.Builder, PostVotingConfigExclusionsRequest> {

    @Nonnull
    private final List<String> nodeIds;

    @Nonnull
    private final List<String> nodeNames;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private PostVotingConfigExclusionsRequest(Builder builder) {
        super(builder);
        this.nodeIds = ApiTypeHelper.unmodifiable(builder.nodeIds);
        this.nodeNames = ApiTypeHelper.unmodifiable(builder.nodeNames);
        this.timeout = builder.timeout;
    }

    public static PostVotingConfigExclusionsRequest of(
        Function<PostVotingConfigExclusionsRequest.Builder, ObjectBuilder<PostVotingConfigExclusionsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A comma-separated list of node IDs to exclude from the voting configuration. When using this setting, you cannot also specify
     * <code>node_names</code>.
     * <p>
     * API name: {@code node_ids}
     * </p>
     */
    @Nonnull
    public final List<String> nodeIds() {
        return this.nodeIds;
    }

    /**
     * A comma-separated list of node names to exclude from the voting configuration. When using this setting, you cannot also specify
     * <code>node_ids</code>.
     * <p>
     * API name: {@code node_names}
     * </p>
     */
    @Nonnull
    public final List<String> nodeNames() {
        return this.nodeNames;
    }

    /**
     * When adding a voting configuration exclusion, the API waits for the specified nodes to be excluded from the voting configuration
     * before returning a response. If the timeout expires before the appropriate condition is satisfied, the request fails and returns an
     * error.
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
     * Builder for {@link PostVotingConfigExclusionsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, PostVotingConfigExclusionsRequest> {
        @Nullable
        private List<String> nodeIds;
        @Nullable
        private List<String> nodeNames;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(PostVotingConfigExclusionsRequest o) {
            super(o);
            this.nodeIds = _listCopy(o.nodeIds);
            this.nodeNames = _listCopy(o.nodeNames);
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.nodeIds = _listCopy(o.nodeIds);
            this.nodeNames = _listCopy(o.nodeNames);
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
         * A comma-separated list of node IDs to exclude from the voting configuration. When using this setting, you cannot also specify
         * <code>node_names</code>.
         * <p>
         * API name: {@code node_ids}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(List<String> list) {
            this.nodeIds = _listAddAll(this.nodeIds, list);
            return this;
        }

        /**
         * A comma-separated list of node IDs to exclude from the voting configuration. When using this setting, you cannot also specify
         * <code>node_names</code>.
         * <p>
         * API name: {@code node_ids}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodeIds</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeIds(String value, String... values) {
            this.nodeIds = _listAdd(this.nodeIds, value, values);
            return this;
        }

        /**
         * A comma-separated list of node names to exclude from the voting configuration. When using this setting, you cannot also specify
         * <code>node_ids</code>.
         * <p>
         * API name: {@code node_names}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeNames(List<String> list) {
            this.nodeNames = _listAddAll(this.nodeNames, list);
            return this;
        }

        /**
         * A comma-separated list of node names to exclude from the voting configuration. When using this setting, you cannot also specify
         * <code>node_ids</code>.
         * <p>
         * API name: {@code node_names}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodeNames</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodeNames(String value, String... values) {
            this.nodeNames = _listAdd(this.nodeNames, value, values);
            return this;
        }

        /**
         * When adding a voting configuration exclusion, the API waits for the specified nodes to be excluded from the voting configuration
         * before returning a response. If the timeout expires before the appropriate condition is satisfied, the request fails and returns
         * an error.
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
         * When adding a voting configuration exclusion, the API waits for the specified nodes to be excluded from the voting configuration
         * before returning a response. If the timeout expires before the appropriate condition is satisfied, the request fails and returns
         * an error.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link PostVotingConfigExclusionsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PostVotingConfigExclusionsRequest build() {
            _checkSingleUse();

            return new PostVotingConfigExclusionsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (ApiTypeHelper.isDefined(this.nodeIds)) {
            params.put("node_ids", String.join(",", this.nodeIds));
        }
        if (ApiTypeHelper.isDefined(this.nodeNames)) {
            params.put("node_names", String.join(",", this.nodeNames));
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code cluster.post_voting_config_exclusions}".
     */
    public static final Endpoint<PostVotingConfigExclusionsRequest, BooleanResponse, ErrorResponse> _ENDPOINT = new BooleanEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_cluster/voting_config_exclusions",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap()
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodeIds);
        result = 31 * result + Objects.hashCode(this.nodeNames);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PostVotingConfigExclusionsRequest other = (PostVotingConfigExclusionsRequest) o;
        return Objects.equals(this.nodeIds, other.nodeIds)
            && Objects.equals(this.nodeNames, other.nodeNames)
            && Objects.equals(this.timeout, other.timeout);
    }
}
