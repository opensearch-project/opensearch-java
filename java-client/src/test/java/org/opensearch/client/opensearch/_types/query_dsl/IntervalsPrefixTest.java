package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsPrefixTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IntervalsPrefix origin = new IntervalsPrefix.Builder().prefix("prefix").build();
        IntervalsPrefix copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
