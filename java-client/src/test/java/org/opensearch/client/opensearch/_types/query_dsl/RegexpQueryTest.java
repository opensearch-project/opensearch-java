package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RegexpQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        RegexpQuery origin = new RegexpQuery.Builder().field("field").value("value").build();
        RegexpQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
