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
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class HybridQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        HybridQuery origin = new HybridQuery.Builder().queries(
            Arrays.asList(
                new TermQuery.Builder().field("passage_text").value(FieldValue.of("Foo bar")).build().toQuery(),
                new NeuralQuery.Builder().field("passage_embedding")
                    .queryText("Hi world")
                    .modelId("bQ1J8ooBpBj3wT4HVUsb")
                    .k(100)
                    .build()
                    .toQuery(),
                new KnnQuery.Builder().field("passage_embedding").vector(0.01f, 0.02f).k(2).build().toQuery()
            )
        ).paginationDepth(100).build();
        HybridQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
