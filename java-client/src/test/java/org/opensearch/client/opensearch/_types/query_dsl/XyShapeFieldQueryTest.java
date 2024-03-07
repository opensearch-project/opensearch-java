package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class XyShapeFieldQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        XyShapeFieldQuery origin = new XyShapeFieldQuery.Builder().build();
        XyShapeFieldQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
