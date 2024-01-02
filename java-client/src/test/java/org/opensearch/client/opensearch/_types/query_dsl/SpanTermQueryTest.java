package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanTermQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanTermQuery origin = new SpanTermQuery.Builder().field("field").value("value").build();
        SpanTermQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
