/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import static java.util.Collections.unmodifiableMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;
import org.opensearch.client.transport.GenericSerializable;

/**
 * Generic HTTP request to OpenSearch
 */
final class GenericRequest implements GenericSerializable, Request {
    private final String method;
    private final String endpoint;
    private final Collection<Map.Entry<String, String>> headers;
    private final Map<String, String> parameters;
    private final Body body;

    /**
     * Create the {@linkplain GenericRequest}.
     * @param method the HTTP method
     * @param endpoint the path of the request (without scheme, host, port, or prefix)
     * @param headers list of headers
     */
    GenericRequest(String method, String endpoint, Collection<Map.Entry<String, String>> headers) {
        this(method, endpoint, headers, Collections.emptyMap(), null);
    }

    /**
     * Create the {@linkplain GenericRequest}.
     * @param method the HTTP method
     * @param endpoint the path of the request (without scheme, host, port, or prefix)
     * @param headers list of headers
     * @param parameters query parameters
     * @param body optional body
     */
    GenericRequest(
        String method,
        String endpoint,
        Collection<Map.Entry<String, String>> headers,
        Map<String, String> parameters,
        @Nullable Body body
    ) {
        this.method = Objects.requireNonNull(method, "method cannot be null");
        this.endpoint = Objects.requireNonNull(endpoint, "endpoint cannot be null");
        this.headers = Objects.requireNonNull(headers, "headers cannot be null");
        this.parameters = Objects.requireNonNull(parameters, "parameters cannot be null");
        this.body = body;
    }

    /**
     * The HTTP method.
     */
    @Override
    public String getMethod() {
        return method;
    }

    /**
     * The path of the request (without scheme, host, port, or prefix).
     */
    @Override
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Query string parameters. The returned map is an unmodifiable view of the
     * map in the request.
     */
    @Override
    public Map<String, String> getParameters() {
        return unmodifiableMap(parameters);
    }

    @Override
    public Collection<Map.Entry<String, String>> getHeaders() {
        return Collections.unmodifiableCollection(headers);
    }

    /**
     * The body of the request. If {@code null} then no body
     * is sent with the request.
     */
    @Override
    public Optional<Body> getBody() {
        return Optional.ofNullable(body);
    }

    /**
     * Convert request to string representation
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("Request{");
        b.append("method='").append(method).append('\'');
        b.append(", endpoint='").append(endpoint).append('\'');
        if (false == parameters.isEmpty()) {
            b.append(", params=").append(parameters);
        }
        if (body != null) {
            b.append(", body=").append(body);
        }
        return b.append('}').toString();
    }

    /**
     * Compare two requests for equality
     * @param obj request instance to compare with
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        final GenericRequest other = (GenericRequest) obj;
        return method.equals(other.method)
            && endpoint.equals(other.endpoint)
            && parameters.equals(other.parameters)
            && headers.equals(other.headers)
            && Objects.equals(body, other.body);
    }

    /**
     * Calculate the hash code of the request
     */
    @Override
    public int hashCode() {
        return Objects.hash(method, endpoint, parameters, headers, body);
    }

    @Override
    public String serialize(OutputStream out) {
        if (getBody().isPresent() == false) {
            throw new IllegalStateException("The request has no content body provided.");
        }

        final Body b = getBody().get();
        try (final InputStream in = b.body()) {
            final byte[] buffer = new byte[Body.DEFAULT_BUFFER_SIZE];
            int read;
            while ((read = in.read(buffer, 0, Body.DEFAULT_BUFFER_SIZE)) >= 0) {
                out.write(buffer, 0, read);
            }
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }

        return b.contentType();
    }
}
