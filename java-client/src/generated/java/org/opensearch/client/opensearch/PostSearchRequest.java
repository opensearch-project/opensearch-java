package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.json.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import javax.annotation.*;

/** Returns results matching a query. */
@JsonpDeserializable
public class PostSearchRequest extends RequestBase implements JsonpSerializable {

    @Nullable private final Boolean allowNoIndices;

    @Nullable private final Boolean allowPartialSearchResults;

    @Nullable private final Boolean analyzeWildcard;

    @Nullable private final String analyzer;

    @Nullable private final Integer batchedReduceSize;

    @Nullable private final Boolean ccsMinimizeRoundtrips;

    @Nullable private final DefaultOperator defaultOperator;

    @Nullable private final String df;

    @Nullable private final String docvalueFields;

    @Nullable private final ExpandWildcards expandWildcards;

    @Nullable private final Boolean explain;

    @Nullable private final List<String> fields;

    @Nullable private final Integer from;

    @Nullable private final Boolean ignoreThrottled;

    @Nullable private final Boolean ignoreUnavailable;

    @Nullable private final List<JsonData> indicesBoost;

    @Nullable private final Boolean lenient;

    @Nullable private final Long maxConcurrentShardRequests;

    @Nullable private final Integer minScore;

    @Nullable private final Long preFilterShardSize;

    @Nullable private final String preference;

    @Nullable private final String q;

    @Nullable private final UserDefinedObjectStructure query;

    @Nullable private final Boolean requestCache;

    @Nullable private final Boolean restTotalHitsAsInt;

    @Nullable private final String routing;

    @Nullable private final String scroll;

    @Nullable private final SearchType searchType;

    @Nullable private final Boolean seqNoPrimaryTerm;

    @Nullable private final Integer size;

    @Nullable private final List<String> sort;

    @Nullable private final String source;

    @Nullable private final List<String> sourceExcludes;

    @Nullable private final List<String> sourceIncludes;

    @Nullable private final String stats;

    @Nullable private final Boolean storedFields;

    @Nullable private final String suggestField;

    @Nullable private final SuggestMode suggestMode;

    @Nullable private final Long suggestSize;

    @Nullable private final String suggestText;

    @Nullable private final Integer terminateAfter;

    @Nullable private final String timeout;

    @Nullable private final Boolean trackScores;

    @Nullable private final Integer trackTotalHits;

    @Nullable private final Boolean typedKeys;

    @Nullable private final Boolean version;

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

    public final Boolean allowNoIndices() {
        return this.allowNoIndices;
    }

    public final Boolean allowPartialSearchResults() {
        return this.allowPartialSearchResults;
    }

    public final Boolean analyzeWildcard() {
        return this.analyzeWildcard;
    }

    public final String analyzer() {
        return this.analyzer;
    }

    public final Integer batchedReduceSize() {
        return this.batchedReduceSize;
    }

