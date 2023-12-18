package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ScrollRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        ScrollRequest origin = new ScrollRequest.Builder().scrollId("scrollId").build();
        ScrollRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
