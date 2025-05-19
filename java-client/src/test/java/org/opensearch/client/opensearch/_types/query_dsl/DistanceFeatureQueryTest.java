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

public class DistanceFeatureQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        DistanceFeatureQuery origin = new DistanceFeatureQuery.Builder().origin(JsonData.of("{}")).pivot("{}").field("field").build();
        DistanceFeatureQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
