package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class QueryStringQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        QueryStringQuery origin = new QueryStringQuery.Builder().query("query").build();
        QueryStringQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
