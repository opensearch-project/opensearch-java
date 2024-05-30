package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SimpleQueryStringQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SimpleQueryStringQuery origin = new SimpleQueryStringQuery.Builder().query("query").build();
        SimpleQueryStringQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
