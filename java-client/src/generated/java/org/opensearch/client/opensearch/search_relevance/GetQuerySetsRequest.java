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

package org.opensearch.client.opensearch.search_relevance;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.get_query_sets.Request

/**
 * Lists the current query sets available.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetQuerySetsRequest extends RequestBase implements ToCopyableBuilder<GetQuerySetsRequest.Builder, GetQuerySetsRequest> {

    @Nullable
    private final String querySetId;

    // ---------------------------------------------------------------------------------------------

    private GetQuerySetsRequest(Builder builder) {
        super(builder);
        this.querySetId = builder.querySetId;
    }

    public static GetQuerySetsRequest of(Function<GetQuerySetsRequest.Builder, ObjectBuilder<GetQuerySetsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The query set id
     * <p>
     * API name: {@code query_set_id}
     * </p>
     */
    @Nullable
    public final String querySetId() {
        return this.querySetId;
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
     * Builder for {@link GetQuerySetsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetQuerySetsRequest> {
        @Nullable
        private String querySetId;

        public Builder() {}

        private Builder(GetQuerySetsRequest o) {
            super(o);
            this.querySetId = o.querySetId;
        }

        private Builder(Builder o) {
            super(o);
            this.querySetId = o.querySetId;
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
         * The query set id
         * <p>
         * API name: {@code query_set_id}
         * </p>
         */
        @Nonnull
        public final Builder querySetId(@Nullable String value) {
            this.querySetId = value;
            return this;
        }

        /**
         * Builds a {@link GetQuerySetsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetQuerySetsRequest build() {
            _checkSingleUse();

            return new GetQuerySetsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.get_query_sets}".
     */
    public static final SimpleEndpoint<GetQuerySetsRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _querySetId = 1 << 0;

            int propsSet = 0;

            if (request.querySetId() != null) propsSet |= _querySetId;

            if (propsSet == 0) {
                return "/_plugins/_search_relevance/query_sets";
            }
            if (propsSet == (_querySetId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/query_sets/");
                SimpleEndpoint.pathEncode(request.querySetId, buf);
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
        GetQuerySetsResponse._DESERIALIZER
    );

    /**
     * Create an "{@code search_relevance.get_query_sets}" endpoint.
     */
    public static <
        TDocument> Endpoint<GetQuerySetsRequest, GetQuerySetsResponse<TDocument>, ErrorResponse> createSearchRelevanceGetQuerySetsEndpoint(
            JsonpDeserializer<TDocument> tDocumentDeserializer
        ) {
        return _ENDPOINT.withResponseDeserializer(GetQuerySetsResponse.createGetQuerySetsResponseDeserializer(tDocumentDeserializer));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.querySetId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetQuerySetsRequest other = (GetQuerySetsRequest) o;
        return Objects.equals(this.querySetId, other.querySetId);
    }
}
