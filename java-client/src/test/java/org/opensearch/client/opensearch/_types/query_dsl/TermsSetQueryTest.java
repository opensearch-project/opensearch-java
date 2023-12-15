package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TermsSetQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        TermsSetQuery origin = new TermsSetQuery.Builder()
            .field("field")
            .terms("terms")
            .build();
        TermsSetQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
