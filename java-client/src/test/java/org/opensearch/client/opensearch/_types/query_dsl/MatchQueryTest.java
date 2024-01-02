package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MatchQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        MatchQuery origin = new MatchQuery.Builder().field("field").query(FieldValue.of("1")).build();
        MatchQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
