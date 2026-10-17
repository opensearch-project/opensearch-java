/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GeoShapeQueryFieldTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        GeoShapeQueryField origin = new GeoShapeQueryField.Builder().shape(
            s -> s.geoJson(g -> g.type("envelope").coordinates(JsonData.of(new Integer[] { 0, 6 }), JsonData.of(new Integer[] { 1, 2 })))
        ).build();
        GeoShapeQueryField copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void wktRoundtrip() {
        GeoShapeQueryField q = new GeoShapeQueryField.Builder().shape(s -> s.wkt("ENVELOPE (0, 1, 6, 2)")).build();

        q = checkJsonRoundtrip(q, "{\"shape\":\"ENVELOPE (0, 1, 6, 2)\"}");

        assertTrue(q.shape().isWkt());
        assertEquals("ENVELOPE (0, 1, 6, 2)", q.shape().wkt());
    }

    @Test
    public void geoJsonRoundtrip() {
        GeoShapeQueryField q = new GeoShapeQueryField.Builder().shape(
            s -> s.geoJson(g -> g.type("envelope").coordinates(JsonData.of(new Integer[] { 0, 6 }), JsonData.of(new Integer[] { 1, 2 })))
        ).build();

        q = checkJsonRoundtrip(q, "{\"shape\":{\"coordinates\":[[0,6],[1,2]],\"type\":\"envelope\"}}");

        assertTrue(q.shape().isGeoJson());
        assertEquals("envelope", q.shape().geoJson().type());
    }
}
