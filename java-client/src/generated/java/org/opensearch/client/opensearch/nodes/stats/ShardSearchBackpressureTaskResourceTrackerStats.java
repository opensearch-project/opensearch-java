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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ShardSearchBackpressureTaskResourceTrackerStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchBackpressureTaskResourceTrackerStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchBackpressureTaskResourceTrackerStats.Builder, ShardSearchBackpressureTaskResourceTrackerStats> {

    @Nullable
    private final ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats cpuUsageTracker;

    @Nullable
    private final ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats elapsedTimeTracker;

    @Nullable
    private final ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats heapUsageTracker;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchBackpressureTaskResourceTrackerStats(Builder builder) {
        this.cpuUsageTracker = builder.cpuUsageTracker;
        this.elapsedTimeTracker = builder.elapsedTimeTracker;
        this.heapUsageTracker = builder.heapUsageTracker;
    }

    public static ShardSearchBackpressureTaskResourceTrackerStats of(
        Function<ShardSearchBackpressureTaskResourceTrackerStats.Builder, ObjectBuilder<ShardSearchBackpressureTaskResourceTrackerStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cpu_usage_tracker}
     */
    @Nullable
    public final ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats cpuUsageTracker() {
        return this.cpuUsageTracker;
    }

    /**
     * API name: {@code elapsed_time_tracker}
     */
    @Nullable
    public final ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats elapsedTimeTracker() {
        return this.elapsedTimeTracker;
    }

    /**
     * API name: {@code heap_usage_tracker}
     */
    @Nullable
    public final ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats heapUsageTracker() {
        return this.heapUsageTracker;
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
        if (this.cpuUsageTracker != null) {
            generator.writeKey("cpu_usage_tracker");
            this.cpuUsageTracker.serialize(generator, mapper);
        }

        if (this.elapsedTimeTracker != null) {
            generator.writeKey("elapsed_time_tracker");
            this.elapsedTimeTracker.serialize(generator, mapper);
        }

        if (this.heapUsageTracker != null) {
            generator.writeKey("heap_usage_tracker");
            this.heapUsageTracker.serialize(generator, mapper);
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
     * Builder for {@link ShardSearchBackpressureTaskResourceTrackerStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardSearchBackpressureTaskResourceTrackerStats> {
        @Nullable
        private ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats cpuUsageTracker;
        @Nullable
        private ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats elapsedTimeTracker;
        @Nullable
        private ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats heapUsageTracker;

        public Builder() {}

        private Builder(ShardSearchBackpressureTaskResourceTrackerStats o) {
            this.cpuUsageTracker = o.cpuUsageTracker;
            this.elapsedTimeTracker = o.elapsedTimeTracker;
            this.heapUsageTracker = o.heapUsageTracker;
        }

        private Builder(Builder o) {
            this.cpuUsageTracker = o.cpuUsageTracker;
            this.elapsedTimeTracker = o.elapsedTimeTracker;
            this.heapUsageTracker = o.heapUsageTracker;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cpu_usage_tracker}
         */
        @Nonnull
        public final Builder cpuUsageTracker(@Nullable ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats value) {
            this.cpuUsageTracker = value;
            return this;
        }

        /**
         * API name: {@code cpu_usage_tracker}
         */
        @Nonnull
        public final Builder cpuUsageTracker(
            Function<
                ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats.Builder,
                ObjectBuilder<ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats>> fn
        ) {
            return cpuUsageTracker(fn.apply(new ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats.Builder()).build());
        }

        /**
         * API name: {@code elapsed_time_tracker}
         */
        @Nonnull
        public final Builder elapsedTimeTracker(@Nullable ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats value) {
            this.elapsedTimeTracker = value;
            return this;
        }

        /**
         * API name: {@code elapsed_time_tracker}
         */
        @Nonnull
        public final Builder elapsedTimeTracker(
            Function<
                ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats.Builder,
                ObjectBuilder<ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats>> fn
        ) {
            return elapsedTimeTracker(fn.apply(new ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats.Builder()).build());
        }

        /**
         * API name: {@code heap_usage_tracker}
         */
        @Nonnull
        public final Builder heapUsageTracker(@Nullable ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats value) {
            this.heapUsageTracker = value;
            return this;
        }

        /**
         * API name: {@code heap_usage_tracker}
         */
        @Nonnull
        public final Builder heapUsageTracker(
            Function<
                ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats.Builder,
                ObjectBuilder<ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats>> fn
        ) {
            return heapUsageTracker(fn.apply(new ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardSearchBackpressureTaskResourceTrackerStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchBackpressureTaskResourceTrackerStats build() {
            _checkSingleUse();

            return new ShardSearchBackpressureTaskResourceTrackerStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchBackpressureTaskResourceTrackerStats}
     */
    public static final JsonpDeserializer<ShardSearchBackpressureTaskResourceTrackerStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchBackpressureTaskResourceTrackerStats::setupShardSearchBackpressureTaskResourceTrackerStatsDeserializer
    );

    protected static void setupShardSearchBackpressureTaskResourceTrackerStatsDeserializer(
        ObjectDeserializer<ShardSearchBackpressureTaskResourceTrackerStats.Builder> op
    ) {
        op.add(Builder::cpuUsageTracker, ShardSearchBackpressureTaskResourceTrackerCpuUsageTrackerStats._DESERIALIZER, "cpu_usage_tracker");
        op.add(
            Builder::elapsedTimeTracker,
            ShardSearchBackpressureTaskResourceTrackerElapsedTimeTrackerStats._DESERIALIZER,
            "elapsed_time_tracker"
        );
        op.add(
            Builder::heapUsageTracker,
            ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats._DESERIALIZER,
            "heap_usage_tracker"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cpuUsageTracker);
        result = 31 * result + Objects.hashCode(this.elapsedTimeTracker);
        result = 31 * result + Objects.hashCode(this.heapUsageTracker);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchBackpressureTaskResourceTrackerStats other = (ShardSearchBackpressureTaskResourceTrackerStats) o;
        return Objects.equals(this.cpuUsageTracker, other.cpuUsageTracker)
            && Objects.equals(this.elapsedTimeTracker, other.elapsedTimeTracker)
            && Objects.equals(this.heapUsageTracker, other.heapUsageTracker);
    }
}
