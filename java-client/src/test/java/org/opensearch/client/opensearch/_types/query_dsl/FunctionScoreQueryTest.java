package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FunctionScoreQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        FunctionScoreQuery origin = new FunctionScoreQuery.Builder().build();
        FunctionScoreQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
