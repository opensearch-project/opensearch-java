/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.integTest.grpc;

import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import java.io.IOException;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Before;
import org.junit.ClassRule;
import org.opensearch.Version;
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.integTest.OpenSearchJavaClientTestCase;
import org.opensearch.client.opensearch.integTest.TestcontainersThreadFilter;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.GrpcTransportOptions;
import org.opensearch.client.transport.grpc.HybridTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

/**
 * Base class for gRPC integration tests.
 * <p>
 * Uses {@link GrpcTestContainerRule} to start an OpenSearch container with gRPC enabled,
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
@ThreadLeakFilters(filters = TestcontainersThreadFilter.class)
public abstract class AbstractGrpcIT extends OpenSearchJavaClientTestCase {

    private static final Version GRPC_MIN_VERSION = Version.fromString("3.5.0");

    @ClassRule
    public static final GrpcTestContainerRule grpcContainer = new GrpcTestContainerRule();

    private static OpenSearchClient grpcClient;

    @Before
    public void initGrpcClient() throws IOException {
        if (grpcClient == null) {
            String grpcCluster = System.getProperty("tests.grpc.cluster");
            if (grpcCluster == null) {
                // Fallback: use REST host with default gRPC port
                String restCluster = getTestRestCluster();
                String host = restCluster.split(":")[0];
                grpcCluster = host + ":" + GrpcTestContainerRule.GRPC_PORT;
            }

            String[] parts = grpcCluster.split(":");
            String grpcHost = parts[0];
            int grpcPort = Integer.parseInt(parts[1]);

            // Build REST transport
            String restCluster = getTestRestCluster();
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
        assumeTrue("gRPC transport is supported in OpenSearch 3.5.0 and later", getServerVersion().onOrAfter(GRPC_MIN_VERSION));
    }
}
