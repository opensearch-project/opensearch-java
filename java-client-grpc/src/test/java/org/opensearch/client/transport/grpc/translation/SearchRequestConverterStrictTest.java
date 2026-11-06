/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import jakarta.json.JsonValue;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch._types.query_dsl.RangeQuery;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.protobufs.QueryContainer;
import org.opensearch.protobufs.SearchRequestBody;

public class SearchRequestConverterStrictTest {

    private final JacksonJsonpMapper mapper = new JacksonJsonpMapper();

    /**
     * Every option of SearchRequest must be either mapped or listed as unsupported, so an option added to the model later
     * cannot be dropped silently: this test fails until the converter decides about it.
     */
    @Test
    public void testEveryRequestOptionIsMappedOrRejected() {
        Set<String> unknown = new TreeSet<>();
        for (Method method : SearchRequest.class.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())
                && Modifier.isStatic(method.getModifiers()) == false
                && Modifier.isFinal(method.getModifiers())
                && method.getParameterCount() == 0
                && method.getReturnType() != void.class
                && SearchRequestConverter.knownOptions().contains(method.getName()) == false) {
                unknown.add(method.getName());
            }
        }
        assertEquals("options of SearchRequest the converter neither maps nor rejects", Set.of(), unknown);
    }

    @Test
    public void testUnsupportedOptionIsRejectedNotDropped() {
        SearchRequest request = new SearchRequest.Builder().index("logs").sort(s -> s.field(f -> f.field("ts"))).build();
        assertFalse(SearchRequestConverter.isSupported(request));
        assertTrue(SearchRequestConverter.unsupportedReason(request).contains("'sort'"));
        try {
            SearchRequestConverter.toProto(request, mapper);
            fail("expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("'sort'"));
        }
        assertFalse(SearchRequestConverter.isSupported(new SearchRequest.Builder().source(s -> s.fetch(false)).build()));
        assertFalse(SearchRequestConverter.isSupported(new SearchRequest.Builder().explain(true).build()));
    }

    @Test
    public void testRequestOptions() {
        SearchRequest request = new SearchRequest.Builder().index("logs-*")
            .routing("r1", "r2")
            .preference("_local")
            .allowPartialSearchResults(false)
            .maxConcurrentShardRequests(3)
            .cancelAfterTimeInterval(Time.of(t -> t.time("30s")))
            .ignoreUnavailable(true)
            .allowNoIndices(false)
            .expandWildcards(ExpandWildcard.Open, ExpandWildcard.Hidden)
            .requestCache(false)
            .size(10)
            .from(5)
            .docvalueFields(f -> f.field("@timestamp").format("epoch_millis"))
            .docvalueFields(f -> f.field("tags").format("list"))
            .docvalueFields(f -> f.field("status"))
            .terminateAfter(1000)
            .timeout("5s")
            .trackTotalHits(t -> t.count(100))
            .build();
        assertNull(SearchRequestConverter.unsupportedReason(request));
        org.opensearch.protobufs.SearchRequest proto = SearchRequestConverter.toProto(request, mapper);
        assertEquals(List.of("logs-*"), proto.getIndexList());
        assertEquals(List.of("r1", "r2"), proto.getRoutingList());
        assertEquals("_local", proto.getPreference());
        assertFalse(proto.getAllowPartialSearchResults());
        assertEquals(3, proto.getMaxConcurrentShardRequests());
        assertEquals("30s", proto.getCancelAfterTimeInterval());
        assertTrue(proto.getIgnoreUnavailable());
        assertFalse(proto.getAllowNoIndices());
        assertEquals(
            List.of(
                org.opensearch.protobufs.ExpandWildcard.EXPAND_WILDCARD_OPEN,
                org.opensearch.protobufs.ExpandWildcard.EXPAND_WILDCARD_HIDDEN
            ),
            proto.getExpandWildcardsList()
        );
        assertFalse(proto.getRequestCache());
        SearchRequestBody body = proto.getSearchRequestBody();
        assertEquals(10, body.getSize());
        assertEquals(5, body.getFrom());
        assertEquals(3, body.getDocvalueFieldsCount());
        assertEquals("@timestamp", body.getDocvalueFields(0).getField());
        assertEquals("epoch_millis", body.getDocvalueFields(0).getFormat());
        assertEquals("list", body.getDocvalueFields(1).getFormat());
        assertFalse(body.getDocvalueFields(2).hasFormat());
        assertEquals(1000, body.getTerminateAfter());
        assertEquals("5s", body.getTimeout());
        assertEquals(100, body.getTrackTotalHits().getCount());
    }

    @Test
    public void testTermAndTermsQueries() {
        QueryContainer term = query(
            new SearchRequest.Builder().query(
                q -> q.term(t -> t.field("status").value(FieldValue.of(500)).caseInsensitive(true).boost(2f).queryName("t"))
            ).build()
        );
        assertEquals("status", term.getTerm().getField());
        assertEquals(500, term.getTerm().getValue().getGeneralNumber().getInt64Value());
        assertTrue(term.getTerm().getCaseInsensitive());
        assertEquals(2f, term.getTerm().getBoost(), 0f);
        assertEquals("t", term.getTerm().getXName());

        QueryContainer terms = query(
            new SearchRequest.Builder().query(
                q -> q.terms(t -> t.field("tag").terms(v -> v.value(List.of(FieldValue.of("a"), FieldValue.of(true), FieldValue.of(1.5)))))
            ).build()
        );
        org.opensearch.protobufs.FieldValueArray values = terms.getTerms().getTermsMap().get("tag").getValue();
        assertEquals("a", values.getFieldValueArray(0).getString());
        assertTrue(values.getFieldValueArray(1).getBool());
        assertEquals(1.5, values.getFieldValueArray(2).getGeneralNumber().getDoubleValue(), 0);

        QueryContainer lookup = query(
            new SearchRequest.Builder().query(
                q -> q.terms(t -> t.field("user").terms(v -> v.lookup(l -> l.index("users").id("1").path("friends"))))
            ).build()
        );
        assertEquals("users", lookup.getTerms().getTermsMap().get("user").getLookup().getIndex());
    }

    @Test
    public void testFractionalRangeBecomesANumberRange() {
        QueryContainer range = query(
            new SearchRequest.Builder().query(
                q -> q.range(r -> r.field("price").gte(JsonData.of(9.5)).lt(JsonData.of(20.5)).boost(1.5f).name("p"))
            ).build()
        );
        assertTrue(range.getRange().hasNumberRangeQuery());
        assertEquals(9.5, range.getRange().getNumberRangeQuery().getGte(), 0);
        assertEquals(20.5, range.getRange().getNumberRangeQuery().getLt(), 0);
        assertEquals("p", range.getRange().getNumberRangeQuery().getXName());
    }

    /**
     * Integers are sent as their digits, which the server parses for the field's type as it does the integers of a REST
     * range: as doubles, epoch millis would read "1.7E12" on a date field and longs past 2^53 would lose precision.
     */
    @Test
    public void testIntegralRangeBoundsAreSentExactly() {
        org.opensearch.protobufs.DateRangeQuery epochMillis = dateRange(r -> r.field("@timestamp").gte(JsonData.of(1700000000000L)));
        assertEquals("1700000000000", epochMillis.getGte());
        assertFalse(epochMillis.hasFormat());

        org.opensearch.protobufs.DateRangeQuery bigLong = dateRange(
            r -> r.field("counter").gte(JsonData.of(9007199254740993L)).lte(JsonData.of(Long.MAX_VALUE))
        );
        assertEquals("9007199254740993", bigLong.getGte());
        assertEquals(String.valueOf(Long.MAX_VALUE), bigLong.getLte());

        org.opensearch.protobufs.DateRangeQuery keyword = dateRange(
            r -> r.field("code").gt(JsonData.of(10)).lt(JsonData.of(20.5)).from(JsonData.of(1)).to(JsonData.of(JsonValue.NULL))
        );
        assertEquals("10", keyword.getGt());
        assertEquals("20.5", keyword.getLt());
        assertEquals("1", keyword.getFrom().getString());
        assertTrue(keyword.getTo().hasNullValue());
    }

    @Test
    public void testTermsLookupByQueryIsNotSupported() {
        SearchRequest request = new SearchRequest.Builder().query(
            q -> q.terms(
                t -> t.field("user")
                    .terms(
                        v -> v.lookup(
                            l -> l.index("users").path("name").query(lq -> lq.term(tq -> tq.field("team").value(FieldValue.of("a"))))
                        )
                    )
            )
        ).build();
        assertFalse(SearchRequestConverter.isSupported(request));
        assertTrue(SearchRequestConverter.unsupportedReason(request), SearchRequestConverter.unsupportedReason(request).contains("query"));
    }

    /** The check rejects the range bounds the conversion rejects, so that such a search goes over REST. */
    @Test
    public void testRangeBoundsTheConversionRejectsAreNotSupported() {
        SearchRequest nullBound = new SearchRequest.Builder().query(
            q -> q.range(r -> r.field("stock").gte(JsonData.of(JsonValue.NULL)).lt(JsonData.of(10)))
        ).build();
        assertFalse(SearchRequestConverter.isSupported(nullBound));
        assertFalse(SearchRequestConverter.isSupported(nullBound, mapper));

        SearchRequest booleanBound = new SearchRequest.Builder().query(q -> q.range(r -> r.field("stock").gte(JsonData.of(true)))).build();
        // Wrapped from a Java object, which only the mapper reads
        assertTrue(SearchRequestConverter.isSupported(booleanBound));
        assertFalse(SearchRequestConverter.isSupported(booleanBound, mapper));
        assertFalse(
            SearchRequestConverter.isSupported(
                new SearchRequest.Builder().query(q -> q.range(r -> r.field("stock").gte(JsonData.of(JsonValue.TRUE)))).build()
            )
        );

        assertTrue(
            SearchRequestConverter.isSupported(
                new SearchRequest.Builder().query(q -> q.range(r -> r.field("stock").gte(JsonData.of(1)).from(JsonData.of(JsonValue.NULL))))
                    .build(),
                mapper
            )
        );
    }

    @Test
    public void testStringOrFormattedRangeBecomesADateRange() {
        QueryContainer range = query(
            new SearchRequest.Builder().query(
                q -> q.range(
                    r -> r.field("@timestamp")
                        .gte(JsonData.of("2023-01-01T00:00:00Z"))
                        .lt(JsonData.of("now"))
                        .format("strict_date_optional_time")
                        .timeZone("+01:00")
                        .relation("within")
                )
            ).build()
        );
        assertTrue(range.getRange().hasDateRangeQuery());
        org.opensearch.protobufs.DateRangeQuery date = range.getRange().getDateRangeQuery();
        assertEquals("2023-01-01T00:00:00Z", date.getGte());
        assertEquals("now", date.getLt());
        assertEquals("strict_date_optional_time", date.getFormat());
        assertEquals("+01:00", date.getTimeZone());
        assertEquals(org.opensearch.protobufs.RangeRelation.RANGE_RELATION_WITHIN, date.getRelation());
    }

    @Test
    public void testBoolWithNestedClauses() {
        QueryContainer bool = query(
            new SearchRequest.Builder().query(
                q -> q.bool(
                    b -> b.filter(f -> f.exists(e -> e.field("user")))
                        .filter(f -> f.ids(i -> i.values("1", "2")))
                        .must(m -> m.prefix(p -> p.field("url").value("http://").caseInsensitive(true)))
                        .should(s -> s.wildcard(w -> w.field("host").value("*.example.com")))
                        .should(s -> s.constantScore(c -> c.filter(f -> f.matchNone(n -> n)).boost(3f)))
                        .mustNot(n -> n.term(t -> t.field("status").value(FieldValue.of("deleted"))))
                        .minimumShouldMatch("1")
                )
            ).build()
        );
        org.opensearch.protobufs.BoolQuery b = bool.getBool();
        assertEquals("user", b.getFilter(0).getExists().getField());
        assertEquals(List.of("1", "2"), b.getFilter(1).getIds().getValuesList());
        assertTrue(b.getMust(0).getPrefix().getCaseInsensitive());
        assertEquals("*.example.com", b.getShould(0).getWildcard().getValue());
        assertTrue(b.getShould(1).getConstantScore().getFilter().hasMatchNone());
        assertEquals("deleted", b.getMustNot(0).getTerm().getValue().getString());
        assertEquals(1, b.getMinimumShouldMatch().getInt32());
    }

    @Test
    public void testUnsupportedNestedQueryRejectsTheWholeRequest() {
        SearchRequest request = new SearchRequest.Builder().query(
            q -> q.bool(b -> b.filter(f -> f.match(m -> m.field("title").query(fv -> fv.stringValue("x")))))
        ).build();
        assertFalse(SearchRequestConverter.isSupported(request));
        assertNotNull(SearchRequestConverter.unsupportedReason(request));
    }

    @Test
    public void testPostFilterIsConvertedAndChecked() {
        SearchRequest request = new SearchRequest.Builder().query(q -> q.matchAll(m -> m))
            .postFilter(p -> p.term(t -> t.field("status").value(FieldValue.of(200))))
            .build();
        assertTrue(SearchRequestConverter.isSupported(request));
        assertEquals("status", SearchRequestConverter.toProto(request, mapper).getSearchRequestBody().getPostFilter().getTerm().getField());
        SearchRequest unsupported = new SearchRequest.Builder().postFilter(p -> p.match(m -> m.field("t").query(fv -> fv.stringValue("x"))))
            .build();
        assertFalse(SearchRequestConverter.isSupported(unsupported));
    }

    private QueryContainer query(SearchRequest request) {
        assertNull(SearchRequestConverter.unsupportedReason(request));
        return SearchRequestConverter.toProto(request, mapper).getSearchRequestBody().getQuery();
    }

    private org.opensearch.protobufs.DateRangeQuery dateRange(Function<RangeQuery.Builder, ObjectBuilder<RangeQuery>> fn) {
        QueryContainer range = query(new SearchRequest.Builder().query(q -> q.range(fn)).build());
        assertTrue(range.getRange().hasDateRangeQuery());
        return range.getRange().getDateRangeQuery();
    }
}
