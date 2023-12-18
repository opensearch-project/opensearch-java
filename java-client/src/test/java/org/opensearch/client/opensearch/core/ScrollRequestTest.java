package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class ScrollRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ScrollRequest origin = new ScrollRequest.Builder().scrollId("scrollId").build();
        ScrollRequest copied = origin.toBuilder().build();

        assertEquals(copied.scrollId(), origin.scrollId());
    }
}
