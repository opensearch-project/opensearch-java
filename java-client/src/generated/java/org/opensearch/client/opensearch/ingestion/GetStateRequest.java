/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ingestion;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ingestion.get_state.Request

/**
 * Use this API to retrieve the ingestion state for a given index.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetStateRequest extends RequestBase implements ToCopyableBuilder<GetStateRequest.Builder, GetStateRequest> {

    @Nonnull
    private final String index;

    @Nullable
    private final String nextToken;

    @Nullable
    private final Integer size;

    @Nullable
    private final Time timeout;

    // ---------------------------------------------------------------------------------------------

    private GetStateRequest(Builder builder) {
        super(builder);
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.nextToken = builder.nextToken;
        this.size = builder.size;
        this.timeout = builder.timeout;
    }

    public static GetStateRequest of(Function<GetStateRequest.Builder, ObjectBuilder<GetStateRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Index for which ingestion state should be retrieved.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Token to retrieve the next page of results.
     * <p>
     * API name: {@code next_token}
     * </p>
     */
    @Nullable
    public final String nextToken() {
        return this.nextToken;
    }

    /**
     * Number of results to return per page.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * Timeout for the request.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
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
     * Builder for {@link GetStateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetStateRequest> {
        private String index;
        @Nullable
        private String nextToken;
        @Nullable
        private Integer size;
        @Nullable
        private Time timeout;

        public Builder() {}

        private Builder(GetStateRequest o) {
            super(o);
            this.index = o.index;
            this.nextToken = o.nextToken;
            this.size = o.size;
            this.timeout = o.timeout;
        }

        private Builder(Builder o) {
            super(o);
            this.index = o.index;
            this.nextToken = o.nextToken;
            this.size = o.size;
            this.timeout = o.timeout;
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
         * Required - Index for which ingestion state should be retrieved.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Token to retrieve the next page of results.
         * <p>
         * API name: {@code next_token}
         * </p>
         */
        @Nonnull
        public final Builder nextToken(@Nullable String value) {
            this.nextToken = value;
            return this;
        }

        /**
         * Number of results to return per page.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * Timeout for the request.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Timeout for the request.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Builds a {@link GetStateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStateRequest build() {
            _checkSingleUse();

            return new GetStateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.nextToken != null) {
            params.put("next_token", this.nextToken);
        }
        if (this.size != null) {
            params.put("size", String.valueOf(this.size));
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
    }

    /**
     * Endpoint "{@code ingestion.get_state}".
     */
    public static final Endpoint<GetStateRequest, GetStateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(request.index, buf);
            buf.append("/ingestion/_state");
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
        GetStateResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.nextToken);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStateRequest other = (GetStateRequest) o;
        return this.index.equals(other.index)
            && Objects.equals(this.nextToken, other.nextToken)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.timeout, other.timeout);
    }
}
