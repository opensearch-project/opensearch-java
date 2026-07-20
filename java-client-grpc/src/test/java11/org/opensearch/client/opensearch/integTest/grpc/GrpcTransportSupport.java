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
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.GrpcTransportOptions;
import org.opensearch.client.transport.grpc.HybridTransport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

/**
 * Utility for building a HybridTransport (gRPC + REST) in integration tests.
 * <p>
 * Self-contained — does not depend on internal test framework interfaces from java-client.
 */
final class GrpcTransportSupport {

    private GrpcTransportSupport() {}

    /**
     * Builds a HybridTransport that routes Bulk over gRPC and everything else over REST.
     *
     * @param restHost the REST host (typically from testcontainers)
     * @param grpcHost the gRPC hostname
     * @param grpcPort the gRPC port
     */
    static OpenSearchTransport buildHybridTransport(HttpHost restHost, String grpcHost, int grpcPort) throws IOException {
        OpenSearchTransport restTransport = ApacheHttpClient5TransportBuilder.builder(restHost).build();

        GrpcTransport grpcTransport = GrpcTransport.builder(grpcHost, grpcPort)
            .jsonpMapper(new JacksonJsonpMapper())
            .grpcOptions(GrpcTransportOptions.builder().maxRetries(2).build())
            .build();

        return new HybridTransport(grpcTransport, restTransport);
    }
}
