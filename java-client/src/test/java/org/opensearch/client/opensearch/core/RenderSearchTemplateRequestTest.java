package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RenderSearchTemplateRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        RenderSearchTemplateRequest origin = new RenderSearchTemplateRequest.Builder().build();
        RenderSearchTemplateRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
