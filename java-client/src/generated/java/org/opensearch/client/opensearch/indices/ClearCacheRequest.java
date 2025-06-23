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

package org.opensearch.client.opensearch.indices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.clear_cache.Request

/**
 * Clears all or specific caches for one or more indexes.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ClearCacheRequest extends RequestBase implements ToCopyableBuilder<ClearCacheRequest.Builder, ClearCacheRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean fielddata;

    @Nonnull
    private final List<String> fields;

    @Nullable
    private final Boolean file;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Boolean query;

    @Nullable
    private final Boolean request;

    // ---------------------------------------------------------------------------------------------

    private ClearCacheRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.fielddata = builder.fielddata;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.file = builder.file;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.query = builder.query;
        this.request = builder.request;
    }

    public static ClearCacheRequest of(Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets only
     * missing or closed indexes. This behavior applies even if the request targets other open indexes.
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    /**
     * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
     * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
     * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * If <code>true</code>, clears the fields cache. Use the <code>fields</code> parameter to clear the cache of specific fields only.
     * <p>
     * API name: {@code fielddata}
     * </p>
     */
    @Nullable
    public final Boolean fielddata() {
        return this.fielddata;
    }

    /**
     * A comma-separated list of field names used to limit the <code>fielddata</code> parameter.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<String> fields() {
        return this.fields;
    }

    /**
     * If <code>true</code>, clears the unused entries from the file cache on nodes with the Search role.
     * <p>
     * API name: {@code file}
     * </p>
     */
    @Nullable
    public final Boolean file() {
        return this.file;
    }

    /**
     * If <code>false</code>, the request returns an error if it targets a missing or closed index.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
     * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * If <code>true</code>, clears the query cache.
     * <p>
     * API name: {@code query}
     * </p>
     */
    @Nullable
    public final Boolean query() {
        return this.query;
    }

    /**
     * If <code>true</code>, clears the request cache.
     * <p>
     * API name: {@code request}
     * </p>
     */
    @Nullable
    public final Boolean request() {
        return this.request;
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
        private Boolean allowNoIndices;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean fielddata;
        @Nullable
        private List<String> fields;
        @Nullable
        private Boolean file;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private Boolean query;
        @Nullable
        private Boolean request;

        public Builder() {}

        private Builder(ClearCacheRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fielddata = o.fielddata;
            this.fields = _listCopy(o.fields);
            this.file = o.file;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.query = o.query;
            this.request = o.request;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.fielddata = o.fielddata;
            this.fields = _listCopy(o.fields);
            this.file = o.file;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.query = o.query;
            this.request = o.request;
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
         * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets
         * only missing or closed indexes. This behavior applies even if the request targets other open indexes.
         * <p>
         * API name: {@code allow_no_indices}
         * </p>
         */
        @Nonnull
        public final Builder allowNoIndices(@Nullable Boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        /**
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
         * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(List<ExpandWildcard> list) {
            this.expandWildcards = _listAddAll(this.expandWildcards, list);
            return this;
        }

        /**
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>. Valid values are:
         * <code>all</code>, <code>open</code>, <code>closed</code>, <code>hidden</code>, <code>none</code>.
         * <p>
         * API name: {@code expand_wildcards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>expandWildcards</code>.
         * </p>
         */
        @Nonnull
        public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
            this.expandWildcards = _listAdd(this.expandWildcards, value, values);
            return this;
        }

        /**
         * If <code>true</code>, clears the fields cache. Use the <code>fields</code> parameter to clear the cache of specific fields only.
         * <p>
         * API name: {@code fielddata}
         * </p>
         */
        @Nonnull
        public final Builder fielddata(@Nullable Boolean value) {
            this.fielddata = value;
            return this;
        }

        /**
         * A comma-separated list of field names used to limit the <code>fielddata</code> parameter.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * A comma-separated list of field names used to limit the <code>fielddata</code> parameter.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * If <code>true</code>, clears the unused entries from the file cache on nodes with the Search role.
         * <p>
         * API name: {@code file}
         * </p>
         */
        @Nonnull
        public final Builder file(@Nullable Boolean value) {
            this.file = value;
            return this;
        }

        /**
         * If <code>false</code>, the request returns an error if it targets a missing or closed index.
         * <p>
         * API name: {@code ignore_unavailable}
         * </p>
         */
        @Nonnull
        public final Builder ignoreUnavailable(@Nullable Boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        /**
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * A comma-separated list of data streams, indexes, and aliases used to limit the request. Supports wildcards (<code>*</code>). To
         * target all data streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * If <code>true</code>, clears the query cache.
         * <p>
         * API name: {@code query}
         * </p>
         */
        @Nonnull
        public final Builder query(@Nullable Boolean value) {
            this.query = value;
            return this;
        }

        /**
         * If <code>true</code>, clears the request cache.
         * <p>
         * API name: {@code request}
         * </p>
         */
        @Nonnull
        public final Builder request(@Nullable Boolean value) {
            this.request = value;
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

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.fielddata != null) {
            params.put("fielddata", String.valueOf(this.fielddata));
        }
        if (ApiTypeHelper.isDefined(this.fields)) {
            params.put("fields", String.join(",", this.fields));
        }
        if (this.file != null) {
            params.put("file", String.valueOf(this.file));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.query != null) {
            params.put("query", String.valueOf(this.query));
        }
        if (this.request != null) {
            params.put("request", String.valueOf(this.request));
        }
    }

    /**
     * Endpoint "{@code indices.clear_cache}".
     */
    public static final Endpoint<ClearCacheRequest, ClearCacheResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_cache/clear";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_cache/clear");
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
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.fielddata);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.file);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.request);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClearCacheRequest other = (ClearCacheRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.fielddata, other.fielddata)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.file, other.file)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.request, other.request);
    }
}
