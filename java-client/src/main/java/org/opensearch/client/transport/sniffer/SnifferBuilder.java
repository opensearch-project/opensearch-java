/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.sniffer;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.HttpHost;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Builder for {@link Sniffer} instances.
 */
public class SnifferBuilder {

    public static final long DEFAULT_SNIFF_INTERVAL = TimeUnit.MINUTES.toMillis(5);
    public static final long DEFAULT_SNIFF_AFTER_FAILURE_DELAY = TimeUnit.MINUTES.toMillis(1);

    private final CloseableHttpClient httpClient;
    private final NodeListCallback nodeListCallback;
    private List<HttpHost> hosts;
    private String scheme = "http";
    private long sniffIntervalMillis = DEFAULT_SNIFF_INTERVAL;
    private long sniffAfterFailureDelayMillis = DEFAULT_SNIFF_AFTER_FAILURE_DELAY;
    private ScheduledExecutorService scheduledExecutorService;
    private NodesSniffer nodesSniffer;

    /**
     * Creates a new SnifferBuilder.
     *
     * @param httpClient the HTTP client to use for sniffing
     * @param nodeListCallback callback to be notified when nodes are updated
     */
    public SnifferBuilder(CloseableHttpClient httpClient, NodeListCallback nodeListCallback) {
        this.httpClient = Objects.requireNonNull(httpClient, "httpClient cannot be null");
        this.nodeListCallback = Objects.requireNonNull(nodeListCallback, "nodeListCallback cannot be null");
    }

    /**
     * Sets the hosts that will be used for sniffing.
     *
     * @param hosts the list of hosts
     * @return this builder
     */
    public SnifferBuilder setHosts(List<HttpHost> hosts) {
        this.hosts = Objects.requireNonNull(hosts, "hosts cannot be null");
        return this;
    }

    /**
     * Sets the scheme to use when connecting to discovered nodes.
     *
     * @param scheme the scheme (http or https)
     * @return this builder
     */
    public SnifferBuilder setScheme(String scheme) {
        this.scheme = Objects.requireNonNull(scheme, "scheme cannot be null");
        return this;
    }

    /**
     * Sets the interval between sniff executions.
     *
     * @param sniffIntervalMillis interval in milliseconds
     * @return this builder
     */
    public SnifferBuilder setSniffIntervalMillis(long sniffIntervalMillis) {
        if (sniffIntervalMillis <= 0) {
            throw new IllegalArgumentException("sniffIntervalMillis must be greater than 0");
        }
        this.sniffIntervalMillis = sniffIntervalMillis;
        return this;
    }

    /**
     * Sets the delay between a sniff execution and the next one when the previous one failed.
     *
     * @param sniffAfterFailureDelayMillis delay in milliseconds
     * @return this builder
     */
    public SnifferBuilder setSniffAfterFailureDelayMillis(long sniffAfterFailureDelayMillis) {
        if (sniffAfterFailureDelayMillis <= 0) {
            throw new IllegalArgumentException("sniffAfterFailureDelayMillis must be greater than 0");
        }
        this.sniffAfterFailureDelayMillis = sniffAfterFailureDelayMillis;
        return this;
    }

    /**
     * Sets a custom ScheduledExecutorService to be used for scheduling sniff tasks.
     *
     * @param scheduledExecutorService the executor service
     * @return this builder
     */
    public SnifferBuilder setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = Objects.requireNonNull(scheduledExecutorService, "scheduledExecutorService cannot be null");
        return this;
    }

    /**
     * Sets a custom NodesSniffer implementation.
     *
     * @param nodesSniffer the nodes sniffer
     * @return this builder
     */
    public SnifferBuilder setNodesSniffer(NodesSniffer nodesSniffer) {
        this.nodesSniffer = Objects.requireNonNull(nodesSniffer, "nodesSniffer cannot be null");
        return this;
    }

    /**
     * Builds the Sniffer instance.
     *
     * @return a new Sniffer instance
     */
    public Sniffer build() {
        if (hosts == null || hosts.isEmpty()) {
            throw new IllegalStateException("hosts must be set and non-empty");
        }

        NodesSniffer sniffer = this.nodesSniffer;
        if (sniffer == null) {
            sniffer = new OpenSearchNodesSniffer(httpClient, hosts, scheme);
        }

        ScheduledExecutorService executor = this.scheduledExecutorService;
        if (executor == null) {
            executor = Executors.newScheduledThreadPool(1, r -> {
                Thread thread = new Thread(r, "opensearch-sniffer");
                thread.setDaemon(true);
                return thread;
            });
        }

        return new Sniffer(sniffer, nodeListCallback, sniffIntervalMillis,
                          sniffAfterFailureDelayMillis, executor);
    }
}
