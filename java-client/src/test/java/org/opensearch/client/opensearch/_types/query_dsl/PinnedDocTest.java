package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PinnedDocTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        PinnedDoc origin = new PinnedDoc.Builder().index("index").id("id").build();
        PinnedDoc copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
