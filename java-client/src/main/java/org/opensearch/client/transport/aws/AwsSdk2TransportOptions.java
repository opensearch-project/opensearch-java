/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.aws;

import java.time.Clock;
import java.util.List;
import java.util.function.Function;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public interface AwsSdk2TransportOptions extends TransportOptions {

    /**
     * Get the credentials provider to user for signing requests.
     * <p>
     * If this is null, then a default provider will be used -- either a provider specified
     * in a more general {@link AwsSdk2TransportOptions} that applies to the request, or the
     * default credential chain if there is none.
     * </P>
     *
     * @return A credentials provider or null
     */
    AwsCredentialsProvider credentials();

    /**
     * Get the maximum size for uncompressed requests.  Requests larger than this size will
     * be sent with Content-Encoding: gzip.
     * <p>
     * If this is null, then a default will be used -- either a value specified
     * in a more general {@link AwsSdk2TransportOptions} that applies to the request, or a
     * reasonable default if there is none.
     * </P><P>
     * If this is Integer.MAX_VALUE, then requests will not be compressed.  If this is 0, then all non-empty
     * request bodies will be compressed.
     * </P>
     *
     * @return An integer size limit or null
     */
    Integer requestCompressionSize();

    /**
     * Get the response compression enable/disable value.  If this is true, then an
     * Accept-Encoding: gzip header will be sent with the request.  The server will
     * decide whether or not to compress its responses.
     * <p>
     * If this is null, then a default will be used -- either a value specified
     * in a more general {@link AwsSdk2TransportOptions} that applies to the request, or
     * {@link Boolean#TRUE} if there is none.
     * </P>
     *
     * @return response compression enable/disable flag, or null
     */
    Boolean responseCompression();

    /**
     * Get mapper used for serializing and deserializing requests and responses.
     * <p>
     * If this is null, then a default will be used -- either a value specified
     * in a more general {@link AwsSdk2TransportOptions} that applies to the request, or a
     * new {@link org.opensearch.client.json.jackson.JacksonJsonpMapper} or equivalent if
     * there is none.
     * </P>
     *
     * @return A mapper or null
     */
    JsonpMapper mapper();

    /**
     * Get the clock used for signing requests.
     * <p>
     * If this is null, then a default will be used -- either a value specified
     * in a more general {@link AwsSdk2TransportOptions} that applies to the request, or
     * {@link Clock#systemUTC()} if there is none.
     * </P>
     *
     * @return A clock or null
     */
    Clock signingClock();

    AwsSdk2TransportOptions.Builder toBuilder();

    static AwsSdk2TransportOptions.Builder builder() {
        return new BuilderImpl();
    }

    interface Builder extends TransportOptions.Builder {
        Builder addHeader(String name, String value);

        Builder setParameter(String name, String value);

        Builder onWarnings(Function<List<String>, Boolean> listener);

        Builder setCredentials(AwsCredentialsProvider credentials);

        Builder setRequestCompressionSize(Integer size);

        Builder setResponseCompression(Boolean enabled);

        Builder setMapper(JsonpMapper mapper);

        Builder setSigningClock(Clock clock);

        AwsSdk2TransportOptions build();
    }

    class BuilderImpl extends TransportOptions.BuilderImpl implements Builder {

        protected AwsCredentialsProvider credentials;
        protected Integer requestCompressionSize;
        protected Boolean responseCompression;
        protected JsonpMapper mapper;
        protected Clock signingClock;

        public BuilderImpl() {}

        public BuilderImpl(AwsSdk2TransportOptions src) {
            super(src);
            credentials = src.credentials();
            requestCompressionSize = src.requestCompressionSize();
            responseCompression = src.responseCompression();
            mapper = src.mapper();
            signingClock = src.signingClock();
        }

        @Override
        public Builder addHeader(String name, String value) {
            super.addHeader(name, value);
            return this;
        }

        @Override
        public Builder setParameter(String name, String value) {
            super.setParameter(name, value);
            return this;
        }

        @Override
        public Builder onWarnings(Function<List<String>, Boolean> listener) {
            super.onWarnings(listener);
            return this;
        }

        @Override
        public Builder setCredentials(AwsCredentialsProvider credentials) {
            this.credentials = credentials;
            return this;
        }

        @Override
        public Builder setRequestCompressionSize(Integer size) {
            this.requestCompressionSize = size;
            return this;
        }

        @Override
        public Builder setMapper(JsonpMapper mapper) {
            this.mapper = mapper;
            return this;
        }

        @Override
        public Builder setResponseCompression(Boolean enabled) {
            this.responseCompression = enabled;
            return this;
        }

        @Override
        public Builder setSigningClock(Clock clock) {
            this.signingClock = clock;
            return this;
        }

        @Override
        public AwsSdk2TransportOptions build() {
            return new DefaultImpl(this);
        }
    }

    class DefaultImpl extends TransportOptions.DefaultImpl implements AwsSdk2TransportOptions {

        private final AwsCredentialsProvider credentials;
        private final Integer requestCompressionSize;
        private final Boolean responseCompression;
        private final JsonpMapper mapper;
        private final Clock signingClock;

        DefaultImpl(AwsSdk2TransportOptions.BuilderImpl builder) {
            super(builder);
            credentials = builder.credentials;
            requestCompressionSize = builder.requestCompressionSize;
            responseCompression = builder.responseCompression;
            mapper = builder.mapper;
            signingClock = builder.signingClock;
        }

        @Override
        public AwsCredentialsProvider credentials() {
            return credentials;
        }

        @Override
        public Integer requestCompressionSize() {
            return requestCompressionSize;
        }

        @Override
        public Boolean responseCompression() {
            return responseCompression;
        }

        @Override
        public JsonpMapper mapper() {
            return mapper;
        }

        @Override
        public Clock signingClock() {
            return signingClock;
        }

        @Override
        public AwsSdk2TransportOptions.Builder toBuilder() {
            return new AwsSdk2TransportOptions.BuilderImpl(this);
        }
    }
}
