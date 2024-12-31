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

// typedef: nodes.stats.ShardSearchPipelinePerPipelineProcessorStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchPipelinePerPipelineProcessorStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchPipelinePerPipelineProcessorStats.Builder, ShardSearchPipelinePerPipelineProcessorStats> {

    @Nonnull
    private final String processorName;

    @Nullable
    private final ShardSearchPipelineOperationStats stats;

    @Nullable
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchPipelinePerPipelineProcessorStats(Builder builder) {
        this.processorName = ApiTypeHelper.requireNonNull(builder.processorName, this, "processorName");
        this.stats = builder.stats;
        this.type = builder.type;
    }

    public static ShardSearchPipelinePerPipelineProcessorStats of(
        Function<ShardSearchPipelinePerPipelineProcessorStats.Builder, ObjectBuilder<ShardSearchPipelinePerPipelineProcessorStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The target processorName
     */
    @Nonnull
    public final String processorName() {
        return this.processorName;
    }

    /**
     * API name: {@code stats}
     */
    @Nullable
    public final ShardSearchPipelineOperationStats stats() {
        return this.stats;
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
        generator.writeStartObject(this.processorName);
        if (this.stats != null) {
            generator.writeKey("stats");
            this.stats.serialize(generator, mapper);
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
     * Builder for {@link ShardSearchPipelinePerPipelineProcessorStats}.
     */
    public static class Builder extends ObjectBuilderBase
        implements
            CopyableBuilder<Builder, ShardSearchPipelinePerPipelineProcessorStats> {
        private String processorName;
        @Nullable
        private ShardSearchPipelineOperationStats stats;
        @Nullable
        private String type;

        public Builder() {}

        private Builder(ShardSearchPipelinePerPipelineProcessorStats o) {
            this.processorName = o.processorName;
            this.stats = o.stats;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.processorName = o.processorName;
            this.stats = o.stats;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The target processorName
         */
        @Nonnull
        public final Builder processorName(String value) {
            this.processorName = value;
            return this;
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(@Nullable ShardSearchPipelineOperationStats value) {
            this.stats = value;
            return this;
        }

        /**
         * API name: {@code stats}
         */
        @Nonnull
        public final Builder stats(
            Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
        ) {
            return stats(fn.apply(new ShardSearchPipelineOperationStats.Builder()).build());
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
         * Builds a {@link ShardSearchPipelinePerPipelineProcessorStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchPipelinePerPipelineProcessorStats build() {
            _checkSingleUse();

            return new ShardSearchPipelinePerPipelineProcessorStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchPipelinePerPipelineProcessorStats}
     */
    public static final JsonpDeserializer<ShardSearchPipelinePerPipelineProcessorStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchPipelinePerPipelineProcessorStats::setupShardSearchPipelinePerPipelineProcessorStatsDeserializer
    );

    protected static void setupShardSearchPipelinePerPipelineProcessorStatsDeserializer(
        ObjectDeserializer<ShardSearchPipelinePerPipelineProcessorStats.Builder> op
    ) {
        op.add(Builder::stats, ShardSearchPipelineOperationStats._DESERIALIZER, "stats");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.setKey(Builder::processorName, JsonpDeserializer.stringDeserializer());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.processorName.hashCode();
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.type);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchPipelinePerPipelineProcessorStats other = (ShardSearchPipelinePerPipelineProcessorStats) o;
        return this.processorName.equals(other.processorName)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.type, other.type);
    }
}
