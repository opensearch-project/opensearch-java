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

// typedef: nodes.stats.ShardResourceUsageStatsDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardResourceUsageStatsDetail
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardResourceUsageStatsDetail.Builder, ShardResourceUsageStatsDetail> {

    @Nullable
    private final String cpuUtilizationPercent;

    @Nullable
    private final ShardResourceUsageStatsIoUsageStats ioUsageStats;

    @Nullable
    private final String memoryUtilizationPercent;

    @Nullable
    private final Long timestamp;

    // ---------------------------------------------------------------------------------------------

    private ShardResourceUsageStatsDetail(Builder builder) {
        this.cpuUtilizationPercent = builder.cpuUtilizationPercent;
        this.ioUsageStats = builder.ioUsageStats;
        this.memoryUtilizationPercent = builder.memoryUtilizationPercent;
        this.timestamp = builder.timestamp;
    }

    public static ShardResourceUsageStatsDetail of(
        Function<ShardResourceUsageStatsDetail.Builder, ObjectBuilder<ShardResourceUsageStatsDetail>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code cpu_utilization_percent}
     */
    @Nullable
    public final String cpuUtilizationPercent() {
        return this.cpuUtilizationPercent;
    }

    /**
     * API name: {@code io_usage_stats}
     */
    @Nullable
    public final ShardResourceUsageStatsIoUsageStats ioUsageStats() {
        return this.ioUsageStats;
    }

    /**
     * API name: {@code memory_utilization_percent}
     */
    @Nullable
    public final String memoryUtilizationPercent() {
        return this.memoryUtilizationPercent;
    }

    /**
     * API name: {@code timestamp}
     */
    @Nullable
    public final Long timestamp() {
        return this.timestamp;
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
        if (this.cpuUtilizationPercent != null) {
            generator.writeKey("cpu_utilization_percent");
            generator.write(this.cpuUtilizationPercent);
        }

        if (this.ioUsageStats != null) {
            generator.writeKey("io_usage_stats");
            this.ioUsageStats.serialize(generator, mapper);
        }

        if (this.memoryUtilizationPercent != null) {
            generator.writeKey("memory_utilization_percent");
            generator.write(this.memoryUtilizationPercent);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
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
     * Builder for {@link ShardResourceUsageStatsDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardResourceUsageStatsDetail> {
        @Nullable
        private String cpuUtilizationPercent;
        @Nullable
        private ShardResourceUsageStatsIoUsageStats ioUsageStats;
        @Nullable
        private String memoryUtilizationPercent;
        @Nullable
        private Long timestamp;

        public Builder() {}

        private Builder(ShardResourceUsageStatsDetail o) {
            this.cpuUtilizationPercent = o.cpuUtilizationPercent;
            this.ioUsageStats = o.ioUsageStats;
            this.memoryUtilizationPercent = o.memoryUtilizationPercent;
            this.timestamp = o.timestamp;
        }

        private Builder(Builder o) {
            this.cpuUtilizationPercent = o.cpuUtilizationPercent;
            this.ioUsageStats = o.ioUsageStats;
            this.memoryUtilizationPercent = o.memoryUtilizationPercent;
            this.timestamp = o.timestamp;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code cpu_utilization_percent}
         */
        @Nonnull
        public final Builder cpuUtilizationPercent(@Nullable String value) {
            this.cpuUtilizationPercent = value;
            return this;
        }

        /**
         * API name: {@code io_usage_stats}
         */
        @Nonnull
        public final Builder ioUsageStats(@Nullable ShardResourceUsageStatsIoUsageStats value) {
            this.ioUsageStats = value;
            return this;
        }

        /**
         * API name: {@code io_usage_stats}
         */
        @Nonnull
        public final Builder ioUsageStats(
            Function<ShardResourceUsageStatsIoUsageStats.Builder, ObjectBuilder<ShardResourceUsageStatsIoUsageStats>> fn
        ) {
            return ioUsageStats(fn.apply(new ShardResourceUsageStatsIoUsageStats.Builder()).build());
        }

        /**
         * API name: {@code memory_utilization_percent}
         */
        @Nonnull
        public final Builder memoryUtilizationPercent(@Nullable String value) {
            this.memoryUtilizationPercent = value;
            return this;
        }

        /**
         * API name: {@code timestamp}
         */
        @Nonnull
        public final Builder timestamp(@Nullable Long value) {
            this.timestamp = value;
            return this;
        }

        /**
         * Builds a {@link ShardResourceUsageStatsDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardResourceUsageStatsDetail build() {
            _checkSingleUse();

            return new ShardResourceUsageStatsDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardResourceUsageStatsDetail}
     */
    public static final JsonpDeserializer<ShardResourceUsageStatsDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardResourceUsageStatsDetail::setupShardResourceUsageStatsDetailDeserializer
    );

    protected static void setupShardResourceUsageStatsDetailDeserializer(ObjectDeserializer<ShardResourceUsageStatsDetail.Builder> op) {
        op.add(Builder::cpuUtilizationPercent, JsonpDeserializer.stringDeserializer(), "cpu_utilization_percent");
        op.add(Builder::ioUsageStats, ShardResourceUsageStatsIoUsageStats._DESERIALIZER, "io_usage_stats");
        op.add(Builder::memoryUtilizationPercent, JsonpDeserializer.stringDeserializer(), "memory_utilization_percent");
        op.add(Builder::timestamp, JsonpDeserializer.longDeserializer(), "timestamp");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.cpuUtilizationPercent);
        result = 31 * result + Objects.hashCode(this.ioUsageStats);
        result = 31 * result + Objects.hashCode(this.memoryUtilizationPercent);
        result = 31 * result + Objects.hashCode(this.timestamp);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardResourceUsageStatsDetail other = (ShardResourceUsageStatsDetail) o;
        return Objects.equals(this.cpuUtilizationPercent, other.cpuUtilizationPercent)
            && Objects.equals(this.ioUsageStats, other.ioUsageStats)
            && Objects.equals(this.memoryUtilizationPercent, other.memoryUtilizationPercent)
            && Objects.equals(this.timestamp, other.timestamp);
    }
}
