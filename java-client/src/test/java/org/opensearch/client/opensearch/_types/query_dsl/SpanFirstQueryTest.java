package org.opensearch.client.opensearch._types.query_dsl;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanFirstQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanFirstQuery origin = new SpanFirstQuery.Builder()
            .end(1)
            .match(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(List.of()).build()).build())
            .build();
        SpanFirstQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
