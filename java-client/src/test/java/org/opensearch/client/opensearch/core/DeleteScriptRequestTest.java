package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class DeleteScriptRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        DeleteScriptRequest origin = new DeleteScriptRequest.Builder().id("id").build();
        DeleteScriptRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
