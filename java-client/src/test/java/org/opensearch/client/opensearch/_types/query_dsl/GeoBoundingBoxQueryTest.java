/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.CoordsGeoBounds;
import org.opensearch.client.opensearch._types.GeoBounds;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GeoBoundingBoxQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        GeoBoundingBoxQuery origin = new GeoBoundingBoxQuery.Builder().field("field")
            .boundingBox(
                new GeoBounds.Builder().coords(new CoordsGeoBounds.Builder().top(1.0f).bottom(1.0f).left(1.0f).right(1.0f).build()).build()
            )
            .build();
        GeoBoundingBoxQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
