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
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.message.BasicHeader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch.core.BulkStreamingRequest;
import org.opensearch.client.opensearch.core.BulkStreamingResponse;
import org.opensearch.client.opensearch.generic.Requests;
import reactor.core.publisher.Flux;

/**
 * Verifies that the headers of a generic client request reach the server, in addition to the headers of the transport options.
 */
public abstract class AbstractRequestHeadersTest extends Assert {

    private HttpServer httpServer;
    private final List<Headers> receivedHeaders = Collections.synchronizedList(new ArrayList<>());

    @Before
    public void setup() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        httpServer.createContext("/_bulk/stream", ex -> {
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
    public void testTransportOptionsHeaders() throws Exception {
        InetSocketAddress address = httpServer.getAddress();
        HttpHost host = new HttpHost("http", address.getHostString(), address.getPort());

        try (OpenSearchTransport transport = createTransport(host, new Header[0])) {
            assertHeadersSent(transport);
        }
    }

    @Test
    public void testTransportOptionsHeadersStreaming() throws Exception {
        InetSocketAddress address = httpServer.getAddress();
        HttpHost host = new HttpHost("http", address.getHostString(), address.getPort());

        try (OpenSearchStreamingTransport transport = createTransport(host, new Header[0])) {
            assertStreamingHeadersSent(transport);
        }
    }

    @Test
    public void testDefaultHeaders() throws Exception {
        InetSocketAddress address = httpServer.getAddress();
        HttpHost host = new HttpHost("http", address.getHostString(), address.getPort());

        try (
            OpenSearchTransport transport = createTransport(
                host,
                new Header[] {
                    new BasicHeader("X-Default-Header", "transport-default"),
                    new BasicHeader("X-Default-Shared-Header", "transport-default") }
            )
        ) {
            assertDefaultHeadersSent(transport);
        }
    }

    @Test
    public void testDefaultHeadersStreaming() throws Exception {
        InetSocketAddress address = httpServer.getAddress();
        HttpHost host = new HttpHost("http", address.getHostString(), address.getPort());

        try (
            OpenSearchStreamingTransport transport = createTransport(
                host,
                new Header[] {
                    new BasicHeader("X-Default-Header", "transport-default"),
                    new BasicHeader("X-Default-Shared-Header", "transport-default") }
            )
        ) {
            assertStreamingDefaultHeadersSent(transport);
        }
    }

    protected abstract OpenSearchStreamingTransport createTransport(HttpHost host, Header[] defaultHeaders);

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
                    .endpoint("/_bulk/stream")
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

    // Scenario: a generic request has two headers and the transport options have another one plus one of the same name (different
    // letter case) as a request header, plus transport has default headers.
    // Expected: the server receives all the distinct headers, and only the value of the options for the shared one.
    private void assertDefaultHeadersSent(OpenSearchTransport transport) throws IOException {
        OpenSearchClient client = new OpenSearchClient(transport).withTransportOptions(
            transport.options().with(b -> b.addHeader("X-Option-Header", "option-value"))
        );

        client.generic()
            .execute(
                Requests.builder()
                    .method("POST")
                    .endpoint("/_bulk/stream")
                    .headers(
                        Arrays.asList(
                            new AbstractMap.SimpleEntry<>("X-Request-Header", "request-value"),
                            new AbstractMap.SimpleEntry<>("X-Default-Shared-Header", "request-default")
                        )
                    )
                    .json("{}")
                    .build()
            );

        assertEquals(1, receivedHeaders.size());
        Headers headers = receivedHeaders.get(0);
        assertEquals("request-value", headers.getFirst("X-Request-Header"));
        assertEquals("option-value", headers.getFirst("X-Option-Header"));
        assertEquals(Collections.singletonList("request-default"), headers.get("X-Default-Shared-Header"));
        assertEquals(Collections.singletonList("transport-default"), headers.get("X-Default-Header"));
    }

    // Scenario: a streaming request has two headers and the transport options have another one plus one of the same name (different
    // letter case) as a request header.
    // Expected: the server receives all the distinct headers, and only the value of the options for the shared one.
    private void assertStreamingHeadersSent(OpenSearchStreamingTransport transport) throws IOException {
        transport.stream(
            BulkStreamingRequest.of(b -> b.operations(Flux.just())),
            (StreamingEndpoint<BulkStreamingRequest, BulkStreamingResponse, ErrorResponse>) BulkStreamingRequest._ENDPOINT,
            transport.options().with(b -> b.addHeader("X-Option-Header", "option-value").addHeader("x-shared-header", "option-shared"))
        );

        assertEquals(1, receivedHeaders.size());
        Headers headers = receivedHeaders.get(0);
        assertEquals("option-value", headers.getFirst("X-Option-Header"));
        assertEquals(Collections.singletonList("option-shared"), headers.get("X-Shared-Header"));
    }

    // Scenario: a generic request has two headers and the transport options have another one plus one of the same name (different
    // letter case) as a request header, plus transport has default headers.
    // Expected: the server receives all the distinct headers, and only the value of the options for the shared one.
    private void assertStreamingDefaultHeadersSent(OpenSearchStreamingTransport transport) throws IOException {
        transport.stream(
            BulkStreamingRequest.of(b -> b.operations(Flux.just())),
            (StreamingEndpoint<BulkStreamingRequest, BulkStreamingResponse, ErrorResponse>) BulkStreamingRequest._ENDPOINT,
            transport.options()
                .with(b -> b.addHeader("X-Option-Header", "option-value").addHeader("X-Default-Shared-Header", "option-default"))
        );

        assertEquals(1, receivedHeaders.size());
        Headers headers = receivedHeaders.get(0);
        assertEquals("option-value", headers.getFirst("X-Option-Header"));
        assertEquals(Collections.singletonList("option-default"), headers.get("X-Default-Shared-Header"));
        assertEquals(Collections.singletonList("transport-default"), headers.get("X-Default-Header"));
    }
}
