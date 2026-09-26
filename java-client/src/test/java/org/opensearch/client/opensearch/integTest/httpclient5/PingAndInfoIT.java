/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.httpclient5;

import org.opensearch.client.opensearch._types.OpenSearchVersionInfo;
import org.opensearch.client.opensearch.integTest.AbstractPingAndInfoIT;

public class PingAndInfoIT extends AbstractPingAndInfoIT implements HttpClient5TransportSupport {
    @Override
    protected String expectedHttpProtocol(OpenSearchVersionInfo version) {
        return isHttps() && version.number().startsWith("3") ? "HTTP/2.0" : "HTTP/1.1";
    }
}
