/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Generic HTTP response from OpenSearch
 */
public interface Response extends AutoCloseable {
    /**
     * The optional body of the response. If {@code Optional.empty()} then no body
     * was sent with the response.
     * @return optional body of the response
     */
    Optional<Body> getBody();

    /**
     * The HTTP protocol version
     * @return HTTP protocol version
     */
    String getProtocol();

    /**
     * The HTTP method
     * @return HTTP method
     */
    String getMethod();

    /**
     * The status message
     * @return status message
     */
    String getReason();

    /**
     * The status code
     * @return status code
     */
    int getStatus();

    /**
     * Full URI of the request
     * @return full URI of the request
     */
    String getUri();

    /**
     * List of headers
     * @return list of headers
     */
    Collection<Map.Entry<String, String>> getHeaders();

    /**
     * Releases all resources associated with this body stream.
     */
    void close() throws IOException;
}
