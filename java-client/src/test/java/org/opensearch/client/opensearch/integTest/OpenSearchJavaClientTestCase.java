/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.core5.function.Factory;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.reactor.ssl.TlsDetails;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.opensearch.Version;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch.cat.IndicesResponse;
import org.opensearch.client.opensearch.cat.indices.IndicesRecord;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.nodes.NodesInfoResponse;
import org.opensearch.client.opensearch.nodes.info.NodeInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.opensearch.common.settings.Settings;
import org.opensearch.core.internal.io.IOUtils;
import org.opensearch.test.rest.OpenSearchRestTestCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import javax.net.ssl.SSLEngine;

public abstract class OpenSearchJavaClientTestCase extends OpenSearchRestTestCase implements OpenSearchTransportSupport {
    private static OpenSearchClient javaClient;
    private static OpenSearchClient adminJavaClient;

    private static TreeSet<Version> nodeVersions;
    private static List<HttpHost> clusterHosts;

    @Before
    public void initJavaClient() throws IOException {
        if (javaClient == null) {
            String cluster = getTestRestCluster();
            String[] stringUrls = cluster.split(",");
            List<HttpHost> hosts = new ArrayList<>(stringUrls.length);
            for (String stringUrl : stringUrls) {
                int portSeparator = stringUrl.lastIndexOf(':');
                if (portSeparator < 0) {
                    throw new IllegalArgumentException("Illegal cluster url [" + stringUrl + "]");
                }
                String host = stringUrl.substring(0, portSeparator);
                int port = Integer.valueOf(stringUrl.substring(portSeparator + 1));
                hosts.add(new HttpHost(getProtocol(), host, port));
            }
            clusterHosts = Collections.unmodifiableList(hosts);
            logger.info("initializing REST clients against {}", clusterHosts);

            javaClient = buildJavaClient(restClientSettings(), clusterHosts.toArray(new HttpHost[clusterHosts.size()]));
            adminJavaClient = buildJavaClient(restAdminSettings(), clusterHosts.toArray(new HttpHost[clusterHosts.size()]));

            nodeVersions = new TreeSet<>();
            final NodesInfoResponse response = adminJavaClient.nodes().info();
            for (final NodeInfo node : response.nodes().values()) {
                nodeVersions.add(Version.fromString(node.version()));
            }
        }
    }

    @Override
    protected String getProtocol() {
        return isHttps() ? "https" : "http";
    }

    @Override
    protected RestClient buildClient(Settings settings, HttpHost[] hosts) throws IOException {
        RestClientBuilder builder = RestClient.builder(hosts);

        if (isHttps()) {
            builder.setHttpClientConfigCallback(httpClientBuilder -> {
                String userName = Optional.ofNullable(System.getProperty("user")).orElse("admin");
                String password = Optional.ofNullable(System.getProperty("password")).orElse("admin");
    
                final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                for (final HttpHost host: hosts) {
                    credentialsProvider.setCredentials(new AuthScope(host),
                        new UsernamePasswordCredentials(userName, password.toCharArray()));
                }
    
                try {
                    final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder
                        .create()
                        .setSslContext(SSLContextBuilder.create().loadTrustMaterial(null, (chains, authType) -> true).build())
                        // disable the certificate since our testing cluster just uses the default security configuration
                        .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                        // See please https://issues.apache.org/jira/browse/HTTPCLIENT-2219
                        .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
                            @Override
                            public TlsDetails create(final SSLEngine sslEngine) {
                                return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
                            }
                        })
                        .build();
    
                    final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                        .setTlsStrategy(tlsStrategy)
                        .build();
    
                    return httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider)
                        .setConnectionManager(connectionManager);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        builder.setStrictDeprecationMode(true);
        return builder.build();
    }

    protected static OpenSearchClient javaClient() {
        return javaClient;
    }

    protected static OpenSearchClient adminJavaClient() {
        return adminJavaClient;
    }

    protected String getTestRestCluster() {
        String cluster = System.getProperty("tests.rest.cluster");
        if (cluster == null) {
            cluster = "localhost:9200";
        }
        return cluster;
    }

    @After
    protected void wipeAllOSIndices() throws IOException {
        final IndicesResponse response = adminJavaClient()
            .cat()
            .indices(r -> r.headers("index,creation.date").expandWildcards(ExpandWildcard.All));

        for (IndicesRecord index : response.valueBody()) {
            if (index.index() != null && !".opendistro_security".equals(index.index())) {
                adminJavaClient().indices().delete(new DeleteIndexRequest.Builder().index(index.index()).build());
            }
        }
    }

    @AfterClass
    public static void cleanupJavaClient() throws IOException {
        try {
            if (javaClient != null) {
                IOUtils.close(javaClient._transport());
            }
            
            if (adminJavaClient != null) {
                IOUtils.close(adminJavaClient._transport());
            }
        } finally {
            clusterHosts = null;
            javaClient = null;
            adminJavaClient = null;
            nodeVersions = null;
        }
    }

    @Override
    protected boolean preserveIndicesUponCompletion() {
        return true;
    }
} 