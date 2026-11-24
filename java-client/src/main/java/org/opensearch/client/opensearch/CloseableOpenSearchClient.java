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
import javax.annotation.Nullable;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;

/**
 * An {@link OpenSearchClient} which is {@link Closeable} and closes the underlying {@link OpenSearchTransport} when closed.
 * <p>
 * This client owns the transport. Clients returned by {@link #withTransportOptions(TransportOptions)} share the transport
 * but are not closeable. Keep this client open while using those clients. Closing this client also makes those clients unusable.
 */
public class CloseableOpenSearchClient extends OpenSearchClient implements Closeable {
    public CloseableOpenSearchClient(final OpenSearchTransport transport) {
        super(transport, null);
    }

    public CloseableOpenSearchClient(final OpenSearchTransport transport, @Nullable final TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public void close() throws IOException {
        this.transport.close();
    }
}
