/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;

/**
 * Generic HTTP request / response body. It is responsibility of the caller to close the body instance
 * explicitly (or through {@link GenericResponse} instance) to release all associated resources.
 */
public interface Body extends AutoCloseable {
    final int DEFAULT_BUFFER_SIZE = 8192;

    /**
     * Constructs the generic response body out of {@link InputStream} with assumed content type
     * @param body response body stream
     * @param contentType content type
     * @return generic response body instance
     */
    static @Nullable Body from(@Nullable final InputStream body, @Nullable final String contentType) {
        if (body == null) {
            return null;
        } else {
            return new GenericInputStreamBody(body, contentType);
        }
    }

    /**
     * Constructs the generic response body out of {@link InputStream} with assumed content type
     * @param body response body stream
     * @param contentType content type
     * @return generic response body instance
     */
    static @Nullable Body from(@Nullable final byte[] body, @Nullable final String contentType) {
        if (body == null) {
            return null;
        } else {
            return new GenericByteArrayBody(body, contentType);
        }
    }

    /**
     * Content type of this body
     * @return content type
     */
    String contentType();

    /**
     * Gets the body as {@link InputStream}
     * @return body as {@link InputStream}
     */
    InputStream body();

    /**
     * Gets the body as {@link String}
     * @return body as {@link String}
     */
    default String bodyAsString() {
        try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            try (final InputStream in = body()) {
                final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
                int read;
                while ((read = in.read(buffer, 0, DEFAULT_BUFFER_SIZE)) >= 0) {
                    out.write(buffer, 0, read);
                }
            }

            out.flush();
            return new String(out.toByteArray(), StandardCharsets.UTF_8);
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    /**
     * Releases all resources associated with this body stream.
     */
    void close() throws IOException;
}
