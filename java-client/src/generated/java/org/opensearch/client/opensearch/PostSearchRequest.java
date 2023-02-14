package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.json.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

/** Returns results matching a query. */
@JsonpDeserializable
public class PostSearchRequest extends RequestBase implements JsonpSerializable {
    private final boolean allowNoIndices;
    private final boolean allowPartialSearchResults;
    private final boolean analyzeWildcard;
    private final String analyzer;
    private final int batchedReduceSize;
    private final boolean ccsMinimizeRoundtrips;
    private final DefaultOperator defaultOperator;
    private final String df;
    private final String docvalueFields;
    private final ExpandWildcards expandWildcards;
    private final boolean explain;
    private final List<String> fields;
    private final int from;
    private final boolean ignoreThrottled;
    private final boolean ignoreUnavailable;
    private final List<JsonData> indicesBoost;
    private final boolean lenient;
    private final long maxConcurrentShardRequests;
    private final int minScore;
    private final long preFilterShardSize;
    private final String preference;
    private final String q;
    private final UserDefinedObjectStructure query;
    private final boolean requestCache;
    private final boolean restTotalHitsAsInt;
    private final String routing;
    private final String scroll;
    private final SearchType searchType;
    private final boolean seqNoPrimaryTerm;
    private final int size;
    private final List<String> sort;
    private final String source;
    private final List<String> sourceExcludes;
    private final List<String> sourceIncludes;
    private final String stats;
    private final boolean storedFields;
    private final String suggestField;
    private final SuggestMode suggestMode;
    private final long suggestSize;
    private final String suggestText;
    private final int terminateAfter;
    private final String timeout;
    private final boolean trackScores;
    private final int trackTotalHits;
    private final boolean typedKeys;
    private final boolean version;

    public PostSearchRequest(Builder builder) {
        this.allowNoIndices = builder.allowNoIndices;
        this.allowPartialSearchResults = builder.allowPartialSearchResults;
        this.analyzeWildcard = builder.analyzeWildcard;
        this.analyzer = builder.analyzer;
        this.batchedReduceSize = builder.batchedReduceSize;
        this.ccsMinimizeRoundtrips = builder.ccsMinimizeRoundtrips;
        this.defaultOperator = builder.defaultOperator;
        this.df = builder.df;
        this.docvalueFields = builder.docvalueFields;
        this.expandWildcards = builder.expandWildcards;
        this.explain = builder.explain;
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.from = builder.from;
        this.ignoreThrottled = builder.ignoreThrottled;
        this.ignoreUnavailable = builder.ignoreUnavailable;
        this.indicesBoost = ApiTypeHelper.unmodifiable(builder.indicesBoost);
        this.lenient = builder.lenient;
        this.maxConcurrentShardRequests = builder.maxConcurrentShardRequests;
        this.minScore = builder.minScore;
        this.preFilterShardSize = builder.preFilterShardSize;
        this.preference = builder.preference;
        this.q = builder.q;
        this.query = builder.query;
        this.requestCache = builder.requestCache;
        this.restTotalHitsAsInt = builder.restTotalHitsAsInt;
        this.routing = builder.routing;
        this.scroll = builder.scroll;
        this.searchType = builder.searchType;
        this.seqNoPrimaryTerm = builder.seqNoPrimaryTerm;
        this.size = builder.size;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.source = builder.source;
        this.sourceExcludes = ApiTypeHelper.unmodifiable(builder.sourceExcludes);
        this.sourceIncludes = ApiTypeHelper.unmodifiable(builder.sourceIncludes);
        this.stats = builder.stats;
        this.storedFields = builder.storedFields;
        this.suggestField = builder.suggestField;
        this.suggestMode = builder.suggestMode;
        this.suggestSize = builder.suggestSize;
        this.suggestText = builder.suggestText;
        this.terminateAfter = builder.terminateAfter;
        this.timeout = builder.timeout;
        this.trackScores = builder.trackScores;
        this.trackTotalHits = builder.trackTotalHits;
        this.typedKeys = builder.typedKeys;
        this.version = builder.version;
    }

