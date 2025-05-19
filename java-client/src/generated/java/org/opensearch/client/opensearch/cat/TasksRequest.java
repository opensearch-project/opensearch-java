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

package org.opensearch.client.opensearch.cat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.TimeUnit;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.tasks.Request

/**
 * Lists the progress of all tasks currently running on the cluster.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class TasksRequest extends CatRequestBase implements ToCopyableBuilder<TasksRequest.Builder, TasksRequest> {

    @Nonnull
    private final List<String> actions;

    @Nullable
    private final Boolean detailed;

    @Nonnull
    private final List<String> nodes;

    @Nullable
    private final String parentTaskId;

    @Nullable
    private final TimeUnit time;

    // ---------------------------------------------------------------------------------------------

    private TasksRequest(Builder builder) {
        super(builder);
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.detailed = builder.detailed;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.parentTaskId = builder.parentTaskId;
        this.time = builder.time;
    }

    public static TasksRequest of(Function<TasksRequest.Builder, ObjectBuilder<TasksRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The task action names used to limit the response.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    @Nonnull
    public final List<String> actions() {
        return this.actions;
    }

    /**
     * If <code>true</code>, the response includes detailed information about shard recoveries.
     * <p>
     * API name: {@code detailed}
     * </p>
     */
    @Nullable
    public final Boolean detailed() {
        return this.detailed;
    }

    /**
     * A comma-separated list of node IDs or names used to limit the returned information. Use <code>_local</code> to return information
     * from the node to which you're connecting, specify a specific node from which to get information, or keep the parameter empty to get
     * information from all nodes.
     * <p>
     * API name: {@code nodes}
     * </p>
     */
    @Nonnull
    public final List<String> nodes() {
        return this.nodes;
    }

    /**
     * The parent task identifier, which is used to limit the response.
     * <p>
     * API name: {@code parent_task_id}
     * </p>
     */
    @Nullable
    public final String parentTaskId() {
        return this.parentTaskId;
    }

    /**
     * Specifies the time units, for example, <code>5d</code> or <code>7h</code>. For more information, see
     * <a href="https://opensearch.org/docs/latest/api-reference/units/">Supported units</a>.
     * <p>
     * API name: {@code time}
     * </p>
     */
    @Nullable
    public final TimeUnit time() {
        return this.time;
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
     * Builder for {@link TasksRequest}.
     */
    public static class Builder extends CatRequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, TasksRequest> {
        @Nullable
        private List<String> actions;
        @Nullable
        private Boolean detailed;
        @Nullable
        private List<String> nodes;
        @Nullable
        private String parentTaskId;
        @Nullable
        private TimeUnit time;

        public Builder() {}

        private Builder(TasksRequest o) {
            super(o);
            this.actions = _listCopy(o.actions);
            this.detailed = o.detailed;
            this.nodes = _listCopy(o.nodes);
            this.parentTaskId = o.parentTaskId;
            this.time = o.time;
        }

        private Builder(Builder o) {
            super(o);
            this.actions = _listCopy(o.actions);
            this.detailed = o.detailed;
            this.nodes = _listCopy(o.nodes);
            this.parentTaskId = o.parentTaskId;
            this.time = o.time;
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
         * The task action names used to limit the response.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(List<String> list) {
            this.actions = _listAddAll(this.actions, list);
            return this;
        }

        /**
         * The task action names used to limit the response.
         * <p>
         * API name: {@code actions}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>actions</code>.
         * </p>
         */
        @Nonnull
        public final Builder actions(String value, String... values) {
            this.actions = _listAdd(this.actions, value, values);
            return this;
        }

        /**
         * If <code>true</code>, the response includes detailed information about shard recoveries.
         * <p>
         * API name: {@code detailed}
         * </p>
         */
        @Nonnull
        public final Builder detailed(@Nullable Boolean value) {
            this.detailed = value;
            return this;
        }

        /**
         * A comma-separated list of node IDs or names used to limit the returned information. Use <code>_local</code> to return information
         * from the node to which you're connecting, specify a specific node from which to get information, or keep the parameter empty to
         * get information from all nodes.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(List<String> list) {
            this.nodes = _listAddAll(this.nodes, list);
            return this;
        }

        /**
         * A comma-separated list of node IDs or names used to limit the returned information. Use <code>_local</code> to return information
         * from the node to which you're connecting, specify a specific node from which to get information, or keep the parameter empty to
         * get information from all nodes.
         * <p>
         * API name: {@code nodes}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>nodes</code>.
         * </p>
         */
        @Nonnull
        public final Builder nodes(String value, String... values) {
            this.nodes = _listAdd(this.nodes, value, values);
            return this;
        }

        /**
         * The parent task identifier, which is used to limit the response.
         * <p>
         * API name: {@code parent_task_id}
         * </p>
         */
        @Nonnull
        public final Builder parentTaskId(@Nullable String value) {
            this.parentTaskId = value;
            return this;
        }

        /**
         * Specifies the time units, for example, <code>5d</code> or <code>7h</code>. For more information, see
         * <a href="https://opensearch.org/docs/latest/api-reference/units/">Supported units</a>.
         * <p>
         * API name: {@code time}
         * </p>
         */
        @Nonnull
        public final Builder time(@Nullable TimeUnit value) {
            this.time = value;
            return this;
        }

        /**
         * Builds a {@link TasksRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TasksRequest build() {
            _checkSingleUse();

            return new TasksRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (ApiTypeHelper.isDefined(this.actions)) {
            params.put("actions", String.join(",", this.actions));
        }
        if (this.detailed != null) {
            params.put("detailed", String.valueOf(this.detailed));
        }
        if (ApiTypeHelper.isDefined(this.nodes)) {
            params.put("nodes", String.join(",", this.nodes));
        }
        if (this.parentTaskId != null) {
            params.put("parent_task_id", this.parentTaskId);
        }
        if (this.time != null) {
            params.put("time", this.time.jsonValue());
        }
    }

    /**
     * Endpoint "{@code cat.tasks}".
     */
    public static final Endpoint<TasksRequest, TasksResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cat/tasks",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        TasksResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actions);
        result = 31 * result + Objects.hashCode(this.detailed);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + Objects.hashCode(this.parentTaskId);
        result = 31 * result + Objects.hashCode(this.time);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TasksRequest other = (TasksRequest) o;
        return Objects.equals(this.actions, other.actions)
            && Objects.equals(this.detailed, other.detailed)
            && Objects.equals(this.nodes, other.nodes)
            && Objects.equals(this.parentTaskId, other.parentTaskId)
            && Objects.equals(this.time, other.time);
    }
}
