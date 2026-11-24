/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * See please https://github.com/justinsb/avro/blob/master/src/java/org/apache/avro/ipc/ByteBufferInputStream.java
 */
public final class ByteBufferInputStream extends InputStream {
    private List<ByteBuffer> buffers;
    private int current;

    public ByteBufferInputStream(ByteBuffer buffer) {
        this(Collections.singleton(buffer));
    }

    public ByteBufferInputStream(Iterable<ByteBuffer> buffers) {
        this.buffers = StreamSupport.stream(buffers.spliterator(), false).collect(Collectors.toList());
    }

    /** @see InputStream#read()
     * @throws EOFException if EOF is reached. */
    @Override
    public int read() throws IOException {
        return getBuffer().get() & 0xff;
    }

    /** @see InputStream#read(byte[], int, int)
     * @throws EOFException if EOF is reached before reading all the bytes. */
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (len == 0) return 0;
        ByteBuffer buffer = getBuffer();
        int remaining = buffer.remaining();
        if (len > remaining) {
            buffer.get(b, off, remaining);
            return remaining;
        } else {
            buffer.get(b, off, len);
            return len;
        }
    }

    /** Returns the next non-empty buffer.
     * @throws EOFException if EOF is reached before reading all the bytes.
     */
    private ByteBuffer getBuffer() throws IOException {
        while (current < buffers.size()) {
            ByteBuffer buffer = buffers.get(current);
            if (buffer.hasRemaining()) return buffer;
            current++;
        }
        throw new EOFException();
    }
}
