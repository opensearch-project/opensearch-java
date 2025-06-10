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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.authinfo.Request

/**
 * Returns or updates authentication information for the currently authenticated user.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class AuthinfoRequest extends RequestBase implements ToCopyableBuilder<AuthinfoRequest.Builder, AuthinfoRequest> {

    @Nullable
    private final String authType;

    @Nullable
    private final Boolean verbose;

    // ---------------------------------------------------------------------------------------------

    private AuthinfoRequest(Builder builder) {
        super(builder);
        this.authType = builder.authType;
        this.verbose = builder.verbose;
    }

    public static AuthinfoRequest of(Function<AuthinfoRequest.Builder, ObjectBuilder<AuthinfoRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The type of the current authentication request.
     * <p>
     * API name: {@code auth_type}
     * </p>
     */
    @Nullable
    public final String authType() {
        return this.authType;
    }

    /**
     * Whether to return a verbose response.
     * <p>
     * API name: {@code verbose}
     * </p>
     */
    @Nullable
    public final Boolean verbose() {
        return this.verbose;
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
     * Builder for {@link AuthinfoRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, AuthinfoRequest> {
        @Nullable
        private String authType;
        @Nullable
        private Boolean verbose;

        public Builder() {}

        private Builder(AuthinfoRequest o) {
            super(o);
            this.authType = o.authType;
            this.verbose = o.verbose;
        }

        private Builder(Builder o) {
            super(o);
            this.authType = o.authType;
            this.verbose = o.verbose;
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
         * The type of the current authentication request.
         * <p>
         * API name: {@code auth_type}
         * </p>
         */
        @Nonnull
        public final Builder authType(@Nullable String value) {
            this.authType = value;
            return this;
        }

        /**
         * Whether to return a verbose response.
         * <p>
         * API name: {@code verbose}
         * </p>
         */
        @Nonnull
        public final Builder verbose(@Nullable Boolean value) {
            this.verbose = value;
            return this;
        }

        /**
         * Builds a {@link AuthinfoRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AuthinfoRequest build() {
            _checkSingleUse();

            return new AuthinfoRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.authType != null) {
            params.put("auth_type", this.authType);
        }
        if (this.verbose != null) {
            params.put("verbose", String.valueOf(this.verbose));
        }
    }

    /**
     * Endpoint "{@code security.authinfo}".
     */
    public static final Endpoint<AuthinfoRequest, AuthinfoResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_security/authinfo",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        AuthinfoResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.authType);
        result = 31 * result + Objects.hashCode(this.verbose);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AuthinfoRequest other = (AuthinfoRequest) o;
        return Objects.equals(this.authType, other.authType) && Objects.equals(this.verbose, other.verbose);
    }
}
