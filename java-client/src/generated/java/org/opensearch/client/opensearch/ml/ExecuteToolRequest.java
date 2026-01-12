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

// typedef: ml.execute_tool.Request

/**
 * Execute a tool.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ExecuteToolRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ExecuteToolRequest.Builder, ExecuteToolRequest> {

    @Nonnull
    private final Map<String, JsonData> parameters;

    @Nonnull
    private final ToolName toolName;

    // ---------------------------------------------------------------------------------------------

    private ExecuteToolRequest(Builder builder) {
        super(builder);
        this.parameters = ApiTypeHelper.unmodifiable(builder.parameters);
        this.toolName = ApiTypeHelper.requireNonNull(builder.toolName, this, "toolName");
    }

    public static ExecuteToolRequest of(Function<ExecuteToolRequest.Builder, ObjectBuilder<ExecuteToolRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code parameters}
     */
    @Nonnull
    public final Map<String, JsonData> parameters() {
        return this.parameters;
    }

    /**
     * Required - API name: {@code tool_name}
     */
    @Nonnull
    public final ToolName toolName() {
        return this.toolName;
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
        if (ApiTypeHelper.isDefined(this.parameters)) {
            generator.writeKey("parameters");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.parameters.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link ExecuteToolRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ExecuteToolRequest> {
        @Nullable
        private Map<String, JsonData> parameters;
        private ToolName toolName;

        public Builder() {}

        private Builder(ExecuteToolRequest o) {
            super(o);
            this.parameters = _mapCopy(o.parameters);
            this.toolName = o.toolName;
        }

        private Builder(Builder o) {
            super(o);
            this.parameters = _mapCopy(o.parameters);
            this.toolName = o.toolName;
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
         * API name: {@code parameters}
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
         * API name: {@code parameters}
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
         * Required - API name: {@code tool_name}
         */
        @Nonnull
        public final Builder toolName(ToolName value) {
            this.toolName = value;
            return this;
        }

        /**
         * Builds a {@link ExecuteToolRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ExecuteToolRequest build() {
            _checkSingleUse();

            return new ExecuteToolRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ExecuteToolRequest}
     */
    public static final JsonpDeserializer<ExecuteToolRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ExecuteToolRequest::setupExecuteToolRequestDeserializer
    );

    protected static void setupExecuteToolRequestDeserializer(ObjectDeserializer<ExecuteToolRequest.Builder> op) {
        op.add(Builder::parameters, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "parameters");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.execute_tool}".
     */
    public static final Endpoint<ExecuteToolRequest, ExecuteToolResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/tools/_execute/");
            SimpleEndpoint.pathEncode(request.toolName.jsonValue(), buf);
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
        ExecuteToolResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.parameters);
        result = 31 * result + this.toolName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ExecuteToolRequest other = (ExecuteToolRequest) o;
        return Objects.equals(this.parameters, other.parameters) && this.toolName.equals(other.toolName);
    }
}
