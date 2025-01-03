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

package org.opensearch.client.opensearch.nodes.stats;

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

// typedef: nodes.stats.ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<
            ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats.Builder,
            ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats> {

    @Nullable
    private final Long cancellationCount;

    @Nullable
    private final Time currentAvg;

    @Nullable
    private final Long currentAvgMillis;

    @Nullable
    private final Time currentMax;

    @Nullable
    private final Long currentMaxMillis;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats(Builder builder) {
        this.cancellationCount = builder.cancellationCount;
        this.currentAvg = builder.currentAvg;
        this.currentAvgMillis = builder.currentAvgMillis;
        this.currentMax = builder.currentMax;
        this.currentMaxMillis = builder.currentMaxMillis;
    }

    public static ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats of(
        Function<
            ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats.Builder,
            ObjectBuilder<ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cancellation_count}
     */
    @Nullable
    public final Long cancellationCount() {
        return this.cancellationCount;
    }

    /**
     * API name: {@code current_avg}
     */
    @Nullable
    public final Time currentAvg() {
        return this.currentAvg;
    }

    /**
     * API name: {@code current_avg_millis}
     */
    @Nullable
    public final Long currentAvgMillis() {
        return this.currentAvgMillis;
    }

    /**
     * API name: {@code current_max}
     */
    @Nullable
    public final Time currentMax() {
        return this.currentMax;
    }

    /**
     * API name: {@code current_max_millis}
     */
    @Nullable
    public final Long currentMaxMillis() {
        return this.currentMaxMillis;
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
        if (this.cancellationCount != null) {
            generator.writeKey("cancellation_count");
            generator.write(this.cancellationCount);
        }

        if (this.currentAvg != null) {
            generator.writeKey("current_avg");
            this.currentAvg.serialize(generator, mapper);
        }

        if (this.currentAvgMillis != null) {
            generator.writeKey("current_avg_millis");
            generator.write(this.currentAvgMillis);
        }

        if (this.currentMax != null) {
            generator.writeKey("current_max");
            this.currentMax.serialize(generator, mapper);
        }

        if (this.currentMaxMillis != null) {
            generator.writeKey("current_max_millis");
            generator.write(this.currentMaxMillis);
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
     * Builder for {@link ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats> {
        @Nullable
        private Long cancellationCount;
        @Nullable
        private Time currentAvg;
        @Nullable
        private Long currentAvgMillis;
        @Nullable
        private Time currentMax;
        @Nullable
        private Long currentMaxMillis;

        public Builder() {}

        private Builder(ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats o) {
            this.cancellationCount = o.cancellationCount;
            this.currentAvg = o.currentAvg;
            this.currentAvgMillis = o.currentAvgMillis;
            this.currentMax = o.currentMax;
            this.currentMaxMillis = o.currentMaxMillis;
        }

        private Builder(Builder o) {
            this.cancellationCount = o.cancellationCount;
            this.currentAvg = o.currentAvg;
            this.currentAvgMillis = o.currentAvgMillis;
            this.currentMax = o.currentMax;
            this.currentMaxMillis = o.currentMaxMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cancellation_count}
         */
        @Nonnull
        public final Builder cancellationCount(@Nullable Long value) {
            this.cancellationCount = value;
            return this;
        }

        /**
         * API name: {@code current_avg}
         */
        @Nonnull
        public final Builder currentAvg(@Nullable Time value) {
            this.currentAvg = value;
            return this;
        }

        /**
         * API name: {@code current_avg}
         */
        @Nonnull
        public final Builder currentAvg(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return currentAvg(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code current_avg_millis}
         */
        @Nonnull
        public final Builder currentAvgMillis(@Nullable Long value) {
            this.currentAvgMillis = value;
            return this;
        }

        /**
         * API name: {@code current_max}
         */
        @Nonnull
        public final Builder currentMax(@Nullable Time value) {
            this.currentMax = value;
            return this;
        }

        /**
         * API name: {@code current_max}
         */
        @Nonnull
        public final Builder currentMax(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return currentMax(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code current_max_millis}
         */
        @Nonnull
        public final Builder currentMaxMillis(@Nullable Long value) {
            this.currentMaxMillis = value;
            return this;
        }

        /**
         * Builds a {@link ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats build() {
            _checkSingleUse();

            return new ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats}
     */
    public static final JsonpDeserializer<ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats> _DESERIALIZER =
        ObjectBuilderDeserializer.lazy(
            Builder::new,
            ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats::setupShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStatsDeserializer
        );

    protected static void setupShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStatsDeserializer(
        ObjectDeserializer<ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats.Builder> op
    ) {
        op.add(Builder::cancellationCount, JsonpDeserializer.longDeserializer(), "cancellation_count");
        op.add(Builder::currentAvg, Time._DESERIALIZER, "current_avg");
        op.add(Builder::currentAvgMillis, JsonpDeserializer.longDeserializer(), "current_avg_millis");
        op.add(Builder::currentMax, Time._DESERIALIZER, "current_max");
        op.add(Builder::currentMaxMillis, JsonpDeserializer.longDeserializer(), "current_max_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cancellationCount);
        result = 31 * result + Objects.hashCode(this.currentAvg);
        result = 31 * result + Objects.hashCode(this.currentAvgMillis);
        result = 31 * result + Objects.hashCode(this.currentMax);
        result = 31 * result + Objects.hashCode(this.currentMaxMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats other =
            (ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats) o;
        return Objects.equals(this.cancellationCount, other.cancellationCount)
            && Objects.equals(this.currentAvg, other.currentAvg)
            && Objects.equals(this.currentAvgMillis, other.currentAvgMillis)
            && Objects.equals(this.currentMax, other.currentMax)
            && Objects.equals(this.currentMaxMillis, other.currentMaxMillis);
    }
}
