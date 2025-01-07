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

package org.opensearch.client.opensearch.cat.snapshots;

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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.snapshots.SnapshotsRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotsRecord implements PlainJsonSerializable, ToCopyableBuilder<SnapshotsRecord.Builder, SnapshotsRecord> {

    @Nullable
    private final Time duration;

    @Nullable
    private final String endEpoch;

    @Nullable
    private final String endTime;

    @Nullable
    private final String failedShards;

    @Nullable
    private final String id;

    @Nullable
    private final String indices;

    @Nullable
    private final String reason;

    @Nullable
    private final String repository;

    @Nullable
    private final String startEpoch;

    @Nullable
    private final String startTime;

    @Nullable
    private final String status;

    @Nullable
    private final String successfulShards;

    @Nullable
    private final String totalShards;

    // ---------------------------------------------------------------------------------------------

    private SnapshotsRecord(Builder builder) {
        this.duration = builder.duration;
        this.endEpoch = builder.endEpoch;
        this.endTime = builder.endTime;
        this.failedShards = builder.failedShards;
        this.id = builder.id;
        this.indices = builder.indices;
        this.reason = builder.reason;
        this.repository = builder.repository;
        this.startEpoch = builder.startEpoch;
        this.startTime = builder.startTime;
        this.status = builder.status;
        this.successfulShards = builder.successfulShards;
        this.totalShards = builder.totalShards;
    }

    public static SnapshotsRecord of(Function<SnapshotsRecord.Builder, ObjectBuilder<SnapshotsRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code duration}
     */
    @Nullable
    public final Time duration() {
        return this.duration;
    }

    /**
     * API name: {@code end_epoch}
     */
    @Nullable
    public final String endEpoch() {
        return this.endEpoch;
    }

    /**
     * API name: {@code end_time}
     */
    @Nullable
    public final String endTime() {
        return this.endTime;
    }

    /**
     * The number of failed shards in the snapshot.
     * <p>
     * API name: {@code failed_shards}
     * </p>
     */
    @Nullable
    public final String failedShards() {
        return this.failedShards;
    }

    /**
     * The unique identifier for the snapshot.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The number of indexes in the snapshot.
     * <p>
     * API name: {@code indices}
     * </p>
     */
    @Nullable
    public final String indices() {
        return this.indices;
    }

    /**
     * The reason for any snapshot failures.
     * <p>
     * API name: {@code reason}
     * </p>
     */
    @Nullable
    public final String reason() {
        return this.reason;
    }

    /**
     * The repository name.
     * <p>
     * API name: {@code repository}
     * </p>
     */
    @Nullable
    public final String repository() {
        return this.repository;
    }

    /**
     * API name: {@code start_epoch}
     */
    @Nullable
    public final String startEpoch() {
        return this.startEpoch;
    }

    /**
     * API name: {@code start_time}
     */
    @Nullable
    public final String startTime() {
        return this.startTime;
    }

    /**
     * The state of the snapshot process. Returned values include: <code>FAILED</code>: The snapshot process failed.
     * <code>INCOMPATIBLE</code>: The snapshot process is incompatible with the current cluster version. <code>IN_PROGRESS</code>: The
     * snapshot process started but has not completed. <code>PARTIAL</code>: The snapshot process completed with a partial success.
     * <code>SUCCESS</code>: The snapshot process completed with a full success.
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nullable
    public final String status() {
        return this.status;
    }

    /**
     * The number of successful shards in the snapshot.
     * <p>
     * API name: {@code successful_shards}
     * </p>
     */
    @Nullable
    public final String successfulShards() {
        return this.successfulShards;
    }

    /**
     * The total number of shards in the snapshot.
     * <p>
     * API name: {@code total_shards}
     * </p>
     */
    @Nullable
    public final String totalShards() {
        return this.totalShards;
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
        if (this.duration != null) {
            generator.writeKey("duration");
            this.duration.serialize(generator, mapper);
        }

        if (this.endEpoch != null) {
            generator.writeKey("end_epoch");
            generator.write(this.endEpoch);
        }

        if (this.endTime != null) {
            generator.writeKey("end_time");
            generator.write(this.endTime);
        }

        if (this.failedShards != null) {
            generator.writeKey("failed_shards");
            generator.write(this.failedShards);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.indices != null) {
            generator.writeKey("indices");
            generator.write(this.indices);
        }

        if (this.reason != null) {
            generator.writeKey("reason");
            generator.write(this.reason);
        }

        if (this.repository != null) {
            generator.writeKey("repository");
            generator.write(this.repository);
        }

        if (this.startEpoch != null) {
            generator.writeKey("start_epoch");
            generator.write(this.startEpoch);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
        }

        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
        }

        if (this.successfulShards != null) {
            generator.writeKey("successful_shards");
            generator.write(this.successfulShards);
        }

        if (this.totalShards != null) {
            generator.writeKey("total_shards");
            generator.write(this.totalShards);
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
     * Builder for {@link SnapshotsRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotsRecord> {
        @Nullable
        private Time duration;
        @Nullable
        private String endEpoch;
        @Nullable
        private String endTime;
        @Nullable
        private String failedShards;
        @Nullable
        private String id;
        @Nullable
        private String indices;
        @Nullable
        private String reason;
        @Nullable
        private String repository;
        @Nullable
        private String startEpoch;
        @Nullable
        private String startTime;
        @Nullable
        private String status;
        @Nullable
        private String successfulShards;
        @Nullable
        private String totalShards;

        public Builder() {}

        private Builder(SnapshotsRecord o) {
            this.duration = o.duration;
            this.endEpoch = o.endEpoch;
            this.endTime = o.endTime;
            this.failedShards = o.failedShards;
            this.id = o.id;
            this.indices = o.indices;
            this.reason = o.reason;
            this.repository = o.repository;
            this.startEpoch = o.startEpoch;
            this.startTime = o.startTime;
            this.status = o.status;
            this.successfulShards = o.successfulShards;
            this.totalShards = o.totalShards;
        }

        private Builder(Builder o) {
            this.duration = o.duration;
            this.endEpoch = o.endEpoch;
            this.endTime = o.endTime;
            this.failedShards = o.failedShards;
            this.id = o.id;
            this.indices = o.indices;
            this.reason = o.reason;
            this.repository = o.repository;
            this.startEpoch = o.startEpoch;
            this.startTime = o.startTime;
            this.status = o.status;
            this.successfulShards = o.successfulShards;
            this.totalShards = o.totalShards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code duration}
         */
        @Nonnull
        public final Builder duration(@Nullable Time value) {
            this.duration = value;
            return this;
        }

        /**
         * API name: {@code duration}
         */
        @Nonnull
        public final Builder duration(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return duration(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code end_epoch}
         */
        @Nonnull
        public final Builder endEpoch(@Nullable String value) {
            this.endEpoch = value;
            return this;
        }

        /**
         * API name: {@code end_time}
         */
        @Nonnull
        public final Builder endTime(@Nullable String value) {
            this.endTime = value;
            return this;
        }

        /**
         * The number of failed shards in the snapshot.
         * <p>
         * API name: {@code failed_shards}
         * </p>
         */
        @Nonnull
        public final Builder failedShards(@Nullable String value) {
            this.failedShards = value;
            return this;
        }

        /**
         * The unique identifier for the snapshot.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The number of indexes in the snapshot.
         * <p>
         * API name: {@code indices}
         * </p>
         */
        @Nonnull
        public final Builder indices(@Nullable String value) {
            this.indices = value;
            return this;
        }

        /**
         * The reason for any snapshot failures.
         * <p>
         * API name: {@code reason}
         * </p>
         */
        @Nonnull
        public final Builder reason(@Nullable String value) {
            this.reason = value;
            return this;
        }

        /**
         * The repository name.
         * <p>
         * API name: {@code repository}
         * </p>
         */
        @Nonnull
        public final Builder repository(@Nullable String value) {
            this.repository = value;
            return this;
        }

        /**
         * API name: {@code start_epoch}
         */
        @Nonnull
        public final Builder startEpoch(@Nullable String value) {
            this.startEpoch = value;
            return this;
        }

        /**
         * API name: {@code start_time}
         */
        @Nonnull
        public final Builder startTime(@Nullable String value) {
            this.startTime = value;
            return this;
        }

        /**
         * The state of the snapshot process. Returned values include: <code>FAILED</code>: The snapshot process failed.
         * <code>INCOMPATIBLE</code>: The snapshot process is incompatible with the current cluster version. <code>IN_PROGRESS</code>: The
         * snapshot process started but has not completed. <code>PARTIAL</code>: The snapshot process completed with a partial success.
         * <code>SUCCESS</code>: The snapshot process completed with a full success.
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * The number of successful shards in the snapshot.
         * <p>
         * API name: {@code successful_shards}
         * </p>
         */
        @Nonnull
        public final Builder successfulShards(@Nullable String value) {
            this.successfulShards = value;
            return this;
        }

        /**
         * The total number of shards in the snapshot.
         * <p>
         * API name: {@code total_shards}
         * </p>
         */
        @Nonnull
        public final Builder totalShards(@Nullable String value) {
            this.totalShards = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotsRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotsRecord build() {
            _checkSingleUse();

            return new SnapshotsRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotsRecord}
     */
    public static final JsonpDeserializer<SnapshotsRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotsRecord::setupSnapshotsRecordDeserializer
    );

    protected static void setupSnapshotsRecordDeserializer(ObjectDeserializer<SnapshotsRecord.Builder> op) {
        op.add(Builder::duration, Time._DESERIALIZER, "duration");
        op.add(Builder::endEpoch, JsonpDeserializer.stringDeserializer(), "end_epoch");
        op.add(Builder::endTime, JsonpDeserializer.stringDeserializer(), "end_time");
        op.add(Builder::failedShards, JsonpDeserializer.stringDeserializer(), "failed_shards");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::indices, JsonpDeserializer.stringDeserializer(), "indices");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::repository, JsonpDeserializer.stringDeserializer(), "repository");
        op.add(Builder::startEpoch, JsonpDeserializer.stringDeserializer(), "start_epoch");
        op.add(Builder::startTime, JsonpDeserializer.stringDeserializer(), "start_time");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::successfulShards, JsonpDeserializer.stringDeserializer(), "successful_shards");
        op.add(Builder::totalShards, JsonpDeserializer.stringDeserializer(), "total_shards");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.duration);
        result = 31 * result + Objects.hashCode(this.endEpoch);
        result = 31 * result + Objects.hashCode(this.endTime);
        result = 31 * result + Objects.hashCode(this.failedShards);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.indices);
        result = 31 * result + Objects.hashCode(this.reason);
        result = 31 * result + Objects.hashCode(this.repository);
        result = 31 * result + Objects.hashCode(this.startEpoch);
        result = 31 * result + Objects.hashCode(this.startTime);
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + Objects.hashCode(this.successfulShards);
        result = 31 * result + Objects.hashCode(this.totalShards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotsRecord other = (SnapshotsRecord) o;
        return Objects.equals(this.duration, other.duration)
            && Objects.equals(this.endEpoch, other.endEpoch)
            && Objects.equals(this.endTime, other.endTime)
            && Objects.equals(this.failedShards, other.failedShards)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.indices, other.indices)
            && Objects.equals(this.reason, other.reason)
            && Objects.equals(this.repository, other.repository)
            && Objects.equals(this.startEpoch, other.startEpoch)
            && Objects.equals(this.startTime, other.startTime)
            && Objects.equals(this.status, other.status)
            && Objects.equals(this.successfulShards, other.successfulShards)
            && Objects.equals(this.totalShards, other.totalShards);
    }
}
