/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.ManagedChannel;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.transport.TransportOptions;

/**
 * AWS-specific gRPC transport that adds SigV4 signing to the gRPC channel.
 * <p>
 * This follows the same pattern as {@code AwsSdk2Transport} vs
 * {@code ApacheHttpClient5Transport} — separating general transport from
 * AWS-specific authentication.
 * <p>
 * Usage:
 * <pre>{@code
 * var grpcTransport = AwsGrpcTransport.builder("domain.us-east-1.es.amazonaws.com", 9400)
 *     .jsonpMapper(new JacksonJsonpMapper())
 *     .tls(GrpcTlsConfig.builder().build())
 *     .sigV4(GrpcSigV4Config.builder()
 *         .region(Region.US_EAST_1)
 *         .service("es")
 *         .credentialsProvider(DefaultCredentialsProvider.create())
 *         .build())
 *     .build();
 * }</pre>
 */
public class AwsGrpcTransport extends GrpcTransport {

    private final GrpcSigV4Interceptor sigV4Interceptor;

    AwsGrpcTransport(ManagedChannel channel, JsonpMapper jsonpMapper,
                     GrpcTransportOptions grpcOptions, @Nullable TransportOptions transportOptions,
                     GrpcSigV4Interceptor sigV4Interceptor) {
        super(channel, jsonpMapper, grpcOptions, transportOptions);
        this.sigV4Interceptor = sigV4Interceptor;
    }

    @Override
    protected void preProcessBulk(org.opensearch.protobufs.BulkRequest protoRequest) {
        if (sigV4Interceptor != null) {
            String payloadHash = GrpcSigV4Interceptor.computePayloadHash(protoRequest.toByteArray());
            sigV4Interceptor.setPayloadHash(payloadHash);
        }
    }

    /**
     * Creates a builder for AwsGrpcTransport.
     *
     * @param host the gRPC server hostname
     * @param port the gRPC server port (default: 9400)
     */
    public static Builder awsBuilder(String host, int port) {
        return new Builder(host, port);
    }

    public static final class Builder {
        private final String host;
        private final int port;
        private JsonpMapper jsonpMapper;
        private GrpcTransportOptions grpcOptions = GrpcTransportOptions.defaults();
        private TransportOptions transportOptions;
        private GrpcTlsConfig tlsConfig;
        private GrpcSigV4Config sigV4Config;
        private ManagedChannel channel;

        Builder(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public Builder jsonpMapper(JsonpMapper mapper) {
            this.jsonpMapper = mapper;
            return this;
        }

        public Builder grpcOptions(GrpcTransportOptions options) {
            this.grpcOptions = options;
            return this;
        }

        public Builder transportOptions(TransportOptions options) {
            this.transportOptions = options;
            return this;
        }

        /**
         * Configures TLS for the gRPC channel. Required for SigV4.
         */
        public Builder tls(GrpcTlsConfig tlsConfig) {
            this.tlsConfig = tlsConfig;
            return this;
        }

        /**
         * Configures AWS SigV4 signing for the gRPC channel.
         * TLS is required when using SigV4.
         *
         * @param sigV4Config the SigV4 configuration (region, service, credentials)
         */
        public Builder sigV4(GrpcSigV4Config sigV4Config) {
            this.sigV4Config = sigV4Config;
            return this;
        }

        /**
         * Inject a pre-built channel (primarily for testing).
         */
        public Builder channel(ManagedChannel channel) {
            this.channel = channel;
            return this;
        }

        public AwsGrpcTransport build() {
            if (jsonpMapper == null) {
                throw new IllegalArgumentException("jsonpMapper is required");
            }
            if (sigV4Config == null) {
                throw new IllegalArgumentException("sigV4 config is required for AwsGrpcTransport. Use GrpcTransport for non-AWS usage.");
            }
            if (tlsConfig == null) {
                throw new IllegalStateException(
                    "TLS is required when using SigV4 signing. Configure TLS with .tls() before .sigV4()."
                );
            }

            ManagedChannel ch = this.channel;
            GrpcSigV4Interceptor sigV4InterceptorRef = null;

            if (ch == null) {
                java.util.List<io.grpc.ClientInterceptor> interceptors = new java.util.ArrayList<>();

                sigV4InterceptorRef = new GrpcSigV4Interceptor(sigV4Config, host);
                interceptors.add(sigV4InterceptorRef);

                try {
                    ch = GrpcChannelFactory.createChannel(host, port, tlsConfig, grpcOptions, interceptors);
                } catch (java.io.IOException e) {
                    throw new IllegalStateException("Failed to create gRPC channel: " + e.getMessage(), e);
                }
            }

            return new AwsGrpcTransport(ch, jsonpMapper, grpcOptions, transportOptions, sigV4InterceptorRef);
        }
    }
}
