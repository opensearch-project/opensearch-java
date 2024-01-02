package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TermQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        TermQuery origin = new TermQuery.Builder().field("field").value(FieldValue.of("1")).build();
        TermQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
