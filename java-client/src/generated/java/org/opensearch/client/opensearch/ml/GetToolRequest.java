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

// typedef: ml.get_tool.Request

/**
 * Get tools.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetToolRequest extends RequestBase implements ToCopyableBuilder<GetToolRequest.Builder, GetToolRequest> {

    @Nonnull
    private final String toolName;

    // ---------------------------------------------------------------------------------------------

    private GetToolRequest(Builder builder) {
        super(builder);
        this.toolName = ApiTypeHelper.requireNonNull(builder.toolName, this, "toolName");
    }

    public static GetToolRequest of(Function<GetToolRequest.Builder, ObjectBuilder<GetToolRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code tool_name}
     */
    @Nonnull
    public final String toolName() {
        return this.toolName;
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
     * Builder for {@link GetToolRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetToolRequest> {
        private String toolName;

        public Builder() {}

        private Builder(GetToolRequest o) {
            super(o);
            this.toolName = o.toolName;
        }

        private Builder(Builder o) {
            super(o);
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
         * Required - API name: {@code tool_name}
         */
        @Nonnull
        public final Builder toolName(String value) {
            this.toolName = value;
            return this;
        }

        /**
         * Builds a {@link GetToolRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetToolRequest build() {
            _checkSingleUse();

            return new GetToolRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_tool}".
     */
    public static final Endpoint<GetToolRequest, GetToolResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/tools/");
            SimpleEndpoint.pathEncode(request.toolName, buf);
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
        GetToolResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.toolName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetToolRequest other = (GetToolRequest) o;
        return this.toolName.equals(other.toolName);
    }
}
