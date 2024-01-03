package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class DecayPlacementTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        DecayPlacement origin = new DecayPlacement.Builder().build();
        DecayPlacement copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
