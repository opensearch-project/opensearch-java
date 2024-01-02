package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FieldValueFactorScoreFunctionTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        FieldValueFactorScoreFunction origin = new FieldValueFactorScoreFunction.Builder().field("field").build();
        FieldValueFactorScoreFunction copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
