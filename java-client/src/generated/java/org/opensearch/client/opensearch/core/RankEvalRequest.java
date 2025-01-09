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
import org.opensearch.client.opensearch._types.SearchType;
import org.opensearch.client.opensearch.core.rank_eval.RankEvalMetric;
import org.opensearch.client.opensearch.core.rank_eval.RankEvalRequestItem;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.rank_eval.Request

/**
 * Allows to evaluate the quality of ranked search results over a set of typical search queries.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class RankEvalRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RankEvalRequest.Builder, RankEvalRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final RankEvalMetric metric;

    @Nonnull
    private final List<RankEvalRequestItem> requests;

    @Nullable
    private final SearchType searchType;

    // ---------------------------------------------------------------------------------------------

    private RankEvalRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.metric = builder.metric;
        this.requests = ApiTypeHelper.unmodifiableRequired(builder.requests, this, "requests");
        this.searchType = builder.searchType;
    }

    public static RankEvalRequest of(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn) {
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
     * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * If <code>true</code>, missing or closed indexes are not included in the response.
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * Comma-separated list of data streams, indexes, and index aliases used to limit the request. Wildcard (<code>*</code>) expressions are
     * supported. To target all data streams and indexes in a cluster, omit this parameter or use <code>_all</code> or <code>*</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * API name: {@code metric}
     */
    @Nullable
    public final RankEvalMetric metric() {
        return this.metric;
    }

    /**
     * Required - A set of typical search requests, together with their provided ratings.
     * <p>
     * API name: {@code requests}
     * </p>
     */
    @Nonnull
    public final List<RankEvalRequestItem> requests() {
        return this.requests;
    }

    /**
     * Search operation type
     * <p>
     * API name: {@code search_type}
     * </p>
     */
    @Nullable
    public final SearchType searchType() {
        return this.searchType;
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
        if (this.metric != null) {
            generator.writeKey("metric");
            this.metric.serialize(generator, mapper);
        }

        generator.writeKey("requests");
        generator.writeStartArray();
        for (RankEvalRequestItem item0 : this.requests) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link RankEvalRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, RankEvalRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private RankEvalMetric metric;
        private List<RankEvalRequestItem> requests;
        @Nullable
        private SearchType searchType;

        public Builder() {}

        private Builder(RankEvalRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.metric = o.metric;
            this.requests = _listCopy(o.requests);
            this.searchType = o.searchType;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.metric = o.metric;
            this.requests = _listCopy(o.requests);
            this.searchType = o.searchType;
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
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
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
         * Whether to expand wildcard expression to concrete indexes that are open, closed or both.
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
         * If <code>true</code>, missing or closed indexes are not included in the response.
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
         * Comma-separated list of data streams, indexes, and index aliases used to limit the request. Wildcard (<code>*</code>) expressions
         * are supported. To target all data streams and indexes in a cluster, omit this parameter or use <code>_all</code> or
         * <code>*</code>.
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
         * Comma-separated list of data streams, indexes, and index aliases used to limit the request. Wildcard (<code>*</code>) expressions
         * are supported. To target all data streams and indexes in a cluster, omit this parameter or use <code>_all</code> or
         * <code>*</code>.
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
         * API name: {@code metric}
         */
        @Nonnull
        public final Builder metric(@Nullable RankEvalMetric value) {
            this.metric = value;
            return this;
        }

        /**
         * API name: {@code metric}
         */
        @Nonnull
        public final Builder metric(Function<RankEvalMetric.Builder, ObjectBuilder<RankEvalMetric>> fn) {
            return metric(fn.apply(new RankEvalMetric.Builder()).build());
        }

        /**
         * Required - A set of typical search requests, together with their provided ratings.
         * <p>
         * API name: {@code requests}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>requests</code>.
         * </p>
         */
        @Nonnull
        public final Builder requests(List<RankEvalRequestItem> list) {
            this.requests = _listAddAll(this.requests, list);
            return this;
        }

        /**
         * Required - A set of typical search requests, together with their provided ratings.
         * <p>
         * API name: {@code requests}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>requests</code>.
         * </p>
         */
        @Nonnull
        public final Builder requests(RankEvalRequestItem value, RankEvalRequestItem... values) {
            this.requests = _listAdd(this.requests, value, values);
            return this;
        }

        /**
         * Required - A set of typical search requests, together with their provided ratings.
         * <p>
         * API name: {@code requests}
         * </p>
         *
         * <p>
         * Adds a value to <code>requests</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder requests(Function<RankEvalRequestItem.Builder, ObjectBuilder<RankEvalRequestItem>> fn) {
            return requests(fn.apply(new RankEvalRequestItem.Builder()).build());
        }

        /**
         * Search operation type
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
         * Builds a {@link RankEvalRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RankEvalRequest build() {
            _checkSingleUse();

            return new RankEvalRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RankEvalRequest}
     */
    public static final JsonpDeserializer<RankEvalRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RankEvalRequest::setupRankEvalRequestDeserializer
    );

    protected static void setupRankEvalRequestDeserializer(ObjectDeserializer<RankEvalRequest.Builder> op) {
        op.add(Builder::metric, RankEvalMetric._DESERIALIZER, "metric");
        op.add(Builder::requests, JsonpDeserializer.arrayDeserializer(RankEvalRequestItem._DESERIALIZER), "requests");
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
        if (this.searchType != null) {
            params.put("search_type", this.searchType.jsonValue());
        }
    }

    /**
     * Endpoint "{@code rank_eval}".
     */
    public static final Endpoint<RankEvalRequest, RankEvalResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_rank_eval";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_rank_eval");
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
        RankEvalResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.metric);
        result = 31 * result + this.requests.hashCode();
        result = 31 * result + Objects.hashCode(this.searchType);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RankEvalRequest other = (RankEvalRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.metric, other.metric)
            && this.requests.equals(other.requests)
            && Objects.equals(this.searchType, other.searchType);
    }
}
