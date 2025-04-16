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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
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

// typedef: _types.TaskFailure

/**
 * The details of a task failure.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TaskFailure implements PlainJsonSerializable, ToCopyableBuilder<TaskFailure.Builder, TaskFailure> {

    @Nonnull
    private final String nodeId;

    @Nonnull
    private final ErrorCause reason;

    @Nonnull
    private final String status;

    private final int taskId;

    // ---------------------------------------------------------------------------------------------

    private TaskFailure(Builder builder) {
        this.nodeId = ApiTypeHelper.requireNonNull(builder.nodeId, this, "nodeId");
        this.reason = ApiTypeHelper.requireNonNull(builder.reason, this, "reason");
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
    }

    public static TaskFailure of(Function<TaskFailure.Builder, ObjectBuilder<TaskFailure>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code node_id}
     */
    @Nonnull
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * Required - API name: {@code reason}
     */
    @Nonnull
    public final ErrorCause reason() {
        return this.reason;
    }

    /**
     * Required - The status of the failed task.
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nonnull
    public final String status() {
        return this.status;
    }

    /**
     * Required - The ID of the failed task.
     * <p>
     * API name: {@code task_id}
     * </p>
     */
    public final int taskId() {
        return this.taskId;
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
        generator.writeKey("node_id");
        generator.write(this.nodeId);

        generator.writeKey("reason");
        this.reason.serialize(generator, mapper);

        generator.writeKey("status");
        generator.write(this.status);

        generator.writeKey("task_id");
        generator.write(this.taskId);
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
     * Builder for {@link TaskFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TaskFailure> {
        private String nodeId;
        private ErrorCause reason;
        private String status;
        private Integer taskId;

        public Builder() {}

        private Builder(TaskFailure o) {
            this.nodeId = o.nodeId;
            this.reason = o.reason;
            this.status = o.status;
            this.taskId = o.taskId;
        }

        private Builder(Builder o) {
            this.nodeId = o.nodeId;
            this.reason = o.reason;
            this.status = o.status;
            this.taskId = o.taskId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code node_id}
         */
        @Nonnull
        public final Builder nodeId(String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(ErrorCause value) {
            this.reason = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        @Nonnull
        public final Builder reason(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return reason(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Required - The status of the failed task.
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Required - The ID of the failed task.
         * <p>
         * API name: {@code task_id}
         * </p>
         */
        @Nonnull
        public final Builder taskId(int value) {
            this.taskId = value;
            return this;
        }

        /**
         * Builds a {@link TaskFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TaskFailure build() {
            _checkSingleUse();

            return new TaskFailure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TaskFailure}
     */
    public static final JsonpDeserializer<TaskFailure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TaskFailure::setupTaskFailureDeserializer
    );

    protected static void setupTaskFailureDeserializer(ObjectDeserializer<TaskFailure.Builder> op) {
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::reason, ErrorCause._DESERIALIZER, "reason");
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::taskId, JsonpDeserializer.integerDeserializer(), "task_id");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.nodeId.hashCode();
        result = 31 * result + this.reason.hashCode();
        result = 31 * result + this.status.hashCode();
        result = 31 * result + Integer.hashCode(this.taskId);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TaskFailure other = (TaskFailure) o;
        return this.nodeId.equals(other.nodeId)
            && this.reason.equals(other.reason)
            && this.status.equals(other.status)
            && this.taskId == other.taskId;
    }
}
