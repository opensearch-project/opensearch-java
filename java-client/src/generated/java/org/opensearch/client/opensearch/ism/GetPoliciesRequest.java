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

package org.opensearch.client.opensearch.ism;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.get_policies.Request

/**
 * Retrieves the policies.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetPoliciesRequest extends RequestBase implements ToCopyableBuilder<GetPoliciesRequest.Builder, GetPoliciesRequest> {

    @Nullable
    private final Integer from;

    @Nullable
    private final String queryString;

    @Nullable
    private final Integer size;

    @Nullable
    private final String sortField;

    @Nullable
    private final SortOrder sortOrder;

    // ---------------------------------------------------------------------------------------------

    private GetPoliciesRequest(Builder builder) {
        super(builder);
        this.from = builder.from;
        this.queryString = builder.queryString;
        this.size = builder.size;
        this.sortField = builder.sortField;
        this.sortOrder = builder.sortOrder;
    }

    public static GetPoliciesRequest of(Function<GetPoliciesRequest.Builder, ObjectBuilder<GetPoliciesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The starting index of the policies to return.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * A query string that filters the policies.
     * <p>
     * API name: {@code queryString}
     * </p>
     */
    @Nullable
    public final String queryString() {
        return this.queryString;
    }

    /**
     * The number of policies to return.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * The field to sort the policies by.
     * <p>
     * API name: {@code sortField}
     * </p>
     */
    @Nullable
    public final String sortField() {
        return this.sortField;
    }

    /**
     * The sort order of the policies.
     * <p>
     * API name: {@code sortOrder}
     * </p>
     */
    @Nullable
    public final SortOrder sortOrder() {
        return this.sortOrder;
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
     * Builder for {@link GetPoliciesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetPoliciesRequest> {
        @Nullable
        private Integer from;
        @Nullable
        private String queryString;
        @Nullable
        private Integer size;
        @Nullable
        private String sortField;
        @Nullable
        private SortOrder sortOrder;

        public Builder() {}

        private Builder(GetPoliciesRequest o) {
            super(o);
            this.from = o.from;
            this.queryString = o.queryString;
            this.size = o.size;
            this.sortField = o.sortField;
            this.sortOrder = o.sortOrder;
        }

        private Builder(Builder o) {
            super(o);
            this.from = o.from;
            this.queryString = o.queryString;
            this.size = o.size;
            this.sortField = o.sortField;
            this.sortOrder = o.sortOrder;
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
         * The starting index of the policies to return.
         * <p>
         * API name: {@code from}
         * </p>
         */
        @Nonnull
        public final Builder from(@Nullable Integer value) {
            this.from = value;
            return this;
        }

        /**
         * A query string that filters the policies.
         * <p>
         * API name: {@code queryString}
         * </p>
         */
        @Nonnull
        public final Builder queryString(@Nullable String value) {
            this.queryString = value;
            return this;
        }

        /**
         * The number of policies to return.
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
         * The field to sort the policies by.
         * <p>
         * API name: {@code sortField}
         * </p>
         */
        @Nonnull
        public final Builder sortField(@Nullable String value) {
            this.sortField = value;
            return this;
        }

        /**
         * The sort order of the policies.
         * <p>
         * API name: {@code sortOrder}
         * </p>
         */
        @Nonnull
        public final Builder sortOrder(@Nullable SortOrder value) {
            this.sortOrder = value;
            return this;
        }

        /**
         * Builds a {@link GetPoliciesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetPoliciesRequest build() {
            _checkSingleUse();

            return new GetPoliciesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.from != null) {
            params.put("from", String.valueOf(this.from));
        }
        if (this.queryString != null) {
            params.put("queryString", this.queryString);
        }
        if (this.size != null) {
            params.put("size", String.valueOf(this.size));
        }
        if (this.sortField != null) {
            params.put("sortField", this.sortField);
        }
        if (this.sortOrder != null) {
            params.put("sortOrder", this.sortOrder.jsonValue());
        }
    }

    /**
     * Endpoint "{@code ism.get_policies}".
     */
    public static final Endpoint<GetPoliciesRequest, GetPoliciesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_plugins/_ism/policies",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetPoliciesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.queryString);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sortField);
        result = 31 * result + Objects.hashCode(this.sortOrder);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetPoliciesRequest other = (GetPoliciesRequest) o;
        return Objects.equals(this.from, other.from)
            && Objects.equals(this.queryString, other.queryString)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sortField, other.sortField)
            && Objects.equals(this.sortOrder, other.sortOrder);
    }
}
