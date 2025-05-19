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
import org.opensearch.client.opensearch.model.ModelTestCase;

public class SpanContainingQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        SpanContainingQuery origin = new SpanContainingQuery.Builder().big(
            new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(Collections.emptyList()).build()).build()
        ).little(new SpanQuery.Builder().spanOr(new SpanOrQuery.Builder().clauses(Collections.emptyList()).build()).build()).build();
        SpanContainingQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
