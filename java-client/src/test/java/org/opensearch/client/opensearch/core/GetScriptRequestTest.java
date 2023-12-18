package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GetScriptRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        GetScriptRequest origin = new GetScriptRequest.Builder().id("id").build();
        GetScriptRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
