package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RankFeatureFunctionLogarithmTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        RankFeatureFunctionLogarithm origin = new RankFeatureFunctionLogarithm.Builder().scalingFactor(1.0f).build();
        RankFeatureFunctionLogarithm copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
