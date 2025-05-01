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

// typedef: indices.recovery.RecoveryIndexStatus

/**
 * The index recovery status.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryIndexStatus implements PlainJsonSerializable, ToCopyableBuilder<RecoveryIndexStatus.Builder, RecoveryIndexStatus> {

    @Nullable
    private final RecoveryBytes bytes;

    @Nonnull
    private final RecoveryFiles files;

    @Nonnull
    private final RecoveryBytes size;

    @Nullable
    private final Time sourceThrottleTime;

    private final long sourceThrottleTimeInMillis;

    @Nullable
    private final Time targetThrottleTime;

    private final long targetThrottleTimeInMillis;

    @Nullable
    private final Time totalTime;

    private final long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private RecoveryIndexStatus(Builder builder) {
        this.bytes = builder.bytes;
        this.files = ApiTypeHelper.requireNonNull(builder.files, this, "files");
        this.size = ApiTypeHelper.requireNonNull(builder.size, this, "size");
        this.sourceThrottleTime = builder.sourceThrottleTime;
        this.sourceThrottleTimeInMillis = ApiTypeHelper.requireNonNull(
            builder.sourceThrottleTimeInMillis,
            this,
            "sourceThrottleTimeInMillis"
        );
        this.targetThrottleTime = builder.targetThrottleTime;
        this.targetThrottleTimeInMillis = ApiTypeHelper.requireNonNull(
            builder.targetThrottleTimeInMillis,
            this,
            "targetThrottleTimeInMillis"
        );
        this.totalTime = builder.totalTime;
        this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");
    }

    public static RecoveryIndexStatus of(Function<RecoveryIndexStatus.Builder, ObjectBuilder<RecoveryIndexStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code bytes}
     */
    @Nullable
    public final RecoveryBytes bytes() {
        return this.bytes;
    }

    /**
     * Required - API name: {@code files}
     */
    @Nonnull
    public final RecoveryFiles files() {
        return this.files;
    }

    /**
     * Required - API name: {@code size}
     */
    @Nonnull
    public final RecoveryBytes size() {
        return this.size;
    }

    /**
     * API name: {@code source_throttle_time}
     */
    @Nullable
    public final Time sourceThrottleTime() {
        return this.sourceThrottleTime;
    }

    /**
     * Required - API name: {@code source_throttle_time_in_millis}
     */
    public final long sourceThrottleTimeInMillis() {
        return this.sourceThrottleTimeInMillis;
    }

    /**
     * API name: {@code target_throttle_time}
     */
    @Nullable
    public final Time targetThrottleTime() {
        return this.targetThrottleTime;
    }

    /**
     * Required - API name: {@code target_throttle_time_in_millis}
     */
    public final long targetThrottleTimeInMillis() {
        return this.targetThrottleTimeInMillis;
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
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.bytes != null) {
            generator.writeKey("bytes");
            this.bytes.serialize(generator, mapper);
        }

        generator.writeKey("files");
        this.files.serialize(generator, mapper);

        generator.writeKey("size");
        this.size.serialize(generator, mapper);

        if (this.sourceThrottleTime != null) {
            generator.writeKey("source_throttle_time");
            this.sourceThrottleTime.serialize(generator, mapper);
        }

        generator.writeKey("source_throttle_time_in_millis");
        generator.write(this.sourceThrottleTimeInMillis);

        if (this.targetThrottleTime != null) {
            generator.writeKey("target_throttle_time");
            this.targetThrottleTime.serialize(generator, mapper);
        }

        generator.writeKey("target_throttle_time_in_millis");
        generator.write(this.targetThrottleTimeInMillis);

        if (this.totalTime != null) {
            generator.writeKey("total_time");
            this.totalTime.serialize(generator, mapper);
        }

        generator.writeKey("total_time_in_millis");
        generator.write(this.totalTimeInMillis);
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
     * Builder for {@link RecoveryIndexStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryIndexStatus> {
        @Nullable
        private RecoveryBytes bytes;
        private RecoveryFiles files;
        private RecoveryBytes size;
        @Nullable
        private Time sourceThrottleTime;
        private Long sourceThrottleTimeInMillis;
        @Nullable
        private Time targetThrottleTime;
        private Long targetThrottleTimeInMillis;
        @Nullable
        private Time totalTime;
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(RecoveryIndexStatus o) {
            this.bytes = o.bytes;
            this.files = o.files;
            this.size = o.size;
            this.sourceThrottleTime = o.sourceThrottleTime;
            this.sourceThrottleTimeInMillis = o.sourceThrottleTimeInMillis;
            this.targetThrottleTime = o.targetThrottleTime;
            this.targetThrottleTimeInMillis = o.targetThrottleTimeInMillis;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.bytes = o.bytes;
            this.files = o.files;
            this.size = o.size;
            this.sourceThrottleTime = o.sourceThrottleTime;
            this.sourceThrottleTimeInMillis = o.sourceThrottleTimeInMillis;
            this.targetThrottleTime = o.targetThrottleTime;
            this.targetThrottleTimeInMillis = o.targetThrottleTimeInMillis;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code bytes}
         */
        @Nonnull
        public final Builder bytes(@Nullable RecoveryBytes value) {
            this.bytes = value;
            return this;
        }

        /**
         * API name: {@code bytes}
         */
        @Nonnull
        public final Builder bytes(Function<RecoveryBytes.Builder, ObjectBuilder<RecoveryBytes>> fn) {
            return bytes(fn.apply(new RecoveryBytes.Builder()).build());
        }

        /**
         * Required - API name: {@code files}
         */
        @Nonnull
        public final Builder files(RecoveryFiles value) {
            this.files = value;
            return this;
        }

        /**
         * Required - API name: {@code files}
         */
        @Nonnull
        public final Builder files(Function<RecoveryFiles.Builder, ObjectBuilder<RecoveryFiles>> fn) {
            return files(fn.apply(new RecoveryFiles.Builder()).build());
        }

        /**
         * Required - API name: {@code size}
         */
        @Nonnull
        public final Builder size(RecoveryBytes value) {
            this.size = value;
            return this;
        }

        /**
         * Required - API name: {@code size}
         */
        @Nonnull
        public final Builder size(Function<RecoveryBytes.Builder, ObjectBuilder<RecoveryBytes>> fn) {
            return size(fn.apply(new RecoveryBytes.Builder()).build());
        }

        /**
         * API name: {@code source_throttle_time}
         */
        @Nonnull
        public final Builder sourceThrottleTime(@Nullable Time value) {
            this.sourceThrottleTime = value;
            return this;
        }

        /**
         * API name: {@code source_throttle_time}
         */
        @Nonnull
        public final Builder sourceThrottleTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return sourceThrottleTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code source_throttle_time_in_millis}
         */
        @Nonnull
        public final Builder sourceThrottleTimeInMillis(long value) {
            this.sourceThrottleTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code target_throttle_time}
         */
        @Nonnull
        public final Builder targetThrottleTime(@Nullable Time value) {
            this.targetThrottleTime = value;
            return this;
        }

        /**
         * API name: {@code target_throttle_time}
         */
        @Nonnull
        public final Builder targetThrottleTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return targetThrottleTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code target_throttle_time_in_millis}
         */
        @Nonnull
        public final Builder targetThrottleTimeInMillis(long value) {
            this.targetThrottleTimeInMillis = value;
            return this;
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
         * Builds a {@link RecoveryIndexStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryIndexStatus build() {
            _checkSingleUse();

            return new RecoveryIndexStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryIndexStatus}
     */
    public static final JsonpDeserializer<RecoveryIndexStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryIndexStatus::setupRecoveryIndexStatusDeserializer
    );

    protected static void setupRecoveryIndexStatusDeserializer(ObjectDeserializer<RecoveryIndexStatus.Builder> op) {
        op.add(Builder::bytes, RecoveryBytes._DESERIALIZER, "bytes");
        op.add(Builder::files, RecoveryFiles._DESERIALIZER, "files");
        op.add(Builder::size, RecoveryBytes._DESERIALIZER, "size");
        op.add(Builder::sourceThrottleTime, Time._DESERIALIZER, "source_throttle_time");
        op.add(Builder::sourceThrottleTimeInMillis, JsonpDeserializer.longDeserializer(), "source_throttle_time_in_millis");
        op.add(Builder::targetThrottleTime, Time._DESERIALIZER, "target_throttle_time");
        op.add(Builder::targetThrottleTimeInMillis, JsonpDeserializer.longDeserializer(), "target_throttle_time_in_millis");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytes);
        result = 31 * result + this.files.hashCode();
        result = 31 * result + this.size.hashCode();
        result = 31 * result + Objects.hashCode(this.sourceThrottleTime);
        result = 31 * result + Long.hashCode(this.sourceThrottleTimeInMillis);
        result = 31 * result + Objects.hashCode(this.targetThrottleTime);
        result = 31 * result + Long.hashCode(this.targetThrottleTimeInMillis);
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Long.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryIndexStatus other = (RecoveryIndexStatus) o;
        return Objects.equals(this.bytes, other.bytes)
            && this.files.equals(other.files)
            && this.size.equals(other.size)
            && Objects.equals(this.sourceThrottleTime, other.sourceThrottleTime)
            && this.sourceThrottleTimeInMillis == other.sourceThrottleTimeInMillis
            && Objects.equals(this.targetThrottleTime, other.targetThrottleTime)
            && this.targetThrottleTimeInMillis == other.targetThrottleTimeInMillis
            && Objects.equals(this.totalTime, other.totalTime)
            && this.totalTimeInMillis == other.totalTimeInMillis;
    }
}
