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

package org.opensearch.client.opensearch.cluster;

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

// typedef: cluster.get_weighted_routing.Request

/**
 * Fetches weighted shard routing weights.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetWeightedRoutingRequest extends RequestBase
    implements
        ToCopyableBuilder<GetWeightedRoutingRequest.Builder, GetWeightedRoutingRequest> {

    @Nonnull
    private final String attribute;

    // ---------------------------------------------------------------------------------------------

    private GetWeightedRoutingRequest(Builder builder) {
        super(builder);
        this.attribute = ApiTypeHelper.requireNonNull(builder.attribute, this, "attribute");
    }

    public static GetWeightedRoutingRequest of(Function<GetWeightedRoutingRequest.Builder, ObjectBuilder<GetWeightedRoutingRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The name of the awareness attribute.
     * <p>
     * API name: {@code attribute}
     * </p>
     */
    @Nonnull
    public final String attribute() {
        return this.attribute;
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
     * Builder for {@link GetWeightedRoutingRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, GetWeightedRoutingRequest> {
        private String attribute;

        public Builder() {}

        private Builder(GetWeightedRoutingRequest o) {
            super(o);
            this.attribute = o.attribute;
        }

        private Builder(Builder o) {
            super(o);
            this.attribute = o.attribute;
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
         * Required - The name of the awareness attribute.
         * <p>
         * API name: {@code attribute}
         * </p>
         */
        @Nonnull
        public final Builder attribute(String value) {
            this.attribute = value;
            return this;
        }

        /**
         * Builds a {@link GetWeightedRoutingRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetWeightedRoutingRequest build() {
            _checkSingleUse();

            return new GetWeightedRoutingRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cluster.get_weighted_routing}".
     */
    public static final Endpoint<GetWeightedRoutingRequest, GetWeightedRoutingResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_cluster/routing/awareness/");
            SimpleEndpoint.pathEncode(request.attribute, buf);
            buf.append("/weights");
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
        GetWeightedRoutingResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.attribute.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetWeightedRoutingRequest other = (GetWeightedRoutingRequest) o;
        return this.attribute.equals(other.attribute);
    }
}
