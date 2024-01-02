package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IdsQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IdsQuery origin = new IdsQuery.Builder().build();
        IdsQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
