/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import jakarta.json.JsonNumber;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.query_dsl.BoolQuery;
import org.opensearch.client.opensearch._types.query_dsl.ConstantScoreQuery;
import org.opensearch.client.opensearch._types.query_dsl.ExistsQuery;
import org.opensearch.client.opensearch._types.query_dsl.FieldAndFormat;
import org.opensearch.client.opensearch._types.query_dsl.IdsQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchAllQuery;
import org.opensearch.client.opensearch._types.query_dsl.MatchNoneQuery;
import org.opensearch.client.opensearch._types.query_dsl.PrefixQuery;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch._types.query_dsl.RangeQuery;
import org.opensearch.client.opensearch._types.query_dsl.TermQuery;
import org.opensearch.client.opensearch._types.query_dsl.TermsLookup;
import org.opensearch.client.opensearch._types.query_dsl.TermsQuery;
import org.opensearch.client.opensearch._types.query_dsl.TermsQueryField;
import org.opensearch.client.opensearch._types.query_dsl.WildcardQuery;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.core.search.TrackHits;

/**
 * Converts opensearch-java SearchRequest to protobuf SearchRequest.
 * <p>
 * The conversion is strict: a request option or query this converter does not map is never dropped. {@link #toProto}
 * throws {@link UnsupportedOperationException} naming it, and {@link #isSupported} returns false, so that
 * {@code HybridTransport} sends such a request over REST instead.
 * <p>
 * Supported request options: index, query, post_filter, size, from, docvalue_fields (with format), terminate_after,
 * timeout, track_total_hits, routing, preference, allow_partial_search_results, max_concurrent_shard_requests,
 * cancel_after_time_interval, ignore_unavailable, allow_no_indices, expand_wildcards and request_cache.
 * <p>
 * Supported query types, with all their options: match_all, match_none, term, terms (values or lookup), range (numeric
 * or string bounds), bool, exists, ids, prefix, wildcard and constant_score.
 * <p>
 * Query types not yet implemented (the server already supports them over gRPC): terms_set, match, match_phrase,
 * match_phrase_prefix, match_bool_prefix, multi_match, regexp, fuzzy, nested, geo_distance, geo_bounding_box, script.
 * To add one, implement a convertXxx() method and add a case to convertQuery(Query, JsonpMapper).
 */
public class SearchRequestConverter {

    /** The request options the converter maps, by their {@link SearchRequest} getter. */
    static final Set<String> SUPPORTED_OPTIONS = Set.of(
        "index",
        "query",
        "postFilter",
        "size",
        "from",
        "docvalueFields",
        "terminateAfter",
        "timeout",
        "trackTotalHits",
        "routing",
        "preference",
        "allowPartialSearchResults",
        "maxConcurrentShardRequests",
        "cancelAfterTimeInterval",
        "ignoreUnavailable",
        "allowNoIndices",
        "expandWildcards",
        "requestCache"
    );

    /**
     * The request options the converter does not map, by their {@link SearchRequest} getter. A request that sets any of
     * them is not supported over gRPC.
     */
    static final Map<String, Function<SearchRequest, Object>> UNSUPPORTED_OPTIONS;

