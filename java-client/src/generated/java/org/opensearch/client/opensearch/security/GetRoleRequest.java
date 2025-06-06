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

// typedef: security.get_role.Request

/**
 * Retrieves one role.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetRoleRequest extends RequestBase implements ToCopyableBuilder<GetRoleRequest.Builder, GetRoleRequest> {

    @Nonnull
    private final String role;

    // ---------------------------------------------------------------------------------------------

    private GetRoleRequest(Builder builder) {
        super(builder);
        this.role = ApiTypeHelper.requireNonNull(builder.role, this, "role");
    }

    public static GetRoleRequest of(Function<GetRoleRequest.Builder, ObjectBuilder<GetRoleRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the role to retrieve.
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
     * Builder for {@link GetRoleRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetRoleRequest> {
        private String role;

        public Builder() {}

        private Builder(GetRoleRequest o) {
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
         * Required - The name of the role to retrieve.
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
         * Builds a {@link GetRoleRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetRoleRequest build() {
            _checkSingleUse();

            return new GetRoleRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.get_role}".
     */
    public static final Endpoint<GetRoleRequest, GetRoleResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_security/api/roles/");
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
        GetRoleResponse._DESERIALIZER
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
        GetRoleRequest other = (GetRoleRequest) o;
        return this.role.equals(other.role);
    }
}
