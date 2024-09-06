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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: tasks.TaskInfo

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TaskInfo implements PlainJsonSerializable {

    private final String action;

    private final boolean cancellable;

    @Nullable
    private final Boolean cancelled;

    @Nullable
    private final String description;

    private final Map<String, String> headers;

    private final long id;

    private final String node;

    @Nullable
    private final String parentTaskId;

    @Nullable
    private final Time runningTime;

    private final long runningTimeInNanos;

    private final long startTimeInMillis;

    @Nullable
    private final Status status;

    private final String type;

    // ---------------------------------------------------------------------------------------------

    private TaskInfo(Builder builder) {
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

    public static TaskInfo of(Function<TaskInfo.Builder, ObjectBuilder<TaskInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code action}
     */
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

    /**
     * Builder for {@link TaskInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TaskInfo> {
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

        /**
         * Required - API name: {@code action}
         */
        public final Builder action(String value) {
            this.action = value;
            return this;
        }

        /**
         * Required - API name: {@code cancellable}
         */
        public final Builder cancellable(boolean value) {
            this.cancellable = value;
            return this;
        }

        /**
         * API name: {@code cancelled}
         */
        public final Builder cancelled(@Nullable Boolean value) {
            this.cancelled = value;
            return this;
        }

        /**
         * API name: {@code description}
         */
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code headers}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>headers</code>.
         * </p>
         */
        public final Builder headers(Map<String, String> map) {
            this.headers = _mapPutAll(this.headers, map);
            return this;
        }

        /**
         * Required - API name: {@code headers}
         *
         * <p>
         * Adds an entry to <code>headers</code>.
         * </p>
         */
        public final Builder headers(String key, String value) {
            this.headers = _mapPut(this.headers, key, value);
            return this;
        }

        /**
         * Required - API name: {@code id}
         */
        public final Builder id(long value) {
            this.id = value;
            return this;
        }

        /**
         * Required - API name: {@code node}
         */
        public final Builder node(String value) {
            this.node = value;
            return this;
        }

        /**
         * API name: {@code parent_task_id}
         */
        public final Builder parentTaskId(@Nullable String value) {
            this.parentTaskId = value;
            return this;
        }

        /**
         * API name: {@code running_time}
         */
        public final Builder runningTime(@Nullable Time value) {
            this.runningTime = value;
            return this;
        }

        /**
         * API name: {@code running_time}
         */
        public final Builder runningTime(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return runningTime(fn.apply(new Time.Builder()).build());
        }

        /**
         * Required - API name: {@code running_time_in_nanos}
         */
        public final Builder runningTimeInNanos(long value) {
            this.runningTimeInNanos = value;
            return this;
        }

        /**
         * Required - API name: {@code start_time_in_millis}
         */
        public final Builder startTimeInMillis(long value) {
            this.startTimeInMillis = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        public final Builder status(@Nullable Status value) {
            this.status = value;
            return this;
        }

        /**
         * API name: {@code status}
         */
        public final Builder status(Function<Status.Builder, ObjectBuilder<Status>> fn) {
            return status(fn.apply(new Status.Builder()).build());
        }

        /**
         * Required - API name: {@code type}
         */
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link TaskInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public TaskInfo build() {
            _checkSingleUse();

            return new TaskInfo(this);
        }
    }
    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TaskInfo}
     */
    public static final JsonpDeserializer<TaskInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TaskInfo::setupTaskInfoDeserializer
    );

    protected static void setupTaskInfoDeserializer(ObjectDeserializer<TaskInfo.Builder> op) {
        op.add(Builder::action, JsonpDeserializer.stringDeserializer(), "action");
        op.add(Builder::cancellable, JsonpDeserializer.booleanDeserializer(), "cancellable");
        op.add(Builder::cancelled, JsonpDeserializer.booleanDeserializer(), "cancelled");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::headers, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()), "headers");
        op.add(Builder::id, JsonpDeserializer.longDeserializer(), "id");
        op.add(Builder::node, JsonpDeserializer.stringDeserializer(), "node");
        op.add(Builder::parentTaskId, JsonpDeserializer.stringDeserializer(), "parent_task_id");
        op.add(Builder::runningTime, Time._DESERIALIZER, "running_time");
        op.add(Builder::runningTimeInNanos, JsonpDeserializer.longDeserializer(), "running_time_in_nanos");
        op.add(Builder::startTimeInMillis, JsonpDeserializer.longDeserializer(), "start_time_in_millis");
        op.add(Builder::status, Status._DESERIALIZER, "status");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }
}
