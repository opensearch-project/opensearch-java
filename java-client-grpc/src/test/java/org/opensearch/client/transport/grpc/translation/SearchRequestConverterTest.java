/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc.translation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.core.SearchRequest;

/**
 * Unit tests for SearchRequestConverter.
 */
public class SearchRequestConverterTest {

    private final JacksonJsonpMapper mapper = new JacksonJsonpMapper();

    @Test
    public void testMatchAllQueryBasic() {
        SearchRequest request = new SearchRequest.Builder().index("test-index").query(q -> q.matchAll(m -> m)).build();

        org.opensearch.protobufs.SearchRequest proto = SearchRequestConverter.toProto(request, mapper);

        assertNotNull(proto);
        assertEquals(1, proto.getIndexCount());
        assertEquals("test-index", proto.getIndex(0));
        assertTrue(proto.hasSearchRequestBody());
        assertTrue(proto.getSearchRequestBody().hasQuery());
        assertTrue(proto.getSearchRequestBody().getQuery().hasMatchAll());
    }

    @Test
    public void testMatchAllQueryWithBoost() {
        SearchRequest request = new SearchRequest.Builder().index("test-index").query(q -> q.matchAll(m -> m.boost(2.0f))).build();

        org.opensearch.protobufs.SearchRequest proto = SearchRequestConverter.toProto(request, mapper);

        assertTrue(proto.getSearchRequestBody().getQuery().hasMatchAll());
        assertEquals(2.0f, proto.getSearchRequestBody().getQuery().getMatchAll().getBoost(), 0.001f);
    }

    @Test
    public void testMatchAllWithSize() {
        SearchRequest request = new SearchRequest.Builder().index("test-index").query(q -> q.matchAll(m -> m)).size(50).build();

        org.opensearch.protobufs.SearchRequest proto = SearchRequestConverter.toProto(request, mapper);

        assertEquals(50, proto.getSearchRequestBody().getSize());
    }

    @Test
    public void testMatchAllWithFrom() {
        SearchRequest request = new SearchRequest.Builder().index("test-index").query(q -> q.matchAll(m -> m)).from(10).size(20).build();

        org.opensearch.protobufs.SearchRequest proto = SearchRequestConverter.toProto(request, mapper);

        assertEquals(10, proto.getSearchRequestBody().getFrom());
        assertEquals(20, proto.getSearchRequestBody().getSize());
    }

    @Test
    public void testMultipleIndexes() {
        SearchRequest request = new SearchRequest.Builder().index("index-1", "index-2", "index-3").query(q -> q.matchAll(m -> m)).build();

        org.opensearch.protobufs.SearchRequest proto = SearchRequestConverter.toProto(request, mapper);

        assertEquals(3, proto.getIndexCount());
        assertEquals("index-1", proto.getIndex(0));
        assertEquals("index-2", proto.getIndex(1));
        assertEquals("index-3", proto.getIndex(2));
    }

    @Test
    public void testNoQuery() {
        SearchRequest request = new SearchRequest.Builder().index("test-index").size(10).build();

        org.opensearch.protobufs.SearchRequest proto = SearchRequestConverter.toProto(request, mapper);

        assertNotNull(proto);
        assertTrue(proto.hasSearchRequestBody());
        // No query set — server returns all docs by default
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedQueryTypeThrows() {
        SearchRequest request = new SearchRequest.Builder().index("test-index")
            .query(q -> q.term(t -> t.field("status").value(v -> v.stringValue("active"))))
            .build();

        // Should throw UnsupportedOperationException for term query
        SearchRequestConverter.toProto(request, mapper);
    }
}
