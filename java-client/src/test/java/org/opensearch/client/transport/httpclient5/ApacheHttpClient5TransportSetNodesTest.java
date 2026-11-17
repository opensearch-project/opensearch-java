/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.apache.hc.core5.http.HttpHost;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.generic.Requests;
import org.opensearch.client.opensearch.generic.Response;
import org.opensearch.client.transport.httpclient5.internal.Node;
import org.opensearch.client.transport.httpclient5.internal.NodeState;

public class ApacheHttpClient5TransportSetNodesTest {
    private static final Node FIRST_NODE = new Node(new HttpHost("first.example.com", 9200));
    private static final Node SECOND_NODE = new Node(new HttpHost("second.example.com", 9200));

    private HttpServer server;
    private ApacheHttpClient5Transport transport;

    @Before
    public void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        server.createContext("/", exchange -> {
            byte[] body = "{}".getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, body.length);
            exchange.getResponseBody().write(body);
            exchange.close();
        });
        server.start();
    }

    @After
    public void stopServer() throws IOException {
        if (transport != null) {
            transport.close();
        }
        server.stop(0);
    }

    // Replacing the nodes updates the same transport instance; the old node is gone.
    @Test
    public void testSetNodesReplacesNodes() {
        transport = transport(FIRST_NODE);

        transport.setNodes(Collections.singletonList(SECOND_NODE));

        Map<Node, NodeState> nodes = transport.getNodes();
        assertEquals(1, nodes.size());
        assertEquals(NodeState.Active, nodes.get(SECOND_NODE));
    }

    // Two nodes with the same host collapse to one; the last one supplied wins.
    @Test
    public void testSetNodesKeepsLastNodeForDuplicateHost() {
        transport = transport(FIRST_NODE);
        Node duplicateOfFirst = new Node(FIRST_NODE.getHost());

        transport.setNodes(Arrays.asList(FIRST_NODE, SECOND_NODE, duplicateOfFirst));

        Map<Node, NodeState> nodes = transport.getNodes();
        assertEquals(2, nodes.size());
        Node retained = nodes.keySet().stream().filter(n -> n.getHost().equals(FIRST_NODE.getHost())).findFirst().get();
        assertSame(duplicateOfFirst, retained);
    }

    // Null, empty, or null-containing input is rejected and the current nodes stay in place.
    @Test
    public void testSetNodesRejectsInvalidInputAndKeepsCurrentNodes() {
        transport = transport(FIRST_NODE);

        assertThrows(IllegalArgumentException.class, () -> transport.setNodes(null));
        assertThrows(IllegalArgumentException.class, () -> transport.setNodes(Collections.emptyList()));
        assertThrows(NullPointerException.class, () -> transport.setNodes(Arrays.asList(SECOND_NODE, null)));

        Map<Node, NodeState> nodes = transport.getNodes();
        assertEquals(1, nodes.size());
        assertEquals(NodeState.Active, nodes.get(FIRST_NODE));
    }

    // A node denylisted by a real failed request is Active again after setNodes, even for the same host.
    @Test
    public void testSetNodesClearsFailureHistory() throws IOException {
        Node unreachable = new Node(new HttpHost("http", "localhost", unusedPort()));
        transport = transport(unreachable);
        OpenSearchClient client = new OpenSearchClient(transport);
        assertThrows(Exception.class, () -> client.generic().execute(Requests.builder().method("GET").endpoint("/").build()));
        assertEquals(NodeState.Unavailable, transport.getNodes().get(unreachable));

        transport.setNodes(Collections.singletonList(unreachable));

        assertEquals(NodeState.Active, transport.getNodes().get(unreachable));
    }

    // After rotating from an unreachable node to a live one, requests succeed without rebuilding the client.
    @Test
    public void testRequestsUseReplacementNodesAfterSetNodes() throws IOException {
        transport = transport(new Node(new HttpHost("http", "localhost", unusedPort())));
        OpenSearchClient client = new OpenSearchClient(transport);

        transport.setNodes(Collections.singletonList(new Node(new HttpHost("http", "localhost", server.getAddress().getPort()))));

        Response response = client.generic().execute(Requests.builder().method("GET").endpoint("/").build());
        assertEquals(200, response.getStatus());
    }

    private static ApacheHttpClient5Transport transport(Node node) {
        return ApacheHttpClient5TransportBuilder.builder(node.getHost()).build();
    }

    private static int unusedPort() throws IOException {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        }
    }
}
