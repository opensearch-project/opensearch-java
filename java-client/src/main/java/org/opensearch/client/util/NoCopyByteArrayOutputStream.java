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

package org.opensearch.client.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/**
 * A {@code ByteArrayOutputStream} that reduces copy operations of its underlying buffer.
 */
public class NoCopyByteArrayOutputStream extends ByteArrayOutputStream {

    /**
     * Create a new output stream with default initial capacity.
     */
    public NoCopyByteArrayOutputStream() {}

    /**
     * Create a new output stream with the specified initial capacity.
     *
     * @param size the initial capacity of the internal buffer
     */
    public NoCopyByteArrayOutputStream(int size) {
        super(size);
    }

    /**
     * Get the underlying buffer. Data was added to this buffer up to {@code size()}. Note that calling this method
     * again may return a different result if additional data was inserted and the buffer had to grow.
     */
    public byte[] array() {
        return this.buf;
    }

    /**
     * Get an {@code InputStream} view on this object, based on the current buffer and size.
     */
    public ByteArrayInputStream asInputStream() {
        return new ByteArrayInputStream(this.buf, 0, this.count);
    }

    /**
     * Get a {@code ByteBuffer} view on this object, based on the current buffer and size.
     */
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.buf, 0, this.count);
    }
}
