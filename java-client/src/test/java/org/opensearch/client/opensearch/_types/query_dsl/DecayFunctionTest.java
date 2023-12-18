package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class DecayFunctionTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        DecayFunction origin = new DecayFunction.Builder().field("field").placement(new DecayPlacement.Builder().build()).build();
        DecayFunction copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
