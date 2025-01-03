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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ShardIndexingPressurePerShardRejectionCoordinatingStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardRejectionCoordinatingStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<
            ShardIndexingPressurePerShardRejectionCoordinatingStats.Builder,
            ShardIndexingPressurePerShardRejectionCoordinatingStats> {

    @Nullable
    private final ShardIndexingPressureRejectionsBreakupStats breakup;

    @Nullable
    private final ShardIndexingPressureRejectionsBreakupStats breakupShadowMode;

    private final long coordinatingRejections;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardRejectionCoordinatingStats(Builder builder) {
        this.breakup = builder.breakup;
        this.breakupShadowMode = builder.breakupShadowMode;
        this.coordinatingRejections = ApiTypeHelper.requireNonNull(builder.coordinatingRejections, this, "coordinatingRejections");
    }

    public static ShardIndexingPressurePerShardRejectionCoordinatingStats of(
        Function<
            ShardIndexingPressurePerShardRejectionCoordinatingStats.Builder,
            ObjectBuilder<ShardIndexingPressurePerShardRejectionCoordinatingStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code breakup}
     */
    @Nullable
    public final ShardIndexingPressureRejectionsBreakupStats breakup() {
        return this.breakup;
    }

    /**
     * API name: {@code breakup_shadow_mode}
     */
    @Nullable
    public final ShardIndexingPressureRejectionsBreakupStats breakupShadowMode() {
        return this.breakupShadowMode;
    }

    /**
     * Required - API name: {@code coordinating_rejections}
     */
    public final long coordinatingRejections() {
        return this.coordinatingRejections;
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
        if (this.breakup != null) {
            generator.writeKey("breakup");
            this.breakup.serialize(generator, mapper);
        }

        if (this.breakupShadowMode != null) {
            generator.writeKey("breakup_shadow_mode");
            this.breakupShadowMode.serialize(generator, mapper);
        }

        generator.writeKey("coordinating_rejections");
        generator.write(this.coordinatingRejections);
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
     * Builder for {@link ShardIndexingPressurePerShardRejectionCoordinatingStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardIndexingPressurePerShardRejectionCoordinatingStats> {
        @Nullable
        private ShardIndexingPressureRejectionsBreakupStats breakup;
        @Nullable
        private ShardIndexingPressureRejectionsBreakupStats breakupShadowMode;
        private Long coordinatingRejections;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardRejectionCoordinatingStats o) {
            this.breakup = o.breakup;
            this.breakupShadowMode = o.breakupShadowMode;
            this.coordinatingRejections = o.coordinatingRejections;
        }

        private Builder(Builder o) {
            this.breakup = o.breakup;
            this.breakupShadowMode = o.breakupShadowMode;
            this.coordinatingRejections = o.coordinatingRejections;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code breakup}
         */
        @Nonnull
        public final Builder breakup(@Nullable ShardIndexingPressureRejectionsBreakupStats value) {
            this.breakup = value;
            return this;
        }

        /**
         * API name: {@code breakup}
         */
        @Nonnull
        public final Builder breakup(
            Function<ShardIndexingPressureRejectionsBreakupStats.Builder, ObjectBuilder<ShardIndexingPressureRejectionsBreakupStats>> fn
        ) {
            return breakup(fn.apply(new ShardIndexingPressureRejectionsBreakupStats.Builder()).build());
        }

        /**
         * API name: {@code breakup_shadow_mode}
         */
        @Nonnull
        public final Builder breakupShadowMode(@Nullable ShardIndexingPressureRejectionsBreakupStats value) {
            this.breakupShadowMode = value;
            return this;
        }

        /**
         * API name: {@code breakup_shadow_mode}
         */
        @Nonnull
        public final Builder breakupShadowMode(
            Function<ShardIndexingPressureRejectionsBreakupStats.Builder, ObjectBuilder<ShardIndexingPressureRejectionsBreakupStats>> fn
        ) {
            return breakupShadowMode(fn.apply(new ShardIndexingPressureRejectionsBreakupStats.Builder()).build());
        }

        /**
         * Required - API name: {@code coordinating_rejections}
         */
        @Nonnull
        public final Builder coordinatingRejections(long value) {
            this.coordinatingRejections = value;
            return this;
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardRejectionCoordinatingStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardRejectionCoordinatingStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardRejectionCoordinatingStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardRejectionCoordinatingStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardRejectionCoordinatingStats> _DESERIALIZER = ObjectBuilderDeserializer
        .lazy(
            Builder::new,
            ShardIndexingPressurePerShardRejectionCoordinatingStats::setupShardIndexingPressurePerShardRejectionCoordinatingStatsDeserializer
        );

    protected static void setupShardIndexingPressurePerShardRejectionCoordinatingStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardRejectionCoordinatingStats.Builder> op
    ) {
        op.add(Builder::breakup, ShardIndexingPressureRejectionsBreakupStats._DESERIALIZER, "breakup");
        op.add(Builder::breakupShadowMode, ShardIndexingPressureRejectionsBreakupStats._DESERIALIZER, "breakup_shadow_mode");
        op.add(Builder::coordinatingRejections, JsonpDeserializer.longDeserializer(), "coordinating_rejections");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.breakup);
        result = 31 * result + Objects.hashCode(this.breakupShadowMode);
        result = 31 * result + Long.hashCode(this.coordinatingRejections);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardRejectionCoordinatingStats other = (ShardIndexingPressurePerShardRejectionCoordinatingStats) o;
        return Objects.equals(this.breakup, other.breakup)
            && Objects.equals(this.breakupShadowMode, other.breakupShadowMode)
            && this.coordinatingRejections == other.coordinatingRejections;
    }
}
