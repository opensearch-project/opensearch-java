package org.opensearch.client.opensearch._types.query_dsl;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanOrQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanOrQuery origin = new SpanOrQuery.Builder()
            .clauses(List.of(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(List.of()).build()).build()))
            .build();
        SpanOrQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
