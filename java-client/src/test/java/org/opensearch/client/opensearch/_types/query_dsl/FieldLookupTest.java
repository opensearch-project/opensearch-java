package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FieldLookupTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        FieldLookup origin = new FieldLookup.Builder().id("id").build();
        FieldLookup copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
