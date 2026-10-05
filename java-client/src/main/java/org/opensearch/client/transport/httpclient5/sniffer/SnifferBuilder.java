/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.internal.Node;
import org.opensearch.client.transport.httpclient5.internal.NodeState;

/**
 * Builds a {@link Sniffer}. Two entry points:
 * <ul>
 *   <li>{@link #SnifferBuilder(ApacheHttpClient5Transport)} — discovers via the transport and
 *       publishes into it (the common case).</li>
 *   <li>{@link #SnifferBuilder(NodeSetConsumer)} — publishes discovered nodes to an arbitrary sink
 *       (used with {@link #setNodesSniffer(NodesSniffer)}).</li>
 * </ul>
 */
public class SnifferBuilder {

    public static final long DEFAULT_SNIFF_INTERVAL_MILLIS = TimeUnit.MINUTES.toMillis(5);
    public static final long DEFAULT_SNIFF_AFTER_FAILURE_DELAY_MILLIS = TimeUnit.MINUTES.toMillis(1);

    private static final Log logger = LogFactory.getLog(SnifferBuilder.class);

    private final NodeSetConsumer consumer;
    private final ApacheHttpClient5Transport transport; // nullable when consumer-based
    private NodesSniffer nodesSniffer;
    private String scheme;
    private long sniffIntervalMillis = DEFAULT_SNIFF_INTERVAL_MILLIS;
    private long sniffAfterFailureDelayMillis = DEFAULT_SNIFF_AFTER_FAILURE_DELAY_MILLIS;
    private long sniffRequestTimeoutMillis = OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_TIMEOUT_MILLIS;
    private long sniffRequestSocketTimeoutMillis = OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_SOCKET_TIMEOUT_MILLIS;

    /** Sniff via {@code transport} and publish discovered nodes back into it. */
    public SnifferBuilder(ApacheHttpClient5Transport transport) {
        this.transport = Objects.requireNonNull(transport, "transport cannot be null");
        this.consumer = transport::setNodes;
        // Default the scheme to the transport's own so an HTTPS client doesn't silently stamp
        // discovered nodes as plaintext http. setScheme(...) still overrides this.
        this.scheme = schemeOf(transport);
    }

    /** Publish discovered nodes to an arbitrary {@code consumer}. Requires {@link #setNodesSniffer}. */
    public SnifferBuilder(NodeSetConsumer consumer) {
        this.consumer = Objects.requireNonNull(consumer, "consumer cannot be null");
        this.transport = null;
        this.scheme = OpenSearchNodesSniffer.DEFAULT_SCHEME;
    }

    /**
     * Infers the scheme from the transport's current nodes. The transport is always seeded with at
     * least one node at construction, so this reflects how the client actually talks to the cluster.
     * Falls back to the default scheme if, unexpectedly, no node is present.
     * <p>
     * When all nodes agree on a single scheme, that scheme is returned. When nodes have mixed
     * schemes (e.g., some {@code http}, some {@code https}), {@code https} is preferred over
     * {@code http} so that discovered nodes are not accidentally stamped with a less-secure scheme,
     * and a warning is logged so the ambiguity is visible to operators.
     */
    private static String schemeOf(ApacheHttpClient5Transport transport) {
        Set<String> schemes = new HashSet<>();
        for (Map.Entry<Node, NodeState> entry : transport.getNodes().entrySet()) {
            String schemeName = entry.getKey().getHost().getSchemeName();
            if (schemeName != null) {
                schemes.add(schemeName);
            }
        }
        if (schemes.isEmpty()) {
            return OpenSearchNodesSniffer.DEFAULT_SCHEME;
        }
        if (schemes.size() == 1) {
            return schemes.iterator().next();
        }
        // Mixed schemes: prefer https over http to avoid accidentally downgrading connections.
        logger.warn(
            "Transport nodes have mixed schemes "
                + schemes
                + "; defaulting sniffer scheme to \"https\". "
                + "Use SnifferBuilder.setScheme(...) to override."
        );
        return "https";
    }

    public SnifferBuilder setNodesSniffer(NodesSniffer nodesSniffer) {
        this.nodesSniffer = Objects.requireNonNull(nodesSniffer, "nodesSniffer cannot be null");
        return this;
    }

    public SnifferBuilder setScheme(String scheme) {
        this.scheme = Objects.requireNonNull(scheme, "scheme cannot be null");
        return this;
    }

    public SnifferBuilder setSniffIntervalMillis(long sniffIntervalMillis) {
        if (sniffIntervalMillis <= 0) {
            throw new IllegalArgumentException("sniffIntervalMillis must be greater than 0");
        }
        this.sniffIntervalMillis = sniffIntervalMillis;
        return this;
    }

    public SnifferBuilder setSniffAfterFailureDelayMillis(long sniffAfterFailureDelayMillis) {
        if (sniffAfterFailureDelayMillis <= 0) {
            throw new IllegalArgumentException("sniffAfterFailureDelayMillis must be greater than 0");
        }
        this.sniffAfterFailureDelayMillis = sniffAfterFailureDelayMillis;
        return this;
    }

    /**
     * Sets the server-side {@code timeout} query parameter sent with the {@code /_nodes/http}
     * request (e.g. a value of {@code 1000} produces {@code ?timeout=1000ms}). Defaults to
     * {@link OpenSearchNodesSniffer#DEFAULT_SNIFF_REQUEST_TIMEOUT_MILLIS} (1 s).
     */
    public SnifferBuilder setSniffRequestTimeoutMillis(long sniffRequestTimeoutMillis) {
        if (sniffRequestTimeoutMillis <= 0) {
            throw new IllegalArgumentException("sniffRequestTimeoutMillis must be > 0, got " + sniffRequestTimeoutMillis);
        }
        this.sniffRequestTimeoutMillis = sniffRequestTimeoutMillis;
        return this;
    }

    /**
     * Sets the client-side connect/response timeout for the nodes-info request — a safety-net
     * against a wedged connection that never returns. Defaults to
     * {@link OpenSearchNodesSniffer#DEFAULT_SNIFF_REQUEST_SOCKET_TIMEOUT_MILLIS} (10 s).
     */
    public SnifferBuilder setSniffRequestSocketTimeoutMillis(long sniffRequestSocketTimeoutMillis) {
        if (sniffRequestSocketTimeoutMillis <= 0) {
            throw new IllegalArgumentException("sniffRequestSocketTimeoutMillis must be > 0, got " + sniffRequestSocketTimeoutMillis);
        }
        this.sniffRequestSocketTimeoutMillis = sniffRequestSocketTimeoutMillis;
        return this;
    }

    public Sniffer build() {
        NodesSniffer effectiveSniffer = this.nodesSniffer;
        if (effectiveSniffer == null) {
            if (transport == null) {
                throw new IllegalStateException("a NodesSniffer must be set when using the consumer-based builder");
            }
            effectiveSniffer = new OpenSearchNodesSniffer(transport, scheme, sniffRequestTimeoutMillis, sniffRequestSocketTimeoutMillis);
        }
        return new Sniffer(effectiveSniffer, consumer, sniffIntervalMillis, sniffAfterFailureDelayMillis);
    }

    /** The scheme discovered nodes will be stamped with (inferred from the transport unless overridden). Package-visible for testing. */
    String resolvedScheme() {
        return scheme;
    }
}
