/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.sniffer;

import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.internal.Node;
import org.apache.hc.core5.http.HttpHost;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Example of how a sniffer-aware transport could work.
 * Note: This is a conceptual implementation showing how the sniffer could integrate
 * with the transport layer. A full implementation would require modifications to
 * the ApacheHttpClient5Transport class to support dynamic node updates.
 */
public class SnifferAwareTransport implements NodeListCallback {

    private final ApacheHttpClient5Transport transport;
    private final CopyOnWriteArrayList<Node> nodes;
    private final Sniffer sniffer;

    /**
     * Creates a sniffer-aware transport wrapper.
     *
     * @param transport the underlying transport implementation
     * @param sniffer the sniffer instance for node discovery
     */
    public SnifferAwareTransport(ApacheHttpClient5Transport transport, Sniffer sniffer) {
        this.transport = transport;
        this.nodes = new CopyOnWriteArrayList<>();
        this.sniffer = sniffer;
    }

    @Override
    public void onNodeListUpdate(List<org.opensearch.client.transport.sniffer.Node> sniffedNodes) {
        // Convert sniffer nodes to transport nodes
        List<Node> transportNodes = sniffedNodes.stream()
            .map(this::convertToTransportNode)
            .collect(Collectors.toList());

        // Update the node list atomically
        synchronized (this) {
            nodes.clear();
            nodes.addAll(transportNodes);
        }

        System.out.println("Updated transport with " + transportNodes.size() + " nodes");

        // Note: In a full implementation, you would need to:
        // 1. Extend ApacheHttpClient5Transport to support dynamic node updates
        // 2. Implement a method to update the transport's internal node list
        // 3. Handle connection pool updates for the new nodes
    }

    private Node convertToTransportNode(org.opensearch.client.transport.sniffer.Node snifferNode) {
        HttpHost host = snifferNode.getHost();
        return new Node(host);
    }

    /**
     * Start the sniffer to begin automatic node discovery.
     */
    public void startSniffer() {
        sniffer.start();
    }

    /**
     * Manually trigger node sniffing on failure.
     */
    public void sniffOnFailure() {
        sniffer.sniffOnFailure();
    }

    /**
     * Get the underlying transport instance.
     */
    public ApacheHttpClient5Transport getTransport() {
        return transport;
    }

    /**
     * Get the current list of discovered nodes.
     */
    public List<Node> getCurrentNodes() {
        return new CopyOnWriteArrayList<>(nodes);
    }

    /**
     * Close both the sniffer and the underlying transport.
     */
    public void close() throws IOException {
        try {
            sniffer.close();
        } finally {
            transport.close();
        }
    }
}
