/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.httpclient5.internal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import com.carrotsearch.randomizedtesting.RandomizedTest;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.hc.core5.http.ContentTooLongException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeapBufferedAsyncEntityConsumerTest extends RandomizedTest {
    private static final int BUFFER_LIMIT = 100 * 1024 * 1024 /* 100Mb */;
    private HeapBufferedAsyncEntityConsumer consumer;

    @Before
    public void setUp() {
        consumer = new HeapBufferedAsyncEntityConsumer(BUFFER_LIMIT);
    }

    @After
    public void tearDown() {
        consumer.releaseResources();
    }

    @Test
    public void testConsumerAllocatesBufferLimit() throws IOException {
        consumer.consume((ByteBuffer) randomByteBufferOfLength(1000).flip());
        assertThat(consumer.getBuffer().capacity(), equalTo(1000));
    }

    @Test
    public void testConsumerAllocatesEmptyBuffer() throws IOException {
        consumer.consume((ByteBuffer) ByteBuffer.allocate(0).flip());
        assertThat(consumer.getBuffer().capacity(), equalTo(0));
    }

    @Test
    public void testConsumerExpandsBufferLimits() throws IOException {
        consumer.consume((ByteBuffer) randomByteBufferOfLength(1000).flip());
        consumer.consume((ByteBuffer) randomByteBufferOfLength(2000).flip());
        consumer.consume((ByteBuffer) randomByteBufferOfLength(3000).flip());
        assertThat(consumer.getBuffer().capacity(), equalTo(6000));
    }

    @Test
    public void testConsumerAllocatesLimit() throws IOException {
        consumer.consume((ByteBuffer) randomByteBufferOfLength(BUFFER_LIMIT).flip());
        assertThat(consumer.getBuffer().capacity(), equalTo(BUFFER_LIMIT));
    }

    @Test
    public void testConsumerFailsToAllocateOverLimit() throws IOException {
        assertThrows(ContentTooLongException.class, () -> consumer.consume((ByteBuffer) randomByteBufferOfLength(BUFFER_LIMIT + 1).flip()));
    }

    @Test
    public void testConsumerFailsToExpandOverLimit() throws IOException {
        consumer.consume((ByteBuffer) randomByteBufferOfLength(BUFFER_LIMIT).flip());
        assertThrows(ContentTooLongException.class, () -> consumer.consume((ByteBuffer) randomByteBufferOfLength(1).flip()));
    }

    private static ByteBuffer randomByteBufferOfLength(int length) {
        return ByteBuffer.allocate(length).put(randomBytesOfLength(length));
    }
}
