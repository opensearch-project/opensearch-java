package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class GetSourceRequestTest extends Assert {

    @Test
    public void toBuilder() {
        GetSourceRequest origin = new GetSourceRequest.Builder().id("id").index("index").build();
        GetSourceRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
