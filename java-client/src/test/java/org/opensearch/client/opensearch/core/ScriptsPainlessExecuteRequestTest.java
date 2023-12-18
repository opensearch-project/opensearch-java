package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class ScriptsPainlessExecuteRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ScriptsPainlessExecuteRequest origin = new ScriptsPainlessExecuteRequest.Builder().context("context").build();
        ScriptsPainlessExecuteRequest copied = origin.toBuilder().build();

        assertEquals(copied.context(), origin.context());
    }
}
