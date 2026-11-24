/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.model;

import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.util.Map;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch._types.aggregations.Aggregate;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchResponse;

/**
 * Tests that unknown/plugin-provided aggregation types deserialize into the {@code _Custom} variant
 * instead of throwing or silently dropping data.
 */
public class CustomVariantTest extends ModelTestCase {

    @Test
    public void testUnknownAggregationTypeDeserializesToCustomVariant() {
        // A response containing a fictional "my_plugin_agg" typed-key aggregation
        String json = "{\"took\":1,\"timed_out\":false,"
            + "\"_shards\":{\"total\":1,\"successful\":1,\"skipped\":0,\"failed\":0},"
            + "\"hits\":{\"total\":{\"value\":0,\"relation\":\"eq\"},\"hits\":[]},"
            + "\"aggregations\":{\"my_plugin_agg#foo\":{\"custom_field\":42,\"label\":\"hello\"}}}";

        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json));
        SearchResponse<Object> response = SearchResponse._DESERIALIZER.deserialize(parser, mapper);

        Map<String, Aggregate> aggs = response.aggregations();
        assertTrue("aggregation 'foo' should be present", aggs.containsKey("foo"));

        Aggregate agg = aggs.get("foo");
        assertEquals(Aggregate.Kind._Custom, agg._kind());
        assertTrue(agg._isCustom());
        assertEquals("my_plugin_agg", agg._customKind());

        // The raw data is accessible and contains the original payload
        JsonData data = agg._custom();
        assertNotNull(data);
        assertEquals(42, data.toJson().asJsonObject().getInt("custom_field"));
        assertEquals("hello", data.toJson().asJsonObject().getString("label"));
    }

    @Test
    public void testCustomVariantSerializesRoundTrip() {
        // Build a custom variant programmatically
        Aggregate agg = new Aggregate.Builder()._custom("my_plugin_agg", JsonData.of(Map.of("x", 1))).build();

        assertTrue(agg._isCustom());
        assertEquals("my_plugin_agg", agg._customKind());

        // Serialize and verify it produces JSON
        String json = toJson(agg);
        assertNotNull(json);
        assertTrue("serialized JSON should contain the payload", json.contains("\"x\""));
    }

    @Test
    public void testKnownAggregationTypeStillWorks() {
        // Sanity: a known type (avg) still deserializes normally
        String json = "{\"took\":1,\"timed_out\":false,"
            + "\"_shards\":{\"total\":1,\"successful\":1,\"skipped\":0,\"failed\":0},"
            + "\"hits\":{\"total\":{\"value\":0,\"relation\":\"eq\"},\"hits\":[]},"
            + "\"aggregations\":{\"avg#bar\":{\"value\":3.14}}}";

        SearchResponse<Object> response = fromJson(
            json,
            SearchResponse.createSearchResponseDeserializer(JsonpDeserializer.of(Object.class))
        );

        Aggregate agg = response.aggregations().get("bar");
        assertEquals(Aggregate.Kind.Avg, agg._kind());
        assertFalse(agg._isCustom());
        assertNull(agg._customKind());
        assertEquals(3.14, agg.avg().value(), 0.001);
    }

    @Test
    public void testCustomAggregateTypedKeysRoundTrip() {
        // Simulates a typed-keys response with a custom aggregation, then re-serializes
        String json = "{\"took\":1,\"timed_out\":false,"
            + "\"_shards\":{\"total\":1,\"successful\":1,\"skipped\":0,\"failed\":0},"
            + "\"hits\":{\"total\":{\"value\":0,\"relation\":\"eq\"},\"hits\":[]},"
            + "\"aggregations\":{\"my_plugin_agg#metric\":{\"score\":99}}}";

        SearchResponse<Object> response = fromJson(
            json,
            SearchResponse.createSearchResponseDeserializer(JsonpDeserializer.of(Object.class))
        );

        // Round-trip: serialize the response back to JSON
        String reserialized = toJson(response);
        // The typed-key format must use the custom type name, not "null"
        assertTrue("typed-key must contain custom type name", reserialized.contains("my_plugin_agg#metric"));
        assertTrue("payload must survive round-trip", reserialized.contains("\"score\""));
    }

    @Test
    public void testCustomQueryVariantRoundTrip() {
        // An internally-tagged query with a plugin-provided type
        String json = "{\"my_plugin_query\":{\"param\":\"value\"}}";

        Query query = fromJson(json, Query._DESERIALIZER);

        assertTrue(query._isCustom());
        assertEquals("my_plugin_query", query._customKind());
        assertNotNull(query._custom());

        // Round-trip serialization
        String reserialized = toJson(query);
        assertTrue("must contain custom type key", reserialized.contains("\"my_plugin_query\""));
        assertTrue("must contain payload", reserialized.contains("\"param\""));
    }

    @Test
    public void testCustomVariantEquality() {
        Aggregate a = new Aggregate.Builder()._custom("type_a", JsonData.of(Map.of("x", 1))).build();
        Aggregate b = new Aggregate.Builder()._custom("type_a", JsonData.of(Map.of("x", 1))).build();
        Aggregate c = new Aggregate.Builder()._custom("type_b", JsonData.of(Map.of("x", 1))).build();

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, c); // different _customKind
    }
}
