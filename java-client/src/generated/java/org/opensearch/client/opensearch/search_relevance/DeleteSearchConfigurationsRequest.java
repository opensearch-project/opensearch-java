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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.delete_search_configurations.Request

/**
 * Deletes a specified search configuration.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteSearchConfigurationsRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteSearchConfigurationsRequest.Builder, DeleteSearchConfigurationsRequest> {

    @Nonnull
    private final String searchConfigurationId;

    // ---------------------------------------------------------------------------------------------

    private DeleteSearchConfigurationsRequest(Builder builder) {
        super(builder);
        this.searchConfigurationId = ApiTypeHelper.requireNonNull(builder.searchConfigurationId, this, "searchConfigurationId");
    }

    public static DeleteSearchConfigurationsRequest of(
        Function<DeleteSearchConfigurationsRequest.Builder, ObjectBuilder<DeleteSearchConfigurationsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The search configuration id
     * <p>
     * API name: {@code search_configuration_id}
     * </p>
     */
    @Nonnull
    public final String searchConfigurationId() {
        return this.searchConfigurationId;
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
     * Builder for {@link DeleteSearchConfigurationsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteSearchConfigurationsRequest> {
        private String searchConfigurationId;

        public Builder() {}

        private Builder(DeleteSearchConfigurationsRequest o) {
            super(o);
            this.searchConfigurationId = o.searchConfigurationId;
        }

        private Builder(Builder o) {
            super(o);
            this.searchConfigurationId = o.searchConfigurationId;
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
         * Required - The search configuration id
         * <p>
         * API name: {@code search_configuration_id}
         * </p>
         */
        @Nonnull
        public final Builder searchConfigurationId(String value) {
            this.searchConfigurationId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteSearchConfigurationsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteSearchConfigurationsRequest build() {
            _checkSingleUse();

            return new DeleteSearchConfigurationsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.delete_search_configurations}".
     */
    public static final Endpoint<DeleteSearchConfigurationsRequest, DeleteSearchConfigurationsResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "DELETE",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/search_configurations/");
                SimpleEndpoint.pathEncode(request.searchConfigurationId, buf);
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
            DeleteSearchConfigurationsResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.searchConfigurationId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteSearchConfigurationsRequest other = (DeleteSearchConfigurationsRequest) o;
        return this.searchConfigurationId.equals(other.searchConfigurationId);
    }
}
