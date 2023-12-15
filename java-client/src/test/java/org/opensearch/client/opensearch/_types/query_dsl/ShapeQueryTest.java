package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ShapeQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        ShapeQuery origin = new ShapeQuery.Builder().field("field").shape(new ShapeFieldQuery.Builder().shape(JsonData.of("{}")).build()).build();
        ShapeQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
