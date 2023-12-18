package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class DeleteRequestTest extends Assert {

    @Test
    public void toBuilder() {
        DeleteRequest origin = new DeleteRequest.Builder().id("id").index("index").build();
        DeleteRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
