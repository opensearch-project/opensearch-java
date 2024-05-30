package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ParentIdQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        ParentIdQuery origin = new ParentIdQuery.Builder().id("id").build();
        ParentIdQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
