package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MtermvectorsRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        MtermvectorsRequest origin = new MtermvectorsRequest.Builder().index("index").build();
        MtermvectorsRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
