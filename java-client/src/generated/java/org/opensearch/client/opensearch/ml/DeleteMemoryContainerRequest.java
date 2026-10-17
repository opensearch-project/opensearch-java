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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.delete_memory_container.Request

/**
 * Delete a memory container.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteMemoryContainerRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteMemoryContainerRequest.Builder, DeleteMemoryContainerRequest> {

    @Nullable
    private final Boolean deleteAllMemories;

    @Nonnull
    private final List<MemoryType> deleteMemories;

    @Nonnull
    private final String memoryContainerId;

    // ---------------------------------------------------------------------------------------------

    private DeleteMemoryContainerRequest(Builder builder) {
        super(builder);
        this.deleteAllMemories = builder.deleteAllMemories;
        this.deleteMemories = ApiTypeHelper.unmodifiable(builder.deleteMemories);
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
    }

    public static DeleteMemoryContainerRequest of(
        Function<DeleteMemoryContainerRequest.Builder, ObjectBuilder<DeleteMemoryContainerRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code delete_all_memories}
     */
    @Nullable
    public final Boolean deleteAllMemories() {
        return this.deleteAllMemories;
    }

    /**
     * API name: {@code delete_memories}
     */
    @Nonnull
    public final List<MemoryType> deleteMemories() {
        return this.deleteMemories;
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
     * Builder for {@link DeleteMemoryContainerRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteMemoryContainerRequest> {
        @Nullable
        private Boolean deleteAllMemories;
        @Nullable
        private List<MemoryType> deleteMemories;
        private String memoryContainerId;

        public Builder() {}

        private Builder(DeleteMemoryContainerRequest o) {
            super(o);
            this.deleteAllMemories = o.deleteAllMemories;
            this.deleteMemories = _listCopy(o.deleteMemories);
            this.memoryContainerId = o.memoryContainerId;
        }

        private Builder(Builder o) {
            super(o);
            this.deleteAllMemories = o.deleteAllMemories;
            this.deleteMemories = _listCopy(o.deleteMemories);
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
         * API name: {@code delete_all_memories}
         */
        @Nonnull
        public final Builder deleteAllMemories(@Nullable Boolean value) {
            this.deleteAllMemories = value;
            return this;
        }

        /**
         * API name: {@code delete_memories}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>deleteMemories</code>.
         * </p>
         */
        @Nonnull
        public final Builder deleteMemories(List<MemoryType> list) {
            this.deleteMemories = _listAddAll(this.deleteMemories, list);
            return this;
        }

        /**
         * API name: {@code delete_memories}
         *
         * <p>
         * Adds one or more values to <code>deleteMemories</code>.
         * </p>
         */
        @Nonnull
        public final Builder deleteMemories(MemoryType value, MemoryType... values) {
            this.deleteMemories = _listAdd(this.deleteMemories, value, values);
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
         * Builds a {@link DeleteMemoryContainerRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteMemoryContainerRequest build() {
            _checkSingleUse();

            return new DeleteMemoryContainerRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.deleteAllMemories != null) {
            params.put("delete_all_memories", String.valueOf(this.deleteAllMemories));
        }
        if (ApiTypeHelper.isDefined(this.deleteMemories)) {
            params.put("delete_memories", this.deleteMemories.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
    }

    /**
     * Endpoint "{@code ml.delete_memory_container}".
     */
    public static final Endpoint<DeleteMemoryContainerRequest, DeleteMemoryContainerResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "DELETE",
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
            DeleteMemoryContainerResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.deleteAllMemories);
        result = 31 * result + Objects.hashCode(this.deleteMemories);
        result = 31 * result + this.memoryContainerId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteMemoryContainerRequest other = (DeleteMemoryContainerRequest) o;
        return Objects.equals(this.deleteAllMemories, other.deleteAllMemories)
            && Objects.equals(this.deleteMemories, other.deleteMemories)
            && this.memoryContainerId.equals(other.memoryContainerId);
    }
}
