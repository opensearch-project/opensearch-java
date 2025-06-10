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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: security.get_node_certificates.Request

/**
 * Retrieves the specified node's security certificates.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetNodeCertificatesRequest extends RequestBase
    implements
        ToCopyableBuilder<GetNodeCertificatesRequest.Builder, GetNodeCertificatesRequest> {

    @Nullable
    private final String certType;

    @Nonnull
    private final String nodeId;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private GetNodeCertificatesRequest(Builder builder) {
        super(builder);
        this.certType = builder.certType;
        this.nodeId = ApiTypeHelper.requireNonNull(builder.nodeId, this, "nodeId");
        this.timeout = builder.timeout;
    }

    public static GetNodeCertificatesRequest of(
        Function<GetNodeCertificatesRequest.Builder, ObjectBuilder<GetNodeCertificatesRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The type of certificates (<code>HTTP</code>, <code>TRANSPORT</code>, or <code>ALL</code>) to retrieve from a node.
     * <p>
     * API name: {@code cert_type}
     * </p>
     */
    @Nullable
    public final String certType() {
        return this.certType;
    }

    /**
     * Required - The node ID to retrieve certificates for.
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nonnull
    public final String nodeId() {
        return this.nodeId;
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
     * Builder for {@link GetNodeCertificatesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetNodeCertificatesRequest> {
        @Nullable
        private String certType;
        private String nodeId;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(GetNodeCertificatesRequest o) {
            super(o);
            this.certType = o.certType;
            this.nodeId = o.nodeId;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.certType = o.certType;
            this.nodeId = o.nodeId;
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
         * The type of certificates (<code>HTTP</code>, <code>TRANSPORT</code>, or <code>ALL</code>) to retrieve from a node.
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
         * Required - The node ID to retrieve certificates for.
         * <p>
         * API name: {@code node_id}
         * </p>
         */
        @Nonnull
        public final Builder nodeId(String value) {
            this.nodeId = value;
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
         * Builds a {@link GetNodeCertificatesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetNodeCertificatesRequest build() {
            _checkSingleUse();

            return new GetNodeCertificatesRequest(this);
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
     * Endpoint "{@code security.get_node_certificates}".
     */
    public static final Endpoint<GetNodeCertificatesRequest, GetNodeCertificatesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_security/api/certificates/");
            SimpleEndpoint.pathEncode(request.nodeId, buf);
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
        GetNodeCertificatesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.certType);
        result = 31 * result + this.nodeId.hashCode();
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetNodeCertificatesRequest other = (GetNodeCertificatesRequest) o;
        return Objects.equals(this.certType, other.certType)
            && this.nodeId.equals(other.nodeId)
            && Objects.equals(this.timeout, other.timeout);
    }
}
