package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class ExplainRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ExplainRequest origin = new ExplainRequest.Builder().index("index").id("id").build();
        ExplainRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
