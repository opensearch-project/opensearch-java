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
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: nodes.stats.ShardSearchPipelineOperationStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardSearchPipelineOperationStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardSearchPipelineOperationStats.Builder, ShardSearchPipelineOperationStats> {

    @Nullable
    private final Long count;

    @Nullable
    private final Long current;

    @Nullable
    private final Long failed;

    @Nullable
    private final Time time;

    @Nullable
    private final Long timeInMillis;

    // ---------------------------------------------------------------------------------------------

    private ShardSearchPipelineOperationStats(Builder builder) {
        this.count = builder.count;
        this.current = builder.current;
        this.failed = builder.failed;
        this.time = builder.time;
        this.timeInMillis = builder.timeInMillis;
    }

    public static ShardSearchPipelineOperationStats of(
        Function<ShardSearchPipelineOperationStats.Builder, ObjectBuilder<ShardSearchPipelineOperationStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code count}
     */
    @Nullable
    public final Long count() {
        return this.count;
    }

    /**
     * API name: {@code current}
     */
    @Nullable
    public final Long current() {
        return this.current;
    }

    /**
     * API name: {@code failed}
     */
    @Nullable
    public final Long failed() {
        return this.failed;
    }

    /**
     * API name: {@code time}
     */
    @Nullable
    public final Time time() {
        return this.time;
    }

    /**
     * API name: {@code time_in_millis}
     */
    @Nullable
    public final Long timeInMillis() {
        return this.timeInMillis;
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
        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.current != null) {
            generator.writeKey("current");
            generator.write(this.current);
        }

        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
        }

        if (this.time != null) {
            generator.writeKey("time");
            this.time.serialize(generator, mapper);
        }

        if (this.timeInMillis != null) {
            generator.writeKey("time_in_millis");
            generator.write(this.timeInMillis);
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
     * Builder for {@link ShardSearchPipelineOperationStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardSearchPipelineOperationStats> {
        @Nullable
        private Long count;
        @Nullable
        private Long current;
        @Nullable
        private Long failed;
        @Nullable
        private Time time;
        @Nullable
        private Long timeInMillis;

        public Builder() {}

        private Builder(ShardSearchPipelineOperationStats o) {
            this.count = o.count;
            this.current = o.current;
            this.failed = o.failed;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.current = o.current;
            this.failed = o.failed;
            this.time = o.time;
            this.timeInMillis = o.timeInMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code count}
         */
        @Nonnull
        public final Builder count(@Nullable Long value) {
            this.count = value;
            return this;
        }

        /**
         * API name: {@code current}
         */
        @Nonnull
        public final Builder current(@Nullable Long value) {
            this.current = value;
            return this;
        }

        /**
         * API name: {@code failed}
         */
        @Nonnull
        public final Builder failed(@Nullable Long value) {
            this.failed = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(@Nullable Time value) {
            this.time = value;
            return this;
        }

        /**
         * API name: {@code time}
         */
        @Nonnull
        public final Builder time(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return time(fn.apply(new Time.Builder()).build());
        }

        /**
         * API name: {@code time_in_millis}
         */
        @Nonnull
        public final Builder timeInMillis(@Nullable Long value) {
            this.timeInMillis = value;
            return this;
        }

        /**
         * Builds a {@link ShardSearchPipelineOperationStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardSearchPipelineOperationStats build() {
            _checkSingleUse();

            return new ShardSearchPipelineOperationStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardSearchPipelineOperationStats}
     */
    public static final JsonpDeserializer<ShardSearchPipelineOperationStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardSearchPipelineOperationStats::setupShardSearchPipelineOperationStatsDeserializer
    );

    protected static void setupShardSearchPipelineOperationStatsDeserializer(
        ObjectDeserializer<ShardSearchPipelineOperationStats.Builder> op
    ) {
        op.add(Builder::count, JsonpDeserializer.longDeserializer(), "count");
        op.add(Builder::current, JsonpDeserializer.longDeserializer(), "current");
        op.add(Builder::failed, JsonpDeserializer.longDeserializer(), "failed");
        op.add(Builder::time, Time._DESERIALIZER, "time");
        op.add(Builder::timeInMillis, JsonpDeserializer.longDeserializer(), "time_in_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.current);
        result = 31 * result + Objects.hashCode(this.failed);
        result = 31 * result + Objects.hashCode(this.time);
        result = 31 * result + Objects.hashCode(this.timeInMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardSearchPipelineOperationStats other = (ShardSearchPipelineOperationStats) o;
        return Objects.equals(this.count, other.count)
            && Objects.equals(this.current, other.current)
            && Objects.equals(this.failed, other.failed)
            && Objects.equals(this.time, other.time)
            && Objects.equals(this.timeInMillis, other.timeInMillis);
    }
}
