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

package org.opensearch.client.opensearch.core.reindex_rethrottle;

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
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.reindex_rethrottle.ReindexNode

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ReindexNode extends BaseNode implements ToCopyableBuilder<ReindexNode.Builder, ReindexNode> {

    @Nonnull
    private final Map<String, ReindexTask> tasks;

    // ---------------------------------------------------------------------------------------------

    private ReindexNode(Builder builder) {
        super(builder);
        this.tasks = ApiTypeHelper.unmodifiableRequired(builder.tasks, this, "tasks");
    }

    public static ReindexNode of(Function<ReindexNode.Builder, ObjectBuilder<ReindexNode>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code tasks}
     */
    @Nonnull
    public final Map<String, ReindexTask> tasks() {
        return this.tasks;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("tasks");
        generator.writeStartObject();
        for (Map.Entry<String, ReindexTask> item0 : this.tasks.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link ReindexNode}.
     */
    public static class Builder extends BaseNode.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ReindexNode> {
        private Map<String, ReindexTask> tasks;

        public Builder() {}

        private Builder(ReindexNode o) {
            super(o);
            this.tasks = _mapCopy(o.tasks);
        }

        private Builder(Builder o) {
            super(o);
            this.tasks = _mapCopy(o.tasks);
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
         * Required - API name: {@code tasks}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>tasks</code>.
         * </p>
         */
        @Nonnull
        public final Builder tasks(Map<String, ReindexTask> map) {
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
        @Nonnull
        public final Builder tasks(String key, ReindexTask value) {
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
        @Nonnull
        public final Builder tasks(String key, Function<ReindexTask.Builder, ObjectBuilder<ReindexTask>> fn) {
            return tasks(key, fn.apply(new ReindexTask.Builder()).build());
        }

        /**
         * Builds a {@link ReindexNode}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ReindexNode build() {
            _checkSingleUse();

            return new ReindexNode(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ReindexNode}
     */
    public static final JsonpDeserializer<ReindexNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ReindexNode::setupReindexNodeDeserializer
    );

    protected static void setupReindexNodeDeserializer(ObjectDeserializer<ReindexNode.Builder> op) {
        setupBaseNodeDeserializer(op);
        op.add(Builder::tasks, JsonpDeserializer.stringMapDeserializer(ReindexTask._DESERIALIZER), "tasks");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.tasks.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ReindexNode other = (ReindexNode) o;
        return this.tasks.equals(other.tasks);
    }
}
