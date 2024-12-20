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

package org.opensearch.client.opensearch.cluster.pending_tasks;

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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.pending_tasks.PendingTask

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PendingTask implements PlainJsonSerializable, ToCopyableBuilder<PendingTask.Builder, PendingTask> {

    private final boolean executing;

    private final int insertOrder;

    @Nonnull
    private final String priority;

    @Nonnull
    private final String source;

    @Nullable
    private final Time timeInQueue;

    private final long timeInQueueMillis;

    // ---------------------------------------------------------------------------------------------

    private PendingTask(Builder builder) {
        this.executing = ApiTypeHelper.requireNonNull(builder.executing, this, "executing");
        this.insertOrder = ApiTypeHelper.requireNonNull(builder.insertOrder, this, "insertOrder");
        this.priority = ApiTypeHelper.requireNonNull(builder.priority, this, "priority");
        this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
        this.timeInQueue = builder.timeInQueue;
        this.timeInQueueMillis = ApiTypeHelper.requireNonNull(builder.timeInQueueMillis, this, "timeInQueueMillis");
    }

    public static PendingTask of(Function<PendingTask.Builder, ObjectBuilder<PendingTask>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Indicates whether the pending tasks are currently executing or not.
     * <p>
     * API name: {@code executing}
     * </p>
     */
    public final boolean executing() {
        return this.executing;
    }

    /**
     * Required - The number that represents when the task has been inserted into the task queue.
     * <p>
     * API name: {@code insert_order}
     * </p>
     */
    public final int insertOrder() {
        return this.insertOrder;
    }

    /**
     * Required - The priority of the pending task. The valid priorities in descending priority order are: <code>IMMEDIATE</code> &gt;
     * <code>URGENT</code> &gt; <code>HIGH</code> &gt; <code>NORMAL</code> &gt; <code>LOW</code> &gt; <code>LANGUID</code>.
     * <p>
     * API name: {@code priority}
     * </p>
     */
    @Nonnull
    public final String priority() {
        return this.priority;
    }

    /**
     * Required - A general description of the cluster task that may include a reason and origin.
     * <p>
     * API name: {@code source}
     * </p>
     */
    @Nonnull
    public final String source() {
        return this.source;
    }

    /**
     * API name: {@code time_in_queue}
     */
    @Nullable
    public final Time timeInQueue() {
        return this.timeInQueue;
    }

    /**
     * Required - API name: {@code time_in_queue_millis}
     */
    public final long timeInQueueMillis() {
        return this.timeInQueueMillis;
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
        generator.writeKey("executing");
        generator.write(this.executing);

        generator.writeKey("insert_order");
        generator.write(this.insertOrder);

        generator.writeKey("priority");
        generator.write(this.priority);

        generator.writeKey("source");
        generator.write(this.source);

        if (this.timeInQueue != null) {
            generator.writeKey("time_in_queue");
            this.timeInQueue.serialize(generator, mapper);
        }

        generator.writeKey("time_in_queue_millis");
        generator.write(this.timeInQueueMillis);
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
     * Builder for {@link PendingTask}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PendingTask> {
        private Boolean executing;
        private Integer insertOrder;
        private String priority;
        private String source;
        @Nullable
        private Time timeInQueue;
        private Long timeInQueueMillis;

        public Builder() {}

        private Builder(PendingTask o) {
            this.executing = o.executing;
            this.insertOrder = o.insertOrder;
            this.priority = o.priority;
            this.source = o.source;
            this.timeInQueue = o.timeInQueue;
            this.timeInQueueMillis = o.timeInQueueMillis;
        }

        private Builder(Builder o) {
            this.executing = o.executing;
            this.insertOrder = o.insertOrder;
            this.priority = o.priority;
            this.source = o.source;
            this.timeInQueue = o.timeInQueue;
            this.timeInQueueMillis = o.timeInQueueMillis;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Indicates whether the pending tasks are currently executing or not.
         * <p>
         * API name: {@code executing}
         * </p>
         */
        @Nonnull
        public final Builder executing(boolean value) {
            this.executing = value;
            return this;
        }

        /**
         * Required - The number that represents when the task has been inserted into the task queue.
         * <p>
         * API name: {@code insert_order}
         * </p>
         */
        @Nonnull
        public final Builder insertOrder(int value) {
            this.insertOrder = value;
            return this;
        }

        /**
         * Required - The priority of the pending task. The valid priorities in descending priority order are: <code>IMMEDIATE</code> &gt;
         * <code>URGENT</code> &gt; <code>HIGH</code> &gt; <code>NORMAL</code> &gt; <code>LOW</code> &gt; <code>LANGUID</code>.
         * <p>
         * API name: {@code priority}
         * </p>
         */
        @Nonnull
        public final Builder priority(String value) {
            this.priority = value;
            return this;
        }

        /**
         * Required - A general description of the cluster task that may include a reason and origin.
         * <p>
         * API name: {@code source}
         * </p>
         */
        @Nonnull
        public final Builder source(String value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code time_in_queue}
         */
        @Nonnull
        public final Builder timeInQueue(@Nullable Time value) {
            this.timeInQueue = value;
            return this;
        }

        /**
         * API name: {@code time_in_queue}
         */
        @Nonnull
        public final Builder timeInQueue(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeInQueue(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code time_in_queue_millis}
         */
        @Nonnull
        public final Builder timeInQueueMillis(long value) {
            this.timeInQueueMillis = value;
            return this;
        }

        /**
         * Builds a {@link PendingTask}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PendingTask build() {
            _checkSingleUse();

            return new PendingTask(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PendingTask}
     */
    public static final JsonpDeserializer<PendingTask> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PendingTask::setupPendingTaskDeserializer
    );

    protected static void setupPendingTaskDeserializer(ObjectDeserializer<PendingTask.Builder> op) {
        op.add(Builder::executing, JsonpDeserializer.booleanDeserializer(), "executing");
        op.add(Builder::insertOrder, JsonpDeserializer.integerDeserializer(), "insert_order");
        op.add(Builder::priority, JsonpDeserializer.stringDeserializer(), "priority");
        op.add(Builder::source, JsonpDeserializer.stringDeserializer(), "source");
        op.add(Builder::timeInQueue, Time._DESERIALIZER, "time_in_queue");
        op.add(Builder::timeInQueueMillis, JsonpDeserializer.longDeserializer(), "time_in_queue_millis");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.executing);
        result = 31 * result + Integer.hashCode(this.insertOrder);
        result = 31 * result + this.priority.hashCode();
        result = 31 * result + this.source.hashCode();
        result = 31 * result + Objects.hashCode(this.timeInQueue);
        result = 31 * result + Long.hashCode(this.timeInQueueMillis);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PendingTask other = (PendingTask) o;
        return this.executing == other.executing
            && this.insertOrder == other.insertOrder
            && this.priority.equals(other.priority)
            && this.source.equals(other.source)
            && Objects.equals(this.timeInQueue, other.timeInQueue)
            && this.timeInQueueMillis == other.timeInQueueMillis;
    }
}
