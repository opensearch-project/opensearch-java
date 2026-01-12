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

// typedef: ml.delete_agentic_memory.Request

/**
 * Delete a specific memory by its type and ID.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteAgenticMemoryRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteAgenticMemoryRequest.Builder, DeleteAgenticMemoryRequest> {

    @Nonnull
    private final String id;

    @Nonnull
    private final String memoryContainerId;

    @Nonnull
    private final MemoryType type;

    // ---------------------------------------------------------------------------------------------

    private DeleteAgenticMemoryRequest(Builder builder) {
        super(builder);
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static DeleteAgenticMemoryRequest of(
        Function<DeleteAgenticMemoryRequest.Builder, ObjectBuilder<DeleteAgenticMemoryRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code memory_container_id}
     */
    @Nonnull
    public final String memoryContainerId() {
        return this.memoryContainerId;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final MemoryType type() {
        return this.type;
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
     * Builder for {@link DeleteAgenticMemoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteAgenticMemoryRequest> {
        private String id;
        private String memoryContainerId;
        private MemoryType type;

        public Builder() {}

        private Builder(DeleteAgenticMemoryRequest o) {
            super(o);
            this.id = o.id;
            this.memoryContainerId = o.memoryContainerId;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.id = o.id;
            this.memoryContainerId = o.memoryContainerId;
            this.type = o.type;
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
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
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
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(MemoryType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link DeleteAgenticMemoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteAgenticMemoryRequest build() {
            _checkSingleUse();

            return new DeleteAgenticMemoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_agentic_memory}".
     */
    public static final Endpoint<DeleteAgenticMemoryRequest, DeleteAgenticMemoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory_containers/");
            SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
            buf.append("/memories/");
            SimpleEndpoint.pathEncode(request.type.jsonValue(), buf);
            buf.append("/");
            SimpleEndpoint.pathEncode(request.id, buf);
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
        DeleteAgenticMemoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.memoryContainerId.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteAgenticMemoryRequest other = (DeleteAgenticMemoryRequest) o;
        return this.id.equals(other.id) && this.memoryContainerId.equals(other.memoryContainerId) && this.type.equals(other.type);
    }
}
