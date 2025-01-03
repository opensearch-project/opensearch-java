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
import java.util.Map;
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

// typedef: nodes.stats.ShardIndexingPressureStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressureStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressureStats.Builder, ShardIndexingPressureStats> {

    @Nullable
    private final Boolean enabled;

    @Nullable
    private final Boolean enforced;

    @Nonnull
    private final Map<String, ShardIndexingPressurePerShardStats> stats;

    @Nullable
    private final ShardIndexingPressureRejectionsBreakupStats totalRejectionsBreakup;

    @Nullable
    private final ShardIndexingPressureRejectionsBreakupStats totalRejectionsBreakupShadowMode;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressureStats(Builder builder) {
        this.enabled = builder.enabled;
        this.enforced = builder.enforced;
        this.stats = ApiTypeHelper.unmodifiable(builder.stats);
        this.totalRejectionsBreakup = builder.totalRejectionsBreakup;
        this.totalRejectionsBreakupShadowMode = builder.totalRejectionsBreakupShadowMode;
    }

    public static ShardIndexingPressureStats of(
        Function<ShardIndexingPressureStats.Builder, ObjectBuilder<ShardIndexingPressureStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code enabled}
     */
    @Nullable
    public final Boolean enabled() {
        return this.enabled;
    }

    /**
     * API name: {@code enforced}
     */
    @Nullable
    public final Boolean enforced() {
        return this.enforced;
    }

    /**
     * API name: {@code stats}
     */
    @Nonnull
    public final Map<String, ShardIndexingPressurePerShardStats> stats() {
        return this.stats;
    }

    /**
     * API name: {@code total_rejections_breakup}
     */
    @Nullable
    public final ShardIndexingPressureRejectionsBreakupStats totalRejectionsBreakup() {
        return this.totalRejectionsBreakup;
    }

    /**
     * API name: {@code total_rejections_breakup_shadow_mode}
     */
    @Nullable
    public final ShardIndexingPressureRejectionsBreakupStats totalRejectionsBreakupShadowMode() {
        return this.totalRejectionsBreakupShadowMode;
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
        if (this.enabled != null) {
            generator.writeKey("enabled");
            generator.write(this.enabled);
        }

        if (this.enforced != null) {
            generator.writeKey("enforced");
            generator.write(this.enforced);
        }

        if (ApiTypeHelper.isDefined(this.stats)) {
            generator.writeKey("stats");
            generator.writeStartObject();
            for (Map.Entry<String, ShardIndexingPressurePerShardStats> item0 : this.stats.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.totalRejectionsBreakup != null) {
            generator.writeKey("total_rejections_breakup");
            this.totalRejectionsBreakup.serialize(generator, mapper);
        }

        if (this.totalRejectionsBreakupShadowMode != null) {
            generator.writeKey("total_rejections_breakup_shadow_mode");
            this.totalRejectionsBreakupShadowMode.serialize(generator, mapper);
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
     * Builder for {@link ShardIndexingPressureStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardIndexingPressureStats> {
        @Nullable
        private Boolean enabled;
        @Nullable
        private Boolean enforced;
        @Nullable
        private Map<String, ShardIndexingPressurePerShardStats> stats;
        @Nullable
        private ShardIndexingPressureRejectionsBreakupStats totalRejectionsBreakup;
        @Nullable
        private ShardIndexingPressureRejectionsBreakupStats totalRejectionsBreakupShadowMode;

        public Builder() {}

        private Builder(ShardIndexingPressureStats o) {
            this.enabled = o.enabled;
            this.enforced = o.enforced;
            this.stats = _mapCopy(o.stats);
            this.totalRejectionsBreakup = o.totalRejectionsBreakup;
            this.totalRejectionsBreakupShadowMode = o.totalRejectionsBreakupShadowMode;
        }

        private Builder(Builder o) {
            this.enabled = o.enabled;
            this.enforced = o.enforced;
            this.stats = _mapCopy(o.stats);
            this.totalRejectionsBreakup = o.totalRejectionsBreakup;
            this.totalRejectionsBreakupShadowMode = o.totalRejectionsBreakupShadowMode;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code enabled}
         */
        @Nonnull
        public final Builder enabled(@Nullable Boolean value) {
            this.enabled = value;
            return this;
        }

        /**
         * API name: {@code enforced}
         */
        @Nonnull
        public final Builder enforced(@Nullable Boolean value) {
            this.enforced = value;
            return this;
        }

        /**
         * API name: {@code stats}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>stats</code>.
         * </p>
         */
        @Nonnull
        public final Builder stats(Map<String, ShardIndexingPressurePerShardStats> map) {
            this.stats = _mapPutAll(this.stats, map);
            return this;
        }

        /**
         * API name: {@code stats}
         *
         * <p>
         * Adds an entry to <code>stats</code>.
         * </p>
         */
        @Nonnull
        public final Builder stats(String key, ShardIndexingPressurePerShardStats value) {
            this.stats = _mapPut(this.stats, key, value);
            return this;
        }

        /**
         * API name: {@code stats}
         *
         * <p>
         * Adds a value to <code>stats</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder stats(
            String key,
            Function<ShardIndexingPressurePerShardStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardStats>> fn
        ) {
            return stats(key, fn.apply(new ShardIndexingPressurePerShardStats.Builder()).build());
        }

        /**
         * API name: {@code total_rejections_breakup}
         */
        @Nonnull
        public final Builder totalRejectionsBreakup(@Nullable ShardIndexingPressureRejectionsBreakupStats value) {
            this.totalRejectionsBreakup = value;
            return this;
        }

        /**
         * API name: {@code total_rejections_breakup}
         */
        @Nonnull
        public final Builder totalRejectionsBreakup(
            Function<ShardIndexingPressureRejectionsBreakupStats.Builder, ObjectBuilder<ShardIndexingPressureRejectionsBreakupStats>> fn
        ) {
            return totalRejectionsBreakup(fn.apply(new ShardIndexingPressureRejectionsBreakupStats.Builder()).build());
        }

        /**
         * API name: {@code total_rejections_breakup_shadow_mode}
         */
        @Nonnull
        public final Builder totalRejectionsBreakupShadowMode(@Nullable ShardIndexingPressureRejectionsBreakupStats value) {
            this.totalRejectionsBreakupShadowMode = value;
            return this;
        }

        /**
         * API name: {@code total_rejections_breakup_shadow_mode}
         */
        @Nonnull
        public final Builder totalRejectionsBreakupShadowMode(
            Function<ShardIndexingPressureRejectionsBreakupStats.Builder, ObjectBuilder<ShardIndexingPressureRejectionsBreakupStats>> fn
        ) {
            return totalRejectionsBreakupShadowMode(fn.apply(new ShardIndexingPressureRejectionsBreakupStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardIndexingPressureStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressureStats build() {
            _checkSingleUse();

            return new ShardIndexingPressureStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressureStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressureStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIndexingPressureStats::setupShardIndexingPressureStatsDeserializer
    );

    protected static void setupShardIndexingPressureStatsDeserializer(ObjectDeserializer<ShardIndexingPressureStats.Builder> op) {
        op.add(Builder::enabled, JsonpDeserializer.booleanDeserializer(), "enabled");
        op.add(Builder::enforced, JsonpDeserializer.booleanDeserializer(), "enforced");
        op.add(Builder::stats, JsonpDeserializer.stringMapDeserializer(ShardIndexingPressurePerShardStats._DESERIALIZER), "stats");
        op.add(Builder::totalRejectionsBreakup, ShardIndexingPressureRejectionsBreakupStats._DESERIALIZER, "total_rejections_breakup");
        op.add(
            Builder::totalRejectionsBreakupShadowMode,
            ShardIndexingPressureRejectionsBreakupStats._DESERIALIZER,
            "total_rejections_breakup_shadow_mode"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.enabled);
        result = 31 * result + Objects.hashCode(this.enforced);
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.totalRejectionsBreakup);
        result = 31 * result + Objects.hashCode(this.totalRejectionsBreakupShadowMode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressureStats other = (ShardIndexingPressureStats) o;
        return Objects.equals(this.enabled, other.enabled)
            && Objects.equals(this.enforced, other.enforced)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.totalRejectionsBreakup, other.totalRejectionsBreakup)
            && Objects.equals(this.totalRejectionsBreakupShadowMode, other.totalRejectionsBreakupShadowMode);
    }
}
