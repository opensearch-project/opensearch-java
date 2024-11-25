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

package org.opensearch.client.opensearch.tasks;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: tasks.TaskInfoBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class TaskInfoBase implements PlainJsonSerializable {

    @Nonnull
    private final String action;

    private final boolean cancellable;

    @Nullable
    private final Boolean cancelled;

    @Nullable
    private final String description;

    @Nonnull
    private final Map<String, String> headers;

    private final long id;

    @Nonnull
    private final String node;

    @Nullable
    private final String parentTaskId;

    @Nullable
    private final Time runningTime;

    private final long runningTimeInNanos;

    private final long startTimeInMillis;

    @Nullable
    private final Status status;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    protected TaskInfoBase(AbstractBuilder<?> builder) {
        this.action = ApiTypeHelper.requireNonNull(builder.action, this, "action");
        this.cancellable = ApiTypeHelper.requireNonNull(builder.cancellable, this, "cancellable");
        this.cancelled = builder.cancelled;
        this.description = builder.description;
        this.headers = ApiTypeHelper.unmodifiableRequired(builder.headers, this, "headers");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.node = ApiTypeHelper.requireNonNull(builder.node, this, "node");
        this.parentTaskId = builder.parentTaskId;
        this.runningTime = builder.runningTime;
        this.runningTimeInNanos = ApiTypeHelper.requireNonNull(builder.runningTimeInNanos, this, "runningTimeInNanos");
        this.startTimeInMillis = ApiTypeHelper.requireNonNull(builder.startTimeInMillis, this, "startTimeInMillis");
        this.status = builder.status;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    /**
     * Required - API name: {@code action}
     */
    @Nonnull
    public final String action() {
        return this.action;
    }

    /**
     * Required - API name: {@code cancellable}
     */
    public final boolean cancellable() {
        return this.cancellable;
    }

    /**
     * API name: {@code cancelled}
     */
    @Nullable
    public final Boolean cancelled() {
        return this.cancelled;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code headers}
     */
    @Nonnull
    public final Map<String, String> headers() {
        return this.headers;
    }

    /**
     * Required - API name: {@code id}
     */
    public final long id() {
        return this.id;
    }

    /**
     * Required - API name: {@code node}
     */
    @Nonnull
    public final String node() {
        return this.node;
    }

    /**
     * API name: {@code parent_task_id}
     */
    @Nullable
    public final String parentTaskId() {
        return this.parentTaskId;
    }

    /**
     * API name: {@code running_time}
     */
    @Nullable
    public final Time runningTime() {
        return this.runningTime;
    }

    /**
     * Required - API name: {@code running_time_in_nanos}
     */
    public final long runningTimeInNanos() {
        return this.runningTimeInNanos;
    }

    /**
     * Required - API name: {@code start_time_in_millis}
     */
    public final long startTimeInMillis() {
        return this.startTimeInMillis;
    }

    /**
     * API name: {@code status}
     */
    @Nullable
    public final Status status() {
        return this.status;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
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
        generator.writeKey("action");
        generator.write(this.action);

        generator.writeKey("cancellable");
        generator.write(this.cancellable);

        if (this.cancelled != null) {
            generator.writeKey("cancelled");
            generator.write(this.cancelled);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        generator.writeKey("headers");
        generator.writeStartObject();
        for (Map.Entry<String, String> item0 : this.headers.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.write(item0.getValue());
        }
        generator.writeEnd();

        generator.writeKey("id");
        generator.write(this.id);

        generator.writeKey("node");
        generator.write(this.node);

        if (this.parentTaskId != null) {
            generator.writeKey("parent_task_id");
            generator.write(this.parentTaskId);
        }

        if (this.runningTime != null) {
            generator.writeKey("running_time");
            this.runningTime.serialize(generator, mapper);
        }

        generator.writeKey("running_time_in_nanos");
        generator.write(this.runningTimeInNanos);

        generator.writeKey("start_time_in_millis");
        generator.write(this.startTimeInMillis);

        if (this.status != null) {
            generator.writeKey("status");
            this.status.serialize(generator, mapper);
        }

        generator.writeKey("type");
        generator.write(this.type);
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        private String action;
        private Boolean cancellable;
        @Nullable
        private Boolean cancelled;
        @Nullable
        private String description;
        private Map<String, String> headers;
        private Long id;
        private String node;
        @Nullable
        private String parentTaskId;
        @Nullable
        private Time runningTime;
        private Long runningTimeInNanos;
        private Long startTimeInMillis;
        @Nullable
        private Status status;
        private String type;

        protected AbstractBuilder() {}

        protected AbstractBuilder(TaskInfoBase o) {
            this.action = o.action;
            this.cancellable = o.cancellable;
            this.cancelled = o.cancelled;
            this.description = o.description;
            this.headers = _mapCopy(o.headers);
            this.id = o.id;
            this.node = o.node;
            this.parentTaskId = o.parentTaskId;
            this.runningTime = o.runningTime;
            this.runningTimeInNanos = o.runningTimeInNanos;
            this.startTimeInMillis = o.startTimeInMillis;
            this.status = o.status;
            this.type = o.type;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.action = o.action;
            this.cancellable = o.cancellable;
            this.cancelled = o.cancelled;
            this.description = o.description;
            this.headers = _mapCopy(o.headers);
            this.id = o.id;
            this.node = o.node;
            this.parentTaskId = o.parentTaskId;
            this.runningTime = o.runningTime;
            this.runningTimeInNanos = o.runningTimeInNanos;
            this.startTimeInMillis = o.startTimeInMillis;
            this.status = o.status;
            this.type = o.type;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * Required - API name: {@code action}
         */
        @Nonnull
        public final BuilderT action(String value) {
            this.action = value;
            return self();
        }

        /**
         * Required - API name: {@code cancellable}
         */
        @Nonnull
        public final BuilderT cancellable(boolean value) {
            this.cancellable = value;
            return self();
        }

        /**
         * API name: {@code cancelled}
         */
        @Nonnull
        public final BuilderT cancelled(@Nullable Boolean value) {
            this.cancelled = value;
            return self();
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final BuilderT description(@Nullable String value) {
            this.description = value;
            return self();
        }

        /**
         * Required - API name: {@code headers}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>headers</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT headers(Map<String, String> map) {
            this.headers = _mapPutAll(this.headers, map);
            return self();
        }

        /**
         * Required - API name: {@code headers}
         *
         * <p>
         * Adds an entry to <code>headers</code>.
         * </p>
         */
        @Nonnull
        public final BuilderT headers(String key, String value) {
            this.headers = _mapPut(this.headers, key, value);
            return self();
        }

        /**
         * Required - API name: {@code id}
         */
        @Nonnull
        public final BuilderT id(long value) {
            this.id = value;
            return self();
        }

        /**
         * Required - API name: {@code node}
         */
        @Nonnull
        public final BuilderT node(String value) {
            this.node = value;
            return self();
        }

        /**
         * API name: {@code parent_task_id}
         */
        @Nonnull
        public final BuilderT parentTaskId(@Nullable String value) {
            this.parentTaskId = value;
            return self();
        }

        /**
         * API name: {@code running_time}
         */
        @Nonnull
        public final BuilderT runningTime(@Nullable Time value) {
            this.runningTime = value;
            return self();
        }

        /**
         * API name: {@code running_time}
         */
        @Nonnull
        public final BuilderT runningTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return runningTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code running_time_in_nanos}
         */
        @Nonnull
        public final BuilderT runningTimeInNanos(long value) {
            this.runningTimeInNanos = value;
            return self();
        }

        /**
         * Required - API name: {@code start_time_in_millis}
         */
        @Nonnull
        public final BuilderT startTimeInMillis(long value) {
            this.startTimeInMillis = value;
            return self();
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final BuilderT status(@Nullable Status value) {
            this.status = value;
            return self();
        }

        /**
         * API name: {@code status}
         */
        @Nonnull
        public final BuilderT status(Function<Status.Builder, ObjectBuilder<Status>> fn) {
            return status(fn.apply(new Status.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final BuilderT type(String value) {
            this.type = value;
            return self();
        }

    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupTaskInfoBaseDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::action, JsonpDeserializer.stringDeserializer(), "action");
        op.add(AbstractBuilder::cancellable, JsonpDeserializer.booleanDeserializer(), "cancellable");
        op.add(AbstractBuilder::cancelled, JsonpDeserializer.booleanDeserializer(), "cancelled");
        op.add(AbstractBuilder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(AbstractBuilder::headers, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "headers");
        op.add(AbstractBuilder::id, JsonpDeserializer.longDeserializer(), "id");
        op.add(AbstractBuilder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(AbstractBuilder::parentTaskId, JsonpDeserializer.stringDeserializer(), "parent_task_id");
        op.add(AbstractBuilder::runningTime, Time._DESERIALIZER, "running_time");
        op.add(AbstractBuilder::runningTimeInNanos, JsonpDeserializer.longDeserializer(), "running_time_in_nanos");
        op.add(AbstractBuilder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(AbstractBuilder::status, Status._DESERIALIZER, "status");
        op.add(AbstractBuilder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.action.hashCode();
        result = 31 * result + Boolean.hashCode(this.cancellable);
        result = 31 * result + Objects.hashCode(this.cancelled);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.headers.hashCode();
        result = 31 * result + Long.hashCode(this.id);
        result = 31 * result + this.node.hashCode();
        result = 31 * result + Objects.hashCode(this.parentTaskId);
        result = 31 * result + Objects.hashCode(this.runningTime);
        result = 31 * result + Long.hashCode(this.runningTimeInNanos);
        result = 31 * result + Long.hashCode(this.startTimeInMillis);
        result = 31 * result + Objects.hashCode(this.status);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TaskInfoBase other = (TaskInfoBase) o;
        return this.action.equals(other.action)
            && this.cancellable == other.cancellable
            && Objects.equals(this.cancelled, other.cancelled)
            && Objects.equals(this.description, other.description)
            && this.headers.equals(other.headers)
            && this.id == other.id
            && this.node.equals(other.node)
            && Objects.equals(this.parentTaskId, other.parentTaskId)
            && Objects.equals(this.runningTime, other.runningTime)
            && this.runningTimeInNanos == other.runningTimeInNanos
            && this.startTimeInMillis == other.startTimeInMillis
            && Objects.equals(this.status, other.status)
            && this.type.equals(other.type);
    }
}