    static {
        Map<String, Function<SearchRequest, Object>> options = new LinkedHashMap<>();
        options.put("aggregations", SearchRequest::aggregations);
        options.put("analyzeWildcard", SearchRequest::analyzeWildcard);
        options.put("analyzer", SearchRequest::analyzer);
        options.put("batchedReduceSize", SearchRequest::batchedReduceSize);
        options.put("ccsMinimizeRoundtrips", SearchRequest::ccsMinimizeRoundtrips);
        options.put("collapse", SearchRequest::collapse);
        options.put("defaultOperator", SearchRequest::defaultOperator);
        options.put("derived", SearchRequest::derived);
        options.put("df", SearchRequest::df);
        options.put("explain", SearchRequest::explain);
        options.put("ext", SearchRequest::ext);
        options.put("fields", SearchRequest::fields);
        options.put("highlight", SearchRequest::highlight);
        options.put("ignoreThrottled", SearchRequest::ignoreThrottled);
        options.put("includeNamedQueriesScore", SearchRequest::includeNamedQueriesScore);
        options.put("indicesBoost", SearchRequest::indicesBoost);
        options.put("lenient", SearchRequest::lenient);
        options.put("minScore", SearchRequest::minScore);
        options.put("phaseTook", SearchRequest::phaseTook);
        options.put("pipeline", SearchRequest::pipeline);
        options.put("pit", SearchRequest::pit);
        options.put("preFilterShardSize", SearchRequest::preFilterShardSize);
        options.put("profile", SearchRequest::profile);
        options.put("q", SearchRequest::q);
        options.put("rescore", SearchRequest::rescore);
        options.put("scriptFields", SearchRequest::scriptFields);
        options.put("scroll", SearchRequest::scroll);
        options.put("searchAfter", SearchRequest::searchAfter);
        options.put("searchPipeline", SearchRequest::searchPipeline);
        options.put("searchType", SearchRequest::searchType);
        options.put("seqNoPrimaryTerm", SearchRequest::seqNoPrimaryTerm);
        options.put("slice", SearchRequest::slice);
        options.put("sort", SearchRequest::sort);
        options.put("source", SearchRequest::source);
        options.put("stats", SearchRequest::stats);
        options.put("storedFields", SearchRequest::storedFields);
        options.put("suggest", SearchRequest::suggest);
        options.put("trackScores", SearchRequest::trackScores);
        options.put("verbosePipeline", SearchRequest::verbosePipeline);
        options.put("version", SearchRequest::version);
        UNSUPPORTED_OPTIONS = Collections.unmodifiableMap(options);
    }

    /**
     * Returns whether the request can be sent over gRPC without losing any of its options. Untyped values wrapped from Java
     * objects, which only a mapper reads, are not checked; see {@link #isSupported(SearchRequest, JsonpMapper)}.
     */
    public static boolean isSupported(SearchRequest request) {
        return unsupportedReason(request) == null;
    }

    /**
     * Returns whether {@link #toProto} converts the request, so that it can be sent over gRPC without losing any of its
     * options.
     *
     * @param jsonpMapper the mapper {@link #toProto} is given, which reads untyped values such as range bounds
     */
    public static boolean isSupported(SearchRequest request, @Nullable JsonpMapper jsonpMapper) {
        return unsupportedReason(request, jsonpMapper) == null;
    }

    /**
     * Returns why the request cannot be sent over gRPC, or {@code null} if it can. Untyped values wrapped from Java objects,
     * which only a mapper reads, are not checked; see {@link #unsupportedReason(SearchRequest, JsonpMapper)}.
     */
    @Nullable
    public static String unsupportedReason(SearchRequest request) {
        return unsupportedReason(request, null);
    }

    /**
     * Returns why the request cannot be sent over gRPC, or {@code null} if it can.
     *
     * @param jsonpMapper the mapper {@link #toProto} is given, which reads untyped values such as range bounds; with
     *                    {@code null}, values wrapped from Java objects are not checked
     */
    @Nullable
    public static String unsupportedReason(SearchRequest request, @Nullable JsonpMapper jsonpMapper) {
        String option = unsupportedOption(request);
        if (option != null) {
            return "Search option '" + option + "' is not supported for gRPC transport in this version.";
        }
        try {
            if (request.query() != null) {
                convertQuery(request.query(), jsonpMapper);
            }
            if (request.postFilter() != null) {
                convertQuery(request.postFilter(), jsonpMapper);
            }
        } catch (UnsupportedOperationException e) {
            return e.getMessage();
        }
        return null;
    }

