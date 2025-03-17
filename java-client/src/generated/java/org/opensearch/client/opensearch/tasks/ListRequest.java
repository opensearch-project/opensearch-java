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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.opensearch._types.Time;
import org.opensearch.client.transport.Endpoint;
import org.opensearch.client.transport.endpoints.SimpleEndpoint;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: tasks.list.Request

/**
 * Returns a list of tasks.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class ListRequest extends RequestBase implements ToCopyableBuilder<ListRequest.Builder, ListRequest> {

    @Nonnull
    private final List<String> actions;

    @Nullable
    private final Boolean detailed;

    @Nullable
    private final GroupBy groupBy;

    @Nonnull
    private final List<String> nodes;

    @Nullable
    private final String parentTaskId;

    @Nullable
    private final Time timeout;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private ListRequest(Builder builder) {
        super(builder);
        this.actions = ApiTypeHelper.unmodifiable(builder.actions);
        this.detailed = builder.detailed;
        this.groupBy = builder.groupBy;
        this.nodes = ApiTypeHelper.unmodifiable(builder.nodes);
        this.parentTaskId = builder.parentTaskId;
        this.timeout = builder.timeout;
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static ListRequest of(Function<ListRequest.Builder, ObjectBuilder<ListRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * A comma-separated list of actions that should be returned. Keep empty to return all.
     * <p>
     * API name: {@code actions}
     * </p>
     */
    @Nonnull
    public final List<String> actions() {
        return this.actions;
    }

    /**
     * When <code>true</code>, the response includes detailed information about shard recoveries.
     * <p>
     * API name: {@code detailed}
     * </p>
     */
    @Nullable
    public final Boolean detailed() {
        return this.detailed;
    }

    /**
     * Groups tasks by parent/child relationships or nodes.
     * <p>
     * API name: {@code group_by}
     * </p>
     */
    @Nullable
    public final GroupBy groupBy() {
        return this.groupBy;
    }

    /**
     * A comma-separated list of node IDs or names to limit the returned information. Use <code>_local</code> to return information from the
     * node you're connecting to, specify the node name to get information from specific nodes, or keep the parameter empty to get
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
     * Returns tasks with a specified parent task ID (node_id:task_number). Keep empty or set to -1 to return all.
     * <p>
     * API name: {@code parent_task_id}
     * </p>
     */
    @Nullable
    public final String parentTaskId() {
        return this.parentTaskId;
    }

    /**
     * The amount of time to wait for a response.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final Time timeout() {
        return this.timeout;
    }

    /**
     * Waits for the matching task to complete. When <code>true</code>, the request is blocked until the task has completed.
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
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
     * Builder for {@link ListRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ListRequest> {
        @Nullable
        private List<String> actions;
        @Nullable
        private Boolean detailed;
        @Nullable
        private GroupBy groupBy;
        @Nullable
        private List<String> nodes;
        @Nullable
        private String parentTaskId;
        @Nullable
        private Time timeout;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(ListRequest o) {
            super(o);
            this.actions = _listCopy(o.actions);
            this.detailed = o.detailed;
            this.groupBy = o.groupBy;
            this.nodes = _listCopy(o.nodes);
            this.parentTaskId = o.parentTaskId;
            this.timeout = o.timeout;
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            super(o);
            this.actions = _listCopy(o.actions);
            this.detailed = o.detailed;
            this.groupBy = o.groupBy;
            this.nodes = _listCopy(o.nodes);
            this.parentTaskId = o.parentTaskId;
            this.timeout = o.timeout;
            this.waitForCompletion = o.waitForCompletion;
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
         * A comma-separated list of actions that should be returned. Keep empty to return all.
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
         * A comma-separated list of actions that should be returned. Keep empty to return all.
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
         * When <code>true</code>, the response includes detailed information about shard recoveries.
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
         * Groups tasks by parent/child relationships or nodes.
         * <p>
         * API name: {@code group_by}
         * </p>
         */
        @Nonnull
        public final Builder groupBy(@Nullable GroupBy value) {
            this.groupBy = value;
            return this;
        }

        /**
         * A comma-separated list of node IDs or names to limit the returned information. Use <code>_local</code> to return information from
         * the node you're connecting to, specify the node name to get information from specific nodes, or keep the parameter empty to get
         * information from all nodes.
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
         * A comma-separated list of node IDs or names to limit the returned information. Use <code>_local</code> to return information from
         * the node you're connecting to, specify the node name to get information from specific nodes, or keep the parameter empty to get
         * information from all nodes.
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
         * Returns tasks with a specified parent task ID (node_id:task_number). Keep empty or set to -1 to return all.
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
         * The amount of time to wait for a response.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable Time value) {
            this.timeout = value;
            return this;
        }

        /**
         * The amount of time to wait for a response.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
            return timeout(fn.apply(new Time.Builder()).build());
        }

        /**
         * Waits for the matching task to complete. When <code>true</code>, the request is blocked until the task has completed.
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        @Nonnull
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link ListRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ListRequest build() {
            _checkSingleUse();

            return new ListRequest(this);
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
        if (this.groupBy != null) {
            params.put("group_by", this.groupBy.jsonValue());
        }
        if (ApiTypeHelper.isDefined(this.nodes)) {
            params.put("nodes", String.join(",", this.nodes));
        }
        if (this.parentTaskId != null) {
            params.put("parent_task_id", this.parentTaskId);
        }
        if (this.timeout != null) {
            params.put("timeout", this.timeout._toJsonString());
        }
        if (this.waitForCompletion != null) {
            params.put("wait_for_completion", String.valueOf(this.waitForCompletion));
        }
    }

    /**
     * Endpoint "{@code tasks.list}".
     */
    public static final Endpoint<ListRequest, ListResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_tasks",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        ListResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.actions);
        result = 31 * result + Objects.hashCode(this.detailed);
        result = 31 * result + Objects.hashCode(this.groupBy);
        result = 31 * result + Objects.hashCode(this.nodes);
        result = 31 * result + Objects.hashCode(this.parentTaskId);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ListRequest other = (ListRequest) o;
        return Objects.equals(this.actions, other.actions)
            && Objects.equals(this.detailed, other.detailed)
            && Objects.equals(this.groupBy, other.groupBy)
            && Objects.equals(this.nodes, other.nodes)
            && Objects.equals(this.parentTaskId, other.parentTaskId)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
