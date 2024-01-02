package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class ReindexRethrottleRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ReindexRethrottleRequest origin = new ReindexRethrottleRequest.Builder().taskId("taskId").build();
        ReindexRethrottleRequest copied = origin.toBuilder().build();

        assertEquals(copied.taskId(), origin.taskId());
    }
}
