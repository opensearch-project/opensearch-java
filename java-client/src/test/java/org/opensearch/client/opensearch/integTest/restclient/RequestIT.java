/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.restclient;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.util.Optional;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContexts;
import org.junit.Assume;
import org.junit.Test;
import org.opensearch.client.RestClient;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.opensearch.client.opensearch.indices.CreateIndexRequest;
import org.opensearch.client.opensearch.indices.IndexSettings;
import org.opensearch.client.opensearch.integTest.AbstractRequestIT;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportException;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.common.settings.Settings;

public class RequestIT extends AbstractRequestIT {
    @Override
    public OpenSearchTransport buildTransport(Settings settings, HttpHost[] hosts) throws IOException {
        return new RestClientTransport(buildClient(settings, hosts), new JacksonJsonpMapper());
    }

    @Test
    public void testUnauthorized() throws Exception {
        // The security plugin is required
        Assume.assumeThat(isHttps(), equalTo(true));

        final String userName = Optional.ofNullable(System.getProperty("user")).orElse("admin");
        final String wrongPassword = Optional.ofNullable(System.getProperty("password")).orElse("admin") + "wrong";

        final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
            new AuthScope(getClusterHosts().get(0)),
            new UsernamePasswordCredentials(userName, wrongPassword)
        );

        final RestClient restClient = RestClient.builder(getClusterHosts().toArray(new HttpHost[0]))
            .setHttpClientConfigCallback(httpClientBuilder -> {
                try {
                    final TrustStrategy trustStrategy = new TrustAllStrategy();
                    final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, trustStrategy).build();
                    return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider).setSSLContext(sslContext);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            })
            .build();

        final RestClientTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        final OpenSearchClient client = new OpenSearchClient(transport);
        final TransportException transportException = assertThrows(TransportException.class, () -> client.cluster().getSettings());
        assertEquals("Unauthorized access", transportException.getMessage());
        restClient.close();
    }

    @Test
    public void testForbidden() throws Exception {
        final OpenSearchClient openSearchClient = javaClient();
        final String testIndex = "test-index";
        final CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(testIndex)
            .settings(new IndexSettings.Builder().blocksRead(true).build())
            .build();
        openSearchClient.indices().create(createIndexRequest);
        final SearchRequest searchRequest = new SearchRequest.Builder().index(testIndex).build();
        final TransportException transportException = assertThrows(
            TransportException.class,
            () -> openSearchClient.search(searchRequest, JsonData.class)
        );
        assertEquals("Forbidden access", transportException.getMessage());
    }
}
