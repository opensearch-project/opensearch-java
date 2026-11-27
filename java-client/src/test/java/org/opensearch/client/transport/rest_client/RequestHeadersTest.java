/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.rest_client;

import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHost;
import org.opensearch.client.RestClient;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.transport.AbstractRequestHeadersTest;
import org.opensearch.client.transport.OpenSearchStreamingTransport;

public class RequestHeadersTest extends AbstractRequestHeadersTest {
    @Override
    protected OpenSearchStreamingTransport createTransport(HttpHost host, Header[] defaultHeaders) {
        return new RestClientTransport(RestClient.builder(host).setDefaultHeaders(defaultHeaders).build(), new JacksonJsonpMapper());
    }
}
