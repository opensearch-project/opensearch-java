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

public class GeoShapeQueryFieldTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        GeoShapeQueryField origin = new GeoShapeQueryField.Builder().shape(s -> s).build();
        GeoShapeQueryField copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void indexedShapeOnly() {
        GeoShapeQueryField field = new GeoShapeQueryField.Builder().indexedShape(
            i -> i.id("id").index("shapes").path("location")
        ).build();

        assertNull(field.shape());
        assertEquals("id", field.indexedShape().id());
        assertEquals("{\"indexed_shape\":{\"id\":\"id\",\"index\":\"shapes\",\"path\":\"location\"}}", toJson(field));
    }
}
