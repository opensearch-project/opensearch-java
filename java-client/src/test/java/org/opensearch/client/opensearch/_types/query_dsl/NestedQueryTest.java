package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class NestedQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        NestedQuery origin = new NestedQuery.Builder().query(buildDummyQuery()).path("path").build();
        NestedQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    private Query buildDummyQuery() {
        return Query.of(
            query -> query.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(
                    FieldValue.of(1)))))
            )
        );
    }
}
