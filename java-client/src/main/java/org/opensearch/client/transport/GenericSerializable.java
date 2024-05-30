/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport;

import java.io.OutputStream;

/**
 * The request that takes care of serializing its body (content) into the {@link OutputStream}
 */
public interface GenericSerializable {
    /**
     * Serializes into the {@link OutputStream} and returns the content type
     * @param out {@link OutputStream} to serialize into
     * @return content type
     */
    String serialize(OutputStream out);
}
