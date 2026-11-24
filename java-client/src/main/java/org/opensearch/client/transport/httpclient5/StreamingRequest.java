/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5;

import static java.util.Collections.unmodifiableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.opensearch.client.transport.TransportOptions;
import org.reactivestreams.Publisher;

/**
 * HTTP Streaming Request to OpenSearch. <strong>This is an experimental API.</strong>
 */
public class StreamingRequest<T> {
    private final String method;
    private final String endpoint;
    private final Map<String, String> parameters = new HashMap<>();

    private TransportOptions options = ApacheHttpClient5Options.DEFAULT;
    private final Publisher<T> publisher;

    /**
     * Constructor
     * @param method method
     * @param endpoint endpoint
     * @param publisher publisher
     */
    public StreamingRequest(String method, String endpoint, Publisher<T> publisher) {
        this.method = method;
        this.endpoint = endpoint;
        this.publisher = publisher;
    }

    /**
     * Get endpoint
     * @return endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Get method
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Get options
     * @return options
     */
    public TransportOptions getOptions() {
        return options;
    }

    /**
     * Get parameters
     * @return parameters
     */
    public Map<String, String> getParameters() {
        if (options.queryParameters().isEmpty()) {
            return unmodifiableMap(parameters);
        } else {
            Map<String, String> combinedParameters = new HashMap<>(parameters);
            combinedParameters.putAll(options.queryParameters());
            return unmodifiableMap(combinedParameters);
        }
    }

    /**
     * Set the portion of an HTTP request to OpenSearch that can be
     * manipulated without changing OpenSearch's behavior.
     *
     * @param options the options to be set.
     * @throws NullPointerException if {@code options} is null.
     */
    public void setOptions(TransportOptions options) {
        Objects.requireNonNull(options, "options cannot be null");
        this.options = options;
    }

    /**
     * Set the portion of an HTTP request to OpenSearch that can be
     * manipulated without changing OpenSearch's behavior.
     *
     * @param options the options to be set.
     * @throws NullPointerException if {@code options} is null.
     */
    public void setOptions(TransportOptions.Builder options) {
        Objects.requireNonNull(options, "options cannot be null");
        this.options = options.build();
    }

    /**
     * Add a query string parameter.
     * @param name the name of the url parameter. Must not be null.
     * @param value the value of the url url parameter. If {@code null} then
     *      the parameter is sent as {@code name} rather than {@code name=value}
     * @throws IllegalArgumentException if a parameter with that name has
     *      already been set
     */
    public void addParameter(String name, String value) {
        Objects.requireNonNull(name, "url parameter name cannot be null");
        if (parameters.containsKey(name)) {
            throw new IllegalArgumentException("url parameter [" + name + "] has already been set to [" + parameters.get(name) + "]");
        } else {
            parameters.put(name, value);
        }
    }

    /**
     * Add query parameters using the provided map of key value pairs.
     *
     * @param paramSource a map of key value pairs where the key is the url parameter.
     * @throws IllegalArgumentException if a parameter with that name has already been set.
     */
    public void addParameters(Map<String, String> paramSource) {
        paramSource.forEach(this::addParameter);
    }

    /**
     * Body publisher
     * @return body publisher
     */
    public Publisher<T> getBody() {
        return publisher;
    }
}
