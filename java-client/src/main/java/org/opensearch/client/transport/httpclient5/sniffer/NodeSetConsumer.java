/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.sniffer;

import java.util.List;
import org.opensearch.client.transport.httpclient5.internal.Node;

/**
 * Receives the set of nodes discovered by a {@link Sniffer}. Typically {@code transport::setNodes}.
 */
@FunctionalInterface
public interface NodeSetConsumer {
    void accept(List<Node> nodes);
}
