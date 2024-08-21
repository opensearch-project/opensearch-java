/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.opensearch.core.search.SourceConfig;
import org.opensearch.client.opensearch.core.search.SourceFilter;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SearchRequestTest extends ModelTestCase {

    @Test
    public void afterSearch() {
        SearchRequest request = new SearchRequest.Builder().searchAfter("string1", "string2").build();

        assertEquals("{\"search_after\":[\"string1\",\"string2\"]}", toJson(request));

        request = new SearchRequest.Builder().searchAfterVals(FieldValue.of(1), FieldValue.of("string")).build();

        assertEquals("{\"search_after\":[1,\"string\"]}", toJson(request));
    }

    @Test
    public void ext() {
        SearchRequest request = new SearchRequest.Builder().ext(
            "similarity",
            JsonData.of(Collections.singletonMap("fields", Collections.singletonList("name")))
        ).build();

        assertEquals("{\"ext\":{\"similarity\":{\"fields\":[\"name\"]}}}", toJson(request));
    }

    @Test
    public void phaseTook() {
        SearchRequest request = new SearchRequest.Builder().phaseTook(true).build();

        assertEquals("{}", toJson(request));
        assertEquals(true, request.phaseTook());
        assertTrue(Boolean.parseBoolean(SearchRequest._ENDPOINT.queryParameters(request).get("phase_took")));
    }

    @Test
    public void pipeline() {
        SearchRequest request = new SearchRequest.Builder().pipeline("my_pipeline").build();

        assertEquals("{}", toJson(request));
        assertEquals("my_pipeline", request.pipeline());
        assertEquals("my_pipeline", SearchRequest._ENDPOINT.queryParameters(request).get("search_pipeline"));
    }

    @Test
    public void cancelAfterTimeInterval() {
        Time cancelAfterTimeInterval = Time.of(ti -> ti.time("1000ms"));
        SearchRequest request = new SearchRequest.Builder().cancelAfterTimeInterval(cancelAfterTimeInterval).build();

        assertEquals("{}", toJson(request));
        assertEquals(cancelAfterTimeInterval, request.cancelAfterTimeInterval());
        assertEquals("1000ms", SearchRequest._ENDPOINT.queryParameters(request).get("cancel_after_time_interval"));
    }

    @Test
    public void toBuilder() {
        SearchRequest origin = new SearchRequest.Builder().index("index").build();
        SearchRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }

    @Test
    public void canDeserializeSourceAsBoolean() {
        String json = "{\"query\":{\"match_all\":{}},\"_source\":true,\"size\":1}";

        SearchRequest searchRequest = fromJson(json, SearchRequest._DESERIALIZER);

        SourceConfig _source = searchRequest.source();
        assertNotNull(_source);
        assertTrue(_source.isFetch());
        assertTrue(_source.fetch());
    }

    @Test
    public void canDeserializeSourceAsString() {
        String json = "{\"query\":{\"match_all\":{}},\"_source\":\"_id\",\"size\":1}";

        SearchRequest searchRequest = fromJson(json, SearchRequest._DESERIALIZER);

        SourceConfig _source = searchRequest.source();
        assertNotNull(_source);
        assertTrue(_source.isFilter());

        SourceFilter filter = _source.filter();
        assertNotNull(filter);

        List<String> includes = filter.includes();
        assertEquals(1, includes.size());
        assertEquals("_id", includes.get(0));

        assertTrue(filter.excludes().isEmpty());
    }

    @Test
    public void canDeserializeSourceAsArray() {
        String json = "{\"query\":{\"match_all\":{}},\"_source\":[\"_id\"],\"size\":1}";

        SearchRequest searchRequest = fromJson(json, SearchRequest._DESERIALIZER);

        SourceConfig _source = searchRequest.source();
        assertNotNull(_source);
        assertTrue(_source.isFilter());

        SourceFilter filter = _source.filter();
        assertNotNull(filter);

        List<String> includes = filter.includes();
        assertEquals(1, includes.size());
        assertEquals("_id", includes.get(0));

        assertTrue(filter.excludes().isEmpty());
    }

    @Test
    public void canDeserializeSourceAsObject() {
        String json = "{\"query\":{\"match_all\":{}},\"_source\":{\"includes\":[\"_id\"]},\"size\":1}";

        SearchRequest searchRequest = fromJson(json, SearchRequest._DESERIALIZER);

        SourceConfig _source = searchRequest.source();
        assertNotNull(_source);
        assertTrue(_source.isFilter());

        SourceFilter filter = _source.filter();
        assertNotNull(filter);

        List<String> includes = filter.includes();
        assertEquals(1, includes.size());
        assertEquals("_id", includes.get(0));

        assertTrue(filter.excludes().isEmpty());
    }
}
