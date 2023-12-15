package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsAllOfTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IntervalsAllOf origin = new IntervalsAllOf.Builder()
            .intervals(new Intervals.Builder().match(new IntervalsMatch.Builder().query("query").build()).build())
            .build();
        IntervalsAllOf copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
