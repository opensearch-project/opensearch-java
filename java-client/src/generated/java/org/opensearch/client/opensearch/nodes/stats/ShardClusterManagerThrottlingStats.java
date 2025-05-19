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

// typedef: nodes.stats.ShardClusterManagerThrottlingStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardClusterManagerThrottlingStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardClusterManagerThrottlingStats.Builder, ShardClusterManagerThrottlingStats> {

    @Nullable
    private final ShardClusterManagerThrottlingStatsDetail stats;

    // ---------------------------------------------------------------------------------------------

    private ShardClusterManagerThrottlingStats(Builder builder) {
        this.stats = builder.stats;
    }

    public static ShardClusterManagerThrottlingStats of(
        Function<ShardClusterManagerThrottlingStats.Builder, ObjectBuilder<ShardClusterManagerThrottlingStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code stats}
     */
    @Nullable
    public final ShardClusterManagerThrottlingStatsDetail stats() {
        return this.stats;
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
        if (this.stats != null) {
            generator.writeKey("stats");
            this.stats.serialize(generator, mapper);
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
     * Builder for {@link ShardClusterManagerThrottlingStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardClusterManagerThrottlingStats> {
        @Nullable
        private ShardClusterManagerThrottlingStatsDetail stats;

        public Builder() {}

        private Builder(ShardClusterManagerThrottlingStats o) {
            this.stats = o.stats;
        }

        private Builder(Builder o) {
            this.stats = o.stats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(@Nullable ShardClusterManagerThrottlingStatsDetail value) {
            this.stats = value;
            return this;
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(
            Function<ShardClusterManagerThrottlingStatsDetail.Builder, ObjectBuilder<ShardClusterManagerThrottlingStatsDetail>> fn
        ) {
            return stats(fn.apply(new ShardClusterManagerThrottlingStatsDetail.Builder()).build());
        }

        /**
         * Builds a {@link ShardClusterManagerThrottlingStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardClusterManagerThrottlingStats build() {
            _checkSingleUse();

            return new ShardClusterManagerThrottlingStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardClusterManagerThrottlingStats}
     */
    public static final JsonpDeserializer<ShardClusterManagerThrottlingStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardClusterManagerThrottlingStats::setupShardClusterManagerThrottlingStatsDeserializer
    );

    protected static void setupShardClusterManagerThrottlingStatsDeserializer(
        ObjectDeserializer<ShardClusterManagerThrottlingStats.Builder> op
    ) {
        op.add(Builder::stats, ShardClusterManagerThrottlingStatsDetail._DESERIALIZER, "stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.stats);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardClusterManagerThrottlingStats other = (ShardClusterManagerThrottlingStats) o;
        return Objects.equals(this.stats, other.stats);
    }
}
