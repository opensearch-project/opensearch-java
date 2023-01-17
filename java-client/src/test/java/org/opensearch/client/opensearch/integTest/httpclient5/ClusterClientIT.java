/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.httpclient5;

import java.io.IOException;

import org.opensearch.client.opensearch.integTest.AbstractClusterClientIT;
import org.opensearch.client.transport.httpclient5.ResponseException;

public class ClusterClientIT extends AbstractClusterClientIT implements HttpClient5TransportSupport {
    @Override
    public void testClusterHealthNotFoundIndex() throws IOException {
        try {
            super.testClusterHealthNotFoundIndex();
        } catch (ResponseException e) {
            assertNotNull(e);
        }
    }
}
