/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Generic HTTP request to OpenSearch
 */
public interface Request {

    /**
     * The HTTP method.
     */
    String getMethod();

    /**
     * The path of the request (without scheme, host, port, or prefix).
     * @return path of the request
     */
    String getEndpoint();

    /**
     * Query string parameters. The returned map is an unmodifiable view of the
     * map in the request.
     * @return query string parameters
     */
    Map<String, String> getParameters();

    /**
     * List of headers
     * @return list of headers
     */
    Collection<Map.Entry<String, String>> getHeaders();

    /**
     * The optional body of the request. If {@code Optional.empty()} then no body
     * is sent with the request.
     * @return optional body of the request
     */
    Optional<Body> getBody();

}
