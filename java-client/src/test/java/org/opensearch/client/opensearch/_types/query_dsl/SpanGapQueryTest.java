package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanGapQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanGapQuery origin = new SpanGapQuery.Builder().field("field").spanWidth(1).build();
        SpanGapQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
