package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PrefixQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        PrefixQuery origin = new PrefixQuery.Builder().field("field").value("value").build();
        PrefixQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
