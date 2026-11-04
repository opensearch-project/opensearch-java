/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;

public class CloseableClientTest extends Assert {

    private final AtomicInteger closeCount = new AtomicInteger();

    private OpenSearchTransport countingTransport() {
        return countingTransport(null);
    }

    private OpenSearchTransport countingTransport(final IOException closeFailure) {
        return (OpenSearchTransport) Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class<?>[] { OpenSearchTransport.class },
            (final var proxy, final var method, final var args) -> {
                if (method.getName().equals("close")) {
                    closeCount.incrementAndGet();
                    if (closeFailure != null) {
                        throw closeFailure;
                    }
                    return null;
                }
                throw new AssertionError("Unexpected transport method: " + method);
            }
        );
    }

    @Test
    public void closingSyncClientClosesTransport() throws IOException {
        try (final CloseableOpenSearchClient client = new CloseableOpenSearchClient(countingTransport())) {
            assertEquals(0, closeCount.get());
        }
        assertEquals(1, closeCount.get());
    }

    @Test
    public void closingAsyncClientClosesTransport() throws IOException {
        try (final CloseableOpenSearchClient client = new CloseableOpenSearchAsyncClient(countingTransport())) {
            assertEquals(0, closeCount.get());
        }
        assertEquals(1, closeCount.get());
    }

    @Test
    public void withTransportOptionsReturnsNonCloseableViews() throws IOException {
        assertWithTransportOptions(TransportOptions.builder().addHeader("X-Test", "value").build());
    }

    @Test
    public void withNullTransportOptionsReturnsNonCloseableViews() throws IOException {
        assertWithTransportOptions(null);
    }

    private void assertWithTransportOptions(final TransportOptions options) throws IOException {
        final OpenSearchTransport transport = countingTransport();
        final TransportOptions originalOptions = TransportOptions.builder().addHeader("X-Original", "value").build();
        try (final CloseableOpenSearchClient client = new CloseableOpenSearchClient(transport, originalOptions)) {
            assertSame(originalOptions, client._transportOptions());
            final OpenSearchClient derived = client.withTransportOptions(options);

            assertNotSame(client, derived);
            assertFalse(derived instanceof Closeable);
            assertSame(transport, derived._transport());
            assertSame(options, derived._transportOptions());
            assertSame(originalOptions, client._transportOptions());

            final OpenSearchClient chained = derived.withTransportOptions(originalOptions);
            assertFalse(chained instanceof Closeable);
            assertSame(transport, chained._transport());
            assertSame(originalOptions, chained._transportOptions());
            assertEquals(0, closeCount.get());
        }
        assertEquals(1, closeCount.get());

        final var asyncTransport = countingTransport();
        try (final var asyncClient = new CloseableOpenSearchAsyncClient(asyncTransport, originalOptions)) {
            assertSame(originalOptions, asyncClient._transportOptions());
            final var asyncDerived = asyncClient.withTransportOptions(options);

            assertNotSame(asyncClient, asyncDerived);
            assertFalse(asyncDerived instanceof Closeable);
            assertSame(asyncTransport, asyncDerived._transport());
            assertSame(options, asyncDerived._transportOptions());
            assertSame(originalOptions, asyncClient._transportOptions());

            final var asyncChained = asyncDerived.withTransportOptions(originalOptions);
            assertFalse(asyncChained instanceof Closeable);
            assertSame(asyncTransport, asyncChained._transport());
            assertSame(originalOptions, asyncChained._transportOptions());
            assertEquals(1, closeCount.get());
        }
        assertEquals(2, closeCount.get());
    }

    @Test
    public void closingSyncClientPropagatesTransportFailure() {
        final var failure = new IOException("Transport close failed");
        final var client = new CloseableOpenSearchClient(countingTransport(failure));

        assertSame(failure, assertThrows(IOException.class, client::close));
        assertEquals(1, closeCount.get());
    }

    @Test
    public void closingAsyncClientPropagatesTransportFailure() {
        final var failure = new IOException("Transport close failed");
        final var client = new CloseableOpenSearchAsyncClient(countingTransport(failure));

        assertSame(failure, assertThrows(IOException.class, client::close));
        assertEquals(1, closeCount.get());
    }
}
