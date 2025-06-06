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

// typedef: security.delete_role_mapping.Request

/**
 * Deletes the specified role mapping.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteRoleMappingRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteRoleMappingRequest.Builder, DeleteRoleMappingRequest> {

    @Nonnull
    private final String role;

    // ---------------------------------------------------------------------------------------------

    private DeleteRoleMappingRequest(Builder builder) {
        super(builder);
        this.role = ApiTypeHelper.requireNonNull(builder.role, this, "role");
    }

    public static DeleteRoleMappingRequest of(Function<DeleteRoleMappingRequest.Builder, ObjectBuilder<DeleteRoleMappingRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the role for which to delete the role's mappings.
     * <p>
     * API name: {@code role}
     * </p>
     */
    @Nonnull
    public final String role() {
        return this.role;
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
     * Builder for {@link DeleteRoleMappingRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DeleteRoleMappingRequest> {
        private String role;

        public Builder() {}

        private Builder(DeleteRoleMappingRequest o) {
            super(o);
            this.role = o.role;
        }

        private Builder(Builder o) {
            super(o);
            this.role = o.role;
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
         * Required - The name of the role for which to delete the role's mappings.
         * <p>
         * API name: {@code role}
         * </p>
         */
        @Nonnull
        public final Builder role(String value) {
            this.role = value;
            return this;
        }

        /**
         * Builds a {@link DeleteRoleMappingRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteRoleMappingRequest build() {
            _checkSingleUse();

            return new DeleteRoleMappingRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.delete_role_mapping}".
     */
    public static final Endpoint<DeleteRoleMappingRequest, DeleteRoleMappingResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_security/api/rolesmapping/");
            SimpleEndpoint.pathEncode(request.role, buf);
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
        DeleteRoleMappingResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.role.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteRoleMappingRequest other = (DeleteRoleMappingRequest) o;
        return this.role.equals(other.role);
    }
}
