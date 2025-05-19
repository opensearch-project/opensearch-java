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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.RecoveryStats

/**
 * The statistics about recovery operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RecoveryStats implements PlainJsonSerializable, ToCopyableBuilder<RecoveryStats.Builder, RecoveryStats> {

    private final long currentAsSource;

    private final long currentAsTarget;

    @Nullable
    private final Time throttleTime;

    private final long throttleTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private RecoveryStats(Builder builder) {
        this.currentAsSource = ApiTypeHelper.requireNonNull(builder.currentAsSource, this, "currentAsSource");
        this.currentAsTarget = ApiTypeHelper.requireNonNull(builder.currentAsTarget, this, "currentAsTarget");
        this.throttleTime = builder.throttleTime;
        this.throttleTimeInMillis = ApiTypeHelper.requireNonNull(builder.throttleTimeInMillis, this, "throttleTimeInMillis");
    }

    public static RecoveryStats of(Function<RecoveryStats.Builder, ObjectBuilder<RecoveryStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of ongoing recoveries for which this node is the source.
     * <p>
     * API name: {@code current_as_source}
     * </p>
     */
    public final long currentAsSource() {
        return this.currentAsSource;
    }

    /**
     * Required - The number of ongoing recoveries for which this node is the target.
     * <p>
     * API name: {@code current_as_target}
     * </p>
     */
    public final long currentAsTarget() {
        return this.currentAsTarget;
    }

    /**
     * The total amount of time recovery operations have been throttled.
     * <p>
     * API name: {@code throttle_time}
     * </p>
     */
    @Nullable
    public final Time throttleTime() {
        return this.throttleTime;
    }

    /**
     * Required - The total amount of time recovery operations have been throttled in milliseconds.
     * <p>
     * API name: {@code throttle_time_in_millis}
     * </p>
     */
    public final long throttleTimeInMillis() {
        return this.throttleTimeInMillis;
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
        generator.writeKey("current_as_source");
        generator.write(this.currentAsSource);

        generator.writeKey("current_as_target");
        generator.write(this.currentAsTarget);

        if (this.throttleTime != null) {
            generator.writeKey("throttle_time");
            this.throttleTime.serialize(generator, mapper);
        }

        generator.writeKey("throttle_time_in_millis");
        generator.write(this.throttleTimeInMillis);
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
     * Builder for {@link RecoveryStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RecoveryStats> {
        private Long currentAsSource;
        private Long currentAsTarget;
        @Nullable
        private Time throttleTime;
        private Long throttleTimeInMillis;

        public Builder() {}

        private Builder(RecoveryStats o) {
            this.currentAsSource = o.currentAsSource;
            this.currentAsTarget = o.currentAsTarget;
            this.throttleTime = o.throttleTime;
            this.throttleTimeInMillis = o.throttleTimeInMillis;
        }

        private Builder(Builder o) {
            this.currentAsSource = o.currentAsSource;
            this.currentAsTarget = o.currentAsTarget;
            this.throttleTime = o.throttleTime;
            this.throttleTimeInMillis = o.throttleTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of ongoing recoveries for which this node is the source.
         * <p>
         * API name: {@code current_as_source}
         * </p>
         */
        @Nonnull
        public final Builder currentAsSource(long value) {
            this.currentAsSource = value;
            return this;
        }

        /**
         * Required - The number of ongoing recoveries for which this node is the target.
         * <p>
         * API name: {@code current_as_target}
         * </p>
         */
        @Nonnull
        public final Builder currentAsTarget(long value) {
            this.currentAsTarget = value;
            return this;
        }

        /**
         * The total amount of time recovery operations have been throttled.
         * <p>
         * API name: {@code throttle_time}
         * </p>
         */
        @Nonnull
        public final Builder throttleTime(@Nullable Time value) {
            this.throttleTime = value;
            return this;
        }

        /**
         * The total amount of time recovery operations have been throttled.
         * <p>
         * API name: {@code throttle_time}
         * </p>
         */
        @Nonnull
        public final Builder throttleTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return throttleTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total amount of time recovery operations have been throttled in milliseconds.
         * <p>
         * API name: {@code throttle_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder throttleTimeInMillis(long value) {
            this.throttleTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link RecoveryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RecoveryStats build() {
            _checkSingleUse();

            return new RecoveryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RecoveryStats}
     */
    public static final JsonpDeserializer<RecoveryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RecoveryStats::setupRecoveryStatsDeserializer
    );

    protected static void setupRecoveryStatsDeserializer(ObjectDeserializer<RecoveryStats.Builder> op) {
        op.add(Builder::currentAsSource, JsonpDeserializer.longDeserializer(), "current_as_source");
        op.add(Builder::currentAsTarget, JsonpDeserializer.longDeserializer(), "current_as_target");
        op.add(Builder::throttleTime, Time._DESERIALIZER, "throttle_time");
        op.add(Builder::throttleTimeInMillis, JsonpDeserializer.longDeserializer(), "throttle_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.currentAsSource);
        result = 31 * result + Long.hashCode(this.currentAsTarget);
        result = 31 * result + Objects.hashCode(this.throttleTime);
        result = 31 * result + Long.hashCode(this.throttleTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RecoveryStats other = (RecoveryStats) o;
        return this.currentAsSource == other.currentAsSource
            && this.currentAsTarget == other.currentAsTarget
            && Objects.equals(this.throttleTime, other.throttleTime)
            && this.throttleTimeInMillis == other.throttleTimeInMillis;
    }
}
