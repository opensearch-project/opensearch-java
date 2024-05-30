/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.restclient;

import java.io.IOException;
import org.apache.hc.core5.http.HttpHost;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.integTest.AbstractKnnIT;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.common.settings.Settings;

public class KnnIT extends AbstractKnnIT {
    @Override
    public OpenSearchTransport buildTransport(Settings settings, HttpHost[] hosts) throws IOException {
        return new RestClientTransport(buildClient(settings, hosts), new JacksonJsonpMapper());
    }
}
