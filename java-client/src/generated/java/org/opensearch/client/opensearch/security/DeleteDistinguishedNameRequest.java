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

package org.opensearch.client.opensearch.security;

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

// typedef: security.delete_distinguished_name.Request

/**
 * Deletes all distinguished names in the specified cluster or node allowlist. Requires super admin or REST API permissions.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteDistinguishedNameRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteDistinguishedNameRequest.Builder, DeleteDistinguishedNameRequest> {

    @Nonnull
    private final String clusterName;

    // ---------------------------------------------------------------------------------------------

    private DeleteDistinguishedNameRequest(Builder builder) {
        super(builder);
        this.clusterName = ApiTypeHelper.requireNonNull(builder.clusterName, this, "clusterName");
    }

    public static DeleteDistinguishedNameRequest of(
        Function<DeleteDistinguishedNameRequest.Builder, ObjectBuilder<DeleteDistinguishedNameRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The cluster name to delete from list of distinguished names.
     * <p>
     * API name: {@code cluster_name}
     * </p>
     */
    @Nonnull
    public final String clusterName() {
        return this.clusterName;
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
     * Builder for {@link DeleteDistinguishedNameRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteDistinguishedNameRequest> {
        private String clusterName;

        public Builder() {}

        private Builder(DeleteDistinguishedNameRequest o) {
            super(o);
            this.clusterName = o.clusterName;
        }

        private Builder(Builder o) {
            super(o);
            this.clusterName = o.clusterName;
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
         * Required - The cluster name to delete from list of distinguished names.
         * <p>
         * API name: {@code cluster_name}
         * </p>
         */
        @Nonnull
        public final Builder clusterName(String value) {
            this.clusterName = value;
            return this;
        }

        /**
         * Builds a {@link DeleteDistinguishedNameRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteDistinguishedNameRequest build() {
            _checkSingleUse();

            return new DeleteDistinguishedNameRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.delete_distinguished_name}".
     */
    public static final Endpoint<DeleteDistinguishedNameRequest, DeleteDistinguishedNameResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "DELETE",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_security/api/nodesdn/");
                SimpleEndpoint.pathEncode(request.clusterName, buf);
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
            DeleteDistinguishedNameResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.clusterName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteDistinguishedNameRequest other = (DeleteDistinguishedNameRequest) o;
        return this.clusterName.equals(other.clusterName);
    }
}
