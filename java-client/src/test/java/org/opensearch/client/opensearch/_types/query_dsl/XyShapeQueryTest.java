package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class XyShapeQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        XyShapeQuery origin = new XyShapeQuery.Builder().field("field")
            .xyShape(new XyShapeFieldQuery.Builder().xyShape(JsonData.of("{}")).build())
            .build();
        XyShapeQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
