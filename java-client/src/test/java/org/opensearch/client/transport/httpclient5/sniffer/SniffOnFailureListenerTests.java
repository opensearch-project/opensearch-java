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

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import org.opensearch.client.transport.httpclient5.internal.Node;

public class SniffOnFailureListenerTests {

    @Test
    public void onFailure_withoutSniffer_isNoOp() {
        SniffOnFailureListener listener = new SniffOnFailureListener();
        // Before setSniffer() (construction window) a failure must degrade gracefully, not throw.
        listener.onFailure(new Node(new HttpHost("http", "localhost", 9200)));
    }

    @Test
    public void onFailure_triggersImmediateSniff() throws Exception {
        // Count sniffs at the NodesSniffer (not the consumer): a failure-triggered sniff that
        // rediscovers the same membership legitimately does not republish (see Sniffer's
        // publish-on-change behaviour), so the consumer is the wrong thing to count. Distinguish the
        // initial startup sniff from the failure-triggered one to prove the latter fires.
        CountDownLatch firstSniff = new CountDownLatch(1);
        CountDownLatch failureSniff = new CountDownLatch(1);
        AtomicInteger sniffCount = new AtomicInteger();
        Node discovered = new Node(new HttpHost("http", "10.0.0.7", 9200));

        // long interval so the second sniff can only come from the failure trigger
        Sniffer sniffer = new SnifferBuilder(nodes -> {}).setNodesSniffer(() -> {
            if (sniffCount.incrementAndGet() == 1) {
                firstSniff.countDown();
            } else {
                failureSniff.countDown();
            }
            return Collections.singletonList(discovered);
        }).setSniffIntervalMillis(TimeUnit.HOURS.toMillis(1)).setSniffAfterFailureDelayMillis(50L).build();

        SniffOnFailureListener listener = new SniffOnFailureListener();
        listener.setSniffer(sniffer);

        try (Sniffer s = sniffer) {
            s.start();
            // wait for the initial sniff to complete FIRST, otherwise onFailure would just coalesce with it
            assertThat(firstSniff.await(5, TimeUnit.SECONDS), is(true));
            listener.onFailure(discovered);
            assertThat(failureSniff.await(5, TimeUnit.SECONDS), is(true)); // failure-triggered sniff fired
        }
    }
}
