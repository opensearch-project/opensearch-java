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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: nodes.stats.ShardIndexingPressurePerShardMemoryStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardMemoryStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressurePerShardMemoryStats.Builder, ShardIndexingPressurePerShardMemoryStats> {

    @Nonnull
    private final ShardIndexingPressurePerShardMemoryStatsDetails current;

    @Nonnull
    private final ShardIndexingPressurePerShardMemoryStatsDetails total;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardMemoryStats(Builder builder) {
        this.current = ApiTypeHelper.requireNonNull(builder.current, this, "current");
        this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total");
    }

    public static ShardIndexingPressurePerShardMemoryStats of(
        Function<ShardIndexingPressurePerShardMemoryStats.Builder, ObjectBuilder<ShardIndexingPressurePerShardMemoryStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code current}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardMemoryStatsDetails current() {
        return this.current;
    }

    /**
     * Required - API name: {@code total}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardMemoryStatsDetails total() {
        return this.total;
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
        generator.writeKey("current");
        this.current.serialize(generator, mapper);

        generator.writeKey("total");
        this.total.serialize(generator, mapper);
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
     * Builder for {@link ShardIndexingPressurePerShardMemoryStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardIndexingPressurePerShardMemoryStats> {
        private ShardIndexingPressurePerShardMemoryStatsDetails current;
        private ShardIndexingPressurePerShardMemoryStatsDetails total;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardMemoryStats o) {
            this.current = o.current;
            this.total = o.total;
        }

        private Builder(Builder o) {
            this.current = o.current;
            this.total = o.total;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code current}
         */
        @Nonnull
        public final Builder current(ShardIndexingPressurePerShardMemoryStatsDetails value) {
            this.current = value;
            return this;
        }

        /**
         * Required - API name: {@code current}
         */
        @Nonnull
        public final Builder current(
            Function<
                ShardIndexingPressurePerShardMemoryStatsDetails.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardMemoryStatsDetails>> fn
        ) {
            return current(fn.apply(new ShardIndexingPressurePerShardMemoryStatsDetails.Builder()).build());
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(ShardIndexingPressurePerShardMemoryStatsDetails value) {
            this.total = value;
            return this;
        }

        /**
         * Required - API name: {@code total}
         */
        @Nonnull
        public final Builder total(
            Function<
                ShardIndexingPressurePerShardMemoryStatsDetails.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardMemoryStatsDetails>> fn
        ) {
            return total(fn.apply(new ShardIndexingPressurePerShardMemoryStatsDetails.Builder()).build());
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardMemoryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardMemoryStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardMemoryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardMemoryStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardMemoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardIndexingPressurePerShardMemoryStats::setupShardIndexingPressurePerShardMemoryStatsDeserializer
    );

    protected static void setupShardIndexingPressurePerShardMemoryStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardMemoryStats.Builder> op
    ) {
        op.add(Builder::current, ShardIndexingPressurePerShardMemoryStatsDetails._DESERIALIZER, "current");
        op.add(Builder::total, ShardIndexingPressurePerShardMemoryStatsDetails._DESERIALIZER, "total");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.current.hashCode();
        result = 31 * result + this.total.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardMemoryStats other = (ShardIndexingPressurePerShardMemoryStats) o;
        return this.current.equals(other.current) && this.total.equals(other.total);
    }
}
