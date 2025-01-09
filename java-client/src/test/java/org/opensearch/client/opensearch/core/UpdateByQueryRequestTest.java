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

public class UpdateByQueryRequestTest extends Assert {
    @Test
    public void testEndpointSlicesAuto() {
        UpdateByQueryRequest updateByQueryRequest = UpdateByQueryRequest.of(
            b -> b.index("test-index").slices(s -> s.calculation(SlicesCalculation.Auto))
        );
        Map<String, String> queryParameters = UpdateByQueryRequest._ENDPOINT.queryParameters(updateByQueryRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("auto", queryParameters.get("slices"));
    }

    @Test
    public void testEndpointSlicesNumber() {
        UpdateByQueryRequest updateByQueryRequest = UpdateByQueryRequest.of(b -> b.index("test-index").slices(s -> s.count(6)));
        Map<String, String> queryParameters = UpdateByQueryRequest._ENDPOINT.queryParameters(updateByQueryRequest);
        assertTrue("Must have a slices query parameter", queryParameters.containsKey("slices"));
        assertEquals("6", queryParameters.get("slices"));
    }

    @Test
    public void toBuilder() {
        UpdateByQueryRequest origin = new UpdateByQueryRequest.Builder().index("index").slices(s -> s.count(6)).build();
        UpdateByQueryRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
        assertEquals(copied.slices(), origin.slices());
    }
}
