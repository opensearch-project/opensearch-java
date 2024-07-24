/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch._types.FieldValue;
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
    public void toBuilder() {
        SearchRequest origin = new SearchRequest.Builder().index("index").build();
        SearchRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
