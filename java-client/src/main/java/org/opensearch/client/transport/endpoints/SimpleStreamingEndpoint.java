/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.endpoints;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.transport.StreamingEndpoint;
import org.reactivestreams.Publisher;

public class SimpleStreamingEndpoint<RequestT extends Publisher<?>, ResponseT extends Publisher<?>>
    implements
        StreamingEndpoint<RequestT, ResponseT, ErrorResponse> {

    private static final Function<?, Map<String, String>> EMPTY_MAP = x -> Collections.emptyMap();

    /**
     * Returns a function that always returns an empty String to String map. Useful to avoid creating lots of
     * duplicate lambdas in endpoints that don't have headers or parameters.
     */
    @SuppressWarnings("unchecked")
    public static <T> Function<T, Map<String, String>> emptyMap() {
        return (Function<T, Map<String, String>>) EMPTY_MAP;
    }

    private final Function<RequestT, String> method;
    private final Function<RequestT, String> requestUrl;
    private final Function<RequestT, Map<String, String>> queryParameters;
    private final Function<RequestT, Map<String, String>> headers;
    private final boolean hasRequestBody;
    private final JsonpDeserializer<?> elementParser;
    private final BiFunction<Publisher<ByteBuffer>, Function<ByteBuffer, ?>, ResponseT> responseParser;

    public SimpleStreamingEndpoint(
        Function<RequestT, String> method,
        Function<RequestT, String> requestUrl,
        Function<RequestT, Map<String, String>> queryParameters,
        Function<RequestT, Map<String, String>> headers,
        boolean hasRequestBody,
        JsonpDeserializer<?> elementParser,
        BiFunction<Publisher<ByteBuffer>, Function<ByteBuffer, ?>, ResponseT> responseParser
    ) {
        this.method = method;
        this.requestUrl = requestUrl;
        this.queryParameters = queryParameters;
        this.headers = headers;
        this.hasRequestBody = hasRequestBody;
        this.elementParser = elementParser;
        this.responseParser = responseParser;
    }

    @Override
    public String method(RequestT request) {
        return this.method.apply(request);
    }

    @Override
    public String requestUrl(RequestT request) {
        return this.requestUrl.apply(request);
    }

    @Override
    public Map<String, String> queryParameters(RequestT request) {
        return this.queryParameters.apply(request);
    }

    @Override
    public Map<String, String> headers(RequestT request) {
        return this.headers.apply(request);
    }

    @Override
    public boolean hasRequestBody() {
        return this.hasRequestBody;
    }

    @Override
    public JsonpDeserializer<?> elementDeserializer() {
        return this.elementParser;
    }

    // ES-specific
    @Override
    public boolean isError(int statusCode) {
        return statusCode >= 400;
    }

    @Override
    public JsonpDeserializer<ErrorResponse> errorDeserializer(int statusCode) {
        return ErrorResponse._DESERIALIZER;
    }

    @Override
    public ResponseT responseDeserializer(Publisher<ByteBuffer> elements, Function<ByteBuffer, ?> elementDeserializer) {
        return responseParser.apply(elements, elementDeserializer);
    }
}
