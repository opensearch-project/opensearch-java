package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ExistsRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        ExistsRequest origin = new ExistsRequest.Builder().index("index").id("id").build();
        ExistsRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
