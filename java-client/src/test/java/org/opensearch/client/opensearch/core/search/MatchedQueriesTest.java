/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.opensearch.client.opensearch.model.ModelTestCase.toJson;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;

public class MatchedQueriesTest {
    private final JsonpMapper mapper = new JsonbJsonpMapper();
    private final JsonpDeserializer<Hit<JsonData>> hitDeserializer = Hit.createHitDeserializer(JsonData._DESERIALIZER);

    private Hit<JsonData> parse(String json) {
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        return hitDeserializer.deserialize(parser, mapper);
    }

    @Test
    public void deserializesArrayFormAsMapWithNullValues() {
        Hit<JsonData> hit = parse("{\"_index\":\"i\",\"matched_queries\":[\"a\",\"b\"]}");
        Map<String, Double> matchedQueries = hit.matchedQueries();
        assertEquals(2, matchedQueries.size());
        assertTrue(matchedQueries.containsKey("a"));
        assertNull(matchedQueries.get("a"));
        assertNull(matchedQueries.get("b"));
    }

    @Test
    public void deserializesObjectFormAsMapWithScores() {
        Hit<JsonData> hit = parse("{\"_index\":\"i\",\"matched_queries\":{\"a\":1.5,\"b\":2.5}}");
        Map<String, Double> matchedQueries = hit.matchedQueries();
        assertEquals(2, matchedQueries.size());
        assertEquals(Double.valueOf(1.5), matchedQueries.get("a"));
        assertEquals(Double.valueOf(2.5), matchedQueries.get("b"));
    }

    @Test
    public void returnsEmptyMapWhenAbsent() {
        Hit<JsonData> hit = parse("{\"_index\":\"i\"}");
        assertTrue(hit.matchedQueries().isEmpty());
    }

    @Test
    public void serializesAsArrayWhenValuesAreNull() {
        Hit<JsonData> hit = parse("{\"_index\":\"i\",\"matched_queries\":[\"a\",\"b\"]}");
        assertTrue(toJson(hit, mapper).contains("\"matched_queries\":[\"a\",\"b\"]"));
    }

    @Test
    public void serializesAsObjectWhenScoresPresent() {
        Hit<JsonData> hit = parse("{\"_index\":\"i\",\"matched_queries\":{\"a\":1.5}}");
        assertTrue(toJson(hit, mapper).contains("\"matched_queries\":{\"a\":1.5}"));
    }
}
