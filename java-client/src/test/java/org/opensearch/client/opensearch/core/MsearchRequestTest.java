package org.opensearch.client.opensearch.core;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MsearchRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        MsearchRequest origin = new MsearchRequest.Builder()
            .index("index")
            .searches(List.of())
            .build();
        MsearchRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
