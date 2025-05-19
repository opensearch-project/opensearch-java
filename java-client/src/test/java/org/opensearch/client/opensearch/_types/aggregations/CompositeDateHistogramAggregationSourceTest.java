/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch._types.aggregations;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class CompositeDateHistogramAggregationSourceTest extends ModelTestCase {

    @Test
    public void testSerializeSpecificFields() {
        String json = "{\"calendar_interval\":\"1d\",\"fixed_interval\":\"1d\",\"offset\":1,\"time_zone\":\"+01:00\"}";
        CompositeDateHistogramAggregationSource aggregation = fromJson(json, CompositeDateHistogramAggregationSource._DESERIALIZER);
        assertEquals(json, toJson(aggregation));
    }

}
