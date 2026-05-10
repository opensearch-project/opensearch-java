/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.sniffer;

import java.io.IOException;
import java.util.List;

/**
 * Interface for sniffing OpenSearch cluster nodes.
 * Implementations are responsible for discovering available nodes in the cluster.
 */
public interface NodesSniffer {

    /**
     * Sniffs the cluster nodes and returns the list of discovered nodes.
     *
     * @return list of discovered nodes
     * @throws IOException if sniffing fails
     */
    List<Node> sniff() throws IOException;
}
