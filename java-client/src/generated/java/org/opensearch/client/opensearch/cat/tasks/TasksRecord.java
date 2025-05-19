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

package org.opensearch.client.opensearch.cat.tasks;

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

// typedef: cat.tasks.TasksRecord

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TasksRecord implements PlainJsonSerializable, ToCopyableBuilder<TasksRecord.Builder, TasksRecord> {

    @Nullable
    private final String action;

    @Nullable
    private final String description;

    @Nullable
    private final String id;

    @Nullable
    private final String ip;

    @Nullable
    private final String node;

    @Nullable
    private final String nodeId;

    @Nullable
    private final String parentTaskId;

    @Nullable
    private final String port;

    @Nullable
    private final String runningTime;

    @Nullable
    private final String runningTimeNs;

    @Nullable
    private final String startTime;

    @Nullable
    private final String taskId;

    @Nullable
    private final String timestamp;

    @Nullable
    private final String type;

    @Nullable
    private final String version;

    @Nullable
    private final String xOpaqueId;

    // ---------------------------------------------------------------------------------------------

    private TasksRecord(Builder builder) {
        this.action = builder.action;
        this.description = builder.description;
        this.id = builder.id;
        this.ip = builder.ip;
        this.node = builder.node;
        this.nodeId = builder.nodeId;
        this.parentTaskId = builder.parentTaskId;
        this.port = builder.port;
        this.runningTime = builder.runningTime;
        this.runningTimeNs = builder.runningTimeNs;
        this.startTime = builder.startTime;
        this.taskId = builder.taskId;
        this.timestamp = builder.timestamp;
        this.type = builder.type;
        this.version = builder.version;
        this.xOpaqueId = builder.xOpaqueId;
    }

    public static TasksRecord of(Function<TasksRecord.Builder, ObjectBuilder<TasksRecord>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The task action.
     * <p>
     * API name: {@code action}
     * </p>
     */
    @Nullable
    public final String action() {
        return this.action;
    }

    /**
     * The task action description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The IP address for the node.
     * <p>
     * API name: {@code ip}
     * </p>
     */
    @Nullable
    public final String ip() {
        return this.ip;
    }

    /**
     * The node name.
     * <p>
     * API name: {@code node}
     * </p>
     */
    @Nullable
    public final String node() {
        return this.node;
    }

    /**
     * API name: {@code node_id}
     */
    @Nullable
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * The parent task identifier.
     * <p>
     * API name: {@code parent_task_id}
     * </p>
     */
    @Nullable
    public final String parentTaskId() {
        return this.parentTaskId;
    }

    /**
     * The bound transport port for the node.
     * <p>
     * API name: {@code port}
     * </p>
     */
    @Nullable
    public final String port() {
        return this.port;
    }

    /**
     * The running time.
     * <p>
     * API name: {@code running_time}
     * </p>
     */
    @Nullable
    public final String runningTime() {
        return this.runningTime;
    }

    /**
     * The running time in nanoseconds.
     * <p>
     * API name: {@code running_time_ns}
     * </p>
     */
    @Nullable
    public final String runningTimeNs() {
        return this.runningTimeNs;
    }

    /**
     * The start time in milliseconds.
     * <p>
     * API name: {@code start_time}
     * </p>
     */
    @Nullable
    public final String startTime() {
        return this.startTime;
    }

    /**
     * API name: {@code task_id}
     */
    @Nullable
    public final String taskId() {
        return this.taskId;
    }

    /**
     * The start time in <code>HH:MM:SS</code> format.
     * <p>
     * API name: {@code timestamp}
     * </p>
     */
    @Nullable
    public final String timestamp() {
        return this.timestamp;
    }

    /**
     * The task type.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nullable
    public final String type() {
        return this.type;
    }

    /**
     * API name: {@code version}
     */
    @Nullable
    public final String version() {
        return this.version;
    }

    /**
     * The X-Opaque-ID header.
     * <p>
     * API name: {@code x_opaque_id}
     * </p>
     */
    @Nullable
    public final String xOpaqueId() {
        return this.xOpaqueId;
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
        if (this.action != null) {
            generator.writeKey("action");
            generator.write(this.action);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.id != null) {
            generator.writeKey("id");
            generator.write(this.id);
        }

        if (this.ip != null) {
            generator.writeKey("ip");
            generator.write(this.ip);
        }

        if (this.node != null) {
            generator.writeKey("node");
            generator.write(this.node);
        }

        if (this.nodeId != null) {
            generator.writeKey("node_id");
            generator.write(this.nodeId);
        }

        if (this.parentTaskId != null) {
            generator.writeKey("parent_task_id");
            generator.write(this.parentTaskId);
        }

        if (this.port != null) {
            generator.writeKey("port");
            generator.write(this.port);
        }

        if (this.runningTime != null) {
            generator.writeKey("running_time");
            generator.write(this.runningTime);
        }

        if (this.runningTimeNs != null) {
            generator.writeKey("running_time_ns");
            generator.write(this.runningTimeNs);
        }

        if (this.startTime != null) {
            generator.writeKey("start_time");
            generator.write(this.startTime);
        }

        if (this.taskId != null) {
            generator.writeKey("task_id");
            generator.write(this.taskId);
        }

        if (this.timestamp != null) {
            generator.writeKey("timestamp");
            generator.write(this.timestamp);
        }

        if (this.type != null) {
            generator.writeKey("type");
            generator.write(this.type);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }

        if (this.xOpaqueId != null) {
            generator.writeKey("x_opaque_id");
            generator.write(this.xOpaqueId);
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
     * Builder for {@link TasksRecord}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TasksRecord> {
        @Nullable
        private String action;
        @Nullable
        private String description;
        @Nullable
        private String id;
        @Nullable
        private String ip;
        @Nullable
        private String node;
        @Nullable
        private String nodeId;
        @Nullable
        private String parentTaskId;
        @Nullable
        private String port;
        @Nullable
        private String runningTime;
        @Nullable
        private String runningTimeNs;
        @Nullable
        private String startTime;
        @Nullable
        private String taskId;
        @Nullable
        private String timestamp;
        @Nullable
        private String type;
        @Nullable
        private String version;
        @Nullable
        private String xOpaqueId;

        public Builder() {}

        private Builder(TasksRecord o) {
            this.action = o.action;
            this.description = o.description;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
            this.nodeId = o.nodeId;
            this.parentTaskId = o.parentTaskId;
            this.port = o.port;
            this.runningTime = o.runningTime;
            this.runningTimeNs = o.runningTimeNs;
            this.startTime = o.startTime;
            this.taskId = o.taskId;
            this.timestamp = o.timestamp;
            this.type = o.type;
            this.version = o.version;
            this.xOpaqueId = o.xOpaqueId;
        }

        private Builder(Builder o) {
            this.action = o.action;
            this.description = o.description;
            this.id = o.id;
            this.ip = o.ip;
            this.node = o.node;
            this.nodeId = o.nodeId;
            this.parentTaskId = o.parentTaskId;
            this.port = o.port;
            this.runningTime = o.runningTime;
            this.runningTimeNs = o.runningTimeNs;
            this.startTime = o.startTime;
            this.taskId = o.taskId;
            this.timestamp = o.timestamp;
            this.type = o.type;
            this.version = o.version;
            this.xOpaqueId = o.xOpaqueId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The task action.
         * <p>
         * API name: {@code action}
         * </p>
         */
        @Nonnull
        public final Builder action(@Nullable String value) {
            this.action = value;
            return this;
        }

        /**
         * The task action description.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code id}
         */
        @Nonnull
        public final Builder id(@Nullable String value) {
            this.id = value;
            return this;
        }

        /**
         * The IP address for the node.
         * <p>
         * API name: {@code ip}
         * </p>
         */
        @Nonnull
        public final Builder ip(@Nullable String value) {
            this.ip = value;
            return this;
        }

        /**
         * The node name.
         * <p>
         * API name: {@code node}
         * </p>
         */
        @Nonnull
        public final Builder node(@Nullable String value) {
            this.node = value;
            return this;
        }

        /**
         * API name: {@code node_id}
         */
        @Nonnull
        public final Builder nodeId(@Nullable String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * The parent task identifier.
         * <p>
         * API name: {@code parent_task_id}
         * </p>
         */
        @Nonnull
        public final Builder parentTaskId(@Nullable String value) {
            this.parentTaskId = value;
            return this;
        }

        /**
         * The bound transport port for the node.
         * <p>
         * API name: {@code port}
         * </p>
         */
        @Nonnull
        public final Builder port(@Nullable String value) {
            this.port = value;
            return this;
        }

        /**
         * The running time.
         * <p>
         * API name: {@code running_time}
         * </p>
         */
        @Nonnull
        public final Builder runningTime(@Nullable String value) {
            this.runningTime = value;
            return this;
        }

        /**
         * The running time in nanoseconds.
         * <p>
         * API name: {@code running_time_ns}
         * </p>
         */
        @Nonnull
        public final Builder runningTimeNs(@Nullable String value) {
            this.runningTimeNs = value;
            return this;
        }

        /**
         * The start time in milliseconds.
         * <p>
         * API name: {@code start_time}
         * </p>
         */
        @Nonnull
        public final Builder startTime(@Nullable String value) {
            this.startTime = value;
            return this;
        }

        /**
         * API name: {@code task_id}
         */
        @Nonnull
        public final Builder taskId(@Nullable String value) {
            this.taskId = value;
            return this;
        }

        /**
         * The start time in <code>HH:MM:SS</code> format.
         * <p>
         * API name: {@code timestamp}
         * </p>
         */
        @Nonnull
        public final Builder timestamp(@Nullable String value) {
            this.timestamp = value;
            return this;
        }

        /**
         * The task type.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(@Nullable String value) {
            this.type = value;
            return this;
        }

        /**
         * API name: {@code version}
         */
        @Nonnull
        public final Builder version(@Nullable String value) {
            this.version = value;
            return this;
        }

        /**
         * The X-Opaque-ID header.
         * <p>
         * API name: {@code x_opaque_id}
         * </p>
         */
        @Nonnull
        public final Builder xOpaqueId(@Nullable String value) {
            this.xOpaqueId = value;
            return this;
        }

        /**
         * Builds a {@link TasksRecord}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TasksRecord build() {
            _checkSingleUse();

            return new TasksRecord(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TasksRecord}
     */
    public static final JsonpDeserializer<TasksRecord> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TasksRecord::setupTasksRecordDeserializer
    );

    protected static void setupTasksRecordDeserializer(ObjectDeserializer<TasksRecord.Builder> op) {
        op.add(Builder::action, JsonpDeserializer.stringDeserializer(), "action");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
        op.add(Builder::ip, JsonpDeserializer.stringDeserializer(), "ip");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::parentTaskId, JsonpDeserializer.stringDeserializer(), "parent_task_id");
        op.add(Builder::port, JsonpDeserializer.stringDeserializer(), "port");
        op.add(Builder::runningTime, JsonpDeserializer.stringDeserializer(), "running_time");
        op.add(Builder::runningTimeNs, JsonpDeserializer.stringDeserializer(), "running_time_ns");
        op.add(Builder::startTime, JsonpDeserializer.stringDeserializer(), "start_time");
        op.add(Builder::taskId, JsonpDeserializer.stringDeserializer(), "task_id");
        op.add(Builder::timestamp, JsonpDeserializer.stringDeserializer(), "timestamp");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
        op.add(Builder::xOpaqueId, JsonpDeserializer.stringDeserializer(), "x_opaque_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.action);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.ip);
        result = 31 * result + Objects.hashCode(this.node);
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.parentTaskId);
        result = 31 * result + Objects.hashCode(this.port);
        result = 31 * result + Objects.hashCode(this.runningTime);
        result = 31 * result + Objects.hashCode(this.runningTimeNs);
        result = 31 * result + Objects.hashCode(this.startTime);
        result = 31 * result + Objects.hashCode(this.taskId);
        result = 31 * result + Objects.hashCode(this.timestamp);
        result = 31 * result + Objects.hashCode(this.type);
        result = 31 * result + Objects.hashCode(this.version);
        result = 31 * result + Objects.hashCode(this.xOpaqueId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TasksRecord other = (TasksRecord) o;
        return Objects.equals(this.action, other.action)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.id, other.id)
            && Objects.equals(this.ip, other.ip)
            && Objects.equals(this.node, other.node)
            && Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.parentTaskId, other.parentTaskId)
            && Objects.equals(this.port, other.port)
            && Objects.equals(this.runningTime, other.runningTime)
            && Objects.equals(this.runningTimeNs, other.runningTimeNs)
            && Objects.equals(this.startTime, other.startTime)
            && Objects.equals(this.taskId, other.taskId)
            && Objects.equals(this.timestamp, other.timestamp)
            && Objects.equals(this.type, other.type)
            && Objects.equals(this.version, other.version)
            && Objects.equals(this.xOpaqueId, other.xOpaqueId);
    }
}
