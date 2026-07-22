/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import javax.annotation.Nonnull;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;

/**
 * Configuration for AWS SigV4 signing of gRPC requests.
 * <p>
 * Required parameters:
 * <ul>
 *   <li>{@link #region()} — AWS region (e.g., us-east-1)</li>
 * </ul>
 * Optional parameters:
 * <ul>
 *   <li>{@link #service()} — signing service name, "es" (default) or "aoss" for Serverless</li>
 *   <li>{@link #credentialsProvider()} — AWS credential provider (default: DefaultCredentialsProvider)</li>
 * </ul>
 *
 * @see <a href="https://opensearch.org/blog/aws-sigv4-support-for-clients/">AWS SigV4 support for OpenSearch clients</a>
 */
public final class GrpcSigV4Config {

    private final Region region;
    private final String service;
    private final AwsCredentialsProvider credentialsProvider;

    private GrpcSigV4Config(Builder builder) {
        this.region = builder.region;
        this.service = builder.service;
        this.credentialsProvider = builder.credentialsProvider;
    }

    /**
     * The AWS region for signing (e.g., us-east-1, us-west-2).
     */
    @Nonnull
    public Region region() {
        return region;
    }

    /**
     * The AWS signing service name.
     * <ul>
     *   <li>"es" — Amazon OpenSearch Service (managed)</li>
     *   <li>"aoss" — Amazon OpenSearch Serverless</li>
     * </ul>
     * Default: "es"
     */
    @Nonnull
    public String service() {
        return service;
    }

    /**
     * The AWS credentials provider used to obtain signing credentials.
     * Default: {@link DefaultCredentialsProvider} (env vars, ~/.aws/credentials, instance profile, etc.)
     */
    @Nonnull
    public AwsCredentialsProvider credentialsProvider() {
        return credentialsProvider;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Region region;
        private String service = "es";
        private AwsCredentialsProvider credentialsProvider;

        /**
         * Sets the AWS region for signing. Required.
         */
        public Builder region(Region region) {
            this.region = region;
            return this;
        }

        /**
         * Sets the signing service name.
         * Use "es" for managed OpenSearch, "aoss" for Serverless.
         * Default: "es"
         */
        public Builder service(String service) {
            this.service = service;
            return this;
        }

        /**
         * Sets the AWS credentials provider.
         * Default: {@link DefaultCredentialsProvider}
         */
        public Builder credentialsProvider(AwsCredentialsProvider credentialsProvider) {
            this.credentialsProvider = credentialsProvider;
            return this;
        }

        public GrpcSigV4Config build() {
            if (region == null) {
                throw new IllegalArgumentException("region is required for SigV4 signing");
            }
            if (service == null || service.isEmpty()) {
                throw new IllegalArgumentException("service name cannot be empty");
            }
            if (credentialsProvider == null) {
                credentialsProvider = DefaultCredentialsProvider.create();
            }
            return new GrpcSigV4Config(this);
        }
    }
}
