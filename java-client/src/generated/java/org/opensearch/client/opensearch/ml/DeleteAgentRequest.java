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
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.delete_agent.Request

/**
 * Delete an agent.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DeleteAgentRequest extends RequestBase implements ToCopyableBuilder<DeleteAgentRequest.Builder, DeleteAgentRequest> {

    @Nonnull
    private final String agentId;

    // ---------------------------------------------------------------------------------------------

    private DeleteAgentRequest(Builder builder) {
        this.agentId = ApiTypeHelper.requireNonNull(builder.agentId, this, "agentId");
    }

    public static DeleteAgentRequest of(Function<DeleteAgentRequest.Builder, ObjectBuilder<DeleteAgentRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code agent_id}
     */
    @Nonnull
    public final String agentId() {
        return this.agentId;
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
     * Builder for {@link DeleteAgentRequest}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DeleteAgentRequest> {
        private String agentId;

        public Builder() {}

        private Builder(DeleteAgentRequest o) {
            this.agentId = o.agentId;
        }

        private Builder(Builder o) {
            this.agentId = o.agentId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code agent_id}
         */
        @Nonnull
        public final Builder agentId(String value) {
            this.agentId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteAgentRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteAgentRequest build() {
            _checkSingleUse();

            return new DeleteAgentRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_agent}".
     */
    public static final Endpoint<DeleteAgentRequest, DeleteAgentResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/agents/");
            SimpleEndpoint.pathEncode(request.agentId, buf);
            return buf.toString();
        },
        // Request parameters
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        false,
        DeleteAgentResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.agentId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteAgentRequest other = (DeleteAgentRequest) o;
        return this.agentId.equals(other.agentId);
    }
}
