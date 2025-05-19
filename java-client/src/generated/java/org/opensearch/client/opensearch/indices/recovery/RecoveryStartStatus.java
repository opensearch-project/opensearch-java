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

// typedef: indices.recovery.RecoveryStartStatus

/**
 * The status at the start of recovery.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryStartStatus implements PlainJsonSerializable, ToCopyableBuilder<RecoveryStartStatus.Builder, RecoveryStartStatus> {

    @Nullable
    private final Time checkIndexTime;

    private final long checkIndexTimeInMillis;

    @Nullable
    private final Time totalTime;

    private final long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private RecoveryStartStatus(Builder builder) {
        this.checkIndexTime = builder.checkIndexTime;
        this.checkIndexTimeInMillis = ApiTypeHelper.requireNonNull(builder.checkIndexTimeInMillis, this, "checkIndexTimeInMillis");
        this.totalTime = builder.totalTime;
        this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");
    }

    public static RecoveryStartStatus of(Function<RecoveryStartStatus.Builder, ObjectBuilder<RecoveryStartStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code check_index_time}
     */
    @Nullable
    public final Time checkIndexTime() {
        return this.checkIndexTime;
    }

    /**
     * Required - API name: {@code check_index_time_in_millis}
     */
    public final long checkIndexTimeInMillis() {
        return this.checkIndexTimeInMillis;
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
        if (this.checkIndexTime != null) {
            generator.writeKey("check_index_time");
            this.checkIndexTime.serialize(generator, mapper);
        }

        generator.writeKey("check_index_time_in_millis");
        generator.write(this.checkIndexTimeInMillis);

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
     * Builder for {@link RecoveryStartStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryStartStatus> {
        @Nullable
        private Time checkIndexTime;
        private Long checkIndexTimeInMillis;
        @Nullable
        private Time totalTime;
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(RecoveryStartStatus o) {
            this.checkIndexTime = o.checkIndexTime;
            this.checkIndexTimeInMillis = o.checkIndexTimeInMillis;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.checkIndexTime = o.checkIndexTime;
            this.checkIndexTimeInMillis = o.checkIndexTimeInMillis;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code check_index_time}
         */
        @Nonnull
        public final Builder checkIndexTime(@Nullable Time value) {
            this.checkIndexTime = value;
            return this;
        }

        /**
         * API name: {@code check_index_time}
         */
        @Nonnull
        public final Builder checkIndexTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return checkIndexTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code check_index_time_in_millis}
         */
        @Nonnull
        public final Builder checkIndexTimeInMillis(long value) {
            this.checkIndexTimeInMillis = value;
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
         * Builds a {@link RecoveryStartStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryStartStatus build() {
            _checkSingleUse();

            return new RecoveryStartStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryStartStatus}
     */
    public static final JsonpDeserializer<RecoveryStartStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryStartStatus::setupRecoveryStartStatusDeserializer
    );

    protected static void setupRecoveryStartStatusDeserializer(ObjectDeserializer<RecoveryStartStatus.Builder> op) {
        op.add(Builder::checkIndexTime, Time._DESERIALIZER, "check_index_time");
        op.add(Builder::checkIndexTimeInMillis, JsonpDeserializer.longDeserializer(), "check_index_time_in_millis");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.checkIndexTime);
        result = 31 * result + Long.hashCode(this.checkIndexTimeInMillis);
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Long.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryStartStatus other = (RecoveryStartStatus) o;
        return Objects.equals(this.checkIndexTime, other.checkIndexTime)
            && this.checkIndexTimeInMillis == other.checkIndexTimeInMillis
            && Objects.equals(this.totalTime, other.totalTime)
            && this.totalTimeInMillis == other.totalTimeInMillis;
    }
}
