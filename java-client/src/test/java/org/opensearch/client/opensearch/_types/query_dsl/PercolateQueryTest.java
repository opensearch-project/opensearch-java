package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PercolateQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        PercolateQuery origin = new PercolateQuery.Builder().id("id").field("field").build();
        PercolateQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
