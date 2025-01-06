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

// typedef: nodes.stats.ShardSearchBackpressureTaskStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchBackpressureTaskStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchBackpressureTaskStats.Builder, ShardSearchBackpressureTaskStats> {

    @Nullable
    private final ShardSearchBackpressureTaskCancellationStats cancellationStats;

    @Nullable
    private final Long completionCount;

    @Nullable
    private final ShardSearchBackpressureTaskResourceTrackerStats resourceTrackerStats;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchBackpressureTaskStats(Builder builder) {
        this.cancellationStats = builder.cancellationStats;
        this.completionCount = builder.completionCount;
        this.resourceTrackerStats = builder.resourceTrackerStats;
    }

    public static ShardSearchBackpressureTaskStats of(
        Function<ShardSearchBackpressureTaskStats.Builder, ObjectBuilder<ShardSearchBackpressureTaskStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cancellation_stats}
     */
    @Nullable
    public final ShardSearchBackpressureTaskCancellationStats cancellationStats() {
        return this.cancellationStats;
    }

    /**
     * API name: {@code completion_count}
     */
    @Nullable
    public final Long completionCount() {
        return this.completionCount;
    }

    /**
     * API name: {@code resource_tracker_stats}
     */
    @Nullable
    public final ShardSearchBackpressureTaskResourceTrackerStats resourceTrackerStats() {
        return this.resourceTrackerStats;
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
        if (this.cancellationStats != null) {
            generator.writeKey("cancellation_stats");
            this.cancellationStats.serialize(generator, mapper);
        }

        if (this.completionCount != null) {
            generator.writeKey("completion_count");
            generator.write(this.completionCount);
        }

        if (this.resourceTrackerStats != null) {
            generator.writeKey("resource_tracker_stats");
            this.resourceTrackerStats.serialize(generator, mapper);
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
     * Builder for {@link ShardSearchBackpressureTaskStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSearchBackpressureTaskStats> {
        @Nullable
        private ShardSearchBackpressureTaskCancellationStats cancellationStats;
        @Nullable
        private Long completionCount;
        @Nullable
        private ShardSearchBackpressureTaskResourceTrackerStats resourceTrackerStats;

        public Builder() {}

        private Builder(ShardSearchBackpressureTaskStats o) {
            this.cancellationStats = o.cancellationStats;
            this.completionCount = o.completionCount;
            this.resourceTrackerStats = o.resourceTrackerStats;
        }

        private Builder(Builder o) {
            this.cancellationStats = o.cancellationStats;
            this.completionCount = o.completionCount;
            this.resourceTrackerStats = o.resourceTrackerStats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cancellation_stats}
         */
        @Nonnull
        public final Builder cancellationStats(@Nullable ShardSearchBackpressureTaskCancellationStats value) {
            this.cancellationStats = value;
            return this;
        }

        /**
         * API name: {@code cancellation_stats}
         */
        @Nonnull
        public final Builder cancellationStats(
            Function<ShardSearchBackpressureTaskCancellationStats.Builder, ObjectBuilder<ShardSearchBackpressureTaskCancellationStats>> fn
        ) {
            return cancellationStats(fn.apply(new ShardSearchBackpressureTaskCancellationStats.Builder()).build());
        }

        /**
         * API name: {@code completion_count}
         */
        @Nonnull
        public final Builder completionCount(@Nullable Long value) {
            this.completionCount = value;
            return this;
        }

        /**
         * API name: {@code resource_tracker_stats}
         */
        @Nonnull
        public final Builder resourceTrackerStats(@Nullable ShardSearchBackpressureTaskResourceTrackerStats value) {
            this.resourceTrackerStats = value;
            return this;
        }

        /**
         * API name: {@code resource_tracker_stats}
         */
        @Nonnull
        public final Builder resourceTrackerStats(
            Function<
                ShardSearchBackpressureTaskResourceTrackerStats.Builder,
                ObjectBuilder<ShardSearchBackpressureTaskResourceTrackerStats>> fn
        ) {
            return resourceTrackerStats(fn.apply(new ShardSearchBackpressureTaskResourceTrackerStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardSearchBackpressureTaskStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchBackpressureTaskStats build() {
            _checkSingleUse();

            return new ShardSearchBackpressureTaskStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchBackpressureTaskStats}
     */
    public static final JsonpDeserializer<ShardSearchBackpressureTaskStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchBackpressureTaskStats::setupShardSearchBackpressureTaskStatsDeserializer
    );

    protected static void setupShardSearchBackpressureTaskStatsDeserializer(
        ObjectDeserializer<ShardSearchBackpressureTaskStats.Builder> op
    ) {
        op.add(Builder::cancellationStats, ShardSearchBackpressureTaskCancellationStats._DESERIALIZER, "cancellation_stats");
        op.add(Builder::completionCount, JsonpDeserializer.longDeserializer(), "completion_count");
        op.add(Builder::resourceTrackerStats, ShardSearchBackpressureTaskResourceTrackerStats._DESERIALIZER, "resource_tracker_stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cancellationStats);
        result = 31 * result + Objects.hashCode(this.completionCount);
        result = 31 * result + Objects.hashCode(this.resourceTrackerStats);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchBackpressureTaskStats other = (ShardSearchBackpressureTaskStats) o;
        return Objects.equals(this.cancellationStats, other.cancellationStats)
            && Objects.equals(this.completionCount, other.completionCount)
            && Objects.equals(this.resourceTrackerStats, other.resourceTrackerStats);
    }
}
