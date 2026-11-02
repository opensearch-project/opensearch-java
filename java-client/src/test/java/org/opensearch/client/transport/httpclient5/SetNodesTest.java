/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.transport.httpclient5.internal.Node;
import org.opensearch.client.transport.httpclient5.internal.NodeState;

public class SetNodesTest {

    @Test
    public void setNodes_replacesTheNodeList() {
        ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("http", "localhost", 9200)).build();

        List<Node> replacement = Arrays.asList(
            new Node(new HttpHost("http", "10.0.0.1", 9200)),
            new Node(new HttpHost("http", "10.0.0.2", 9200))
        );

        transport.setNodes(replacement);

        List<HttpHost> hosts = transport.getNodes().keySet().stream().map(Node::getHost).collect(Collectors.toList());
        assertThat(hosts, hasSize(2));
        assertThat(hosts, containsInAnyOrder(new HttpHost("http", "10.0.0.1", 9200), new HttpHost("http", "10.0.0.2", 9200)));
    }

    /**
     * setNodes() must publish the new node set and clear the per-host denylist as a single
     * conceptual update: once the call returns, no node from the new set may be left in a stale
     * "Unavailable" state carried over from a previous generation. This is a sequential
     * (post-setNodes) check of that invariant; it cannot observe the transient interleaving a
     * concurrent reader might see mid-call (see the comment in ApacheHttpClient5Transport#setNodes
     * for why that transient window is safe), but it does guard against a regression where the
     * denylist is no longer cleared at all, or is cleared against the wrong node set.
     */
    @Test
    public void setNodes_republishingClearsDenylistForNewNodeSet() {
        ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("http", "localhost", 9200)).build();

        List<Node> firstGeneration = Arrays.asList(
            new Node(new HttpHost("http", "10.0.0.1", 9200)),
            new Node(new HttpHost("http", "10.0.0.2", 9200))
        );
        transport.setNodes(firstGeneration);

        // Republish a second generation, including a host reused from the first generation.
        List<Node> secondGeneration = Arrays.asList(
            new Node(new HttpHost("http", "10.0.0.2", 9200)),
            new Node(new HttpHost("http", "10.0.0.3", 9200))
        );
        transport.setNodes(secondGeneration);

        assertThat(transport.getNodes().values(), everyItem(is(NodeState.Active)));
        List<HttpHost> hosts = transport.getNodes().keySet().stream().map(Node::getHost).collect(Collectors.toList());
        assertThat(hosts, hasSize(2));
        assertThat(hosts, containsInAnyOrder(new HttpHost("http", "10.0.0.2", 9200), new HttpHost("http", "10.0.0.3", 9200)));
    }
}
