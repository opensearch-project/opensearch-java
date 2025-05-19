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

// typedef: ml.get_stats.Request

/**
 * Get stats.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetStatsRequest extends RequestBase implements ToCopyableBuilder<GetStatsRequest.Builder, GetStatsRequest> {

    @Nullable
    private final String nodeId;

    @Nullable
    private final String stat;

    // ---------------------------------------------------------------------------------------------

    private GetStatsRequest(Builder builder) {
        super(builder);
        this.nodeId = builder.nodeId;
        this.stat = builder.stat;
    }

    public static GetStatsRequest of(Function<GetStatsRequest.Builder, ObjectBuilder<GetStatsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code node_id}
     */
    @Nullable
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * API name: {@code stat}
     */
    @Nullable
    public final String stat() {
        return this.stat;
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
     * Builder for {@link GetStatsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetStatsRequest> {
        @Nullable
        private String nodeId;
        @Nullable
        private String stat;

        public Builder() {}

        private Builder(GetStatsRequest o) {
            super(o);
            this.nodeId = o.nodeId;
            this.stat = o.stat;
        }

        private Builder(Builder o) {
            super(o);
            this.nodeId = o.nodeId;
            this.stat = o.stat;
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
         * API name: {@code node_id}
         */
        @Nonnull
        public final Builder nodeId(@Nullable String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * API name: {@code stat}
         */
        @Nonnull
        public final Builder stat(@Nullable String value) {
            this.stat = value;
            return this;
        }

        /**
         * Builds a {@link GetStatsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStatsRequest build() {
            _checkSingleUse();

            return new GetStatsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_stats}".
     */
    public static final Endpoint<GetStatsRequest, GetStatsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _nodeId = 1 << 0;
            final int _stat = 1 << 1;

            int propsSet = 0;

            if (request.nodeId() != null) propsSet |= _nodeId;
            if (request.stat() != null) propsSet |= _stat;

            if (propsSet == 0) {
                return "/_plugins/_ml/stats";
            }
            if (propsSet == (_nodeId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/");
                SimpleEndpoint.pathEncode(request.nodeId, buf);
                buf.append("/stats");
                return buf.toString();
            }
            if (propsSet == (_nodeId | _stat)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/");
                SimpleEndpoint.pathEncode(request.nodeId, buf);
                buf.append("/stats/");
                SimpleEndpoint.pathEncode(request.stat, buf);
                return buf.toString();
            }
            if (propsSet == (_stat)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/stats/");
                SimpleEndpoint.pathEncode(request.stat, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetStatsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.stat);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStatsRequest other = (GetStatsRequest) o;
        return Objects.equals(this.nodeId, other.nodeId) && Objects.equals(this.stat, other.stat);
    }
}
