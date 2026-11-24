/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport;

import com.sun.net.httpserver.HttpServer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.hc.core5.http.HttpHost;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.RestClient;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.opensearch.client.transport.rest_client.RestClientTransport;

/**
 * Verifies that the request body sent over the wire matches the serialized request for all transports.
 */
public class RequestBodyTest extends Assert {

    private static final String INDEX_RESPONSE = "{\"_index\":\"test\",\"_id\":\"1\",\"_version\":1,\"result\":\"created\","
        + "\"_shards\":{\"total\":1,\"successful\":1,\"failed\":0},\"_seq_no\":0,\"_primary_term\":1}";
    private static final String BULK_RESPONSE = "{\"took\":1,\"errors\":false,\"items\":[]}";

    // Long enough to make the serialization buffer grow beyond its initial capacity
    private static final String LONG_VALUE = String.join("", Collections.nCopies(1000, "x"));

    private HttpServer httpServer;
    private final List<String> receivedBodies = Collections.synchronizedList(new ArrayList<>());

    @Before
    public void setup() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        httpServer.createContext("/", ex -> {
            InputStream in = ex.getRequestBody();
            if ("gzip".equals(ex.getRequestHeaders().getFirst("Content-Encoding"))) {
                in = new GZIPInputStream(in);
            }
            receivedBodies.add(new String(readAll(in), StandardCharsets.UTF_8));

            byte[] response = (ex.getRequestURI().getPath().endsWith("/_bulk") ? BULK_RESPONSE : INDEX_RESPONSE).getBytes(
                StandardCharsets.UTF_8
            );
            ex.getResponseHeaders().add("Content-Type", "application/json");
            ex.sendResponseHeaders(200, response.length);
            try (OutputStream out = ex.getResponseBody()) {
                out.write(response);
            }
        });
        httpServer.start();
    }

    @After
    public void tearDown() {
        httpServer.stop(0);
    }

    @Test
    public void testRestClientTransport() throws IOException {
        try (RestClient restClient = RestClient.builder(host()).build()) {
            assertBodies(new RestClientTransport(restClient, new JacksonJsonpMapper()));
        }
    }

    @Test
    public void testRestClientTransportWithCompression() throws IOException {
        try (RestClient restClient = RestClient.builder(host()).setCompressionEnabled(true).build()) {
            assertBodies(new RestClientTransport(restClient, new JacksonJsonpMapper()));
        }
    }

    @Test
    public void testApacheHttpClient5Transport() throws IOException {
        try (OpenSearchTransport transport = ApacheHttpClient5TransportBuilder.builder(host()).build()) {
            assertBodies(transport);
        }
    }

    @Test
    public void testApacheHttpClient5TransportWithCompression() throws IOException {
        try (OpenSearchTransport transport = ApacheHttpClient5TransportBuilder.builder(host()).setCompressionEnabled(true).build()) {
            assertBodies(transport);
        }
    }

    @Test
    public void testApacheHttpClient5TransportWithChunking() throws IOException {
        try (OpenSearchTransport transport = ApacheHttpClient5TransportBuilder.builder(host()).setChunkedEnabled(true).build()) {
            assertBodies(transport);
        }
    }

    private void assertBodies(OpenSearchTransport transport) throws IOException {
        OpenSearchClient client = new OpenSearchClient(transport);
        Map<String, String> doc = Collections.singletonMap("field", LONG_VALUE);

        client.index(i -> i.index("test").id("1").document(doc));
        client.bulk(
            b -> b.index("test")
                .operations(o -> o.index(i -> i.id("1").document(doc)))
                .operations(o -> o.delete(d -> d.id("2")))
                .operations(o -> o.create(c -> c.id("3").document(doc)))
        );

        String docJson = "{\"field\":\"" + LONG_VALUE + "\"}";
        assertEquals(2, receivedBodies.size());
        assertEquals(docJson, receivedBodies.get(0));
        assertEquals(
            "{\"index\":{\"_id\":\"1\"}}\n"
                + docJson
                + "\n"
                + "{\"delete\":{\"_id\":\"2\"}}\n"
                + "{\"create\":{\"_id\":\"3\"}}\n"
                + docJson
                + "\n",
            receivedBodies.get(1)
        );
    }

    private HttpHost host() {
        InetSocketAddress address = httpServer.getAddress();
        return new HttpHost("http", address.getHostString(), address.getPort());
    }

    private static byte[] readAll(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        return out.toByteArray();
    }
}
