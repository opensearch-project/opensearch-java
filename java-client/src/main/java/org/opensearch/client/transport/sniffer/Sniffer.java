/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.sniffer;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class responsible for sniffing nodes from an OpenSearch cluster and notifying a {@link NodeListCallback}
 * when the sniffed nodes set is updated.
 */
public class Sniffer implements Closeable {

    private final NodesSniffer nodesSniffer;
    private final NodeListCallback nodeListCallback;
    private final long sniffIntervalMillis;
    private final long sniffAfterFailureDelayMillis;
    private final ScheduledExecutorService scheduledExecutorService;
    private final AtomicBoolean running = new AtomicBoolean(false);

    private volatile ScheduledFuture<?> scheduledSniff;

    Sniffer(NodesSniffer nodesSniffer, NodeListCallback nodeListCallback,
            long sniffIntervalMillis, long sniffAfterFailureDelayMillis,
            ScheduledExecutorService scheduledExecutorService) {
        this.nodesSniffer = nodesSniffer;
        this.nodeListCallback = nodeListCallback;
        this.sniffIntervalMillis = sniffIntervalMillis;
        this.sniffAfterFailureDelayMillis = sniffAfterFailureDelayMillis;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    /**
     * Start the sniffer. The sniffer will run according to the configured interval.
     */
    public void start() {
        if (running.compareAndSet(false, true)) {
            scheduleNextSniff(0);
        }
    }

    /**
     * Triggers sniffing of cluster nodes. Can be called manually to force node discovery.
     */
    public void sniffOnFailure() {
        if (running.get()) {
            if (scheduledSniff != null) {
                scheduledSniff.cancel(false);
            }
            scheduleNextSniff(sniffAfterFailureDelayMillis);
        }
    }

    private void scheduleNextSniff(long delayMillis) {
        if (running.get()) {
            scheduledSniff = scheduledExecutorService.schedule(this::performSniffing, delayMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void performSniffing() {
        try {
            List<Node> sniffedNodes = nodesSniffer.sniff();
            nodeListCallback.onNodeListUpdate(sniffedNodes);
            scheduleNextSniff(sniffIntervalMillis);
        } catch (Exception e) {
            // Log the exception and schedule retry
            scheduleNextSniff(sniffAfterFailureDelayMillis);
        }
    }

    @Override
    public void close() throws IOException {
        if (running.compareAndSet(true, false)) {
            if (scheduledSniff != null) {
                scheduledSniff.cancel(false);
            }
            scheduledExecutorService.shutdown();
        }
    }
}
