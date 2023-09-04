/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ReindexRequestTest extends Assert {
    @Test
    public void testEndpointSlicesAuto() {
        ReindexRequest reindexRequest = ReindexRequest.of(b -> b
                .slices(0L));
        Map<String, String> queryParameters = ReindexRequest._ENDPOINT.queryParameters(reindexRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("auto", queryParameters.get("slices"));
    }

    @Test
    public void testEndpointSlicesNumber() {
        ReindexRequest reindexRequest = ReindexRequest.of(b -> b
                .slices(6L));
        Map<String, String> queryParameters = ReindexRequest._ENDPOINT.queryParameters(reindexRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("6", queryParameters.get("slices"));
    }
}
