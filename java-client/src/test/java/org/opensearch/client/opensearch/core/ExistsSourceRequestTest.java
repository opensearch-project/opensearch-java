package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

public class ExistsSourceRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ExistsSourceRequest origin = new ExistsSourceRequest.Builder().index("index").id("id").build();
        ExistsSourceRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
