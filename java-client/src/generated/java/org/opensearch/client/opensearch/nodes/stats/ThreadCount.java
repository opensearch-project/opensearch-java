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

// typedef: nodes.stats.ThreadCount

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ThreadCount implements PlainJsonSerializable, ToCopyableBuilder<ThreadCount.Builder, ThreadCount> {

    @Nullable
    private final Long active;

    @Nullable
    private final Long completed;

    @Nullable
    private final Long largest;

    @Nullable
    private final Long queue;

    @Nullable
    private final Long rejected;

    @Nullable
    private final Long threads;

    @Nullable
    private final Time totalWaitTime;

    @Nullable
    private final Long totalWaitTimeInNanos;

    // ---------------------------------------------------------------------------------------------

    private ThreadCount(Builder builder) {
        this.active = builder.active;
        this.completed = builder.completed;
        this.largest = builder.largest;
        this.queue = builder.queue;
        this.rejected = builder.rejected;
        this.threads = builder.threads;
        this.totalWaitTime = builder.totalWaitTime;
        this.totalWaitTimeInNanos = builder.totalWaitTimeInNanos;
    }

    public static ThreadCount of(Function<ThreadCount.Builder, ObjectBuilder<ThreadCount>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Number of active threads in the thread pool.
     * <p>
     * API name: {@code active}
     * </p>
     */
    @Nullable
    public final Long active() {
        return this.active;
    }

    /**
     * Number of tasks completed by the thread pool executor.
     * <p>
     * API name: {@code completed}
     * </p>
     */
    @Nullable
    public final Long completed() {
        return this.completed;
    }

    /**
     * Highest number of active threads in the thread pool.
     * <p>
     * API name: {@code largest}
     * </p>
     */
    @Nullable
    public final Long largest() {
        return this.largest;
    }

    /**
     * Number of tasks in queue for the thread pool.
     * <p>
     * API name: {@code queue}
     * </p>
     */
    @Nullable
    public final Long queue() {
        return this.queue;
    }

    /**
     * Number of tasks rejected by the thread pool executor.
     * <p>
     * API name: {@code rejected}
     * </p>
     */
    @Nullable
    public final Long rejected() {
        return this.rejected;
    }

    /**
     * Number of threads in the thread pool.
     * <p>
     * API name: {@code threads}
     * </p>
     */
    @Nullable
    public final Long threads() {
        return this.threads;
    }

    /**
     * The total amount of time that tasks spend waiting in the thread pool queue. Currently, only <code>search</code>,
     * <code>search_throttled</code>, and <code>index_searcher</code> thread pools support this metric.
     * <p>
     * API name: {@code total_wait_time}
     * </p>
     */
    @Nullable
    public final Time totalWaitTime() {
        return this.totalWaitTime;
    }

    /**
     * The total amount of time that tasks spend waiting in the thread pool queue. Currently, only <code>search</code>,
     * <code>search_throttled</code>, and <code>index_searcher</code> thread pools support this metric.
     * <p>
     * API name: {@code total_wait_time_in_nanos}
     * </p>
     */
    @Nullable
    public final Long totalWaitTimeInNanos() {
        return this.totalWaitTimeInNanos;
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
        if (this.active != null) {
            generator.writeKey("active");
            generator.write(this.active);
        }

        if (this.completed != null) {
            generator.writeKey("completed");
            generator.write(this.completed);
        }

        if (this.largest != null) {
            generator.writeKey("largest");
            generator.write(this.largest);
        }

        if (this.queue != null) {
            generator.writeKey("queue");
            generator.write(this.queue);
        }

        if (this.rejected != null) {
            generator.writeKey("rejected");
            generator.write(this.rejected);
        }

        if (this.threads != null) {
            generator.writeKey("threads");
            generator.write(this.threads);
        }

        if (this.totalWaitTime != null) {
            generator.writeKey("total_wait_time");
            this.totalWaitTime.serialize(generator, mapper);
        }

        if (this.totalWaitTimeInNanos != null) {
            generator.writeKey("total_wait_time_in_nanos");
            generator.write(this.totalWaitTimeInNanos);
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
     * Builder for {@link ThreadCount}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ThreadCount> {
        @Nullable
        private Long active;
        @Nullable
        private Long completed;
        @Nullable
        private Long largest;
        @Nullable
        private Long queue;
        @Nullable
        private Long rejected;
        @Nullable
        private Long threads;
        @Nullable
        private Time totalWaitTime;
        @Nullable
        private Long totalWaitTimeInNanos;

        public Builder() {}

        private Builder(ThreadCount o) {
            this.active = o.active;
            this.completed = o.completed;
            this.largest = o.largest;
            this.queue = o.queue;
            this.rejected = o.rejected;
            this.threads = o.threads;
            this.totalWaitTime = o.totalWaitTime;
            this.totalWaitTimeInNanos = o.totalWaitTimeInNanos;
        }

        private Builder(Builder o) {
            this.active = o.active;
            this.completed = o.completed;
            this.largest = o.largest;
            this.queue = o.queue;
            this.rejected = o.rejected;
            this.threads = o.threads;
            this.totalWaitTime = o.totalWaitTime;
            this.totalWaitTimeInNanos = o.totalWaitTimeInNanos;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Number of active threads in the thread pool.
         * <p>
         * API name: {@code active}
         * </p>
         */
        @Nonnull
        public final Builder active(@Nullable Long value) {
            this.active = value;
            return this;
        }

        /**
         * Number of tasks completed by the thread pool executor.
         * <p>
         * API name: {@code completed}
         * </p>
         */
        @Nonnull
        public final Builder completed(@Nullable Long value) {
            this.completed = value;
            return this;
        }

        /**
         * Highest number of active threads in the thread pool.
         * <p>
         * API name: {@code largest}
         * </p>
         */
        @Nonnull
        public final Builder largest(@Nullable Long value) {
            this.largest = value;
            return this;
        }

        /**
         * Number of tasks in queue for the thread pool.
         * <p>
         * API name: {@code queue}
         * </p>
         */
        @Nonnull
        public final Builder queue(@Nullable Long value) {
            this.queue = value;
            return this;
        }

        /**
         * Number of tasks rejected by the thread pool executor.
         * <p>
         * API name: {@code rejected}
         * </p>
         */
        @Nonnull
        public final Builder rejected(@Nullable Long value) {
            this.rejected = value;
            return this;
        }

        /**
         * Number of threads in the thread pool.
         * <p>
         * API name: {@code threads}
         * </p>
         */
        @Nonnull
        public final Builder threads(@Nullable Long value) {
            this.threads = value;
            return this;
        }

        /**
         * The total amount of time that tasks spend waiting in the thread pool queue. Currently, only <code>search</code>,
         * <code>search_throttled</code>, and <code>index_searcher</code> thread pools support this metric.
         * <p>
         * API name: {@code total_wait_time}
         * </p>
         */
        @Nonnull
        public final Builder totalWaitTime(@Nullable Time value) {
            this.totalWaitTime = value;
            return this;
        }

        /**
         * The total amount of time that tasks spend waiting in the thread pool queue. Currently, only <code>search</code>,
         * <code>search_throttled</code>, and <code>index_searcher</code> thread pools support this metric.
         * <p>
         * API name: {@code total_wait_time}
         * </p>
         */
        @Nonnull
        public final Builder totalWaitTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return totalWaitTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * The total amount of time that tasks spend waiting in the thread pool queue. Currently, only <code>search</code>,
         * <code>search_throttled</code>, and <code>index_searcher</code> thread pools support this metric.
         * <p>
         * API name: {@code total_wait_time_in_nanos}
         * </p>
         */
        @Nonnull
        public final Builder totalWaitTimeInNanos(@Nullable Long value) {
            this.totalWaitTimeInNanos = value;
            return this;
        }

        /**
         * Builds a {@link ThreadCount}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ThreadCount build() {
            _checkSingleUse();

            return new ThreadCount(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ThreadCount}
     */
    public static final JsonpDeserializer<ThreadCount> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ThreadCount::setupThreadCountDeserializer
    );

    protected static void setupThreadCountDeserializer(ObjectDeserializer<ThreadCount.Builder> op) {
        op.add(Builder::active, JsonpDeserializer.longDeserializer(), "active");
        op.add(Builder::completed, JsonpDeserializer.longDeserializer(), "completed");
        op.add(Builder::largest, JsonpDeserializer.longDeserializer(), "largest");
        op.add(Builder::queue, JsonpDeserializer.longDeserializer(), "queue");
        op.add(Builder::rejected, JsonpDeserializer.longDeserializer(), "rejected");
        op.add(Builder::threads, JsonpDeserializer.longDeserializer(), "threads");
        op.add(Builder::totalWaitTime, Time._DESERIALIZER, "total_wait_time");
        op.add(Builder::totalWaitTimeInNanos, JsonpDeserializer.longDeserializer(), "total_wait_time_in_nanos");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.active);
        result = 31 * result + Objects.hashCode(this.completed);
        result = 31 * result + Objects.hashCode(this.largest);
        result = 31 * result + Objects.hashCode(this.queue);
        result = 31 * result + Objects.hashCode(this.rejected);
        result = 31 * result + Objects.hashCode(this.threads);
        result = 31 * result + Objects.hashCode(this.totalWaitTime);
        result = 31 * result + Objects.hashCode(this.totalWaitTimeInNanos);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ThreadCount other = (ThreadCount) o;
        return Objects.equals(this.active, other.active)
            && Objects.equals(this.completed, other.completed)
            && Objects.equals(this.largest, other.largest)
            && Objects.equals(this.queue, other.queue)
            && Objects.equals(this.rejected, other.rejected)
            && Objects.equals(this.threads, other.threads)
            && Objects.equals(this.totalWaitTime, other.totalWaitTime)
            && Objects.equals(this.totalWaitTimeInNanos, other.totalWaitTimeInNanos);
    }
}
