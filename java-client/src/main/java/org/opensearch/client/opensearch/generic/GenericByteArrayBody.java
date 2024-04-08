/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.generic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/**
 * The HTTP request / response body that uses {@link byte[]}
 */
final class GenericByteArrayBody implements Body {
    private final byte[] bytes;
    private final String contentType;

    GenericByteArrayBody(final byte[] bytes, @Nullable final String contentType) {
        this.bytes = bytes;
        this.contentType = contentType;
    }

    @Override
    public String contentType() {
        return contentType;
    }

    @Override
    public InputStream body() {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void close() throws IOException {}
}
