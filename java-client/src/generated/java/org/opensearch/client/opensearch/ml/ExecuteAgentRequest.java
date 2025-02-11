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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
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

// typedef: ml.execute_agent.Request

/**
 * Execute an agent.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExecuteAgentRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExecuteAgentRequest.Builder, ExecuteAgentRequest> {

    @Nonnull
    private final String agentId;

    @Nonnull
    private final Map<String, JsonData> parameters;

    @Nullable
    private final Boolean parametersVerbose;

    // ---------------------------------------------------------------------------------------------

    private ExecuteAgentRequest(Builder builder) {
        super(builder);
        this.agentId = ApiTypeHelper.requireNonNull(builder.agentId, this, "agentId");
        this.parameters = ApiTypeHelper.unmodifiableRequired(builder.parameters, this, "parameters");
        this.parametersVerbose = builder.parametersVerbose;
    }

    public static ExecuteAgentRequest of(Function<ExecuteAgentRequest.Builder, ObjectBuilder<ExecuteAgentRequest>> fn) {
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
    public final Map<String, JsonData> parameters() {
        return this.parameters;
    }

    /**
     * Whether to provide verbose output.
     * <p>
     * API name: {@code parameters.verbose}
     * </p>
     */
    @Nullable
    public final Boolean parametersVerbose() {
        return this.parametersVerbose;
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
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();

        if (this.parametersVerbose != null) {
            generator.writeKey("parameters.verbose");
            generator.write(this.parametersVerbose);
        }
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
     * Builder for {@link ExecuteAgentRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ExecuteAgentRequest> {
        private String agentId;
        private Map<String, JsonData> parameters;
        @Nullable
        private Boolean parametersVerbose;

        public Builder() {}

        private Builder(ExecuteAgentRequest o) {
            super(o);
            this.agentId = o.agentId;
            this.parameters = _mapCopy(o.parameters);
            this.parametersVerbose = o.parametersVerbose;
        }

        private Builder(Builder o) {
            super(o);
            this.agentId = o.agentId;
            this.parameters = _mapCopy(o.parameters);
            this.parametersVerbose = o.parametersVerbose;
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
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(Map<String, JsonData> map) {
            this.parameters = _mapPutAll(this.parameters, map);
            return this;
        }

        /**
         * Required - API name: {@code parameters}
         *
         * <p>
         * Adds an entry to <code>parameters</code>.
         * </p>
         */
        @Nonnull
        public final Builder parameters(String key, JsonData value) {
            this.parameters = _mapPut(this.parameters, key, value);
            return this;
        }

        /**
         * Whether to provide verbose output.
         * <p>
         * API name: {@code parameters.verbose}
         * </p>
         */
        @Nonnull
        public final Builder parametersVerbose(@Nullable Boolean value) {
            this.parametersVerbose = value;
            return this;
        }

        /**
         * Builds a {@link ExecuteAgentRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteAgentRequest build() {
            _checkSingleUse();

            return new ExecuteAgentRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteAgentRequest}
     */
    public static final JsonpDeserializer<ExecuteAgentRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteAgentRequest::setupExecuteAgentRequestDeserializer
    );

    protected static void setupExecuteAgentRequestDeserializer(ObjectDeserializer<ExecuteAgentRequest.Builder> op) {
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
        op.add(Builder::parametersVerbose, JsonpDeserializer.booleanDeserializer(), "parameters.verbose");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.execute_agent}".
     */
    public static final Endpoint<ExecuteAgentRequest, ExecuteAgentResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/agents/");
            SimpleEndpoint.pathEncode(request.agentId, buf);
            buf.append("/_execute");
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
        ExecuteAgentResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.agentId.hashCode();
        result = 31 * result + this.parameters.hashCode();
        result = 31 * result + Objects.hashCode(this.parametersVerbose);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExecuteAgentRequest other = (ExecuteAgentRequest) o;
        return this.agentId.equals(other.agentId)
            && this.parameters.equals(other.parameters)
            && Objects.equals(this.parametersVerbose, other.parametersVerbose);
    }
}
