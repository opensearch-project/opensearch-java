package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ExistsQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        ExistsQuery origin = new ExistsQuery.Builder().field("field").build();
        ExistsQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
