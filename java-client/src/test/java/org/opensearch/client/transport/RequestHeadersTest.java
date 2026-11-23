/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.hc.core5.http.HttpHost;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.RestClient;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.opensearch.client.transport.rest_client.RestClientTransport;

/**
 * Verifies that the headers of a generic client request reach the server, in addition to the headers of the transport options.
 */
public class RequestHeadersTest extends Assert {

    private HttpServer httpServer;
    private final List<Headers> receivedHeaders = Collections.synchronizedList(new ArrayList<>());

    @Before
    public void setup() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        httpServer.createContext("/", ex -> {
            receivedHeaders.add(ex.getRequestHeaders());
            ex.sendResponseHeaders(200, -1);
            ex.close();
        });
        httpServer.start();
    }

    @After
    public void tearDown() {
        httpServer.stop(0);
    }

    @Test
    public void testRestClientTransport() throws IOException {
        InetSocketAddress address = httpServer.getAddress();
        HttpHost host = new HttpHost("http", address.getHostString(), address.getPort());

        try (OpenSearchTransport transport = new RestClientTransport(RestClient.builder(host).build(), new JacksonJsonpMapper())) {
            assertHeadersSent(transport);
        }
    }

    @Test
    public void testApacheHttpClient5Transport() throws Exception {
        InetSocketAddress address = httpServer.getAddress();
        HttpHost host = new HttpHost("http", address.getHostString(), address.getPort());

        try (OpenSearchTransport transport = ApacheHttpClient5TransportBuilder.builder(host).build()) {
            assertHeadersSent(transport);
        }
    }

    // Scenario: a generic request has two headers and the transport options have another one plus one of the same name (different
    // letter case) as a request header.
    // Expected: the server receives all the distinct headers, and only the value of the options for the shared one.
    private void assertHeadersSent(OpenSearchTransport transport) throws IOException {
        OpenSearchClient client = new OpenSearchClient(transport).withTransportOptions(
            transport.options().with(b -> b.addHeader("X-Option-Header", "option-value").addHeader("x-shared-header", "option-shared"))
        );

        client.generic()
            .execute(
                Requests.builder()
                    .method("POST")
                    .endpoint("/")
                    .headers(
                        Arrays.asList(
                            new AbstractMap.SimpleEntry<>("X-Request-Header", "request-value"),
                            new AbstractMap.SimpleEntry<>("X-Shared-Header", "request-shared")
                        )
                    )
                    .json("{}")
                    .build()
            );

        assertEquals(1, receivedHeaders.size());
        Headers headers = receivedHeaders.get(0);
        assertEquals("request-value", headers.getFirst("X-Request-Header"));
        assertEquals("option-value", headers.getFirst("X-Option-Header"));
        assertEquals(Collections.singletonList("option-shared"), headers.get("X-Shared-Header"));
    }
}
