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

// typedef: nodes.stats.ShardTaskCancellationStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardTaskCancellationStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardTaskCancellationStats.Builder, ShardTaskCancellationStats> {

    @Nullable
    private final ShardTaskCancellationStatsDetail searchShardTask;

    // ---------------------------------------------------------------------------------------------

    private ShardTaskCancellationStats(Builder builder) {
        this.searchShardTask = builder.searchShardTask;
    }

    public static ShardTaskCancellationStats of(
        Function<ShardTaskCancellationStats.Builder, ObjectBuilder<ShardTaskCancellationStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code search_shard_task}
     */
    @Nullable
    public final ShardTaskCancellationStatsDetail searchShardTask() {
        return this.searchShardTask;
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
        if (this.searchShardTask != null) {
            generator.writeKey("search_shard_task");
            this.searchShardTask.serialize(generator, mapper);
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
     * Builder for {@link ShardTaskCancellationStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardTaskCancellationStats> {
        @Nullable
        private ShardTaskCancellationStatsDetail searchShardTask;

        public Builder() {}

        private Builder(ShardTaskCancellationStats o) {
            this.searchShardTask = o.searchShardTask;
        }

        private Builder(Builder o) {
            this.searchShardTask = o.searchShardTask;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code search_shard_task}
         */
        @Nonnull
        public final Builder searchShardTask(@Nullable ShardTaskCancellationStatsDetail value) {
            this.searchShardTask = value;
            return this;
        }

        /**
         * API name: {@code search_shard_task}
         */
        @Nonnull
        public final Builder searchShardTask(
            Function<ShardTaskCancellationStatsDetail.Builder, ObjectBuilder<ShardTaskCancellationStatsDetail>> fn
        ) {
            return searchShardTask(fn.apply(new ShardTaskCancellationStatsDetail.Builder()).build());
        }

        /**
         * Builds a {@link ShardTaskCancellationStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardTaskCancellationStats build() {
            _checkSingleUse();

            return new ShardTaskCancellationStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardTaskCancellationStats}
     */
    public static final JsonpDeserializer<ShardTaskCancellationStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardTaskCancellationStats::setupShardTaskCancellationStatsDeserializer
    );

    protected static void setupShardTaskCancellationStatsDeserializer(ObjectDeserializer<ShardTaskCancellationStats.Builder> op) {
        op.add(Builder::searchShardTask, ShardTaskCancellationStatsDetail._DESERIALIZER, "search_shard_task");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.searchShardTask);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardTaskCancellationStats other = (ShardTaskCancellationStats) o;
        return Objects.equals(this.searchShardTask, other.searchShardTask);
    }
}
