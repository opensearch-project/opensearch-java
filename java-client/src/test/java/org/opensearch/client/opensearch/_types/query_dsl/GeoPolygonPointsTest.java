package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GeoPolygonPointsTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        GeoPolygonPoints origin = new GeoPolygonPoints.Builder().points(new GeoLocation.Builder().text("text").build()).build();
        GeoPolygonPoints copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
