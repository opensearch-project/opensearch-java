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

// typedef: nodes.stats.ShardIndexingPressureRejectionsBreakupStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressureRejectionsBreakupStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressureRejectionsBreakupStats.Builder, ShardIndexingPressureRejectionsBreakupStats> {

    @Nullable
    private final Long noSuccessfulRequestLimits;

    @Nullable
    private final Long nodeLimits;

    @Nullable
    private final Long throughputDegradationLimits;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressureRejectionsBreakupStats(Builder builder) {
        this.noSuccessfulRequestLimits = builder.noSuccessfulRequestLimits;
        this.nodeLimits = builder.nodeLimits;
        this.throughputDegradationLimits = builder.throughputDegradationLimits;
    }

    public static ShardIndexingPressureRejectionsBreakupStats of(
        Function<ShardIndexingPressureRejectionsBreakupStats.Builder, ObjectBuilder<ShardIndexingPressureRejectionsBreakupStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code no_successful_request_limits}
     */
    @Nullable
    public final Long noSuccessfulRequestLimits() {
        return this.noSuccessfulRequestLimits;
    }

    /**
     * API name: {@code node_limits}
     */
    @Nullable
    public final Long nodeLimits() {
        return this.nodeLimits;
    }

    /**
     * API name: {@code throughput_degradation_limits}
     */
    @Nullable
    public final Long throughputDegradationLimits() {
        return this.throughputDegradationLimits;
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
        if (this.noSuccessfulRequestLimits != null) {
            generator.writeKey("no_successful_request_limits");
            generator.write(this.noSuccessfulRequestLimits);
        }

        if (this.nodeLimits != null) {
            generator.writeKey("node_limits");
            generator.write(this.nodeLimits);
        }

        if (this.throughputDegradationLimits != null) {
            generator.writeKey("throughput_degradation_limits");
            generator.write(this.throughputDegradationLimits);
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
     * Builder for {@link ShardIndexingPressureRejectionsBreakupStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardIndexingPressureRejectionsBreakupStats> {
        @Nullable
        private Long noSuccessfulRequestLimits;
        @Nullable
        private Long nodeLimits;
        @Nullable
        private Long throughputDegradationLimits;

        public Builder() {}

        private Builder(ShardIndexingPressureRejectionsBreakupStats o) {
            this.noSuccessfulRequestLimits = o.noSuccessfulRequestLimits;
            this.nodeLimits = o.nodeLimits;
            this.throughputDegradationLimits = o.throughputDegradationLimits;
        }

        private Builder(Builder o) {
            this.noSuccessfulRequestLimits = o.noSuccessfulRequestLimits;
            this.nodeLimits = o.nodeLimits;
            this.throughputDegradationLimits = o.throughputDegradationLimits;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code no_successful_request_limits}
         */
        @Nonnull
        public final Builder noSuccessfulRequestLimits(@Nullable Long value) {
            this.noSuccessfulRequestLimits = value;
            return this;
        }

        /**
         * API name: {@code node_limits}
         */
        @Nonnull
        public final Builder nodeLimits(@Nullable Long value) {
            this.nodeLimits = value;
            return this;
        }

        /**
         * API name: {@code throughput_degradation_limits}
         */
        @Nonnull
        public final Builder throughputDegradationLimits(@Nullable Long value) {
            this.throughputDegradationLimits = value;
            return this;
        }

        /**
         * Builds a {@link ShardIndexingPressureRejectionsBreakupStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressureRejectionsBreakupStats build() {
            _checkSingleUse();

            return new ShardIndexingPressureRejectionsBreakupStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressureRejectionsBreakupStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressureRejectionsBreakupStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIndexingPressureRejectionsBreakupStats::setupShardIndexingPressureRejectionsBreakupStatsDeserializer
    );

    protected static void setupShardIndexingPressureRejectionsBreakupStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressureRejectionsBreakupStats.Builder> op
    ) {
        op.add(Builder::noSuccessfulRequestLimits, JsonpDeserializer.longDeserializer(), "no_successful_request_limits");
        op.add(Builder::nodeLimits, JsonpDeserializer.longDeserializer(), "node_limits");
        op.add(Builder::throughputDegradationLimits, JsonpDeserializer.longDeserializer(), "throughput_degradation_limits");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.noSuccessfulRequestLimits);
        result = 31 * result + Objects.hashCode(this.nodeLimits);
        result = 31 * result + Objects.hashCode(this.throughputDegradationLimits);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressureRejectionsBreakupStats other = (ShardIndexingPressureRejectionsBreakupStats) o;
        return Objects.equals(this.noSuccessfulRequestLimits, other.noSuccessfulRequestLimits)
            && Objects.equals(this.nodeLimits, other.nodeLimits)
            && Objects.equals(this.throughputDegradationLimits, other.throughputDegradationLimits);
    }
}
