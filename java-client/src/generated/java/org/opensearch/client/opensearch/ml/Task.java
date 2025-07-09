/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Task

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Task implements PlainJsonSerializable, ToCopyableBuilder<Task.Builder, Task> {

    @Nullable
    private final Long createTime;

    @Nullable
    private final String error;

    @Nullable
    private final FunctionName functionName;

    @Nullable
    private final Boolean isAsync;

    @Nullable
    private final Long lastUpdateTime;

    @Nullable
    private final String modelId;

    @Nonnull
    private final String state;

    @Nullable
    private final String taskId;

    @Nullable
    private final String taskType;

    @Nonnull
    private final List<List<String>> workerNode;

    // ---------------------------------------------------------------------------------------------

    private Task(Builder builder) {
        this.createTime = builder.createTime;
        this.error = builder.error;
        this.functionName = builder.functionName;
        this.isAsync = builder.isAsync;
        this.lastUpdateTime = builder.lastUpdateTime;
        this.modelId = builder.modelId;
        this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");
        this.taskId = builder.taskId;
        this.taskType = builder.taskType;
        this.workerNode = ApiTypeHelper.unmodifiable(builder.workerNode);
    }

    public static Task of(Function<Task.Builder, ObjectBuilder<Task>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code create_time}
     */
    @Nullable
    public final Long createTime() {
        return this.createTime;
    }

    /**
     * API name: {@code error}
     */
    @Nullable
    public final String error() {
        return this.error;
    }

    /**
     * API name: {@code function_name}
     */
    @Nullable
    public final FunctionName functionName() {
        return this.functionName;
    }

    /**
     * API name: {@code is_async}
     */
    @Nullable
    public final Boolean isAsync() {
        return this.isAsync;
    }

    /**
     * API name: {@code last_update_time}
     */
    @Nullable
    public final Long lastUpdateTime() {
        return this.lastUpdateTime;
    }

    /**
     * API name: {@code model_id}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * Required - API name: {@code state}
     */
    @Nonnull
    public final String state() {
        return this.state;
    }

    /**
     * API name: {@code task_id}
     */
    @Nullable
    public final String taskId() {
        return this.taskId;
    }

    /**
     * API name: {@code task_type}
     */
    @Nullable
    public final String taskType() {
        return this.taskType;
    }

    /**
     * API name: {@code worker_node}
     */
    @Nonnull
    public final List<List<String>> workerNode() {
        return this.workerNode;
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
        if (this.createTime != null) {
            generator.writeKey("create_time");
            generator.write(this.createTime);
        }

        if (this.error != null) {
            generator.writeKey("error");
            generator.write(this.error);
        }

        if (this.functionName != null) {
            generator.writeKey("function_name");
            this.functionName.serialize(generator, mapper);
        }

        if (this.isAsync != null) {
            generator.writeKey("is_async");
            generator.write(this.isAsync);
        }

        if (this.lastUpdateTime != null) {
            generator.writeKey("last_update_time");
            generator.write(this.lastUpdateTime);
        }

        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        generator.writeKey("state");
        generator.write(this.state);

        if (this.taskId != null) {
            generator.writeKey("task_id");
            generator.write(this.taskId);
        }

        if (this.taskType != null) {
            generator.writeKey("task_type");
            generator.write(this.taskType);
        }

        if (ApiTypeHelper.isDefined(this.workerNode)) {
            generator.writeKey("worker_node");
            generator.writeStartArray();
            for (List<String> item0 : this.workerNode) {
                generator.writeStartArray();
                for (String item1 : item0) {
                    generator.write(item1);
                }
                generator.writeEnd();
            }
            generator.writeEnd();
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
     * Builder for {@link Task}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Task> {
        @Nullable
        private Long createTime;
        @Nullable
        private String error;
        @Nullable
        private FunctionName functionName;
        @Nullable
        private Boolean isAsync;
        @Nullable
        private Long lastUpdateTime;
        @Nullable
        private String modelId;
        private String state;
        @Nullable
        private String taskId;
        @Nullable
        private String taskType;
        @Nullable
        private List<List<String>> workerNode;

        public Builder() {}

        private Builder(Task o) {
            this.createTime = o.createTime;
            this.error = o.error;
            this.functionName = o.functionName;
            this.isAsync = o.isAsync;
            this.lastUpdateTime = o.lastUpdateTime;
            this.modelId = o.modelId;
            this.state = o.state;
            this.taskId = o.taskId;
            this.taskType = o.taskType;
            this.workerNode = _listCopy(o.workerNode);
        }

        private Builder(Builder o) {
            this.createTime = o.createTime;
            this.error = o.error;
            this.functionName = o.functionName;
            this.isAsync = o.isAsync;
            this.lastUpdateTime = o.lastUpdateTime;
            this.modelId = o.modelId;
            this.state = o.state;
            this.taskId = o.taskId;
            this.taskType = o.taskType;
            this.workerNode = _listCopy(o.workerNode);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code create_time}
         */
        @Nonnull
        public final Builder createTime(@Nullable Long value) {
            this.createTime = value;
            return this;
        }

        /**
         * API name: {@code error}
         */
        @Nonnull
        public final Builder error(@Nullable String value) {
            this.error = value;
            return this;
        }

        /**
         * API name: {@code function_name}
         */
        @Nonnull
        public final Builder functionName(@Nullable FunctionName value) {
            this.functionName = value;
            return this;
        }

        /**
         * API name: {@code is_async}
         */
        @Nonnull
        public final Builder isAsync(@Nullable Boolean value) {
            this.isAsync = value;
            return this;
        }

        /**
         * API name: {@code last_update_time}
         */
        @Nonnull
        public final Builder lastUpdateTime(@Nullable Long value) {
            this.lastUpdateTime = value;
            return this;
        }

        /**
         * API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Required - API name: {@code state}
         */
        @Nonnull
        public final Builder state(String value) {
            this.state = value;
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
         * API name: {@code task_type}
         */
        @Nonnull
        public final Builder taskType(@Nullable String value) {
            this.taskType = value;
            return this;
        }

        /**
         * API name: {@code worker_node}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>workerNode</code>.
         * </p>
         */
        @Nonnull
        public final Builder workerNode(List<List<String>> list) {
            this.workerNode = _listAddAll(this.workerNode, list);
            return this;
        }

        /**
         * API name: {@code worker_node}
         *
         * <p>
         * Adds one or more values to <code>workerNode</code>.
         * </p>
         */
        @Nonnull
        public final Builder workerNode(List<String> value, List<String>... values) {
            this.workerNode = _listAdd(this.workerNode, value, values);
            return this;
        }

        /**
         * Builds a {@link Task}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Task build() {
            _checkSingleUse();

            return new Task(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Task}
     */
    public static final JsonpDeserializer<Task> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Task::setupTaskDeserializer);

    protected static void setupTaskDeserializer(ObjectDeserializer<Task.Builder> op) {
        op.add(Builder::createTime, JsonpDeserializer.longDeserializer(), "create_time");
        op.add(Builder::error, JsonpDeserializer.stringDeserializer(), "error");
        op.add(Builder::functionName, FunctionName._DESERIALIZER, "function_name");
        op.add(Builder::isAsync, JsonpDeserializer.booleanDeserializer(), "is_async");
        op.add(Builder::lastUpdateTime, JsonpDeserializer.longDeserializer(), "last_update_time");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
        op.add(Builder::taskId, JsonpDeserializer.stringDeserializer(), "task_id");
        op.add(Builder::taskType, JsonpDeserializer.stringDeserializer(), "task_type");
        op.add(
            Builder::workerNode,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "worker_node"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.createTime);
        result = 31 * result + Objects.hashCode(this.error);
        result = 31 * result + Objects.hashCode(this.functionName);
        result = 31 * result + Objects.hashCode(this.isAsync);
        result = 31 * result + Objects.hashCode(this.lastUpdateTime);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + this.state.hashCode();
        result = 31 * result + Objects.hashCode(this.taskId);
        result = 31 * result + Objects.hashCode(this.taskType);
        result = 31 * result + Objects.hashCode(this.workerNode);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Task other = (Task) o;
        return Objects.equals(this.createTime, other.createTime)
            && Objects.equals(this.error, other.error)
            && Objects.equals(this.functionName, other.functionName)
            && Objects.equals(this.isAsync, other.isAsync)
            && Objects.equals(this.lastUpdateTime, other.lastUpdateTime)
            && Objects.equals(this.modelId, other.modelId)
            && this.state.equals(other.state)
            && Objects.equals(this.taskId, other.taskId)
            && Objects.equals(this.taskType, other.taskType)
            && Objects.equals(this.workerNode, other.workerNode);
    }
}
