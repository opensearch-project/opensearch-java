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

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.execute_agent_stream.Request

/**
 * Execute an agent in streaming mode.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExecuteAgentStreamRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExecuteAgentStreamRequest.Builder, ExecuteAgentStreamRequest> {

    @Nonnull
    private final String agentId;

    @Nonnull
    private final Parameters parameters;

    // ---------------------------------------------------------------------------------------------

    private ExecuteAgentStreamRequest(Builder builder) {
        super(builder);
        this.agentId = ApiTypeHelper.requireNonNull(builder.agentId, this, "agentId");
        this.parameters = ApiTypeHelper.requireNonNull(builder.parameters, this, "parameters");
    }

    public static ExecuteAgentStreamRequest of(Function<ExecuteAgentStreamRequest.Builder, ObjectBuilder<ExecuteAgentStreamRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code agent_id}
     */
    @Nonnull
    public final String agentId() {
        return this.agentId;
    }

    /**
     * Required - API name: {@code parameters}
     */
    @Nonnull
    public final Parameters parameters() {
        return this.parameters;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("parameters");
        this.parameters.serialize(generator, mapper);
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
     * Builder for {@link ExecuteAgentStreamRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, ExecuteAgentStreamRequest> {
        private String agentId;
        private Parameters parameters;

        public Builder() {}

        private Builder(ExecuteAgentStreamRequest o) {
            super(o);
            this.agentId = o.agentId;
            this.parameters = o.parameters;
        }

        private Builder(Builder o) {
            super(o);
            this.agentId = o.agentId;
            this.parameters = o.parameters;
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
         * Required - API name: {@code agent_id}
         */
        @Nonnull
        public final Builder agentId(String value) {
            this.agentId = value;
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(Parameters value) {
            this.parameters = value;
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         */
        @Nonnull
        public final Builder parameters(Function<Parameters.Builder, ObjectBuilder<Parameters>> fn) {
            return parameters(fn.apply(new Parameters.Builder()).build());
        }

        /**
         * Builds a {@link ExecuteAgentStreamRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteAgentStreamRequest build() {
            _checkSingleUse();

            return new ExecuteAgentStreamRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteAgentStreamRequest}
     */
    public static final JsonpDeserializer<ExecuteAgentStreamRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteAgentStreamRequest::setupExecuteAgentStreamRequestDeserializer
    );

    protected static void setupExecuteAgentStreamRequestDeserializer(ObjectDeserializer<ExecuteAgentStreamRequest.Builder> op) {
        op.add(Builder::parameters, Parameters._DESERIALIZER, "parameters");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.execute_agent_stream}".
     */
    public static final Endpoint<ExecuteAgentStreamRequest, ExecuteAgentStreamResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/agents/");
            SimpleEndpoint.pathEncode(request.agentId, buf);
            buf.append("/_execute/stream");
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        ExecuteAgentStreamResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.agentId.hashCode();
        result = 31 * result + this.parameters.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExecuteAgentStreamRequest other = (ExecuteAgentStreamRequest) o;
        return this.agentId.equals(other.agentId) && this.parameters.equals(other.parameters);
    }
}
