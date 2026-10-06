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

// typedef: ml.get_memory_container.Request

/**
 * Get a memory container.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetMemoryContainerRequest extends RequestBase
    implements
        ToCopyableBuilder<GetMemoryContainerRequest.Builder, GetMemoryContainerRequest> {

    @Nonnull
    private final String memoryContainerId;

    // ---------------------------------------------------------------------------------------------

    private GetMemoryContainerRequest(Builder builder) {
        super(builder);
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
    }

    public static GetMemoryContainerRequest of(Function<GetMemoryContainerRequest.Builder, ObjectBuilder<GetMemoryContainerRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memory_container_id}
     */
    @Nonnull
    public final String memoryContainerId() {
        return this.memoryContainerId;
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
     * Builder for {@link GetMemoryContainerRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetMemoryContainerRequest> {
        private String memoryContainerId;

        public Builder() {}

        private Builder(GetMemoryContainerRequest o) {
            super(o);
            this.memoryContainerId = o.memoryContainerId;
        }

        private Builder(Builder o) {
            super(o);
            this.memoryContainerId = o.memoryContainerId;
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
         * Required - API name: {@code memory_container_id}
         */
        @Nonnull
        public final Builder memoryContainerId(String value) {
            this.memoryContainerId = value;
            return this;
        }

        /**
         * Builds a {@link GetMemoryContainerRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMemoryContainerRequest build() {
            _checkSingleUse();

            return new GetMemoryContainerRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_memory_container}".
     */
    public static final Endpoint<GetMemoryContainerRequest, GetMemoryContainerResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory_containers/");
            SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
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
        GetMemoryContainerResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memoryContainerId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetMemoryContainerRequest other = (GetMemoryContainerRequest) o;
        return this.memoryContainerId.equals(other.memoryContainerId);
    }
}
