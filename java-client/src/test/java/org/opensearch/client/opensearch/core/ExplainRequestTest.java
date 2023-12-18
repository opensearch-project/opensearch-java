package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ExplainRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        ExplainRequest origin = new ExplainRequest.Builder().index("index").id("id").build();
        ExplainRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
