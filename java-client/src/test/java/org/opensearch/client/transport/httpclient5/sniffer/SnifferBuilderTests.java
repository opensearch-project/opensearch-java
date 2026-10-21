/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.opensearch.client.transport.httpclient5.internal.Node;

public class SnifferBuilderTests {

    @Test
    public void build_requiresNonNullTransport() {
        assertThrows(NullPointerException.class, () -> new SnifferBuilder((ApacheHttpClient5Transport) null));
    }

    @Test
    public void transportBuilder_infersHttpsSchemeFromTransport() {
        ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("https", "seed", 9200)).build();
        // No setScheme call: the builder must pick up "https" from the transport's seed node instead
        // of defaulting to "http" (which would break every request after the first publish).
        assertThat(new SnifferBuilder(transport).resolvedScheme(), is("https"));
    }

    @Test
    public void transportBuilder_setSchemeOverridesInference() {
        ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(new HttpHost("https", "seed", 9200)).build();
        assertThat(new SnifferBuilder(transport).setScheme("http").resolvedScheme(), is("http"));
    }

    @Test
    public void consumerBuilder_defaultsToHttpScheme() {
        assertThat(new SnifferBuilder(nodes -> {}).resolvedScheme(), is(OpenSearchNodesSniffer.DEFAULT_SCHEME));
    }

    @Test
    public void build_rejectsNonPositiveInterval() {
        SnifferBuilder b = new SnifferBuilder(nodes -> {}).setNodesSniffer(Collections::emptyList);
        assertThrows(IllegalArgumentException.class, () -> b.setSniffIntervalMillis(0));
    }

    @Test
    public void transportBuilder_prefersHttpsForMixedSchemeNodes() {
        // Transport seeded with both http and https nodes: schemeOf must prefer https (safer default)
        // rather than returning whichever scheme the first node in iteration order happens to have.
        ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(
            new Node(new HttpHost("http", "node-a", 9200)),
            new Node(new HttpHost("https", "node-b", 9200))
        ).build();
        assertThat(new SnifferBuilder(transport).resolvedScheme(), is("https"));
    }

    @Test
    public void transportBuilder_prefersHttpsForMixedSchemeNodesHttpsFirst() {
        // Same mixed-scheme case, but with https node listed first — result must still be "https"
        // (not dependent on insertion order).
        ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(
            new Node(new HttpHost("https", "node-a", 9200)),
            new Node(new HttpHost("http", "node-b", 9200))
        ).build();
        assertThat(new SnifferBuilder(transport).resolvedScheme(), is("https"));
    }

    @Test
    public void transportBuilder_uniformHttpSchemeReturnsHttp() {
        // All-http transport must still resolve to "http" (no regression for the common case).
        ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(
            new Node(new HttpHost("http", "node-a", 9200)),
            new Node(new HttpHost("http", "node-b", 9200))
        ).build();
        assertThat(new SnifferBuilder(transport).resolvedScheme(), is("http"));
    }

    @Test
    public void build_startsAndPublishesThroughConsumer() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        Node discovered = new Node(new HttpHost("http", "10.0.0.5", 9200));

        Sniffer sniffer = new SnifferBuilder(nodes -> latch.countDown()).setNodesSniffer(() -> Collections.singletonList(discovered))
            .setSniffIntervalMillis(TimeUnit.MINUTES.toMillis(5))
            .build();

        try (Sniffer s = sniffer) {
            s.start();
            assertThat(latch.await(5, TimeUnit.SECONDS), is(true));
        }
    }

    @Test
    public void setSniffRequestTimeoutMillis_rejectsNonPositive() {
        for (long bad : new long[] { 0L, -1L }) {
            try {
                new SnifferBuilder(nodes -> {}).setSniffRequestTimeoutMillis(bad);
                org.junit.Assert.fail("expected IllegalArgumentException for " + bad);
            } catch (IllegalArgumentException expected) {
                // expected
            }
        }
    }

    @Test
    public void setSniffRequestSocketTimeoutMillis_rejectsNonPositive() {
        for (long bad : new long[] { 0L, -1L }) {
            try {
                new SnifferBuilder(nodes -> {}).setSniffRequestSocketTimeoutMillis(bad);
                org.junit.Assert.fail("expected IllegalArgumentException for " + bad);
            } catch (IllegalArgumentException expected) {
                // expected
            }
        }
    }
}
