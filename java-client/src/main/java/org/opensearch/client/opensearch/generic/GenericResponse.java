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
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generic HTTP response from OpenSearch
 */
final class GenericResponse implements Response {
    private final String protocol;
    private final String method;
    private final String uri;
    private final int status;
    private final String reason;
    private final Collection<Map.Entry<String, String>> headers;
    private final Body body;

    GenericResponse(String uri, String protocol, String method, int status, String reason, Collection<Map.Entry<String, String>> headers) {
        this(uri, protocol, method, status, reason, headers, null);
    }

    GenericResponse(
        String uri,
        String protocol,
        String method,
        int status,
        String reason,
        Collection<Map.Entry<String, String>> headers,
        Body body
    ) {
        this.uri = Objects.requireNonNull(uri, "uri cannot be null");
        this.protocol = Objects.requireNonNull(protocol, "protocol cannot be null");
        this.method = Objects.requireNonNull(method, "method cannot be null");
        this.status = status;
        this.reason = reason;
        this.headers = Objects.requireNonNull(headers, "headers cannot be null");
        this.body = body;
    }

    @Override
    public Optional<Body> getBody() {
        return Optional.ofNullable(body);
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public Collection<Map.Entry<String, String>> getHeaders() {
        return Collections.unmodifiableCollection(headers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        final GenericResponse other = (GenericResponse) obj;
        return method.equals(other.method)
            && protocol.equals(other.protocol)
            && uri.equals(other.uri)
            && Objects.equals(reason, other.reason)
            && headers.equals(other.headers)
            && status == other.status
            && Objects.equals(body, other.body);
    }

    /**
     * Calculate the hash code of the response
     */
    @Override
    public int hashCode() {
        return Objects.hash(method, protocol, uri, status, reason, headers, body);
    }

    @Override
    public void close() throws IOException {
        if (body != null) {
            body.close();
        }
    }
}
