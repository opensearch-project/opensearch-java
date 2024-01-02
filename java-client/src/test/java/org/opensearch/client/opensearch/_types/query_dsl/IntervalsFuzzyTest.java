package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IntervalsFuzzyTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        IntervalsFuzzy origin = new IntervalsFuzzy.Builder().term("term").fuzziness("fuzziness").build();
        IntervalsFuzzy copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
