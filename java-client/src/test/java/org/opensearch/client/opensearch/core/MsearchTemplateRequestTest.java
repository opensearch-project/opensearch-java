package org.opensearch.client.opensearch.core;

import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

public class MsearchTemplateRequestTest extends Assert {

    @Test
    public void toBuilder() {
        MsearchTemplateRequest origin = new MsearchTemplateRequest.Builder().index("index")
            .searchTemplates(Collections.emptyList())
            .build();
        MsearchTemplateRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
