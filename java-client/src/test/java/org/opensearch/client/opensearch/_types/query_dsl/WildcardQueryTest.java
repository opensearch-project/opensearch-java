package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class WildcardQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        WildcardQuery origin = new WildcardQuery.Builder().field("field").value("value").build();
        WildcardQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
