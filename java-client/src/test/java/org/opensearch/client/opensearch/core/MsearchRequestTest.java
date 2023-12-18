package org.opensearch.client.opensearch.core;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class MsearchRequestTest extends Assert {

    @Test
    public void toBuilder() {
        MsearchRequest origin = new MsearchRequest.Builder().index("index").searches(List.of()).build();
        MsearchRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
