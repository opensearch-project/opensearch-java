package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class DeleteScriptRequestTest extends Assert {

    @Test
    public void toBuilder() {
        DeleteScriptRequest origin = new DeleteScriptRequest.Builder().id("id").build();
        DeleteScriptRequest copied = origin.toBuilder().build();

        assertEquals(copied.id(), origin.id());
    }
}
