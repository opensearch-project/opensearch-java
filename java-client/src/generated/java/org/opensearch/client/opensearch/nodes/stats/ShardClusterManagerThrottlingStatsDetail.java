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
import java.util.Map;
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

// typedef: nodes.stats.ShardClusterManagerThrottlingStatsDetail

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardClusterManagerThrottlingStatsDetail
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ShardClusterManagerThrottlingStatsDetail.Builder, ShardClusterManagerThrottlingStatsDetail> {

    @Nonnull
    private final Map<String, Long> throttledTasksPerTaskType;

    private final long totalThrottledTasks;

    // ---------------------------------------------------------------------------------------------

    private ShardClusterManagerThrottlingStatsDetail(Builder builder) {
        this.throttledTasksPerTaskType = ApiTypeHelper.unmodifiableRequired(
            builder.throttledTasksPerTaskType,
            this,
            "throttledTasksPerTaskType"
        );
        this.totalThrottledTasks = ApiTypeHelper.requireNonNull(builder.totalThrottledTasks, this, "totalThrottledTasks");
    }

    public static ShardClusterManagerThrottlingStatsDetail of(
        Function<ShardClusterManagerThrottlingStatsDetail.Builder, ObjectBuilder<ShardClusterManagerThrottlingStatsDetail>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code throttled_tasks_per_task_type}
     */
    @Nonnull
    public final Map<String, Long> throttledTasksPerTaskType() {
        return this.throttledTasksPerTaskType;
    }

    /**
     * Required - API name: {@code total_throttled_tasks}
     */
    public final long totalThrottledTasks() {
        return this.totalThrottledTasks;
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
        generator.writeKey("throttled_tasks_per_task_type");
        generator.writeStartObject();
        for (Map.Entry<String, Long> item0 : this.throttledTasksPerTaskType.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("total_throttled_tasks");
        generator.write(this.totalThrottledTasks);
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
     * Builder for {@link ShardClusterManagerThrottlingStatsDetail}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardClusterManagerThrottlingStatsDetail> {
        private Map<String, Long> throttledTasksPerTaskType;
        private Long totalThrottledTasks;

        public Builder() {}

        private Builder(ShardClusterManagerThrottlingStatsDetail o) {
            this.throttledTasksPerTaskType = _mapCopy(o.throttledTasksPerTaskType);
            this.totalThrottledTasks = o.totalThrottledTasks;
        }

        private Builder(Builder o) {
            this.throttledTasksPerTaskType = _mapCopy(o.throttledTasksPerTaskType);
            this.totalThrottledTasks = o.totalThrottledTasks;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code throttled_tasks_per_task_type}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>throttledTasksPerTaskType</code>.
         * </p>
         */
        @Nonnull
        public final Builder throttledTasksPerTaskType(Map<String, Long> map) {
            this.throttledTasksPerTaskType = _mapPutAll(this.throttledTasksPerTaskType, map);
            return this;
        }

        /**
         * Required - API name: {@code throttled_tasks_per_task_type}
         *
         * <p>
         * Adds an entry to <code>throttledTasksPerTaskType</code>.
         * </p>
         */
        @Nonnull
        public final Builder throttledTasksPerTaskType(String key, Long value) {
            this.throttledTasksPerTaskType = _mapPut(this.throttledTasksPerTaskType, key, value);
            return this;
        }

        /**
         * Required - API name: {@code total_throttled_tasks}
         */
        @Nonnull
        public final Builder totalThrottledTasks(long value) {
            this.totalThrottledTasks = value;
            return this;
        }

        /**
         * Builds a {@link ShardClusterManagerThrottlingStatsDetail}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardClusterManagerThrottlingStatsDetail build() {
            _checkSingleUse();

            return new ShardClusterManagerThrottlingStatsDetail(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardClusterManagerThrottlingStatsDetail}
     */
    public static final JsonpDeserializer<ShardClusterManagerThrottlingStatsDetail> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardClusterManagerThrottlingStatsDetail::setupShardClusterManagerThrottlingStatsDetailDeserializer
    );

    protected static void setupShardClusterManagerThrottlingStatsDetailDeserializer(
        ObjectDeserializer<ShardClusterManagerThrottlingStatsDetail.Builder> op
    ) {
        op.add(
            Builder::throttledTasksPerTaskType,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.longDeserializer()),
            "throttled_tasks_per_task_type"
        );
        op.add(Builder::totalThrottledTasks, JsonpDeserializer.longDeserializer(), "total_throttled_tasks");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.throttledTasksPerTaskType.hashCode();
        result = 31 * result + Long.hashCode(this.totalThrottledTasks);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardClusterManagerThrottlingStatsDetail other = (ShardClusterManagerThrottlingStatsDetail) o;
        return this.throttledTasksPerTaskType.equals(other.throttledTasksPerTaskType)
            && this.totalThrottledTasks == other.totalThrottledTasks;
    }
}
