/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;

/**
 * Factory that creates gRPC {@link ManagedChannel} instances configured for
 * either plaintext or TLS communication.
 * <p>
 * Uses gRPC-Netty's shaded SSL context for TLS channels, supporting:
 * <ul>
 *   <li>System default trust store (JVM cacerts)</li>
 *   <li>Custom CA certificate (PEM file)</li>
 *   <li>Custom trust store (JKS/PKCS12)</li>
 *   <li>Mutual TLS with client certificate</li>
 *   <li>Insecure mode (trust all — development only)</li>
 * </ul>
 */
public final class GrpcChannelFactory {

    private GrpcChannelFactory() {
        // utility class
    }

    /**
     * Creates a plaintext (unencrypted) gRPC channel.
     *
     * @param host       the server hostname
     * @param port       the server port
     * @param options    channel options (keepalive, max message size, etc.)
     * @param interceptors optional client interceptors (e.g., auth)
     * @return a configured ManagedChannel
     */
    public static ManagedChannel createPlaintextChannel(
        String host,
        int port,
        GrpcTransportOptions options,
        List<ClientInterceptor> interceptors
    ) {
        ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress(host, port).usePlaintext();

        applyOptions(builder, options);
        applyInterceptors(builder, interceptors);

        return builder.build();
    }

    /**
     * Creates a TLS-encrypted gRPC channel.
     *
     * @param host       the server hostname
     * @param port       the server port
     * @param tlsConfig  TLS configuration (certs, trust store, insecure mode)
     * @param options    channel options (keepalive, max message size, etc.)
     * @param interceptors optional client interceptors (e.g., auth)
     * @return a configured ManagedChannel with TLS
     * @throws IOException if SSL context creation fails
     */
    public static ManagedChannel createTlsChannel(
        String host,
        int port,
        GrpcTlsConfig tlsConfig,
        GrpcTransportOptions options,
        List<ClientInterceptor> interceptors
    ) throws IOException {
        SslContext sslContext = buildSslContext(tlsConfig);

        NettyChannelBuilder builder = NettyChannelBuilder.forAddress(host, port).sslContext(sslContext);

        // Hostname verification override — verify cert against a different hostname
        // than the one we're connecting to. Useful when connecting via IP.
        if (tlsConfig.hostnameOverride() != null) {
            builder.overrideAuthority(tlsConfig.hostnameOverride());
        }

        applyOptions(builder, options);
        applyInterceptors(builder, interceptors);

        return builder.build();
    }

    /**
     * Creates a channel based on configuration — TLS if config is provided, plaintext otherwise.
     *
     * @param host         the server hostname
     * @param port         the server port
     * @param tlsConfig    TLS configuration, or null for plaintext
     * @param options      channel options
     * @param interceptors client interceptors
     * @return a configured ManagedChannel
     * @throws IOException if TLS context creation fails
     */
    public static ManagedChannel createChannel(
        String host,
        int port,
        @Nullable GrpcTlsConfig tlsConfig,
        GrpcTransportOptions options,
        List<ClientInterceptor> interceptors
    ) throws IOException {
        if (tlsConfig != null && tlsConfig.isEnabled()) {
            return createTlsChannel(host, port, tlsConfig, options, interceptors);
        }
        return createPlaintextChannel(host, port, options, interceptors);
    }

    // ─── SSL Context Builder ─────────────────────────────────────────────────────

    private static SslContext buildSslContext(GrpcTlsConfig config) throws IOException {
        try {
            SslContextBuilder sslBuilder = GrpcSslContexts.forClient();

            // Trust configuration
            if (config.isInsecure()) {
                // Trust all certificates — development only
                sslBuilder.trustManager(InsecureTrustManagerFactory.INSTANCE);
            } else if (config.trustCertificatePath() != null) {
                // Trust a specific CA certificate (PEM file)
                sslBuilder.trustManager(new File(config.trustCertificatePath()));
            } else if (config.trustStorePath() != null) {
                // Trust from a Java KeyStore
                TrustManagerFactory tmf = buildTrustManagerFactory(config);
                sslBuilder.trustManager(tmf);
            }
            // else: use system default trust store (JVM cacerts)

            // Client certificate for mutual TLS
            if (config.clientCertificatePath() != null && config.clientKeyPath() != null) {
                File certFile = new File(config.clientCertificatePath());
                File keyFile = new File(config.clientKeyPath());
                if (config.clientKeyPassword() != null) {
                    sslBuilder.keyManager(certFile, keyFile, config.clientKeyPassword());
                } else {
                    sslBuilder.keyManager(certFile, keyFile);
                }
            }

            return sslBuilder.build();
        } catch (SSLException e) {
            throw new IOException("Failed to build SSL context for gRPC channel", e);
        }
    }

    private static TrustManagerFactory buildTrustManagerFactory(GrpcTlsConfig config) throws IOException {
        try {
            KeyStore trustStore = KeyStore.getInstance(config.trustStoreType());
            try (FileInputStream fis = new FileInputStream(config.trustStorePath())) {
                char[] password = config.trustStorePassword() != null ? config.trustStorePassword().toCharArray() : null;
                trustStore.load(fis, password);
            }
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            return tmf;
        } catch (Exception e) {
            throw new IOException("Failed to load trust store: " + config.trustStorePath(), e);
        }
    }

    // ─── Channel Configuration ───────────────────────────────────────────────────

    private static void applyOptions(ManagedChannelBuilder<?> builder, GrpcTransportOptions options) {
        if (options.maxInboundMessageSize() > 0) {
            builder.maxInboundMessageSize(options.maxInboundMessageSize());
        }
        if (options.keepAliveTimeMs() > 0) {
            builder.keepAliveTime(options.keepAliveTimeMs(), TimeUnit.MILLISECONDS);
        }
        if (options.keepAliveTimeoutMs() > 0) {
            builder.keepAliveTimeout(options.keepAliveTimeoutMs(), TimeUnit.MILLISECONDS);
        }
        builder.keepAliveWithoutCalls(options.keepAliveWithoutCalls());
        if (options.idleTimeoutMs() > 0) {
            builder.idleTimeout(options.idleTimeoutMs(), TimeUnit.MILLISECONDS);
        }
    }

    private static void applyInterceptors(ManagedChannelBuilder<?> builder, List<ClientInterceptor> interceptors) {
        if (interceptors != null && !interceptors.isEmpty()) {
            builder.intercept(interceptors);
        }
    }
}
