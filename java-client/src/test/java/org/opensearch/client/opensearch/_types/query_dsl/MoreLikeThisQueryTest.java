package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MoreLikeThisQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        MoreLikeThisQuery origin = new MoreLikeThisQuery.Builder().like(new Like.Builder().text("text").build()).build();
        MoreLikeThisQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
