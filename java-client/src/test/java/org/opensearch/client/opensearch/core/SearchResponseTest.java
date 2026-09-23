/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch.model.ModelTestCase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.MissingRequiredPropertyException;

public class SearchResponseTest extends ModelTestCase {
    private final JsonpDeserializer<SearchResponse<JsonData>> deserializer = SearchResponse.createSearchResponseDeserializer(
        JsonData._DESERIALIZER
    );

    // A zero-hit search without filter_path: hits.hits is present and empty.
    private static final String EMPTY_RESPONSE = "{\"took\":6,\"timed_out\":false,"
        + "\"_shards\":{\"total\":2,\"successful\":2,\"skipped\":0,\"failed\":0},"
        + "\"hits\":{\"total\":{\"value\":0,\"relation\":\"eq\"},\"max_score\":null,\"hits\":[]}}";

    // Response from #1729: a zero-hit search with filter_path=*,-hits.hits._source.someField, which prunes the
    // required hits.hits array off the wire.
    private static final String FILTERED_EMPTY_RESPONSE = "{\"took\":6,\"timed_out\":false,"
        + "\"_shards\":{\"total\":2,\"successful\":2,\"skipped\":0,\"failed\":0},"
        + "\"hits\":{\"total\":{\"value\":0,\"relation\":\"eq\"},\"max_score\":null}}";

    @Test
    public void emptyResponseDeserializes() {
        SearchResponse<JsonData> response = fromJson(EMPTY_RESPONSE, deserializer);
        assertTrue(response.hits().hits().isEmpty());
        assertTrue(ApiTypeHelper.isDefined(response.hits().hits()));
        assertEquals(0L, response.hits().total().value());
    }

    @Test
    public void filteredResponseWithoutHitsArrayFailsByDefault() {
        MissingRequiredPropertyException ex = assertThrows(
            MissingRequiredPropertyException.class,
            () -> fromJson(FILTERED_EMPTY_RESPONSE, deserializer)
        );
        assertEquals("hits", ex.getPropertyName());
    }

    @Test
    public void filteredResponseWithoutHitsArrayDeserializesWhenRequiredChecksAreDisabled() {
        try (ApiTypeHelper.DisabledChecksHandle h = ApiTypeHelper.DANGEROUS_disableRequiredPropertiesCheck(true)) {
            SearchResponse<JsonData> response = fromJson(FILTERED_EMPTY_RESPONSE, deserializer);
            assertTrue(response.hits().hits().isEmpty());
            // Unlike the empty array above, the pruned array is undefined
            assertFalse(ApiTypeHelper.isDefined(response.hits().hits()));
            assertEquals(0L, response.hits().total().value());
            assertEquals(6L, response.took());
        }
    }
}
