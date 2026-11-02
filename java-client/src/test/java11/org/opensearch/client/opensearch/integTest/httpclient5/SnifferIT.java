/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.httpclient5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.opensearch.integTest.OpenSearchJavaClientTestCase;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.internal.Node;
import org.opensearch.client.transport.httpclient5.sniffer.OpenSearchNodesSniffer;
import org.opensearch.client.transport.httpclient5.sniffer.Sniffer;
import org.opensearch.client.transport.httpclient5.sniffer.SnifferBuilder;

public class SnifferIT extends OpenSearchJavaClientTestCase implements HttpClient5TransportSupport {

    /**
     * Verifies the end-to-end discovery path: {@code _nodes/http} fetched through the client's own
     * authenticated transport and parsed into {@link Node}s. Read-only — does not mutate the shared
     * client's node list.
     */
    @Test
    public void sniff_discoversRunningNodesThroughAuthenticatedTransport() throws Exception {
        ApacheHttpClient5Transport transport = (ApacheHttpClient5Transport) javaClient()._transport();

        List<Node> discovered = new OpenSearchNodesSniffer(transport, getProtocol()).sniff();

        assertThat(discovered.size(), greaterThanOrEqualTo(1));
        assertThat(discovered.get(0).getHost(), notNullValue());
    }

    /**
     * Verifies the full wiring: a scheduled {@link Sniffer} publishes discovered nodes into the
     * transport via {@code setNodes}. Uses a dedicated throwaway transport so the JVM-shared client
     * is not repointed at possibly-unreachable published addresses. A latch on the publish consumer
     * proves a real sniff cycle completed with a non-empty node set (rather than asserting on a
     * transport that already carries the seed node and is therefore never "empty").
     */
    @Test
    public void snifferBuilder_publishesDiscoveredNodesIntoTransport() throws Exception {
        OpenSearchTransport transport = buildTransport(restClientSettings(), clusterHttpHosts());
        try {
            ApacheHttpClient5Transport apache = (ApacheHttpClient5Transport) transport;
            CountDownLatch published = new CountDownLatch(1);
            AtomicReference<List<Node>> captured = new AtomicReference<>();

            try (Sniffer sniffer = new SnifferBuilder(nodes -> {
                captured.set(nodes);
                apache.setNodes(nodes);
                published.countDown();
            }).setNodesSniffer(new OpenSearchNodesSniffer(transport, getProtocol()))
                .setSniffIntervalMillis(TimeUnit.MINUTES.toMillis(5))
                .build()) {
                sniffer.start();
                assertThat(published.await(15, TimeUnit.SECONDS), is(true)); // a sniff cycle published nodes
            }

            assertThat(captured.get(), not(empty()));               // discovery returned real nodes
            assertThat(apache.getNodes().size(), greaterThanOrEqualTo(1)); // and they were pushed into the transport
        } finally {
            transport.close();
        }
    }

    private HttpHost[] clusterHttpHosts() {
        String[] urls = getTestRestCluster().split(",");
        HttpHost[] hosts = new HttpHost[urls.length];
        for (int i = 0; i < urls.length; i++) {
            int sep = urls[i].lastIndexOf(':');
            hosts[i] = new HttpHost(getProtocol(), urls[i].substring(0, sep), Integer.parseInt(urls[i].substring(sep + 1)));
        }
        return hosts;
    }
}
