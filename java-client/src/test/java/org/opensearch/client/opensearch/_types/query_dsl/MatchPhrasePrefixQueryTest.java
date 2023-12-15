package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class MatchPhrasePrefixQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        MatchPhrasePrefixQuery origin = new MatchPhrasePrefixQuery.Builder().field("field").query("query").build();
        MatchPhrasePrefixQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