    /**
     * Convert an opensearch-java SearchRequest to a protobuf SearchRequest.
     *
     * @param request     the client SearchRequest
     * @param jsonpMapper the JSON mapper, used to read untyped range bounds
     * @return the protobuf SearchRequest
     * @throws UnsupportedOperationException if the request sets an option or query that cannot be sent over gRPC
     */
    public static org.opensearch.protobufs.SearchRequest toProto(SearchRequest request, JsonpMapper jsonpMapper) {
        String option = unsupportedOption(request);
        if (option != null) {
            throw new UnsupportedOperationException(
                "Search option '" + option + "' is not supported for gRPC transport in this version. Use REST transport."
            );
        }
        org.opensearch.protobufs.SearchRequest.Builder protoBuilder = org.opensearch.protobufs.SearchRequest.newBuilder();

        // Set index(es)
        if (request.index() != null && !request.index().isEmpty()) {
            protoBuilder.addAllIndex(request.index());
        }
        if (isSet(request.routing())) {
            protoBuilder.addAllRouting(request.routing());
        }
        if (request.preference() != null) {
            protoBuilder.setPreference(request.preference());
        }
        if (request.allowPartialSearchResults() != null) {
            protoBuilder.setAllowPartialSearchResults(request.allowPartialSearchResults());
        }
        if (request.maxConcurrentShardRequests() != null) {
            protoBuilder.setMaxConcurrentShardRequests(request.maxConcurrentShardRequests());
        }
        if (request.cancelAfterTimeInterval() != null) {
            protoBuilder.setCancelAfterTimeInterval(timeString(request.cancelAfterTimeInterval()));
        }
        if (request.ignoreUnavailable() != null) {
            protoBuilder.setIgnoreUnavailable(request.ignoreUnavailable());
        }
        if (request.allowNoIndices() != null) {
            protoBuilder.setAllowNoIndices(request.allowNoIndices());
        }
        for (ExpandWildcard expand : request.expandWildcards()) {
            protoBuilder.addExpandWildcards(
                org.opensearch.protobufs.ExpandWildcard.valueOf("EXPAND_WILDCARD_" + expand.jsonValue().toUpperCase(Locale.ROOT))
            );
        }
        if (request.requestCache() != null) {
            protoBuilder.setRequestCache(request.requestCache());
        }

        // Build SearchRequestBody
        org.opensearch.protobufs.SearchRequestBody.Builder bodyBuilder = org.opensearch.protobufs.SearchRequestBody.newBuilder();

        // Set size
        if (request.size() != null) {
            bodyBuilder.setSize(request.size());
        }

        // Set from (pagination offset)
        if (request.from() != null) {
            bodyBuilder.setFrom(request.from());
        }

        // Convert query
        if (request.query() != null) {
            bodyBuilder.setQuery(convertQuery(request.query(), jsonpMapper));
        }
        if (request.postFilter() != null) {
            bodyBuilder.setPostFilter(convertQuery(request.postFilter(), jsonpMapper));
        }
        for (FieldAndFormat field : request.docvalueFields()) {
            org.opensearch.protobufs.FieldAndFormat.Builder fieldBuilder = org.opensearch.protobufs.FieldAndFormat.newBuilder()
                .setField(field.field());
            if (field.format() != null) {
                fieldBuilder.setFormat(field.format());
            }
            bodyBuilder.addDocvalueFields(fieldBuilder.build());
        }
        if (request.terminateAfter() != null) {
            bodyBuilder.setTerminateAfter(request.terminateAfter());
        }
        if (request.timeout() != null) {
            bodyBuilder.setTimeout(request.timeout());
        }
        if (request.trackTotalHits() != null) {
            bodyBuilder.setTrackTotalHits(convertTrackHits(request.trackTotalHits()));
        }

        protoBuilder.setSearchRequestBody(bodyBuilder.build());
        return protoBuilder.build();
    }

    /** Returns the first option the request sets that the converter does not map, or {@code null}. */
    @Nullable
    private static String unsupportedOption(SearchRequest request) {
        for (Map.Entry<String, Function<SearchRequest, Object>> option : UNSUPPORTED_OPTIONS.entrySet()) {
            if (isSet(option.getValue().apply(request))) {
                return option.getKey();
            }
        }
        return null;
    }

