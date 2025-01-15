/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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

// typedef: ml.get_connector.Request

/**
 * Retrieves a standalone connector.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetConnectorRequest extends RequestBase implements ToCopyableBuilder<GetConnectorRequest.Builder, GetConnectorRequest> {

    @Nonnull
    private final String connectorId;

    // ---------------------------------------------------------------------------------------------

    private GetConnectorRequest(Builder builder) {
        super(builder);
        this.connectorId = ApiTypeHelper.requireNonNull(builder.connectorId, this, "connectorId");
    }

    public static GetConnectorRequest of(Function<GetConnectorRequest.Builder, ObjectBuilder<GetConnectorRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code connector_id}
     */
    @Nonnull
    public final String connectorId() {
        return this.connectorId;
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
     * Builder for {@link GetConnectorRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetConnectorRequest> {
        private String connectorId;

        public Builder() {}

        private Builder(GetConnectorRequest o) {
            super(o);
            this.connectorId = o.connectorId;
        }

        private Builder(Builder o) {
            super(o);
            this.connectorId = o.connectorId;
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
         * Required - API name: {@code connector_id}
         */
        @Nonnull
        public final Builder connectorId(String value) {
            this.connectorId = value;
            return this;
        }

        /**
         * Builds a {@link GetConnectorRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetConnectorRequest build() {
            _checkSingleUse();

            return new GetConnectorRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_connector}".
     */
    public static final Endpoint<GetConnectorRequest, GetConnectorResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/connectors/");
            SimpleEndpoint.pathEncode(request.connectorId, buf);
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
        GetConnectorResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.connectorId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetConnectorRequest other = (GetConnectorRequest) o;
        return this.connectorId.equals(other.connectorId);
    }
}
