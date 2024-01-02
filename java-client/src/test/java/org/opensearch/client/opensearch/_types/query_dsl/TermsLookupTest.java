package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TermsLookupTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        TermsLookup origin = new TermsLookup.Builder().id("id").index("index").path("path").build();
        TermsLookup copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
