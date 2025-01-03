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

// typedef: nodes.stats.ShardResourceUsageStatsIoUsageStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardResourceUsageStatsIoUsageStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardResourceUsageStatsIoUsageStats.Builder, ShardResourceUsageStatsIoUsageStats> {

    @Nullable
    private final String maxIoUtilizationPercent;

    // ---------------------------------------------------------------------------------------------

    private ShardResourceUsageStatsIoUsageStats(Builder builder) {
        this.maxIoUtilizationPercent = builder.maxIoUtilizationPercent;
    }

    public static ShardResourceUsageStatsIoUsageStats of(
        Function<ShardResourceUsageStatsIoUsageStats.Builder, ObjectBuilder<ShardResourceUsageStatsIoUsageStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_io_utilization_percent}
     */
    @Nullable
    public final String maxIoUtilizationPercent() {
        return this.maxIoUtilizationPercent;
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
        if (this.maxIoUtilizationPercent != null) {
            generator.writeKey("max_io_utilization_percent");
            generator.write(this.maxIoUtilizationPercent);
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
     * Builder for {@link ShardResourceUsageStatsIoUsageStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardResourceUsageStatsIoUsageStats> {
        @Nullable
        private String maxIoUtilizationPercent;

        public Builder() {}

        private Builder(ShardResourceUsageStatsIoUsageStats o) {
            this.maxIoUtilizationPercent = o.maxIoUtilizationPercent;
        }

        private Builder(Builder o) {
            this.maxIoUtilizationPercent = o.maxIoUtilizationPercent;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code max_io_utilization_percent}
         */
        @Nonnull
        public final Builder maxIoUtilizationPercent(@Nullable String value) {
            this.maxIoUtilizationPercent = value;
            return this;
        }

        /**
         * Builds a {@link ShardResourceUsageStatsIoUsageStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardResourceUsageStatsIoUsageStats build() {
            _checkSingleUse();

            return new ShardResourceUsageStatsIoUsageStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardResourceUsageStatsIoUsageStats}
     */
    public static final JsonpDeserializer<ShardResourceUsageStatsIoUsageStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardResourceUsageStatsIoUsageStats::setupShardResourceUsageStatsIoUsageStatsDeserializer
    );

    protected static void setupShardResourceUsageStatsIoUsageStatsDeserializer(
        ObjectDeserializer<ShardResourceUsageStatsIoUsageStats.Builder> op
    ) {
        op.add(Builder::maxIoUtilizationPercent, JsonpDeserializer.stringDeserializer(), "max_io_utilization_percent");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxIoUtilizationPercent);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardResourceUsageStatsIoUsageStats other = (ShardResourceUsageStatsIoUsageStats) o;
        return Objects.equals(this.maxIoUtilizationPercent, other.maxIoUtilizationPercent);
    }
}
