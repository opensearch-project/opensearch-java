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
import org.opensearch.client.opensearch._types.Conflicts;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.SearchType;
import org.opensearch.client.opensearch._types.SlicedScroll;
import org.opensearch.client.opensearch._types.Slices;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.WaitForActiveShards;
import org.opensearch.client.opensearch._types.query_dsl.Operator;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.search.SourceConfigParam;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.delete_by_query.Request

/**
 * Deletes documents matching the provided query.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteByQueryRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeleteByQueryRequest.Builder, DeleteByQueryRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Boolean analyzeWildcard;

    @Nullable
    private final String analyzer;

    @Nullable
    private final Conflicts conflicts;

    @Nullable
    private final Operator defaultOperator;

    @Nullable
    private final String df;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Integer from;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nonnull
    private final List<String> index;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final Integer maxDocs;

    @Nullable
    private final String preference;

    @Nullable
    private final String q;

    @Nullable
    private final Query query;

    @Nullable
    private final Refresh refresh;

    @Nullable
    private final Boolean requestCache;

    @Nullable
    private final Float requestsPerSecond;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final Time scroll;

    @Nullable
    private final Integer scrollSize;

    @Nullable
    private final Time searchTimeout;

    @Nullable
    private final SearchType searchType;

    @Nullable
    private final Integer size;

    @Nullable
    private final SlicedScroll slice;

    @Nullable
    private final Slices slices;

    @Nonnull
    private final List<String> sort;

    @Nullable
    private final SourceConfigParam source;

    @Nonnull
    private final List<String> sourceExcludes;

    @Nonnull
    private final List<String> sourceIncludes;

    @Nonnull
    private final List<String> stats;

    @Nullable
    private final Integer terminateAfter;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Boolean version;

    @Nullable
    private final WaitForActiveShards waitForActiveShards;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private DeleteByQueryRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.conflicts = builder.conflicts;
        this.defaultOperator = builder.defaultOperator;
        this.df = builder.df;
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.from = builder.from;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.index = ApiTypeHelper.unmodifiableRequired(builder.index, this, "index");
        this.lenient = builder.lenient;
        this.maxDocs = builder.maxDocs;
        this.preference = builder.preference;
        this.q = builder.q;
        this.query = builder.query;
        this.refresh = builder.refresh;
        this.requestCache = builder.requestCache;
        this.requestsPerSecond = builder.requestsPerSecond;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.scroll = builder.scroll;
        this.scrollSize = builder.scrollSize;
        this.searchTimeout = builder.searchTimeout;
        this.searchType = builder.searchType;
        this.size = builder.size;
        this.slice = builder.slice;
        this.slices = builder.slices;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.source = builder.source;
        this.sourceExcludes = ApiTypeHelper.unmodifiable(builder.sourceExcludes);
        this.sourceIncludes = ApiTypeHelper.unmodifiable(builder.sourceIncludes);
        this.stats = ApiTypeHelper.unmodifiable(builder.stats);
        this.terminateAfter = builder.terminateAfter;
        this.timeout = builder.timeout;
        this.version = builder.version;
        this.waitForActiveShards = builder.waitForActiveShards;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static DeleteByQueryRequest of(Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn) {
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
     * Analyzer to use for the query string.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * What to do if delete by query hits version conflicts: <code>abort</code> or <code>proceed</code>.
     * <p>
     * API name: {@code conflicts}
     * </p>
     */
    @Nullable
    public final Conflicts conflicts() {
        return this.conflicts;
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
     * Field to use as default where no field prefix is given in the query string.
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
     * Starting offset.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
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
     * Required - Comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search all
     * data streams or indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
     * The maximum number of documents to delete.
     * <p>
     * API name: {@code max_docs}
     * </p>
     */
    @Nullable
    public final Integer maxDocs() {
        return this.maxDocs;
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
     * If <code>true</code>, OpenSearch refreshes all shards involved in the delete by query after the request completes.
     * <p>
     * API name: {@code refresh}
     * </p>
     */
    @Nullable
    public final Refresh refresh() {
        return this.refresh;
    }

    /**
     * If <code>true</code>, the request cache is used for this request. Defaults to the index-level setting.
     * <p>
     * API name: {@code request_cache}
     * </p>
     */
    @Nullable
    public final Boolean requestCache() {
        return this.requestCache;
    }

    /**
     * The throttle for this request in sub-requests per second.
     * <p>
     * API name: {@code requests_per_second}
     * </p>
     */
    @Nullable
    public final Float requestsPerSecond() {
        return this.requestsPerSecond;
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
     * Period to retain the search context for scrolling.
     * <p>
     * API name: {@code scroll}
     * </p>
     */
    @Nullable
    public final Time scroll() {
        return this.scroll;
    }

    /**
     * Size of the scroll request that powers the operation.
     * <p>
     * API name: {@code scroll_size}
     * </p>
     */
    @Nullable
    public final Integer scrollSize() {
        return this.scrollSize;
    }

    /**
     * Explicit timeout for each search request. Defaults to no timeout.
     * <p>
     * API name: {@code search_timeout}
     * </p>
     */
    @Nullable
    public final Time searchTimeout() {
        return this.searchTimeout;
    }

    /**
     * The type of the search operation. Available options: <code>query_then_fetch</code>, <code>dfs_query_then_fetch</code>.
     * <p>
     * API name: {@code search_type}
     * </p>
     */
    @Nullable
    public final SearchType searchType() {
        return this.searchType;
    }

    /**
     * Deprecated, use <code>max_docs</code> instead.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code slice}
     */
    @Nullable
    public final SlicedScroll slice() {
        return this.slice;
    }

    /**
     * The number of slices this task should be divided into.
     * <p>
     * API name: {@code slices}
     * </p>
     */
    @Nullable
    public final Slices slices() {
        return this.slices;
    }

    /**
     * A comma-separated list of &lt;field&gt;:&lt;direction&gt; pairs.
     * <p>
     * API name: {@code sort}
     * </p>
     */
    @Nonnull
    public final List<String> sort() {
        return this.sort;
    }

    /**
     * Set to <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
     * <p>
     * API name: {@code _source}
     * </p>
     */
    @Nullable
    public final SourceConfigParam source() {
        return this.source;
    }

    /**
     * List of fields to exclude from the returned <code>_source</code> field.
     * <p>
     * API name: {@code _source_excludes}
     * </p>
     */
    @Nonnull
    public final List<String> sourceExcludes() {
        return this.sourceExcludes;
    }

    /**
     * List of fields to extract and return from the <code>_source</code> field.
     * <p>
     * API name: {@code _source_includes}
     * </p>
     */
    @Nonnull
    public final List<String> sourceIncludes() {
        return this.sourceIncludes;
    }

    /**
     * Specific <code>tag</code> of the request for logging and statistical purposes.
     * <p>
     * API name: {@code stats}
     * </p>
     */
    @Nonnull
    public final List<String> stats() {
        return this.stats;
    }

    /**
     * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
     * OpenSearch collects documents before sorting. Use with caution. OpenSearch applies this parameter to each shard handling the request.
     * When possible, let OpenSearch perform early termination automatically. Avoid specifying this parameter for requests that target data
     * streams with backing indexes across multiple data tiers.
     * <p>
     * API name: {@code terminate_after}
     * </p>
     */
    @Nullable
    public final Integer terminateAfter() {
        return this.terminateAfter;
    }

    /**
     * Period each deletion request waits for active shards.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * If <code>true</code>, returns the document version as part of a hit.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Boolean version() {
        return this.version;
    }

    /**
     * The number of shard copies that must be active before proceeding with the operation. Set to all or any positive integer up to the
     * total number of shards in the index (<code>number_of_replicas+1</code>).
     * <p>
     * API name: {@code wait_for_active_shards}
     * </p>
     */
    @Nullable
    public final WaitForActiveShards waitForActiveShards() {
        return this.waitForActiveShards;
    }

    /**
     * If <code>true</code>, the request blocks until the operation is complete.
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
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
        if (this.maxDocs != null) {
            generator.writeKey("max_docs");
            generator.write(this.maxDocs);
        }

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

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
     * Builder for {@link DeleteByQueryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DeleteByQueryRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Boolean analyzeWildcard;
        @Nullable
        private String analyzer;
        @Nullable
        private Conflicts conflicts;
        @Nullable
        private Operator defaultOperator;
        @Nullable
        private String df;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Integer from;
        @Nullable
        private Boolean ignoreUnavailable;
        private List<String> index;
        @Nullable
        private Boolean lenient;
        @Nullable
        private Integer maxDocs;
        @Nullable
        private String preference;
        @Nullable
        private String q;
        @Nullable
        private Query query;
        @Nullable
        private Refresh refresh;
        @Nullable
        private Boolean requestCache;
        @Nullable
        private Float requestsPerSecond;
        @Nullable
        private List<String> routing;
        @Nullable
        private Time scroll;
        @Nullable
        private Integer scrollSize;
        @Nullable
        private Time searchTimeout;
        @Nullable
        private SearchType searchType;
        @Nullable
        private Integer size;
        @Nullable
        private SlicedScroll slice;
        @Nullable
        private Slices slices;
        @Nullable
        private List<String> sort;
        @Nullable
        private SourceConfigParam source;
        @Nullable
        private List<String> sourceExcludes;
        @Nullable
        private List<String> sourceIncludes;
        @Nullable
        private List<String> stats;
        @Nullable
        private Integer terminateAfter;
        @Nullable
        private Time timeout;
        @Nullable
        private Boolean version;
        @Nullable
        private WaitForActiveShards waitForActiveShards;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(DeleteByQueryRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.conflicts = o.conflicts;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.from = o.from;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.lenient = o.lenient;
            this.maxDocs = o.maxDocs;
            this.preference = o.preference;
            this.q = o.q;
            this.query = o.query;
            this.refresh = o.refresh;
            this.requestCache = o.requestCache;
            this.requestsPerSecond = o.requestsPerSecond;
            this.routing = _listCopy(o.routing);
            this.scroll = o.scroll;
            this.scrollSize = o.scrollSize;
            this.searchTimeout = o.searchTimeout;
            this.searchType = o.searchType;
            this.size = o.size;
            this.slice = o.slice;
            this.slices = o.slices;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.stats = _listCopy(o.stats);
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.version = o.version;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.conflicts = o.conflicts;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.from = o.from;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.index = _listCopy(o.index);
            this.lenient = o.lenient;
            this.maxDocs = o.maxDocs;
            this.preference = o.preference;
            this.q = o.q;
            this.query = o.query;
            this.refresh = o.refresh;
            this.requestCache = o.requestCache;
            this.requestsPerSecond = o.requestsPerSecond;
            this.routing = _listCopy(o.routing);
            this.scroll = o.scroll;
            this.scrollSize = o.scrollSize;
            this.searchTimeout = o.searchTimeout;
            this.searchType = o.searchType;
            this.size = o.size;
            this.slice = o.slice;
            this.slices = o.slices;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.stats = _listCopy(o.stats);
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.version = o.version;
            this.waitForActiveShards = o.waitForActiveShards;
            this.waitForCompletion = o.waitForCompletion;
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
         * Analyzer to use for the query string.
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
         * What to do if delete by query hits version conflicts: <code>abort</code> or <code>proceed</code>.
         * <p>
         * API name: {@code conflicts}
         * </p>
         */
        @Nonnull
        public final Builder conflicts(@Nullable Conflicts value) {
            this.conflicts = value;
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
         * Field to use as default where no field prefix is given in the query string.
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
         * Starting offset.
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
         * Required - Comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search
         * all data streams or indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * Required - Comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search
         * all data streams or indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
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
         * The maximum number of documents to delete.
         * <p>
         * API name: {@code max_docs}
         * </p>
         */
        @Nonnull
        public final Builder maxDocs(@Nullable Integer value) {
            this.maxDocs = value;
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
         * If <code>true</code>, OpenSearch refreshes all shards involved in the delete by query after the request completes.
         * <p>
         * API name: {@code refresh}
         * </p>
         */
        @Nonnull
        public final Builder refresh(@Nullable Refresh value) {
            this.refresh = value;
            return this;
        }

        /**
         * If <code>true</code>, the request cache is used for this request. Defaults to the index-level setting.
         * <p>
         * API name: {@code request_cache}
         * </p>
         */
        @Nonnull
        public final Builder requestCache(@Nullable Boolean value) {
            this.requestCache = value;
            return this;
        }

        /**
         * The throttle for this request in sub-requests per second.
         * <p>
         * API name: {@code requests_per_second}
         * </p>
         */
        @Nonnull
        public final Builder requestsPerSecond(@Nullable Float value) {
            this.requestsPerSecond = value;
            return this;
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
         * Period to retain the search context for scrolling.
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
         * Period to retain the search context for scrolling.
         * <p>
         * API name: {@code scroll}
         * </p>
         */
        @Nonnull
        public final Builder scroll(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return scroll(fn.apply(new Time.Builder()).build());
        }

        /**
         * Size of the scroll request that powers the operation.
         * <p>
         * API name: {@code scroll_size}
         * </p>
         */
        @Nonnull
        public final Builder scrollSize(@Nullable Integer value) {
            this.scrollSize = value;
            return this;
        }

        /**
         * Explicit timeout for each search request. Defaults to no timeout.
         * <p>
         * API name: {@code search_timeout}
         * </p>
         */
        @Nonnull
        public final Builder searchTimeout(@Nullable Time value) {
            this.searchTimeout = value;
            return this;
        }

        /**
         * Explicit timeout for each search request. Defaults to no timeout.
         * <p>
         * API name: {@code search_timeout}
         * </p>
         */
        @Nonnull
        public final Builder searchTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return searchTimeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * The type of the search operation. Available options: <code>query_then_fetch</code>, <code>dfs_query_then_fetch</code>.
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
         * Deprecated, use <code>max_docs</code> instead.
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
         * The number of slices this task should be divided into.
         * <p>
         * API name: {@code slices}
         * </p>
         */
        @Nonnull
        public final Builder slices(@Nullable Slices value) {
            this.slices = value;
            return this;
        }

        /**
         * The number of slices this task should be divided into.
         * <p>
         * API name: {@code slices}
         * </p>
         */
        @Nonnull
        public final Builder slices(Function<Slices.Builder, ObjectBuilder<Slices>> fn) {
            return slices(fn.apply(new Slices.Builder()).build());
        }

        /**
         * A comma-separated list of &lt;field&gt;:&lt;direction&gt; pairs.
         * <p>
         * API name: {@code sort}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(List<String> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * A comma-separated list of &lt;field&gt;:&lt;direction&gt; pairs.
         * <p>
         * API name: {@code sort}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(String value, String... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * Set to <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder source(@Nullable SourceConfigParam value) {
            this.source = value;
            return this;
        }

        /**
         * Set to <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
         * <p>
         * API name: {@code _source}
         * </p>
         */
        @Nonnull
        public final Builder source(Function<SourceConfigParam.Builder, ObjectBuilder<SourceConfigParam>> fn) {
            return source(fn.apply(new SourceConfigParam.Builder()).build());
        }

        /**
         * List of fields to exclude from the returned <code>_source</code> field.
         * <p>
         * API name: {@code _source_excludes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceExcludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceExcludes(List<String> list) {
            this.sourceExcludes = _listAddAll(this.sourceExcludes, list);
            return this;
        }

        /**
         * List of fields to exclude from the returned <code>_source</code> field.
         * <p>
         * API name: {@code _source_excludes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sourceExcludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceExcludes(String value, String... values) {
            this.sourceExcludes = _listAdd(this.sourceExcludes, value, values);
            return this;
        }

        /**
         * List of fields to extract and return from the <code>_source</code> field.
         * <p>
         * API name: {@code _source_includes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sourceIncludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceIncludes(List<String> list) {
            this.sourceIncludes = _listAddAll(this.sourceIncludes, list);
            return this;
        }

        /**
         * List of fields to extract and return from the <code>_source</code> field.
         * <p>
         * API name: {@code _source_includes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>sourceIncludes</code>.
         * </p>
         */
        @Nonnull
        public final Builder sourceIncludes(String value, String... values) {
            this.sourceIncludes = _listAdd(this.sourceIncludes, value, values);
            return this;
        }

        /**
         * Specific <code>tag</code> of the request for logging and statistical purposes.
         * <p>
         * API name: {@code stats}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stats</code>.
         * </p>
         */
        @Nonnull
        public final Builder stats(List<String> list) {
            this.stats = _listAddAll(this.stats, list);
            return this;
        }

        /**
         * Specific <code>tag</code> of the request for logging and statistical purposes.
         * <p>
         * API name: {@code stats}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>stats</code>.
         * </p>
         */
        @Nonnull
        public final Builder stats(String value, String... values) {
            this.stats = _listAdd(this.stats, value, values);
            return this;
        }

        /**
         * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
         * OpenSearch collects documents before sorting. Use with caution. OpenSearch applies this parameter to each shard handling the
         * request. When possible, let OpenSearch perform early termination automatically. Avoid specifying this parameter for requests that
         * target data streams with backing indexes across multiple data tiers.
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
         * Period each deletion request waits for active shards.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * Period each deletion request waits for active shards.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * If <code>true</code>, returns the document version as part of a hit.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(@Nullable Boolean value) {
            this.version = value;
            return this;
        }

        /**
         * The number of shard copies that must be active before proceeding with the operation. Set to all or any positive integer up to the
         * total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(@Nullable WaitForActiveShards value) {
            this.waitForActiveShards = value;
            return this;
        }

        /**
         * The number of shard copies that must be active before proceeding with the operation. Set to all or any positive integer up to the
         * total number of shards in the index (<code>number_of_replicas+1</code>).
         * <p>
         * API name: {@code wait_for_active_shards}
         * </p>
         */
        @Nonnull
        public final Builder waitForActiveShards(Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
            return waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
        }

        /**
         * If <code>true</code>, the request blocks until the operation is complete.
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        @Nonnull
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link DeleteByQueryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteByQueryRequest build() {
            _checkSingleUse();

            return new DeleteByQueryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteByQueryRequest}
     */
    public static final JsonpDeserializer<DeleteByQueryRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteByQueryRequest::setupDeleteByQueryRequestDeserializer
    );

    protected static void setupDeleteByQueryRequestDeserializer(ObjectDeserializer<DeleteByQueryRequest.Builder> op) {
        op.add(Builder::maxDocs, JsonpDeserializer.integerDeserializer(), "max_docs");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::slice, SlicedScroll._DESERIALIZER, "slice");
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
        if (this.conflicts != null) {
            params.put("conflicts", this.conflicts.jsonValue());
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
        if (this.from != null) {
            params.put("from", String.valueOf(this.from));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.lenient != null) {
            params.put("lenient", String.valueOf(this.lenient));
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (this.q != null) {
            params.put("q", this.q);
        }
        if (this.refresh != null) {
            params.put("refresh", this.refresh.jsonValue());
        }
        if (this.requestCache != null) {
            params.put("request_cache", String.valueOf(this.requestCache));
        }
        if (this.requestsPerSecond != null) {
            params.put("requests_per_second", String.valueOf(this.requestsPerSecond));
        }
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.scroll != null) {
            params.put("scroll", this.scroll._toJsonString());
        }
        if (this.scrollSize != null) {
            params.put("scroll_size", String.valueOf(this.scrollSize));
        }
        if (this.searchTimeout != null) {
            params.put("search_timeout", this.searchTimeout._toJsonString());
        }
        if (this.searchType != null) {
            params.put("search_type", this.searchType.jsonValue());
        }
        if (this.size != null) {
            params.put("size", String.valueOf(this.size));
        }
        if (this.slices != null) {
            params.put("slices", this.slices._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.sort)) {
            params.put("sort", String.join(",", this.sort));
        }
        if (this.source != null) {
            params.put("_source", this.source._toJsonString());
        }
        if (ApiTypeHelper.isDefined(this.sourceExcludes)) {
            params.put("_source_excludes", String.join(",", this.sourceExcludes));
        }
        if (ApiTypeHelper.isDefined(this.sourceIncludes)) {
            params.put("_source_includes", String.join(",", this.sourceIncludes));
        }
        if (ApiTypeHelper.isDefined(this.stats)) {
            params.put("stats", String.join(",", this.stats));
        }
        if (this.terminateAfter != null) {
            params.put("terminate_after", String.valueOf(this.terminateAfter));
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.version != null) {
            params.put("version", String.valueOf(this.version));
        }
        if (this.waitForActiveShards != null) {
            params.put("wait_for_active_shards", this.waitForActiveShards._toJsonString());
        }
        if (this.waitForCompletion != null) {
            params.put("wait_for_completion", String.valueOf(this.waitForCompletion));
        }
    }

    /**
     * Endpoint "{@code delete_by_query}".
     */
    public static final Endpoint<DeleteByQueryRequest, DeleteByQueryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/");
            SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
            buf.append("/_delete_by_query");
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        DeleteByQueryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.conflicts);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.df);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.maxDocs);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.q);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.refresh);
        result = 31 * result + Objects.hashCode(this.requestCache);
        result = 31 * result + Objects.hashCode(this.requestsPerSecond);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.scroll);
        result = 31 * result + Objects.hashCode(this.scrollSize);
        result = 31 * result + Objects.hashCode(this.searchTimeout);
        result = 31 * result + Objects.hashCode(this.searchType);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.slice);
        result = 31 * result + Objects.hashCode(this.slices);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.sourceExcludes);
        result = 31 * result + Objects.hashCode(this.sourceIncludes);
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.terminateAfter);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.waitForActiveShards);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteByQueryRequest other = (DeleteByQueryRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.conflicts, other.conflicts)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.df, other.df)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.from, other.from)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && this.index.equals(other.index)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.maxDocs, other.maxDocs)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.q, other.q)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.refresh, other.refresh)
            && Objects.equals(this.requestCache, other.requestCache)
            && Objects.equals(this.requestsPerSecond, other.requestsPerSecond)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.scroll, other.scroll)
            && Objects.equals(this.scrollSize, other.scrollSize)
            && Objects.equals(this.searchTimeout, other.searchTimeout)
            && Objects.equals(this.searchType, other.searchType)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.slice, other.slice)
            && Objects.equals(this.slices, other.slices)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.sourceExcludes, other.sourceExcludes)
            && Objects.equals(this.sourceIncludes, other.sourceIncludes)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.terminateAfter, other.terminateAfter)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.waitForActiveShards, other.waitForActiveShards)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
