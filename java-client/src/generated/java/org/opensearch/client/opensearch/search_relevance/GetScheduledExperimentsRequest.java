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

// typedef: search_relevance.get_scheduled_experiments.Request

/**
 * Gets the scheduled experiments.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetScheduledExperimentsRequest extends RequestBase
    implements
        ToCopyableBuilder<GetScheduledExperimentsRequest.Builder, GetScheduledExperimentsRequest> {

    @Nullable
    private final String experimentId;

    // ---------------------------------------------------------------------------------------------

    private GetScheduledExperimentsRequest(Builder builder) {
        super(builder);
        this.experimentId = builder.experimentId;
    }

    public static GetScheduledExperimentsRequest of(
        Function<GetScheduledExperimentsRequest.Builder, ObjectBuilder<GetScheduledExperimentsRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The experiment id
     * <p>
     * API name: {@code experiment_id}
     * </p>
     */
    @Nullable
    public final String experimentId() {
        return this.experimentId;
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
     * Builder for {@link GetScheduledExperimentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetScheduledExperimentsRequest> {
        @Nullable
        private String experimentId;

        public Builder() {}

        private Builder(GetScheduledExperimentsRequest o) {
            super(o);
            this.experimentId = o.experimentId;
        }

        private Builder(Builder o) {
            super(o);
            this.experimentId = o.experimentId;
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
         * The experiment id
         * <p>
         * API name: {@code experiment_id}
         * </p>
         */
        @Nonnull
        public final Builder experimentId(@Nullable String value) {
            this.experimentId = value;
            return this;
        }

        /**
         * Builds a {@link GetScheduledExperimentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetScheduledExperimentsRequest build() {
            _checkSingleUse();

            return new GetScheduledExperimentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.get_scheduled_experiments}".
     */
    public static final SimpleEndpoint<GetScheduledExperimentsRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _experimentId = 1 << 0;

            int propsSet = 0;

            if (request.experimentId() != null) propsSet |= _experimentId;

            if (propsSet == 0) {
                return "/_plugins/_search_relevance/experiments/schedule";
            }
            if (propsSet == (_experimentId)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_search_relevance/experiments/schedule/");
                SimpleEndpoint.pathEncode(request.experimentId, buf);
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
        GetScheduledExperimentsResponse._DESERIALIZER
    );

    /**
     * Create an "{@code search_relevance.get_scheduled_experiments}" endpoint.
     */
    public static <
        TDocument>
        Endpoint<GetScheduledExperimentsRequest, GetScheduledExperimentsResponse<TDocument>, ErrorResponse>
        createSearchRelevanceGetScheduledExperimentsEndpoint(JsonpDeserializer<TDocument> tDocumentDeserializer) {
        return _ENDPOINT.withResponseDeserializer(
            GetScheduledExperimentsResponse.createGetScheduledExperimentsResponseDeserializer(tDocumentDeserializer)
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.experimentId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetScheduledExperimentsRequest other = (GetScheduledExperimentsRequest) o;
        return Objects.equals(this.experimentId, other.experimentId);
    }
}
