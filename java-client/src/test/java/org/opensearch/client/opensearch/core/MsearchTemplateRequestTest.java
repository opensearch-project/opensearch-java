package org.opensearch.client.opensearch.core;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MsearchTemplateRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        MsearchTemplateRequest origin = new MsearchTemplateRequest.Builder().index("index").searchTemplates(List.of()).build();
        MsearchTemplateRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
