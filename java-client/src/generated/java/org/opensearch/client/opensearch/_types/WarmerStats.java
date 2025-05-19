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

// typedef: _types.WarmerStats

/**
 * The statistics about index warmer operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class WarmerStats implements PlainJsonSerializable, ToCopyableBuilder<WarmerStats.Builder, WarmerStats> {

    private final long current;

    private final long total;

    @Nullable
    private final Time totalTime;

    private final long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private WarmerStats(Builder builder) {
        this.current = ApiTypeHelper.requireNonNull(builder.current, this, "current");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.totalTime = builder.totalTime;
        this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");
    }

    public static WarmerStats of(Function<WarmerStats.Builder, ObjectBuilder<WarmerStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of current warmer operations.
     * <p>
     * API name: {@code current}
     * </p>
     */
    public final long current() {
        return this.current;
    }

    /**
     * Required - The total number of warmer operations.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final long total() {
        return this.total;
    }

    /**
     * The total time spent on warmer operations.
     * <p>
     * API name: {@code total_time}
     * </p>
     */
    @Nullable
    public final Time totalTime() {
        return this.totalTime;
    }

    /**
     * Required - The total time spent on warmer operations in milliseconds.
     * <p>
     * API name: {@code total_time_in_millis}
     * </p>
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
        generator.writeKey("current");
        generator.write(this.current);

        generator.writeKey("total");
        generator.write(this.total);

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
     * Builder for {@link WarmerStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, WarmerStats> {
        private Long current;
        private Long total;
        @Nullable
        private Time totalTime;
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(WarmerStats o) {
            this.current = o.current;
            this.total = o.total;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.current = o.current;
            this.total = o.total;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of current warmer operations.
         * <p>
         * API name: {@code current}
         * </p>
         */
        @Nonnull
        public final Builder current(long value) {
            this.current = value;
            return this;
        }

        /**
         * Required - The total number of warmer operations.
         * <p>
         * API name: {@code total}
         * </p>
         */
        @Nonnull
        public final Builder total(long value) {
            this.total = value;
            return this;
        }

        /**
         * The total time spent on warmer operations.
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
         * The total time spent on warmer operations.
         * <p>
         * API name: {@code total_time}
         * </p>
         */
        @Nonnull
        public final Builder totalTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - The total time spent on warmer operations in milliseconds.
         * <p>
         * API name: {@code total_time_in_millis}
         * </p>
         */
        @Nonnull
        public final Builder totalTimeInMillis(long value) {
            this.totalTimeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link WarmerStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public WarmerStats build() {
            _checkSingleUse();

            return new WarmerStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link WarmerStats}
     */
    public static final JsonpDeserializer<WarmerStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        WarmerStats::setupWarmerStatsDeserializer
    );

    protected static void setupWarmerStatsDeserializer(ObjectDeserializer<WarmerStats.Builder> op) {
        op.add(Builder::current, JsonpDeserializer.longDeserializer(), "current");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.current);
        result = 31 * result + Long.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Long.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        WarmerStats other = (WarmerStats) o;
        return this.current == other.current
            && this.total == other.total
            && Objects.equals(this.totalTime, other.totalTime)
            && this.totalTimeInMillis == other.totalTimeInMillis;
    }
}
