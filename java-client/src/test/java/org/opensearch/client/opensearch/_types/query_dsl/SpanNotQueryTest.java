package org.opensearch.client.opensearch._types.query_dsl;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanNotQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanNotQuery origin = new SpanNotQuery.Builder().include(
            new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(Collections.emptyList()).build()).build()
        ).exclude(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(Collections.emptyList()).build()).build()).build();
        SpanNotQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
