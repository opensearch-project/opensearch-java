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
import java.util.List;
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
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.opensearch._types.TaskFailure;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: tasks.TaskListResponseBase

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class TaskListResponseBase implements PlainJsonSerializable {

    @Nonnull
    private final List<ErrorCause> nodeFailures;

    @Nonnull
    private final Map<String, TaskExecutingNode> nodes;

    @Nonnull
    private final List<TaskFailure> taskFailures;

    @Nullable
    private final TaskInfos tasks;

    // ---------------------------------------------------------------------------------------------

    protected TaskListResponseBase(AbstractBuilder<?> builder) {
        this.nodeFailures = ApiTypeHelper.unmodifiable(builder.nodeFailures);
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.taskFailures = ApiTypeHelper.unmodifiable(builder.taskFailures);
        this.tasks = builder.tasks;
    }

    /**
     * API name: {@code node_failures}
     */
    @Nonnull
    public final List<ErrorCause> nodeFailures() {
        return this.nodeFailures;
    }

    /**
     * Task information grouped by node, if <code>group_by</code> was set to <code>node</code> (the default).
     * <p>
     * API name: {@code nodes}
     * </p>
     */
    @Nonnull
    public final Map<String, TaskExecutingNode> nodes() {
        return this.nodes;
    }

    /**
     * API name: {@code task_failures}
     */
    @Nonnull
    public final List<TaskFailure> taskFailures() {
        return this.taskFailures;
    }

    /**
     * API name: {@code tasks}
     */
    @Nullable
    public final TaskInfos tasks() {
        return this.tasks;
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
        if (ApiTypeHelper.isDefined(this.nodeFailures)) {
            generator.writeKey("node_failures");
            generator.writeStartArray();
            for (ErrorCause item0 : this.nodeFailures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.nodes)) {
            generator.writeKey("nodes");
            generator.writeStartObject();
            for (Map.Entry<String, TaskExecutingNode> item0 : this.nodes.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.taskFailures)) {
            generator.writeKey("task_failures");
            generator.writeStartArray();
            for (TaskFailure item0 : this.taskFailures) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.tasks != null) {
            generator.writeKey("tasks");
            this.tasks.serialize(generator, mapper);
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private List<ErrorCause> nodeFailures;
        @Nullable
        private Map<String, TaskExecutingNode> nodes;
        @Nullable
        private List<TaskFailure> taskFailures;
        @Nullable
        private TaskInfos tasks;

        /**
         * API name: {@code node_failures}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodeFailures</code>.
         * </p>
         */
        public final BuilderT nodeFailures(List<ErrorCause> list) {
            this.nodeFailures = _listAddAll(this.nodeFailures, list);
            return self();
        }

        /**
         * API name: {@code node_failures}
         *
         * <p>
         * Adds one or more values to <code>nodeFailures</code>.
         * </p>
         */
        public final BuilderT nodeFailures(ErrorCause value, ErrorCause... values) {
            this.nodeFailures = _listAdd(this.nodeFailures, value, values);
            return self();
        }

        /**
         * API name: {@code node_failures}
         *
         * <p>
         * Adds a value to <code>nodeFailures</code> using a builder lambda.
         * </p>
         */
        public final BuilderT nodeFailures(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return nodeFailures(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Task information grouped by node, if <code>group_by</code> was set to <code>node</code> (the default).
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>nodes</code>.
         * </p>
         */
        public final BuilderT nodes(Map<String, TaskExecutingNode> map) {
            this.nodes = _mapPutAll(this.nodes, map);
            return self();
        }

        /**
         * Task information grouped by node, if <code>group_by</code> was set to <code>node</code> (the default).
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds an entry to <code>nodes</code>.
         * </p>
         */
        public final BuilderT nodes(String key, TaskExecutingNode value) {
            this.nodes = _mapPut(this.nodes, key, value);
            return self();
        }

        /**
         * Task information grouped by node, if <code>group_by</code> was set to <code>node</code> (the default).
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds a value to <code>nodes</code> using a builder lambda.
         * </p>
         */
        public final BuilderT nodes(String key, Function<TaskExecutingNode.Builder, ObjectBuilder<TaskExecutingNode>> fn) {
            return nodes(key, fn.apply(new TaskExecutingNode.Builder()).build());
        }

        /**
         * API name: {@code task_failures}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>taskFailures</code>.
         * </p>
         */
        public final BuilderT taskFailures(List<TaskFailure> list) {
            this.taskFailures = _listAddAll(this.taskFailures, list);
            return self();
        }

        /**
         * API name: {@code task_failures}
         *
         * <p>
         * Adds one or more values to <code>taskFailures</code>.
         * </p>
         */
        public final BuilderT taskFailures(TaskFailure value, TaskFailure... values) {
            this.taskFailures = _listAdd(this.taskFailures, value, values);
            return self();
        }

        /**
         * API name: {@code task_failures}
         *
         * <p>
         * Adds a value to <code>taskFailures</code> using a builder lambda.
         * </p>
         */
        public final BuilderT taskFailures(Function<TaskFailure.Builder, ObjectBuilder<TaskFailure>> fn) {
            return taskFailures(fn.apply(new TaskFailure.Builder()).build());
        }

        /**
         * API name: {@code tasks}
         */
        public final BuilderT tasks(@Nullable TaskInfos value) {
            this.tasks = value;
            return self();
        }

        /**
         * API name: {@code tasks}
         */
        public final BuilderT tasks(Function<TaskInfos.Builder, ObjectBuilder<TaskInfos>> fn) {
            return tasks(fn.apply(new TaskInfos.Builder()).build());
        }

        protected abstract BuilderT self();
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupTaskListResponseBaseDeserializer(
        ObjectDeserializer<BuilderT> op
    ) {
        op.add(AbstractBuilder::nodeFailures, JsonpDeserializer.arrayDeserializer(ErrorCause._DESERIALIZER), "node_failures");
        op.add(AbstractBuilder::nodes, JsonpDeserializer.stringMapDeserializer(TaskExecutingNode._DESERIALIZER), "nodes");
        op.add(AbstractBuilder::taskFailures, JsonpDeserializer.arrayDeserializer(TaskFailure._DESERIALIZER), "task_failures");
        op.add(AbstractBuilder::tasks, TaskInfos._DESERIALIZER, "tasks");
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.nodeFailures);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + Objects.hashCode(this.taskFailures);
        result = 31 * result + Objects.hashCode(this.tasks);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TaskListResponseBase other = (TaskListResponseBase) o;
        return Objects.equals(this.nodeFailures, other.nodeFailures)
            && Objects.equals(this.nodes, other.nodes)
            && Objects.equals(this.taskFailures, other.taskFailures)
            && Objects.equals(this.tasks, other.tasks);
    }
}
