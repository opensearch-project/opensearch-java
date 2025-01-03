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

// typedef: nodes.stats.ShardAdmissionControlStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardAdmissionControlStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardAdmissionControlStats.Builder, ShardAdmissionControlStats> {

    @Nullable
    private final UsageStats globalCpuUsage;

    @Nullable
    private final UsageStats globalIoUsage;

    // ---------------------------------------------------------------------------------------------

    private ShardAdmissionControlStats(Builder builder) {
        this.globalCpuUsage = builder.globalCpuUsage;
        this.globalIoUsage = builder.globalIoUsage;
    }

    public static ShardAdmissionControlStats of(
        Function<ShardAdmissionControlStats.Builder, ObjectBuilder<ShardAdmissionControlStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code global_cpu_usage}
     */
    @Nullable
    public final UsageStats globalCpuUsage() {
        return this.globalCpuUsage;
    }

    /**
     * API name: {@code global_io_usage}
     */
    @Nullable
    public final UsageStats globalIoUsage() {
        return this.globalIoUsage;
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
        if (this.globalCpuUsage != null) {
            generator.writeKey("global_cpu_usage");
            this.globalCpuUsage.serialize(generator, mapper);
        }

        if (this.globalIoUsage != null) {
            generator.writeKey("global_io_usage");
            this.globalIoUsage.serialize(generator, mapper);
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
     * Builder for {@link ShardAdmissionControlStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardAdmissionControlStats> {
        @Nullable
        private UsageStats globalCpuUsage;
        @Nullable
        private UsageStats globalIoUsage;

        public Builder() {}

        private Builder(ShardAdmissionControlStats o) {
            this.globalCpuUsage = o.globalCpuUsage;
            this.globalIoUsage = o.globalIoUsage;
        }

        private Builder(Builder o) {
            this.globalCpuUsage = o.globalCpuUsage;
            this.globalIoUsage = o.globalIoUsage;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code global_cpu_usage}
         */
        @Nonnull
        public final Builder globalCpuUsage(@Nullable UsageStats value) {
            this.globalCpuUsage = value;
            return this;
        }

        /**
         * API name: {@code global_cpu_usage}
         */
        @Nonnull
        public final Builder globalCpuUsage(Function<UsageStats.Builder, ObjectBuilder<UsageStats>> fn) {
            return globalCpuUsage(fn.apply(new UsageStats.Builder()).build());
        }

        /**
         * API name: {@code global_io_usage}
         */
        @Nonnull
        public final Builder globalIoUsage(@Nullable UsageStats value) {
            this.globalIoUsage = value;
            return this;
        }

        /**
         * API name: {@code global_io_usage}
         */
        @Nonnull
        public final Builder globalIoUsage(Function<UsageStats.Builder, ObjectBuilder<UsageStats>> fn) {
            return globalIoUsage(fn.apply(new UsageStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardAdmissionControlStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardAdmissionControlStats build() {
            _checkSingleUse();

            return new ShardAdmissionControlStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardAdmissionControlStats}
     */
    public static final JsonpDeserializer<ShardAdmissionControlStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardAdmissionControlStats::setupShardAdmissionControlStatsDeserializer
    );

    protected static void setupShardAdmissionControlStatsDeserializer(ObjectDeserializer<ShardAdmissionControlStats.Builder> op) {
        op.add(Builder::globalCpuUsage, UsageStats._DESERIALIZER, "global_cpu_usage");
        op.add(Builder::globalIoUsage, UsageStats._DESERIALIZER, "global_io_usage");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.globalCpuUsage);
        result = 31 * result + Objects.hashCode(this.globalIoUsage);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardAdmissionControlStats other = (ShardAdmissionControlStats) o;
        return Objects.equals(this.globalCpuUsage, other.globalCpuUsage) && Objects.equals(this.globalIoUsage, other.globalIoUsage);
    }
}
