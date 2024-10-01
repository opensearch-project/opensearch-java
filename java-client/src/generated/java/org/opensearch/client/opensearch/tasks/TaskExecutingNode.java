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
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.opensearch._types.BaseNode;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;

// typedef: tasks.TaskExecutingNode

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TaskExecutingNode extends BaseNode {

    @Nonnull
    private final Map<String, TaskInfo> tasks;

    // ---------------------------------------------------------------------------------------------

    private TaskExecutingNode(Builder builder) {
        super(builder);
        this.tasks = ApiTypeHelper.unmodifiableRequired(builder.tasks, this, "tasks");
    }

    public static TaskExecutingNode of(Function<TaskExecutingNode.Builder, ObjectBuilder<TaskExecutingNode>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code tasks}
     */
    @Nonnull
    public final Map<String, TaskInfo> tasks() {
        return this.tasks;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("tasks");
        generator.writeStartObject();
        for (Map.Entry<String, TaskInfo> item0 : this.tasks.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link TaskExecutingNode}.
     */
    public static class Builder extends BaseNode.AbstractBuilder<Builder> implements ObjectBuilder<TaskExecutingNode> {
        @Override
        protected Builder self() {
            return this;
        }

        private Map<String, TaskInfo> tasks;

        /**
         * Required - API name: {@code tasks}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>tasks</code>.
         * </p>
         */
        public final Builder tasks(Map<String, TaskInfo> map) {
            this.tasks = _mapPutAll(this.tasks, map);
            return this;
        }

        /**
         * Required - API name: {@code tasks}
         *
         * <p>
         * Adds an entry to <code>tasks</code>.
         * </p>
         */
        public final Builder tasks(String key, TaskInfo value) {
            this.tasks = _mapPut(this.tasks, key, value);
            return this;
        }

        /**
         * Required - API name: {@code tasks}
         *
         * <p>
         * Adds a value to <code>tasks</code> using a builder lambda.
         * </p>
         */
        public final Builder tasks(String key, Function<TaskInfo.Builder, ObjectBuilder<TaskInfo>> fn) {
            return tasks(key, fn.apply(new TaskInfo.Builder()).build());
        }

        /**
         * Builds a {@link TaskExecutingNode}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public TaskExecutingNode build() {
            _checkSingleUse();

            return new TaskExecutingNode(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TaskExecutingNode}
     */
    public static final JsonpDeserializer<TaskExecutingNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TaskExecutingNode::setupTaskExecutingNodeDeserializer
    );

    protected static void setupTaskExecutingNodeDeserializer(ObjectDeserializer<TaskExecutingNode.Builder> op) {
        BaseNode.setupBaseNodeDeserializer(op);
        op.add(Builder::tasks, JsonpDeserializer.stringMapDeserializer(TaskInfo._DESERIALIZER), "tasks");
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.tasks.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TaskExecutingNode other = (TaskExecutingNode) o;
        return this.tasks.equals(other.tasks);
    }
}
