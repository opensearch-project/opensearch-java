package org.opensearch.client.opensearch.core;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ClearScrollRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        ClearScrollRequest origin = new ClearScrollRequest.Builder().scrollId(List.of("1")).build();
        ClearScrollRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
