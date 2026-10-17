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
import java.util.List;
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

// typedef: ism.refresh_search_analyzers.Request

/**
 * Refreshes search analyzers in real time.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RefreshSearchAnalyzersRequest extends RequestBase
    implements
        ToCopyableBuilder<RefreshSearchAnalyzersRequest.Builder, RefreshSearchAnalyzersRequest> {

    @Nonnull
    private final List<String> index;

    // ---------------------------------------------------------------------------------------------

    private RefreshSearchAnalyzersRequest(Builder builder) {
        super(builder);
        this.index = ApiTypeHelper.unmodifiableRequired(builder.index, this, "index");
    }

    public static RefreshSearchAnalyzersRequest of(
        Function<RefreshSearchAnalyzersRequest.Builder, ObjectBuilder<RefreshSearchAnalyzersRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards
     * (<code>*</code>). To target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
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
     * Builder for {@link RefreshSearchAnalyzersRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, RefreshSearchAnalyzersRequest> {
        private List<String> index;

        public Builder() {}

        private Builder(RefreshSearchAnalyzersRequest o) {
            super(o);
            this.index = _listCopy(o.index);
        }

        private Builder(Builder o) {
            super(o);
            this.index = _listCopy(o.index);
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
         * Required - A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards
         * (<code>*</code>). To target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(List<String> list) {
            this.index = _listAddAll(this.index, list);
            return this;
        }

        /**
         * Required - A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards
         * (<code>*</code>). To target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
         * <p>
         * API name: {@code index}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>index</code>.
         * </p>
         */
        @Nonnull
        public final Builder index(String value, String... values) {
            this.index = _listAdd(this.index, value, values);
            return this;
        }

        /**
         * Builds a {@link RefreshSearchAnalyzersRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RefreshSearchAnalyzersRequest build() {
            _checkSingleUse();

            return new RefreshSearchAnalyzersRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ism.refresh_search_analyzers}".
     */
    public static final Endpoint<RefreshSearchAnalyzersRequest, RefreshSearchAnalyzersResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "POST",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_refresh_search_analyzers/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
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
            RefreshSearchAnalyzersResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.index.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RefreshSearchAnalyzersRequest other = (RefreshSearchAnalyzersRequest) o;
        return this.index.equals(other.index);
    }
}
