package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GetRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        GetRequest origin = new GetRequest.Builder().index("index").id("id").build();
        GetRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
