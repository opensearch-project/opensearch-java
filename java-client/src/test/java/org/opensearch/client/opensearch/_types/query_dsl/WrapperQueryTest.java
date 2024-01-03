package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class WrapperQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        WrapperQuery origin = new WrapperQuery.Builder().query("query").build();
        WrapperQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
