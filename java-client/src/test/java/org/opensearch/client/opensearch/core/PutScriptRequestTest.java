package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch._types.StoredScript;

public class PutScriptRequestTest extends Assert {

    @Test
    public void toBuilder() {
        PutScriptRequest origin = new PutScriptRequest.Builder().id("id")
            .script(StoredScript.of(a -> a.lang("lang").source("source")))
            .build();
        PutScriptRequest copied = origin.toBuilder().build();

        assertEquals(copied.id(), origin.id());
    }
}
