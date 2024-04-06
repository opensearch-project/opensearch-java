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
import javax.annotation.Nullable;

/**
 * The HTTP request / response body that uses {@link InputStream}
 */
final class GenericInputStreamBody implements Body {
    private final InputStream in;
    private final String contentType;

    GenericInputStreamBody(final InputStream in, @Nullable final String contentType) {
        this.in = in;
        this.contentType = contentType;
    }

    @Override
    public String contentType() {
        return contentType;
    }

    @Override
    public InputStream body() {
        return in;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
