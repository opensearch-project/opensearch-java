/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.ClientConfig

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ClientConfig implements PlainJsonSerializable {

    @Nullable
    private final Integer connectionTimeout;

    @Nullable
    private final Integer maxConnection;

    @Nullable
    private final Integer maxRetryTimes;

    @Nullable
    private final Integer readTimeout;

    @Nullable
    private final Integer retryBackoffMillis;

    @Nullable
    private final String retryBackoffPolicy;

    @Nullable
    private final Integer retryTimeoutSeconds;

    // ---------------------------------------------------------------------------------------------

    private ClientConfig(Builder builder) {
        this.connectionTimeout = builder.connectionTimeout;
        this.maxConnection = builder.maxConnection;
        this.maxRetryTimes = builder.maxRetryTimes;
        this.readTimeout = builder.readTimeout;
        this.retryBackoffMillis = builder.retryBackoffMillis;
        this.retryBackoffPolicy = builder.retryBackoffPolicy;
        this.retryTimeoutSeconds = builder.retryTimeoutSeconds;
    }

    public static ClientConfig of(Function<ClientConfig.Builder, ObjectBuilder<ClientConfig>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code connection_timeout}
     */
    @Nullable
    public final Integer connectionTimeout() {
        return this.connectionTimeout;
    }

    /**
     * API name: {@code max_connection}
     */
    @Nullable
    public final Integer maxConnection() {
        return this.maxConnection;
    }

    /**
     * API name: {@code max_retry_times}
     */
    @Nullable
    public final Integer maxRetryTimes() {
        return this.maxRetryTimes;
    }

    /**
     * API name: {@code read_timeout}
     */
    @Nullable
    public final Integer readTimeout() {
        return this.readTimeout;
    }

    /**
     * API name: {@code retry_backoff_millis}
     */
    @Nullable
    public final Integer retryBackoffMillis() {
        return this.retryBackoffMillis;
    }

    /**
     * API name: {@code retry_backoff_policy}
     */
    @Nullable
    public final String retryBackoffPolicy() {
        return this.retryBackoffPolicy;
    }

    /**
     * API name: {@code retry_timeout_seconds}
     */
    @Nullable
    public final Integer retryTimeoutSeconds() {
        return this.retryTimeoutSeconds;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.connectionTimeout != null) {
            generator.writeKey("connection_timeout");
            generator.write(this.connectionTimeout);
        }

        if (this.maxConnection != null) {
            generator.writeKey("max_connection");
            generator.write(this.maxConnection);
        }

        if (this.maxRetryTimes != null) {
            generator.writeKey("max_retry_times");
            generator.write(this.maxRetryTimes);
        }

        if (this.readTimeout != null) {
            generator.writeKey("read_timeout");
            generator.write(this.readTimeout);
        }

        if (this.retryBackoffMillis != null) {
            generator.writeKey("retry_backoff_millis");
            generator.write(this.retryBackoffMillis);
        }

        if (this.retryBackoffPolicy != null) {
            generator.writeKey("retry_backoff_policy");
            generator.write(this.retryBackoffPolicy);
        }

        if (this.retryTimeoutSeconds != null) {
            generator.writeKey("retry_timeout_seconds");
            generator.write(this.retryTimeoutSeconds);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ClientConfig}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ClientConfig> {
        @Nullable
        private Integer connectionTimeout;
        @Nullable
        private Integer maxConnection;
        @Nullable
        private Integer maxRetryTimes;
        @Nullable
        private Integer readTimeout;
        @Nullable
        private Integer retryBackoffMillis;
        @Nullable
        private String retryBackoffPolicy;
        @Nullable
        private Integer retryTimeoutSeconds;

        /**
         * API name: {@code connection_timeout}
         */
        public final Builder connectionTimeout(@Nullable Integer value) {
            this.connectionTimeout = value;
            return this;
        }

        /**
         * API name: {@code max_connection}
         */
        public final Builder maxConnection(@Nullable Integer value) {
            this.maxConnection = value;
            return this;
        }

        /**
         * API name: {@code max_retry_times}
         */
        public final Builder maxRetryTimes(@Nullable Integer value) {
            this.maxRetryTimes = value;
            return this;
        }

        /**
         * API name: {@code read_timeout}
         */
        public final Builder readTimeout(@Nullable Integer value) {
            this.readTimeout = value;
            return this;
        }

        /**
         * API name: {@code retry_backoff_millis}
         */
        public final Builder retryBackoffMillis(@Nullable Integer value) {
            this.retryBackoffMillis = value;
            return this;
        }

        /**
         * API name: {@code retry_backoff_policy}
         */
        public final Builder retryBackoffPolicy(@Nullable String value) {
            this.retryBackoffPolicy = value;
            return this;
        }

        /**
         * API name: {@code retry_timeout_seconds}
         */
        public final Builder retryTimeoutSeconds(@Nullable Integer value) {
            this.retryTimeoutSeconds = value;
            return this;
        }

        /**
         * Builds a {@link ClientConfig}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public ClientConfig build() {
            _checkSingleUse();

            return new ClientConfig(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ClientConfig}
     */
    public static final JsonpDeserializer<ClientConfig> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ClientConfig::setupClientConfigDeserializer
    );

    protected static void setupClientConfigDeserializer(ObjectDeserializer<ClientConfig.Builder> op) {
        op.add(Builder::connectionTimeout, JsonpDeserializer.integerDeserializer(), "connection_timeout");
        op.add(Builder::maxConnection, JsonpDeserializer.integerDeserializer(), "max_connection");
        op.add(Builder::maxRetryTimes, JsonpDeserializer.integerDeserializer(), "max_retry_times");
        op.add(Builder::readTimeout, JsonpDeserializer.integerDeserializer(), "read_timeout");
        op.add(Builder::retryBackoffMillis, JsonpDeserializer.integerDeserializer(), "retry_backoff_millis");
        op.add(Builder::retryBackoffPolicy, JsonpDeserializer.stringDeserializer(), "retry_backoff_policy");
        op.add(Builder::retryTimeoutSeconds, JsonpDeserializer.integerDeserializer(), "retry_timeout_seconds");
    }
}
