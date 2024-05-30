package org.opensearch.client.opensearch._types.query_dsl;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanQuery origin = new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(Collections.emptyList()).build()).build();
        SpanQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
