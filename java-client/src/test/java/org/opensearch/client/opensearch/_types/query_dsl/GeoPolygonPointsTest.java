/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch._types.GeoLocation;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class GeoPolygonPointsTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        GeoPolygonPoints origin = new GeoPolygonPoints.Builder().points(new GeoLocation.Builder().text("text").build()).build();
        GeoPolygonPoints copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
