package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsFilterTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IntervalsFilter origin = new IntervalsFilter.Builder()
            .after(new Intervals.Builder().match(new IntervalsMatch.Builder().query("query").build()).build())
            .build();
        IntervalsFilter copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
