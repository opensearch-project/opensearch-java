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
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: tasks.get.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class GetTasksResponse implements PlainJsonSerializable {

    private final boolean completed;

    @Nullable
    private final ErrorCause error;

    @Nullable
    private final TaskResponse response;

    @Nonnull
    private final TaskInfo task;

    // ---------------------------------------------------------------------------------------------

    private GetTasksResponse(Builder builder) {
        this.completed = ApiTypeHelper.requireNonNull(builder.completed, this, "completed");
        this.error = builder.error;
        this.response = builder.response;
        this.task = ApiTypeHelper.requireNonNull(builder.task, this, "task");
    }

    public static GetTasksResponse of(Function<GetTasksResponse.Builder, ObjectBuilder<GetTasksResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code completed}
     */
    public final boolean completed() {
        return this.completed;
    }

    /**
     * API name: {@code error}
     */
    @Nullable
    public final ErrorCause error() {
        return this.error;
    }

    /**
     * API name: {@code response}
     */
    @Nullable
    public final TaskResponse response() {
        return this.response;
    }

    /**
     * Required - API name: {@code task}
     */
    @Nonnull
    public final TaskInfo task() {
        return this.task;
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
        generator.writeKey("completed");
        generator.write(this.completed);

        if (this.error != null) {
            generator.writeKey("error");
            this.error.serialize(generator, mapper);
        }

        if (this.response != null) {
            generator.writeKey("response");
            this.response.serialize(generator, mapper);
        }

        generator.writeKey("task");
        this.task.serialize(generator, mapper);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link GetTasksResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<GetTasksResponse> {
        private Boolean completed;
        @Nullable
        private ErrorCause error;
        @Nullable
        private TaskResponse response;
        private TaskInfo task;

        /**
         * Required - API name: {@code completed}
         */
        public final Builder completed(boolean value) {
            this.completed = value;
            return this;
        }

        /**
         * API name: {@code error}
         */
        public final Builder error(@Nullable ErrorCause value) {
            this.error = value;
            return this;
        }

        /**
         * API name: {@code error}
         */
        public final Builder error(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return error(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * API name: {@code response}
         */
        public final Builder response(@Nullable TaskResponse value) {
            this.response = value;
            return this;
        }

        /**
         * API name: {@code response}
         */
        public final Builder response(Function<TaskResponse.Builder, ObjectBuilder<TaskResponse>> fn) {
            return response(fn.apply(new TaskResponse.Builder()).build());
        }

        /**
         * Required - API name: {@code task}
         */
        public final Builder task(TaskInfo value) {
            this.task = value;
            return this;
        }

        /**
         * Required - API name: {@code task}
         */
        public final Builder task(Function<TaskInfo.Builder, ObjectBuilder<TaskInfo>> fn) {
            return task(fn.apply(new TaskInfo.Builder()).build());
        }

        /**
         * Builds a {@link GetTasksResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public GetTasksResponse build() {
            _checkSingleUse();

            return new GetTasksResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetTasksResponse}
     */
    public static final JsonpDeserializer<GetTasksResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetTasksResponse::setupGetTasksResponseDeserializer
    );

    protected static void setupGetTasksResponseDeserializer(ObjectDeserializer<GetTasksResponse.Builder> op) {
        op.add(Builder::completed, JsonpDeserializer.booleanDeserializer(), "completed");
        op.add(Builder::error, ErrorCause._DESERIALIZER, "error");
        op.add(Builder::response, TaskResponse._DESERIALIZER, "response");
        op.add(Builder::task, TaskInfo._DESERIALIZER, "task");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Boolean.hashCode(this.completed);
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.response);
        result = 31 * result + this.task.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetTasksResponse other = (GetTasksResponse) o;
        return this.completed == other.completed
            && Objects.equals(this.error, other.error)
            && Objects.equals(this.response, other.response)
            && this.task.equals(other.task);
    }
}
