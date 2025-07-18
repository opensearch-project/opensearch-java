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

package org.opensearch.client.opensearch.knn;

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
import org.opensearch.client.opensearch._types.SearchType;
import org.opensearch.client.opensearch._types.SuggestMode;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.query_dsl.Operator;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: knn.search_models.Request

/**
 * Use an OpenSearch query to search for models in the index.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SearchModelsRequest extends RequestBase implements ToCopyableBuilder<SearchModelsRequest.Builder, SearchModelsRequest> {

    @Nullable
    private final Boolean allowNoIndices;

    @Nullable
    private final Boolean allowPartialSearchResults;

    @Nullable
    private final Boolean analyzeWildcard;

    @Nullable
    private final String analyzer;

    @Nullable
    private final Integer batchedReduceSize;

    @Nullable
    private final Boolean ccsMinimizeRoundtrips;

    @Nullable
    private final Operator defaultOperator;

    @Nullable
    private final String df;

    @Nonnull
    private final List<String> docvalueFields;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean explain;

    @Nullable
    private final Integer from;

    @Nullable
    private final Boolean ignoreThrottled;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final Integer maxConcurrentShardRequests;

    @Nullable
    private final Integer preFilterShardSize;

    @Nullable
    private final String preference;

    @Nullable
    private final String q;

    @Nullable
    private final Boolean requestCache;

    @Nullable
    private final Boolean restTotalHitsAsInt;

    @Nonnull
    private final List<String> routing;

    @Nullable
    private final Time scroll;

    @Nullable
    private final SearchType searchType;

    @Nullable
    private final Boolean seqNoPrimaryTerm;

    @Nullable
    private final Integer size;

    @Nonnull
    private final List<String> sort;

    @Nonnull
    private final List<String> source;

    @Nonnull
    private final List<String> sourceExcludes;

    @Nonnull
    private final List<String> sourceIncludes;

    @Nonnull
    private final List<String> stats;

    @Nonnull
    private final List<String> storedFields;

    @Nullable
    private final String suggestField;

    @Nullable
    private final SuggestMode suggestMode;

    @Nullable
    private final Integer suggestSize;

    @Nullable
    private final String suggestText;

    @Nullable
    private final Integer terminateAfter;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Boolean trackScores;

    @Nullable
    private final Boolean trackTotalHits;

    @Nullable
    private final Boolean version;

    // ---------------------------------------------------------------------------------------------

    private SearchModelsRequest(Builder builder) {
        super(builder);
        this.allowNoIndices = builder.allowNoIndices;
        this.allowPartialSearchResults = builder.allowPartialSearchResults;
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.batchedReduceSize = builder.batchedReduceSize;
        this.ccsMinimizeRoundtrips = builder.ccsMinimizeRoundtrips;
        this.defaultOperator = builder.defaultOperator;
        this.df = builder.df;
        this.docvalueFields = ApiTypeHelper.unmodifiable(builder.docvalueFields);
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.explain = builder.explain;
        this.from = builder.from;
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.lenient = builder.lenient;
        this.maxConcurrentShardRequests = builder.maxConcurrentShardRequests;
        this.preFilterShardSize = builder.preFilterShardSize;
        this.preference = builder.preference;
        this.q = builder.q;
        this.requestCache = builder.requestCache;
        this.restTotalHitsAsInt = builder.restTotalHitsAsInt;
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.scroll = builder.scroll;
        this.searchType = builder.searchType;
        this.seqNoPrimaryTerm = builder.seqNoPrimaryTerm;
        this.size = builder.size;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.source = ApiTypeHelper.unmodifiable(builder.source);
        this.sourceExcludes = ApiTypeHelper.unmodifiable(builder.sourceExcludes);
        this.sourceIncludes = ApiTypeHelper.unmodifiable(builder.sourceIncludes);
        this.stats = ApiTypeHelper.unmodifiable(builder.stats);
        this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
        this.suggestField = builder.suggestField;
        this.suggestMode = builder.suggestMode;
        this.suggestSize = builder.suggestSize;
        this.suggestText = builder.suggestText;
        this.terminateAfter = builder.terminateAfter;
        this.timeout = builder.timeout;
        this.trackScores = builder.trackScores;
        this.trackTotalHits = builder.trackTotalHits;
        this.version = builder.version;
    }

    public static SearchModelsRequest of(Function<SearchModelsRequest.Builder, ObjectBuilder<SearchModelsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or when
     * no indexes have been specified).
     * <p>
     * API name: {@code allow_no_indices}
     * </p>
     */
    @Nullable
    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    /**
     * Indicate if an error should be returned if there is a partial search failure or timeout.
     * <p>
     * API name: {@code allow_partial_search_results}
     * </p>
     */
    @Nullable
    public final Boolean allowPartialSearchResults() {
        return this.allowPartialSearchResults;
    }

    /**
     * Specify whether wildcard and prefix queries should be analyzed.
     * <p>
     * API name: {@code analyze_wildcard}
     * </p>
     */
    @Nullable
    public final Boolean analyzeWildcard() {
        return this.analyzeWildcard;
    }

    /**
     * The analyzer to use for the query string.
     * <p>
     * API name: {@code analyzer}
     * </p>
     */
    @Nullable
    public final String analyzer() {
        return this.analyzer;
    }

    /**
     * The number of shard results that should be reduced at once on the coordinating node. This value should be used as a protection
     * mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.
     * <p>
     * API name: {@code batched_reduce_size}
     * </p>
     */
    @Nullable
    public final Integer batchedReduceSize() {
        return this.batchedReduceSize;
    }

    /**
     * Indicates whether network round-trips should be minimized as part of cross-cluster search requests execution.
     * <p>
     * API name: {@code ccs_minimize_roundtrips}
     * </p>
     */
    @Nullable
    public final Boolean ccsMinimizeRoundtrips() {
        return this.ccsMinimizeRoundtrips;
    }

    /**
     * The default operator for query string query (AND or OR).
     * <p>
     * API name: {@code default_operator}
     * </p>
     */
    @Nullable
    public final Operator defaultOperator() {
        return this.defaultOperator;
    }

    /**
     * The field to use as default where no field prefix is given in the query string.
     * <p>
     * API name: {@code df}
     * </p>
     */
    @Nullable
    public final String df() {
        return this.df;
    }

    /**
     * A comma-separated list of fields to return as the docvalue representation of a field for each hit.
     * <p>
     * API name: {@code docvalue_fields}
     * </p>
     */
    @Nonnull
    public final List<String> docvalueFields() {
        return this.docvalueFields;
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
     * Specify whether to return detailed information about score computation as part of a hit.
     * <p>
     * API name: {@code explain}
     * </p>
     */
    @Nullable
    public final Boolean explain() {
        return this.explain;
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
     * Whether specified concrete, expanded or aliased indexes should be ignored when throttled.
     * <p>
     * API name: {@code ignore_throttled}
     * </p>
     */
    @Nullable
    public final Boolean ignoreThrottled() {
        return this.ignoreThrottled;
    }

    /**
     * Whether specified concrete indexes should be ignored when unavailable (missing or closed).
     * <p>
     * API name: {@code ignore_unavailable}
     * </p>
     */
    @Nullable
    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    /**
     * Specify whether format-based query failures (such as providing text to a numeric field) should be ignored.
     * <p>
     * API name: {@code lenient}
     * </p>
     */
    @Nullable
    public final Boolean lenient() {
        return this.lenient;
    }

    /**
     * The number of concurrent shard requests per node this search executes concurrently. This value should be used to limit the impact of
     * the search on the cluster in order to limit the number of concurrent shard requests.
     * <p>
     * API name: {@code max_concurrent_shard_requests}
     * </p>
     */
    @Nullable
    public final Integer maxConcurrentShardRequests() {
        return this.maxConcurrentShardRequests;
    }

    /**
     * Threshold that enforces a pre-filter round-trip to prefilter search shards based on query rewriting if the number of shards the
     * search request expands to exceeds the threshold. This filter round-trip can limit the number of shards significantly if for instance
     * a shard can not match any documents based on its rewrite method, that is if date filters are mandatory to match but the shard bounds
     * and the query are disjoint.
     * <p>
     * API name: {@code pre_filter_shard_size}
     * </p>
     */
    @Nullable
    public final Integer preFilterShardSize() {
        return this.preFilterShardSize;
    }

    /**
     * Specify the node or shard the operation should be performed on.
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
     * Specify if request cache should be used for this request or not, defaults to index level setting.
     * <p>
     * API name: {@code request_cache}
     * </p>
     */
    @Nullable
    public final Boolean requestCache() {
        return this.requestCache;
    }

    /**
     * Indicates whether <code>hits.total</code> should be rendered as an integer or an object in the rest search response.
     * <p>
     * API name: {@code rest_total_hits_as_int}
     * </p>
     */
    @Nullable
    public final Boolean restTotalHitsAsInt() {
        return this.restTotalHitsAsInt;
    }

    /**
     * A comma-separated list of specific routing values.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nonnull
    public final List<String> routing() {
        return this.routing;
    }

    /**
     * Specify how long a consistent view of the index should be maintained for scrolled search.
     * <p>
     * API name: {@code scroll}
     * </p>
     */
    @Nullable
    public final Time scroll() {
        return this.scroll;
    }

    /**
     * Search operation type.
     * <p>
     * API name: {@code search_type}
     * </p>
     */
    @Nullable
    public final SearchType searchType() {
        return this.searchType;
    }

    /**
     * Specify whether to return sequence number and primary term of the last modification of each hit.
     * <p>
     * API name: {@code seq_no_primary_term}
     * </p>
     */
    @Nullable
    public final Boolean seqNoPrimaryTerm() {
        return this.seqNoPrimaryTerm;
    }

    /**
     * Number of hits to return.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
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
    @Nonnull
    public final List<String> source() {
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
     * Specific 'tag' of the request for logging and statistical purposes.
     * <p>
     * API name: {@code stats}
     * </p>
     */
    @Nonnull
    public final List<String> stats() {
        return this.stats;
    }

    /**
     * A comma-separated list of stored fields to return.
     * <p>
     * API name: {@code stored_fields}
     * </p>
     */
    @Nonnull
    public final List<String> storedFields() {
        return this.storedFields;
    }

    /**
     * Specify which field to use for suggestions.
     * <p>
     * API name: {@code suggest_field}
     * </p>
     */
    @Nullable
    public final String suggestField() {
        return this.suggestField;
    }

    /**
     * Specify suggest mode.
     * <p>
     * API name: {@code suggest_mode}
     * </p>
     */
    @Nullable
    public final SuggestMode suggestMode() {
        return this.suggestMode;
    }

    /**
     * How many suggestions to return in response.
     * <p>
     * API name: {@code suggest_size}
     * </p>
     */
    @Nullable
    public final Integer suggestSize() {
        return this.suggestSize;
    }

    /**
     * The source text for which the suggestions should be returned.
     * <p>
     * API name: {@code suggest_text}
     * </p>
     */
    @Nullable
    public final String suggestText() {
        return this.suggestText;
    }

    /**
     * The maximum number of documents to collect for each shard, upon reaching which the query execution will terminate early.
     * <p>
     * API name: {@code terminate_after}
     * </p>
     */
    @Nullable
    public final Integer terminateAfter() {
        return this.terminateAfter;
    }

    /**
     * Operation timeout.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * Whether to calculate and return scores even if they are not used for sorting.
     * <p>
     * API name: {@code track_scores}
     * </p>
     */
    @Nullable
    public final Boolean trackScores() {
        return this.trackScores;
    }

    /**
     * Indicate if the number of documents that match the query should be tracked.
     * <p>
     * API name: {@code track_total_hits}
     * </p>
     */
    @Nullable
    public final Boolean trackTotalHits() {
        return this.trackTotalHits;
    }

    /**
     * Whether to return document version as part of a hit.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Boolean version() {
        return this.version;
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
     * Builder for {@link SearchModelsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SearchModelsRequest> {
        @Nullable
        private Boolean allowNoIndices;
        @Nullable
        private Boolean allowPartialSearchResults;
        @Nullable
        private Boolean analyzeWildcard;
        @Nullable
        private String analyzer;
        @Nullable
        private Integer batchedReduceSize;
        @Nullable
        private Boolean ccsMinimizeRoundtrips;
        @Nullable
        private Operator defaultOperator;
        @Nullable
        private String df;
        @Nullable
        private List<String> docvalueFields;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean explain;
        @Nullable
        private Integer from;
        @Nullable
        private Boolean ignoreThrottled;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Boolean lenient;
        @Nullable
        private Integer maxConcurrentShardRequests;
        @Nullable
        private Integer preFilterShardSize;
        @Nullable
        private String preference;
        @Nullable
        private String q;
        @Nullable
        private Boolean requestCache;
        @Nullable
        private Boolean restTotalHitsAsInt;
        @Nullable
        private List<String> routing;
        @Nullable
        private Time scroll;
        @Nullable
        private SearchType searchType;
        @Nullable
        private Boolean seqNoPrimaryTerm;
        @Nullable
        private Integer size;
        @Nullable
        private List<String> sort;
        @Nullable
        private List<String> source;
        @Nullable
        private List<String> sourceExcludes;
        @Nullable
        private List<String> sourceIncludes;
        @Nullable
        private List<String> stats;
        @Nullable
        private List<String> storedFields;
        @Nullable
        private String suggestField;
        @Nullable
        private SuggestMode suggestMode;
        @Nullable
        private Integer suggestSize;
        @Nullable
        private String suggestText;
        @Nullable
        private Integer terminateAfter;
        @Nullable
        private Time timeout;
        @Nullable
        private Boolean trackScores;
        @Nullable
        private Boolean trackTotalHits;
        @Nullable
        private Boolean version;

        public Builder() {}

        private Builder(SearchModelsRequest o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.allowPartialSearchResults = o.allowPartialSearchResults;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.batchedReduceSize = o.batchedReduceSize;
            this.ccsMinimizeRoundtrips = o.ccsMinimizeRoundtrips;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.from = o.from;
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.lenient = o.lenient;
            this.maxConcurrentShardRequests = o.maxConcurrentShardRequests;
            this.preFilterShardSize = o.preFilterShardSize;
            this.preference = o.preference;
            this.q = o.q;
            this.requestCache = o.requestCache;
            this.restTotalHitsAsInt = o.restTotalHitsAsInt;
            this.routing = _listCopy(o.routing);
            this.scroll = o.scroll;
            this.searchType = o.searchType;
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
            this.source = _listCopy(o.source);
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.stats = _listCopy(o.stats);
            this.storedFields = _listCopy(o.storedFields);
            this.suggestField = o.suggestField;
            this.suggestMode = o.suggestMode;
            this.suggestSize = o.suggestSize;
            this.suggestText = o.suggestText;
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.trackScores = o.trackScores;
            this.trackTotalHits = o.trackTotalHits;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.allowNoIndices = o.allowNoIndices;
            this.allowPartialSearchResults = o.allowPartialSearchResults;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.batchedReduceSize = o.batchedReduceSize;
            this.ccsMinimizeRoundtrips = o.ccsMinimizeRoundtrips;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.from = o.from;
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.lenient = o.lenient;
            this.maxConcurrentShardRequests = o.maxConcurrentShardRequests;
            this.preFilterShardSize = o.preFilterShardSize;
            this.preference = o.preference;
            this.q = o.q;
            this.requestCache = o.requestCache;
            this.restTotalHitsAsInt = o.restTotalHitsAsInt;
            this.routing = _listCopy(o.routing);
            this.scroll = o.scroll;
            this.searchType = o.searchType;
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.sort = _listCopy(o.sort);
            this.source = _listCopy(o.source);
            this.sourceExcludes = _listCopy(o.sourceExcludes);
            this.sourceIncludes = _listCopy(o.sourceIncludes);
            this.stats = _listCopy(o.stats);
            this.storedFields = _listCopy(o.storedFields);
            this.suggestField = o.suggestField;
            this.suggestMode = o.suggestMode;
            this.suggestSize = o.suggestSize;
            this.suggestText = o.suggestText;
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.trackScores = o.trackScores;
            this.trackTotalHits = o.trackTotalHits;
            this.version = o.version;
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
         * Whether to ignore if a wildcard indexes expression resolves into no concrete indexes. (This includes <code>_all</code> string or
         * when no indexes have been specified).
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
         * Indicate if an error should be returned if there is a partial search failure or timeout.
         * <p>
         * API name: {@code allow_partial_search_results}
         * </p>
         */
        @Nonnull
        public final Builder allowPartialSearchResults(@Nullable Boolean value) {
            this.allowPartialSearchResults = value;
            return this;
        }

        /**
         * Specify whether wildcard and prefix queries should be analyzed.
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
         * The analyzer to use for the query string.
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
         * The number of shard results that should be reduced at once on the coordinating node. This value should be used as a protection
         * mechanism to reduce the memory overhead per search request if the potential number of shards in the request can be large.
         * <p>
         * API name: {@code batched_reduce_size}
         * </p>
         */
        @Nonnull
        public final Builder batchedReduceSize(@Nullable Integer value) {
            this.batchedReduceSize = value;
            return this;
        }

        /**
         * Indicates whether network round-trips should be minimized as part of cross-cluster search requests execution.
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
         * The default operator for query string query (AND or OR).
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
         * The field to use as default where no field prefix is given in the query string.
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
         * A comma-separated list of fields to return as the docvalue representation of a field for each hit.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(List<String> list) {
            this.docvalueFields = _listAddAll(this.docvalueFields, list);
            return this;
        }

        /**
         * A comma-separated list of fields to return as the docvalue representation of a field for each hit.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(String value, String... values) {
            this.docvalueFields = _listAdd(this.docvalueFields, value, values);
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
         * Specify whether to return detailed information about score computation as part of a hit.
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
         * Whether specified concrete, expanded or aliased indexes should be ignored when throttled.
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
         * Whether specified concrete indexes should be ignored when unavailable (missing or closed).
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
         * Specify whether format-based query failures (such as providing text to a numeric field) should be ignored.
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
         * The number of concurrent shard requests per node this search executes concurrently. This value should be used to limit the impact
         * of the search on the cluster in order to limit the number of concurrent shard requests.
         * <p>
         * API name: {@code max_concurrent_shard_requests}
         * </p>
         */
        @Nonnull
        public final Builder maxConcurrentShardRequests(@Nullable Integer value) {
            this.maxConcurrentShardRequests = value;
            return this;
        }

        /**
         * Threshold that enforces a pre-filter round-trip to prefilter search shards based on query rewriting if the number of shards the
         * search request expands to exceeds the threshold. This filter round-trip can limit the number of shards significantly if for
         * instance a shard can not match any documents based on its rewrite method, that is if date filters are mandatory to match but the
         * shard bounds and the query are disjoint.
         * <p>
         * API name: {@code pre_filter_shard_size}
         * </p>
         */
        @Nonnull
        public final Builder preFilterShardSize(@Nullable Integer value) {
            this.preFilterShardSize = value;
            return this;
        }

        /**
         * Specify the node or shard the operation should be performed on.
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
         * Specify if request cache should be used for this request or not, defaults to index level setting.
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
         * Indicates whether <code>hits.total</code> should be rendered as an integer or an object in the rest search response.
         * <p>
         * API name: {@code rest_total_hits_as_int}
         * </p>
         */
        @Nonnull
        public final Builder restTotalHitsAsInt(@Nullable Boolean value) {
            this.restTotalHitsAsInt = value;
            return this;
        }

        /**
         * A comma-separated list of specific routing values.
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
         * A comma-separated list of specific routing values.
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
         * Specify how long a consistent view of the index should be maintained for scrolled search.
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
         * Specify how long a consistent view of the index should be maintained for scrolled search.
         * <p>
         * API name: {@code scroll}
         * </p>
         */
        @Nonnull
        public final Builder scroll(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return scroll(fn.apply(new Time.Builder()).build());
        }

        /**
         * Search operation type.
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
         * Specify whether to return sequence number and primary term of the last modification of each hit.
         * <p>
         * API name: {@code seq_no_primary_term}
         * </p>
         */
        @Nonnull
        public final Builder seqNoPrimaryTerm(@Nullable Boolean value) {
            this.seqNoPrimaryTerm = value;
            return this;
        }

        /**
         * Number of hits to return.
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
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>source</code>.
         * </p>
         */
        @Nonnull
        public final Builder source(List<String> list) {
            this.source = _listAddAll(this.source, list);
            return this;
        }

        /**
         * Set to <code>true</code> or <code>false</code> to return the <code>_source</code> field or not, or a list of fields to return.
         * <p>
         * API name: {@code _source}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>source</code>.
         * </p>
         */
        @Nonnull
        public final Builder source(String value, String... values) {
            this.source = _listAdd(this.source, value, values);
            return this;
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
         * Specific 'tag' of the request for logging and statistical purposes.
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
         * Specific 'tag' of the request for logging and statistical purposes.
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
         * A comma-separated list of stored fields to return.
         * <p>
         * API name: {@code stored_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(List<String> list) {
            this.storedFields = _listAddAll(this.storedFields, list);
            return this;
        }

        /**
         * A comma-separated list of stored fields to return.
         * <p>
         * API name: {@code stored_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(String value, String... values) {
            this.storedFields = _listAdd(this.storedFields, value, values);
            return this;
        }

        /**
         * Specify which field to use for suggestions.
         * <p>
         * API name: {@code suggest_field}
         * </p>
         */
        @Nonnull
        public final Builder suggestField(@Nullable String value) {
            this.suggestField = value;
            return this;
        }

        /**
         * Specify suggest mode.
         * <p>
         * API name: {@code suggest_mode}
         * </p>
         */
        @Nonnull
        public final Builder suggestMode(@Nullable SuggestMode value) {
            this.suggestMode = value;
            return this;
        }

        /**
         * How many suggestions to return in response.
         * <p>
         * API name: {@code suggest_size}
         * </p>
         */
        @Nonnull
        public final Builder suggestSize(@Nullable Integer value) {
            this.suggestSize = value;
            return this;
        }

        /**
         * The source text for which the suggestions should be returned.
         * <p>
         * API name: {@code suggest_text}
         * </p>
         */
        @Nonnull
        public final Builder suggestText(@Nullable String value) {
            this.suggestText = value;
            return this;
        }

        /**
         * The maximum number of documents to collect for each shard, upon reaching which the query execution will terminate early.
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
         * Operation timeout.
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
         * Operation timeout.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Whether to calculate and return scores even if they are not used for sorting.
         * <p>
         * API name: {@code track_scores}
         * </p>
         */
        @Nonnull
        public final Builder trackScores(@Nullable Boolean value) {
            this.trackScores = value;
            return this;
        }

        /**
         * Indicate if the number of documents that match the query should be tracked.
         * <p>
         * API name: {@code track_total_hits}
         * </p>
         */
        @Nonnull
        public final Builder trackTotalHits(@Nullable Boolean value) {
            this.trackTotalHits = value;
            return this;
        }

        /**
         * Whether to return document version as part of a hit.
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
         * Builds a {@link SearchModelsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchModelsRequest build() {
            _checkSingleUse();

            return new SearchModelsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        params.put("typed_keys", "true");
        if (this.allowNoIndices != null) {
            params.put("allow_no_indices", String.valueOf(this.allowNoIndices));
        }
        if (this.allowPartialSearchResults != null) {
            params.put("allow_partial_search_results", String.valueOf(this.allowPartialSearchResults));
        }
        if (this.analyzeWildcard != null) {
            params.put("analyze_wildcard", String.valueOf(this.analyzeWildcard));
        }
        if (this.analyzer != null) {
            params.put("analyzer", this.analyzer);
        }
        if (this.batchedReduceSize != null) {
            params.put("batched_reduce_size", String.valueOf(this.batchedReduceSize));
        }
        if (this.ccsMinimizeRoundtrips != null) {
            params.put("ccs_minimize_roundtrips", String.valueOf(this.ccsMinimizeRoundtrips));
        }
        if (this.defaultOperator != null) {
            params.put("default_operator", this.defaultOperator.jsonValue());
        }
        if (this.df != null) {
            params.put("df", this.df);
        }
        if (ApiTypeHelper.isDefined(this.docvalueFields)) {
            params.put("docvalue_fields", String.join(",", this.docvalueFields));
        }
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.explain != null) {
            params.put("explain", String.valueOf(this.explain));
        }
        if (this.from != null) {
            params.put("from", String.valueOf(this.from));
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
        if (this.maxConcurrentShardRequests != null) {
            params.put("max_concurrent_shard_requests", String.valueOf(this.maxConcurrentShardRequests));
        }
        if (this.preFilterShardSize != null) {
            params.put("pre_filter_shard_size", String.valueOf(this.preFilterShardSize));
        }
        if (this.preference != null) {
            params.put("preference", this.preference);
        }
        if (this.q != null) {
            params.put("q", this.q);
        }
        if (this.requestCache != null) {
            params.put("request_cache", String.valueOf(this.requestCache));
        }
        if (this.restTotalHitsAsInt != null) {
            params.put("rest_total_hits_as_int", String.valueOf(this.restTotalHitsAsInt));
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
        if (this.seqNoPrimaryTerm != null) {
            params.put("seq_no_primary_term", String.valueOf(this.seqNoPrimaryTerm));
        }
        if (this.size != null) {
            params.put("size", String.valueOf(this.size));
        }
        if (ApiTypeHelper.isDefined(this.sort)) {
            params.put("sort", String.join(",", this.sort));
        }
        if (ApiTypeHelper.isDefined(this.source)) {
            params.put("_source", String.join(",", this.source));
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
        if (ApiTypeHelper.isDefined(this.storedFields)) {
            params.put("stored_fields", String.join(",", this.storedFields));
        }
        if (this.suggestField != null) {
            params.put("suggest_field", this.suggestField);
        }
        if (this.suggestMode != null) {
            params.put("suggest_mode", this.suggestMode.jsonValue());
        }
        if (this.suggestSize != null) {
            params.put("suggest_size", String.valueOf(this.suggestSize));
        }
        if (this.suggestText != null) {
            params.put("suggest_text", this.suggestText);
        }
        if (this.terminateAfter != null) {
            params.put("terminate_after", String.valueOf(this.terminateAfter));
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.trackScores != null) {
            params.put("track_scores", String.valueOf(this.trackScores));
        }
        if (this.trackTotalHits != null) {
            params.put("track_total_hits", String.valueOf(this.trackTotalHits));
        }
        if (this.version != null) {
            params.put("version", String.valueOf(this.version));
        }
    }

    /**
     * Endpoint "{@code knn.search_models}".
     */
    public static final Endpoint<SearchModelsRequest, SearchModelsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_knn/models/_search",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        SearchModelsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.allowPartialSearchResults);
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.batchedReduceSize);
        result = 31 * result + Objects.hashCode(this.ccsMinimizeRoundtrips);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.df);
        result = 31 * result + Objects.hashCode(this.docvalueFields);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.explain);
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.ignoreThrottled);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.maxConcurrentShardRequests);
        result = 31 * result + Objects.hashCode(this.preFilterShardSize);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.q);
        result = 31 * result + Objects.hashCode(this.requestCache);
        result = 31 * result + Objects.hashCode(this.restTotalHitsAsInt);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.scroll);
        result = 31 * result + Objects.hashCode(this.searchType);
        result = 31 * result + Objects.hashCode(this.seqNoPrimaryTerm);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.sourceExcludes);
        result = 31 * result + Objects.hashCode(this.sourceIncludes);
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.storedFields);
        result = 31 * result + Objects.hashCode(this.suggestField);
        result = 31 * result + Objects.hashCode(this.suggestMode);
        result = 31 * result + Objects.hashCode(this.suggestSize);
        result = 31 * result + Objects.hashCode(this.suggestText);
        result = 31 * result + Objects.hashCode(this.terminateAfter);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.trackScores);
        result = 31 * result + Objects.hashCode(this.trackTotalHits);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchModelsRequest other = (SearchModelsRequest) o;
        return Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.allowPartialSearchResults, other.allowPartialSearchResults)
            && Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.batchedReduceSize, other.batchedReduceSize)
            && Objects.equals(this.ccsMinimizeRoundtrips, other.ccsMinimizeRoundtrips)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.df, other.df)
            && Objects.equals(this.docvalueFields, other.docvalueFields)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.explain, other.explain)
            && Objects.equals(this.from, other.from)
            && Objects.equals(this.ignoreThrottled, other.ignoreThrottled)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.maxConcurrentShardRequests, other.maxConcurrentShardRequests)
            && Objects.equals(this.preFilterShardSize, other.preFilterShardSize)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.q, other.q)
            && Objects.equals(this.requestCache, other.requestCache)
            && Objects.equals(this.restTotalHitsAsInt, other.restTotalHitsAsInt)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.scroll, other.scroll)
            && Objects.equals(this.searchType, other.searchType)
            && Objects.equals(this.seqNoPrimaryTerm, other.seqNoPrimaryTerm)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.sourceExcludes, other.sourceExcludes)
            && Objects.equals(this.sourceIncludes, other.sourceIncludes)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.storedFields, other.storedFields)
            && Objects.equals(this.suggestField, other.suggestField)
            && Objects.equals(this.suggestMode, other.suggestMode)
            && Objects.equals(this.suggestSize, other.suggestSize)
            && Objects.equals(this.suggestText, other.suggestText)
            && Objects.equals(this.terminateAfter, other.terminateAfter)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.trackScores, other.trackScores)
            && Objects.equals(this.trackTotalHits, other.trackTotalHits)
            && Objects.equals(this.version, other.version);
    }
}
