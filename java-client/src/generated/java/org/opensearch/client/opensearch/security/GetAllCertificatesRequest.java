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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.get_all_certificates.Request

/**
 * Retrieves the cluster security certificates.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetAllCertificatesRequest extends RequestBase
    implements
        ToCopyableBuilder<GetAllCertificatesRequest.Builder, GetAllCertificatesRequest> {

    @Nullable
    private final String certType;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private GetAllCertificatesRequest(Builder builder) {
        super(builder);
        this.certType = builder.certType;
        this.timeout = builder.timeout;
    }

    public static GetAllCertificatesRequest of(Function<GetAllCertificatesRequest.Builder, ObjectBuilder<GetAllCertificatesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The type of certificates (<code>HTTP</code>, <code>TRANSPORT</code>, or <code>ALL</code>) to retrieve from all nodes.
     * <p>
     * API name: {@code cert_type}
     * </p>
     */
    @Nullable
    public final String certType() {
        return this.certType;
    }

    /**
     * The maximum duration, in seconds, to spend retrieving certificates from all nodes before a timeout.
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
     * Builder for {@link GetAllCertificatesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetAllCertificatesRequest> {
        @Nullable
        private String certType;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(GetAllCertificatesRequest o) {
            super(o);
            this.certType = o.certType;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.certType = o.certType;
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
         * The type of certificates (<code>HTTP</code>, <code>TRANSPORT</code>, or <code>ALL</code>) to retrieve from all nodes.
         * <p>
         * API name: {@code cert_type}
         * </p>
         */
        @Nonnull
        public final Builder certType(@Nullable String value) {
            this.certType = value;
            return this;
        }

        /**
         * The maximum duration, in seconds, to spend retrieving certificates from all nodes before a timeout.
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
         * The maximum duration, in seconds, to spend retrieving certificates from all nodes before a timeout.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link GetAllCertificatesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllCertificatesRequest build() {
            _checkSingleUse();

            return new GetAllCertificatesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.certType != null) {
            params.put("cert_type", this.certType);
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code security.get_all_certificates}".
     */
    public static final Endpoint<GetAllCertificatesRequest, GetAllCertificatesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_plugins/_security/api/certificates",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetAllCertificatesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.certType);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAllCertificatesRequest other = (GetAllCertificatesRequest) o;
        return Objects.equals(this.certType, other.certType) && Objects.equals(this.timeout, other.timeout);
    }
}
