package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class NeuralQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        NeuralQuery origin = new NeuralQuery.Builder().field("field").queryText("queryText").k(1).build();
        NeuralQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
