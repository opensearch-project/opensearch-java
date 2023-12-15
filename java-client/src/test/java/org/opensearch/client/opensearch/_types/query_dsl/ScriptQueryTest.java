package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.InlineScript;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ScriptQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        ScriptQuery origin = new ScriptQuery.Builder().script(
            new Script.Builder().inline(new InlineScript.Builder().source("source").build()).build()
        ).build();
        ScriptQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
