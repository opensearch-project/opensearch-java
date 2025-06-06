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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.reload_http_certificates.Request

/**
 * Reloads the HTTP communication certificates.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ReloadHttpCertificatesRequest extends RequestBase
    implements
        ToCopyableBuilder<ReloadHttpCertificatesRequest.Builder, ReloadHttpCertificatesRequest> {

    // ---------------------------------------------------------------------------------------------

    private ReloadHttpCertificatesRequest(Builder builder) {
        super(builder);
    }

    public static ReloadHttpCertificatesRequest of(
        Function<ReloadHttpCertificatesRequest.Builder, ObjectBuilder<ReloadHttpCertificatesRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
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
     * Builder for {@link ReloadHttpCertificatesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ReloadHttpCertificatesRequest> {

        public Builder() {}

        private Builder(ReloadHttpCertificatesRequest o) {
            super(o);
        }

        private Builder(Builder o) {
            super(o);
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
         * Builds a {@link ReloadHttpCertificatesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ReloadHttpCertificatesRequest build() {
            _checkSingleUse();

            return new ReloadHttpCertificatesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.reload_http_certificates}".
     */
    public static final Endpoint<ReloadHttpCertificatesRequest, ReloadHttpCertificatesResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> "/_plugins/_security/api/ssl/http/reloadcerts",
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            false,
            ReloadHttpCertificatesResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return true;
    }
}
