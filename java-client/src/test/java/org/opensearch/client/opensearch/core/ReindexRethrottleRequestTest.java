package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ReindexRethrottleRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        ReindexRethrottleRequest origin = new ReindexRethrottleRequest.Builder().taskId("taskId").build();
        ReindexRethrottleRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
