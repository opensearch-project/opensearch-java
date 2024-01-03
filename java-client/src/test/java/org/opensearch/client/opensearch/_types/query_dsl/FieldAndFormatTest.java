package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FieldAndFormatTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        FieldAndFormat origin = new FieldAndFormat.Builder().field("field").build();
        FieldAndFormat copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
