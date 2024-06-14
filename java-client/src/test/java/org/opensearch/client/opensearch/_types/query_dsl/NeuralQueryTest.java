/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class NeuralQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        NeuralQuery origin = new NeuralQuery.Builder().field("field")
            .queryText("queryText")
            .k(1)
            .filter(IdsQuery.of(builder -> builder.values("Some_ID")).toQuery())
            .build();
        NeuralQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
