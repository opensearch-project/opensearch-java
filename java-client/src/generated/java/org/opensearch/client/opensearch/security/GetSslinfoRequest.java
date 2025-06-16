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

// typedef: security.get_sslinfo.Request

/**
 * Retrieves information about the SSL configuration.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetSslinfoRequest extends RequestBase implements ToCopyableBuilder<GetSslinfoRequest.Builder, GetSslinfoRequest> {

    @Nullable
    private final Boolean showDn;

    // ---------------------------------------------------------------------------------------------

    private GetSslinfoRequest(Builder builder) {
        super(builder);
        this.showDn = builder.showDn;
    }

    public static GetSslinfoRequest of(Function<GetSslinfoRequest.Builder, ObjectBuilder<GetSslinfoRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to include all domain names in the response.
     * <p>
     * API name: {@code show_dn}
     * </p>
     */
    @Nullable
    public final Boolean showDn() {
        return this.showDn;
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
     * Builder for {@link GetSslinfoRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetSslinfoRequest> {
        @Nullable
        private Boolean showDn;

        public Builder() {}

        private Builder(GetSslinfoRequest o) {
            super(o);
            this.showDn = o.showDn;
        }

        private Builder(Builder o) {
            super(o);
            this.showDn = o.showDn;
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
         * Whether to include all domain names in the response.
         * <p>
         * API name: {@code show_dn}
         * </p>
         */
        @Nonnull
        public final Builder showDn(@Nullable Boolean value) {
            this.showDn = value;
            return this;
        }

        /**
         * Builds a {@link GetSslinfoRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetSslinfoRequest build() {
            _checkSingleUse();

            return new GetSslinfoRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.showDn != null) {
            params.put("show_dn", String.valueOf(this.showDn));
        }
    }

    /**
     * Endpoint "{@code security.get_sslinfo}".
     */
    public static final Endpoint<GetSslinfoRequest, GetSslinfoResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_opendistro/_security/sslinfo",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetSslinfoResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.showDn);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetSslinfoRequest other = (GetSslinfoRequest) o;
        return Objects.equals(this.showDn, other.showDn);
    }
}
