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

package org.opensearch.client.opensearch.ltr;

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

// typedef: ltr.search_features.Request

/**
 * Search for features in a feature store.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SearchFeaturesRequest extends RequestBase
    implements
        ToCopyableBuilder<SearchFeaturesRequest.Builder, SearchFeaturesRequest> {

    @Nullable
    private final Integer from;

    @Nullable
    private final String prefix;

    @Nullable
    private final Integer size;

    @Nullable
    private final String store;

    // ---------------------------------------------------------------------------------------------

    private SearchFeaturesRequest(Builder builder) {
        super(builder);
        this.from = builder.from;
        this.prefix = builder.prefix;
        this.size = builder.size;
        this.store = builder.store;
    }

    public static SearchFeaturesRequest of(Function<SearchFeaturesRequest.Builder, ObjectBuilder<SearchFeaturesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The offset from the first result (for pagination).
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * A name prefix to filter features by.
     * <p>
     * API name: {@code prefix}
     * </p>
     */
    @Nullable
    public final String prefix() {
        return this.prefix;
    }

    /**
     * The number of features to return.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * The name of the feature store.
     * <p>
     * API name: {@code store}
     * </p>
     */
    @Nullable
    public final String store() {
        return this.store;
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
     * Builder for {@link SearchFeaturesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SearchFeaturesRequest> {
        @Nullable
        private Integer from;
        @Nullable
        private String prefix;
        @Nullable
        private Integer size;
        @Nullable
        private String store;

        public Builder() {}

        private Builder(SearchFeaturesRequest o) {
            super(o);
            this.from = o.from;
            this.prefix = o.prefix;
            this.size = o.size;
            this.store = o.store;
        }

        private Builder(Builder o) {
            super(o);
            this.from = o.from;
            this.prefix = o.prefix;
            this.size = o.size;
            this.store = o.store;
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
         * The offset from the first result (for pagination).
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
         * A name prefix to filter features by.
         * <p>
         * API name: {@code prefix}
         * </p>
         */
        @Nonnull
        public final Builder prefix(@Nullable String value) {
            this.prefix = value;
            return this;
        }

        /**
         * The number of features to return.
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
         * The name of the feature store.
         * <p>
         * API name: {@code store}
         * </p>
         */
        @Nonnull
        public final Builder store(@Nullable String value) {
            this.store = value;
            return this;
        }

        /**
         * Builds a {@link SearchFeaturesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchFeaturesRequest build() {
            _checkSingleUse();

            return new SearchFeaturesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.from != null) {
            params.put("from", String.valueOf(this.from));
        }
        if (this.prefix != null) {
            params.put("prefix", this.prefix);
        }
        if (this.size != null) {
            params.put("size", String.valueOf(this.size));
        }
    }

    /**
     * Endpoint "{@code ltr.search_features}".
     */
    public static final Endpoint<SearchFeaturesRequest, SearchFeaturesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            final int _store = 1 << 0;

            int propsSet = 0;

            if (request.store() != null) propsSet |= _store;

            if (propsSet == 0) {
                return "/_ltr/_feature";
            }
            if (propsSet == (_store)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_ltr/");
                SimpleEndpoint.pathEncode(request.store, buf);
                buf.append("/_feature");
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
        SearchFeaturesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.prefix);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.store);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchFeaturesRequest other = (SearchFeaturesRequest) o;
        return Objects.equals(this.from, other.from)
            && Objects.equals(this.prefix, other.prefix)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.store, other.store);
    }
}
