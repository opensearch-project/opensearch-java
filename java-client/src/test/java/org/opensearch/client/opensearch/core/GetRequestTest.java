package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class GetRequestTest extends Assert {

    @Test
    public void toBuilder() {
        GetRequest origin = new GetRequest.Builder().index("index").id("id").build();
        GetRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
