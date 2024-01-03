package org.opensearch.client.opensearch.core;

import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

public class MsearchRequestTest extends Assert {

    @Test
    public void toBuilder() {
        MsearchRequest origin = new MsearchRequest.Builder().index("index").searches(Collections.emptyList()).build();
        MsearchRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
