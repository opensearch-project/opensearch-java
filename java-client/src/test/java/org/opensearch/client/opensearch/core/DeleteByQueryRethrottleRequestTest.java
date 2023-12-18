package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class DeleteByQueryRethrottleRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        DeleteByQueryRethrottleRequest origin = new DeleteByQueryRethrottleRequest.Builder()
            .taskId("taskId")
            .build();
        DeleteByQueryRethrottleRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
