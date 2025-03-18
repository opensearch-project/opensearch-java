/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.Optional;
import org.apache.http.HttpHost;
import org.opensearch.client.opensearch.OpenSearchAsyncClient;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.common.settings.Settings;

public interface OpenSearchTransportSupport {
    default boolean isHttps() {
        return Optional.ofNullable(System.getProperty("https")).map("true"::equalsIgnoreCase).orElse(false);
    }

    default OpenSearchClient buildJavaClient(Settings settings, HttpHost[] hosts) throws IOException {
        return new OpenSearchClient(buildTransport(settings, hosts));
    }

    default OpenSearchAsyncClient buildAsyncJavaClient(Settings settings, HttpHost[] hosts) throws IOException {
        return new OpenSearchAsyncClient(buildTransport(settings, hosts));
    }

    OpenSearchTransport buildTransport(Settings settings, HttpHost[] hosts) throws IOException;
}