    /** Lists the options this converter knows about, whether it maps them or not. */
    static Set<String> knownOptions() {
        Set<String> known = new HashSet<>(SUPPORTED_OPTIONS);
        known.addAll(UNSUPPORTED_OPTIONS.keySet());
        return known;
    }

    private static boolean isSet(@Nullable Object value) {
        if (value == null) {
            return false;
        }
        if (value instanceof Collection) {
            return ((Collection<?>) value).isEmpty() == false;
        }
        if (value instanceof Map) {
            return ((Map<?, ?>) value).isEmpty() == false;
        }
        return true;
    }

    private static String timeString(Time time) {
        return time.isTime() ? time.time() : time.offset() + "ms";
    }

    private static org.opensearch.protobufs.TrackHits convertTrackHits(TrackHits trackHits) {
        org.opensearch.protobufs.TrackHits.Builder builder = org.opensearch.protobufs.TrackHits.newBuilder();
        if (trackHits.isCount()) {
            builder.setCount(trackHits.count());
        } else {
            builder.setEnabled(trackHits.enabled());
        }
        return builder.build();
    }

    /**
     * Convert an opensearch-java Query to a protobuf QueryContainer.
     *
     * @param jsonpMapper reads untyped range bounds; {@code null} when only checking that the query can be converted
     * @throws UnsupportedOperationException if the query type or one of its options is not yet supported
     */
    private static org.opensearch.protobufs.QueryContainer convertQuery(Query query, @Nullable JsonpMapper jsonpMapper) {
        org.opensearch.protobufs.QueryContainer.Builder containerBuilder = org.opensearch.protobufs.QueryContainer.newBuilder();

        if (query.isMatchAll()) {
            containerBuilder.setMatchAll(convertMatchAll(query.matchAll()));
        } else if (query.isMatchNone()) {
            containerBuilder.setMatchNone(convertMatchNone(query.matchNone()));
        } else if (query.isTerm()) {
            containerBuilder.setTerm(convertTerm(query.term()));
        } else if (query.isTerms()) {
            containerBuilder.setTerms(convertTerms(query.terms()));
        } else if (query.isRange()) {
            containerBuilder.setRange(convertRange(query.range(), jsonpMapper));
        } else if (query.isBool()) {
            containerBuilder.setBool(convertBool(query.bool(), jsonpMapper));
        } else if (query.isExists()) {
            containerBuilder.setExists(convertExists(query.exists()));
        } else if (query.isIds()) {
            containerBuilder.setIds(convertIds(query.ids()));
        } else if (query.isPrefix()) {
            containerBuilder.setPrefix(convertPrefix(query.prefix()));
        } else if (query.isWildcard()) {
            containerBuilder.setWildcard(convertWildcard(query.wildcard()));
        } else if (query.isConstantScore()) {
            containerBuilder.setConstantScore(convertConstantScore(query.constantScore(), jsonpMapper));
        } else {
            throw new UnsupportedOperationException(
                "Query type '"
                    + query._kind()
                    + "' is not yet supported for gRPC transport in this version. "
                    + "Use REST transport for this query type."
            );
        }

        return containerBuilder.build();
    }

    /**
     * Convert MatchAllQuery to protobuf.
     * MatchAllQuery has only optional boost and _name fields.
     */
    private static org.opensearch.protobufs.MatchAllQuery convertMatchAll(MatchAllQuery matchAll) {
        org.opensearch.protobufs.MatchAllQuery.Builder builder = org.opensearch.protobufs.MatchAllQuery.newBuilder();

        if (matchAll.boost() != null) {
            builder.setBoost(matchAll.boost().floatValue());
        }
        if (matchAll.queryName() != null) {
            builder.setXName(matchAll.queryName());
        }

        return builder.build();
    }

