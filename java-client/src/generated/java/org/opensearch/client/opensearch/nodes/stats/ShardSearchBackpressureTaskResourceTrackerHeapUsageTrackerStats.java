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

// typedef: nodes.stats.ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<
            ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats.Builder,
            ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats> {

    @Nullable
    private final Long cancellationCount;

    @Nullable
    private final String currentAvg;

    @Nullable
    private final Long currentAvgBytes;

    @Nullable
    private final String currentMax;

    @Nullable
    private final Long currentMaxBytes;

    @Nullable
    private final String rollingAvg;

    @Nullable
    private final Long rollingAvgBytes;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats(Builder builder) {
        this.cancellationCount = builder.cancellationCount;
        this.currentAvg = builder.currentAvg;
        this.currentAvgBytes = builder.currentAvgBytes;
        this.currentMax = builder.currentMax;
        this.currentMaxBytes = builder.currentMaxBytes;
        this.rollingAvg = builder.rollingAvg;
        this.rollingAvgBytes = builder.rollingAvgBytes;
    }

    public static ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats of(
        Function<
            ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats.Builder,
            ObjectBuilder<ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats>> fn
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
    public final String currentAvg() {
        return this.currentAvg;
    }

    /**
     * API name: {@code current_avg_bytes}
     */
    @Nullable
    public final Long currentAvgBytes() {
        return this.currentAvgBytes;
    }

    /**
     * API name: {@code current_max}
     */
    @Nullable
    public final String currentMax() {
        return this.currentMax;
    }

    /**
     * API name: {@code current_max_bytes}
     */
    @Nullable
    public final Long currentMaxBytes() {
        return this.currentMaxBytes;
    }

    /**
     * API name: {@code rolling_avg}
     */
    @Nullable
    public final String rollingAvg() {
        return this.rollingAvg;
    }

    /**
     * API name: {@code rolling_avg_bytes}
     */
    @Nullable
    public final Long rollingAvgBytes() {
        return this.rollingAvgBytes;
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
            generator.write(this.currentAvg);
        }

        if (this.currentAvgBytes != null) {
            generator.writeKey("current_avg_bytes");
            generator.write(this.currentAvgBytes);
        }

        if (this.currentMax != null) {
            generator.writeKey("current_max");
            generator.write(this.currentMax);
        }

        if (this.currentMaxBytes != null) {
            generator.writeKey("current_max_bytes");
            generator.write(this.currentMaxBytes);
        }

        if (this.rollingAvg != null) {
            generator.writeKey("rolling_avg");
            generator.write(this.rollingAvg);
        }

        if (this.rollingAvgBytes != null) {
            generator.writeKey("rolling_avg_bytes");
            generator.write(this.rollingAvgBytes);
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
     * Builder for {@link ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats> {
        @Nullable
        private Long cancellationCount;
        @Nullable
        private String currentAvg;
        @Nullable
        private Long currentAvgBytes;
        @Nullable
        private String currentMax;
        @Nullable
        private Long currentMaxBytes;
        @Nullable
        private String rollingAvg;
        @Nullable
        private Long rollingAvgBytes;

        public Builder() {}

        private Builder(ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats o) {
            this.cancellationCount = o.cancellationCount;
            this.currentAvg = o.currentAvg;
            this.currentAvgBytes = o.currentAvgBytes;
            this.currentMax = o.currentMax;
            this.currentMaxBytes = o.currentMaxBytes;
            this.rollingAvg = o.rollingAvg;
            this.rollingAvgBytes = o.rollingAvgBytes;
        }

        private Builder(Builder o) {
            this.cancellationCount = o.cancellationCount;
            this.currentAvg = o.currentAvg;
            this.currentAvgBytes = o.currentAvgBytes;
            this.currentMax = o.currentMax;
            this.currentMaxBytes = o.currentMaxBytes;
            this.rollingAvg = o.rollingAvg;
            this.rollingAvgBytes = o.rollingAvgBytes;
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
        public final Builder currentAvg(@Nullable String value) {
            this.currentAvg = value;
            return this;
        }

        /**
         * API name: {@code current_avg_bytes}
         */
        @Nonnull
        public final Builder currentAvgBytes(@Nullable Long value) {
            this.currentAvgBytes = value;
            return this;
        }

        /**
         * API name: {@code current_max}
         */
        @Nonnull
        public final Builder currentMax(@Nullable String value) {
            this.currentMax = value;
            return this;
        }

        /**
         * API name: {@code current_max_bytes}
         */
        @Nonnull
        public final Builder currentMaxBytes(@Nullable Long value) {
            this.currentMaxBytes = value;
            return this;
        }

        /**
         * API name: {@code rolling_avg}
         */
        @Nonnull
        public final Builder rollingAvg(@Nullable String value) {
            this.rollingAvg = value;
            return this;
        }

        /**
         * API name: {@code rolling_avg_bytes}
         */
        @Nonnull
        public final Builder rollingAvgBytes(@Nullable Long value) {
            this.rollingAvgBytes = value;
            return this;
        }

        /**
         * Builds a {@link ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats build() {
            _checkSingleUse();

            return new ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats}
     */
    public static final JsonpDeserializer<ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats> _DESERIALIZER =
        ObjectBuilderDeserializer.lazy(
            Builder::new,
            ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats::setupShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStatsDeserializer
        );

    protected static void setupShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStatsDeserializer(
        ObjectDeserializer<ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats.Builder> op
    ) {
        op.add(Builder::cancellationCount, JsonpDeserializer.longDeserializer(), "cancellation_count");
        op.add(Builder::currentAvg, JsonpDeserializer.stringDeserializer(), "current_avg");
        op.add(Builder::currentAvgBytes, JsonpDeserializer.longDeserializer(), "current_avg_bytes");
        op.add(Builder::currentMax, JsonpDeserializer.stringDeserializer(), "current_max");
        op.add(Builder::currentMaxBytes, JsonpDeserializer.longDeserializer(), "current_max_bytes");
        op.add(Builder::rollingAvg, JsonpDeserializer.stringDeserializer(), "rolling_avg");
        op.add(Builder::rollingAvgBytes, JsonpDeserializer.longDeserializer(), "rolling_avg_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cancellationCount);
        result = 31 * result + Objects.hashCode(this.currentAvg);
        result = 31 * result + Objects.hashCode(this.currentAvgBytes);
        result = 31 * result + Objects.hashCode(this.currentMax);
        result = 31 * result + Objects.hashCode(this.currentMaxBytes);
        result = 31 * result + Objects.hashCode(this.rollingAvg);
        result = 31 * result + Objects.hashCode(this.rollingAvgBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats other =
            (ShardSearchBackpressureTaskResourceTrackerHeapUsageTrackerStats) o;
        return Objects.equals(this.cancellationCount, other.cancellationCount)
            && Objects.equals(this.currentAvg, other.currentAvg)
            && Objects.equals(this.currentAvgBytes, other.currentAvgBytes)
            && Objects.equals(this.currentMax, other.currentMax)
            && Objects.equals(this.currentMaxBytes, other.currentMaxBytes)
            && Objects.equals(this.rollingAvg, other.rollingAvg)
            && Objects.equals(this.rollingAvgBytes, other.rollingAvgBytes);
    }
}
