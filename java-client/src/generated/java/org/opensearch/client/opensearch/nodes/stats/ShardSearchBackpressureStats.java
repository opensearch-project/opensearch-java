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

// typedef: nodes.stats.ShardSearchBackpressureStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchBackpressureStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchBackpressureStats.Builder, ShardSearchBackpressureStats> {

    @Nullable
    private final ShardSearchBackpressureMode mode;

    @Nullable
    private final ShardSearchBackpressureTaskStats searchShardTask;

    @Nullable
    private final ShardSearchBackpressureTaskStats searchTask;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchBackpressureStats(Builder builder) {
        this.mode = builder.mode;
        this.searchShardTask = builder.searchShardTask;
        this.searchTask = builder.searchTask;
    }

    public static ShardSearchBackpressureStats of(
        Function<ShardSearchBackpressureStats.Builder, ObjectBuilder<ShardSearchBackpressureStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code mode}
     */
    @Nullable
    public final ShardSearchBackpressureMode mode() {
        return this.mode;
    }

    /**
     * API name: {@code search_shard_task}
     */
    @Nullable
    public final ShardSearchBackpressureTaskStats searchShardTask() {
        return this.searchShardTask;
    }

    /**
     * API name: {@code search_task}
     */
    @Nullable
    public final ShardSearchBackpressureTaskStats searchTask() {
        return this.searchTask;
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
        if (this.mode != null) {
            generator.writeKey("mode");
            this.mode.serialize(generator, mapper);
        }

        if (this.searchShardTask != null) {
            generator.writeKey("search_shard_task");
            this.searchShardTask.serialize(generator, mapper);
        }

        if (this.searchTask != null) {
            generator.writeKey("search_task");
            this.searchTask.serialize(generator, mapper);
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
     * Builder for {@link ShardSearchBackpressureStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSearchBackpressureStats> {
        @Nullable
        private ShardSearchBackpressureMode mode;
        @Nullable
        private ShardSearchBackpressureTaskStats searchShardTask;
        @Nullable
        private ShardSearchBackpressureTaskStats searchTask;

        public Builder() {}

        private Builder(ShardSearchBackpressureStats o) {
            this.mode = o.mode;
            this.searchShardTask = o.searchShardTask;
            this.searchTask = o.searchTask;
        }

        private Builder(Builder o) {
            this.mode = o.mode;
            this.searchShardTask = o.searchShardTask;
            this.searchTask = o.searchTask;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code mode}
         */
        @Nonnull
        public final Builder mode(@Nullable ShardSearchBackpressureMode value) {
            this.mode = value;
            return this;
        }

        /**
         * API name: {@code search_shard_task}
         */
        @Nonnull
        public final Builder searchShardTask(@Nullable ShardSearchBackpressureTaskStats value) {
            this.searchShardTask = value;
            return this;
        }

        /**
         * API name: {@code search_shard_task}
         */
        @Nonnull
        public final Builder searchShardTask(
            Function<ShardSearchBackpressureTaskStats.Builder, ObjectBuilder<ShardSearchBackpressureTaskStats>> fn
        ) {
            return searchShardTask(fn.apply(new ShardSearchBackpressureTaskStats.Builder()).build());
        }

        /**
         * API name: {@code search_task}
         */
        @Nonnull
        public final Builder searchTask(@Nullable ShardSearchBackpressureTaskStats value) {
            this.searchTask = value;
            return this;
        }

        /**
         * API name: {@code search_task}
         */
        @Nonnull
        public final Builder searchTask(
            Function<ShardSearchBackpressureTaskStats.Builder, ObjectBuilder<ShardSearchBackpressureTaskStats>> fn
        ) {
            return searchTask(fn.apply(new ShardSearchBackpressureTaskStats.Builder()).build());
        }

        /**
         * Builds a {@link ShardSearchBackpressureStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchBackpressureStats build() {
            _checkSingleUse();

            return new ShardSearchBackpressureStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchBackpressureStats}
     */
    public static final JsonpDeserializer<ShardSearchBackpressureStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchBackpressureStats::setupShardSearchBackpressureStatsDeserializer
    );

    protected static void setupShardSearchBackpressureStatsDeserializer(ObjectDeserializer<ShardSearchBackpressureStats.Builder> op) {
        op.add(Builder::mode, ShardSearchBackpressureMode._DESERIALIZER, "mode");
        op.add(Builder::searchShardTask, ShardSearchBackpressureTaskStats._DESERIALIZER, "search_shard_task");
        op.add(Builder::searchTask, ShardSearchBackpressureTaskStats._DESERIALIZER, "search_task");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.mode);
        result = 31 * result + Objects.hashCode(this.searchShardTask);
        result = 31 * result + Objects.hashCode(this.searchTask);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchBackpressureStats other = (ShardSearchBackpressureStats) o;
        return Objects.equals(this.mode, other.mode)
            && Objects.equals(this.searchShardTask, other.searchShardTask)
            && Objects.equals(this.searchTask, other.searchTask);
    }
}
