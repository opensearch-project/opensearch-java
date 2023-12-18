package org.opensearch.client.opensearch.core;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class RankEvalRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        RankEvalRequest origin = new RankEvalRequest.Builder()
            .index("index")
            .requests(List.of())
            .build();
        RankEvalRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
