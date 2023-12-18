package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch._types.StoredScript;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PutScriptRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        PutScriptRequest origin = new PutScriptRequest.Builder().id("id")
            .script(StoredScript.of(a -> a.lang("lang").source("source")))
            .build();
        PutScriptRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
