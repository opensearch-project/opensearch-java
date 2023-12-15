package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FuzzyQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        FuzzyQuery origin = new FuzzyQuery.Builder().field("field").value(FieldValue.of("value")).build();
        FuzzyQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
