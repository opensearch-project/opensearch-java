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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_all_memories.Request

/**
 * Get all memories.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetAllMemoriesRequest extends RequestBase
    implements
        ToCopyableBuilder<GetAllMemoriesRequest.Builder, GetAllMemoriesRequest> {

    @Nullable
    private final Integer maxResults;

    @Nullable
    private final Integer nextToken;

    // ---------------------------------------------------------------------------------------------

    private GetAllMemoriesRequest(Builder builder) {
        super(builder);
        this.maxResults = builder.maxResults;
        this.nextToken = builder.nextToken;
    }

    public static GetAllMemoriesRequest of(Function<GetAllMemoriesRequest.Builder, ObjectBuilder<GetAllMemoriesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The maximum number of results to return. If there are fewer memories than the number set in <code>max_results</code>, the response
     * returns only the number of memories that exist. Default is <code>10</code>.
     * <p>
     * API name: {@code max_results}
     * </p>
     */
    @Nullable
    public final Integer maxResults() {
        return this.maxResults;
    }

    /**
     * The index of the first memory in the sorted list of memories to return. Memories are ordered by <code>create_time</code>. For
     * example, if memories <code>A</code>, <code>B</code>, and <code>C</code> exist, <code>next_token=1</code> returns memories
     * <code>B</code> and <code>C</code>. Default is <code>0</code> (return all memories).
     * <p>
     * API name: {@code next_token}
     * </p>
     */
    @Nullable
    public final Integer nextToken() {
        return this.nextToken;
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
     * Builder for {@link GetAllMemoriesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetAllMemoriesRequest> {
        @Nullable
        private Integer maxResults;
        @Nullable
        private Integer nextToken;

        public Builder() {}

        private Builder(GetAllMemoriesRequest o) {
            super(o);
            this.maxResults = o.maxResults;
            this.nextToken = o.nextToken;
        }

        private Builder(Builder o) {
            super(o);
            this.maxResults = o.maxResults;
            this.nextToken = o.nextToken;
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
         * The maximum number of results to return. If there are fewer memories than the number set in <code>max_results</code>, the
         * response returns only the number of memories that exist. Default is <code>10</code>.
         * <p>
         * API name: {@code max_results}
         * </p>
         */
        @Nonnull
        public final Builder maxResults(@Nullable Integer value) {
            this.maxResults = value;
            return this;
        }

        /**
         * The index of the first memory in the sorted list of memories to return. Memories are ordered by <code>create_time</code>. For
         * example, if memories <code>A</code>, <code>B</code>, and <code>C</code> exist, <code>next_token=1</code> returns memories
         * <code>B</code> and <code>C</code>. Default is <code>0</code> (return all memories).
         * <p>
         * API name: {@code next_token}
         * </p>
         */
        @Nonnull
        public final Builder nextToken(@Nullable Integer value) {
            this.nextToken = value;
            return this;
        }

        /**
         * Builds a {@link GetAllMemoriesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllMemoriesRequest build() {
            _checkSingleUse();

            return new GetAllMemoriesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.maxResults != null) {
            params.put("max_results", String.valueOf(this.maxResults));
        }
        if (this.nextToken != null) {
            params.put("next_token", String.valueOf(this.nextToken));
        }
    }

    /**
     * Endpoint "{@code ml.get_all_memories}".
     */
    public static final Endpoint<GetAllMemoriesRequest, GetAllMemoriesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_plugins/_ml/memory",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetAllMemoriesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxResults);
        result = 31 * result + Objects.hashCode(this.nextToken);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAllMemoriesRequest other = (GetAllMemoriesRequest) o;
        return Objects.equals(this.maxResults, other.maxResults) && Objects.equals(this.nextToken, other.nextToken);
    }
}
