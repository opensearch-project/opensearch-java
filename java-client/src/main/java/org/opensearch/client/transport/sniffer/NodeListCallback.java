/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.sniffer;

import java.util.List;

/**
 * Callback interface used to notify when the list of nodes is updated after sniffing.
 */
@FunctionalInterface
public interface NodeListCallback {

    /**
     * Called when the node list is updated after sniffing.
     *
     * @param nodes the updated list of nodes
     */
    void onNodeListUpdate(List<Node> nodes);
}
