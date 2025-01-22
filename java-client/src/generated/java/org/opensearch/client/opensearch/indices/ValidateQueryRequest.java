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

// typedef: indices.validate_query.Request

/**
 * Allows a user to validate a potentially expensive query without executing it.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ValidateQueryRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ValidateQueryRequest.Builder, ValidateQueryRequest> {

    @Nullable
    private final Boolean allShards;

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
    private final Boolean explain;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final String q;

    @Nullable
    private final Query query;

    @Nullable
    private final Boolean rewrite;

    // ---------------------------------------------------------------------------------------------

    private ValidateQueryRequest(Builder builder) {
        super(builder);
        this.allShards = builder.allShards;
        this.allowNoIndices = builder.allowNoIndices;
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.defaultOperator = builder.defaultOperator;
        this.df = builder.df;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.explain = builder.explain;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.lenient = builder.lenient;
        this.q = builder.q;
        this.query = builder.query;
        this.rewrite = builder.rewrite;
    }

    public static ValidateQueryRequest of(Function<ValidateQueryRequest.Builder, ObjectBuilder<ValidateQueryRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * If <code>true</code>, the validation is executed on all shards instead of one random shard per index.
     * <p>
     * API name: {@code all_shards}
     * </p>
     */
    @Nullable
    public final Boolean allShards() {
        return this.allShards;
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
     * If <code>true</code>, wildcard and prefix queries are analyzed.
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
     * The default operator for query string query: <code>AND</code> or <code>OR</code>.
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
     * If <code>true</code>, the response returns detailed information if an error has occurred.
     * <p>
     * API name: {@code explain}
     * </p>
     */
    @Nullable
    public final Boolean explain() {
        return this.explain;
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
     * or indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
     * If <code>true</code>, returns a more detailed explanation showing the actual Lucene query that will be executed.
     * <p>
     * API name: {@code rewrite}
     * </p>
     */
    @Nullable
    public final Boolean rewrite() {
        return this.rewrite;
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
     * Builder for {@link ValidateQueryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ValidateQueryRequest> {
        @Nullable
        private Boolean allShards;
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
        private Boolean explain;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private List<String> index;
        @Nullable
        private Boolean lenient;
        @Nullable
        private String q;
        @Nullable
        private Query query;
        @Nullable
        private Boolean rewrite;

        public Builder() {}

        private Builder(ValidateQueryRequest o) {
            super(o);
            this.allShards = o.allShards;
            this.allowNoIndices = o.allowNoIndices;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.lenient = o.lenient;
            this.q = o.q;
            this.query = o.query;
            this.rewrite = o.rewrite;
        }

        private Builder(Builder o) {
            super(o);
            this.allShards = o.allShards;
            this.allowNoIndices = o.allowNoIndices;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.lenient = o.lenient;
            this.q = o.q;
            this.query = o.query;
            this.rewrite = o.rewrite;
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
         * If <code>true</code>, the validation is executed on all shards instead of one random shard per index.
         * <p>
         * API name: {@code all_shards}
         * </p>
         */
        @Nonnull
        public final Builder allShards(@Nullable Boolean value) {
            this.allShards = value;
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
         * If <code>true</code>, wildcard and prefix queries are analyzed.
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
         * The default operator for query string query: <code>AND</code> or <code>OR</code>.
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
         * If <code>true</code>, the response returns detailed information if an error has occurred.
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
         * streams or indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * streams or indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * If <code>true</code>, returns a more detailed explanation showing the actual Lucene query that will be executed.
         * <p>
         * API name: {@code rewrite}
         * </p>
         */
        @Nonnull
        public final Builder rewrite(@Nullable Boolean value) {
            this.rewrite = value;
            return this;
        }

        /**
         * Builds a {@link ValidateQueryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ValidateQueryRequest build() {
            _checkSingleUse();

            return new ValidateQueryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ValidateQueryRequest}
     */
    public static final JsonpDeserializer<ValidateQueryRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ValidateQueryRequest::setupValidateQueryRequestDeserializer
    );

    protected static void setupValidateQueryRequestDeserializer(ObjectDeserializer<ValidateQueryRequest.Builder> op) {
        op.add(Builder::query, Query._DESERIALIZER, "query");
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.allShards != null) {
            params.put("all_shards", String.valueOf(this.allShards));
        }
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
        if (this.explain != null) {
            params.put("explain", String.valueOf(this.explain));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.lenient != null) {
            params.put("lenient", String.valueOf(this.lenient));
        }
        if (this.q != null) {
            params.put("q", this.q);
        }
        if (this.rewrite != null) {
            params.put("rewrite", String.valueOf(this.rewrite));
        }
    }

    /**
     * Endpoint "{@code indices.validate_query}".
     */
    public static final Endpoint<ValidateQueryRequest, ValidateQueryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_validate/query";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_validate/query");
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
        ValidateQueryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allShards);
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.df);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.explain);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.q);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.rewrite);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ValidateQueryRequest other = (ValidateQueryRequest) o;
        return Objects.equals(this.allShards, other.allShards)
            && Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.df, other.df)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.explain, other.explain)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.q, other.q)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.rewrite, other.rewrite);
    }
}
