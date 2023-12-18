package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FieldCapsRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        FieldCapsRequest origin = new FieldCapsRequest.Builder().index("index").build();
        FieldCapsRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
