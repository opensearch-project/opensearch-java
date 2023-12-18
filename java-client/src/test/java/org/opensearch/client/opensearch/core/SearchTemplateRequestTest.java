package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SearchTemplateRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        SearchTemplateRequest origin = new SearchTemplateRequest.Builder().index("index").build();
        SearchTemplateRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
