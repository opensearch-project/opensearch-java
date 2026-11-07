/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.MergesWarmerStats

/**
 * The statistics about segment-replication merge warmer operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MergesWarmerStats implements PlainJsonSerializable, ToCopyableBuilder<MergesWarmerStats.Builder, MergesWarmerStats> {

    @Nullable
    private final Long ongoingCount;

    @Nullable
    private final Long totalBytesReceived;

    @Nullable
    private final Long totalBytesSent;

    @Nullable
    private final Long totalFailureCount;

    @Nullable
    private final Long totalInvocationsCount;

    @Nullable
    private final Time totalReceiveTime;

    @Nullable
    private final Long totalReceiveTimeMillis;

    @Nullable
    private final String totalReceivedSize;

    @Nullable
    private final Time totalSendTime;

    @Nullable
    private final Long totalSendTimeMillis;

    @Nullable
    private final String totalSentSize;

    @Nullable
    private final Time totalTime;

    @Nullable
    private final Long totalTimeMillis;

    // ---------------------------------------------------------------------------------------------

    private MergesWarmerStats(Builder builder) {
        this.ongoingCount = builder.ongoingCount;
        this.totalBytesReceived = builder.totalBytesReceived;
        this.totalBytesSent = builder.totalBytesSent;
        this.totalFailureCount = builder.totalFailureCount;
        this.totalInvocationsCount = builder.totalInvocationsCount;
        this.totalReceiveTime = builder.totalReceiveTime;
        this.totalReceiveTimeMillis = builder.totalReceiveTimeMillis;
        this.totalReceivedSize = builder.totalReceivedSize;
        this.totalSendTime = builder.totalSendTime;
        this.totalSendTimeMillis = builder.totalSendTimeMillis;
        this.totalSentSize = builder.totalSentSize;
        this.totalTime = builder.totalTime;
        this.totalTimeMillis = builder.totalTimeMillis;
    }

    public static MergesWarmerStats of(Function<MergesWarmerStats.Builder, ObjectBuilder<MergesWarmerStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of currently ongoing merge warmer operations.
     * <p>
     * API name: {@code ongoing_count}
     * </p>
     */
    @Nullable
    public final Long ongoingCount() {
        return this.ongoingCount;
    }

    /**
     * The total number of bytes received during merge warmer operations.
     * <p>
     * API name: {@code total_bytes_received}
     * </p>
     */
    @Nullable
    public final Long totalBytesReceived() {
        return this.totalBytesReceived;
    }

    /**
     * The total number of bytes sent during merge warmer operations.
     * <p>
     * API name: {@code total_bytes_sent}
     * </p>
     */
    @Nullable
    public final Long totalBytesSent() {
        return this.totalBytesSent;
    }

    /**
     * The total number of failed merge warmer operations.
     * <p>
     * API name: {@code total_failure_count}
     * </p>
     */
    @Nullable
    public final Long totalFailureCount() {
        return this.totalFailureCount;
    }

    /**
     * The total number of merge warmer invocations.
     * <p>
     * API name: {@code total_invocations_count}
     * </p>
     */
    @Nullable
    public final Long totalInvocationsCount() {
        return this.totalInvocationsCount;
    }

    /**
     * The total amount of time spent receiving data during merge warmer operations.
     * <p>
     * API name: {@code total_receive_time}
     * </p>
     */
    @Nullable
    public final Time totalReceiveTime() {
        return this.totalReceiveTime;
    }

    /**
     * The total amount of time spent receiving data during merge warmer operations, in milliseconds.
     * <p>
     * API name: {@code total_receive_time_millis}
     * </p>
     */
    @Nullable
    public final Long totalReceiveTimeMillis() {
        return this.totalReceiveTimeMillis;
    }

    /**
     * The total number of bytes received during merge warmer operations, in a human-readable format.
     * <p>
     * API name: {@code total_received_size}
     * </p>
     */
    @Nullable
    public final String totalReceivedSize() {
        return this.totalReceivedSize;
    }

    /**
     * The total amount of time spent sending data during merge warmer operations.
     * <p>
     * API name: {@code total_send_time}
     * </p>
     */
    @Nullable
    public final Time totalSendTime() {
        return this.totalSendTime;
    }

    /**
     * The total amount of time spent sending data during merge warmer operations, in milliseconds.
     * <p>
     * API name: {@code total_send_time_millis}
     * </p>
     */
    @Nullable
    public final Long totalSendTimeMillis() {
        return this.totalSendTimeMillis;
    }

    /**
     * The total number of bytes sent during merge warmer operations, in a human-readable format.
     * <p>
     * API name: {@code total_sent_size}
     * </p>
     */
    @Nullable
    public final String totalSentSize() {
        return this.totalSentSize;
    }

    /**
     * The total amount of time spent on merge warmer operations.
     * <p>
     * API name: {@code total_time}
     * </p>
     */
    @Nullable
    public final Time totalTime() {
        return this.totalTime;
    }

    /**
     * The total amount of time spent on merge warmer operations, in milliseconds.
     * <p>
     * API name: {@code total_time_millis}
     * </p>
     */
    @Nullable
    public final Long totalTimeMillis() {
        return this.totalTimeMillis;
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
        if (this.ongoingCount != null) {
            generator.writeKey("ongoing_count");
            generator.write(this.ongoingCount);
        }

        if (this.totalBytesReceived != null) {
            generator.writeKey("total_bytes_received");
            generator.write(this.totalBytesReceived);
        }

        if (this.totalBytesSent != null) {
            generator.writeKey("total_bytes_sent");
            generator.write(this.totalBytesSent);
        }

        if (this.totalFailureCount != null) {
            generator.writeKey("total_failure_count");
            generator.write(this.totalFailureCount);
        }

        if (this.totalInvocationsCount != null) {
            generator.writeKey("total_invocations_count");
            generator.write(this.totalInvocationsCount);
        }

        if (this.totalReceiveTime != null) {
            generator.writeKey("total_receive_time");
            this.totalReceiveTime.serialize(generator, mapper);
        }

        if (this.totalReceiveTimeMillis != null) {
            generator.writeKey("total_receive_time_millis");
            generator.write(this.totalReceiveTimeMillis);
        }

        if (this.totalReceivedSize != null) {
            generator.writeKey("total_received_size");
            generator.write(this.totalReceivedSize);
        }

        if (this.totalSendTime != null) {
            generator.writeKey("total_send_time");
            this.totalSendTime.serialize(generator, mapper);
        }

        if (this.totalSendTimeMillis != null) {
            generator.writeKey("total_send_time_millis");
            generator.write(this.totalSendTimeMillis);
        }

        if (this.totalSentSize != null) {
            generator.writeKey("total_sent_size");
            generator.write(this.totalSentSize);
        }

        if (this.totalTime != null) {
            generator.writeKey("total_time");
            this.totalTime.serialize(generator, mapper);
        }

        if (this.totalTimeMillis != null) {
            generator.writeKey("total_time_millis");
            generator.write(this.totalTimeMillis);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link MergesWarmerStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MergesWarmerStats> {
        @Nullable
        private Long ongoingCount;
        @Nullable
        private Long totalBytesReceived;
        @Nullable
        private Long totalBytesSent;
        @Nullable
        private Long totalFailureCount;
        @Nullable
        private Long totalInvocationsCount;
        @Nullable
        private Time totalReceiveTime;
        @Nullable
        private Long totalReceiveTimeMillis;
        @Nullable
        private String totalReceivedSize;
        @Nullable
        private Time totalSendTime;
        @Nullable
        private Long totalSendTimeMillis;
        @Nullable
        private String totalSentSize;
        @Nullable
        private Time totalTime;
        @Nullable
        private Long totalTimeMillis;

        public Builder() {}

        private Builder(MergesWarmerStats o) {
            this.ongoingCount = o.ongoingCount;
            this.totalBytesReceived = o.totalBytesReceived;
            this.totalBytesSent = o.totalBytesSent;
            this.totalFailureCount = o.totalFailureCount;
            this.totalInvocationsCount = o.totalInvocationsCount;
            this.totalReceiveTime = o.totalReceiveTime;
            this.totalReceiveTimeMillis = o.totalReceiveTimeMillis;
            this.totalReceivedSize = o.totalReceivedSize;
            this.totalSendTime = o.totalSendTime;
            this.totalSendTimeMillis = o.totalSendTimeMillis;
            this.totalSentSize = o.totalSentSize;
            this.totalTime = o.totalTime;
            this.totalTimeMillis = o.totalTimeMillis;
        }

        private Builder(Builder o) {
            this.ongoingCount = o.ongoingCount;
            this.totalBytesReceived = o.totalBytesReceived;
            this.totalBytesSent = o.totalBytesSent;
            this.totalFailureCount = o.totalFailureCount;
            this.totalInvocationsCount = o.totalInvocationsCount;
            this.totalReceiveTime = o.totalReceiveTime;
            this.totalReceiveTimeMillis = o.totalReceiveTimeMillis;
            this.totalReceivedSize = o.totalReceivedSize;
            this.totalSendTime = o.totalSendTime;
            this.totalSendTimeMillis = o.totalSendTimeMillis;
            this.totalSentSize = o.totalSentSize;
            this.totalTime = o.totalTime;
            this.totalTimeMillis = o.totalTimeMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of currently ongoing merge warmer operations.
         * <p>
         * API name: {@code ongoing_count}
         * </p>
         */
        @Nonnull
        public final Builder ongoingCount(@Nullable Long value) {
            this.ongoingCount = value;
            return this;
        }

        /**
         * The total number of bytes received during merge warmer operations.
         * <p>
         * API name: {@code total_bytes_received}
         * </p>
         */
        @Nonnull
        public final Builder totalBytesReceived(@Nullable Long value) {
            this.totalBytesReceived = value;
            return this;
        }

        /**
         * The total number of bytes sent during merge warmer operations.
         * <p>
         * API name: {@code total_bytes_sent}
         * </p>
         */
        @Nonnull
        public final Builder totalBytesSent(@Nullable Long value) {
            this.totalBytesSent = value;
            return this;
        }

        /**
         * The total number of failed merge warmer operations.
         * <p>
         * API name: {@code total_failure_count}
         * </p>
         */
        @Nonnull
        public final Builder totalFailureCount(@Nullable Long value) {
            this.totalFailureCount = value;
            return this;
        }

        /**
         * The total number of merge warmer invocations.
         * <p>
         * API name: {@code total_invocations_count}
         * </p>
         */
        @Nonnull
        public final Builder totalInvocationsCount(@Nullable Long value) {
            this.totalInvocationsCount = value;
            return this;
        }

        /**
         * The total amount of time spent receiving data during merge warmer operations.
         * <p>
         * API name: {@code total_receive_time}
         * </p>
         */
        @Nonnull
        public final Builder totalReceiveTime(@Nullable Time value) {
            this.totalReceiveTime = value;
            return this;
        }

        /**
         * The total amount of time spent receiving data during merge warmer operations.
         * <p>
         * API name: {@code total_receive_time}
         * </p>
         */
        @Nonnull
        public final Builder totalReceiveTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalReceiveTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The total amount of time spent receiving data during merge warmer operations, in milliseconds.
         * <p>
         * API name: {@code total_receive_time_millis}
         * </p>
         */
        @Nonnull
        public final Builder totalReceiveTimeMillis(@Nullable Long value) {
            this.totalReceiveTimeMillis = value;
            return this;
        }

        /**
         * The total number of bytes received during merge warmer operations, in a human-readable format.
         * <p>
         * API name: {@code total_received_size}
         * </p>
         */
        @Nonnull
        public final Builder totalReceivedSize(@Nullable String value) {
            this.totalReceivedSize = value;
            return this;
        }

        /**
         * The total amount of time spent sending data during merge warmer operations.
         * <p>
         * API name: {@code total_send_time}
         * </p>
         */
        @Nonnull
        public final Builder totalSendTime(@Nullable Time value) {
            this.totalSendTime = value;
            return this;
        }

        /**
         * The total amount of time spent sending data during merge warmer operations.
         * <p>
         * API name: {@code total_send_time}
         * </p>
         */
        @Nonnull
        public final Builder totalSendTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalSendTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The total amount of time spent sending data during merge warmer operations, in milliseconds.
         * <p>
         * API name: {@code total_send_time_millis}
         * </p>
         */
        @Nonnull
        public final Builder totalSendTimeMillis(@Nullable Long value) {
            this.totalSendTimeMillis = value;
            return this;
        }

        /**
         * The total number of bytes sent during merge warmer operations, in a human-readable format.
         * <p>
         * API name: {@code total_sent_size}
         * </p>
         */
        @Nonnull
        public final Builder totalSentSize(@Nullable String value) {
            this.totalSentSize = value;
            return this;
        }

        /**
         * The total amount of time spent on merge warmer operations.
         * <p>
         * API name: {@code total_time}
         * </p>
         */
        @Nonnull
        public final Builder totalTime(@Nullable Time value) {
            this.totalTime = value;
            return this;
        }

        /**
         * The total amount of time spent on merge warmer operations.
         * <p>
         * API name: {@code total_time}
         * </p>
         */
        @Nonnull
        public final Builder totalTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The total amount of time spent on merge warmer operations, in milliseconds.
         * <p>
         * API name: {@code total_time_millis}
         * </p>
         */
        @Nonnull
        public final Builder totalTimeMillis(@Nullable Long value) {
            this.totalTimeMillis = value;
            return this;
        }

        /**
         * Builds a {@link MergesWarmerStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MergesWarmerStats build() {
            _checkSingleUse();

            return new MergesWarmerStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MergesWarmerStats}
     */
    public static final JsonpDeserializer<MergesWarmerStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MergesWarmerStats::setupMergesWarmerStatsDeserializer
    );

    protected static void setupMergesWarmerStatsDeserializer(ObjectDeserializer<MergesWarmerStats.Builder> op) {
        op.add(Builder::ongoingCount, JsonpDeserializer.longDeserializer(), "ongoing_count");
        op.add(Builder::totalBytesReceived, JsonpDeserializer.longDeserializer(), "total_bytes_received");
        op.add(Builder::totalBytesSent, JsonpDeserializer.longDeserializer(), "total_bytes_sent");
        op.add(Builder::totalFailureCount, JsonpDeserializer.longDeserializer(), "total_failure_count");
        op.add(Builder::totalInvocationsCount, JsonpDeserializer.longDeserializer(), "total_invocations_count");
        op.add(Builder::totalReceiveTime, Time._DESERIALIZER, "total_receive_time");
        op.add(Builder::totalReceiveTimeMillis, JsonpDeserializer.longDeserializer(), "total_receive_time_millis");
        op.add(Builder::totalReceivedSize, JsonpDeserializer.stringDeserializer(), "total_received_size");
        op.add(Builder::totalSendTime, Time._DESERIALIZER, "total_send_time");
        op.add(Builder::totalSendTimeMillis, JsonpDeserializer.longDeserializer(), "total_send_time_millis");
        op.add(Builder::totalSentSize, JsonpDeserializer.stringDeserializer(), "total_sent_size");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeMillis, JsonpDeserializer.longDeserializer(), "total_time_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.ongoingCount);
        result = 31 * result + Objects.hashCode(this.totalBytesReceived);
        result = 31 * result + Objects.hashCode(this.totalBytesSent);
        result = 31 * result + Objects.hashCode(this.totalFailureCount);
        result = 31 * result + Objects.hashCode(this.totalInvocationsCount);
        result = 31 * result + Objects.hashCode(this.totalReceiveTime);
        result = 31 * result + Objects.hashCode(this.totalReceiveTimeMillis);
        result = 31 * result + Objects.hashCode(this.totalReceivedSize);
        result = 31 * result + Objects.hashCode(this.totalSendTime);
        result = 31 * result + Objects.hashCode(this.totalSendTimeMillis);
        result = 31 * result + Objects.hashCode(this.totalSentSize);
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Objects.hashCode(this.totalTimeMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MergesWarmerStats other = (MergesWarmerStats) o;
        return Objects.equals(this.ongoingCount, other.ongoingCount)
            && Objects.equals(this.totalBytesReceived, other.totalBytesReceived)
            && Objects.equals(this.totalBytesSent, other.totalBytesSent)
            && Objects.equals(this.totalFailureCount, other.totalFailureCount)
            && Objects.equals(this.totalInvocationsCount, other.totalInvocationsCount)
            && Objects.equals(this.totalReceiveTime, other.totalReceiveTime)
            && Objects.equals(this.totalReceiveTimeMillis, other.totalReceiveTimeMillis)
            && Objects.equals(this.totalReceivedSize, other.totalReceivedSize)
            && Objects.equals(this.totalSendTime, other.totalSendTime)
            && Objects.equals(this.totalSendTimeMillis, other.totalSendTimeMillis)
            && Objects.equals(this.totalSentSize, other.totalSentSize)
            && Objects.equals(this.totalTime, other.totalTime)
            && Objects.equals(this.totalTimeMillis, other.totalTimeMillis);
    }
}
