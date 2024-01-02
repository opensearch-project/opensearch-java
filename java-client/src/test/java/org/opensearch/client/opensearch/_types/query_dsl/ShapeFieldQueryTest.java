package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ShapeFieldQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        ShapeFieldQuery origin = new ShapeFieldQuery.Builder().shape(JsonData.of("{}")).build();
        ShapeFieldQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
