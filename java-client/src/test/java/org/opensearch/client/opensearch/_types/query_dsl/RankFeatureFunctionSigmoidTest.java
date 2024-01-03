package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RankFeatureFunctionSigmoidTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        RankFeatureFunctionSigmoid origin = new RankFeatureFunctionSigmoid.Builder().exponent(1.0f).pivot(1.0f).build();
        RankFeatureFunctionSigmoid copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
