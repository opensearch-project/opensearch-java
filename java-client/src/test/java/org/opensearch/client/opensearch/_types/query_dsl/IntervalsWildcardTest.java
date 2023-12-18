package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsWildcardTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IntervalsWildcard origin = new IntervalsWildcard.Builder().useField("useField").pattern("pattern").build();
        IntervalsWildcard copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
