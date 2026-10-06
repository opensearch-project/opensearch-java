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

// typedef: nodes.stats.ShardSearchPipelineFactoryStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchPipelineFactoryStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchPipelineFactoryStats.Builder, ShardSearchPipelineFactoryStats> {

    @Nullable
    private final ShardSearchPipelineOperationStats evaluationStats;

    @Nonnull
    private final String factoryType;

    @Nullable
    private final ShardSearchPipelineOperationStats generationStats;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchPipelineFactoryStats(Builder builder) {
        this.evaluationStats = builder.evaluationStats;
        this.factoryType = ApiTypeHelper.requireNonNull(builder.factoryType, this, "factoryType");
        this.generationStats = builder.generationStats;
        this.type = builder.type;
    }

    public static ShardSearchPipelineFactoryStats of(
        Function<ShardSearchPipelineFactoryStats.Builder, ObjectBuilder<ShardSearchPipelineFactoryStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code evaluation_stats}
     */
    @Nullable
    public final ShardSearchPipelineOperationStats evaluationStats() {
        return this.evaluationStats;
    }

    /**
     * Required - The target factoryType
     */
    @Nonnull
    public final String factoryType() {
        return this.factoryType;
    }

    /**
     * API name: {@code generation_stats}
     */
    @Nullable
    public final ShardSearchPipelineOperationStats generationStats() {
        return this.generationStats;
    }

    /**
     * API name: {@code type}
     */
    @Nullable
    public final String type() {
        return this.type;
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
        generator.writeStartObject(this.factoryType);
        if (this.evaluationStats != null) {
            generator.writeKey("evaluation_stats");
            this.evaluationStats.serialize(generator, mapper);
        }

        if (this.generationStats != null) {
            generator.writeKey("generation_stats");
            this.generationStats.serialize(generator, mapper);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
        }
        generator.writeEnd();
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
     * Builder for {@link ShardSearchPipelineFactoryStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSearchPipelineFactoryStats> {
        @Nullable
        private ShardSearchPipelineOperationStats evaluationStats;
        private String factoryType;
        @Nullable
        private ShardSearchPipelineOperationStats generationStats;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(ShardSearchPipelineFactoryStats o) {
            this.evaluationStats = o.evaluationStats;
            this.factoryType = o.factoryType;
            this.generationStats = o.generationStats;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.evaluationStats = o.evaluationStats;
            this.factoryType = o.factoryType;
            this.generationStats = o.generationStats;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code evaluation_stats}
         */
        @Nonnull
        public final Builder evaluationStats(@Nullable ShardSearchPipelineOperationStats value) {
            this.evaluationStats = value;
            return this;
        }

        /**
         * API name: {@code evaluation_stats}
         */
        @Nonnull
        public final Builder evaluationStats(
            Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
        ) {
            return evaluationStats(fn.apply(new ShardSearchPipelineOperationStats.Builder()).build());
        }

        /**
         * Required - The target factoryType
         */
        @Nonnull
        public final Builder factoryType(String value) {
            this.factoryType = value;
            return this;
        }

        /**
         * API name: {@code generation_stats}
         */
        @Nonnull
        public final Builder generationStats(@Nullable ShardSearchPipelineOperationStats value) {
            this.generationStats = value;
            return this;
        }

        /**
         * API name: {@code generation_stats}
         */
        @Nonnull
        public final Builder generationStats(
            Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
        ) {
            return generationStats(fn.apply(new ShardSearchPipelineOperationStats.Builder()).build());
        }

        /**
         * API name: {@code type}
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ShardSearchPipelineFactoryStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchPipelineFactoryStats build() {
            _checkSingleUse();

            return new ShardSearchPipelineFactoryStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchPipelineFactoryStats}
     */
    public static final JsonpDeserializer<ShardSearchPipelineFactoryStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchPipelineFactoryStats::setupShardSearchPipelineFactoryStatsDeserializer
    );

    protected static void setupShardSearchPipelineFactoryStatsDeserializer(ObjectDeserializer<ShardSearchPipelineFactoryStats.Builder> op) {
        op.add(Builder::evaluationStats, ShardSearchPipelineOperationStats._DESERIALIZER, "evaluation_stats");
        op.add(Builder::generationStats, ShardSearchPipelineOperationStats._DESERIALIZER, "generation_stats");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.setKey(Builder::factoryType, JsonpDeserializer.stringDeserializer());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.evaluationStats);
        result = 31 * result + this.factoryType.hashCode();
        result = 31 * result + Objects.hashCode(this.generationStats);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchPipelineFactoryStats other = (ShardSearchPipelineFactoryStats) o;
        return Objects.equals(this.evaluationStats, other.evaluationStats)
            && this.factoryType.equals(other.factoryType)
            && Objects.equals(this.generationStats, other.generationStats)
            && Objects.equals(this.type, other.type);
    }
}
