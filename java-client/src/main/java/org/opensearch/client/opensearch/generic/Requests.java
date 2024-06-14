/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;

/**
 * Helper class to construct requests instances
 */
public final class Requests {
    private Requests() {}

    /**
     * Creates a new builder for requests with JSON body
     * @return a new builder for requests with JSON body
     */
    public static JsonBodyBuilder builder() {
        return new JsonBodyBuilder();
    }

    /**
     * Create request instance
     * @param method the HTTP method
     * @param endpoint the path of the request (without scheme, host, port, or prefix)
     * @param headers list of headers
     * @param parameters query parameters
     * @param body optional body
     * @return request instance
     */
    public static Request create(
        String method,
        String endpoint,
        Collection<Map.Entry<String, String>> headers,
        Map<String, String> parameters,
        @Nullable Body body
    ) {
        return new GenericRequest(method, endpoint, headers, parameters, body);
    }

    /**
     * A new builder for requests with JSON body
     */
    public static final class JsonBodyBuilder {
        private String method;
        private String endpoint;
        private Collection<Map.Entry<String, String>> headers = Collections.emptyList();
        private Map<String, String> parameters = Collections.emptyMap();
        private Body body;

        private JsonBodyBuilder() {}

        public JsonBodyBuilder endpoint(final String endpoint) {
            this.endpoint = Objects.requireNonNull(endpoint, "endpoint cannot be null");
            return this;
        }

        public JsonBodyBuilder body(final Body body) {
            this.body = Objects.requireNonNull(body, "body cannot be null");
            return this;
        }

        public JsonBodyBuilder json(final JsonObjectBuilder builder) {
            this.body = Bodies.json(builder);
            return this;
        }

        public JsonBodyBuilder json(final JsonObject json) {
            this.body = Bodies.json(json);
            return this;
        }

        public JsonBodyBuilder json(String str) {
            this.body = Bodies.json(str);
            return this;
        }

        public <C> JsonBodyBuilder json(C value, JsonpMapper mapper) throws IOException {
            this.body = Bodies.json(value, mapper);
            return this;
        }

        public JsonBodyBuilder query(final Map<String, String> parameters) {
            this.parameters = Objects.requireNonNull(parameters, "parameters cannot be null");
            return this;
        }

        public JsonBodyBuilder headers(final Collection<Map.Entry<String, String>> headers) {
            this.headers = Objects.requireNonNull(headers, "headers cannot be null");
            return this;
        }

        public JsonBodyBuilder method(final String method) {
            this.method = Objects.requireNonNull(method, "headers cannot be null");
            return this;
        }

        public Request build() {
            return new GenericRequest(method, endpoint, headers, parameters, body);
        }
    }
}
