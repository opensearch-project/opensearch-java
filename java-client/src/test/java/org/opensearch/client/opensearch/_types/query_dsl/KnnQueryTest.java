package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class KnnQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        KnnQuery origin = new KnnQuery.Builder().field("field").vector(new float[] { 1.0f }).k(1).build();
        KnnQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