    public static PostSearchRequest of(Function<Builder, ObjectBuilder<PostSearchRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    public final boolean allowPartialSearchResults() {
        return this.allowPartialSearchResults;
    }

    public final boolean analyzeWildcard() {
        return this.analyzeWildcard;
    }

    public final String analyzer() {
        return this.analyzer;
    }

    public final int batchedReduceSize() {
        return this.batchedReduceSize;
    }

    public final boolean ccsMinimizeRoundtrips() {
        return this.ccsMinimizeRoundtrips;
    }

    public final DefaultOperator defaultOperator() {
        return this.defaultOperator;
    }

    public final String df() {
        return this.df;
    }

    public final String docvalueFields() {
        return this.docvalueFields;
    }

    public final ExpandWildcards expandWildcards() {
        return this.expandWildcards;
    }

    public final boolean explain() {
        return this.explain;
    }

    public final List<String> fields() {
        return this.fields;
    }

    public final int from() {
        return this.from;
    }

    public final boolean ignoreThrottled() {
        return this.ignoreThrottled;
    }

    public final boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    public final List<JsonData> indicesBoost() {
        return this.indicesBoost;
    }

    public final boolean lenient() {
        return this.lenient;
    }

    public final long maxConcurrentShardRequests() {
        return this.maxConcurrentShardRequests;
    }

    public final int minScore() {
        return this.minScore;
    }

    public final long preFilterShardSize() {
        return this.preFilterShardSize;
    }

    public final String preference() {
        return this.preference;
    }

    public final String q() {
        return this.q;
    }

    public final UserDefinedObjectStructure query() {
        return this.query;
    }

    public final boolean requestCache() {
        return this.requestCache;
    }

    public final boolean restTotalHitsAsInt() {
        return this.restTotalHitsAsInt;
    }

    public final String routing() {
        return this.routing;
    }

    public final String scroll() {
        return this.scroll;
    }

    public final SearchType searchType() {
        return this.searchType;
    }

    public final boolean seqNoPrimaryTerm() {
        return this.seqNoPrimaryTerm;
    }

    public final int size() {
        return this.size;
    }

    public final List<String> sort() {
        return this.sort;
    }

    public final String source() {
        return this.source;
    }

    public final List<String> sourceExcludes() {
        return this.sourceExcludes;
    }

    public final List<String> sourceIncludes() {
        return this.sourceIncludes;
    }

    public final String stats() {
        return this.stats;
    }

    public final boolean storedFields() {
        return this.storedFields;
    }

    public final String suggestField() {
        return this.suggestField;
    }

    public final SuggestMode suggestMode() {
        return this.suggestMode;
    }

    public final long suggestSize() {
        return this.suggestSize;
    }

    public final String suggestText() {
        return this.suggestText;
    }

    public final int terminateAfter() {
        return this.terminateAfter;
    }

    public final String timeout() {
        return this.timeout;
    }

    public final boolean trackScores() {
        return this.trackScores;
    }

    public final int trackTotalHits() {
        return this.trackTotalHits;
    }

    public final boolean typedKeys() {
        return this.typedKeys;
    }

    public final boolean version() {
        return this.version;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.docvalueFields != null) {
            generator.writeKey("docvalue_fields");
            generator.write(this.docvalueFields);
        }

        if (this.explain != null) {
            generator.writeKey("explain");
            generator.write(this.explain);
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (String item0 : this.fields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (ApiTypeHelper.isDefined(this.indicesBoost)) {
            generator.writeKey("indices_boost");
            generator.writeStartArray();
            for (JsonData item0 : this.indicesBoost) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);
        }

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

        if (this.seqNoPrimaryTerm != null) {
            generator.writeKey("seq_no_primary_term");
            generator.write(this.seqNoPrimaryTerm);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.source != null) {
            generator.writeKey("source");
            generator.write(this.source);
        }

        if (this.stats != null) {
            generator.writeKey("stats");
            generator.write(this.stats);
        }

        if (this.terminateAfter != null) {
            generator.writeKey("terminate_after");
            generator.write(this.terminateAfter);
        }

        if (this.timeout != null) {
            generator.writeKey("timeout");
            generator.write(this.timeout);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }
    }

    /** Builder for {@link PostSearchRequest}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PostSearchRequest> {
        private boolean allowNoIndices;
        private boolean allowPartialSearchResults;
        private boolean analyzeWildcard;
        private String analyzer;
        private int batchedReduceSize;
        private boolean ccsMinimizeRoundtrips;
        private DefaultOperator defaultOperator;
        private String df;
        private String docvalueFields;
        private ExpandWildcards expandWildcards;
        private boolean explain;
        private List<String> fields;
        private int from;
        private boolean ignoreThrottled;
        private boolean ignoreUnavailable;
        private List<JsonData> indicesBoost;
        private boolean lenient;
        private long maxConcurrentShardRequests;
        private int minScore;
        private long preFilterShardSize;
        private String preference;
        private String q;
        private UserDefinedObjectStructure query;
        private boolean requestCache;
        private boolean restTotalHitsAsInt;
        private String routing;
        private String scroll;
        private SearchType searchType;
        private boolean seqNoPrimaryTerm;
        private int size;
        private List<String> sort;
        private String source;
        private List<String> sourceExcludes;
        private List<String> sourceIncludes;
        private String stats;
        private boolean storedFields;
        private String suggestField;
        private SuggestMode suggestMode;
        private long suggestSize;
        private String suggestText;
        private int terminateAfter;
        private String timeout;
        private boolean trackScores;
        private int trackTotalHits;
        private boolean typedKeys;
        private boolean version;

        public final Builder allowNoIndices(boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        public final Builder allowPartialSearchResults(boolean value) {
            this.allowPartialSearchResults = value;
            return this;
        }

        public final Builder analyzeWildcard(boolean value) {
            this.analyzeWildcard = value;
            return this;
        }

        public final Builder analyzer(String value) {
            this.analyzer = value;
            return this;
        }

        public final Builder batchedReduceSize(int value) {
            this.batchedReduceSize = value;
            return this;
        }

        public final Builder ccsMinimizeRoundtrips(boolean value) {
            this.ccsMinimizeRoundtrips = value;
            return this;
        }

        public final Builder defaultOperator(DefaultOperator value) {
            this.defaultOperator = value;
            return this;
        }

        public final Builder defaultOperator(
                Function<DefaultOperator.Builder, ObjectBuilder<DefaultOperator>> fn) {
            return defaultOperator(fn.apply(new DefaultOperator.Builder()).build());
        }

        public final Builder df(String value) {
            this.df = value;
            return this;
        }

        public final Builder docvalueFields(String value) {
            this.docvalueFields = value;
            return this;
        }

        public final Builder expandWildcards(ExpandWildcards value) {
            this.expandWildcards = value;
            return this;
        }

        public final Builder expandWildcards(
                Function<ExpandWildcards.Builder, ObjectBuilder<ExpandWildcards>> fn) {
            return expandWildcards(fn.apply(new ExpandWildcards.Builder()).build());
        }

        public final Builder explain(boolean value) {
            this.explain = value;
            return this;
        }

        public final Builder fields(List<String> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        public final Builder fields(String value, String... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        public final Builder from(int value) {
            this.from = value;
            return this;
        }

        public final Builder ignoreThrottled(boolean value) {
            this.ignoreThrottled = value;
            return this;
        }

        public final Builder ignoreUnavailable(boolean value) {
            this.ignoreUnavailable = value;
            return this;
        }

        public final Builder indicesBoost(List<JsonData> list) {
            this.indicesBoost = _listAddAll(this.indicesBoost, list);
            return this;
        }

        public final Builder indicesBoost(JsonData value, JsonData... values) {
            this.indicesBoost = _listAdd(this.indicesBoost, value, values);
            return this;
        }

        public final Builder lenient(boolean value) {
            this.lenient = value;
            return this;
        }

        public final Builder maxConcurrentShardRequests(long value) {
            this.maxConcurrentShardRequests = value;
            return this;
        }

        public final Builder minScore(int value) {
            this.minScore = value;
            return this;
        }

        public final Builder preFilterShardSize(long value) {
            this.preFilterShardSize = value;
            return this;
        }

        public final Builder preference(String value) {
            this.preference = value;
            return this;
        }

        public final Builder q(String value) {
            this.q = value;
            return this;
        }

        public final Builder query(UserDefinedObjectStructure value) {
            this.query = value;
            return this;
        }

        public final Builder query(
                Function<
                                UserDefinedObjectStructure.Builder,
                                ObjectBuilder<UserDefinedObjectStructure>>
                        fn) {
            return query(fn.apply(new UserDefinedObjectStructure.Builder()).build());
        }

        public final Builder requestCache(boolean value) {
            this.requestCache = value;
            return this;
        }

        public final Builder restTotalHitsAsInt(boolean value) {
            this.restTotalHitsAsInt = value;
            return this;
        }

        public final Builder routing(String value) {
            this.routing = value;
            return this;
        }

        public final Builder scroll(String value) {
            this.scroll = value;
            return this;
        }

        public final Builder searchType(SearchType value) {
            this.searchType = value;
            return this;
        }

        public final Builder searchType(
                Function<SearchType.Builder, ObjectBuilder<SearchType>> fn) {
            return searchType(fn.apply(new SearchType.Builder()).build());
        }

        public final Builder seqNoPrimaryTerm(boolean value) {
            this.seqNoPrimaryTerm = value;
            return this;
        }

        public final Builder size(int value) {
            this.size = value;
            return this;
        }

        public final Builder sort(List<String> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        public final Builder sort(String value, String... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        public final Builder source(String value) {
            this.source = value;
            return this;
        }

        public final Builder sourceExcludes(List<String> list) {
            this.sourceExcludes = _listAddAll(this.sourceExcludes, list);
            return this;
        }

        public final Builder sourceExcludes(String value, String... values) {
            this.sourceExcludes = _listAdd(this.sourceExcludes, value, values);
            return this;
        }

        public final Builder sourceIncludes(List<String> list) {
            this.sourceIncludes = _listAddAll(this.sourceIncludes, list);
            return this;
        }

        public final Builder sourceIncludes(String value, String... values) {
            this.sourceIncludes = _listAdd(this.sourceIncludes, value, values);
            return this;
        }

        public final Builder stats(String value) {
            this.stats = value;
            return this;
        }

        public final Builder storedFields(boolean value) {
            this.storedFields = value;
            return this;
        }

        public final Builder suggestField(String value) {
            this.suggestField = value;
            return this;
        }

        public final Builder suggestMode(SuggestMode value) {
            this.suggestMode = value;
            return this;
        }

        public final Builder suggestMode(
                Function<SuggestMode.Builder, ObjectBuilder<SuggestMode>> fn) {
            return suggestMode(fn.apply(new SuggestMode.Builder()).build());
        }

        public final Builder suggestSize(long value) {
            this.suggestSize = value;
            return this;
        }

        public final Builder suggestText(String value) {
            this.suggestText = value;
            return this;
        }

        public final Builder terminateAfter(int value) {
            this.terminateAfter = value;
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        public final Builder trackScores(boolean value) {
            this.trackScores = value;
            return this;
        }

        public final Builder trackTotalHits(int value) {
            this.trackTotalHits = value;
            return this;
        }

        public final Builder typedKeys(boolean value) {
            this.typedKeys = value;
            return this;
        }

        public final Builder version(boolean value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link PostSearchRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PostSearchRequest build() {
            _checkSingleUse();

            return new PostSearchRequest(this);
        }
    }

    public static final JsonpDeserializer<PostSearchRequest> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, PostSearchRequest::setupPostSearchRequestDeserializer);

    protected static void setupPostSearchRequestDeserializer(
            ObjectDeserializer<PostSearchRequest.Builder> op) {
        op.add(Builder::docvalueFields, JsonpDeserializer.stringDeserializer(), "docvalue_fields");
        op.add(Builder::explain, JsonpDeserializer.booleanDeserializer(), "explain");
        op.add(
                Builder::fields,
                JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
                "fields");
        op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
        op.add(
                Builder::indicesBoost,
                JsonpDeserializer.arrayDeserializer(JsonData._DESERIALIZER),
                "indices_boost");
        op.add(Builder::minScore, JsonpDeserializer.integerDeserializer(), "min_score");
        op.add(Builder::query, UserDefinedObjectStructure._DESERIALIZER, "query");
        op.add(
                Builder::seqNoPrimaryTerm,
                JsonpDeserializer.booleanDeserializer(),
                "seq_no_primary_term");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
        op.add(Builder::stats, JsonpDeserializer.stringDeserializer(), "stats");
        op.add(Builder::terminateAfter, JsonpDeserializer.integerDeserializer(), "terminate_after");
        op.add(Builder::timeout, JsonpDeserializer.stringDeserializer(), "timeout");
        op.add(Builder::version, JsonpDeserializer.booleanDeserializer(), "version");
    }

    public static final Endpoint<PostSearchRequest, PostSearchResponse, ErrorResponse> _ENDPOINT =
            new SimpleEndpoint<>(
                    // Request method
                    request -> {
                        return "post";
                    },
                    // Request path
                    request -> {
                        return "/_search";
                    },
                    // Request parameters
                    request -> {
                        Map<String, String> params = new HashMap<>();
                        if (request.allowNoIndices != null) {
                            params.put("allow_no_indices", String.valueOf(request.allowNoIndices));
                        }
                        if (request.allowPartialSearchResults != null) {
                            params.put(
                                    "allow_partial_search_results",
                                    String.valueOf(request.allowPartialSearchResults));
                        }
                        if (request.analyzeWildcard != null) {
                            params.put("analyze_wildcard", String.valueOf(request.analyzeWildcard));
                        }
                        if (request.analyzer != null) {
                            params.put("analyzer", request.analyzer);
                        }
                        if (request.batchedReduceSize != null) {
                            params.put(
                                    "batched_reduce_size",
                                    String.valueOf(request.batchedReduceSize));
                        }
                        if (request.ccsMinimizeRoundtrips != null) {
                            params.put(
                                    "ccs_minimize_roundtrips",
                                    String.valueOf(request.ccsMinimizeRoundtrips));
                        }
                        if (request.defaultOperator != null) {
                            params.put("default_operator", request.defaultOperator.jsonValue());
                        }
                        if (request.df != null) {
                            params.put("df", request.df);
                        }
                        if (request.docvalueFields != null) {
                            params.put("docvalue_fields", request.docvalueFields);
                        }
                        if (request.expandWildcards != null) {
                            params.put("expand_wildcards", request.expandWildcards.jsonValue());
                        }
                        if (request.explain != null) {
                            params.put("explain", String.valueOf(request.explain));
                        }
                        if (request.from != null) {
                            params.put("from", String.valueOf(request.from));
                        }
                        if (request.ignoreThrottled != null) {
                            params.put("ignore_throttled", String.valueOf(request.ignoreThrottled));
                        }
                        if (request.ignoreUnavailable != null) {
                            params.put(
                                    "ignore_unavailable",
                                    String.valueOf(request.ignoreUnavailable));
                        }
                        if (request.lenient != null) {
                            params.put("lenient", String.valueOf(request.lenient));
                        }
                        if (request.maxConcurrentShardRequests != null) {
                            params.put(
                                    "max_concurrent_shard_requests",
                                    String.valueOf(request.maxConcurrentShardRequests));
                        }
                        if (request.preFilterShardSize != null) {
                            params.put(
                                    "pre_filter_shard_size",
                                    String.valueOf(request.preFilterShardSize));
                        }
                        if (request.preference != null) {
                            params.put("preference", request.preference);
                        }
                        if (request.q != null) {
                            params.put("q", request.q);
                        }
                        if (request.requestCache != null) {
                            params.put("request_cache", String.valueOf(request.requestCache));
                        }
                        if (request.restTotalHitsAsInt != null) {
                            params.put(
                                    "rest_total_hits_as_int",
                                    String.valueOf(request.restTotalHitsAsInt));
                        }
                        if (request.routing != null) {
                            params.put("routing", request.routing);
                        }
                        if (request.scroll != null) {
                            params.put("scroll", request.scroll);
                        }
                        if (request.searchType != null) {
                            params.put("search_type", request.searchType.jsonValue());
                        }
                        if (request.seqNoPrimaryTerm != null) {
                            params.put(
                                    "seq_no_primary_term",
                                    String.valueOf(request.seqNoPrimaryTerm));
                        }
                        if (request.size != null) {
                            params.put("size", String.valueOf(request.size));
                        }
                        if (ApiTypeHelper.isDefined(request.sort)) {
                            params.put(
                                    "sort",
                                    request.sort.stream()
                                            .map(v -> v)
                                            .collect(Collectors.joining(",")));
                        }
                        if (request.source != null) {
                            params.put("source", request.source);
                        }
                        if (ApiTypeHelper.isDefined(request.sourceExcludes)) {
                            params.put(
                                    "source_excludes",
                                    request.sourceExcludes.stream()
                                            .map(v -> v)
                                            .collect(Collectors.joining(",")));
                        }
                        if (ApiTypeHelper.isDefined(request.sourceIncludes)) {
                            params.put(
                                    "source_includes",
                                    request.sourceIncludes.stream()
                                            .map(v -> v)
                                            .collect(Collectors.joining(",")));
                        }
                        if (request.stats != null) {
                            params.put("stats", request.stats);
                        }
                        if (request.storedFields != null) {
                            params.put("stored_fields", String.valueOf(request.storedFields));
                        }
                        if (request.suggestField != null) {
                            params.put("suggest_field", request.suggestField);
                        }
                        if (request.suggestMode != null) {
                            params.put("suggest_mode", request.suggestMode.jsonValue());
                        }
                        if (request.suggestSize != null) {
                            params.put("suggest_size", String.valueOf(request.suggestSize));
                        }
                        if (request.suggestText != null) {
                            params.put("suggest_text", request.suggestText);
                        }
                        if (request.terminateAfter != null) {
                            params.put("terminate_after", String.valueOf(request.terminateAfter));
                        }
                        if (request.timeout != null) {
                            params.put("timeout", request.timeout);
                        }
                        if (request.trackScores != null) {
                            params.put("track_scores", String.valueOf(request.trackScores));
                        }
                        if (request.trackTotalHits != null) {
                            params.put("track_total_hits", String.valueOf(request.trackTotalHits));
                        }
                        if (request.typedKeys != null) {
                            params.put("typed_keys", String.valueOf(request.typedKeys));
                        }
                        if (request.version != null) {
                            params.put("version", String.valueOf(request.version));
                        }
                        return params;
                    },
                    SimpleEndpoint.emptyMap(),
                    true,
                    PostSearchResponse._DESERIALIZER);
}
