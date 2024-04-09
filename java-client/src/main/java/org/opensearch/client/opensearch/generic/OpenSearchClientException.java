/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

/**
 * Exception thrown by API client methods when OpenSearch could not accept or
 * process a request.
 * <p>
 * The {@link #response()} contains the the raw response as returned by the API
 * endpoint that was called.
 */
public class OpenSearchClientException extends RuntimeException {

    private final Response response;

    public OpenSearchClientException(Response response) {
        super("Request failed: [" + response.getStatus() + "] " + response.getReason());
        this.response = response;
    }

    /**
     * The error response sent by OpenSearch
     */
    public Response response() {
        return this.response;
    }

    /**
     * Status code returned by OpenSearch. Shortcut for
     * {@code response().status()}.
     */
    public int status() {
        return this.response.getStatus();
    }
}
