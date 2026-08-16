/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.opensearch.client.opensearch.model.ModelTestCase.toJson;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;

public class MatchedQueriesTest {
    private final JsonpMapper mapper = new JsonbJsonpMapper();
    private final JsonpDeserializer<Hit<JsonData>> hitDeserializer = Hit.createHitDeserializer(JsonData._DESERIALIZER);

    private Hit<JsonData> parseHit(String json) {
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        return hitDeserializer.deserialize(parser, mapper);
    }

    @Test
    public void deserializesArrayFormAsNamesVariant() {
        Hit<JsonData> hit = parseHit("{\"_index\":\"i\",\"matched_queries\":[\"a\",\"b\"]}");
        MatchedQueries mq = hit.matchedQueries();
        assertTrue(mq.isNames());
        assertFalse(mq.isScores());
        assertEquals(Arrays.asList("a", "b"), mq.names());
    }

    @Test
    public void deserializesObjectFormAsScoresVariant() {
        Hit<JsonData> hit = parseHit("{\"_index\":\"i\",\"matched_queries\":{\"a\":1.5,\"b\":2.5}}");
        MatchedQueries mq = hit.matchedQueries();
        assertTrue(mq.isScores());
        assertFalse(mq.isNames());
        Map<String, Double> scores = mq.scores();
        assertEquals(Double.valueOf(1.5), scores.get("a"));
        assertEquals(Double.valueOf(2.5), scores.get("b"));
    }

    @Test
    public void returnsNullWhenAbsent() {
        Hit<JsonData> hit = parseHit("{\"_index\":\"i\"}");
        assertNull(hit.matchedQueries());
    }

    @Test
    public void serializesNamesVariantAsArray() {
        Hit<JsonData> hit = parseHit("{\"_index\":\"i\",\"matched_queries\":[\"a\",\"b\"]}");
        assertTrue(toJson(hit, mapper).contains("\"matched_queries\":[\"a\",\"b\"]"));
    }

    @Test
    public void serializesScoresVariantAsObject() {
        Map<String, Double> scores = new LinkedHashMap<>();
        scores.put("a", 1.5);
        scores.put("b", 2.5);
        Hit<JsonData> hit = new Hit.Builder<JsonData>().index("i").matchedQueries(MatchedQueries.ofScores(scores)).build();
        assertTrue(toJson(hit, mapper).contains("\"matched_queries\":{\"a\":1.5,\"b\":2.5}"));
    }
}
