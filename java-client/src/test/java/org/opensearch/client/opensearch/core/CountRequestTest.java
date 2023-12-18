package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class CountRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        CountRequest origin = new CountRequest.Builder()
            .index("index")
            .build();
        CountRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
