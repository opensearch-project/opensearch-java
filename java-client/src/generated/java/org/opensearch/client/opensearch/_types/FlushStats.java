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

// typedef: _types.FlushStats

/**
 * The statistics about flush operations.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class FlushStats implements PlainJsonSerializable, ToCopyableBuilder<FlushStats.Builder, FlushStats> {

    private final long periodic;

    private final long total;

    @Nullable
    private final Time totalTime;

    private final long totalTimeInMillis;

    // ---------------------------------------------------------------------------------------------

    private FlushStats(Builder builder) {
        this.periodic = ApiTypeHelper.requireNonNull(builder.periodic, this, "periodic");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
        this.totalTime = builder.totalTime;
        this.totalTimeInMillis = ApiTypeHelper.requireNonNull(builder.totalTimeInMillis, this, "totalTimeInMillis");
    }

    public static FlushStats of(Function<FlushStats.Builder, ObjectBuilder<FlushStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of periodic flush operations.
     * <p>
     * API name: {@code periodic}
     * </p>
     */
    public final long periodic() {
        return this.periodic;
    }

    /**
     * Required - The total number of flush operations.
     * <p>
     * API name: {@code total}
     * </p>
     */
    public final long total() {
        return this.total;
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
        generator.writeKey("periodic");
        generator.write(this.periodic);

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
     * Builder for {@link FlushStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, FlushStats> {
        private Long periodic;
        private Long total;
        @Nullable
        private Time totalTime;
        private Long totalTimeInMillis;

        public Builder() {}

        private Builder(FlushStats o) {
            this.periodic = o.periodic;
            this.total = o.total;
            this.totalTime = o.totalTime;
            this.totalTimeInMillis = o.totalTimeInMillis;
        }

        private Builder(Builder o) {
            this.periodic = o.periodic;
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
         * Required - The number of periodic flush operations.
         * <p>
         * API name: {@code periodic}
         * </p>
         */
        @Nonnull
        public final Builder periodic(long value) {
            this.periodic = value;
            return this;
        }

        /**
         * Required - The total number of flush operations.
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
         * Builds a {@link FlushStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public FlushStats build() {
            _checkSingleUse();

            return new FlushStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link FlushStats}
     */
    public static final JsonpDeserializer<FlushStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        FlushStats::setupFlushStatsDeserializer
    );

    protected static void setupFlushStatsDeserializer(ObjectDeserializer<FlushStats.Builder> op) {
        op.add(Builder::periodic, JsonpDeserializer.longDeserializer(), "periodic");
        op.add(Builder::total, JsonpDeserializer.longDeserializer(), "total");
        op.add(Builder::totalTime, Time._DESERIALIZER, "total_time");
        op.add(Builder::totalTimeInMillis, JsonpDeserializer.longDeserializer(), "total_time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.periodic);
        result = 31 * result + Long.hashCode(this.total);
        result = 31 * result + Objects.hashCode(this.totalTime);
        result = 31 * result + Long.hashCode(this.totalTimeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FlushStats other = (FlushStats) o;
        return this.periodic == other.periodic
            && this.total == other.total
            && Objects.equals(this.totalTime, other.totalTime)
            && this.totalTimeInMillis == other.totalTimeInMillis;
    }
}
