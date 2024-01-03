package org.opensearch.client.opensearch._types.query_dsl;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanContainingQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanContainingQuery origin = new SpanContainingQuery.Builder().big(
            new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(List.of()).build()).build()
        ).little(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(List.of()).build()).build()).build();
        SpanContainingQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
