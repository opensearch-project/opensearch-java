package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class FieldCapsRequestTest extends Assert {

    @Test
    public void toBuilder() {
        FieldCapsRequest origin = new FieldCapsRequest.Builder().index("index").build();
        FieldCapsRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
