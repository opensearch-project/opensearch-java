package org.opensearch.client.opensearch._types.query_dsl;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PinnedQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        PinnedQuery origin = new PinnedQuery.Builder().organic(buildDummyQuery()).ids(List.of("1")).build();
        PinnedQuery copied = origin.toBuilder().build();

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
