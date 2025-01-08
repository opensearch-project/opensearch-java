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
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.BooleanEndpoint;
import org.opensearch.client.transport.endpoints.BooleanResponse;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.delete_voting_config_exclusions.Request

/**
 * Clears cluster voting config exclusions.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteVotingConfigExclusionsRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteVotingConfigExclusionsRequest.Builder, DeleteVotingConfigExclusionsRequest> {

    @Nullable
    private final Boolean waitForRemoval;

    // ---------------------------------------------------------------------------------------------

    private DeleteVotingConfigExclusionsRequest(Builder builder) {
        super(builder);
        this.waitForRemoval = builder.waitForRemoval;
    }

    public static DeleteVotingConfigExclusionsRequest of(
        Function<DeleteVotingConfigExclusionsRequest.Builder, ObjectBuilder<DeleteVotingConfigExclusionsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Specifies whether to wait for all excluded nodes to be removed from the cluster before clearing the voting configuration exclusions
     * list. Defaults to true, meaning that all excluded nodes must be removed from the cluster before this API takes any action. If set to
     * <code>false</code> then the voting configuration exclusions list is cleared even if some excluded nodes are still in the cluster.
     * <p>
     * API name: {@code wait_for_removal}
     * </p>
     */
    @Nullable
    public final Boolean waitForRemoval() {
        return this.waitForRemoval;
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
     * Builder for {@link DeleteVotingConfigExclusionsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteVotingConfigExclusionsRequest> {
        @Nullable
        private Boolean waitForRemoval;

        public Builder() {}

        private Builder(DeleteVotingConfigExclusionsRequest o) {
            super(o);
            this.waitForRemoval = o.waitForRemoval;
        }

        private Builder(Builder o) {
            super(o);
            this.waitForRemoval = o.waitForRemoval;
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
         * Specifies whether to wait for all excluded nodes to be removed from the cluster before clearing the voting configuration
         * exclusions list. Defaults to true, meaning that all excluded nodes must be removed from the cluster before this API takes any
         * action. If set to <code>false</code> then the voting configuration exclusions list is cleared even if some excluded nodes are
         * still in the cluster.
         * <p>
         * API name: {@code wait_for_removal}
         * </p>
         */
        @Nonnull
        public final Builder waitForRemoval(@Nullable Boolean value) {
            this.waitForRemoval = value;
            return this;
        }

        /**
         * Builds a {@link DeleteVotingConfigExclusionsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteVotingConfigExclusionsRequest build() {
            _checkSingleUse();

            return new DeleteVotingConfigExclusionsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.waitForRemoval != null) {
            params.put("wait_for_removal", String.valueOf(this.waitForRemoval));
        }
    }

    /**
     * Endpoint "{@code cluster.delete_voting_config_exclusions}".
     */
    public static final Endpoint<DeleteVotingConfigExclusionsRequest, BooleanResponse, ErrorResponse> _ENDPOINT = new BooleanEndpoint<>(
        // Request method
        request -> "DELETE",
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
        result = 31 * result + Objects.hashCode(this.waitForRemoval);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteVotingConfigExclusionsRequest other = (DeleteVotingConfigExclusionsRequest) o;
        return Objects.equals(this.waitForRemoval, other.waitForRemoval);
    }
}
