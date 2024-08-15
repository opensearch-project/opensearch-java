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
import org.opensearch.client.util.MissingRequiredPropertiesException;

public class NeuralQueryTest extends ModelTestCase {
    @Test
    public void toBuilder_queryText() {
        NeuralQuery origin = new NeuralQuery.Builder().field("field")
            .queryText("queryText")
            .k(1)
            .filter(IdsQuery.of(builder -> builder.values("Some_ID")).toQuery())
            .build();
        NeuralQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void toBuilder_queryImage() {
        NeuralQuery origin = new NeuralQuery.Builder().field("field")
            .queryImage("queryImage")
            .k(1)
            .filter(IdsQuery.of(builder -> builder.values("Some_ID")).toQuery())
            .build();
        NeuralQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void toBuilder_both() {
        NeuralQuery origin = new NeuralQuery.Builder().field("field")
            .queryText("queryText")
            .queryImage("queryImage")
            .k(1)
            .filter(IdsQuery.of(builder -> builder.values("Some_ID")).toQuery())
            .build();
        NeuralQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void toBuilder_missing_query() {
        assertThrows(
            MissingRequiredPropertiesException.class,
            () -> new NeuralQuery.Builder().field("field").k(1).filter(IdsQuery.of(builder -> builder.values("Some_ID")).toQuery()).build()
        );
    }
}
