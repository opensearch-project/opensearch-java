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
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: tasks.TaskGroup

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TaskGroup extends TaskInfoBase implements ToCopyableBuilder<TaskGroup.Builder, TaskGroup> {

    @Nonnull
    private final List<TaskGroup> children;

    // ---------------------------------------------------------------------------------------------

    private TaskGroup(Builder builder) {
        super(builder);
        this.children = ApiTypeHelper.unmodifiable(builder.children);
    }

    public static TaskGroup of(Function<TaskGroup.Builder, ObjectBuilder<TaskGroup>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code children}
     */
    @Nonnull
    public final List<TaskGroup> children() {
        return this.children;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.children)) {
            generator.writeKey("children");
            generator.writeStartArray();
            for (TaskGroup item0 : this.children) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link TaskGroup}.
     */
    public static class Builder extends TaskInfoBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TaskGroup> {
        @Nullable
        private List<TaskGroup> children;

        public Builder() {}

        private Builder(TaskGroup o) {
            super(o);
            this.children = _listCopy(o.children);
        }

        private Builder(Builder o) {
            super(o);
            this.children = _listCopy(o.children);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code children}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>children</code>.
         * </p>
         */
        @Nonnull
        public final Builder children(List<TaskGroup> list) {
            this.children = _listAddAll(this.children, list);
            return this;
        }

        /**
         * API name: {@code children}
         *
         * <p>
         * Adds one or more values to <code>children</code>.
         * </p>
         */
        @Nonnull
        public final Builder children(TaskGroup value, TaskGroup... values) {
            this.children = _listAdd(this.children, value, values);
            return this;
        }

        /**
         * API name: {@code children}
         *
         * <p>
         * Adds a value to <code>children</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder children(Function<TaskGroup.Builder, ObjectBuilder<TaskGroup>> fn) {
            return children(fn.apply(new TaskGroup.Builder()).build());
        }

        /**
         * Builds a {@link TaskGroup}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TaskGroup build() {
            _checkSingleUse();

            return new TaskGroup(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TaskGroup}
     */
    public static final JsonpDeserializer<TaskGroup> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TaskGroup::setupTaskGroupDeserializer
    );

    protected static void setupTaskGroupDeserializer(ObjectDeserializer<TaskGroup.Builder> op) {
        setupTaskInfoBaseDeserializer(op);
        op.add(Builder::children, JsonpDeserializer.arrayDeserializer(TaskGroup._DESERIALIZER), "children");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.children);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TaskGroup other = (TaskGroup) o;
        return Objects.equals(this.children, other.children);
    }
}
