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

package org.opensearch.client.opensearch.core;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.SlicedScroll;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.search_shards.Request

/**
 * Returns information about the indexes and shards that a search request would be executed against.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SearchShardsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SearchShardsRequest.Builder, SearchShardsRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Boolean local;

    @Nullable
    private final String preference;

    @Nullable
    private final String routing;

    @Nullable
    private final SlicedScroll slice;

    // ---------------------------------------------------------------------------------------------

    private SearchShardsRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.local = builder.local;
        this.preference = builder.preference;
        this.routing = builder.routing;
        this.slice = builder.slice;
    }

    public static SearchShardsRequest of(Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>false</code>, the request returns an error if any wildcard expression, index alias, or <code>_all</code> value targets only
     * missing or closed indexes. This behavior applies even if the request targets other open indexes. For example, a request targeting
     * <code>foo*,bar*</code> returns an error if an index starts with <code>foo</code> but no index starts with <code>bar</code>.
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
     * Returns the indexes and shards that a search request would be executed against.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * If <code>true</code>, the request retrieves information from the local node only.
     * <p>
     * API name: {@code local}
     * </p>
     */
    @Nullable
    public final Boolean local() {
        return this.local;
    }

    /**
     * Specifies the node or shard the operation should be performed on. Random by default.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * A custom value used to route operations to a specific shard.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * API name: {@code slice}
     */
    @Nullable
    public final SlicedScroll slice() {
        return this.slice;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.slice != null) {
            generator.writeKey("slice");
            this.slice.serialize(generator, mapper);
        }
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
     * Builder for {@link SearchShardsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SearchShardsRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private Boolean local;
        @Nullable
        private String preference;
        @Nullable
        private String routing;
        @Nullable
        private SlicedScroll slice;

        public Builder() {}

        private Builder(SearchShardsRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.local = o.local;
            this.preference = o.preference;
            this.routing = o.routing;
            this.slice = o.slice;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.local = o.local;
            this.preference = o.preference;
            this.routing = o.routing;
            this.slice = o.slice;
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
         * only missing or closed indexes. This behavior applies even if the request targets other open indexes. For example, a request
         * targeting <code>foo*,bar*</code> returns an error if an index starts with <code>foo</code> but no index starts with
         * <code>bar</code>.
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
         * Returns the indexes and shards that a search request would be executed against.
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
         * Returns the indexes and shards that a search request would be executed against.
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
         * If <code>true</code>, the request retrieves information from the local node only.
         * <p>
         * API name: {@code local}
         * </p>
         */
        @Nonnull
        public final Builder local(@Nullable Boolean value) {
            this.local = value;
            return this;
        }

        /**
         * Specifies the node or shard the operation should be performed on. Random by default.
         * <p>
         * API name: {@code preference}
         * </p>
         */
        @Nonnull
        public final Builder preference(@Nullable String value) {
            this.preference = value;
            return this;
        }

        /**
         * A custom value used to route operations to a specific shard.
         * <p>
         * API name: {@code routing}
         * </p>
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * API name: {@code slice}
         */
        @Nonnull
        public final Builder slice(@Nullable SlicedScroll value) {
            this.slice = value;
            return this;
        }

        /**
         * API name: {@code slice}
         */
        @Nonnull
        public final Builder slice(Function<SlicedScroll.Builder, ObjectBuilder<SlicedScroll>> fn) {
            return slice(fn.apply(new SlicedScroll.Builder()).build());
        }

        /**
         * Builds a {@link SearchShardsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchShardsRequest build() {
            _checkSingleUse();

            return new SearchShardsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchShardsRequest}
     */
    public static final JsonpDeserializer<SearchShardsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchShardsRequest::setupSearchShardsRequestDeserializer
    );

    protected static void setupSearchShardsRequestDeserializer(ObjectDeserializer<SearchShardsRequest.Builder> op) {
        op.add(Builder::slice, SlicedScroll._DESERIALIZER, "slice");
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
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.local != null) {
            params.put("local", String.valueOf(this.local));
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (this.routing != null) {
            params.put("routing", this.routing);
        }
    }

    /**
     * Endpoint "{@code search_shards}".
     */
    public static final Endpoint<SearchShardsRequest, SearchShardsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_search_shards";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_search_shards");
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
        true,
        SearchShardsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.local);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.slice);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchShardsRequest other = (SearchShardsRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.local, other.local)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.slice, other.slice);
    }
}
