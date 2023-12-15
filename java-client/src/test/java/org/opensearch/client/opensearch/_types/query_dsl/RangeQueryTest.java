package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RangeQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        RangeQuery origin = new RangeQuery.Builder().field("field").build();
        RangeQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
