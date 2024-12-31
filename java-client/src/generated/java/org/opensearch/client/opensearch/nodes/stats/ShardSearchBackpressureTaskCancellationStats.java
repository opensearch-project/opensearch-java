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

// typedef: nodes.stats.ShardSearchBackpressureTaskCancellationStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchBackpressureTaskCancellationStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchBackpressureTaskCancellationStats.Builder, ShardSearchBackpressureTaskCancellationStats> {

    @Nullable
    private final Long cancellationCount;

    @Nullable
    private final Long cancellationLimitReachedCount;

    @Nullable
    private final Double cancelledTaskPercentage;

    @Nullable
    private final Long currentCancellationEligibleTasksCount;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchBackpressureTaskCancellationStats(Builder builder) {
        this.cancellationCount = builder.cancellationCount;
        this.cancellationLimitReachedCount = builder.cancellationLimitReachedCount;
        this.cancelledTaskPercentage = builder.cancelledTaskPercentage;
        this.currentCancellationEligibleTasksCount = builder.currentCancellationEligibleTasksCount;
    }

    public static ShardSearchBackpressureTaskCancellationStats of(
        Function<ShardSearchBackpressureTaskCancellationStats.Builder, ObjectBuilder<ShardSearchBackpressureTaskCancellationStats>> fn
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
     * API name: {@code cancellation_limit_reached_count}
     */
    @Nullable
    public final Long cancellationLimitReachedCount() {
        return this.cancellationLimitReachedCount;
    }

    /**
     * API name: {@code cancelled_task_percentage}
     */
    @Nullable
    public final Double cancelledTaskPercentage() {
        return this.cancelledTaskPercentage;
    }

    /**
     * API name: {@code current_cancellation_eligible_tasks_count}
     */
    @Nullable
    public final Long currentCancellationEligibleTasksCount() {
        return this.currentCancellationEligibleTasksCount;
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

        if (this.cancellationLimitReachedCount != null) {
            generator.writeKey("cancellation_limit_reached_count");
            generator.write(this.cancellationLimitReachedCount);
        }

        if (this.cancelledTaskPercentage != null) {
            generator.writeKey("cancelled_task_percentage");
            generator.write(this.cancelledTaskPercentage);
        }

        if (this.currentCancellationEligibleTasksCount != null) {
            generator.writeKey("current_cancellation_eligible_tasks_count");
            generator.write(this.currentCancellationEligibleTasksCount);
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
     * Builder for {@link ShardSearchBackpressureTaskCancellationStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardSearchBackpressureTaskCancellationStats> {
        @Nullable
        private Long cancellationCount;
        @Nullable
        private Long cancellationLimitReachedCount;
        @Nullable
        private Double cancelledTaskPercentage;
        @Nullable
        private Long currentCancellationEligibleTasksCount;

        public Builder() {}

        private Builder(ShardSearchBackpressureTaskCancellationStats o) {
            this.cancellationCount = o.cancellationCount;
            this.cancellationLimitReachedCount = o.cancellationLimitReachedCount;
            this.cancelledTaskPercentage = o.cancelledTaskPercentage;
            this.currentCancellationEligibleTasksCount = o.currentCancellationEligibleTasksCount;
        }

        private Builder(Builder o) {
            this.cancellationCount = o.cancellationCount;
            this.cancellationLimitReachedCount = o.cancellationLimitReachedCount;
            this.cancelledTaskPercentage = o.cancelledTaskPercentage;
            this.currentCancellationEligibleTasksCount = o.currentCancellationEligibleTasksCount;
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
         * API name: {@code cancellation_limit_reached_count}
         */
        @Nonnull
        public final Builder cancellationLimitReachedCount(@Nullable Long value) {
            this.cancellationLimitReachedCount = value;
            return this;
        }

        /**
         * API name: {@code cancelled_task_percentage}
         */
        @Nonnull
        public final Builder cancelledTaskPercentage(@Nullable Double value) {
            this.cancelledTaskPercentage = value;
            return this;
        }

        /**
         * API name: {@code current_cancellation_eligible_tasks_count}
         */
        @Nonnull
        public final Builder currentCancellationEligibleTasksCount(@Nullable Long value) {
            this.currentCancellationEligibleTasksCount = value;
            return this;
        }

        /**
         * Builds a {@link ShardSearchBackpressureTaskCancellationStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchBackpressureTaskCancellationStats build() {
            _checkSingleUse();

            return new ShardSearchBackpressureTaskCancellationStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchBackpressureTaskCancellationStats}
     */
    public static final JsonpDeserializer<ShardSearchBackpressureTaskCancellationStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchBackpressureTaskCancellationStats::setupShardSearchBackpressureTaskCancellationStatsDeserializer
    );

    protected static void setupShardSearchBackpressureTaskCancellationStatsDeserializer(
        ObjectDeserializer<ShardSearchBackpressureTaskCancellationStats.Builder> op
    ) {
        op.add(Builder::cancellationCount, JsonpDeserializer.longDeserializer(), "cancellation_count");
        op.add(Builder::cancellationLimitReachedCount, JsonpDeserializer.longDeserializer(), "cancellation_limit_reached_count");
        op.add(Builder::cancelledTaskPercentage, JsonpDeserializer.doubleDeserializer(), "cancelled_task_percentage");
        op.add(
            Builder::currentCancellationEligibleTasksCount,
            JsonpDeserializer.longDeserializer(),
            "current_cancellation_eligible_tasks_count"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cancellationCount);
        result = 31 * result + Objects.hashCode(this.cancellationLimitReachedCount);
        result = 31 * result + Objects.hashCode(this.cancelledTaskPercentage);
        result = 31 * result + Objects.hashCode(this.currentCancellationEligibleTasksCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchBackpressureTaskCancellationStats other = (ShardSearchBackpressureTaskCancellationStats) o;
        return Objects.equals(this.cancellationCount, other.cancellationCount)
            && Objects.equals(this.cancellationLimitReachedCount, other.cancellationLimitReachedCount)
            && Objects.equals(this.cancelledTaskPercentage, other.cancelledTaskPercentage)
            && Objects.equals(this.currentCancellationEligibleTasksCount, other.currentCancellationEligibleTasksCount);
    }
}
