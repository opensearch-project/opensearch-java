package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MgetRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        MgetRequest origin = new MgetRequest.Builder().index("index").build();
        MgetRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
