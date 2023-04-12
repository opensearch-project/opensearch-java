/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.transport.endpoints;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

import org.apache.hc.core5.net.URLEncodedUtils;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.opensearch._types.ErrorResponse;

public class GenericEndpoint<RequestT, ResponseT> {

    private static final Function<?, Map<String, String>> EMPTY_MAP = x -> Collections.emptyMap();

    /**
     * Returns a function that always returns an empty String to String map. Useful
     * to avoid creating lots of
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
    private final Function<RequestT, Boolean> hasRequestBody;
    private final JsonpDeserializer<ResponseT> responseParser;

    public GenericEndpoint(
            Function<RequestT, String> method,
            Function<RequestT, String> requestUrl,
            Function<RequestT, Map<String, String>> queryParameters,
            Function<RequestT, Map<String, String>> headers,
            Function<RequestT, Boolean> hasRequestBody,
            JsonpDeserializer<ResponseT> responseParser) {
        this.method = method;
        this.requestUrl = requestUrl;
        this.queryParameters = queryParameters;
        this.headers = headers;
        this.hasRequestBody = hasRequestBody;
        this.responseParser = responseParser;
    }

    public String method(RequestT request) {
        return this.method.apply(request);
    }

    public String requestUrl(RequestT request) {
        return this.requestUrl.apply(request);
    }

    public Map<String, String> queryParameters(RequestT request) {
        return this.queryParameters.apply(request);
    }

    public Map<String, String> headers(RequestT request) {
        return this.headers.apply(request);
    }

    public boolean hasRequestBody(RequestT request) {
        return this.hasRequestBody.apply(request);
    }

    public JsonpDeserializer<ResponseT> responseDeserializer() {
        return this.responseParser;
    }

    public boolean isError(int statusCode) {
        return statusCode >= 400;
    }

    public JsonpDeserializer<ErrorResponse> errorDeserializer(int statusCode) {
        return ErrorResponse._DESERIALIZER;
    }

    public <NewResponseT> GenericEndpoint<RequestT, NewResponseT> withResponseDeserializer(
            JsonpDeserializer<NewResponseT> newResponseParser) {
        return new GenericEndpoint<>(
                method,
                requestUrl,
                queryParameters,
                headers,
                hasRequestBody,
                newResponseParser);
    }

    public static RuntimeException noPathTemplateFound(String what) {
        return new RuntimeException("Could not find a request " + what + " with this set of properties. " +
                "Please check the API documentation, or raise an issue if this should be a valid request.");
    }

    public static void pathEncode(String src, StringBuilder dest) {
        // TODO: avoid dependency on HttpClient here (and use something more efficient)
        dest.append(URLEncodedUtils.formatSegments(src).substring(1));
    }
}