    public final Boolean ccsMinimizeRoundtrips() {
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

    public final Boolean explain() {
        return this.explain;
    }

    public final List<String> fields() {
        return this.fields;
    }

    public final Integer from() {
        return this.from;
    }

    public final Boolean ignoreThrottled() {
        return this.ignoreThrottled;
    }

    public final Boolean ignoreUnavailable() {
        return this.ignoreUnavailable;
    }

    public final List<JsonData> indicesBoost() {
        return this.indicesBoost;
    }

    public final Boolean lenient() {
        return this.lenient;
    }

    public final Long maxConcurrentShardRequests() {
        return this.maxConcurrentShardRequests;
    }

    public final Integer minScore() {
        return this.minScore;
    }

    public final Long preFilterShardSize() {
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

    public final Boolean requestCache() {
        return this.requestCache;
    }

    public final Boolean restTotalHitsAsInt() {
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

    public final Boolean seqNoPrimaryTerm() {
        return this.seqNoPrimaryTerm;
    }

    public final Integer size() {
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

    public final Boolean storedFields() {
        return this.storedFields;
    }

    public final String suggestField() {
        return this.suggestField;
    }

    public final SuggestMode suggestMode() {
        return this.suggestMode;
    }

    public final Long suggestSize() {
        return this.suggestSize;
    }

    public final String suggestText() {
        return this.suggestText;
    }

    public final Integer terminateAfter() {
        return this.terminateAfter;
    }

    public final String timeout() {
        return this.timeout;
    }

    public final Boolean trackScores() {
        return this.trackScores;
    }

    public final Integer trackTotalHits() {
        return this.trackTotalHits;
    }

    public final Boolean typedKeys() {
        return this.typedKeys;
    }

    public final Boolean version() {
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
        private Boolean allowNoIndices;
        private Boolean allowPartialSearchResults;
        private Boolean analyzeWildcard;
        private String analyzer;
        private Integer batchedReduceSize;
        private Boolean ccsMinimizeRoundtrips;
        private DefaultOperator defaultOperator;
        private String df;
        private String docvalueFields;
        private ExpandWildcards expandWildcards;
        private Boolean explain;
        private List<String> fields;
        private Integer from;
        private Boolean ignoreThrottled;
        private Boolean ignoreUnavailable;
        private List<JsonData> indicesBoost;
        private Boolean lenient;
        private Long maxConcurrentShardRequests;
        private Integer minScore;
        private Long preFilterShardSize;
        private String preference;
        private String q;
        private UserDefinedObjectStructure query;
        private Boolean requestCache;
        private Boolean restTotalHitsAsInt;
        private String routing;
        private String scroll;
        private SearchType searchType;
        private Boolean seqNoPrimaryTerm;
        private Integer size;
        private List<String> sort;
        private String source;
        private List<String> sourceExcludes;
        private List<String> sourceIncludes;
        private String stats;
        private Boolean storedFields;
        private String suggestField;
        private SuggestMode suggestMode;
        private Long suggestSize;
        private String suggestText;
        private Integer terminateAfter;
        private String timeout;
        private Boolean trackScores;
        private Integer trackTotalHits;
        private Boolean typedKeys;
        private Boolean version;

        public final Builder allowNoIndices(Boolean value) {
            this.allowNoIndices = value;
            return this;
        }

        public final Builder allowPartialSearchResults(Boolean value) {
            this.allowPartialSearchResults = value;
            return this;
        }

        public final Builder analyzeWildcard(Boolean value) {
            this.analyzeWildcard = value;
            return this;
        }

        public final Builder analyzer(String value) {
            this.analyzer = value;
            return this;
        }

        public final Builder batchedReduceSize(Integer value) {
            this.batchedReduceSize = value;
            return this;
        }

        public final Builder ccsMinimizeRoundtrips(Boolean value) {
            this.ccsMinimizeRoundtrips = value;
            return this;
        }

        public final Builder defaultOperator(DefaultOperator value) {
            this.defaultOperator = value;
            return this;
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

        public final Builder explain(Boolean value) {
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

        public final Builder from(Integer value) {
            this.from = value;
            return this;
        }

        public final Builder ignoreThrottled(Boolean value) {
            this.ignoreThrottled = value;
            return this;
        }

        public final Builder ignoreUnavailable(Boolean value) {
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

        public final Builder lenient(Boolean value) {
            this.lenient = value;
            return this;
        }

        public final Builder maxConcurrentShardRequests(Long value) {
            this.maxConcurrentShardRequests = value;
            return this;
        }

        public final Builder minScore(Integer value) {
            this.minScore = value;
            return this;
        }

        public final Builder preFilterShardSize(Long value) {
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

        public final Builder requestCache(Boolean value) {
            this.requestCache = value;
            return this;
        }

        public final Builder restTotalHitsAsInt(Boolean value) {
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

        public final Builder seqNoPrimaryTerm(Boolean value) {
            this.seqNoPrimaryTerm = value;
            return this;
        }

        public final Builder size(Integer value) {
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

        public final Builder storedFields(Boolean value) {
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

        public final Builder suggestSize(Long value) {
            this.suggestSize = value;
            return this;
        }

        public final Builder suggestText(String value) {
            this.suggestText = value;
            return this;
        }

        public final Builder terminateAfter(Integer value) {
            this.terminateAfter = value;
            return this;
        }

        public final Builder timeout(String value) {
            this.timeout = value;
            return this;
        }

        public final Builder trackScores(Boolean value) {
            this.trackScores = value;
            return this;
        }

        public final Builder trackTotalHits(Integer value) {
            this.trackTotalHits = value;
            return this;
        }

        public final Builder typedKeys(Boolean value) {
            this.typedKeys = value;
            return this;
        }

        public final Builder version(Boolean value) {
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
