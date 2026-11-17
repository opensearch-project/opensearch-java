/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.internal.Node;

/**
 * A {@link ApacheHttpClient5Transport.FailureListener} that asks a {@link Sniffer} to re-discover
 * nodes as soon as a request fails. Set on the transport via
 * {@code ApacheHttpClient5TransportBuilder.setFailureListener(...)}, then hand the same instance its
 * {@link Sniffer} through {@link #setSniffer(Sniffer)} once the sniffer is built.
 */
public class SniffOnFailureListener extends ApacheHttpClient5Transport.FailureListener {

    private volatile Sniffer sniffer;

    public SniffOnFailureListener() {}

    /** Associates the sniffer to trigger on failure. Must be called before failures occur. */
    public void setSniffer(Sniffer sniffer) {
        this.sniffer = sniffer;
    }

    @Override
    public void onFailure(Node node) {
        Sniffer current = this.sniffer;
        if (current != null) {
            current.sniffOnFailure();
        }
        // else: sniffer not yet wired (construction window) — degrade gracefully rather than
        // throwing into the transport's failure-handling path.
    }
}
