/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.grpc;

import java.io.IOException;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Assume;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.InfoResponse;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.GrpcTransportOptions;
import org.opensearch.client.transport.grpc.HybridTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

/**
 * Base class for gRPC integration tests.
 * <p>
 * Self-contained — does not depend on internal test framework classes from java-client.
 * Uses {@link OpenSearchGrpcTestContainerRule} to start an OpenSearch container with gRPC enabled,
 * then creates a {@link HybridTransport} that routes bulk over gRPC and everything else over REST.
 * <p>
 * Subclasses get access to:
 * <ul>
 *   <li>{@link #grpcClient()} — OpenSearchClient using HybridTransport (bulk → gRPC, rest → REST)</li>
 *   <li>{@link #getGrpcHost()} — gRPC hostname</li>
 *   <li>{@link #getGrpcPort()} — gRPC mapped port</li>
 * </ul>
 * <p>
 * All tests automatically skip if the server version is below 3.5.0 (gRPC not available).
 */
@RunWith(JUnit4.class)
public abstract class AbstractGrpcIT {

    private static final int GRPC_MIN_MAJOR = 3;
    private static final int GRPC_MIN_MINOR = 5;

    @ClassRule
    public static final OpenSearchGrpcTestContainerRule grpcContainer = new OpenSearchGrpcTestContainerRule();

    private static OpenSearchClient grpcClient;

    @Before
    public void initGrpcClient() throws IOException {
        if (grpcClient == null) {
            String grpcCluster = System.getProperty("tests.grpc.cluster");
            if (grpcCluster == null) {
                // Use REST host with default gRPC port if not explicitly configured
                String restCluster = getRestCluster();
                String host = restCluster.split(":")[0];
                grpcCluster = host + ":" + OpenSearchGrpcTestContainerRule.GRPC_PORT;
            }

            String[] parts = grpcCluster.split(":");
            String grpcHost = parts[0];
            int grpcPort = Integer.parseInt(parts[1]);

            // Build REST transport
            String restCluster = getRestCluster();
            String[] restParts = restCluster.split(":");
            HttpHost restHost = new HttpHost("http", restParts[0], Integer.parseInt(restParts[1]));
            OpenSearchTransport restTransport = ApacheHttpClient5TransportBuilder.builder(restHost).build();

            // Build gRPC transport
            GrpcTransport grpcTransport = GrpcTransport.builder(grpcHost, grpcPort)
                .jsonpMapper(new JacksonJsonpMapper())
                .grpcOptions(GrpcTransportOptions.builder().maxRetries(2).build())
                .build();

            // Combine into HybridTransport
            HybridTransport hybridTransport = new HybridTransport(grpcTransport, restTransport);
            grpcClient = new OpenSearchClient(hybridTransport);
        }
    }

    /**
     * Returns the REST cluster address from system properties.
     */
    private String getRestCluster() {
        String cluster = System.getProperty("tests.rest.cluster");
        if (cluster == null || cluster.isBlank()) {
            return "localhost:9200";
        }
        return cluster;
    }

    /**
     * Returns the OpenSearch client configured with HybridTransport (gRPC + REST).
     */
    protected static OpenSearchClient grpcClient() {
        return grpcClient;
    }

    /**
     * Returns the gRPC host from system properties.
     */
    protected String getGrpcHost() {
        String grpcCluster = System.getProperty("tests.grpc.cluster", "localhost:9400");
        return grpcCluster.split(":")[0];
    }

    /**
     * Returns the gRPC port from system properties.
     */
    protected int getGrpcPort() {
        String grpcCluster = System.getProperty("tests.grpc.cluster", "localhost:9400");
        return Integer.parseInt(grpcCluster.split(":")[1]);
    }

    /**
     * Checks that the server version supports gRPC (3.5.0+).
     * Call this at the top of each test method:
     * <pre>
     * assumeGrpcSupported();
     * </pre>
     */
    protected void assumeGrpcSupported() throws IOException {
        InfoResponse info = grpcClient().info();
        String version = info.version().number();
        String[] versionParts = version.split("\\.");
        int major = Integer.parseInt(versionParts[0]);
        int minor = Integer.parseInt(versionParts[1]);

        Assume.assumeTrue(
            "gRPC transport requires OpenSearch 3.5.0+, but server is " + version,
            major > GRPC_MIN_MAJOR || (major == GRPC_MIN_MAJOR && minor >= GRPC_MIN_MINOR)
        );

        // Also verify gRPC port is actually reachable
        try {
            java.net.Socket socket = new java.net.Socket();
            socket.connect(new java.net.InetSocketAddress(getGrpcHost(), getGrpcPort()), 2000);
            socket.close();
        } catch (IOException e) {
            Assume.assumeTrue("gRPC port not reachable at " + getGrpcHost() + ":" + getGrpcPort(), false);
        }
    }
}
