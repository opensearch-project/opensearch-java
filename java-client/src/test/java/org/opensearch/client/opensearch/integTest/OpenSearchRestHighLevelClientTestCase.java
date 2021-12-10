/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.opensearch.client.RestClient;
import org.opensearch.client.base.RestClientTransport;
import org.opensearch.client.base.Transport;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.test.rest.OpenSearchRestTestCase;
import org.junit.AfterClass;
import org.junit.Before;

import java.io.IOException;

public abstract class OpenSearchRestHighLevelClientTestCase extends OpenSearchRestTestCase {

    private static RestClient restClient;
    private static OpenSearchClient restHighLevelClient;

    @Before
    public void initHighLevelClient() throws IOException {
        super.initClient();
        if (restHighLevelClient == null) {
            // Create the low-level client
            restClient = client();
            // Create the transport that provides JSON and http services to API clients
            Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
            // Create API client
            restHighLevelClient = new OpenSearchClient(transport);
        }
    }

    protected String getTestRestCluster() {
        String cluster = System.getProperty("tests.rest.cluster");
        if (cluster == null) {
            cluster = "localhost:9200";
        }
        return cluster;
    }

    @AfterClass
    public static void cleanupClient() throws IOException {
        try {
            restClient.close();
        } finally {
            restClient = null;
            restHighLevelClient = null;
        }
    }

    protected static OpenSearchClient highLevelClient() {
        return restHighLevelClient;
    }
}
