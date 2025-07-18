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

// typedef: ltr.clear_cache.Request

/**
 * Clears the store caches.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ClearCacheRequest extends RequestBase implements ToCopyableBuilder<ClearCacheRequest.Builder, ClearCacheRequest> {

    @Nullable
    private final String store;

    // ---------------------------------------------------------------------------------------------

    private ClearCacheRequest(Builder builder) {
        super(builder);
        this.store = builder.store;
    }

    public static ClearCacheRequest of(Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The name of the feature store for which to clear the cache.
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
     * Builder for {@link ClearCacheRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ClearCacheRequest> {
        @Nullable
        private String store;

        public Builder() {}

        private Builder(ClearCacheRequest o) {
            super(o);
            this.store = o.store;
        }

        private Builder(Builder o) {
            super(o);
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
         * The name of the feature store for which to clear the cache.
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
         * Builds a {@link ClearCacheRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ClearCacheRequest build() {
            _checkSingleUse();

            return new ClearCacheRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ltr.clear_cache}".
     */
    public static final Endpoint<ClearCacheRequest, ClearCacheResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _store = 1 << 0;

            int propsSet = 0;

            if (request.store() != null) propsSet |= _store;

            if (propsSet == 0) {
                return "/_ltr/_clearcache";
            }
            if (propsSet == (_store)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_ltr/");
                SimpleEndpoint.pathEncode(request.store, buf);
                buf.append("/_clearcache");
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
        ClearCacheResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.store);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClearCacheRequest other = (ClearCacheRequest) o;
        return Objects.equals(this.store, other.store);
    }
}
