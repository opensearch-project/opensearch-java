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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.ScriptField;
import org.opensearch.client.opensearch._types.SearchType;
import org.opensearch.client.opensearch._types.SlicedScroll;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.query_dsl.FieldAndFormat;
import org.opensearch.client.opensearch._types.query_dsl.Operator;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.search.FieldCollapse;
import org.opensearch.client.opensearch.core.search.Highlight;
import org.opensearch.client.opensearch.core.search.PointInTimeReference;
import org.opensearch.client.opensearch.core.search.Rescore;
import org.opensearch.client.opensearch.core.search.SourceConfig;
import org.opensearch.client.opensearch.core.search.Suggester;
import org.opensearch.client.opensearch.core.search.TrackHits;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _global.search.Request

/**
 * Returns results matching a query.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SearchRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SearchRequest.Builder, SearchRequest> {

    @Nonnull
    private final Map<String, Aggregation> aggregations;

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
    private final Time cancelAfterTimeInterval;

    @Nullable
    private final Boolean ccsMinimizeRoundtrips;

    @Nullable
    private final FieldCollapse collapse;

    @Nullable
    private final Operator defaultOperator;

    @Nullable
    private final String df;

    @Nonnull
    private final List<FieldAndFormat> docvalueFields;

    @Nonnull
    private final List<ExpandWildcard> expandWildcards;

    @Nullable
    private final Boolean explain;

    @Nonnull
    private final Map<String, JsonData> ext;

    @Nonnull
    private final List<FieldAndFormat> fields;

    @Nullable
    private final Integer from;

    @Nullable
    private final Highlight highlight;

    @Nullable
    private final Boolean ignoreThrottled;

    @Nullable
    private final Boolean ignoreUnavailable;

    @Nullable
    private final Boolean includeNamedQueriesScore;

    @Nonnull
    private final List<String> index;

    @Nonnull
    private final List<Map<String, Float>> indicesBoost;

    @Nullable
    private final Boolean lenient;

    @Nullable
    private final Integer maxConcurrentShardRequests;

    @Nullable
    private final Float minScore;

    @Nullable
    private final Boolean phaseTook;

    @Nullable
    private final String pipeline;

    @Nullable
    private final PointInTimeReference pit;

    @Nullable
    private final Query postFilter;

    @Nullable
    private final Integer preFilterShardSize;

    @Nullable
    private final String preference;

    @Nullable
    private final Boolean profile;

    @Nullable
    private final String q;

    @Nullable
    private final Query query;

    @Nullable
    private final Boolean requestCache;

    @Nonnull
    private final List<Rescore> rescore;

    @Nonnull
    private final List<String> routing;

    @Nonnull
    private final Map<String, ScriptField> scriptFields;

    @Nullable
    private final Time scroll;

    @Nonnull
    private final List<FieldValue> searchAfter;

    @Nullable
    private final SearchType searchType;

    @Nullable
    private final Boolean seqNoPrimaryTerm;

    @Nullable
    private final Integer size;

    @Nullable
    private final SlicedScroll slice;

    @Nonnull
    private final List<SortOptions> sort;

    @Nullable
    private final SourceConfig source;

    @Nonnull
    private final List<String> stats;

    @Nonnull
    private final List<String> storedFields;

    @Nullable
    private final Suggester suggest;

    @Nullable
    private final Integer terminateAfter;

    @Nullable
    private final String timeout;

    @Nullable
    private final Boolean trackScores;

    @Nullable
    private final TrackHits trackTotalHits;

    @Nullable
    private final Boolean verbosePipeline;

    @Nullable
    private final Boolean version;

    // ---------------------------------------------------------------------------------------------

    private SearchRequest(Builder builder) {
        super(builder);
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.allowNoIndices = builder.allowNoIndices;
        this.allowPartialSearchResults = builder.allowPartialSearchResults;
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.batchedReduceSize = builder.batchedReduceSize;
        this.cancelAfterTimeInterval = builder.cancelAfterTimeInterval;
        this.ccsMinimizeRoundtrips = builder.ccsMinimizeRoundtrips;
        this.collapse = builder.collapse;
        this.defaultOperator = builder.defaultOperator;
        this.df = builder.df;
        this.docvalueFields = ApiTypeHelper.unmodifiable(builder.docvalueFields);
        this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
        this.explain = builder.explain;
        this.ext = ApiTypeHelper.unmodifiable(builder.ext);
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.from = builder.from;
        this.highlight = builder.highlight;
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.includeNamedQueriesScore = builder.includeNamedQueriesScore;
        this.index = ApiTypeHelper.unmodifiable(builder.index);
        this.indicesBoost = ApiTypeHelper.unmodifiable(builder.indicesBoost);
        this.lenient = builder.lenient;
        this.maxConcurrentShardRequests = builder.maxConcurrentShardRequests;
        this.minScore = builder.minScore;
        this.phaseTook = builder.phaseTook;
        this.pipeline = builder.pipeline;
        this.pit = builder.pit;
        this.postFilter = builder.postFilter;
        this.preFilterShardSize = builder.preFilterShardSize;
        this.preference = builder.preference;
        this.profile = builder.profile;
        this.q = builder.q;
        this.query = builder.query;
        this.requestCache = builder.requestCache;
        this.rescore = ApiTypeHelper.unmodifiable(builder.rescore);
        this.routing = ApiTypeHelper.unmodifiable(builder.routing);
        this.scriptFields = ApiTypeHelper.unmodifiable(builder.scriptFields);
        this.scroll = builder.scroll;
        this.searchAfter = ApiTypeHelper.unmodifiable(builder.searchAfter);
        this.searchType = builder.searchType;
        this.seqNoPrimaryTerm = builder.seqNoPrimaryTerm;
        this.size = builder.size;
        this.slice = builder.slice;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.source = builder.source;
        this.stats = ApiTypeHelper.unmodifiable(builder.stats);
        this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
        this.suggest = builder.suggest;
        this.terminateAfter = builder.terminateAfter;
        this.timeout = builder.timeout;
        this.trackScores = builder.trackScores;
        this.trackTotalHits = builder.trackTotalHits;
        this.verbosePipeline = builder.verbosePipeline;
        this.version = builder.version;
    }

    public static SearchRequest of(Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Defines the aggregations that are run as part of the search request.
     * <p>
     * API name: {@code aggregations}
     * </p>
     */
    @Nonnull
    public final Map<String, Aggregation> aggregations() {
        return this.aggregations;
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
     * If <code>true</code>, returns partial results if there are shard request timeouts or shard failures. If <code>false</code>, returns
     * an error with no partial results.
     * <p>
     * API name: {@code allow_partial_search_results}
     * </p>
     */
    @Nullable
    public final Boolean allowPartialSearchResults() {
        return this.allowPartialSearchResults;
    }

    /**
     * If <code>true</code>, wildcard and prefix queries are analyzed. This parameter can only be used when the q query string parameter is
     * specified.
     * <p>
     * API name: {@code analyze_wildcard}
     * </p>
     */
    @Nullable
    public final Boolean analyzeWildcard() {
        return this.analyzeWildcard;
    }

    /**
     * Analyzer to use for the query string. This parameter can only be used when the q query string parameter is specified.
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
     * The time after which the search request will be canceled. Request-level parameter takes precedence over
     * <code>cancel_after_time_interval</code> cluster setting.
     * <p>
     * API name: {@code cancel_after_time_interval}
     * </p>
     */
    @Nullable
    public final Time cancelAfterTimeInterval() {
        return this.cancelAfterTimeInterval;
    }

    /**
     * If <code>true</code>, network round-trips between the coordinating node and the remote clusters are minimized when executing
     * cross-cluster search (CCS) requests.
     * <p>
     * API name: {@code ccs_minimize_roundtrips}
     * </p>
     */
    @Nullable
    public final Boolean ccsMinimizeRoundtrips() {
        return this.ccsMinimizeRoundtrips;
    }

    /**
     * API name: {@code collapse}
     */
    @Nullable
    public final FieldCollapse collapse() {
        return this.collapse;
    }

    /**
     * The default operator for query string query: AND or OR. This parameter can only be used when the <code>q</code> query string
     * parameter is specified.
     * <p>
     * API name: {@code default_operator}
     * </p>
     */
    @Nullable
    public final Operator defaultOperator() {
        return this.defaultOperator;
    }

    /**
     * Field to use as default where no field prefix is given in the query string. This parameter can only be used when the q query string
     * parameter is specified.
     * <p>
     * API name: {@code df}
     * </p>
     */
    @Nullable
    public final String df() {
        return this.df;
    }

    /**
     * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
     * <code>hits.fields</code> property of the response.
     * <p>
     * API name: {@code docvalue_fields}
     * </p>
     */
    @Nonnull
    public final List<FieldAndFormat> docvalueFields() {
        return this.docvalueFields;
    }

    /**
     * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
     * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
     * <p>
     * API name: {@code expand_wildcards}
     * </p>
     */
    @Nonnull
    public final List<ExpandWildcard> expandWildcards() {
        return this.expandWildcards;
    }

    /**
     * If <code>true</code>, returns detailed information about score computation as part of a hit.
     * <p>
     * API name: {@code explain}
     * </p>
     */
    @Nullable
    public final Boolean explain() {
        return this.explain;
    }

    /**
     * Configuration of search extensions defined by OpenSearch plugins.
     * <p>
     * API name: {@code ext}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> ext() {
        return this.ext;
    }

    /**
     * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
     * <code>hits.fields</code> property of the response.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<FieldAndFormat> fields() {
        return this.fields;
    }

    /**
     * Starting document offset. Needs to be non-negative. By default, you cannot page through more than 10,000 hits using the
     * <code>from</code> and <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * API name: {@code highlight}
     */
    @Nullable
    public final Highlight highlight() {
        return this.highlight;
    }

    /**
     * If <code>true</code>, concrete, expanded or aliased indexes will be ignored when frozen.
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
     * Indicates whether <code>hit.matched_queries</code> should be rendered as a map that includes the name of the matched query associated
     * with its score (true) or as an array containing the name of the matched queries (false)
     * <p>
     * API name: {@code include_named_queries_score}
     * </p>
     */
    @Nullable
    public final Boolean includeNamedQueriesScore() {
        return this.includeNamedQueriesScore;
    }

    /**
     * A comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search all data
     * streams and indexes, omit this parameter or use <code>*</code> or <code>_all</code>.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nonnull
    public final List<String> index() {
        return this.index;
    }

    /**
     * Boosts the <code>_score</code> of documents from specified indexes.
     * <p>
     * API name: {@code indices_boost}
     * </p>
     */
    @Nonnull
    public final List<Map<String, Float>> indicesBoost() {
        return this.indicesBoost;
    }

    /**
     * If <code>true</code>, format-based query failures (such as providing text to a numeric field) in the query string will be ignored.
     * This parameter can only be used when the <code>q</code> query string parameter is specified.
     * <p>
     * API name: {@code lenient}
     * </p>
     */
    @Nullable
    public final Boolean lenient() {
        return this.lenient;
    }

    /**
     * Defines the number of concurrent shard requests per node this search executes concurrently. This value should be used to limit the
     * impact of the search on the cluster in order to limit the number of concurrent shard requests.
     * <p>
     * API name: {@code max_concurrent_shard_requests}
     * </p>
     */
    @Nullable
    public final Integer maxConcurrentShardRequests() {
        return this.maxConcurrentShardRequests;
    }

    /**
     * Minimum <code>_score</code> for matching documents. Documents with a lower <code>_score</code> are not included in the search
     * results.
     * <p>
     * API name: {@code min_score}
     * </p>
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
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
     * API name: {@code pit}
     */
    @Nullable
    public final PointInTimeReference pit() {
        return this.pit;
    }

    /**
     * API name: {@code post_filter}
     */
    @Nullable
    public final Query postFilter() {
        return this.postFilter;
    }

    /**
     * Defines a threshold that enforces a pre-filter roundtrip to prefilter search shards based on query rewriting if the number of shards
     * the search request expands to exceeds the threshold. This filter roundtrip can limit the number of shards significantly if for
     * instance a shard can not match any documents based on its rewrite method (if date filters are mandatory to match but the shard bounds
     * and the query are disjoint). When unspecified, the pre-filter phase is executed if any of these conditions is met: the request
     * targets more than 128 shards; the request targets one or more read-only index; the primary sort of the query targets an indexed
     * field.
     * <p>
     * API name: {@code pre_filter_shard_size}
     * </p>
     */
    @Nullable
    public final Integer preFilterShardSize() {
        return this.preFilterShardSize;
    }

    /**
     * Nodes and shards used for the search. By default, OpenSearch selects from eligible nodes and shards using adaptive replica selection,
     * accounting for allocation awareness. Valid values are: <code>_only_local</code> to run the search only on shards on the local node;
     * <code>_local</code> to, if possible, run the search on shards on the local node, or if not, select shards using the default method;
     * <code>_only_nodes:&lt;node-id&gt;,&lt;node-id&gt;</code> to run the search on only the specified nodes IDs, where, if suitable shards
     * exist on more than one selected node, use shards on those nodes using the default method, or if none of the specified nodes are
     * available, select shards from any available node using the default method; <code>_prefer_nodes:&lt;node-id&gt;,&lt;node-id&gt;</code>
     * to if possible, run the search on the specified nodes IDs, or if not, select shards using the default method;
     * <code>_shards:&lt;shard&gt;,&lt;shard&gt;</code> to run the search only on the specified shards; <code>&lt;custom-string&gt;</code>
     * (any string that does not start with <code>_</code>) to route searches with the same <code>&lt;custom-string&gt;</code> to the same
     * shards in the same order.
     * <p>
     * API name: {@code preference}
     * </p>
     */
    @Nullable
    public final String preference() {
        return this.preference;
    }

    /**
     * Set to <code>true</code> to return detailed timing information about the execution of individual components in a search request.
     * NOTE: This is a debugging tool and adds significant overhead to search execution.
     * <p>
     * API name: {@code profile}
     * </p>
     */
    @Nullable
    public final Boolean profile() {
        return this.profile;
    }

    /**
     * Query in the Lucene query string syntax using query parameter search. Query parameter searches do not support the full OpenSearch
     * Query DSL but are handy for testing.
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
     * If <code>true</code>, the caching of search results is enabled for requests where <code>size</code> is <code>0</code>. Defaults to
     * index level settings.
     * <p>
     * API name: {@code request_cache}
     * </p>
     */
    @Nullable
    public final Boolean requestCache() {
        return this.requestCache;
    }

    /**
     * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code> and
     * <code>post_filter</code> phases.
     * <p>
     * API name: {@code rescore}
     * </p>
     */
    @Nonnull
    public final List<Rescore> rescore() {
        return this.rescore;
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
     * Retrieve a script evaluation (based on different fields) for each hit.
     * <p>
     * API name: {@code script_fields}
     * </p>
     */
    @Nonnull
    public final Map<String, ScriptField> scriptFields() {
        return this.scriptFields;
    }

    /**
     * Period to retain the search context for scrolling. See Scroll search results. By default, this value cannot exceed <code>1d</code>
     * (24 hours). You can change this limit using the <code>search.max_keep_alive</code> cluster-level setting.
     * <p>
     * API name: {@code scroll}
     * </p>
     */
    @Nullable
    public final Time scroll() {
        return this.scroll;
    }

    /**
     * API name: {@code search_after}
     */
    @Nonnull
    public final List<FieldValue> searchAfter() {
        return this.searchAfter;
    }

    /**
     * How distributed term frequencies are calculated for relevance scoring.
     * <p>
     * API name: {@code search_type}
     * </p>
     */
    @Nullable
    public final SearchType searchType() {
        return this.searchType;
    }

    /**
     * If <code>true</code>, returns sequence number and primary term of the last modification of each hit.
     * <p>
     * API name: {@code seq_no_primary_term}
     * </p>
     */
    @Nullable
    public final Boolean seqNoPrimaryTerm() {
        return this.seqNoPrimaryTerm;
    }

    /**
     * The number of hits to return. By default, you cannot page through more than 10,000 hits using the <code>from</code> and
     * <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
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
     * API name: {@code sort}
     */
    @Nonnull
    public final List<SortOptions> sort() {
        return this.sort;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final SourceConfig source() {
        return this.source;
    }

    /**
     * Stats groups to associate with the search. Each group maintains a statistics aggregation for its associated searches. You can
     * retrieve these stats using the indexes stats API.
     * <p>
     * API name: {@code stats}
     * </p>
     */
    @Nonnull
    public final List<String> stats() {
        return this.stats;
    }

    /**
     * API name: {@code stored_fields}
     */
    @Nonnull
    public final List<String> storedFields() {
        return this.storedFields;
    }

    /**
     * API name: {@code suggest}
     */
    @Nullable
    public final Suggester suggest() {
        return this.suggest;
    }

    /**
     * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
     * OpenSearch collects documents before sorting. Use with caution. OpenSearch applies this parameter to each shard handling the request.
     * When possible, let OpenSearch perform early termination automatically. Avoid specifying this parameter for requests that target data
     * streams with backing indexes across multiple data tiers. If set to <code>0</code> (default), the query does not terminate early.
     * <p>
     * API name: {@code terminate_after}
     * </p>
     */
    @Nullable
    public final Integer terminateAfter() {
        return this.terminateAfter;
    }

    /**
     * Specifies the period of time to wait for a response from each shard. If no response is received before the timeout expires, the
     * request fails and returns an error. Defaults to no timeout.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final String timeout() {
        return this.timeout;
    }

    /**
     * If <code>true</code>, calculate and return document scores, even if the scores are not used for sorting.
     * <p>
     * API name: {@code track_scores}
     * </p>
     */
    @Nullable
    public final Boolean trackScores() {
        return this.trackScores;
    }

    /**
     * API name: {@code track_total_hits}
     */
    @Nullable
    public final TrackHits trackTotalHits() {
        return this.trackTotalHits;
    }

    /**
     * Enables or disables verbose mode for the search pipeline. When verbose mode is enabled, detailed information about each processor in
     * the search pipeline is included in the search response. This includes the processor name, execution status, input, output, and time
     * taken for processing. This parameter is primarily intended for debugging purposes, allowing users to track how data flows and
     * transforms through the search pipeline.
     * <p>
     * API name: {@code verbose_pipeline}
     * </p>
     */
    @Nullable
    public final Boolean verbosePipeline() {
        return this.verbosePipeline;
    }

    /**
     * If <code>true</code>, returns document version as part of a hit.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Boolean version() {
        return this.version;
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
        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            generator.writeStartObject();
            for (Map.Entry<String, Aggregation> item0 : this.aggregations.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.collapse != null) {
            generator.writeKey("collapse");
            this.collapse.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.docvalueFields)) {
            generator.writeKey("docvalue_fields");
            generator.writeStartArray();
            for (FieldAndFormat item0 : this.docvalueFields) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.explain != null) {
            generator.writeKey("explain");
            generator.write(this.explain);
        }

        if (ApiTypeHelper.isDefined(this.ext)) {
            generator.writeKey("ext");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.ext.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (FieldAndFormat item0 : this.fields) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (this.highlight != null) {
            generator.writeKey("highlight");
            this.highlight.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.indicesBoost)) {
            generator.writeKey("indices_boost");
            generator.writeStartArray();
            for (Map<String, Float> item0 : this.indicesBoost) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, Float> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        generator.write(item1.getValue());
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);
        }

        if (this.pit != null) {
            generator.writeKey("pit");
            this.pit.serialize(generator, mapper);
        }

        if (this.postFilter != null) {
            generator.writeKey("post_filter");
            this.postFilter.serialize(generator, mapper);
        }

        if (this.profile != null) {
            generator.writeKey("profile");
            generator.write(this.profile);
        }

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.rescore)) {
            generator.writeKey("rescore");
            generator.writeStartArray();
            for (Rescore item0 : this.rescore) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.scriptFields)) {
            generator.writeKey("script_fields");
            generator.writeStartObject();
            for (Map.Entry<String, ScriptField> item0 : this.scriptFields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.searchAfter)) {
            generator.writeKey("search_after");
            generator.writeStartArray();
            for (FieldValue item0 : this.searchAfter) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.seqNoPrimaryTerm != null) {
            generator.writeKey("seq_no_primary_term");
            generator.write(this.seqNoPrimaryTerm);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.slice != null) {
            generator.writeKey("slice");
            this.slice.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (SortOptions item0 : this.sort) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.source != null) {
            generator.writeKey("_source");
            this.source.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.stats)) {
            generator.writeKey("stats");
            generator.writeStartArray();
            for (String item0 : this.stats) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.storedFields)) {
            generator.writeKey("stored_fields");
            generator.writeStartArray();
            for (String item0 : this.storedFields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.suggest != null) {
            generator.writeKey("suggest");
            this.suggest.serialize(generator, mapper);
        }

        if (this.terminateAfter != null) {
            generator.writeKey("terminate_after");
            generator.write(this.terminateAfter);
        }

        if (this.timeout != null) {
            generator.writeKey("timeout");
            generator.write(this.timeout);
        }

        if (this.trackScores != null) {
            generator.writeKey("track_scores");
            generator.write(this.trackScores);
        }

        if (this.trackTotalHits != null) {
            generator.writeKey("track_total_hits");
            this.trackTotalHits.serialize(generator, mapper);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
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
     * Builder for {@link SearchRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SearchRequest> {
        @Nullable
        private Map<String, Aggregation> aggregations;
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
        private Time cancelAfterTimeInterval;
        @Nullable
        private Boolean ccsMinimizeRoundtrips;
        @Nullable
        private FieldCollapse collapse;
        @Nullable
        private Operator defaultOperator;
        @Nullable
        private String df;
        @Nullable
        private List<FieldAndFormat> docvalueFields;
        @Nullable
        private List<ExpandWildcard> expandWildcards;
        @Nullable
        private Boolean explain;
        @Nullable
        private Map<String, JsonData> ext;
        @Nullable
        private List<FieldAndFormat> fields;
        @Nullable
        private Integer from;
        @Nullable
        private Highlight highlight;
        @Nullable
        private Boolean ignoreThrottled;
        @Nullable
        private Boolean ignoreUnavailable;
        @Nullable
        private Boolean includeNamedQueriesScore;
        @Nullable
        private List<String> index;
        @Nullable
        private List<Map<String, Float>> indicesBoost;
        @Nullable
        private Boolean lenient;
        @Nullable
        private Integer maxConcurrentShardRequests;
        @Nullable
        private Float minScore;
        @Nullable
        private Boolean phaseTook;
        @Nullable
        private String pipeline;
        @Nullable
        private PointInTimeReference pit;
        @Nullable
        private Query postFilter;
        @Nullable
        private Integer preFilterShardSize;
        @Nullable
        private String preference;
        @Nullable
        private Boolean profile;
        @Nullable
        private String q;
        @Nullable
        private Query query;
        @Nullable
        private Boolean requestCache;
        @Nullable
        private List<Rescore> rescore;
        @Nullable
        private List<String> routing;
        @Nullable
        private Map<String, ScriptField> scriptFields;
        @Nullable
        private Time scroll;
        @Nullable
        private List<FieldValue> searchAfter;
        @Nullable
        private SearchType searchType;
        @Nullable
        private Boolean seqNoPrimaryTerm;
        @Nullable
        private Integer size;
        @Nullable
        private SlicedScroll slice;
        @Nullable
        private List<SortOptions> sort;
        @Nullable
        private SourceConfig source;
        @Nullable
        private List<String> stats;
        @Nullable
        private List<String> storedFields;
        @Nullable
        private Suggester suggest;
        @Nullable
        private Integer terminateAfter;
        @Nullable
        private String timeout;
        @Nullable
        private Boolean trackScores;
        @Nullable
        private TrackHits trackTotalHits;
        @Nullable
        private Boolean verbosePipeline;
        @Nullable
        private Boolean version;

        public Builder() {}

        private Builder(SearchRequest o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.allowNoIndices = o.allowNoIndices;
            this.allowPartialSearchResults = o.allowPartialSearchResults;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.batchedReduceSize = o.batchedReduceSize;
            this.cancelAfterTimeInterval = o.cancelAfterTimeInterval;
            this.ccsMinimizeRoundtrips = o.ccsMinimizeRoundtrips;
            this.collapse = o.collapse;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.ext = _mapCopy(o.ext);
            this.fields = _listCopy(o.fields);
            this.from = o.from;
            this.highlight = o.highlight;
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeNamedQueriesScore = o.includeNamedQueriesScore;
            this.index = _listCopy(o.index);
            this.indicesBoost = _listCopy(o.indicesBoost);
            this.lenient = o.lenient;
            this.maxConcurrentShardRequests = o.maxConcurrentShardRequests;
            this.minScore = o.minScore;
            this.phaseTook = o.phaseTook;
            this.pipeline = o.pipeline;
            this.pit = o.pit;
            this.postFilter = o.postFilter;
            this.preFilterShardSize = o.preFilterShardSize;
            this.preference = o.preference;
            this.profile = o.profile;
            this.q = o.q;
            this.query = o.query;
            this.requestCache = o.requestCache;
            this.rescore = _listCopy(o.rescore);
            this.routing = _listCopy(o.routing);
            this.scriptFields = _mapCopy(o.scriptFields);
            this.scroll = o.scroll;
            this.searchAfter = _listCopy(o.searchAfter);
            this.searchType = o.searchType;
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.slice = o.slice;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.stats = _listCopy(o.stats);
            this.storedFields = _listCopy(o.storedFields);
            this.suggest = o.suggest;
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.trackScores = o.trackScores;
            this.trackTotalHits = o.trackTotalHits;
            this.verbosePipeline = o.verbosePipeline;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.allowNoIndices = o.allowNoIndices;
            this.allowPartialSearchResults = o.allowPartialSearchResults;
            this.analyzeWildcard = o.analyzeWildcard;
            this.analyzer = o.analyzer;
            this.batchedReduceSize = o.batchedReduceSize;
            this.cancelAfterTimeInterval = o.cancelAfterTimeInterval;
            this.ccsMinimizeRoundtrips = o.ccsMinimizeRoundtrips;
            this.collapse = o.collapse;
            this.defaultOperator = o.defaultOperator;
            this.df = o.df;
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.expandWildcards = _listCopy(o.expandWildcards);
            this.explain = o.explain;
            this.ext = _mapCopy(o.ext);
            this.fields = _listCopy(o.fields);
            this.from = o.from;
            this.highlight = o.highlight;
            this.ignoreThrottled = o.ignoreThrottled;
            this.ignoreUnavailable = o.ignoreUnavailable;
            this.includeNamedQueriesScore = o.includeNamedQueriesScore;
            this.index = _listCopy(o.index);
            this.indicesBoost = _listCopy(o.indicesBoost);
            this.lenient = o.lenient;
            this.maxConcurrentShardRequests = o.maxConcurrentShardRequests;
            this.minScore = o.minScore;
            this.phaseTook = o.phaseTook;
            this.pipeline = o.pipeline;
            this.pit = o.pit;
            this.postFilter = o.postFilter;
            this.preFilterShardSize = o.preFilterShardSize;
            this.preference = o.preference;
            this.profile = o.profile;
            this.q = o.q;
            this.query = o.query;
            this.requestCache = o.requestCache;
            this.rescore = _listCopy(o.rescore);
            this.routing = _listCopy(o.routing);
            this.scriptFields = _mapCopy(o.scriptFields);
            this.scroll = o.scroll;
            this.searchAfter = _listCopy(o.searchAfter);
            this.searchType = o.searchType;
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.slice = o.slice;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.stats = _listCopy(o.stats);
            this.storedFields = _listCopy(o.storedFields);
            this.suggest = o.suggest;
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.trackScores = o.trackScores;
            this.trackTotalHits = o.trackTotalHits;
            this.verbosePipeline = o.verbosePipeline;
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
         * Defines the aggregations that are run as part of the search request.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(Map<String, Aggregation> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return this;
        }

        /**
         * Defines the aggregations that are run as part of the search request.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(String key, Aggregation value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return this;
        }

        /**
         * Defines the aggregations that are run as part of the search request.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(String key, Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return aggregations(key, fn.apply(new Aggregation.Builder()).build());
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
         * If <code>true</code>, returns partial results if there are shard request timeouts or shard failures. If <code>false</code>,
         * returns an error with no partial results.
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
         * If <code>true</code>, wildcard and prefix queries are analyzed. This parameter can only be used when the q query string parameter
         * is specified.
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
         * Analyzer to use for the query string. This parameter can only be used when the q query string parameter is specified.
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
         * The time after which the search request will be canceled. Request-level parameter takes precedence over
         * <code>cancel_after_time_interval</code> cluster setting.
         * <p>
         * API name: {@code cancel_after_time_interval}
         * </p>
         */
        @Nonnull
        public final Builder cancelAfterTimeInterval(@Nullable Time value) {
            this.cancelAfterTimeInterval = value;
            return this;
        }

        /**
         * The time after which the search request will be canceled. Request-level parameter takes precedence over
         * <code>cancel_after_time_interval</code> cluster setting.
         * <p>
         * API name: {@code cancel_after_time_interval}
         * </p>
         */
        @Nonnull
        public final Builder cancelAfterTimeInterval(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return cancelAfterTimeInterval(fn.apply(new Time.Builder()).build());
        }

        /**
         * If <code>true</code>, network round-trips between the coordinating node and the remote clusters are minimized when executing
         * cross-cluster search (CCS) requests.
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
         * API name: {@code collapse}
         */
        @Nonnull
        public final Builder collapse(@Nullable FieldCollapse value) {
            this.collapse = value;
            return this;
        }

        /**
         * API name: {@code collapse}
         */
        @Nonnull
        public final Builder collapse(Function<FieldCollapse.Builder, ObjectBuilder<FieldCollapse>> fn) {
            return collapse(fn.apply(new FieldCollapse.Builder()).build());
        }

        /**
         * The default operator for query string query: AND or OR. This parameter can only be used when the <code>q</code> query string
         * parameter is specified.
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
         * Field to use as default where no field prefix is given in the query string. This parameter can only be used when the q query
         * string parameter is specified.
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
         * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(List<FieldAndFormat> list) {
            this.docvalueFields = _listAddAll(this.docvalueFields, list);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(FieldAndFormat value, FieldAndFormat... values) {
            this.docvalueFields = _listAdd(this.docvalueFields, value, values);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>docvalueFields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
            return docvalueFields(fn.apply(new FieldAndFormat.Builder()).build());
        }

        /**
         * Type of index that wildcard patterns can match. If the request can target data streams, this argument determines whether wildcard
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
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
         * expressions match hidden data streams. Supports comma-separated values, such as <code>open,hidden</code>.
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
         * If <code>true</code>, returns detailed information about score computation as part of a hit.
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
         * Configuration of search extensions defined by OpenSearch plugins.
         * <p>
         * API name: {@code ext}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>ext</code>.
         * </p>
         */
        @Nonnull
        public final Builder ext(Map<String, JsonData> map) {
            this.ext = _mapPutAll(this.ext, map);
            return this;
        }

        /**
         * Configuration of search extensions defined by OpenSearch plugins.
         * <p>
         * API name: {@code ext}
         * </p>
         *
         * <p>
         * Adds an entry to <code>ext</code>.
         * </p>
         */
        @Nonnull
        public final Builder ext(String key, JsonData value) {
            this.ext = _mapPut(this.ext, key, value);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<FieldAndFormat> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(FieldAndFormat value, FieldAndFormat... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
            return fields(fn.apply(new FieldAndFormat.Builder()).build());
        }

        /**
         * Starting document offset. Needs to be non-negative. By default, you cannot page through more than 10,000 hits using the
         * <code>from</code> and <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
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
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(@Nullable Highlight value) {
            this.highlight = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(Function<Highlight.Builder, ObjectBuilder<Highlight>> fn) {
            return highlight(fn.apply(new Highlight.Builder()).build());
        }

        /**
         * If <code>true</code>, concrete, expanded or aliased indexes will be ignored when frozen.
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
         * Indicates whether <code>hit.matched_queries</code> should be rendered as a map that includes the name of the matched query
         * associated with its score (true) or as an array containing the name of the matched queries (false)
         * <p>
         * API name: {@code include_named_queries_score}
         * </p>
         */
        @Nonnull
        public final Builder includeNamedQueriesScore(@Nullable Boolean value) {
            this.includeNamedQueriesScore = value;
            return this;
        }

        /**
         * A comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search all data
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
         * A comma-separated list of data streams, indexes, and aliases to search. Supports wildcards (<code>*</code>). To search all data
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
         * Boosts the <code>_score</code> of documents from specified indexes.
         * <p>
         * API name: {@code indices_boost}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indicesBoost</code>.
         * </p>
         */
        @Nonnull
        public final Builder indicesBoost(List<Map<String, Float>> list) {
            this.indicesBoost = _listAddAll(this.indicesBoost, list);
            return this;
        }

        /**
         * Boosts the <code>_score</code> of documents from specified indexes.
         * <p>
         * API name: {@code indices_boost}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indicesBoost</code>.
         * </p>
         */
        @Nonnull
        public final Builder indicesBoost(Map<String, Float> value, Map<String, Float>... values) {
            this.indicesBoost = _listAdd(this.indicesBoost, value, values);
            return this;
        }

        /**
         * If <code>true</code>, format-based query failures (such as providing text to a numeric field) in the query string will be
         * ignored. This parameter can only be used when the <code>q</code> query string parameter is specified.
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
         * Defines the number of concurrent shard requests per node this search executes concurrently. This value should be used to limit
         * the impact of the search on the cluster in order to limit the number of concurrent shard requests.
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
         * Minimum <code>_score</code> for matching documents. Documents with a lower <code>_score</code> are not included in the search
         * results.
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
         * API name: {@code pit}
         */
        @Nonnull
        public final Builder pit(@Nullable PointInTimeReference value) {
            this.pit = value;
            return this;
        }

        /**
         * API name: {@code pit}
         */
        @Nonnull
        public final Builder pit(Function<PointInTimeReference.Builder, ObjectBuilder<PointInTimeReference>> fn) {
            return pit(fn.apply(new PointInTimeReference.Builder()).build());
        }

        /**
         * API name: {@code post_filter}
         */
        @Nonnull
        public final Builder postFilter(@Nullable Query value) {
            this.postFilter = value;
            return this;
        }

        /**
         * API name: {@code post_filter}
         */
        @Nonnull
        public final Builder postFilter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return postFilter(fn.apply(new Query.Builder()).build());
        }

        /**
         * Defines a threshold that enforces a pre-filter roundtrip to prefilter search shards based on query rewriting if the number of
         * shards the search request expands to exceeds the threshold. This filter roundtrip can limit the number of shards significantly if
         * for instance a shard can not match any documents based on its rewrite method (if date filters are mandatory to match but the
         * shard bounds and the query are disjoint). When unspecified, the pre-filter phase is executed if any of these conditions is met:
         * the request targets more than 128 shards; the request targets one or more read-only index; the primary sort of the query targets
         * an indexed field.
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
         * Nodes and shards used for the search. By default, OpenSearch selects from eligible nodes and shards using adaptive replica
         * selection, accounting for allocation awareness. Valid values are: <code>_only_local</code> to run the search only on shards on
         * the local node; <code>_local</code> to, if possible, run the search on shards on the local node, or if not, select shards using
         * the default method; <code>_only_nodes:&lt;node-id&gt;,&lt;node-id&gt;</code> to run the search on only the specified nodes IDs,
         * where, if suitable shards exist on more than one selected node, use shards on those nodes using the default method, or if none of
         * the specified nodes are available, select shards from any available node using the default method;
         * <code>_prefer_nodes:&lt;node-id&gt;,&lt;node-id&gt;</code> to if possible, run the search on the specified nodes IDs, or if not,
         * select shards using the default method; <code>_shards:&lt;shard&gt;,&lt;shard&gt;</code> to run the search only on the specified
         * shards; <code>&lt;custom-string&gt;</code> (any string that does not start with <code>_</code>) to route searches with the same
         * <code>&lt;custom-string&gt;</code> to the same shards in the same order.
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
         * Set to <code>true</code> to return detailed timing information about the execution of individual components in a search request.
         * NOTE: This is a debugging tool and adds significant overhead to search execution.
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
         * Query in the Lucene query string syntax using query parameter search. Query parameter searches do not support the full OpenSearch
         * Query DSL but are handy for testing.
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
         * If <code>true</code>, the caching of search results is enabled for requests where <code>size</code> is <code>0</code>. Defaults
         * to index level settings.
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
         * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code>
         * and <code>post_filter</code> phases.
         * <p>
         * API name: {@code rescore}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>rescore</code>.
         * </p>
         */
        @Nonnull
        public final Builder rescore(List<Rescore> list) {
            this.rescore = _listAddAll(this.rescore, list);
            return this;
        }

        /**
         * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code>
         * and <code>post_filter</code> phases.
         * <p>
         * API name: {@code rescore}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>rescore</code>.
         * </p>
         */
        @Nonnull
        public final Builder rescore(Rescore value, Rescore... values) {
            this.rescore = _listAdd(this.rescore, value, values);
            return this;
        }

        /**
         * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code>
         * and <code>post_filter</code> phases.
         * <p>
         * API name: {@code rescore}
         * </p>
         *
         * <p>
         * Adds a value to <code>rescore</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder rescore(Function<Rescore.Builder, ObjectBuilder<Rescore>> fn) {
            return rescore(fn.apply(new Rescore.Builder()).build());
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
         * Retrieve a script evaluation (based on different fields) for each hit.
         * <p>
         * API name: {@code script_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>scriptFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(Map<String, ScriptField> map) {
            this.scriptFields = _mapPutAll(this.scriptFields, map);
            return this;
        }

        /**
         * Retrieve a script evaluation (based on different fields) for each hit.
         * <p>
         * API name: {@code script_fields}
         * </p>
         *
         * <p>
         * Adds an entry to <code>scriptFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(String key, ScriptField value) {
            this.scriptFields = _mapPut(this.scriptFields, key, value);
            return this;
        }

        /**
         * Retrieve a script evaluation (based on different fields) for each hit.
         * <p>
         * API name: {@code script_fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>scriptFields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(String key, Function<ScriptField.Builder, ObjectBuilder<ScriptField>> fn) {
            return scriptFields(key, fn.apply(new ScriptField.Builder()).build());
        }

        /**
         * Period to retain the search context for scrolling. See Scroll search results. By default, this value cannot exceed
         * <code>1d</code> (24 hours). You can change this limit using the <code>search.max_keep_alive</code> cluster-level setting.
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
         * Period to retain the search context for scrolling. See Scroll search results. By default, this value cannot exceed
         * <code>1d</code> (24 hours). You can change this limit using the <code>search.max_keep_alive</code> cluster-level setting.
         * <p>
         * API name: {@code scroll}
         * </p>
         */
        @Nonnull
        public final Builder scroll(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return scroll(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code search_after}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>searchAfter</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchAfter(List<FieldValue> list) {
            this.searchAfter = _listAddAll(this.searchAfter, list);
            return this;
        }

        /**
         * API name: {@code search_after}
         *
         * <p>
         * Adds one or more values to <code>searchAfter</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchAfter(FieldValue value, FieldValue... values) {
            this.searchAfter = _listAdd(this.searchAfter, value, values);
            return this;
        }

        /**
         * API name: {@code search_after}
         *
         * <p>
         * Adds a value to <code>searchAfter</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder searchAfter(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return searchAfter(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * How distributed term frequencies are calculated for relevance scoring.
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
         * If <code>true</code>, returns sequence number and primary term of the last modification of each hit.
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
         * The number of hits to return. By default, you cannot page through more than 10,000 hits using the <code>from</code> and
         * <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
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
         * API name: {@code sort}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(List<SortOptions> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds one or more values to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(SortOptions value, SortOptions... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds a value to <code>sort</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return sort(fn.apply(new SortOptions.Builder()).build());
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(@Nullable SourceConfig value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(Function<SourceConfig.Builder, ObjectBuilder<SourceConfig>> fn) {
            return source(fn.apply(new SourceConfig.Builder()).build());
        }

        /**
         * Stats groups to associate with the search. Each group maintains a statistics aggregation for its associated searches. You can
         * retrieve these stats using the indexes stats API.
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
         * Stats groups to associate with the search. Each group maintains a statistics aggregation for its associated searches. You can
         * retrieve these stats using the indexes stats API.
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
         * API name: {@code stored_fields}
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
         * API name: {@code stored_fields}
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
         * API name: {@code suggest}
         */
        @Nonnull
        public final Builder suggest(@Nullable Suggester value) {
            this.suggest = value;
            return this;
        }

        /**
         * API name: {@code suggest}
         */
        @Nonnull
        public final Builder suggest(Function<Suggester.Builder, ObjectBuilder<Suggester>> fn) {
            return suggest(fn.apply(new Suggester.Builder()).build());
        }

        /**
         * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
         * OpenSearch collects documents before sorting. Use with caution. OpenSearch applies this parameter to each shard handling the
         * request. When possible, let OpenSearch perform early termination automatically. Avoid specifying this parameter for requests that
         * target data streams with backing indexes across multiple data tiers. If set to <code>0</code> (default), the query does not
         * terminate early.
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
         * Specifies the period of time to wait for a response from each shard. If no response is received before the timeout expires, the
         * request fails and returns an error. Defaults to no timeout.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable String value) {
            this.timeout = value;
            return this;
        }

        /**
         * If <code>true</code>, calculate and return document scores, even if the scores are not used for sorting.
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
         * API name: {@code track_total_hits}
         */
        @Nonnull
        public final Builder trackTotalHits(@Nullable TrackHits value) {
            this.trackTotalHits = value;
            return this;
        }

        /**
         * API name: {@code track_total_hits}
         */
        @Nonnull
        public final Builder trackTotalHits(Function<TrackHits.Builder, ObjectBuilder<TrackHits>> fn) {
            return trackTotalHits(fn.apply(new TrackHits.Builder()).build());
        }

        /**
         * Enables or disables verbose mode for the search pipeline. When verbose mode is enabled, detailed information about each processor
         * in the search pipeline is included in the search response. This includes the processor name, execution status, input, output, and
         * time taken for processing. This parameter is primarily intended for debugging purposes, allowing users to track how data flows
         * and transforms through the search pipeline.
         * <p>
         * API name: {@code verbose_pipeline}
         * </p>
         */
        @Nonnull
        public final Builder verbosePipeline(@Nullable Boolean value) {
            this.verbosePipeline = value;
            return this;
        }

        /**
         * If <code>true</code>, returns document version as part of a hit.
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
         * Builds a {@link SearchRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchRequest build() {
            _checkSingleUse();

            return new SearchRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchRequest}
     */
    public static final JsonpDeserializer<SearchRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchRequest::setupSearchRequestDeserializer
    );

    protected static void setupSearchRequestDeserializer(ObjectDeserializer<SearchRequest.Builder> op) {
        op.add(Builder::aggregations, JsonpDeserializer.stringMapDeserializer(Aggregation._DESERIALIZER), "aggregations", "aggs");
        op.add(Builder::collapse, FieldCollapse._DESERIALIZER, "collapse");
        op.add(Builder::docvalueFields, JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "docvalue_fields");
        op.add(Builder::explain, JsonpDeserializer.booleanDeserializer(), "explain");
        op.add(Builder::ext, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "ext");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "fields");
        op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
        op.add(Builder::highlight, Highlight._DESERIALIZER, "highlight");
        op.add(
            Builder::indicesBoost,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.floatDeserializer())),
            "indices_boost"
        );
        op.add(Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(Builder::pit, PointInTimeReference._DESERIALIZER, "pit");
        op.add(Builder::postFilter, Query._DESERIALIZER, "post_filter");
        op.add(Builder::profile, JsonpDeserializer.booleanDeserializer(), "profile");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::rescore, JsonpDeserializer.arrayDeserializer(Rescore._DESERIALIZER), "rescore");
        op.add(Builder::scriptFields, JsonpDeserializer.stringMapDeserializer(ScriptField._DESERIALIZER), "script_fields");
        op.add(Builder::searchAfter, JsonpDeserializer.arrayDeserializer(FieldValue._DESERIALIZER), "search_after");
        op.add(Builder::seqNoPrimaryTerm, JsonpDeserializer.booleanDeserializer(), "seq_no_primary_term");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::slice, SlicedScroll._DESERIALIZER, "slice");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
        op.add(Builder::source, SourceConfig._DESERIALIZER, "_source");
        op.add(Builder::stats, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stats");
        op.add(Builder::storedFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stored_fields");
        op.add(Builder::suggest, Suggester._DESERIALIZER, "suggest");
        op.add(Builder::terminateAfter, JsonpDeserializer.integerDeserializer(), "terminate_after");
        op.add(Builder::timeout, JsonpDeserializer.stringDeserializer(), "timeout");
        op.add(Builder::trackScores, JsonpDeserializer.booleanDeserializer(), "track_scores");
        op.add(Builder::trackTotalHits, TrackHits._DESERIALIZER, "track_total_hits");
        op.add(Builder::version, JsonpDeserializer.booleanDeserializer(), "version");
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
        if (this.cancelAfterTimeInterval != null) {
            params.put("cancel_after_time_interval", this.cancelAfterTimeInterval._toJsonString());
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
        if (ApiTypeHelper.isDefined(this.expandWildcards)) {
            params.put("expand_wildcards", this.expandWildcards.stream().map(v -> v.jsonValue()).collect(Collectors.joining(",")));
        }
        if (this.ignoreThrottled != null) {
            params.put("ignore_throttled", String.valueOf(this.ignoreThrottled));
        }
        if (this.ignoreUnavailable != null) {
            params.put("ignore_unavailable", String.valueOf(this.ignoreUnavailable));
        }
        if (this.includeNamedQueriesScore != null) {
            params.put("include_named_queries_score", String.valueOf(this.includeNamedQueriesScore));
        }
        if (this.lenient != null) {
            params.put("lenient", String.valueOf(this.lenient));
        }
        if (this.maxConcurrentShardRequests != null) {
            params.put("max_concurrent_shard_requests", String.valueOf(this.maxConcurrentShardRequests));
        }
        if (this.phaseTook != null) {
            params.put("phase_took", String.valueOf(this.phaseTook));
        }
        if (this.pipeline != null) {
            params.put("search_pipeline", this.pipeline);
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
        if (ApiTypeHelper.isDefined(this.routing)) {
            params.put("routing", String.join(",", this.routing));
        }
        if (this.scroll != null) {
            params.put("scroll", this.scroll._toJsonString());
        }
        if (this.searchType != null) {
            params.put("search_type", this.searchType.jsonValue());
        }
        if (this.verbosePipeline != null) {
            params.put("verbose_pipeline", String.valueOf(this.verbosePipeline));
        }
    }

    /**
     * Endpoint "{@code search}".
     */
    public static final SimpleEndpoint<SearchRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _index = 1 << 0;

            int propsSet = 0;

            if (ApiTypeHelper.isDefined(request.index())) propsSet |= _index;

            if (propsSet == 0) {
                return "/_search";
            }
            if (propsSet == (_index)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/");
                SimpleEndpoint.pathEncode(String.join(",", request.index), buf);
                buf.append("/_search");
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
        SearchResponse._DESERIALIZER
    );

    /**
     * Create an "{@code search}" endpoint.
     */
    public static <TDocument> Endpoint<SearchRequest, SearchResponse<TDocument>, ErrorResponse> createSearchEndpoint(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return _ENDPOINT.withResponseDeserializer(SearchResponse.createSearchResponseDeserializer(tDocumentDeserializer));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Objects.hashCode(this.allowNoIndices);
        result = 31 * result + Objects.hashCode(this.allowPartialSearchResults);
        result = 31 * result + Objects.hashCode(this.analyzeWildcard);
        result = 31 * result + Objects.hashCode(this.analyzer);
        result = 31 * result + Objects.hashCode(this.batchedReduceSize);
        result = 31 * result + Objects.hashCode(this.cancelAfterTimeInterval);
        result = 31 * result + Objects.hashCode(this.ccsMinimizeRoundtrips);
        result = 31 * result + Objects.hashCode(this.collapse);
        result = 31 * result + Objects.hashCode(this.defaultOperator);
        result = 31 * result + Objects.hashCode(this.df);
        result = 31 * result + Objects.hashCode(this.docvalueFields);
        result = 31 * result + Objects.hashCode(this.expandWildcards);
        result = 31 * result + Objects.hashCode(this.explain);
        result = 31 * result + Objects.hashCode(this.ext);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.highlight);
        result = 31 * result + Objects.hashCode(this.ignoreThrottled);
        result = 31 * result + Objects.hashCode(this.ignoreUnavailable);
        result = 31 * result + Objects.hashCode(this.includeNamedQueriesScore);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indicesBoost);
        result = 31 * result + Objects.hashCode(this.lenient);
        result = 31 * result + Objects.hashCode(this.maxConcurrentShardRequests);
        result = 31 * result + Objects.hashCode(this.minScore);
        result = 31 * result + Objects.hashCode(this.phaseTook);
        result = 31 * result + Objects.hashCode(this.pipeline);
        result = 31 * result + Objects.hashCode(this.pit);
        result = 31 * result + Objects.hashCode(this.postFilter);
        result = 31 * result + Objects.hashCode(this.preFilterShardSize);
        result = 31 * result + Objects.hashCode(this.preference);
        result = 31 * result + Objects.hashCode(this.profile);
        result = 31 * result + Objects.hashCode(this.q);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.requestCache);
        result = 31 * result + Objects.hashCode(this.rescore);
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.scriptFields);
        result = 31 * result + Objects.hashCode(this.scroll);
        result = 31 * result + Objects.hashCode(this.searchAfter);
        result = 31 * result + Objects.hashCode(this.searchType);
        result = 31 * result + Objects.hashCode(this.seqNoPrimaryTerm);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.slice);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.storedFields);
        result = 31 * result + Objects.hashCode(this.suggest);
        result = 31 * result + Objects.hashCode(this.terminateAfter);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.trackScores);
        result = 31 * result + Objects.hashCode(this.trackTotalHits);
        result = 31 * result + Objects.hashCode(this.verbosePipeline);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchRequest other = (SearchRequest) o;
        return Objects.equals(this.aggregations, other.aggregations)
            && Objects.equals(this.allowNoIndices, other.allowNoIndices)
            && Objects.equals(this.allowPartialSearchResults, other.allowPartialSearchResults)
            && Objects.equals(this.analyzeWildcard, other.analyzeWildcard)
            && Objects.equals(this.analyzer, other.analyzer)
            && Objects.equals(this.batchedReduceSize, other.batchedReduceSize)
            && Objects.equals(this.cancelAfterTimeInterval, other.cancelAfterTimeInterval)
            && Objects.equals(this.ccsMinimizeRoundtrips, other.ccsMinimizeRoundtrips)
            && Objects.equals(this.collapse, other.collapse)
            && Objects.equals(this.defaultOperator, other.defaultOperator)
            && Objects.equals(this.df, other.df)
            && Objects.equals(this.docvalueFields, other.docvalueFields)
            && Objects.equals(this.expandWildcards, other.expandWildcards)
            && Objects.equals(this.explain, other.explain)
            && Objects.equals(this.ext, other.ext)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.from, other.from)
            && Objects.equals(this.highlight, other.highlight)
            && Objects.equals(this.ignoreThrottled, other.ignoreThrottled)
            && Objects.equals(this.ignoreUnavailable, other.ignoreUnavailable)
            && Objects.equals(this.includeNamedQueriesScore, other.includeNamedQueriesScore)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indicesBoost, other.indicesBoost)
            && Objects.equals(this.lenient, other.lenient)
            && Objects.equals(this.maxConcurrentShardRequests, other.maxConcurrentShardRequests)
            && Objects.equals(this.minScore, other.minScore)
            && Objects.equals(this.phaseTook, other.phaseTook)
            && Objects.equals(this.pipeline, other.pipeline)
            && Objects.equals(this.pit, other.pit)
            && Objects.equals(this.postFilter, other.postFilter)
            && Objects.equals(this.preFilterShardSize, other.preFilterShardSize)
            && Objects.equals(this.preference, other.preference)
            && Objects.equals(this.profile, other.profile)
            && Objects.equals(this.q, other.q)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.requestCache, other.requestCache)
            && Objects.equals(this.rescore, other.rescore)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.scriptFields, other.scriptFields)
            && Objects.equals(this.scroll, other.scroll)
            && Objects.equals(this.searchAfter, other.searchAfter)
            && Objects.equals(this.searchType, other.searchType)
            && Objects.equals(this.seqNoPrimaryTerm, other.seqNoPrimaryTerm)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.slice, other.slice)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.storedFields, other.storedFields)
            && Objects.equals(this.suggest, other.suggest)
            && Objects.equals(this.terminateAfter, other.terminateAfter)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.trackScores, other.trackScores)
            && Objects.equals(this.trackTotalHits, other.trackTotalHits)
            && Objects.equals(this.verbosePipeline, other.verbosePipeline)
            && Objects.equals(this.version, other.version);
    }
}
