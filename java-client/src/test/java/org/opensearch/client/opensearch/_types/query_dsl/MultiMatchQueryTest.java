package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MultiMatchQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        MultiMatchQuery origin = new MultiMatchQuery.Builder().query("query").build();
        MultiMatchQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
