package org.opensearch.client.opensearch._types.query_dsl;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanWithinQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanWithinQuery origin = new SpanWithinQuery.Builder().big(
            new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(Collections.emptyList()).build()).build()
        ).little(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(Collections.emptyList()).build()).build()).build();
        SpanWithinQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
