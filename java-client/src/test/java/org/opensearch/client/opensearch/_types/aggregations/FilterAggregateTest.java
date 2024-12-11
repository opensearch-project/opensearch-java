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

public class FilterAggregateTest extends ModelTestCase {
    @Test
    public void serializesNestedAggregates() {
        String json = "{\"sum#l2_result\":{\"value\":1.0},\"doc_count\":1}";
        FilterAggregate aggregate = fromJson(json, FilterAggregate._DESERIALIZER);
        assertEquals(json, toJson(aggregate));
    }
}
