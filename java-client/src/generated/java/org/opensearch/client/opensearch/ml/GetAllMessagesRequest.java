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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_all_messages.Request

/**
 * Get all messages in a memory.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetAllMessagesRequest extends RequestBase
    implements
        ToCopyableBuilder<GetAllMessagesRequest.Builder, GetAllMessagesRequest> {

    @Nullable
    private final Integer maxResults;

    @Nonnull
    private final String memoryId;

    @Nullable
    private final Integer nextToken;

    // ---------------------------------------------------------------------------------------------

    private GetAllMessagesRequest(Builder builder) {
        super(builder);
        this.maxResults = builder.maxResults;
        this.memoryId = ApiTypeHelper.requireNonNull(builder.memoryId, this, "memoryId");
        this.nextToken = builder.nextToken;
    }

    public static GetAllMessagesRequest of(Function<GetAllMessagesRequest.Builder, ObjectBuilder<GetAllMessagesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_results}
     */
    @Nullable
    public final Integer maxResults() {
        return this.maxResults;
    }

    /**
     * Required - API name: {@code memory_id}
     */
    @Nonnull
    public final String memoryId() {
        return this.memoryId;
    }

    /**
     * API name: {@code next_token}
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
     * Builder for {@link GetAllMessagesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetAllMessagesRequest> {
        @Nullable
        private Integer maxResults;
        private String memoryId;
        @Nullable
        private Integer nextToken;

        public Builder() {}

        private Builder(GetAllMessagesRequest o) {
            super(o);
            this.maxResults = o.maxResults;
            this.memoryId = o.memoryId;
            this.nextToken = o.nextToken;
        }

        private Builder(Builder o) {
            super(o);
            this.maxResults = o.maxResults;
            this.memoryId = o.memoryId;
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
         * API name: {@code max_results}
         */
        @Nonnull
        public final Builder maxResults(@Nullable Integer value) {
            this.maxResults = value;
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
         * API name: {@code next_token}
         */
        @Nonnull
        public final Builder nextToken(@Nullable Integer value) {
            this.nextToken = value;
            return this;
        }

        /**
         * Builds a {@link GetAllMessagesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllMessagesRequest build() {
            _checkSingleUse();

            return new GetAllMessagesRequest(this);
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
     * Endpoint "{@code ml.get_all_messages}".
     */
    public static final Endpoint<GetAllMessagesRequest, GetAllMessagesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory/");
            SimpleEndpoint.pathEncode(request.memoryId, buf);
            buf.append("/messages");
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
        GetAllMessagesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxResults);
        result = 31 * result + this.memoryId.hashCode();
        result = 31 * result + Objects.hashCode(this.nextToken);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAllMessagesRequest other = (GetAllMessagesRequest) o;
        return Objects.equals(this.maxResults, other.maxResults)
            && this.memoryId.equals(other.memoryId)
            && Objects.equals(this.nextToken, other.nextToken);
    }
}
