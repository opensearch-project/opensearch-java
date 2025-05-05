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

package org.opensearch.client.opensearch.indices.recovery;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.recovery.ShardRecovery

/**
 * The recovery status of a shard.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardRecovery implements PlainJsonSerializable, ToCopyableBuilder<ShardRecovery.Builder, ShardRecovery> {

    private final int id;

    @Nonnull
    private final RecoveryIndexStatus index;

    private final boolean primary;

    @Nonnull
    private final RecoveryOrigin source;

    @Nonnull
    private final String stage;

    @Nullable
    private final RecoveryStartStatus start;

    @Nullable
    private final String startTime;

    private final long startTimeInMillis;

    @Nullable
    private final String stopTime;

    @Nullable
    private final Long stopTimeInMillis;

    @Nonnull
    private final RecoveryOrigin target;

    @Nullable
    private final Time totalTime;

    private final long totalTimeInMillis;

    @Nonnull
    private final TranslogStatus translog;

    @Nonnull
    private final String type;

    @Nonnull
    private final VerifyIndex verifyIndex;

    // ---------------------------------------------------------------------------------------------

    private ShardRecovery(Builder builder) {
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.primary = ApiTypeHelper.requireNonNull(builder.primary, this, "primary");
        this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
        this.stage = ApiTypeHelper.requireNonNull(builder.stage, this, "stage");
        this.start = builder.start;
        this.startTime = builder.startTime;
        this.startTimeInMillis = ApiTypeHelper.requireNonNull(builder.startTimeInMillis, this, "startTimeInMillis");
        this.stopTime = builder.stopTime;
        this.stopTimeInMillis = builder.stopTimeInMillis;
        this.target = ApiTypeHelper.requireNonNull(builder.target, this, "target");
        this.totalTime = builder.totalTime;
        this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");
        this.translog = ApiTypeHelper.requireNonNull(builder.translog, this, "translog");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.verifyIndex = ApiTypeHelper.requireNonNull(builder.verifyIndex, this, "verifyIndex");
    }

    public static ShardRecovery of(Function<ShardRecovery.Builder, ObjectBuilder<ShardRecovery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The shard ID.
     * <p>
     * API name: {@code id}
     * </p>
     */
    public final int id() {
        return this.id;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final RecoveryIndexStatus index() {
        return this.index;
    }

    /**
     * Required - Whether this is a primary shard.
     * <p>
     * API name: {@code primary}
     * </p>
     */
    public final boolean primary() {
        return this.primary;
    }

    /**
     * Required - API name: {@code source}
     */
    @Nonnull
    public final RecoveryOrigin source() {
        return this.source;
    }

    /**
     * Required - The current recovery stage.
     * <p>
     * API name: {@code stage}
     * </p>
     */
    @Nonnull
    public final String stage() {
        return this.stage;
    }

    /**
     * API name: {@code start}
     */
    @Nullable
    public final RecoveryStartStatus start() {
        return this.start;
    }

    /**
     * API name: {@code start_time}
     */
    @Nullable
    public final String startTime() {
        return this.startTime;
    }

    /**
     * Required - API name: {@code start_time_in_millis}
     */
    public final long startTimeInMillis() {
        return this.startTimeInMillis;
    }

    /**
     * API name: {@code stop_time}
     */
    @Nullable
    public final String stopTime() {
        return this.stopTime;
    }

    /**
     * API name: {@code stop_time_in_millis}
     */
    @Nullable
    public final Long stopTimeInMillis() {
        return this.stopTimeInMillis;
    }

    /**
     * Required - API name: {@code target}
     */
    @Nonnull
    public final RecoveryOrigin target() {
        return this.target;
    }

    /**
     * API name: {@code total_time}
     */
    @Nullable
    public final Time totalTime() {
        return this.totalTime;
    }

    /**
     * Required - API name: {@code total_time_in_millis}
     */
    public final long totalTimeInMillis() {
        return this.totalTimeInMillis;
    }

    /**
     * Required - API name: {@code translog}
     */
    @Nonnull
    public final TranslogStatus translog() {
        return this.translog;
    }

    /**
     * Required - The type of recovery operation.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final String type() {
        return this.type;
    }

    /**
     * Required - API name: {@code verify_index}
     */
    @Nonnull
    public final VerifyIndex verifyIndex() {
        return this.verifyIndex;
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
        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("index");
        this.index.serialize(generator, mapper);

        generator.writeKey("primary");
        generator.write(this.primary);

        generator.writeKey("source");
        this.source.serialize(generator, mapper);

        generator.writeKey("stage");
        generator.write(this.stage);

        if (this.start != null) {
            generator.writeKey("start");
            this.start.serialize(generator, mapper);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
        }

        generator.writeKey("start_time_in_millis");
        generator.write(this.startTimeInMillis);

        if (this.stopTime != null) {
            generator.writeKey("stop_time");
            generator.write(this.stopTime);
        }

        if (this.stopTimeInMillis != null) {
            generator.writeKey("stop_time_in_millis");
            generator.write(this.stopTimeInMillis);
        }

        generator.writeKey("target");
        this.target.serialize(generator, mapper);

        if (this.totalTime != null) {
            generator.writeKey("total_time");
            this.totalTime.serialize(generator, mapper);
        }

        generator.writeKey("total_time_in_millis");
        generator.write(this.totalTimeInMillis);

        generator.writeKey("translog");
        this.translog.serialize(generator, mapper);

        generator.writeKey("type");
        generator.write(this.type);

        generator.writeKey("verify_index");
        this.verifyIndex.serialize(generator, mapper);
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
     * Builder for {@link ShardRecovery}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardRecovery> {
        private Integer id;
        private RecoveryIndexStatus index;
        private Boolean primary;
        private RecoveryOrigin source;
        private String stage;
        @Nullable
        private RecoveryStartStatus start;
        @Nullable
        private String startTime;
        private Long startTimeInMillis;
        @Nullable
        private String stopTime;
        @Nullable
        private Long stopTimeInMillis;
        private RecoveryOrigin target;
        @Nullable
        private Time totalTime;
        private Long totalTimeInMillis;
        private TranslogStatus translog;
        private String type;
        private VerifyIndex verifyIndex;

        public Builder() {}

        private Builder(ShardRecovery o) {
            this.id = o.id;
            this.index = o.index;
            this.primary = o.primary;
            this.source = o.source;
            this.stage = o.stage;
            this.start = o.start;
            this.startTime = o.startTime;
            this.startTimeInMillis = o.startTimeInMillis;
            this.stopTime = o.stopTime;
            this.stopTimeInMillis = o.stopTimeInMillis;
            this.target = o.target;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
            this.translog = o.translog;
            this.type = o.type;
            this.verifyIndex = o.verifyIndex;
        }

        private Builder(Builder o) {
            this.id = o.id;
            this.index = o.index;
            this.primary = o.primary;
            this.source = o.source;
            this.stage = o.stage;
            this.start = o.start;
            this.startTime = o.startTime;
            this.startTimeInMillis = o.startTimeInMillis;
            this.stopTime = o.stopTime;
            this.stopTimeInMillis = o.stopTimeInMillis;
            this.target = o.target;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
            this.translog = o.translog;
            this.type = o.type;
            this.verifyIndex = o.verifyIndex;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The shard ID.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(int value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(RecoveryIndexStatus value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(Function<RecoveryIndexStatus.Builder, ObjectBuilder<RecoveryIndexStatus>> fn) {
            return index(fn.apply(new RecoveryIndexStatus.Builder()).build());
        }

        /**
         * Required - Whether this is a primary shard.
         * <p>
         * API name: {@code primary}
         * </p>
         */
        @Nonnull
        public final Builder primary(boolean value) {
            this.primary = value;
            return this;
        }

        /**
         * Required - API name: {@code source}
         */
        @Nonnull
        public final Builder source(RecoveryOrigin value) {
            this.source = value;
            return this;
        }

        /**
         * Required - API name: {@code source}
         */
        @Nonnull
        public final Builder source(Function<RecoveryOrigin.Builder, ObjectBuilder<RecoveryOrigin>> fn) {
            return source(fn.apply(new RecoveryOrigin.Builder()).build());
        }

        /**
         * Required - The current recovery stage.
         * <p>
         * API name: {@code stage}
         * </p>
         */
        @Nonnull
        public final Builder stage(String value) {
            this.stage = value;
            return this;
        }

        /**
         * API name: {@code start}
         */
        @Nonnull
        public final Builder start(@Nullable RecoveryStartStatus value) {
            this.start = value;
            return this;
        }

        /**
         * API name: {@code start}
         */
        @Nonnull
        public final Builder start(Function<RecoveryStartStatus.Builder, ObjectBuilder<RecoveryStartStatus>> fn) {
            return start(fn.apply(new RecoveryStartStatus.Builder()).build());
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
         * Required - API name: {@code start_time_in_millis}
         */
        @Nonnull
        public final Builder startTimeInMillis(long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code stop_time}
         */
        @Nonnull
        public final Builder stopTime(@Nullable String value) {
            this.stopTime = value;
            return this;
        }

        /**
         * API name: {@code stop_time_in_millis}
         */
        @Nonnull
        public final Builder stopTimeInMillis(@Nullable Long value) {
            this.stopTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code target}
         */
        @Nonnull
        public final Builder target(RecoveryOrigin value) {
            this.target = value;
            return this;
        }

        /**
         * Required - API name: {@code target}
         */
        @Nonnull
        public final Builder target(Function<RecoveryOrigin.Builder, ObjectBuilder<RecoveryOrigin>> fn) {
            return target(fn.apply(new RecoveryOrigin.Builder()).build());
        }

        /**
         * API name: {@code total_time}
         */
        @Nonnull
        public final Builder totalTime(@Nullable Time value) {
            this.totalTime = value;
            return this;
        }

        /**
         * API name: {@code total_time}
         */
        @Nonnull
        public final Builder totalTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code total_time_in_millis}
         */
        @Nonnull
        public final Builder totalTimeInMillis(long value) {
            this.totalTimeInMillis = value;
            return this;
        }

        /**
         * Required - API name: {@code translog}
         */
        @Nonnull
        public final Builder translog(TranslogStatus value) {
            this.translog = value;
            return this;
        }

        /**
         * Required - API name: {@code translog}
         */
        @Nonnull
        public final Builder translog(Function<TranslogStatus.Builder, ObjectBuilder<TranslogStatus>> fn) {
            return translog(fn.apply(new TranslogStatus.Builder()).build());
        }

        /**
         * Required - The type of recovery operation.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Required - API name: {@code verify_index}
         */
        @Nonnull
        public final Builder verifyIndex(VerifyIndex value) {
            this.verifyIndex = value;
            return this;
        }

        /**
         * Required - API name: {@code verify_index}
         */
        @Nonnull
        public final Builder verifyIndex(Function<VerifyIndex.Builder, ObjectBuilder<VerifyIndex>> fn) {
            return verifyIndex(fn.apply(new VerifyIndex.Builder()).build());
        }

        /**
         * Builds a {@link ShardRecovery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardRecovery build() {
            _checkSingleUse();

            return new ShardRecovery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardRecovery}
     */
    public static final JsonpDeserializer<ShardRecovery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardRecovery::setupShardRecoveryDeserializer
    );

    protected static void setupShardRecoveryDeserializer(ObjectDeserializer<ShardRecovery.Builder> op) {
        op.add(Builder::id, JsonpDeserializer.integerDeserializer(), "id");
        op.add(Builder::index, RecoveryIndexStatus._DESERIALIZER, "index");
        op.add(Builder::primary, JsonpDeserializer.booleanDeserializer(), "primary");
        op.add(Builder::source, RecoveryOrigin._DESERIALIZER, "source");
        op.add(Builder::stage, JsonpDeserializer.stringDeserializer(), "stage");
        op.add(Builder::start, RecoveryStartStatus._DESERIALIZER, "start");
        op.add(Builder::startTime, JsonpDeserializer.stringDeserializer(), "start_time");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::stopTime, JsonpDeserializer.stringDeserializer(), "stop_time");
        op.add(Builder::stopTimeInMillis, JsonpDeserializer.longDeserializer(), "stop_time_in_millis");
        op.add(Builder::target, RecoveryOrigin._DESERIALIZER, "target");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
        op.add(Builder::translog, TranslogStatus._DESERIALIZER, "translog");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::verifyIndex, VerifyIndex._DESERIALIZER, "verify_index");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.id);
        result = 31 * result + this.index.hashCode();
        result = 31 * result + Boolean.hashCode(this.primary);
        result = 31 * result + this.source.hashCode();
        result = 31 * result + this.stage.hashCode();
        result = 31 * result + Objects.hashCode(this.start);
        result = 31 * result + Objects.hashCode(this.startTime);
        result = 31 * result + Long.hashCode(this.startTimeInMillis);
        result = 31 * result + Objects.hashCode(this.stopTime);
        result = 31 * result + Objects.hashCode(this.stopTimeInMillis);
        result = 31 * result + this.target.hashCode();
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Long.hashCode(this.totalTimeInMillis);
        result = 31 * result + this.translog.hashCode();
        result = 31 * result + this.type.hashCode();
        result = 31 * result + this.verifyIndex.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardRecovery other = (ShardRecovery) o;
        return this.id == other.id
            && this.index.equals(other.index)
            && this.primary == other.primary
            && this.source.equals(other.source)
            && this.stage.equals(other.stage)
            && Objects.equals(this.start, other.start)
            && Objects.equals(this.startTime, other.startTime)
            && this.startTimeInMillis == other.startTimeInMillis
            && Objects.equals(this.stopTime, other.stopTime)
            && Objects.equals(this.stopTimeInMillis, other.stopTimeInMillis)
            && this.target.equals(other.target)
            && Objects.equals(this.totalTime, other.totalTime)
            && this.totalTimeInMillis == other.totalTimeInMillis
            && this.translog.equals(other.translog)
            && this.type.equals(other.type)
            && this.verifyIndex.equals(other.verifyIndex);
    }
}
