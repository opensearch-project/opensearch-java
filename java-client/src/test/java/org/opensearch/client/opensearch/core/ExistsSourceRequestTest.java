package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ExistsSourceRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        ExistsSourceRequest origin = new ExistsSourceRequest.Builder().index("index").id("id").build();
        ExistsSourceRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
