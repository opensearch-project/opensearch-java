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

// typedef: nodes.stats.ShardIndexingPressurePerShardMemoryAllocationStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardIndexingPressurePerShardMemoryAllocationStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardIndexingPressurePerShardMemoryAllocationStats.Builder, ShardIndexingPressurePerShardMemoryAllocationStats> {

    @Nonnull
    private final ShardIndexingPressurePerShardMemoryAllocationCurrentStats current;

    @Nonnull
    private final ShardIndexingPressurePerShardMemoryAllocationLimitStats limit;

    // ---------------------------------------------------------------------------------------------

    private ShardIndexingPressurePerShardMemoryAllocationStats(Builder builder) {
        this.current = ApiTypeHelper.requireNonNull(builder.current, this, "current");
        this.limit = ApiTypeHelper.requireNonNull(builder.limit, this, "limit");
    }

    public static ShardIndexingPressurePerShardMemoryAllocationStats of(
        Function<
            ShardIndexingPressurePerShardMemoryAllocationStats.Builder,
            ObjectBuilder<ShardIndexingPressurePerShardMemoryAllocationStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code current}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardMemoryAllocationCurrentStats current() {
        return this.current;
    }

    /**
     * Required - API name: {@code limit}
     */
    @Nonnull
    public final ShardIndexingPressurePerShardMemoryAllocationLimitStats limit() {
        return this.limit;
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

        generator.writeKey("limit");
        this.limit.serialize(generator, mapper);
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
     * Builder for {@link ShardIndexingPressurePerShardMemoryAllocationStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardIndexingPressurePerShardMemoryAllocationStats> {
        private ShardIndexingPressurePerShardMemoryAllocationCurrentStats current;
        private ShardIndexingPressurePerShardMemoryAllocationLimitStats limit;

        public Builder() {}

        private Builder(ShardIndexingPressurePerShardMemoryAllocationStats o) {
            this.current = o.current;
            this.limit = o.limit;
        }

        private Builder(Builder o) {
            this.current = o.current;
            this.limit = o.limit;
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
        public final Builder current(ShardIndexingPressurePerShardMemoryAllocationCurrentStats value) {
            this.current = value;
            return this;
        }

        /**
         * Required - API name: {@code current}
         */
        @Nonnull
        public final Builder current(
            Function<
                ShardIndexingPressurePerShardMemoryAllocationCurrentStats.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardMemoryAllocationCurrentStats>> fn
        ) {
            return current(fn.apply(new ShardIndexingPressurePerShardMemoryAllocationCurrentStats.Builder()).build());
        }

        /**
         * Required - API name: {@code limit}
         */
        @Nonnull
        public final Builder limit(ShardIndexingPressurePerShardMemoryAllocationLimitStats value) {
            this.limit = value;
            return this;
        }

        /**
         * Required - API name: {@code limit}
         */
        @Nonnull
        public final Builder limit(
            Function<
                ShardIndexingPressurePerShardMemoryAllocationLimitStats.Builder,
                ObjectBuilder<ShardIndexingPressurePerShardMemoryAllocationLimitStats>> fn
        ) {
            return limit(fn.apply(new ShardIndexingPressurePerShardMemoryAllocationLimitStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardIndexingPressurePerShardMemoryAllocationStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardIndexingPressurePerShardMemoryAllocationStats build() {
            _checkSingleUse();

            return new ShardIndexingPressurePerShardMemoryAllocationStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardIndexingPressurePerShardMemoryAllocationStats}
     */
    public static final JsonpDeserializer<ShardIndexingPressurePerShardMemoryAllocationStats> _DESERIALIZER = ObjectBuilderDeserializer
        .lazy(
            Builder::new,
            ShardIndexingPressurePerShardMemoryAllocationStats::setupShardIndexingPressurePerShardMemoryAllocationStatsDeserializer
        );

    protected static void setupShardIndexingPressurePerShardMemoryAllocationStatsDeserializer(
        ObjectDeserializer<ShardIndexingPressurePerShardMemoryAllocationStats.Builder> op
    ) {
        op.add(Builder::current, ShardIndexingPressurePerShardMemoryAllocationCurrentStats._DESERIALIZER, "current");
        op.add(Builder::limit, ShardIndexingPressurePerShardMemoryAllocationLimitStats._DESERIALIZER, "limit");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.current.hashCode();
        result = 31 * result + this.limit.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardIndexingPressurePerShardMemoryAllocationStats other = (ShardIndexingPressurePerShardMemoryAllocationStats) o;
        return this.current.equals(other.current) && this.limit.equals(other.limit);
    }
}
