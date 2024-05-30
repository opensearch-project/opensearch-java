package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class MgetRequestTest extends Assert {

    @Test
    public void toBuilder() {
        MgetRequest origin = new MgetRequest.Builder().index("index").build();
        MgetRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
