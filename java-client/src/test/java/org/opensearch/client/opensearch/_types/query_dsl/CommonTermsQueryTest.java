package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class CommonTermsQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        CommonTermsQuery origin = new CommonTermsQuery.Builder().query("query").field("field").build();
        CommonTermsQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
