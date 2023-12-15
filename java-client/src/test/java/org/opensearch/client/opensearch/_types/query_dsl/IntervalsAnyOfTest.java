package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsAnyOfTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IntervalsAnyOf origin = new IntervalsAnyOf.Builder()
            .intervals(new Intervals.Builder().match(new IntervalsMatch.Builder().query("query").build()).build())
            .build();
        IntervalsAnyOf copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
