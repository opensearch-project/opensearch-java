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
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.SearchType;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.search_template.Request

/**
 * Allows to use the Mustache language to pre-render a search definition.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SearchTemplateRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SearchTemplateRequest.Builder, SearchTemplateRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Boolean ccsMinimizeRoundtrips;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean explain;

    @Nullable
    private final String id;

    @Nullable
    private final Boolean ignoreThrottled;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nonnull
    private final Map<String, JsonData> params;

    @Nullable
    private final Boolean phaseTook;

    @Nullable
    private final String pipeline;

    @Nullable
    private final String preference;

    @Nullable
    private final Boolean profile;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final Time scroll;

    @Nullable
    private final SearchType searchType;

    @Nullable
    private final String source;

    // ---------------------------------------------------------------------------------------------

    private SearchTemplateRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.ccsMinimizeRoundtrips = builder.ccsMinimizeRoundtrips;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.explain = builder.explain;
        this.id = builder.id;
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.params = ApiTypeHelper.unmodifiable(builder.params);
        this.phaseTook = builder.phaseTook;
        this.pipeline = builder.pipeline;
        this.preference = builder.preference;
        this.profile = builder.profile;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.scroll = builder.scroll;
        this.searchType = builder.searchType;
        this.source = builder.source;
    }

    public static SearchTemplateRequest of(Function<SearchTemplateRequest.Builder, ObjectBuilder<SearchTemplateRequest>> fn) {
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
     * If <code>true</code>, network round-trips are minimized for cross-cluster search requests.
     * <p>
     * API name: {@code ccs_minimize_roundtrips}
     * </p>
     */
    @Nullable
    public final Boolean ccsMinimizeRoundtrips() {
        return this.ccsMinimizeRoundtrips;
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
     * If <code>true</code>, returns detailed information about score calculation as part of each hit.
     * <p>
     * API name: {@code explain}
     * </p>
     */
    @Nullable
    public final Boolean explain() {
        return this.explain;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * If <code>true</code>, specified concrete, expanded, or aliased indexes are not included in the response when throttled.
     * <p>
     * API name: {@code ignore_throttled}
     * </p>
     */
    @Nullable
    public final Boolean ignoreThrottled() {
        return this.ignoreThrottled;
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
     * A comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (*).
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Key-value pairs used to replace Mustache variables in the template. The key is the variable name. The value is the variable value.
     * <p>
     * API name: {@code params}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> params() {
        return this.params;
    }

    /**
     * Indicates whether to return phase-level <code>took</code> time values in the response.
     * <p>
     * API name: {@code phase_took}
     * </p>
     */
    @Nullable
    public final Boolean phaseTook() {
        return this.phaseTook;
    }

    /**
     * Customizable sequence of processing stages applied to search queries.
     * <p>
     * API name: {@code search_pipeline}
     * </p>
     */
    @Nullable
    public final String pipeline() {
        return this.pipeline;
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
     * If <code>true</code>, the query execution is profiled.
     * <p>
     * API name: {@code profile}
     * </p>
     */
    @Nullable
    public final Boolean profile() {
        return this.profile;
    }

    /**
     * A custom value used to route operations to a specific shard.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * Specifies how long a consistent view of the index should be maintained for scrolled search.
     * <p>
     * API name: {@code scroll}
     * </p>
     */
    @Nullable
    public final Time scroll() {
        return this.scroll;
    }

    /**
     * The type of the search operation.
     * <p>
     * API name: {@code search_type}
     * </p>
     */
    @Nullable
    public final SearchType searchType() {
        return this.searchType;
    }

    /**
     * An inline search template. Supports the same parameters as the search API request body. Also supports Mustache variables. If no id is
     * specified, this parameter is required.
     * <p>
     * API name: {@code source}
     * </p>
     */
    @Nullable
    public final String source() {
        return this.source;
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
        if (this.explain != null) {
            generator.writeKey("explain");
            generator.write(this.explain);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (ApiTypeHelper.isDefined(this.params)) {
            generator.writeKey("params");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.profile != null) {
            generator.writeKey("profile");
            generator.write(this.profile);
        }

        if (this.source != null) {
            generator.writeKey("source");
            generator.write(this.source);
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
     * Builder for {@link SearchTemplateRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SearchTemplateRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Boolean ccsMinimizeRoundtrips;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean explain;
        @Nullable
        private String id;
        @Nullable
        private Boolean ignoreThrottled;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private Map<String, JsonData> params;
        @Nullable
        private Boolean phaseTook;
        @Nullable
        private String pipeline;
        @Nullable
        private String preference;
        @Nullable
        private Boolean profile;
        @Nullable
        private List<String> routing;
        @Nullable
        private Time scroll;
        @Nullable
        private SearchType searchType;
        @Nullable
        private String source;

        public Builder() {}

        private Builder(SearchTemplateRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.ccsMinimizeRoundtrips = o.ccsMinimizeRoundtrips;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.id = o.id;
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.params = _mapCopy(o.params);
            this.phaseTook = o.phaseTook;
            this.pipeline = o.pipeline;
            this.preference = o.preference;
            this.profile = o.profile;
            this.routing = _listCopy(o.routing);
            this.scroll = o.scroll;
            this.searchType = o.searchType;
            this.source = o.source;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.ccsMinimizeRoundtrips = o.ccsMinimizeRoundtrips;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.id = o.id;
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.params = _mapCopy(o.params);
            this.phaseTook = o.phaseTook;
            this.pipeline = o.pipeline;
            this.preference = o.preference;
            this.profile = o.profile;
            this.routing = _listCopy(o.routing);
            this.scroll = o.scroll;
            this.searchType = o.searchType;
            this.source = o.source;
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
         * If <code>true</code>, network round-trips are minimized for cross-cluster search requests.
         * <p>
         * API name: {@code ccs_minimize_roundtrips}
         * </p>
         */
        @Nonnull
        public final Builder ccsMinimizeRoundtrips(@Nullable Boolean value) {
            this.ccsMinimizeRoundtrips = value;
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
         * If <code>true</code>, returns detailed information about score calculation as part of each hit.
         * <p>
         * API name: {@code explain}
         * </p>
         */
        @Nonnull
        public final Builder explain(@Nullable Boolean value) {
            this.explain = value;
            return this;
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * If <code>true</code>, specified concrete, expanded, or aliased indexes are not included in the response when throttled.
         * <p>
         * API name: {@code ignore_throttled}
         * </p>
         */
        @Nonnull
        public final Builder ignoreThrottled(@Nullable Boolean value) {
            this.ignoreThrottled = value;
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
         * A comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (*).
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
         * A comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (*).
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
         * Key-value pairs used to replace Mustache variables in the template. The key is the variable name. The value is the variable
         * value.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(Map<String, JsonData> map) {
            this.params = _mapPutAll(this.params, map);
            return this;
        }

        /**
         * Key-value pairs used to replace Mustache variables in the template. The key is the variable name. The value is the variable
         * value.
         * <p>
         * API name: {@code params}
         * </p>
         *
         * <p>
         * Adds an entry to <code>params</code>.
         * </p>
         */
        @Nonnull
        public final Builder params(String key, JsonData value) {
            this.params = _mapPut(this.params, key, value);
            return this;
        }

        /**
         * Indicates whether to return phase-level <code>took</code> time values in the response.
         * <p>
         * API name: {@code phase_took}
         * </p>
         */
        @Nonnull
        public final Builder phaseTook(@Nullable Boolean value) {
            this.phaseTook = value;
            return this;
        }

        /**
         * Customizable sequence of processing stages applied to search queries.
         * <p>
         * API name: {@code search_pipeline}
         * </p>
         */
        @Nonnull
        public final Builder pipeline(@Nullable String value) {
            this.pipeline = value;
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
         * If <code>true</code>, the query execution is profiled.
         * <p>
         * API name: {@code profile}
         * </p>
         */
        @Nonnull
        public final Builder profile(@Nullable Boolean value) {
            this.profile = value;
            return this;
        }

        /**
         * A custom value used to route operations to a specific shard.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(List<String> list) {
            this.routing = _listAddAll(this.routing, list);
            return this;
        }

        /**
         * A custom value used to route operations to a specific shard.
         * <p>
         * API name: {@code routing}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>routing</code>.
         * </p>
         */
        @Nonnull
        public final Builder routing(String value, String... values) {
            this.routing = _listAdd(this.routing, value, values);
            return this;
        }

        /**
         * Specifies how long a consistent view of the index should be maintained for scrolled search.
         * <p>
         * API name: {@code scroll}
         * </p>
         */
        @Nonnull
        public final Builder scroll(@Nullable Time value) {
            this.scroll = value;
            return this;
        }

        /**
         * Specifies how long a consistent view of the index should be maintained for scrolled search.
         * <p>
         * API name: {@code scroll}
         * </p>
         */
        @Nonnull
        public final Builder scroll(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return scroll(fn.apply(new Time.Builder()).build());
        }

        /**
         * The type of the search operation.
         * <p>
         * API name: {@code search_type}
         * </p>
         */
        @Nonnull
        public final Builder searchType(@Nullable SearchType value) {
            this.searchType = value;
            return this;
        }

        /**
         * An inline search template. Supports the same parameters as the search API request body. Also supports Mustache variables. If no
         * id is specified, this parameter is required.
         * <p>
         * API name: {@code source}
         * </p>
         */
        @Nonnull
        public final Builder source(@Nullable String value) {
            this.source = value;
            return this;
        }

        /**
         * Builds a {@link SearchTemplateRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchTemplateRequest build() {
            _checkSingleUse();

            return new SearchTemplateRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchTemplateRequest}
     */
    public static final JsonpDeserializer<SearchTemplateRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchTemplateRequest::setupSearchTemplateRequestDeserializer
    );

    protected static void setupSearchTemplateRequestDeserializer(ObjectDeserializer<SearchTemplateRequest.Builder> op) {
        op.add(Builder::explain, JsonpDeserializer.booleanDeserializer(), "explain");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
        op.add(Builder::profile, JsonpDeserializer.booleanDeserializer(), "profile");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        params.put("typed_keys", "true");
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (this.ccsMinimizeRoundtrips != null) {
            params.put("ccs_minimize_roundtrips", String.valueOf(this.ccsMinimizeRoundtrips));
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.ignoreThrottled != null) {
            params.put("ignore_throttled", String.valueOf(this.ignoreThrottled));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.phaseTook != null) {
            params.put("phase_took", String.valueOf(this.phaseTook));
        }
        if (this.pipeline != null) {
            params.put("search_pipeline", this.pipeline);
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.scroll != null) {
            params.put("scroll", this.scroll._toJsonString());
        }
        if (this.searchType != null) {
            params.put("search_type", this.searchType.jsonValue());
        }
    }

    /**
     * Endpoint "{@code search_template}".
     */
    public static final SimpleEndpoint<SearchTemplateRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_search/template";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_search/template");
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
        SearchTemplateResponse._DESERIALIZER
    );

    /**
     * Create an "{@code search_template}" endpoint.
     */
    public static <
        TDocument> Endpoint<SearchTemplateRequest, SearchTemplateResponse<TDocument>, ErrorResponse> createSearchTemplateEndpoint(
            JsonpDeserializer<TDocument> tDocumentDeserializer
        ) {
        return _ENDPOINT.withResponseDeserializer(SearchTemplateResponse.createSearchTemplateResponseDeserializer(tDocumentDeserializer));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.ccsMinimizeRoundtrips);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.explain);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.ignoreThrottled);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.params);
        result = 31 * result + Objects.hashCode(this.phaseTook);
        result = 31 * result + Objects.hashCode(this.pipeline);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.profile);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.scroll);
        result = 31 * result + Objects.hashCode(this.searchType);
        result = 31 * result + Objects.hashCode(this.source);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchTemplateRequest other = (SearchTemplateRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.ccsMinimizeRoundtrips, other.ccsMinimizeRoundtrips)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.explain, other.explain)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.ignoreThrottled, other.ignoreThrottled)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.params, other.params)
            && Objects.equals(this.phaseTook, other.phaseTook)
            && Objects.equals(this.pipeline, other.pipeline)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.profile, other.profile)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.scroll, other.scroll)
            && Objects.equals(this.searchType, other.searchType)
            && Objects.equals(this.source, other.source);
    }
}
