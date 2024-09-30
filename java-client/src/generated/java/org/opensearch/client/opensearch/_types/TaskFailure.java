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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.TaskFailure

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TaskFailure implements PlainJsonSerializable {

    private final String nodeId;

    private final ErrorCause reason;

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
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * Required - API name: {@code reason}
     */
    public final ErrorCause reason() {
        return this.reason;
    }

    /**
     * Required - API name: {@code status}
     */
    public final String status() {
        return this.status;
    }

    /**
     * Required - API name: {@code task_id}
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

    /**
     * Builder for {@link TaskFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TaskFailure> {
        private String nodeId;
        private ErrorCause reason;
        private String status;
        private Integer taskId;

        /**
         * Required - API name: {@code node_id}
         */
        public final Builder nodeId(String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        public final Builder reason(ErrorCause value) {
            this.reason = value;
            return this;
        }

        /**
         * Required - API name: {@code reason}
         */
        public final Builder reason(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return reason(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Required - API name: {@code status}
         */
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Required - API name: {@code task_id}
         */
        public final Builder taskId(int value) {
            this.taskId = value;
            return this;
        }

        /**
         * Builds a {@link TaskFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
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

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.nodeId.hashCode();
        result = 31 * result + this.reason.hashCode();
        result = 31 * result + this.status.hashCode();
        result = 31 * result + Integer.hashCode(this.taskId);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        TaskFailure other = (TaskFailure) o;
        return Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.reason, other.reason)
            && Objects.equals(this.status, other.status)
            && this.taskId() == other.taskId();
    }
}
