package org.opensearch.client.opensearch._types.query_dsl;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanWithinQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanWithinQuery origin = new SpanWithinQuery.Builder().big(
            new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(List.of()).build()).build()
        ).little(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(List.of()).build()).build()).build();
        SpanWithinQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
