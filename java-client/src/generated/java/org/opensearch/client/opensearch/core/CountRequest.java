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
import org.opensearch.client.opensearch._types.query_dsl.Operator;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.count.Request

/**
 * Returns number of documents matching a query.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class CountRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CountRequest.Builder, CountRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Boolean analyzeWildcard;

    @Nullable
    private final String analyzer;

    @Nullable
    private final Operator defaultOperator;

    @Nullable
    private final String df;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean ignoreThrottled;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final Float minScore;

    @Nullable
    private final String preference;

    @Nullable
    private final String q;

    @Nullable
    private final Query query;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final Integer terminateAfter;

    // ---------------------------------------------------------------------------------------------

    private CountRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.defaultOperator = builder.defaultOperator;
        this.df = builder.df;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.lenient = builder.lenient;
        this.minScore = builder.minScore;
        this.preference = builder.preference;
        this.q = builder.q;
        this.query = builder.query;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.terminateAfter = builder.terminateAfter;
    }

    public static CountRequest of(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) {
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
     * If <code>true</code>, wildcard and prefix queries are analyzed. This parameter can only be used when the <code>q</code> query string
     * parameter is specified.
     * <p>
     * API name: {@code analyze_wildcard}
     * </p>
     */
    @Nullable
    public final Boolean analyzeWildcard() {
        return this.analyzeWildcard;
    }

    /**
     * Analyzer to use for the query string. This parameter can only be used when the <code>q</code> query string parameter is specified.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * The default operator for query string query: <code>AND</code> or <code>OR</code>. This parameter can only be used when the
     * <code>q</code> query string parameter is specified.
     * <p>
     * API name: {@code default_operator}
     * </p>
     */
    @Nullable
    public final Operator defaultOperator() {
        return this.defaultOperator;
    }

    /**
     * Field to use as default where no field prefix is given in the query string. This parameter can only be used when the <code>q</code>
     * query string parameter is specified.
     * <p>
     * API name: {@code df}
     * </p>
     */
    @Nullable
    public final String df() {
        return this.df;
    }

    /**
     * Specifies the type of index that wildcard expressions can match. Supports comma-separated values.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * If <code>true</code>, concrete, expanded or aliased indexes are ignored when frozen.
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
     * Comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search all data streams
     * and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * If <code>true</code>, format-based query failures (such as providing text to a numeric field) in the query string will be ignored.
     * <p>
     * API name: {@code lenient}
     * </p>
     */
    @Nullable
    public final Boolean lenient() {
        return this.lenient;
    }

    /**
     * Sets the minimum <code>_score</code> value that documents must have to be included in the result.
     * <p>
     * API name: {@code min_score}
     * </p>
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
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
     * Query in the Lucene query string syntax.
     * <p>
     * API name: {@code q}
     * </p>
     */
    @Nullable
    public final String q() {
        return this.q;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * Custom value used to route operations to a specific shard.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
     * OpenSearch collects documents before sorting.
     * <p>
     * API name: {@code terminate_after}
     * </p>
     */
    @Nullable
    public final Integer terminateAfter() {
        return this.terminateAfter;
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
        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
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
     * Builder for {@link CountRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CountRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Boolean analyzeWildcard;
        @Nullable
        private String analyzer;
        @Nullable
        private Operator defaultOperator;
        @Nullable
        private String df;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean ignoreThrottled;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private Boolean lenient;
        @Nullable
        private Float minScore;
        @Nullable
        private String preference;
        @Nullable
        private String q;
        @Nullable
        private Query query;
        @Nullable
        private List<String> routing;
        @Nullable
        private Integer terminateAfter;

        public Builder() {}

        private Builder(CountRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.lenient = o.lenient;
            this.minScore = o.minScore;
            this.preference = o.preference;
            this.q = o.q;
            this.query = o.query;
            this.routing = _listCopy(o.routing);
            this.terminateAfter = o.terminateAfter;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.lenient = o.lenient;
            this.minScore = o.minScore;
            this.preference = o.preference;
            this.q = o.q;
            this.query = o.query;
            this.routing = _listCopy(o.routing);
            this.terminateAfter = o.terminateAfter;
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
         * If <code>true</code>, wildcard and prefix queries are analyzed. This parameter can only be used when the <code>q</code> query
         * string parameter is specified.
         * <p>
         * API name: {@code analyze_wildcard}
         * </p>
         */
        @Nonnull
        public final Builder analyzeWildcard(@Nullable Boolean value) {
            this.analyzeWildcard = value;
            return this;
        }

        /**
         * Analyzer to use for the query string. This parameter can only be used when the <code>q</code> query string parameter is
         * specified.
         * <p>
         * API name: {@code analyzer}
         * </p>
         */
        @Nonnull
        public final Builder analyzer(@Nullable String value) {
            this.analyzer = value;
            return this;
        }

        /**
         * The default operator for query string query: <code>AND</code> or <code>OR</code>. This parameter can only be used when the
         * <code>q</code> query string parameter is specified.
         * <p>
         * API name: {@code default_operator}
         * </p>
         */
        @Nonnull
        public final Builder defaultOperator(@Nullable Operator value) {
            this.defaultOperator = value;
            return this;
        }

        /**
         * Field to use as default where no field prefix is given in the query string. This parameter can only be used when the
         * <code>q</code> query string parameter is specified.
         * <p>
         * API name: {@code df}
         * </p>
         */
        @Nonnull
        public final Builder df(@Nullable String value) {
            this.df = value;
            return this;
        }

        /**
         * Specifies the type of index that wildcard expressions can match. Supports comma-separated values.
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
         * Specifies the type of index that wildcard expressions can match. Supports comma-separated values.
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
         * If <code>true</code>, concrete, expanded or aliased indexes are ignored when frozen.
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
         * Comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search all data
         * streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * Comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search all data
         * streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * If <code>true</code>, format-based query failures (such as providing text to a numeric field) in the query string will be
         * ignored.
         * <p>
         * API name: {@code lenient}
         * </p>
         */
        @Nonnull
        public final Builder lenient(@Nullable Boolean value) {
            this.lenient = value;
            return this;
        }

        /**
         * Sets the minimum <code>_score</code> value that documents must have to be included in the result.
         * <p>
         * API name: {@code min_score}
         * </p>
         */
        @Nonnull
        public final Builder minScore(@Nullable Float value) {
            this.minScore = value;
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
         * Query in the Lucene query string syntax.
         * <p>
         * API name: {@code q}
         * </p>
         */
        @Nonnull
        public final Builder q(@Nullable String value) {
            this.q = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable Query value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return query(fn.apply(new Query.Builder()).build());
        }

        /**
         * Custom value used to route operations to a specific shard.
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
         * Custom value used to route operations to a specific shard.
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
         * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
         * OpenSearch collects documents before sorting.
         * <p>
         * API name: {@code terminate_after}
         * </p>
         */
        @Nonnull
        public final Builder terminateAfter(@Nullable Integer value) {
            this.terminateAfter = value;
            return this;
        }

        /**
         * Builds a {@link CountRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CountRequest build() {
            _checkSingleUse();

            return new CountRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CountRequest}
     */
    public static final JsonpDeserializer<CountRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CountRequest::setupCountRequestDeserializer
    );

    protected static void setupCountRequestDeserializer(ObjectDeserializer<CountRequest.Builder> op) {
        op.add(Builder::query, Query._DESERIALIZER, "query");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (this.analyzeWildcard != null) {
            params.put("analyze_wildcard", String.valueOf(this.analyzeWildcard));
        }
        if (this.analyzer != null) {
            params.put("analyzer", this.analyzer);
        }
        if (this.defaultOperator != null) {
            params.put("default_operator", this.defaultOperator.jsonValue());
        }
        if (this.df != null) {
            params.put("df", this.df);
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
        if (this.lenient != null) {
            params.put("lenient", String.valueOf(this.lenient));
        }
        if (this.minScore != null) {
            params.put("min_score", String.valueOf(this.minScore));
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (this.q != null) {
            params.put("q", this.q);
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.terminateAfter != null) {
            params.put("terminate_after", String.valueOf(this.terminateAfter));
        }
    }

    /**
     * Endpoint "{@code count}".
     */
    public static final Endpoint<CountRequest, CountResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_count";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_count");
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
        CountResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.df);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.ignoreThrottled);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.minScore);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.q);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.terminateAfter);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CountRequest other = (CountRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.df, other.df)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.ignoreThrottled, other.ignoreThrottled)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.minScore, other.minScore)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.q, other.q)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.terminateAfter, other.terminateAfter);
    }
}
