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
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.get_judgments.Request

/**
 * Gets judgments.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetJudgmentsRequest extends RequestBase implements ToCopyableBuilder<GetJudgmentsRequest.Builder, GetJudgmentsRequest> {

    @Nullable
    private final String judgmentId;

    // ---------------------------------------------------------------------------------------------

    private GetJudgmentsRequest(Builder builder) {
        super(builder);
        this.judgmentId = builder.judgmentId;
    }

    public static GetJudgmentsRequest of(Function<GetJudgmentsRequest.Builder, ObjectBuilder<GetJudgmentsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The judgment id
     * <p>
     * API name: {@code judgment_id}
     * </p>
     */
    @Nullable
    public final String judgmentId() {
        return this.judgmentId;
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
     * Builder for {@link GetJudgmentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetJudgmentsRequest> {
        @Nullable
        private String judgmentId;

        public Builder() {}

        private Builder(GetJudgmentsRequest o) {
            super(o);
            this.judgmentId = o.judgmentId;
        }

        private Builder(Builder o) {
            super(o);
            this.judgmentId = o.judgmentId;
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
         * The judgment id
         * <p>
         * API name: {@code judgment_id}
         * </p>
         */
        @Nonnull
        public final Builder judgmentId(@Nullable String value) {
            this.judgmentId = value;
            return this;
        }

        /**
         * Builds a {@link GetJudgmentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetJudgmentsRequest build() {
            _checkSingleUse();

            return new GetJudgmentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.get_judgments}".
     */
    public static final Endpoint<GetJudgmentsRequest, GetJudgmentsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _judgmentId = 1 << 0;

            int propsSet = 0;

            if (request.judgmentId() != null) propsSet |= _judgmentId;

            if (propsSet == 0) {
                return "/_plugins/_search_relevance/judgments";
            }
            if (propsSet == (_judgmentId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/judgments/");
                SimpleEndpoint.pathEncode(request.judgmentId, buf);
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
        GetJudgmentsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.judgmentId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetJudgmentsRequest other = (GetJudgmentsRequest) o;
        return Objects.equals(this.judgmentId, other.judgmentId);
    }
}
