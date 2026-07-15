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
import org.opensearch.client.json.jackson3.JacksonJsonpMapper;
import org.opensearch.client.opensearch.integTest.OpenSearchTransportSupport;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.GrpcTransportOptions;
import org.opensearch.client.transport.grpc.HybridTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.opensearch.common.settings.Settings;

/**
 * Transport support for gRPC integration tests.
 * <p>
 * Builds a {@link HybridTransport} that routes Bulk over gRPC and everything else over REST.
 * Used as a mixin interface on concrete test classes (same pattern as {@code HttpClient5TransportSupport}).
 */
interface GrpcTransportSupport extends OpenSearchTransportSupport {

    @Override
    default OpenSearchTransport buildTransport(Settings settings, HttpHost[] hosts) throws IOException {
        // Build REST transport for non-bulk operations
        final OpenSearchTransport restTransport = ApacheHttpClient5TransportBuilder.builder(hosts).build();

        // Determine gRPC host/port from system property or derive from REST host
        String grpcCluster = System.getProperty("tests.grpc.cluster");
        String grpcHost;
        int grpcPort;

        if (grpcCluster != null && !grpcCluster.isEmpty()) {
            String[] parts = grpcCluster.split(":");
            grpcHost = parts[0];
            grpcPort = Integer.parseInt(parts[1]);
        } else {
            // Default: same host as REST, port 9400
            grpcHost = hosts[0].getHostName();
            grpcPort = GrpcTestContainerRule.GRPC_PORT;
        }

        // Build gRPC transport
        GrpcTransport grpcTransport = GrpcTransport.builder(grpcHost, grpcPort)
            .jsonpMapper(new JacksonJsonpMapper())
            .grpcOptions(GrpcTransportOptions.builder().maxRetries(2).build())
            .build();

        return new HybridTransport(grpcTransport, restTransport);
    }
}
