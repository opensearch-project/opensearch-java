/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.aws;

import org.junit.Assert;
import org.junit.Test;

public class AwsSdk2TransportOptionsTestCase extends Assert {
    @Test
    public void testBuilderResponseCompression() throws Exception {
        AwsSdk2TransportOptions options = AwsSdk2TransportOptions.builder()
            .setResponseCompression(true)
            .setRequestCompressionSize(10)
            .build();
        assertEquals(10, options.requestCompressionSize().intValue());
        assertTrue(options.responseCompression());
    }
}
