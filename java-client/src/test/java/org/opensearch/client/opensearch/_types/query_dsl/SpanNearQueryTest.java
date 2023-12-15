package org.opensearch.client.opensearch._types.query_dsl;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanNearQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanNearQuery origin = new SpanNearQuery.Builder()
            .clauses(List.of(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(List.of()).build()).build()))
            .build();
        SpanNearQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
