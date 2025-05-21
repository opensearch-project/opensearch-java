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

public class ExtendedBoundsTest extends ModelTestCase {
    @Test
    public void testToJsonString() {
        ExtendedBounds<Double> bounds = ExtendedBounds.of(eb -> eb.min(0.0).max(4096.0));

        assertEquals("{\"max\":4096.0,\"min\":0.0}", bounds.toJsonString());
    }
}
