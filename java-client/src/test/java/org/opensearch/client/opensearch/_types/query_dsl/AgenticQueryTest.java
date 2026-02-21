/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import java.util.Arrays;
import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class AgenticQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        AgenticQuery origin = new AgenticQuery.Builder().queryText("What is the best selling product?")
            .queryFields(Arrays.asList("title", "description"))
            .memoryId("conv-123")
            .build();
        AgenticQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
