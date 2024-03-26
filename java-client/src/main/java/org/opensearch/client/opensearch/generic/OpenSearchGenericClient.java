/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;

/**
 * Client for the generic HTTP requests.
 */
public class OpenSearchGenericClient extends ApiClient<OpenSearchTransport, OpenSearchGenericClient> {
    /**
     * Generic endpoint instance
     */
    private static final class GenericEndpoint implements org.opensearch.client.transport.GenericEndpoint<Request, Response> {
        private final Request request;

        public GenericEndpoint(Request request) {
            this.request = request;
        }

        @Override
        public String method(Request request) {
            return request.getMethod();
        }

        @Override
        public String requestUrl(Request request) {
            return request.getEndpoint();
        }

        @Override
        public boolean hasRequestBody() {
            return request.getBody().isPresent();
        }

        @Override
        public Map<String, String> queryParameters(Request request) {
            return request.getParameters();
        }

        @Override
        public Map<String, String> headers(Request request) {
            return request.getHeaders().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1));
        }

        @Override
        public GenericResponse responseDeserializer(
            String uri,
            String method,
            String protocol,
            int status,
            String reason,
            List<Entry<String, String>> headers,
            String contentType,
            InputStream body
        ) {
            return new GenericResponse(uri, protocol, method, status, reason, headers, Body.from(body, contentType));
        }
    }

    public OpenSearchGenericClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchGenericClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchGenericClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchGenericClient(this.transport, transportOptions);
    }

    /**
     * Executes generic HTTP request and returns generic HTTP response.
     * @param request generic HTTP request
     * @return generic HTTP response
     * @throws IOException I/O exception
     */
    public Response execute(Request request) throws IOException {
        return transport.performRequest(request, new GenericEndpoint(request), this.transportOptions);
    }

    /**
     * Asynchronously executes generic HTTP request and returns generic HTTP response.
     * @param request generic HTTP request
     * @return generic HTTP response future
     */
    public CompletableFuture<Response> executeAsync(Request request) {
        return transport.performRequestAsync(request, new GenericEndpoint(request), this.transportOptions);
    }
}
