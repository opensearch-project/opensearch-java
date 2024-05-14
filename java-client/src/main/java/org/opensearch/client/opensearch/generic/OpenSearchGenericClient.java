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
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
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
     * Generic client options
     */
    public static final class ClientOptions {
        private static final ClientOptions DEFAULT = new ClientOptions();

        private final Predicate<Integer> error;

        private ClientOptions() {
            this(statusCode -> false);
        }

        private ClientOptions(final Predicate<Integer> error) {
            this.error = error;
        }

        public static ClientOptions throwOnHttpErrors() {
            return new ClientOptions(statusCode -> statusCode >= 400);
        }
    }

    /**
     * Generic endpoint instance
     */
    private static final class GenericEndpoint implements org.opensearch.client.transport.GenericEndpoint<Request, Response> {
        private final Request request;
        private final Predicate<Integer> error;

        public GenericEndpoint(Request request, Predicate<Integer> error) {
            this.request = request;
            this.error = error;
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
            @Nullable String contentType,
            @Nullable InputStream body
        ) {
            try (Body b = Body.from(body, contentType)) {
                if (b != null) {
                    // Fully consume the response body:
                    // - if it will be propagated as an exception with possible no chance to be closed
                    // - the entity stream will be consumed and become unavailable
                    return new GenericResponse(uri, protocol, method, status, reason, headers, Body.from(b.bodyAsBytes(), b.contentType()));
                } else {
                    return new GenericResponse(uri, protocol, method, status, reason, headers);
                }
            } catch (final IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

        @Override
        public boolean isError(int statusCode) {
            return error.test(statusCode);
        }

        @Override
        public <T extends RuntimeException> T exceptionConverter(int statusCode, @Nullable Response error) {
            throw new OpenSearchClientException(error);
        }
    }

    private final ClientOptions clientOptions;

    public OpenSearchGenericClient(OpenSearchTransport transport) {
        this(transport, null, ClientOptions.DEFAULT);
    }

    public OpenSearchGenericClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        this(transport, transportOptions, ClientOptions.DEFAULT);
    }

    public OpenSearchGenericClient(
        OpenSearchTransport transport,
        @Nullable TransportOptions transportOptions,
        ClientOptions clientOptions
    ) {
        super(transport, transportOptions);
        this.clientOptions = clientOptions;
    }

    public OpenSearchGenericClient withClientOptions(ClientOptions clientOptions) {
        return new OpenSearchGenericClient(this.transport, this.transportOptions, clientOptions);
    }

    @Override
    public OpenSearchGenericClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchGenericClient(this.transport, transportOptions, this.clientOptions);
    }

    /**
     * Executes generic HTTP request and returns generic HTTP response.
     * @param request generic HTTP request
     * @return generic HTTP response
     * @throws IOException I/O exception
     */
    public Response execute(Request request) throws IOException {
        return transport.performRequest(request, new GenericEndpoint(request, clientOptions.error), this.transportOptions);
    }

    /**
     * Asynchronously executes generic HTTP request and returns generic HTTP response.
     * @param request generic HTTP request
     * @return generic HTTP response future
     */
    public CompletableFuture<Response> executeAsync(Request request) {
        return transport.performRequestAsync(request, new GenericEndpoint(request, clientOptions.error), this.transportOptions);
    }
}
