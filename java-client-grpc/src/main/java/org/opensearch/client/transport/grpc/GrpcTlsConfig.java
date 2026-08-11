/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import javax.annotation.Nullable;

/**
 * TLS configuration for gRPC channels.
 * <p>
 * Supports three main scenarios:
 * <ul>
 *   <li><b>Trusted CA</b> — trust a specific CA certificate (truststore or PEM file)</li>
 *   <li><b>Mutual TLS (mTLS)</b> — client certificate + key for client authentication</li>
 *   <li><b>Insecure</b> — trust all certificates (for development/testing only)</li>
 * </ul>
 * <p>
 * Usage:
 * <pre>{@code
 * // Trust a CA certificate file
 * GrpcTlsConfig tls = GrpcTlsConfig.builder()
 *     .trustCertificatePath("/path/to/ca.pem")
 *     .build();
 *
 * // Mutual TLS with client cert
 * GrpcTlsConfig tls = GrpcTlsConfig.builder()
 *     .trustCertificatePath("/path/to/ca.pem")
 *     .clientCertificatePath("/path/to/client.pem")
 *     .clientKeyPath("/path/to/client-key.pem")
 *     .build();
 *
 * // Insecure (trust all - development only)
 * GrpcTlsConfig tls = GrpcTlsConfig.builder()
 *     .insecure(true)
 *     .build();
 * }</pre>
 *
 * @see <a href="https://docs.opensearch.org/latest/security/configuration/tls/">OpenSearch TLS Configuration</a>
 */
public final class GrpcTlsConfig {

    private final boolean enabled;
    private final boolean insecure;
    private final String trustCertificatePath;
    private final String clientCertificatePath;
    private final String clientKeyPath;
    private final String clientKeyPassword;
    private final String trustStorePath;
    private final String trustStorePassword;
    private final String trustStoreType;
    private final String hostnameOverride;

    private GrpcTlsConfig(Builder builder) {
        this.enabled = builder.enabled;
        this.insecure = builder.insecure;
        this.trustCertificatePath = builder.trustCertificatePath;
        this.clientCertificatePath = builder.clientCertificatePath;
        this.clientKeyPath = builder.clientKeyPath;
        this.clientKeyPassword = builder.clientKeyPassword;
        this.trustStorePath = builder.trustStorePath;
        this.trustStorePassword = builder.trustStorePassword;
        this.trustStoreType = builder.trustStoreType;
        this.hostnameOverride = builder.hostnameOverride;
    }

    /**
     * Whether TLS is enabled. Default: true when this config is used.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Whether to trust all certificates without verification.
     * <b>WARNING: Only use for development/testing.</b>
     */
    public boolean isInsecure() {
        return insecure;
    }

    /**
     * Path to a PEM-encoded CA certificate file to trust.
     * Used for verifying the server's certificate.
     */
    @Nullable
    public String trustCertificatePath() {
        return trustCertificatePath;
    }

    /**
     * Path to a PEM-encoded client certificate file for mTLS.
     */
    @Nullable
    public String clientCertificatePath() {
        return clientCertificatePath;
    }

    /**
     * Path to the client's private key file (PEM-encoded) for mTLS.
     */
    @Nullable
    public String clientKeyPath() {
        return clientKeyPath;
    }

    /**
     * Password for the client private key, if encrypted. May be null.
     */
    @Nullable
    public String clientKeyPassword() {
        return clientKeyPassword;
    }

    /**
     * Path to a Java KeyStore (JKS/PKCS12) trust store file.
     * Alternative to {@link #trustCertificatePath()} for Java-native trust stores.
     */
    @Nullable
    public String trustStorePath() {
        return trustStorePath;
    }

    /**
     * Password for the trust store.
     */
    @Nullable
    public String trustStorePassword() {
        return trustStorePassword;
    }

    /**
     * Trust store type (e.g., "JKS", "PKCS12"). Default: "JKS".
     */
    public String trustStoreType() {
        return trustStoreType;
    }

    /**
     * Override the hostname used for TLS certificate verification.
     * <p>
     * Useful when connecting to a server via IP address or a different hostname
     * than what appears in the server's certificate SAN (Subject Alternative Name).
     * <p>
     * Example: connecting to {@code 10.0.0.1:9400} but the cert has SAN {@code my-cluster.example.com}:
     * <pre>{@code
     * GrpcTlsConfig.builder()
     *     .hostnameOverride("my-cluster.example.com")
     *     .build();
     * }</pre>
     *
     * @return the hostname to verify against, or null to use the connection hostname (default)
     */
    @Nullable
    public String hostnameOverride() {
        return hostnameOverride;
    }

    /**
     * Returns a simple TLS config that trusts all certificates (insecure).
     * For development and testing only.
     */
    public static GrpcTlsConfig insecure() {
        return new Builder().insecure(true).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private boolean enabled = true;
        private boolean insecure = false;
        private String trustCertificatePath;
        private String clientCertificatePath;
        private String clientKeyPath;
        private String clientKeyPassword;
        private String trustStorePath;
        private String trustStorePassword;
        private String trustStoreType = "JKS";
        private String hostnameOverride;

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Trust all certificates without verification.
         * <b>WARNING: Only use for development/testing.</b>
         */
        public Builder insecure(boolean insecure) {
            this.insecure = insecure;
            return this;
        }

        /**
         * Path to a PEM-encoded CA certificate to trust.
         */
        public Builder trustCertificatePath(String path) {
            this.trustCertificatePath = path;
            return this;
        }

        /**
         * Path to PEM-encoded client certificate for mTLS.
         */
        public Builder clientCertificatePath(String path) {
            this.clientCertificatePath = path;
            return this;
        }

        /**
         * Path to PEM-encoded client private key for mTLS.
         */
        public Builder clientKeyPath(String path) {
            this.clientKeyPath = path;
            return this;
        }

        /**
         * Password for the client key, if encrypted.
         */
        public Builder clientKeyPassword(String password) {
            this.clientKeyPassword = password;
            return this;
        }

        /**
         * Path to a Java KeyStore trust store (JKS or PKCS12).
         */
        public Builder trustStorePath(String path) {
            this.trustStorePath = path;
            return this;
        }

        /**
         * Password for the trust store.
         */
        public Builder trustStorePassword(String password) {
            this.trustStorePassword = password;
            return this;
        }

        /**
         * Trust store type. Default: "JKS". Set to "PKCS12" for .p12 files.
         */
        public Builder trustStoreType(String type) {
            this.trustStoreType = type;
            return this;
        }

        /**
         * Override the hostname used for TLS certificate hostname verification.
         * <p>
         * Maps to gRPC's {@code NettyChannelBuilder.overrideAuthority()}.
         * Use when connecting via IP but the server cert has a DNS name in SAN.
         *
         * @param hostname the hostname to verify the certificate against
         */
        public Builder hostnameOverride(String hostname) {
            this.hostnameOverride = hostname;
            return this;
        }

        public GrpcTlsConfig build() {
            if (!insecure && trustCertificatePath == null && trustStorePath == null) {
                // No explicit trust config — will use system default trust store
            }
            if (clientCertificatePath != null && clientKeyPath == null) {
                throw new IllegalArgumentException("clientKeyPath is required when clientCertificatePath is set");
            }
            return new GrpcTlsConfig(this);
        }
    }
}
