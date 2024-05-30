package org.opensearch.client.opensearch._types.query_dsl;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GeoDistanceQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        GeoDistanceQuery origin = new GeoDistanceQuery.Builder().field("field")
            .location(new GeoLocation.Builder().coords(Collections.singletonList(1.0)).build())
            .build();
        GeoDistanceQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
