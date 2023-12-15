package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TypeQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        TypeQuery origin = new TypeQuery.Builder().value("value").build();
        TypeQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
