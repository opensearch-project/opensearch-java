package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IntervalsQuery origin = new IntervalsQuery.Builder()
            .field("field")
            .allOf(new IntervalsAllOf.Builder()
                .intervals(new Intervals.Builder().match(new IntervalsMatch.Builder().query("query").build()).build())
                .build())
            .build();
        IntervalsQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