    private static org.opensearch.protobufs.MatchNoneQuery convertMatchNone(MatchNoneQuery matchNone) {
        org.opensearch.protobufs.MatchNoneQuery.Builder builder = org.opensearch.protobufs.MatchNoneQuery.newBuilder();
        if (matchNone.boost() != null) {
            builder.setBoost(matchNone.boost());
        }
        if (matchNone.queryName() != null) {
            builder.setXName(matchNone.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.TermQuery convertTerm(TermQuery term) {
        org.opensearch.protobufs.TermQuery.Builder builder = org.opensearch.protobufs.TermQuery.newBuilder()
            .setField(term.field())
            .setValue(convertFieldValue(term.value()));
        if (term.caseInsensitive() != null) {
            builder.setCaseInsensitive(term.caseInsensitive());
        }
        if (term.boost() != null) {
            builder.setBoost(term.boost());
        }
        if (term.queryName() != null) {
            builder.setXName(term.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.TermsQuery convertTerms(TermsQuery terms) {
        if (terms.valueType() != null) {
            throw new UnsupportedOperationException("Option 'value_type' of query 'terms' is not yet supported for gRPC transport.");
        }
        org.opensearch.protobufs.TermsQuery.Builder builder = org.opensearch.protobufs.TermsQuery.newBuilder();
        builder.putTerms(terms.field(), convertTermsQueryField(terms.terms()));
        if (terms.boost() != null) {
            builder.setBoost(terms.boost());
        }
        if (terms.name() != null) {
            builder.setXName(terms.name());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.TermsQueryField convertTermsQueryField(TermsQueryField field) {
        org.opensearch.protobufs.TermsQueryField.Builder builder = org.opensearch.protobufs.TermsQueryField.newBuilder();
        if (field.isLookup()) {
            TermsLookup lookup = field.lookup();
            if (lookup.query() != null || lookup.id() == null) {
                // The gRPC terms lookup names its document by id only
                throw new UnsupportedOperationException("A terms lookup by query is not yet supported for gRPC transport.");
            }
            org.opensearch.protobufs.TermsLookup.Builder lookupBuilder = org.opensearch.protobufs.TermsLookup.newBuilder()
                .setIndex(lookup.index())
                .setId(lookup.id())
                .setPath(lookup.path());
            if (lookup.routing() != null) {
                lookupBuilder.setRouting(lookup.routing());
            }
            if (lookup.store() != null) {
                lookupBuilder.setStore(lookup.store());
            }
            builder.setLookup(lookupBuilder.build());
        } else {
            org.opensearch.protobufs.FieldValueArray.Builder values = org.opensearch.protobufs.FieldValueArray.newBuilder();
            for (FieldValue value : field.value()) {
                values.addFieldValueArray(convertFieldValue(value));
            }
            builder.setValue(values.build());
        }
        return builder.build();
    }

    /**
     * A range with only fractional numeric bounds (and no format or time zone) becomes a number range, whose double bounds
     * the server reads as those of a REST range query. Any other range becomes a date range, whose string bounds the server
     * parses for the field's type. An integer is sent as its digits, which the server parses as it parses the integers of a
     * REST range query. As a double, epoch millis would read "1.7E12" on a date field, and a long past 2^53 would lose
     * precision.
     */
    private static org.opensearch.protobufs.RangeQuery convertRange(RangeQuery range, @Nullable JsonpMapper jsonpMapper) {
        JsonValue gt = bound(range.gt(), jsonpMapper);
        JsonValue gte = bound(range.gte(), jsonpMapper);
        JsonValue lt = bound(range.lt(), jsonpMapper);
        JsonValue lte = bound(range.lte(), jsonpMapper);
        JsonValue from = bound(range.from(), jsonpMapper);
        JsonValue to = bound(range.to(), jsonpMapper);
        for (JsonValue exclusiveOrInclusive : new JsonValue[] { gt, gte, lt, lte }) {
            if (exclusiveOrInclusive == JsonValue.NULL) {
                throw new UnsupportedOperationException(
                    "A null 'gt', 'gte', 'lt' or 'lte' range bound is not supported for gRPC transport."
                );
            }
        }
        if (jsonpMapper == null) {
            // Only checking: the bounds that could be read are valid
            if (range.relation() != null) {
                relation(range.relation());
            }
            return org.opensearch.protobufs.RangeQuery.getDefaultInstance();
        }
        boolean numeric = range.format() == null && range.timeZone() == null && allFractionsOrNull(gt, gte, lt, lte, from, to);
        org.opensearch.protobufs.RangeQuery.Builder container = org.opensearch.protobufs.RangeQuery.newBuilder();
        if (numeric) {
            org.opensearch.protobufs.NumberRangeQuery.Builder builder = org.opensearch.protobufs.NumberRangeQuery.newBuilder()
                .setField(range.field());
            if (gt != null) {
                builder.setGt(number(gt));
            }
            if (gte != null) {
                builder.setGte(number(gte));
            }
            if (lt != null) {
                builder.setLt(number(lt));
            }
            if (lte != null) {
                builder.setLte(number(lte));
            }
            if (from != null) {
                org.opensearch.protobufs.NumberRangeQueryAllOfFrom.Builder bound = org.opensearch.protobufs.NumberRangeQueryAllOfFrom
                    .newBuilder();
                builder.setFrom(
                    from == JsonValue.NULL
                        ? bound.setNullValue(org.opensearch.protobufs.NullValue.NULL_VALUE_NULL)
                        : bound.setDouble(number(from))
                );
            }
            if (to != null) {
                org.opensearch.protobufs.NumberRangeQueryAllOfTo.Builder bound = org.opensearch.protobufs.NumberRangeQueryAllOfTo
                    .newBuilder();
                builder.setTo(
                    to == JsonValue.NULL
                        ? bound.setNullValue(org.opensearch.protobufs.NullValue.NULL_VALUE_NULL)
                        : bound.setDouble(number(to))
                );
            }
            if (range.includeLower() != null) {
                builder.setIncludeLower(range.includeLower());
            }
            if (range.includeUpper() != null) {
                builder.setIncludeUpper(range.includeUpper());
            }
            if (range.relation() != null) {
                builder.setRelation(relation(range.relation()));
            }
            if (range.boost() != null) {
                builder.setBoost(range.boost());
            }
            if (range.name() != null) {
                builder.setXName(range.name());
            }
            container.setNumberRangeQuery(builder.build());
        } else {
            org.opensearch.protobufs.DateRangeQuery.Builder builder = org.opensearch.protobufs.DateRangeQuery.newBuilder()
                .setField(range.field());
            if (gt != null) {
                builder.setGt(text(gt));
            }
            if (gte != null) {
                builder.setGte(text(gte));
            }
            if (lt != null) {
                builder.setLt(text(lt));
            }
            if (lte != null) {
                builder.setLte(text(lte));
            }
            if (from != null) {
                org.opensearch.protobufs.DateRangeQueryAllOfFrom.Builder bound = org.opensearch.protobufs.DateRangeQueryAllOfFrom
                    .newBuilder();
                builder.setFrom(
                    from == JsonValue.NULL
                        ? bound.setNullValue(org.opensearch.protobufs.NullValue.NULL_VALUE_NULL)
                        : bound.setString(text(from))
                );
            }
            if (to != null) {
                org.opensearch.protobufs.DateRangeQueryAllOfTo.Builder bound = org.opensearch.protobufs.DateRangeQueryAllOfTo.newBuilder();
                builder.setTo(
                    to == JsonValue.NULL
                        ? bound.setNullValue(org.opensearch.protobufs.NullValue.NULL_VALUE_NULL)
                        : bound.setString(text(to))
                );
            }
            if (range.includeLower() != null) {
                builder.setIncludeLower(range.includeLower());
            }
            if (range.includeUpper() != null) {
                builder.setIncludeUpper(range.includeUpper());
            }
            if (range.format() != null) {
                builder.setFormat(range.format());
            }
            if (range.timeZone() != null) {
                builder.setTimeZone(range.timeZone());
            }
            if (range.relation() != null) {
                builder.setRelation(relation(range.relation()));
            }
            if (range.boost() != null) {
                builder.setBoost(range.boost());
            }
            if (range.name() != null) {
                builder.setXName(range.name());
            }
            container.setDateRangeQuery(builder.build());
        }
        return container.build();
    }

    /**
     * Reads an untyped range bound, which must be a number, a string or null.
     *
     * @param jsonpMapper reads bounds wrapped from Java objects; {@code null} when only checking, in which case such a
     *                    bound is not read and this returns {@code null}
     */
    @Nullable
    private static JsonValue bound(@Nullable JsonData data, @Nullable JsonpMapper jsonpMapper) {
        if (data == null) {
            return null;
        }
        JsonValue value;
        if (jsonpMapper != null) {
            value = data.toJson(jsonpMapper);
        } else {
            try {
                value = data.toJson();
            } catch (IllegalStateException e) {
                // A Java object, which only the transport's mapper reads
                return null;
            }
        }
        if (value == JsonValue.NULL || value instanceof JsonNumber || value instanceof JsonString) {
            return value;
        }
        throw new UnsupportedOperationException(
            "Range bound of type '" + value.getValueType() + "' is not yet supported for gRPC transport."
        );
    }

    private static boolean allFractionsOrNull(JsonValue... values) {
        for (JsonValue value : values) {
            if (value != null && value != JsonValue.NULL && (value instanceof JsonNumber == false || ((JsonNumber) value).isIntegral())) {
                return false;
            }
        }
        return true;
    }

    private static double number(JsonValue value) {
        return ((JsonNumber) value).doubleValue();
    }

    private static String text(JsonValue value) {
        return value instanceof JsonString ? ((JsonString) value).getString() : value.toString();
    }

    private static org.opensearch.protobufs.RangeRelation relation(String relation) {
        switch (relation.toLowerCase(Locale.ROOT)) {
            case "contains":
                return org.opensearch.protobufs.RangeRelation.RANGE_RELATION_CONTAINS;
            case "intersects":
                return org.opensearch.protobufs.RangeRelation.RANGE_RELATION_INTERSECTS;
            case "within":
                return org.opensearch.protobufs.RangeRelation.RANGE_RELATION_WITHIN;
            default:
                throw new UnsupportedOperationException("Range relation '" + relation + "' is not supported for gRPC transport.");
        }
    }

    private static org.opensearch.protobufs.BoolQuery convertBool(BoolQuery bool, @Nullable JsonpMapper jsonpMapper) {
        org.opensearch.protobufs.BoolQuery.Builder builder = org.opensearch.protobufs.BoolQuery.newBuilder();
        for (Query clause : bool.must()) {
            builder.addMust(convertQuery(clause, jsonpMapper));
        }
        for (Query clause : bool.filter()) {
            builder.addFilter(convertQuery(clause, jsonpMapper));
        }
        for (Query clause : bool.should()) {
            builder.addShould(convertQuery(clause, jsonpMapper));
        }
        for (Query clause : bool.mustNot()) {
            builder.addMustNot(convertQuery(clause, jsonpMapper));
        }
        if (bool.minimumShouldMatch() != null) {
            String minimum = bool.minimumShouldMatch();
            org.opensearch.protobufs.MinimumShouldMatch.Builder minimumBuilder = org.opensearch.protobufs.MinimumShouldMatch.newBuilder();
            if (minimum.matches("-?\\d+")) {
                minimumBuilder.setInt32(Integer.parseInt(minimum));
            } else {
                minimumBuilder.setString(minimum);
            }
            builder.setMinimumShouldMatch(minimumBuilder.build());
        }
        if (bool.adjustPureNegative() != null) {
            builder.setAdjustPureNegative(bool.adjustPureNegative());
        }
        if (bool.boost() != null) {
            builder.setBoost(bool.boost());
        }
        if (bool.queryName() != null) {
            builder.setXName(bool.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.ExistsQuery convertExists(ExistsQuery exists) {
        org.opensearch.protobufs.ExistsQuery.Builder builder = org.opensearch.protobufs.ExistsQuery.newBuilder().setField(exists.field());
        if (exists.boost() != null) {
            builder.setBoost(exists.boost());
        }
        if (exists.queryName() != null) {
            builder.setXName(exists.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.IdsQuery convertIds(IdsQuery ids) {
        org.opensearch.protobufs.IdsQuery.Builder builder = org.opensearch.protobufs.IdsQuery.newBuilder().addAllValues(ids.values());
        if (ids.boost() != null) {
            builder.setBoost(ids.boost());
        }
        if (ids.queryName() != null) {
            builder.setXName(ids.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.PrefixQuery convertPrefix(PrefixQuery prefix) {
        org.opensearch.protobufs.PrefixQuery.Builder builder = org.opensearch.protobufs.PrefixQuery.newBuilder()
            .setField(prefix.field())
            .setValue(prefix.value());
        if (prefix.caseInsensitive() != null) {
            builder.setCaseInsensitive(prefix.caseInsensitive());
        }
        if (prefix.rewrite() != null) {
            builder.setRewrite(prefix.rewrite());
        }
        if (prefix.boost() != null) {
            builder.setBoost(prefix.boost());
        }
        if (prefix.queryName() != null) {
            builder.setXName(prefix.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.WildcardQuery convertWildcard(WildcardQuery wildcard) {
        org.opensearch.protobufs.WildcardQuery.Builder builder = org.opensearch.protobufs.WildcardQuery.newBuilder()
            .setField(wildcard.field());
        if (wildcard.value() != null) {
            builder.setValue(wildcard.value());
        }
        if (wildcard.wildcard() != null) {
            builder.setWildcard(wildcard.wildcard());
        }
        if (wildcard.caseInsensitive() != null) {
            builder.setCaseInsensitive(wildcard.caseInsensitive());
        }
        if (wildcard.rewrite() != null) {
            builder.setRewrite(wildcard.rewrite());
        }
        if (wildcard.boost() != null) {
            builder.setBoost(wildcard.boost());
        }
        if (wildcard.queryName() != null) {
            builder.setXName(wildcard.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.ConstantScoreQuery convertConstantScore(
        ConstantScoreQuery constantScore,
        @Nullable JsonpMapper jsonpMapper
    ) {
        org.opensearch.protobufs.ConstantScoreQuery.Builder builder = org.opensearch.protobufs.ConstantScoreQuery.newBuilder()
            .setFilter(convertQuery(constantScore.filter(), jsonpMapper));
        if (constantScore.boost() != null) {
            builder.setBoost(constantScore.boost());
        }
        if (constantScore.queryName() != null) {
            builder.setXName(constantScore.queryName());
        }
        return builder.build();
    }

    private static org.opensearch.protobufs.FieldValue convertFieldValue(FieldValue value) {
        org.opensearch.protobufs.FieldValue.Builder builder = org.opensearch.protobufs.FieldValue.newBuilder();
        switch (value._kind()) {
            case Boolean:
                return builder.setBool(value.booleanValue()).build();
            case Long:
                return builder.setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setInt64Value(value.longValue()))
                    .build();
            case Double:
                return builder.setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setDoubleValue(value.doubleValue()))
                    .build();
            case String:
                return builder.setString(value.stringValue()).build();
            case Null:
                return builder.setNullValue(org.opensearch.protobufs.NullValue.NULL_VALUE_NULL).build();
            default:
                throw new UnsupportedOperationException("Field value of kind '" + value._kind() + "' is not supported for gRPC transport.");
        }
    }
}
