package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class LikeTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        Like origin = new Like.Builder().text("text").build();
        Like copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
