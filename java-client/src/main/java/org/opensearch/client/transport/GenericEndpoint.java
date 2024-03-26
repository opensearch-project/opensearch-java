/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;

/**
 * An endpoint with a raw, unparsed response body. The endpoind does not distinguish between errornous and successful response
 * and always return the raw response body.
 */
public interface GenericEndpoint<RequestT, ResponseT> extends Endpoint<RequestT, ResponseT, ResponseT> {
    default public boolean isError(int statusCode) {
        return false; /* never return an error since errorDeserializer is JSON specific */
    }

    /**
     * The error is never deserialized explicitly, represented as the instance of {@link ResponseT} instead.
     */
    default public JsonpDeserializer<ResponseT> errorDeserializer(int statusCode) {
        return null;
    }

    /**
     * Constructs the {@link ResponseT} instance
     * @param uri request URI
     * @param method HTTP method
     * @param protocol HTTP protocol version
     * @param status status code
     * @param reason reason phrase
     * @param headers response headers
     * @param body optional body
     * @return the {@link ResponseT} instance
     */
    ResponseT responseDeserializer(
        final String uri,
        final String method,
        final String protocol,
        int status,
        final String reason,
        final List<Map.Entry<String, String>> headers,
        @Nullable final String contentType,
        @Nullable final InputStream body
    );
}
