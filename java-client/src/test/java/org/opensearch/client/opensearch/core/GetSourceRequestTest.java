package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GetSourceRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        GetSourceRequest origin = new GetSourceRequest.Builder().id("id").index("index").build();
        GetSourceRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
