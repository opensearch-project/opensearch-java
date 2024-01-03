package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MatchPhraseQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        MatchPhraseQuery origin = new MatchPhraseQuery.Builder().field("field").query("query").build();
        MatchPhraseQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
