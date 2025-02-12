/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class KnnQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        KnnQuery origin = new KnnQuery.Builder().field("field").vector(new float[] { 1.0f }).k(1).minScore(0.0f).maxDistance(1.0f).build();
        KnnQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void roundTripJson() {
        KnnQuery query = new KnnQuery.Builder().field("field")
            .vector(new float[] { 1.0f })
            .k(1)
            .minScore(0.0f)
            .maxDistance(1.0f)
            .methodParameters("ef_search", JsonData.of(100))
            .build();
        String json =
            "{\"field\":{\"vector\":[1.0],\"k\":1,\"min_score\":0.0,\"max_distance\":1.0,\"method_parameters\":{\"ef_search\":100}}}";
        query = checkJsonRoundtrip(query, json);
        assertEquals("field", query.field());
        assertArrayEquals(new float[] { 1.0f }, query.vector(), 0.001f);
        assertEquals((Integer) 1, query.k());
        assertEquals((Float) 0.0f, query.minScore());
        assertEquals((Float) 1.0f, query.maxDistance());
        assertEquals((Integer) 100, query.methodParameters().get("ef_search").to(Integer.class));
    }
}
