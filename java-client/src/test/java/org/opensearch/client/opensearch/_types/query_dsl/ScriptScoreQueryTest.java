/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.InlineScript;
import org.opensearch.client.opensearch._types.Script;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class ScriptScoreQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        ScriptScoreQuery origin = new ScriptScoreQuery.Builder().query(buildDummyQuery())
            .script(new Script.Builder().inline(new InlineScript.Builder().source("source").build()).build())
            .build();
        ScriptScoreQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    private Query buildDummyQuery() {
        return Query.of(
            query -> query.bool(
                builder -> builder.filter(filter -> filter.term(TermQuery.of(term -> term.field("size").value(FieldValue.of(1)))))
            )
        );
    }
}
