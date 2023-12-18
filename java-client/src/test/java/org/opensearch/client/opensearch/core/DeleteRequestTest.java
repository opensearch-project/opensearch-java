package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class DeleteRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        DeleteRequest origin = new DeleteRequest.Builder().id("id").index("index").build();
        DeleteRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
