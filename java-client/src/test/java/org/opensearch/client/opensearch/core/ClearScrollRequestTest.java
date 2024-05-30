package org.opensearch.client.opensearch.core;

import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

public class ClearScrollRequestTest extends Assert {

    @Test
    public void toBuilder() {
        ClearScrollRequest origin = new ClearScrollRequest.Builder().scrollId(Collections.singletonList("1")).build();
        ClearScrollRequest copied = origin.toBuilder().build();

        assertEquals(copied.scrollId(), origin.scrollId());
    }
}
