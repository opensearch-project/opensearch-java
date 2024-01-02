package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RandomScoreFunctionTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        RandomScoreFunction origin = new RandomScoreFunction.Builder().seed("seed").build();
        RandomScoreFunction copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
