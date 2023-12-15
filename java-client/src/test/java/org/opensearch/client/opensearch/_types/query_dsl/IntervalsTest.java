package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        Intervals origin = new Intervals.Builder().match(new IntervalsMatch.Builder().query("query").build()).build();
        Intervals copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
