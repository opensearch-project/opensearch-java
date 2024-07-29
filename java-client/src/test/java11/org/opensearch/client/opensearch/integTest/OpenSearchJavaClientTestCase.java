/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.opensearch.Version;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.opensearch.IOUtils;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.ExpandWildcard;
import org.opensearch.client.opensearch.cat.IndicesResponse;
import org.opensearch.client.opensearch.cat.indices.IndicesRecord;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.opensearch.indices.DeleteIndexRequest;
import org.opensearch.client.opensearch.nodes.NodesInfoResponse;
import org.opensearch.client.opensearch.nodes.info.NodeInfo;
import org.opensearch.common.settings.Settings;
import org.opensearch.test.rest.OpenSearchRestTestCase;

public abstract class OpenSearchJavaClientTestCase extends OpenSearchRestTestCase implements OpenSearchTransportSupport {
    private static final List<String> systemIndices = List.of(".opensearch-observability", ".opendistro_security", ".plugins-ml-config");
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
                hosts.add(new HttpHost(host, port, getProtocol()));
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
                for (final HttpHost host : hosts) {
                    credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));
                }

                try {
                    return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                        // disable the certificate since our testing cluster just uses the default security configuration
                        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                        .setSSLContext(SSLContextBuilder.create().loadTrustMaterial(null, (chains, authType) -> true).build());
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
        if (cluster == null || cluster.isEmpty()) {
            cluster = "localhost:9200";
        }
        return cluster;
    }

    @After
    protected void wipeAllOSIndices() throws IOException {
        // wipe all data streams first, otherwise deleting backing indices will encounter exception
        adminJavaClient().indices().deleteDataStream(b -> b.name("*"));

        // wipe all indices
        final IndicesResponse response = adminJavaClient().cat()
            .indices(r -> r.headers("index,creation.date").expandWildcards(ExpandWildcard.All));

        for (IndicesRecord index : response.valueBody()) {
            if (index.index() != null && !systemIndices.contains(index.index())) {
                adminJavaClient().indices().delete(new DeleteIndexRequest.Builder().index(index.index()).build());
            }
        }
    }

    @AfterClass
    public static void cleanupJavaClient() throws IOException {
        try {
            if (javaClient != null) {
                IOUtils.closeQueitly(javaClient._transport());
            }

            if (adminJavaClient != null) {
                IOUtils.closeQueitly(adminJavaClient._transport());
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

    protected Version getServerVersion() throws IOException {
        final InfoResponse info = javaClient().info();

        String version = info.version().number();
        if (version.contains("SNAPSHOT")) {
            version = version.split("-")[0];
        }

        return Version.fromString(version);
    }
}
