package org.opensearch.client.opensearch.core;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class RankEvalRequestTest extends Assert {

    @Test
    public void toBuilder() {
        RankEvalRequest origin = new RankEvalRequest.Builder().index("index").requests(List.of()).build();
        RankEvalRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
