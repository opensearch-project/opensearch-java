/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.transport.grpc;

import java.util.concurrent.TimeUnit;

/**
 * Configuration options for gRPC transport.
 * <p>
 * Maps to OpenSearch gRPC server settings:
 * <ul>
 *   <li>{@code grpc.netty.max_msg_size} → {@link #maxInboundMessageSize()}</li>
 *   <li>{@code grpc.netty.keepalive_timeout} → {@link #keepAliveTimeoutMs()}</li>
 *   <li>{@code grpc.netty.max_connection_idle} → {@link #idleTimeoutMs()}</li>
 * </ul>
 */
public final class GrpcTransportOptions {

    private final int maxInboundMessageSize;
    private final long keepAliveTimeMs;
    private final long keepAliveTimeoutMs;
    private final boolean keepAliveWithoutCalls;
    private final long idleTimeoutMs;
    private final long deadlineMs;
    private final int maxRetries;
    private final long retryBackoffMs;

    private GrpcTransportOptions(Builder builder) {
        this.maxInboundMessageSize = builder.maxInboundMessageSize;
        this.keepAliveTimeMs = builder.keepAliveTimeMs;
        this.keepAliveTimeoutMs = builder.keepAliveTimeoutMs;
        this.keepAliveWithoutCalls = builder.keepAliveWithoutCalls;
        this.idleTimeoutMs = builder.idleTimeoutMs;
        this.deadlineMs = builder.deadlineMs;
        this.maxRetries = builder.maxRetries;
        this.retryBackoffMs = builder.retryBackoffMs;
    }

    /**
     * Maximum inbound message size in bytes. Default: 10MB.
     * Corresponds to {@code grpc.netty.max_msg_size}.
     */
    public int maxInboundMessageSize() {
        return maxInboundMessageSize;
    }

    /**
     * Keep-alive ping interval in milliseconds. Default: disabled (0).
     */
    public long keepAliveTimeMs() {
        return keepAliveTimeMs;
    }

    /**
     * Keep-alive ping timeout in milliseconds. Default: 20000 (20s).
     */
    public long keepAliveTimeoutMs() {
        return keepAliveTimeoutMs;
    }

    /**
     * Whether to send keep-alive pings when no RPCs are active. Default: false.
     */
    public boolean keepAliveWithoutCalls() {
        return keepAliveWithoutCalls;
    }

    /**
     * Idle timeout in milliseconds before closing the channel. Default: disabled (0).
     * Corresponds to {@code grpc.netty.max_connection_idle}.
     */
    public long idleTimeoutMs() {
        return idleTimeoutMs;
    }

    /**
     * Per-RPC deadline in milliseconds. Default: 0 (no deadline).
     */
    public long deadlineMs() {
        return deadlineMs;
    }

    /**
     * Maximum number of retries on transient errors (UNAVAILABLE, DEADLINE_EXCEEDED).
     * Default: 3.
     */
    public int maxRetries() {
        return maxRetries;
    }

    /**
     * Initial retry backoff in milliseconds. Doubles on each retry. Default: 100ms.
     */
    public long retryBackoffMs() {
        return retryBackoffMs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GrpcTransportOptions defaults() {
        return new Builder().build();
    }

    public static final class Builder {
        private int maxInboundMessageSize = 10 * 1024 * 1024; // 10MB
        private long keepAliveTimeMs = 0; // disabled
        private long keepAliveTimeoutMs = 20_000; // 20s
        private boolean keepAliveWithoutCalls = false;
        private long idleTimeoutMs = 0; // disabled
        private long deadlineMs = 0; // no deadline
        private int maxRetries = 3;
        private long retryBackoffMs = 100;

        public Builder maxInboundMessageSize(int bytes) {
            this.maxInboundMessageSize = bytes;
            return this;
        }

        public Builder keepAliveTime(long duration, TimeUnit unit) {
            this.keepAliveTimeMs = unit.toMillis(duration);
            return this;
        }

        public Builder keepAliveTimeout(long duration, TimeUnit unit) {
            this.keepAliveTimeoutMs = unit.toMillis(duration);
            return this;
        }

        public Builder keepAliveWithoutCalls(boolean enable) {
            this.keepAliveWithoutCalls = enable;
            return this;
        }

        public Builder idleTimeout(long duration, TimeUnit unit) {
            this.idleTimeoutMs = unit.toMillis(duration);
            return this;
        }

        public Builder deadline(long duration, TimeUnit unit) {
            this.deadlineMs = unit.toMillis(duration);
            return this;
        }

        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        public Builder retryBackoff(long duration, TimeUnit unit) {
            this.retryBackoffMs = unit.toMillis(duration);
            return this;
        }

        public GrpcTransportOptions build() {
            return new GrpcTransportOptions(this);
        }
    }
}
