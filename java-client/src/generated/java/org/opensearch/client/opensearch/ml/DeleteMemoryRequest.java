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

// typedef: ml.delete_memory.Request

/**
 * Delete a memory.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteMemoryRequest extends RequestBase implements ToCopyableBuilder<DeleteMemoryRequest.Builder, DeleteMemoryRequest> {

    @Nonnull
    private final String memoryId;

    // ---------------------------------------------------------------------------------------------

    private DeleteMemoryRequest(Builder builder) {
        super(builder);
        this.memoryId = ApiTypeHelper.requireNonNull(builder.memoryId, this, "memoryId");
    }

    public static DeleteMemoryRequest of(Function<DeleteMemoryRequest.Builder, ObjectBuilder<DeleteMemoryRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memory_id}
     */
    @Nonnull
    public final String memoryId() {
        return this.memoryId;
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
     * Builder for {@link DeleteMemoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DeleteMemoryRequest> {
        private String memoryId;

        public Builder() {}

        private Builder(DeleteMemoryRequest o) {
            super(o);
            this.memoryId = o.memoryId;
        }

        private Builder(Builder o) {
            super(o);
            this.memoryId = o.memoryId;
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
         * Required - API name: {@code memory_id}
         */
        @Nonnull
        public final Builder memoryId(String value) {
            this.memoryId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteMemoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteMemoryRequest build() {
            _checkSingleUse();

            return new DeleteMemoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_memory}".
     */
    public static final Endpoint<DeleteMemoryRequest, DeleteMemoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory/");
            SimpleEndpoint.pathEncode(request.memoryId, buf);
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
        DeleteMemoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memoryId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteMemoryRequest other = (DeleteMemoryRequest) o;
        return this.memoryId.equals(other.memoryId);
    }
}
