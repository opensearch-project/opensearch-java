/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import java.io.IOException;
import java.util.List;
import org.opensearch.client.transport.httpclient5.internal.Node;

/**
 * Discovers the nodes of an OpenSearch cluster. Implementations return the nodes that the client
 * should use for subsequent requests.
 */
public interface NodesSniffer {

    /**
     * Discovers and returns the current set of cluster nodes.
     *
     * @return the discovered nodes; never {@code null}
     * @throws IOException if discovery fails
     */
    List<Node> sniff() throws IOException;
}
