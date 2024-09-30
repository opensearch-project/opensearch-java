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

import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.delete_connector.Request

/**
 * Deletes a standalone connector.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteConnectorRequest extends RequestBase {

    private final String connectorId;

    // ---------------------------------------------------------------------------------------------

    private DeleteConnectorRequest(Builder builder) {
        this.connectorId = ApiTypeHelper.requireNonNull(builder.connectorId, this, "connectorId");
    }

    public static DeleteConnectorRequest of(Function<DeleteConnectorRequest.Builder, ObjectBuilder<DeleteConnectorRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code connector_id}
     */
    public final String connectorId() {
        return this.connectorId;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link DeleteConnectorRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<DeleteConnectorRequest> {
        private String connectorId;

        /**
         * Required - API name: {@code connector_id}
         */
        public final Builder connectorId(String value) {
            this.connectorId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteConnectorRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public DeleteConnectorRequest build() {
            _checkSingleUse();

            return new DeleteConnectorRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_connector}".
     */
    public static final Endpoint<DeleteConnectorRequest, DeleteConnectorResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/connectors/");
            SimpleEndpoint.pathEncode(request.connectorId, buf);
            return buf.toString();
        },
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        false,
        DeleteConnectorResponse._DESERIALIZER
    );

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.connectorId.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        DeleteConnectorRequest other = (DeleteConnectorRequest) o;
        return Objects.equals(this.connectorId, other.connectorId);
    }
}
