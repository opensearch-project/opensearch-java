/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.Refresh;
import org.opensearch.client.opensearch.core.BulkRequest;
import org.opensearch.client.opensearch.core.BulkResponse;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.IndexOperation;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.aws.AwsSdk2Transport;
import org.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import org.opensearch.client.transport.grpc.AwsGrpcTransport;
import org.opensearch.client.transport.grpc.GrpcSigV4Config;
import org.opensearch.client.transport.grpc.GrpcTlsConfig;
import org.opensearch.client.transport.grpc.GrpcTransport;
import org.opensearch.client.transport.grpc.HybridTransport;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;

/**
 * Demonstrates using gRPC with AWS SigV4 signing against Amazon OpenSearch Service.
 * <p>
 * This shows how to configure:
 * - gRPC transport with SigV4 authentication (for bulk)
 * - AwsSdk2Transport for REST (unsupported ops like search) (for search, info, etc.)
 * - Both using the same AWS credentials from the default provider chain
 * <p>
 * Prerequisites:
 * - An Amazon OpenSearch Service domain with gRPC enabled (OS 3.5+)
 * - AWS credentials configured (env vars, ~/.aws/credentials, or instance profile)
 * - IAM permissions for the OpenSearch domain
 * <p>
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=GrpcAwsSigV4}
 * <p>
 * Environment variables:
 * - OPENSEARCH_DOMAIN: domain endpoint (e.g., search-my-domain.us-east-1.es.amazonaws.com)
 * - AWS_REGION: AWS region (default: us-east-1)
 * - GRPC_PORT: gRPC port (default: 9400)
 */
public class GrpcAwsSigV4 {
    private static final Logger LOGGER = LogManager.getLogger(GrpcAwsSigV4.class);

    public static void main(String[] args) {
        try {
            var env = System.getenv();
            var domain = env.getOrDefault("OPENSEARCH_DOMAIN", "search-my-domain.us-east-1.es.amazonaws.com");
            var region = Region.of(env.getOrDefault("AWS_REGION", "us-east-1"));
            var grpcPort = Integer.parseInt(env.getOrDefault("GRPC_PORT", "9400"));
            var service = env.getOrDefault("OPENSEARCH_SERVICE", "es"); // "es" or "aoss"

            LOGGER.info("Connecting to {} in {} (service={})", domain, region, service);

            // ─── REST transport with SigV4 (for non-bulk operations) ─────────────

            SdkHttpClient httpClient = ApacheHttpClient.builder().build();
            OpenSearchTransport restTransport = new AwsSdk2Transport(
                httpClient,
                domain,
                service,
                region,
                AwsSdk2TransportOptions.builder().build()
            );

            // ─── gRPC transport with SigV4 (for bulk operations) ─────────────────

            GrpcTransport grpcTransport = AwsGrpcTransport.awsBuilder(domain, grpcPort)
                .jsonpMapper(new JacksonJsonpMapper())
                .tls(GrpcTlsConfig.builder().build())  // system trust store (AWS certs are in JVM cacerts)
                .sigV4(
                    GrpcSigV4Config.builder()
                        .region(region)
                        .service(service)
                        .credentialsProvider(DefaultCredentialsProvider.create())
                        .build()
                )
                .build();

            // ─── Combine into HybridTransport ────────────────────────────────────

            HybridTransport transport = new HybridTransport(grpcTransport, restTransport);
            OpenSearchClient client = new OpenSearchClient(transport);

            // ─── Use the client ──────────────────────────────────────────────────

            // info() → REST with SigV4
            var info = client.info();
            LOGGER.info("Connected: {} {}", info.version().distribution(), info.version().number());

            // bulk() → gRPC with SigV4
            final var indexName = "grpc-sigv4-sample";
            List<BulkOperation> ops = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                final int id = i;
                ops.add(
                    new BulkOperation.Builder().index(
                        new IndexOperation.Builder<GrpcBulk.SampleDoc>().index(indexName)
                            .id(String.valueOf(id))
                            .document(new GrpcBulk.SampleDoc("AWS Doc " + id, id * 2.0, id))
                            .build()
                    ).build()
                );
            }

            BulkResponse response = client.bulk(new BulkRequest.Builder().index(indexName).operations(ops).refresh(Refresh.True).build());
            LOGGER.info("Bulk via gRPC+SigV4: took={}ms, errors={}", response.took(), response.errors());

            // search() → REST with SigV4
            var search = client.search(s -> s.index(indexName).size(3), GrpcBulk.SampleDoc.class);
            LOGGER.info("Search via REST+SigV4: {} hits", search.hits().total().value());

            // cleanup
            client.indices().delete(r -> r.index(indexName));
            transport.close();
            httpClient.close();

            LOGGER.info("Done!");

        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage(), e);
        }
    }
}
