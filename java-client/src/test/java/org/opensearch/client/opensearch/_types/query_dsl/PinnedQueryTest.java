/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import java.util.Collections;
import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PinnedQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        PinnedQuery origin = new PinnedQuery.Builder().organic(buildDummyQuery()).ids(Collections.singletonList("1")).build();
        PinnedQuery copied = origin.toBuilder().build();

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
