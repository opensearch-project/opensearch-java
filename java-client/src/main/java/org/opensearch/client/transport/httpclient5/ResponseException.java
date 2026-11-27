/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.transport.httpclient5;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.BufferedHttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

/**
 * Exception thrown when an opensearch node responds to a request with a status code that indicates an error.
 * Holds the response that was returned.
 */
public final class ResponseException extends IOException {

    /**
     * Media types of the binary formats a response body can be requested in (through the {@code Accept} header).
     * Their bytes are not human readable, so they are described in the message instead of being decoded as text.
     */
    private static final List<String> BINARY_TYPES = Arrays.asList("application/cbor", "application/smile", "application/octet-stream");

    private final Response response;

    /**
     * Creates a ResponseException containing the given {@code Response}.
     *
     * @param response The error response.
     */
    ResponseException(Response response) throws IOException {
        super(buildMessage(response));
        this.response = response;
    }

    static String buildMessage(Response response) throws IOException {
        String message = String.format(
            Locale.ROOT,
            "method [%s], host [%s], URI [%s], status line [%s]",
            response.getRequestLine().getMethod(),
            response.getHost(),
            response.getRequestLine().getUri(),
            response.getStatusLine()
        );

        if (response.hasWarnings()) {
            message += "\n" + "Warnings: " + response.getWarnings();
        }

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            if (entity.isRepeatable() == false) {
                entity = new BufferedHttpEntity(entity);
                response.getHttpResponse().setEntity(entity);
            }
            final String mediaType = mediaTypeOf(entity);
            if (BINARY_TYPES.contains(mediaType)) {
                message += "\n" + describeBinaryBody(mediaType, entity);
            } else {
                try {
                    message += "\n" + EntityUtils.toString(entity);
                } catch (final ParseException ex) {
                    throw new IOException(ex);
                }
            }
        }
        return message;
    }

    /**
     * Returns the lower-cased media type of the entity without its parameters, or {@code null} if it has no content type.
     */
    private static String mediaTypeOf(HttpEntity entity) {
        final String contentType = entity.getContentType();
        if (contentType == null) {
            return null;
        }
        final int parameters = contentType.indexOf(';');
        return (parameters < 0 ? contentType : contentType.substring(0, parameters)).trim().toLowerCase(Locale.ROOT);
    }

    private static String describeBinaryBody(String mediaType, HttpEntity entity) {
        final long length = entity.getContentLength();
        final String size = length < 0 ? "" : ", " + length + " bytes";
        return "[binary " + mediaType + " content omitted" + size + "]";
    }

    /**
     * Returns the {@link Response} that caused this exception to be thrown.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * HTTP status code returned by OpenSearch.
     */
    public int status() {
        return this.response.getStatusLine().getStatusCode();
    }
}
