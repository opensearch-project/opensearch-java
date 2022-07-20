/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;


import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.After;
import org.opensearch.client.Request;
import org.opensearch.client.Response;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.junit.AfterClass;
import org.junit.Before;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.common.settings.Settings;
import org.opensearch.common.xcontent.DeprecationHandler;
import org.opensearch.common.xcontent.NamedXContentRegistry;
import org.opensearch.common.xcontent.XContentParser;
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.test.rest.OpenSearchRestTestCase;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


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
            OpenSearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
            // Create API client
            restHighLevelClient = new OpenSearchClient(transport);
        }
    }

    private boolean isHttps() {
        return Optional.ofNullable(System.getProperty("https"))
                .map("true"::equalsIgnoreCase)
                .orElse(false);
    }

    @Override
    protected String getProtocol() {
        return isHttps() ? "https" : "http";
    }

    protected static OpenSearchClient highLevelClient() {
        return restHighLevelClient;
    }

    @Override
    protected RestClient buildClient(Settings settings, HttpHost[] hosts) throws IOException {
        RestClientBuilder builder = RestClient.builder(hosts);
        builder.setStrictDeprecationMode(true);
        if (isHttps()) {
            configureHttpsClient(builder);
        }
        return builder.build();
    }

    private void configureHttpsClient(RestClientBuilder builder) {
        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            String userName = Optional.ofNullable(System.getProperty("user")).orElse("admin");
            String password = Optional.ofNullable(System.getProperty("password")).orElse("admin");

            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));

            try {
                return httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider)
                        // disable the certificate since our testing cluster just uses the default security configuration
                        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                        .setSSLContext(SSLContextBuilder.create().loadTrustMaterial(null, (chains, authType) -> true).build());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
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

    @SuppressWarnings("unchecked")
    @After
    protected void wipeAllOSIndices() throws IOException {
        Response response = adminClient().performRequest(new Request("GET", "/_cat/indices?format=json&expand_wildcards=all"));
        XContentType xContentType = XContentType.fromMediaType(response.getEntity().getContentType().getValue());
        XContentParser parser = xContentType.xContent().createParser(
                NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                response.getEntity().getContent());

        try {
            XContentParser.Token token = parser.nextToken();
            List<Map<String, Object>> parserList;
            if (token == XContentParser.Token.START_ARRAY) {
                parserList = parser.listOrderedMap().stream().map(obj -> (Map<String, Object>) obj).collect(Collectors.toList());
            } else {
                parserList = Collections.singletonList(parser.mapOrdered());
            }

            for (Map<String, Object> index : parserList) {
                String indexName = (String) index.get("index");
                if (indexName != null && !".opendistro_security".equals(indexName)) {
                    adminClient().performRequest(new Request("DELETE", "/" + indexName));
                }
            }
        } finally {
            parser.close();
        }
    }

    /**
     * wipeAllIndices won't work since it cannot delete security index. Use wipeAllOSIndices instead.
     */
    @Override
    protected boolean preserveIndicesUponCompletion() {
        return true;
    }
} 