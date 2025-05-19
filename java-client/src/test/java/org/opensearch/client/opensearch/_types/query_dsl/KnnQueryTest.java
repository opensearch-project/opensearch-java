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

public class KnnQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        KnnQuery origin = new KnnQuery.Builder().field("field").vector(1.0f).k(1).minScore(0.0f).maxDistance(1.0f).build();
        KnnQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
