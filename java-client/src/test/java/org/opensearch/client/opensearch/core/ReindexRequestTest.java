/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch._types.SlicesCalculation;

public class ReindexRequestTest extends Assert {
    @Test
    public void testEndpointSlicesAuto() {
        ReindexRequest reindexRequest = ReindexRequest.of(
            b -> b.source(s -> s.index("source")).dest(d -> d.index("dest")).slices(s -> s.calculation(SlicesCalculation.Auto))
        );
        Map<String, String> queryParameters = ReindexRequest._ENDPOINT.queryParameters(reindexRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("auto", queryParameters.get("slices"));
    }

    @Test
    public void testEndpointSlicesNumber() {
        ReindexRequest reindexRequest = ReindexRequest.of(
            b -> b.source(s -> s.index("source")).dest(d -> d.index("dest")).slices(s -> s.count(6))
        );
        Map<String, String> queryParameters = ReindexRequest._ENDPOINT.queryParameters(reindexRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("6", queryParameters.get("slices"));
    }

    @Test
    public void toBuilder() {
        ReindexRequest origin = new ReindexRequest.Builder().source(s -> s.index("source"))
            .dest(d -> d.index("dest"))
            .requestsPerSecond(1f)
            .build();
        ReindexRequest copied = origin.toBuilder().build();

        assertEquals(copied.requestsPerSecond(), origin.requestsPerSecond());
    }
}
