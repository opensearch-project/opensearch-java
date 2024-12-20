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

package org.opensearch.client.opensearch.cluster;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch.cluster.pending_tasks.PendingTask;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cluster.pending_tasks.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PendingTasksResponse implements PlainJsonSerializable, ToCopyableBuilder<PendingTasksResponse.Builder, PendingTasksResponse> {

    @Nonnull
    private final List<PendingTask> tasks;

    // ---------------------------------------------------------------------------------------------

    private PendingTasksResponse(Builder builder) {
        this.tasks = ApiTypeHelper.unmodifiableRequired(builder.tasks, this, "tasks");
    }

    public static PendingTasksResponse of(Function<PendingTasksResponse.Builder, ObjectBuilder<PendingTasksResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code tasks}
     */
    @Nonnull
    public final List<PendingTask> tasks() {
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
        generator.writeKey("tasks");
        generator.writeStartArray();
        for (PendingTask item0 : this.tasks) {
            item0.serialize(generator, mapper);
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
     * Builder for {@link PendingTasksResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PendingTasksResponse> {
        private List<PendingTask> tasks;

        public Builder() {}

        private Builder(PendingTasksResponse o) {
            this.tasks = _listCopy(o.tasks);
        }

        private Builder(Builder o) {
            this.tasks = _listCopy(o.tasks);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code tasks}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>tasks</code>.
         * </p>
         */
        @Nonnull
        public final Builder tasks(List<PendingTask> list) {
            this.tasks = _listAddAll(this.tasks, list);
            return this;
        }

        /**
         * Required - API name: {@code tasks}
         *
         * <p>
         * Adds one or more values to <code>tasks</code>.
         * </p>
         */
        @Nonnull
        public final Builder tasks(PendingTask value, PendingTask... values) {
            this.tasks = _listAdd(this.tasks, value, values);
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
        public final Builder tasks(Function<PendingTask.Builder, ObjectBuilder<PendingTask>> fn) {
            return tasks(fn.apply(new PendingTask.Builder()).build());
        }

        /**
         * Builds a {@link PendingTasksResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PendingTasksResponse build() {
            _checkSingleUse();

            return new PendingTasksResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PendingTasksResponse}
     */
    public static final JsonpDeserializer<PendingTasksResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PendingTasksResponse::setupPendingTasksResponseDeserializer
    );

    protected static void setupPendingTasksResponseDeserializer(ObjectDeserializer<PendingTasksResponse.Builder> op) {
        op.add(Builder::tasks, JsonpDeserializer.arrayDeserializer(PendingTask._DESERIALIZER), "tasks");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.tasks.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PendingTasksResponse other = (PendingTasksResponse) o;
        return this.tasks.equals(other.tasks);
    }
}
