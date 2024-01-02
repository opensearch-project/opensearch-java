package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RankFeatureQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        RankFeatureQuery origin = new RankFeatureQuery.Builder().field("field").build();
        RankFeatureQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
